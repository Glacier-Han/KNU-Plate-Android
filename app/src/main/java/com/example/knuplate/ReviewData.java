package com.example.knuplate;

public class ReviewData {
    private int detail_profile;
    private String detail_nick;
    private int detail_picture;
    private int detail_rate;
    private String detail_review;

    public ReviewData(int detail_profile, String detail_nick, int detail_picture, int detail_rate, String detail_review) {
        this.detail_profile = detail_profile;
        this.detail_nick = detail_nick;
        this.detail_picture = detail_picture;
        this.detail_rate = detail_rate;
        this.detail_review = detail_review;
    }

    public int getDetail_profile() {
        return detail_profile;
    }

    public void setDetail_profile(int detail_profile) {
        this.detail_profile = detail_profile;
    }

    public String getDetail_nick() {
        return detail_nick;
    }

    public void setDetail_nick(String detail_nick) {
        this.detail_nick = detail_nick;
    }

    public int getDetail_picture() {
        return detail_picture;
    }

    public void setDetail_picture(int detail_picture) {
        this.detail_picture = detail_picture;
    }

    public int getDetail_rate() {
        return detail_rate;
    }

    public void setDetail_rate(int detail_rate) {
        this.detail_rate = detail_rate;
    }

    public String getDetail_review() {
        return detail_review;
    }

    public void setDetail_review(String detail_review) {
        this.detail_review = detail_review;
    }
}
