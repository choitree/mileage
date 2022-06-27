package com.triple.mileage.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.Column;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewRequestDTO {

    private String type;
    private String action;
    private String reviewId;
    private String content;

    @JsonProperty("attachedPhotoIds")
    private List<String> photoIds;

    private String userId;
    private String placeId;

}
