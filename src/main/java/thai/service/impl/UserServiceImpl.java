package thai.service.impl;

import org.springframework.stereotype.Service;
import thai.service.UserService;
import thai.service.dto.UserDto;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public void save(UserDto userDto) {

    }

    @Override
    public List<UserDto> getAll() {
        return null;
    }

    @Override
    public UserDto getByEmail(String email) {
        return null;
    }
}
