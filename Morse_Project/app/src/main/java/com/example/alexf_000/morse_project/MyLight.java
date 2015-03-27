package com.example.alexf_000.morse_project;

import android.hardware.Camera;

/**
 * Created by alexf_000 on 27.03.2015.
 */
public class MyLight {
    private Camera camera;

    // константи пауз
    public static final int UNIT = 100;

    public static final int DOT = UNIT;
    public static final int DASH = 3 * UNIT;

    public static final int SYMBOL_SPACE = UNIT;
    public static final int LETTER_SPACE = 3 * UNIT;
    public static final int WORD_SPACE = 7 * UNIT;

    public MyLight(){};

    public void lightOn(){
        camera = Camera.open();

        Camera.Parameters params = camera.getParameters();
        params.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
        camera.setParameters(params);

        camera.startPreview();
    }

    public void lightOff(){
        camera.stopPreview();
        camera.release();
    }

    public void lightDot() {
        lightOn();
        pause(DOT);
        lightOff();
    }

    public void lightDash() {
        lightOn();
        pause(DASH);
        lightOff();
    }

    public static void pause(int constant){
        try {
            Thread.sleep(constant);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
