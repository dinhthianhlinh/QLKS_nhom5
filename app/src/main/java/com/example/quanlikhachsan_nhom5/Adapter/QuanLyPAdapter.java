package com.example.quanlikhachsan_nhom5.Adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quanlikhachsan_nhom5.R;
import com.example.quanlikhachsan_nhom5.model.QuanLyP;

import java.util.ArrayList;

public class QuanLyPAdapter extends RecyclerView.Adapter<QuanLyPAdapter.ViewHolder> {

    private Context context;
    private ArrayList<QuanLyP> list;

    public QuanLyPAdapter(Context context, ArrayList<QuanLyP> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_qlp, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        QuanLyP quanLyP = list.get(position);
        holder.txttenkhnv.setText(quanLyP.getName());
        holder.txtsodienthoaikhnv.setText(quanLyP.getPhone());
        holder.txtemailkhnv.setText(quanLyP.getEmail());
        holder.txtsoluongnguoikhnv.setText(quanLyP.getNumPeople());
        holder.txtcheckinkhnv.setText(quanLyP.getCheckIn());
        holder.txtcheckoutkhnv.setText(quanLyP.getCheckOut());
        holder.txttongtienkhnv.setText(quanLyP.getTotalPrice());
        holder.txtsophongkhnv.setText(quanLyP.getRoomNumber());
        holder.txtthongtinthanhtoankhnv.setText(quanLyP.getPaymentInfo());

        holder.bindData(quanLyP);

        // Lưu trạng thái ẩn của mục vào SharedPreferences
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    QuanLyP quanLyP = list.get(position);
                    quanLyP.setVisible(!quanLyP.isVisible());
                    saveHiddenState(position, !quanLyP.isVisible());
                    notifyItemChanged(position);
                }
            }
        });

        // Đặt trạng thái hiển thị của mục
        if (quanLyP.isVisible()) {
            holder.itemView.setVisibility(View.VISIBLE);
        } else {
            holder.itemView.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setOnItemClickListner(QuanLyPAdapter.OnItemClickListener onItemClickListener) {
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txttenkhnv, txtsodienthoaikhnv, txtemailkhnv, txtsoluongnguoikhnv, txtcheckinkhnv, txtcheckoutkhnv, txttongtienkhnv, txtsophongkhnv, txtthongtinthanhtoankhnv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txttenkhnv = itemView.findViewById(R.id.txttenkhnv);
            txtsodienthoaikhnv = itemView.findViewById(R.id.txtsodienthoaikhnv);
            txtemailkhnv = itemView.findViewById(R.id.txtemailkhnv);
            txtsoluongnguoikhnv = itemView.findViewById(R.id.txtsoluongnguoikhnv);
            txtcheckinkhnv = itemView.findViewById(R.id.txtcheckinkhnv);
            txtcheckoutkhnv = itemView.findViewById(R.id.txtcheckoutkhnv);
            txttongtienkhnv = itemView.findViewById(R.id.txttongtienkhnv);
            txtsophongkhnv = itemView.findViewById(R.id.txtsophongkhnv);
            txtthongtinthanhtoankhnv = itemView.findViewById(R.id.txtthongtinthanhtoankhnv);
        }

        public void bindData(QuanLyP quanLyP) {
            txttenkhnv.setText(quanLyP.getName());
            txtsodienthoaikhnv.setText(quanLyP.getPhone());
            txtemailkhnv.setText(quanLyP.getEmail());
            txtsoluongnguoikhnv.setText(quanLyP.getNumPeople());
            txtcheckinkhnv.setText(quanLyP.getCheckIn());
            txtcheckoutkhnv.setText(quanLyP.getCheckOut());
            txttongtienkhnv.setText(quanLyP.getTotalPrice());
            txtsophongkhnv.setText(quanLyP.getRoomNumber());
            txtthongtinthanhtoankhnv.setText(quanLyP.getPaymentInfo());
        }
    }

    private void saveHiddenState(int position, boolean isHidden) {
        SharedPreferences preferences = context.getSharedPreferences("hidden_states", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("item_" + position, isHidden);
        editor.apply();
    }
}