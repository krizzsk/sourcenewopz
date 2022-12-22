package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.internal.ads.zzcf;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzfw extends zzgn {
    public zzfw(zzfc zzfc, String str, String str2, zzcf.zza.zzb zzb, int i, int i2) {
        super(zzfc, str, str2, zzb, i, 24);
    }

    public final Void zzcz() throws Exception {
        if (this.zzwh.isInitialized()) {
            return super.call();
        }
        if (!this.zzwh.zzcl()) {
            return null;
        }
        zzda();
        return null;
    }

    /* access modifiers changed from: protected */
    public final void zzcx() throws IllegalAccessException, InvocationTargetException {
        if (this.zzwh.zzcl()) {
            zzda();
            return;
        }
        synchronized (this.zzabg) {
            this.zzabg.zzak((String) this.zzabq.invoke((Object) null, new Object[]{this.zzwh.getContext()}));
        }
    }

    private final void zzda() {
        AdvertisingIdClient zzct = this.zzwh.zzct();
        if (zzct != null) {
            try {
                AdvertisingIdClient.Info info = zzct.getInfo();
                String zzaq = zzfh.zzaq(info.getId());
                if (zzaq != null) {
                    synchronized (this.zzabg) {
                        this.zzabg.zzak(zzaq);
                        this.zzabg.zzb(info.isLimitAdTrackingEnabled());
                        this.zzabg.zzb(zzcf.zza.zzc.DEVICE_IDENTIFIER_ANDROID_AD_ID);
                    }
                }
            } catch (IOException unused) {
            }
        }
    }

    public final /* synthetic */ Object call() throws Exception {
        return call();
    }
}
