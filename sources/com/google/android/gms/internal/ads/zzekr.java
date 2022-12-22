package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.crypto.Mac;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzekr extends ThreadLocal<Mac> {
    private final /* synthetic */ zzeko zziob;

    zzekr(zzeko zzeko) {
        this.zziob = zzeko;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzbgr */
    public final Mac initialValue() {
        try {
            Mac zzhx = zzekd.zzink.zzhx(this.zziob.zzinu);
            zzhx.init(this.zziob.zzinv);
            return zzhx;
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException(e);
        }
    }
}
