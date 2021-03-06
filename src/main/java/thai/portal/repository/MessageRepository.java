package thai.portal.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import thai.portal.domain.Message;

public interface MessageRepository extends ReactiveSortingRepository<Message, String> {
    Mono<Message> findFirstByOrderByModifiedDesc();

    Flux<Message> findAllByUserId(String userId);

    Flux<Message> findAllByOrderByModifiedDesc(Pageable pageable);
}
