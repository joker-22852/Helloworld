package com.example.linear.recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.linear.R;

public class RecyclerViewActivity extends AppCompatActivity {

    private Button button,mtnhor,mbtngrid,mtnfalls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        button=findViewById(R.id.linear);
        mtnhor=findViewById(R.id.horizontal);
        mbtngrid=findViewById(R.id.grid_view);
        mtnfalls=findViewById(R.id.falls_view);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RecyclerViewActivity.this,LinearRecyclerViewActivity.class);

                startActivity(intent);
            }

        });
        mtnhor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RecyclerViewActivity.this,HorRecyclerViewActivity.class);

                startActivity(intent);
            }
        });
        mbtngrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RecyclerViewActivity.this,GridRecyclerViewActivity.class);

                startActivity(intent);
            }
        });
        mtnfalls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RecyclerViewActivity.this,PuRecyclerViewActivity.class);

                startActivity(intent);
            }
        });
    }
}
