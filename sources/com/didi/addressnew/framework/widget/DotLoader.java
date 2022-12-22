package com.didi.addressnew.framework.widget;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.didi.passenger.C10448R;
import java.lang.ref.WeakReference;

public class DotLoader extends View {

    /* renamed from: b */
    private static final int f7414b = 80;

    /* renamed from: c */
    private static final int f7415c = 500;

    /* renamed from: d */
    private static final int f7416d = 500;

    /* renamed from: a */
    Integer[] f7417a;

    /* renamed from: e */
    private C3300b[] f7418e;

    /* renamed from: f */
    private int f7419f;

    /* renamed from: g */
    private Rect f7420g;

    /* renamed from: h */
    private float f7421h;

    /* renamed from: i */
    private float f7422i;

    /* renamed from: j */
    private float f7423j;

    /* renamed from: k */
    private Interpolator f7424k = new LoadingInterpolator(0.62f, 0.28f, 0.23f, 0.99f);

    public void setNumberOfDots(int i) {
        C3300b[] bVarArr = new C3300b[i];
        initAnimation();
        C3300b[] bVarArr2 = this.f7418e;
        if (i <= bVarArr2.length) {
            System.arraycopy(bVarArr2, 0, bVarArr, 0, i);
            for (C3300b bVar : this.f7418e) {
                bVar.f7436f.start();
                bVar.f7437g.start();
            }
        } else {
            System.arraycopy(bVarArr2, 0, bVarArr, 0, bVarArr2.length);
            for (int i2 = 0; i2 < i; i2++) {
                bVarArr[i2] = new C3300b(this, this.f7419f, i2);
                int i3 = i2 - 1;
                bVarArr[i2].f7433c = bVarArr[i3 < 0 ? 0 : i3].f7433c + this.f7421h;
                bVarArr[i2].f7434d = bVarArr[i3 < 0 ? 0 : i3].f7434d / 2.0f;
                C3300b bVar2 = bVarArr[i2];
                if (i3 < 0) {
                    i3 = 0;
                }
                bVar2.mo39117a(bVarArr[i3].f7431a);
                bVarArr[i2].f7436f = m4661b(bVarArr[0].f7436f, bVarArr[i2]);
                bVarArr[i2].f7437g = m4654a(bVarArr[0].f7437g, bVarArr[i2]);
                bVarArr[i2].f7436f.start();
            }
        }
        this.f7418e = bVarArr;
    }

    /* renamed from: a */
    private ValueAnimator m4654a(ValueAnimator valueAnimator, C3300b bVar) {
        ValueAnimator clone = valueAnimator.clone();
        clone.removeAllUpdateListeners();
        clone.addUpdateListener(new DotColorUpdater(bVar, this));
        return clone;
    }

    /* renamed from: b */
    private ValueAnimator m4661b(ValueAnimator valueAnimator, C3300b bVar) {
        ValueAnimator clone = valueAnimator.clone();
        clone.removeAllUpdateListeners();
        clone.addUpdateListener(new DotYUpdater(bVar, this));
        clone.setStartDelay((long) (bVar.f7435e * 80));
        clone.removeAllListeners();
        clone.addListener(new C3299a(bVar, this.f7417a));
        return clone;
    }

    public void resetColors() {
        for (C3300b a : this.f7418e) {
            a.mo39117a(0);
        }
    }

    public DotLoader(Context context) {
        super(context);
        m4659a(context, (AttributeSet) null);
    }

    public DotLoader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m4659a(context, attributeSet);
    }

    public DotLoader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m4659a(context, attributeSet);
    }

    public DotLoader(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m4659a(context, attributeSet);
    }

    /* renamed from: a */
    private void m4659a(Context context, AttributeSet attributeSet) {
        Integer[] numArr;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C10448R.styleable.DotLoader, 0, 0);
            try {
                float dimension = obtainStyledAttributes.getDimension(1, 0.0f);
                int integer = obtainStyledAttributes.getInteger(2, 1);
                int resourceId = obtainStyledAttributes.getResourceId(0, 0);
                if (resourceId == 0) {
                    numArr = new Integer[integer];
                    for (int i = 0; i < integer; i++) {
                        numArr[i] = 0;
                    }
                } else {
                    int[] intArray = getResources().getIntArray(resourceId);
                    Integer[] numArr2 = new Integer[intArray.length];
                    for (int i2 = 0; i2 < intArray.length; i2++) {
                        numArr2[i2] = Integer.valueOf(intArray[i2]);
                    }
                    numArr = numArr2;
                }
                m4658a(integer, numArr, (int) dimension);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m4656a() {
        for (C3300b bVar : this.f7418e) {
            bVar.f7436f.end();
            bVar.f7437g.end();
        }
    }

    /* renamed from: a */
    private void m4658a(int i, Integer[] numArr, int i2) {
        this.f7417a = numArr;
        this.f7420g = new Rect(0, 0, 0, 0);
        this.f7418e = new C3300b[i];
        this.f7419f = i2;
        for (int i3 = 0; i3 < i; i3++) {
            this.f7418e[i3] = new C3300b(this, i2, i3);
        }
    }

    public void initAnimation() {
        int length = this.f7418e.length;
        for (int i = 0; i < length; i++) {
            C3300b[] bVarArr = this.f7418e;
            bVarArr[i].f7436f = m4655a(bVarArr[i]);
            this.f7418e[i].f7436f.setStartDelay((long) (i * 80));
            C3300b[] bVarArr2 = this.f7418e;
            bVarArr2[i].f7437g = m4662b(bVarArr2[i]);
        }
    }

    /* renamed from: b */
    private void m4663b() {
        postDelayed(new Runnable() {
            public void run() {
                DotLoader.this.m4667d();
            }
        }, 10);
    }

    /* renamed from: c */
    private void m4665c() {
        post(new Runnable() {
            public void run() {
                DotLoader.this.m4656a();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m4667d() {
        initAnimation();
        for (C3300b bVar : this.f7418e) {
            bVar.f7436f.start();
        }
    }

    /* renamed from: a */
    private ValueAnimator m4655a(C3300b bVar) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{this.f7422i, this.f7423j});
        ofFloat.setInterpolator(this.f7424k);
        ofFloat.setDuration(500);
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ofFloat.addUpdateListener(new DotYUpdater(bVar, this));
        ofFloat.addListener(new C3299a(bVar, this.f7417a));
        return ofFloat;
    }

    /* renamed from: b */
    private ValueAnimator m4662b(C3300b bVar) {
        ValueAnimator ofObject = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{this.f7417a[bVar.f7431a], this.f7417a[bVar.mo39121c()]});
        ofObject.setInterpolator(new LinearInterpolator());
        ofObject.setDuration(500);
        ofObject.addUpdateListener(new DotColorUpdater(bVar, this));
        return ofObject;
    }

    private static class DotColorUpdater implements ValueAnimator.AnimatorUpdateListener {
        private C3300b mDot;
        private WeakReference<DotLoader> mDotLoaderRef;

        private DotColorUpdater(C3300b bVar, DotLoader dotLoader) {
            this.mDot = bVar;
            this.mDotLoaderRef = new WeakReference<>(dotLoader);
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.mDot.mo39120b(((Integer) valueAnimator.getAnimatedValue()).intValue());
            DotLoader dotLoader = (DotLoader) this.mDotLoaderRef.get();
            if (dotLoader != null) {
                dotLoader.m4668e();
            }
        }
    }

    private static class DotYUpdater implements ValueAnimator.AnimatorUpdateListener {
        private C3300b mDot;
        private WeakReference<DotLoader> mDotLoaderRef;

        private DotYUpdater(C3300b bVar, DotLoader dotLoader) {
            this.mDot = bVar;
            this.mDotLoaderRef = new WeakReference<>(dotLoader);
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.mDot.f7434d = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            DotLoader dotLoader = (DotLoader) this.mDotLoaderRef.get();
            if (dotLoader != null) {
                dotLoader.m4668e();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m4668e() {
        Rect rect = this.f7420g;
        if (rect == null || rect.left == 0 || this.f7420g.top == 0 || this.f7420g.right == 0 || this.f7420g.bottom == 0) {
            invalidate();
        } else {
            invalidate(this.f7420g);
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.getClipBounds(this.f7420g);
        for (C3300b a : this.f7418e) {
            a.mo39118a(canvas);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        m4657a(size);
        this.f7421h = m4669f();
        int i3 = this.f7419f * 14;
        int length = this.f7418e.length;
        for (int i4 = 0; i4 < length; i4++) {
            this.f7418e[i4].f7433c = ((float) (this.f7419f * 3)) + (((float) i4) * this.f7421h);
            this.f7418e[i4].f7434d = (float) (size / 2);
        }
        int i5 = size / 2;
        int i6 = this.f7419f;
        this.f7422i = (float) (i5 - (i6 * 1));
        this.f7423j = (float) (i5 + (i6 * 1));
        for (C3300b bVar : this.f7418e) {
            bVar.f7432b = this.f7419f;
        }
        setMeasuredDimension(i3, size);
    }

    /* renamed from: a */
    private void m4657a(int i) {
        this.f7419f = ((i - getPaddingTop()) - getPaddingBottom()) / 20;
    }

    /* renamed from: f */
    private float m4669f() {
        return (float) (this.f7419f * 4);
    }
}
