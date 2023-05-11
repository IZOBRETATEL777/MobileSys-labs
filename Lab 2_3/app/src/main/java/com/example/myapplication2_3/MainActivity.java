package com.example.myapplication2_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button startGameButton;
    private EditText nameInput;
    private TextView questionText;
    private Button answerTrueButton;
    private Button answerFalseButton;

    private String nickname;
    private int points = 0;
    private int currentQuestionIdx = 0;
    private List<Pair<String, Boolean>> questions = List.of(
            Pair.create("Capital of USA is New York", false),
            Pair.create("Creator of Linux is Linus Torvalds", true)
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startGameButton = findViewById(R.id.startGameButton);
        nameInput = findViewById(R.id.nameInput);
        questionText = findViewById(R.id.questionText);
        answerTrueButton = findViewById(R.id.answerTrue);
        answerFalseButton = findViewById(R.id.answerFlase);

        startGameButton.setOnClickListener(v -> startGame());

        answerTrueButton.setOnClickListener(v -> {
            changeQuestion(true);
        });
        answerFalseButton.setOnClickListener(v -> {
            changeQuestion(false);
        });
    }

    private void startGame() {
        nickname = nameInput.getText().toString();

        questionText.setVisibility(View.VISIBLE);
        answerTrueButton.setVisibility(View.VISIBLE);
        answerFalseButton.setVisibility(View.VISIBLE);
        startGameButton.setVisibility(View.INVISIBLE);
        nameInput.setVisibility(View.INVISIBLE);

        questionText.setText(questions.get(0).first);
    }

    private void changeQuestion(boolean answer) {
        if (answer == questions.get(currentQuestionIdx).second) {
            points++;
        }
        currentQuestionIdx++;
        if (currentQuestionIdx == questions.size()) {
            finishGame();
            return;
        }
        questionText.setText(questions.get(currentQuestionIdx).first);
    }

    private void finishGame() {
        answerFalseButton.setVisibility(View.INVISIBLE);
        answerTrueButton.setVisibility(View.INVISIBLE);
        questionText.setText("Hey, " + nickname + " you got " + points + " points!");
    }
}