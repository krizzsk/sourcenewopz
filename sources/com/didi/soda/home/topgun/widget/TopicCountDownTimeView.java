package com.didi.soda.home.topgun.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.didi.soda.customer.widget.support.CustomerAppCompatTextView;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0014J\u0018\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0014J\u0016\u0010\u0017\u001a\u00020\u00102\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rR\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/widget/TopicCountDownTimeView;", "Lcom/didi/soda/customer/widget/support/CustomerAppCompatTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "linePaint", "Landroid/graphics/Paint;", "mRadius", "", "numWidth", "timeList", "", "", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "", "heightMeasureSpec", "setData", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: TopicCountDownTimeView.kt */
public final class TopicCountDownTimeView extends CustomerAppCompatTextView {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final float LINE_H_PADDING = 9.0f;
    public static final float LINE_V_PADDING = 9.0f;
    public static final float LINE_WIDTH = 2.0f;

    /* renamed from: a */
    private List<String> f43189a;

    /* renamed from: b */
    private float f43190b;

    /* renamed from: c */
    private final Paint f43191c;

    /* renamed from: d */
    private final float f43192d = 2.0f;

    public void _$_clearFindViewByIdCache() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TopicCountDownTimeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Paint paint = new Paint();
        this.f43191c = paint;
        paint.setAntiAlias(true);
        this.f43191c.setColor(872415231);
    }

    public final void setData(List<String> list) {
        this.f43189a = list;
        requestLayout();
        invalidate();
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/widget/TopicCountDownTimeView$Companion;", "", "()V", "LINE_H_PADDING", "", "LINE_V_PADDING", "LINE_WIDTH", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: TopicCountDownTimeView.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        Unit unit;
        List<String> list = this.f43189a;
        if (list == null) {
            unit = null;
        } else {
            this.f43190b = getPaint().measureText("0");
            int i3 = 0;
            for (String length : list) {
                i3 += length.length();
            }
            super.onMeasure(View.MeasureSpec.makeMeasureSpec((int) ((this.f43190b * ((float) i3)) + (((float) (list.size() - 1)) * 20.0f)), 1073741824), i2);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            super.onMeasure(i, i2);
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        List<String> list;
        super.onDraw(canvas);
        int measuredHeight = getMeasuredHeight();
        if (canvas != null && (list = this.f43189a) != null) {
            int i = 0;
            float f = 0.0f;
            for (Object next : list) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                String str = (String) next;
                if (i != 0) {
                    float f2 = f + 9.0f;
                    float f3 = this.f43192d;
                    canvas.drawRoundRect(f2, 9.0f, f2 + 2.0f, ((float) measuredHeight) - 9.0f, f3, f3, this.f43191c);
                    f += 20.0f;
                }
                canvas.drawText(str, f, ((float) measuredHeight) - ((float) getPaint().getFontMetricsInt().descent), getPaint());
                f += this.f43190b * ((float) str.length());
                i = i2;
            }
        }
    }
}
