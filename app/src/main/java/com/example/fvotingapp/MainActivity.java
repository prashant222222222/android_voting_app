package com.example.fvotingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import static android.util.Log.i;

public class MainActivity extends AppCompatActivity {
EditText e1,e2,e3,e4;
public  static String state;
public static String aadhar;
mydb mdb;
SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=findViewById(R.id.name);
        e2= findViewById(R.id.aadhar);
        e3=findViewById(R.id.birth);
        e4=findViewById(R.id.mobile);


    }
    public void submit(View view)
    {
        mdb=new mydb(this);
        db=mdb.getReadableDatabase();
        Cursor cur=db.rawQuery("select * from voterlist where name=?  and aadhar=? and day=? and mobile=?",new String[]{e1.getText().toString(),e2.getText().toString(),e3.getText().toString(),e4.getText().toString()});
        if(cur.getCount()==0)
        {//Log.i("no","ffgrg");
            Toast.makeText(this,"invalid user",Toast.LENGTH_SHORT).show();
            //
             }
        else
        {
           state=new String("");
           // Log.i("yes","ffgrg");
            // Toast.makeText(this,"valid user",Toast.LENGTH_SHORT).show();
           Intent i=new Intent(this,choose.class);
           while (cur.moveToNext()) {
               state = cur.getString(4);
               aadhar=cur.getString(1);
           }
          //Log.i("state",cur.getString(4));
                   //"state"+cur.getString(0)).show();

           // i.putExtra("state", state);
           startActivity(i);
            
        }
    }

}
