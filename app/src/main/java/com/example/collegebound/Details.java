package com.example.collegebound;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.DataOutputStream;
import java.io.IOException;

public class Details extends AppCompatActivity {

    private TextView details;
    private ImageView image;
    private Vibrator vib;
    private CheckBox check1, check2, check3;
    private Button chckBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        details = findViewById(R.id.detailsText);
        image = findViewById(R.id.imageView3);

        vib = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        Intent intent = getIntent();

        image.setImageResource(intent.getIntExtra("image", 0));

        Bundle extra = getIntent().getExtras();
        if (extra != null) {
            String t = extra.getString("EXTRA_TITLE");
            String d = extra.getString("EXTRA_INFO");

            details.setText(d);
        }

        chckBtn = findViewById(R.id.button2);

        chckBtn.setOnClickListener(unused -> phoneVib(1));
    }

    /*public void addListener() {
        check1 = findViewById(R.id.chckB1);
        check2 = findViewById(R.id.chckB2);
        check3 = findViewById(R.id.chckB3);
        chckBtn = findViewById(R.id.button2);

        boolean checked = PreferenceManager.getDefaultSharedPreferences(this)
                .getBoolean("checkBox1", false);
        check1.setChecked(checked);
        check2.setChecked(checked);
        check3.setChecked(checked);


        chckBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phoneVib(0);
            }
        });
    }*/

    private void phoneVib(int intensity) {

        if (intensity == 0) {
            VibrationEffect effect = VibrationEffect.createWaveform(new long[]{0, 400, 400}, new int[]{0, 255, 0}, -1);
            vib.vibrate(effect);
        } else if (intensity == 1) {
            VibrationEffect effect = VibrationEffect.createWaveform(new long[]{0, 400, 400, 400, 400, 400, 400}, new int[]{0, 255, 0, 255, 0, 255, 0}, -1);
            vib.vibrate(effect);
        }
    }


}
