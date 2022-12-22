package com.yanzhenjie.permission.bridge;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;

class Messenger extends BroadcastReceiver {

    /* renamed from: a */
    private static final String f56164a = "com.yanzhenjie.permission.bridge";

    /* renamed from: b */
    private final Context f56165b;

    /* renamed from: c */
    private final Callback f56166c;

    public interface Callback {
        void onCallback();
    }

    /* renamed from: a */
    public static void m40424a(Context context) {
        context.sendBroadcast(new Intent(f56164a));
    }

    public Messenger(Context context, Callback callback) {
        this.f56165b = context;
        this.f56166c = callback;
    }

    /* renamed from: a */
    public void mo169056a() {
        try {
            this.f56165b.registerReceiver(this, new IntentFilter(f56164a));
        } catch (Exception e) {
            Log.d("Context", "registerReceiver", e);
        }
    }

    /* renamed from: b */
    public void mo169057b() {
        try {
            this.f56165b.unregisterReceiver(this);
        } catch (Exception e) {
            Log.d("Context", "unregisterReceiver", e);
        }
    }

    public void onReceive(Context context, Intent intent) {
        this.f56166c.onCallback();
    }
}
