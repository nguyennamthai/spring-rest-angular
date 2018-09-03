package thai.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import thai.service.dto.MessageDto;
import thai.service.dto.UserDto;

public interface MessageService {
    Mono<MessageDto> getLatest();

    Mono<MessageDto> save(Mono<MessageDto> messageDto);

    Mono<Void> deleteById(Mono<String> id);

    Mono<MessageDto> getById(Mono<String> id);

    Flux<MessageDto> getByPageNumber(Mono<Integer> pageNumber);

    Flux<MessageDto> getByUser(Mono<UserDto> userDto);
}
