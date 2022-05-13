package com.qjinshui.qmusic.controller;

import com.qjinshui.qmusic.dto.UserCreateDto;
import com.qjinshui.qmusic.dto.UserDto;
import com.qjinshui.qmusic.entity.User;
import com.qjinshui.qmusic.mapper.UserMapper;
import com.qjinshui.qmusic.repository.UserRepository;
import com.qjinshui.qmusic.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class UserControllerTest {
    private UserRepository userRepository;
    private UserService userService;
    private UserMapper userMapper;
    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    @Test
    public void test(){
        UserCreateDto userCreateDto = new UserCreateDto();
        userCreateDto.setUsername("zhangsan");
        userCreateDto.setPassword("12345678");
        System.out.println("userCreateDto = " + userCreateDto);
        User user = userMapper.createEntity(userCreateDto);
        System.out.println("user = " + user);
//        userRepository.save(user);
//        Optional<User> user = userRepository.findByUsername(userCreateDto.getUsername());
//        System.out.println("user=" + user);
    }

    @Test
    void setUserMapper() {
    }

    @Test
    void setUserService() {
    }

    @Test
    void list() {
    }

    @Test
    void create() {
        UserCreateDto userCreateDto = new UserCreateDto();
        userCreateDto.setUsername("zhangsan");
        userCreateDto.setPassword("12345678");

        System.out.println(userCreateDto.getUsername());

//        UserDto userDto = userService.create(userCreateDto);
//        System.out.println(userDto);
    }

}