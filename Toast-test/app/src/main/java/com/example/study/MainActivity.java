package com.example.study;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onBtn1Click(View view) {
        Toast toast = Toast.makeText(
                getApplicationContext(),
                "버튼 클릭 Toast.LENGTH_SHORT",
                Toast.LENGTH_SHORT);
        toast.show();
    }

    public void onBtn2Click(View view) {
        Toast toast = Toast.makeText(
                getApplicationContext(),
                "버튼 클릭 Toast.LENGTH_LONG",
                Toast.LENGTH_LONG);
        toast.show();
    }
}
