package com.example.newsreader;

public class NewsModel {

    String newsTitle, newsDescription, newsDate, newsImageUrl;

    public NewsModel(String newsTitle, String newsDescription, String newsDate, String newsImageUrl) {
        this.newsTitle = newsTitle;
        this.newsDescription = newsDescription;
        this.newsDate = newsDate;
        this.newsImageUrl = newsImageUrl;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public String getNewsDescription() {
        return newsDescription;
    }

    public String getNewsDate() {
        return newsDate;
    }

    public String getNewsImageUrl() {
        return newsImageUrl;
    }

}
