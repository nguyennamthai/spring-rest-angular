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

import java.util.Date;
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
            Message message = new Message("This is my first message", new Date());
            Optional<Message> messageOptional = messageRepository.save(message).blockOptional();
            PortalUser user = new PortalUser("user@thai.com", "123456", ADMIN, profile, messageOptional.orElse(message).getId());
            userRepository.save(user).block();
        };
    }
}