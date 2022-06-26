package com.example.study;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onBtn1Click(View view) {
        new AlertDialog.Builder(this)
                .setTitle("얼럿창 제목")
                .show();
    }

    public void onBtn2Click(View view) {
        new AlertDialog.Builder(this)
                .setTitle("얼럿창 제목")
                .setMessage("얼랏창 메시지")
                .show();
    }

    public void onBtn3Click(View view) {
        new AlertDialog.Builder(this)
                .setTitle("얼럿창 제목")
                .setMessage("얼랏창 메시지")
                .setPositiveButton("OK", null)
                .show();
    }

    public void onBtn4Click(View view) {
        new AlertDialog.Builder(this)
                .setTitle("얼럿창 제목")
                .setMessage("얼랏창 메시지")
                .setNegativeButton("Cancel", null)
                .show();
    }

    public void onBtn5Click(View view) {
        new AlertDialog.Builder(this)
                .setTitle("얼럿창 제목")
                .setMessage("얼랏창 메시지")
                .setPositiveButton("OK", null)
                .setNegativeButton("Cancel", null)
                .show();
    }
}
