package thai.portal.service.impl;

import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import thai.portal.repository.MessageRepository;
import thai.portal.service.MessageService;
import thai.portal.service.dto.MessageDto;
import thai.portal.service.mapper.MessageMapper;

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
    public Mono<MessageDto> getById(String id) {
        return messageRepository.findById(id).map(messageMapper::mapToDto);
    }

    @Override
    public Flux<MessageDto> getByUserId(String userId) {
        return messageRepository.findAllByUserId(userId).map(messageMapper::mapToDto);
    }

    @Override
    public Mono<MessageDto> save(Mono<MessageDto> messageDto) {
        return messageRepository.saveAll(messageDto.map(messageMapper::mapToEntity)).single().map(messageMapper::mapToDto);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return messageRepository.deleteById(id);
    }
}
