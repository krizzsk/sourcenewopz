package com.google.android.play.core.internal;

import android.os.IBinder;
import android.os.IInterface;

/* renamed from: com.google.android.play.core.internal.n */
public abstract class C18505n extends C18502k implements C18506o {
    /* renamed from: a */
    public static C18506o m37950a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.play.core.appupdate.protocol.IAppUpdateService");
        return queryLocalInterface instanceof C18506o ? (C18506o) queryLocalInterface : new C18504m(iBinder);
    }
}
