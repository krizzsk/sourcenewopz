package com.github.mikephil.charting.utils;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.View;

public class ViewPortHandler {

    /* renamed from: a */
    private float f52521a = 1.0f;

    /* renamed from: b */
    private float f52522b = Float.MAX_VALUE;

    /* renamed from: c */
    private float f52523c = 1.0f;

    /* renamed from: d */
    private float f52524d = Float.MAX_VALUE;

    /* renamed from: e */
    private float f52525e = 1.0f;

    /* renamed from: f */
    private float f52526f = 1.0f;

    /* renamed from: g */
    private float f52527g = 0.0f;

    /* renamed from: h */
    private float f52528h = 0.0f;

    /* renamed from: i */
    private float f52529i = 0.0f;

    /* renamed from: j */
    private float f52530j = 0.0f;
    protected Matrix mCenterViewPortMatrixBuffer = new Matrix();
    protected float mChartHeight = 0.0f;
    protected float mChartWidth = 0.0f;
    protected RectF mContentRect = new RectF();
    protected final Matrix mMatrixTouch = new Matrix();
    protected final float[] matrixBuffer = new float[9];
    protected float[] valsBufferForFitScreen = new float[9];

    public void setChartDimens(float f, float f2) {
        float offsetLeft = offsetLeft();
        float offsetTop = offsetTop();
        float offsetRight = offsetRight();
        float offsetBottom = offsetBottom();
        this.mChartHeight = f2;
        this.mChartWidth = f;
        restrainViewPort(offsetLeft, offsetTop, offsetRight, offsetBottom);
    }

    public boolean hasChartDimens() {
        return this.mChartHeight > 0.0f && this.mChartWidth > 0.0f;
    }

    public void restrainViewPort(float f, float f2, float f3, float f4) {
        this.mContentRect.set(f, f2, this.mChartWidth - f3, this.mChartHeight - f4);
    }

    public float offsetLeft() {
        return this.mContentRect.left;
    }

    public float offsetRight() {
        return this.mChartWidth - this.mContentRect.right;
    }

    public float offsetTop() {
        return this.mContentRect.top;
    }

    public float offsetBottom() {
        return this.mChartHeight - this.mContentRect.bottom;
    }

    public float contentTop() {
        return this.mContentRect.top;
    }

    public float contentLeft() {
        return this.mContentRect.left;
    }

    public float contentRight() {
        return this.mContentRect.right;
    }

    public float contentBottom() {
        return this.mContentRect.bottom;
    }

    public float contentWidth() {
        return this.mContentRect.width();
    }

    public float contentHeight() {
        return this.mContentRect.height();
    }

    public RectF getContentRect() {
        return this.mContentRect;
    }

    public MPPointF getContentCenter() {
        return MPPointF.getInstance(this.mContentRect.centerX(), this.mContentRect.centerY());
    }

    public float getChartHeight() {
        return this.mChartHeight;
    }

    public float getChartWidth() {
        return this.mChartWidth;
    }

    public float getSmallestContentExtension() {
        return Math.min(this.mContentRect.width(), this.mContentRect.height());
    }

    public Matrix zoomIn(float f, float f2) {
        Matrix matrix = new Matrix();
        zoomIn(f, f2, matrix);
        return matrix;
    }

    public void zoomIn(float f, float f2, Matrix matrix) {
        matrix.reset();
        matrix.set(this.mMatrixTouch);
        matrix.postScale(1.4f, 1.4f, f, f2);
    }

    public Matrix zoomOut(float f, float f2) {
        Matrix matrix = new Matrix();
        zoomOut(f, f2, matrix);
        return matrix;
    }

    public void zoomOut(float f, float f2, Matrix matrix) {
        matrix.reset();
        matrix.set(this.mMatrixTouch);
        matrix.postScale(0.7f, 0.7f, f, f2);
    }

    public void resetZoom(Matrix matrix) {
        matrix.reset();
        matrix.set(this.mMatrixTouch);
        matrix.postScale(1.0f, 1.0f, 0.0f, 0.0f);
    }

    public Matrix zoom(float f, float f2) {
        Matrix matrix = new Matrix();
        zoom(f, f2, matrix);
        return matrix;
    }

    public void zoom(float f, float f2, Matrix matrix) {
        matrix.reset();
        matrix.set(this.mMatrixTouch);
        matrix.postScale(f, f2);
    }

    public Matrix zoom(float f, float f2, float f3, float f4) {
        Matrix matrix = new Matrix();
        zoom(f, f2, f3, f4, matrix);
        return matrix;
    }

    public void zoom(float f, float f2, float f3, float f4, Matrix matrix) {
        matrix.reset();
        matrix.set(this.mMatrixTouch);
        matrix.postScale(f, f2, f3, f4);
    }

    public Matrix setZoom(float f, float f2) {
        Matrix matrix = new Matrix();
        setZoom(f, f2, matrix);
        return matrix;
    }

    public void setZoom(float f, float f2, Matrix matrix) {
        matrix.reset();
        matrix.set(this.mMatrixTouch);
        matrix.setScale(f, f2);
    }

    public Matrix setZoom(float f, float f2, float f3, float f4) {
        Matrix matrix = new Matrix();
        matrix.set(this.mMatrixTouch);
        matrix.setScale(f, f2, f3, f4);
        return matrix;
    }

    public Matrix fitScreen() {
        Matrix matrix = new Matrix();
        fitScreen(matrix);
        return matrix;
    }

    public void fitScreen(Matrix matrix) {
        this.f52523c = 1.0f;
        this.f52521a = 1.0f;
        matrix.set(this.mMatrixTouch);
        float[] fArr = this.valsBufferForFitScreen;
        for (int i = 0; i < 9; i++) {
            fArr[i] = 0.0f;
        }
        matrix.getValues(fArr);
        fArr[2] = 0.0f;
        fArr[5] = 0.0f;
        fArr[0] = 1.0f;
        fArr[4] = 1.0f;
        matrix.setValues(fArr);
    }

    public Matrix translate(float[] fArr) {
        Matrix matrix = new Matrix();
        translate(fArr, matrix);
        return matrix;
    }

    public void translate(float[] fArr, Matrix matrix) {
        matrix.reset();
        matrix.set(this.mMatrixTouch);
        matrix.postTranslate(-(fArr[0] - offsetLeft()), -(fArr[1] - offsetTop()));
    }

    public void centerViewPort(float[] fArr, View view) {
        Matrix matrix = this.mCenterViewPortMatrixBuffer;
        matrix.reset();
        matrix.set(this.mMatrixTouch);
        matrix.postTranslate(-(fArr[0] - offsetLeft()), -(fArr[1] - offsetTop()));
        refresh(matrix, view, true);
    }

    public Matrix refresh(Matrix matrix, View view, boolean z) {
        this.mMatrixTouch.set(matrix);
        limitTransAndScale(this.mMatrixTouch, this.mContentRect);
        if (z) {
            view.invalidate();
        }
        matrix.set(this.mMatrixTouch);
        return matrix;
    }

    public void limitTransAndScale(Matrix matrix, RectF rectF) {
        float f;
        matrix.getValues(this.matrixBuffer);
        float[] fArr = this.matrixBuffer;
        float f2 = fArr[2];
        float f3 = fArr[0];
        float f4 = fArr[5];
        float f5 = fArr[4];
        this.f52525e = Math.min(Math.max(this.f52523c, f3), this.f52524d);
        this.f52526f = Math.min(Math.max(this.f52521a, f5), this.f52522b);
        float f6 = 0.0f;
        if (rectF != null) {
            f6 = rectF.width();
            f = rectF.height();
        } else {
            f = 0.0f;
        }
        this.f52527g = Math.min(Math.max(f2, ((-f6) * (this.f52525e - 1.0f)) - this.f52529i), this.f52529i);
        float max = Math.max(Math.min(f4, (f * (this.f52526f - 1.0f)) + this.f52530j), -this.f52530j);
        this.f52528h = max;
        float[] fArr2 = this.matrixBuffer;
        fArr2[2] = this.f52527g;
        fArr2[0] = this.f52525e;
        fArr2[5] = max;
        fArr2[4] = this.f52526f;
        matrix.setValues(fArr2);
    }

    public void setMinimumScaleX(float f) {
        if (f < 1.0f) {
            f = 1.0f;
        }
        this.f52523c = f;
        limitTransAndScale(this.mMatrixTouch, this.mContentRect);
    }

    public void setMaximumScaleX(float f) {
        if (f == 0.0f) {
            f = Float.MAX_VALUE;
        }
        this.f52524d = f;
        limitTransAndScale(this.mMatrixTouch, this.mContentRect);
    }

    public void setMinMaxScaleX(float f, float f2) {
        if (f < 1.0f) {
            f = 1.0f;
        }
        if (f2 == 0.0f) {
            f2 = Float.MAX_VALUE;
        }
        this.f52523c = f;
        this.f52524d = f2;
        limitTransAndScale(this.mMatrixTouch, this.mContentRect);
    }

    public void setMinimumScaleY(float f) {
        if (f < 1.0f) {
            f = 1.0f;
        }
        this.f52521a = f;
        limitTransAndScale(this.mMatrixTouch, this.mContentRect);
    }

    public void setMaximumScaleY(float f) {
        if (f == 0.0f) {
            f = Float.MAX_VALUE;
        }
        this.f52522b = f;
        limitTransAndScale(this.mMatrixTouch, this.mContentRect);
    }

    public void setMinMaxScaleY(float f, float f2) {
        if (f < 1.0f) {
            f = 1.0f;
        }
        if (f2 == 0.0f) {
            f2 = Float.MAX_VALUE;
        }
        this.f52521a = f;
        this.f52522b = f2;
        limitTransAndScale(this.mMatrixTouch, this.mContentRect);
    }

    public Matrix getMatrixTouch() {
        return this.mMatrixTouch;
    }

    public boolean isInBoundsX(float f) {
        return isInBoundsLeft(f) && isInBoundsRight(f);
    }

    public boolean isInBoundsY(float f) {
        return isInBoundsTop(f) && isInBoundsBottom(f);
    }

    public boolean isInBounds(float f, float f2) {
        return isInBoundsX(f) && isInBoundsY(f2);
    }

    public boolean isInBoundsLeft(float f) {
        return this.mContentRect.left <= f + 1.0f;
    }

    public boolean isInBoundsRight(float f) {
        return this.mContentRect.right >= (((float) ((int) (f * 100.0f))) / 100.0f) - 1.0f;
    }

    public boolean isInBoundsTop(float f) {
        return this.mContentRect.top <= f;
    }

    public boolean isInBoundsBottom(float f) {
        return this.mContentRect.bottom >= ((float) ((int) (f * 100.0f))) / 100.0f;
    }

    public float getScaleX() {
        return this.f52525e;
    }

    public float getScaleY() {
        return this.f52526f;
    }

    public float getMinScaleX() {
        return this.f52523c;
    }

    public float getMaxScaleX() {
        return this.f52524d;
    }

    public float getMinScaleY() {
        return this.f52521a;
    }

    public float getMaxScaleY() {
        return this.f52522b;
    }

    public float getTransX() {
        return this.f52527g;
    }

    public float getTransY() {
        return this.f52528h;
    }

    public boolean isFullyZoomedOut() {
        return isFullyZoomedOutX() && isFullyZoomedOutY();
    }

    public boolean isFullyZoomedOutY() {
        float f = this.f52526f;
        float f2 = this.f52521a;
        return f <= f2 && f2 <= 1.0f;
    }

    public boolean isFullyZoomedOutX() {
        float f = this.f52525e;
        float f2 = this.f52523c;
        return f <= f2 && f2 <= 1.0f;
    }

    public void setDragOffsetX(float f) {
        this.f52529i = Utils.convertDpToPixel(f);
    }

    public void setDragOffsetY(float f) {
        this.f52530j = Utils.convertDpToPixel(f);
    }

    public boolean hasNoDragOffset() {
        return this.f52529i <= 0.0f && this.f52530j <= 0.0f;
    }

    public boolean canZoomOutMoreX() {
        return this.f52525e > this.f52523c;
    }

    public boolean canZoomInMoreX() {
        return this.f52525e < this.f52524d;
    }

    public boolean canZoomOutMoreY() {
        return this.f52526f > this.f52521a;
    }

    public boolean canZoomInMoreY() {
        return this.f52526f < this.f52522b;
    }
}
