package com.example.quanlikhachsan_nhom5.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quanlikhachsan_nhom5.R;
import com.example.quanlikhachsan_nhom5.model.Tang4;

import java.util.ArrayList;

public class Tang4Adapter extends RecyclerView.Adapter<Tang4Adapter.ViewHolder>{

    private Context context;
    private ArrayList<Tang4> list;


    public Tang4Adapter(Context context,ArrayList<Tang4>list){
        this.context = context;
        this.list = list;
    }








    @NonNull
    @Override
    public Tang4Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View view = inflater.inflate(com.example.quanlikhachsan_nhom5.R.layout.item_tang4,parent,false);

        return new Tang4Adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Tang4Adapter.ViewHolder holder, int position) {
        holder.id.setText("ID"+ list.get(position).getId());
        holder.sophong.setText(list.get(position).getSophong());
        holder.sptang.setText(list.get(position).getSotang());
        holder.giaphong.setText(list.get(position).getGiaphong());
        holder.hangphong.setText(list.get(position).getHangphong());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView id , sophong, sptang, giaphong, hangphong;
        ImageView xoatang4, updatetang4;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            id =itemView.findViewById(R.id.idtang4);
            sophong = itemView.findViewById(R.id.sophongtang4);
            sptang = itemView.findViewById(R.id.sotangtang4);
            giaphong = itemView.findViewById(R.id.giaphongtang4);
            hangphong = itemView.findViewById(R.id.hangphongtamg4);
            xoatang4 = itemView.findViewById(R.id.xoatang4);
            updatetang4 = itemView.findViewById(R.id.updatetang4);



        }
    }
}
