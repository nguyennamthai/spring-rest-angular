package thai.service;

import thai.service.dto.UserDto;

import java.util.List;

public interface UserService {
    void save(UserDto userDto);

    List<UserDto> getAll();

    UserDto getByEmail(String email);
}
