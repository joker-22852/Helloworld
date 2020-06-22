package com.example.relative;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.relative.util.ToastUtil;

public class RelativeActivity extends AppCompatActivity {
    private Button button1,button2,button3,button4,button5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative);
        button1=findViewById(R.id.toast);
        button2=findViewById(R.id.toast2);
        button3=findViewById(R.id.toast3);
        button4=findViewById(R.id.toast4);
        button5=findViewById(R.id.progress);
        OnClick onClick=new OnClick();
        button1.setOnClickListener(onClick);
        button2.setOnClickListener(onClick);
        button3.setOnClickListener(onClick);
        button4.setOnClickListener(onClick);
        button5.setOnClickListener(onClick);
    }
    class OnClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Intent intent=null;
            switch (v.getId()){
                case R.id.toast:
                    Toast.makeText(getApplicationContext(),"Toast", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.toast2:
                    Toast toastcenter= Toast.makeText(getApplicationContext(),"居中Toast",Toast.LENGTH_SHORT);
                    toastcenter.setGravity(Gravity.CENTER,0,0);
                    toastcenter.show();
                    break;
                case R.id.toast3:
                    Toast toastc=new Toast(getApplicationContext());
                    LayoutInflater inflater=LayoutInflater.from(RelativeActivity.this);
                    View view = inflater.inflate(R.layout.layout_toast, null);
                    ImageView imageView=view.findViewById(R.id.iv_1);
                    TextView textView=view.findViewById(R.id.tx);
                    imageView.setImageResource(R.drawable.icon_1);
                    textView.setText("你好啊");
                    toastc.setView(view);
                    toastc.show();
                    break;
                case R.id.toast4:
                    ToastUtil.showMsg(getApplicationContext(),"你好啊");
                    break;
                case R.id.progress:

                    break;

            }
        }
    }

}
