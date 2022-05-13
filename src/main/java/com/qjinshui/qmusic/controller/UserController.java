package com.qjinshui.qmusic.controller;

import com.qjinshui.qmusic.dto.UserCreateDto;
import com.qjinshui.qmusic.mapper.UserMapper;
import com.qjinshui.qmusic.service.UserService;
import com.qjinshui.qmusic.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;
    private UserMapper userMapper;
    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    List<UserVo> list(){
        return userService.list().stream().map(userMapper::toVo).collect(Collectors.toList());
    }

    @PostMapping("/")
    UserVo create(@RequestBody UserCreateDto userCreateDto){
        return userMapper.toVo(userService.create(userCreateDto));
    };

}
