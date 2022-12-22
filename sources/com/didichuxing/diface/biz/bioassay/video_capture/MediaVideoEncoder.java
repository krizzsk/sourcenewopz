package com.didichuxing.diface.biz.bioassay.video_capture;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.opengl.EGLContext;
import android.view.Surface;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.diface.biz.bioassay.video_capture.MediaEncoder;
import com.didichuxing.mlcp.drtc.consts.SDKConsts;
import java.io.IOException;

public class MediaVideoEncoder extends MediaEncoder {

    /* renamed from: a */
    private static final boolean f47434a = false;

    /* renamed from: b */
    private static final String f47435b = "MediaVideoEncoder";

    /* renamed from: c */
    private static final String f47436c = "video/avc";
    protected static int[] recognizedFormats = {2130708361};

    /* renamed from: d */
    private final int f47437d;

    /* renamed from: e */
    private final int f47438e;

    /* renamed from: f */
    private RenderHandler f47439f = RenderHandler.createHandler(f47435b);

    /* renamed from: g */
    private Surface f47440g;

    public MediaVideoEncoder(MediaMuxerWrapper mediaMuxerWrapper, MediaEncoder.MediaEncoderListener mediaEncoderListener, int i, int i2) {
        super(mediaMuxerWrapper, mediaEncoderListener);
        this.f47437d = i;
        this.f47438e = i2;
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
                if (m33973a(i3)) {
                    i = i3;
                    break;
                }
                i2++;
            }
            if (i == 0) {
                SystemUtils.log(6, f47435b, "couldn't find a good color format for " + mediaCodecInfo.getName() + " / " + str, (Throwable) null, "com.didichuxing.diface.biz.bioassay.video_capture.MediaVideoEncoder", 139);
            }
            return i;
        } catch (Throwable th) {
            Thread.currentThread().setPriority(5);
            throw th;
        }
    }

    /* renamed from: a */
    private static final boolean m33973a(int i) {
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
            this.f47439f.draw(fArr);
        }
        return frameAvailableSoon;
    }

    public boolean frameAvailableSoon(float[] fArr, float[] fArr2) {
        boolean frameAvailableSoon = super.frameAvailableSoon();
        if (frameAvailableSoon) {
            this.f47439f.draw(fArr, fArr2);
        }
        return frameAvailableSoon;
    }

    public boolean frameAvailableSoon() {
        boolean frameAvailableSoon = super.frameAvailableSoon();
        if (frameAvailableSoon) {
            this.f47439f.draw((float[]) null);
        }
        return frameAvailableSoon;
    }

    /* access modifiers changed from: protected */
    public void prepare() throws IOException {
        this.mTrackIndex = -1;
        this.mIsEOS = false;
        this.mMuxerStarted = false;
        if (selectVideoCodec("video/avc") == null) {
            SystemUtils.log(6, f47435b, "Unable to find an appropriate codec for video/avc", (Throwable) null, "com.didichuxing.diface.biz.bioassay.video_capture.MediaVideoEncoder", 205);
            return;
        }
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", this.f47437d, this.f47438e);
        createVideoFormat.setInteger("color-format", 2130708361);
        createVideoFormat.setInteger(SDKConsts.TAG_KEY_BITRATE, m33972a());
        createVideoFormat.setInteger("frame-rate", DiFaceVideoCaptureManager.FRAME_RATE);
        createVideoFormat.setInteger("i-frame-interval", 10);
        this.mMediaCodec = MediaCodec.createEncoderByType("video/avc");
        this.mMediaCodec.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
        this.f47440g = this.mMediaCodec.createInputSurface();
        this.mMediaCodec.start();
        if (this.mListener != null) {
            try {
                this.mListener.onPrepared(this);
            } catch (Exception e) {
                SystemUtils.log(6, f47435b, "prepare:", e, "com.didichuxing.diface.biz.bioassay.video_capture.MediaVideoEncoder", 241);
            }
        }
    }

    public void setEglContext(EGLContext eGLContext, int i) {
        this.f47439f.setEglContext(eGLContext, i, this.f47440g, true);
    }

    /* access modifiers changed from: protected */
    public void release() {
        Surface surface = this.f47440g;
        if (surface != null) {
            surface.release();
            this.f47440g = null;
        }
        RenderHandler renderHandler = this.f47439f;
        if (renderHandler != null) {
            renderHandler.release();
            this.f47439f = null;
        }
        super.release();
    }

    /* renamed from: a */
    private int m33972a() {
        int i = (int) (DiFaceVideoCaptureManager.BPP * ((float) DiFaceVideoCaptureManager.FRAME_RATE) * ((float) this.f47437d) * ((float) this.f47438e));
        SystemUtils.log(4, f47435b, String.format("bitrate=%5.2f[Mbps]", new Object[]{Float.valueOf((((float) i) / 1024.0f) / 1024.0f)}), (Throwable) null, "com.didichuxing.diface.biz.bioassay.video_capture.MediaVideoEncoder", 275);
        return i;
    }

    /* access modifiers changed from: protected */
    public void signalEndOfInputStream() {
        this.mMediaCodec.signalEndOfInputStream();
        this.mIsEOS = true;
    }
}
