package com.triple.mileage.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "photo")
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(columnDefinition = "char(36)")
    private String fileName;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumns(foreignKey = @ForeignKey(name = "fk_photo_review"),
            value = {@JoinColumn(name = "review_id", referencedColumnName = "review_id"),
                    @JoinColumn(name = "event_type", referencedColumnName = "event_type")
            })
    private Review review;

    public Photo(String fileName, Review review) {
        this.fileName = fileName;
        this.review = review;
    }
}
