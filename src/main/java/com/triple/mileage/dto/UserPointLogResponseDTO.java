package com.triple.mileage.dto;

import com.triple.mileage.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
@Builder
public class UserPointLogResponseDTO {

    private final int point;
    private final List<PointLogResponseDTO> pointLogResponseDTOS;

    public static UserPointLogResponseDTO from(User user, List<PointLogResponseDTO> pointLogResponseDTOS) {
        return UserPointLogResponseDTO.builder()
                .point(user.getPoint())
                .pointLogResponseDTOS(pointLogResponseDTOS)
                .build();
    }
}
