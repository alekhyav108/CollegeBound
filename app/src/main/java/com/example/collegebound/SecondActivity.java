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
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.os.Vibrator;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

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

    //not sure if this should be done in details class
    private CheckBox check1, check2, check3;
    private Button chckBtn;

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

    private String[] names = {"Harvard", "Brown","Yale","Darthmouth","Penn","Princeton","Cornell","Columbia","UIUC"};

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
        //addListener();


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
            View view2 = getLayoutInflater().inflate(R.layout.activity_second, null);
            ImageView image = view1.findViewById(R.id.imageView3);
            TextView text = view2.findViewById(R.id.texts);

            image.setImageResource(images[i]);
            text.setText(names[i]);
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
                progressBar = (ProgressBar) row.findViewById(R.id.progressBar);
                holder.info = info;

                row.setTag(holder);
            } else {
                holder = row.getTag();

                holder.info.setProgressBar(null);
                holder.info = info;
                holder.info.setProgressBar(progressBar);
            }*/


            return view1;
        }
    }

    /*public void addListener() {
        check1 = findViewById(R.id.chckB1);
        check2 = findViewById(R.id.chckB2);
        check3 = findViewById(R.id.chckB3);
        chckBtn = findViewById(R.id.checkBtn);

        chckBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //do stuff w progress bar
                        StringBuffer result = new StringBuffer();
                        result.append("hello").append(check1.isChecked() == true);
                        result.append("hi").append(check2.isChecked() == true);
                        result.append("lol").append(check3.isChecked() == true);

                        Toast.makeText(SecondActivity.this, result.toString(), Toast.LENGTH_LONG).show();
                    }
                }
        );
    }*/

    /*private void setProgressValue(final int progress) {

        // set the progress
        progressBar.setProgress(progress);
        // thread is used to change the progress value
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                setProgressValue(progress + 10);
            }
        });
        thread.start();
    }*/


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
