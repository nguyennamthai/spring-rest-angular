package thai.service.impl;

import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
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
    private static final String SORT_PROPERTY = "modified";

    private final MessageMapper messageMapper;
    private final MessageRepository messageRepository;

    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageMapper = Mappers.getMapper(MessageMapper.class);
        this.messageRepository = messageRepository;
    }

    @Override
    public Mono<MessageDto> getLatest() {
        return messageRepository.findFirstOrderByModifiedDesc().map(messageMapper::mapToDto);
    }

    @Override
    public Flux<MessageDto> getAll(String direction) {
        return messageRepository.findAll(Sort.by(Direction.valueOf(direction.toUpperCase()), SORT_PROPERTY))
                .map(messageMapper::mapToDto);
    }

    @Override
    public Mono<MessageDto> save(Mono<MessageDto> messageDto) {
        return messageRepository.saveAll(messageDto.map(messageMapper::mapToEntity)).single().map(messageMapper::mapToDto);
    }

    @Override
    public Mono<Void> deleteById(Mono<String> id) {
        return messageRepository.deleteById(id);
    }

    @Override
    public Mono<MessageDto> getById(Mono<String> id) {
        return messageRepository.findById(id).map(messageMapper::mapToDto);
    }

    @Override
    public Flux<MessageDto> getByUser(UserDto userDto, String direction) {
        return messageRepository.findAllByUserId(userDto.getId(), Sort.by(Direction.valueOf(direction.toUpperCase()), SORT_PROPERTY))
                .map(messageMapper::mapToDto);
    }
}
