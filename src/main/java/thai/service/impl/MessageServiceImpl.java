package thai.service.impl;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import thai.repository.MessageRepository;
import thai.service.MessageService;
import thai.service.dto.MessageDto;
import thai.service.dto.UserDto;
import thai.service.mapper.MessageMapper;

@Service
public class MessageServiceImpl implements MessageService {
    private final MessageMapper messageMapper;
    private final MessageRepository messageRepository;

    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageMapper = Mappers.getMapper(MessageMapper.class);
        this.messageRepository = messageRepository;
    }

    @Override
    public Mono<MessageDto> getLatest() {
        return null;
    }

    @Override
    public Mono<MessageDto> save(Mono<MessageDto> messageDto) {
        return null;
    }

    @Override
    public Mono<Void> deleteById(Mono<String> id) {
        return null;
    }

    @Override
    public Mono<MessageDto> getById(Mono<String> id) {
        return null;
    }

    @Override
    public Flux<MessageDto> getByPageNumber(Mono<Integer> pageNumber) {
        return null;
    }

    @Override
    public Flux<MessageDto> getByUser(Mono<UserDto> userDto) {
        return null;
    }
}
