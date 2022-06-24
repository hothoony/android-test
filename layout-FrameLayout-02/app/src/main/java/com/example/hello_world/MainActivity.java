package com.example.hello_world;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void onButton1Click(View view) {
        Log.i(TAG, "onButton1Click: button 1 click");
        View view1 = findViewById(R.id.view1);
        view1.bringToFront();
//        view1.invalidate();
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void onButton2Click(View view) {
        Log.i(TAG, "onButton2Click: button 2 click");
        View view2 = findViewById(R.id.view2);
        view2.bringToFront();
//        view2.invalidate();
    }
}
