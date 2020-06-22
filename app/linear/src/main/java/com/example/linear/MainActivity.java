package com.example.linear;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import com.example.linear.gridview.GridViewActivity;
import com.example.linear.listview.ListViewActivity;
import com.example.linear.recyclerview.RecyclerViewActivity;

public class MainActivity extends AppCompatActivity {

    private Button btntestview;
    private Button btnbutton;
    private Button edittext;
    private Button radiobtn;
    private Button mbtcheckbox;
    private Button imageview;
    private Button listview;
    private Button gridview;
    private Button mrecycle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btntestview = findViewById(R.id.btn_textview);

        btnbutton = findViewById(R.id.btn_button);

        edittext = findViewById(R.id.btn_edittext);

        radiobtn =findViewById(R.id.btn_radiobutton);

        mbtcheckbox= findViewById(R.id.btn_checkbox);

        imageview=findViewById(R.id.btn_imageview);

        listview=findViewById(R.id.btn_listview);

        gridview=findViewById(R.id.btn_gridview);

        mrecycle=findViewById(R.id.btn_recycler);
        setListeners();
    }
    private void setListeners(){
        Onclick onclick=new Onclick();
        btntestview.setOnClickListener(onclick);
        btnbutton.setOnClickListener(onclick);
        edittext.setOnClickListener(onclick);
        radiobtn.setOnClickListener(onclick);
        mbtcheckbox.setOnClickListener(onclick);
        imageview.setOnClickListener(onclick);
        listview.setOnClickListener(onclick);
        gridview.setOnClickListener(onclick);
        mrecycle.setOnClickListener(onclick);
    }
    private class Onclick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Intent intend =null;
            switch (v.getId()){
                case R.id.btn_textview:
                    intend = new Intent(MainActivity.this,Main2Activity.class);
                   break;
                case R.id.btn_button:
                    intend = new Intent(MainActivity.this,ButtonActivity.class);
                    break;
                case R.id.btn_edittext:
                    intend = new Intent(MainActivity.this,EditTextActivity.class);
                    break;
                case R.id.btn_radiobutton:
                    intend = new Intent(MainActivity.this,RadioButtonActivity.class);
                    break;
                case R.id.btn_checkbox:
                     intend = new Intent(MainActivity.this,CheckBoxActivity.class);
                     break;
                case  R.id.btn_imageview:
                    intend = new Intent(MainActivity.this,ImageViewActivity.class);
                    break;
                case  R.id.btn_listview:
                    intend = new Intent(MainActivity.this, ListViewActivity.class);
                    break;
                case  R.id.btn_gridview:
                    intend = new Intent(MainActivity.this, GridViewActivity.class);
                    break;
                case  R.id.btn_recycler:
                    intend = new Intent(MainActivity.this, RecyclerViewActivity.class);
                    break;
            }
            startActivity(intend);
        }
    }
}
