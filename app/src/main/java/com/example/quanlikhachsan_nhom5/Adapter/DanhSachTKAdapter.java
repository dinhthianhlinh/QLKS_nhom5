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
import com.example.quanlikhachsan_nhom5.dao.NguoiDungDao;
import com.example.quanlikhachsan_nhom5.dao.QuanLyPDAO;
import com.example.quanlikhachsan_nhom5.model.NguoiDung;
import com.example.quanlikhachsan_nhom5.model.QuanLyP;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DanhSachTKAdapter extends RecyclerView.Adapter<DanhSachTKAdapter.viewholder>{

    private final Context context;
    private final ArrayList<NguoiDung> list;
    NguoiDungDao nguoiDungDao;

    public DanhSachTKAdapter(Context context, ArrayList<NguoiDung> list) {
        this.context = context;
        this.list = list;
        nguoiDungDao = new NguoiDungDao(context);
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_dstk, null);
        return new DanhSachTKAdapter.viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        Picasso.get()
                .load(list.get(position).getLinkAvata())
//                .placeholder(R.drawable.placeholder) // (Tùy chọn) Ảnh placeholder trong khi đang tải
//                .error(R.drawable.error) // (Tùy chọn) Ảnh hiển thị khi có lỗi
                .into(holder.Img_DSTK);
        holder.txttaikhoan_DSTK.setText(list.get(position).getTendn());
        holder.txtmatkhau_DSTK.setText(list.get(position).getMatkhau());
        holder.txthoten_DSTK.setText(list.get(position).getTennd());
        holder.txtsdt_DSTK.setText((list.get(position).getSdt()));
        holder.txtque_DSTK.setText(list.get(position).getDiachi());

    }

    @Override
    public int getItemCount() {
        if (list != null)
            return list.size();
        return 0;
    }

    public static class viewholder extends RecyclerView.ViewHolder {

        ImageView Img_DSTK;
        TextView txttaikhoan_DSTK, txtmatkhau_DSTK, txthoten_DSTK, txtsdt_DSTK,txtque_DSTK;



        public viewholder(@NonNull View itemView) {
            super(itemView);
            Img_DSTK = itemView.findViewById(R.id.img_Avata);
            txttaikhoan_DSTK = itemView.findViewById(R.id.txttentk_DSTK);
            txtmatkhau_DSTK = itemView.findViewById(R.id.txtmatkhau_DSTK);
            txthoten_DSTK = itemView.findViewById(R.id.txthovaten_DSTK);
            txtsdt_DSTK = itemView.findViewById(R.id.txtsdt_DSTK);
            txtque_DSTK = itemView.findViewById(R.id.txtquequan_DSTK);

        }
    }
}
