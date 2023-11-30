package com.example.quanlikhachsan_nhom5.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.quanlikhachsan_nhom5.R;
import com.example.quanlikhachsan_nhom5.fragment.ChiTietActivity;
import com.example.quanlikhachsan_nhom5.model.DatPhong;
import com.google.gson.Gson;

import java.util.ArrayList;

public class DatPhongAdapter extends RecyclerView.Adapter<DatPhongAdapter.ViewHolder> {
    private Context context;
    private ArrayList<DatPhong> list;
    private OnItemClickedListener listener;

    public DatPhongAdapter(Context context, ArrayList<DatPhong> list) {
        this.context = context;
        this.list = list;
    }

    // Interface để xử lý sự kiện click trên mỗi item
    public interface OnItemClickedListener {
        void onItemClicked(DatPhong datPhong);
    }

    public void setOnItemClickedListener(OnItemClickedListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_datphong, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DatPhong datPhong = list.get(position);
        holder.id.setText("ID: " + datPhong.getId());
        holder.sophong.setText(datPhong.getSophong());
        holder.sptang.setText(datPhong.getSotang());
        holder.giaphong.setText(datPhong.getGiaphong());
        holder.hangphong.setText(datPhong.getHangphong());
        holder.btnChitiet.setOnClickListener(v -> {
            Gson gson = new Gson();
            String datPhongJson = gson.toJson(datPhong);
            Intent intent = new Intent(context, ChiTietActivity.class);
            intent.putExtra("datPhongJson", datPhongJson);
            context.startActivity(intent);
        });

        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onItemClicked(list.get(position));
            } else {
                // Khi không có listener, mở ChiTietActivity
                Intent intent = new Intent(context, ChiTietActivity.class);

                intent.putExtra("sophong", datPhong.getSophong());
                intent.putExtra("sotang", datPhong.getSotang());
                intent.putExtra("giaphong", datPhong.getGiaphong());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    // ViewHolder cho adapter
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView id, sophong, sptang, giaphong, hangphong;
        Button btnChitiet;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.txtid);
            sophong = itemView.findViewById(R.id.txtsophong);
            sptang = itemView.findViewById(R.id.txtsotang);
            giaphong = itemView.findViewById(R.id.txtgiaphong);
            hangphong = itemView.findViewById(R.id.txthangphong);
            btnChitiet = itemView.findViewById(R.id.btnChitiet);
        }
    }

    // Phương thức để lấy vị trí của một DatPhong trong danh sách
    public int getDatPhongPosition(DatPhong datPhong) {
        return list.indexOf(datPhong);
    }

    // Phương thức để xóa một DatPhong khỏi danh sách
    public void removeDatPhong(int position) {
        if (position >= 0 && position < list.size()) {
            list.remove(position);
            notifyItemRemoved(position);
        }
    }
}
