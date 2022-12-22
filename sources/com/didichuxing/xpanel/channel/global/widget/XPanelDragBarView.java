package com.didichuxing.xpanel.channel.global.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.taxis99.R;

public class XPanelDragBarView extends View {

    /* renamed from: d */
    private static final int f49401d = 40;

    /* renamed from: e */
    private static final int f49402e = 5;

    /* renamed from: a */
    private float f49403a;

    /* renamed from: b */
    private float f49404b;

    /* renamed from: c */
    private Paint f49405c;

    /* renamed from: f */
    private RectF f49406f;

    /* renamed from: g */
    private float f49407g;

    /* renamed from: h */
    private float f49408h;

    public XPanelDragBarView(Context context) {
        this(context, (AttributeSet) null);
    }

    public XPanelDragBarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public XPanelDragBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f49405c = null;
        this.f49406f = new RectF();
        this.f49407g = 0.0f;
        this.f49408h = 0.0f;
        m35681a();
    }

    /* renamed from: a */
    private void m35681a() {
        this.f49403a = (float) getResources().getDimensionPixelSize(R.dimen.oc_x_panel_drag_bar_triangle_width);
        this.f49404b = (float) getResources().getDimensionPixelSize(R.dimen.oc_x_panel_drag_bar_triangle_height);
        this.f49407g = (float) getResources().getDimensionPixelSize(R.dimen.oc_x_panel_drag_bar_radius);
        Paint paint = new Paint();
        this.f49405c = paint;
        paint.setAntiAlias(true);
        this.f49405c.setStyle(Paint.Style.FILL);
        this.f49405c.setDither(true);
        this.f49405c.setColor(getResources().getColor(R.color.oc_color_1A000000));
    }

    /* access modifiers changed from: protected */
    public final void setDragAngle(float f) {
        this.f49408h = f;
        if (getVisibility() == 0) {
            invalidate();
        }
    }

    /* access modifiers changed from: protected */
    public float getDragAngle() {
        return this.f49408h;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f49406f.top = (((float) (i4 - i2)) - this.f49404b) / 2.0f;
        RectF rectF = this.f49406f;
        rectF.left = (((float) (i3 - i)) - this.f49403a) / 2.0f;
        RectF rectF2 = this.f49406f;
        rectF2.bottom = rectF2.top + this.f49404b;
        RectF rectF3 = this.f49406f;
        rectF3.right = rectF3.left + this.f49403a;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        m35682a(canvas);
    }

    /* renamed from: a */
    private void m35682a(Canvas canvas) {
        Canvas canvas2 = canvas;
        float f = this.f49408h;
        if (f == 180.0f) {
            RectF rectF = this.f49406f;
            float f2 = this.f49407g;
            canvas2.drawRoundRect(rectF, f2, f2, this.f49405c);
            return;
        }
        Path path = new Path();
        path.setFillType(Path.FillType.WINDING);
        RectF rectF2 = new RectF(this.f49406f);
        rectF2.right = ((rectF2.right - rectF2.left) / 2.0f) + rectF2.left;
        float f3 = this.f49407g;
        path.addRoundRect(rectF2, new float[]{f3, f3, 0.0f, 0.0f, 0.0f, 0.0f, f3, f3}, Path.Direction.CCW);
        Path path2 = new Path();
        path2.setFillType(Path.FillType.WINDING);
        RectF rectF3 = new RectF(this.f49406f);
        rectF3.left += (rectF3.right - rectF3.left) / 2.0f;
        float f4 = this.f49407g;
        path2.addRoundRect(rectF3, new float[]{0.0f, 0.0f, f4, f4, f4, f4, 0.0f, 0.0f}, Path.Direction.CCW);
        RectF rectF4 = new RectF();
        float f5 = rectF2.bottom - rectF2.top;
        rectF4.left = rectF2.right - f5;
        rectF4.top = rectF2.top - f5;
        rectF4.right = rectF2.right + f5;
        rectF4.bottom = rectF2.top + f5;
        float f6 = 180.0f - f;
        float f7 = f6 / 2.0f;
        float sin = (float) ((Math.sin(Math.toRadians((double) f7)) * ((double) (rectF2.right - rectF2.left))) / 2.0d);
        canvas2.translate(0.0f, sin);
        float f8 = f6;
        RectF rectF5 = rectF3;
        canvas.drawArc(rectF4, 90.0f - f7, f8, true, this.f49405c);
        canvas.save();
        canvas2.rotate(f7, rectF2.right, rectF2.top);
        canvas2.drawPath(path, this.f49405c);
        canvas.restore();
        canvas.save();
        canvas2.rotate(-f7, rectF5.left, rectF5.top);
        canvas2.drawPath(path2, this.f49405c);
        canvas.restore();
        canvas2.translate(0.0f, -sin);
    }
}
