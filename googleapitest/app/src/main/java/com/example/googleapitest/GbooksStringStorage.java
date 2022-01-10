package com.example.googleapitest;


import org.json.JSONArray;

public class GbooksStringStorage {
   private String title;
   private String subtitle;
   private String authors;



    public GbooksStringStorage() {

    }

    @Override
    public String toString() {
        if( subtitle == null || subtitle.isEmpty()){
            subtitle = (" No subtitle available");
        }

        if( authors == null || authors.isEmpty()){
            authors = (" No Author available");
        }

        return
                "Title: " + title +
                ", Subtitle: " + subtitle +
                ", Author: " + authors
                ;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }


    public void setAuthors(JSONArray jsonArray) {
    }
}
