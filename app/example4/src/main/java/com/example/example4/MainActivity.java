package com.example.example4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.example4.broadcast.Broad2Activity;
import com.example.example4.broadcast.BroadActivity;
import com.example.example4.data.DataStorageActivity;
import com.example.example4.data.FileActivity;

import java.io.FileInputStream;

public class MainActivity extends AppCompatActivity {

    private Button button,btndata,mbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.btn_1);
        btndata=findViewById(R.id.btn_data);
        mbtn=findViewById(R.id.btn_bd);
        setClickListener();
    }
    private void setClickListener(){
        Onclick onclick=new Onclick();
        button.setOnClickListener(onclick);
        btndata.setOnClickListener(onclick);
        mbtn.setOnClickListener(onclick);
    }
    private  class Onclick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent intent=null;
            switch (v.getId()){
                case R.id.btn_1:

                    intent=new Intent(MainActivity.this,EventActivity.class);
                    break;
                case R.id.btn_data:
                    intent=new Intent(MainActivity.this, DataStorageActivity.class);
                    break;
                case R.id.btn_bd:
                    intent=new Intent(MainActivity.this, BroadActivity.class);
                    break;

            }
            startActivity(intent);
        }
    }
}
