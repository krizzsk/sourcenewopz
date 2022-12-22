package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaFormat;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import com.didi.dimina.container.monitor.ErrorCode;
import com.didichuxing.mlcp.drtc.consts.SDKConsts;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.util.zzj;
import com.google.android.gms.ads.internal.zzr;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbbq extends zzbbz implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnVideoSizeChangedListener, TextureView.SurfaceTextureListener {
    private static final Map<Integer, String> zzeky = new HashMap();
    private final zzbcs zzekz;
    private final zzbcr zzela;
    private final boolean zzelb;
    private int zzelc = 0;
    private int zzeld = 0;
    private MediaPlayer zzele;
    private Uri zzelf;
    private int zzelg;
    private int zzelh;
    private int zzeli;
    private int zzelj;
    private int zzelk;
    private zzbcq zzell;
    private boolean zzelm;
    private int zzeln;
    /* access modifiers changed from: private */
    public zzbca zzelo;
    private Integer zzelp = null;

    public zzbbq(Context context, zzbcs zzbcs, boolean z, boolean z2, zzbcp zzbcp, zzbcr zzbcr) {
        super(context);
        setSurfaceTextureListener(this);
        this.zzekz = zzbcs;
        this.zzela = zzbcr;
        this.zzelm = z;
        this.zzelb = z2;
        zzbcr.zzb(this);
    }

    public final long zznh() {
        return 0;
    }

    public final String zzaaw() {
        String str = this.zzelm ? " spherical" : "";
        return str.length() != 0 ? "MediaPlayer".concat(str) : new String("MediaPlayer");
    }

    public final void zza(zzbca zzbca) {
        this.zzelo = zzbca;
    }

    public final void setVideoPath(String str) {
        Uri parse = Uri.parse(str);
        zzti zzd = zzti.zzd(parse);
        if (zzd == null || zzd.url != null) {
            if (zzd != null) {
                parse = Uri.parse(zzd.url);
            }
            this.zzelf = parse;
            this.zzeln = 0;
            zzaax();
            requestLayout();
            invalidate();
        }
    }

    public final void stop() {
        zzd.zzed("AdMediaPlayerView stop");
        MediaPlayer mediaPlayer = this.zzele;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            this.zzele.release();
            this.zzele = null;
            zzdo(0);
            this.zzeld = 0;
        }
        this.zzela.onStop();
    }

    public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        StringBuilder sb = new StringBuilder(57);
        sb.append("AdMediaPlayerView size changed: ");
        sb.append(i);
        sb.append(" x ");
        sb.append(i2);
        zzd.zzed(sb.toString());
        this.zzelg = mediaPlayer.getVideoWidth();
        int videoHeight = mediaPlayer.getVideoHeight();
        this.zzelh = videoHeight;
        if (this.zzelg != 0 && videoHeight != 0) {
            requestLayout();
        }
    }

    public final void onPrepared(MediaPlayer mediaPlayer) {
        zzd.zzed("AdMediaPlayerView prepared");
        zzdo(2);
        this.zzela.zzff();
        zzj.zzegq.post(new zzbbs(this, mediaPlayer));
        this.zzelg = mediaPlayer.getVideoWidth();
        this.zzelh = mediaPlayer.getVideoHeight();
        int i = this.zzeln;
        if (i != 0) {
            seekTo(i);
        }
        zzaay();
        int i2 = this.zzelg;
        int i3 = this.zzelh;
        StringBuilder sb = new StringBuilder(62);
        sb.append("AdMediaPlayerView stream dimensions: ");
        sb.append(i2);
        sb.append(" x ");
        sb.append(i3);
        zzd.zzey(sb.toString());
        if (this.zzeld == 3) {
            play();
        }
        zzabc();
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        zzd.zzed("AdMediaPlayerView completion");
        zzdo(5);
        this.zzeld = 5;
        zzj.zzegq.post(new zzbbr(this));
    }

    public final boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        String str = zzeky.get(Integer.valueOf(i));
        String str2 = zzeky.get(Integer.valueOf(i2));
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 37 + String.valueOf(str2).length());
        sb.append("AdMediaPlayerView MediaPlayer info: ");
        sb.append(str);
        sb.append(":");
        sb.append(str2);
        zzd.zzed(sb.toString());
        return true;
    }

    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        String str = zzeky.get(Integer.valueOf(i));
        String str2 = zzeky.get(Integer.valueOf(i2));
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 38 + String.valueOf(str2).length());
        sb.append("AdMediaPlayerView MediaPlayer error: ");
        sb.append(str);
        sb.append(":");
        sb.append(str2);
        zzd.zzez(sb.toString());
        zzdo(-1);
        this.zzeld = -1;
        zzj.zzegq.post(new zzbbu(this, str, str2));
        return true;
    }

    public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        this.zzeli = i;
    }

    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        zzd.zzed("AdMediaPlayerView surface created");
        zzaax();
        zzj.zzegq.post(new zzbbt(this));
    }

    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        zzd.zzed("AdMediaPlayerView surface changed");
        boolean z = true;
        boolean z2 = this.zzeld == 3;
        if (!(this.zzelg == i && this.zzelh == i2)) {
            z = false;
        }
        if (this.zzele != null && z2 && z) {
            int i3 = this.zzeln;
            if (i3 != 0) {
                seekTo(i3);
            }
            play();
        }
        zzbcq zzbcq = this.zzell;
        if (zzbcq != null) {
            zzbcq.zzo(i, i2);
        }
        zzj.zzegq.post(new zzbbw(this, i, i2));
    }

    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        zzd.zzed("AdMediaPlayerView surface destroyed");
        MediaPlayer mediaPlayer = this.zzele;
        if (mediaPlayer != null && this.zzeln == 0) {
            this.zzeln = mediaPlayer.getCurrentPosition();
        }
        zzbcq zzbcq = this.zzell;
        if (zzbcq != null) {
            zzbcq.zzabp();
        }
        zzj.zzegq.post(new zzbbv(this));
        zzax(true);
        return true;
    }

    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.zzela.zzc(this);
        this.zzelw.zza(surfaceTexture, this.zzelo);
    }

    /* access modifiers changed from: protected */
    public final void onWindowVisibilityChanged(int i) {
        StringBuilder sb = new StringBuilder(58);
        sb.append("AdMediaPlayerView window visibility changed to ");
        sb.append(i);
        zzd.zzed(sb.toString());
        zzj.zzegq.post(new zzbbp(this, i));
        super.onWindowVisibilityChanged(i);
    }

    /* access modifiers changed from: protected */
    public final void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int defaultSize = getDefaultSize(this.zzelg, i);
        int defaultSize2 = getDefaultSize(this.zzelh, i2);
        if (this.zzelg > 0 && this.zzelh > 0 && this.zzell == null) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            int size2 = View.MeasureSpec.getSize(i2);
            if (mode == 1073741824 && mode2 == 1073741824) {
                int i5 = this.zzelg;
                int i6 = i5 * size2;
                int i7 = this.zzelh;
                if (i6 < size * i7) {
                    defaultSize = (i5 * size2) / i7;
                    defaultSize2 = size2;
                } else {
                    if (i5 * size2 > size * i7) {
                        i4 = (i7 * size) / i5;
                    }
                    defaultSize = size;
                    defaultSize2 = size2;
                }
            } else if (mode == 1073741824) {
                int i8 = (this.zzelh * size) / this.zzelg;
                if (mode2 != Integer.MIN_VALUE || i8 <= size2) {
                    i4 = i8;
                }
                defaultSize = size;
                defaultSize2 = size2;
            } else if (mode2 == 1073741824) {
                int i9 = (this.zzelg * size2) / this.zzelh;
                if (mode != Integer.MIN_VALUE || i9 <= size) {
                    defaultSize = i9;
                    defaultSize2 = size2;
                }
                defaultSize = size;
                defaultSize2 = size2;
            } else {
                int i10 = this.zzelg;
                int i11 = this.zzelh;
                if (mode2 != Integer.MIN_VALUE || i11 <= size2) {
                    defaultSize2 = i11;
                } else {
                    i10 = (i10 * size2) / i11;
                    defaultSize2 = size2;
                }
                if (mode != Integer.MIN_VALUE || i10 <= size) {
                    defaultSize = i10;
                } else {
                    i4 = (this.zzelh * size) / this.zzelg;
                }
            }
            defaultSize = size;
        }
        setMeasuredDimension(defaultSize, defaultSize2);
        zzbcq zzbcq = this.zzell;
        if (zzbcq != null) {
            zzbcq.zzo(defaultSize, defaultSize2);
        }
        if (Build.VERSION.SDK_INT == 16) {
            int i12 = this.zzelj;
            if ((i12 > 0 && i12 != defaultSize) || ((i3 = this.zzelk) > 0 && i3 != defaultSize2)) {
                zzaay();
            }
            this.zzelj = defaultSize;
            this.zzelk = defaultSize2;
        }
    }

    public final String toString() {
        String name = getClass().getName();
        String hexString = Integer.toHexString(hashCode());
        StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 1 + String.valueOf(hexString).length());
        sb.append(name);
        sb.append("@");
        sb.append(hexString);
        return sb.toString();
    }

    private final void zzaax() {
        zzd.zzed("AdMediaPlayerView init MediaPlayer");
        SurfaceTexture surfaceTexture = getSurfaceTexture();
        if (this.zzelf != null && surfaceTexture != null) {
            zzax(false);
            try {
                zzr.zzll();
                MediaPlayer mediaPlayer = new MediaPlayer();
                this.zzele = mediaPlayer;
                mediaPlayer.setOnBufferingUpdateListener(this);
                this.zzele.setOnCompletionListener(this);
                this.zzele.setOnErrorListener(this);
                this.zzele.setOnInfoListener(this);
                this.zzele.setOnPreparedListener(this);
                this.zzele.setOnVideoSizeChangedListener(this);
                this.zzeli = 0;
                if (this.zzelm) {
                    zzbcq zzbcq = new zzbcq(getContext());
                    this.zzell = zzbcq;
                    zzbcq.zza(surfaceTexture, getWidth(), getHeight());
                    this.zzell.start();
                    SurfaceTexture zzabq = this.zzell.zzabq();
                    if (zzabq != null) {
                        surfaceTexture = zzabq;
                    } else {
                        this.zzell.zzabp();
                        this.zzell = null;
                    }
                }
                this.zzele.setDataSource(getContext(), this.zzelf);
                zzr.zzlm();
                this.zzele.setSurface(new Surface(surfaceTexture));
                this.zzele.setAudioStreamType(3);
                this.zzele.setScreenOnWhilePlaying(true);
                this.zzele.prepareAsync();
                zzdo(1);
            } catch (IOException | IllegalArgumentException | IllegalStateException e) {
                String valueOf = String.valueOf(this.zzelf);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 36);
                sb.append("Failed to initialize MediaPlayer at ");
                sb.append(valueOf);
                zzd.zzd(sb.toString(), e);
                onError(this.zzele, 1, 0);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0034 A[LOOP:0: B:10:0x0034->B:15:0x004f, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzaay() {
        /*
            r8 = this;
            boolean r0 = r8.zzelb
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            boolean r0 = r8.zzaaz()
            if (r0 == 0) goto L_0x0059
            android.media.MediaPlayer r0 = r8.zzele
            int r0 = r0.getCurrentPosition()
            if (r0 <= 0) goto L_0x0059
            int r0 = r8.zzeld
            r1 = 3
            if (r0 == r1) goto L_0x0059
            java.lang.String r0 = "AdMediaPlayerView nudging MediaPlayer"
            com.google.android.gms.ads.internal.util.zzd.zzed(r0)
            r0 = 0
            r8.zzd(r0)
            android.media.MediaPlayer r0 = r8.zzele
            r0.start()
            android.media.MediaPlayer r0 = r8.zzele
            int r0 = r0.getCurrentPosition()
            com.google.android.gms.common.util.Clock r1 = com.google.android.gms.ads.internal.zzr.zzlc()
            long r1 = r1.currentTimeMillis()
        L_0x0034:
            boolean r3 = r8.zzaaz()
            if (r3 == 0) goto L_0x0051
            android.media.MediaPlayer r3 = r8.zzele
            int r3 = r3.getCurrentPosition()
            if (r3 != r0) goto L_0x0051
            com.google.android.gms.common.util.Clock r3 = com.google.android.gms.ads.internal.zzr.zzlc()
            long r3 = r3.currentTimeMillis()
            long r3 = r3 - r1
            r5 = 250(0xfa, double:1.235E-321)
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x0034
        L_0x0051:
            android.media.MediaPlayer r0 = r8.zzele
            r0.pause()
            r8.zzabc()
        L_0x0059:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbbq.zzaay():void");
    }

    private final void zzax(boolean z) {
        zzd.zzed("AdMediaPlayerView release");
        zzbcq zzbcq = this.zzell;
        if (zzbcq != null) {
            zzbcq.zzabp();
            this.zzell = null;
        }
        MediaPlayer mediaPlayer = this.zzele;
        if (mediaPlayer != null) {
            mediaPlayer.reset();
            this.zzele.release();
            this.zzele = null;
            zzdo(0);
            if (z) {
                this.zzeld = 0;
                this.zzeld = 0;
            }
        }
    }

    public final void play() {
        zzd.zzed("AdMediaPlayerView play");
        if (zzaaz()) {
            this.zzele.start();
            zzdo(3);
            this.zzelw.zzabe();
            zzj.zzegq.post(new zzbby(this));
        }
        this.zzeld = 3;
    }

    public final void pause() {
        zzd.zzed("AdMediaPlayerView pause");
        if (zzaaz() && this.zzele.isPlaying()) {
            this.zzele.pause();
            zzdo(4);
            zzj.zzegq.post(new zzbbx(this));
        }
        this.zzeld = 4;
    }

    public final int getDuration() {
        if (zzaaz()) {
            return this.zzele.getDuration();
        }
        return -1;
    }

    public final int getCurrentPosition() {
        if (zzaaz()) {
            return this.zzele.getCurrentPosition();
        }
        return 0;
    }

    public final void seekTo(int i) {
        StringBuilder sb = new StringBuilder(34);
        sb.append("AdMediaPlayerView seek ");
        sb.append(i);
        zzd.zzed(sb.toString());
        if (zzaaz()) {
            this.zzele.seekTo(i);
            this.zzeln = 0;
            return;
        }
        this.zzeln = i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r2.zzelc;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzaaz() {
        /*
            r2 = this;
            android.media.MediaPlayer r0 = r2.zzele
            if (r0 == 0) goto L_0x000f
            int r0 = r2.zzelc
            r1 = -1
            if (r0 == r1) goto L_0x000f
            if (r0 == 0) goto L_0x000f
            r1 = 1
            if (r0 == r1) goto L_0x000f
            return r1
        L_0x000f:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbbq.zzaaz():boolean");
    }

    public final void zza(float f, float f2) {
        zzbcq zzbcq = this.zzell;
        if (zzbcq != null) {
            zzbcq.zzb(f, f2);
        }
    }

    public final int getVideoWidth() {
        MediaPlayer mediaPlayer = this.zzele;
        if (mediaPlayer != null) {
            return mediaPlayer.getVideoWidth();
        }
        return 0;
    }

    public final int getVideoHeight() {
        MediaPlayer mediaPlayer = this.zzele;
        if (mediaPlayer != null) {
            return mediaPlayer.getVideoHeight();
        }
        return 0;
    }

    public final long zzaba() {
        if (this.zzelp != null) {
            return (getTotalBytes() * ((long) this.zzeli)) / 100;
        }
        return -1;
    }

    public final long getTotalBytes() {
        if (this.zzelp != null) {
            return ((long) getDuration()) * ((long) this.zzelp.intValue());
        }
        return -1;
    }

    public final int zzabb() {
        if (Build.VERSION.SDK_INT < 26 || !zzaaz()) {
            return -1;
        }
        return this.zzele.getMetrics().getInt("android.media.mediaplayer.dropped");
    }

    public final void zzabc() {
        zzd(this.zzelx.getVolume());
    }

    private final void zzd(float f) {
        MediaPlayer mediaPlayer = this.zzele;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.setVolume(f, f);
            } catch (IllegalStateException unused) {
            }
        } else {
            zzd.zzez("AdMediaPlayerView setMediaPlayerVolume() called before onPrepared().");
        }
    }

    /* access modifiers changed from: private */
    public final void zza(MediaPlayer mediaPlayer) {
        MediaPlayer.TrackInfo[] trackInfo;
        MediaFormat format;
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcsd)).booleanValue() && this.zzekz != null && mediaPlayer != null && Build.VERSION.SDK_INT >= 19 && (trackInfo = mediaPlayer.getTrackInfo()) != null) {
            HashMap hashMap = new HashMap();
            for (MediaPlayer.TrackInfo trackInfo2 : trackInfo) {
                if (trackInfo2 != null) {
                    int trackType = trackInfo2.getTrackType();
                    if (trackType == 1) {
                        MediaFormat format2 = trackInfo2.getFormat();
                        if (format2 != null) {
                            if (format2.containsKey("frame-rate")) {
                                try {
                                    hashMap.put("frameRate", String.valueOf(format2.getFloat("frame-rate")));
                                } catch (ClassCastException unused) {
                                    hashMap.put("frameRate", String.valueOf(format2.getInteger("frame-rate")));
                                }
                            }
                            if (format2.containsKey(SDKConsts.TAG_KEY_BITRATE)) {
                                Integer valueOf = Integer.valueOf(format2.getInteger(SDKConsts.TAG_KEY_BITRATE));
                                this.zzelp = valueOf;
                                hashMap.put("bitRate", String.valueOf(valueOf));
                            }
                            if (format2.containsKey("width") && format2.containsKey("height")) {
                                int integer = format2.getInteger("width");
                                int integer2 = format2.getInteger("height");
                                StringBuilder sb = new StringBuilder(23);
                                sb.append(integer);
                                sb.append("x");
                                sb.append(integer2);
                                hashMap.put("resolution", sb.toString());
                            }
                            if (format2.containsKey("mime")) {
                                hashMap.put("videoMime", format2.getString("mime"));
                            }
                            if (Build.VERSION.SDK_INT >= 30 && format2.containsKey("codecs-string")) {
                                hashMap.put("videoCodec", format2.getString("codecs-string"));
                            }
                        }
                    } else if (trackType == 2 && (format = trackInfo2.getFormat()) != null) {
                        if (format.containsKey("mime")) {
                            hashMap.put("audioMime", format.getString("mime"));
                        }
                        if (Build.VERSION.SDK_INT >= 30 && format.containsKey("codecs-string")) {
                            hashMap.put("audioCodec", format.getString("codecs-string"));
                        }
                    }
                }
            }
            if (!hashMap.isEmpty()) {
                this.zzekz.zza("onMetadataEvent", (Map<String, ?>) hashMap);
            }
        }
    }

    private final void zzdo(int i) {
        if (i == 3) {
            this.zzela.zzabs();
            this.zzelx.zzabs();
        } else if (this.zzelc == 3) {
            this.zzela.zzabt();
            this.zzelx.zzabt();
        }
        this.zzelc = i;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzdp(int i) {
        zzbca zzbca = this.zzelo;
        if (zzbca != null) {
            zzbca.onWindowVisibilityChanged(i);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 17) {
            zzeky.put(Integer.valueOf(ErrorCode.APP_SERVICE_READ_ERROR), "MEDIA_ERROR_IO");
            zzeky.put(-1007, "MEDIA_ERROR_MALFORMED");
            zzeky.put(-1010, "MEDIA_ERROR_UNSUPPORTED");
            zzeky.put(-110, "MEDIA_ERROR_TIMED_OUT");
            zzeky.put(3, "MEDIA_INFO_VIDEO_RENDERING_START");
        }
        zzeky.put(100, "MEDIA_ERROR_SERVER_DIED");
        zzeky.put(1, "MEDIA_ERROR_UNKNOWN");
        zzeky.put(1, "MEDIA_INFO_UNKNOWN");
        zzeky.put(700, "MEDIA_INFO_VIDEO_TRACK_LAGGING");
        zzeky.put(701, "MEDIA_INFO_BUFFERING_START");
        zzeky.put(702, "MEDIA_INFO_BUFFERING_END");
        zzeky.put(800, "MEDIA_INFO_BAD_INTERLEAVING");
        zzeky.put(801, "MEDIA_INFO_NOT_SEEKABLE");
        zzeky.put(802, "MEDIA_INFO_METADATA_UPDATE");
        if (Build.VERSION.SDK_INT >= 19) {
            zzeky.put(901, "MEDIA_INFO_UNSUPPORTED_SUBTITLE");
            zzeky.put(902, "MEDIA_INFO_SUBTITLE_TIMED_OUT");
        }
    }
}
