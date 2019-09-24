package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Integer counter = 0;
    TextView counterView;
    Integer counter2 = 0;
    TextView counterView2;

    Button btn;
    final String TAG = "StartActivity";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate");
        counterView = findViewById(R.id.txt_counter);
        counterView2 = findViewById(R.id.txt_counter2);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("counter", counter);
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("counter2", counter2);
    }

    @Override
    public void onRestoreInstanceState(Bundle saveInstanceState) {
        super.onRestoreInstanceState(saveInstanceState);
        if (saveInstanceState != null && saveInstanceState.containsKey("counter")) {
            counter = saveInstanceState.getInt("counter", counter);
            counterView.setText(String.valueOf(counter));
        }
        super.onRestoreInstanceState(saveInstanceState);
        if (saveInstanceState != null && saveInstanceState.containsKey("counter2")) {
            counter = saveInstanceState.getInt("counter2", counter2);
            counterView.setText(String.valueOf(counter2));
        }
    }

    public void onClickBtnGoalTeamOne(View view) {
        counter++;
        counterView.setText(String.valueOf(counter));
    }

    public void onClickBtnGoalTeamTwo(View view) {
        counter2++;
        counterView2.setText(String.valueOf(counter2));
    }

    public void onClickBtnResetScope(View view) {
        counter = 0;
        counterView.setText(String.valueOf(counter));
        counter2 = 0;
        counterView2.setText(String.valueOf(counter2));
    }
}