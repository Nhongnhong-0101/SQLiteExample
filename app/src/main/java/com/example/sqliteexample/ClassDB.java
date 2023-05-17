package com.example.sqliteexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class ClassDB extends SQLiteOpenHelper {

    public static  String TABLE_CLASS = "class";
    public static  String COLUMN_ID = "_id";
    public static String COLUMN_NAME = "name";
    public static String COLUMN_STUDENTS = "students";
    public static String DATABASE_NAME ="Class.db";
    public static  int DATABASE_VERSION = 1;


    public ClassDB(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table CLASS (id text primary key, name text, students int)");
        db.execSQL("create table STUDENT(id text primary key, name text, image int, dob text, classID text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists CLASS");
        db.execSQL("drop table if exists STUDENT");

    }

    public void addClass (InfOfClass _class){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id" , _class.getId());
        contentValues.put("name", _class.getName());
        contentValues.put("students", _class.getStudents());

        db.insert("CLASS", null, contentValues);
        db.close();
    }
    public void addStudent (Student s){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", s.getId());
        contentValues.put("name", s.getName());
        contentValues.put("dob", s.getDob());
        contentValues.put("image", s.getImage());
        contentValues.put("class", s.getClassID());
        db.insert("STUDENT", null, contentValues);
        db.close();
    }

    public ArrayList<InfOfClass> getClasses() {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<InfOfClass> classes = new ArrayList<>();
        String sql = "select * from CLASS";
        Cursor cursor = db.rawQuery(sql, null);
        if  (cursor!= null){
            //lay tren xyong den het
            cursor.moveToFirst();
            while (cursor.isAfterLast() == false){
                classes.add(new InfOfClass(cursor.getString(0), cursor.getString(1), cursor.getInt(2)));
                cursor.moveToNext();
            }
        }
        return classes;
    }

    public ArrayList<Student> getStudents(String idClass) {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<Student> students = new ArrayList<>();
        String sql = "select * from STUDENT where class = ?";
        String []kqua = {idClass};
        Cursor cursor = db.rawQuery(sql, kqua);
//        if  (cursor!= null){
//            //lay tren xyong den het
//            cursor.moveToFirst();
//            while (cursor.isAfterLast() == false){
//                students.add(new Student(cursor.getString(0), cursor.getString(1), cursor.getInt(2), cursor.getString(3), cursor.getString(4)));
//                cursor.moveToNext();
//            }
//        }
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    students.add(new Student(cursor.getString(0), cursor.getString(1), cursor.getInt(2), cursor.getString(3), cursor.getString(4)));
                } while (cursor.moveToNext());
            }
        }
        return students;
    }
}
