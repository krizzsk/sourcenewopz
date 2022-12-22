package com.didi.global.globalgenerickit.dialog;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.didi.passenger.C10448R;

public class GGKRoundImageView extends AppCompatImageView {

    /* renamed from: a */
    private float f22097a;

    /* renamed from: b */
    private float f22098b;

    /* renamed from: c */
    private float f22099c;

    /* renamed from: d */
    private float f22100d;

    /* renamed from: e */
    private float f22101e;

    /* renamed from: f */
    private float f22102f;

    /* renamed from: g */
    private float f22103g;

    public GGKRoundImageView(Context context) {
        this(context, (AttributeSet) null);
    }

    public GGKRoundImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GGKRoundImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m16002a(context, attributeSet);
    }

    /* renamed from: a */
    private void m16002a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.custom_Round_Image_View);
        float dimension = obtainStyledAttributes.getDimension(2, 0.0f);
        this.f22099c = dimension;
        if (dimension != 0.0f) {
            this.f22101e = dimension;
            this.f22100d = dimension;
            this.f22103g = dimension;
            this.f22102f = dimension;
            obtainStyledAttributes.recycle();
            return;
        }
        this.f22101e = obtainStyledAttributes.getDimension(0, 0.0f);
        this.f22100d = obtainStyledAttributes.getDimension(1, 0.0f);
        this.f22102f = obtainStyledAttributes.getDimension(4, 0.0f);
        this.f22103g = obtainStyledAttributes.getDimension(3, 0.0f);
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f22097a = (float) getWidth();
        this.f22098b = (float) getHeight();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Path path = new Path();
        path.moveTo(this.f22100d, 0.0f);
        path.lineTo(this.f22097a - this.f22102f, 0.0f);
        float f = this.f22097a;
        path.quadTo(f, 0.0f, f, this.f22102f);
        path.lineTo(this.f22097a, this.f22098b - this.f22103g);
        float f2 = this.f22097a;
        float f3 = this.f22098b;
        path.quadTo(f2, f3, f2 - this.f22103g, f3);
        path.lineTo(this.f22101e, this.f22098b);
        float f4 = this.f22098b;
        path.quadTo(0.0f, f4, 0.0f, f4 - this.f22101e);
        path.lineTo(0.0f, this.f22100d);
        path.quadTo(0.0f, 0.0f, this.f22100d, 0.0f);
        canvas.clipPath(path);
        super.onDraw(canvas);
    }
}
