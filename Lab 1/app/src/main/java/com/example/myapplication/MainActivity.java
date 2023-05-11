package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button);
        RatingBar ratingBar = findViewById(R.id.ratingBar);
        TextView textView = findViewById(R.id.textView);

        button.setOnClickListener(view -> {
            ratingBar.setRating(4.5f);
        });

        ratingBar.setOnRatingBarChangeListener((view, rating, fromUser) -> {
            textView.setText(String.valueOf(rating));
        });
    }
}