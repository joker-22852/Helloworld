package com.example.linear;

import androidx.appcompat.app.AppCompatActivity;


import android.graphics.Paint;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;


public class Main2Activity extends AppCompatActivity {
    private TextView mtv,mtv2,mtv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mtv = findViewById(R.id.tv_4);
        mtv.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);//中划线
        mtv.getPaint().setAntiAlias(true);//消除锯齿
//        mtv2 = findViewById(R.id.tv_1);
//        mtv2.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);//下划线
        mtv3=findViewById(R.id.tv_1);
        mtv3.setText(Html.fromHtml("<u>dsgdsg</u>"));
    }
}
