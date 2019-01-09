package thai.portal.handler;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import thai.portal.service.MessageService;
import thai.portal.service.dto.MessageDto;

import java.util.Optional;

import static java.lang.Integer.valueOf;

@Component
public class MessageHandler {
    private final MessageService messageService;

    public MessageHandler(MessageService messageService) {
        this.messageService = messageService;
    }

    public Mono<ServerResponse> getLatestMessage() {
        return ServerResponse.ok().body(messageService.getLatest(), MessageDto.class);
    }

    public Mono<ServerResponse> getMessagePage(ServerRequest serverRequest) {
        String pageNumber = serverRequest.queryParam("pageNumber").orElse("0");
        String pageSize = serverRequest.queryParam("pageSize").orElse("5");
        return ServerResponse.ok().body(messageService.getPage(valueOf(pageNumber), valueOf(pageSize)), MessageDto.class);
    }

    public Mono<ServerResponse> getMessageById(ServerRequest serverRequest) {
        String messageId = serverRequest.pathVariable("id");
        return ServerResponse.ok().body(messageService.getById(messageId), MessageDto.class);
    }

    public Mono<ServerResponse> getMessageByUserId(ServerRequest serverRequest) {
        Optional<String> userId = serverRequest.queryParam("id");
        if (userId.isPresent()) {
            return ServerResponse.ok().body(messageService.getByUserId(userId.get()), MessageDto.class);
        }
        return ServerResponse.badRequest().body(Mono.just("The user id was missing"), String.class);
    }

    public Mono<ServerResponse> saveMessage(ServerRequest serverRequest) {
        return ServerResponse.ok().body(messageService.save(serverRequest.bodyToMono(MessageDto.class)), MessageDto.class);
    }

    public Mono<ServerResponse> deleteMessageById(ServerRequest serverRequest) {
        String messageId = serverRequest.pathVariable("id");
        return ServerResponse.ok().body(messageService.deleteById(messageId), Void.class);
    }
}
