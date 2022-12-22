package com.didi.unifylogin.country;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;

public class PinnedHeaderListView extends ListView implements AbsListView.OnScrollListener {

    /* renamed from: a */
    private AbsListView.OnScrollListener f44752a;

    /* renamed from: b */
    private CountrySectionedAdapter f44753b;

    /* renamed from: c */
    private View f44754c;

    /* renamed from: d */
    private float f44755d;

    /* renamed from: e */
    private boolean f44756e = true;

    /* renamed from: f */
    private int f44757f = 0;

    /* renamed from: g */
    private int f44758g;

    public PinnedHeaderListView(Context context) {
        super(context);
        super.setOnScrollListener(this);
    }

    public PinnedHeaderListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setOnScrollListener(this);
    }

    public PinnedHeaderListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        super.setOnScrollListener(this);
    }

    public void setAdapter(ListAdapter listAdapter) {
        this.f44754c = null;
        this.f44753b = (CountrySectionedAdapter) listAdapter;
        super.setAdapter(listAdapter);
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        AbsListView.OnScrollListener onScrollListener = this.f44752a;
        if (onScrollListener != null) {
            onScrollListener.onScroll(absListView, i, i2, i3);
        }
        CountrySectionedAdapter countrySectionedAdapter = this.f44753b;
        if (countrySectionedAdapter == null || countrySectionedAdapter.getCount() == 0 || !this.f44756e || i < getHeaderViewsCount()) {
            this.f44754c = null;
            this.f44755d = 0.0f;
            for (int i4 = i; i4 < i + i2; i4++) {
                View childAt = getChildAt(i4);
                if (childAt != null) {
                    childAt.setVisibility(0);
                }
            }
            return;
        }
        int headerViewsCount = i - getHeaderViewsCount();
        View a = m31765a(this.f44753b.getSectionForPosition(headerViewsCount), this.f44754c);
        this.f44754c = a;
        m31766a(a);
        this.f44755d = 0.0f;
        for (int i5 = headerViewsCount; i5 < headerViewsCount + i2; i5++) {
            if (this.f44753b.isSectionHeader(i5)) {
                View childAt2 = getChildAt(i5 - headerViewsCount);
                float top = (float) childAt2.getTop();
                childAt2.setVisibility(0);
                if (((float) this.f44754c.getMeasuredHeight()) >= top && top > 0.0f) {
                    this.f44755d = top - ((float) childAt2.getHeight());
                } else if (top <= 0.0f) {
                    childAt2.setVisibility(4);
                }
            }
        }
        invalidate();
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        AbsListView.OnScrollListener onScrollListener = this.f44752a;
        if (onScrollListener != null) {
            onScrollListener.onScrollStateChanged(absListView, i);
        }
    }

    /* renamed from: a */
    private View m31765a(int i, View view) {
        boolean z = i != this.f44757f || view == null;
        View sectionHeaderView = this.f44753b.getSectionHeaderView(i, view, this);
        if (z) {
            m31766a(sectionHeaderView);
            this.f44757f = i;
        }
        return sectionHeaderView;
    }

    /* renamed from: a */
    private void m31766a(View view) {
        int i;
        if (view.isLayoutRequested()) {
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), this.f44758g);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null || layoutParams.height <= 0) {
                i = View.MeasureSpec.makeMeasureSpec(0, 0);
            } else {
                i = View.MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
            }
            view.measure(makeMeasureSpec, i);
            view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.f44753b != null && this.f44756e && this.f44754c != null) {
            int save = canvas.save();
            canvas.translate(0.0f, this.f44755d);
            canvas.clipRect(0, 0, getWidth(), this.f44754c.getMeasuredHeight());
            this.f44754c.draw(canvas);
            canvas.restoreToCount(save);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.f44752a = onScrollListener;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f44758g = View.MeasureSpec.getMode(i);
    }
}
