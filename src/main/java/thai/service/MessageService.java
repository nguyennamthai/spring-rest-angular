package thai.service;

import thai.domain.PortalUser;
import thai.service.dto.MessageDto;

import java.util.List;

public interface MessageService {
    void save(MessageDto messageDto);

    void delete(String id);

    MessageDto getLatest();

    MessageDto getById(String id);

    List<MessageDto> getByPageNumber(int pageNumber);

    List<MessageDto> getByUser(PortalUser user);
}
