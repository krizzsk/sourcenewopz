package com.google.android.play.core.review;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.google.android.play.core.tasks.C18619i;

/* renamed from: com.google.android.play.core.review.b */
final class C18523b extends ResultReceiver {

    /* renamed from: a */
    final /* synthetic */ C18619i f53209a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C18523b(Handler handler, C18619i iVar) {
        super(handler);
        this.f53209a = iVar;
    }

    public final void onReceiveResult(int i, Bundle bundle) {
        this.f53209a.mo149342b(null);
    }
}
