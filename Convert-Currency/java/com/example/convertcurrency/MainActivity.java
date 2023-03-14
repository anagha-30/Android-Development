package com.example.convertcurrency;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void convertCurrency(View view)
    {
        Log.i("Info","Button Pressed" );
        EditText editText= (EditText) findViewById(R.id.editTextNumberDecimal);
        String amt_in_Rs = editText.getText().toString();
        double amt_in_Rs_double = Double.parseDouble(amt_in_Rs);
        double amt_in_Dollars_double = amt_in_Rs_double*0.012;
        String amt_in_Dollars = String.format("%.2f",amt_in_Dollars_double);
        Log.i("Amount in Dollars", amt_in_Dollars);
        Toast.makeText(this,"$"+amt_in_Dollars,Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}