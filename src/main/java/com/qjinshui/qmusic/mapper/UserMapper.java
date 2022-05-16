package com.qjinshui.qmusic.mapper;

import com.qjinshui.qmusic.dto.UserCreateRequest;
import com.qjinshui.qmusic.dto.UserDto;
import com.qjinshui.qmusic.dto.UserUpdateRequest;
import com.qjinshui.qmusic.entity.User;
import com.qjinshui.qmusic.vo.UserVo;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;



@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);

    UserVo toVo(UserDto userDto);

    User createEntity(UserCreateRequest userCreateDto);

    User updateEntity(@MappingTarget User user, UserUpdateRequest userUpdateRequest);
}
