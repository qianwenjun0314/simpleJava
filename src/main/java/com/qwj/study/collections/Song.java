package com.qwj.study.collections;

/**
 * Created by qianwenjun on 2017/11/2.
 */
public class Song implements Comparable<Song> {
    private String title;
    private String songer;
    private String rating;
    private String time;

    public Song ( String title, String songer, String rating, String time) {

        this.title = title;
        this.songer = songer;
        this.rating = rating;
        this.time = time;
    }
    /*
    * 返回string比较的结果
    * */
    public int compareTo(Song s) {
        return title.compareTo(s.getTitle());
    }

    @Override
    public String toString() {
        return title +  "--" +songer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSonger() {
        return songer;
    }

    public void setSonger(String songer) {
        this.songer = songer;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getTime() {

        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }



}
