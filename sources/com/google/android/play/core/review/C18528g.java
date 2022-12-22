package com.google.android.play.core.review;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.internal.C18432ag;
import com.google.android.play.core.tasks.C18619i;

/* renamed from: com.google.android.play.core.review.g */
final class C18528g extends C18527f<ReviewInfo> {
    C18528g(C18529h hVar, C18619i iVar) {
        super(hVar, new C18432ag("OnRequestInstallCallback"), iVar);
    }

    /* renamed from: a */
    public final void mo149077a(Bundle bundle) throws RemoteException {
        super.mo149077a(bundle);
        this.f53216b.mo149342b(ReviewInfo.m38019a((PendingIntent) bundle.get("confirmation_intent")));
    }
}
