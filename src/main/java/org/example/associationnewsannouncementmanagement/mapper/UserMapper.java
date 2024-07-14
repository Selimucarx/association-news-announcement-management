package org.example.associationnewsannouncementmanagement.mapper;

import org.example.associationnewsannouncementmanagement.dto.UserDto;
import org.example.associationnewsannouncementmanagement.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);
    User toEntity(User user);
}
