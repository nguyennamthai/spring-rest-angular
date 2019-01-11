package thai.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableAutoConfiguration
@EnableEurekaServer
public class RegistryApplication {
    public static void main(String[] args) {
        System.setProperty("spring.config.name", "registry");
        SpringApplication.run(RegistryApplication.class, args);
    }
}
