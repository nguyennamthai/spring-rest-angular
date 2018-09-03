package thai.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;
import thai.domain.PortalUser;

public interface UserRepository extends ReactiveCrudRepository<PortalUser, String> {
    Mono<PortalUser> findByEmail(Mono<String> email);
}
