package com.didi.soda.home.topgun.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.widget.support.CustomerAppCompatTextView;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\r\u001a\u00020\u000eH\u0002J\u0012\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014J\u000e\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\tR\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000¨\u0006\u0014"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/widget/MidLineTextView;", "Lcom/didi/soda/customer/widget/support/CustomerAppCompatTextView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mPaint", "Landroid/graphics/Paint;", "initPaint", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "setLineColor", "lineColor", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: MidLineTextView.kt */
public final class MidLineTextView extends CustomerAppCompatTextView {

    /* renamed from: a */
    private Paint f43188a;

    public void _$_clearFindViewByIdCache() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MidLineTextView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        m30541a();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MidLineTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        m30541a();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MidLineTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        m30541a();
    }

    /* renamed from: a */
    private final void m30541a() {
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(ResourceHelper.getColor(R.color.rf_color_background_1_100));
        Unit unit = Unit.INSTANCE;
        this.f43188a = paint;
    }

    public final void setLineColor(int i) {
        Paint paint = this.f43188a;
        if (paint == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPaint");
            paint = null;
        }
        paint.setColor(i);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (canvas != null) {
            float measuredHeight = (float) ((getMeasuredHeight() / 2) - 1);
            float measuredWidth = (float) getMeasuredWidth();
            float measuredHeight2 = (float) ((getMeasuredHeight() / 2) + 1);
            Paint paint = this.f43188a;
            if (paint == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPaint");
                paint = null;
            }
            canvas.drawRect(0.0f, measuredHeight, measuredWidth, measuredHeight2, paint);
        }
        super.onDraw(canvas);
    }
}
