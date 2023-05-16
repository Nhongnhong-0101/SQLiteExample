package com.example.sqliteexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ClassDetailsActivity extends AppCompatActivity {


    private ArrayList<Student> students;
    ListView lvStudents;
    StudentAdapter studentAdapter;
    ClassDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_details);

        Bundle bundle = getIntent().getExtras();
        String idClass = bundle.getString("id");

        db = new ClassDB( ClassDetailsActivity.this);
        lvStudents = findViewById(R.id.lvStudents);
        students.addAll(db.getStudents(idClass));

        studentAdapter = new StudentAdapter(this, students);
        lvStudents.setAdapter(studentAdapter);

    }
}