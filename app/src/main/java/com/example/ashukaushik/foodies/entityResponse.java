package com.example.ashukaushik.foodies;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by ashukaushik on 11/07/16.
 */
public class entityResponse {
    @SerializedName("location_suggestions")
    private ArrayList<entity> locations;

    public ArrayList<entity> getLocations() {
        return locations;
    }

    public void setLocations(ArrayList<entity> locations) {
        this.locations = locations;
    }
    public class entity{
        @SerializedName("entity_id")
        private String entityId;
        @SerializedName("entity_type")
        private String entityType;
        @SerializedName("country_name")
        private String countryName;


        public entity(String entityId, String entityType, String countryName) {
            this.entityId = entityId;
            this.entityType = entityType;
            this.countryName = countryName;
        }

        public String getCountryName() {
            return countryName;
        }

        public void setCountryName(String countryName) {
            this.countryName = countryName;
        }

        public String getEntityType() {
            return entityType;
        }

        public void setEntityType(String entityType) {
            this.entityType = entityType;
        }

        public String getEntityId() {
            return entityId;
        }

        public void setEntityId(String entityId) {
            this.entityId = entityId;
        }
    }


}
