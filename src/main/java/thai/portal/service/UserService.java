package thai.portal.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import thai.portal.service.dto.UserDto;

public interface UserService {
    Flux<UserDto> getAll();

    Mono<UserDto> save(Mono<UserDto> userDto);
}
