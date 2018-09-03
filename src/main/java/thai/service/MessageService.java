package thai.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import thai.service.dto.MessageDto;

public interface MessageService {
    Mono<MessageDto> getLatest();

    Flux<MessageDto> getPage(int pageNumber, int pageSize);

    Mono<MessageDto> getById(Mono<String> id);

    Flux<MessageDto> getByUserId(Mono<String> userId);

    Mono<MessageDto> save(Mono<MessageDto> messageDto);

    Mono<Void> deleteById(Mono<String> id);
}
