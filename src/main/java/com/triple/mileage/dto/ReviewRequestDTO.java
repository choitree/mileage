package com.triple.mileage.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewRequestDTO {

    private String type;
    private String action;
    private UUID reviewId;
    private String content;

    @JsonProperty("attachedPhotoIds")
    private List<UUID> photoIds;

    private UUID userId;
    private UUID placeId;
}
