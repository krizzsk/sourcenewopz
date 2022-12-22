package com.didi.hawaii.p118ar.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.didi.hawaii.p118ar.utils.DisplayUtils;
import com.taxis99.R;

/* renamed from: com.didi.hawaii.ar.view.GirdBackGround */
public class GirdBackGround extends View {

    /* renamed from: a */
    private Paint f23402a = new Paint();

    /* renamed from: b */
    private Path f23403b;

    /* renamed from: c */
    private int f23404c;

    /* renamed from: d */
    private int f23405d;

    public GirdBackGround(Context context) {
        super(context);
        m16733a();
    }

    public GirdBackGround(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m16733a();
    }

    public GirdBackGround(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m16733a();
    }

    /* renamed from: a */
    private void m16733a() {
        this.f23402a.setColor(getResources().getColor(R.color.gird_color));
        this.f23402a.setAntiAlias(true);
        this.f23402a.setStyle(Paint.Style.STROKE);
        this.f23402a.setStrokeWidth(1.0f);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f23404c = getMeasuredWidth();
        this.f23405d = getMeasuredHeight();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate((float) (this.f23404c / 2), (float) (this.f23405d / 2));
        canvas.save();
        m16734a(canvas);
        canvas.restore();
    }

    /* renamed from: a */
    private void m16734a(Canvas canvas) {
        Rect rect = new Rect(((-this.f23404c) / 2) + getPaddingLeft(), ((-this.f23405d) / 2) + getPaddingTop(), (this.f23404c / 2) - getPaddingRight(), (this.f23405d / 2) - getPaddingBottom());
        if (this.f23403b == null) {
            this.f23403b = new Path();
            float dip2px = (float) DisplayUtils.dip2px(getContext(), 8.0f);
            int i = 0;
            int i2 = 0;
            while (true) {
                float f = ((float) i2) * dip2px;
                if (((float) rect.left) + f > ((float) rect.right)) {
                    break;
                }
                this.f23403b.moveTo(((float) rect.left) + f, (float) rect.top);
                this.f23403b.lineTo(((float) rect.left) + f, (float) rect.bottom);
                i2++;
            }
            while (true) {
                float f2 = ((float) i) * dip2px;
                if (((float) rect.top) + f2 > ((float) rect.bottom)) {
                    break;
                }
                this.f23403b.moveTo((float) rect.left, ((float) rect.top) + f2);
                this.f23403b.lineTo((float) rect.right, ((float) rect.top) + f2);
                i++;
            }
        }
        canvas.drawPath(this.f23403b, this.f23402a);
    }
}
