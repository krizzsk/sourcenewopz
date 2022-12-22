package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
public enum zzenp {
    VOID(Void.class, Void.class, (Class<?>) null),
    INT(Integer.TYPE, Integer.class, 0),
    LONG(Long.TYPE, Long.class, 0L),
    FLOAT(Float.TYPE, Float.class, Float.valueOf(0.0f)),
    DOUBLE(Double.TYPE, Double.class, Double.valueOf(0.0d)),
    BOOLEAN(Boolean.TYPE, Boolean.class, false),
    STRING(String.class, String.class, ""),
    BYTE_STRING(zzelq.class, zzelq.class, zzelq.zzipc),
    ENUM(Integer.TYPE, Integer.class, (Class<?>) null),
    MESSAGE(Object.class, Object.class, (Class<?>) null);
    
    private final Class<?> zziut;
    private final Class<?> zziuu;
    private final Object zziuv;

    private zzenp(Class<?> cls, Class<?> cls2, Object obj) {
        this.zziut = cls;
        this.zziuu = cls2;
        this.zziuv = obj;
    }

    public final Class<?> zzbkj() {
        return this.zziuu;
    }
}
