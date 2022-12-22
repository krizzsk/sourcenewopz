package com.didi.sdk.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;
import com.didi.passenger.C10448R;

public class StrokeTextView extends TextView {

    /* renamed from: a */
    private Context f37898a;

    /* renamed from: b */
    private float f37899b = -1.0f;

    /* renamed from: c */
    private ColorStateList f37900c;

    public StrokeTextView(Context context) {
        super(context);
        m26822a(context, (AttributeSet) null);
    }

    public StrokeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m26822a(context, attributeSet);
    }

    public StrokeTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m26822a(context, attributeSet);
    }

    /* renamed from: a */
    private void m26822a(Context context, AttributeSet attributeSet) {
        if (context != null && attributeSet != null) {
            this.f37898a = context;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.stroke_text_view);
            this.f37899b = obtainStyledAttributes.getDimension(1, -1.0f);
            this.f37900c = obtainStyledAttributes.getColorStateList(0);
            obtainStyledAttributes.recycle();
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        TextPaint paint = getPaint();
        if (!(paint == null || this.f37900c == null || Float.compare(this.f37899b, -1.0f) <= 0)) {
            int currentTextColor = getCurrentTextColor();
            Paint.Style style = paint.getStyle();
            Paint.Join strokeJoin = paint.getStrokeJoin();
            float strokeWidth = paint.getStrokeWidth();
            float strokeMiter = paint.getStrokeMiter();
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeJoin(Paint.Join.MITER);
            paint.setStrokeMiter(10.0f);
            paint.setStrokeWidth(this.f37899b);
            setTextColor(this.f37900c);
            super.onDraw(canvas);
            paint.setStyle(style);
            paint.setStrokeJoin(strokeJoin);
            paint.setStrokeMiter(strokeMiter);
            paint.setStrokeWidth(strokeWidth);
            setTextColor(currentTextColor);
        }
        super.onDraw(canvas);
    }

    public float getStrokeWidth() {
        return this.f37899b;
    }

    public StrokeTextView setStrokeWidth(float f) {
        this.f37899b = f;
        return this;
    }

    public ColorStateList getStrokeColor() {
        return this.f37900c;
    }

    public StrokeTextView setStrokeColor(int i) {
        this.f37900c = ColorStateList.valueOf(i);
        return this;
    }

    public StrokeTextView setStrokeColorResource(int i) {
        Context context = this.f37898a;
        if (context != null) {
            this.f37900c = context.getResources().getColorStateList(i);
        }
        return this;
    }
}
