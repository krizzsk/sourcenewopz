package com.didiglobal.dittoview.view.recyclerview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didiglobal.dittoview.DittoEventListener;
import com.didiglobal.dittoview.util.DittoUtil;
import java.util.ArrayList;

public class ScrollManager {

    /* renamed from: b */
    private static final String f50003b = "ScrollManager";

    /* renamed from: a */
    ArrayList<SubCardData> f50004a;

    /* renamed from: c */
    private DittoRecyclerView f50005c;

    /* renamed from: d */
    private LinearLayoutManager f50006d;

    /* renamed from: e */
    private int f50007e;

    /* renamed from: f */
    private int f50008f = 0;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public int f50009g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public int f50010h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public int f50011i = 0;

    /* renamed from: j */
    private Context f50012j;

    /* renamed from: k */
    private DittoEventListener f50013k;

    public ScrollManager(DittoRecyclerView dittoRecyclerView, Context context, LinearLayoutManager linearLayoutManager) {
        this.f50005c = dittoRecyclerView;
        this.f50012j = context;
        this.f50006d = linearLayoutManager;
        this.f50004a = dittoRecyclerView.dittoRecyclerAdapter.f49994a;
        this.f50007e = DittoUtil.dip2px(context, 30.0f);
    }

    public void initScrollListener() {
        this.f50005c.addOnScrollListener(new GalleryScrollerListener());
    }

    public void setXCardListener(DittoEventListener dittoEventListener) {
        this.f50013k = dittoEventListener;
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
        int findFirstVisibleItemPosition = this.f50006d.findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = this.f50006d.findLastVisibleItemPosition();
        try {
            int measuredWidth = this.f50005c.getMeasuredWidth();
            for (int i = 0; i < this.f50004a.size(); i++) {
                SubCardData subCardData = this.f50004a.get(i);
                if (i < findFirstVisibleItemPosition || i > findLastVisibleItemPosition) {
                    subCardData.moveOut();
                } else {
                    View childAt = this.f50006d.getChildAt(i - findFirstVisibleItemPosition);
                    int left = measuredWidth - childAt.getLeft();
                    if (childAt.getRight() < this.f50007e) {
                        if (left <= this.f50007e) {
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
        if (this.f50004a != null) {
            for (int i = 0; i < this.f50004a.size(); i++) {
                this.f50004a.get(i).moveOut();
            }
        }
    }

    /* renamed from: a */
    private void m36017a(final RecyclerView recyclerView, int i) {
        this.f50011i += i;
        if (this.f50009g == 0) {
            this.f50009g = recyclerView.getMeasuredWidth();
        }
        ((ViewGroup) recyclerView.getParent()).getMeasuredWidth();
        recyclerView.post(new Runnable() {
            public void run() {
                if (ScrollManager.this.f50010h == 0 && recyclerView.getLayoutManager().getChildCount() > 0) {
                    int unused = ScrollManager.this.f50010h = recyclerView.getLayoutManager().getChildAt(0).getMeasuredWidth();
                }
                if (ScrollManager.this.f50010h != 0) {
                    ScrollManager scrollManager = ScrollManager.this;
                    int a = scrollManager.m36013a(scrollManager.f50011i, ScrollManager.this.f50010h);
                    float a2 = ((float) ((ScrollManager.this.f50010h * a) - ScrollManager.this.f50011i)) / ((float) ScrollManager.this.f50010h);
                    float f = a2 < 0.0f ? 0.0f : a2;
                    int i = a + 1;
                    float a3 = ((float) ((ScrollManager.this.f50010h * i) - ScrollManager.this.f50011i)) / ((float) ScrollManager.this.f50010h);
                    float f2 = a3 > 1.0f ? 1.0f : a3;
                    float c = ((float) ((ScrollManager.this.f50009g + ScrollManager.this.f50011i) - (i * ScrollManager.this.f50010h))) / ((float) ScrollManager.this.f50010h);
                    AnimManager.getInstance().setAlpha(1.0f);
                    AnimManager.getInstance().setAnim(recyclerView, a, f, f2, c);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public int m36013a(int i, int i2) {
        return ((i + this.f50009g) / i2) - 1;
    }

    public int getPosition() {
        return this.f50008f;
    }
}
