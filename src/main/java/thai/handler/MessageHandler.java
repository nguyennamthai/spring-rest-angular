package thai.handler;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import thai.service.MessageService;
import thai.service.dto.MessageDto;

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
        return ServerResponse.ok().body(messageService.getByUserId(userId.orElse("")), MessageDto.class);
    }

    public Mono<ServerResponse> saveMessage(ServerRequest serverRequest) {
        return ServerResponse.ok().body(messageService.save(serverRequest.bodyToMono(MessageDto.class)), MessageDto.class);
    }

    public Mono<ServerResponse> deleteMessageById(ServerRequest serverRequest) {
        String messageId = serverRequest.pathVariable("id");
        return ServerResponse.ok().body(messageService.deleteById(messageId), Void.class);
    }
}
