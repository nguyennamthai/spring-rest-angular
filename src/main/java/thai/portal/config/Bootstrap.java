package thai.portal.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import thai.portal.domain.Message;
import thai.portal.domain.PortalUser;
import thai.portal.domain.Profile;
import thai.portal.repository.MessageRepository;
import thai.portal.repository.UserRepository;

import java.util.Optional;

@Configuration
@EnableMongoAuditing
public class Bootstrap {
    @Bean
    CommandLineRunner runner(UserRepository userRepository, MessageRepository messageRepository) {
        return args -> {
            PortalUser admin = new PortalUser("admin@thai.com", PortalUser.Role.ADMIN);
            admin.setProfile(new Profile("Administrator", "The administrator of this community portal", "/images/admin.png"));
            Optional<PortalUser> adminOptional = userRepository.save(admin).blockOptional();
            saveMassage("Welcome to our community!", adminOptional.orElse(admin), messageRepository);

            PortalUser user = new PortalUser("johndoe@thai.com", PortalUser.Role.MEMBER);
            user.setProfile(new Profile("John Doe", "Someone from somewhere", "/images/john.png"));
            Optional<PortalUser> userOptional = userRepository.save(user).blockOptional();
            saveMassage("Hello Spring", userOptional.orElse(user), messageRepository);
            saveMassage("Hello Angular", userOptional.orElse(user), messageRepository);
        };
    }

    private void saveMassage(String content, PortalUser persistedUser, MessageRepository messageRepository) {
        try {
            // Make each message have a different last modified time
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        Message message = new Message(content);
        message.setUserId(persistedUser.getId());
        messageRepository.save(message).block();
    }
}
