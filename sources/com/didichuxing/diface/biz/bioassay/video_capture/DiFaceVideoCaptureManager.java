package com.didichuxing.diface.biz.bioassay.video_capture;

import android.content.Context;
import android.opengl.EGL14;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import com.didi.beatles.p099im.picture.utils.IMPictureFileUtils;
import com.didichuxing.diface.biz.bioassay.video_capture.MediaEncoder;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DiFaceVideoCaptureManager {
    public static float BPP = 0.25f;
    public static int FRAME_RATE = 20;

    /* renamed from: a */
    private static final String f47378a = "bioassayVideo";

    /* renamed from: b */
    private static final SimpleDateFormat f47379b = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss", Locale.US);

    /* renamed from: c */
    private final float[] f47380c = new float[16];

    /* renamed from: d */
    private MediaMuxerWrapper f47381d;

    /* renamed from: e */
    private int f47382e;

    /* renamed from: f */
    private int f47383f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public GLSurfaceView f47384g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public int f47385h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public MediaVideoEncoder f47386i;

    /* renamed from: j */
    private final MediaEncoder.MediaEncoderListener f47387j = new MediaEncoder.MediaEncoderListener() {
        public void onPrepared(MediaEncoder mediaEncoder) {
            if (mediaEncoder instanceof MediaVideoEncoder) {
                DiFaceVideoCaptureManager.this.m33944a((MediaVideoEncoder) mediaEncoder);
            }
        }

        public void onStopped(MediaEncoder mediaEncoder) {
            if (mediaEncoder instanceof MediaVideoEncoder) {
                DiFaceVideoCaptureManager.this.m33944a((MediaVideoEncoder) null);
            }
        }
    };

    /* renamed from: k */
    private boolean f47388k = false;

    public DiFaceVideoCaptureManager(int i, int i2, boolean z, GLSurfaceView gLSurfaceView, float f, int i3) {
        if (!z) {
            this.f47382e = i;
            this.f47383f = i2;
        } else {
            this.f47382e = i2;
            this.f47383f = i;
        }
        this.f47384g = gLSurfaceView;
        Matrix.setIdentityM(this.f47380c, 0);
        Matrix.rotateM(this.f47380c, 0, 270.0f, 0.0f, 0.0f, 1.0f);
        BPP = f;
        FRAME_RATE = i3;
    }

    public boolean isRecording() {
        return this.f47388k;
    }

    public void startRecording(Context context, int i) {
        this.f47385h = i;
        try {
            MediaMuxerWrapper mediaMuxerWrapper = new MediaMuxerWrapper(context, IMPictureFileUtils.POST_VIDEO);
            this.f47381d = mediaMuxerWrapper;
            new MediaVideoEncoder(mediaMuxerWrapper, this.f47387j, this.f47382e, this.f47383f);
            this.f47381d.prepare();
            this.f47381d.startRecording();
            this.f47388k = true;
        } catch (Exception unused) {
        }
    }

    public void stopRecording() {
        MediaMuxerWrapper mediaMuxerWrapper = this.f47381d;
        if (mediaMuxerWrapper != null) {
            this.f47388k = false;
            mediaMuxerWrapper.stopRecording();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m33944a(final MediaVideoEncoder mediaVideoEncoder) {
        this.f47384g.queueEvent(new Runnable() {
            public void run() {
                synchronized (DiFaceVideoCaptureManager.this.f47384g) {
                    if (mediaVideoEncoder != null) {
                        mediaVideoEncoder.setEglContext(EGL14.eglGetCurrentContext(), DiFaceVideoCaptureManager.this.f47385h);
                        MediaVideoEncoder unused = DiFaceVideoCaptureManager.this.f47386i = mediaVideoEncoder;
                    }
                }
            }
        });
    }

    public void frameAvailable(float[] fArr, float[] fArr2) {
        MediaVideoEncoder mediaVideoEncoder = this.f47386i;
        if (mediaVideoEncoder != null) {
            mediaVideoEncoder.frameAvailableSoon(fArr, fArr2);
        }
    }

    public void frameAvailable(float[] fArr) {
        MediaVideoEncoder mediaVideoEncoder = this.f47386i;
        if (mediaVideoEncoder != null) {
            mediaVideoEncoder.frameAvailableSoon(fArr, this.f47380c);
        }
    }

    public void frameAvailable() {
        MediaVideoEncoder mediaVideoEncoder = this.f47386i;
        if (mediaVideoEncoder != null) {
            mediaVideoEncoder.frameAvailableSoon();
        }
    }

    public String getVideoPath() {
        MediaMuxerWrapper mediaMuxerWrapper = this.f47381d;
        if (mediaMuxerWrapper == null) {
            return null;
        }
        String outputPath = mediaMuxerWrapper.getOutputPath();
        this.f47381d = null;
        return outputPath;
    }

    public static final File getCaptureFile(Context context, String str) {
        if (context == null) {
            return null;
        }
        File externalFilesDir = context.getExternalFilesDir(f47378a);
        externalFilesDir.mkdirs();
        if (!externalFilesDir.canWrite()) {
            return null;
        }
        return new File(externalFilesDir, m33942a() + str);
    }

    /* renamed from: a */
    private static final String m33942a() {
        return f47379b.format(new GregorianCalendar().getTime());
    }
}
