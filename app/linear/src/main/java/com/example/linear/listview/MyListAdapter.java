package com.example.linear.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.linear.R;

public class MyListAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater layoutInflater;
    public  MyListAdapter(Context context){
          this.context=context;
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
        public TextView title,time,tvcontent;

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder=null;
        if(convertView==null){
            convertView = layoutInflater.inflate(R.layout.layout_list_item,null);
            viewHolder=new ViewHolder();
            viewHolder.imageView=convertView.findViewById(R.id.im_1);
            viewHolder.title=convertView.findViewById(R.id.title_1);
            viewHolder.time=convertView.findViewById(R.id.time_1);
            viewHolder.tvcontent=convertView.findViewById(R.id.tv_content);
            convertView.setTag(viewHolder);
        }else{
            viewHolder= (ViewHolder) convertView.getTag();
        }
        //给控件赋值
        viewHolder.title.setText("这是标题");
        viewHolder.time.setText("2099-8-8");
        viewHolder.tvcontent.setText("这是内容");
        Glide.with(context).load("https://pics7.baidu.com/feed/a71ea8d3fd1f41341b16f949978c38ccd1c85e7a.jpeg?token=59e0c3d50f04487f2662e37d9b60634f").into(viewHolder.imageView);
        return convertView;
    }
}
