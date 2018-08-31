package thai;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import thai.domain.Message;
import thai.domain.PortalUser;
import thai.domain.Profile;
import thai.repository.MessageRepository;
import thai.repository.UserRepository;

import java.util.Optional;

import static thai.domain.PortalUser.Role.ADMIN;

@SpringBootApplication
public class CommunityPortalApplication {
    public static void main(String[] args) {
        SpringApplication.run(CommunityPortalApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(UserRepository userRepository, MessageRepository messageRepository) {
        return args -> {
            Profile profile = new Profile("My name is Thai", "/my-image");
            PortalUser user = new PortalUser("user@thai.com", "123456", ADMIN);
            user.setProfile(profile);
            Optional<PortalUser> userOptional = userRepository.save(user).blockOptional();

            Message message = new Message("This is my first message");
            message.setUserId(userOptional.orElse(user).getId());
            messageRepository.save(message).block();
        };
    }
}