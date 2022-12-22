package com.google.p217ar.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/* renamed from: com.google.ar.core.w */
/* compiled from: InstallServiceImpl */
final class C18679w extends BroadcastReceiver {

    /* renamed from: a */
    private final /* synthetic */ C18675s f53572a;

    /* renamed from: b */
    private final /* synthetic */ C18673p f53573b;

    C18679w(C18673p pVar, C18675s sVar) {
        this.f53573b = pVar;
        this.f53572a = sVar;
    }

    public final void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        Bundle extras = intent.getExtras();
        if ("com.google.android.play.core.install.ACTION_INSTALL_STATUS".equals(action) && extras != null && extras.containsKey("install.status")) {
            this.f53573b.m38313c();
            int i = extras.getInt("install.status");
            if (i == 1 || i == 2 || i == 3) {
                this.f53572a.mo149646a(C18672o.ACCEPTED);
            } else if (i == 4) {
                this.f53572a.mo149646a(C18672o.COMPLETED);
            } else if (i == 6) {
                this.f53572a.mo149646a(C18672o.CANCELLED);
            }
        }
    }
}
