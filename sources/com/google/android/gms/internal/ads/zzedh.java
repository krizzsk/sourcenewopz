package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzedh implements Comparable<zzedh> {
    private final byte[] zziey;

    private zzedh(byte[] bArr) {
        this.zziey = Arrays.copyOf(bArr, bArr.length);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.zziey);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzedh)) {
            return false;
        }
        return Arrays.equals(this.zziey, ((zzedh) obj).zziey);
    }

    public final String toString() {
        byte[] bArr = this.zziey;
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            byte b2 = b & 255;
            sb.append("0123456789abcdef".charAt(b2 / 16));
            sb.append("0123456789abcdef".charAt(b2 % 16));
        }
        return sb.toString();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ int compareTo(java.lang.Object r7) {
        /*
            r6 = this;
            com.google.android.gms.internal.ads.zzedh r7 = (com.google.android.gms.internal.ads.zzedh) r7
            byte[] r0 = r6.zziey
            int r1 = r0.length
            byte[] r2 = r7.zziey
            int r3 = r2.length
            if (r1 == r3) goto L_0x000e
            int r7 = r0.length
            int r0 = r2.length
        L_0x000c:
            int r7 = r7 - r0
            return r7
        L_0x000e:
            r0 = 0
            r1 = 0
        L_0x0010:
            byte[] r2 = r6.zziey
            int r3 = r2.length
            if (r1 >= r3) goto L_0x0025
            byte r3 = r2[r1]
            byte[] r4 = r7.zziey
            byte r5 = r4[r1]
            if (r3 == r5) goto L_0x0022
            byte r7 = r2[r1]
            byte r0 = r4[r1]
            goto L_0x000c
        L_0x0022:
            int r1 = r1 + 1
            goto L_0x0010
        L_0x0025:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzedh.compareTo(java.lang.Object):int");
    }
}
