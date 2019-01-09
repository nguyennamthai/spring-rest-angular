package thai.portal.service.impl;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import thai.portal.repository.UserRepository;
import thai.portal.service.dto.UserDto;
import thai.portal.service.mapper.UserMapper;
import thai.portal.service.UserService;

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
        return userRepository.findAll().map(userMapper::mapToDto);
    }

    @Override
    public Mono<UserDto> save(Mono<UserDto> userDto) {
        return userRepository.saveAll(userDto.map(userMapper::mapToEntity)).single().map(userMapper::mapToDto);
    }
}
