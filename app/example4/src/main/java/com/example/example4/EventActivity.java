package com.example.example4;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.example.example4.widget.MyButton;

public class EventActivity extends AppCompatActivity {

    private Button mbutton;
    private MyButton myButton;
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        mbutton=findViewById(R.id.btn_event);
        myButton=findViewById(R.id.mybtn);
        mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(EventActivity.this,HandlerActivity.class);
                startActivity(intent);
            }
        });
        myButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        Log.d("listener","EventActivity");
                        break;
                }
                return false;
            }
        });
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("listener","----onClick------");
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
         switch (event.getAction()){
             case MotionEvent.ACTION_DOWN:
                 Log.d("MyButton1","EventActivity");
             break;
         }
         return false;
    }
}
