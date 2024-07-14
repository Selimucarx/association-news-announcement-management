package org.example.associationnewsannouncementmanagement.service;

import org.example.associationnewsannouncementmanagement.config.EmailValidator;
import org.example.associationnewsannouncementmanagement.dto.UserDto;
import org.example.associationnewsannouncementmanagement.exception.EmailAlreadyExistsException;
import org.example.associationnewsannouncementmanagement.exception.InvalidEmailException;
import org.example.associationnewsannouncementmanagement.exception.LoginFailedException;
import org.example.associationnewsannouncementmanagement.mapper.UserMapper;
import org.example.associationnewsannouncementmanagement.model.ErrorMessageType;
import org.example.associationnewsannouncementmanagement.model.User;
import org.example.associationnewsannouncementmanagement.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public UserServiceImpl(UserRepository userRepository, JwtService jwtService, UserMapper userMapper, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }


    @Override
    public UserDto registerUser(UserDto userDto) {
        if (!EmailValidator.validate(userDto.getEmail())) {
            throw new InvalidEmailException(ErrorMessageType.INVALID_EMAIL + userDto.getEmail());
        }

        if (userRepository.findByEmail(userDto.getEmail()).isPresent()) {
            throw new EmailAlreadyExistsException(ErrorMessageType.EMAIL_ALREADY_EXISTS + userDto.getEmail());
        }

        User newUser = User.builder()
                .email(userDto.getEmail())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .build();

        User savedUser = userRepository.save(newUser);
        return userMapper.toDto(savedUser);
    }

    @Override
    public String loginUser(UserDto userDto) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userDto.getEmail(), userDto.getPassword())
            );

            UserDetails userDetails = (UserDetails) authentication.getPrincipal();

            return jwtService.generateToken(userDetails);
        } catch (AuthenticationException e) {
            throw new LoginFailedException(ErrorMessageType.LOGIN_FAILED.getMessage());
        }
    }

}
