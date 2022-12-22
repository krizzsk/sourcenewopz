package com.didi.sdk.webview.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewTreeObserver;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class CropImageView extends ImageView implements View.OnTouchListener, ViewTreeObserver.OnGlobalLayoutListener {
    public static final float DEFAULT_MAX_SCALE = 4.0f;
    public static final float DEFAULT_MID_SCALE = 2.0f;
    public static final float DEFAULT_MIN_SCALE = 1.0f;

    /* renamed from: a */
    private static final int f38433a = 50;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public float f38434b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public float f38435c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public float f38436d;

    /* renamed from: e */
    private MultiGestureDetector f38437e;

    /* renamed from: f */
    private int f38438f;

    /* renamed from: g */
    private int f38439g;

    /* renamed from: h */
    private boolean f38440h;

    /* renamed from: i */
    private int f38441i;

    /* renamed from: j */
    private int f38442j;

    /* renamed from: k */
    private final Matrix f38443k;

    /* renamed from: l */
    private final Matrix f38444l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public final Matrix f38445m;

    /* renamed from: n */
    private final RectF f38446n;

    public void setWidthScale(int i) {
        this.f38441i = i;
    }

    public void setHeightScale(int i) {
        this.f38442j = i;
    }

    public CropImageView(Context context) {
        this(context, (AttributeSet) null);
    }

    public CropImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CropImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f38434b = 1.0f;
        this.f38435c = 2.0f;
        this.f38436d = 4.0f;
        this.f38443k = new Matrix();
        this.f38444l = new Matrix();
        this.f38445m = new Matrix();
        this.f38446n = new RectF();
        super.setScaleType(ImageView.ScaleType.MATRIX);
        setOnTouchListener(this);
        this.f38437e = new MultiGestureDetector(context);
    }

    public boolean performClick() {
        return super.performClick();
    }

    /* renamed from: a */
    private void m27214a() {
        super.setScaleType(ImageView.ScaleType.MATRIX);
        Drawable drawable = getDrawable();
        if (drawable != null) {
            float width = (float) getWidth();
            float height = (float) getHeight();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i = (int) (width - 100.0f);
            this.f38438f = i;
            this.f38439g = (this.f38442j * i) / this.f38441i;
            float f = 1.0f;
            float f2 = (float) intrinsicHeight;
            float f3 = (float) intrinsicWidth;
            float max = Math.max(((float) i) / f2, ((float) i) / f3);
            this.f38434b = max;
            if (max > this.f38435c) {
                if (max > this.f38436d) {
                    this.f38435c = max;
                    this.f38436d = max;
                } else {
                    this.f38435c = max;
                    this.f38436d = max * 2.0f;
                }
            }
            if (intrinsicWidth <= intrinsicHeight) {
                if (intrinsicWidth < this.f38438f) {
                    this.f38443k.reset();
                    f = ((float) this.f38438f) / f3;
                    this.f38443k.postScale(f, f);
                }
            } else if (intrinsicHeight < this.f38439g) {
                this.f38443k.reset();
                f = ((float) this.f38439g) / f2;
                this.f38443k.postScale(f, f);
            }
            if (f2 > height && f3 > width) {
                this.f38443k.reset();
                f = f2 - height > f3 - width ? width / f3 : height / f2;
                this.f38443k.postScale(f, f);
            }
            this.f38443k.postTranslate((width - (f3 * f)) / 2.0f, (height - (f2 * f)) / 2.0f);
            m27221d();
            this.f38440h = true;
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        view.performClick();
        return this.f38437e.onTouchEvent(motionEvent);
    }

    private class MultiGestureDetector extends GestureDetector.SimpleOnGestureListener implements ScaleGestureDetector.OnScaleGestureListener {
        private final GestureDetector gestureDetector;
        private boolean isDragging;
        private float lastPointerCount;
        private float lastTouchX;
        private float lastTouchY;
        private final ScaleGestureDetector scaleGestureDetector;
        private final float scaledTouchSlop;
        private VelocityTracker velocityTracker;

        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector2) {
            return true;
        }

        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector2) {
        }

        public MultiGestureDetector(Context context) {
            this.scaleGestureDetector = new ScaleGestureDetector(context, this);
            GestureDetector gestureDetector2 = new GestureDetector(context, this);
            this.gestureDetector = gestureDetector2;
            gestureDetector2.setOnDoubleTapListener(this);
            this.scaledTouchSlop = (float) ViewConfiguration.get(context).getScaledTouchSlop();
        }

        public boolean onScale(ScaleGestureDetector scaleGestureDetector2) {
            float scale = CropImageView.this.getScale();
            float scaleFactor = scaleGestureDetector2.getScaleFactor();
            if (CropImageView.this.getDrawable() == null) {
                return true;
            }
            if ((scale >= CropImageView.this.f38436d || scaleFactor <= 1.0f) && (scale <= CropImageView.this.f38434b || scaleFactor >= 1.0f)) {
                return true;
            }
            if (scaleFactor * scale < CropImageView.this.f38434b) {
                scaleFactor = CropImageView.this.f38434b / scale;
            }
            if (scaleFactor * scale > CropImageView.this.f38436d) {
                scaleFactor = CropImageView.this.f38436d / scale;
            }
            CropImageView.this.f38445m.postScale(scaleFactor, scaleFactor, (float) (CropImageView.this.getWidth() / 2), (float) (CropImageView.this.getHeight() / 2));
            CropImageView.this.m27218b();
            return true;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:18:0x004b, code lost:
            if (r0 != 3) goto L_0x00ba;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTouchEvent(android.view.MotionEvent r12) {
            /*
                r11 = this;
                android.view.GestureDetector r0 = r11.gestureDetector
                boolean r0 = r0.onTouchEvent(r12)
                r1 = 1
                if (r0 == 0) goto L_0x000a
                return r1
            L_0x000a:
                android.view.ScaleGestureDetector r0 = r11.scaleGestureDetector
                r0.onTouchEvent(r12)
                int r0 = r12.getPointerCount()
                r2 = 0
                r3 = 0
                r4 = 0
                r5 = 0
                r6 = 0
            L_0x0018:
                if (r4 >= r0) goto L_0x0027
                float r7 = r12.getX(r4)
                float r5 = r5 + r7
                float r7 = r12.getY(r4)
                float r6 = r6 + r7
                int r4 = r4 + 1
                goto L_0x0018
            L_0x0027:
                float r0 = (float) r0
                float r5 = r5 / r0
                float r6 = r6 / r0
                float r4 = r11.lastPointerCount
                int r4 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
                if (r4 == 0) goto L_0x003d
                r11.isDragging = r3
                android.view.VelocityTracker r4 = r11.velocityTracker
                if (r4 == 0) goto L_0x0039
                r4.clear()
            L_0x0039:
                r11.lastTouchX = r5
                r11.lastTouchY = r6
            L_0x003d:
                r11.lastPointerCount = r0
                int r0 = r12.getAction()
                if (r0 == 0) goto L_0x00a1
                if (r0 == r1) goto L_0x0094
                r4 = 2
                if (r0 == r4) goto L_0x004e
                r12 = 3
                if (r0 == r12) goto L_0x0094
                goto L_0x00ba
            L_0x004e:
                float r0 = r11.lastTouchX
                float r0 = r5 - r0
                float r2 = r11.lastTouchY
                float r2 = r6 - r2
                boolean r4 = r11.isDragging
                if (r4 != 0) goto L_0x006e
                float r4 = r0 * r0
                float r7 = r2 * r2
                float r4 = r4 + r7
                double r7 = (double) r4
                double r7 = java.lang.Math.sqrt(r7)
                float r4 = r11.scaledTouchSlop
                double r9 = (double) r4
                int r4 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
                if (r4 < 0) goto L_0x006c
                r3 = 1
            L_0x006c:
                r11.isDragging = r3
            L_0x006e:
                boolean r3 = r11.isDragging
                if (r3 == 0) goto L_0x00ba
                com.didi.sdk.webview.image.CropImageView r3 = com.didi.sdk.webview.image.CropImageView.this
                android.graphics.drawable.Drawable r3 = r3.getDrawable()
                if (r3 == 0) goto L_0x0088
                com.didi.sdk.webview.image.CropImageView r3 = com.didi.sdk.webview.image.CropImageView.this
                android.graphics.Matrix r3 = r3.f38445m
                r3.postTranslate(r0, r2)
                com.didi.sdk.webview.image.CropImageView r0 = com.didi.sdk.webview.image.CropImageView.this
                r0.m27218b()
            L_0x0088:
                r11.lastTouchX = r5
                r11.lastTouchY = r6
                android.view.VelocityTracker r0 = r11.velocityTracker
                if (r0 == 0) goto L_0x00ba
                r0.addMovement(r12)
                goto L_0x00ba
            L_0x0094:
                r11.lastPointerCount = r2
                android.view.VelocityTracker r12 = r11.velocityTracker
                if (r12 == 0) goto L_0x00ba
                r12.recycle()
                r12 = 0
                r11.velocityTracker = r12
                goto L_0x00ba
            L_0x00a1:
                android.view.VelocityTracker r0 = r11.velocityTracker
                if (r0 != 0) goto L_0x00ac
                android.view.VelocityTracker r0 = android.view.VelocityTracker.obtain()
                r11.velocityTracker = r0
                goto L_0x00af
            L_0x00ac:
                r0.clear()
            L_0x00af:
                android.view.VelocityTracker r0 = r11.velocityTracker
                r0.addMovement(r12)
                r11.lastTouchX = r5
                r11.lastTouchY = r6
                r11.isDragging = r3
            L_0x00ba:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.webview.image.CropImageView.MultiGestureDetector.onTouchEvent(android.view.MotionEvent):boolean");
        }

        public boolean onDoubleTap(MotionEvent motionEvent) {
            try {
                float scale = CropImageView.this.getScale();
                float width = (float) (CropImageView.this.getWidth() / 2);
                float height = (float) (CropImageView.this.getHeight() / 2);
                if (scale < CropImageView.this.f38435c) {
                    CropImageView.this.post(new AnimatedZoomRunnable(scale, CropImageView.this.f38435c, width, height));
                    return true;
                } else if (scale < CropImageView.this.f38435c || scale >= CropImageView.this.f38436d) {
                    CropImageView.this.post(new AnimatedZoomRunnable(scale, CropImageView.this.f38434b, width, height));
                    return true;
                } else {
                    CropImageView.this.post(new AnimatedZoomRunnable(scale, CropImageView.this.f38436d, width, height));
                    return true;
                }
            } catch (Exception unused) {
                return true;
            }
        }
    }

    private class AnimatedZoomRunnable implements Runnable {
        static final float ANIMATION_SCALE_PER_ITERATION_IN = 1.07f;
        static final float ANIMATION_SCALE_PER_ITERATION_OUT = 0.93f;
        private final float deltaScale;
        private final float focalX;
        private final float focalY;
        private final float targetZoom;

        public AnimatedZoomRunnable(float f, float f2, float f3, float f4) {
            this.targetZoom = f2;
            this.focalX = f3;
            this.focalY = f4;
            if (f < f2) {
                this.deltaScale = ANIMATION_SCALE_PER_ITERATION_IN;
            } else {
                this.deltaScale = ANIMATION_SCALE_PER_ITERATION_OUT;
            }
        }

        public void run() {
            Matrix c = CropImageView.this.f38445m;
            float f = this.deltaScale;
            c.postScale(f, f, this.focalX, this.focalY);
            CropImageView.this.m27218b();
            float scale = CropImageView.this.getScale();
            if ((this.deltaScale <= 1.0f || scale >= this.targetZoom) && (this.deltaScale >= 1.0f || this.targetZoom >= scale)) {
                float f2 = this.targetZoom / scale;
                CropImageView.this.f38445m.postScale(f2, f2, this.focalX, this.focalY);
                CropImageView.this.m27218b();
                return;
            }
            CropImageView cropImageView = CropImageView.this;
            cropImageView.m27215a(cropImageView, this);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m27215a(View view, Runnable runnable) {
        view.postDelayed(runnable, 16);
    }

    public final float getScale() {
        RectF a = m27213a(getDisplayMatrix());
        float f = a.bottom - a.top;
        int intrinsicHeight = getDrawable().getIntrinsicHeight();
        if (intrinsicHeight > 0) {
            return f / ((float) intrinsicHeight);
        }
        return 1.0f;
    }

    public void onGlobalLayout() {
        if (!this.f38440h) {
            m27214a();
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m27218b() {
        m27220c();
        setImageMatrix(getDisplayMatrix());
    }

    /* renamed from: c */
    private void m27220c() {
        RectF a = m27213a(getDisplayMatrix());
        if (a != null) {
            float width = (float) getWidth();
            float height = (float) getHeight();
            float f = a.top;
            int i = this.f38439g;
            float f2 = f > (height - ((float) i)) / 2.0f ? ((height - ((float) i)) / 2.0f) - a.top : 0.0f;
            float f3 = a.bottom;
            int i2 = this.f38439g;
            if (f3 < (((float) i2) + height) / 2.0f) {
                f2 = ((height + ((float) i2)) / 2.0f) - a.bottom;
            }
            float f4 = a.left;
            int i3 = this.f38438f;
            float f5 = f4 > (width - ((float) i3)) / 2.0f ? ((width - ((float) i3)) / 2.0f) - a.left : 0.0f;
            float f6 = a.right;
            int i4 = this.f38438f;
            if (f6 < (((float) i4) + width) / 2.0f) {
                f5 = ((width + ((float) i4)) / 2.0f) - a.right;
            }
            this.f38445m.postTranslate(f5, f2);
            TranslateAnimation translateAnimation = new TranslateAnimation(-f5, 0.0f, -f2, 0.0f);
            translateAnimation.setDuration(10);
            startAnimation(translateAnimation);
        }
    }

    /* renamed from: a */
    private RectF m27213a(Matrix matrix) {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return this.f38446n;
        }
        this.f38446n.set(0.0f, 0.0f, (float) drawable.getIntrinsicWidth(), (float) drawable.getIntrinsicHeight());
        matrix.mapRect(this.f38446n);
        return this.f38446n;
    }

    /* renamed from: d */
    private void m27221d() {
        Matrix matrix = this.f38445m;
        if (matrix != null) {
            matrix.reset();
            setImageMatrix(getDisplayMatrix());
        }
    }

    /* access modifiers changed from: protected */
    public Matrix getDisplayMatrix() {
        this.f38444l.set(this.f38443k);
        this.f38444l.postConcat(this.f38445m);
        return this.f38444l;
    }

    public Bitmap crop(float f, float f2) {
        RectF a = m27213a(getDisplayMatrix());
        float f3 = a.bottom - a.top;
        BitmapDrawable bitmapDrawable = (BitmapDrawable) getDrawable();
        int height = bitmapDrawable.getBitmap().getHeight();
        int width = bitmapDrawable.getBitmap().getWidth();
        float f4 = (float) height;
        float f5 = f3 / f4;
        float height2 = ((((float) getHeight()) - ((float) this.f38439g)) / 2.0f) - a.top;
        float width2 = ((((float) getWidth()) - ((float) this.f38438f)) / 2.0f) - a.left;
        Matrix matrix = new Matrix();
        float max = Math.max(f / ((float) width), f2 / f4);
        matrix.setScale(max, max);
        try {
            return m27212a(bitmapDrawable.getBitmap(), (int) (width2 / f5), (int) (height2 / f5), (int) (((float) this.f38438f) / f5), (int) (((float) this.f38439g) / f5), matrix, true);
        } catch (Exception unused) {
            return null;
        }
    }

    public Bitmap cropUpPercentTen(float f, float f2) {
        float f3 = f;
        float f4 = f2;
        float width = (float) getWidth();
        float height = (float) getHeight();
        RectF a = m27213a(getDisplayMatrix());
        float f5 = a.bottom - a.top;
        BitmapDrawable bitmapDrawable = (BitmapDrawable) getDrawable();
        float height2 = (float) bitmapDrawable.getBitmap().getHeight();
        float max = Math.max(f3 / ((float) bitmapDrawable.getBitmap().getWidth()), f4 / height2);
        float f6 = f5 / height2;
        double d = (double) f6;
        float f7 = (float) ((((double) f3) * 0.1d) / d);
        float f8 = (float) ((((double) f4) * 0.1d) / d);
        float f9 = (height - ((float) this.f38439g)) / 2.0f;
        float f10 = f9 - a.top;
        if (((float) Math.round(f9 - a.top)) > f8) {
            f10 -= f8;
        }
        float f11 = (width - ((float) this.f38438f)) / 2.0f;
        float f12 = f11 - a.left;
        if (((float) Math.round(f11 - a.left)) > f7) {
            f12 -= f7;
        }
        int i = this.f38438f;
        float f13 = ((width - ((float) i)) / 2.0f) + ((float) i);
        float f14 = (float) i;
        if (((float) Math.round(a.right - f13)) > f7) {
            f14 += f7;
        }
        int i2 = this.f38439g;
        float f15 = ((height - ((float) i2)) / 2.0f) + ((float) i2);
        float f16 = (float) i2;
        if (((float) Math.round(a.bottom - f15)) > f8) {
            f16 += f8;
        }
        Matrix matrix = new Matrix();
        matrix.setScale(max, max);
        try {
            int i3 = (int) (f16 / f6);
            return m27212a(bitmapDrawable.getBitmap(), (int) (f12 / f6), (int) (f10 / f6), (int) (f14 / f6), i3, matrix, true);
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: a */
    private Bitmap m27212a(Bitmap bitmap, int i, int i2, int i3, int i4, Matrix matrix, boolean z) {
        if (bitmap == null) {
            return null;
        }
        try {
            int max = Math.max(0, i);
            int max2 = Math.max(0, i2);
            return Bitmap.createBitmap(bitmap, max, max2, Math.min(bitmap.getWidth() - max, i3), Math.min(bitmap.getHeight() - max2, i4), matrix, true);
        } catch (Exception unused) {
            return null;
        }
    }
}
