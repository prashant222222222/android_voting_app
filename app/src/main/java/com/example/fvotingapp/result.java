package com.example.fvotingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class result extends AppCompatActivity {
    mydb mdb;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        mdb = new mydb(this);
        db = mdb.getReadableDatabase();
        Cursor cur;
        String name="", age="", votes="";
        String tt;

        Calendar rightNow = Calendar.getInstance();
        int currentHourIn24Format = rightNow.get(Calendar.HOUR_OF_DAY);
        Log.i("time",Integer.toString(currentHourIn24Format));
        int xx=(24+2-currentHourIn24Format)%24;

        TextView tr = (TextView) findViewById(R.id.tr);
        if(xx<=0)
            tr.setText("FINAL RESULT\n");
        else
        {
            tr.setText("VOTING STILL GOING ON\nNOT THE FINAL RESULT");
        }

        TextView s1 = (TextView) findViewById(R.id.delhi);
        tt = String.format("select * from delhi where votes=(select max(votes) from delhi)");
         cur = db.rawQuery(tt, null);
        if (cur.getCount() == 0) {//Log.i("no","ffgrg");
            Toast.makeText(this, "invalid user", Toast.LENGTH_SHORT).show();
            //
        } else {
            while (cur.moveToNext()) {
                name = cur.getString(1);
                votes = cur.getString(2);
                age = cur.getString(3);
            }}
            s1.setText("DELHI\n winning candidate is\nname : "+name+"\nage : "+age+"\nvotes : "+votes);


            TextView s2 = (TextView) findViewById(R.id.maharastra);
        tt = String.format("select * from maharastra where votes=(select max(votes) from maharastra)");
         cur = db.rawQuery(tt, null);
        if (cur.getCount() == 0) {//Log.i("no","ffgrg");
            Toast.makeText(this, "invalid user", Toast.LENGTH_SHORT).show();
            //
        } else {
            while (cur.moveToNext()) {
                name = cur.getString(1);
                votes = cur.getString(2);
                age = cur.getString(3);
            }}
        s2.setText("MAHARASTRA\n winning candidate is\nname : "+name+"\nage : "+age+"\nvotes : "+votes);



            TextView s3 = (TextView) findViewById(R.id.uttarpradesh);
        tt = String.format("select * from uttarpradesh where votes=(select max(votes) from uttarpradesh)");
        cur = db.rawQuery(tt, null);
        if (cur.getCount() == 0) {//Log.i("no","ffgrg");
            Toast.makeText(this, "invalid user", Toast.LENGTH_SHORT).show();
            //
        } else {
            while (cur.moveToNext()) {
                name = cur.getString(1);
                votes = cur.getString(2);
                age = cur.getString(3);
            }}
        s3.setText("UTTARPRADESH\n winning candidate is\nname : "+name+"\nage : "+age+"\nvotes : "+votes);



            TextView s4 = (TextView) findViewById(R.id.bihar);
        tt = String.format("select * from bihar where votes=(select max(votes) from bihar)");
        cur = db.rawQuery(tt, null);
        if (cur.getCount() == 0) {//Log.i("no","ffgrg");
            Toast.makeText(this, "invalid user", Toast.LENGTH_SHORT).show();
            //
        } else {
            while (cur.moveToNext()) {
                name = cur.getString(1);
                votes = cur.getString(2);
                age = cur.getString(3);
            }}
        s4.setText("BIHAR\n winning candidate is\nname : "+name+"\nage : "+age+"\nvotes : "+votes);



            TextView s5 = (TextView) findViewById(R.id.tamilnadu);
        tt = String.format("select * from tamilnadu where votes=(select max(votes) from tamilnadu)");
        cur = db.rawQuery(tt, null);
        if (cur.getCount() == 0) {//Log.i("no","ffgrg");
            Toast.makeText(this, "invalid user", Toast.LENGTH_SHORT).show();
            //
        } else {
            while (cur.moveToNext()) {
                name = cur.getString(1);
               votes = cur.getString(2);
                age = cur.getString(3);
            }}
        s5.setText("TAMILNADU\n winning candidate is\nname : "+name+"\nage : "+age+"\nvotes : "+votes);

        }
    @Override
    public void onBackPressed() {


    }
}
