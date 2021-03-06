package com.example.alexf_000.morse_project;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;

/**
 * Created by Valera on 16.04.2015.
 */
public class MySound {

    //AudioManager am;
    //public MediaPlayer mediaPlayer1;
    public MediaPlayer mediaPlayer2;
    Context context;

    public MySound(Context mContext) {
        //am = (AudioManager) mContext.getSystemService(Context.AUDIO_SERVICE);
        context=mContext;

        //mediaPlayer1 = MediaPlayer.create(context, R.raw.beep_short);
        mediaPlayer2 = MediaPlayer.create(context, R.raw.beep_long);

        mediaPlayer2.setLooping(true);
        mediaPlayer2.start();
        mediaPlayer2.pause();
    }

    public void end(){
        //mediaPlayer1.stop();
        mediaPlayer2.stop();

        //mediaPlayer1.release();
        mediaPlayer2.release();
    }

    public void soundDot() {
        //mediaPlayer2 = MediaPlayer.create(context, R.raw.beep);
        mediaPlayer2.start();
        pause(Constants.DOT);
        mediaPlayer2.pause();
        //mediaPlayer1.release();

    }

    public void soundDash(){
        //mediaPlayer2 = MediaPlayer.create(context, R.raw.beep);
        mediaPlayer2.start();
        pause(Constants.DASH);
        mediaPlayer2.pause();
        //mediaPlayer2.release();

    }

    public void shortPause() {
        //mediaPlayer = MediaPlayer.create(context, R.raw.short_pause);
        //mediaPlayer.start();
    }
    public void longPause() {
       // mediaPlayer = MediaPlayer.create(context, R.raw.long_pause);
        //mediaPlayer.start();
    }

    private void pause(int constant){
        try {
            Thread.sleep(constant);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void soundStr(String str){
        //StringTransformer st = new StringTransformer(str);


        char[] string = str.toCharArray();

        for(int i=0; i<str.length(); i++){
            if(string[i] == '.'){
                soundDot();
                //pause(mediaPlayer1.getDuration());
                //shortPause();
                pause(Constants.SYMBOL_SPACE);
            }

            if(string[i] == '-'){
                soundDash();
                //pause(mediaPlayer2.getDuration());
                //shortPause();
                pause(Constants.SYMBOL_SPACE);
            }

            if(string[i] == '|')
                pause(Constants.LETTER_SPACE - Constants.SYMBOL_SPACE);
            //longPause();
        }
    }
}