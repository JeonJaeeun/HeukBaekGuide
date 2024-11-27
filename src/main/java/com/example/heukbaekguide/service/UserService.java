package com.example.heukbaekguide.service;

import lombok.RequiredArgsConstructor;
import com.example.heukbaekguide.domain.User;
import com.example.heukbaekguide.dto.AddUserRequest;
import com.example.heukbaekguide.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public Long save(AddUserRequest dto) {
        return userRepository.save(User.builder()
                .email(dto.getEmail())
                .password(bCryptPasswordEncoder.encode(dto.getPassword()))
                .build()).getUserid();
    }
}