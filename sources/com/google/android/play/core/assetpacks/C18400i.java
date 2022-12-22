package com.google.android.play.core.assetpacks;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.google.android.play.core.tasks.C18619i;

/* renamed from: com.google.android.play.core.assetpacks.i */
final class C18400i extends ResultReceiver {

    /* renamed from: a */
    final /* synthetic */ C18619i f53075a;

    /* renamed from: b */
    final /* synthetic */ C18401j f53076b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C18400i(C18401j jVar, Handler handler, C18619i iVar) {
        super(handler);
        this.f53076b = jVar;
        this.f53075a = iVar;
    }

    public final void onReceiveResult(int i, Bundle bundle) {
        if (i == 1) {
            this.f53075a.mo149342b(-1);
            this.f53076b.f53084h.mo148961a((PendingIntent) null);
        } else if (i != 2) {
            this.f53075a.mo149341b((Exception) new AssetPackException(-100));
        } else {
            this.f53075a.mo149342b(0);
        }
    }
}
