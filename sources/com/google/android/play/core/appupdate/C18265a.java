package com.google.android.play.core.appupdate;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.play.core.install.InstallState;
import com.google.android.play.core.internal.C18432ag;
import com.google.android.play.core.listener.C18519b;

/* renamed from: com.google.android.play.core.appupdate.a */
public final class C18265a extends C18519b<InstallState> {
    public C18265a(Context context) {
        super(new C18432ag("AppUpdateListenerRegistry"), new IntentFilter("com.google.android.play.core.install.ACTION_INSTALL_STATUS"), context);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo148800a(Context context, Intent intent) {
        Intent intent2 = intent;
        if (!context.getPackageName().equals(intent2.getStringExtra("package.name"))) {
            this.f53193a.mo149081a("ListenerRegistryBroadcastReceiver received broadcast for third party app: %s", intent2.getStringExtra("package.name"));
            return;
        }
        this.f53193a.mo149081a("List of extras in received intent:", new Object[0]);
        for (String str : intent.getExtras().keySet()) {
            this.f53193a.mo149081a("Key: %s; value: %s", str, intent.getExtras().get(str));
        }
        C18432ag agVar = this.f53193a;
        agVar.mo149081a("List of extras in received intent needed by fromUpdateIntent:", new Object[0]);
        agVar.mo149081a("Key: %s; value: %s", "install.status", Integer.valueOf(intent2.getIntExtra("install.status", 0)));
        agVar.mo149081a("Key: %s; value: %s", "error.code", Integer.valueOf(intent2.getIntExtra("error.code", 0)));
        InstallState a = InstallState.m37742a(intent2.getIntExtra("install.status", 0), intent2.getLongExtra("bytes.downloaded", 0), intent2.getLongExtra("total.bytes.to.download", 0), intent2.getIntExtra("error.code", 0), intent2.getStringExtra("package.name"));
        this.f53193a.mo149081a("ListenerRegistryBroadcastReceiver.onReceive: %s", a);
        mo149189a(a);
    }
}
