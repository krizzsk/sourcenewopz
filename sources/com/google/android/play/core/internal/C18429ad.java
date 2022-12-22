package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.google.android.play.core.internal.ad */
public abstract class C18429ad extends C18502k implements C18430ae {
    public C18429ad() {
        super("com.google.android.play.core.inappreview.protocol.IInAppReviewServiceCallback");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean mo149076a(int i, Parcel parcel) throws RemoteException {
        if (i != 2) {
            return false;
        }
        mo149077a((Bundle) C18503l.m37945a(parcel, Bundle.CREATOR));
        return true;
    }
}
