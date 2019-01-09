package thai.portal.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import thai.portal.domain.PortalUser;

public interface UserRepository extends ReactiveCrudRepository<PortalUser, String> {
}
