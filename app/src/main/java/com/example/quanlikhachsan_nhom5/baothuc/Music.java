package com.example.quanlikhachsan_nhom5.baothuc;

import android.app.Service;
import android.content.Intent;
import android.media.MediaParser;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.quanlikhachsan_nhom5.R;

public class Music extends Service {

    MediaParser mediaParser;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.e("TÔI TRONG MISIC","HELLO");
        return START_NOT_STICKY;
    }
}
