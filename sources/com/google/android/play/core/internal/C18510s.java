package com.google.android.play.core.internal;

import android.os.IBinder;
import android.os.IInterface;

/* renamed from: com.google.android.play.core.internal.s */
public abstract class C18510s extends C18502k implements C18511t {
    /* renamed from: a */
    public static C18511t m37966a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.play.core.assetpacks.protocol.IAssetModuleService");
        return queryLocalInterface instanceof C18511t ? (C18511t) queryLocalInterface : new C18509r(iBinder);
    }
}
