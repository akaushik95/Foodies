package com.example.ashukaushik.foodies;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by ashukaushik on 11/07/16.
 */
public class CategoriesResponse {
    @SerializedName("categories")
    private ArrayList<Data> categories;

    public ArrayList<Data> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<Data> categories) {
        this.categories = categories;
    }

    public class Data {
        private Category categories;

        public Category getCategory() {
            return categories;
        }

        public void setCategory(Category categories) {
            this.categories = categories;
        }
    }

    public class Category {
        private String name;
        private int id;

        public Category(String name, int id) {
            this.name = name;
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}
