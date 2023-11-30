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
import com.example.quanlikhachsan_nhom5.model.Tang2;

import java.util.ArrayList;

public class Tang2Adapter extends RecyclerView.Adapter<Tang2Adapter.ViewHolder> {
    private Context context;
    private ArrayList<Tang2> list;


    public Tang2Adapter(Context context, ArrayList<Tang2> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public Tang2Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View view = inflater.inflate(com.example.quanlikhachsan_nhom5.R.layout.item_tang2, parent, false);

        return new Tang2Adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Tang2Adapter.ViewHolder holder, int position) {
        holder.id.setText("ID" + list.get(position).getId());
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
        TextView id, sophong, sptang, giaphong, hangphong;
        ImageView xoatang2, updatetang2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            id = itemView.findViewById(R.id.idtang2);
            sophong = itemView.findViewById(R.id.sophongtang2);
            sptang = itemView.findViewById(R.id.sotangtang2);
            giaphong = itemView.findViewById(R.id.giaphongtang2);
            hangphong = itemView.findViewById(R.id.hangphongtamg2);
            xoatang2 = itemView.findViewById(R.id.xoatang2);
            updatetang2 = itemView.findViewById(R.id.updatetang2);


        }
    }
}
