package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.didi.sdk.apm.SystemUtils;
import com.google.android.gms.internal.ads.zzpb;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzpc<T extends zzpb> extends Handler implements Runnable {
    private volatile boolean zzagd;
    private final T zzbjv;
    private final zzoz<T> zzbjw;
    public final int zzbjx;
    private final long zzbjy;
    private IOException zzbjz;
    private int zzbka;
    private volatile Thread zzbkb;
    private final /* synthetic */ zzpa zzbkc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzpc(zzpa zzpa, Looper looper, T t, zzoz<T> zzoz, int i, long j) {
        super(looper);
        this.zzbkc = zzpa;
        this.zzbjv = t;
        this.zzbjw = zzoz;
        this.zzbjx = i;
        this.zzbjy = j;
    }

    public final void zzbj(int i) throws IOException {
        IOException iOException = this.zzbjz;
        if (iOException != null && this.zzbka > i) {
            throw iOException;
        }
    }

    public final void zzek(long j) {
        zzpg.checkState(this.zzbkc.zzbjt == null);
        zzpc unused = this.zzbkc.zzbjt = this;
        if (j > 0) {
            sendEmptyMessageDelayed(0, j);
        } else {
            execute();
        }
    }

    public final void zzm(boolean z) {
        this.zzagd = z;
        this.zzbjz = null;
        if (hasMessages(0)) {
            removeMessages(0);
            if (!z) {
                sendEmptyMessage(1);
            }
        } else {
            this.zzbjv.cancelLoad();
            if (this.zzbkb != null) {
                this.zzbkb.interrupt();
            }
        }
        if (z) {
            finish();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.zzbjw.zza(this.zzbjv, elapsedRealtime, elapsedRealtime - this.zzbjy, true);
        }
    }

    public final void run() {
        try {
            this.zzbkb = Thread.currentThread();
            if (!this.zzbjv.zzib()) {
                String valueOf = String.valueOf(this.zzbjv.getClass().getSimpleName());
                zzpu.beginSection(valueOf.length() != 0 ? "load:".concat(valueOf) : new String("load:"));
                this.zzbjv.zzic();
                zzpu.endSection();
            }
            if (!this.zzagd) {
                sendEmptyMessage(2);
            }
        } catch (IOException e) {
            if (!this.zzagd) {
                obtainMessage(3, e).sendToTarget();
            }
        } catch (InterruptedException unused) {
            zzpg.checkState(this.zzbjv.zzib());
            if (!this.zzagd) {
                sendEmptyMessage(2);
            }
        } catch (Exception e2) {
            SystemUtils.log(6, "LoadTask", "Unexpected exception loading stream", e2, "com.google.android.gms.internal.ads.zzpc", 52);
            if (!this.zzagd) {
                obtainMessage(3, new zzpe(e2)).sendToTarget();
            }
        } catch (OutOfMemoryError e3) {
            SystemUtils.log(6, "LoadTask", "OutOfMemory error loading stream", e3, "com.google.android.gms.internal.ads.zzpc", 57);
            if (!this.zzagd) {
                obtainMessage(3, new zzpe(e3)).sendToTarget();
            }
        } catch (Error e4) {
            SystemUtils.log(6, "LoadTask", "Unexpected error loading stream", e4, "com.google.android.gms.internal.ads.zzpc", 62);
            if (!this.zzagd) {
                obtainMessage(4, e4).sendToTarget();
            }
            throw e4;
        } catch (Throwable th) {
            zzpu.endSection();
            throw th;
        }
    }

    public final void handleMessage(Message message) {
        int i;
        if (!this.zzagd) {
            if (message.what == 0) {
                execute();
            } else if (message.what != 4) {
                finish();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                long j = elapsedRealtime - this.zzbjy;
                if (this.zzbjv.zzib()) {
                    this.zzbjw.zza(this.zzbjv, elapsedRealtime, j, false);
                    return;
                }
                int i2 = message.what;
                if (i2 == 1) {
                    this.zzbjw.zza(this.zzbjv, elapsedRealtime, j, false);
                } else if (i2 == 2) {
                    this.zzbjw.zza(this.zzbjv, elapsedRealtime, j);
                } else if (i2 == 3) {
                    IOException iOException = (IOException) message.obj;
                    this.zzbjz = iOException;
                    int zza = this.zzbjw.zza(this.zzbjv, elapsedRealtime, j, iOException);
                    if (zza == 3) {
                        IOException unused = this.zzbkc.zzbju = this.zzbjz;
                    } else if (zza != 2) {
                        if (zza == 1) {
                            i = 1;
                        } else {
                            i = this.zzbka + 1;
                        }
                        this.zzbka = i;
                        zzek((long) Math.min((i - 1) * 1000, 5000));
                    }
                }
            } else {
                throw ((Error) message.obj);
            }
        }
    }

    private final void execute() {
        this.zzbjz = null;
        this.zzbkc.zzbjs.execute(this.zzbkc.zzbjt);
    }

    private final void finish() {
        zzpc unused = this.zzbkc.zzbjt = null;
    }
}
