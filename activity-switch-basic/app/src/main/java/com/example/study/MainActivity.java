package com.example.study;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // SubActivity 에서 넘어 온 결과를 받는다
    ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Log.i("", "onActivityResult: OK");
                        Intent intent = result.getData();
                        String resultData = intent.getExtras().getString("resultData");
                        Log.i("", "resultData: " + resultData);

                        new AlertDialog.Builder(MainActivity.this)
                                .setTitle("얼럿 테스트")
                                .setMessage("얼럿 메시지입니다\n" + resultData)
                                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Log.i("", "onClick: OK 버튼 클릭");
                                    }
                                })
//                                .setNegativeButton("Cancel", null)
                                .show();

                    } else {
                        Log.i("", "onActivityResult: NOT OK");
                    }
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button goSubBtn = (Button) findViewById(R.id.goSubBtn);
        goSubBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeToSubActivity();
            }
        });
    }

    private void changeToSubActivity() {
        // SubActivity 에 전달할 파라미터를 정의
        Intent intent = new Intent(getBaseContext(), SubActivity.class);
        intent.putExtra("myParam1", "MainActivity 에서 전달한 파라미터 01");

        activityResultLauncher.launch(intent);
    }
}
