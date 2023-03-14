package com.example.numberguess;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int randomNumber;

    public void generateRandom()
    {
        Random random = new Random();
        randomNumber = random.nextInt(20)+1;
    }

    public void guess(View view)
    {
        String msg;
        EditText editText = (EditText) findViewById(R.id.editTextNumber);
        int guessNumber = Integer.parseInt(editText.getText().toString());
        if(editText.getText().toString().isEmpty())
        {
            msg = "Enter the number first!";
        } else {
            if (guessNumber < randomNumber) {
                msg = "The number is lower!";
            } else if (guessNumber > randomNumber) {
                msg = "The number is Grater!";
            } else {
                msg = "Perfect!Try again";
                generateRandom();
            }
            Log.i("Editor", "Number Entered");
            Log.i("Info", "Button Pressed");
            Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}