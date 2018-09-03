package thai.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import thai.service.dto.UserDto;

public interface UserService {
    Flux<UserDto> getAll();

    Mono<UserDto> getByEmail(Mono<String> email);

    Mono<UserDto> save(Mono<UserDto> userDto);
}
