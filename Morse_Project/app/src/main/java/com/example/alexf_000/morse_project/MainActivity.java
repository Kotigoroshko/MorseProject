package com.example.alexf_000.morse_project;

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
    private EditText textField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        but = (Button)findViewById(R.id.button);

        textField = (EditText)findViewById(R.id.editText);

    }

    public void onClick(View view){

        myLight = new MyLight();

        StringTransformer st = new StringTransformer(textField.getText().toString());

        myLight.lightStr(st.getMorse_string());

        /*
        // SOS
        myLight.lightDot();
        MyLight.pause(MyLight.SYMBOL_SPACE);
        myLight.lightDot();
        MyLight.pause(MyLight.SYMBOL_SPACE);
        myLight.lightDot();

        MyLight.pause(MyLight.LETTER_SPACE);

        myLight.lightDash();
        MyLight.pause(MyLight.SYMBOL_SPACE);
        myLight.lightDash();
        MyLight.pause(MyLight.SYMBOL_SPACE);
        myLight.lightDash();

        MyLight.pause(MyLight.LETTER_SPACE);

        myLight.lightDot();
        MyLight.pause(MyLight.SYMBOL_SPACE);
        myLight.lightDot();
        MyLight.pause(MyLight.SYMBOL_SPACE);
        myLight.lightDot();
        */

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
