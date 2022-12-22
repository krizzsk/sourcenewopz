package com.didi.soda.customer.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import androidx.core.view.ViewCompat;
import com.didi.passenger.C10448R;

public class CustomerSeekBar extends View {

    /* renamed from: a */
    private int f41485a = 40;

    /* renamed from: b */
    private int f41486b = -1;

    /* renamed from: c */
    private int f41487c = -1;

    /* renamed from: d */
    private int f41488d = 5;

    /* renamed from: e */
    private int f41489e = 25;

    /* renamed from: f */
    private Drawable f41490f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public float f41491g = 1.3f;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public float f41492h = 1.0f;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public float f41493i = 1.0f;

    /* renamed from: j */
    private int f41494j = 20;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public int f41495k = 100;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public int f41496l = 0;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public OnTrackListener f41497m;

    /* renamed from: n */
    private SparseArray<StarData> f41498n = new SparseArray<>();

    /* renamed from: o */
    private boolean f41499o = false;

    /* renamed from: p */
    private int f41500p;

    /* renamed from: q */
    private int f41501q;

    /* renamed from: r */
    private int f41502r;

    /* renamed from: s */
    private int f41503s;

    /* renamed from: t */
    private ValueAnimator f41504t;

    /* renamed from: u */
    private BeginDragRunnable f41505u = new BeginDragRunnable();

    public interface OnTrackListener {
        void onEndTrackingTouch(CustomerSeekBar customerSeekBar, int i, int i2, boolean z);

        boolean onInterceptTouch();

        void onStartTrackingTouch(CustomerSeekBar customerSeekBar, int i, int i2);

        void onTrackingTouch(CustomerSeekBar customerSeekBar, int i, int i2);
    }

    public CustomerSeekBar(Context context) {
        super(context);
        m29358a((AttributeSet) null);
    }

    public CustomerSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m29358a(attributeSet);
    }

    public CustomerSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m29358a(attributeSet);
    }

    public int getMinStep() {
        return this.f41494j;
    }

    public void setOnTrackListener(OnTrackListener onTrackListener) {
        this.f41497m = onTrackListener;
    }

    public void setCurrentProgress(int i) {
        if (i != this.f41496l) {
            int i2 = this.f41495k;
            if (i > i2) {
                i = i2;
            }
            int i3 = this.f41494j;
            int i4 = i / i3;
            if ((((float) i) * 1.0f) / ((float) i3) == ((float) i4)) {
                this.f41496l = i;
            } else {
                this.f41496l = (i4 + 1) * i3;
            }
            invalidate();
        }
    }

    public void setMaxProgress(int i) {
        if (i <= 0) {
            i = 100;
        }
        this.f41495k = i;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        OnTrackListener onTrackListener = this.f41497m;
        if (onTrackListener != null && onTrackListener.onInterceptTouch()) {
            return onTouchEvent;
        }
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                this.f41499o = false;
                m29355a();
                m29356a((int) motionEvent.getX(), (int) motionEvent.getY());
                boolean z = this.f41500p != this.f41496l;
                if (z) {
                    m29363b();
                }
                OnTrackListener onTrackListener2 = this.f41497m;
                if (onTrackListener2 != null) {
                    onTrackListener2.onEndTrackingTouch(this, this.f41496l, this.f41495k, z);
                }
            } else if (actionMasked == 2) {
                int x = (int) motionEvent.getX();
                if (!this.f41499o && Math.abs(this.f41501q - x) > this.f41502r) {
                    this.f41499o = true;
                    onTouchEvent = true;
                }
                if (this.f41499o) {
                    ViewParent parent = getParent();
                    if (parent != null) {
                        parent.requestDisallowInterceptTouchEvent(true);
                    }
                    m29355a();
                    m29356a((int) motionEvent.getX(), (int) motionEvent.getY());
                    OnTrackListener onTrackListener3 = this.f41497m;
                    if (onTrackListener3 != null) {
                        onTrackListener3.onTrackingTouch(this, this.f41496l, this.f41495k);
                    }
                }
            } else if (actionMasked == 3) {
                removeCallbacks(this.f41505u);
                setCurrentProgress(this.f41500p);
                this.f41499o = false;
            }
            if (onTouchEvent || this.f41499o) {
                return true;
            }
            return false;
        }
        this.f41500p = this.f41496l;
        this.f41501q = (int) motionEvent.getX();
        this.f41499o = false;
        int unused = this.f41505u.f41506x = (int) motionEvent.getX();
        int unused2 = this.f41505u.f41507y = (int) motionEvent.getY();
        boolean unused3 = this.f41505u.isPost = false;
        postDelayed(this.f41505u, (long) this.f41503s);
        return true;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i2);
        int i3 = this.f41485a;
        if (size < i3) {
            size = i3;
        }
        int i4 = this.f41487c;
        if (i4 < 0) {
            this.f41487c = (int) (((float) size) / this.f41491g);
        } else {
            size = (int) (((float) i4) * this.f41491g);
        }
        if (this.f41486b < 0) {
            this.f41486b = this.f41487c;
        }
        int i5 = this.f41486b;
        int i6 = this.f41488d;
        setMeasuredDimension((i5 * i6) + (this.f41489e * (i6 - 1)) + ((int) (((float) i5) * (this.f41491g - 1.0f))), size);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        m29357a(canvas);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x009c, code lost:
        if (r4 != null) goto L_0x00a1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x009f, code lost:
        if (r4 != null) goto L_0x00a1;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m29357a(android.graphics.Canvas r17) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            android.graphics.drawable.Drawable r2 = r0.f41490f
            if (r2 != 0) goto L_0x0009
            return
        L_0x0009:
            boolean r2 = r2 instanceof android.graphics.drawable.LayerDrawable
            if (r2 == 0) goto L_0x00e3
            r2 = 16908288(0x1020000, float:2.387723E-38)
            android.graphics.drawable.Drawable r2 = r0.m29354a((int) r2)
            r3 = 16908301(0x102000d, float:2.3877265E-38)
            android.graphics.drawable.Drawable r3 = r0.m29354a((int) r3)
            r4 = 2131430854(0x7f0b0dc6, float:1.848342E38)
            android.graphics.drawable.Drawable r4 = r0.m29354a((int) r4)
            int r5 = r0.f41486b
            int r6 = r0.f41487c
            int r7 = r0.f41489e
            int r8 = r0.f41488d
            float r9 = (float) r5
            float r10 = r0.f41491g
            r11 = 1065353216(0x3f800000, float:1.0)
            float r10 = r10 - r11
            float r9 = r9 * r10
            r10 = 1073741824(0x40000000, float:2.0)
            float r9 = r9 / r10
            int r9 = (int) r9
            int r10 = r16.getHeight()
            int r10 = r10 - r6
            int r10 = r10 / 2
            int r6 = r6 + r10
            r13 = 0
        L_0x003e:
            if (r13 >= r8) goto L_0x006a
            int r14 = r5 + r7
            int r14 = r14 * r13
            int r14 = r14 + r9
            int r15 = r14 + r5
            r2.setBounds(r14, r10, r15, r6)
            r2.draw(r1)
            android.util.SparseArray<com.didi.soda.customer.widget.CustomerSeekBar$StarData> r11 = r0.f41498n
            java.lang.Object r11 = r11.get(r13)
            com.didi.soda.customer.widget.CustomerSeekBar$StarData r11 = (com.didi.soda.customer.widget.CustomerSeekBar.StarData) r11
            if (r11 != 0) goto L_0x0062
            com.didi.soda.customer.widget.CustomerSeekBar$StarData r11 = new com.didi.soda.customer.widget.CustomerSeekBar$StarData
            r12 = 0
            r11.<init>()
            android.util.SparseArray<com.didi.soda.customer.widget.CustomerSeekBar$StarData> r12 = r0.f41498n
            r12.put(r13, r11)
        L_0x0062:
            r11.set(r14, r10, r15, r6)
            int r13 = r13 + 1
            r11 = 1065353216(0x3f800000, float:1.0)
            goto L_0x003e
        L_0x006a:
            int r2 = r0.f41496l
            int r6 = r0.f41495k
            int r7 = r0.f41494j
            int r8 = r6 - r7
            if (r2 >= r8) goto L_0x0086
            int r2 = r0.m29361b((int) r5)
            android.graphics.Rect r4 = new android.graphics.Rect
            int r6 = r16.getHeight()
            r8 = 0
            r4.<init>(r8, r8, r2, r6)
            r1.clipRect(r4)
            goto L_0x00a2
        L_0x0086:
            r8 = 0
            if (r2 >= r6) goto L_0x009f
            int r6 = r6 - r7
            if (r2 < r6) goto L_0x009f
            int r2 = r0.m29361b((int) r5)
            android.graphics.Rect r6 = new android.graphics.Rect
            int r7 = r16.getHeight()
            r6.<init>(r8, r8, r2, r7)
            r1.clipRect(r6)
            if (r4 == 0) goto L_0x00a2
            goto L_0x00a1
        L_0x009f:
            if (r4 == 0) goto L_0x00a2
        L_0x00a1:
            r3 = r4
        L_0x00a2:
            float r2 = r0.f41492h
            r4 = 1065353216(0x3f800000, float:1.0)
            float r2 = r2 - r4
            float r4 = (float) r5
            float r2 = r2 * r4
            int r2 = (int) r2
            int r2 = r2 / 2
            r12 = 0
        L_0x00ae:
            android.util.SparseArray<com.didi.soda.customer.widget.CustomerSeekBar$StarData> r4 = r0.f41498n
            int r4 = r4.size()
            if (r12 >= r4) goto L_0x00e3
            android.util.SparseArray<com.didi.soda.customer.widget.CustomerSeekBar$StarData> r4 = r0.f41498n
            int r4 = r4.keyAt(r12)
            android.util.SparseArray<com.didi.soda.customer.widget.CustomerSeekBar$StarData> r5 = r0.f41498n
            java.lang.Object r4 = r5.get(r4)
            com.didi.soda.customer.widget.CustomerSeekBar$StarData r4 = (com.didi.soda.customer.widget.CustomerSeekBar.StarData) r4
            int r5 = r4.left
            int r5 = r5 - r2
            int r6 = r4.top
            int r6 = r6 - r2
            int r7 = r4.right
            int r7 = r7 + r2
            int r4 = r4.bottom
            int r4 = r4 + r2
            r3.setBounds(r5, r6, r7, r4)
            float r4 = r0.f41493i
            r5 = 1132396544(0x437f0000, float:255.0)
            float r4 = r4 * r5
            int r4 = (int) r4
            r3.setAlpha(r4)
            r3.draw(r1)
            int r12 = r12 + 1
            goto L_0x00ae
        L_0x00e3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.customer.widget.CustomerSeekBar.m29357a(android.graphics.Canvas):void");
    }

    /* renamed from: a */
    private void m29355a() {
        OnTrackListener onTrackListener;
        removeCallbacks(this.f41505u);
        if (!this.f41505u.isPost && (onTrackListener = this.f41497m) != null) {
            onTrackListener.onStartTrackingTouch(this, this.f41496l, this.f41495k);
        }
    }

    /* renamed from: a */
    private Drawable m29354a(int i) {
        Drawable drawable = this.f41490f;
        Drawable drawable2 = null;
        if (drawable != null) {
            this.f41490f = drawable.mutate();
            if (drawable instanceof LayerDrawable) {
                drawable2 = ((LayerDrawable) drawable).findDrawableByLayerId(i);
            }
            if (drawable2 == null) {
                return drawable;
            }
        }
        return drawable2;
    }

    /* renamed from: b */
    private int m29361b(int i) {
        int i2 = (int) (((((float) this.f41496l) * 1.0f) / ((float) this.f41495k)) * ((float) (this.f41488d * i)));
        int i3 = i2 / i;
        StarData starData = this.f41498n.get(i3);
        if (starData == null) {
            return 0;
        }
        int i4 = i2 - (i3 * i);
        if (i4 == 0) {
            return Math.max(starData.left - (this.f41489e / 2), 0);
        }
        return starData.left + i4;
    }

    /* renamed from: a */
    private void m29358a(AttributeSet attributeSet) {
        this.f41502r = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.f41503s = ViewConfiguration.getTapTimeout();
        this.f41485a = m29364c(this.f41485a);
        this.f41489e = m29364c(this.f41489e);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C10448R.styleable.CustomerSeekBar);
            this.f41490f = obtainStyledAttributes.getDrawable(6);
            this.f41494j = obtainStyledAttributes.getInteger(4, this.f41495k / 5);
            this.f41488d = obtainStyledAttributes.getInteger(0, 5);
            this.f41489e = obtainStyledAttributes.getDimensionPixelOffset(2, this.f41489e);
            setCurrentProgress(obtainStyledAttributes.getInteger(5, 0));
            this.f41487c = obtainStyledAttributes.getDimensionPixelOffset(1, -1);
            this.f41486b = obtainStyledAttributes.getDimensionPixelOffset(3, -1);
            obtainStyledAttributes.recycle();
        }
    }

    /* renamed from: b */
    private void m29363b() {
        if (this.f41504t == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f, 2.0f});
            this.f41504t = ofFloat;
            ofFloat.setDuration(400);
            this.f41504t.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    CustomerSeekBar customerSeekBar = CustomerSeekBar.this;
                    float unused = customerSeekBar.f41492h = customerSeekBar.f41491g - ((CustomerSeekBar.this.f41491g - 1.0f) * Math.abs(1.0f - floatValue));
                    float unused2 = CustomerSeekBar.this.f41493i = Math.min(floatValue, 1.0f);
                    ViewCompat.postInvalidateOnAnimation(CustomerSeekBar.this);
                }
            });
        }
        if (this.f41504t.isRunning()) {
            this.f41504t.end();
        }
        this.f41504t.start();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m29356a(int i, int i2) {
        int i3;
        StarData starData = null;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < this.f41498n.size(); i7++) {
            int keyAt = this.f41498n.keyAt(i7);
            StarData starData2 = this.f41498n.get(keyAt);
            if (starData2.left < i && starData2.right >= i) {
                i5 = keyAt;
                starData = starData2;
            }
            i4 = Math.min(i4, starData2.left);
            i6 = Math.max(i6, starData2.right);
        }
        if (starData != null) {
            int i8 = this.f41486b;
            setCurrentProgress((int) (((((float) (((i5 * i8) + i) - starData.left)) * 1.0f) / ((float) (this.f41488d * i8))) * ((float) this.f41495k)));
        } else if (i <= i4) {
            if (this.f41496l != 0) {
                setCurrentProgress(0);
            }
        } else if (i >= i6 && this.f41496l != (i3 = this.f41495k)) {
            setCurrentProgress(i3);
        }
    }

    /* renamed from: c */
    private int m29364c(int i) {
        return (int) TypedValue.applyDimension(1, (float) i, getResources().getDisplayMetrics());
    }

    public int getMaxProgress() {
        return this.f41495k;
    }

    private static class StarData {
        int bottom;
        int left;
        int right;
        int top;

        private StarData() {
        }

        /* access modifiers changed from: package-private */
        public void set(int i, int i2, int i3, int i4) {
            this.left = i;
            this.top = i2;
            this.right = i3;
            this.bottom = i4;
        }
    }

    private class BeginDragRunnable implements Runnable {
        /* access modifiers changed from: private */
        public boolean isPost;
        /* access modifiers changed from: private */

        /* renamed from: x */
        public int f41506x;
        /* access modifiers changed from: private */

        /* renamed from: y */
        public int f41507y;

        private BeginDragRunnable() {
        }

        public void run() {
            this.isPost = true;
            CustomerSeekBar.this.m29356a(this.f41506x, this.f41507y);
            if (CustomerSeekBar.this.f41497m != null) {
                OnTrackListener b = CustomerSeekBar.this.f41497m;
                CustomerSeekBar customerSeekBar = CustomerSeekBar.this;
                b.onStartTrackingTouch(customerSeekBar, customerSeekBar.f41496l, CustomerSeekBar.this.f41495k);
            }
        }
    }
}
