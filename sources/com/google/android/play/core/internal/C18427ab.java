package com.google.android.play.core.internal;

import android.os.IBinder;
import android.os.IInterface;

/* renamed from: com.google.android.play.core.internal.ab */
public abstract class C18427ab extends C18502k implements C18428ac {
    /* renamed from: a */
    public static C18428ac m37745a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.play.core.inappreview.protocol.IInAppReviewService");
        return queryLocalInterface instanceof C18428ac ? (C18428ac) queryLocalInterface : new C18426aa(iBinder);
    }
}
