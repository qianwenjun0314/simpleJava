package com.qwj.study.collections;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by qianwenjun on 2017/11/2.
 */
public class SongBox {
    ArrayList<Song> songList = new ArrayList<Song>();
    ArrayList<String> songerList = new ArrayList<String>();

    public static void main (String[] args) {
        SongBox songbox = new SongBox();
        songbox.go();
    }

    //getSong from file ->addSong from split songinfo
    public void getSong () {
        try {
            File file = new File("song.txt");
            FileReader fileReader  = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);

            String line = null;
            try {
                while((line = reader.readLine()) != null) {
                String songLine = line;
                addSong(songLine);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addSong (String songline) {

        String[] songobject = songline.split("/");

        Song nextSong = new Song( songobject[0], songobject[1], songobject[2], songobject[3]);
//        nextSong = new Song( songobject[0], songobject[1], songobject[2], songobject[3]);
        songList.add(nextSong);
        songerList.add(nextSong.getSonger());
    }

    public void go () {
        getSong();
        System.out.println("歌名： " +songList );
        System.out.println("歌手： " + songerList);

        Collections.sort(songList);
        System.out.println("歌名： " +songList );
        System.out.println("歌手： " + songerList);
    }

}
