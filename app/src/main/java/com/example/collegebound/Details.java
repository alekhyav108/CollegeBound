package com.example.collegebound;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Details extends AppCompatActivity {

    private TextView details;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);



        details = findViewById(R.id.detailsText);
        image = findViewById(R.id.imageView3);

        Intent intent = getIntent();

        image.setImageResource(intent.getIntExtra("image", 0));

        Bundle extra = getIntent().getExtras();
        if (extra != null) {
            String t = extra.getString("EXTRA_TITLE");
            String d = extra.getString("EXTRA_INFO");

            details.setText(d);
        }


    }
}
