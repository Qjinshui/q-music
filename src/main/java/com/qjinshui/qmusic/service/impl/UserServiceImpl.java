package com.qjinshui.qmusic.service.impl;

import com.qjinshui.qmusic.dto.UserCreateDto;
import com.qjinshui.qmusic.dto.UserDto;
import com.qjinshui.qmusic.entity.User;
import com.qjinshui.qmusic.exception.BizException;
import com.qjinshui.qmusic.exception.ExceptionType;
import com.qjinshui.qmusic.mapper.UserMapper;
import com.qjinshui.qmusic.repository.UserRepository;
import com.qjinshui.qmusic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    UserMapper userMapper;

    PasswordEncoder passwordEncoder;

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDto> list() {
        return userRepository.findAll().stream().map(userMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public UserDto create(UserCreateDto userCreateDto) {
        checkUserName(userCreateDto.getUsername());
        User user = userMapper.createEntity(userCreateDto);
        String encode = passwordEncoder.encode(user.getPassword());
        user.setPassword(encode);
        return userMapper.toDto(userRepository.save(user));
    }

    @Override
    public User loadUserByUsername(String username){
        Optional<User> user = userRepository.findByUsername(username);
        if (!user.isPresent()){
            throw new BizException(ExceptionType.USER_NOT_FOUND);
        }
        return user.get();
    }

    private void checkUserName(String username){
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()){
            throw new BizException(ExceptionType.USER_NAME_DUPLICATE);
        }
    }
}
