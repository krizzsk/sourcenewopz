package com.didi.soda.business.component.home.scroll;

import android.view.ViewTreeObserver;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.soda.customer.foundation.log.util.LogUtil;

public class BusinessFastScroller implements IScroller {

    /* renamed from: a */
    private static final String f39589a = "BusinessFastScroller";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public RecyclerView f39590b;

    /* renamed from: c */
    private LinearLayoutManager f39591c;

    public BusinessFastScroller(RecyclerView recyclerView) {
        this.f39590b = recyclerView;
        this.f39591c = (LinearLayoutManager) recyclerView.getLayoutManager();
    }

    public void scrollToPosition(int i, final ScrollerFinishCallback scrollerFinishCallback) {
        LogUtil.m29104i(f39589a, "fast scroll start");
        this.f39591c.scrollToPositionWithOffset(i, SCROLL_OFFSET);
        this.f39590b.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                LogUtil.m29104i(BusinessFastScroller.f39589a, "fast scroll end");
                ScrollerFinishCallback scrollerFinishCallback = scrollerFinishCallback;
                if (scrollerFinishCallback != null) {
                    scrollerFinishCallback.onScrollFinished();
                }
                BusinessFastScroller.this.f39590b.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
    }
}
