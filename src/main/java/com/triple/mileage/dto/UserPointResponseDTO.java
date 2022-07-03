package com.triple.mileage.dto;

import com.triple.mileage.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@Builder
public class UserPointResponseDTO {

    private final int point;

    public static UserPointResponseDTO from(User user) {
        return UserPointResponseDTO.builder()
                .point(user.getPoint())
                .build();
    }
}
