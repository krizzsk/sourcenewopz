package com.google.android.play.core.appupdate;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.google.android.play.core.tasks.C18619i;

/* renamed from: com.google.android.play.core.appupdate.c */
final class C18267c extends ResultReceiver {

    /* renamed from: a */
    final /* synthetic */ C18619i f52620a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C18267c(Handler handler, C18619i iVar) {
        super(handler);
        this.f52620a = iVar;
    }

    public final void onReceiveResult(int i, Bundle bundle) {
        C18619i iVar;
        int i2 = 1;
        if (i == 1) {
            iVar = this.f52620a;
            i2 = -1;
        } else if (i != 2) {
            iVar = this.f52620a;
        } else {
            iVar = this.f52620a;
            i2 = 0;
        }
        iVar.mo149342b(Integer.valueOf(i2));
    }
}
