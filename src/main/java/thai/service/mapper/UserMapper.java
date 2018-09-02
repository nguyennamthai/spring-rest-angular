package thai.service.mapper;

import org.mapstruct.Mapper;
import thai.domain.PortalUser;
import thai.service.dto.UserDto;

import java.util.List;

@Mapper
public interface UserMapper {
    PortalUser mapToEntity(UserDto userDto);

    UserDto mapToDto(PortalUser user);

    List<UserDto> mapUsers(List<PortalUser> users);
}
