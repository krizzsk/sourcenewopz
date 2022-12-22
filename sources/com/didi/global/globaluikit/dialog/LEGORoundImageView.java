package com.didi.global.globaluikit.dialog;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.didi.passenger.C10448R;

public class LEGORoundImageView extends AppCompatImageView {

    /* renamed from: a */
    private float f22487a;

    /* renamed from: b */
    private float f22488b;

    /* renamed from: c */
    private float f22489c;

    /* renamed from: d */
    private float f22490d;

    /* renamed from: e */
    private float f22491e;

    /* renamed from: f */
    private float f22492f;

    /* renamed from: g */
    private float f22493g;

    public LEGORoundImageView(Context context) {
        this(context, (AttributeSet) null);
    }

    public LEGORoundImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LEGORoundImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m16186a(context, attributeSet);
    }

    /* renamed from: a */
    private void m16186a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.custom_Round_Image_View);
        float dimension = obtainStyledAttributes.getDimension(2, 0.0f);
        this.f22489c = dimension;
        if (dimension != 0.0f) {
            this.f22491e = dimension;
            this.f22490d = dimension;
            this.f22493g = dimension;
            this.f22492f = dimension;
            obtainStyledAttributes.recycle();
            return;
        }
        this.f22491e = obtainStyledAttributes.getDimension(0, 0.0f);
        this.f22490d = obtainStyledAttributes.getDimension(1, 0.0f);
        this.f22492f = obtainStyledAttributes.getDimension(4, 0.0f);
        this.f22493g = obtainStyledAttributes.getDimension(3, 0.0f);
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f22487a = (float) getWidth();
        this.f22488b = (float) getHeight();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Path path = new Path();
        path.moveTo(this.f22490d, 0.0f);
        path.lineTo(this.f22487a - this.f22492f, 0.0f);
        float f = this.f22487a;
        path.quadTo(f, 0.0f, f, this.f22492f);
        path.lineTo(this.f22487a, this.f22488b - this.f22493g);
        float f2 = this.f22487a;
        float f3 = this.f22488b;
        path.quadTo(f2, f3, f2 - this.f22493g, f3);
        path.lineTo(this.f22491e, this.f22488b);
        float f4 = this.f22488b;
        path.quadTo(0.0f, f4, 0.0f, f4 - this.f22491e);
        path.lineTo(0.0f, this.f22490d);
        path.quadTo(0.0f, 0.0f, this.f22490d, 0.0f);
        canvas.clipPath(path);
        super.onDraw(canvas);
    }
}
