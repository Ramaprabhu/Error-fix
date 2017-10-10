package com.example.shiva.sms;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

    PendingIntent pi;
    SmsManager sms;
    Button b1;
    EditText msd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.Send);
        msd=(EditText)findViewById(R.id.Message);

//======================================
//    Get all pending Activity
//======================================
    }
    public void Send(View view)
    {
        String msg = msd.getText().toString();
        PendingIntent piSent = PendingIntent.getBroadcast(MainActivity.this, 0, new Intent(msg), 0);

//======================================
//    Send SMS Using Default SMS Manager
//======================================
        sms = SmsManager.getDefault();
        sms.sendTextMessage("5556", null, msg, piSent, null);

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
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}


