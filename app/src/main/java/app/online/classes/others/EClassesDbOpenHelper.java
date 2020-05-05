package app.online.classes.others;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by lenovo on 8/4/2017.
 */
public class EClassesDbOpenHelper extends SQLiteOpenHelper
{
    private static String dataBaseName="schooldb";
    private static String tableName="student";
    private static int version=1;

    public EClassesDbOpenHelper(Context context)
    {
        super(context, dataBaseName, null, version);
        Log.e("Db created","Data Base Created Successfully");
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("CREATE TABLE IF NOT EXISTS student(student_id TEXT,student_name TEXT,dob TEXT,class_id TEXT,present_address TEXT,mobile TEXT,student_photo TEXT)");

//        db.execSQL("CREATE TABLE IF NOT EXISTS urlset(baseurl TEXT,pictureurl TEXT,apiurl TEXT,activityurl TEXT,addonurl TEXT)");
//
//        db.execSQL("CREATE TABLE IF NOT EXISTS notice(id integer PRIMARY KEY AUTOINCREMENT,information varchar(400),date varchar(30),title carchar(30))");
//        Log.d("store table","store Table created Successfully");
//
//
//        db.execSQL("CREATE TABLE IF NOT EXISTS attendance(id integer PRIMARY KEY AUTOINCREMENT,attendance varchar(10),date varchar(30),month varchar(30),year varchar(30))");
//        Log.d("attendance table","Attendance Table created Successfully");
//
//
//        db.execSQL("CREATE TABLE IF NOT EXISTS homework(id integer PRIMARY KEY AUTOINCREMENT,subject varchar(50),homework varchar(300),homework_hindi varchar(300),date varchar(20),file varchar(50))");
//        Log.d("homework table","home work Table created Successfully");

        Log.e("Student Table created", "client_case_mapp Table Created Successfully8989");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        //db.execSQL("DROP TABLE IF EXISTS" + tableName);
    }
    //CREATE TABLE IF NOT EXISTS student(student_id TEXT,student_name TEXT,dob TEXT,class_id TEXT,present_address TEXT,mobile TEXT,student_photo TEXT)
    public void deleteRecord(SQLiteDatabase db)
    {
        db.execSQL("delete from " + tableName);
    }

    public void addStudent(String student_id, String student_name, String dob, String class_id, String section_id, String present_address, String father_mobile, String student_photo, SQLiteDatabase db)
    {
        Log.e("aaa", "addEntry");
        ContentValues contentValues=new ContentValues();
        db.insert("mobile", null, contentValues);
        //db.insert("client",null,contentValues);
        Log.e("Student Record Inserted", "Record Inserted Successfully");
    }


    public void addUrl(String baseurl, String pictureurl, String apiurl, String activityurl, String addonurl, SQLiteDatabase db)
    {
        Log.e("aaa", "addUrl");
        ContentValues contentValues=new ContentValues();
        contentValues.put("baseurl",baseurl);
        contentValues.put("pictureurl",pictureurl);
        contentValues.put("apiurl",apiurl);
        contentValues.put("activityurl",activityurl);
        contentValues.put("addonurl",addonurl);
        db.insert("urlset", null, contentValues);
        //db.insert("client",null,contentValues);
        Log.e("urlset", "urlset Added Successfully");
    }

    public void addNotice(String info, String date, String title, SQLiteDatabase db)
    {
        Log.e("aaa", "addNotice");
        ContentValues contentValues=new ContentValues();
        contentValues.put("information",info);
        contentValues.put("date",date);
        contentValues.put("title",title);
        db.insert("notice", null, contentValues);
        //db.insert("client",null,contentValues);
        Log.e("Notice Add", "Notice Added Successfully");
    }

    public Cursor getNotice(SQLiteDatabase db)
    {
        Cursor cursor=db.rawQuery("select * from notice",null);
        return cursor;
    }

    public void deleteNotice(SQLiteDatabase db)
    {
        db.delete("notice","",null);
        Log.e("notice Deleted","Notice attendance");
    }

    public void addAttendance(String attendance, String date, String month, String year, SQLiteDatabase db)
    {
        Log.e("aaa", "addNotice");
        ContentValues contentValues=new ContentValues();
        contentValues.put("attendance",attendance);
        contentValues.put("date",date);
        contentValues.put("month",month);
        contentValues.put("year",year);
        db.insert("attendance", null, contentValues);
        //db.insert("client",null,contentValues);
        Log.e("Attendance Add", "Attendance Added Successfully");
    }

    public Cursor getAttendance(SQLiteDatabase db)
    {
        Cursor cursor=db.rawQuery("select * from attendance",null);
        return cursor;
    }

    public Cursor getMonthAttendance(String month, SQLiteDatabase db)
    {
        Cursor cursor=db.rawQuery("select * from attendance where month='"+month+"'",null);
        return cursor;
    }

    public void deleteAttendance(SQLiteDatabase db)
    {
        db.delete("attendance","",null);
        Log.e("attendance Deleted","Notice attendance");
    }

    public void addHomework(String subject, String homework, String homework_hindi, String date, String file, SQLiteDatabase db)
    {
        Log.e("aaa", "addHomework");
        ContentValues contentValues=new ContentValues();
        contentValues.put("subject",subject);
        contentValues.put("homework",homework);
        contentValues.put("homework_hindi",homework_hindi);
        contentValues.put("date",date);
        contentValues.put("file",file);
        db.insert("homework", null, contentValues);
        //db.insert("client",null,contentValues);
        Log.e("Notice Add", "Homework Added Successfully");
    }

    public Cursor getHomework(SQLiteDatabase db)
    {
        Cursor cursor=db.rawQuery("select * from homework",null);
        return cursor;
    }

    public void deleteHomework(SQLiteDatabase db)
    {
        //db.rawQuery("delete from homework",null);
        db.delete("homework","",null);
        Log.e("Home Work Deleted","Notice Deleted");
    }


    public void deleteUser(SQLiteDatabase db)
    {
        //db.rawQuery("delete from homework",null);
        db.delete("student","",null);
        Log.e("Login Deleted","Login Deleted");
    }

    public void updateStudent(String classId, String studentId, SQLiteDatabase db)
    {
        ContentValues cont=new ContentValues();
        cont.put("class_id",classId);
        db.update(tableName, cont, "student_id=" + studentId, null);
        Log.e("data updated", "Student update");
    }


    public Cursor getEntry(SQLiteDatabase db)
    {
        Cursor cursor=db.rawQuery("select * from "+tableName,null);
        return cursor;
    }
}
