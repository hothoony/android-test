package com.example.study;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        // MainActivity 에서 전달된 파라미터를 받는다
        Intent intent = getIntent();
        String value1 = intent.getExtras().getString("myParam1");

        // 전달받은 파라미터를 TextView 에 출력한다
        TextView textView = findViewById(R.id.text1);
        textView.setText(value1);

        // back 버튼 클릭시 data 를 담아서 MainActivity 로 전달
        Button backBtn = (Button) findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent();
                intent2.putExtra("resultData", textView.getText().toString());
                setResult(RESULT_OK, intent2);
                finish();
            }
        });
    }
}
