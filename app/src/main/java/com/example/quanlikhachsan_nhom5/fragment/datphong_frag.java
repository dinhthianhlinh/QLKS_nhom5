package com.example.quanlikhachsan_nhom5.fragment;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quanlikhachsan_nhom5.Adapter.DatPhongAdapter;
import com.example.quanlikhachsan_nhom5.R;
import com.example.quanlikhachsan_nhom5.dao.DatPhongDao;
import com.example.quanlikhachsan_nhom5.model.DatPhong;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class datphong_frag extends AppCompatActivity {
    private DatPhongAdapter datPhongAdapter;
    private DatPhongDao datPhongDao;
    private ArrayList<DatPhong> list;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datphong_frag);

        RecyclerView recyclerView = findViewById(R.id.Rcvdp);
        datPhongDao = new DatPhongDao(this);
        list = datPhongDao.getDSDatPhong();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        datPhongAdapter = new DatPhongAdapter(this, list);

        datPhongAdapter.setOnItemClickedListener(datPhong -> {
            Dialog dialog = new Dialog(this);
            dialog.setContentView(R.layout.dialog_qlp);
            EditText editTextRoomNumber = dialog.findViewById(R.id.editTextRoomNumber);

            EditText edtName = dialog.findViewById(R.id.edtName);
            EditText editTextPhone = dialog.findViewById(R.id.editTextPhone);
            EditText editTextEmail = dialog.findViewById(R.id.editTextEmail);
            EditText editTextNumPeople = dialog.findViewById(R.id.editTextNumPeople);
            TextView tvCheckIn = dialog.findViewById(R.id.tvCheckIn);
            TextView tvCheckOut = dialog.findViewById(R.id.tvCheckOut);
            TextView Sotienphaitra = dialog.findViewById(R.id.Sotienphaitra);
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

                // Xác định thông tin thanh toán
                String paymentInfo = "";
                int selectedPaymentMethod = radioGroupPayment.getCheckedRadioButtonId();
                if (selectedPaymentMethod == R.id.radioDirectPayment) {
                    paymentInfo = "thanh toán khi đến nơi";
                } else if (selectedPaymentMethod == R.id.radioOnlinePayment) {
                    paymentInfo = "bạn thanh toán thành công";
                }

                // Gửi dữ liệu sang qlphong_frag
                Intent intent = new Intent(datphong_frag.this, qlphong_frag.class);
                intent.putExtra("NAME", name);
                intent.putExtra("PHONE", phone);
                intent.putExtra("EMAIL", email);
                intent.putExtra("NUM_PEOPLE", numPeople);
                intent.putExtra("CHECK_IN", checkIn);
                intent.putExtra("CHECK_OUT", checkOut);
                intent.putExtra("TOTAL_AMOUNT", totalAmount);
                intent.putExtra("PAYMENT_INFO", paymentInfo);

                startActivity(intent);
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
    }

    private void openDialogNgayGio(Dialog parentDialog, String giaphong) {
        Dialog dialogNgayGio = new Dialog(this);
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
