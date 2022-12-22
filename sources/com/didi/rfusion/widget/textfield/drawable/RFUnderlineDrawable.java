package com.didi.rfusion.widget.textfield.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\u000e\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\fJ\u0010\u0010\u0018\u001a\u00020\u000e2\b\b\u0001\u0010\u0019\u001a\u00020\u0006J\u0018\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, mo175978d2 = {"Lcom/didi/rfusion/widget/textfield/drawable/RFUnderlineDrawable;", "Landroid/graphics/drawable/GradientDrawable;", "()V", "streamPaint", "Landroid/graphics/Paint;", "streamProgress", "", "streamRect", "Landroid/graphics/Rect;", "underlinePaint", "underlineRect", "underlineWidth", "", "completeStream", "", "draw", "canvas", "Landroid/graphics/Canvas;", "drawStream", "drawUnderline", "hasStream", "", "setStreamColor", "color", "setStreamProgress", "progress", "setStroke", "width", "r-fusion_ninePhoneRelease"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: RFUnderlineDrawable.kt */
public final class RFUnderlineDrawable extends GradientDrawable {

    /* renamed from: a */
    private final Paint f33920a = new Paint();

    /* renamed from: b */
    private final Paint f33921b = new Paint();

    /* renamed from: c */
    private final Rect f33922c = new Rect();

    /* renamed from: d */
    private final Rect f33923d = new Rect();

    /* renamed from: e */
    private int f33924e = 1;

    /* renamed from: f */
    private float f33925f;

    public void draw(Canvas canvas) {
        Intrinsics.checkParameterIsNotNull(canvas, "canvas");
        super.draw(canvas);
        m23935a(canvas);
        m23937b(canvas);
    }

    /* renamed from: a */
    private final void m23935a(Canvas canvas) {
        this.f33922c.set(getBounds());
        Rect rect = this.f33922c;
        rect.top = rect.bottom - this.f33924e;
        canvas.drawRect(this.f33922c, this.f33920a);
    }

    /* renamed from: b */
    private final void m23937b(Canvas canvas) {
        if (m23936a()) {
            this.f33923d.set(this.f33922c);
            int width = (int) (((float) this.f33922c.width()) * this.f33925f);
            this.f33923d.left = (this.f33922c.width() - width) / 2;
            Rect rect = this.f33923d;
            rect.right = rect.left + width;
            canvas.drawRect(this.f33923d, this.f33921b);
        }
    }

    /* renamed from: a */
    private final boolean m23936a() {
        return this.f33925f > 0.0f;
    }

    public void setStroke(int i, int i2) {
        this.f33924e = i;
        this.f33920a.setColor(i2);
        invalidateSelf();
    }

    public final void setStreamColor(int i) {
        this.f33921b.setColor(i);
        invalidateSelf();
    }

    public final void setStreamProgress(float f) {
        this.f33925f = f;
        invalidateSelf();
    }

    public final void completeStream() {
        this.f33925f = 0.0f;
        this.f33920a.setColor(this.f33921b.getColor());
    }
}
