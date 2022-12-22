package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzjh implements zzij {
    private int zzahy = -1;
    private int zzako = 0;
    private ByteBuffer zzalt = zzajm;
    private int zzamq = -1;
    private ByteBuffer zzamu = zzajm;
    private boolean zzamv;

    public final int zzfo() {
        return 2;
    }

    public final boolean zzb(int i, int i2, int i3) throws zzii {
        if (i3 != 3 && i3 != 2 && i3 != Integer.MIN_VALUE && i3 != 1073741824) {
            throw new zzii(i, i2, i3);
        } else if (this.zzamq == i && this.zzahy == i2 && this.zzako == i3) {
            return false;
        } else {
            this.zzamq = i;
            this.zzahy = i2;
            this.zzako = i3;
            if (i3 != 2) {
                return true;
            }
            this.zzamu = zzajm;
            return true;
        }
    }

    public final boolean isActive() {
        int i = this.zzako;
        return (i == 0 || i == 2) ? false : true;
    }

    public final int zzfn() {
        return this.zzahy;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0081 A[LOOP:2: B:23:0x0081->B:24:0x0083, LOOP_START, PHI: r0 
      PHI: (r0v2 int) = (r0v0 int), (r0v3 int) binds: [B:14:0x0041, B:24:0x0083] A[DONT_GENERATE, DONT_INLINE]] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzn(java.nio.ByteBuffer r8) {
        /*
            r7 = this;
            int r0 = r8.position()
            int r1 = r8.limit()
            int r2 = r1 - r0
            int r3 = r7.zzako
            r4 = 1073741824(0x40000000, float:2.0)
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = 3
            if (r3 == r5) goto L_0x0020
            if (r3 == r6) goto L_0x0021
            if (r3 != r4) goto L_0x001a
            int r2 = r2 / 2
            goto L_0x0023
        L_0x001a:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            r8.<init>()
            throw r8
        L_0x0020:
            int r2 = r2 / r6
        L_0x0021:
            int r2 = r2 << 1
        L_0x0023:
            java.nio.ByteBuffer r3 = r7.zzamu
            int r3 = r3.capacity()
            if (r3 >= r2) goto L_0x003a
            java.nio.ByteBuffer r2 = java.nio.ByteBuffer.allocateDirect(r2)
            java.nio.ByteOrder r3 = java.nio.ByteOrder.nativeOrder()
            java.nio.ByteBuffer r2 = r2.order(r3)
            r7.zzamu = r2
            goto L_0x003f
        L_0x003a:
            java.nio.ByteBuffer r2 = r7.zzamu
            r2.clear()
        L_0x003f:
            int r2 = r7.zzako
            if (r2 == r5) goto L_0x0081
            if (r2 == r6) goto L_0x0068
            if (r2 != r4) goto L_0x0062
        L_0x0047:
            if (r0 >= r1) goto L_0x009c
            java.nio.ByteBuffer r2 = r7.zzamu
            int r3 = r0 + 2
            byte r3 = r8.get(r3)
            r2.put(r3)
            java.nio.ByteBuffer r2 = r7.zzamu
            int r3 = r0 + 3
            byte r3 = r8.get(r3)
            r2.put(r3)
            int r0 = r0 + 4
            goto L_0x0047
        L_0x0062:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            r8.<init>()
            throw r8
        L_0x0068:
            if (r0 >= r1) goto L_0x009c
            java.nio.ByteBuffer r2 = r7.zzamu
            r3 = 0
            r2.put(r3)
            java.nio.ByteBuffer r2 = r7.zzamu
            byte r3 = r8.get(r0)
            r3 = r3 & 255(0xff, float:3.57E-43)
            int r3 = r3 + -128
            byte r3 = (byte) r3
            r2.put(r3)
            int r0 = r0 + 1
            goto L_0x0068
        L_0x0081:
            if (r0 >= r1) goto L_0x009c
            java.nio.ByteBuffer r2 = r7.zzamu
            int r3 = r0 + 1
            byte r3 = r8.get(r3)
            r2.put(r3)
            java.nio.ByteBuffer r2 = r7.zzamu
            int r3 = r0 + 2
            byte r3 = r8.get(r3)
            r2.put(r3)
            int r0 = r0 + 3
            goto L_0x0081
        L_0x009c:
            int r0 = r8.limit()
            r8.position(r0)
            java.nio.ByteBuffer r8 = r7.zzamu
            r8.flip()
            java.nio.ByteBuffer r8 = r7.zzamu
            r7.zzalt = r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzjh.zzn(java.nio.ByteBuffer):void");
    }

    public final void zzfp() {
        this.zzamv = true;
    }

    public final ByteBuffer zzfq() {
        ByteBuffer byteBuffer = this.zzalt;
        this.zzalt = zzajm;
        return byteBuffer;
    }

    public final boolean zzfi() {
        return this.zzamv && this.zzalt == zzajm;
    }

    public final void flush() {
        this.zzalt = zzajm;
        this.zzamv = false;
    }

    public final void reset() {
        flush();
        this.zzamu = zzajm;
        this.zzamq = -1;
        this.zzahy = -1;
        this.zzako = 0;
    }
}
