package com.example.ashukaushik.foodies;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by ashukaushik on 12/07/16.
 */
public class restaurantResponse {
    @SerializedName("restaurants")
    private ArrayList<data> restaurants;

    public ArrayList<data> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(ArrayList<data> restaurants) {
        this.restaurants = restaurants;
    }

    public class data{
        private restaurant restaurant;

        public restaurantResponse.restaurant getRestaurant() {
            return restaurant;
        }

        public void setRestaurant(restaurantResponse.restaurant restaurant) {
            this.restaurant = restaurant;
        }
    }
    public class Location{
        @SerializedName("address")
        private String address;

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }
    }

    public class restaurant {
        @SerializedName("name")
        private String name;
        @SerializedName("featured_image")
        private String image;
        @SerializedName("cuisines")
        private String cuisines;
        @SerializedName("average_cost_for_two")
        private String averageCostForTwo;
        @SerializedName("id")
        private String resId;
        @SerializedName("location")
        private Location location;

        public restaurant(String name, Location location, String image, String cuisines, String averageCostForTwo, String resId) {
            this.name = name;
            this.location = location;
            //this.image = image;
            this.cuisines = cuisines;
            this.averageCostForTwo = averageCostForTwo;
            this.resId = resId;
        }

        public String getResId() {
            return resId;
        }

        public void setResId(String resId) {
            this.resId = resId;
            
        }

        public String getCuisines() {
            return cuisines;
        }

        public void setCuisines(String cuisines) {
            this.cuisines = cuisines;
        }

        public String getAverageCostForTwo() {
            return averageCostForTwo;
        }

        public void setAverageCostForTwo(String averageCostForTwo) {
            this.averageCostForTwo = averageCostForTwo;
        }
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public Location getLocation() {
            return location;
        }

        public void setLocation(Location location) {
            this.location = location;
        }
    }
}
