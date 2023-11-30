package com.example.quanlikhachsan_nhom5.Adapter;

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

public class ChiTietAdapter extends RecyclerView.Adapter<ChiTietAdapter.ViewHolder> {
    private Context context;
    private ArrayList<DatPhong> list;

    public ChiTietAdapter(Context context, ArrayList<DatPhong> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_ctphong, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DatPhong datPhong = list.get(position);

        holder.txtSoPhongChiTiet.setText(datPhong.getSophong());
        holder.txtSoTangChiTiet.setText(datPhong.getSotang());
        holder.txtThanhToanChiTiet.setText(datPhong.getGiaphong());
        // ... thiết lập các thông tin khác nếu có ...
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtSoPhongChiTiet, txtSoTangChiTiet, txtThanhToanChiTiet;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtSoPhongChiTiet = itemView.findViewById(R.id.txtSoPhongChiTiet);
            txtSoTangChiTiet = itemView.findViewById(R.id.txtSoTangChiTiet);
            txtThanhToanChiTiet = itemView.findViewById(R.id.txtThanhToanChiTiet);
        }
    }
}
