package thai.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import thai.handler.HomeHandler;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;

@Configuration
public class RoutingConfig {
    private final HomeHandler homeHandler;

    public RoutingConfig(HomeHandler homeHandler) {
        this.homeHandler = homeHandler;
    }

    @Bean
    public RouterFunction<ServerResponse> monoRouterFunction() {
        return RouterFunctions.route(GET("/"), request -> homeHandler.showHomePage());
    }
}
