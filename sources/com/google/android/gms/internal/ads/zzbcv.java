package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.view.Surface;
import android.view.TextureView;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.util.zzj;
import com.google.android.gms.ads.internal.zzr;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbcv extends zzbbz implements TextureView.SurfaceTextureListener, zzbdx {
    private Surface zzblw;
    private final zzbcs zzekz;
    private final zzbcr zzela;
    private final boolean zzelb;
    private int zzelg;
    private int zzelh;
    private int zzelj;
    private int zzelk;
    private zzbcq zzell;
    private final boolean zzelm;
    private zzbca zzelo;
    private String[] zzemk;
    private final zzbcp zzepi;
    private zzbdn zzepj;
    private String zzepk;
    private boolean zzepl;
    private int zzepm = 1;
    private boolean zzepn;
    private boolean zzepo;
    private float zzepp;

    public zzbcv(Context context, zzbcr zzbcr, zzbcs zzbcs, boolean z, boolean z2, zzbcp zzbcp) {
        super(context);
        this.zzelb = z2;
        this.zzekz = zzbcs;
        this.zzela = zzbcr;
        this.zzelm = z;
        this.zzepi = zzbcp;
        setSurfaceTextureListener(this);
        this.zzela.zzb(this);
    }

    private final zzbdn zzack() {
        return new zzbdn(this.zzekz.getContext(), this.zzepi, this.zzekz);
    }

    private final String zzacl() {
        return zzr.zzkv().zzq(this.zzekz.getContext(), this.zzekz.zzacc().zzbrz);
    }

    private final boolean zzacm() {
        zzbdn zzbdn = this.zzepj;
        return (zzbdn == null || zzbdn.zzadd() == null || this.zzepl) ? false : true;
    }

    private final boolean zzacn() {
        return zzacm() && this.zzepm != 1;
    }

    private final void zzaco() {
        String str;
        if (this.zzepj == null && (str = this.zzepk) != null && this.zzblw != null) {
            if (str.startsWith("cache:")) {
                zzbek zzfe = this.zzekz.zzfe(this.zzepk);
                if (zzfe instanceof zzbev) {
                    zzbdn zzadi = ((zzbev) zzfe).zzadi();
                    this.zzepj = zzadi;
                    if (zzadi.zzadd() == null) {
                        zzd.zzez("Precached video player has been released.");
                        return;
                    }
                } else if (zzfe instanceof zzbew) {
                    zzbew zzbew = (zzbew) zzfe;
                    String zzacl = zzacl();
                    ByteBuffer byteBuffer = zzbew.getByteBuffer();
                    boolean zzadj = zzbew.zzadj();
                    String url = zzbew.getUrl();
                    if (url == null) {
                        zzd.zzez("Stream cache URL is null.");
                        return;
                    }
                    zzbdn zzack = zzack();
                    this.zzepj = zzack;
                    zzack.zza(new Uri[]{Uri.parse(url)}, zzacl, byteBuffer, zzadj);
                } else {
                    String valueOf = String.valueOf(this.zzepk);
                    zzd.zzez(valueOf.length() != 0 ? "Stream cache miss: ".concat(valueOf) : new String("Stream cache miss: "));
                    return;
                }
            } else {
                this.zzepj = zzack();
                String zzacl2 = zzacl();
                Uri[] uriArr = new Uri[this.zzemk.length];
                int i = 0;
                while (true) {
                    String[] strArr = this.zzemk;
                    if (i >= strArr.length) {
                        break;
                    }
                    uriArr[i] = Uri.parse(strArr[i]);
                    i++;
                }
                this.zzepj.zza(uriArr, zzacl2);
            }
            this.zzepj.zza((zzbdx) this);
            zza(this.zzblw, false);
            if (this.zzepj.zzadd() != null) {
                int playbackState = this.zzepj.zzadd().getPlaybackState();
                this.zzepm = playbackState;
                if (playbackState == 3) {
                    zzacp();
                }
            }
        }
    }

    private final void zza(Surface surface, boolean z) {
        zzbdn zzbdn = this.zzepj;
        if (zzbdn != null) {
            zzbdn.zza(surface, z);
        } else {
            zzd.zzez("Trying to set surface before player is initalized.");
        }
    }

    private final void zza(float f, boolean z) {
        zzbdn zzbdn = this.zzepj;
        if (zzbdn != null) {
            zzbdn.zzb(f, z);
        } else {
            zzd.zzez("Trying to set volume before player is initalized.");
        }
    }

    public final void zzabc() {
        zza(this.zzelx.getVolume(), false);
    }

    private final void zzacp() {
        if (!this.zzepn) {
            this.zzepn = true;
            zzj.zzegq.post(new zzbcy(this));
            zzabc();
            this.zzela.zzff();
            if (this.zzepo) {
                play();
            }
        }
    }

    private static String zza(String str, Exception exc) {
        String canonicalName = exc.getClass().getCanonicalName();
        String message = exc.getMessage();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 2 + String.valueOf(canonicalName).length() + String.valueOf(message).length());
        sb.append(str);
        sb.append("/");
        sb.append(canonicalName);
        sb.append(":");
        sb.append(message);
        return sb.toString();
    }

    public final String zzaaw() {
        String str = this.zzelm ? " spherical" : "";
        return str.length() != 0 ? "ExoPlayer/3".concat(str) : new String("ExoPlayer/3");
    }

    public final void zza(zzbca zzbca) {
        this.zzelo = zzbca;
    }

    public final void setVideoPath(String str) {
        if (str != null) {
            this.zzepk = str;
            this.zzemk = new String[]{str};
            zzaco();
        }
    }

    public final void zzb(String str, String[] strArr) {
        if (str != null) {
            if (strArr == null) {
                setVideoPath(str);
            }
            this.zzepk = str;
            this.zzemk = (String[]) Arrays.copyOf(strArr, strArr.length);
            zzaco();
        }
    }

    public final void play() {
        if (zzacn()) {
            if (this.zzepi.zzenh) {
                zzacr();
            }
            this.zzepj.zzadd().zzh(true);
            this.zzela.zzabs();
            this.zzelx.zzabs();
            this.zzelw.zzabe();
            zzj.zzegq.post(new zzbdc(this));
            return;
        }
        this.zzepo = true;
    }

    public final void stop() {
        if (zzacm()) {
            this.zzepj.zzadd().stop();
            if (this.zzepj != null) {
                zza((Surface) null, true);
                zzbdn zzbdn = this.zzepj;
                if (zzbdn != null) {
                    zzbdn.zza((zzbdx) null);
                    this.zzepj.release();
                    this.zzepj = null;
                }
                this.zzepm = 1;
                this.zzepl = false;
                this.zzepn = false;
                this.zzepo = false;
            }
        }
        this.zzela.zzabt();
        this.zzelx.zzabt();
        this.zzela.onStop();
    }

    public final void pause() {
        if (zzacn()) {
            if (this.zzepi.zzenh) {
                zzacs();
            }
            this.zzepj.zzadd().zzh(false);
            this.zzela.zzabt();
            this.zzelx.zzabt();
            zzj.zzegq.post(new zzbdb(this));
        }
    }

    public final void seekTo(int i) {
        if (zzacn()) {
            this.zzepj.zzadd().seekTo((long) i);
        }
    }

    public final void zzdq(int i) {
        zzbdn zzbdn = this.zzepj;
        if (zzbdn != null) {
            zzbdn.zzadg().zzea(i);
        }
    }

    public final void zzdr(int i) {
        zzbdn zzbdn = this.zzepj;
        if (zzbdn != null) {
            zzbdn.zzadg().zzeb(i);
        }
    }

    public final void zzds(int i) {
        zzbdn zzbdn = this.zzepj;
        if (zzbdn != null) {
            zzbdn.zzadg().zzds(i);
        }
    }

    public final void zzdt(int i) {
        zzbdn zzbdn = this.zzepj;
        if (zzbdn != null) {
            zzbdn.zzadg().zzdt(i);
        }
    }

    public final void zzdu(int i) {
        zzbdn zzbdn = this.zzepj;
        if (zzbdn != null) {
            zzbdn.zzdu(i);
        }
    }

    public final void zza(float f, float f2) {
        zzbcq zzbcq = this.zzell;
        if (zzbcq != null) {
            zzbcq.zzb(f, f2);
        }
    }

    public final int getCurrentPosition() {
        if (zzacn()) {
            return (int) this.zzepj.zzadd().zzeq();
        }
        return 0;
    }

    public final int getDuration() {
        if (zzacn()) {
            return (int) this.zzepj.zzadd().getDuration();
        }
        return 0;
    }

    public final int getVideoWidth() {
        return this.zzelg;
    }

    public final int getVideoHeight() {
        return this.zzelh;
    }

    public final long zzaba() {
        zzbdn zzbdn = this.zzepj;
        if (zzbdn != null) {
            return zzbdn.zzaba();
        }
        return -1;
    }

    public final long zznh() {
        zzbdn zzbdn = this.zzepj;
        if (zzbdn != null) {
            return zzbdn.zznh();
        }
        return -1;
    }

    public final long getTotalBytes() {
        zzbdn zzbdn = this.zzepj;
        if (zzbdn != null) {
            return zzbdn.getTotalBytes();
        }
        return -1;
    }

    public final int zzabb() {
        zzbdn zzbdn = this.zzepj;
        if (zzbdn != null) {
            return zzbdn.zzabb();
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x007a A[LOOP:0: B:30:0x007a->B:35:0x0095, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onMeasure(int r11, int r12) {
        /*
            r10 = this;
            super.onMeasure(r11, r12)
            int r11 = r10.getMeasuredWidth()
            int r12 = r10.getMeasuredHeight()
            float r0 = r10.zzepp
            r1 = 0
            int r2 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r2 == 0) goto L_0x002a
            com.google.android.gms.internal.ads.zzbcq r2 = r10.zzell
            if (r2 != 0) goto L_0x002a
            float r2 = (float) r11
            float r3 = (float) r12
            float r3 = r2 / r3
            int r4 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r4 <= 0) goto L_0x0020
            float r2 = r2 / r0
            int r12 = (int) r2
        L_0x0020:
            float r0 = r10.zzepp
            int r2 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r2 >= 0) goto L_0x002a
            float r11 = (float) r12
            float r11 = r11 * r0
            int r11 = (int) r11
        L_0x002a:
            r10.setMeasuredDimension(r11, r12)
            com.google.android.gms.internal.ads.zzbcq r0 = r10.zzell
            if (r0 == 0) goto L_0x0034
            r0.zzo(r11, r12)
        L_0x0034:
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 16
            if (r0 != r2) goto L_0x00a2
            int r0 = r10.zzelj
            if (r0 <= 0) goto L_0x0040
            if (r0 != r11) goto L_0x0046
        L_0x0040:
            int r0 = r10.zzelk
            if (r0 <= 0) goto L_0x009e
            if (r0 == r12) goto L_0x009e
        L_0x0046:
            boolean r0 = r10.zzelb
            if (r0 == 0) goto L_0x009e
            boolean r0 = r10.zzacm()
            if (r0 == 0) goto L_0x009e
            com.google.android.gms.internal.ads.zzbdn r0 = r10.zzepj
            com.google.android.gms.internal.ads.zzhh r0 = r0.zzadd()
            long r2 = r0.zzeq()
            r4 = 0
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 <= 0) goto L_0x009e
            boolean r2 = r0.zzeo()
            if (r2 == 0) goto L_0x0067
            goto L_0x009e
        L_0x0067:
            r2 = 1
            r10.zza((float) r1, (boolean) r2)
            r0.zzh(r2)
            long r1 = r0.zzeq()
            com.google.android.gms.common.util.Clock r3 = com.google.android.gms.ads.internal.zzr.zzlc()
            long r3 = r3.currentTimeMillis()
        L_0x007a:
            boolean r5 = r10.zzacm()
            if (r5 == 0) goto L_0x0097
            long r5 = r0.zzeq()
            int r7 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r7 != 0) goto L_0x0097
            com.google.android.gms.common.util.Clock r5 = com.google.android.gms.ads.internal.zzr.zzlc()
            long r5 = r5.currentTimeMillis()
            long r5 = r5 - r3
            r7 = 250(0xfa, double:1.235E-321)
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 <= 0) goto L_0x007a
        L_0x0097:
            r1 = 0
            r0.zzh(r1)
            r10.zzabc()
        L_0x009e:
            r10.zzelj = r11
            r10.zzelk = r12
        L_0x00a2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbcv.onMeasure(int, int):void");
    }

    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.zzelm) {
            zzbcq zzbcq = new zzbcq(getContext());
            this.zzell = zzbcq;
            zzbcq.zza(surfaceTexture, i, i2);
            this.zzell.start();
            SurfaceTexture zzabq = this.zzell.zzabq();
            if (zzabq != null) {
                surfaceTexture = zzabq;
            } else {
                this.zzell.zzabp();
                this.zzell = null;
            }
        }
        Surface surface = new Surface(surfaceTexture);
        this.zzblw = surface;
        if (this.zzepj == null) {
            zzaco();
        } else {
            zza(surface, true);
            if (!this.zzepi.zzenh) {
                zzacr();
            }
        }
        if (this.zzelg == 0 || this.zzelh == 0) {
            zzq(i, i2);
        } else {
            zzacq();
        }
        zzj.zzegq.post(new zzbde(this));
    }

    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        zzbcq zzbcq = this.zzell;
        if (zzbcq != null) {
            zzbcq.zzo(i, i2);
        }
        zzj.zzegq.post(new zzbdd(this, i, i2));
    }

    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.zzela.zzc(this);
        this.zzelw.zza(surfaceTexture, this.zzelo);
    }

    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        pause();
        zzbcq zzbcq = this.zzell;
        if (zzbcq != null) {
            zzbcq.zzabp();
            this.zzell = null;
        }
        if (this.zzepj != null) {
            zzacs();
            Surface surface = this.zzblw;
            if (surface != null) {
                surface.release();
            }
            this.zzblw = null;
            zza((Surface) null, true);
        }
        zzj.zzegq.post(new zzbdg(this));
        return true;
    }

    /* access modifiers changed from: protected */
    public final void onWindowVisibilityChanged(int i) {
        StringBuilder sb = new StringBuilder(57);
        sb.append("AdExoPlayerView3 window visibility changed to ");
        sb.append(i);
        zzd.zzed(sb.toString());
        zzj.zzegq.post(new zzbdf(this, i));
        super.onWindowVisibilityChanged(i);
    }

    public final void zzb(boolean z, long j) {
        if (this.zzekz != null) {
            zzbat.zzeki.execute(new zzbdi(this, z, j));
        }
    }

    public final void zzdy(int i) {
        if (this.zzepm != i) {
            this.zzepm = i;
            if (i == 3) {
                zzacp();
            } else if (i == 4) {
                if (this.zzepi.zzenh) {
                    zzacs();
                }
                this.zzela.zzabt();
                this.zzelx.zzabt();
                zzj.zzegq.post(new zzbcx(this));
            }
        }
    }

    public final void zzp(int i, int i2) {
        this.zzelg = i;
        this.zzelh = i2;
        zzacq();
    }

    public final void zzb(String str, Exception exc) {
        String zza = zza(str, exc);
        String valueOf = String.valueOf(zza);
        zzd.zzez(valueOf.length() != 0 ? "ExoPlayerAdapter error: ".concat(valueOf) : new String("ExoPlayerAdapter error: "));
        this.zzepl = true;
        if (this.zzepi.zzenh) {
            zzacs();
        }
        zzj.zzegq.post(new zzbcz(this, zza));
    }

    public final void zzc(String str, Exception exc) {
        String zza = zza(str, exc);
        String valueOf = String.valueOf(zza);
        zzd.zzez(valueOf.length() != 0 ? "ExoPlayerAdapter exception: ".concat(valueOf) : new String("ExoPlayerAdapter exception: "));
        zzj.zzegq.post(new zzbda(this, zza));
    }

    private final void zzacq() {
        zzq(this.zzelg, this.zzelh);
    }

    private final void zzq(int i, int i2) {
        float f = i2 > 0 ? ((float) i) / ((float) i2) : 1.0f;
        if (this.zzepp != f) {
            this.zzepp = f;
            requestLayout();
        }
    }

    private final void zzacr() {
        zzbdn zzbdn = this.zzepj;
        if (zzbdn != null) {
            zzbdn.zzba(true);
        }
    }

    private final void zzacs() {
        zzbdn zzbdn = this.zzepj;
        if (zzbdn != null) {
            zzbdn.zzba(false);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzff(String str) {
        zzbca zzbca = this.zzelo;
        if (zzbca != null) {
            zzbca.zzm("ExoPlayerAdapter exception", str);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(boolean z, long j) {
        this.zzekz.zza(z, j);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzdz(int i) {
        zzbca zzbca = this.zzelo;
        if (zzbca != null) {
            zzbca.onWindowVisibilityChanged(i);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzact() {
        zzbca zzbca = this.zzelo;
        if (zzbca != null) {
            zzbca.zzabg();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzr(int i, int i2) {
        zzbca zzbca = this.zzelo;
        if (zzbca != null) {
            zzbca.zzm(i, i2);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzacu() {
        zzbca zzbca = this.zzelo;
        if (zzbca != null) {
            zzbca.zzabd();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzacv() {
        zzbca zzbca = this.zzelo;
        if (zzbca != null) {
            zzbca.onPaused();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzacw() {
        zzbca zzbca = this.zzelo;
        if (zzbca != null) {
            zzbca.zzabe();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzfg(String str) {
        zzbca zzbca = this.zzelo;
        if (zzbca != null) {
            zzbca.zzl("ExoPlayerAdapter error", str);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzacx() {
        zzbca zzbca = this.zzelo;
        if (zzbca != null) {
            zzbca.zzabf();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzacy() {
        zzbca zzbca = this.zzelo;
        if (zzbca != null) {
            zzbca.zzff();
        }
    }
}
