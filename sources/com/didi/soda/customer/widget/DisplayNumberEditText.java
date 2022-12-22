package com.didi.soda.customer.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import com.didi.passenger.C10448R;

public class DisplayNumberEditText extends MaxLengthEditText {

    /* renamed from: a */
    private static final int f41526a = 25;

    /* renamed from: b */
    private int f41527b;

    /* renamed from: c */
    private int f41528c;

    /* renamed from: d */
    private float f41529d;

    /* renamed from: e */
    private float f41530e;

    /* renamed from: f */
    private float f41531f;

    /* renamed from: g */
    private float f41532g = 25.0f;

    /* renamed from: h */
    private Paint f41533h;

    public DisplayNumberEditText(Context context) {
        super(context);
        m29373a(context, (AttributeSet) null);
    }

    public DisplayNumberEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m29373a(context, attributeSet);
    }

    public DisplayNumberEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m29373a(context, attributeSet);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int length = getText().length();
        String valueOf = String.valueOf(length);
        int width = (int) ((((float) getWidth()) - this.f41529d) - this.f41533h.measureText(String.valueOf(length) + "/" + String.valueOf(this.mMaxNumber)));
        this.f41533h.setColor(this.f41527b);
        float height = (float) ((int) ((((float) getHeight()) - this.f41530e) - this.f41531f));
        canvas.drawText(valueOf, (float) width, height, this.f41533h);
        this.f41533h.setColor(this.f41528c);
        canvas.drawText("/" + String.valueOf(this.mMaxNumber), (float) (width + ((int) this.f41533h.measureText(valueOf))), height, this.f41533h);
    }

    /* renamed from: a */
    private void m29373a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.DisplayNumberEditText);
            this.mMaxNumber = obtainStyledAttributes.getInt(3, 0);
            this.f41527b = obtainStyledAttributes.getColor(0, 0);
            this.f41528c = obtainStyledAttributes.getColor(4, 0);
            this.f41532g = obtainStyledAttributes.getDimension(5, 25.0f);
            this.f41529d = obtainStyledAttributes.getDimension(2, 0.0f);
            this.f41530e = obtainStyledAttributes.getDimension(1, 0.0f);
            obtainStyledAttributes.recycle();
            setMaxNumber(this.mMaxNumber);
        }
        Paint paint = new Paint();
        this.f41533h = paint;
        paint.setAntiAlias(true);
        this.f41533h.setTextSize(this.f41532g);
        this.f41531f = (float) ((int) this.f41533h.getFontMetrics().bottom);
    }
}
