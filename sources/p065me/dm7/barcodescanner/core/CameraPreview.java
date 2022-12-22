package p065me.dm7.barcodescanner.core;

import android.content.Context;
import android.graphics.Point;
import android.hardware.Camera;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.didi.sdk.apm.SystemUtils;
import java.util.List;

/* renamed from: me.dm7.barcodescanner.core.CameraPreview */
public class CameraPreview extends SurfaceView implements SurfaceHolder.Callback {

    /* renamed from: b */
    private static final String f4737b = "CameraPreview";

    /* renamed from: a */
    Camera.AutoFocusCallback f4738a = new Camera.AutoFocusCallback() {
        public void onAutoFocus(boolean z, Camera camera) {
            CameraPreview.this.m3030a();
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: c */
    public CameraWrapper f4739c;

    /* renamed from: d */
    private Handler f4740d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f4741e = true;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f4742f = true;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public boolean f4743g = false;

    /* renamed from: h */
    private boolean f4744h = true;

    /* renamed from: i */
    private Camera.PreviewCallback f4745i;

    /* renamed from: j */
    private float f4746j = 0.1f;

    /* renamed from: k */
    private Runnable f4747k = new Runnable() {
        public void run() {
            if (CameraPreview.this.f4739c != null && CameraPreview.this.f4741e && CameraPreview.this.f4742f && CameraPreview.this.f4743g) {
                CameraPreview.this.safeAutoFocus();
            }
        }
    };

    public CameraPreview(Context context, CameraWrapper cameraWrapper, Camera.PreviewCallback previewCallback) {
        super(context);
        init(cameraWrapper, previewCallback);
    }

    public CameraPreview(Context context, AttributeSet attributeSet, CameraWrapper cameraWrapper, Camera.PreviewCallback previewCallback) {
        super(context, attributeSet);
        init(cameraWrapper, previewCallback);
    }

    public void init(CameraWrapper cameraWrapper, Camera.PreviewCallback previewCallback) {
        setCamera(cameraWrapper, previewCallback);
        this.f4740d = new Handler();
        getHolder().addCallback(this);
        getHolder().setType(3);
    }

    public void setCamera(CameraWrapper cameraWrapper, Camera.PreviewCallback previewCallback) {
        this.f4739c = cameraWrapper;
        this.f4745i = previewCallback;
    }

    public void setShouldScaleToFill(boolean z) {
        this.f4744h = z;
    }

    public void setAspectTolerance(float f) {
        this.f4746j = f;
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.f4743g = true;
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (surfaceHolder.getSurface() != null) {
            stopCameraPreview();
            showCameraPreview();
        }
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.f4743g = false;
        stopCameraPreview();
    }

    public void showCameraPreview() {
        if (this.f4739c != null) {
            try {
                getHolder().addCallback(this);
                this.f4741e = true;
                setupCameraParameters();
                this.f4739c.mCamera.setPreviewDisplay(getHolder());
                this.f4739c.mCamera.setDisplayOrientation(getDisplayOrientation());
                this.f4739c.mCamera.setOneShotPreviewCallback(this.f4745i);
                this.f4739c.mCamera.startPreview();
                if (!this.f4742f) {
                    return;
                }
                if (this.f4743g) {
                    safeAutoFocus();
                } else {
                    m3030a();
                }
            } catch (Exception e) {
                Exception exc = e;
                SystemUtils.log(6, f4737b, exc.toString(), exc, "me.dm7.barcodescanner.core.CameraPreview", 100);
            }
        }
    }

    public void safeAutoFocus() {
        try {
            this.f4739c.mCamera.autoFocus(this.f4738a);
        } catch (RuntimeException unused) {
            m3030a();
        }
    }

    public void stopCameraPreview() {
        if (this.f4739c != null) {
            try {
                this.f4741e = false;
                getHolder().removeCallback(this);
                this.f4739c.mCamera.cancelAutoFocus();
                this.f4739c.mCamera.setOneShotPreviewCallback((Camera.PreviewCallback) null);
                this.f4739c.mCamera.stopPreview();
            } catch (Exception e) {
                Exception exc = e;
                SystemUtils.log(6, f4737b, exc.toString(), exc, "me.dm7.barcodescanner.core.CameraPreview", 124);
            }
        }
    }

    public void setupCameraParameters() {
        Camera.Size optimalPreviewSize = getOptimalPreviewSize();
        Camera.Parameters parameters = this.f4739c.mCamera.getParameters();
        parameters.setPreviewSize(optimalPreviewSize.width, optimalPreviewSize.height);
        this.f4739c.mCamera.setParameters(parameters);
        m3032a(optimalPreviewSize);
    }

    /* renamed from: a */
    private void m3032a(Camera.Size size) {
        Point a = m3028a(new Point(getWidth(), getHeight()));
        float f = ((float) size.width) / ((float) size.height);
        if (((float) a.x) / ((float) a.y) > f) {
            m3031a((int) (((float) a.y) * f), a.y);
        } else {
            m3031a(a.x, (int) (((float) a.x) / f));
        }
    }

    /* renamed from: a */
    private Point m3028a(Point point) {
        if (getDisplayOrientation() % 180 == 0) {
            return point;
        }
        return new Point(point.y, point.x);
    }

    /* renamed from: a */
    private void m3031a(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (getDisplayOrientation() % 180 != 0) {
            int i3 = i2;
            i2 = i;
            i = i3;
        }
        if (this.f4744h) {
            float f = (float) i;
            float width = ((float) ((View) getParent()).getWidth()) / f;
            float f2 = (float) i2;
            float height = ((float) ((View) getParent()).getHeight()) / f2;
            if (width <= height) {
                width = height;
            }
            i = Math.round(f * width);
            i2 = Math.round(f2 * width);
        }
        layoutParams.width = i;
        layoutParams.height = i2;
        setLayoutParams(layoutParams);
    }

    public int getDisplayOrientation() {
        int i = 0;
        if (this.f4739c == null) {
            return 0;
        }
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        if (this.f4739c.mCameraId == -1) {
            Camera.getCameraInfo(0, cameraInfo);
        } else {
            Camera.getCameraInfo(this.f4739c.mCameraId, cameraInfo);
        }
        int rotation = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getRotation();
        if (rotation != 0) {
            if (rotation == 1) {
                i = 90;
            } else if (rotation == 2) {
                i = 180;
            } else if (rotation == 3) {
                i = 270;
            }
        }
        if (cameraInfo.facing == 1) {
            return (360 - ((cameraInfo.orientation + i) % 360)) % 360;
        }
        return ((cameraInfo.orientation - i) + 360) % 360;
    }

    private Camera.Size getOptimalPreviewSize() {
        CameraWrapper cameraWrapper = this.f4739c;
        Camera.Size size = null;
        if (cameraWrapper == null) {
            return null;
        }
        List<Camera.Size> supportedPreviewSizes = cameraWrapper.mCamera.getParameters().getSupportedPreviewSizes();
        int width = getWidth();
        int height = getHeight();
        if (DisplayUtils.getScreenOrientation(getContext()) == 1) {
            int i = height;
            height = width;
            width = i;
        }
        double d = ((double) width) / ((double) height);
        if (supportedPreviewSizes == null) {
            return null;
        }
        double d2 = Double.MAX_VALUE;
        double d3 = Double.MAX_VALUE;
        for (Camera.Size next : supportedPreviewSizes) {
            if (Math.abs((((double) next.width) / ((double) next.height)) - d) <= ((double) this.f4746j) && ((double) Math.abs(next.height - height)) < d3) {
                d3 = (double) Math.abs(next.height - height);
                size = next;
            }
        }
        if (size == null) {
            for (Camera.Size next2 : supportedPreviewSizes) {
                if (((double) Math.abs(next2.height - height)) < d2) {
                    size = next2;
                    d2 = (double) Math.abs(next2.height - height);
                }
            }
        }
        return size;
    }

    public void setAutoFocus(boolean z) {
        if (this.f4739c != null && this.f4741e && z != this.f4742f) {
            this.f4742f = z;
            if (!z) {
                SystemUtils.log(2, f4737b, "Cancelling autofocus", (Throwable) null, "me.dm7.barcodescanner.core.CameraPreview", 288);
                this.f4739c.mCamera.cancelAutoFocus();
            } else if (this.f4743g) {
                SystemUtils.log(2, f4737b, "Starting autofocus", (Throwable) null, "me.dm7.barcodescanner.core.CameraPreview", 282);
                safeAutoFocus();
            } else {
                m3030a();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m3030a() {
        this.f4740d.postDelayed(this.f4747k, 1000);
    }
}
