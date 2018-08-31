package thai.repository;

import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import thai.domain.Message;

public interface MessageRepository extends ReactiveSortingRepository<Message, String> {
}
