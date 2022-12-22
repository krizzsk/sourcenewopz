package com.didichuxing.sdk.alphaface.video_capture;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.opengl.EGLContext;
import android.view.Surface;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.mlcp.drtc.consts.SDKConsts;
import com.didichuxing.sdk.alphaface.video_capture.MediaEncoder;
import java.io.IOException;

public class MediaVideoEncoder extends MediaEncoder {

    /* renamed from: a */
    private static final boolean f48833a = false;

    /* renamed from: b */
    private static final String f48834b = "MediaVideoEncoder";

    /* renamed from: c */
    private static final String f48835c = "video/avc";
    protected static int[] recognizedFormats = {2130708361};

    /* renamed from: d */
    private final int f48836d;

    /* renamed from: e */
    private final int f48837e;

    /* renamed from: f */
    private RenderHandler f48838f = RenderHandler.createHandler(f48834b);

    /* renamed from: g */
    private Surface f48839g;

    public MediaVideoEncoder(MediaMuxerWrapper mediaMuxerWrapper, MediaEncoder.MediaEncoderListener mediaEncoderListener, int i, int i2) {
        super(mediaMuxerWrapper, mediaEncoderListener);
        this.f48836d = i;
        this.f48837e = i2;
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
                if (m35038a(i3)) {
                    i = i3;
                    break;
                }
                i2++;
            }
            if (i == 0) {
                SystemUtils.log(6, f48834b, "couldn't find a good color format for " + mediaCodecInfo.getName() + " / " + str, (Throwable) null, "com.didichuxing.sdk.alphaface.video_capture.MediaVideoEncoder", 138);
            }
            return i;
        } catch (Throwable th) {
            Thread.currentThread().setPriority(5);
            throw th;
        }
    }

    /* renamed from: a */
    private static final boolean m35038a(int i) {
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
            this.f48838f.draw(fArr);
        }
        return frameAvailableSoon;
    }

    public boolean frameAvailableSoon(float[] fArr, float[] fArr2) {
        boolean frameAvailableSoon = super.frameAvailableSoon();
        if (frameAvailableSoon) {
            this.f48838f.draw(fArr, fArr2);
        }
        return frameAvailableSoon;
    }

    public boolean frameAvailableSoon() {
        boolean frameAvailableSoon = super.frameAvailableSoon();
        if (frameAvailableSoon) {
            this.f48838f.draw((float[]) null);
        }
        return frameAvailableSoon;
    }

    /* access modifiers changed from: protected */
    public void prepare() throws IOException {
        this.mTrackIndex = -1;
        this.mIsEOS = false;
        this.mMuxerStarted = false;
        if (selectVideoCodec("video/avc") == null) {
            SystemUtils.log(6, f48834b, "Unable to find an appropriate codec for video/avc", (Throwable) null, "com.didichuxing.sdk.alphaface.video_capture.MediaVideoEncoder", 204);
            return;
        }
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", this.f48836d, this.f48837e);
        createVideoFormat.setInteger("color-format", 2130708361);
        createVideoFormat.setInteger(SDKConsts.TAG_KEY_BITRATE, m35037a());
        createVideoFormat.setInteger("frame-rate", DiFaceVideoCaptureManager.FRAME_RATE);
        createVideoFormat.setInteger("i-frame-interval", 10);
        this.mMediaCodec = MediaCodec.createEncoderByType("video/avc");
        this.mMediaCodec.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
        this.f48839g = this.mMediaCodec.createInputSurface();
        this.mMediaCodec.start();
        if (this.mListener != null) {
            try {
                this.mListener.onPrepared(this);
            } catch (Exception e) {
                SystemUtils.log(6, f48834b, "prepare:", e, "com.didichuxing.sdk.alphaface.video_capture.MediaVideoEncoder", 240);
            }
        }
    }

    public void setEglContext(EGLContext eGLContext, int i) {
        RenderHandler renderHandler = this.f48838f;
        if (renderHandler != null) {
            renderHandler.setEglContext(eGLContext, i, this.f48839g, true);
        }
    }

    /* access modifiers changed from: protected */
    public void release() {
        Surface surface = this.f48839g;
        if (surface != null) {
            surface.release();
            this.f48839g = null;
        }
        RenderHandler renderHandler = this.f48838f;
        if (renderHandler != null) {
            renderHandler.release();
            this.f48838f = null;
        }
        super.release();
    }

    /* renamed from: a */
    private int m35037a() {
        int i = (int) (DiFaceVideoCaptureManager.BPP * ((float) DiFaceVideoCaptureManager.FRAME_RATE) * ((float) this.f48836d) * ((float) this.f48837e));
        SystemUtils.log(4, f48834b, String.format("bitrate=%5.2f[Mbps]", new Object[]{Float.valueOf((((float) i) / 1024.0f) / 1024.0f)}), (Throwable) null, "com.didichuxing.sdk.alphaface.video_capture.MediaVideoEncoder", 276);
        return i;
    }

    /* access modifiers changed from: protected */
    public void signalEndOfInputStream() {
        this.mMediaCodec.signalEndOfInputStream();
        this.mIsEOS = true;
    }
}
