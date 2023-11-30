package com.example.quanlikhachsan_nhom5.baothuc;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("Tôi trong Rsv", "xin chào ");
        Intent myIntent = new Intent(context, Music.class);
        context.startService(myIntent);
    }
}
