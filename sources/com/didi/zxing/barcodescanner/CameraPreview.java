package com.didi.zxing.barcodescanner;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.appsflyer.internal.referrer.Payload;
import com.didi.bike.utils.SystemUtil;
import com.didi.passenger.C10448R;
import com.didi.sdk.apm.SystemUtils;
import com.didi.util.DecodeConfigUtil;
import com.didi.zxing.barcodescanner.camera.CameraInstance;
import com.didi.zxing.barcodescanner.camera.CameraSettings;
import com.didi.zxing.barcodescanner.camera.CameraSurface;
import com.didi.zxing.barcodescanner.camera.CenterCropStrategy;
import com.didi.zxing.barcodescanner.camera.DisplayConfiguration;
import com.didi.zxing.barcodescanner.camera.FitCenterStrategy;
import com.didi.zxing.barcodescanner.camera.FitXYStrategy;
import com.didi.zxing.barcodescanner.camera.PreviewCallback;
import com.didi.zxing.barcodescanner.camera.PreviewScalingStrategy;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CameraPreview extends ViewGroup {

    /* renamed from: a */
    private static final String f45215a = "CameraPreview";

    /* renamed from: i */
    private static final int f45216i = 250;

    /* renamed from: A */
    private final Handler.Callback f45217A = new Handler.Callback() {
        public boolean handleMessage(Message message) {
            if (message.what == R.id.zxing_prewiew_size_ready) {
                SystemUtils.log(3, CameraPreview.f45215a, "zxing_prewiew_size_ready", (Throwable) null, "com.didi.zxing.barcodescanner.CameraPreview$3", 213);
                CameraPreview.this.m32487b((Size) message.obj);
                return true;
            } else if (message.what == R.id.zxing_camera_error) {
                Exception exc = (Exception) message.obj;
                if (!CameraPreview.this.isActive()) {
                    return false;
                }
                CameraPreview.this.pause();
                CameraPreview.this.f45219C.cameraError(exc);
                return false;
            } else if (message.what != R.id.zxing_camera_closed) {
                return false;
            } else {
                CameraPreview.this.f45219C.cameraClosed();
                return false;
            }
        }
    };

    /* renamed from: B */
    private RotationCallback f45218B = new RotationCallback() {
        public void onRotationChanged(int i) {
            CameraPreview.this.f45222c.postDelayed(new Runnable() {
                public void run() {
                    CameraPreview.this.m32484b();
                }
            }, 250);
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: C */
    public final StateListener f45219C = new StateListener() {
        public void previewSized() {
            for (StateListener previewSized : CameraPreview.this.f45228j) {
                previewSized.previewSized();
            }
        }

        public void previewStarted() {
            for (StateListener previewStarted : CameraPreview.this.f45228j) {
                previewStarted.previewStarted();
            }
        }

        public void previewStopped() {
            for (StateListener previewStopped : CameraPreview.this.f45228j) {
                previewStopped.previewStopped();
            }
        }

        public void cameraError(Exception exc) {
            for (StateListener cameraError : CameraPreview.this.f45228j) {
                cameraError.cameraError(exc);
            }
        }

        public void cameraClosed() {
            for (StateListener cameraClosed : CameraPreview.this.f45228j) {
                cameraClosed.cameraClosed();
            }
        }
    };

    /* renamed from: D */
    private PreviewCallback f45220D = new PreviewCallback() {
        long count;

        public void onPreviewError(Exception exc) {
        }

        public boolean oneShot() {
            return false;
        }

        public void onPreview(SourceData sourceData) {
            if (CameraPreview.this.f45243y != null && this.count % ((long) CameraPreview.this.f45243y.frequency()) == 0) {
                CameraPreview.this.f45243y.onLumChange(sourceData.getAverageLum(64));
            }
            this.count++;
        }
    };

    /* renamed from: b */
    private WindowManager f45221b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Handler f45222c;
    protected CameraInstance cameraInstance;

    /* renamed from: d */
    private boolean f45223d = false;

    /* renamed from: e */
    private SurfaceView f45224e;

    /* renamed from: f */
    private TextureView f45225f;

    /* renamed from: g */
    private RotationListener f45226g;

    /* renamed from: h */
    private int f45227h = -1;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public List<StateListener> f45228j = new ArrayList();

    /* renamed from: k */
    private DisplayConfiguration f45229k;

    /* renamed from: l */
    private CameraSettings f45230l = new CameraSettings();

    /* renamed from: m */
    private Size f45231m;

    /* renamed from: n */
    private Size f45232n;

    /* renamed from: o */
    private Rect f45233o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public Size f45234p;
    protected boolean previewActive = false;

    /* renamed from: q */
    private Rect f45235q = null;

    /* renamed from: r */
    private Rect f45236r = null;

    /* renamed from: s */
    private Size f45237s = null;

    /* renamed from: t */
    private double f45238t = 0.06d;

    /* renamed from: u */
    private PreviewScalingStrategy f45239u = null;

    /* renamed from: v */
    private boolean f45240v = false;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public int f45241w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public int f45242x;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public LumListener f45243y;

    /* renamed from: z */
    private final SurfaceHolder.Callback f45244z = new SurfaceHolder.Callback() {
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
        }

        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            Size unused = CameraPreview.this.f45234p = null;
        }

        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            if (surfaceHolder == null) {
                SystemUtils.log(6, CameraPreview.f45215a, "*** WARNING *** surfaceChanged() gave us a null surface!", (Throwable) null, "com.didi.zxing.barcodescanner.CameraPreview$2", 200);
                return;
            }
            Size unused = CameraPreview.this.f45234p = new Size(i2, i3);
            CameraPreview.this.m32494e();
        }
    };

    public interface StateListener {
        void cameraClosed();

        void cameraError(Exception exc);

        void previewSized();

        void previewStarted();

        void previewStopped();
    }

    /* access modifiers changed from: protected */
    public void previewStarted() {
    }

    /* renamed from: a */
    private TextureView.SurfaceTextureListener m32476a() {
        return new TextureView.SurfaceTextureListener() {
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                return false;
            }

            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                onSurfaceTextureSizeChanged(surfaceTexture, i, i2);
            }

            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
                Size unused = CameraPreview.this.f45234p = new Size(i, i2);
                CameraPreview cameraPreview = CameraPreview.this;
                cameraPreview.m32482a(cameraPreview.f45234p);
                CameraPreview.this.m32494e();
            }
        };
    }

    public CameraPreview(Context context) {
        super(context);
        m32479a(context, (AttributeSet) null, 0, 0);
    }

    public CameraPreview(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m32479a(context, attributeSet, 0, 0);
    }

    public CameraPreview(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m32479a(context, attributeSet, i, 0);
    }

    /* renamed from: a */
    private void m32479a(Context context, AttributeSet attributeSet, int i, int i2) {
        if (getBackground() == null) {
            setBackgroundColor(0);
        }
        initializeAttributes(attributeSet);
        this.f45221b = (WindowManager) context.getSystemService("window");
        this.f45222c = new Handler(this.f45217A);
        this.f45226g = new RotationListener();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        m32489c();
    }

    /* access modifiers changed from: protected */
    public void initializeAttributes(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C10448R.styleable.zxing_camera_preview);
        int dimension = (int) obtainStyledAttributes.getDimension(1, -1.0f);
        int dimension2 = (int) obtainStyledAttributes.getDimension(0, -1.0f);
        if (dimension > 0 && dimension2 > 0) {
            this.f45237s = new Size(dimension, dimension2);
        }
        DecodeConfig config = DecodeConfigUtil.getConfig();
        boolean useSurfaceView = config != null ? config.useSurfaceView() : false;
        String brand = SystemUtil.getBrand();
        if ((brand.toLowerCase().contains(Payload.SOURCE_HUAWEI) || brand.toLowerCase().contains("honor")) && useSurfaceView) {
            this.f45223d = false;
        } else {
            this.f45223d = obtainStyledAttributes.getBoolean(5, !useSurfaceView);
        }
        int integer = obtainStyledAttributes.getInteger(4, -1);
        if (integer == 1) {
            this.f45239u = new CenterCropStrategy();
        } else if (integer == 2) {
            this.f45239u = new FitCenterStrategy();
        } else if (integer == 3) {
            this.f45239u = new FitXYStrategy();
        }
        this.f45241w = (int) obtainStyledAttributes.getDimension(2, 0.0f);
        this.f45242x = obtainStyledAttributes.getColor(3, 0);
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m32484b() {
        if (isActive() && getDisplayRotation() != this.f45227h) {
            pause();
            resume();
        }
    }

    /* renamed from: c */
    private void m32489c() {
        if (!this.f45223d || Build.VERSION.SDK_INT < 14) {
            if (this.f45241w > 0) {
                this.f45224e = new RoundSurfaceView(getContext());
            } else {
                this.f45224e = new SurfaceView(getContext());
            }
            this.f45224e.setZOrderMediaOverlay(true);
            if (Build.VERSION.SDK_INT < 11) {
                this.f45224e.getHolder().setType(3);
            }
            this.f45224e.getHolder().addCallback(this.f45244z);
            addView(this.f45224e);
            return;
        }
        if (this.f45241w > 0) {
            this.f45225f = new RoundTextureView(getContext());
        } else {
            this.f45225f = new TextureView(getContext());
        }
        this.f45225f.setSurfaceTextureListener(m32476a());
        addView(this.f45225f);
    }

    public class RoundTextureView extends TextureView {
        private Path roundPath;

        public RoundTextureView(Context context) {
            super(context);
        }

        /* access modifiers changed from: protected */
        public void dispatchDraw(Canvas canvas) {
            if (Build.VERSION.SDK_INT >= 21) {
                canvas.drawColor(CameraPreview.this.f45242x);
                if (this.roundPath == null) {
                    this.roundPath = new Path();
                    RectF rectF = new RectF(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
                    this.roundPath.addRoundRect(rectF, new float[]{(float) CameraPreview.this.f45241w, (float) CameraPreview.this.f45241w, (float) CameraPreview.this.f45241w, (float) CameraPreview.this.f45241w, 0.0f, 0.0f, 0.0f, 0.0f}, Path.Direction.CW);
                }
                CameraPreview.this.m32480a(canvas, this.roundPath, Region.Op.REPLACE);
            }
            super.dispatchDraw(canvas);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m32480a(Canvas canvas, Path path, Region.Op op) {
        if (Build.VERSION.SDK_INT >= 26) {
            canvas.clipPath(path);
        } else {
            canvas.clipPath(path, op);
        }
    }

    public class RoundSurfaceView extends SurfaceView {
        private Path roundPath;

        public RoundSurfaceView(Context context) {
            super(context);
        }

        /* access modifiers changed from: protected */
        public void dispatchDraw(Canvas canvas) {
            if (Build.VERSION.SDK_INT >= 21) {
                canvas.drawColor(CameraPreview.this.f45242x);
                if (this.roundPath == null) {
                    this.roundPath = new Path();
                    RectF rectF = new RectF(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
                    this.roundPath.addRoundRect(rectF, new float[]{(float) CameraPreview.this.f45241w, (float) CameraPreview.this.f45241w, (float) CameraPreview.this.f45241w, (float) CameraPreview.this.f45241w, 0.0f, 0.0f, 0.0f, 0.0f}, Path.Direction.CW);
                }
                CameraPreview.this.m32480a(canvas, this.roundPath, Region.Op.REPLACE);
            }
            super.dispatchDraw(canvas);
        }
    }

    public void addStateListener(StateListener stateListener) {
        this.f45228j.add(stateListener);
    }

    /* renamed from: d */
    private void m32491d() {
        Size size;
        SystemUtils.log(3, f45215a, "calculateFrames", (Throwable) null, "com.didi.zxing.barcodescanner.CameraPreview", 470);
        if (this.f45231m == null || (size = this.f45232n) == null || this.f45229k == null) {
            this.f45236r = null;
            this.f45235q = null;
            this.f45233o = null;
            SystemUtils.log(3, f45215a, "calculateFrames null", (Throwable) null, "com.didi.zxing.barcodescanner.CameraPreview", 476);
            return;
        }
        int i = size.width;
        int i2 = this.f45232n.height;
        int i3 = this.f45231m.width;
        int i4 = this.f45231m.height;
        this.f45233o = this.f45229k.scalePreview(this.f45232n);
        SystemUtils.log(3, f45215a, "previewSize =" + this.f45232n.toString() + "  surfaceRect = " + this.f45233o.toString() + " containerSize = " + this.f45231m, (Throwable) null, "com.didi.zxing.barcodescanner.CameraPreview", 488);
        if (this.f45233o.height() == 0) {
            Message obtain = Message.obtain(this.f45222c, R.id.zxing_prewiew_size_ready);
            obtain.obj = this.f45232n;
            this.f45222c.sendMessageDelayed(obtain, 100);
            return;
        }
        new Rect(0, 0, i3, i4);
        this.f45235q = new Rect(this.f45233o);
        Rect rect = new Rect(this.f45235q);
        rect.offset(-this.f45233o.left, -this.f45233o.top);
        this.f45236r = new Rect((rect.left * i) / this.f45233o.width(), (rect.top * i2) / this.f45233o.height(), (rect.right * i) / this.f45233o.width(), (rect.bottom * i2) / this.f45233o.height());
        SystemUtils.log(3, f45215a, "calculateFrames previewFramingRect = " + this.f45236r.toString(), (Throwable) null, "com.didi.zxing.barcodescanner.CameraPreview", 505);
        if (this.f45236r.width() <= 0 || this.f45236r.height() <= 0) {
            this.f45236r = null;
            this.f45235q = null;
            SystemUtils.log(5, f45215a, "Preview frame is too small", (Throwable) null, "com.didi.zxing.barcodescanner.CameraPreview", 509);
            return;
        }
        this.f45219C.previewSized();
    }

    public void setTorch(boolean z) {
        this.f45240v = z;
        CameraInstance cameraInstance2 = this.cameraInstance;
        if (cameraInstance2 != null) {
            cameraInstance2.setTorch(z);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m32482a(Size size) {
        this.f45231m = size;
        DisplayConfiguration displayConfiguration = this.f45229k;
        if (displayConfiguration != null) {
            displayConfiguration.setViewfinderSize(size);
        }
        CameraInstance cameraInstance2 = this.cameraInstance;
        if (cameraInstance2 != null && cameraInstance2.getDisplayConfiguration() == null) {
            DisplayConfiguration displayConfiguration2 = new DisplayConfiguration(getDisplayRotation(), size);
            this.f45229k = displayConfiguration2;
            displayConfiguration2.setPreviewScalingStrategy(getPreviewScalingStrategy());
            this.cameraInstance.setDisplayConfiguration(this.f45229k);
            this.cameraInstance.configureCamera();
            boolean z = this.f45240v;
            if (z) {
                this.cameraInstance.setTorch(z);
            }
        }
    }

    public void setPreviewScalingStrategy(PreviewScalingStrategy previewScalingStrategy) {
        this.f45239u = previewScalingStrategy;
    }

    public PreviewScalingStrategy getPreviewScalingStrategy() {
        PreviewScalingStrategy previewScalingStrategy = this.f45239u;
        if (previewScalingStrategy != null) {
            return previewScalingStrategy;
        }
        if (this.f45225f != null) {
            return new CenterCropStrategy();
        }
        return new FitCenterStrategy();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m32487b(Size size) {
        this.f45232n = size;
        SystemUtils.log(3, f45215a, "previewSized", (Throwable) null, "com.didi.zxing.barcodescanner.CameraPreview", 575);
        if (this.f45231m != null) {
            m32491d();
            requestLayout();
            m32494e();
        }
    }

    /* access modifiers changed from: protected */
    public Matrix calculateTextureTransform(Size size, Size size2) {
        float f;
        float f2 = ((float) size.width) / ((float) size.height);
        float f3 = ((float) size2.width) / ((float) size2.height);
        float f4 = 1.0f;
        if (f2 < f3) {
            f4 = f3 / f2;
            f = 1.0f;
        } else {
            f = f2 / f3;
        }
        Matrix matrix = new Matrix();
        matrix.setScale(f4, f);
        matrix.postTranslate((((float) size.width) - (((float) size.width) * f4)) / 2.0f, (((float) size.height) - (((float) size.height) * f)) / 2.0f);
        return matrix;
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m32494e() {
        Rect rect;
        Size size = this.f45234p;
        if (size != null && this.f45232n != null && (rect = this.f45233o) != null) {
            if (this.f45224e != null && size.equals(new Size(rect.width(), this.f45233o.height()))) {
                m32483a(new CameraSurface(this.f45224e.getHolder()));
            } else if (this.f45225f != null && Build.VERSION.SDK_INT >= 14 && this.f45225f.getSurfaceTexture() != null) {
                if (this.f45232n != null) {
                    this.f45225f.setTransform(calculateTextureTransform(new Size(this.f45225f.getWidth(), this.f45225f.getHeight()), this.f45232n));
                }
                m32483a(new CameraSurface(this.f45225f.getSurfaceTexture()));
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        m32482a(new Size(i3 - i, i4 - i2));
        SurfaceView surfaceView = this.f45224e;
        if (surfaceView != null) {
            Rect rect = this.f45233o;
            if (rect == null) {
                surfaceView.layout(0, 0, getWidth(), getHeight());
            } else {
                surfaceView.layout(rect.left, this.f45233o.top, this.f45233o.right, this.f45233o.bottom);
            }
        } else if (this.f45225f != null && Build.VERSION.SDK_INT >= 14) {
            this.f45225f.layout(0, 0, getWidth(), getHeight());
        }
    }

    public Rect getFramingRect() {
        return this.f45235q;
    }

    public Rect getPreviewFramingRect() {
        return this.f45236r;
    }

    public CameraSettings getCameraSettings() {
        return this.f45230l;
    }

    public void setCameraSettings(CameraSettings cameraSettings) {
        this.f45230l = cameraSettings;
    }

    public void resume() {
        C14921Util.validateMainThread();
        SystemUtils.log(3, f45215a, "resume()", (Throwable) null, "com.didi.zxing.barcodescanner.CameraPreview", 712);
        m32496f();
        if (this.f45234p != null) {
            m32494e();
        } else {
            SurfaceView surfaceView = this.f45224e;
            if (surfaceView != null) {
                surfaceView.getHolder().addCallback(this.f45244z);
            } else if (this.f45225f != null && Build.VERSION.SDK_INT >= 14) {
                if (this.f45225f.isAvailable()) {
                    m32476a().onSurfaceTextureAvailable(this.f45225f.getSurfaceTexture(), this.f45225f.getWidth(), this.f45225f.getHeight());
                } else {
                    this.f45225f.setSurfaceTextureListener(m32476a());
                }
            }
        }
        requestLayout();
        this.f45226g.listen(getContext(), this.f45218B);
    }

    public void pause() {
        SurfaceView surfaceView;
        C14921Util.validateMainThread();
        SystemUtils.log(3, f45215a, "pause()", (Throwable) null, "com.didi.zxing.barcodescanner.CameraPreview", 746);
        this.f45227h = -1;
        CameraInstance cameraInstance2 = this.cameraInstance;
        if (cameraInstance2 != null) {
            cameraInstance2.close();
            this.cameraInstance = null;
            this.previewActive = false;
        } else {
            this.f45222c.sendEmptyMessage(R.id.zxing_camera_closed);
        }
        if (this.f45234p == null && (surfaceView = this.f45224e) != null) {
            surfaceView.getHolder().removeCallback(this.f45244z);
        }
        if (this.f45234p == null && this.f45225f != null && Build.VERSION.SDK_INT >= 14) {
            this.f45225f.setSurfaceTextureListener((TextureView.SurfaceTextureListener) null);
        }
        this.f45231m = null;
        this.f45232n = null;
        this.f45236r = null;
        this.f45226g.stop();
        this.f45219C.previewStopped();
    }

    public void pauseAndWait() {
        CameraInstance cameraInstance2 = getCameraInstance();
        pause();
        long nanoTime = System.nanoTime();
        while (cameraInstance2 != null && !cameraInstance2.isCameraClosed() && System.nanoTime() - nanoTime <= 2000000000) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException unused) {
                return;
            }
        }
    }

    public Size getFramingRectSize() {
        return this.f45237s;
    }

    public void setFramingRectSize(Size size) {
        this.f45237s = size;
    }

    public double getMarginFraction() {
        return this.f45238t;
    }

    public void setMarginFraction(double d) {
        if (d < 0.5d) {
            this.f45238t = d;
            return;
        }
        throw new IllegalArgumentException("The margin fraction must be less than 0.5");
    }

    public boolean isUseTextureView() {
        return this.f45223d;
    }

    public void setUseTextureView(boolean z) {
        this.f45223d = z;
    }

    /* access modifiers changed from: protected */
    public boolean isActive() {
        return this.cameraInstance != null;
    }

    private int getDisplayRotation() {
        return this.f45221b.getDefaultDisplay().getRotation();
    }

    /* renamed from: f */
    private void m32496f() {
        int i;
        if (this.cameraInstance != null) {
            SystemUtils.log(5, f45215a, "initCamera called twice", (Throwable) null, "com.didi.zxing.barcodescanner.CameraPreview", 854);
            return;
        }
        this.cameraInstance = createCameraInstance();
        DecodeConfig config = DecodeConfigUtil.getConfig();
        if (config != null && config.useContinousFocusMode() && (i = Calendar.getInstance().get(11)) >= config.useContinousFocusModeStartTime() && i < config.useContinousFocusModeEndTime()) {
            this.cameraInstance.getCameraSettings().setFocusMode(CameraSettings.FocusMode.CONTINUOUS);
        }
        this.cameraInstance.setReadyHandler(this.f45222c);
        this.cameraInstance.open();
        this.f45227h = getDisplayRotation();
        this.cameraInstance.getCameraManager().addPreviewCallback(this.f45220D);
    }

    /* access modifiers changed from: protected */
    public CameraInstance createCameraInstance() {
        CameraInstance cameraInstance2 = new CameraInstance(getContext());
        cameraInstance2.setCameraSettings(this.f45230l);
        return cameraInstance2;
    }

    /* renamed from: a */
    private void m32483a(CameraSurface cameraSurface) {
        if (!this.previewActive && this.cameraInstance != null) {
            SystemUtils.log(4, f45215a, "Starting preview", (Throwable) null, "com.didi.zxing.barcodescanner.CameraPreview", 892);
            this.cameraInstance.setSurface(cameraSurface);
            this.cameraInstance.startPreview();
            this.previewActive = true;
            previewStarted();
            this.f45219C.previewStarted();
        }
    }

    public CameraInstance getCameraInstance() {
        return this.cameraInstance;
    }

    public boolean isPreviewActive() {
        return this.previewActive;
    }

    /* access modifiers changed from: protected */
    public Rect calculateFramingRect(Rect rect, Rect rect2) {
        Rect rect3 = new Rect(rect);
        rect3.intersect(rect2);
        if (this.f45237s != null) {
            rect3.inset(Math.max(0, (rect3.width() - this.f45237s.width) / 2), Math.max(0, (rect3.height() - this.f45237s.height) / 2));
            return rect3;
        }
        int min = (int) Math.min(((double) rect3.width()) * this.f45238t, ((double) rect3.height()) * this.f45238t);
        rect3.inset(min, min);
        if (rect3.height() > rect3.width()) {
            rect3.inset(0, (rect3.height() - rect3.width()) / 2);
        }
        return rect3;
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        Bundle bundle = new Bundle();
        bundle.putParcelable("super", onSaveInstanceState);
        bundle.putBoolean("torch", this.f45240v);
        return bundle;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof Bundle)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Bundle bundle = (Bundle) parcelable;
        super.onRestoreInstanceState(bundle.getParcelable("super"));
        setTorch(bundle.getBoolean("torch"));
    }

    public boolean isCameraClosed() {
        CameraInstance cameraInstance2 = this.cameraInstance;
        return cameraInstance2 == null || cameraInstance2.isCameraClosed();
    }

    public boolean isTorchOn() {
        return this.f45240v;
    }

    public void setLumListener(LumListener lumListener) {
        this.f45243y = lumListener;
    }
}
