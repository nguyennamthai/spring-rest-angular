package thai.portal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.server.WebFilter;
import thai.portal.handler.HomeHandler;
import thai.portal.handler.MessageHandler;
import thai.portal.handler.UserHandler;

import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RequestPredicates.path;
import static org.springframework.web.reactive.function.server.RouterFunctions.nest;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RoutingConfig {
    private final HomeHandler homeHandler;
    private final UserHandler userHandler;
    private final MessageHandler messageHandler;

    public RoutingConfig(HomeHandler homeHandler, UserHandler userHandler, MessageHandler messageHandler) {
        this.homeHandler = homeHandler;
        this.userHandler = userHandler;
        this.messageHandler = messageHandler;
    }

    @Bean
    public WebFilter forwardRootAccessToIndexHtml() {
        return (exchange, chain) -> exchange.getRequest().getURI().getPath().equals("/") ?
                chain.filter(exchange.mutate().request(exchange.getRequest().mutate().path("/index.html").build()).build()) : chain.filter(exchange);
    }

    @Bean
    public RouterFunction<ServerResponse> routerFunction() {
        RouterFunction<ServerResponse> userRoutes = route(GET("/"), request -> userHandler.getAllUsers())
                .andRoute(PUT("/"), userHandler::saveUser);

        RouterFunction<ServerResponse> messageRoutes = route(GET("/latest"), request -> messageHandler.getLatestMessage())
                .andRoute(GET("/"), messageHandler::getMessagePage)
                .andRoute(GET("/{id}"), messageHandler::getMessageById)
                .andRoute(GET("/user"), messageHandler::getMessageByUserId)
                .andRoute(PUT("/"), messageHandler::saveMessage)
                .andRoute(DELETE("/{id}"), messageHandler::deleteMessageById);

        RouterFunction<ServerResponse> apiRoutes = route(GET("/"), request -> homeHandler.showHomePage())
                .andNest(path("/users"), userRoutes)
                .andNest(path("/messages"), messageRoutes);

        return nest(path("/api"), apiRoutes);
    }
}
