package com.didichuxing.xpanel.xcard.view.recyclerview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didichuxing.xpanel.util.Utils;
import com.didichuxing.xpanel.xcard.ICardListener;
import com.didichuxing.xpanel.xcard.XPanelCardDataHelper;
import java.util.ArrayList;
import java.util.HashMap;

public class ScrollManager {

    /* renamed from: b */
    private static final String f49710b = "ScrollManager";

    /* renamed from: a */
    ArrayList<SubCardData> f49711a;

    /* renamed from: c */
    private XPanelHorizontalRecyclerView f49712c;

    /* renamed from: d */
    private LinearLayoutManager f49713d;

    /* renamed from: e */
    private int f49714e;

    /* renamed from: f */
    private int f49715f = 0;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public int f49716g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public int f49717h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public int f49718i = 0;

    /* renamed from: j */
    private Context f49719j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public XPanelCardDataHelper f49720k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public ICardListener f49721l;

    public ScrollManager(XPanelHorizontalRecyclerView xPanelHorizontalRecyclerView, Context context, LinearLayoutManager linearLayoutManager) {
        this.f49712c = xPanelHorizontalRecyclerView;
        this.f49719j = context;
        this.f49713d = linearLayoutManager;
        this.f49711a = xPanelHorizontalRecyclerView.myRecylerAdapter.f49701a;
        this.f49714e = Utils.dip2px(context, 30.0f);
    }

    public void initScrollListener() {
        this.f49712c.addOnScrollListener(new GalleryScrollerListener());
    }

    public void setCardDataHelper(XPanelCardDataHelper xPanelCardDataHelper) {
        this.f49720k = xPanelCardDataHelper;
    }

    public void setXCardListener(ICardListener iCardListener) {
        this.f49721l = iCardListener;
    }

    class GalleryScrollerListener extends RecyclerView.OnScrollListener {
        GalleryScrollerListener() {
        }

        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i != 0) {
                return;
            }
            if (ScrollManager.this.f49720k != null) {
                ScrollManager.this.f49720k.scrollCardOmega();
            } else if (ScrollManager.this.f49721l != null) {
                ScrollManager.this.f49721l.handleEvent("xpanel_card_scroll", (HashMap<String, Object>) null);
            }
        }

        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            ScrollManager.this.checkScrollX();
        }
    }

    public void checkScrollX() {
        int findFirstVisibleItemPosition = this.f49713d.findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = this.f49713d.findLastVisibleItemPosition();
        try {
            int measuredWidth = this.f49712c.getMeasuredWidth();
            for (int i = 0; i < this.f49711a.size(); i++) {
                SubCardData subCardData = this.f49711a.get(i);
                if (i < findFirstVisibleItemPosition || i > findLastVisibleItemPosition) {
                    subCardData.moveOut();
                } else {
                    View childAt = this.f49713d.getChildAt(i - findFirstVisibleItemPosition);
                    int left = measuredWidth - childAt.getLeft();
                    if (childAt.getRight() < this.f49714e) {
                        if (left <= this.f49714e) {
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
        if (this.f49711a != null) {
            for (int i = 0; i < this.f49711a.size(); i++) {
                this.f49711a.get(i).moveOut();
            }
        }
    }

    /* renamed from: a */
    private void m35876a(final RecyclerView recyclerView, int i) {
        this.f49718i += i;
        if (this.f49716g == 0) {
            this.f49716g = recyclerView.getMeasuredWidth();
        }
        ((ViewGroup) recyclerView.getParent()).getMeasuredWidth();
        recyclerView.post(new Runnable() {
            public void run() {
                if (ScrollManager.this.f49717h == 0 && recyclerView.getLayoutManager().getChildCount() > 0) {
                    int unused = ScrollManager.this.f49717h = recyclerView.getLayoutManager().getChildAt(0).getMeasuredWidth();
                }
                if (ScrollManager.this.f49717h != 0) {
                    ScrollManager scrollManager = ScrollManager.this;
                    int a = scrollManager.m35872a(scrollManager.f49718i, ScrollManager.this.f49717h);
                    float c = ((float) ((ScrollManager.this.f49717h * a) - ScrollManager.this.f49718i)) / ((float) ScrollManager.this.f49717h);
                    float f = c < 0.0f ? 0.0f : c;
                    int i = a + 1;
                    float c2 = ((float) ((ScrollManager.this.f49717h * i) - ScrollManager.this.f49718i)) / ((float) ScrollManager.this.f49717h);
                    float f2 = c2 > 1.0f ? 1.0f : c2;
                    float e = ((float) ((ScrollManager.this.f49716g + ScrollManager.this.f49718i) - (i * ScrollManager.this.f49717h))) / ((float) ScrollManager.this.f49717h);
                    AnimManager.getInstance().setAlpha(1.0f);
                    AnimManager.getInstance().setAnim(recyclerView, a, f, f2, e);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public int m35872a(int i, int i2) {
        return ((i + this.f49716g) / i2) - 1;
    }

    public int getPosition() {
        return this.f49715f;
    }
}
