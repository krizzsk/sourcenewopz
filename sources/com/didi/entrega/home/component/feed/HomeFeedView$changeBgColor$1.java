package com.didi.entrega.home.component.feed;

import android.animation.ArgbEvaluator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.app.nova.support.view.recyclerview.view.NovaRecyclerView;
import com.didi.entrega.customer.foundation.util.ResourceHelper;
import com.didi.map.setting.common.utils.DisplayUtil;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0005H\u0002J \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, mo175978d2 = {"com/didi/entrega/home/component/feed/HomeFeedView$changeBgColor$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "argbEvaluator", "Landroid/animation/ArgbEvaluator;", "defaultMaxOffset", "", "endColor", "", "startColor", "getBgColorByFraction", "fraction", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "dy", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: HomeFeedView.kt */
public final class HomeFeedView$changeBgColor$1 extends RecyclerView.OnScrollListener {
    private final ArgbEvaluator argbEvaluator = new ArgbEvaluator();
    private final float defaultMaxOffset = 400.0f;
    private int endColor = ResourceHelper.getColor(R.color.color_FFFFFF_60_alpha);
    private int startColor = ResourceHelper.getColor(R.color.rf_color_white_100_alpha_0);
    final /* synthetic */ HomeFeedView this$0;

    HomeFeedView$changeBgColor$1(HomeFeedView homeFeedView) {
        this.this$0 = homeFeedView;
    }

    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, i, i2);
        if (recyclerView.getLayoutManager() != null && (recyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager != null) {
                float f = 1.0f;
                if (((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition() == 0) {
                    f = Math.min(Math.max((((float) recyclerView.computeVerticalScrollOffset()) * 1.0f) / ((float) DisplayUtil.dp2px(this.this$0.getContext(), this.defaultMaxOffset)), 0.0f), 1.0f);
                }
                NovaRecyclerView access$getMRecycleView$p = this.this$0.f20653a;
                if (access$getMRecycleView$p == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRecycleView");
                    access$getMRecycleView$p = null;
                }
                access$getMRecycleView$p.setBackgroundColor(getBgColorByFraction(f));
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        }
    }

    private final int getBgColorByFraction(float f) {
        Object evaluate = this.argbEvaluator.evaluate(f, Integer.valueOf(this.startColor), Integer.valueOf(this.endColor));
        if (evaluate != null) {
            return ((Integer) evaluate).intValue();
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }
}
