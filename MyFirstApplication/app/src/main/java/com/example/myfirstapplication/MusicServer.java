package com.example.myfirstapplication;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;
public class MusicServer extends Service {
    private MediaPlayer mp;
    public IBinder onBind(Intent intent) {
        Log.e("Service", "onBind被调用");
        mp.start();
        return null;
    }

    public void onCreate() {
        Log.e("Service", "onCreate被调用");
        mp = MediaPlayer.create(this, R.raw.love);
        super.onCreate();
    }

    public void onDestroy() {
        Log.e("Service", "onDestroy被调用");
        mp.stop();
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("Service", "onStartCommand被调用");
        mp.start();
        return super.onStartCommand(intent, flags, startId);
    }

    public boolean onUnbind(Intent intent) {
        Log.e("Service", "onUnbind被调用");
        mp.stop();
        return super.onUnbind(intent);
    }
}