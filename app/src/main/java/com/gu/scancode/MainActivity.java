package com.gu.scancode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.gu.zxing.CaptureActivity;
import com.gu.zxing.Intents;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startScan(View v){
        Intent intent=new Intent(MainActivity.this, CaptureActivity.class);
        intent.setAction(Intents.Scan.ACTION);
        startActivityForResult(intent,10001);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==10001){
            if(resultCode!=RESULT_CANCELED){
                String result=data.getStringExtra(Intents.Scan.RESULT);
                Toast.makeText(MainActivity.this,result,Toast.LENGTH_LONG).show();
            }
        }
    }
}
