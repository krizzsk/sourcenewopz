package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Point;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import android.view.Surface;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzqe extends zzlv {
    private static final int[] zzbln = {1920, 1600, 1440, 1280, 960, 854, 640, 540, 480};
    private final Context context;
    private int zzaip;
    private boolean zzama;
    private final zzqi zzblo;
    private final zzqj zzblp;
    private final long zzblq;
    private final int zzblr;
    private final boolean zzbls;
    private final long[] zzblt;
    private zzht[] zzblu;
    private zzqg zzblv;
    private Surface zzblw;
    private Surface zzblx;
    private int zzbly;
    private boolean zzblz;
    private long zzbma;
    private long zzbmb;
    private int zzbmc;
    private int zzbmd;
    private int zzbme;
    private float zzbmf;
    private int zzbmg;
    private int zzbmh;
    private int zzbmi;
    private float zzbmj;
    private int zzbmk;
    private int zzbml;
    private int zzbmm;
    private float zzbmn;
    zzqf zzbmo;
    private long zzbmp;
    private int zzbmq;

    public zzqe(Context context2, zzlx zzlx, long j, Handler handler, zzqk zzqk, int i) {
        this(context2, zzlx, 0, (zzjt<zzjv>) null, false, handler, zzqk, -1);
    }

    private static boolean zzem(long j) {
        return j < -30000;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private zzqe(Context context2, zzlx zzlx, long j, zzjt<zzjv> zzjt, boolean z, Handler handler, zzqk zzqk, int i) {
        super(2, zzlx, (zzjt<zzjv>) null, false);
        boolean z2 = false;
        this.zzblq = 0;
        this.zzblr = -1;
        this.context = context2.getApplicationContext();
        this.zzblo = new zzqi(context2);
        this.zzblp = new zzqj(handler, zzqk);
        if (zzpt.SDK_INT <= 22 && "foster".equals(zzpt.DEVICE) && "NVIDIA".equals(zzpt.MANUFACTURER)) {
            z2 = true;
        }
        this.zzbls = z2;
        this.zzblt = new long[10];
        this.zzbmp = -9223372036854775807L;
        this.zzbma = -9223372036854775807L;
        this.zzbmg = -1;
        this.zzbmh = -1;
        this.zzbmj = -1.0f;
        this.zzbmf = -1.0f;
        this.zzbly = 1;
        zzjp();
    }

    /* access modifiers changed from: protected */
    public final int zza(zzlx zzlx, zzht zzht) throws zzmd {
        boolean z;
        String str = zzht.zzaho;
        int i = 0;
        if (!zzpj.zzbd(str)) {
            return 0;
        }
        zzjo zzjo = zzht.zzahr;
        if (zzjo != null) {
            z = false;
            for (int i2 = 0; i2 < zzjo.zzaot; i2++) {
                z |= zzjo.zzaf(i2).zzaox;
            }
        } else {
            z = false;
        }
        zzlw zzc = zzlx.zzc(str, z);
        boolean z2 = true;
        if (zzc == null) {
            return 1;
        }
        boolean zzaz = zzc.zzaz(zzht.zzahl);
        if (zzaz && zzht.width > 0 && zzht.height > 0) {
            if (zzpt.SDK_INT >= 21) {
                zzaz = zzc.zza(zzht.width, zzht.height, (double) zzht.zzahs);
            } else {
                if (zzht.width * zzht.height > zzlz.zzho()) {
                    z2 = false;
                }
                if (!z2) {
                    int i3 = zzht.width;
                    int i4 = zzht.height;
                    String str2 = zzpt.zzbkx;
                    StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 56);
                    sb.append("FalseCheck [legacyFrameSize, ");
                    sb.append(i3);
                    sb.append("x");
                    sb.append(i4);
                    sb.append("] [");
                    sb.append(str2);
                    sb.append(Const.jaRight);
                    SystemUtils.log(3, "MediaCodecVideoRenderer", sb.toString(), (Throwable) null, "com.google.android.gms.internal.ads.zzqe", 40);
                }
                zzaz = z2;
            }
        }
        int i5 = zzc.zzbdb ? 8 : 4;
        if (zzc.zzama) {
            i = 16;
        }
        return (zzaz ? 3 : 2) | i5 | i;
    }

    /* access modifiers changed from: protected */
    public final void zzf(boolean z) throws zzhe {
        super.zzf(z);
        int i = zzel().zzaip;
        this.zzaip = i;
        this.zzama = i != 0;
        this.zzblp.zza(this.zzbda);
        this.zzblo.enable();
    }

    /* access modifiers changed from: protected */
    public final void zza(zzht[] zzhtArr, long j) throws zzhe {
        this.zzblu = zzhtArr;
        if (this.zzbmp == -9223372036854775807L) {
            this.zzbmp = j;
        } else {
            int i = this.zzbmq;
            long[] jArr = this.zzblt;
            if (i == jArr.length) {
                long j2 = jArr[i - 1];
                StringBuilder sb = new StringBuilder(65);
                sb.append("Too many stream changes, so dropping offset: ");
                sb.append(j2);
                SystemUtils.log(5, "MediaCodecVideoRenderer", sb.toString(), (Throwable) null, "com.google.android.gms.internal.ads.zzqe", 55);
            } else {
                this.zzbmq = i + 1;
            }
            this.zzblt[this.zzbmq - 1] = j;
        }
        super.zza(zzhtArr, j);
    }

    /* access modifiers changed from: protected */
    public final void zza(long j, boolean z) throws zzhe {
        super.zza(j, z);
        zzjn();
        this.zzbmd = 0;
        int i = this.zzbmq;
        if (i != 0) {
            this.zzbmp = this.zzblt[i - 1];
            this.zzbmq = 0;
        }
        if (z) {
            zzjm();
        } else {
            this.zzbma = -9223372036854775807L;
        }
    }

    public final boolean isReady() {
        Surface surface;
        if (super.isReady() && (this.zzblz || (((surface = this.zzblx) != null && this.zzblw == surface) || zzhh() == null))) {
            this.zzbma = -9223372036854775807L;
            return true;
        } else if (this.zzbma == -9223372036854775807L) {
            return false;
        } else {
            if (SystemClock.elapsedRealtime() < this.zzbma) {
                return true;
            }
            this.zzbma = -9223372036854775807L;
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public final void onStarted() {
        super.onStarted();
        this.zzbmc = 0;
        this.zzbmb = SystemClock.elapsedRealtime();
        this.zzbma = -9223372036854775807L;
    }

    /* access modifiers changed from: protected */
    public final void onStopped() {
        zzjs();
        super.onStopped();
    }

    /* access modifiers changed from: protected */
    public final void zzek() {
        this.zzbmg = -1;
        this.zzbmh = -1;
        this.zzbmj = -1.0f;
        this.zzbmf = -1.0f;
        this.zzbmp = -9223372036854775807L;
        this.zzbmq = 0;
        zzjp();
        zzjn();
        this.zzblo.disable();
        this.zzbmo = null;
        this.zzama = false;
        try {
            super.zzek();
        } finally {
            this.zzbda.zzgr();
            this.zzblp.zzb(this.zzbda);
        }
    }

    public final void zza(int i, Object obj) throws zzhe {
        if (i == 1) {
            Surface surface = (Surface) obj;
            if (surface == null) {
                Surface surface2 = this.zzblx;
                if (surface2 != null) {
                    surface = surface2;
                } else {
                    zzlw zzhi = zzhi();
                    if (zzhi != null && zzo(zzhi.zzbdc)) {
                        surface = zzqa.zzc(this.context, zzhi.zzbdc);
                        this.zzblx = surface;
                    }
                }
            }
            if (this.zzblw != surface) {
                this.zzblw = surface;
                int state = getState();
                if (state == 1 || state == 2) {
                    MediaCodec zzhh = zzhh();
                    if (zzpt.SDK_INT < 23 || zzhh == null || surface == null) {
                        zzhj();
                        zzhg();
                    } else {
                        zzhh.setOutputSurface(surface);
                    }
                }
                if (surface == null || surface == this.zzblx) {
                    zzjp();
                    zzjn();
                    return;
                }
                zzjr();
                zzjn();
                if (state == 2) {
                    zzjm();
                }
            } else if (surface != null && surface != this.zzblx) {
                zzjr();
                if (this.zzblz) {
                    this.zzblp.zza(this.zzblw);
                }
            }
        } else if (i == 4) {
            this.zzbly = ((Integer) obj).intValue();
            MediaCodec zzhh2 = zzhh();
            if (zzhh2 != null) {
                zzhh2.setVideoScalingMode(this.zzbly);
            }
        } else {
            super.zza(i, obj);
        }
    }

    /* access modifiers changed from: protected */
    public final boolean zza(zzlw zzlw) {
        return this.zzblw != null || zzo(zzlw.zzbdc);
    }

    /* access modifiers changed from: protected */
    public final void zza(zzlw zzlw, MediaCodec mediaCodec, zzht zzht, MediaCrypto mediaCrypto) throws zzmd {
        zzqg zzqg;
        Point point;
        zzlw zzlw2 = zzlw;
        MediaCodec mediaCodec2 = mediaCodec;
        zzht zzht2 = zzht;
        zzht[] zzhtArr = this.zzblu;
        int i = zzht2.width;
        int i2 = zzht2.height;
        int zzi = zzi(zzht);
        if (zzhtArr.length == 1) {
            zzqg = new zzqg(i, i2, zzi);
        } else {
            boolean z = false;
            for (zzht zzht3 : zzhtArr) {
                if (zza(zzlw2.zzbdb, zzht2, zzht3)) {
                    z |= zzht3.width == -1 || zzht3.height == -1;
                    i = Math.max(i, zzht3.width);
                    i2 = Math.max(i2, zzht3.height);
                    zzi = Math.max(zzi, zzi(zzht3));
                }
            }
            if (z) {
                StringBuilder sb = new StringBuilder(66);
                sb.append("Resolutions unknown. Codec max resolution: ");
                sb.append(i);
                sb.append("x");
                sb.append(i2);
                SystemUtils.log(5, "MediaCodecVideoRenderer", sb.toString(), (Throwable) null, "com.google.android.gms.internal.ads.zzqe", 164);
                boolean z2 = zzht2.height > zzht2.width;
                int i3 = z2 ? zzht2.height : zzht2.width;
                int i4 = z2 ? zzht2.width : zzht2.height;
                float f = ((float) i4) / ((float) i3);
                int[] iArr = zzbln;
                int length = iArr.length;
                int i5 = 0;
                while (true) {
                    if (i5 >= length) {
                        break;
                    }
                    int i6 = iArr[i5];
                    int i7 = length;
                    int i8 = (int) (((float) i6) * f);
                    if (i6 <= i3 || i8 <= i4) {
                        break;
                    }
                    int i9 = i3;
                    int i10 = i4;
                    if (zzpt.SDK_INT >= 21) {
                        int i11 = z2 ? i8 : i6;
                        if (!z2) {
                            i6 = i8;
                        }
                        Point zzf = zzlw2.zzf(i11, i6);
                        Point point2 = zzf;
                        if (zzlw2.zza(zzf.x, zzf.y, (double) zzht2.zzahs)) {
                            point = point2;
                            break;
                        }
                    } else {
                        int zzh = zzpt.zzh(i6, 16) << 4;
                        int zzh2 = zzpt.zzh(i8, 16) << 4;
                        if (zzh * zzh2 <= zzlz.zzho()) {
                            int i12 = z2 ? zzh2 : zzh;
                            if (!z2) {
                                zzh = zzh2;
                            }
                            point = new Point(i12, zzh);
                        }
                    }
                    i5++;
                    length = i7;
                    i3 = i9;
                    i4 = i10;
                }
                point = null;
                if (point != null) {
                    i = Math.max(i, point.x);
                    i2 = Math.max(i2, point.y);
                    zzi = Math.max(zzi, zza(zzht2.zzaho, i, i2));
                    StringBuilder sb2 = new StringBuilder(57);
                    sb2.append("Codec max resolution adjusted to: ");
                    sb2.append(i);
                    sb2.append("x");
                    sb2.append(i2);
                    SystemUtils.log(5, "MediaCodecVideoRenderer", sb2.toString(), (Throwable) null, "com.google.android.gms.internal.ads.zzqe", 197);
                }
            }
            zzqg = new zzqg(i, i2, zzi);
        }
        this.zzblv = zzqg;
        boolean z3 = this.zzbls;
        int i13 = this.zzaip;
        MediaFormat zzfe = zzht.zzfe();
        zzfe.setInteger("max-width", zzqg.width);
        zzfe.setInteger("max-height", zzqg.height);
        if (zzqg.zzbms != -1) {
            zzfe.setInteger("max-input-size", zzqg.zzbms);
        }
        if (z3) {
            zzfe.setInteger("auto-frc", 0);
        }
        if (i13 != 0) {
            zzfe.setFeatureEnabled("tunneled-playback", true);
            zzfe.setInteger("audio-session-id", i13);
        }
        if (this.zzblw == null) {
            zzpg.checkState(zzo(zzlw2.zzbdc));
            if (this.zzblx == null) {
                this.zzblx = zzqa.zzc(this.context, zzlw2.zzbdc);
            }
            this.zzblw = this.zzblx;
        }
        mediaCodec2.configure(zzfe, this.zzblw, (MediaCrypto) null, 0);
        if (zzpt.SDK_INT >= 23 && this.zzama) {
            this.zzbmo = new zzqf(this, mediaCodec2);
        }
    }

    /* access modifiers changed from: protected */
    public final void zzhj() {
        try {
            super.zzhj();
        } finally {
            Surface surface = this.zzblx;
            if (surface != null) {
                if (this.zzblw == surface) {
                    this.zzblw = null;
                }
                this.zzblx.release();
                this.zzblx = null;
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void zzc(String str, long j, long j2) {
        this.zzblp.zza(str, j, j2);
    }

    /* access modifiers changed from: protected */
    public final void zzd(zzht zzht) throws zzhe {
        super.zzd(zzht);
        this.zzblp.zzb(zzht);
        this.zzbmf = zzht.zzahu == -1.0f ? 1.0f : zzht.zzahu;
        this.zzbme = zzj(zzht);
    }

    /* access modifiers changed from: protected */
    public final void zza(zzjp zzjp) {
        if (zzpt.SDK_INT < 23 && this.zzama) {
            zzjo();
        }
    }

    /* access modifiers changed from: protected */
    public final void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        int i;
        int i2;
        boolean z = mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top");
        if (z) {
            i = (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1;
        } else {
            i = mediaFormat.getInteger("width");
        }
        this.zzbmg = i;
        if (z) {
            i2 = (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1;
        } else {
            i2 = mediaFormat.getInteger("height");
        }
        this.zzbmh = i2;
        this.zzbmj = this.zzbmf;
        if (zzpt.SDK_INT >= 21) {
            int i3 = this.zzbme;
            if (i3 == 90 || i3 == 270) {
                int i4 = this.zzbmg;
                this.zzbmg = this.zzbmh;
                this.zzbmh = i4;
                this.zzbmj = 1.0f / this.zzbmj;
            }
        } else {
            this.zzbmi = this.zzbme;
        }
        mediaCodec.setVideoScalingMode(this.zzbly);
    }

    /* access modifiers changed from: protected */
    public final boolean zza(MediaCodec mediaCodec, boolean z, zzht zzht, zzht zzht2) {
        return zza(z, zzht, zzht2) && zzht2.width <= this.zzblv.width && zzht2.height <= this.zzblv.height && zzht2.zzahp <= this.zzblv.zzbms;
    }

    /* access modifiers changed from: protected */
    public final boolean zza(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) {
        MediaCodec mediaCodec2 = mediaCodec;
        int i3 = i;
        long j4 = j3;
        while (true) {
            int i4 = this.zzbmq;
            if (i4 == 0) {
                break;
            }
            long[] jArr = this.zzblt;
            if (j4 < jArr[0]) {
                break;
            }
            this.zzbmp = jArr[0];
            int i5 = i4 - 1;
            this.zzbmq = i5;
            System.arraycopy(jArr, 1, jArr, 0, i5);
        }
        long j5 = j4 - this.zzbmp;
        if (z) {
            zza(mediaCodec2, i3, j5);
            return true;
        }
        long j6 = j4 - j;
        if (this.zzblw == this.zzblx) {
            if (!zzem(j6)) {
                return false;
            }
            zza(mediaCodec2, i3, j5);
            return true;
        } else if (!this.zzblz) {
            if (zzpt.SDK_INT >= 21) {
                zza(mediaCodec, i, j5, System.nanoTime());
            } else {
                zzb(mediaCodec2, i3, j5);
            }
            return true;
        } else if (getState() != 2) {
            return false;
        } else {
            long elapsedRealtime = j6 - ((SystemClock.elapsedRealtime() * 1000) - j2);
            long nanoTime = System.nanoTime();
            long zzf = this.zzblo.zzf(j4, (elapsedRealtime * 1000) + nanoTime);
            long j7 = (zzf - nanoTime) / 1000;
            if (zzem(j7)) {
                zzpu.beginSection("dropVideoBuffer");
                mediaCodec2.releaseOutputBuffer(i3, false);
                zzpu.endSection();
                this.zzbda.zzaop++;
                this.zzbmc++;
                this.zzbmd++;
                this.zzbda.zzaoq = Math.max(this.zzbmd, this.zzbda.zzaoq);
                if (this.zzbmc == this.zzblr) {
                    zzjs();
                }
                return true;
            }
            if (zzpt.SDK_INT >= 21) {
                if (j7 < 50000) {
                    zza(mediaCodec, i, j5, zzf);
                    return true;
                }
            } else if (j7 < 30000) {
                if (j7 > 11000) {
                    try {
                        Thread.sleep((j7 - 10000) / 1000);
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
                zzb(mediaCodec2, i3, j5);
                return true;
            }
            return false;
        }
    }

    private final void zza(MediaCodec mediaCodec, int i, long j) {
        zzpu.beginSection("skipVideoBuffer");
        mediaCodec.releaseOutputBuffer(i, false);
        zzpu.endSection();
        this.zzbda.zzaoo++;
    }

    private final void zzb(MediaCodec mediaCodec, int i, long j) {
        zzjq();
        zzpu.beginSection("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, true);
        zzpu.endSection();
        this.zzbda.zzaon++;
        this.zzbmd = 0;
        zzjo();
    }

    private final void zza(MediaCodec mediaCodec, int i, long j, long j2) {
        zzjq();
        zzpu.beginSection("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, j2);
        zzpu.endSection();
        this.zzbda.zzaon++;
        this.zzbmd = 0;
        zzjo();
    }

    private final boolean zzo(boolean z) {
        if (zzpt.SDK_INT < 23 || this.zzama) {
            return false;
        }
        return !z || zzqa.zzc(this.context);
    }

    private final void zzjm() {
        this.zzbma = -9223372036854775807L;
    }

    private final void zzjn() {
        MediaCodec zzhh;
        this.zzblz = false;
        if (zzpt.SDK_INT >= 23 && this.zzama && (zzhh = zzhh()) != null) {
            this.zzbmo = new zzqf(this, zzhh);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzjo() {
        if (!this.zzblz) {
            this.zzblz = true;
            this.zzblp.zza(this.zzblw);
        }
    }

    private final void zzjp() {
        this.zzbmk = -1;
        this.zzbml = -1;
        this.zzbmn = -1.0f;
        this.zzbmm = -1;
    }

    private final void zzjq() {
        if (this.zzbmk != this.zzbmg || this.zzbml != this.zzbmh || this.zzbmm != this.zzbmi || this.zzbmn != this.zzbmj) {
            this.zzblp.zza(this.zzbmg, this.zzbmh, this.zzbmi, this.zzbmj);
            this.zzbmk = this.zzbmg;
            this.zzbml = this.zzbmh;
            this.zzbmm = this.zzbmi;
            this.zzbmn = this.zzbmj;
        }
    }

    private final void zzjr() {
        if (this.zzbmk != -1 || this.zzbml != -1) {
            this.zzblp.zza(this.zzbmg, this.zzbmh, this.zzbmi, this.zzbmj);
        }
    }

    private final void zzjs() {
        if (this.zzbmc > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.zzblp.zzf(this.zzbmc, elapsedRealtime - this.zzbmb);
            this.zzbmc = 0;
            this.zzbmb = elapsedRealtime;
        }
    }

    private static int zzi(zzht zzht) {
        if (zzht.zzahp != -1) {
            return zzht.zzahp;
        }
        return zza(zzht.zzaho, zzht.width, zzht.height);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int zza(java.lang.String r7, int r8, int r9) {
        /*
            r0 = -1
            if (r8 == r0) goto L_0x0086
            if (r9 != r0) goto L_0x0007
            goto L_0x0086
        L_0x0007:
            int r1 = r7.hashCode()
            r2 = 5
            r3 = 1
            r4 = 3
            r5 = 4
            r6 = 2
            switch(r1) {
                case -1664118616: goto L_0x0046;
                case -1662541442: goto L_0x003c;
                case 1187890754: goto L_0x0032;
                case 1331836730: goto L_0x0028;
                case 1599127256: goto L_0x001e;
                case 1599127257: goto L_0x0014;
                default: goto L_0x0013;
            }
        L_0x0013:
            goto L_0x0050
        L_0x0014:
            java.lang.String r1 = "video/x-vnd.on2.vp9"
            boolean r7 = r7.equals(r1)
            if (r7 == 0) goto L_0x0050
            r7 = 5
            goto L_0x0051
        L_0x001e:
            java.lang.String r1 = "video/x-vnd.on2.vp8"
            boolean r7 = r7.equals(r1)
            if (r7 == 0) goto L_0x0050
            r7 = 3
            goto L_0x0051
        L_0x0028:
            java.lang.String r1 = "video/avc"
            boolean r7 = r7.equals(r1)
            if (r7 == 0) goto L_0x0050
            r7 = 2
            goto L_0x0051
        L_0x0032:
            java.lang.String r1 = "video/mp4v-es"
            boolean r7 = r7.equals(r1)
            if (r7 == 0) goto L_0x0050
            r7 = 1
            goto L_0x0051
        L_0x003c:
            java.lang.String r1 = "video/hevc"
            boolean r7 = r7.equals(r1)
            if (r7 == 0) goto L_0x0050
            r7 = 4
            goto L_0x0051
        L_0x0046:
            java.lang.String r1 = "video/3gpp"
            boolean r7 = r7.equals(r1)
            if (r7 == 0) goto L_0x0050
            r7 = 0
            goto L_0x0051
        L_0x0050:
            r7 = -1
        L_0x0051:
            if (r7 == 0) goto L_0x007d
            if (r7 == r3) goto L_0x007d
            if (r7 == r6) goto L_0x0061
            if (r7 == r4) goto L_0x007d
            if (r7 == r5) goto L_0x005e
            if (r7 == r2) goto L_0x005e
            return r0
        L_0x005e:
            int r8 = r8 * r9
            goto L_0x0080
        L_0x0061:
            java.lang.String r7 = com.google.android.gms.internal.ads.zzpt.MODEL
            java.lang.String r1 = "BRAVIA 4K 2015"
            boolean r7 = r1.equals(r7)
            if (r7 == 0) goto L_0x006c
            return r0
        L_0x006c:
            r7 = 16
            int r8 = com.google.android.gms.internal.ads.zzpt.zzh(r8, r7)
            int r7 = com.google.android.gms.internal.ads.zzpt.zzh(r9, r7)
            int r8 = r8 * r7
            int r7 = r8 << 4
            int r8 = r7 << 4
            goto L_0x007f
        L_0x007d:
            int r8 = r8 * r9
        L_0x007f:
            r5 = 2
        L_0x0080:
            int r8 = r8 * 3
            int r5 = r5 * 2
            int r8 = r8 / r5
            return r8
        L_0x0086:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzqe.zza(java.lang.String, int, int):int");
    }

    private static boolean zza(boolean z, zzht zzht, zzht zzht2) {
        if (!zzht.zzaho.equals(zzht2.zzaho) || zzj(zzht) != zzj(zzht2)) {
            return false;
        }
        if (!z) {
            return zzht.width == zzht2.width && zzht.height == zzht2.height;
        }
        return true;
    }

    private static int zzj(zzht zzht) {
        if (zzht.zzaht == -1) {
            return 0;
        }
        return zzht.zzaht;
    }
}
