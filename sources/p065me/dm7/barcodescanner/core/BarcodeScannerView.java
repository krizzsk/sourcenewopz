package p065me.dm7.barcodescanner.core;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.hardware.Camera;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.didi.passenger.C10448R;
import com.taxis99.R;
import kotlinx.coroutines.DebugKt;

/* renamed from: me.dm7.barcodescanner.core.BarcodeScannerView */
public abstract class BarcodeScannerView extends FrameLayout implements Camera.PreviewCallback {

    /* renamed from: a */
    private CameraWrapper f4715a;

    /* renamed from: b */
    private CameraPreview f4716b;

    /* renamed from: c */
    private IViewFinder f4717c;

    /* renamed from: d */
    private Rect f4718d;

    /* renamed from: e */
    private CameraHandlerThread f4719e;

    /* renamed from: f */
    private Boolean f4720f;

    /* renamed from: g */
    private boolean f4721g = true;

    /* renamed from: h */
    private boolean f4722h = true;

    /* renamed from: i */
    private boolean f4723i = true;

    /* renamed from: j */
    private int f4724j = getResources().getColor(R.color.viewfinder_laser);

    /* renamed from: k */
    private int f4725k = getResources().getColor(R.color.viewfinder_border);

    /* renamed from: l */
    private int f4726l = getResources().getColor(R.color.viewfinder_mask);

    /* renamed from: m */
    private int f4727m = getResources().getInteger(R.integer.viewfinder_border_width);

    /* renamed from: n */
    private int f4728n = getResources().getInteger(R.integer.viewfinder_border_length);

    /* renamed from: o */
    private boolean f4729o = false;

    /* renamed from: p */
    private int f4730p = 0;

    /* renamed from: q */
    private boolean f4731q = false;

    /* renamed from: r */
    private float f4732r = 1.0f;

    /* renamed from: s */
    private int f4733s = 0;

    /* renamed from: t */
    private float f4734t = 0.1f;

    public BarcodeScannerView(Context context) {
        super(context);
        m3026a();
    }

    /* JADX INFO: finally extract failed */
    public BarcodeScannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C10448R.styleable.BarcodeScannerView, 0, 0);
        try {
            setShouldScaleToFill(obtainStyledAttributes.getBoolean(10, true));
            this.f4723i = obtainStyledAttributes.getBoolean(7, this.f4723i);
            this.f4724j = obtainStyledAttributes.getColor(6, this.f4724j);
            this.f4725k = obtainStyledAttributes.getColor(1, this.f4725k);
            this.f4726l = obtainStyledAttributes.getColor(8, this.f4726l);
            this.f4727m = obtainStyledAttributes.getDimensionPixelSize(3, this.f4727m);
            this.f4728n = obtainStyledAttributes.getDimensionPixelSize(2, this.f4728n);
            this.f4729o = obtainStyledAttributes.getBoolean(9, this.f4729o);
            this.f4730p = obtainStyledAttributes.getDimensionPixelSize(4, this.f4730p);
            this.f4731q = obtainStyledAttributes.getBoolean(11, this.f4731q);
            this.f4732r = obtainStyledAttributes.getFloat(0, this.f4732r);
            this.f4733s = obtainStyledAttributes.getDimensionPixelSize(5, this.f4733s);
            obtainStyledAttributes.recycle();
            m3026a();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    /* renamed from: a */
    private void m3026a() {
        this.f4717c = createViewFinderView(getContext());
    }

    public final void setupLayout(CameraWrapper cameraWrapper) {
        removeAllViews();
        CameraPreview cameraPreview = new CameraPreview(getContext(), cameraWrapper, this);
        this.f4716b = cameraPreview;
        cameraPreview.setAspectTolerance(this.f4734t);
        this.f4716b.setShouldScaleToFill(this.f4722h);
        if (!this.f4722h) {
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            relativeLayout.setGravity(17);
            relativeLayout.setBackgroundColor(-16777216);
            relativeLayout.addView(this.f4716b);
            addView(relativeLayout);
        } else {
            addView(this.f4716b);
        }
        IViewFinder iViewFinder = this.f4717c;
        if (iViewFinder instanceof View) {
            addView((View) iViewFinder);
            return;
        }
        throw new IllegalArgumentException("IViewFinder object returned by 'createViewFinderView()' should be instance of android.view.View");
    }

    /* access modifiers changed from: protected */
    public IViewFinder createViewFinderView(Context context) {
        ViewFinderView viewFinderView = new ViewFinderView(context);
        viewFinderView.setBorderColor(this.f4725k);
        viewFinderView.setLaserColor(this.f4724j);
        viewFinderView.setLaserEnabled(this.f4723i);
        viewFinderView.setBorderStrokeWidth(this.f4727m);
        viewFinderView.setBorderLineLength(this.f4728n);
        viewFinderView.setMaskColor(this.f4726l);
        viewFinderView.setBorderCornerRounded(this.f4729o);
        viewFinderView.setBorderCornerRadius(this.f4730p);
        viewFinderView.setSquareViewFinder(this.f4731q);
        viewFinderView.setViewFinderOffset(this.f4733s);
        return viewFinderView;
    }

    public void setLaserColor(int i) {
        this.f4724j = i;
        this.f4717c.setLaserColor(i);
        this.f4717c.setupViewFinder();
    }

    public void setMaskColor(int i) {
        this.f4726l = i;
        this.f4717c.setMaskColor(i);
        this.f4717c.setupViewFinder();
    }

    public void setBorderColor(int i) {
        this.f4725k = i;
        this.f4717c.setBorderColor(i);
        this.f4717c.setupViewFinder();
    }

    public void setBorderStrokeWidth(int i) {
        this.f4727m = i;
        this.f4717c.setBorderStrokeWidth(i);
        this.f4717c.setupViewFinder();
    }

    public void setBorderLineLength(int i) {
        this.f4728n = i;
        this.f4717c.setBorderLineLength(i);
        this.f4717c.setupViewFinder();
    }

    public void setLaserEnabled(boolean z) {
        this.f4723i = z;
        this.f4717c.setLaserEnabled(z);
        this.f4717c.setupViewFinder();
    }

    public void setIsBorderCornerRounded(boolean z) {
        this.f4729o = z;
        this.f4717c.setBorderCornerRounded(z);
        this.f4717c.setupViewFinder();
    }

    public void setBorderCornerRadius(int i) {
        this.f4730p = i;
        this.f4717c.setBorderCornerRadius(i);
        this.f4717c.setupViewFinder();
    }

    public void setSquareViewFinder(boolean z) {
        this.f4731q = z;
        this.f4717c.setSquareViewFinder(z);
        this.f4717c.setupViewFinder();
    }

    public void setBorderAlpha(float f) {
        this.f4732r = f;
        this.f4717c.setBorderAlpha(f);
        this.f4717c.setupViewFinder();
    }

    public void startCamera(int i) {
        if (this.f4719e == null) {
            this.f4719e = new CameraHandlerThread(this);
        }
        this.f4719e.startCamera(i);
    }

    public void setupCameraPreview(CameraWrapper cameraWrapper) {
        this.f4715a = cameraWrapper;
        if (cameraWrapper != null) {
            setupLayout(cameraWrapper);
            this.f4717c.setupViewFinder();
            Boolean bool = this.f4720f;
            if (bool != null) {
                setFlash(bool.booleanValue());
            }
            setAutoFocus(this.f4721g);
        }
    }

    public void startCamera() {
        startCamera(CameraUtils.getDefaultCameraId());
    }

    public void stopCamera() {
        if (this.f4715a != null) {
            this.f4716b.stopCameraPreview();
            this.f4716b.setCamera((CameraWrapper) null, (Camera.PreviewCallback) null);
            this.f4715a.mCamera.release();
            this.f4715a = null;
        }
        CameraHandlerThread cameraHandlerThread = this.f4719e;
        if (cameraHandlerThread != null) {
            cameraHandlerThread.quit();
            this.f4719e = null;
        }
    }

    public void stopCameraPreview() {
        CameraPreview cameraPreview = this.f4716b;
        if (cameraPreview != null) {
            cameraPreview.stopCameraPreview();
        }
    }

    /* access modifiers changed from: protected */
    public void resumeCameraPreview() {
        CameraPreview cameraPreview = this.f4716b;
        if (cameraPreview != null) {
            cameraPreview.showCameraPreview();
        }
    }

    public synchronized Rect getFramingRectInPreview(int i, int i2) {
        if (this.f4718d == null) {
            Rect framingRect = this.f4717c.getFramingRect();
            int width = this.f4717c.getWidth();
            int height = this.f4717c.getHeight();
            if (!(framingRect == null || width == 0)) {
                if (height != 0) {
                    Rect rect = new Rect(framingRect);
                    if (i < width) {
                        rect.left = (rect.left * i) / width;
                        rect.right = (rect.right * i) / width;
                    }
                    if (i2 < height) {
                        rect.top = (rect.top * i2) / height;
                        rect.bottom = (rect.bottom * i2) / height;
                    }
                    this.f4718d = rect;
                }
            }
            return null;
        }
        return this.f4718d;
    }

    public void setFlash(boolean z) {
        this.f4720f = Boolean.valueOf(z);
        CameraWrapper cameraWrapper = this.f4715a;
        if (cameraWrapper != null && CameraUtils.isFlashSupported(cameraWrapper.mCamera)) {
            Camera.Parameters parameters = this.f4715a.mCamera.getParameters();
            if (z) {
                if (!parameters.getFlashMode().equals("torch")) {
                    parameters.setFlashMode("torch");
                } else {
                    return;
                }
            } else if (!parameters.getFlashMode().equals(DebugKt.DEBUG_PROPERTY_VALUE_OFF)) {
                parameters.setFlashMode(DebugKt.DEBUG_PROPERTY_VALUE_OFF);
            } else {
                return;
            }
            this.f4715a.mCamera.setParameters(parameters);
        }
    }

    public boolean getFlash() {
        CameraWrapper cameraWrapper = this.f4715a;
        if (cameraWrapper == null || !CameraUtils.isFlashSupported(cameraWrapper.mCamera) || !this.f4715a.mCamera.getParameters().getFlashMode().equals("torch")) {
            return false;
        }
        return true;
    }

    public void toggleFlash() {
        CameraWrapper cameraWrapper = this.f4715a;
        if (cameraWrapper != null && CameraUtils.isFlashSupported(cameraWrapper.mCamera)) {
            Camera.Parameters parameters = this.f4715a.mCamera.getParameters();
            if (parameters.getFlashMode().equals("torch")) {
                parameters.setFlashMode(DebugKt.DEBUG_PROPERTY_VALUE_OFF);
            } else {
                parameters.setFlashMode("torch");
            }
            this.f4715a.mCamera.setParameters(parameters);
        }
    }

    public void setAutoFocus(boolean z) {
        this.f4721g = z;
        CameraPreview cameraPreview = this.f4716b;
        if (cameraPreview != null) {
            cameraPreview.setAutoFocus(z);
        }
    }

    public void setShouldScaleToFill(boolean z) {
        this.f4722h = z;
    }

    public void setAspectTolerance(float f) {
        this.f4734t = f;
    }

    public byte[] getRotatedData(byte[] bArr, Camera camera) {
        Camera.Size previewSize = camera.getParameters().getPreviewSize();
        int i = previewSize.width;
        int i2 = previewSize.height;
        int rotationCount = getRotationCount();
        if (rotationCount == 1 || rotationCount == 3) {
            int i3 = 0;
            while (i3 < rotationCount) {
                byte[] bArr2 = new byte[bArr.length];
                for (int i4 = 0; i4 < i2; i4++) {
                    for (int i5 = 0; i5 < i; i5++) {
                        bArr2[(((i5 * i2) + i2) - i4) - 1] = bArr[(i4 * i) + i5];
                    }
                }
                i3++;
                bArr = bArr2;
                int i6 = i;
                i = i2;
                i2 = i6;
            }
        }
        return bArr;
    }

    public int getRotationCount() {
        return this.f4716b.getDisplayOrientation() / 90;
    }
}
