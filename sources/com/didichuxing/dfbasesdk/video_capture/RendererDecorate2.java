package com.didichuxing.dfbasesdk.video_capture;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.os.Build;
import com.didichuxing.dfbasesdk.camera.ICameraInterface;
import com.didichuxing.dfbasesdk.utils.LogUtils;
import com.didichuxing.dfbasesdk.utils.OpenGLUtil;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class RendererDecorate2 implements GLSurfaceView.Renderer, IMediaControl {
    private final ICameraInterface camera;
    private final Context context;
    private IErrorListener listener;
    private CameraMatrix mCameraMatrix;
    private final float[] mMVPMatrix = new float[16];
    private final float[] mProjMatrix = new float[16];
    private int mTextureID = 0;
    private final float[] mVMatrix = new float[16];
    private IRecordVideo recordVideo;
    private GLSurfaceView.Renderer renderer;
    private SurfaceTexture surface;
    /* access modifiers changed from: private */
    public final GLSurfaceView surfaceView;

    public IMediaControl getMediaControl() {
        return this;
    }

    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig, SurfaceTexture surfaceTexture) {
    }

    public RendererDecorate2(Context context2, ICameraInterface iCameraInterface, GLSurfaceView gLSurfaceView) {
        this.context = context2;
        this.camera = iCameraInterface;
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

    public void setRecordVideo(boolean z, float f, int i) {
        RecordVideoWrapper recordVideoWrapper = new RecordVideoWrapper(this.context, z, this.surfaceView, this.camera, f, i);
        this.recordVideo = recordVideoWrapper;
        recordVideoWrapper.setErrorListener(this.listener);
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
            if (this.recordVideo != null && this.recordVideo.recording()) {
                synchronized (this) {
                    this.recordVideo.frameAvailable(fArr);
                }
            }
            if (this.renderer != null) {
                this.renderer.onDrawFrame(gl10);
            }
        } catch (Throwable th) {
            LogUtils.logStackTrace(th);
        }
    }

    private void initSurfaceTextureForCapture() {
        this.mTextureID = OpenGLUtil.createTextureID();
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.mTextureID);
        this.surface = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() {
            public void onFrameAvailable(SurfaceTexture surfaceTexture) {
                if (RendererDecorate2.this.surfaceView != null) {
                    RendererDecorate2.this.surfaceView.requestRender();
                }
            }
        });
        this.mCameraMatrix = new CameraMatrix(this.mTextureID);
    }

    public void startRecord() {
        IRecordVideo iRecordVideo = this.recordVideo;
        if (iRecordVideo != null) {
            iRecordVideo.start(this.mTextureID);
        }
    }

    public void startRecord(String str) {
        IRecordVideo iRecordVideo = this.recordVideo;
        if (iRecordVideo != null) {
            iRecordVideo.start(this.mTextureID, str);
        }
    }

    public void stopRecord() {
        IRecordVideo iRecordVideo = this.recordVideo;
        if (iRecordVideo != null) {
            iRecordVideo.stop();
        }
    }

    public boolean recording() {
        IRecordVideo iRecordVideo = this.recordVideo;
        if (iRecordVideo != null) {
            return iRecordVideo.recording();
        }
        return false;
    }

    public String getVideoPath() {
        IRecordVideo iRecordVideo = this.recordVideo;
        return iRecordVideo != null ? iRecordVideo.getVideoPath() : "";
    }

    public void setErrorListener(IErrorListener iErrorListener) {
        this.listener = iErrorListener;
        IRecordVideo iRecordVideo = this.recordVideo;
        if (iRecordVideo != null) {
            iRecordVideo.setErrorListener(iErrorListener);
        }
    }
}
