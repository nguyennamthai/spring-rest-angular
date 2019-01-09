package thai.portal.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import thai.portal.service.dto.MessageDto;

public interface MessageService {
    Mono<MessageDto> getLatest();

    Flux<MessageDto> getPage(int pageNumber, int pageSize);

    Mono<MessageDto> getById(String id);

    Flux<MessageDto> getByUserId(String userId);

    Mono<MessageDto> save(Mono<MessageDto> messageDto);

    Mono<Void> deleteById(String id);
}
