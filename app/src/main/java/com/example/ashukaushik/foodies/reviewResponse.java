package com.example.ashukaushik.foodies;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by ashukaushik on 13/07/16.
 */
public class reviewResponse {
    @SerializedName("user_reviews")
    private ArrayList<Data> userreviews;

    public ArrayList<Data> getUserreviews() {
        return userreviews;
    }

    public void setUserreviews(ArrayList<Data> userreviews) {
        this.userreviews = userreviews;
    }


    public class Data {
        @SerializedName("review")
        private Review review;

        public Review getReview() {
            return review;
        }

        public void setReview(Review review) {
            this.review = review;
        }

        public class Review{
            @SerializedName("review_text")
            private String reviewText;
            @SerializedName("rating_text")
            private String rating;

            public Review(String reviewText, String rating) {
                this.reviewText = reviewText;
                this.rating = rating;
            }

            public String getReviewText() {
                return reviewText;
            }

            public void setReviewText(String reviewText) {
                this.reviewText = reviewText;
            }

            public String getRating() {
                return rating;
            }

            public void setRating(String rating) {
                this.rating = rating;
            }
        }
    }


}
