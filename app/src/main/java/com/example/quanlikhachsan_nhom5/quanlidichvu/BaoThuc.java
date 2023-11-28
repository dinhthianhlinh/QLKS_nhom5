package com.example.quanlikhachsan_nhom5.quanlidichvu;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.quanlikhachsan_nhom5.R;
import com.example.quanlikhachsan_nhom5.baothuc.AlarmReceiver;

import org.w3c.dom.Text;

import java.util.Calendar;

public class BaoThuc extends AppCompatActivity {
    Button btndunglai, btndath;
    TextView txth;
    TimePicker timePicker;
    Calendar calendar;
    AlarmManager alarmManager;

    PendingIntent pendingIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bao_thuc);


        btndath = (Button)findViewById(R.id.dath);
        btndunglai = (Button)findViewById(R.id.dunglai);
        txth = (TextView)findViewById(R.id.txth);
        timePicker = (TimePicker)findViewById(R.id.timepicker);

        calendar = Calendar.getInstance();
        alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);

        Intent intent = new Intent(BaoThuc.this,AlarmReceiver.class);
        btndunglai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txth.setText("Dừng Lại");
                pendingIntent.cancel();
            }
        });
        btndath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendar.set(Calendar.HOUR_OF_DAY,timePicker.getCurrentHour());
                calendar.set(Calendar.MINUTE,timePicker.getCurrentMinute());


                int gio = timePicker.getCurrentHour();
                int phut = timePicker.getCurrentMinute();

                String string_gio = String.valueOf(gio);
                String string_phut = String.valueOf(phut);


                if (gio > 12){
                    string_gio = String.valueOf(gio - 12);
                }
                if (phut < 10){
                    string_phut = "0" + String.valueOf(phut);
                }
                pendingIntent = PendingIntent.getBroadcast(
                        BaoThuc.this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT
                );
                alarmManager.set(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),pendingIntent);


                txth.setText("Đặt GIỜ"+ string_gio + ":" + string_phut);

            }
        });

    }
}