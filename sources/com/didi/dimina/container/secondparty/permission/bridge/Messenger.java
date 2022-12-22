package com.didi.dimina.container.secondparty.permission.bridge;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;

class Messenger extends BroadcastReceiver {

    /* renamed from: a */
    private static final String f17341a = "com.didi.dimina.container.secondparty.permission.bridge";

    /* renamed from: b */
    private final Context f17342b;

    /* renamed from: c */
    private final Callback f17343c;

    public interface Callback {
        void onCallback();
    }

    /* renamed from: a */
    public static void m12883a(Context context) {
        context.sendBroadcast(new Intent(f17341a));
    }

    public Messenger(Context context, Callback callback) {
        this.f17342b = context;
        this.f17343c = callback;
    }

    /* renamed from: a */
    public void mo55886a() {
        try {
            this.f17342b.registerReceiver(this, new IntentFilter(f17341a));
        } catch (Exception e) {
            Log.d("Context", "registerReceiver", e);
        }
    }

    /* renamed from: b */
    public void mo55887b() {
        try {
            this.f17342b.unregisterReceiver(this);
        } catch (Exception e) {
            Log.d("Context", "unregisterReceiver", e);
        }
    }

    public void onReceive(Context context, Intent intent) {
        this.f17343c.onCallback();
    }
}
