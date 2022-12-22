package com.didichuxing.dfbasesdk.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.passenger.C10448R;
import com.didichuxing.dfbasesdk.camera.CameraWrapper;
import com.didichuxing.dfbasesdk.camera.IMediaInterface;
import com.didichuxing.dfbasesdk.utils.ResUtils;
import com.didichuxing.dfbasesdk.video_capture.IErrorListener;
import com.didichuxing.dfbasesdk.video_capture.IMediaControl;
import com.didichuxing.dfbasesdk.video_capture.RendererDecorate2;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class GLSurfaceViewEx extends GLSurfaceView implements LifecycleObserver, IMediaInterface {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public CameraWrapper f46920a;

    /* renamed from: b */
    private RendererDecorate2 f46921b;

    /* renamed from: c */
    private int f46922c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public SurfaceTexture f46923d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Camera.PreviewCallback f46924e;

    /* renamed from: f */
    private IMediaControl f46925f;

    /* renamed from: g */
    private int f46926g;

    /* renamed from: h */
    private int f46927h;

    public GLSurfaceViewEx(Context context) {
        this(context, (AttributeSet) null);
    }

    public GLSurfaceViewEx(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m33644a(attributeSet);
        m33643a();
    }

    /* renamed from: a */
    private void m33644a(AttributeSet attributeSet) {
        TypedArray typedArray = null;
        try {
            typedArray = getContext().obtainStyledAttributes(attributeSet, C10448R.styleable.GLSurfaceViewEx);
            this.f46926g = typedArray.getInt(4, 640);
            this.f46927h = typedArray.getInt(3, 480);
            int i = typedArray.getInt(2, -1);
            int i2 = typedArray.getInt(1, -1);
            this.f46922c = typedArray.getInt(0, 0);
            this.f46920a = new CameraWrapper(ResUtils.isScreenPortrait(getContext()), -1, -1, this.f46926g, this.f46927h, i, i2);
            if (typedArray == null) {
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (typedArray == null) {
                return;
            }
        } catch (Throwable th) {
            if (typedArray != null) {
                typedArray.recycle();
            }
            throw th;
        }
        typedArray.recycle();
    }

    public void setCallback(Camera.PreviewCallback previewCallback) {
        this.f46924e = previewCallback;
    }

    /* renamed from: a */
    private void m33643a() {
        setEGLContextClientVersion(2);
        C153221 r0 = new RendererDecorate2(getContext(), this.f46920a, this) {
            public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig, SurfaceTexture surfaceTexture) {
                SurfaceTexture unused = GLSurfaceViewEx.this.f46923d = surfaceTexture;
                if (GLSurfaceViewEx.this.f46920a != null) {
                    GLSurfaceViewEx.this.f46920a.startPreview(GLSurfaceViewEx.this.f46923d);
                    GLSurfaceViewEx.this.f46920a.autoFocus();
                    if (GLSurfaceViewEx.this.f46924e != null) {
                        GLSurfaceViewEx.this.f46920a.setPreviewCallback(GLSurfaceViewEx.this.f46924e);
                    }
                }
            }
        };
        this.f46921b = r0;
        setRenderer(r0);
        this.f46925f = this.f46921b.getMediaControl();
        if (getContext() instanceof LifecycleOwner) {
            ((LifecycleOwner) getContext()).getLifecycle().addObserver(this);
        }
        setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GLSurfaceViewEx.this.autoFocus();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        setMeasuredDimension(measuredWidth, (int) (((((float) measuredWidth) * 1.0f) * ((float) this.f46926g)) / ((float) this.f46927h)));
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void openCamera() {
        CameraWrapper cameraWrapper = this.f46920a;
        if (cameraWrapper != null) {
            cameraWrapper.openCamera(this.f46922c);
            if (!(this.f46920a.getPreviewWidth() == this.f46926g && this.f46920a.getPreviewHeight() == this.f46927h)) {
                this.f46926g = this.f46920a.getPreviewWidth();
                this.f46927h = this.f46920a.getPreviewHeight();
                requestLayout();
            }
        }
        onResume();
    }

    public void openCamera(int i) {
        this.f46922c = i;
        openCamera();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void closeCamera() {
        onPause();
        CameraWrapper cameraWrapper = this.f46920a;
        if (cameraWrapper != null) {
            cameraWrapper.closeCamera();
        }
    }

    public void setRecordVideo(boolean z, float f, int i) {
        RendererDecorate2 rendererDecorate2 = this.f46921b;
        if (rendererDecorate2 != null) {
            rendererDecorate2.setRecordVideo(z, f, i);
        }
    }

    public void startRecord() {
        IMediaControl iMediaControl = this.f46925f;
        if (iMediaControl != null) {
            iMediaControl.startRecord();
        }
    }

    public void startRecord(String str) {
        IMediaControl iMediaControl = this.f46925f;
        if (iMediaControl != null) {
            iMediaControl.startRecord(str);
        }
    }

    public void stopRecord() {
        IMediaControl iMediaControl = this.f46925f;
        if (iMediaControl != null) {
            iMediaControl.stopRecord();
        }
    }

    public boolean recording() {
        IMediaControl iMediaControl = this.f46925f;
        if (iMediaControl != null) {
            return iMediaControl.recording();
        }
        return false;
    }

    public String getVideoPath() {
        IMediaControl iMediaControl = this.f46925f;
        if (iMediaControl != null) {
            return iMediaControl.getVideoPath();
        }
        return null;
    }

    public void setErrorListener(IErrorListener iErrorListener) {
        IMediaControl iMediaControl = this.f46925f;
        if (iMediaControl != null) {
            iMediaControl.setErrorListener(iErrorListener);
        }
    }

    public void switchCamera() {
        SurfaceTexture surfaceTexture;
        CameraWrapper cameraWrapper = this.f46920a;
        if (cameraWrapper != null && (surfaceTexture = this.f46923d) != null) {
            cameraWrapper.switchCamera(surfaceTexture);
        }
    }

    public void autoFocus() {
        CameraWrapper cameraWrapper = this.f46920a;
        if (cameraWrapper != null) {
            cameraWrapper.autoFocus();
        }
    }

    public void takePhoto(Camera.PictureCallback pictureCallback) {
        CameraWrapper cameraWrapper = this.f46920a;
        if (cameraWrapper != null) {
            cameraWrapper.takePhoto(pictureCallback);
        }
    }

    public boolean switchFlashLight() {
        CameraWrapper cameraWrapper = this.f46920a;
        if (cameraWrapper != null) {
            return cameraWrapper.switchFlashLight();
        }
        return false;
    }

    public CameraWrapper getCamera() {
        return this.f46920a;
    }

    public int getPreviewWidth() {
        return this.f46920a.getPreviewWidth();
    }

    public int getPreviewHeight() {
        return this.f46920a.getPreviewHeight();
    }
}
