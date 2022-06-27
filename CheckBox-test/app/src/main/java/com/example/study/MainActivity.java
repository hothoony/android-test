package com.example.study;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onChk1Click(View view) {
        CheckBox checkBox1 = (CheckBox) findViewById(R.id.chk1);
        Toast.makeText(getApplicationContext(),
                "빨강 checked: " + checkBox1.isChecked(),
                Toast.LENGTH_SHORT).show();
    }

    public void onChk2Click(View view) {
        CheckBox checkBox2 = (CheckBox) findViewById(R.id.chk2);
        Toast.makeText(getApplicationContext(),
                "녹색 checked: " + checkBox2.isChecked(),
                Toast.LENGTH_SHORT).show();
    }

    public void onChk3Click(View view) {
        CheckBox checkBox3 = (CheckBox) findViewById(R.id.chk3);
        Toast.makeText(getApplicationContext(),
                "파랑 checked: " + checkBox3.isChecked(),
                Toast.LENGTH_SHORT).show();
    }

    public void onBtn1Click(View view) {
        Log.i("", "onBtn1Click: ");

        CheckBox checkBox1 = (CheckBox) findViewById(R.id.chk1);
        CheckBox checkBox2 = (CheckBox) findViewById(R.id.chk2);
        CheckBox checkBox3 = (CheckBox) findViewById(R.id.chk3);

        String value = "";
        if (checkBox1.isChecked()) value += checkBox1.getText() + ", ";
        if (checkBox2.isChecked()) value += checkBox2.getText() + ", ";
        if (checkBox3.isChecked()) value += checkBox3.getText() + ", ";

        EditText editText1 = (EditText) findViewById(R.id.editText1);
        editText1.setText(value);
    }
}