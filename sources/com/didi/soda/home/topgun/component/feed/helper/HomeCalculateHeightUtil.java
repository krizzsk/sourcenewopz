package com.didi.soda.home.topgun.component.feed.helper;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.util.LoginUtil;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.taxis99.R;

public final class HomeCalculateHeightUtil {

    /* renamed from: a */
    private static final String f42825a = "HomeCalculateHeightUtil";

    private HomeCalculateHeightUtil() {
    }

    public static int getLandingContentFullScreenOffset(RecyclerView recyclerView, int i, int i2) {
        if ((recyclerView.getAdapter() == null || recyclerView.getAdapter().getItemCount() <= 10) && (recyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
            int screenHeight = (DisplayUtils.getScreenHeight(recyclerView.getContext()) - i2) + i + DisplayUtils.dip2px(recyclerView.getContext(), 5.0f);
            int computeVerticalScrollRange = recyclerView.computeVerticalScrollRange();
            int i3 = 0;
            for (int i4 = 0; i4 < recyclerView.getChildCount(); i4++) {
                i3 += recyclerView.getChildAt(i4).getHeight();
            }
            int max = Math.max(computeVerticalScrollRange, i3);
            if (max < screenHeight) {
                return screenHeight - max;
            }
        }
        return 0;
    }

    public static int getContentFullScreenOffset(RecyclerView recyclerView, int i) {
        if ((recyclerView.getAdapter() == null || recyclerView.getAdapter().getItemCount() <= 10) && (recyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
            int screenHeight = (DisplayUtils.getScreenHeight(recyclerView.getContext()) - getTabBarHeight()) + i + DisplayUtils.dip2px(recyclerView.getContext(), 50.0f);
            int computeVerticalScrollRange = recyclerView.computeVerticalScrollRange();
            int i2 = 0;
            for (int i3 = 0; i3 < recyclerView.getChildCount(); i3++) {
                i2 += recyclerView.getChildAt(i3).getHeight();
            }
            if (Math.max(computeVerticalScrollRange, i2) < screenHeight) {
                int cartStubOffset = (screenHeight - computeVerticalScrollRange) + getCartStubOffset(recyclerView);
                return !LoginUtil.isLogin() ? cartStubOffset + DisplayUtils.dip2px(recyclerView.getContext(), 184.0f) : cartStubOffset;
            }
        }
        return 0;
    }

    public static int getFilterDataFullScreenOffset(RecyclerView recyclerView, int i, boolean z) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        int findLastVisibleItemPosition = layoutManager instanceof LinearLayoutManager ? ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition() : 0;
        int itemCount = layoutManager.getItemCount() - 1;
        View findViewByPosition = layoutManager.findViewByPosition(findLastVisibleItemPosition);
        LogUtil.m29104i(f42825a, findLastVisibleItemPosition + ">>>>>" + itemCount);
        if (findLastVisibleItemPosition == itemCount && findViewByPosition != null) {
            Rect rect = new Rect();
            findViewByPosition.getLocalVisibleRect(rect);
            LogUtil.m29104i(f42825a, i + " height:>>>>>" + rect.height());
            int height = rect.height();
            int dip2px = DisplayUtils.dip2px(recyclerView.getContext(), 64.0f);
            if (z && !LoginUtil.isLogin()) {
                dip2px = DisplayUtils.dip2px(recyclerView.getContext(), 50.0f);
            }
            int i2 = height - dip2px;
            int max = Math.max(i2, getCartStubOffset(recyclerView));
            if (i2 > 0) {
                return max;
            }
        }
        return 0;
    }

    public static int getTabBarHeight() {
        return ResourceHelper.getDimensionPixelSize(R.dimen.customer_tab_bar_height);
    }

    public static int getCartStubOffset(RecyclerView recyclerView) {
        return ResourceHelper.getDimensionPixelSize(R.dimen.customer_cart_stub_h);
    }
}
