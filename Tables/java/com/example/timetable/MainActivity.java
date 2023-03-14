package com.example.timetable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView timesTableListView;
    public void generate(int timesTablesNum)
    {
        ArrayList<String> timesTableContent = new ArrayList<String>();
        for(int j=1;j<=10;j++)
        {
            timesTableContent.add(Integer.toString(j*timesTablesNum));
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,timesTableContent);
        timesTableListView.setAdapter(arrayAdapter);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar timesTableSeekBar = findViewById(R.id.timeTableSeekBar);
        timesTableListView = findViewById(R.id.timesTableListView);

        timesTableSeekBar.setMax(20);
        timesTableSeekBar.setProgress(10);

        timesTableSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int min = 1;
                int timesTableNum;

                if(i<min)
                {
                    timesTableSeekBar.setProgress(min);
                    timesTableNum = min;
                }

                else {
                    timesTableNum = i;
                }

                Log.i("Seek",Integer.toString(timesTableNum));

                generate(timesTableNum);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}