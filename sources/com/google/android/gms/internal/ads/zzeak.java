package com.google.android.gms.internal.ads;

import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
abstract class zzeak<I, O, F, T> extends zzebb<O> implements Runnable {
    @NullableDecl
    private zzebt<? extends I> zzibw;
    @NullableDecl
    private F zzics;

    static <I, O> zzebt<O> zza(zzebt<I> zzebt, zzear<? super I, ? extends O> zzear, Executor executor) {
        zzdyi.checkNotNull(executor);
        zzeaj zzeaj = new zzeaj(zzebt, zzear);
        zzebt.addListener(zzeaj, zzebv.zza(executor, zzeaj));
        return zzeaj;
    }

    /* access modifiers changed from: package-private */
    public abstract void setResult(@NullableDecl T t);

    /* access modifiers changed from: package-private */
    @NullableDecl
    public abstract T zzd(F f, @NullableDecl I i) throws Exception;

    static <I, O> zzebt<O> zza(zzebt<I> zzebt, zzdxw<? super I, ? extends O> zzdxw, Executor executor) {
        zzdyi.checkNotNull(zzdxw);
        zzeam zzeam = new zzeam(zzebt, zzdxw);
        zzebt.addListener(zzeam, zzebv.zza(executor, zzeam));
        return zzeam;
    }

    zzeak(zzebt<? extends I> zzebt, F f) {
        this.zzibw = (zzebt) zzdyi.checkNotNull(zzebt);
        this.zzics = zzdyi.checkNotNull(f);
    }

    public final void run() {
        zzebt<? extends I> zzebt = this.zzibw;
        F f = this.zzics;
        boolean z = true;
        boolean isCancelled = isCancelled() | (zzebt == null);
        if (f != null) {
            z = false;
        }
        if (!isCancelled && !z) {
            this.zzibw = null;
            if (zzebt.isCancelled()) {
                setFuture(zzebt);
                return;
            }
            try {
                try {
                    Object zzd = zzd(f, zzebh.zza(zzebt));
                    this.zzics = null;
                    setResult(zzd);
                } catch (Throwable th) {
                    this.zzics = null;
                    throw th;
                }
            } catch (CancellationException unused) {
                cancel(false);
            } catch (ExecutionException e) {
                setException(e.getCause());
            } catch (RuntimeException e2) {
                setException(e2);
            } catch (Error e3) {
                setException(e3);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void afterDone() {
        maybePropagateCancellationTo(this.zzibw);
        this.zzibw = null;
        this.zzics = null;
    }

    /* access modifiers changed from: protected */
    public final String pendingToString() {
        String str;
        zzebt<? extends I> zzebt = this.zzibw;
        F f = this.zzics;
        String pendingToString = super.pendingToString();
        if (zzebt != null) {
            String valueOf = String.valueOf(zzebt);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 16);
            sb.append("inputFuture=[");
            sb.append(valueOf);
            sb.append("], ");
            str = sb.toString();
        } else {
            str = "";
        }
        if (f != null) {
            String valueOf2 = String.valueOf(f);
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 11 + String.valueOf(valueOf2).length());
            sb2.append(str);
            sb2.append("function=[");
            sb2.append(valueOf2);
            sb2.append(Const.jaRight);
            return sb2.toString();
        } else if (pendingToString == null) {
            return null;
        } else {
            String valueOf3 = String.valueOf(str);
            String valueOf4 = String.valueOf(pendingToString);
            return valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3);
        }
    }
}
