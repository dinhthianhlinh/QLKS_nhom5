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
import com.example.quanlikhachsan_nhom5.model.Tang3;

import java.util.ArrayList;

public class Tang3Adapter extends RecyclerView.Adapter<Tang3Adapter.ViewHolder> {

    private Context context;
    private ArrayList<Tang3> list;


    public Tang3Adapter(Context context, ArrayList<Tang3> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public Tang3Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View view = inflater.inflate(com.example.quanlikhachsan_nhom5.R.layout.item_tang3, parent, false);

        return new Tang3Adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Tang3Adapter.ViewHolder holder, int position) {
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
        ImageView xoatang3, updatetang3;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            id = itemView.findViewById(R.id.idtang3);
            sophong = itemView.findViewById(R.id.sophongtang3);
            sptang = itemView.findViewById(R.id.sotangtang3);
            giaphong = itemView.findViewById(R.id.giaphongtang3);
            hangphong = itemView.findViewById(R.id.hangphongtamg3);
            xoatang3 = itemView.findViewById(R.id.xoatang3);
            updatetang3 = itemView.findViewById(R.id.updatetang3);


        }
    }


}
