package com.example.quanlikhachsan_nhom5.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quanlikhachsan_nhom5.R;
import com.example.quanlikhachsan_nhom5.dao.QuanLyKHDAO;
import com.example.quanlikhachsan_nhom5.fragment.qlkh_frag;
import com.example.quanlikhachsan_nhom5.model.QuanLyKH;

import java.util.ArrayList;

public class QuanLyKHAdapter extends RecyclerView.Adapter<QuanLyKHAdapter.viewholder>{

    private final Context context;
    private final ArrayList<QuanLyKH> list;
    QuanLyKHDAO quanLyKHDAO;

    public QuanLyKHAdapter(Context context, ArrayList<QuanLyKH> list) {
        this.context = context;
        this.list = list;
        quanLyKHDAO = new QuanLyKHDAO(context);
    }



    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_qlkh, null);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        holder.txtsott.setText(String.valueOf(list.get(position).getId()));
        holder.txtten.setText(list.get(position).getTenQLKH());
        holder.txttuoi.setText(String.valueOf(list.get(position).getTuoiQLKH()));
        holder.txtgioitinh.setText(list.get(position).getGioitinhQLKH());
        holder.txtsodienthoai.setText(String.valueOf(list.get(position).getSodtQLKH()));
        holder.txtquequan.setText(list.get(position).getQuequanQLKH());
        holder.txtcancuoc.setText(String.valueOf(list.get(position).getCancuocQLKH()));
        holder.txtlandatphong.setText(String.valueOf(list.get(position).getSolandatphongQLKH()));
    }

    @Override
    public int getItemCount() {
        if (list != null)
            return list.size();
        return 0;
    }

    public static class viewholder extends RecyclerView.ViewHolder {
        TextView txtsott, txtten, txttuoi, txtgioitinh, txtsodienthoai,txtquequan,txtcancuoc,txtlandatphong;



        public viewholder(@NonNull View itemView) {
            super(itemView);
            txtsott = itemView.findViewById(R.id.txtsott);
            txtten = itemView.findViewById(R.id.txtten);
            txttuoi = itemView.findViewById(R.id.txttuoi);
            txtgioitinh = itemView.findViewById(R.id.txtgioitinh);
            txtsodienthoai = itemView.findViewById(R.id.txtsodienthoai);
            txtquequan = itemView.findViewById(R.id.txtquequan);
            txtcancuoc = itemView.findViewById(R.id.txtcancuoc);
            txtlandatphong = itemView.findViewById(R.id.txtlandatphong);


        }
}

}
