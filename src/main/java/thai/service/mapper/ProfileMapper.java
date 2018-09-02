package thai.service.mapper;

import org.mapstruct.Mapper;
import thai.domain.Profile;
import thai.service.dto.ProfileDto;

@Mapper
public interface ProfileMapper {
    Profile mapToEntity(ProfileDto profileDto);

    ProfileDto mapToDto(Profile profile);
}
