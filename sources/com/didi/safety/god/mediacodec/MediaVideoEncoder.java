package com.didi.safety.god.mediacodec;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.opengl.EGLContext;
import android.view.Surface;
import com.didi.safety.god.mediacodec.MediaEncoder;
import com.didi.safety.god.util.LogUtils;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.mlcp.drtc.consts.SDKConsts;
import java.io.IOException;

public class MediaVideoEncoder extends MediaEncoder {

    /* renamed from: a */
    private static final boolean f34672a = false;

    /* renamed from: b */
    private static final String f34673b = "MediaVideoEncoder";

    /* renamed from: c */
    private static final String f34674c = "video/avc";

    /* renamed from: d */
    private static final int f34675d = 25;

    /* renamed from: e */
    private static final float f34676e = 0.07f;
    protected static int[] recognizedFormats = {2130708361};

    /* renamed from: f */
    private final int f34677f;

    /* renamed from: g */
    private final int f34678g;

    /* renamed from: h */
    private RenderHandler f34679h = RenderHandler.createHandler(f34673b);

    /* renamed from: i */
    private Surface f34680i;

    public MediaVideoEncoder(MediaMuxerWrapper mediaMuxerWrapper, MediaEncoder.MediaEncoderListener mediaEncoderListener, int i, int i2) {
        super(mediaMuxerWrapper, mediaEncoderListener);
        this.f34677f = i;
        this.f34678g = i2;
    }

    protected static final MediaCodecInfo selectVideoCodec(String str) {
        int codecCount = MediaCodecList.getCodecCount();
        for (int i = 0; i < codecCount; i++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
            if (codecInfoAt.isEncoder()) {
                String[] supportedTypes = codecInfoAt.getSupportedTypes();
                for (String equalsIgnoreCase : supportedTypes) {
                    if (equalsIgnoreCase.equalsIgnoreCase(str) && selectColorFormat(codecInfoAt, str) > 0) {
                        return codecInfoAt;
                    }
                }
                continue;
            }
        }
        return null;
    }

    /* JADX INFO: finally extract failed */
    protected static final int selectColorFormat(MediaCodecInfo mediaCodecInfo, String str) {
        try {
            Thread.currentThread().setPriority(10);
            MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(str);
            Thread.currentThread().setPriority(5);
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i2 >= capabilitiesForType.colorFormats.length) {
                    break;
                }
                int i3 = capabilitiesForType.colorFormats[i2];
                if (m24491a(i3)) {
                    i = i3;
                    break;
                }
                i2++;
            }
            if (i == 0) {
                SystemUtils.log(6, f34673b, "couldn't find a good color format for " + mediaCodecInfo.getName() + " / " + str, (Throwable) null, "com.didi.safety.god.mediacodec.MediaVideoEncoder", 108);
            }
            return i;
        } catch (Throwable th) {
            Thread.currentThread().setPriority(5);
            throw th;
        }
    }

    /* renamed from: a */
    private static final boolean m24491a(int i) {
        int[] iArr = recognizedFormats;
        int length = iArr != null ? iArr.length : 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (recognizedFormats[i2] == i) {
                return true;
            }
        }
        return false;
    }

    public boolean frameAvailableSoon(float[] fArr) {
        boolean frameAvailableSoon = super.frameAvailableSoon();
        if (frameAvailableSoon) {
            this.f34679h.draw(fArr);
        }
        return frameAvailableSoon;
    }

    public boolean frameAvailableSoon(float[] fArr, float[] fArr2) {
        boolean frameAvailableSoon = super.frameAvailableSoon();
        if (frameAvailableSoon) {
            this.f34679h.draw(fArr, fArr2);
        }
        return frameAvailableSoon;
    }

    public boolean frameAvailableSoon() {
        boolean frameAvailableSoon = super.frameAvailableSoon();
        if (frameAvailableSoon) {
            this.f34679h.draw((float[]) null);
        }
        return frameAvailableSoon;
    }

    /* access modifiers changed from: protected */
    public void prepare() throws IOException {
        int i;
        this.mTrackIndex = -1;
        this.mIsEOS = false;
        this.mMuxerStarted = false;
        if (selectVideoCodec("video/avc") == null) {
            SystemUtils.log(6, f34673b, "Unable to find an appropriate codec for video/avc", (Throwable) null, "com.didi.safety.god.mediacodec.MediaVideoEncoder", 153);
            return;
        }
        int i2 = this.f34677f;
        if (i2 != 0 && (i = this.f34678g) != 0) {
            MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", i2, i);
            createVideoFormat.setInteger("color-format", 2130708361);
            createVideoFormat.setInteger(SDKConsts.TAG_KEY_BITRATE, m24490a());
            createVideoFormat.setInteger("frame-rate", 25);
            createVideoFormat.setInteger("i-frame-interval", 10);
            this.mMediaCodec = MediaCodec.createEncoderByType("video/avc");
            this.mMediaCodec.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
            this.f34680i = this.mMediaCodec.createInputSurface();
            this.mMediaCodec.start();
            if (this.mListener != null) {
                try {
                    this.mListener.onPrepared(this);
                } catch (Exception e) {
                    SystemUtils.log(6, f34673b, "prepare:", e, "com.didi.safety.god.mediacodec.MediaVideoEncoder", 180);
                }
            }
        }
    }

    public void setEglContext(EGLContext eGLContext, int i) {
        this.f34679h.setEglContext(eGLContext, i, this.f34680i, true);
    }

    /* access modifiers changed from: protected */
    public void release() {
        Surface surface = this.f34680i;
        if (surface != null) {
            surface.release();
            this.f34680i = null;
        }
        RenderHandler renderHandler = this.f34679h;
        if (renderHandler != null) {
            renderHandler.release();
            this.f34679h = null;
        }
        super.release();
    }

    /* renamed from: a */
    private int m24490a() {
        return (int) (((float) this.f34677f) * 1.75f * ((float) this.f34678g));
    }

    /* access modifiers changed from: protected */
    public void signalEndOfInputStream() {
        try {
            this.mMediaCodec.signalEndOfInputStream();
        } catch (Exception e) {
            LogUtils.logStackTrace(e);
        }
        this.mIsEOS = true;
    }
}
