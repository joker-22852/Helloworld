package com.example.example4.data;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.example4.R;

public class DataStorageActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnshared,btnfile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_storage);
        btnshared=findViewById(R.id.sharedpreferences);
        btnfile=findViewById(R.id.btnfile);
        btnshared.setOnClickListener(this);
        btnfile.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent=null;
        switch (v.getId()){
            case R.id.sharedpreferences:
                intent=new Intent(DataStorageActivity.this,SharedPreferencesActivity.class);
                Log.d("joker","sharedpreferences");
                break;
            case R.id.btnfile:
                intent=new Intent(DataStorageActivity.this,FileActivity.class);
                Log.d("joker","btnfile");
                break;

        }
        startActivity(intent);
    }
}
