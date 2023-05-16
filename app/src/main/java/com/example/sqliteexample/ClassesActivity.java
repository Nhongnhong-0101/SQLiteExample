package com.example.sqliteexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ClassesActivity extends AppCompatActivity {
    private ArrayList<InfOfClass> classes;
    ListView lvClass;
    ClassAdapter classAdapter;
    ClassDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classes);

        db = new ClassDB(ClassesActivity.this);
        classes.addAll(db.getClasses());
        lvClass = findViewById(R.id.lvClasses);
        classAdapter = new ClassAdapter(classes, this);
        lvClass.setAdapter(classAdapter);

        lvClass.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ClassesActivity.this, ClassDetailsActivity.class);
                InfOfClass i = classes.get(position);

                intent.putExtra("id", i.getId());
                intent.putExtra("name", i.getName());
                intent.putExtra("students", i.getStudents());
                startActivity(intent);
            }
        });

    }
}