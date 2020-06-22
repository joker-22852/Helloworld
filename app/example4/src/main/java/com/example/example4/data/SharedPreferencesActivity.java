package com.example.example4.data;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.example4.R;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class SharedPreferencesActivity extends AppCompatActivity {

    private EditText name;
    private Button save,show;
    private TextView tvshow;
    private SharedPreferences msharedPreferences;
    private SharedPreferences.Editor meditor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);
        name=findViewById(R.id.et_name);
        save=findViewById(R.id.btn_save);
        show=findViewById(R.id.btn_show);
        tvshow=findViewById(R.id.tv_show);

        msharedPreferences=getSharedPreferences("data",MODE_PRIVATE);
        meditor= msharedPreferences.edit();
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                meditor.putString("name",name.getText().toString());
                meditor.apply();
            }
        });
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvshow.setText(msharedPreferences.getString("name",""));
            }
        });
    }

}
