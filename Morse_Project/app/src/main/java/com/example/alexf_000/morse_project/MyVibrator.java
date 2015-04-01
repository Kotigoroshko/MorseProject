package com.example.alexf_000.morse_project;

/**
 * Created by Olexiy on 01.04.2015.
*/
import android.content.Context;
import android.os.Vibrator;

import static com.example.alexf_000.morse_project.MyLight.pause;

/**
 * Created by Olexiy on 01.04.2015.
 */
public class MyVibrator {

    private Vibrator v;
    //private Context mContext;

    public MyVibrator(Context mContext) {
        v = (Vibrator) mContext.getSystemService(Context.VIBRATOR_SERVICE);
    }

    public void vibrateDot() {
        v.vibrate(Constants.DOT);
    }

    public void vibrateDash() {
        v.vibrate(Constants.DASH);
    }

    public void vibrateStr(String str) {
        char[] string = str.toCharArray();
        for(int i=0; i<str.length(); i++){
            if(string[i] == '.'){
                vibrateDot();
                pause(Constants.SYMBOL_SPACE_VIBRO);
            }

            if(string[i] == '-'){
                vibrateDash();
                pause(Constants.SYMBOL_SPACE_VIBRO);
            }

            if(string[i] == '|')
                pause(Constants.LETTER_SPACE_VIBRO - Constants.SYMBOL_SPACE_VIBRO);
        }
    }

}
