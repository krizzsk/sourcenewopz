package com.didi.soda.business.component.home;

import androidx.recyclerview.widget.RecyclerView;
import com.didi.app.nova.support.view.recyclerview.view.NovaRecyclerView;
import com.didi.app.nova.support.view.recyclerview.view.layoutmanager.NovaLinearLayoutManager;
import com.didi.soda.business.component.home.scroll.BusinessScrollerFactory;
import com.didi.soda.business.component.home.scroll.ScrollerFinishCallback;
import com.didi.soda.business.listener.BusinessViewBehaviorImpl;
import com.didi.soda.business.model.BusinessCategoryRvModel;
import didinet.Logger;
import java.util.Map;

public class BusinessScrollManager {

    /* renamed from: a */
    private static final String f39569a = "BusinessScrollManager";

    /* renamed from: b */
    private NovaRecyclerView f39570b;

    /* renamed from: c */
    private BusinessViewBehaviorImpl f39571c;

    /* renamed from: d */
    private NovaLinearLayoutManager f39572d;

    /* renamed from: e */
    private Map<String, BusinessCategoryRvModel> f39573e;

    /* renamed from: f */
    private int f39574f = 0;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public boolean f39575g = false;

    /* renamed from: h */
    private BusinessScrollerFactory f39576h = new BusinessScrollerFactory();

    public BusinessScrollManager(NovaRecyclerView novaRecyclerView) {
        this.f39570b = novaRecyclerView;
        this.f39572d = (NovaLinearLayoutManager) novaRecyclerView.getLayoutManager();
        this.f39570b.addOnScrollListener(new RecyclerView.OnScrollListener() {
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                if (i == 0) {
                    boolean unused = BusinessScrollManager.this.f39575g = false;
                }
            }

            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                if (!BusinessScrollManager.this.f39575g) {
                    BusinessScrollManager.this.m28145b();
                }
            }
        });
    }

    public void onTabSelected(int i) {
        if (i != this.f39574f) {
            m28141a(m28140a().getCategoryRvIndex(i), m28140a().getCategoryRvIndex(this.f39574f), (ScrollerFinishCallback) null);
            this.f39574f = i;
        }
    }

    public void scrollToAnchorView(int i, int i2, ScrollerFinishCallback scrollerFinishCallback) {
        m28142a("scrollToAnchorView cateIndex: " + i + ", position " + i2);
        m28141a(i2, 0, scrollerFinishCallback);
        this.f39574f = i;
    }

    public void setBusinessViewBehaviorImpl(BusinessViewBehaviorImpl businessViewBehaviorImpl) {
        this.f39571c = businessViewBehaviorImpl;
    }

    public void updateCategoryMap(Map<String, BusinessCategoryRvModel> map) {
        this.f39573e = map;
    }

    /* renamed from: a */
    private BusinessViewBehaviorImpl m28140a() {
        return this.f39571c;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m28145b() {
        int a = m28139a(this.f39572d.findFirstVisibleItemPosition());
        m28142a("current tab index: " + a + " is Scrolling:" + this.f39575g);
        if (this.f39574f != a && !this.f39575g) {
            m28140a().selectTab(a);
            this.f39574f = a;
        }
    }

    /* renamed from: a */
    private void m28141a(int i, int i2, ScrollerFinishCallback scrollerFinishCallback) {
        this.f39575g = true;
        m28142a("target pos: " + i);
        this.f39576h.getBusinessScroller(this.f39570b, Math.abs(i - i2)).scrollToPosition(i, scrollerFinishCallback);
    }

    /* renamed from: a */
    private int m28139a(int i) {
        Map<String, BusinessCategoryRvModel> map = this.f39573e;
        int i2 = 0;
        if (map != null && map.size() > 0) {
            int i3 = 0;
            for (BusinessCategoryRvModel next : this.f39573e.values()) {
                int size = next.getAllDisplayGoods().size() + next.getAllDyDisplayGoods().size();
                if (i2 != 0) {
                    size++;
                }
                if (next.mExpandRvModel != null) {
                    size++;
                }
                int i4 = (i3 + size) - 1;
                if (i - 1 <= i4) {
                    break;
                }
                i3 = i4 + 1;
                i2++;
            }
        }
        return i2;
    }

    /* renamed from: a */
    private void m28142a(String str) {
        Logger.m40928d(f39569a, str);
    }
}
