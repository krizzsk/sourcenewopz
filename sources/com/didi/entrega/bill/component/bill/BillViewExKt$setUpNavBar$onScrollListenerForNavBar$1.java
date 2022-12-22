package com.didi.entrega.bill.component.bill;

import android.animation.ArgbEvaluator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.customer.foundation.util.ResourceHelper;
import com.didi.map.setting.common.utils.DisplayUtil;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0002J \u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, mo175978d2 = {"com/didi/entrega/bill/component/bill/BillViewExKt$setUpNavBar$onScrollListenerForNavBar$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "argbEvaluator", "Landroid/animation/ArgbEvaluator;", "endColor", "", "startColor", "getBgColorByFraction", "fraction", "", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "dy", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BillViewEx.kt */
public final class BillViewExKt$setUpNavBar$onScrollListenerForNavBar$1 extends RecyclerView.OnScrollListener {
    final /* synthetic */ BillView $this_setUpNavBar;
    private final ArgbEvaluator argbEvaluator = new ArgbEvaluator();
    private int endColor = ResourceHelper.getColor(R.color.rf_color_white_100_FFFFFF);
    private int startColor = ResourceHelper.getColor(R.color.rf_color_white_100_alpha_0);

    BillViewExKt$setUpNavBar$onScrollListenerForNavBar$1(BillView billView) {
        this.$this_setUpNavBar = billView;
    }

    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, i, i2);
        if (recyclerView.getLayoutManager() == null || !(recyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
            LogUtil.m14761d("setUpNavBar", "不是 LinearLayoutManager");
            return;
        }
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager != null) {
            float f = 1.0f;
            if (((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition() == 0) {
                f = Math.min(Math.max((((float) recyclerView.computeVerticalScrollOffset()) * 1.0f) / ((float) (DisplayUtil.dp2px(this.$this_setUpNavBar.getContext(), 230.0f) - (this.$this_setUpNavBar.getNavBarView().getHeight() + this.$this_setUpNavBar.getStatusBarView().getHeight()))), 0.0f), 1.0f);
            }
            int bgColorByFraction = getBgColorByFraction(f);
            this.$this_setUpNavBar.getNavBarView().setBackgroundColor(bgColorByFraction);
            this.$this_setUpNavBar.getStatusBarView().setBackgroundColor(bgColorByFraction);
            this.$this_setUpNavBar.getTitleView().setAlpha(f);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
    }

    private final int getBgColorByFraction(float f) {
        Object evaluate = this.argbEvaluator.evaluate(f, Integer.valueOf(this.startColor), Integer.valueOf(this.endColor));
        if (evaluate != null) {
            return ((Integer) evaluate).intValue();
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }
}
