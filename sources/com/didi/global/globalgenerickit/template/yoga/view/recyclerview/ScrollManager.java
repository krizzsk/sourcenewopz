package com.didi.global.globalgenerickit.template.yoga.view.recyclerview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.global.globalgenerickit.helper.KitHelper;
import com.didi.global.globalgenerickit.template.yoga.EventListener;
import java.util.ArrayList;

public class ScrollManager {

    /* renamed from: b */
    private static final String f22313b = "ScrollManager";

    /* renamed from: a */
    ArrayList<SubCardData> f22314a;

    /* renamed from: c */
    private XPanelHorizontalRecyclerView f22315c;

    /* renamed from: d */
    private LinearLayoutManager f22316d;

    /* renamed from: e */
    private int f22317e;

    /* renamed from: f */
    private int f22318f = 0;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public int f22319g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public int f22320h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public int f22321i = 0;

    /* renamed from: j */
    private Context f22322j;

    /* renamed from: k */
    private EventListener f22323k;

    public ScrollManager(XPanelHorizontalRecyclerView xPanelHorizontalRecyclerView, Context context, LinearLayoutManager linearLayoutManager) {
        this.f22315c = xPanelHorizontalRecyclerView;
        this.f22322j = context;
        this.f22316d = linearLayoutManager;
        this.f22314a = xPanelHorizontalRecyclerView.myRecylerAdapter.f22305a;
        this.f22317e = KitHelper.dip2px(context, 30.0f);
    }

    public void initScrollListener() {
        this.f22315c.addOnScrollListener(new GalleryScrollerListener());
    }

    public void setXCardListener(EventListener eventListener) {
        this.f22323k = eventListener;
    }

    class GalleryScrollerListener extends RecyclerView.OnScrollListener {
        GalleryScrollerListener() {
        }

        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
        }

        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            ScrollManager.this.checkScrollX();
        }
    }

    public void checkScrollX() {
        int findFirstVisibleItemPosition = this.f22316d.findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = this.f22316d.findLastVisibleItemPosition();
        try {
            int measuredWidth = this.f22315c.getMeasuredWidth();
            for (int i = 0; i < this.f22314a.size(); i++) {
                SubCardData subCardData = this.f22314a.get(i);
                if (i < findFirstVisibleItemPosition || i > findLastVisibleItemPosition) {
                    subCardData.moveOut();
                } else {
                    View childAt = this.f22316d.getChildAt(i - findFirstVisibleItemPosition);
                    int left = measuredWidth - childAt.getLeft();
                    if (childAt.getRight() < this.f22317e) {
                        if (left <= this.f22317e) {
                            subCardData.moveOut();
                        }
                    }
                    subCardData.moveIn();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void pauseStatus() {
        if (this.f22314a != null) {
            for (int i = 0; i < this.f22314a.size(); i++) {
                this.f22314a.get(i).moveOut();
            }
        }
    }

    /* renamed from: a */
    private void m16096a(final RecyclerView recyclerView, int i) {
        this.f22321i += i;
        if (this.f22319g == 0) {
            this.f22319g = recyclerView.getMeasuredWidth();
        }
        ((ViewGroup) recyclerView.getParent()).getMeasuredWidth();
        recyclerView.post(new Runnable() {
            public void run() {
                if (ScrollManager.this.f22320h == 0 && recyclerView.getLayoutManager().getChildCount() > 0) {
                    int unused = ScrollManager.this.f22320h = recyclerView.getLayoutManager().getChildAt(0).getMeasuredWidth();
                }
                if (ScrollManager.this.f22320h != 0) {
                    ScrollManager scrollManager = ScrollManager.this;
                    int a = scrollManager.m16092a(scrollManager.f22321i, ScrollManager.this.f22320h);
                    float a2 = ((float) ((ScrollManager.this.f22320h * a) - ScrollManager.this.f22321i)) / ((float) ScrollManager.this.f22320h);
                    float f = a2 < 0.0f ? 0.0f : a2;
                    int i = a + 1;
                    float a3 = ((float) ((ScrollManager.this.f22320h * i) - ScrollManager.this.f22321i)) / ((float) ScrollManager.this.f22320h);
                    float f2 = a3 > 1.0f ? 1.0f : a3;
                    float c = ((float) ((ScrollManager.this.f22319g + ScrollManager.this.f22321i) - (i * ScrollManager.this.f22320h))) / ((float) ScrollManager.this.f22320h);
                    AnimManager.getInstance().setAlpha(1.0f);
                    AnimManager.getInstance().setAnim(recyclerView, a, f, f2, c);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public int m16092a(int i, int i2) {
        return ((i + this.f22319g) / i2) - 1;
    }

    public int getPosition() {
        return this.f22318f;
    }
}
