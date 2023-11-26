package com.example.quanlikhachsan_nhom5.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quanlikhachsan_nhom5.R;
import com.example.quanlikhachsan_nhom5.fragment.datphong_frag;
import com.example.quanlikhachsan_nhom5.model.DatPhong;

import java.util.ArrayList;

public class DatPhongAdapter extends RecyclerView.Adapter<DatPhongAdapter.ViewHolder> {
    private Context context;
    private ArrayList<DatPhong> list;

    public DatPhongAdapter(Context context, ArrayList<DatPhong>list, datphong_frag datphongFrag){
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public DatPhongAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_datphong,parent,false);

        return new DatPhongAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DatPhongAdapter.ViewHolder holder, int position) {
        holder.id.setText("ID"+list.get(position).getId());
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
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            id =itemView.findViewById(R.id.txtid);
            sophong = itemView.findViewById(R.id.txtsophong);
            sptang = itemView.findViewById(R.id.txtsotang);
            giaphong = itemView.findViewById(R.id.txtgiaphong);
            hangphong = itemView.findViewById(R.id.txthangphong);
        }
    }
}
