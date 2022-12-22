package com.didichuxing.sdk.alphaface.core;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.os.Build;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.sdk.alphaface.utils.OpenGLUtil;
import com.didichuxing.sdk.alphaface.video_capture.CameraMatrix;
import com.didichuxing.sdk.alphaface.video_capture.DiFaceVideoCaptureManager;
import com.didichuxing.sdk.alphaface.video_capture.IErrorListener;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class RendererDecorate implements GLSurfaceView.Renderer {
    private final Context context;
    private boolean isRecordVideo;
    private IErrorListener listener;
    private CameraMatrix mCameraMatrix;
    private final float[] mMVPMatrix = new float[16];
    private final float[] mProjMatrix = new float[16];
    private int mTextureID = 0;
    private final float[] mVMatrix = new float[16];
    private DiFaceVideoCaptureManager mediaManager;
    private GLSurfaceView.Renderer renderer;
    private SurfaceTexture surface;
    private boolean surfaceCreate;
    /* access modifiers changed from: private */
    public final GLSurfaceView surfaceView;

    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig, SurfaceTexture surfaceTexture) {
    }

    public RendererDecorate(Context context2, GLSurfaceView gLSurfaceView) {
        this.context = context2;
        this.surfaceView = gLSurfaceView;
    }

    public void setRenderer(GLSurfaceView.Renderer renderer2) {
        this.renderer = renderer2;
    }

    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        if (Build.VERSION.SDK_INT >= 16) {
            initSurfaceTextureForCapture();
        }
        GLSurfaceView.Renderer renderer2 = this.renderer;
        if (renderer2 != null) {
            renderer2.onSurfaceCreated(gl10, eGLConfig);
        }
        onSurfaceCreated(gl10, eGLConfig, this.surface);
    }

    public boolean setRecordVideo(boolean z, int i, int i2, boolean z2, float f, int i3) {
        this.isRecordVideo = z;
        if (Build.VERSION.SDK_INT < 18) {
            this.isRecordVideo = false;
            return false;
        }
        if (this.isRecordVideo) {
            DiFaceVideoCaptureManager diFaceVideoCaptureManager = new DiFaceVideoCaptureManager(i, i2, z2, this.surfaceView, f, i3);
            this.mediaManager = diFaceVideoCaptureManager;
            diFaceVideoCaptureManager.setListener(this.listener);
        }
        return this.isRecordVideo;
    }

    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        GLES20.glViewport(0, 0, i, i2);
        Matrix.frustumM(this.mProjMatrix, 0, -1.0f, 1.0f, -1.0f, 1.0f, 3.0f, 7.0f);
        GLSurfaceView.Renderer renderer2 = this.renderer;
        if (renderer2 != null) {
            renderer2.onSurfaceChanged(gl10, i, i2);
        }
    }

    public void onDrawFrame(GL10 gl10) {
        try {
            GLES20.glClear(16640);
            Matrix.setLookAtM(this.mVMatrix, 0, 0.0f, 0.0f, -3.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f);
            Matrix.multiplyMM(this.mMVPMatrix, 0, this.mProjMatrix, 0, this.mVMatrix, 0);
            this.surface.updateTexImage();
            float[] fArr = new float[16];
            this.surface.getTransformMatrix(fArr);
            this.mCameraMatrix.draw(fArr);
            this.surface.updateTexImage();
            if (this.isRecordVideo && this.mediaManager != null) {
                synchronized (this) {
                    this.mediaManager.frameAvailable(fArr);
                }
            }
            if (this.renderer != null) {
                this.renderer.onDrawFrame(gl10);
            }
        } catch (Throwable th) {
            SystemUtils.log(6, "af_default ", "onDrawFrame: ", th, "com.didichuxing.sdk.alphaface.core.RendererDecorate", 118);
        }
    }

    private void initSurfaceTextureForCapture() {
        this.mTextureID = OpenGLUtil.createTextureID();
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.mTextureID);
        this.surface = surfaceTexture;
        this.surfaceCreate = true;
        surfaceTexture.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() {
            public void onFrameAvailable(SurfaceTexture surfaceTexture) {
                if (RendererDecorate.this.surfaceView != null) {
                    RendererDecorate.this.surfaceView.requestRender();
                }
            }
        });
        this.mCameraMatrix = new CameraMatrix(this.mTextureID);
    }

    public void startRecord() {
        String str;
        StringBuilder sb;
        boolean z;
        DiFaceVideoCaptureManager diFaceVideoCaptureManager;
        if (!this.isRecordVideo || (diFaceVideoCaptureManager = this.mediaManager) == null || !this.surfaceCreate) {
            IErrorListener iErrorListener = this.listener;
            if (iErrorListener != null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("startRecord failed : ");
                if (!this.isRecordVideo) {
                    sb = new StringBuilder();
                    sb.append("isRecordVideo is ");
                    z = this.isRecordVideo;
                } else if (this.mediaManager == null) {
                    str = " mediaManager == null ";
                    sb2.append(str);
                    iErrorListener.onError(sb2.toString());
                    return;
                } else {
                    sb = this.surfaceCreate ? new StringBuilder() : new StringBuilder();
                    sb.append(" surfaceCreate is ");
                    z = this.surfaceCreate;
                }
                sb.append(z);
                str = sb.toString();
                sb2.append(str);
                iErrorListener.onError(sb2.toString());
                return;
            }
            return;
        }
        diFaceVideoCaptureManager.startRecording(this.context, this.mTextureID);
    }

    public void stopCapture() {
        DiFaceVideoCaptureManager diFaceVideoCaptureManager;
        if (this.isRecordVideo && (diFaceVideoCaptureManager = this.mediaManager) != null && diFaceVideoCaptureManager.isRecording()) {
            this.mediaManager.stopRecording();
        }
    }

    public String getVideoPath() {
        DiFaceVideoCaptureManager diFaceVideoCaptureManager;
        if (!this.isRecordVideo || (diFaceVideoCaptureManager = this.mediaManager) == null || !diFaceVideoCaptureManager.isRecording()) {
            return "";
        }
        this.mediaManager.stopRecording();
        return this.mediaManager.getVideoPath();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r1.mediaManager;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isRecordVideo() {
        /*
            r1 = this;
            boolean r0 = r1.isRecordVideo
            if (r0 == 0) goto L_0x0010
            com.didichuxing.sdk.alphaface.video_capture.DiFaceVideoCaptureManager r0 = r1.mediaManager
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
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.sdk.alphaface.core.RendererDecorate.isRecordVideo():boolean");
    }

    public IErrorListener getListener() {
        return this.listener;
    }

    public void setListener(IErrorListener iErrorListener) {
        DiFaceVideoCaptureManager diFaceVideoCaptureManager;
        this.listener = iErrorListener;
        if (Build.VERSION.SDK_INT >= 16 && (diFaceVideoCaptureManager = this.mediaManager) != null) {
            diFaceVideoCaptureManager.setListener(iErrorListener);
        }
    }
}
