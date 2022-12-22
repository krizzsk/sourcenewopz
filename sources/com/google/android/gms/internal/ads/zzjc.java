package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.view.Surface;
import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzjc extends zzlv implements zzpk {
    private int zzahy;
    private int zzaia;
    /* access modifiers changed from: private */
    public final zzik zzamw;
    private final zzit zzamx;
    private boolean zzamy;
    private boolean zzamz;
    private MediaFormat zzana;
    private long zzanb;
    /* access modifiers changed from: private */
    public boolean zzanc;

    public zzjc(zzlx zzlx, Handler handler, zzil zzil) {
        this(zzlx, (zzjt<zzjv>) null, true, handler, zzil);
    }

    protected static void zzaa(int i) {
    }

    private final boolean zzax(String str) {
        return false;
    }

    protected static void zzb(int i, long j, long j2) {
    }

    protected static void zzgh() {
    }

    public final zzpk zzed() {
        return this;
    }

    private zzjc(zzlx zzlx, zzjt<zzjv> zzjt, boolean z, Handler handler, zzil zzil) {
        this(zzlx, (zzjt<zzjv>) null, true, handler, zzil, (zzig) null, new zzij[0]);
    }

    private zzjc(zzlx zzlx, zzjt<zzjv> zzjt, boolean z, Handler handler, zzil zzil, zzig zzig, zzij... zzijArr) {
        super(1, zzlx, (zzjt<zzjv>) null, true);
        this.zzamx = new zzit((zzig) null, zzijArr, new zzje(this));
        this.zzamw = new zzik(handler, zzil);
    }

    /* access modifiers changed from: protected */
    public final int zza(zzlx zzlx, zzht zzht) throws zzmd {
        String str = zzht.zzaho;
        boolean z = false;
        if (!zzpj.zzbc(str)) {
            return 0;
        }
        int i = zzpt.SDK_INT >= 21 ? 16 : 0;
        int i2 = 3;
        if (zzax(str) && zzlx.zzhn() != null) {
            return i | 4 | 3;
        }
        zzlw zzc = zzlx.zzc(str, false);
        if (zzc == null) {
            return 1;
        }
        if (zzpt.SDK_INT < 21 || ((zzht.zzahz == -1 || zzc.zzaz(zzht.zzahz)) && (zzht.zzahy == -1 || zzc.zzba(zzht.zzahy)))) {
            z = true;
        }
        if (!z) {
            i2 = 2;
        }
        return i | 4 | i2;
    }

    /* access modifiers changed from: protected */
    public final zzlw zza(zzlx zzlx, zzht zzht, boolean z) throws zzmd {
        zzlw zzhn;
        if (!zzax(zzht.zzaho) || (zzhn = zzlx.zzhn()) == null) {
            this.zzamy = false;
            return super.zza(zzlx, zzht, z);
        }
        this.zzamy = true;
        return zzhn;
    }

    /* access modifiers changed from: protected */
    public final void zza(zzlw zzlw, MediaCodec mediaCodec, zzht zzht, MediaCrypto mediaCrypto) {
        this.zzamz = zzpt.SDK_INT < 24 && "OMX.SEC.aac.dec".equals(zzlw.name) && "samsung".equals(zzpt.MANUFACTURER) && (zzpt.DEVICE.startsWith("zeroflte") || zzpt.DEVICE.startsWith("herolte") || zzpt.DEVICE.startsWith("heroqlte"));
        if (this.zzamy) {
            MediaFormat zzfe = zzht.zzfe();
            this.zzana = zzfe;
            zzfe.setString("mime", "audio/raw");
            mediaCodec.configure(this.zzana, (Surface) null, (MediaCrypto) null, 0);
            this.zzana.setString("mime", zzht.zzaho);
            return;
        }
        mediaCodec.configure(zzht.zzfe(), (Surface) null, (MediaCrypto) null, 0);
        this.zzana = null;
    }

    /* access modifiers changed from: protected */
    public final void zzc(String str, long j, long j2) {
        this.zzamw.zza(str, j, j2);
    }

    /* access modifiers changed from: protected */
    public final void zzd(zzht zzht) throws zzhe {
        super.zzd(zzht);
        this.zzamw.zzb(zzht);
        this.zzaia = "audio/raw".equals(zzht.zzaho) ? zzht.zzaia : 2;
        this.zzahy = zzht.zzahy;
    }

    /* access modifiers changed from: protected */
    public final void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) throws zzhe {
        int[] iArr;
        int i;
        boolean z = this.zzana != null;
        String string = z ? this.zzana.getString("mime") : "audio/raw";
        if (z) {
            mediaFormat = this.zzana;
        }
        int integer = mediaFormat.getInteger("channel-count");
        int integer2 = mediaFormat.getInteger("sample-rate");
        if (!this.zzamz || integer != 6 || (i = this.zzahy) >= 6) {
            iArr = null;
        } else {
            iArr = new int[i];
            for (int i2 = 0; i2 < this.zzahy; i2++) {
                iArr[i2] = i2;
            }
        }
        try {
            this.zzamx.zza(string, integer, integer2, this.zzaia, 0, iArr);
        } catch (zzix e) {
            throw zzhe.zza(e, getIndex());
        }
    }

    /* access modifiers changed from: protected */
    public final void zzf(boolean z) throws zzhe {
        super.zzf(z);
        this.zzamw.zza(this.zzbda);
        int i = zzel().zzaip;
        this.zzamx.zzfx();
    }

    /* access modifiers changed from: protected */
    public final void zza(long j, boolean z) throws zzhe {
        super.zza(j, z);
        this.zzamx.reset();
        this.zzanb = j;
        this.zzanc = true;
    }

    /* access modifiers changed from: protected */
    public final void onStarted() {
        super.onStarted();
        this.zzamx.play();
    }

    /* access modifiers changed from: protected */
    public final void onStopped() {
        this.zzamx.pause();
        super.onStopped();
    }

    /* access modifiers changed from: protected */
    public final void zzek() {
        try {
            this.zzamx.release();
            try {
                super.zzek();
            } finally {
                this.zzbda.zzgr();
                this.zzamw.zzb(this.zzbda);
            }
        } catch (Throwable th) {
            super.zzek();
            throw th;
        } finally {
            this.zzbda.zzgr();
            this.zzamw.zzb(this.zzbda);
        }
    }

    public final boolean zzfi() {
        return super.zzfi() && this.zzamx.zzfi();
    }

    public final boolean isReady() {
        return this.zzamx.zzfv() || super.isReady();
    }

    public final long zzgg() {
        long zzk = this.zzamx.zzk(zzfi());
        if (zzk != Long.MIN_VALUE) {
            if (!this.zzanc) {
                zzk = Math.max(this.zzanb, zzk);
            }
            this.zzanb = zzk;
            this.zzanc = false;
        }
        return this.zzanb;
    }

    public final zzhz zzb(zzhz zzhz) {
        return this.zzamx.zzb(zzhz);
    }

    public final zzhz zzfw() {
        return this.zzamx.zzfw();
    }

    /* access modifiers changed from: protected */
    public final boolean zza(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) throws zzhe {
        if (this.zzamy && (i2 & 2) != 0) {
            mediaCodec.releaseOutputBuffer(i, false);
            return true;
        } else if (z) {
            mediaCodec.releaseOutputBuffer(i, false);
            this.zzbda.zzaoo++;
            this.zzamx.zzfs();
            return true;
        } else {
            try {
                if (!this.zzamx.zzb(byteBuffer, j3)) {
                    return false;
                }
                mediaCodec.releaseOutputBuffer(i, false);
                this.zzbda.zzaon++;
                return true;
            } catch (zziw | zzjb e) {
                throw zzhe.zza(e, getIndex());
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void zzgi() throws zzhe {
        try {
            this.zzamx.zzft();
        } catch (zzjb e) {
            throw zzhe.zza(e, getIndex());
        }
    }

    public final void zza(int i, Object obj) throws zzhe {
        if (i == 2) {
            this.zzamx.setVolume(((Float) obj).floatValue());
        } else if (i != 3) {
            super.zza(i, obj);
        } else {
            this.zzamx.setStreamType(((Integer) obj).intValue());
        }
    }
}
