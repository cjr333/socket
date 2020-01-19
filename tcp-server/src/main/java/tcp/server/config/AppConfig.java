package tcp.server.config;

import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Hooks;

import javax.annotation.PostConstruct;

@Configuration
public class AppConfig {
  @PostConstruct
  public void init() {
    Hooks.onOperatorDebug();
  }
}
