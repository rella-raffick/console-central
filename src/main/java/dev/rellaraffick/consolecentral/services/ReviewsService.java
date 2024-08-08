package dev.rellaraffick.consolecentral.services;

import dev.rellaraffick.consolecentral.records.ConsoleCentralReviews;
import dev.rellaraffick.consolecentral.repositories.ReviewsRepository;

public class ReviewsService {
    private final ReviewsRepository reviewsRepository;

    public ReviewsService(ReviewsRepository reviewsRepository) {
        this.reviewsRepository = reviewsRepository;
    }

    public void getReviews() {
        reviewsRepository.findAll();
    }

    public void getReview(Integer id) {
        reviewsRepository.findById(id).orElseThrow();
    }

    public void createReview(ConsoleCentralReviews review) {
        reviewsRepository.save(review);
    }

    public void deleteReview(Integer id) {
        reviewsRepository.deleteById(id);
    }

    public void updateReview(Integer id, ConsoleCentralReviews reviewDetails) {
        ConsoleCentralReviews existingReview = reviewsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Review not found with id: " + id));
        existingReview.setUser(reviewDetails.getUser());
        existingReview.setProduct(reviewDetails.getProduct());
        existingReview.setRating(reviewDetails.getRating());
        existingReview.setComment(reviewDetails.getComment());
        existingReview.setReviewDate(reviewDetails.getReviewDate());
        reviewsRepository.save(existingReview);
    }
}
