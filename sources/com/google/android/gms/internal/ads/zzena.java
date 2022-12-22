package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzena;
import com.google.android.gms.internal.ads.zzena.zzb;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
public abstract class zzena<MessageType extends zzena<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zzelg<MessageType, BuilderType> {
    private static Map<Object, zzena<?, ?>> zzitp = new ConcurrentHashMap();
    protected zzeqd zzitn = zzeqd.zzbly();
    private int zzito = -1;

    /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
    protected static class zza<T extends zzena<T, ?>> extends zzelh<T> {
        private final T zzitr;

        public zza(T t) {
            this.zzitr = t;
        }
    }

    /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
    static final class zzc implements zzemv<zzc> {
        public final int zzv() {
            throw new NoSuchMethodError();
        }

        public final zzeqr zzbjc() {
            throw new NoSuchMethodError();
        }

        public final zzequ zzbjd() {
            throw new NoSuchMethodError();
        }

        public final boolean zzbje() {
            throw new NoSuchMethodError();
        }

        public final boolean zzbjf() {
            throw new NoSuchMethodError();
        }

        public final zzeom zza(zzeom zzeom, zzeon zzeon) {
            throw new NoSuchMethodError();
        }

        public final zzeos zza(zzeos zzeos, zzeos zzeos2) {
            throw new NoSuchMethodError();
        }

        public final /* synthetic */ int compareTo(Object obj) {
            throw new NoSuchMethodError();
        }
    }

    /* 'enum' modifier removed */
    /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
    public static final class zze {
        public static final int zzitv = 1;
        public static final int zzitw = 2;
        public static final int zzitx = 3;
        public static final int zzity = 4;
        public static final int zzitz = 5;
        public static final int zziua = 6;
        public static final int zziub = 7;
        private static final /* synthetic */ int[] zziuc = {1, 2, 3, 4, 5, 6, 7};

        public static int[] zzbjx() {
            return (int[]) zziuc.clone();
        }
    }

    /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
    public static class zzf<ContainingType extends zzeon, Type> extends zzemo<ContainingType, Type> {
    }

    /* access modifiers changed from: protected */
    public abstract Object zza(int i, Object obj, Object obj2);

    /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
    public static abstract class zzd<MessageType extends zzd<MessageType, BuilderType>, BuilderType> extends zzena<MessageType, BuilderType> implements zzeop {
        protected zzemt<zzc> zzitu = zzemt.zzbja();

        /* access modifiers changed from: package-private */
        public final zzemt<zzc> zzbjw() {
            if (this.zzitu.isImmutable()) {
                this.zzitu = (zzemt) this.zzitu.clone();
            }
            return this.zzitu;
        }
    }

    public String toString() {
        return zzeoo.zza(this, super.toString());
    }

    public int hashCode() {
        if (this.zziop != 0) {
            return this.zziop;
        }
        this.zziop = zzepb.zzble().zzax(this).hashCode(this);
        return this.zziop;
    }

    /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
    public static abstract class zzb<MessageType extends zzena<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zzelf<MessageType, BuilderType> {
        private final MessageType zzitr;
        protected MessageType zzits;
        protected boolean zzitt = false;

        protected zzb(MessageType messagetype) {
            this.zzitr = messagetype;
            this.zzits = (zzena) messagetype.zza(zze.zzity, (Object) null, (Object) null);
        }

        /* access modifiers changed from: protected */
        public void zzbjr() {
            MessageType messagetype = (zzena) this.zzits.zza(zze.zzity, (Object) null, (Object) null);
            zza(messagetype, this.zzits);
            this.zzits = messagetype;
        }

        public final boolean isInitialized() {
            return zzena.zza(this.zzits, false);
        }

        /* renamed from: zzbjs */
        public MessageType zzbju() {
            if (this.zzitt) {
                return this.zzits;
            }
            MessageType messagetype = this.zzits;
            zzepb.zzble().zzax(messagetype).zzak(messagetype);
            this.zzitt = true;
            return this.zzits;
        }

        /* renamed from: zzbjt */
        public final MessageType zzbjv() {
            MessageType messagetype = (zzena) zzbju();
            if (messagetype.isInitialized()) {
                return messagetype;
            }
            throw new zzeqb(messagetype);
        }

        /* renamed from: zzb */
        public final BuilderType zza(MessageType messagetype) {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            zza(this.zzits, messagetype);
            return this;
        }

        private static void zza(MessageType messagetype, MessageType messagetype2) {
            zzepb.zzble().zzax(messagetype).zzg(messagetype, messagetype2);
        }

        private final BuilderType zzb(byte[] bArr, int i, int i2, zzemn zzemn) throws zzenn {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            try {
                zzepb.zzble().zzax(this.zzits).zza(this.zzits, bArr, 0, i2, new zzell(zzemn));
                return this;
            } catch (zzenn e) {
                throw e;
            } catch (IndexOutOfBoundsException unused) {
                throw zzenn.zzbjz();
            } catch (IOException e2) {
                throw new RuntimeException("Reading from byte array should not throw IOException.", e2);
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: zzb */
        public final BuilderType zza(zzemb zzemb, zzemn zzemn) throws IOException {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            try {
                zzepb.zzble().zzax(this.zzits).zza(this.zzits, zzemi.zza(zzemb), zzemn);
                return this;
            } catch (RuntimeException e) {
                if (e.getCause() instanceof IOException) {
                    throw ((IOException) e.getCause());
                }
                throw e;
            }
        }

        public final /* synthetic */ zzelf zza(byte[] bArr, int i, int i2, zzemn zzemn) throws zzenn {
            return zzb(bArr, 0, i2, zzemn);
        }

        public final /* synthetic */ zzelf zzbgx() {
            return (zzb) clone();
        }

        public final /* synthetic */ zzeon zzbjp() {
            return this.zzitr;
        }

        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            zzb zzb = (zzb) ((zzena) this.zzitr).zza(zze.zzitz, (Object) null, (Object) null);
            zzb.zza((zzena) zzbju());
            return zzb;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return zzepb.zzble().zzax(this).equals(this, (zzena) obj);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public final <MessageType extends zzena<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> BuilderType zzbjh() {
        return (zzb) zza(zze.zzitz, (Object) null, (Object) null);
    }

    public final boolean isInitialized() {
        return zza(this, Boolean.TRUE.booleanValue());
    }

    public final BuilderType zzbji() {
        BuilderType buildertype = (zzb) zza(zze.zzitz, (Object) null, (Object) null);
        buildertype.zza(this);
        return buildertype;
    }

    /* access modifiers changed from: package-private */
    public final int zzbgz() {
        return this.zzito;
    }

    /* access modifiers changed from: package-private */
    public final void zzgd(int i) {
        this.zzito = i;
    }

    public final void zzb(zzemk zzemk) throws IOException {
        zzepb.zzble().zzax(this).zza(this, zzemm.zza(zzemk));
    }

    public final int zzbjj() {
        if (this.zzito == -1) {
            this.zzito = zzepb.zzble().zzax(this).zzau(this);
        }
        return this.zzito;
    }

    static <T extends zzena<?, ?>> T zzf(Class<T> cls) {
        T t = (zzena) zzitp.get(cls);
        if (t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t = (zzena) zzitp.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (t == null) {
            t = (zzena) ((zzena) zzeqg.zzl(cls)).zza(zze.zziua, (Object) null, (Object) null);
            if (t != null) {
                zzitp.put(cls, t);
            } else {
                throw new IllegalStateException();
            }
        }
        return t;
    }

    protected static <T extends zzena<?, ?>> void zza(Class<T> cls, T t) {
        zzitp.put(cls, t);
    }

    protected static Object zza(zzeon zzeon, String str, Object[] objArr) {
        return new zzepd(zzeon, str, objArr);
    }

    static Object zza(Method method, Object obj, Object... objArr) {
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

    protected static final <T extends zzena<T, ?>> boolean zza(T t, boolean z) {
        byte byteValue = ((Byte) t.zza(zze.zzitv, (Object) null, (Object) null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzaw = zzepb.zzble().zzax(t).zzaw(t);
        if (z) {
            t.zza(zze.zzitw, (Object) zzaw ? t : null, (Object) null);
        }
        return zzaw;
    }

    protected static zzeng zzbjk() {
        return zzend.zzbjy();
    }

    protected static zzeng zza(zzeng zzeng) {
        int size = zzeng.size();
        return zzeng.zzho(size == 0 ? 10 : size << 1);
    }

    protected static zzenl zzbjl() {
        return zzeob.zzbkq();
    }

    protected static <E> zzenk<E> zzbjm() {
        return zzepa.zzbld();
    }

    protected static <E> zzenk<E> zza(zzenk<E> zzenk) {
        int size = zzenk.size();
        return zzenk.zzgg(size == 0 ? 10 : size << 1);
    }

    private static <T extends zzena<T, ?>> T zza(T t, zzemb zzemb, zzemn zzemn) throws zzenn {
        T t2 = (zzena) t.zza(zze.zzity, (Object) null, (Object) null);
        try {
            zzepi zzax = zzepb.zzble().zzax(t2);
            zzax.zza(t2, zzemi.zza(zzemb), zzemn);
            zzax.zzak(t2);
            return t2;
        } catch (IOException e) {
            if (e.getCause() instanceof zzenn) {
                throw ((zzenn) e.getCause());
            }
            throw new zzenn(e.getMessage()).zzl(t2);
        } catch (RuntimeException e2) {
            if (e2.getCause() instanceof zzenn) {
                throw ((zzenn) e2.getCause());
            }
            throw e2;
        }
    }

    private static <T extends zzena<T, ?>> T zza(T t, byte[] bArr, int i, int i2, zzemn zzemn) throws zzenn {
        T t2 = (zzena) t.zza(zze.zzity, (Object) null, (Object) null);
        try {
            zzepi zzax = zzepb.zzble().zzax(t2);
            zzax.zza(t2, bArr, 0, i2, new zzell(zzemn));
            zzax.zzak(t2);
            if (t2.zziop == 0) {
                return t2;
            }
            throw new RuntimeException();
        } catch (IOException e) {
            if (e.getCause() instanceof zzenn) {
                throw ((zzenn) e.getCause());
            }
            throw new zzenn(e.getMessage()).zzl(t2);
        } catch (IndexOutOfBoundsException unused) {
            throw zzenn.zzbjz().zzl(t2);
        }
    }

    private static <T extends zzena<T, ?>> T zza(T t) throws zzenn {
        if (t == null || t.isInitialized()) {
            return t;
        }
        throw new zzenn(new zzeqb(t).getMessage()).zzl(t);
    }

    protected static <T extends zzena<T, ?>> T zza(T t, zzelq zzelq) throws zzenn {
        return zza(zza(zzb(t, zzelq, zzemn.zzbiv())));
    }

    protected static <T extends zzena<T, ?>> T zza(T t, zzelq zzelq, zzemn zzemn) throws zzenn {
        return zza(zzb(t, zzelq, zzemn));
    }

    private static <T extends zzena<T, ?>> T zzb(T t, zzelq zzelq, zzemn zzemn) throws zzenn {
        T zza2;
        try {
            zzemb zzbhj = zzelq.zzbhj();
            zza2 = zza(t, zzbhj, zzemn);
            zzbhj.zzgl(0);
            return zza2;
        } catch (zzenn e) {
            throw e.zzl(zza2);
        } catch (zzenn e2) {
            throw e2;
        }
    }

    protected static <T extends zzena<T, ?>> T zza(T t, byte[] bArr) throws zzenn {
        return zza(zza(t, bArr, 0, bArr.length, zzemn.zzbiv()));
    }

    protected static <T extends zzena<T, ?>> T zza(T t, byte[] bArr, zzemn zzemn) throws zzenn {
        return zza(zza(t, bArr, 0, bArr.length, zzemn));
    }

    public final /* synthetic */ zzeom zzbjn() {
        zzb zzb2 = (zzb) zza(zze.zzitz, (Object) null, (Object) null);
        zzb2.zza(this);
        return zzb2;
    }

    public final /* synthetic */ zzeom zzbjo() {
        return (zzb) zza(zze.zzitz, (Object) null, (Object) null);
    }

    public final /* synthetic */ zzeon zzbjp() {
        return (zzena) zza(zze.zziua, (Object) null, (Object) null);
    }
}
