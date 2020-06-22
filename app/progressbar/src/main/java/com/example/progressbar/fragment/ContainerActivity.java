package com.example.progressbar.fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.progressbar.R;

public class ContainerActivity extends AppCompatActivity implements AFragment.IOnMessageClick {

    private AFragment afragment;
    private BFragment bfragment;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
        textView=findViewById(R.id.tv_title1);
        //实例化Afragment
        afragment=AFragment.newInstance("我是参数");
        //吧Afragment添加到activity中,记得调用commit
        getSupportFragmentManager().beginTransaction().add(R.id.action_container,afragment,"a").commitAllowingStateLoss();
    }
    public void setData(String text){
        textView.setText(text);
    }

    @Override
    public void onclick(String text) {
        textView.setText(text);
    }
}
