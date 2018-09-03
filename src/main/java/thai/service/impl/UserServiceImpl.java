package thai.service.impl;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import thai.repository.UserRepository;
import thai.service.UserService;
import thai.service.dto.UserDto;
import thai.service.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userMapper = Mappers.getMapper(UserMapper.class);
        this.userRepository = userRepository;
    }

    @Override
    public Flux<UserDto> getAll() {
        return null;
    }

    @Override
    public Mono<Void> save(Mono<UserDto> userDto) {
        return null;
    }

    @Override
    public Mono<UserDto> getByEmail(Mono<String> email) {
        return null;
    }
}
