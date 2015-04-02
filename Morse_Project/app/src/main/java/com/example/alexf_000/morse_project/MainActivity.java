package com.example.alexf_000.morse_project;

import android.content.Context;
import android.hardware.Camera;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;


public class MainActivity extends ActionBarActivity {

    Camera camera;
    private boolean lightOn = false;
    private Button but;
    private MyLight myLight;
    private MyVibrator vibr;
    private EditText textField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       //but = (Button)findViewById(R.id.button);

        textField = (EditText)findViewById(R.id.editText);

    }

    public void onVibroClick(View view){

        vibr = new MyVibrator(MainActivity.this);

        StringTransformer st = new StringTransformer(textField.getText().toString());

        vibr.vibrateStr(st.getMorse_string());

    }

    public void onLightClick(View view){

        myLight = new MyLight();
        myLight.lightStr(textField.getText().toString());

        myLight.end();
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
