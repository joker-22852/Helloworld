package com.example.progressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.progressbar.fragment.ContainerActivity;
import com.example.progressbar.jump.AActivity;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar2;
    private Button button,progressdialog1,progressdialog2,pg3,pg4,pg5,pg7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar2=findViewById(R.id.pgbar2);
        progressdialog1=findViewById(R.id.pg1);
        progressdialog2=findViewById(R.id.pg2);
        pg3=findViewById(R.id.pg3);
        pg4=findViewById(R.id.pg4);
        pg7=findViewById(R.id.pg7);
//        pg5=findViewById(R.id.pg5);
        button=findViewById(R.id.start);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler.sendEmptyMessage(0);
            }
        });

        pg3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,CustomDialogActivity.class);
                startActivity(intent);
            }
        });
        pg4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,PopupWindowActivity.class);
                startActivity(intent);
            }
        });
        pg7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, ContainerActivity.class);
                startActivity(intent);
            }
        });
//        pg5.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(MainActivity.this, AActivity.class);
//                startActivity(intent);
//            }
//        });
        progressdialog1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog progressDialog=new ProgressDialog(MainActivity.this);
                progressDialog.setTitle("提示");
                progressDialog.setMessage("正在加载");

                progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        Toast.makeText(MainActivity.this,"haha",Toast.LENGTH_SHORT).show();
                    }
                });
                progressDialog.show();
            }
        });
        progressdialog2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog progressDialog=new ProgressDialog(MainActivity.this);
                progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressDialog.setTitle("提示");
                progressDialog.setMessage("正在加载");
                progressDialog.setButton(DialogInterface.BUTTON_POSITIVE, "棒", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //
                    }
                });
                progressDialog.show();
            }
        });

    }

    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(progressBar2.getProgress()<100){
                handler.postDelayed(runnable,500);
            }else{
                Toast.makeText(MainActivity.this,"加载完成",Toast.LENGTH_SHORT).show();
            }
        }
    };
    Runnable runnable=new Runnable() {
        @Override
        public void run() {
            progressBar2.setProgress(progressBar2.getProgress()+5);
            handler.sendEmptyMessage(0);
        }
    };

}
