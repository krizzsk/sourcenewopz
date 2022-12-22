package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import com.didi.sdk.apm.SystemUtils;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.ParametersAreNonnullByDefault;
import p242io.socket.engineio.parser.Packet;

@Deprecated
@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzabx {
    private Context context;
    private File file;
    private String zzbrz;
    private String zzdbu;
    private BlockingQueue<zzach> zzdbx = new ArrayBlockingQueue(100);
    private LinkedHashMap<String, String> zzdby = new LinkedHashMap<>();
    private Map<String, zzacb> zzdbz = new HashMap();
    private final HashSet<String> zzdca = new HashSet<>(Arrays.asList(new String[]{Packet.NOOP, "activeViewPingSent", "viewabilityChanged", "visibilityChanged"}));
    private AtomicBoolean zzdcb;

    public final void zza(Context context2, String str, String str2, Map<String, String> map) {
        File externalStorageDirectory;
        this.context = context2;
        this.zzbrz = str;
        this.zzdbu = str2;
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.zzdcb = atomicBoolean;
        atomicBoolean.set(zzadj.zzdeo.get().booleanValue());
        if (this.zzdcb.get() && (externalStorageDirectory = SystemUtils.getExternalStorageDirectory()) != null) {
            this.file = new File(externalStorageDirectory, "sdk_csi_data.txt");
        }
        for (Map.Entry next : map.entrySet()) {
            this.zzdby.put((String) next.getKey(), (String) next.getValue());
        }
        zzbat.zzeke.execute(new zzabw(this));
        this.zzdbz.put("action", zzacb.zzdcd);
        this.zzdbz.put(FirebaseAnalytics.Param.AD_FORMAT, zzacb.zzdcd);
        this.zzdbz.put("e", zzacb.zzdce);
    }

    public final boolean zza(zzach zzach) {
        return this.zzdbx.offer(zzach);
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x00a8 A[SYNTHETIC, Splitter:B:38:0x00a8] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00b3 A[SYNTHETIC, Splitter:B:43:0x00b3] */
    /* JADX WARNING: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zza(java.util.Map<java.lang.String, java.lang.String> r5, com.google.android.gms.internal.ads.zzacg r6) {
        /*
            r4 = this;
            java.lang.String r0 = "CsiReporter: Cannot close file: sdk_csi_data.txt."
            java.lang.String r1 = r4.zzdbu
            android.net.Uri r1 = android.net.Uri.parse(r1)
            android.net.Uri$Builder r1 = r1.buildUpon()
            java.util.Set r5 = r5.entrySet()
            java.util.Iterator r5 = r5.iterator()
        L_0x0014:
            boolean r2 = r5.hasNext()
            if (r2 == 0) goto L_0x0030
            java.lang.Object r2 = r5.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r3 = r2.getKey()
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r2 = r2.getValue()
            java.lang.String r2 = (java.lang.String) r2
            r1.appendQueryParameter(r3, r2)
            goto L_0x0014
        L_0x0030:
            android.net.Uri r5 = r1.build()
            java.lang.String r5 = r5.toString()
            if (r6 != 0) goto L_0x003b
            goto L_0x0070
        L_0x003b:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r5)
            java.lang.String r5 = r6.zzsu()
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L_0x0056
            java.lang.String r5 = "&it="
            r1.append(r5)
            java.lang.String r5 = r6.zzsu()
            r1.append(r5)
        L_0x0056:
            java.lang.String r5 = r6.zzsv()
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L_0x006c
            java.lang.String r5 = "&blat="
            r1.append(r5)
            java.lang.String r5 = r6.zzsv()
            r1.append(r5)
        L_0x006c:
            java.lang.String r5 = r1.toString()
        L_0x0070:
            java.util.concurrent.atomic.AtomicBoolean r6 = r4.zzdcb
            boolean r6 = r6.get()
            if (r6 == 0) goto L_0x00c2
            java.io.File r6 = r4.file
            if (r6 == 0) goto L_0x00bc
            r1 = 0
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x00a0 }
            r3 = 1
            r2.<init>(r6, r3)     // Catch:{ IOException -> 0x00a0 }
            byte[] r5 = r5.getBytes()     // Catch:{ IOException -> 0x009b, all -> 0x0098 }
            r2.write(r5)     // Catch:{ IOException -> 0x009b, all -> 0x0098 }
            r5 = 10
            r2.write(r5)     // Catch:{ IOException -> 0x009b, all -> 0x0098 }
            r2.close()     // Catch:{ IOException -> 0x0093 }
            return
        L_0x0093:
            r5 = move-exception
            com.google.android.gms.ads.internal.util.zzd.zzd(r0, r5)
            return
        L_0x0098:
            r5 = move-exception
            r1 = r2
            goto L_0x00b1
        L_0x009b:
            r5 = move-exception
            r1 = r2
            goto L_0x00a1
        L_0x009e:
            r5 = move-exception
            goto L_0x00b1
        L_0x00a0:
            r5 = move-exception
        L_0x00a1:
            java.lang.String r6 = "CsiReporter: Cannot write to file: sdk_csi_data.txt."
            com.google.android.gms.ads.internal.util.zzd.zzd(r6, r5)     // Catch:{ all -> 0x009e }
            if (r1 == 0) goto L_0x00b0
            r1.close()     // Catch:{ IOException -> 0x00ac }
            goto L_0x00b0
        L_0x00ac:
            r5 = move-exception
            com.google.android.gms.ads.internal.util.zzd.zzd(r0, r5)
        L_0x00b0:
            return
        L_0x00b1:
            if (r1 == 0) goto L_0x00bb
            r1.close()     // Catch:{ IOException -> 0x00b7 }
            goto L_0x00bb
        L_0x00b7:
            r6 = move-exception
            com.google.android.gms.ads.internal.util.zzd.zzd(r0, r6)
        L_0x00bb:
            throw r5
        L_0x00bc:
            java.lang.String r5 = "CsiReporter: File doesn't exists. Cannot write CSI data to file."
            com.google.android.gms.ads.internal.util.zzd.zzez(r5)
            return
        L_0x00c2:
            com.google.android.gms.ads.internal.zzr.zzkv()
            android.content.Context r6 = r4.context
            java.lang.String r0 = r4.zzbrz
            com.google.android.gms.ads.internal.util.zzj.zzb(r6, r0, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzabx.zza(java.util.Map, com.google.android.gms.internal.ads.zzacg):void");
    }

    /* access modifiers changed from: package-private */
    public final Map<String, String> zza(Map<String, String> map, Map<String, String> map2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        if (map2 == null) {
            return linkedHashMap;
        }
        for (Map.Entry next : map2.entrySet()) {
            String str = (String) next.getKey();
            String str2 = (String) linkedHashMap.get(str);
            linkedHashMap.put(str, zzcq(str).zzf(str2, (String) next.getValue()));
        }
        return linkedHashMap;
    }

    public final zzacb zzcq(String str) {
        zzacb zzacb = this.zzdbz.get(str);
        if (zzacb != null) {
            return zzacb;
        }
        return zzacb.zzdcc;
    }

    public final void zzcr(String str) {
        if (!this.zzdca.contains(str)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("sdkVersion", this.zzbrz);
            linkedHashMap.put("ue", str);
            zza(zza((Map<String, String>) this.zzdby, (Map<String, String>) linkedHashMap), (zzacg) null);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzsq() {
        while (true) {
            try {
                zzach take = this.zzdbx.take();
                zzacg zzsw = take.zzsw();
                if (zzsw != null && !TextUtils.isEmpty(zzsw.zzsu())) {
                    zza(zza((Map<String, String>) this.zzdby, take.zzsx()), zzsw);
                }
            } catch (InterruptedException e) {
                zzd.zzd("CsiReporter:reporter interrupted", e);
                return;
            }
        }
    }
}
