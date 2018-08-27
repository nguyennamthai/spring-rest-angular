package thai.handler;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class HomeHandler {
    public Mono<ServerResponse> showHomePage() {
        return ServerResponse.ok().body(Mono.just("home"), String.class);
    }
}
