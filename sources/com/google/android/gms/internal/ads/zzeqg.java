package com.google.android.gms.internal.ads;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
final class zzeqg {
    private static final Unsafe zzicl = zzbmd();
    private static final Class<?> zziot = zzelj.zzbhc();
    private static final boolean zziqf = zzbme();
    private static final boolean zziyi = zzo(Long.TYPE);
    private static final boolean zziyj = zzo(Integer.TYPE);
    private static final zzd zziyk;
    private static final boolean zziyl = zzbmf();
    private static final long zziym = ((long) zzm(byte[].class));
    private static final long zziyn;
    private static final long zziyo;
    private static final long zziyp;
    private static final long zziyq;
    private static final long zziyr;
    private static final long zziys;
    private static final long zziyt;
    private static final long zziyu;
    private static final long zziyv;
    private static final long zziyw;
    private static final long zziyx = ((long) zzm(Object[].class));
    private static final long zziyy = ((long) zzn(Object[].class));
    private static final long zziyz;
    private static final int zziza = ((int) (zziym & 7));
    static final boolean zzizb = (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN);

    private zzeqg() {
    }

    /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
    private static final class zza extends zzd {
        zza(Unsafe unsafe) {
            super(unsafe);
        }

        public final byte zzy(Object obj, long j) {
            if (zzeqg.zzizb) {
                return zzeqg.zzq(obj, j);
            }
            return zzeqg.zzr(obj, j);
        }

        public final void zze(Object obj, long j, byte b) {
            if (zzeqg.zzizb) {
                zzeqg.zza(obj, j, b);
            } else {
                zzeqg.zzb(obj, j, b);
            }
        }

        public final boolean zzm(Object obj, long j) {
            if (zzeqg.zzizb) {
                return zzeqg.zzs(obj, j);
            }
            return zzeqg.zzt(obj, j);
        }

        public final void zza(Object obj, long j, boolean z) {
            if (zzeqg.zzizb) {
                zzeqg.zzb(obj, j, z);
            } else {
                zzeqg.zzc(obj, j, z);
            }
        }

        public final float zzn(Object obj, long j) {
            return Float.intBitsToFloat(zzk(obj, j));
        }

        public final void zza(Object obj, long j, float f) {
            zzb(obj, j, Float.floatToIntBits(f));
        }

        public final double zzo(Object obj, long j) {
            return Double.longBitsToDouble(zzl(obj, j));
        }

        public final void zza(Object obj, long j, double d) {
            zza(obj, j, Double.doubleToLongBits(d));
        }
    }

    /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
    private static final class zzb extends zzd {
        zzb(Unsafe unsafe) {
            super(unsafe);
        }

        public final byte zzy(Object obj, long j) {
            return this.zzize.getByte(obj, j);
        }

        public final void zze(Object obj, long j, byte b) {
            this.zzize.putByte(obj, j, b);
        }

        public final boolean zzm(Object obj, long j) {
            return this.zzize.getBoolean(obj, j);
        }

        public final void zza(Object obj, long j, boolean z) {
            this.zzize.putBoolean(obj, j, z);
        }

        public final float zzn(Object obj, long j) {
            return this.zzize.getFloat(obj, j);
        }

        public final void zza(Object obj, long j, float f) {
            this.zzize.putFloat(obj, j, f);
        }

        public final double zzo(Object obj, long j) {
            return this.zzize.getDouble(obj, j);
        }

        public final void zza(Object obj, long j, double d) {
            this.zzize.putDouble(obj, j, d);
        }
    }

    /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
    private static final class zzc extends zzd {
        zzc(Unsafe unsafe) {
            super(unsafe);
        }

        public final byte zzy(Object obj, long j) {
            if (zzeqg.zzizb) {
                return zzeqg.zzq(obj, j);
            }
            return zzeqg.zzr(obj, j);
        }

        public final void zze(Object obj, long j, byte b) {
            if (zzeqg.zzizb) {
                zzeqg.zza(obj, j, b);
            } else {
                zzeqg.zzb(obj, j, b);
            }
        }

        public final boolean zzm(Object obj, long j) {
            if (zzeqg.zzizb) {
                return zzeqg.zzs(obj, j);
            }
            return zzeqg.zzt(obj, j);
        }

        public final void zza(Object obj, long j, boolean z) {
            if (zzeqg.zzizb) {
                zzeqg.zzb(obj, j, z);
            } else {
                zzeqg.zzc(obj, j, z);
            }
        }

        public final float zzn(Object obj, long j) {
            return Float.intBitsToFloat(zzk(obj, j));
        }

        public final void zza(Object obj, long j, float f) {
            zzb(obj, j, Float.floatToIntBits(f));
        }

        public final double zzo(Object obj, long j) {
            return Double.longBitsToDouble(zzl(obj, j));
        }

        public final void zza(Object obj, long j, double d) {
            zza(obj, j, Double.doubleToLongBits(d));
        }
    }

    static boolean zzbmb() {
        return zziqf;
    }

    /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
    private static abstract class zzd {
        Unsafe zzize;

        zzd(Unsafe unsafe) {
            this.zzize = unsafe;
        }

        public abstract void zza(Object obj, long j, double d);

        public abstract void zza(Object obj, long j, float f);

        public abstract void zza(Object obj, long j, boolean z);

        public abstract void zze(Object obj, long j, byte b);

        public abstract boolean zzm(Object obj, long j);

        public abstract float zzn(Object obj, long j);

        public abstract double zzo(Object obj, long j);

        public abstract byte zzy(Object obj, long j);

        public final int zzk(Object obj, long j) {
            return this.zzize.getInt(obj, j);
        }

        public final void zzb(Object obj, long j, int i) {
            this.zzize.putInt(obj, j, i);
        }

        public final long zzl(Object obj, long j) {
            return this.zzize.getLong(obj, j);
        }

        public final void zza(Object obj, long j, long j2) {
            this.zzize.putLong(obj, j, j2);
        }
    }

    static boolean zzbmc() {
        return zziyl;
    }

    static <T> T zzl(Class<T> cls) {
        try {
            return zzicl.allocateInstance(cls);
        } catch (InstantiationException e) {
            throw new IllegalStateException(e);
        }
    }

    private static int zzm(Class<?> cls) {
        if (zziqf) {
            return zziyk.zzize.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static int zzn(Class<?> cls) {
        if (zziqf) {
            return zziyk.zzize.arrayIndexScale(cls);
        }
        return -1;
    }

    static int zzk(Object obj, long j) {
        return zziyk.zzk(obj, j);
    }

    static void zzb(Object obj, long j, int i) {
        zziyk.zzb(obj, j, i);
    }

    static long zzl(Object obj, long j) {
        return zziyk.zzl(obj, j);
    }

    static void zza(Object obj, long j, long j2) {
        zziyk.zza(obj, j, j2);
    }

    static boolean zzm(Object obj, long j) {
        return zziyk.zzm(obj, j);
    }

    static void zza(Object obj, long j, boolean z) {
        zziyk.zza(obj, j, z);
    }

    static float zzn(Object obj, long j) {
        return zziyk.zzn(obj, j);
    }

    static void zza(Object obj, long j, float f) {
        zziyk.zza(obj, j, f);
    }

    static double zzo(Object obj, long j) {
        return zziyk.zzo(obj, j);
    }

    static void zza(Object obj, long j, double d) {
        zziyk.zza(obj, j, d);
    }

    static Object zzp(Object obj, long j) {
        return zziyk.zzize.getObject(obj, j);
    }

    static void zza(Object obj, long j, Object obj2) {
        zziyk.zzize.putObject(obj, j, obj2);
    }

    static byte zza(byte[] bArr, long j) {
        return zziyk.zzy(bArr, zziym + j);
    }

    static void zza(byte[] bArr, long j, byte b) {
        zziyk.zze(bArr, zziym + j, b);
    }

    static Unsafe zzbmd() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzeqi());
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean zzbme() {
        Unsafe unsafe = zzicl;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", new Class[]{Field.class});
            cls.getMethod("arrayBaseOffset", new Class[]{Class.class});
            cls.getMethod("arrayIndexScale", new Class[]{Class.class});
            cls.getMethod("getInt", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putInt", new Class[]{Object.class, Long.TYPE, Integer.TYPE});
            cls.getMethod("getLong", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putLong", new Class[]{Object.class, Long.TYPE, Long.TYPE});
            cls.getMethod("getObject", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putObject", new Class[]{Object.class, Long.TYPE, Object.class});
            if (zzelj.zzbhb()) {
                return true;
            }
            cls.getMethod("getByte", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putByte", new Class[]{Object.class, Long.TYPE, Byte.TYPE});
            cls.getMethod("getBoolean", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putBoolean", new Class[]{Object.class, Long.TYPE, Boolean.TYPE});
            cls.getMethod("getFloat", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putFloat", new Class[]{Object.class, Long.TYPE, Float.TYPE});
            cls.getMethod("getDouble", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putDouble", new Class[]{Object.class, Long.TYPE, Double.TYPE});
            return true;
        } catch (Throwable th) {
            Logger logger = Logger.getLogger(zzeqg.class.getName());
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(valueOf);
            logger.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", sb.toString());
            return false;
        }
    }

    private static boolean zzbmf() {
        Unsafe unsafe = zzicl;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", new Class[]{Field.class});
            cls.getMethod("getLong", new Class[]{Object.class, Long.TYPE});
            if (zzbmg() == null) {
                return false;
            }
            if (zzelj.zzbhb()) {
                return true;
            }
            cls.getMethod("getByte", new Class[]{Long.TYPE});
            cls.getMethod("putByte", new Class[]{Long.TYPE, Byte.TYPE});
            cls.getMethod("getInt", new Class[]{Long.TYPE});
            cls.getMethod("putInt", new Class[]{Long.TYPE, Integer.TYPE});
            cls.getMethod("getLong", new Class[]{Long.TYPE});
            cls.getMethod("putLong", new Class[]{Long.TYPE, Long.TYPE});
            cls.getMethod("copyMemory", new Class[]{Long.TYPE, Long.TYPE, Long.TYPE});
            cls.getMethod("copyMemory", new Class[]{Object.class, Long.TYPE, Object.class, Long.TYPE, Long.TYPE});
            return true;
        } catch (Throwable th) {
            Logger logger = Logger.getLogger(zzeqg.class.getName());
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(valueOf);
            logger.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeByteBufferOperations", sb.toString());
            return false;
        }
    }

    private static boolean zzo(Class<?> cls) {
        Class<byte[]> cls2 = byte[].class;
        if (!zzelj.zzbhb()) {
            return false;
        }
        try {
            Class<?> cls3 = zziot;
            cls3.getMethod("peekLong", new Class[]{cls, Boolean.TYPE});
            cls3.getMethod("pokeLong", new Class[]{cls, Long.TYPE, Boolean.TYPE});
            cls3.getMethod("pokeInt", new Class[]{cls, Integer.TYPE, Boolean.TYPE});
            cls3.getMethod("peekInt", new Class[]{cls, Boolean.TYPE});
            cls3.getMethod("pokeByte", new Class[]{cls, Byte.TYPE});
            cls3.getMethod("peekByte", new Class[]{cls});
            cls3.getMethod("pokeByteArray", new Class[]{cls, cls2, Integer.TYPE, Integer.TYPE});
            cls3.getMethod("peekByteArray", new Class[]{cls, cls2, Integer.TYPE, Integer.TYPE});
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static Field zzbmg() {
        Field zzb2;
        if (zzelj.zzbhb() && (zzb2 = zzb(Buffer.class, "effectiveDirectAddress")) != null) {
            return zzb2;
        }
        Field zzb3 = zzb(Buffer.class, "address");
        if (zzb3 == null || zzb3.getType() != Long.TYPE) {
            return null;
        }
        return zzb3;
    }

    private static Field zzb(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static byte zzq(Object obj, long j) {
        return (byte) (zzk(obj, -4 & j) >>> ((int) (((~j) & 3) << 3)));
    }

    /* access modifiers changed from: private */
    public static byte zzr(Object obj, long j) {
        return (byte) (zzk(obj, -4 & j) >>> ((int) ((j & 3) << 3)));
    }

    /* access modifiers changed from: private */
    public static void zza(Object obj, long j, byte b) {
        long j2 = -4 & j;
        int zzk = zzk(obj, j2);
        int i = ((~((int) j)) & 3) << 3;
        zzb(obj, j2, ((255 & b) << i) | (zzk & (~(255 << i))));
    }

    /* access modifiers changed from: private */
    public static void zzb(Object obj, long j, byte b) {
        long j2 = -4 & j;
        int i = (((int) j) & 3) << 3;
        zzb(obj, j2, ((255 & b) << i) | (zzk(obj, j2) & (~(255 << i))));
    }

    /* access modifiers changed from: private */
    public static boolean zzs(Object obj, long j) {
        return zzq(obj, j) != 0;
    }

    /* access modifiers changed from: private */
    public static boolean zzt(Object obj, long j) {
        return zzr(obj, j) != 0;
    }

    /* access modifiers changed from: private */
    public static void zzb(Object obj, long j, boolean z) {
        zza(obj, j, z ? (byte) 1 : 0);
    }

    /* access modifiers changed from: private */
    public static void zzc(Object obj, long j, boolean z) {
        zzb(obj, j, z ? (byte) 1 : 0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x00c6, code lost:
        r1 = zziyk;
     */
    static {
        /*
            java.lang.Class<double[]> r0 = double[].class
            java.lang.Class<float[]> r1 = float[].class
            java.lang.Class<long[]> r2 = long[].class
            java.lang.Class<int[]> r3 = int[].class
            java.lang.Class<boolean[]> r4 = boolean[].class
            sun.misc.Unsafe r5 = zzbmd()
            zzicl = r5
            java.lang.Class r5 = com.google.android.gms.internal.ads.zzelj.zzbhc()
            zziot = r5
            java.lang.Class r5 = java.lang.Long.TYPE
            boolean r5 = zzo(r5)
            zziyi = r5
            java.lang.Class r5 = java.lang.Integer.TYPE
            boolean r5 = zzo(r5)
            zziyj = r5
            sun.misc.Unsafe r5 = zzicl
            r6 = 0
            if (r5 != 0) goto L_0x002c
            goto L_0x0051
        L_0x002c:
            boolean r5 = com.google.android.gms.internal.ads.zzelj.zzbhb()
            if (r5 == 0) goto L_0x004a
            boolean r5 = zziyi
            if (r5 == 0) goto L_0x003e
            com.google.android.gms.internal.ads.zzeqg$zzc r6 = new com.google.android.gms.internal.ads.zzeqg$zzc
            sun.misc.Unsafe r5 = zzicl
            r6.<init>(r5)
            goto L_0x0051
        L_0x003e:
            boolean r5 = zziyj
            if (r5 == 0) goto L_0x0051
            com.google.android.gms.internal.ads.zzeqg$zza r6 = new com.google.android.gms.internal.ads.zzeqg$zza
            sun.misc.Unsafe r5 = zzicl
            r6.<init>(r5)
            goto L_0x0051
        L_0x004a:
            com.google.android.gms.internal.ads.zzeqg$zzb r6 = new com.google.android.gms.internal.ads.zzeqg$zzb
            sun.misc.Unsafe r5 = zzicl
            r6.<init>(r5)
        L_0x0051:
            zziyk = r6
            boolean r5 = zzbmf()
            zziyl = r5
            boolean r5 = zzbme()
            zziqf = r5
            java.lang.Class<byte[]> r5 = byte[].class
            int r5 = zzm(r5)
            long r5 = (long) r5
            zziym = r5
            int r5 = zzm(r4)
            long r5 = (long) r5
            zziyn = r5
            int r4 = zzn(r4)
            long r4 = (long) r4
            zziyo = r4
            int r4 = zzm(r3)
            long r4 = (long) r4
            zziyp = r4
            int r3 = zzn(r3)
            long r3 = (long) r3
            zziyq = r3
            int r3 = zzm(r2)
            long r3 = (long) r3
            zziyr = r3
            int r2 = zzn(r2)
            long r2 = (long) r2
            zziys = r2
            int r2 = zzm(r1)
            long r2 = (long) r2
            zziyt = r2
            int r1 = zzn(r1)
            long r1 = (long) r1
            zziyu = r1
            int r1 = zzm(r0)
            long r1 = (long) r1
            zziyv = r1
            int r0 = zzn(r0)
            long r0 = (long) r0
            zziyw = r0
            java.lang.Class<java.lang.Object[]> r0 = java.lang.Object[].class
            int r0 = zzm(r0)
            long r0 = (long) r0
            zziyx = r0
            java.lang.Class<java.lang.Object[]> r0 = java.lang.Object[].class
            int r0 = zzn(r0)
            long r0 = (long) r0
            zziyy = r0
            java.lang.reflect.Field r0 = zzbmg()
            if (r0 == 0) goto L_0x00d2
            com.google.android.gms.internal.ads.zzeqg$zzd r1 = zziyk
            if (r1 != 0) goto L_0x00cb
            goto L_0x00d2
        L_0x00cb:
            sun.misc.Unsafe r1 = r1.zzize
            long r0 = r1.objectFieldOffset(r0)
            goto L_0x00d4
        L_0x00d2:
            r0 = -1
        L_0x00d4:
            zziyz = r0
            long r0 = zziym
            r2 = 7
            long r0 = r0 & r2
            int r1 = (int) r0
            zziza = r1
            java.nio.ByteOrder r0 = java.nio.ByteOrder.nativeOrder()
            java.nio.ByteOrder r1 = java.nio.ByteOrder.BIG_ENDIAN
            if (r0 != r1) goto L_0x00e8
            r0 = 1
            goto L_0x00e9
        L_0x00e8:
            r0 = 0
        L_0x00e9:
            zzizb = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeqg.<clinit>():void");
    }
}
