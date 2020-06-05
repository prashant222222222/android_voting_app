package com.example.fvotingapp;
import java.util.*;
import java.io.*;
import java.lang.*;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static java.util.Locale.getDefault;

public class choose extends AppCompatActivity {
    Cursor cur;
    int iq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        final String ad=MainActivity.aadhar;
        mydb mdb;
        TextView b1=findViewById(R.id.timer);
        SQLiteDatabase db;
        String tt=String.format("select voted from voterlist where aadhar= '%s' ",ad);
        mdb = new mydb(this);
        db = mdb.getReadableDatabase();
       cur=db.rawQuery(tt,null);
        if (cur.getCount() == 0) {//Log.i("no","ffgrg");
            Toast.makeText(this, "", Toast.LENGTH_SHORT).show();}
                     else{
                while (cur.moveToNext()) {
                    String gg = cur.getString(0);
                    Log.i("can", gg);
                    iq=Integer.parseInt((gg));

                }


            String currentTime = new SimpleDateFormat("HH:mm:ss", getDefault()).format(new Date());
                Log.i("time",currentTime);

            Calendar rightNow = Calendar.getInstance();
            int currentHourIn24Format = rightNow.get(Calendar.HOUR_OF_DAY);
            Log.i("time",Integer.toString(currentHourIn24Format));
            int xx=(24+2-currentHourIn24Format)%24;

            b1.setText("Remaining Voting Time  \n"+(24+2-currentHourIn24Format)%24 +" HOURS");
                if(iq==1 || xx<=0){
            View b = findViewById(R.id.vote);
            b.setVisibility(View.GONE);
            b1.setVisibility(View.GONE);
            Toast.makeText(this,"TIME OVER OR ALREADY DONE VOTING",Toast.LENGTH_LONG).show();
                }
            }
    }
    public void vote(View view)
    { //Intent intent = getIntent();


       // String state = intent.getStringExtra("state");
        Intent i=new Intent(this,vote.class);
        //i.putExtra("state", state);
        startActivity(i);
    }


    public void result(View view)
        {
            Intent i=new Intent(this,result.class);
            startActivity(i);
        }
}
