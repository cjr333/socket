package tcp.server.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
                .bindNow();
        log.info("Tcp server started on 8888");
//        server.onDispose().block();
    }
//    @Bean
//    public TcpServer tcpServer() {
//        return TcpServer.create()
//                .host("localhost")
//                .port(8888);
//    }
}
