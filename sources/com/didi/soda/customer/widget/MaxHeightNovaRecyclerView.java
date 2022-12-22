package com.didi.soda.customer.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.didi.app.nova.support.view.recyclerview.view.NovaRecyclerView;
import com.didi.soda.customer.foundation.util.CustomerSystemUtil;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.foundation.util.UiUtil;
import com.taxis99.R;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B#\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0014J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\tH\u0002¨\u0006\u0011"}, mo175978d2 = {"Lcom/didi/soda/customer/widget/MaxHeightNovaRecyclerView;", "Lcom/didi/app/nova/support/view/recyclerview/view/NovaRecyclerView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onMeasure", "", "widthSpec", "heightSpec", "onMeasureHeight", "heightMeasureSpecOrigin", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: MaxHeightNovaRecyclerView.kt */
public final class MaxHeightNovaRecyclerView extends NovaRecyclerView {
    public void _$_clearFindViewByIdCache() {
    }

    public MaxHeightNovaRecyclerView(Context context) {
        super(context);
    }

    public MaxHeightNovaRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MaxHeightNovaRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, m29375a(i2));
    }

    /* renamed from: a */
    private final int m29375a(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int screenHeight = CustomerSystemUtil.getScreenHeight(getContext());
        int realScreenHeight = CustomerSystemUtil.getRealScreenHeight(getContext());
        int statusBarHeight = CustomerSystemUtil.getStatusBarHeight(getContext());
        int virtualBarHeight = UiUtil.getVirtualBarHeight(getContext());
        int dimensionPixelSize = realScreenHeight - ResourceHelper.getDimensionPixelSize(R.dimen.customer_282px);
        return View.MeasureSpec.makeMeasureSpec(virtualBarHeight + screenHeight == realScreenHeight ? virtualBarHeight == statusBarHeight ? dimensionPixelSize - statusBarHeight : (dimensionPixelSize - statusBarHeight) - virtualBarHeight : (dimensionPixelSize - statusBarHeight) - (realScreenHeight - screenHeight), mode);
    }
}
