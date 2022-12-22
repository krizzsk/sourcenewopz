package com.didi.sdk.sidebar.history.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import com.didi.sdk.view.DropDownListView;

public class DropPinnedHeaderList extends DropDownListView {

    /* renamed from: a */
    private static final int f37413a = 255;

    /* renamed from: b */
    private PinnedHeaderAdapter f37414b;

    /* renamed from: c */
    private View f37415c;

    /* renamed from: d */
    private boolean f37416d;

    /* renamed from: e */
    private int f37417e;

    /* renamed from: f */
    private int f37418f;

    /* renamed from: g */
    private int f37419g;

    /* renamed from: h */
    private int f37420h;

    /* renamed from: i */
    private boolean f37421i;

    public interface PinnedHeaderAdapter {
        public static final int PINNED_HEADER_GONE = 0;
        public static final int PINNED_HEADER_PUSHED_UP = 2;
        public static final int PINNED_HEADER_VISIBLE = 1;

        void configurePinnedHeader(View view, int i, int i2);

        int getPinnedHeaderState(int i);
    }

    public DropPinnedHeaderList(Context context) {
        super(context);
    }

    public DropPinnedHeaderList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOverScrollMode(2);
    }

    public DropPinnedHeaderList(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setPinnedHeaderView(View view) {
        this.f37415c = view;
        if (view != null) {
            setFadingEdgeLength(0);
        }
        requestLayout();
    }

    public void setAdapter(ListAdapter listAdapter, boolean z) {
        super.setAdapter(listAdapter);
        this.f37421i = z;
        if (z) {
            this.f37414b = (PinnedHeaderAdapter) listAdapter;
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        View view = this.f37415c;
        if (view != null) {
            measureChild(view, i, i2);
            this.f37417e = this.f37415c.getMeasuredWidth();
            this.f37418f = this.f37415c.getMeasuredHeight();
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View view;
        super.onLayout(z, i, i2, i3, i4);
        if (this.f37421i && (view = this.f37415c) != null) {
            view.layout(0, 0, this.f37417e, this.f37418f);
            configureHeaderView(getFirstVisiblePosition());
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        super.onScroll(absListView, i, i2, i3);
        configureHeaderView(i);
    }

    public void updateHeaderView(int i) {
        PinnedHeaderAdapter pinnedHeaderAdapter = this.f37414b;
        if (pinnedHeaderAdapter != null) {
            pinnedHeaderAdapter.configurePinnedHeader(this.f37415c, i, 255);
        }
    }

    public void configureHeaderView(int i) {
        if (this.f37421i && this.f37415c != null && this.f37414b != null && getChildCount() != 0 && getCount() != i + 1) {
            int i2 = this.f37419g;
            int i3 = this.f37420h;
            this.f37420h = i;
            int pinnedHeaderState = this.f37414b.getPinnedHeaderState(i);
            this.f37419g = pinnedHeaderState;
            if (pinnedHeaderState == 0) {
                this.f37416d = false;
            } else if (pinnedHeaderState == 1) {
                if (this.f37415c.getTop() != 0) {
                    this.f37415c.layout(0, 0, this.f37417e, this.f37418f);
                }
                if (this.f37419g != i2) {
                    this.f37414b.configurePinnedHeader(this.f37415c, i, 255);
                    this.f37415c.invalidate();
                }
                if (!this.f37416d) {
                    this.f37415c.invalidate();
                }
                this.f37416d = true;
            } else if (pinnedHeaderState == 2) {
                if (pinnedHeaderState != i2) {
                    this.f37414b.configurePinnedHeader(this.f37415c, i, 255);
                } else if (i3 != this.f37420h) {
                    this.f37414b.configurePinnedHeader(this.f37415c, i, 255);
                    this.f37415c.invalidate();
                }
                int bottom = getChildAt(0).getBottom();
                int height = this.f37415c.getHeight();
                int i4 = bottom < height ? bottom - height : 0;
                if (this.f37415c.getTop() != i4) {
                    this.f37415c.layout(0, i4, this.f37417e, this.f37418f + i4);
                }
                this.f37416d = true;
            }
        }
    }

    public void setSelection(int i) {
        PinnedHeaderAdapter pinnedHeaderAdapter;
        super.setSelection(i);
        int firstVisiblePosition = getFirstVisiblePosition();
        int lastVisiblePosition = getLastVisiblePosition();
        if (!this.f37421i) {
            return;
        }
        if ((firstVisiblePosition != 0 || lastVisiblePosition != getCount() - 1) && (pinnedHeaderAdapter = this.f37414b) != null) {
            pinnedHeaderAdapter.configurePinnedHeader(this.f37415c, i, 255);
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.f37416d && this.f37421i) {
            drawChild(canvas, this.f37415c, getDrawingTime());
        }
    }
}
