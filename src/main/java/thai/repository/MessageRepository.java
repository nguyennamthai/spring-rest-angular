package thai.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import reactor.core.publisher.Flux;
import thai.domain.Message;

public interface MessageRepository extends ReactiveSortingRepository<Message, String> {
    Flux<Message> findAllByUserId(String userId, Sort sort);
}
