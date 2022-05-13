package com.qjinshui.qmusic.mapper;

import com.qjinshui.qmusic.dto.UserCreateDto;
import com.qjinshui.qmusic.dto.UserDto;
import com.qjinshui.qmusic.entity.User;
import com.qjinshui.qmusic.vo.UserVo;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
//@Component
public interface UserMapper {
    UserDto toDto(User user);

    UserVo toVo(UserDto userDto);

    User createEntity(UserCreateDto userCreateDto);
}
