package com.google.android.gms.internal.ads;

import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.internal.ads.zzcf;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzgc extends zzgn {
    private static final Object zzabf = new Object();
    private static volatile String zzabj;

    public zzgc(zzfc zzfc, String str, String str2, zzcf.zza.zzb zzb, int i, int i2) {
        super(zzfc, str, str2, zzb, i, 1);
    }

    /* access modifiers changed from: protected */
    public final void zzcx() throws IllegalAccessException, InvocationTargetException {
        this.zzabg.zzac(ExifInterface.LONGITUDE_EAST);
        if (zzabj == null) {
            synchronized (zzabf) {
                if (zzabj == null) {
                    zzabj = (String) this.zzabq.invoke((Object) null, new Object[0]);
                }
            }
        }
        synchronized (this.zzabg) {
            this.zzabg.zzac(zzabj);
        }
    }
}
