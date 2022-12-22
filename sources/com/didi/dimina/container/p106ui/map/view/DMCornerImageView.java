package com.didi.dimina.container.p106ui.map.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.didi.dimina.container.util.PixUtil;

/* renamed from: com.didi.dimina.container.ui.map.view.DMCornerImageView */
public class DMCornerImageView extends AppCompatImageView {

    /* renamed from: a */
    private float[] f17575a;

    /* renamed from: b */
    private final PaintFlagsDrawFilter f17576b;

    /* renamed from: c */
    private final Path f17577c;

    /* renamed from: d */
    private final RectF f17578d;

    public DMCornerImageView(Context context) {
        this(context, (AttributeSet) null);
    }

    public DMCornerImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DMCornerImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f17575a = new float[8];
        this.f17577c = new Path();
        this.f17578d = new RectF();
        this.f17576b = new PaintFlagsDrawFilter(0, 1);
        float dip2px = (float) PixUtil.dip2px(context, 10.0f);
        float[] fArr = this.f17575a;
        fArr[0] = dip2px;
        fArr[1] = dip2px;
        fArr[2] = dip2px;
        fArr[3] = dip2px;
    }

    public void setRadius(float[] fArr) {
        this.f17575a = fArr;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        float[] fArr = this.f17575a;
        if (!(fArr == null || fArr.length <= 0 || this.f17578d == null)) {
            this.f17577c.reset();
            this.f17578d.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
            this.f17577c.addRoundRect(this.f17578d, this.f17575a, Path.Direction.CW);
            canvas.setDrawFilter(this.f17576b);
            canvas.clipPath(this.f17577c);
        }
        super.onDraw(canvas);
    }
}
