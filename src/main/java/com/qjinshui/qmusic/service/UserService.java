package com.qjinshui.qmusic.service;

import com.qjinshui.qmusic.dto.UserCreateDto;
import com.qjinshui.qmusic.dto.UserDto;
import com.qjinshui.qmusic.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<UserDto> list();

    UserDto create(UserCreateDto userCreateDto);

    @Override
    User loadUserByUsername(String username);
}
