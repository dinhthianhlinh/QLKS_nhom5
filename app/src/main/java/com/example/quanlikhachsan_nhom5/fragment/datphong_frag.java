package com.example.quanlikhachsan_nhom5.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quanlikhachsan_nhom5.Adapter.DatPhongAdapter;
import com.example.quanlikhachsan_nhom5.R;
import com.example.quanlikhachsan_nhom5.dao.DatPhongDao;
import com.example.quanlikhachsan_nhom5.dao.QuanLyPDAO;
import com.example.quanlikhachsan_nhom5.model.DatPhong;
import com.example.quanlikhachsan_nhom5.model.QuanLyP;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class datphong_frag extends Fragment {
    private DatPhongAdapter datPhongAdapter;
    private DatPhongDao datPhongDao;
    private ArrayList<DatPhong> list;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.datphong_frag,container,false);



        RecyclerView recyclerView = view.findViewById(R.id.Rcvdp);
        datPhongDao = new DatPhongDao(this.getContext());
        list = datPhongDao.getDSDatPhong();

        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        datPhongAdapter = new DatPhongAdapter(this.getContext(), list);


        datPhongAdapter.setOnItemClickedListener(datPhong -> {
            Dialog dialog = new Dialog(this.getContext());
            dialog.setContentView(R.layout.dialog_qlp);


            EditText edtName = dialog.findViewById(R.id.edtName);
            EditText editTextPhone = dialog.findViewById(R.id.editTextPhone);
            EditText editTextEmail = dialog.findViewById(R.id.editTextEmail);
            EditText editTextNumPeople = dialog.findViewById(R.id.editTextNumPeople);
            TextView tvCheckIn = dialog.findViewById(R.id.tvCheckIn);
            TextView tvCheckOut = dialog.findViewById(R.id.tvCheckOut);
            TextView Sotienphaitra = dialog.findViewById(R.id.Sotienphaitra);
            EditText editTextRoomNumber = dialog.findViewById(R.id.editTextRoomNumber);
            RadioGroup radioGroupPayment = dialog.findViewById(R.id.radioGroupPayment);
            Button btnBook = dialog.findViewById(R.id.btnBook);

            editTextRoomNumber.setText(datPhong.getSophong());

            // Khi người dùng nhấn nút btnBook
            btnBook.setOnClickListener(v -> {


                // Lấy dữ liệu từ các trường nhập
                String name = edtName.getText().toString();
                String phone = editTextPhone.getText().toString();
                String email = editTextEmail.getText().toString();
                String numPeople = editTextNumPeople.getText().toString();
                String checkIn = tvCheckIn.getText().toString();
                String checkOut = tvCheckOut.getText().toString();
                String totalAmount = Sotienphaitra.getText().toString();
                String roomNumber = editTextRoomNumber.getText().toString();


                // Xác định thông tin thanh toán
                String paymentInfo = "";
                int selectedPaymentMethod = radioGroupPayment.getCheckedRadioButtonId();
                if (selectedPaymentMethod == R.id.radioDirectPayment) {
                    paymentInfo = "thanh toán khi đến nơi";
                } else if (selectedPaymentMethod == R.id.radioOnlinePayment) {
                    paymentInfo = "bạn thanh toán thành công";
                }
                QuanLyP quanLyP = new QuanLyP(name, phone, email, numPeople, checkIn, checkOut, totalAmount, roomNumber, paymentInfo);
                QuanLyPDAO dao = new QuanLyPDAO(datphong_frag.this.getContext());
                dao.addQuanLyP(quanLyP);
                Toast.makeText(datphong_frag.this.getContext(), "Thêm thành công", Toast.LENGTH_SHORT).show();

                // Gửi dữ liệu sang qlphong_frag

                dialog.dismiss();
            });


            editTextRoomNumber.setText(datPhong.getSophong());

            Button chooseTimeButton = dialog.findViewById(R.id.choosetime);
            chooseTimeButton.setOnClickListener(v -> openDialogNgayGio(dialog, datPhong.getGiaphong()));

            Window window = dialog.getWindow();
            if (window != null) {
                WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
                layoutParams.copyFrom(window.getAttributes());
                layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
                layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
                window.setAttributes(layoutParams);
            }

            dialog.show();
        });

        recyclerView.setAdapter(datPhongAdapter);



        return view;
    }



    private void openDialogNgayGio(Dialog parentDialog, String giaphong) {
        Dialog dialogNgayGio = new Dialog(this.getContext());
        dialogNgayGio.setContentView(R.layout.dialog_ngaygio);

        // Cài đặt kích thước cho dialog
        Window window = dialogNgayGio.getWindow();
        if (window != null) {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.copyFrom(window.getAttributes());

            // Đặt kích thước dialog: rộng tối đa, cao tự động điều chỉnh
            layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
            layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;

            window.setAttributes(layoutParams);
        }

        RadioGroup radioGroup1 = dialogNgayGio.findViewById(R.id.radioGroup1);
        RadioGroup radioGroup2 = dialogNgayGio.findViewById(R.id.radioGroup2);
        Button applyButton = dialogNgayGio.findViewById(R.id.applyButton);

        applyButton.setOnClickListener(v -> {
            int hoursToAdd = 0;
            int selectedId1 = radioGroup1.getCheckedRadioButtonId();
            int selectedId2 = radioGroup2.getCheckedRadioButtonId();

            // Xử lý lựa chọn từ RadioGroup thứ nhất
            if (selectedId1 != -1) {
                if (selectedId1 == R.id.radioButton1Hours) {
                    hoursToAdd = 1;
                } else if (selectedId1 == R.id.radioButton2Hours) {
                    hoursToAdd = 2;
                } else if (selectedId1 == R.id.radioButton3Hours) {
                    hoursToAdd = 3;
                } else if (selectedId1 == R.id.radioButton4Hours) {
                    hoursToAdd = 4;
                } else if (selectedId1 == R.id.radioButton5Hours) {
                    hoursToAdd = 5;
                } // Thêm các trường hợp khác nếu cần
            }

            // Xử lý lựa chọn từ RadioGroup thứ hai
            else if (selectedId2 != -1) {
                if (selectedId2 == R.id.radioButton6Hours) {
                    hoursToAdd = 6;
                } else if (selectedId2 == R.id.radioButton7Hours) {
                    hoursToAdd = 7;
                } else if (selectedId2 == R.id.radioButtonOvernight) {
                    hoursToAdd = 8;
                } else if (selectedId2 == R.id.radioButtonDayRental) {
                    hoursToAdd = 24;
                } // Thêm các trường hợp khác nếu cần
            }

            TextView tvCheckIn = parentDialog.findViewById(R.id.tvCheckIn);
            TextView tvCheckOut = parentDialog.findViewById(R.id.tvCheckOut);
            Calendar checkInTime = Calendar.getInstance();
            Calendar checkOutTime = (Calendar) checkInTime.clone();
            checkOutTime.add(Calendar.HOUR, hoursToAdd);

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault());
            tvCheckIn.setText(dateFormat.format(checkInTime.getTime()));
            tvCheckOut.setText(dateFormat.format(checkOutTime.getTime()));

            TextView Sotienphaitra = parentDialog.findViewById(R.id.Sotienphaitra);
            int soTienPhaiTra = Integer.parseInt(giaphong) * hoursToAdd;
            Sotienphaitra.setText(String.valueOf(soTienPhaiTra));

            dialogNgayGio.dismiss();
        });

        dialogNgayGio.show();
    }
}
