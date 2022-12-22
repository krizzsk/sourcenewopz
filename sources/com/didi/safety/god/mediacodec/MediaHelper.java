package com.didi.safety.god.mediacodec;

import android.content.Context;
import android.opengl.EGL14;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import com.didi.beatles.p099im.picture.utils.IMPictureFileUtils;
import com.didi.safety.god.mediacodec.MediaEncoder;
import java.io.IOException;

public class MediaHelper {

    /* renamed from: a */
    private final float[] f34652a = new float[16];

    /* renamed from: b */
    private MediaMuxerWrapper f34653b;

    /* renamed from: c */
    private int f34654c;

    /* renamed from: d */
    private int f34655d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public GLSurfaceView f34656e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public int f34657f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public MediaVideoEncoder f34658g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public OnVideoRecordListener f34659h;

    /* renamed from: i */
    private final MediaEncoder.MediaEncoderListener f34660i = new MediaEncoder.MediaEncoderListener() {
        public void onPrepared(MediaEncoder mediaEncoder) {
            if (mediaEncoder instanceof MediaVideoEncoder) {
                MediaHelper.this.m24480a((MediaVideoEncoder) mediaEncoder);
            }
        }

        public void onStopped(MediaEncoder mediaEncoder) {
            if (mediaEncoder instanceof MediaVideoEncoder) {
                MediaHelper.this.m24480a((MediaVideoEncoder) null);
            }
        }

        public void onException(MediaEncoder mediaEncoder, Exception exc) {
            if (MediaHelper.this.f34659h != null) {
                MediaHelper.this.f34659h.onRecordException(exc);
            }
        }

        public void onVideoReady(MediaEncoder mediaEncoder) {
            if (MediaHelper.this.f34659h != null) {
                MediaHelper.this.f34659h.onVideoReady();
            }
        }
    };

    public interface OnVideoRecordListener {
        void onRecordException(Exception exc);

        void onVideoReady();
    }

    public void setOnVideoRecordListener(OnVideoRecordListener onVideoRecordListener) {
        this.f34659h = onVideoRecordListener;
    }

    public MediaHelper(int i, int i2, boolean z, GLSurfaceView gLSurfaceView) {
        if (z) {
            this.f34654c = i;
            this.f34655d = i2;
        } else {
            this.f34654c = i2;
            this.f34655d = i;
        }
        this.f34656e = gLSurfaceView;
        Matrix.setIdentityM(this.f34652a, 0);
        Matrix.rotateM(this.f34652a, 0, 0.0f, 0.0f, 0.0f, 1.0f);
    }

    public void startRecording(Context context, int i) {
        this.f34657f = i;
        try {
            MediaMuxerWrapper mediaMuxerWrapper = new MediaMuxerWrapper(context, IMPictureFileUtils.POST_VIDEO);
            this.f34653b = mediaMuxerWrapper;
            new MediaVideoEncoder(mediaMuxerWrapper, this.f34660i, this.f34654c, this.f34655d);
            this.f34653b.prepare();
            this.f34653b.startRecording();
        } catch (IOException unused) {
        }
    }

    public void startRecording(Context context, int i, String str, double d) {
        this.f34657f = i;
        try {
            MediaMuxerWrapper mediaMuxerWrapper = new MediaMuxerWrapper(context, str, ".log");
            this.f34653b = mediaMuxerWrapper;
            if (d <= 0.0d || d >= 1.0d) {
                new MediaVideoEncoder(this.f34653b, this.f34660i, this.f34654c, this.f34655d);
            } else {
                new MediaVideoEncoder(mediaMuxerWrapper, this.f34660i, (int) (((double) this.f34654c) * d), (int) (((double) this.f34655d) * d));
            }
            this.f34653b.prepare();
            this.f34653b.startRecording();
        } catch (IOException unused) {
        }
    }

    public void stopRecording() {
        MediaMuxerWrapper mediaMuxerWrapper = this.f34653b;
        if (mediaMuxerWrapper != null) {
            mediaMuxerWrapper.stopRecording();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m24480a(final MediaVideoEncoder mediaVideoEncoder) {
        this.f34656e.queueEvent(new Runnable() {
            public void run() {
                synchronized (MediaHelper.this.f34656e) {
                    if (mediaVideoEncoder != null) {
                        mediaVideoEncoder.setEglContext(EGL14.eglGetCurrentContext(), MediaHelper.this.f34657f);
                        MediaVideoEncoder unused = MediaHelper.this.f34658g = mediaVideoEncoder;
                    }
                }
            }
        });
    }

    public void frameAvailable(float[] fArr, float[] fArr2) {
        MediaVideoEncoder mediaVideoEncoder = this.f34658g;
        if (mediaVideoEncoder != null) {
            mediaVideoEncoder.frameAvailableSoon(fArr, fArr2);
        }
    }

    public void frameAvailable(float[] fArr) {
        MediaVideoEncoder mediaVideoEncoder = this.f34658g;
        if (mediaVideoEncoder != null) {
            mediaVideoEncoder.frameAvailableSoon(fArr, this.f34652a);
        }
    }

    public void frameAvailable() {
        MediaVideoEncoder mediaVideoEncoder = this.f34658g;
        if (mediaVideoEncoder != null) {
            mediaVideoEncoder.frameAvailableSoon();
        }
    }

    public String getVideoPath() {
        MediaMuxerWrapper mediaMuxerWrapper = this.f34653b;
        if (mediaMuxerWrapper == null) {
            return null;
        }
        String outputPath = mediaMuxerWrapper.getOutputPath();
        this.f34653b = null;
        return outputPath;
    }
}
