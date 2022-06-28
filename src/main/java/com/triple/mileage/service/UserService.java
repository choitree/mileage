package com.triple.mileage.service;

import com.triple.mileage.domain.User;
import com.triple.mileage.exception.UserNotFoundException;
import com.triple.mileage.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByUserId(UUID userId) {
        return userRepository.findByUserId(userId)
                .orElseThrow(() -> new UserNotFoundException("리뷰를 등록하려는 유저가 존재하지 않습니다."));
    }
}
