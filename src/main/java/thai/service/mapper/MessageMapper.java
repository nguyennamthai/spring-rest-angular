package thai.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import thai.domain.Message;
import thai.service.dto.MessageDto;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MessageMapper {
    Message mapToEntity(MessageDto messageDto);

    MessageDto mapToDto(Message message);
}
