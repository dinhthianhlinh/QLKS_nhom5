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
import com.example.quanlikhachsan_nhom5.model.DatPhong;

import java.util.ArrayList;

public class DatPhongAdapter extends RecyclerView.Adapter<DatPhongAdapter.ViewHolder> {
    private Context context;
    private ArrayList<DatPhong> list;
    private OnItemClickedListener listener;

    public interface OnItemClickedListener {
        void onItemClicked(DatPhong datPhong);
    }

    public DatPhongAdapter(Context context, ArrayList<DatPhong> list) {
        this.context = context;
        this.list = list;
    }

    public void setOnItemClickedListener(OnItemClickedListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public DatPhongAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_datphong, parent, false);
        return new DatPhongAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DatPhongAdapter.ViewHolder holder, int position) {
        DatPhong datPhong = list.get(position);
        holder.id.setText("ID: " + datPhong.getId());
        holder.sophong.setText(datPhong.getSophong());
        holder.sptang.setText(datPhong.getSotang());
        holder.giaphong.setText(datPhong.getGiaphong());
        holder.hangphong.setText(datPhong.getHangphong());

        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onItemClicked(datPhong);
            }
        });

        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onItemClicked(list.get(position));
            }
        });




    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView id, sophong, sptang, giaphong, hangphong;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.txtid);
            sophong = itemView.findViewById(R.id.txtsophong);
            sptang = itemView.findViewById(R.id.txtsotang);
            giaphong = itemView.findViewById(R.id.txtgiaphong);
            hangphong = itemView.findViewById(R.id.txthangphong);
        }
    }
}
