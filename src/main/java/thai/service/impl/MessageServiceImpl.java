package thai.service.impl;

import org.springframework.stereotype.Service;
import thai.domain.PortalUser;
import thai.service.MessageService;
import thai.service.dto.MessageDto;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    @Override
    public void save(MessageDto messageDto) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public MessageDto getLatest() {
        return null;
    }

    @Override
    public MessageDto getById(String id) {
        return null;
    }

    @Override
    public List<MessageDto> getByPageNumber(int pageNumber) {
        return null;
    }

    @Override
    public List<MessageDto> getByUser(PortalUser user) {
        return null;
    }
}
