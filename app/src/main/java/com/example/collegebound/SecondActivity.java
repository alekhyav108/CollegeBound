package com.example.collegebound;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.os.Vibrator;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {


    private ListView lv;
    private ArrayList<Ivy> ivyList;
    private ArrayList<String> titleList;
    private Adapter adapter;
    private Vibrator vib;
    //private int[] progress;
    //private ProgressBar progressBar = findViewById(R.id.progressBar);
    private int[] images = {R.drawable.harvard,
            R.drawable.brown,
            R.drawable.yale,
            R.drawable.dart,
            R.drawable.penn,
            R.drawable.princeton,
            R.drawable.cornell,
            R.drawable.columbia,
            R.drawable.uiuc
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

    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, Details.class);
        String title = ivyList.get(position).getTitle();
        String details = ivyList.get(position).getInfo();


        intent.putExtra("EXTRA_TITLE", title);
        intent.putExtra("EXTRA_INFO", details);
        intent.putExtra("image", images[position]);

        startActivity(intent);
    }


    private abstract class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return images.length;
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
        public View getView(int i, View view, ViewGroup viewGroup) {
            View view1 = getLayoutInflater().inflate(R.layout.activity_details, null);
            ImageView image = view1.findViewById(R.id.imageView3);

            image.setImageResource(images[i]);
            //if (checkbox is checked, then increase progress bar)
           /* progressBar.setProgress(progress[i]);

            View row = view;
            ListView holder = null;

            //this should be the checkbox part
            final DownloadInfo info = getItem(i);

            if(null == row) {
                LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                row = inflater.inflate(R.layout.activity_second, viewGroup, false);

                holder = new RecyclerView.ViewHolder();
                holder.progressBar = (ProgressBar) row.findViewById(R.id.progressBar);
                holder.info = info;

                row.setTag(holder);
            } else {
                holder = row.getTag();

                holder.info.setProgressBar(null);
                holder.info = info;
                holder.info.setProgressBar(holder.progressBar);
            }*/


            return view1;
        }
    }


    private void phoneVib(int intensity) {
        vib = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        int actualIntensity = 0;

        switch(intensity) {
            case 1: actualIntensity = 25;
            case 2: actualIntensity = 50;
            case 3: actualIntensity = 75;
            case 4: actualIntensity = 100;
            case 5: actualIntensity = 125;
            case 6: actualIntensity = 150;
            case 7: actualIntensity = 175;
            case 8: actualIntensity = 200;
            case 9: actualIntensity = 225;
            case 10: actualIntensity = 255;
            default: actualIntensity = 255;

        }
        long[] pattern = new long[]{0, 100, 1000, 300, 200, 100, 500, 200, 100, 400};
        int[] amp = new int[]{0, actualIntensity, 0, actualIntensity, 0, actualIntensity, 0, actualIntensity};

        if (vib.hasAmplitudeControl()) {
            VibrationEffect effect = VibrationEffect.createWaveform(pattern, amp, -1);
            vib.vibrate(effect);
        }
    }





}
