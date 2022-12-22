package com.microblink.blinkbarcode.view.surface;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.TextureView;
import android.view.View;
import com.microblink.blinkbarcode.secured.IIlIlIIlll;
import com.microblink.blinkbarcode.secured.llIllIIlll;
import com.microblink.blinkbarcode.util.Log;
import com.microblink.blinkbarcode.view.CameraAspectMode;
import com.microblink.blinkbarcode.view.surface.ICameraView;

/* compiled from: line */
public class IllIIIllII extends TextureView implements ICameraView {
    /* access modifiers changed from: private */
    public ICameraView.CameraViewEventListener IIlIIIllIl;
    private int IlIllIlIIl = 0;
    private boolean IlIllIlllI = false;
    private ScaleGestureDetector IlIlllllII;
    private int IllIIIIllI = 0;
    private int IllIIIllII = 0;
    private Handler IllIIlIIII;
    private GestureDetector lIIIIIlIlI;
    private int lIIIIIllll = -1;
    private int lIlIIIIlIl = 0;
    private CameraAspectMode llIIIlllll = CameraAspectMode.ASPECT_FIT;
    /* access modifiers changed from: private */
    public int llIIlIIlll = 1;
    private int llIIlIlIIl = 0;
    private int lllIIIlIlI = -1;
    private boolean lllIlIlIIl = false;

    /* compiled from: line */
    public class IlIllIlIIl extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        public IlIllIlIIl() {
        }

        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (IllIIIllII.this.IIlIIIllIl == null) {
                return false;
            }
            IllIIIllII.this.IIlIIIllIl.onCameraPinchEvent(scaleGestureDetector.getScaleFactor());
            return true;
        }
    }

    /* renamed from: com.microblink.blinkbarcode.view.surface.IllIIIllII$IllIIIllII  reason: collision with other inner class name */
    /* compiled from: line */
    public class C22039IllIIIllII implements Runnable {
        public C22039IllIIIllII() {
        }

        public void run() {
            IllIIIllII.this.requestLayout();
        }
    }

    /* compiled from: line */
    public class llIIIlllll implements Runnable {
        public llIIIlllll() {
        }

        public void run() {
            IllIIIllII.this.llIIlIlIIl();
        }
    }

    /* compiled from: line */
    public class llIIlIlIIl extends GestureDetector.SimpleOnGestureListener {
        public llIIlIlIIl() {
        }

        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            float[] fArr = {motionEvent.getX(), motionEvent.getY()};
            Log.m40227d(this, "Camera surface view touch event at location: ({}, {})", Float.valueOf(fArr[0]), Float.valueOf(fArr[1]));
            llIllIIlll.IlIllIlIIl(fArr, (float) View.MeasureSpec.getSize(IllIIIllII.this.getMeasuredWidth()), (float) View.MeasureSpec.getSize(IllIIIllII.this.getMeasuredHeight()));
            llIllIIlll.IlIllIlIIl(fArr, IllIIIllII.this.llIIlIIlll, 1.0f, 1.0f);
            Log.m40227d(this, "Camera surface view touch event at normalized location: ({}, {})", Float.valueOf(fArr[0]), Float.valueOf(fArr[1]));
            if (IllIIIllII.this.IIlIIIllIl == null) {
                return false;
            }
            IllIIIllII.this.IIlIIIllIl.onCameraTapEvent(fArr[0], fArr[1]);
            return true;
        }
    }

    public IllIIIllII(Context context) {
        super(context);
        llIIlIlIIl(context);
    }

    public Rect convertRectangleToActualRect(RectF rectF) {
        float f = rectF.left;
        float f2 = rectF.top;
        float[] fArr = {f, f2};
        float f3 = rectF.right;
        float[] fArr2 = {f3, f2};
        float f4 = rectF.bottom;
        float[] fArr3 = {f, f4};
        float[] fArr4 = {f3, f4};
        llIllIIlll.llIIlIlIIl(fArr, this.llIIlIIlll, 1.0f, 1.0f);
        llIllIIlll.llIIlIlIIl(fArr2, this.llIIlIIlll, 1.0f, 1.0f);
        llIllIIlll.llIIlIlIIl(fArr3, this.llIIlIIlll, 1.0f, 1.0f);
        llIllIIlll.llIIlIlIIl(fArr4, this.llIIlIIlll, 1.0f, 1.0f);
        llIllIIlll.llIIlIlIIl(fArr, (float) View.MeasureSpec.getSize(getMeasuredWidth()), (float) View.MeasureSpec.getSize(getMeasuredHeight()));
        llIllIIlll.llIIlIlIIl(fArr2, (float) View.MeasureSpec.getSize(getMeasuredWidth()), (float) View.MeasureSpec.getSize(getMeasuredHeight()));
        llIllIIlll.llIIlIlIIl(fArr3, (float) View.MeasureSpec.getSize(getMeasuredWidth()), (float) View.MeasureSpec.getSize(getMeasuredHeight()));
        llIllIIlll.llIIlIlIIl(fArr4, (float) View.MeasureSpec.getSize(getMeasuredWidth()), (float) View.MeasureSpec.getSize(getMeasuredHeight()));
        int round = Math.round(Math.min(fArr[0], Math.min(fArr2[0], Math.min(fArr3[0], fArr4[0]))));
        int round2 = Math.round(Math.min(fArr[1], Math.min(fArr2[1], Math.min(fArr3[1], fArr4[1]))));
        int round3 = Math.round(Math.max(fArr[0], Math.max(fArr2[0], Math.max(fArr3[0], fArr4[0]))));
        int round4 = Math.round(Math.max(fArr[1], Math.max(fArr2[1], Math.max(fArr3[1], fArr4[1]))));
        if (this.llIIIlllll == CameraAspectMode.ASPECT_FILL) {
            int i = this.lllIIIlIlI;
            round += i;
            round3 += i;
            int i2 = this.lIIIIIllll;
            round2 += i2;
            round4 += i2;
        }
        return new Rect(round, round2, round3, round4);
    }

    public void dispose() {
        this.IIlIIIllIl = null;
    }

    public View getView() {
        return this;
    }

    public int getVisibleHeight() {
        return this.lIlIIIIlIl;
    }

    public int getVisibleWidth() {
        return this.IllIIIIllI;
    }

    public void installCallback(com.microblink.blinkbarcode.hardware.camera.IllIIIllII illIIIllII) {
        setSurfaceTextureListener(illIIIllII.lllIIIlIlI().IlIllIlIIl());
        this.IlIllIlllI = illIIIllII instanceof IIlIlIIlll;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isHardwareAccelerated()) {
            throw new RuntimeException("Camera texture view works only on hardware accelerated windows!");
        }
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.lllIIIlIlI = i;
        this.lIIIIIllll = i2;
        llIIlIlIIl();
    }

    public void onMeasure(int i, int i2) {
        int i3;
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int i4 = this.IlIllIlIIl;
        if (i4 == 0 || (i3 = this.IllIIIllII) == 0) {
            setMeasuredDimension(size, size2);
            this.IllIIIIllI = size;
            this.lIlIIIIlIl = size2;
            return;
        }
        if (llIllIIlll.llIIlIlIIl(getContext())) {
            i4 = this.IllIIIllII;
            i3 = this.IlIllIlIIl;
            Log.m40227d(this, "Activity is in portrait mode, preview size used for layouting is {}x{}", Integer.valueOf(i4), Integer.valueOf(i3));
        }
        if (this.llIIIlllll == CameraAspectMode.ASPECT_FIT) {
            Log.m40227d(this, "Measuring size in ASPECT_FIT mode", new Object[0]);
            int i5 = size * i3;
            int i6 = size2 * i4;
            if (i5 > i6) {
                Log.m40227d(this, "width*previewHeight ({}*{}) > height*previewWidth ({}*{})", Integer.valueOf(size), Integer.valueOf(i3), Integer.valueOf(size2), Integer.valueOf(i4));
                this.IllIIIIllI = i6 / i3;
                this.lIlIIIIlIl = size2;
            } else {
                Log.m40227d(this, "width*previewHeight ({}*{}) <= height*previewWidth ({}*{})", Integer.valueOf(size), Integer.valueOf(i3), Integer.valueOf(size2), Integer.valueOf(i4));
                this.lIlIIIIlIl = i5 / i4;
                this.IllIIIIllI = size;
            }
            Log.m40227d(this, "Measured dimension: {}x{}", Integer.valueOf(this.IllIIIIllI), Integer.valueOf(this.lIlIIIIlIl));
            setMeasuredDimension(this.IllIIIIllI, this.lIlIIIIlIl);
            return;
        }
        Log.m40227d(this, "Measuring size in ASPECT_FILL mode", new Object[0]);
        int i7 = size * i3;
        int i8 = size2 * i4;
        if (i7 < i8) {
            Log.m40227d(this, "width*previewHeight ({}*{}) > height*previewWidth ({}*{})", Integer.valueOf(size), Integer.valueOf(i3), Integer.valueOf(size2), Integer.valueOf(i4));
            size = i8 / i3;
        } else {
            Log.m40227d(this, "width*previewHeight ({}*{}) <= height*previewWidth ({}*{})", Integer.valueOf(size), Integer.valueOf(i3), Integer.valueOf(size2), Integer.valueOf(i4));
            size2 = i7 / i4;
        }
        Log.m40227d(this, "Measured dimension: {}x{}", Integer.valueOf(size), Integer.valueOf(size2));
        setMeasuredDimension(size, size2);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.IIlIIIllIl == null) {
            return false;
        }
        if (this.lIIIIIlIlI.onTouchEvent(motionEvent) || this.IlIlllllII.onTouchEvent(motionEvent)) {
            return true;
        }
        return false;
    }

    public void removeCallback() {
    }

    public void setAspectMode(CameraAspectMode cameraAspectMode) {
        this.llIIIlllll = cameraAspectMode;
    }

    public void setCameraViewEventListener(ICameraView.CameraViewEventListener cameraViewEventListener) {
        this.IIlIIIllIl = cameraViewEventListener;
    }

    public void setDeviceNaturalOrientationLandscape(boolean z) {
        this.lllIlIlIIl = z;
    }

    public void setHostActivityOrientation(int i) {
        this.llIIlIIlll = i;
    }

    public void setPreviewSize(int i, int i2) {
        this.IllIIIllII = i2;
        this.IlIllIlIIl = i;
        this.IllIIlIIII.post(new C22039IllIIIllII());
    }

    public void setRotation(int i) {
        this.llIIlIlIIl = i;
        if (this.IllIIIllII > 0 && this.IlIllIlIIl > 0) {
            this.IllIIlIIII.post(new llIIIlllll());
        }
    }

    private void llIIlIlIIl(Context context) {
        this.IllIIlIIII = new Handler();
        this.lIIIIIlIlI = new GestureDetector(context, new llIIlIlIIl());
        this.IlIlllllII = new ScaleGestureDetector(context, new IlIllIlIIl());
    }

    /* access modifiers changed from: private */
    public void llIIlIlIIl() {
        int size = View.MeasureSpec.getSize(getMeasuredWidth());
        int size2 = View.MeasureSpec.getSize(getMeasuredHeight());
        if (this.IlIllIlIIl > 0 && this.IllIIIllII > 0) {
            Matrix matrix = new Matrix();
            float f = (float) size;
            float f2 = (float) size2;
            RectF rectF = new RectF(0.0f, 0.0f, f, f2);
            float centerX = rectF.centerX();
            float centerY = rectF.centerY();
            if (!this.IlIllIlllI || this.lllIlIlIIl) {
                if (llIllIIlll.llIIlIlIIl(getContext())) {
                    matrix.postScale(f2 / f, f / f2, centerX, centerY);
                }
                matrix.postRotate((float) this.llIIlIlIIl, centerX, centerY);
            } else {
                if (!llIllIIlll.llIIlIlIIl(getContext())) {
                    matrix.postScale(f2 / f, f / f2, centerX, centerY);
                }
                matrix.postRotate((float) (this.llIIlIlIIl - 90), centerX, centerY);
            }
            setTransform(matrix);
        }
    }
}
