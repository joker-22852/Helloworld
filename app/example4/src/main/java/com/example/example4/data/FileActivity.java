package com.example.example4.data;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.example4.R;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileActivity extends AppCompatActivity {

    private EditText name;
    private Button save,show;
    private TextView tvshow;
    private final String mfilename="test.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);
        name=findViewById(R.id.et_name);
        save=findViewById(R.id.btn_save);
        show=findViewById(R.id.btn_show);
        tvshow=findViewById(R.id.tv_show);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save(name.getText().toString().trim());
            }
        });
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvshow.setText(read());
            }
        });
    }
    //存取数据
    private void save(String s){
        FileOutputStream fileOutputStream=null;
        try {
            fileOutputStream= openFileOutput(mfilename,MODE_PRIVATE);
            fileOutputStream.write(s.getBytes());

        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fileOutputStream!=null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    //读取数据
    private  String read(){
        FileInputStream fileInputStream=null;
        try {
             fileInputStream=openFileInput(mfilename);
             byte[] bytes=new byte[1024];
             StringBuilder stringBuilder=new StringBuilder("");
             int len=0;
             while ((len=fileInputStream.read(bytes))>0){
                 stringBuilder.append(new String(bytes,0,len));
             }
             return stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fileInputStream!=null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
