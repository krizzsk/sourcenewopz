package com.didi.soda.customer.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.raven.config.RavenKey;
import com.didi.soda.customer.foundation.util.CustomerSystemUtil;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\tH\u0014R\u000e\u0010\u000b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, mo175978d2 = {"Lcom/didi/soda/customer/widget/CustomerCartDiscountParentView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "actionBarHeight", "actionBarStyle", "", "getActionBarStyle", "()Z", "setActionBarStyle", "(Z)V", "minHorizontalPadding", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CustomerCartDiscountParentView.kt */
public final class CustomerCartDiscountParentView extends LinearLayout {

    /* renamed from: a */
    private boolean f41452a;

    /* renamed from: b */
    private final int f41453b = ResourceHelper.getDimensionPixelSize(R.dimen.customer_112px);

    /* renamed from: c */
    private final int f41454c = ResourceHelper.getDimensionPixelSize(R.dimen.customer_120px);

    public void _$_clearFindViewByIdCache() {
    }

    public final boolean getActionBarStyle() {
        return this.f41452a;
    }

    public final void setActionBarStyle(boolean z) {
        this.f41452a = z;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomerCartDiscountParentView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomerCartDiscountParentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, RavenKey.ATTRS);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomerCartDiscountParentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, RavenKey.ATTRS);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        super.onMeasure(i, i2);
        if (this.f41452a) {
            int childCount = getChildCount();
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            if (childCount > 0) {
                int i7 = 0;
                while (true) {
                    int i8 = i4 + 1;
                    View childAt = getChildAt(i4);
                    i5 = Math.max(childAt.getMeasuredHeight(), i5);
                    i6 += childAt.getMeasuredWidth();
                    if (childAt instanceof TextView) {
                        i7 = ((TextView) childAt).getLineCount();
                    }
                    if (i8 >= childCount) {
                        break;
                    }
                    i4 = i8;
                }
                i4 = i7;
            }
            if (i4 == 2) {
                i3 = this.f41454c;
            } else {
                i3 = (CustomerSystemUtil.getScreenWidth(getContext()) - i6) / 2;
            }
            int max = Math.max(this.f41454c, i3);
            int i9 = (this.f41453b - i5) / 2;
            setPadding(max, i9, max, i9);
        }
    }
}
