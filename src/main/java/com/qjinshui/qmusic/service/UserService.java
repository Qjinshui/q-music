package com.qjinshui.qmusic.service;

import com.qjinshui.qmusic.dto.UserCreateRequest;
import com.qjinshui.qmusic.dto.UserDto;
import com.qjinshui.qmusic.dto.UserUpdateRequest;
import com.qjinshui.qmusic.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface UserService extends UserDetailsService {


    @Override
    User loadUserByUsername(String username);

    UserDto create(UserCreateRequest userCreateRequest);

    UserDto get(String id);

    UserDto update(String id, UserUpdateRequest userUpdateRequest);

    void delete(String id);

    Page<UserDto> search(Pageable pageable);
}
