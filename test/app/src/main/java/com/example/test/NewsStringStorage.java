package com.example.test;

public class NewsStringStorage {
    private String webTitle;


    public NewsStringStorage(String webTitle) {
        this.webTitle = webTitle;
    }

    public NewsStringStorage() {

    }

    @Override
    public String toString() {
        return  webTitle ;
    }

    public String getWebTitle() {
        return webTitle;
    }

    public void setWebTitle(String webTitle) {
        this.webTitle = webTitle;
    }
}
