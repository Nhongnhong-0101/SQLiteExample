package com.example.sqliteexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class ClassAdapter extends BaseAdapter {
    Context context;
    ArrayList<InfOfClass> classes;
    ClassAdapter(ArrayList<InfOfClass> classes, Context context){
        this.context = context;
        this.classes = classes;
    }
    @Override
    public int getCount() {
        return classes.size();
    }

    @Override
    public Object getItem(int position) {
        return classes.get(position);
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
            v = LayoutInflater.from(context).inflate(R.layout.class_adapter, viewGroup, false);

            //anh xâ dư lieu
            InfOfClass infOfClass = classes.get(i);
            TextView tvName = v.findViewById(R.id.tvName);
            TextView tvID = v.findViewById(R.id.tvId);
            TextView tvStu = v.findViewById(R.id.tvStudents);

            tvName.setText(infOfClass.getName());
            tvID.setText(infOfClass.getId());
            tvStu.setText(infOfClass.getStudents());

        }
        return v;
    }
}
