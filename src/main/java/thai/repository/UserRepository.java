package thai.repository;

import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import reactor.core.publisher.Mono;
import thai.domain.PortalUser;

public interface UserRepository extends ReactiveSortingRepository<PortalUser, String> {
    Mono<PortalUser> findByEmail(String email);
}
