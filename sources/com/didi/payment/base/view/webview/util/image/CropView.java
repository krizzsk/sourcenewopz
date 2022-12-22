package com.didi.payment.base.view.webview.util.image;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0012\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0014R\u0014\u0010\u000b\u001a\u00020\tXD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\r\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\r\"\u0004\b\u001a\u0010\u0011¨\u0006\u001f"}, mo175978d2 = {"Lcom/didi/payment/base/view/webview/util/image/CropView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "BORDERDISTANCE", "getBORDERDISTANCE", "()I", "heightScale", "getHeightScale", "setHeightScale", "(I)V", "mPaint", "Landroid/graphics/Paint;", "getMPaint", "()Landroid/graphics/Paint;", "setMPaint", "(Landroid/graphics/Paint;)V", "widthScale", "getWidthScale", "setWidthScale", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "base_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CropView.kt */
public final class CropView extends View {

    /* renamed from: a */
    private final int f30089a;

    /* renamed from: b */
    private Paint f30090b;

    /* renamed from: c */
    private int f30091c;

    /* renamed from: d */
    private int f30092d;

    public final int getBORDERDISTANCE() {
        return this.f30089a;
    }

    public final Paint getMPaint() {
        return this.f30090b;
    }

    public final void setMPaint(Paint paint) {
        this.f30090b = paint;
    }

    public final int getWidthScale() {
        return this.f30091c;
    }

    public final void setWidthScale(int i) {
        this.f30091c = i;
    }

    public final int getHeightScale() {
        return this.f30092d;
    }

    public final void setHeightScale(int i) {
        this.f30092d = i;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CropView(Context context) {
        this(context, (AttributeSet) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CropView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CropView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f30089a = 50;
        this.f30090b = new Paint();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = ((getWidth() - 100) * this.f30092d) / this.f30091c;
        Paint paint = this.f30090b;
        if (paint != null) {
            paint.setColor(-1442840576);
        }
        if (canvas != null) {
            float width2 = (float) getWidth();
            float height = (float) ((getHeight() - width) / 2);
            Paint paint2 = this.f30090b;
            Intrinsics.checkNotNull(paint2);
            canvas.drawRect(0.0f, 0.0f, width2, height, paint2);
        }
        if (canvas != null) {
            float height2 = (float) ((getHeight() + width) / 2);
            float width3 = (float) getWidth();
            float height3 = (float) getHeight();
            Paint paint3 = this.f30090b;
            Intrinsics.checkNotNull(paint3);
            canvas.drawRect(0.0f, height2, width3, height3, paint3);
        }
        if (canvas != null) {
            float height4 = (float) ((getHeight() - width) / 2);
            float height5 = (float) ((getHeight() + width) / 2);
            Paint paint4 = this.f30090b;
            Intrinsics.checkNotNull(paint4);
            canvas.drawRect(0.0f, height4, 50.0f, height5, paint4);
        }
        if (canvas != null) {
            float width4 = (float) (getWidth() - 50);
            float height6 = (float) ((getHeight() - width) / 2);
            float width5 = (float) getWidth();
            float height7 = (float) ((getHeight() + width) / 2);
            Paint paint5 = this.f30090b;
            Intrinsics.checkNotNull(paint5);
            canvas.drawRect(width4, height6, width5, height7, paint5);
        }
        Paint paint6 = this.f30090b;
        if (paint6 != null) {
            paint6.setColor(-1);
        }
        Paint paint7 = this.f30090b;
        if (paint7 != null) {
            paint7.setStrokeWidth(2.0f);
        }
        if (canvas != null) {
            float height8 = (float) ((getHeight() - width) / 2);
            float width6 = (float) (getWidth() - 50);
            float height9 = (float) ((getHeight() - width) / 2);
            Paint paint8 = this.f30090b;
            Intrinsics.checkNotNull(paint8);
            canvas.drawLine(50.0f, height8, width6, height9, paint8);
        }
        if (canvas != null) {
            float height10 = (float) ((getHeight() + width) / 2);
            float width7 = (float) (getWidth() - 50);
            float height11 = (float) ((getHeight() + width) / 2);
            Paint paint9 = this.f30090b;
            Intrinsics.checkNotNull(paint9);
            canvas.drawLine(50.0f, height10, width7, height11, paint9);
        }
        if (canvas != null) {
            float height12 = (float) ((getHeight() - width) / 2);
            float height13 = (float) ((getHeight() + width) / 2);
            Paint paint10 = this.f30090b;
            Intrinsics.checkNotNull(paint10);
            canvas.drawLine(50.0f, height12, 50.0f, height13, paint10);
        }
        if (canvas != null) {
            float width8 = (float) (getWidth() - 50);
            float height14 = (float) ((getHeight() - width) / 2);
            float width9 = (float) (getWidth() - 50);
            float height15 = (float) ((getHeight() + width) / 2);
            Paint paint11 = this.f30090b;
            Intrinsics.checkNotNull(paint11);
            canvas.drawLine(width8, height14, width9, height15, paint11);
        }
    }
}
