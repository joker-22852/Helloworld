package com.example.progressbar.jump;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.progressbar.CustomDialogActivity;
import com.example.progressbar.MainActivity;
import com.example.progressbar.R;

public class AActivity extends AppCompatActivity {

    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        button=findViewById(R.id.jump);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //显式跳转1
                Intent intent=new Intent(AActivity.this, BActivity.class);
                Bundle bundle=new Bundle();
                bundle.putString("name","joker");
                bundle.putInt("joker1",3);
                intent.putExtras(bundle);
//                startActivity(intent);
                startActivityForResult(intent,0);
                //显式跳转2
//                Intent intent=new Intent();
//                intent.setClass(AActivity.this, BActivity.class);
//                startActivity(intent);
                //隐式
//                Intent intent=new Intent();
//                intent.setAction("com.haha.test.Bactivity");
//                startActivity(intent);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Toast.makeText(AActivity.this,data.getExtras().getString("msg"),Toast.LENGTH_SHORT).show();
    }
}
