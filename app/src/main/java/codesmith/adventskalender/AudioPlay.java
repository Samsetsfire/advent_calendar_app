package codesmith.adventskalender;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;

/**
 * Created by Julian on 15.11.2015.
 */
public class AudioPlay {
    public static MediaPlayer mediaPlayer;
    private static SoundPool soundPool;
    public static boolean isplayingAudio=false;
    static int length;


    public static void playAudio(Context c, int id){
        mediaPlayer = MediaPlayer.create(c,id);
        soundPool = new SoundPool(4, AudioManager.STREAM_MUSIC, 100);
        isplayingAudio=true;
        mediaPlayer.start();
    }
    public static void stopAudio(){
        isplayingAudio=false;
        mediaPlayer.stop();
        mediaPlayer.release();
        mediaPlayer = null;
    }

    public static void pauseAudio(){
        isplayingAudio=false;
        mediaPlayer.pause();
        length=mediaPlayer.getCurrentPosition();
    }

    public static void resumeAudio(){
        isplayingAudio=true;
        mediaPlayer.seekTo(length);
        mediaPlayer.start();
    }

}
