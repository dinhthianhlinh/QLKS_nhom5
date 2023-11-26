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
import com.example.quanlikhachsan_nhom5.model.Tang1;

import java.util.ArrayList;

public class Tang1Adapter extends RecyclerView.Adapter<Tang1Adapter.ViewHolder>{



    private Context context;
    private ArrayList<Tang1> list;

    public Tang1Adapter(Context context,ArrayList<Tang1>list){
        this.context = context;
        this.list = list;
    }









    @NonNull
    @Override
    public Tang1Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_tang1,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Tang1Adapter.ViewHolder holder, int position) {
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
        ImageView xoatang1, updatetang1;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            id =itemView.findViewById(R.id.idtang1);
            sophong = itemView.findViewById(R.id.sophongtang1);
            sptang = itemView.findViewById(R.id.sotangtang1);
            giaphong = itemView.findViewById(R.id.giaphongtang1);
            hangphong = itemView.findViewById(R.id.hangphongtamg1);
            xoatang1 = itemView.findViewById(R.id.xoatang1);
            updatetang1 = itemView.findViewById(R.id.updatetang1);
        }
    }
}
