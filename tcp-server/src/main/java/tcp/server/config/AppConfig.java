package tcp.server.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import reactor.core.publisher.Hooks;

import javax.annotation.PostConstruct;

@Configuration
@EnableScheduling
public class AppConfig {
  @PostConstruct
  public void init() {
    Hooks.onOperatorDebug();
  }
}
