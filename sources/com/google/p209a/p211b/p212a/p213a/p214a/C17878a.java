package com.google.p209a.p211b.p212a.p213a.p214a;

import android.os.IBinder;
import android.os.IInterface;
import com.google.p209a.p210a.C17874a;

/* renamed from: com.google.a.b.a.a.a.a */
/* compiled from: IInstallService */
public abstract class C17878a extends C17874a implements C17879b {
    /* renamed from: a */
    public static C17879b m37324a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.play.core.install.protocol.IInstallService");
        if (queryLocalInterface instanceof C17879b) {
            return (C17879b) queryLocalInterface;
        }
        return new C17881d(iBinder);
    }
}
