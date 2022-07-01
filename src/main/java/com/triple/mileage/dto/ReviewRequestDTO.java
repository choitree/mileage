package com.triple.mileage.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import java.util.List;
 

@Getter
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
