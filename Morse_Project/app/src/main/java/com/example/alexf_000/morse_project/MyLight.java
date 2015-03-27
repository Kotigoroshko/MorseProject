package com.example.alexf_000.morse_project;

import android.hardware.Camera;

/**
 * Created by alexf_000 on 27.03.2015.
 */
public class MyLight {
    private Camera camera;

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
}
