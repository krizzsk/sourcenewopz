package com.google.android.play.core.internal;

import android.os.IBinder;
import android.os.IInterface;

/* renamed from: com.google.android.play.core.internal.bu */
public abstract class C18473bu extends C18502k implements C18474bv {
    /* renamed from: a */
    public static C18474bv m37868a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.play.core.splitinstall.protocol.ISplitInstallService");
        return queryLocalInterface instanceof C18474bv ? (C18474bv) queryLocalInterface : new C18472bt(iBinder);
    }
}
