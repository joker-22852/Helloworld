package com.example.linear.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.linear.R;

public class StaggeredGridAdapter extends RecyclerView.Adapter<StaggeredGridAdapter.LinearViewHolder> {

    private Context mcontext;
    private OnItemClickListener monItemClickListener;
    public StaggeredGridAdapter(Context context, OnItemClickListener onItemClickListener){
        mcontext=context;
        monItemClickListener=onItemClickListener;
    }
    @NonNull
    @Override
    public StaggeredGridAdapter.LinearViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LinearViewHolder(LayoutInflater.from(mcontext).inflate(R.layout.layout_staggeredgrid_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull StaggeredGridAdapter.LinearViewHolder holder, final int position) {
       if(position%2!=0){
           holder.iView.setImageResource(R.drawable.icon_1);
       }else {
           holder.iView.setImageResource(R.drawable.icon_3);
       }


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(mcontext,"click..."+position,Toast.LENGTH_SHORT).show();
                monItemClickListener.onClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 30;
    }
    class LinearViewHolder extends RecyclerView.ViewHolder{

        private ImageView iView;
        public LinearViewHolder(@NonNull View itemView) {
            super(itemView);
            iView=itemView.findViewById(R.id.iv);

        }
    }
    public interface OnItemClickListener{
        void onClick(int pos);
    }
}
