package thai.handler;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import thai.service.UserService;
import thai.service.dto.UserDto;

@Component
public class UserHandler {
    private final UserService userService;

    public UserHandler(UserService userService) {
        this.userService = userService;
    }

    public Mono<ServerResponse> getAllUsers() {
        return ServerResponse.ok().body(userService.getAll(), UserDto.class);
    }

    public Mono<ServerResponse> saveUser(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .body(userService.save(serverRequest.bodyToMono(UserDto.class)), UserDto.class);
    }
}
