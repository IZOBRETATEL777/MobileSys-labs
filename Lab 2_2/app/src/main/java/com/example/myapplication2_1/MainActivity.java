package com.example.myapplication2_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RatingBar;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private Button button;
    private RatingBar ratingBar;
    private boolean isCat = true;
    private float catRating = 0;
    private float dogRating = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.evalutateButton);
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        imageView = findViewById(R.id.imageView);
        ratingBar = findViewById(R.id.ratingBar);
        ratingBar.setOnRatingBarChangeListener((v, rating, user) -> updateRating(rating));
        button.setOnClickListener(v -> evaluateImage());
        radioGroup.setOnCheckedChangeListener( (v, u) -> toggleImage());
    }

    private void toggleImage() {

        updateRating(ratingBar.getRating());

        if (isCat) {
            imageView.setImageResource(R.drawable.dog);
            isCat = !isCat;
            ratingBar.setRating(dogRating);
        }
        else {
            imageView.setImageResource(R.drawable.cat);
            isCat = !isCat;
            ratingBar.setRating(catRating);
        }

    }

    private void updateRating(float newRating) {
        if (isCat) {
            catRating = newRating;
        }
        else {
            dogRating = newRating;
        }
    }

    private void evaluateImage() {
        String text;
        if (catRating > dogRating) {
            text = "Cats win";
        } else if (catRating < dogRating) {
            text = "Dogs win";
        }
        else {
            text = "draw";
        }
        Snackbar.make(button, text, Snackbar.LENGTH_LONG).show();
    }
}