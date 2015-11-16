package com.camera.flux.com.fluxchannel;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String fontPath = "fonts/Roboto-Thin.ttf";

        // text view label
        final TextView start = (TextView) findViewById(R.id.start);
        //TextView channelName = (TextView) findViewById(R.id.channelName);
        TextView date = (TextView) findViewById(R.id.date);
        TextView time = (TextView) findViewById(R.id.time);
        final TextView connectionStatus = (TextView) findViewById(R.id.connectionStatus);
        final ImageButton connect = (ImageButton) findViewById(R.id.connectButton);
        final ImageView pink = (ImageView) findViewById(R.id.pink);
        final ImageView green = (ImageView) findViewById(R.id.green);
        // Loading Font Face
        Typeface tf = Typeface.createFromAsset(getAssets(), fontPath);

        // Applying font
        start.setTypeface(tf);
        //channelName.setTypeface(tf);
        date.setTypeface(tf);
        time.setTypeface(tf);
        connectionStatus.setTypeface(tf);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        start.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                if(start.getText() == "START") {
                    start.setText("STOP");
                }else{
                    start.setText("START");
                }
            }

     });

        connect.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                if(connectionStatus.getText() == "Disconnected") {
                    connectionStatus.setText("Connected");
                    pink.setImageResource(R.drawable.green);
                }else{
                    connectionStatus.setText("Disconnected");
                    pink.setImageResource(R.drawable.pink);
                }
            }

        });



    }
    public void sendMessage(View view)
    {
        Intent intent = new Intent(MainActivity.this, CameraActivity.class);
        startActivity(intent);
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
