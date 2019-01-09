package thai.portal.service.mapper;

import org.mapstruct.Mapper;
import thai.portal.domain.PortalUser;
import thai.portal.service.dto.UserDto;

@Mapper
public interface UserMapper {
    PortalUser mapToEntity(UserDto userDto);

    UserDto mapToDto(PortalUser user);
}
