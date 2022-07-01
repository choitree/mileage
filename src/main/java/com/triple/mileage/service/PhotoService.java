package com.triple.mileage.service;

import com.triple.mileage.domain.Photo;
import com.triple.mileage.domain.Review;
import com.triple.mileage.repository.PhotoRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PhotoService {

    private final PhotoRepository photoRepository;

    public PhotoService(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    @Transactional
    public void convertAndSaveAllPhotosByReview(List<UUID> fileNames, Review review) {
        List<Photo> photos = new ArrayList<>();
        for (UUID fileName : fileNames) {
            Photo photo = new Photo(fileName, review);
            photos.add(photo);
        }
        photoRepository.saveAll(photos);
    }

    @Transactional
    public void deleteAllPhotoByReview(Review review) {
        photoRepository.deleteAllByReview(review);
    }
}
