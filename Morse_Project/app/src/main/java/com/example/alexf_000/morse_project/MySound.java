package com.example.alexf_000.morse_project;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;

/**
 * Created by Valera on 16.04.2015.
 */
public class MySound {

    AudioManager am;
    MediaPlayer mediaPlayer;
    Context context;

    public MySound(Context mContext) {
        am = (AudioManager) mContext.getSystemService(Context.AUDIO_SERVICE);
        context=mContext;
    }

    public void soundDot() {
        mediaPlayer = MediaPlayer.create(context, R.raw.beep_short);
        mediaPlayer.start();
    }

    public void soundDash() {
        mediaPlayer = MediaPlayer.create(context, R.raw.beep_long);
        mediaPlayer.start();
    }

    public void shortPause() {
        mediaPlayer = MediaPlayer.create(context, R.raw.short_pause);
        mediaPlayer.start();
    }
    public void longPause() {
        mediaPlayer = MediaPlayer.create(context, R.raw.long_pause);
        mediaPlayer.start();
    }

    public void soundStr(String str){
        StringTransformer st = new StringTransformer(str);

        char[] string = st.getMorse_string().toCharArray();
        for(int i=0; i<str.length(); i++){
            if(string[i] == '.'){
                soundDot();
                shortPause();
                //pause(Constants.SYMBOL_SPACE);
            }

            if(string[i] == '-'){
                soundDash();
                shortPause();
                //pause(Constants.SYMBOL_SPACE);
            }

            if(string[i] == '|')
                //pause(Constants.LETTER_SPACE - Constants.SYMBOL_SPACE);
            longPause();
        }
    }
}