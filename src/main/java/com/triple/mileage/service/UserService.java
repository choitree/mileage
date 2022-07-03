package com.triple.mileage.service;

import com.triple.mileage.domain.User;
import com.triple.mileage.dto.PointLogResponseDTO;
import com.triple.mileage.dto.UserPointLogResponseDTO;
import com.triple.mileage.dto.UserPointResponseDTO;
import com.triple.mileage.exception.UserNotFoundException;
import com.triple.mileage.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PointLogService pointLogService;

    public User findByUserId(String userId) {
        return userRepository.findByUserId(userId)
                .orElseThrow(() -> new UserNotFoundException("해당 유저가 존재하지 않습니다."));
    }

    public UserPointResponseDTO showUserPoint(String userId) {
        User user = findByUserId(userId);
        return UserPointResponseDTO.from(user);
    }

    public UserPointLogResponseDTO showUserPointLog(String userId) {
        List<PointLogResponseDTO> pointLogResponseDTOS = pointLogService.showAllPointLogsByUser(userId);
        User user = findByUserId(userId);
        return UserPointLogResponseDTO.from(user, pointLogResponseDTOS);
    }
}
