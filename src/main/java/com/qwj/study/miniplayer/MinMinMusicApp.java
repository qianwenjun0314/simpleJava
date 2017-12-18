package com.qwj.study.miniplayer;

import javax.sound.midi.*;

/**
 * Hello world!
 *
 */
public class MinMinMusicApp 
{
    public static void main( String[] args )
    {
        System.out.println( "Start MinMinMusicApp!" );
        MinMinMusicApp mini = new MinMinMusicApp();
        mini.play();
    }
    
    public void play(){
    	
    	try {
    		//取得音序器，并打开
			Sequencer player = MidiSystem.getSequencer();
			player.open();
			
			//创建序列和track（CD和CD里面的歌曲类目）
			Sequence seq = new Sequence(Sequence.PPQ,4);
			Track track = seq.createTrack();
			
			//制作MidiEvent （执行的时机）,Message（执行的内容）
			ShortMessage a = new ShortMessage();
			a.setMessage(144, 1, 44, 100);
			MidiEvent noteOn = new MidiEvent(a,1);
			track.add(noteOn);
			
			ShortMessage b = new ShortMessage();
			a.setMessage(128, 1, 44, 100);
			MidiEvent noteOff = new MidiEvent(b,16);
			track.add(noteOff);
			
			//将具体的歌曲信息，放在sequence中
			player.setSequence(seq);
			player.start();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
}
