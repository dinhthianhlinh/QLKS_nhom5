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
import com.example.quanlikhachsan_nhom5.dao.QuanLyPDAO;
import com.example.quanlikhachsan_nhom5.model.QuanLyP;

import java.util.ArrayList;

public class QuanLyPAdapter extends RecyclerView.Adapter<QuanLyPAdapter.viewholder>{

    private final Context context;
    private final ArrayList<QuanLyP> list;
    QuanLyPDAO quanLyPDAO;

    public QuanLyPAdapter(Context context, ArrayList<QuanLyP> list) {
        this.context = context;
        this.list = list;
        quanLyPDAO = new QuanLyPDAO(context);
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_qlp, null);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        holder.txtsophong.setText("Số Phòng"+String.valueOf(list.get(position).getSophongQLP()));
        holder.txtten_qlp.setText("Tên kh: "+list.get(position).getTenQLP());
        holder.txtsogio_qlp.setText("Giờ ở: "+String.valueOf(list.get(position).getSogioQLP()));
        holder.txtdongia_qlp.setText("Đơn Giá: "+String.valueOf(list.get(position).getDongiaQLP()));
        holder.txtdichvukh_qlp.setText("Dịch vụ sử dụng: "+String.valueOf(list.get(position).getDichvukhQLP()));
        holder.txttongtien_qlp.setText("Tổng Tiền: "+ (Double.valueOf(list.get(position).getDongiaQLP())+Double.valueOf(list.get(position).getDichvukhQLP())));
        holder.txtdatcoc_qlp.setText("Đặt cọc: "+String.valueOf(list.get(position).getDatcocQLP()));
        holder.txtkhachtra_qlp.setText("Khách Trả: "+String.valueOf(list.get(position).getKhachtra()));
        holder.txtinhoadon_qlp.setText(list.get(position).getInhoadonQLP());
    }

    @Override
    public int getItemCount() {
        if (list != null)
            return list.size();
        return 0;
    }

    public static class viewholder extends RecyclerView.ViewHolder {
        TextView txtsophong, txtten_qlp, txtsogio_qlp, txtdongia_qlp,txtdichvukh_qlp,txttongtien_qlp,txtdatcoc_qlp,txtkhachtra_qlp, txtinhoadon_qlp;



        public viewholder(@NonNull View itemView) {
            super(itemView);
            txtsophong = itemView.findViewById(R.id.txtsophong);
            txtten_qlp = itemView.findViewById(R.id.txttenQLP);
            txtsogio_qlp = itemView.findViewById(R.id.txtsogioQLP);
            txtdongia_qlp = itemView.findViewById(R.id.txtdongiaQLP);
            txtdichvukh_qlp = itemView.findViewById(R.id.txtdichvukhacQLP);
            txttongtien_qlp = itemView.findViewById(R.id.txttongtienQLP);
            txtdatcoc_qlp= itemView.findViewById(R.id.txtdatcocQLP);
            txtkhachtra_qlp = itemView.findViewById(R.id.txtkhachtraQLP);
            txtinhoadon_qlp = itemView.findViewById(R.id.txtinhoadonQLP);

        }
    }
}
