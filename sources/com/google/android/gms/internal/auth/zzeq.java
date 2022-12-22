package com.google.android.gms.internal.auth;

import com.google.android.gms.internal.auth.zzeo;
import com.google.android.gms.internal.auth.zzeq;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public abstract class zzeq<MessageType extends zzeq<MessageType, BuilderType>, BuilderType extends zzeo<MessageType, BuilderType>> extends zzdm<MessageType, BuilderType> {
    private static final Map<Object, zzeq<?, ?>> zzb = new ConcurrentHashMap();
    protected zzgq zzc = zzgq.zza();

    static <T extends zzeq> T zza(Class<T> cls) {
        T t = (zzeq) zzb.get(cls);
        if (t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t = (zzeq) zzb.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (t == null) {
            t = (zzeq) ((zzeq) zzgz.zze(cls)).zzj(6, (Object) null, (Object) null);
            if (t != null) {
                zzb.put(cls, t);
            } else {
                throw new IllegalStateException();
            }
        }
        return t;
    }

    protected static <T extends zzeq<T, ?>> T zzb(T t, byte[] bArr) throws zzew {
        boolean z = false;
        T zzc2 = zzc(t, bArr, 0, bArr.length, zzeg.zza());
        if (zzc2 != null) {
            boolean booleanValue = Boolean.TRUE.booleanValue();
            byte byteValue = ((Byte) zzc2.zzj(1, (Object) null, (Object) null)).byteValue();
            if (byteValue == 1) {
                z = true;
            } else if (byteValue != 0) {
                z = zzfy.zza().zzb(zzc2.getClass()).zzi(zzc2);
                if (booleanValue) {
                    zzc2.zzj(2, true != z ? null : zzc2, (Object) null);
                }
            }
            if (!z) {
                zzew zzew = new zzew(new zzgo(zzc2).getMessage());
                zzew.zze(zzc2);
                throw zzew;
            }
        }
        return zzc2;
    }

    static <T extends zzeq<T, ?>> T zzc(T t, byte[] bArr, int i, int i2, zzeg zzeg) throws zzew {
        T t2 = (zzeq) t.zzj(4, (Object) null, (Object) null);
        try {
            zzgb<?> zzb2 = zzfy.zza().zzb(t2.getClass());
            zzb2.zzg(t2, bArr, 0, i2, new zzdp(zzeg));
            zzb2.zze(t2);
            if (t2.zza == 0) {
                return t2;
            }
            throw new RuntimeException();
        } catch (zzew e) {
            e.zze(t2);
            throw e;
        } catch (IOException e2) {
            if (e2.getCause() instanceof zzew) {
                throw ((zzew) e2.getCause());
            }
            zzew zzew = new zzew(e2);
            zzew.zze(t2);
            throw zzew;
        } catch (IndexOutOfBoundsException unused) {
            zzew zzf = zzew.zzf();
            zzf.zze(t2);
            throw zzf;
        }
    }

    protected static <E> zzeu<E> zzd() {
        return zzfz.zze();
    }

    static Object zzf(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
        }
    }

    protected static Object zzg(zzfq zzfq, String str, Object[] objArr) {
        return new zzga(zzfq, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a", objArr);
    }

    protected static <T extends zzeq> void zzi(Class<T> cls, T t) {
        zzb.put(cls, t);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return zzfy.zza().zzb(getClass()).zzh(this, (zzeq) obj);
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zza;
        if (i != 0) {
            return i;
        }
        int zza = zzfy.zza().zzb(getClass()).zza(this);
        this.zza = zza;
        return zza;
    }

    public final String toString() {
        return zzfs.zza(this, super.toString());
    }

    public final /* synthetic */ zzfp zze() {
        zzeo zzeo = (zzeo) zzj(5, (Object) null, (Object) null);
        zzeo.zze(this);
        return zzeo;
    }

    public final /* synthetic */ zzfq zzh() {
        return (zzeq) zzj(6, (Object) null, (Object) null);
    }

    /* access modifiers changed from: protected */
    public abstract Object zzj(int i, Object obj, Object obj2);
}
