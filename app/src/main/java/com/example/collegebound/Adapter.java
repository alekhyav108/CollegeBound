package com.example.collegebound;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;


import java.util.ArrayList;


public class Adapter extends ArrayAdapter<String> {

    private Button login;
    public Adapter (Context context, ArrayList<String> records) {
        super(context, 0, records);
    }

    public View getView (int position, View convertView, ViewGroup parent) {
        String item = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_list_view, parent);

        }
        TextView list_Txt = (TextView)convertView.findViewById(R.id.texts);



        list_Txt.setText(item);
        return convertView;

    }


}
