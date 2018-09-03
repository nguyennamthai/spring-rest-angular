package thai.service.impl;

import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import thai.repository.MessageRepository;
import thai.service.MessageService;
import thai.service.dto.MessageDto;
import thai.service.mapper.MessageMapper;

import static org.springframework.data.domain.Sort.Direction.DESC;

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
        return messageRepository.findFirstByOrderByModifiedDesc().map(messageMapper::mapToDto);
    }

    @Override
    public Flux<MessageDto> getPage(int pageNumber, int pageSize) {
        return messageRepository.findAllByOrderByModifiedDesc(PageRequest.of(pageNumber - 1, pageSize, DESC, SORT_PROPERTY))
                .map(messageMapper::mapToDto);
    }

    @Override
    public Mono<MessageDto> getById(Mono<String> id) {
        return messageRepository.findById(id).map(messageMapper::mapToDto);
    }

    @Override
    public Flux<MessageDto> getByUserId(Mono<String> userId) {
        return messageRepository.findAllByUserId(userId).map(messageMapper::mapToDto);
    }

    @Override
    public Mono<MessageDto> save(Mono<MessageDto> messageDto) {
        return messageRepository.saveAll(messageDto.map(messageMapper::mapToEntity)).single().map(messageMapper::mapToDto);
    }

    @Override
    public Mono<Void> deleteById(Mono<String> id) {
        return messageRepository.deleteById(id);
    }
}
