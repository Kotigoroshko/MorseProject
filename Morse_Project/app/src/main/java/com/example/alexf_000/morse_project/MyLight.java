package com.example.alexf_000.morse_project;

import android.hardware.Camera;

/**
 * Created by alexf_000 on 27.03.2015.
 */
public class MyLight {
    private Camera camera;
    private Camera.Parameters params;

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
        pause(Constants.DOT);
        lightOff();
    }

    public void lightDash() {
        lightOn();
        pause(Constants.DASH);
        lightOff();
    }

    public void lightStr(String str){

        char[] string = str.toCharArray();

        for(int i=0; i<str.length(); i++){
            if(string[i] == '.'){
                lightDot();
                pause(Constants.SYMBOL_SPACE);
            }

            if(string[i] == '-'){
                lightDash();
                pause(Constants.SYMBOL_SPACE);
            }

            if(string[i] == '|')
                pause(Constants.LETTER_SPACE - Constants.SYMBOL_SPACE);
        }
    }

    public static void pause(int constant){
        try {
            Thread.sleep(constant);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
