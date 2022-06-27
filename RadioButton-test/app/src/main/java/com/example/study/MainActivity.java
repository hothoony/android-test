package com.example.study;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onRadio1Click(View view) {
        RadioButton radioButton1 = (RadioButton) findViewById(R.id.radioButton1);
        if (!radioButton1.isChecked()) return;
        Toast.makeText(getApplicationContext(),
                        radioButton1.getText() + " checked",
                        Toast.LENGTH_SHORT)
                .show();
    }

    public void onRadio2Click(View view) {
        RadioButton radioButton2 = (RadioButton) findViewById(R.id.radioButton2);
        if (!radioButton2.isChecked()) return;
        Toast.makeText(getApplicationContext(),
                        radioButton2.getText() + " checked",
                        Toast.LENGTH_SHORT)
                .show();
    }

    public void onRadio3Click(View view) {
        RadioButton radioButton3 = (RadioButton) findViewById(R.id.radioButton3);
        if (!radioButton3.isChecked()) return;
        Toast.makeText(getApplicationContext(),
                        radioButton3.getText() + " checked",
                        Toast.LENGTH_SHORT)
                .show();
    }

    public void onRadio4Click(View view) {
        RadioButton radioButton4 = (RadioButton) findViewById(R.id.radioButton4);
        if (!radioButton4.isChecked()) return;
        Toast.makeText(getApplicationContext(),
                        radioButton4.getText() + " checked",
                        Toast.LENGTH_SHORT)
                .show();
    }

    public void onBtn1Click(View view) {
        RadioButton radioButton1 = (RadioButton) findViewById(R.id.radioButton1);
        RadioButton radioButton2 = (RadioButton) findViewById(R.id.radioButton2);
        RadioButton radioButton3 = (RadioButton) findViewById(R.id.radioButton3);
        RadioButton radioButton4 = (RadioButton) findViewById(R.id.radioButton4);

        String message = "";
        if (radioButton1.isChecked()) message += radioButton1.getText() + ", ";
        if (radioButton2.isChecked()) message += radioButton2.getText() + ", ";
        if (radioButton3.isChecked()) message += radioButton3.getText() + ", ";
        if (radioButton4.isChecked()) message += radioButton4.getText() + ", ";

        EditText editText1 = (EditText) findViewById(R.id.editText1);
        editText1.setText(message);
    }

}
