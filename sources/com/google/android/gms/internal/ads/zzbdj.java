package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.common.util.IOUtils;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbdj implements zzon {
    private final Context context;
    private boolean isOpen;
    private Uri uri;
    private boolean zzbvt = false;
    private long zzbvv = 0;
    private boolean zzbvw = false;
    private final String zzbwe;
    private final int zzbwf;
    private final zzpd<zzon> zzepv;
    private final zzon zzepw;
    private final zzbdl zzepx;
    private final boolean zzepy = ((Boolean) zzww.zzra().zzd(zzabq.zzcsd)).booleanValue();
    private InputStream zzepz;
    private volatile zzti zzeqa;
    private boolean zzeqb = false;
    private boolean zzeqc = false;
    private zzebt<Long> zzeqd = null;
    private final AtomicLong zzeqe = new AtomicLong(-1);

    public zzbdj(Context context2, zzon zzon, String str, int i, zzpd<zzon> zzpd, zzbdl zzbdl) {
        this.context = context2;
        this.zzepw = zzon;
        this.zzepv = zzpd;
        this.zzepx = zzbdl;
        this.zzbwe = str;
        this.zzbwf = i;
    }

    public final void close() throws IOException {
        zzpd<zzon> zzpd;
        if (this.isOpen) {
            boolean z = false;
            this.isOpen = false;
            this.uri = null;
            if (!this.zzepy || this.zzepz != null) {
                z = true;
            }
            InputStream inputStream = this.zzepz;
            if (inputStream != null) {
                IOUtils.closeQuietly((Closeable) inputStream);
                this.zzepz = null;
            } else {
                this.zzepw.close();
            }
            if (z && (zzpd = this.zzepv) != null) {
                zzpd.zze(this);
                return;
            }
            return;
        }
        throw new IOException("Attempt to close an already closed CacheDataSource.");
    }

    /* JADX WARNING: Removed duplicated region for block: B:60:0x01f4  */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:39:0x0141=Splitter:B:39:0x0141, B:34:0x010f=Splitter:B:34:0x010f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long zza(com.google.android.gms.internal.ads.zzos r15) throws java.io.IOException {
        /*
            r14 = this;
            java.lang.String r0 = "ms"
            java.lang.String r1 = "Cache connection took "
            boolean r2 = r14.isOpen
            if (r2 != 0) goto L_0x0216
            r2 = 1
            r14.isOpen = r2
            android.net.Uri r3 = r15.uri
            r14.uri = r3
            boolean r3 = r14.zzepy
            if (r3 != 0) goto L_0x0016
            r14.zzb(r15)
        L_0x0016:
            android.net.Uri r3 = r15.uri
            com.google.android.gms.internal.ads.zzti r3 = com.google.android.gms.internal.ads.zzti.zzd(r3)
            r14.zzeqa = r3
            com.google.android.gms.internal.ads.zzabf<java.lang.Boolean> r3 = com.google.android.gms.internal.ads.zzabq.zzcva
            com.google.android.gms.internal.ads.zzabm r4 = com.google.android.gms.internal.ads.zzww.zzra()
            java.lang.Object r3 = r4.zzd(r3)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            r4 = -1
            r6 = 0
            if (r3 == 0) goto L_0x0193
            com.google.android.gms.internal.ads.zzti r3 = r14.zzeqa
            if (r3 == 0) goto L_0x01ee
            com.google.android.gms.internal.ads.zzti r3 = r14.zzeqa
            long r7 = r15.position
            r3.zzbwd = r7
            com.google.android.gms.internal.ads.zzti r3 = r14.zzeqa
            java.lang.String r7 = r14.zzbwe
            java.lang.String r7 = com.google.android.gms.internal.ads.zzdyq.zzhn(r7)
            r3.zzbwe = r7
            com.google.android.gms.internal.ads.zzti r3 = r14.zzeqa
            int r7 = r14.zzbwf
            r3.zzbwf = r7
            com.google.android.gms.internal.ads.zzti r3 = r14.zzeqa
            boolean r3 = r3.zzbwc
            if (r3 == 0) goto L_0x0060
            com.google.android.gms.internal.ads.zzabf<java.lang.Long> r3 = com.google.android.gms.internal.ads.zzabq.zzcvc
            com.google.android.gms.internal.ads.zzabm r7 = com.google.android.gms.internal.ads.zzww.zzra()
            java.lang.Object r3 = r7.zzd(r3)
            java.lang.Long r3 = (java.lang.Long) r3
            goto L_0x006c
        L_0x0060:
            com.google.android.gms.internal.ads.zzabf<java.lang.Long> r3 = com.google.android.gms.internal.ads.zzabq.zzcvb
            com.google.android.gms.internal.ads.zzabm r7 = com.google.android.gms.internal.ads.zzww.zzra()
            java.lang.Object r3 = r7.zzd(r3)
            java.lang.Long r3 = (java.lang.Long) r3
        L_0x006c:
            long r7 = r3.longValue()
            com.google.android.gms.common.util.Clock r3 = com.google.android.gms.ads.internal.zzr.zzlc()
            long r9 = r3.elapsedRealtime()
            com.google.android.gms.ads.internal.zzr.zzlp()
            android.content.Context r3 = r14.context
            com.google.android.gms.internal.ads.zzti r11 = r14.zzeqa
            java.util.concurrent.Future r3 = com.google.android.gms.internal.ads.zztx.zza(r3, r11)
            r11 = 44
            java.util.concurrent.TimeUnit r12 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ ExecutionException | TimeoutException -> 0x0140, InterruptedException -> 0x010e, all -> 0x010b }
            java.lang.Object r7 = r3.get(r7, r12)     // Catch:{ ExecutionException | TimeoutException -> 0x0140, InterruptedException -> 0x010e, all -> 0x010b }
            com.google.android.gms.internal.ads.zztw r7 = (com.google.android.gms.internal.ads.zztw) r7     // Catch:{ ExecutionException | TimeoutException -> 0x0140, InterruptedException -> 0x010e, all -> 0x010b }
            boolean r8 = r7.zznf()     // Catch:{ ExecutionException | TimeoutException -> 0x0109, InterruptedException -> 0x0107, all -> 0x0105 }
            r14.zzbvt = r8     // Catch:{ ExecutionException | TimeoutException -> 0x0109, InterruptedException -> 0x0107, all -> 0x0105 }
            boolean r8 = r7.zzni()     // Catch:{ ExecutionException | TimeoutException -> 0x0109, InterruptedException -> 0x0107, all -> 0x0105 }
            r14.zzbvw = r8     // Catch:{ ExecutionException | TimeoutException -> 0x0109, InterruptedException -> 0x0107, all -> 0x0105 }
            boolean r8 = r7.zzng()     // Catch:{ ExecutionException | TimeoutException -> 0x0109, InterruptedException -> 0x0107, all -> 0x0105 }
            r14.zzeqc = r8     // Catch:{ ExecutionException | TimeoutException -> 0x0109, InterruptedException -> 0x0107, all -> 0x0105 }
            long r12 = r7.zznh()     // Catch:{ ExecutionException | TimeoutException -> 0x0109, InterruptedException -> 0x0107, all -> 0x0105 }
            r14.zzbvv = r12     // Catch:{ ExecutionException | TimeoutException -> 0x0109, InterruptedException -> 0x0107, all -> 0x0105 }
            boolean r8 = r14.zzadb()     // Catch:{ ExecutionException | TimeoutException -> 0x0109, InterruptedException -> 0x0107, all -> 0x0105 }
            if (r8 != 0) goto L_0x00de
            java.io.InputStream r7 = r7.getInputStream()     // Catch:{ ExecutionException | TimeoutException -> 0x0109, InterruptedException -> 0x0107, all -> 0x0105 }
            r14.zzepz = r7     // Catch:{ ExecutionException | TimeoutException -> 0x0109, InterruptedException -> 0x0107, all -> 0x0105 }
            boolean r7 = r14.zzepy     // Catch:{ ExecutionException | TimeoutException -> 0x0109, InterruptedException -> 0x0107, all -> 0x0105 }
            if (r7 == 0) goto L_0x00b8
            r14.zzb(r15)     // Catch:{ ExecutionException | TimeoutException -> 0x0109, InterruptedException -> 0x0107, all -> 0x0105 }
        L_0x00b8:
            com.google.android.gms.common.util.Clock r15 = com.google.android.gms.ads.internal.zzr.zzlc()
            long r6 = r15.elapsedRealtime()
            long r6 = r6 - r9
            com.google.android.gms.internal.ads.zzbdl r15 = r14.zzepx
            r15.zzb(r2, r6)
            r14.zzeqb = r2
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>(r11)
            r15.append(r1)
            r15.append(r6)
            r15.append(r0)
            java.lang.String r15 = r15.toString()
            com.google.android.gms.ads.internal.util.zzd.zzed(r15)
            return r4
        L_0x00de:
            com.google.android.gms.common.util.Clock r3 = com.google.android.gms.ads.internal.zzr.zzlc()
            long r3 = r3.elapsedRealtime()
            long r3 = r3 - r9
            com.google.android.gms.internal.ads.zzbdl r5 = r14.zzepx
            r5.zzb(r2, r3)
            r14.zzeqb = r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r11)
            r2.append(r1)
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            com.google.android.gms.ads.internal.util.zzd.zzed(r0)
            goto L_0x01ee
        L_0x0105:
            r15 = move-exception
            goto L_0x016d
        L_0x0107:
            r4 = 1
            goto L_0x010f
        L_0x0109:
            r4 = 1
            goto L_0x0141
        L_0x010b:
            r15 = move-exception
            r2 = 0
            goto L_0x016d
        L_0x010e:
            r4 = 0
        L_0x010f:
            r3.cancel(r2)     // Catch:{ all -> 0x016b }
            java.lang.Thread r2 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x016b }
            r2.interrupt()     // Catch:{ all -> 0x016b }
            com.google.android.gms.common.util.Clock r2 = com.google.android.gms.ads.internal.zzr.zzlc()
            long r2 = r2.elapsedRealtime()
            long r2 = r2 - r9
            com.google.android.gms.internal.ads.zzbdl r5 = r14.zzepx
            r5.zzb(r4, r2)
            r14.zzeqb = r4
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r11)
            r4.append(r1)
            r4.append(r2)
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            com.google.android.gms.ads.internal.util.zzd.zzed(r0)
            goto L_0x01ee
        L_0x0140:
            r4 = 0
        L_0x0141:
            r3.cancel(r2)     // Catch:{ all -> 0x016b }
            com.google.android.gms.common.util.Clock r2 = com.google.android.gms.ads.internal.zzr.zzlc()
            long r2 = r2.elapsedRealtime()
            long r2 = r2 - r9
            com.google.android.gms.internal.ads.zzbdl r5 = r14.zzepx
            r5.zzb(r4, r2)
            r14.zzeqb = r4
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r11)
            r4.append(r1)
            r4.append(r2)
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            com.google.android.gms.ads.internal.util.zzd.zzed(r0)
            goto L_0x01ee
        L_0x016b:
            r15 = move-exception
            r2 = r4
        L_0x016d:
            com.google.android.gms.common.util.Clock r3 = com.google.android.gms.ads.internal.zzr.zzlc()
            long r3 = r3.elapsedRealtime()
            long r3 = r3 - r9
            com.google.android.gms.internal.ads.zzbdl r5 = r14.zzepx
            r5.zzb(r2, r3)
            r14.zzeqb = r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r11)
            r2.append(r1)
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            com.google.android.gms.ads.internal.util.zzd.zzed(r0)
            throw r15
        L_0x0193:
            r0 = 0
            com.google.android.gms.internal.ads.zzti r1 = r14.zzeqa
            if (r1 == 0) goto L_0x01b8
            com.google.android.gms.internal.ads.zzti r0 = r14.zzeqa
            long r7 = r15.position
            r0.zzbwd = r7
            com.google.android.gms.internal.ads.zzti r0 = r14.zzeqa
            java.lang.String r1 = r14.zzbwe
            java.lang.String r1 = com.google.android.gms.internal.ads.zzdyq.zzhn(r1)
            r0.zzbwe = r1
            com.google.android.gms.internal.ads.zzti r0 = r14.zzeqa
            int r1 = r14.zzbwf
            r0.zzbwf = r1
            com.google.android.gms.internal.ads.zzta r0 = com.google.android.gms.ads.internal.zzr.zzlb()
            com.google.android.gms.internal.ads.zzti r1 = r14.zzeqa
            com.google.android.gms.internal.ads.zzth r0 = r0.zza((com.google.android.gms.internal.ads.zzti) r1)
        L_0x01b8:
            if (r0 == 0) goto L_0x01ee
            boolean r1 = r0.zznc()
            if (r1 == 0) goto L_0x01ee
            boolean r1 = r0.zznf()
            r14.zzbvt = r1
            boolean r1 = r0.zzni()
            r14.zzbvw = r1
            boolean r1 = r0.zzng()
            r14.zzeqc = r1
            long r7 = r0.zznh()
            r14.zzbvv = r7
            r14.zzeqb = r2
            boolean r1 = r14.zzadb()
            if (r1 != 0) goto L_0x01ee
            java.io.InputStream r0 = r0.zznd()
            r14.zzepz = r0
            boolean r0 = r14.zzepy
            if (r0 == 0) goto L_0x01ed
            r14.zzb(r15)
        L_0x01ed:
            return r4
        L_0x01ee:
            r14.zzeqb = r6
            com.google.android.gms.internal.ads.zzti r0 = r14.zzeqa
            if (r0 == 0) goto L_0x020f
            com.google.android.gms.internal.ads.zzos r0 = new com.google.android.gms.internal.ads.zzos
            com.google.android.gms.internal.ads.zzti r1 = r14.zzeqa
            java.lang.String r1 = r1.url
            android.net.Uri r2 = android.net.Uri.parse(r1)
            byte[] r3 = r15.zzbiv
            long r4 = r15.zzbiw
            long r6 = r15.position
            long r8 = r15.zzco
            java.lang.String r10 = r15.zzcm
            int r11 = r15.flags
            r1 = r0
            r1.<init>(r2, r3, r4, r6, r8, r10, r11)
            r15 = r0
        L_0x020f:
            com.google.android.gms.internal.ads.zzon r0 = r14.zzepw
            long r0 = r0.zza(r15)
            return r0
        L_0x0216:
            java.io.IOException r15 = new java.io.IOException
            java.lang.String r0 = "Attempt to open an already open CacheDataSource."
            r15.<init>(r0)
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbdj.zza(com.google.android.gms.internal.ads.zzos):long");
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        zzpd<zzon> zzpd;
        if (this.isOpen) {
            InputStream inputStream = this.zzepz;
            if (inputStream != null) {
                i3 = inputStream.read(bArr, i, i2);
            } else {
                i3 = this.zzepw.read(bArr, i, i2);
            }
            if ((!this.zzepy || this.zzepz != null) && (zzpd = this.zzepv) != null) {
                zzpd.zzc(this, i3);
            }
            return i3;
        }
        throw new IOException("Attempt to read closed CacheDataSource.");
    }

    public final Uri getUri() {
        return this.uri;
    }

    public final boolean zznf() {
        return this.zzbvt;
    }

    public final boolean zzacz() {
        return this.zzeqb;
    }

    public final boolean zzni() {
        return this.zzbvw;
    }

    public final boolean zzada() {
        return this.zzeqc;
    }

    public final long zznh() {
        return this.zzbvv;
    }

    public final long getContentLength() {
        if (this.zzeqa == null) {
            return -1;
        }
        if (this.zzeqe.get() != -1) {
            return this.zzeqe.get();
        }
        synchronized (this) {
            if (this.zzeqd == null) {
                this.zzeqd = zzbat.zzeke.zze(new zzbdm(this));
            }
        }
        if (!this.zzeqd.isDone()) {
            return -1;
        }
        try {
            this.zzeqe.compareAndSet(-1, ((Long) this.zzeqd.get()).longValue());
            return this.zzeqe.get();
        } catch (InterruptedException | ExecutionException unused) {
            return -1;
        }
    }

    private final void zzb(zzos zzos) {
        zzpd<zzon> zzpd = this.zzepv;
        if (zzpd != null) {
            zzpd.zza(this, zzos);
        }
    }

    private final boolean zzadb() {
        if (!this.zzepy) {
            return false;
        }
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcvd)).booleanValue() && !this.zzbvw) {
            return true;
        }
        if (!((Boolean) zzww.zzra().zzd(zzabq.zzcve)).booleanValue() || this.zzeqc) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Long zzadc() throws Exception {
        return Long.valueOf(zzr.zzlb().zzb(this.zzeqa));
    }
}
