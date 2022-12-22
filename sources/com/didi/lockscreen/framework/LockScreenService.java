package com.didi.lockscreen.framework;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.util.Log;

public class LockScreenService extends Service {

    /* renamed from: a */
    private LockScreenReceiver f24401a;

    /* renamed from: b */
    private IntentFilter f24402b = new IntentFilter();

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        this.f24402b.addAction("android.intent.action.SCREEN_ON");
        this.f24402b.setPriority(Integer.MAX_VALUE);
        if (this.f24401a != null) {
            return 1;
        }
        this.f24401a = new LockScreenReceiver();
        this.f24402b.setPriority(Integer.MAX_VALUE);
        try {
            registerReceiver(this.f24401a, this.f24402b);
            return 1;
        } catch (Exception e) {
            Log.d("Context", "registerReceiver", e);
            return 1;
        }
    }

    public void onDestroy() {
        LockScreenReceiver lockScreenReceiver = this.f24401a;
        if (lockScreenReceiver != null) {
            try {
                unregisterReceiver(lockScreenReceiver);
            } catch (Exception e) {
                Log.d("Context", "unregisterReceiver", e);
            }
            this.f24401a = null;
        }
        super.onDestroy();
    }
}
