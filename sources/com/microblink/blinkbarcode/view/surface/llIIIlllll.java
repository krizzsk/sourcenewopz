package com.microblink.blinkbarcode.view.surface;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.view.View;
import com.microblink.blinkbarcode.hardware.camera.IllIIIllII;
import com.microblink.blinkbarcode.secured.llIllIIlll;
import com.microblink.blinkbarcode.view.CameraAspectMode;
import com.microblink.blinkbarcode.view.surface.ICameraView;

/* compiled from: line */
public class llIIIlllll extends View implements ICameraView {
    private int IIlIIIllIl = 0;
    private Paint IlIllIlIIl;
    private int IllIIIIllI = 1920;
    private Paint IllIIIllII;
    private int lIIIIIllll = 0;
    private int lIlIIIIlIl = 1080;
    private Paint llIIIlllll;
    private int llIIlIIlll;
    private int llIIlIlIIl = 1;
    private CameraAspectMode lllIIIlIlI;

    public llIIIlllll(Context context, CameraAspectMode cameraAspectMode) {
        super(context);
        llIIlIlIIl(context, cameraAspectMode);
    }

    private void llIIlIlIIl(Context context, CameraAspectMode cameraAspectMode) {
        this.llIIlIIlll = context.getResources().getConfiguration().orientation;
        this.lllIIIlIlI = cameraAspectMode;
        Paint paint = new Paint(1);
        this.IlIllIlIIl = paint;
        paint.setStrokeCap(Paint.Cap.ROUND);
        this.IlIllIlIIl.setTextAlign(Paint.Align.LEFT);
        this.IlIllIlIIl.setTypeface(Typeface.DEFAULT_BOLD);
        this.IlIllIlIIl.setColor(-65536);
        setBackgroundColor(Color.argb(255, 128, 59, 100));
        Paint paint2 = new Paint(this.IlIllIlIIl);
        this.IllIIIllII = paint2;
        paint2.setColor(-1);
        Paint paint3 = new Paint(this.IlIllIlIIl);
        this.llIIIlllll = paint3;
        paint3.setTextSize(125.0f);
        this.llIIIlllll.setColor(-16776961);
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
        llIllIIlll.llIIlIlIIl(fArr, this.llIIlIlIIl, 1.0f, 1.0f);
        llIllIIlll.llIIlIlIIl(fArr2, this.llIIlIlIIl, 1.0f, 1.0f);
        llIllIIlll.llIIlIlIIl(fArr3, this.llIIlIlIIl, 1.0f, 1.0f);
        llIllIIlll.llIIlIlIIl(fArr4, this.llIIlIlIIl, 1.0f, 1.0f);
        llIllIIlll.llIIlIlIIl(fArr, (float) View.MeasureSpec.getSize(getMeasuredWidth()), (float) View.MeasureSpec.getSize(getMeasuredHeight()));
        llIllIIlll.llIIlIlIIl(fArr2, (float) View.MeasureSpec.getSize(getMeasuredWidth()), (float) View.MeasureSpec.getSize(getMeasuredHeight()));
        llIllIIlll.llIIlIlIIl(fArr3, (float) View.MeasureSpec.getSize(getMeasuredWidth()), (float) View.MeasureSpec.getSize(getMeasuredHeight()));
        llIllIIlll.llIIlIlIIl(fArr4, (float) View.MeasureSpec.getSize(getMeasuredWidth()), (float) View.MeasureSpec.getSize(getMeasuredHeight()));
        return new Rect(Math.round(Math.min(fArr[0], Math.min(fArr2[0], Math.min(fArr3[0], fArr4[0])))), Math.round(Math.min(fArr[1], Math.min(fArr2[1], Math.min(fArr3[1], fArr4[1])))), Math.round(Math.max(fArr[0], Math.max(fArr2[0], Math.max(fArr3[0], fArr4[0])))), Math.round(Math.max(fArr[1], Math.max(fArr2[1], Math.max(fArr3[1], fArr4[1])))));
    }

    public void dispose() {
        this.IlIllIlIIl = null;
        this.IllIIIllII = null;
        this.llIIIlllll = null;
    }

    public View getView() {
        return this;
    }

    public int getVisibleHeight() {
        return this.lIIIIIllll;
    }

    public int getVisibleWidth() {
        return this.IIlIIIllIl;
    }

    public void installCallback(IllIIIllII illIIIllII) {
    }

    public void onDraw(Canvas canvas) {
        Paint paint;
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        if (this.lllIIIlIlI == CameraAspectMode.ASPECT_FIT) {
            width = this.IIlIIIllIl;
            height = this.lIIIIIllll;
        }
        boolean z = true;
        int round = Math.round(((float) width) / 50.0f) + 1;
        int round2 = Math.round(((float) height) / 50.0f) + 1;
        float f = 0.0f;
        for (int i = 0; i < round2; i++) {
            float f2 = 0.0f;
            int i2 = 0;
            while (i2 < round) {
                if (z) {
                    paint = i2 % 2 == 0 ? this.IlIllIlIIl : this.IllIIIllII;
                } else {
                    paint = i2 % 2 == 0 ? this.IllIIIllII : this.IlIllIlIIl;
                }
                float f3 = f2 + 50.0f;
                canvas.drawRect(f2, f, f3, f + 50.0f, paint);
                i2++;
                f2 = f3;
            }
            f += 50.0f;
            z = !z;
        }
        int width2 = getWidth();
        int height2 = getHeight();
        if (this.lllIIIlIlI == CameraAspectMode.ASPECT_FIT) {
            width2 = this.IIlIIIllIl;
            height2 = this.lIIIIIllll;
        }
        canvas.drawText("Camera", (((float) width2) - this.llIIIlllll.measureText("Camera")) / 2.0f, (((float) height2) / 2.0f) + 62.5f, this.llIIIlllll);
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int i3 = this.IllIIIIllI;
        int i4 = this.lIlIIIIlIl;
        if (this.llIIlIIlll != 1) {
            int i5 = i4;
            i4 = i3;
            i3 = i5;
        }
        if (this.lllIIIlIlI == CameraAspectMode.ASPECT_FIT) {
            int i6 = size * i3;
            int i7 = size2 * i4;
            if (i6 > i7) {
                this.IIlIIIllIl = i7 / i3;
                this.lIIIIIllll = size2;
            } else {
                this.lIIIIIllll = i6 / i4;
                this.IIlIIIllIl = size;
            }
            setMeasuredDimension(this.IIlIIIllIl, this.lIIIIIllll);
            return;
        }
        int i8 = size * i3;
        int i9 = size2 * i4;
        if (i8 < i9) {
            size = i9 / i3;
        } else {
            size2 = i8 / i4;
        }
        setMeasuredDimension(size, size2);
    }

    public void removeCallback() {
    }

    public void setAspectMode(CameraAspectMode cameraAspectMode) {
        this.lllIIIlIlI = cameraAspectMode;
    }

    public void setCameraViewEventListener(ICameraView.CameraViewEventListener cameraViewEventListener) {
    }

    public void setDeviceNaturalOrientationLandscape(boolean z) {
    }

    public void setHostActivityOrientation(int i) {
        this.llIIlIlIIl = i;
    }

    public void setPreviewSize(int i, int i2) {
        this.IllIIIIllI = i;
        this.lIlIIIIlIl = i2;
    }

    public void setRotation(int i) {
    }
}
