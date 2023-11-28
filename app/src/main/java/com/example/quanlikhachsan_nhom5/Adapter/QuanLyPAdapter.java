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


        }
    }
}
