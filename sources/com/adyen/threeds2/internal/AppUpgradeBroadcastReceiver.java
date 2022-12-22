package com.adyen.threeds2.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import atd.p030k0.C1073b;
import atd.p046s0.C1172a;

public class AppUpgradeBroadcastReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (C1172a.m764a(-453331630).equals(intent.getAction()) && context.getPackageName().equals(intent.getPackage())) {
            C1398e.m1104a(context, C1073b.m488a()).mo14852c(context);
        }
    }
}
