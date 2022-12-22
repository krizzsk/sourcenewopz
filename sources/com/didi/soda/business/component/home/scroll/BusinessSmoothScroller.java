package com.didi.soda.business.component.home.scroll;

import androidx.recyclerview.widget.RecyclerView;
import com.didi.app.nova.support.view.recyclerview.view.layoutmanager.NovaLinearLayoutManager;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.widget.scroll.CustomerSmoothScroller;
import com.didi.soda.customer.widget.scroll.SmoothScrollListener;

public class BusinessSmoothScroller implements IScroller {

    /* renamed from: a */
    private static final String f39594a = "BusinessSmoothScroller";

    /* renamed from: b */
    private RecyclerView f39595b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public CustomerSmoothScroller f39596c;

    public BusinessSmoothScroller(RecyclerView recyclerView) {
        this.f39595b = recyclerView;
        CustomerSmoothScroller customerSmoothScroller = new CustomerSmoothScroller(this.f39595b.getContext());
        this.f39596c = customerSmoothScroller;
        customerSmoothScroller.setOrientation(1);
        ((NovaLinearLayoutManager) recyclerView.getLayoutManager()).setSmoothScroller(this.f39596c);
        this.f39596c.setOffset(SCROLL_OFFSET);
    }

    public void scrollToPosition(int i, final ScrollerFinishCallback scrollerFinishCallback) {
        LogUtil.m29104i(f39594a, "smooth scroll start");
        this.f39596c.setSmoothScrollListener(new SmoothScrollListener() {
            public /* synthetic */ void onStart() {
                SmoothScrollListener.CC.$default$onStart(this);
            }

            public void onStop() {
                LogUtil.m29104i(BusinessSmoothScroller.f39594a, "smooth scroll end");
                ScrollerFinishCallback scrollerFinishCallback = scrollerFinishCallback;
                if (scrollerFinishCallback != null) {
                    scrollerFinishCallback.onScrollFinished();
                }
                BusinessSmoothScroller.this.f39596c.setSmoothScrollListener((SmoothScrollListener) null);
            }
        });
        this.f39595b.smoothScrollToPosition(i);
    }
}
