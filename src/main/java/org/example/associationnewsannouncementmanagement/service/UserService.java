package org.example.associationnewsannouncementmanagement.service;

import org.example.associationnewsannouncementmanagement.dto.UserDto;

public interface UserService {
    UserDto registerUser(UserDto userDto);
    String loginUser(UserDto userDto);
}
