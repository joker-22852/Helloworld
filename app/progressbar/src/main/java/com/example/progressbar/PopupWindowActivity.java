package com.example.progressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

public class PopupWindowActivity extends AppCompatActivity {

    private Button button;
    private PopupWindow popupWindow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_window);
        button=findViewById(R.id.btn_w);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view= getLayoutInflater().inflate(R.layout.layout_pop,null);
               TextView editText=view.findViewById(R.id.tv_1);
                editText.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       popupWindow.dismiss();
                        Toast.makeText(PopupWindowActivity.this,"哈哈",Toast.LENGTH_SHORT).show();
                    }
             });
                popupWindow=new PopupWindow(view,button.getWidth(), ViewGroup.LayoutParams.WRAP_CONTENT);
                popupWindow.showAsDropDown(button);
                popupWindow.setFocusable(true);
                popupWindow.setOutsideTouchable(true);
            }
        });
    }
}
