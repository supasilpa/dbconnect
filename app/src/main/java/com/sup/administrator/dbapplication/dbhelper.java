package com.sup.administrator.dbapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 1/29/2019.
 */
public class dbhelper extends SQLiteOpenHelper {
    public static final  String dbname="mydb.db";
    public static final String tablename="student";
    public static final String col1="id";
    public static final  String col2="name";
    public static final String col3="emailid";
    public dbhelper(Context context) {
        super(context, dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
   String query="create table "+tablename+"("+col1+ " integer primary key autoincrement, "+col2+" text, "+col3+ " text)";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String query="drop table if exists "+tablename;
        sqLiteDatabase.execSQL(query);
        onCreate(sqLiteDatabase);

    }
    public boolean insertdata(String name,String emailid)
    {
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(col2,name);
        contentValues.put(col3,emailid);
       Long status= sqLiteDatabase.insert(tablename,null,contentValues);
        if (status==-1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
}
