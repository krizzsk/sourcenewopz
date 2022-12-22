package com.didichuxing.cardscan.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: com.didichuxing.cardscan.view.a */
public class C15187a extends ViewGroup {

    /* renamed from: b */
    static final /* synthetic */ boolean f46221b = (!C15187a.class.desiredAssertionStatus());

    /* renamed from: a */
    SurfaceView f46222a;

    public C15187a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f46222a = new SurfaceView(context);
        addView(this.f46222a, new ViewGroup.LayoutParams(-1, -1));
    }

    public SurfaceHolder getSurfaceHolder() {
        SurfaceHolder holder = getSurfaceView().getHolder();
        if (f46221b || holder != null) {
            return holder;
        }
        throw new AssertionError();
    }

    public SurfaceView getSurfaceView() {
        if (f46221b || this.f46222a != null) {
            return this.f46222a;
        }
        throw new AssertionError();
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawARGB(255, 255, 0, 0);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z && getChildCount() > 0) {
            if (f46221b || this.f46222a != null) {
                this.f46222a.layout(0, 0, i3 - i, i4 - i2);
                return;
            }
            throw new AssertionError();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int resolveSize = resolveSize(getSuggestedMinimumWidth(), i);
        int resolveSize2 = resolveSize(getSuggestedMinimumHeight(), i2);
        this.f46222a.measure(View.MeasureSpec.makeMeasureSpec(resolveSize, 1073741824), View.MeasureSpec.makeMeasureSpec(resolveSize2, 1073741824));
        setMeasuredDimension(resolveSize, resolveSize2);
    }
}
