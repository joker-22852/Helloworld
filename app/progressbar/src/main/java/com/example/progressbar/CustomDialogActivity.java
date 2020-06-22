package com.example.progressbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Paint;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import widget.CustomDialog;

public class CustomDialogActivity extends AppCompatActivity {

    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_dialog);
        //设置宽度
        WindowManager m= getWindow().getWindowManager();
        Display d=m.getDefaultDisplay();
        WindowManager.LayoutParams p =getWindow().getAttributes();
        Point size=new Point();
        d.getSize(size);
        p.width=(int)(size.x*0.8);//设置Dialog宽度为当前手机屏幕的80%
        getWindow().setAttributes(p);
        button=findViewById(R.id.co1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                CustomDialog customDialog=new CustomDialog(CustomDialogActivity.this,R.style.CustomDialog1);
                customDialog.setTitle("提示").setMessage("确认删除此项？")
                        .setCancel("取消", new CustomDialog.IOnCancelListener() {
                    @Override
                    public void cancel(CustomDialog dialog) {

                    }
                }).setConfirm("确认", new CustomDialog.IOnConfirmListener() {
                    @Override
                    public void confirm(CustomDialog dialog) {

                    }
                }).show();
            }
        });
    }
}
