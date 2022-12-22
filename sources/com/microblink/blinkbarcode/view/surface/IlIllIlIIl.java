package com.microblink.blinkbarcode.view.surface;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import com.microblink.blinkbarcode.secured.llIllIIlll;
import com.microblink.blinkbarcode.secured.lllIIIlIlI;
import com.microblink.blinkbarcode.util.Log;
import com.microblink.blinkbarcode.view.CameraAspectMode;
import com.microblink.blinkbarcode.view.surface.ICameraView;

/* compiled from: line */
public class IlIllIlIIl extends SurfaceView implements ICameraView {
    private lllIIIlIlI IIlIIIllIl;
    private int IlIllIlIIl = 0;
    /* access modifiers changed from: private */
    public int IlIllIlllI = -1;
    /* access modifiers changed from: private */
    public int IllIIIIllI = 1;
    private int IllIIIllII = 0;
    private ScaleGestureDetector IllIIlIIII;
    private Handler lIIIIIlIlI;
    public SurfaceHolder.Callback lIIIIIllll;
    /* access modifiers changed from: private */
    public ICameraView.CameraViewEventListener lIlIIIIlIl;
    private int llIIIlllll = 0;
    /* access modifiers changed from: private */
    public CameraAspectMode llIIlIIlll = CameraAspectMode.ASPECT_FIT;
    private int llIIlIlIIl = 0;
    /* access modifiers changed from: private */
    public int lllIIIlIlI = -1;
    private GestureDetector lllIlIlIIl;

    /* renamed from: com.microblink.blinkbarcode.view.surface.IlIllIlIIl$IlIllIlIIl  reason: collision with other inner class name */
    /* compiled from: line */
    public class C22038IlIllIlIIl extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        public C22038IlIllIlIIl() {
        }

        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (IlIllIlIIl.this.lIlIIIIlIl == null) {
                return false;
            }
            IlIllIlIIl.this.lIlIIIIlIl.onCameraPinchEvent(scaleGestureDetector.getScaleFactor());
            return true;
        }
    }

    /* compiled from: line */
    public class IllIIIllII implements Runnable {
        public IllIIIllII() {
        }

        public void run() {
            IlIllIlIIl.this.requestLayout();
        }
    }

    /* compiled from: line */
    public class llIIlIlIIl extends GestureDetector.SimpleOnGestureListener {
        public llIIlIlIIl() {
        }

        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            float[] fArr = {motionEvent.getX(), motionEvent.getY()};
            Log.m40233v(this, "Camera surface view touch event at location: ({}, {})", Float.valueOf(fArr[0]), Float.valueOf(fArr[1]));
            if (IlIllIlIIl.this.llIIlIIlll == CameraAspectMode.ASPECT_FILL) {
                fArr[0] = fArr[0] - ((float) IlIllIlIIl.this.IlIllIlllI);
                fArr[1] = fArr[1] - ((float) IlIllIlIIl.this.lllIIIlIlI);
            }
            Log.m40233v(this, "Camera surface view touch event at raw sensor location: ({}, {})", Float.valueOf(fArr[0]), Float.valueOf(fArr[1]));
            llIllIIlll.IlIllIlIIl(fArr, (float) View.MeasureSpec.getSize(IlIllIlIIl.this.getMeasuredWidth()), (float) View.MeasureSpec.getSize(IlIllIlIIl.this.getMeasuredHeight()));
            llIllIIlll.IlIllIlIIl(fArr, IlIllIlIIl.this.IllIIIIllI, 1.0f, 1.0f);
            Log.m40233v(this, "Camera surface view touch event at normalized location: ({}, {})", Float.valueOf(fArr[0]), Float.valueOf(fArr[1]));
            if (IlIllIlIIl.this.lIlIIIIlIl == null) {
                return false;
            }
            IlIllIlIIl.this.lIlIIIIlIl.onCameraTapEvent(fArr[0], fArr[1]);
            return true;
        }
    }

    public IlIllIlIIl(Context context) {
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
        llIllIIlll.llIIlIlIIl(fArr, this.IllIIIIllI, 1.0f, 1.0f);
        llIllIIlll.llIIlIlIIl(fArr2, this.IllIIIIllI, 1.0f, 1.0f);
        llIllIIlll.llIIlIlIIl(fArr3, this.IllIIIIllI, 1.0f, 1.0f);
        llIllIIlll.llIIlIlIIl(fArr4, this.IllIIIIllI, 1.0f, 1.0f);
        llIllIIlll.llIIlIlIIl(fArr, (float) View.MeasureSpec.getSize(getMeasuredWidth()), (float) View.MeasureSpec.getSize(getMeasuredHeight()));
        llIllIIlll.llIIlIlIIl(fArr2, (float) View.MeasureSpec.getSize(getMeasuredWidth()), (float) View.MeasureSpec.getSize(getMeasuredHeight()));
        llIllIIlll.llIIlIlIIl(fArr3, (float) View.MeasureSpec.getSize(getMeasuredWidth()), (float) View.MeasureSpec.getSize(getMeasuredHeight()));
        llIllIIlll.llIIlIlIIl(fArr4, (float) View.MeasureSpec.getSize(getMeasuredWidth()), (float) View.MeasureSpec.getSize(getMeasuredHeight()));
        int round = Math.round(Math.min(fArr[0], Math.min(fArr2[0], Math.min(fArr3[0], fArr4[0]))));
        int round2 = Math.round(Math.min(fArr[1], Math.min(fArr2[1], Math.min(fArr3[1], fArr4[1]))));
        int round3 = Math.round(Math.max(fArr[0], Math.max(fArr2[0], Math.max(fArr3[0], fArr4[0]))));
        int round4 = Math.round(Math.max(fArr[1], Math.max(fArr2[1], Math.max(fArr3[1], fArr4[1]))));
        if (this.llIIlIIlll == CameraAspectMode.ASPECT_FILL) {
            int i = this.IlIllIlllI;
            round += i;
            round3 += i;
            int i2 = this.lllIIIlIlI;
            round2 += i2;
            round4 += i2;
        }
        return new Rect(round, round2, round3, round4);
    }

    public void dispose() {
        this.lIlIIIIlIl = null;
        this.IIlIIIllIl = null;
        this.lIIIIIllll = null;
        this.lllIlIlIIl = null;
        this.IllIIlIIII = null;
    }

    public View getView() {
        return this;
    }

    public int getVisibleHeight() {
        return this.llIIIlllll;
    }

    public int getVisibleWidth() {
        return this.IllIIIllII;
    }

    public void installCallback(com.microblink.blinkbarcode.hardware.camera.IllIIIllII illIIIllII) {
        this.lIIIIIllll = illIIIllII.lllIIIlIlI().llIIlIlIIl();
        getHolder().addCallback(this.lIIIIIllll);
        getHolder().setType(3);
        if (illIIIllII instanceof lllIIIlIlI) {
            this.IIlIIIllIl = (lllIIIlIlI) illIIIllII;
        }
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.IlIllIlllI = i;
        this.lllIIIlIlI = i2;
    }

    public void onMeasure(int i, int i2) {
        int i3;
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int i4 = this.llIIlIlIIl;
        if (i4 == 0 || (i3 = this.IlIllIlIIl) == 0) {
            setMeasuredDimension(size, size2);
            this.IllIIIllII = size;
            this.llIIIlllll = size2;
            return;
        }
        if (llIllIIlll.llIIlIlIIl(getContext())) {
            i4 = this.IlIllIlIIl;
            i3 = this.llIIlIlIIl;
            Log.m40227d(this, "Activity is in portrait mode, preview size used for layouting is {}x{}", Integer.valueOf(i4), Integer.valueOf(i3));
        }
        if (this.llIIlIIlll == CameraAspectMode.ASPECT_FIT) {
            Log.m40227d(this, "Measuring size in ASPECT_FIT mode", new Object[0]);
            int i5 = size * i3;
            int i6 = size2 * i4;
            if (i5 > i6) {
                Log.m40227d(this, "width*previewHeight ({}*{}) > height*previewWidth ({}*{})", Integer.valueOf(size), Integer.valueOf(i3), Integer.valueOf(size2), Integer.valueOf(i4));
                this.IllIIIllII = i6 / i3;
                this.llIIIlllll = size2;
            } else {
                Log.m40227d(this, "width*previewHeight ({}*{}) <= height*previewWidth ({}*{})", Integer.valueOf(size), Integer.valueOf(i3), Integer.valueOf(size2), Integer.valueOf(i4));
                this.llIIIlllll = i5 / i4;
                this.IllIIIllII = size;
            }
            setMeasuredDimension(this.IllIIIllII, this.llIIIlllll);
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
        setMeasuredDimension(size, size2);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.lIlIIIIlIl == null) {
            return false;
        }
        if (this.lllIlIlIIl.onTouchEvent(motionEvent) || this.IllIIlIIII.onTouchEvent(motionEvent)) {
            return true;
        }
        return false;
    }

    public void removeCallback() {
    }

    public void setAspectMode(CameraAspectMode cameraAspectMode) {
        this.llIIlIIlll = cameraAspectMode;
    }

    public void setCameraViewEventListener(ICameraView.CameraViewEventListener cameraViewEventListener) {
        this.lIlIIIIlIl = cameraViewEventListener;
    }

    public void setDeviceNaturalOrientationLandscape(boolean z) {
    }

    public void setHostActivityOrientation(int i) {
        this.IllIIIIllI = i;
    }

    public void setPreviewSize(int i, int i2) {
        this.IlIllIlIIl = i2;
        this.llIIlIlIIl = i;
        this.lIIIIIlIlI.post(new IllIIIllII());
    }

    public void setRotation(int i) {
        lllIIIlIlI llliiilili = this.IIlIIIllIl;
        if (llliiilili != null) {
            llliiilili.IlIllIlIIl(i);
        }
    }

    private void llIIlIlIIl(Context context) {
        this.lIIIIIlIlI = new Handler();
        this.lllIlIlIIl = new GestureDetector(context, new llIIlIlIIl());
        this.IllIIlIIII = new ScaleGestureDetector(context, new C22038IlIllIlIIl());
    }
}
