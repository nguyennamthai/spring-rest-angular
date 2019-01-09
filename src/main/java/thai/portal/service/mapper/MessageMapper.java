package thai.portal.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import thai.portal.domain.Message;
import thai.portal.service.dto.MessageDto;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MessageMapper {
    Message mapToEntity(MessageDto messageDto);

    MessageDto mapToDto(Message message);
}
