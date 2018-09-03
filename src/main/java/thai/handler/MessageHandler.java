package thai.handler;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import thai.service.MessageService;
import thai.service.UserService;
import thai.service.dto.MessageDto;

@Component
public class MessageHandler {
    private final UserService userService;
    private final MessageService messageService;

    public MessageHandler(UserService userService, MessageService messageService) {
        this.userService = userService;
        this.messageService = messageService;
    }

    public Mono<ServerResponse> getLatest() {
        return ServerResponse.ok().body(messageService.getLatest(), MessageDto.class);
    }
}
