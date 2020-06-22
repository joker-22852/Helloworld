package com.example.progressbar.fragment;

import androidx.lifecycle.ViewModelProviders;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.progressbar.R;

public class AFragment extends Fragment {

    private TextView mtvtitle;
    private Button btnchange,btnreset,btnmessage;
    private BFragment bfragment;
    private IOnMessageClick listener;
//    private Activity mactivity;

    public  static AFragment newInstance(String title){
        AFragment aFragment=new AFragment();
        Bundle bundle=new Bundle();
        bundle.putString("title",title);
        aFragment.setArguments(bundle);
        return aFragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            listener= (IOnMessageClick) context;
        }catch (ClassCastException e){
            throw new ClassCastException("Activity 必须实现 IOnMessageClick接口");
        }

    }

    public interface IOnMessageClick{
           void onclick(String text);
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view=inflater.inflate(R.layout.a_fragment,container,false);
       Log.d("AFragment","-----onCreateView------");
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mtvtitle=view.findViewById(R.id.tv_title);
        btnchange=view.findViewById(R.id.btn_change);
        btnreset=view.findViewById(R.id.btn_reset);
        btnmessage=view.findViewById(R.id.btn_message);
        super.onViewCreated(view, savedInstanceState);
        btnmessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                ((ContainerActivity)getActivity()).setData("你好");
                listener.onclick("你好");
            }
        });
        btnchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bfragment==null){
                    bfragment=new BFragment();
                }
                Fragment tag = getParentFragmentManager().findFragmentByTag("a");
                if(tag!=null){
                    getParentFragmentManager().beginTransaction().hide(tag).add(R.id.action_container,bfragment).addToBackStack(null).commitAllowingStateLoss();
                }else {
                    getParentFragmentManager().beginTransaction().replace(R.id.action_container, bfragment).addToBackStack(null).commitAllowingStateLoss();
                }
            }
        });
        btnreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mtvtitle.setText("我是新文字");
            }
        });
        if(getArguments()!=null){
            mtvtitle.setText(getArguments().getString("title"));
        }


    }


}
