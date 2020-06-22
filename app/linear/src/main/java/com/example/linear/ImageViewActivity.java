package com.example.linear;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ImageViewActivity extends AppCompatActivity {

    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);
        imageView=findViewById(R.id.iv_2);
        Glide.with(this).load("https://pics7.baidu.com/feed/a71ea8d3fd1f41341b16f949978c38ccd1c85e7a.jpeg?token=59e0c3d50f04487f2662e37d9b60634f").into(imageView);
    }

}
