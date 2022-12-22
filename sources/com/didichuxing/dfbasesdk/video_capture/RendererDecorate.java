package com.didichuxing.dfbasesdk.video_capture;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.os.Build;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.dfbasesdk.utils.OpenGLUtil;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class RendererDecorate implements GLSurfaceView.Renderer {

    /* renamed from: a */
    private final Context f46868a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final GLSurfaceView f46869b;

    /* renamed from: c */
    private GLSurfaceView.Renderer f46870c;

    /* renamed from: d */
    private DiFaceVideoCaptureManager f46871d;

    /* renamed from: e */
    private CameraMatrix f46872e;

    /* renamed from: f */
    private int f46873f = 0;

    /* renamed from: g */
    private SurfaceTexture f46874g;

    /* renamed from: h */
    private boolean f46875h;

    /* renamed from: i */
    private boolean f46876i;

    /* renamed from: j */
    private final float[] f46877j = new float[16];

    /* renamed from: k */
    private final float[] f46878k = new float[16];

    /* renamed from: l */
    private final float[] f46879l = new float[16];

    /* renamed from: m */
    private IErrorListener f46880m;

    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig, SurfaceTexture surfaceTexture) {
    }

    public RendererDecorate(Context context, GLSurfaceView gLSurfaceView) {
        this.f46868a = context;
        this.f46869b = gLSurfaceView;
    }

    public void setRenderer(GLSurfaceView.Renderer renderer) {
        this.f46870c = renderer;
    }

    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        if (Build.VERSION.SDK_INT >= 16) {
            m33626a();
        }
        GLSurfaceView.Renderer renderer = this.f46870c;
        if (renderer != null) {
            renderer.onSurfaceCreated(gl10, eGLConfig);
        }
        onSurfaceCreated(gl10, eGLConfig, this.f46874g);
    }

    public boolean setRecordVideo(boolean z, int i, int i2, boolean z2, float f, int i3) {
        this.f46875h = z;
        if (Build.VERSION.SDK_INT < 18) {
            this.f46875h = false;
            return false;
        }
        if (this.f46875h) {
            DiFaceVideoCaptureManager diFaceVideoCaptureManager = new DiFaceVideoCaptureManager(i, i2, z2, this.f46869b, f, i3);
            this.f46871d = diFaceVideoCaptureManager;
            diFaceVideoCaptureManager.setListener(this.f46880m);
        }
        return this.f46875h;
    }

    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        GLES20.glViewport(0, 0, i, i2);
        Matrix.frustumM(this.f46878k, 0, -1.0f, 1.0f, -1.0f, 1.0f, 3.0f, 7.0f);
        GLSurfaceView.Renderer renderer = this.f46870c;
        if (renderer != null) {
            renderer.onSurfaceChanged(gl10, i, i2);
        }
    }

    public void onDrawFrame(GL10 gl10) {
        try {
            GLES20.glClear(16640);
            Matrix.setLookAtM(this.f46879l, 0, 0.0f, 0.0f, -3.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f);
            Matrix.multiplyMM(this.f46877j, 0, this.f46878k, 0, this.f46879l, 0);
            this.f46874g.updateTexImage();
            float[] fArr = new float[16];
            this.f46874g.getTransformMatrix(fArr);
            this.f46872e.draw(fArr);
            this.f46874g.updateTexImage();
            if (this.f46875h && this.f46871d != null) {
                synchronized (this) {
                    this.f46871d.frameAvailable(fArr);
                }
            }
            if (this.f46870c != null) {
                this.f46870c.onDrawFrame(gl10);
            }
        } catch (Throwable th) {
            SystemUtils.log(6, "af_default ", "onDrawFrame: ", th, "com.didichuxing.dfbasesdk.video_capture.RendererDecorate", 116);
        }
    }

    /* renamed from: a */
    private void m33626a() {
        this.f46873f = OpenGLUtil.createTextureID();
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.f46873f);
        this.f46874g = surfaceTexture;
        this.f46876i = true;
        surfaceTexture.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() {
            public void onFrameAvailable(SurfaceTexture surfaceTexture) {
                if (RendererDecorate.this.f46869b != null) {
                    RendererDecorate.this.f46869b.requestRender();
                }
            }
        });
        this.f46872e = new CameraMatrix(this.f46873f);
    }

    public void startRecord() {
        String str;
        StringBuilder sb;
        boolean z;
        DiFaceVideoCaptureManager diFaceVideoCaptureManager;
        if (!this.f46875h || (diFaceVideoCaptureManager = this.f46871d) == null || !this.f46876i) {
            IErrorListener iErrorListener = this.f46880m;
            if (iErrorListener != null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("startRecord failed : ");
                if (!this.f46875h) {
                    sb = new StringBuilder();
                    sb.append("isRecordVideo is ");
                    z = this.f46875h;
                } else if (this.f46871d == null) {
                    str = " mediaManager == null ";
                    sb2.append(str);
                    iErrorListener.onError(sb2.toString());
                    return;
                } else {
                    sb = this.f46876i ? new StringBuilder() : new StringBuilder();
                    sb.append(" surfaceCreate is ");
                    z = this.f46876i;
                }
                sb.append(z);
                str = sb.toString();
                sb2.append(str);
                iErrorListener.onError(sb2.toString());
                return;
            }
            return;
        }
        diFaceVideoCaptureManager.startRecording(this.f46868a, this.f46873f);
    }

    public void stopCapture() {
        DiFaceVideoCaptureManager diFaceVideoCaptureManager;
        if (this.f46875h && (diFaceVideoCaptureManager = this.f46871d) != null && diFaceVideoCaptureManager.isRecording()) {
            this.f46871d.stopRecording();
        }
    }

    public String getVideoPath() {
        DiFaceVideoCaptureManager diFaceVideoCaptureManager;
        if (!this.f46875h || (diFaceVideoCaptureManager = this.f46871d) == null || !diFaceVideoCaptureManager.isRecording()) {
            return "";
        }
        this.f46871d.stopRecording();
        return this.f46871d.getVideoPath();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r1.f46871d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isRecordVideo() {
        /*
            r1 = this;
            boolean r0 = r1.f46875h
            if (r0 == 0) goto L_0x0010
            com.didichuxing.dfbasesdk.video_capture.DiFaceVideoCaptureManager r0 = r1.f46871d
            if (r0 == 0) goto L_0x0010
            boolean r0 = r0.isRecording()
            if (r0 == 0) goto L_0x0010
            r0 = 1
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.dfbasesdk.video_capture.RendererDecorate.isRecordVideo():boolean");
    }

    public IErrorListener getListener() {
        return this.f46880m;
    }

    public void setListener(IErrorListener iErrorListener) {
        DiFaceVideoCaptureManager diFaceVideoCaptureManager;
        this.f46880m = iErrorListener;
        if (Build.VERSION.SDK_INT >= 16 && (diFaceVideoCaptureManager = this.f46871d) != null) {
            diFaceVideoCaptureManager.setListener(iErrorListener);
        }
    }
}
