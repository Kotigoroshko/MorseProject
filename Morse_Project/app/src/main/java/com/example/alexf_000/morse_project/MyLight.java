package com.example.alexf_000.morse_project;

import android.hardware.Camera;

/**
 * Created by alexf_000 on 27.03.2015.
 */
public class MyLight {
    private Camera camera;
    private Camera.Parameters params;

    // константи пауз
    public static final int UNIT = 150;

    public static final int DOT = UNIT;
    public static final int DASH = 3 * UNIT;

    public static final int SYMBOL_SPACE = UNIT;
    public static final int LETTER_SPACE = 3 * UNIT;
    public static final int WORD_SPACE = 7 * UNIT;

    public MyLight(){
        start();
    };

    public void start(){
        camera = Camera.open();

        params = camera.getParameters();
        params.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
        camera.setParameters(params);

        camera.startPreview();
    }

    public void end(){
        camera.stopPreview();
        camera.release();
    }

    public void lightOn(){
        params.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
        camera.setParameters(params);
    }

    public void lightOff(){
        params.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
        camera.setParameters(params);
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
