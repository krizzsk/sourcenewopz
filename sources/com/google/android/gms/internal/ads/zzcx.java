package com.google.android.gms.internal.ads;

import androidx.exifinterface.media.ExifInterface;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcx extends zzcw<Integer, Object> {
    public String zzns;
    public long zznt;
    public String zznu;
    public String zznv;
    public String zznw;

    public zzcx(String str) {
        this();
        zzam(str);
    }

    public zzcx() {
        this.zzns = ExifInterface.LONGITUDE_EAST;
        this.zznt = -1;
        this.zznu = ExifInterface.LONGITUDE_EAST;
        this.zznv = ExifInterface.LONGITUDE_EAST;
        this.zznw = ExifInterface.LONGITUDE_EAST;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.lang.String} */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzam(java.lang.String r4) {
        /*
            r3 = this;
            java.util.HashMap r4 = zzan(r4)
            if (r4 == 0) goto L_0x008a
            r0 = 0
            java.lang.Integer r1 = java.lang.Integer.valueOf(r0)
            java.lang.Object r1 = r4.get(r1)
            java.lang.String r2 = "E"
            if (r1 != 0) goto L_0x0015
            r0 = r2
            goto L_0x001f
        L_0x0015:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.Object r0 = r4.get(r0)
            java.lang.String r0 = (java.lang.String) r0
        L_0x001f:
            r3.zzns = r0
            r0 = 1
            java.lang.Integer r1 = java.lang.Integer.valueOf(r0)
            java.lang.Object r1 = r4.get(r1)
            if (r1 != 0) goto L_0x002f
            r0 = -1
            goto L_0x003d
        L_0x002f:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.Object r0 = r4.get(r0)
            java.lang.Long r0 = (java.lang.Long) r0
            long r0 = r0.longValue()
        L_0x003d:
            r3.zznt = r0
            r0 = 2
            java.lang.Integer r1 = java.lang.Integer.valueOf(r0)
            java.lang.Object r1 = r4.get(r1)
            if (r1 != 0) goto L_0x004c
            r0 = r2
            goto L_0x0056
        L_0x004c:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.Object r0 = r4.get(r0)
            java.lang.String r0 = (java.lang.String) r0
        L_0x0056:
            r3.zznu = r0
            r0 = 3
            java.lang.Integer r1 = java.lang.Integer.valueOf(r0)
            java.lang.Object r1 = r4.get(r1)
            if (r1 != 0) goto L_0x0065
            r0 = r2
            goto L_0x006f
        L_0x0065:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.Object r0 = r4.get(r0)
            java.lang.String r0 = (java.lang.String) r0
        L_0x006f:
            r3.zznv = r0
            r0 = 4
            java.lang.Integer r1 = java.lang.Integer.valueOf(r0)
            java.lang.Object r1 = r4.get(r1)
            if (r1 != 0) goto L_0x007d
            goto L_0x0088
        L_0x007d:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.Object r4 = r4.get(r0)
            r2 = r4
            java.lang.String r2 = (java.lang.String) r2
        L_0x0088:
            r3.zznw = r2
        L_0x008a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcx.zzam(java.lang.String):void");
    }

    /* access modifiers changed from: protected */
    public final HashMap<Integer, Object> zzbo() {
        HashMap<Integer, Object> hashMap = new HashMap<>();
        hashMap.put(0, this.zzns);
        hashMap.put(4, this.zznw);
        hashMap.put(3, this.zznv);
        hashMap.put(2, this.zznu);
        hashMap.put(1, Long.valueOf(this.zznt));
        return hashMap;
    }
}
