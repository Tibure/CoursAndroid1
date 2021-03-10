package com.example.bonneappli;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final int maxRandom = 10;
    private GuessNumber guessNumber;

    Button buttonGuess;
    EditText editTextGuessNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        guessNumber = new GuessNumber(maxRandom);
        buttonGuess = findViewById(R.id.buttonGuess);
        editTextGuessNumber = findViewById(R.id.editTextGuessNumber);
        setListener();
    }

    private void setListener() {
        buttonGuess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guess();
            }
        });
    }

    private void guess() {
        int numberToGuess = Integer.parseInt(editTextGuessNumber.getText().toString());
        GuessNumber.guessState guessState = guessNumber.testNumber(numberToGuess);
        if(guessState == GuessNumber.guessState.BIGGER) {
            showMessage("Votre nombre est trop grand!");
        } else if(guessState == GuessNumber.guessState.SMALLER) {
            showMessage("Votre nombre est trop petit!");
        } else{
            showMessage("Bravo");
            guessNumber.generateNewRandomNumber();
        }
    }

    private void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}