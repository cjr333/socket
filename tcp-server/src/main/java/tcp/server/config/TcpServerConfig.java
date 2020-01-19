package tcp.server.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import reactor.core.publisher.EmitterProcessor;
import reactor.core.publisher.Mono;
import reactor.netty.DisposableServer;
import reactor.netty.tcp.TcpServer;

import javax.annotation.PostConstruct;

@Slf4j
@Configuration
public class TcpServerConfig {
    @PostConstruct
    public void start() {
        TcpServer.create()
                .host("localhost")
                .port(8888)
                .handle((inbound, outbound) -> {
                    inbound.receive().asByteArray().subscribe(data -> log.info(new String(data)));

                    return outbound.sendString(stringEmitter)
                            .neverComplete();
                })
                .bindNow();
        log.info("Tcp server started on 8888");
//        server.onDispose().block();
    }

    private EmitterProcessor<String> stringEmitter = EmitterProcessor.create();

    @Scheduled(fixedRate = 1000L)
    public void emit() {
        stringEmitter.onNext("test");
    }
//    @Bean
//    public TcpServer tcpServer() {
//        return TcpServer.create()
//                .host("localhost")
//                .port(8888);
//    }
}
