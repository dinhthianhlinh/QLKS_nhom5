package com.example.quanlikhachsan_nhom5.Adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quanlikhachsan_nhom5.R;
import com.example.quanlikhachsan_nhom5.dao.NguoiDungDao;
import com.example.quanlikhachsan_nhom5.dao.QuanLyPDAO;
import com.example.quanlikhachsan_nhom5.model.NguoiDung;
import com.example.quanlikhachsan_nhom5.model.QuanLyP;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DanhSachTKAdapter extends RecyclerView.Adapter<DanhSachTKAdapter.viewholder> {

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

        holder.btnDelete_DSTK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NguoiDung nd = list.get(position);
                delete(nd);

            }

        });

        holder.btnUpdate_DSTK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NguoiDung nd = list.get(position);
                update(nd);
            }
        });

    }


    @Override
    public int getItemCount() {
        if (list != null)
            return list.size();
        return 0;
    }

    public static class viewholder extends RecyclerView.ViewHolder {

        ImageView Img_DSTK;
        TextView txttaikhoan_DSTK, txtmatkhau_DSTK, txthoten_DSTK, txtsdt_DSTK, txtque_DSTK;

        ImageButton btnDelete_DSTK, btnUpdate_DSTK;

        public viewholder(@NonNull View itemView) {
            super(itemView);
            Img_DSTK = itemView.findViewById(R.id.img_Avata);
            txttaikhoan_DSTK = itemView.findViewById(R.id.txttentk_DSTK);
            txtmatkhau_DSTK = itemView.findViewById(R.id.txtmatkhau_DSTK);
            txthoten_DSTK = itemView.findViewById(R.id.txthovaten_DSTK);
            txtsdt_DSTK = itemView.findViewById(R.id.txtsdt_DSTK);
            txtque_DSTK = itemView.findViewById(R.id.txtquequan_DSTK);
            btnDelete_DSTK = itemView.findViewById(R.id.btnDelete_DSTK);
            btnUpdate_DSTK = itemView.findViewById(R.id.btnUpdate_DSTK);
        }
    }
    public void delete(NguoiDung nd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Delete");
        builder.setMessage("Do you want to delete");
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {

            }
        });
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                nguoiDungDao = new NguoiDungDao(context);
                nguoiDungDao.Delete(nd);
                list.remove(nd);
                notifyDataSetChanged();
            }
        });
        builder.show();

    }

    public void update(NguoiDung nd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        AlertDialog alertDialog = builder.create();
        View view = View.inflate(context, R.layout.itemupdate_dstk, null);
        alertDialog.setView(view);

        EditText edtaikhoan = view.findViewById(R.id.taikhoanUpdate_DSTK);
        EditText edmatkhau = view.findViewById(R.id.matkhauUpdate_DSTK);
        EditText edhoten = view.findViewById(R.id.hotenUpdate_DSTK);
        EditText edsdt = view.findViewById(R.id.sdtUpdate_DSTK);
        EditText edque = view.findViewById(R.id.queUpdate_DSTK);
        EditText edlinkAvata = view.findViewById(R.id.linkAvataUpdate_DSTK);

        edtaikhoan.setText(nd.getTendn().toString());
        edmatkhau.setText(nd.getMatkhau().toString());
        edhoten.setText(nd.getTennd().toString());
        edsdt.setText(nd.getSdt().toString());
        edque.setText(nd.getDiachi().toString());
        edlinkAvata.setText(nd.getLinkAvata().toString());
        Button btnupdate = view.findViewById(R.id.btnSua_DSTK);


        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nd.setTendn(edtaikhoan.getText().toString());
                nd.setMatkhau(edmatkhau.getText().toString());
                nd.setTennd(edhoten.getText().toString());
                nd.setSdt(edsdt.getText().toString());
                nd.setDiachi(edque.getText().toString());
                nd.setLinkAvata(edlinkAvata.getText().toString());

                nguoiDungDao = new NguoiDungDao(context);
                nguoiDungDao.CapNhatThongTin(nd);
                notifyDataSetChanged();
                alertDialog.dismiss();

            }
        });

        alertDialog.show();
    }
}
