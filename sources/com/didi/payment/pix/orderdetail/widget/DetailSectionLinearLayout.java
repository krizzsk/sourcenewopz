package com.didi.payment.pix.orderdetail.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.widget.LinearLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0015J\u0018\u0010$\u001a\u00020!2\u0006\u0010%\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u0006H\u0014J\u000e\u0010'\u001a\u00020!2\u0006\u0010(\u001a\u00020\u0006R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u001a\u0010\u0017\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R\u001a\u0010\u001a\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0011\"\u0004\b\u001c\u0010\u0013R\u001a\u0010\u001d\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0011\"\u0004\b\u001f\u0010\u0013¨\u0006)"}, mo175978d2 = {"Lcom/didi/payment/pix/orderdetail/widget/DetailSectionLinearLayout;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TYPE_FOOTER", "", "TYPE_HEADER", "TYPE_MIDDLE", "definePath", "Landroid/graphics/Path;", "getDefinePath", "()Landroid/graphics/Path;", "setDefinePath", "(Landroid/graphics/Path;)V", "displayType", "getDisplayType", "()I", "setDisplayType", "(I)V", "radiusBottom", "getRadiusBottom", "setRadiusBottom", "radiusTop", "getRadiusTop", "setRadiusTop", "selfHeight", "getSelfHeight", "setSelfHeight", "selfWidth", "getSelfWidth", "setSelfWidth", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setType", "type", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: DetailSectionLinearLayout.kt */
public final class DetailSectionLinearLayout extends LinearLayout {

    /* renamed from: a */
    private int f31107a = 20;

    /* renamed from: b */
    private int f31108b = 10;

    /* renamed from: c */
    private Path f31109c = new Path();

    /* renamed from: d */
    private int f31110d;

    /* renamed from: e */
    private int f31111e;

    /* renamed from: f */
    private int f31112f;

    /* renamed from: g */
    private int f31113g = 1;

    /* renamed from: h */
    private int f31114h = 2;

    /* renamed from: i */
    private int f31115i = this.f31112f;

    public DetailSectionLinearLayout(Context context) {
        super(context);
    }

    public final int getRadiusTop() {
        return this.f31107a;
    }

    public final void setRadiusTop(int i) {
        this.f31107a = i;
    }

    public final int getRadiusBottom() {
        return this.f31108b;
    }

    public final void setRadiusBottom(int i) {
        this.f31108b = i;
    }

    public final Path getDefinePath() {
        return this.f31109c;
    }

    public final void setDefinePath(Path path) {
        Intrinsics.checkNotNullParameter(path, "<set-?>");
        this.f31109c = path;
    }

    public final int getSelfWidth() {
        return this.f31110d;
    }

    public final void setSelfWidth(int i) {
        this.f31110d = i;
    }

    public final int getSelfHeight() {
        return this.f31111e;
    }

    public final void setSelfHeight(int i) {
        this.f31111e = i;
    }

    public final int getDisplayType() {
        return this.f31115i;
    }

    public final void setDisplayType(int i) {
        this.f31115i = i;
    }

    public final void setType(int i) {
        this.f31115i = Math.abs(i % 3);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f31110d = getMeasuredWidth();
        this.f31111e = getMeasuredHeight();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int i = this.f31115i;
        if (i == this.f31112f) {
            this.f31109c.moveTo(0.0f, (float) this.f31107a);
            int i2 = this.f31107a;
            this.f31109c.addArc(new RectF(new Rect(0, 0, i2, i2)), 180.0f, 270.0f);
            this.f31109c.lineTo((float) (getMeasuredWidth() - this.f31107a), 0.0f);
            this.f31109c.addArc(new RectF(new Rect(getMeasuredWidth() - this.f31107a, 0, getMeasuredWidth(), this.f31107a)), 270.0f, 360.0f);
            this.f31109c.lineTo((float) getMeasuredWidth(), (float) (getMeasuredHeight() - this.f31108b));
            this.f31109c.addArc(new RectF(new Rect(getMeasuredWidth() - this.f31108b, getMeasuredHeight() - this.f31108b, getMeasuredWidth(), getMeasuredHeight())), 270.0f, 180.0f);
            this.f31109c.lineTo((float) this.f31108b, (float) getMeasuredHeight());
            int measuredHeight = getMeasuredHeight();
            int i3 = this.f31108b;
            this.f31109c.addArc(new RectF(new Rect(0, measuredHeight - i3, i3, getMeasuredHeight())), 360.0f, 270.0f);
            this.f31109c.close();
        } else if (i == this.f31113g) {
            this.f31109c.moveTo(0.0f, (float) this.f31107a);
            int i4 = this.f31107a;
            this.f31109c.addArc(new RectF(new Rect(0, 0, i4, i4)), 180.0f, 270.0f);
            this.f31109c.lineTo((float) (getMeasuredWidth() - this.f31107a), 0.0f);
            this.f31109c.addArc(new RectF(new Rect(getMeasuredWidth() - this.f31107a, 0, getMeasuredWidth(), this.f31107a)), 270.0f, 360.0f);
            this.f31109c.lineTo((float) getMeasuredWidth(), (float) (getMeasuredHeight() - this.f31108b));
            this.f31109c.addArc(new RectF(new Rect(getMeasuredWidth() - this.f31108b, getMeasuredHeight() - this.f31108b, getMeasuredWidth(), getMeasuredHeight())), 270.0f, 180.0f);
            this.f31109c.lineTo((float) this.f31108b, (float) getMeasuredHeight());
            int measuredHeight2 = getMeasuredHeight();
            int i5 = this.f31108b;
            this.f31109c.addArc(new RectF(new Rect(0, measuredHeight2 - i5, i5, getMeasuredHeight())), 360.0f, 270.0f);
            this.f31109c.close();
        }
        super.onDraw(canvas);
    }
}
