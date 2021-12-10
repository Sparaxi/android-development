package com.example.googleapitest;


public class GbooksStringStorage {
   private String title;
   private String subtitle;


    public GbooksStringStorage() {

    }

    @Override
    public String toString() {
        return  title + '\'' +  subtitle + '\''
                ;
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


}
