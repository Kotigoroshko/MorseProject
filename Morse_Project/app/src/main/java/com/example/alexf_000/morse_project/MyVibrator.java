package com.example.alexf_000.morse_project;

import android.content.Context;
import android.os.Vibrator;

import static com.example.alexf_000.morse_project.MyLight.pause;

/**
 * Created by Olexiy on 01.04.2015.
 */
public class MyVibrator {

    private Vibrator v;

    public MyVibrator(Context mContext) {
        v = (Vibrator) mContext.getSystemService(Context.VIBRATOR_SERVICE);
    }

    public void vibrateStr(String str) {
        long[] arr = new long[str.length()*2+1];
        arr[0] = 0;

        char[] string = str.toCharArray();
        for(int i=0; i<str.length(); i++){
            if(string[i] == '.'){
                arr[2*(i+1)-1] = Constants.DOT;
                arr[2*(i+1)] = Constants.SYMBOL_SPACE;
            }

            if(string[i] == '-'){
                arr[2*(i+1)-1] = Constants.DASH;
                arr[2*(i+1)] = Constants.SYMBOL_SPACE;
            }

            if(string[i] == '|') {
                arr[2*(i+1)-1] = 0;
                arr[2*(i+1)] = Constants.LETTER_SPACE - Constants.SYMBOL_SPACE;
            }

            v.vibrate(arr, -1);
        }
    }

}
