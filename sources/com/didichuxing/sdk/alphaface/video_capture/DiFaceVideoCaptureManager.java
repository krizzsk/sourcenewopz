package com.didichuxing.sdk.alphaface.video_capture;

import android.content.Context;
import android.opengl.EGL14;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.util.Log;
import com.didi.beatles.p099im.picture.utils.IMPictureFileUtils;
import com.didichuxing.sdk.alphaface.video_capture.MediaEncoder;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DiFaceVideoCaptureManager {
    public static float BPP = 0.25f;
    public static int FRAME_RATE = 20;

    /* renamed from: a */
    private static final String f48777a = "difaceBioassayVideo";

    /* renamed from: b */
    private static final SimpleDateFormat f48778b = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss", Locale.US);

    /* renamed from: c */
    private final float[] f48779c = new float[16];

    /* renamed from: d */
    private MediaMuxerWrapper f48780d;

    /* renamed from: e */
    private int f48781e;

    /* renamed from: f */
    private int f48782f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public GLSurfaceView f48783g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public int f48784h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public MediaVideoEncoder f48785i;

    /* renamed from: j */
    private final MediaEncoder.MediaEncoderListener f48786j = new MediaEncoder.MediaEncoderListener() {
        public void onPrepared(MediaEncoder mediaEncoder) {
            if (mediaEncoder instanceof MediaVideoEncoder) {
                DiFaceVideoCaptureManager.this.m35009a((MediaVideoEncoder) mediaEncoder);
            }
        }

        public void onStopped(MediaEncoder mediaEncoder) {
            if (mediaEncoder instanceof MediaVideoEncoder) {
                DiFaceVideoCaptureManager.this.m35009a((MediaVideoEncoder) null);
            }
        }

        public void onError(String str) {
            if (DiFaceVideoCaptureManager.this.listener != null) {
                DiFaceVideoCaptureManager.this.listener.onError(str);
            }
        }
    };

    /* renamed from: k */
    private boolean f48787k = false;
    public IErrorListener listener;

    public DiFaceVideoCaptureManager(int i, int i2, boolean z, GLSurfaceView gLSurfaceView, float f, int i3) {
        if (!z) {
            this.f48781e = i;
            this.f48782f = i2;
        } else {
            this.f48781e = i2;
            this.f48782f = i;
        }
        this.f48783g = gLSurfaceView;
        Matrix.setIdentityM(this.f48779c, 0);
        Matrix.rotateM(this.f48779c, 0, 270.0f, 0.0f, 0.0f, 1.0f);
        BPP = f;
        FRAME_RATE = i3;
    }

    public boolean isRecording() {
        return this.f48787k;
    }

    public void startRecording(Context context, int i) {
        this.f48784h = i;
        try {
            MediaMuxerWrapper mediaMuxerWrapper = new MediaMuxerWrapper(context, IMPictureFileUtils.POST_VIDEO, "SecurityDiFace");
            this.f48780d = mediaMuxerWrapper;
            new MediaVideoEncoder(mediaMuxerWrapper, this.f48786j, this.f48781e, this.f48782f);
            this.f48780d.prepare();
            this.f48780d.startRecording();
            this.f48787k = true;
        } catch (Exception e) {
            MediaEncoder.MediaEncoderListener mediaEncoderListener = this.f48786j;
            if (mediaEncoderListener != null) {
                mediaEncoderListener.onError("startRecording failed , " + Log.getStackTraceString(e));
            }
        }
    }

    public void stopRecording() {
        MediaMuxerWrapper mediaMuxerWrapper = this.f48780d;
        if (mediaMuxerWrapper != null) {
            this.f48787k = false;
            mediaMuxerWrapper.stopRecording();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m35009a(final MediaVideoEncoder mediaVideoEncoder) {
        this.f48783g.queueEvent(new Runnable() {
            public void run() {
                synchronized (DiFaceVideoCaptureManager.this.f48783g) {
                    if (mediaVideoEncoder != null) {
                        mediaVideoEncoder.setEglContext(EGL14.eglGetCurrentContext(), DiFaceVideoCaptureManager.this.f48784h);
                        MediaVideoEncoder unused = DiFaceVideoCaptureManager.this.f48785i = mediaVideoEncoder;
                    }
                }
            }
        });
    }

    public void frameAvailable(float[] fArr, float[] fArr2) {
        MediaVideoEncoder mediaVideoEncoder = this.f48785i;
        if (mediaVideoEncoder != null) {
            mediaVideoEncoder.frameAvailableSoon(fArr, fArr2);
        }
    }

    public void frameAvailable(float[] fArr) {
        MediaVideoEncoder mediaVideoEncoder = this.f48785i;
        if (mediaVideoEncoder != null) {
            mediaVideoEncoder.frameAvailableSoon(fArr, this.f48779c);
        }
    }

    public void frameAvailable() {
        MediaVideoEncoder mediaVideoEncoder = this.f48785i;
        if (mediaVideoEncoder != null) {
            mediaVideoEncoder.frameAvailableSoon();
        }
    }

    public String getVideoPath() {
        MediaMuxerWrapper mediaMuxerWrapper = this.f48780d;
        if (mediaMuxerWrapper == null) {
            return null;
        }
        String outputPath = mediaMuxerWrapper.getOutputPath();
        this.f48780d = null;
        return outputPath;
    }

    public static final File getCaptureFile(Context context, String str, String str2) {
        if (context == null) {
            return null;
        }
        File file = new File(getUnitedTempDir(context), str2);
        file.mkdirs();
        if (!file.canWrite()) {
            return null;
        }
        return new File(file, System.currentTimeMillis() + str);
    }

    /* renamed from: a */
    private static final String m35007a() {
        return f48778b.format(new GregorianCalendar().getTime());
    }

    public IErrorListener getListener() {
        return this.listener;
    }

    public void setListener(IErrorListener iErrorListener) {
        this.listener = iErrorListener;
    }

    public static File getCaptureDir(Context context, String str) {
        if (context == null) {
            return null;
        }
        File file = new File(new File(context.getCacheDir(), "AccessSecurityTempDir"), str);
        file.mkdirs();
        return file;
    }

    public static File getUnitedTempDir(Context context) {
        if (context == null) {
            return null;
        }
        File file = new File(context.getCacheDir(), "AccessSecurityTempDir");
        file.mkdirs();
        return file;
    }
}
