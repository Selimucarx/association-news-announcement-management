package org.example.associationnewsannouncementmanagement.service;

import org.example.associationnewsannouncementmanagement.model.CustomUserDetails;
import org.example.associationnewsannouncementmanagement.model.User;
import org.example.associationnewsannouncementmanagement.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public CustomUserDetails loadUserByUsername(String email) throws RuntimeException {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found: " + email));

        return new CustomUserDetails(user);
    }

}