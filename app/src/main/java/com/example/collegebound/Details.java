package com.example.collegebound;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Details extends AppCompatActivity {

    private TextView title;
    private TextView details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);



        title = findViewById(R.id.titleText);
        details = findViewById(R.id.detailsText);

        Bundle extra = getIntent().getExtras();
        if (extra != null) {
            String t = extra.getString("EXTRA_TITLE");
            String d = extra.getString("EXTRA_INFO");

            title.setText(t);
            details.setText(d);
        }


    }
}
