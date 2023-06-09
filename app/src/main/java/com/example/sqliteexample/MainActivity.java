package com.example.sqliteexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button btnLogin;
    private EditText tvUser;
    private EditText tvPass;

    String user, pass;

    ClassDB classDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = (Button) findViewById(R.id.btnLogin);
        tvUser = (EditText) findViewById(R.id.etUser);
        tvPass = (EditText) findViewById(R.id.etPass);
        //tao database class
        classDB = new ClassDB(MainActivity.this);
        classDB.addClass(new InfOfClass("Class1","Class1", 5));
        classDB.addClass(new InfOfClass("Class2","Class2", 4));
        classDB.addClass(new InfOfClass("Class3","Class3", 3));
        classDB.addClass(new InfOfClass("Class4","Class4", 2));

        classDB.addStudent(new Student("HSLop11", "Nguyen Van A1", R.drawable.baseline_account_circle_24, "01/01/2001", "Class1"));
        classDB.addStudent(new Student("HSLop12", "Nguyen Van A2", R.drawable.baseline_account_circle_24, "02/01/2001", "Class1"));
        classDB.addStudent(new Student("HSLop13", "Nguyen Van A3", R.drawable.baseline_account_circle_24, "03/01/2001", "Class1"));
        classDB.addStudent(new Student("HSLop14", "Nguyen Van A4", R.drawable.baseline_account_circle_24, "04/01/2001", "Class1"));
        classDB.addStudent(new Student("HSLop15", "Nguyen Van A5", R.drawable.baseline_account_circle_24, "05/01/2001", "Class1"));
        classDB.addStudent(new Student("HSLop26", "Nguyen Van A1", R.drawable.baseline_account_circle_24, "01/01/2002", "Class2"));
        classDB.addStudent(new Student("HSLop27", "Nguyen Van A2", R.drawable.baseline_account_circle_24, "02/01/2002", "Class2"));
        classDB.addStudent(new Student("HSLop28", "Nguyen Van A3", R.drawable.baseline_account_circle_24, "03/01/2002", "Class2"));
        classDB.addStudent(new Student("HSLop29", "Nguyen Van A4", R.drawable.baseline_account_circle_24, "04/01/2002", "Class2"));
        classDB.addStudent(new Student("HSLop31", "Nguyen Van A1", R.drawable.baseline_account_circle_24, "01/01/2003", "Class3"));
        classDB.addStudent(new Student("HSLop32", "Nguyen Van A2", R.drawable.baseline_account_circle_24, "02/01/2003", "Class3"));
        classDB.addStudent(new Student("HSLop33", "Nguyen Van A3", R.drawable.baseline_account_circle_24, "03/01/2003", "Class3"));
        classDB.addStudent(new Student("HSLop44", "Nguyen Van A1", R.drawable.baseline_account_circle_24, "01/01/2004", "Class4"));
        classDB.addStudent(new Student("HSLop45", "Nguyen Van A2", R.drawable.baseline_account_circle_24, "02/01/2004", "Class4"));


        //tao bang Class
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  intent = new Intent(MainActivity.this, ClassesActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}