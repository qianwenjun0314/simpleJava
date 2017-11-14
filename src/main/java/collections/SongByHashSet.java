/**
 * Copyright (C), 2015-2017
 * FileName: SongByHashSet
 * Author:   qianwenjun
 * Date:     2017/11/3 17:27
 * Description: 不重复的Song
 */
package collections;

import java.util.Comparator;

/**
 * 〈一句话功能简述〉<br> 
 * 〈不重复的Song〉
 *
 * @author qianwenjun
 * @create 2017/11/3
 * @since 1.0.0
 */
public class SongByHashSet implements Comparable <SongByHashSet> {


    private String title;
    private String songer;
    private String rating;
    private String time;

    public SongByHashSet ( String title, String songer, String rating, String time) {

        this.title = title;
        this.songer = songer;
        this.rating = rating;
        this.time = time;
    }

    public int compareTo(SongByHashSet s) {
        return title.compareTo(s.getTitle());
    }

    /*
    * 重写HashSet和equal()方法，比较对象是否完全相等
    * */
    public int hashCode () {
        return title.hashCode();
    }

    public boolean equals (Object aSong) {
        Song s = (Song) aSong;
        return getTitle().equals(s.getTitle());
    }



    @Override
    public String toString() {
        return title + "-" + songer;
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