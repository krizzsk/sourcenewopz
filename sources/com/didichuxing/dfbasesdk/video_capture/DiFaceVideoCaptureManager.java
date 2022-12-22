package com.didichuxing.dfbasesdk.video_capture;

import android.content.Context;
import android.opengl.EGL14;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.util.Log;
import com.didi.beatles.p099im.picture.utils.IMPictureFileUtils;
import com.didichuxing.dfbasesdk.video_capture.MediaEncoder;

public class DiFaceVideoCaptureManager {
    public static float BPP = 0.25f;
    public static int FRAME_RATE = 20;

    /* renamed from: a */
    private final float[] f46778a = new float[16];

    /* renamed from: b */
    private MediaMuxerWrapper f46779b;

    /* renamed from: c */
    private int f46780c;

    /* renamed from: d */
    private int f46781d;

    /* renamed from: e */
    private boolean f46782e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public GLSurfaceView f46783f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public int f46784g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public MediaVideoEncoder f46785h;

    /* renamed from: i */
    private final MediaEncoder.MediaEncoderListener f46786i = new MediaEncoder.MediaEncoderListener() {
        public void onPrepared(MediaEncoder mediaEncoder) {
            if (mediaEncoder instanceof MediaVideoEncoder) {
                DiFaceVideoCaptureManager.this.m33590a((MediaVideoEncoder) mediaEncoder);
            }
        }

        public void onStopped(MediaEncoder mediaEncoder) {
            if (mediaEncoder instanceof MediaVideoEncoder) {
                DiFaceVideoCaptureManager.this.m33590a((MediaVideoEncoder) null);
            }
        }

        public void onError(String str) {
            if (DiFaceVideoCaptureManager.this.listener != null) {
                DiFaceVideoCaptureManager.this.listener.onError(str);
            }
        }
    };

    /* renamed from: j */
    private boolean f46787j = false;
    public IErrorListener listener;

    public DiFaceVideoCaptureManager(int i, int i2, boolean z, GLSurfaceView gLSurfaceView, float f, int i3) {
        this.f46782e = z;
        if (!z) {
            this.f46780c = i;
            this.f46781d = i2;
        } else {
            this.f46780c = i2;
            this.f46781d = i;
        }
        this.f46783f = gLSurfaceView;
        Matrix.setIdentityM(this.f46778a, 0);
        Matrix.rotateM(this.f46778a, 0, 270.0f, 0.0f, 0.0f, 1.0f);
        BPP = f;
        FRAME_RATE = i3;
    }

    public void setCameraWidthAndHeight(int i, int i2) {
        if (!this.f46782e) {
            this.f46780c = i;
            this.f46781d = i2;
            return;
        }
        this.f46780c = i2;
        this.f46781d = i;
    }

    public boolean isRecording() {
        return this.f46787j;
    }

    public void startRecording(Context context, int i) {
        this.f46784g = i;
        try {
            MediaMuxerWrapper mediaMuxerWrapper = new MediaMuxerWrapper(context, IMPictureFileUtils.POST_VIDEO);
            this.f46779b = mediaMuxerWrapper;
            new MediaVideoEncoder(mediaMuxerWrapper, this.f46786i, this.f46780c, this.f46781d);
            this.f46779b.prepare();
            this.f46779b.startRecording();
            this.f46787j = true;
        } catch (Exception e) {
            IErrorListener iErrorListener = this.listener;
            if (iErrorListener != null) {
                iErrorListener.onStartError("startRecording failed , " + Log.getStackTraceString(e));
            }
            MediaEncoder.MediaEncoderListener mediaEncoderListener = this.f46786i;
            if (mediaEncoderListener != null) {
                mediaEncoderListener.onError("startRecording failed , " + Log.getStackTraceString(e));
            }
        }
    }

    public void startRecording(Context context, int i, String str) {
        this.f46784g = i;
        try {
            MediaMuxerWrapper mediaMuxerWrapper = new MediaMuxerWrapper(context, IMPictureFileUtils.POST_VIDEO, str);
            this.f46779b = mediaMuxerWrapper;
            new MediaVideoEncoder(mediaMuxerWrapper, this.f46786i, this.f46780c, this.f46781d);
            this.f46779b.prepare();
            this.f46779b.startRecording();
            this.f46787j = true;
        } catch (Exception e) {
            IErrorListener iErrorListener = this.listener;
            if (iErrorListener != null) {
                iErrorListener.onStartError("startRecording failed , " + Log.getStackTraceString(e));
            }
            MediaEncoder.MediaEncoderListener mediaEncoderListener = this.f46786i;
            if (mediaEncoderListener != null) {
                mediaEncoderListener.onError("startRecording failed , " + Log.getStackTraceString(e));
            }
        }
    }

    public void stopRecording() {
        MediaMuxerWrapper mediaMuxerWrapper = this.f46779b;
        if (mediaMuxerWrapper != null) {
            this.f46787j = false;
            mediaMuxerWrapper.stopRecording();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m33590a(final MediaVideoEncoder mediaVideoEncoder) {
        this.f46783f.queueEvent(new Runnable() {
            public void run() {
                synchronized (DiFaceVideoCaptureManager.this.f46783f) {
                    if (mediaVideoEncoder != null) {
                        mediaVideoEncoder.setEglContext(EGL14.eglGetCurrentContext(), DiFaceVideoCaptureManager.this.f46784g);
                        MediaVideoEncoder unused = DiFaceVideoCaptureManager.this.f46785h = mediaVideoEncoder;
                    }
                }
            }
        });
    }

    public void frameAvailable(float[] fArr, float[] fArr2) {
        MediaVideoEncoder mediaVideoEncoder = this.f46785h;
        if (mediaVideoEncoder != null) {
            mediaVideoEncoder.frameAvailableSoon(fArr, fArr2);
        }
    }

    public void frameAvailable(float[] fArr) {
        MediaVideoEncoder mediaVideoEncoder = this.f46785h;
        if (mediaVideoEncoder != null) {
            mediaVideoEncoder.frameAvailableSoon(fArr, this.f46778a);
        }
    }

    public void frameAvailable() {
        MediaVideoEncoder mediaVideoEncoder = this.f46785h;
        if (mediaVideoEncoder != null) {
            mediaVideoEncoder.frameAvailableSoon();
        }
    }

    public String getVideoPath() {
        MediaMuxerWrapper mediaMuxerWrapper = this.f46779b;
        if (mediaMuxerWrapper == null) {
            return null;
        }
        String outputPath = mediaMuxerWrapper.getOutputPath();
        this.f46779b = null;
        return outputPath;
    }

    public IErrorListener getListener() {
        return this.listener;
    }

    public void setListener(IErrorListener iErrorListener) {
        this.listener = iErrorListener;
    }
}
