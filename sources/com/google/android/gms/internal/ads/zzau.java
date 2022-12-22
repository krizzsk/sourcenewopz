package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public class zzau implements zzu {
    @Deprecated
    private final zzbe zzce;
    private final zzar zzcf;
    private final zzat zzcg;

    public zzau(zzar zzar) {
        this(zzar, new zzat(4096));
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [com.google.android.gms.internal.ads.zzbe, com.google.android.gms.internal.ads.zzar] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private zzau(com.google.android.gms.internal.ads.zzar r1, com.google.android.gms.internal.ads.zzat r2) {
        /*
            r0 = this;
            r0.<init>()
            r0.zzcf = r1
            r0.zzce = r1
            r0.zzcg = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzau.<init>(com.google.android.gms.internal.ads.zzar, com.google.android.gms.internal.ads.zzat):void");
    }

    public zzz zza(zzab<?> zzab) throws zzap {
        byte[] bArr;
        zzbb zzbb;
        IOException iOException;
        Map map;
        zzbb zza;
        int statusCode;
        List<zzv> zzq;
        zzab<?> zzab2 = zzab;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        while (true) {
            Collections.emptyList();
            try {
                zzn zzf = zzab.zzf();
                if (zzf == null) {
                    map = Collections.emptyMap();
                } else {
                    HashMap hashMap = new HashMap();
                    if (zzf.zzr != null) {
                        hashMap.put(HttpHeaders.IF_NONE_MATCH, zzf.zzr);
                    }
                    if (zzf.zzt > 0) {
                        hashMap.put(HttpHeaders.IF_MODIFIED_SINCE, zzbc.zzb(zzf.zzt));
                    }
                    map = hashMap;
                }
                zza = this.zzcf.zza(zzab2, map);
                try {
                    statusCode = zza.getStatusCode();
                    zzq = zza.zzq();
                    break;
                } catch (IOException e) {
                    bArr = null;
                    zzbb = zza;
                    iOException = e;
                }
            } catch (IOException e2) {
                iOException = e2;
                zzbb = null;
                bArr = null;
            }
            zzbi.zza(zzab, iOException, elapsedRealtime, zzbb, bArr);
        }
        if (statusCode == 304) {
            long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
            zzn zzf2 = zzab.zzf();
            if (zzf2 == null) {
                return new zzz(304, (byte[]) null, true, elapsedRealtime2, zzq);
            }
            TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
            if (!zzq.isEmpty()) {
                for (zzv name : zzq) {
                    treeSet.add(name.getName());
                }
            }
            ArrayList arrayList = new ArrayList(zzq);
            if (zzf2.zzx != null) {
                if (!zzf2.zzx.isEmpty()) {
                    for (zzv next : zzf2.zzx) {
                        if (!treeSet.contains(next.getName())) {
                            arrayList.add(next);
                        }
                    }
                }
            } else if (!zzf2.zzw.isEmpty()) {
                for (Map.Entry next2 : zzf2.zzw.entrySet()) {
                    if (!treeSet.contains(next2.getKey())) {
                        arrayList.add(new zzv((String) next2.getKey(), (String) next2.getValue()));
                    }
                }
            }
            return new zzz(304, zzf2.data, true, elapsedRealtime2, (List<zzv>) arrayList);
        }
        InputStream content = zza.getContent();
        byte[] zza2 = content != null ? zzbi.zza(content, zza.getContentLength(), this.zzcg) : new byte[0];
        long elapsedRealtime3 = SystemClock.elapsedRealtime() - elapsedRealtime;
        if (zzao.DEBUG || elapsedRealtime3 > 3000) {
            Object[] objArr = new Object[5];
            objArr[0] = zzab2;
            objArr[1] = Long.valueOf(elapsedRealtime3);
            objArr[2] = zza2 != null ? Integer.valueOf(zza2.length) : "null";
            objArr[3] = Integer.valueOf(statusCode);
            objArr[4] = Integer.valueOf(zzab.zzj().zzc());
            zzao.m37365d("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", objArr);
        }
        if (statusCode < 200 || statusCode > 299) {
            throw new IOException();
        }
        return new zzz(statusCode, zza2, false, SystemClock.elapsedRealtime() - elapsedRealtime, zzq);
    }
}
