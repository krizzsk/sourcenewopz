package com.didi.entrega.customer.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import com.didi.passenger.C10448R;

public class DisplayNumberEditText extends MaxLengthEditText {

    /* renamed from: a */
    private static final int f20299a = 25;

    /* renamed from: b */
    private int f20300b;

    /* renamed from: c */
    private int f20301c;

    /* renamed from: d */
    private float f20302d;

    /* renamed from: e */
    private float f20303e;

    /* renamed from: f */
    private float f20304f;

    /* renamed from: g */
    private float f20305g = 25.0f;

    /* renamed from: h */
    private Paint f20306h;

    public DisplayNumberEditText(Context context) {
        super(context);
        m14901a(context, (AttributeSet) null);
    }

    public DisplayNumberEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m14901a(context, attributeSet);
    }

    public DisplayNumberEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m14901a(context, attributeSet);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int length = getText().length();
        String valueOf = String.valueOf(length);
        int width = (int) ((((float) getWidth()) - this.f20302d) - this.f20306h.measureText(String.valueOf(length) + "/" + String.valueOf(this.mMaxNumber)));
        this.f20306h.setColor(this.f20300b);
        float height = (float) ((int) ((((float) getHeight()) - this.f20303e) - this.f20304f));
        canvas.drawText(valueOf, (float) width, height, this.f20306h);
        this.f20306h.setColor(this.f20301c);
        canvas.drawText("/" + String.valueOf(this.mMaxNumber), (float) (width + ((int) this.f20306h.measureText(valueOf))), height, this.f20306h);
    }

    /* renamed from: a */
    private void m14901a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.EntregaDisplayNumberEditText);
            this.mMaxNumber = obtainStyledAttributes.getInt(3, 0);
            this.f20300b = obtainStyledAttributes.getColor(0, 0);
            this.f20301c = obtainStyledAttributes.getColor(4, 0);
            this.f20305g = obtainStyledAttributes.getDimension(5, 25.0f);
            this.f20302d = obtainStyledAttributes.getDimension(2, 0.0f);
            this.f20303e = obtainStyledAttributes.getDimension(1, 0.0f);
            obtainStyledAttributes.recycle();
            setMaxNumber(this.mMaxNumber);
        }
        Paint paint = new Paint();
        this.f20306h = paint;
        paint.setAntiAlias(true);
        this.f20306h.setTextSize(this.f20305g);
        this.f20304f = (float) ((int) this.f20306h.getFontMetrics().bottom);
    }
}
