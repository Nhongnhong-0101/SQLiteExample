package com.example.sqliteexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class StudentAdapter extends BaseAdapter {
    Context context;
    private ArrayList<Student> students;
    public StudentAdapter( Context context, ArrayList<Student> item) {
        this.context = context;
        this.students = item;
    }

    @Override
    public int getCount() {
        return students.size();
    }

    @Override
    public Object getItem(int position) {
        return students.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = view;
        if (v == null)
        {
            v = LayoutInflater.from(context).inflate(R.layout.student_details, viewGroup, false);

            //anh xâ dư lieu
            Student student = students.get(i);
            TextView tvName = v.findViewById(R.id.tvName);
            TextView tvDateOfBirth = v.findViewById(R.id.tvDOB);
            TextView tvClassID = v.findViewById(R.id.tvId);
            ImageView imageView = v.findViewById(R.id.image);


            tvName.setText(student.getName());
            tvDateOfBirth.setText(student.getDob());
            tvClassID.setText(student.getClassID());
            imageView.setImageResource(student.getImage());

        }
        return v;
    }
}
