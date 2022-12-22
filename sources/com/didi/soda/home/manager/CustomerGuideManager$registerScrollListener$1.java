package com.didi.soda.home.manager;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(mo175977d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t"}, mo175978d2 = {"com/didi/soda/home/manager/CustomerGuideManager$registerScrollListener$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CustomerGuideManager.kt */
public final class CustomerGuideManager$registerScrollListener$1 extends RecyclerView.OnScrollListener {
    final /* synthetic */ Context $ctx;
    final /* synthetic */ Ref.IntRef $totalScrollHeieght;
    final /* synthetic */ CustomerGuideManager this$0;

    CustomerGuideManager$registerScrollListener$1(Ref.IntRef intRef, Context context, CustomerGuideManager customerGuideManager) {
        this.$totalScrollHeieght = intRef;
        this.$ctx = context;
        this.this$0 = customerGuideManager;
    }

    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, i, i2);
        this.$totalScrollHeieght.element += i2;
        if (this.$totalScrollHeieght.element >= DisplayUtils.dip2px(this.$ctx, 150.0f)) {
            this.this$0.closeCustomerGuide();
        }
        LogUtil.m29100d(this.this$0.f42679c, "onScrolled------dy=" + i2 + "----totalScrollHeight=" + this.$totalScrollHeieght.element);
    }
}
