package com.example.sqliteexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

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

        TextView tvId = findViewById(R.id.tvIdClass);
        TextView tvName = findViewById(R.id.tvNameClass);
        TextView tvStu = findViewById(R.id.tStudentsOfClass);



        Bundle bundle = getIntent().getExtras();
        String idClass = bundle.getString("id");

        tvId.setText("Id: " + bundle.getString("id"));
        tvName.setText("Name: " + bundle.getString("name"));
        tvStu.setText("Stdents: " + bundle.getString("students"));


        db = new ClassDB( ClassDetailsActivity.this);
        students = new ArrayList<Student>();
        lvStudents = findViewById(R.id.lvStudents);
        students.addAll(db.getStudents(idClass));

        studentAdapter = new StudentAdapter(this, students);
        lvStudents.setAdapter(studentAdapter);

    }
}