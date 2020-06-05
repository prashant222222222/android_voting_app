package com.example.fvotingapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class mydb extends SQLiteOpenHelper {
public static final String voterlist="voterlist";
private static final String states="states";
private static final String candidates="candidates";
private static final String delhi="delhi";
private static final String maharastra="maharastra";
private static final String uttarpradesh="uttarpradesh";
private static final String bihar="bihar";
private static final String tamilnadu="tamilnadu";

    public mydb(Context context)

    {
       super(context, "voting.db",null, 9);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
       String voterlist1= "create table "+voterlist+" (name varchar(20),aadhar varchar(12),day number(2),mobile number(10),state varchar(20),voted int(1))";
        db.execSQL(voterlist1);
        //db.execSQL("drop table voterlist");
       // db.execSQL("create table voterlist(name varchar(20),aadhar varchar(12),day number(2),mobile number(10),state varchar(20));");
        db.execSQL("insert into voterlist values('prashant','123456789012',28,9672410241,'delhi',0);");
     db.execSQL("insert into voterlist values('rahul','123456789013',28,9672410241,'maharastra',0);");
     db.execSQL("insert into voterlist values('prashant','123456789014',28,9672410241,'delhi',0);");
        //db.execSQL("insert into voterlist values('a','a',1,1,'a');");
        String candidates1="create table "+ candidates+" (id number(2),name varchar(50), votes number(4),age number(3))";
        //db.execSQL("create table candidates(id number(2),name varchar(50), votes number(4),age number(3));");
        //db.execSQL(
        db.execSQL(candidates1);
        String states1="create table "+ states+" (name varchar(50))";
        db.execSQL(states1);
        db.execSQL("insert into states values('delhi');");
        db.execSQL("insert into states values('maharastra');");
        db.execSQL("insert into states values('bihar');");
        db.execSQL("insert into states values('tamilnadu');");
        db.execSQL("insert into states values('uttarpradesh');");
        db.execSQL("insert into candidates values (1,'modi',0,65);");
        db.execSQL("insert into candidates values (2,'kejriwal',0,42);");

        String delhi1= "create table "+delhi+" (id number(2),name varchar(50), votes number(4),age number(3))";
        db.execSQL(delhi1);
        String maharastra1= "create table "+maharastra+" (id number(2),name varchar(50), votes number(4),age number(3))";
        db.execSQL(maharastra1);
        String tamilnadu1= "create table "+tamilnadu+" (id number(2),name varchar(50), votes number(4),age number(3))";
        db.execSQL(tamilnadu1);
        String uttarpradesh1= "create table "+uttarpradesh+" (id number(2),name varchar(50), votes number(4),age number(3))";
        db.execSQL(uttarpradesh1);
        String bihar1= "create table "+bihar+" (id number(2),name varchar(50), votes number(4),age number(3))";
        db.execSQL(bihar1);

        db.execSQL("insert into delhi values(1,'modi',0,67);");
        db.execSQL("insert into delhi values(2,'arvind',0,43);");
        db.execSQL("insert into delhi values(3,'nishant',0,47);");
        db.execSQL("insert into delhi values(4,'gaanesh',0,37);");

        db.execSQL("insert into maharastra values(1,'thakrey',0,54);");
        db.execSQL("insert into maharastra values(2,'govinda',0,51);");
        db.execSQL("insert into maharastra values(3,'rekha',0,66);");
        db.execSQL("insert into maharastra values(4,'amitabh',0,71);");

        db.execSQL("insert into uttarpradesh values(1,'gandhi',0,62);");
        db.execSQL("insert into uttarpradesh values(2,'akhilesh',0,45);");
        db.execSQL("insert into uttarpradesh values(3,'mayabati',0,48);");
        db.execSQL("insert into uttarpradesh values(4,'amit',0,55);");

        db.execSQL("insert into tamilnadu values(1,'ashmit',0,43);");
        db.execSQL("insert into tamilnadu values(2,'rohit',0,39);");
        db.execSQL("insert into tamilnadu values(3,'dinesh',0,61);");
        db.execSQL("insert into tamilnadu values(4,'rahul',0,54);");

        db.execSQL("insert into bihar values(1,'lalu',0,60);");
        db.execSQL("insert into bihar values(2,'nitish',0,64);");
        db.execSQL("insert into bihar values(3,'ghanshyam',0,54);");
        db.execSQL("insert into bihar values(4,'ritesh',0,48);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
       db.execSQL("drop table if exists "+voterlist);
        db.execSQL("drop table if exists "+candidates);
        db.execSQL("drop table if exists "+states);
        db.execSQL("drop table if exists "+delhi);
        db.execSQL("drop table if exists "+maharastra);
        db.execSQL("drop table if exists "+uttarpradesh);
        db.execSQL("drop table if exists "+bihar);
        db.execSQL("drop table if exists "+tamilnadu);


        onCreate(db);

    }
}
