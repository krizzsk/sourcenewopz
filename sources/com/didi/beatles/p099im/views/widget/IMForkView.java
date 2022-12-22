package com.didi.beatles.p099im.views.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.didi.beatles.p099im.resource.IMResource;
import com.didi.beatles.p099im.utils.IMLog;
import com.didi.beatles.p099im.utils.IMViewUtil;
import com.didi.passenger.C10448R;
import com.taxis99.R;

/* renamed from: com.didi.beatles.im.views.widget.IMForkView */
public class IMForkView extends View {

    /* renamed from: a */
    private int f10459a;

    /* renamed from: b */
    private int f10460b;

    /* renamed from: c */
    private Paint f10461c;

    public IMForkView(Context context) {
        this(context, (AttributeSet) null, 0);
    }

    public IMForkView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IMForkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m7110a();
    }

    public void setViewColor(int i) {
        this.f10459a = i;
    }

    /* renamed from: a */
    private void m7110a() {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(C10448R.styleable.IMForkView);
        if (obtainStyledAttributes != null) {
            this.f10459a = obtainStyledAttributes.getColor(0, IMResource.getColor(R.color.white));
            this.f10460b = obtainStyledAttributes.getInteger(1, 3);
            obtainStyledAttributes.recycle();
            Paint paint = new Paint();
            this.f10461c = paint;
            paint.setStrokeWidth((float) IMViewUtil.dp2px(getContext(), 1.0f));
            this.f10461c.setAntiAlias(true);
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        this.f10461c.setColor(this.f10459a);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        IMLog.m6631d("IMForkView", "paddingleft = " + getPaddingLeft() + "  padingRight = " + getPaddingRight() + " width = " + getMeasuredWidth() + "  height = " + getMeasuredHeight());
        Canvas canvas2 = canvas;
        canvas2.drawLine((float) getPaddingLeft(), (float) getPaddingTop(), (float) (measuredWidth - getPaddingRight()), (float) (measuredHeight - getPaddingBottom()), this.f10461c);
        canvas2.drawLine((float) getPaddingLeft(), (float) (measuredHeight - getPaddingBottom()), (float) (measuredWidth - getPaddingRight()), (float) getPaddingTop(), this.f10461c);
    }
}
