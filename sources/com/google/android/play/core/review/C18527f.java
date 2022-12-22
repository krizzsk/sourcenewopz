package com.google.android.play.core.review;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.internal.C18429ad;
import com.google.android.play.core.internal.C18432ag;
import com.google.android.play.core.tasks.C18619i;

/* renamed from: com.google.android.play.core.review.f */
class C18527f<T> extends C18429ad {

    /* renamed from: a */
    final C18432ag f53215a;

    /* renamed from: b */
    final C18619i<T> f53216b;

    /* renamed from: c */
    final /* synthetic */ C18529h f53217c;

    C18527f(C18529h hVar, C18432ag agVar, C18619i<T> iVar) {
        this.f53217c = hVar;
        this.f53215a = agVar;
        this.f53216b = iVar;
    }

    /* renamed from: a */
    public void mo149077a(Bundle bundle) throws RemoteException {
        this.f53217c.f53219a.mo149092a();
        this.f53215a.mo149084c("onGetLaunchReviewFlowInfo", new Object[0]);
    }
}
