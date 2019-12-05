package com.example.collegebound;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {


    private ListView lv;
    private ArrayList<Ivy> ivyList;
    private ArrayList<String> titleList;
    private Adapter adapter;
    private int[] images = {R.drawable.cornell,
            R.drawable.dartmouth,
            R.drawable.harvard,
            R.drawable.columbia,
            R.drawable.penn,
            R.drawable.yale,
            R.drawable.brown,
            R.drawable.princeton
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        lv = findViewById(R.id.lv);

        ivyList = Data.loadIvy(this);
        titleList = new ArrayList<>();
        for (int i = 0; i < ivyList.size(); i++) {
            String str = ivyList.get(i).getTitle();
            titleList.add(str);
        }

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, titleList);
        lv.setAdapter((ListAdapter) adapter);

        lv.setOnItemClickListener(this);
        /*ListView collegeLV = (ListView) findViewById(R.id.lv);
        CustomAdapter customAdapter = new CustomAdapter();
        collegeLV.setAdapter(customAdapter); */
    }
        //lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, Details.class);
        String title = ivyList.get(position).getTitle();
        String details = ivyList.get(position).getInfo();

        intent.putExtra("EXTRA_TITLE", title);
        intent.putExtra("EXTRA_INFO", details);

        startActivity(intent);
    }


   /* class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return null;
        }

    } */

    public View getView(int position) {
        View view = getLayoutInflater().inflate(R.layout.activity_second, null);
        ImageView imgView = (ImageView) view.findViewById(R.id.collegePic);
        imgView.setImageResource(images[position]);
        return view;
    }

}
