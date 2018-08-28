package thai.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.server.WebFilter;
import thai.handler.HomeHandler;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;

@Configuration
public class RoutingConfig {
    private final HomeHandler homeHandler;

    public RoutingConfig(HomeHandler homeHandler) {
        this.homeHandler = homeHandler;
    }

    @Bean
    public WebFilter forwardRootAccessToIndexHtml() {
        return (exchange, chain) -> exchange.getRequest().getURI().getPath().equals("/") ?
                chain.filter(exchange.mutate().request(exchange.getRequest().mutate().path("/index.html").build()).build()) : chain.filter(exchange);
    }

    @Bean
    public RouterFunction<ServerResponse> routerFunction() {
        return RouterFunctions.route(GET("/api"), request -> homeHandler.showHomePage());
    }
}
