package com.example.linear.gridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.linear.R;

import org.w3c.dom.Text;

public class MyGridViewAdapter extends BaseAdapter {

    private Context mcontext;
    private LayoutInflater layoutInflater;
    public MyGridViewAdapter(Context context){
                this.mcontext=context;
        layoutInflater=LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    static class ViewHolder{
        public ImageView imageView;
        public TextView textView;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder=null;
        if(convertView==null){
            convertView=layoutInflater.inflate(R.layout.layout_gridview_item,null);
            viewHolder =new ViewHolder();
            viewHolder.imageView=convertView.findViewById(R.id.im_2);
            viewHolder.textView=convertView.findViewById(R.id.tv_t);
            convertView.setTag(viewHolder);
        }else{
            viewHolder= (ViewHolder) convertView.getTag();
        }
        //赋值
        viewHolder.textView.setText("地方");
        Glide.with(mcontext).load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1590246412745&di=b759501fffd68dd5614dbd4b8db90537&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201605%2F21%2F20160521070226_ABFLR.jpeg").into(viewHolder.imageView);
        return convertView;
    }
}
