package com.didi.soda.business.page;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.view.ViewCompat;

class OverlayView extends View {

    /* renamed from: a */
    private Bitmap f39741a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Matrix f39742b = new Matrix();

    /* renamed from: c */
    private Matrix f39743c;

    /* renamed from: d */
    private Matrix f39744d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public View f39745e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public View f39746f;

    public interface AnimateEndListener {
        void onAnimationEnd();
    }

    public OverlayView(Context context, Bitmap bitmap) {
        super(context);
        this.f39741a = bitmap;
    }

    /* renamed from: a */
    public void mo100892a(View view, int i, int i2) {
        if (view != null) {
            this.f39745e = view;
            Matrix matrix = new Matrix();
            this.f39743c = matrix;
            matrix.setTranslate((float) i, (float) i2);
            this.f39742b.set(this.f39743c);
            mo100891a();
        }
    }

    /* renamed from: b */
    public void mo100894b(View view, int i, int i2) {
        if (view != null && this.f39745e != null) {
            this.f39746f = view;
            Matrix matrix = new Matrix();
            this.f39744d = matrix;
            matrix.setTranslate((float) i, (float) i2);
            this.f39744d.preScale((((float) this.f39746f.getWidth()) * 1.0f) / ((float) this.f39745e.getWidth()), (((float) this.f39746f.getHeight()) * 1.0f) / ((float) this.f39745e.getHeight()));
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Bitmap bitmap = this.f39741a;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, this.f39742b, (Paint) null);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m28311c();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo100891a() {
        ViewCompat.postInvalidateOnAnimation(this);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public Animator mo100893b() {
        if (this.f39745e == null || this.f39746f == null) {
            return null;
        }
        post(new Runnable() {
            public final void run() {
                OverlayView.this.m28314e();
            }
        });
        ValueAnimator ofObject = ValueAnimator.ofObject(new MatrixEvaluator(), new Object[]{this.f39743c, this.f39744d});
        ofObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                OverlayView.this.f39742b.set((Matrix) valueAnimator.getAnimatedValue());
                OverlayView.this.mo100891a();
            }
        });
        ofObject.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                OverlayView.this.f39745e.setVisibility(0);
                OverlayView.this.f39746f.setVisibility(0);
                OverlayView.this.m28312d();
            }

            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                OverlayView.this.f39745e.setVisibility(0);
                OverlayView.this.f39746f.setVisibility(0);
                OverlayView.this.m28312d();
            }
        });
        return ofObject;
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public /* synthetic */ void m28314e() {
        this.f39745e.setVisibility(4);
        this.f39746f.setVisibility(4);
    }

    /* renamed from: c */
    private void m28311c() {
        Bitmap bitmap = this.f39741a;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f39741a.recycle();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m28312d() {
        ViewParent parent = getParent();
        if (parent != null) {
            ((ViewGroup) parent).removeView(this);
        }
        m28311c();
    }

    private static class MatrixEvaluator implements TypeEvaluator<Matrix> {
        private Matrix mTemp;

        private MatrixEvaluator() {
            this.mTemp = new Matrix();
        }

        public Matrix evaluate(float f, Matrix matrix, Matrix matrix2) {
            float value = getValue(matrix, 2);
            float value2 = getValue(matrix, 5);
            float value3 = getValue(matrix2, 2);
            float value4 = getValue(matrix2, 5);
            float value5 = getValue(matrix, 0);
            float value6 = getValue(matrix, 4);
            float value7 = getValue(matrix2, 0);
            float value8 = getValue(matrix2, 4);
            this.mTemp.reset();
            this.mTemp.setTranslate(value + ((value3 - value) * f), value2 + ((value4 - value2) * f));
            this.mTemp.preScale(value5 + ((value7 - value5) * f), value6 + ((value8 - value6) * f));
            return new Matrix(this.mTemp);
        }

        private float getValue(Matrix matrix, int i) {
            float[] fArr = new float[9];
            matrix.getValues(fArr);
            return fArr[i];
        }
    }
}
