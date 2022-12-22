package com.didiglobal.p205sa.biz.tab.p206ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.global.globaluikit.utils.UiUtils;
import com.didi.passenger.C10448R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0012\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0014J\u0010\u0010'\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0002J\b\u0010(\u001a\u00020$H\u0002J \u0010(\u001a\u00020$2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010)\u001a\u0004\u0018\u00010\u00062\u0006\u0010*\u001a\u00020\tJ\u0010\u0010+\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0014J0\u0010,\u001a\u00020$2\u0006\u0010-\u001a\u00020\u00182\u0006\u0010.\u001a\u00020\t2\u0006\u0010/\u001a\u00020\t2\u0006\u00100\u001a\u00020\t2\u0006\u00101\u001a\u00020\tH\u0014J\u0018\u00102\u001a\u00020$2\u0006\u00103\u001a\u00020\t2\u0006\u00104\u001a\u00020\tH\u0014R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0011\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\u0013\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u000e\u0010\u0015\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000¨\u00065"}, mo175978d2 = {"Lcom/didiglobal/sa/biz/tab/ui/SaTabContainer;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "def", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "SHADOW_DEFAULT_BLUR_RADIUS", "", "getSHADOW_DEFAULT_BLUR_RADIUS", "()F", "SHADOW_DEFAULT_RADIUS", "getSHADOW_DEFAULT_RADIUS", "SHADOW_MAX_BLUR", "getSHADOW_MAX_BLUR", "SHADOW_MAX_OFFSET", "getSHADOW_MAX_OFFSET", "bgColor", "blurRadius", "hasEffect", "", "locationPaint", "Landroid/graphics/Paint;", "mHeightMode", "mPaint", "mWidthMode", "shadowColor", "shadowRadius", "shadowType", "xOffset", "yOffset", "dispatchDraw", "", "canvas", "Landroid/graphics/Canvas;", "drawBackground", "init", "attrs", "defStyleAttr", "onDraw", "onLayout", "changed", "l", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "biz-library_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didiglobal.sa.biz.tab.ui.SaTabContainer */
/* compiled from: SaTabContainer.kt */
public final class SaTabContainer extends ConstraintLayout {

    /* renamed from: a */
    private final float f51246a = ((float) UiUtils.dip2px(getContext(), 5.0f));

    /* renamed from: b */
    private final float f51247b = ((float) UiUtils.dip2px(getContext(), 20.0f));

    /* renamed from: c */
    private final float f51248c = ((float) UiUtils.dip2px(getContext(), 20.0f));

    /* renamed from: d */
    private final float f51249d = ((float) UiUtils.dip2px(getContext(), 5.0f));

    /* renamed from: e */
    private int f51250e = Color.parseColor("#333333");

    /* renamed from: f */
    private final int f51251f;

    /* renamed from: g */
    private float f51252g;

    /* renamed from: h */
    private float f51253h = this.f51249d;

    /* renamed from: i */
    private float f51254i = ((float) UiUtils.dip2px(getContext(), 10.0f));

    /* renamed from: j */
    private float f51255j = ((float) UiUtils.dip2px(getContext(), 10.0f));

    /* renamed from: k */
    private int f51256k = -1;

    /* renamed from: l */
    private boolean f51257l;

    /* renamed from: m */
    private float f51258m;

    /* renamed from: n */
    private float f51259n;

    /* renamed from: o */
    private final Paint f51260o = new Paint();

    /* renamed from: p */
    private final Paint f51261p = new Paint();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SaTabContainer(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        init(context, (AttributeSet) null, 0);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SaTabContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attributeSet");
        init(context, attributeSet, 0);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SaTabContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attributeSet");
        init(context, attributeSet, 0);
    }

    public final float getSHADOW_DEFAULT_RADIUS() {
        return this.f51246a;
    }

    public final float getSHADOW_MAX_OFFSET() {
        return this.f51247b;
    }

    public final float getSHADOW_MAX_BLUR() {
        return this.f51248c;
    }

    public final float getSHADOW_DEFAULT_BLUR_RADIUS() {
        return this.f51249d;
    }

    public final void init(Context context, AttributeSet attributeSet, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        setLayerType(1, (Paint) null);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.SaTabContainer);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…styleable.SaTabContainer)");
        this.f51250e = obtainStyledAttributes.getColor(3, -16776961);
        this.f51253h = obtainStyledAttributes.getDimension(1, this.f51249d);
        this.f51252g = obtainStyledAttributes.getDimension(4, 0.0f);
        this.f51257l = obtainStyledAttributes.getBoolean(2, false);
        this.f51254i = obtainStyledAttributes.getDimension(5, (float) UiUtils.dip2px(context, 10.0f));
        this.f51255j = obtainStyledAttributes.getDimension(6, (float) UiUtils.dip2px(context, 10.0f));
        this.f51256k = obtainStyledAttributes.getColor(0, -1);
        obtainStyledAttributes.recycle();
        float f = this.f51252g;
        if (f < 0.0f) {
            this.f51252g = -f;
        }
        float f2 = this.f51253h;
        if (f2 < 0.0f) {
            this.f51253h = -f2;
        }
        this.f51253h = Math.min(this.f51248c, this.f51253h);
        if (Math.abs(this.f51254i) > this.f51247b) {
            float f3 = this.f51254i;
            this.f51254i = (f3 / Math.abs(f3)) * this.f51247b;
        }
        if (Math.abs(this.f51255j) > this.f51247b) {
            float f4 = this.f51255j;
            this.f51255j = (f4 / Math.abs(f4)) * this.f51247b;
        }
        m36705a();
    }

    /* renamed from: a */
    private final void m36705a() {
        float f = this.f51254i;
        boolean z = true;
        if (f > 0.0f) {
            setRight((int) (this.f51253h + Math.abs(f)));
        } else {
            if (f == 0.0f) {
                setLeft(0);
                setRight(0);
            } else {
                setLeft((int) (this.f51253h + Math.abs(this.f51254i)));
            }
        }
        float f2 = this.f51255j;
        if (f2 > 0.0f) {
            setBottom((int) Math.abs(f2));
        } else {
            if (f2 != 0.0f) {
                z = false;
            }
            if (z) {
                setTop((int) this.f51253h);
                setBottom((int) this.f51253h);
            } else {
                setTop((int) Math.abs(this.f51255j));
            }
        }
        setPadding(getLeft(), getTop(), getRight(), getBottom());
        setBackgroundColor(this.f51256k);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        m36706a(canvas);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    /* renamed from: a */
    private final void m36706a(Canvas canvas) {
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        this.f51258m = (float) getMeasuredWidth();
        this.f51259n = (float) getMeasuredHeight();
        boolean z = false;
        if (this.f51254i == 0.0f) {
            f3 = (float) getRight();
            f2 = this.f51258m;
            f = this.f51253h;
        } else {
            f3 = ((float) getRight()) + this.f51253h;
            f2 = this.f51258m - ((float) getLeft());
            f = this.f51253h;
        }
        float f7 = f2 - f;
        if (this.f51255j == 0.0f) {
            f6 = (float) getBottom();
            f5 = this.f51259n;
            f4 = this.f51253h;
        } else {
            f6 = ((float) getBottom()) + this.f51253h;
            f5 = this.f51259n - ((float) getTop());
            f4 = this.f51253h;
        }
        float f8 = f5 - f4;
        if (this.f51253h > 0.0f) {
            this.f51260o.setMaskFilter(new BlurMaskFilter(this.f51253h, BlurMaskFilter.Blur.NORMAL));
        }
        this.f51260o.setColor(this.f51250e);
        this.f51260o.setAntiAlias(true);
        RectF rectF = new RectF(f3, f6, f7, f8);
        RectF rectF2 = new RectF((float) getLeft(), (float) getTop(), this.f51258m - ((float) getRight()), this.f51259n - ((float) getBottom()));
        if (this.f51252g == 0.0f) {
            canvas.drawRect(rectF, this.f51260o);
        } else {
            float f9 = this.f51252g;
            canvas.drawRoundRect(rectF, f9, f9, this.f51260o);
        }
        this.f51261p.setColor(this.f51256k);
        this.f51261p.setAntiAlias(true);
        if (this.f51252g == 0.0f) {
            z = true;
        }
        if (z) {
            canvas.drawRect(rectF2, this.f51261p);
            return;
        }
        float f10 = this.f51252g;
        canvas.drawRoundRect(rectF2, f10, f10, this.f51261p);
    }
}
