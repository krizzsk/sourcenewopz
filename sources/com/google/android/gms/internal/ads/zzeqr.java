package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
public enum zzeqr {
    DOUBLE(zzequ.DOUBLE, 1),
    FLOAT(zzequ.FLOAT, 5),
    INT64(zzequ.LONG, 0),
    UINT64(zzequ.LONG, 0),
    INT32(zzequ.INT, 0),
    FIXED64(zzequ.LONG, 1),
    FIXED32(zzequ.INT, 5),
    BOOL(zzequ.BOOLEAN, 0),
    STRING(zzequ.STRING, 2),
    GROUP(zzequ.MESSAGE, 3),
    MESSAGE(zzequ.MESSAGE, 2),
    BYTES(zzequ.BYTE_STRING, 2),
    UINT32(zzequ.INT, 0),
    ENUM(zzequ.ENUM, 0),
    SFIXED32(zzequ.INT, 5),
    SFIXED64(zzequ.LONG, 1),
    SINT32(zzequ.INT, 0),
    SINT64(zzequ.LONG, 0);
    
    private final zzequ zzizx;
    private final int zzizy;

    private zzeqr(zzequ zzequ, int i) {
        this.zzizx = zzequ;
        this.zzizy = i;
    }

    public final zzequ zzbmh() {
        return this.zzizx;
    }

    public final int zzbmi() {
        return this.zzizy;
    }
}
