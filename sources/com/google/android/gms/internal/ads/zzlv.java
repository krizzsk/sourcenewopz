package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Looper;
import android.os.SystemClock;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public abstract class zzlv extends zzhd {
    private static final byte[] zzbbq = zzpt.zzbi("0000016742C00BDA259000000168CE0F13200000016588840DCE7118A0002FBF1C31C3275D78");
    private zzht zzaij;
    private ByteBuffer[] zzalr;
    private final zzlx zzbbr;
    private final zzjt<zzjv> zzbbs;
    private final boolean zzbbt;
    private final zzjp zzbbu;
    private final zzjp zzbbv;
    private final zzhv zzbbw;
    private final List<Long> zzbbx;
    private final MediaCodec.BufferInfo zzbby;
    private zzjr<zzjv> zzbbz;
    private zzjr<zzjv> zzbca;
    private MediaCodec zzbcb;
    private zzlw zzbcc;
    private boolean zzbcd;
    private boolean zzbce;
    private boolean zzbcf;
    private boolean zzbcg;
    private boolean zzbch;
    private boolean zzbci;
    private boolean zzbcj;
    private boolean zzbck;
    private boolean zzbcl;
    private ByteBuffer[] zzbcm;
    private long zzbcn;
    private int zzbco;
    private int zzbcp;
    private boolean zzbcq;
    private boolean zzbcr;
    private int zzbcs;
    private int zzbct;
    private boolean zzbcu;
    private boolean zzbcv;
    private boolean zzbcw;
    private boolean zzbcx;
    private boolean zzbcy;
    private boolean zzbcz;
    protected zzjm zzbda;

    public zzlv(int i, zzlx zzlx, zzjt<zzjv> zzjt, boolean z) {
        super(i);
        zzpg.checkState(zzpt.SDK_INT >= 16);
        this.zzbbr = (zzlx) zzpg.checkNotNull(zzlx);
        this.zzbbs = null;
        this.zzbbt = z;
        this.zzbbu = new zzjp(0);
        this.zzbbv = new zzjp(0);
        this.zzbbw = new zzhv();
        this.zzbbx = new ArrayList();
        this.zzbby = new MediaCodec.BufferInfo();
        this.zzbcs = 0;
        this.zzbct = 0;
    }

    /* access modifiers changed from: protected */
    public void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) throws zzhe {
    }

    /* access modifiers changed from: protected */
    public void onStarted() {
    }

    /* access modifiers changed from: protected */
    public void onStopped() {
    }

    /* access modifiers changed from: protected */
    public abstract int zza(zzlx zzlx, zzht zzht) throws zzmd;

    /* access modifiers changed from: protected */
    public void zza(zzjp zzjp) {
    }

    /* access modifiers changed from: protected */
    public abstract void zza(zzlw zzlw, MediaCodec mediaCodec, zzht zzht, MediaCrypto mediaCrypto) throws zzmd;

    /* access modifiers changed from: protected */
    public abstract boolean zza(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) throws zzhe;

    /* access modifiers changed from: protected */
    public boolean zza(MediaCodec mediaCodec, boolean z, zzht zzht, zzht zzht2) {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean zza(zzlw zzlw) {
        return true;
    }

    /* access modifiers changed from: protected */
    public void zzc(String str, long j, long j2) {
    }

    public final int zzej() {
        return 4;
    }

    /* access modifiers changed from: protected */
    public void zzgi() throws zzhe {
    }

    public final int zza(zzht zzht) throws zzhe {
        try {
            return zza(this.zzbbr, zzht);
        } catch (zzmd e) {
            throw zzhe.zza(e, getIndex());
        }
    }

    /* access modifiers changed from: protected */
    public zzlw zza(zzlx zzlx, zzht zzht, boolean z) throws zzmd {
        return zzlx.zzc(zzht.zzaho, z);
    }

    /* access modifiers changed from: protected */
    public final void zzhg() throws zzhe {
        zzht zzht;
        if (this.zzbcb == null && (zzht = this.zzaij) != null) {
            this.zzbbz = this.zzbca;
            String str = zzht.zzaho;
            zzjr<zzjv> zzjr = this.zzbbz;
            if (zzjr != null) {
                int state = zzjr.getState();
                if (state == 0) {
                    throw zzhe.zza(this.zzbbz.zzgt(), getIndex());
                } else if (state == 3 || state == 4) {
                    zzjv zzgs = this.zzbbz.zzgs();
                    throw new NoSuchMethodError();
                }
            } else {
                if (this.zzbcc == null) {
                    try {
                        this.zzbcc = zza(this.zzbbr, this.zzaij, false);
                    } catch (zzmd e) {
                        zza(new zzly(this.zzaij, (Throwable) e, false, -49998));
                    }
                    if (this.zzbcc == null) {
                        zza(new zzly(this.zzaij, (Throwable) null, false, -49999));
                    }
                }
                if (zza(this.zzbcc)) {
                    String str2 = this.zzbcc.name;
                    this.zzbcd = zzpt.SDK_INT < 21 && this.zzaij.zzahq.isEmpty() && "OMX.MTK.VIDEO.DECODER.AVC".equals(str2);
                    this.zzbce = zzpt.SDK_INT < 18 || (zzpt.SDK_INT == 18 && ("OMX.SEC.avc.dec".equals(str2) || "OMX.SEC.avc.dec.secure".equals(str2))) || (zzpt.SDK_INT == 19 && zzpt.MODEL.startsWith("SM-G800") && ("OMX.Exynos.avc.dec".equals(str2) || "OMX.Exynos.avc.dec.secure".equals(str2)));
                    this.zzbcf = zzpt.SDK_INT < 24 && ("OMX.Nvidia.h264.decode".equals(str2) || "OMX.Nvidia.h264.decode.secure".equals(str2)) && ("flounder".equals(zzpt.DEVICE) || "flounder_lte".equals(zzpt.DEVICE) || "grouper".equals(zzpt.DEVICE) || "tilapia".equals(zzpt.DEVICE));
                    this.zzbcg = zzpt.SDK_INT <= 17 && ("OMX.rk.video_decoder.avc".equals(str2) || "OMX.allwinner.video.decoder.avc".equals(str2));
                    this.zzbch = (zzpt.SDK_INT <= 23 && "OMX.google.vorbis.decoder".equals(str2)) || (zzpt.SDK_INT <= 19 && "hb2000".equals(zzpt.DEVICE) && ("OMX.amlogic.avc.decoder.awesome".equals(str2) || "OMX.amlogic.avc.decoder.awesome.secure".equals(str2)));
                    this.zzbci = zzpt.SDK_INT == 21 && "OMX.google.aac.decoder".equals(str2);
                    this.zzbcj = zzpt.SDK_INT <= 18 && this.zzaij.zzahy == 1 && "OMX.MTK.AUDIO.DECODER.MP3".equals(str2);
                    try {
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        String valueOf = String.valueOf(str2);
                        zzpu.beginSection(valueOf.length() != 0 ? "createCodec:".concat(valueOf) : new String("createCodec:"));
                        this.zzbcb = MediaCodec.createByCodecName(str2);
                        zzpu.endSection();
                        zzpu.beginSection("configureCodec");
                        zza(this.zzbcc, this.zzbcb, this.zzaij, (MediaCrypto) null);
                        zzpu.endSection();
                        zzpu.beginSection("startCodec");
                        this.zzbcb.start();
                        zzpu.endSection();
                        long elapsedRealtime2 = SystemClock.elapsedRealtime();
                        zzc(str2, elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
                        this.zzbcm = this.zzbcb.getInputBuffers();
                        this.zzalr = this.zzbcb.getOutputBuffers();
                    } catch (Exception e2) {
                        zza(new zzly(this.zzaij, (Throwable) e2, false, str2));
                    }
                    this.zzbcn = getState() == 2 ? SystemClock.elapsedRealtime() + 1000 : -9223372036854775807L;
                    this.zzbco = -1;
                    this.zzbcp = -1;
                    this.zzbcz = true;
                    this.zzbda.zzaok++;
                }
            }
        }
    }

    private final void zza(zzly zzly) throws zzhe {
        throw zzhe.zza(zzly, getIndex());
    }

    /* access modifiers changed from: protected */
    public final MediaCodec zzhh() {
        return this.zzbcb;
    }

    /* access modifiers changed from: protected */
    public final zzlw zzhi() {
        return this.zzbcc;
    }

    /* access modifiers changed from: protected */
    public void zzf(boolean z) throws zzhe {
        this.zzbda = new zzjm();
    }

    /* access modifiers changed from: protected */
    public void zza(long j, boolean z) throws zzhe {
        this.zzbcw = false;
        this.zzbcx = false;
        if (this.zzbcb != null) {
            this.zzbcn = -9223372036854775807L;
            this.zzbco = -1;
            this.zzbcp = -1;
            this.zzbcz = true;
            this.zzbcy = false;
            this.zzbcq = false;
            this.zzbbx.clear();
            this.zzbck = false;
            this.zzbcl = false;
            if (this.zzbce || (this.zzbch && this.zzbcv)) {
                zzhj();
                zzhg();
            } else if (this.zzbct != 0) {
                zzhj();
                zzhg();
            } else {
                this.zzbcb.flush();
                this.zzbcu = false;
            }
            if (this.zzbcr && this.zzaij != null) {
                this.zzbcs = 1;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void zzek() {
        this.zzaij = null;
        try {
            zzhj();
            try {
                if (this.zzbbz != null) {
                    this.zzbbs.zza(this.zzbbz);
                }
                try {
                    if (!(this.zzbca == null || this.zzbca == this.zzbbz)) {
                        this.zzbbs.zza(this.zzbca);
                    }
                } finally {
                    this.zzbbz = null;
                    this.zzbca = null;
                }
            } catch (Throwable th) {
                if (!(this.zzbca == null || this.zzbca == this.zzbbz)) {
                    this.zzbbs.zza(this.zzbca);
                }
                throw th;
            } finally {
                this.zzbbz = null;
                this.zzbca = null;
            }
        } catch (Throwable th2) {
            try {
                if (!(this.zzbca == null || this.zzbca == this.zzbbz)) {
                    this.zzbbs.zza(this.zzbca);
                }
                throw th2;
            } finally {
                this.zzbbz = null;
                this.zzbca = null;
            }
        } finally {
        }
    }

    /* access modifiers changed from: protected */
    public void zzhj() {
        this.zzbcn = -9223372036854775807L;
        this.zzbco = -1;
        this.zzbcp = -1;
        this.zzbcy = false;
        this.zzbcq = false;
        this.zzbbx.clear();
        this.zzbcm = null;
        this.zzalr = null;
        this.zzbcc = null;
        this.zzbcr = false;
        this.zzbcu = false;
        this.zzbcd = false;
        this.zzbce = false;
        this.zzbcf = false;
        this.zzbcg = false;
        this.zzbch = false;
        this.zzbcj = false;
        this.zzbck = false;
        this.zzbcl = false;
        this.zzbcv = false;
        this.zzbcs = 0;
        this.zzbct = 0;
        this.zzbbu.zzdr = null;
        if (this.zzbcb != null) {
            this.zzbda.zzaol++;
            try {
                this.zzbcb.stop();
                try {
                    this.zzbcb.release();
                    this.zzbcb = null;
                    zzjr<zzjv> zzjr = this.zzbbz;
                    if (zzjr != null && this.zzbca != zzjr) {
                        try {
                            this.zzbbs.zza(zzjr);
                        } finally {
                            this.zzbbz = null;
                        }
                    }
                } catch (Throwable th) {
                    this.zzbcb = null;
                    zzjr<zzjv> zzjr2 = this.zzbbz;
                    if (!(zzjr2 == null || this.zzbca == zzjr2)) {
                        this.zzbbs.zza(zzjr2);
                    }
                    throw th;
                } finally {
                    this.zzbbz = null;
                }
            } catch (Throwable th2) {
                this.zzbcb = null;
                zzjr<zzjv> zzjr3 = this.zzbbz;
                if (!(zzjr3 == null || this.zzbca == zzjr3)) {
                    try {
                        this.zzbbs.zza(zzjr3);
                    } finally {
                        this.zzbbz = null;
                    }
                }
                throw th2;
            } finally {
            }
        }
    }

    public final void zzb(long j, long j2) throws zzhe {
        if (this.zzbcx) {
            zzgi();
            return;
        }
        if (this.zzaij == null) {
            this.zzbbv.clear();
            int zza = zza(this.zzbbw, this.zzbbv, true);
            if (zza == -5) {
                zzd(this.zzbbw.zzaij);
            } else if (zza == -4) {
                zzpg.checkState(this.zzbbv.zzgm());
                this.zzbcw = true;
                zzhl();
                return;
            } else {
                return;
            }
        }
        zzhg();
        if (this.zzbcb != null) {
            zzpu.beginSection("drainAndFeed");
            do {
            } while (zzd(j, j2));
            do {
            } while (zzhk());
            zzpu.endSection();
        } else {
            zzdn(j);
            this.zzbbv.clear();
            int zza2 = zza(this.zzbbw, this.zzbbv, false);
            if (zza2 == -5) {
                zzd(this.zzbbw.zzaij);
            } else if (zza2 == -4) {
                zzpg.checkState(this.zzbbv.zzgm());
                this.zzbcw = true;
                zzhl();
            }
        }
        this.zzbda.zzgr();
    }

    /* JADX WARNING: Removed duplicated region for block: B:84:0x0149 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x014a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzhk() throws com.google.android.gms.internal.ads.zzhe {
        /*
            r14 = this;
            android.media.MediaCodec r0 = r14.zzbcb
            r1 = 0
            if (r0 == 0) goto L_0x01d4
            int r2 = r14.zzbct
            r3 = 2
            if (r2 == r3) goto L_0x01d4
            boolean r2 = r14.zzbcw
            if (r2 == 0) goto L_0x0010
            goto L_0x01d4
        L_0x0010:
            int r2 = r14.zzbco
            if (r2 >= 0) goto L_0x002c
            r4 = 0
            int r0 = r0.dequeueInputBuffer(r4)
            r14.zzbco = r0
            if (r0 >= 0) goto L_0x001f
            return r1
        L_0x001f:
            com.google.android.gms.internal.ads.zzjp r2 = r14.zzbbu
            java.nio.ByteBuffer[] r4 = r14.zzbcm
            r0 = r4[r0]
            r2.zzdr = r0
            com.google.android.gms.internal.ads.zzjp r0 = r14.zzbbu
            r0.clear()
        L_0x002c:
            int r0 = r14.zzbct
            r2 = -1
            r4 = 1
            if (r0 != r4) goto L_0x0049
            boolean r0 = r14.zzbcg
            if (r0 != 0) goto L_0x0046
            r14.zzbcv = r4
            android.media.MediaCodec r5 = r14.zzbcb
            int r6 = r14.zzbco
            r7 = 0
            r8 = 0
            r9 = 0
            r11 = 4
            r5.queueInputBuffer(r6, r7, r8, r9, r11)
            r14.zzbco = r2
        L_0x0046:
            r14.zzbct = r3
            return r1
        L_0x0049:
            boolean r0 = r14.zzbck
            if (r0 == 0) goto L_0x006b
            r14.zzbck = r1
            com.google.android.gms.internal.ads.zzjp r0 = r14.zzbbu
            java.nio.ByteBuffer r0 = r0.zzdr
            byte[] r1 = zzbbq
            r0.put(r1)
            android.media.MediaCodec r5 = r14.zzbcb
            int r6 = r14.zzbco
            r7 = 0
            byte[] r0 = zzbbq
            int r8 = r0.length
            r9 = 0
            r11 = 0
            r5.queueInputBuffer(r6, r7, r8, r9, r11)
            r14.zzbco = r2
            r14.zzbcu = r4
            return r4
        L_0x006b:
            boolean r0 = r14.zzbcy
            if (r0 == 0) goto L_0x0072
            r0 = -4
            r5 = 0
            goto L_0x00aa
        L_0x0072:
            int r0 = r14.zzbcs
            if (r0 != r4) goto L_0x0097
            r0 = 0
        L_0x0077:
            com.google.android.gms.internal.ads.zzht r5 = r14.zzaij
            java.util.List<byte[]> r5 = r5.zzahq
            int r5 = r5.size()
            if (r0 >= r5) goto L_0x0095
            com.google.android.gms.internal.ads.zzht r5 = r14.zzaij
            java.util.List<byte[]> r5 = r5.zzahq
            java.lang.Object r5 = r5.get(r0)
            byte[] r5 = (byte[]) r5
            com.google.android.gms.internal.ads.zzjp r6 = r14.zzbbu
            java.nio.ByteBuffer r6 = r6.zzdr
            r6.put(r5)
            int r0 = r0 + 1
            goto L_0x0077
        L_0x0095:
            r14.zzbcs = r3
        L_0x0097:
            com.google.android.gms.internal.ads.zzjp r0 = r14.zzbbu
            java.nio.ByteBuffer r0 = r0.zzdr
            int r0 = r0.position()
            com.google.android.gms.internal.ads.zzhv r5 = r14.zzbbw
            com.google.android.gms.internal.ads.zzjp r6 = r14.zzbbu
            int r5 = r14.zza((com.google.android.gms.internal.ads.zzhv) r5, (com.google.android.gms.internal.ads.zzjp) r6, (boolean) r1)
            r13 = r5
            r5 = r0
            r0 = r13
        L_0x00aa:
            r6 = -3
            if (r0 != r6) goto L_0x00ae
            return r1
        L_0x00ae:
            r6 = -5
            if (r0 != r6) goto L_0x00c4
            int r0 = r14.zzbcs
            if (r0 != r3) goto L_0x00bc
            com.google.android.gms.internal.ads.zzjp r0 = r14.zzbbu
            r0.clear()
            r14.zzbcs = r4
        L_0x00bc:
            com.google.android.gms.internal.ads.zzhv r0 = r14.zzbbw
            com.google.android.gms.internal.ads.zzht r0 = r0.zzaij
            r14.zzd(r0)
            return r4
        L_0x00c4:
            com.google.android.gms.internal.ads.zzjp r0 = r14.zzbbu
            boolean r0 = r0.zzgm()
            if (r0 == 0) goto L_0x0100
            int r0 = r14.zzbcs
            if (r0 != r3) goto L_0x00d7
            com.google.android.gms.internal.ads.zzjp r0 = r14.zzbbu
            r0.clear()
            r14.zzbcs = r4
        L_0x00d7:
            r14.zzbcw = r4
            boolean r0 = r14.zzbcu
            if (r0 != 0) goto L_0x00e1
            r14.zzhl()
            return r1
        L_0x00e1:
            boolean r0 = r14.zzbcg     // Catch:{ CryptoException -> 0x00f6 }
            if (r0 != 0) goto L_0x00f5
            r14.zzbcv = r4     // Catch:{ CryptoException -> 0x00f6 }
            android.media.MediaCodec r5 = r14.zzbcb     // Catch:{ CryptoException -> 0x00f6 }
            int r6 = r14.zzbco     // Catch:{ CryptoException -> 0x00f6 }
            r7 = 0
            r8 = 0
            r9 = 0
            r11 = 4
            r5.queueInputBuffer(r6, r7, r8, r9, r11)     // Catch:{ CryptoException -> 0x00f6 }
            r14.zzbco = r2     // Catch:{ CryptoException -> 0x00f6 }
        L_0x00f5:
            return r1
        L_0x00f6:
            r0 = move-exception
            int r1 = r14.getIndex()
            com.google.android.gms.internal.ads.zzhe r0 = com.google.android.gms.internal.ads.zzhe.zza(r0, r1)
            throw r0
        L_0x0100:
            boolean r0 = r14.zzbcz
            if (r0 == 0) goto L_0x0118
            com.google.android.gms.internal.ads.zzjp r0 = r14.zzbbu
            boolean r0 = r0.zzgn()
            if (r0 != 0) goto L_0x0118
            com.google.android.gms.internal.ads.zzjp r0 = r14.zzbbu
            r0.clear()
            int r0 = r14.zzbcs
            if (r0 != r3) goto L_0x0117
            r14.zzbcs = r4
        L_0x0117:
            return r4
        L_0x0118:
            r14.zzbcz = r1
            com.google.android.gms.internal.ads.zzjp r0 = r14.zzbbu
            boolean r0 = r0.isEncrypted()
            com.google.android.gms.internal.ads.zzjr<com.google.android.gms.internal.ads.zzjv> r3 = r14.zzbbz
            if (r3 == 0) goto L_0x0144
            int r3 = r3.getState()
            if (r3 == 0) goto L_0x0135
            r6 = 4
            if (r3 == r6) goto L_0x0144
            if (r0 != 0) goto L_0x0133
            boolean r3 = r14.zzbbt
            if (r3 != 0) goto L_0x0144
        L_0x0133:
            r3 = 1
            goto L_0x0145
        L_0x0135:
            com.google.android.gms.internal.ads.zzjr<com.google.android.gms.internal.ads.zzjv> r0 = r14.zzbbz
            com.google.android.gms.internal.ads.zzju r0 = r0.zzgt()
            int r1 = r14.getIndex()
            com.google.android.gms.internal.ads.zzhe r0 = com.google.android.gms.internal.ads.zzhe.zza(r0, r1)
            throw r0
        L_0x0144:
            r3 = 0
        L_0x0145:
            r14.zzbcy = r3
            if (r3 == 0) goto L_0x014a
            return r1
        L_0x014a:
            boolean r3 = r14.zzbcd
            if (r3 == 0) goto L_0x0164
            if (r0 != 0) goto L_0x0164
            com.google.android.gms.internal.ads.zzjp r3 = r14.zzbbu
            java.nio.ByteBuffer r3 = r3.zzdr
            com.google.android.gms.internal.ads.zzpm.zzp(r3)
            com.google.android.gms.internal.ads.zzjp r3 = r14.zzbbu
            java.nio.ByteBuffer r3 = r3.zzdr
            int r3 = r3.position()
            if (r3 != 0) goto L_0x0162
            return r4
        L_0x0162:
            r14.zzbcd = r1
        L_0x0164:
            com.google.android.gms.internal.ads.zzjp r3 = r14.zzbbu     // Catch:{ CryptoException -> 0x01ca }
            long r10 = r3.zzaov     // Catch:{ CryptoException -> 0x01ca }
            com.google.android.gms.internal.ads.zzjp r3 = r14.zzbbu     // Catch:{ CryptoException -> 0x01ca }
            boolean r3 = r3.zzgl()     // Catch:{ CryptoException -> 0x01ca }
            if (r3 == 0) goto L_0x0179
            java.util.List<java.lang.Long> r3 = r14.zzbbx     // Catch:{ CryptoException -> 0x01ca }
            java.lang.Long r6 = java.lang.Long.valueOf(r10)     // Catch:{ CryptoException -> 0x01ca }
            r3.add(r6)     // Catch:{ CryptoException -> 0x01ca }
        L_0x0179:
            com.google.android.gms.internal.ads.zzjp r3 = r14.zzbbu     // Catch:{ CryptoException -> 0x01ca }
            java.nio.ByteBuffer r3 = r3.zzdr     // Catch:{ CryptoException -> 0x01ca }
            r3.flip()     // Catch:{ CryptoException -> 0x01ca }
            com.google.android.gms.internal.ads.zzjp r3 = r14.zzbbu     // Catch:{ CryptoException -> 0x01ca }
            r14.zza((com.google.android.gms.internal.ads.zzjp) r3)     // Catch:{ CryptoException -> 0x01ca }
            if (r0 == 0) goto L_0x01ab
            com.google.android.gms.internal.ads.zzjp r0 = r14.zzbbu     // Catch:{ CryptoException -> 0x01ca }
            com.google.android.gms.internal.ads.zzjl r0 = r0.zzaou     // Catch:{ CryptoException -> 0x01ca }
            android.media.MediaCodec$CryptoInfo r9 = r0.zzgq()     // Catch:{ CryptoException -> 0x01ca }
            if (r5 != 0) goto L_0x0192
            goto L_0x01a1
        L_0x0192:
            int[] r0 = r9.numBytesOfClearData     // Catch:{ CryptoException -> 0x01ca }
            if (r0 != 0) goto L_0x019a
            int[] r0 = new int[r4]     // Catch:{ CryptoException -> 0x01ca }
            r9.numBytesOfClearData = r0     // Catch:{ CryptoException -> 0x01ca }
        L_0x019a:
            int[] r0 = r9.numBytesOfClearData     // Catch:{ CryptoException -> 0x01ca }
            r3 = r0[r1]     // Catch:{ CryptoException -> 0x01ca }
            int r3 = r3 + r5
            r0[r1] = r3     // Catch:{ CryptoException -> 0x01ca }
        L_0x01a1:
            android.media.MediaCodec r6 = r14.zzbcb     // Catch:{ CryptoException -> 0x01ca }
            int r7 = r14.zzbco     // Catch:{ CryptoException -> 0x01ca }
            r8 = 0
            r12 = 0
            r6.queueSecureInputBuffer(r7, r8, r9, r10, r12)     // Catch:{ CryptoException -> 0x01ca }
            goto L_0x01bc
        L_0x01ab:
            android.media.MediaCodec r6 = r14.zzbcb     // Catch:{ CryptoException -> 0x01ca }
            int r7 = r14.zzbco     // Catch:{ CryptoException -> 0x01ca }
            r8 = 0
            com.google.android.gms.internal.ads.zzjp r0 = r14.zzbbu     // Catch:{ CryptoException -> 0x01ca }
            java.nio.ByteBuffer r0 = r0.zzdr     // Catch:{ CryptoException -> 0x01ca }
            int r9 = r0.limit()     // Catch:{ CryptoException -> 0x01ca }
            r12 = 0
            r6.queueInputBuffer(r7, r8, r9, r10, r12)     // Catch:{ CryptoException -> 0x01ca }
        L_0x01bc:
            r14.zzbco = r2     // Catch:{ CryptoException -> 0x01ca }
            r14.zzbcu = r4     // Catch:{ CryptoException -> 0x01ca }
            r14.zzbcs = r1     // Catch:{ CryptoException -> 0x01ca }
            com.google.android.gms.internal.ads.zzjm r0 = r14.zzbda     // Catch:{ CryptoException -> 0x01ca }
            int r1 = r0.zzaom     // Catch:{ CryptoException -> 0x01ca }
            int r1 = r1 + r4
            r0.zzaom = r1     // Catch:{ CryptoException -> 0x01ca }
            return r4
        L_0x01ca:
            r0 = move-exception
            int r1 = r14.getIndex()
            com.google.android.gms.internal.ads.zzhe r0 = com.google.android.gms.internal.ads.zzhe.zza(r0, r1)
            throw r0
        L_0x01d4:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzlv.zzhk():boolean");
    }

    /* access modifiers changed from: protected */
    public void zzd(zzht zzht) throws zzhe {
        zzjo zzjo;
        MediaCodec mediaCodec;
        zzht zzht2 = this.zzaij;
        this.zzaij = zzht;
        zzjo zzjo2 = zzht.zzahr;
        if (zzht2 == null) {
            zzjo = null;
        } else {
            zzjo = zzht2.zzahr;
        }
        boolean zza = zzpt.zza(zzjo2, zzjo);
        boolean z = true;
        if (!zza) {
            if (this.zzaij.zzahr != null) {
                zzjt<zzjv> zzjt = this.zzbbs;
                if (zzjt != null) {
                    zzjr<zzjv> zza2 = zzjt.zza(Looper.myLooper(), this.zzaij.zzahr);
                    this.zzbca = zza2;
                    if (zza2 == this.zzbbz) {
                        this.zzbbs.zza(zza2);
                    }
                } else {
                    throw zzhe.zza(new IllegalStateException("Media requires a DrmSessionManager"), getIndex());
                }
            } else {
                this.zzbca = null;
            }
        }
        if (this.zzbca == this.zzbbz && (mediaCodec = this.zzbcb) != null && zza(mediaCodec, this.zzbcc.zzbdb, zzht2, this.zzaij)) {
            this.zzbcr = true;
            this.zzbcs = 1;
            if (!(this.zzbcf && this.zzaij.width == zzht2.width && this.zzaij.height == zzht2.height)) {
                z = false;
            }
            this.zzbck = z;
        } else if (this.zzbcu) {
            this.zzbct = 1;
        } else {
            zzhj();
            zzhg();
        }
    }

    public boolean zzfi() {
        return this.zzbcx;
    }

    public boolean isReady() {
        if (this.zzaij == null || this.zzbcy) {
            return false;
        }
        if (zzem() || this.zzbcp >= 0) {
            return true;
        }
        return this.zzbcn != -9223372036854775807L && SystemClock.elapsedRealtime() < this.zzbcn;
    }

    private final boolean zzd(long j, long j2) throws zzhe {
        boolean z;
        boolean z2;
        if (this.zzbcp < 0) {
            if (!this.zzbci || !this.zzbcv) {
                this.zzbcp = this.zzbcb.dequeueOutputBuffer(this.zzbby, 0);
            } else {
                try {
                    this.zzbcp = this.zzbcb.dequeueOutputBuffer(this.zzbby, 0);
                } catch (IllegalStateException unused) {
                    zzhl();
                    if (this.zzbcx) {
                        zzhj();
                    }
                    return false;
                }
            }
            int i = this.zzbcp;
            if (i >= 0) {
                if (this.zzbcl) {
                    this.zzbcl = false;
                    this.zzbcb.releaseOutputBuffer(i, false);
                    this.zzbcp = -1;
                    return true;
                } else if ((this.zzbby.flags & 4) != 0) {
                    zzhl();
                    this.zzbcp = -1;
                    return false;
                } else {
                    ByteBuffer byteBuffer = this.zzalr[this.zzbcp];
                    if (byteBuffer != null) {
                        byteBuffer.position(this.zzbby.offset);
                        byteBuffer.limit(this.zzbby.offset + this.zzbby.size);
                    }
                    long j3 = this.zzbby.presentationTimeUs;
                    int size = this.zzbbx.size();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= size) {
                            z2 = false;
                            break;
                        } else if (this.zzbbx.get(i2).longValue() == j3) {
                            this.zzbbx.remove(i2);
                            z2 = true;
                            break;
                        } else {
                            i2++;
                        }
                    }
                    this.zzbcq = z2;
                }
            } else if (i == -2) {
                MediaFormat outputFormat = this.zzbcb.getOutputFormat();
                if (this.zzbcf && outputFormat.getInteger("width") == 32 && outputFormat.getInteger("height") == 32) {
                    this.zzbcl = true;
                } else {
                    if (this.zzbcj) {
                        outputFormat.setInteger("channel-count", 1);
                    }
                    onOutputFormatChanged(this.zzbcb, outputFormat);
                }
                return true;
            } else if (i == -3) {
                this.zzalr = this.zzbcb.getOutputBuffers();
                return true;
            } else {
                if (this.zzbcg && (this.zzbcw || this.zzbct == 2)) {
                    zzhl();
                }
                return false;
            }
        }
        if (!this.zzbci || !this.zzbcv) {
            MediaCodec mediaCodec = this.zzbcb;
            ByteBuffer[] byteBufferArr = this.zzalr;
            int i3 = this.zzbcp;
            z = zza(j, j2, mediaCodec, byteBufferArr[i3], i3, this.zzbby.flags, this.zzbby.presentationTimeUs, this.zzbcq);
        } else {
            try {
                z = zza(j, j2, this.zzbcb, this.zzalr[this.zzbcp], this.zzbcp, this.zzbby.flags, this.zzbby.presentationTimeUs, this.zzbcq);
            } catch (IllegalStateException unused2) {
                zzhl();
                if (this.zzbcx) {
                    zzhj();
                }
                return false;
            }
        }
        if (!z) {
            return false;
        }
        long j4 = this.zzbby.presentationTimeUs;
        this.zzbcp = -1;
        return true;
    }

    private final void zzhl() throws zzhe {
        if (this.zzbct == 2) {
            zzhj();
            zzhg();
            return;
        }
        this.zzbcx = true;
        zzgi();
    }
}
