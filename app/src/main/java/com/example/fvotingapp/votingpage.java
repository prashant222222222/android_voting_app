package com.example.fvotingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import android.content.Intent;
public class votingpage extends AppCompatActivity {
    mydb mdb;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_votingpage);
       final String s = MainActivity.state;
       final String ad=MainActivity.aadhar;
        Log.i("stat",ad );
       TextView st = (TextView) findViewById(R.id.state);
       st.setText("YOUR STATE IS "+s.toUpperCase()+"\nCHOOSE THE CANDIDATE YOU WANT TO VOTE\n");
      String tt=String.format("select name from %s ",s);
        mdb = new mydb(this);
        db = mdb.getReadableDatabase();
        Cursor cur=db.rawQuery(tt,null);

        final ArrayList<String> candidates=new ArrayList<String>();
        ListView lv=findViewById(R.id.lv);

        if (cur.getCount() == 0) {//Log.i("no","ffgrg");
            Toast.makeText(this, "invalid user", Toast.LENGTH_SHORT).show();
            //
        } else {

            while (cur.moveToNext()) {
                String gg = cur.getString(0);
                candidates.add(gg);
                Log.i("can",gg);

            }
            ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,candidates);
            Toast.makeText(this, "valid user", Toast.LENGTH_SHORT).show();
            lv.setAdapter(arrayAdapter);

            lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                    Toast.makeText(getApplicationContext(), "VOTED TO " + candidates.get(position), Toast.LENGTH_LONG).show();
                    String ff=candidates.get(position);

                    String tt1 = String.format("select votes from %s where name= '%s'", s,ff);
                    Log.i("sta", tt1);
                    Cursor cur2 = db.rawQuery(tt1, null);
                    if (cur2.getCount() == 0) {  //Log.i("no","ffgrg");
                        Log.i("votes", "unsucc");
                        //
                    } else {

                        while (cur2.moveToNext()) {
                            String gg1 = cur2.getString(0);
                            Log.i("votes", gg1);
                            int i = Integer.parseInt(gg1);
                            i = i + 1;

                            String tt = String.format("update %s set votes=%d where name='%s'", s, i, ff);
                            db.execSQL(tt);
                            String ttre = String.format("update voterlist set voted=%d where aadhar='%s'", 1, ad);
                            db.execSQL(ttre);
                            String ttx = String.format("select votes from %s where name= '%s'", s, ff);
                            Log.i("sta", ttx);
                            Cursor cur3 = db.rawQuery(ttx, null);
                            if (cur3.getCount() == 0) {  //Log.i("no","ffgrg");
                                Log.i("votes", "unsucc");
                                //
                            } else {
                                while (cur3.moveToNext()) {
                                    String gg2 = cur3.getString(0);
                                    Log.i("votes", gg2);
                                }
                                Intent intent=new Intent(votingpage.this,result.class);
                                startActivity(intent);
                            }
                        }
                    }
                }

            });

        }
    }
}

