package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.internal.ads.zzcf;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzfq extends zzgn {
    private static zzgq<String> zzabc = new zzgq<>();
    private final Context zzaba;

    public zzfq(zzfc zzfc, String str, String str2, zzcf.zza.zzb zzb, int i, int i2, Context context) {
        super(zzfc, str, str2, zzb, i, 29);
        this.zzaba = context;
    }

    /* access modifiers changed from: protected */
    public final void zzcx() throws IllegalAccessException, InvocationTargetException {
        this.zzabg.zzaf(ExifInterface.LONGITUDE_EAST);
        AtomicReference<String> zzas = zzabc.zzas(this.zzaba.getPackageName());
        if (zzas.get() == null) {
            synchronized (zzas) {
                if (zzas.get() == null) {
                    zzas.set((String) this.zzabq.invoke((Object) null, new Object[]{this.zzaba}));
                }
            }
        }
        String str = zzas.get();
        synchronized (this.zzabg) {
            this.zzabg.zzaf(zzcy.zza(str.getBytes(), true));
        }
    }
}
