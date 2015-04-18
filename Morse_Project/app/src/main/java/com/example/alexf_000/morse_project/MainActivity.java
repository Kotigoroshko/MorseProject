package com.example.alexf_000.morse_project;

import android.hardware.Camera;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {

    Camera camera;
    private boolean lightOn = false;
    private Button but;
    private MyLight myLight;
    private MyVibrator vibr;
    private EditText textField;
    private MySound mySound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       //but = (Button)findViewById(R.id.button);

        textField = (EditText)findViewById(R.id.editText);

    }

    public void onVibroClick(View view){

        vibr = new MyVibrator(MainActivity.this);
        vibr.vibrateStr(textField.getText().toString());

    }

    public void onLightClick(View view){

        myLight = new MyLight();
        myLight.lightStr(textField.getText().toString());

        myLight.end();
    }

    public void onSoundClick(View view){

        mySound = new MySound(MainActivity.this);
        mySound.soundStr(textField.getText().toString());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
