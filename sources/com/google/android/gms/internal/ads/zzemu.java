package com.google.android.gms.internal.ads;

import java.lang.reflect.Type;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
public enum zzemu {
    DOUBLE(0, zzemw.SCALAR, zzenp.DOUBLE),
    FLOAT(1, zzemw.SCALAR, zzenp.FLOAT),
    INT64(2, zzemw.SCALAR, zzenp.LONG),
    UINT64(3, zzemw.SCALAR, zzenp.LONG),
    INT32(4, zzemw.SCALAR, zzenp.INT),
    FIXED64(5, zzemw.SCALAR, zzenp.LONG),
    FIXED32(6, zzemw.SCALAR, zzenp.INT),
    BOOL(7, zzemw.SCALAR, zzenp.BOOLEAN),
    STRING(8, zzemw.SCALAR, zzenp.STRING),
    MESSAGE(9, zzemw.SCALAR, zzenp.MESSAGE),
    BYTES(10, zzemw.SCALAR, zzenp.BYTE_STRING),
    UINT32(11, zzemw.SCALAR, zzenp.INT),
    ENUM(12, zzemw.SCALAR, zzenp.ENUM),
    SFIXED32(13, zzemw.SCALAR, zzenp.INT),
    SFIXED64(14, zzemw.SCALAR, zzenp.LONG),
    SINT32(15, zzemw.SCALAR, zzenp.INT),
    SINT64(16, zzemw.SCALAR, zzenp.LONG),
    GROUP(17, zzemw.SCALAR, zzenp.MESSAGE),
    DOUBLE_LIST(18, zzemw.VECTOR, zzenp.DOUBLE),
    FLOAT_LIST(19, zzemw.VECTOR, zzenp.FLOAT),
    INT64_LIST(20, zzemw.VECTOR, zzenp.LONG),
    UINT64_LIST(21, zzemw.VECTOR, zzenp.LONG),
    INT32_LIST(22, zzemw.VECTOR, zzenp.INT),
    FIXED64_LIST(23, zzemw.VECTOR, zzenp.LONG),
    FIXED32_LIST(24, zzemw.VECTOR, zzenp.INT),
    BOOL_LIST(25, zzemw.VECTOR, zzenp.BOOLEAN),
    STRING_LIST(26, zzemw.VECTOR, zzenp.STRING),
    MESSAGE_LIST(27, zzemw.VECTOR, zzenp.MESSAGE),
    BYTES_LIST(28, zzemw.VECTOR, zzenp.BYTE_STRING),
    UINT32_LIST(29, zzemw.VECTOR, zzenp.INT),
    ENUM_LIST(30, zzemw.VECTOR, zzenp.ENUM),
    SFIXED32_LIST(31, zzemw.VECTOR, zzenp.INT),
    SFIXED64_LIST(32, zzemw.VECTOR, zzenp.LONG),
    SINT32_LIST(33, zzemw.VECTOR, zzenp.INT),
    SINT64_LIST(34, zzemw.VECTOR, zzenp.LONG),
    DOUBLE_LIST_PACKED(35, zzemw.PACKED_VECTOR, zzenp.DOUBLE),
    FLOAT_LIST_PACKED(36, zzemw.PACKED_VECTOR, zzenp.FLOAT),
    INT64_LIST_PACKED(37, zzemw.PACKED_VECTOR, zzenp.LONG),
    UINT64_LIST_PACKED(38, zzemw.PACKED_VECTOR, zzenp.LONG),
    INT32_LIST_PACKED(39, zzemw.PACKED_VECTOR, zzenp.INT),
    FIXED64_LIST_PACKED(40, zzemw.PACKED_VECTOR, zzenp.LONG),
    FIXED32_LIST_PACKED(41, zzemw.PACKED_VECTOR, zzenp.INT),
    BOOL_LIST_PACKED(42, zzemw.PACKED_VECTOR, zzenp.BOOLEAN),
    UINT32_LIST_PACKED(43, zzemw.PACKED_VECTOR, zzenp.INT),
    ENUM_LIST_PACKED(44, zzemw.PACKED_VECTOR, zzenp.ENUM),
    SFIXED32_LIST_PACKED(45, zzemw.PACKED_VECTOR, zzenp.INT),
    SFIXED64_LIST_PACKED(46, zzemw.PACKED_VECTOR, zzenp.LONG),
    SINT32_LIST_PACKED(47, zzemw.PACKED_VECTOR, zzenp.INT),
    SINT64_LIST_PACKED(48, zzemw.PACKED_VECTOR, zzenp.LONG),
    GROUP_LIST(49, zzemw.VECTOR, zzenp.MESSAGE),
    MAP(50, zzemw.MAP, zzenp.VOID);
    
    private static final zzemu[] zzisz = null;
    private static final Type[] zzita = null;

    /* renamed from: id */
    private final int f52595id;
    private final zzenp zzisv;
    private final zzemw zzisw;
    private final Class<?> zzisx;
    private final boolean zzisy;

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002d, code lost:
        r5 = com.google.android.gms.internal.ads.zzemx.zzitj[r6.ordinal()];
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private zzemu(int r4, com.google.android.gms.internal.ads.zzemw r5, com.google.android.gms.internal.ads.zzenp r6) {
        /*
            r1 = this;
            r1.<init>(r2, r3)
            r1.f52595id = r4
            r1.zzisw = r5
            r1.zzisv = r6
            int[] r2 = com.google.android.gms.internal.ads.zzemx.zziti
            int r3 = r5.ordinal()
            r2 = r2[r3]
            r3 = 2
            r4 = 1
            if (r2 == r4) goto L_0x0022
            if (r2 == r3) goto L_0x001b
            r2 = 0
            r1.zzisx = r2
            goto L_0x0028
        L_0x001b:
            java.lang.Class r2 = r6.zzbkj()
            r1.zzisx = r2
            goto L_0x0028
        L_0x0022:
            java.lang.Class r2 = r6.zzbkj()
            r1.zzisx = r2
        L_0x0028:
            r2 = 0
            com.google.android.gms.internal.ads.zzemw r0 = com.google.android.gms.internal.ads.zzemw.SCALAR
            if (r5 != r0) goto L_0x003d
            int[] r5 = com.google.android.gms.internal.ads.zzemx.zzitj
            int r6 = r6.ordinal()
            r5 = r5[r6]
            if (r5 == r4) goto L_0x003d
            if (r5 == r3) goto L_0x003d
            r3 = 3
            if (r5 == r3) goto L_0x003d
            goto L_0x003e
        L_0x003d:
            r4 = 0
        L_0x003e:
            r1.zzisy = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzemu.<init>(java.lang.String, int, int, com.google.android.gms.internal.ads.zzemw, com.google.android.gms.internal.ads.zzenp):void");
    }

    /* renamed from: id */
    public final int mo140188id() {
        return this.f52595id;
    }

    static {
        int i;
        zzita = new Type[0];
        zzemu[] values = values();
        zzisz = new zzemu[values.length];
        for (zzemu zzemu : values) {
            zzisz[zzemu.f52595id] = zzemu;
        }
    }
}
