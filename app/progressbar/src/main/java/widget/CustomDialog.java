package widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.progressbar.R;


public class CustomDialog extends Dialog implements View.OnClickListener {
    private TextView textView1,textView2,textView3,textView4;
   private IOnCancelListener iOnCancelListener;
   private IOnConfirmListener iOnConfirmListener;


    private String title,message,cancel,confirm;

    public CustomDialog(@NonNull Context context) {
        super(context);
    }
    public CustomDialog(@NonNull Context context,int themeId) {
        super(context,themeId);
    }

    public CustomDialog setTitle(String title) {
        this.title = title;
        return this;
    }

    public CustomDialog setMessage(String message) {
        this.message = message;
        return this;
    }

    public CustomDialog setCancel(String cancel,IOnCancelListener iOnCancelListener) {
        this.cancel = cancel;
        this.iOnCancelListener=iOnCancelListener;
        return this;
    }

    public CustomDialog setConfirm(String confirm,IOnConfirmListener iOnConfirmListener) {
        this.confirm = confirm;
        this.iOnConfirmListener=iOnConfirmListener;
        return this;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_custom_dialog);
        textView1=findViewById(R.id.tv_1);
        textView2=findViewById(R.id.tv_2);
        textView3=findViewById(R.id.tv_3);
        textView4=findViewById(R.id.tv_4);
        if(!TextUtils.isEmpty(title)){
            textView1.setText(title);
        }
        if(!TextUtils.isEmpty(message)){
            textView2.setText(message);

        }
        if(!TextUtils.isEmpty(cancel)){
            textView3.setText(cancel);

        }
        if(!TextUtils.isEmpty(confirm)){
            textView4.setText(confirm);
        }
        textView3.setOnClickListener(this);
        textView4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_3:
                if(iOnCancelListener!=null){
                    iOnCancelListener.cancel(this);
                }
                dismiss();
                break;
            case R.id.tv_4:
                if(iOnConfirmListener!=null){
                    iOnConfirmListener.confirm(this);
                }
                dismiss();
                break;
        }
    }

    public interface IOnCancelListener{
        void cancel(CustomDialog dialog);
    }
    public interface IOnConfirmListener{
        void confirm(CustomDialog dialog);
    }
}
