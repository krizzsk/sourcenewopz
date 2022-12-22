package com.didi.payment.pix.orderdetail.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import com.didi.payment.base.utils.UIUtil;
import com.taxis99.R;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014J\u0018\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0006H\u0014R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR\u001a\u0010\u0011\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\n¨\u0006\u001b"}, mo175978d2 = {"Lcom/didi/payment/pix/orderdetail/widget/SectionSepretorLine;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "colorLine", "", "getColorLine", "()I", "setColorLine", "(I)V", "defaultHeightSize", "defaultPaint", "Landroid/graphics/Paint;", "dp10", "getDp10", "setDp10", "radius", "getRadius", "setRadius", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SectionSepretorLine.kt */
public final class SectionSepretorLine extends View {

    /* renamed from: a */
    private int f31116a;

    /* renamed from: b */
    private int f31117b;

    /* renamed from: c */
    private int f31118c;

    /* renamed from: d */
    private int f31119d = getResources().getColor(R.color.light_gray_sss);

    /* renamed from: e */
    private Paint f31120e;

    public SectionSepretorLine(Context context) {
        super(context);
        this.f31116a = UIUtil.dip2px(context, 20.0f);
        this.f31118c = UIUtil.dip2px(context, 10.0f);
        Paint paint = new Paint();
        this.f31120e = paint;
        paint.setColor(getResources().getColor(R.color.pix_page_light_shade_bg));
        this.f31120e.setStrokeWidth((float) UIUtil.dip2px(context, 1.0f));
    }

    public final int getRadius() {
        return this.f31117b;
    }

    public final void setRadius(int i) {
        this.f31117b = i;
    }

    public final int getDp10() {
        return this.f31118c;
    }

    public final void setDp10(int i) {
        this.f31118c = i;
    }

    public final int getColorLine() {
        return this.f31119d;
    }

    public final void setColorLine(int i) {
        this.f31119d = i;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == 0) {
            size = this.f31116a;
        }
        setMeasuredDimension(View.MeasureSpec.getSize(i), size);
        this.f31117b = getMeasuredHeight() / 2;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (canvas != null) {
            canvas.drawCircle(0.0f, ((float) getMeasuredHeight()) / ((float) 2), (float) this.f31117b, this.f31120e);
        }
        if (canvas != null) {
            canvas.drawCircle((float) getMeasuredWidth(), (float) (getMeasuredHeight() / 2), (float) this.f31117b, this.f31120e);
        }
        this.f31120e.setColor(this.f31119d);
        int measuredWidth = (getMeasuredWidth() - (this.f31117b * 2)) / 52;
        int i = this.f31118c;
        if (measuredWidth < i) {
            measuredWidth = i;
        }
        for (int i2 = this.f31117b; i2 < (getMeasuredWidth() - (this.f31117b * 2)) - measuredWidth; i2 += measuredWidth * 2) {
            if (canvas != null) {
                canvas.drawLine((float) (i2 + measuredWidth), (float) (getMeasuredHeight() / 2), (float) ((measuredWidth * 2) + i2), (float) (getMeasuredHeight() / 2), this.f31120e);
            }
        }
    }
}
