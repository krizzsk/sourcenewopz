package com.didi.sdk.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.didi.sdk.apm.SystemUtils;

public class PinnedHeaderListView extends ListView {

    /* renamed from: a */
    private static final int f37856a = 255;

    /* renamed from: b */
    private PinnedHeaderAdapter f37857b;

    /* renamed from: c */
    private View f37858c;

    /* renamed from: d */
    private boolean f37859d;

    /* renamed from: e */
    private int f37860e;

    /* renamed from: f */
    private int f37861f;

    /* renamed from: g */
    private int f37862g;

    /* renamed from: h */
    private int f37863h;

    /* renamed from: i */
    private boolean f37864i;

    public interface PinnedHeaderAdapter {
        public static final int PINNED_HEADER_GONE = 0;
        public static final int PINNED_HEADER_PUSHED_UP = 2;
        public static final int PINNED_HEADER_VISIBLE = 1;

        public interface ScrollStateChangeListener {
            void onScroll(AbsListView absListView, int i, int i2, int i3);

            void onScrollStateChanged(AbsListView absListView, int i);
        }

        void configurePinnedHeader(View view, int i, int i2);

        int getPinnedHeaderState(int i);
    }

    public PinnedHeaderListView(Context context) {
        super(context);
    }

    public PinnedHeaderListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOverScrollMode(2);
    }

    public PinnedHeaderListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setPinnedHeaderView(View view) {
        this.f37858c = view;
        if (view != null) {
            setFadingEdgeLength(0);
        }
        requestLayout();
    }

    public void setAdapter(ListAdapter listAdapter, boolean z) {
        super.setAdapter(listAdapter);
        this.f37864i = z;
        if (z) {
            this.f37857b = (PinnedHeaderAdapter) listAdapter;
        }
        setOnScrollListener((AbsListView.OnScrollListener) this.f37857b);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        View view = this.f37858c;
        if (view != null) {
            measureChild(view, i, i2);
            this.f37860e = this.f37858c.getMeasuredWidth();
            this.f37861f = this.f37858c.getMeasuredHeight();
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View view;
        super.onLayout(z, i, i2, i3, i4);
        if (this.f37864i && (view = this.f37858c) != null) {
            view.layout(0, 0, this.f37860e, this.f37861f);
            configureHeaderView(getFirstVisiblePosition());
        }
    }

    public void configureHeaderView(int i) {
        if (this.f37864i && this.f37858c != null && this.f37857b != null && getChildCount() != 0 && getCount() != i + 1) {
            int i2 = this.f37862g;
            int i3 = this.f37863h;
            this.f37863h = i;
            int pinnedHeaderState = this.f37857b.getPinnedHeaderState(i);
            this.f37862g = pinnedHeaderState;
            if (pinnedHeaderState == 0) {
                this.f37859d = false;
            } else if (pinnedHeaderState == 1) {
                if (this.f37858c.getTop() != 0) {
                    this.f37858c.layout(0, 0, this.f37860e, this.f37861f);
                }
                this.f37857b.configurePinnedHeader(this.f37858c, i, 255);
                this.f37858c.invalidate();
                if (!this.f37859d) {
                    this.f37858c.invalidate();
                }
                this.f37859d = true;
            } else if (pinnedHeaderState == 2) {
                if (pinnedHeaderState != i2) {
                    this.f37857b.configurePinnedHeader(this.f37858c, i, 255);
                } else if (i3 != this.f37863h) {
                    this.f37857b.configurePinnedHeader(this.f37858c, i, 255);
                    this.f37858c.invalidate();
                    SystemUtils.log(3, "chenyi", "pushe up  oldPosition != mFirstPositionchagen group...", (Throwable) null, "com.didi.sdk.view.PinnedHeaderListView", 141);
                }
                int bottom = getChildAt(0).getBottom();
                int height = this.f37858c.getHeight();
                int i4 = bottom < height ? bottom - height : 0;
                if (this.f37858c.getTop() != i4) {
                    this.f37858c.layout(0, i4, this.f37860e, this.f37861f + i4);
                }
                this.f37859d = true;
            }
        }
    }

    public void setSelection(int i) {
        super.setSelection(i);
        int firstVisiblePosition = getFirstVisiblePosition();
        int lastVisiblePosition = getLastVisiblePosition();
        if (this.f37864i) {
            if (firstVisiblePosition != 0 || lastVisiblePosition != getCount() - 1) {
                this.f37857b.configurePinnedHeader(this.f37858c, i, 255);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.f37859d && this.f37864i) {
            drawChild(canvas, this.f37858c, getDrawingTime());
        }
    }
}
