/**
 * Copyright (C), 2015-2017
 * FileName: SongBox2
 * Author:   qianwenjun
 * Date:     2017/11/3 15:54
 * Description: sort by title and by songer
 */
package collections;

import java.io.*;
import java.util.*;

/**
 * 〈一句话功能简述〉<br> 
 * 〈按照歌名和歌手名字排序〉
 *
 * @author qianwenjun
 * @create 2017/11/3
 * @since 1.0.0
 */
public class SongBox2 {

    ArrayList<Song> songList = new ArrayList<Song>();
    ArrayList<String> songNameList = new ArrayList<String>();
    /*
    *   添加内部类，进行比较歌手名字的大小
    * */
    class SongerCompare implements Comparator<Song> {
        public int compare(Song s1, Song s2) {
            return s1.getSonger().compareTo(s2.getSonger());
        }
    }

    public void getSong () {
        File file = new File("song.txt");
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null ;
            try {
                while (( line = reader.readLine()) != null){
                addSong(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addSong (String line) {
        String[] songObject = line.split("/");
        Song song = new Song(songObject[0],songObject[1],songObject[2],songObject[3]);
        songList.add(song);
        songNameList.add(song.getTitle());
    }

    public void go () {
        getSong();
        System.out.println("直接输出的歌曲列表" + "\n" + songList + "\n");

        Collections.sort(songList);
        System.out.println("根据歌名排序输出的歌曲列表" + "\n"  +songList + "\n");

        SongerCompare songerCompare = new SongerCompare();
        Collections.sort(songList,songerCompare);
        System.out.println("根据歌名和歌手排序输出的歌曲列表" + "\n"  +songList + "\n");
        HashSet<Song> songSet1 = new HashSet<Song>();
        songSet1.addAll(songList);
        System.out.println("去除重复的(歌曲--歌手)" + "\n"  + songSet1 + "\n");


        Collections.sort(songNameList);
        HashSet<String> songSet2 = new HashSet<String>();
        songSet2.addAll(songNameList);
        System.out.println("去除重复的歌曲" + "\n"  + songSet2 + "\n");

    }

    public static void main (String[] args) {
        SongBox2 songBox2 = new SongBox2();
        songBox2.go();
    }
}