package com.didi.addressold.widget;

import android.view.View;
import android.widget.AbsListView;

public class AbsListViewCompat<T extends AbsListView> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public OnScrollCallback f8054a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f8055b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f8056c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public int f8057d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public T f8058e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f8059f;

    public interface OnScrollCallback {
        public static final int SCROLL_DIRECTION_DOWN = 2;
        public static final int SCROLL_DIRECTION_NOTHING = 0;
        public static final int SCROLL_DIRECTION_UP = 1;
        public static final int SCROLL_POSITION_BOTTOM = 2;
        public static final int SCROLL_POSITION_OTHER = 0;
        public static final int SCROLL_POSITION_TOP = 1;
        public static final int STATE_SCROLLING = 1;
        public static final int STATE_STOPPED = 2;
        public static final int STATE_TOUCH_SCROLL = 0;

        void onScrollChanged(int i, int i2, int i3);
    }

    public AbsListViewCompat setScrollView(T t) {
        if (t == null) {
            return this;
        }
        this.f8058e = t;
        m5228a();
        return this;
    }

    public T getScrollView() {
        return this.f8058e;
    }

    public AbsListViewCompat setOnScrollCallback(OnScrollCallback onScrollCallback) {
        this.f8054a = onScrollCallback;
        return this;
    }

    /* renamed from: a */
    private void m5228a() {
        this.f8058e.setOnScrollListener(new AbsListView.OnScrollListener() {
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (AbsListViewCompat.this.f8054a != null) {
                    int b = AbsListViewCompat.this.m5233c();
                    if (i == 0) {
                        AbsListViewCompat absListViewCompat = AbsListViewCompat.this;
                        int unused = absListViewCompat.f8055b = absListViewCompat.m5230b();
                        AbsListViewCompat.this.f8054a.onScrollChanged(2, 0, b);
                    } else if (i == 1) {
                        boolean unused2 = AbsListViewCompat.this.f8059f = true;
                        AbsListViewCompat.this.f8054a.onScrollChanged(0, 0, b);
                    }
                }
            }

            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int c;
                if (AbsListViewCompat.this.f8059f && AbsListViewCompat.this.f8054a != null && AbsListViewCompat.this.f8055b != (c = AbsListViewCompat.this.m5230b())) {
                    int unused = AbsListViewCompat.this.f8055b = c;
                    int i4 = 0;
                    int i5 = 2;
                    int[] iArr = new int[2];
                    AbsListViewCompat.this.f8058e.getChildAt(0).getLocationOnScreen(iArr);
                    int i6 = 1;
                    if (i != AbsListViewCompat.this.f8056c) {
                        if (i > AbsListViewCompat.this.f8056c) {
                            i4 = 1;
                        } else if (i < AbsListViewCompat.this.f8056c) {
                            i4 = 2;
                        }
                        int unused2 = AbsListViewCompat.this.f8056c = i;
                        int unused3 = AbsListViewCompat.this.f8057d = iArr[1];
                    } else {
                        if (AbsListViewCompat.this.f8057d > iArr[1]) {
                            i4 = 1;
                        } else {
                            if (AbsListViewCompat.this.f8057d < iArr[1]) {
                                i4 = 2;
                            }
                            int unused4 = AbsListViewCompat.this.f8057d = iArr[1];
                            i6 = i5;
                        }
                        i5 = 1;
                        int unused5 = AbsListViewCompat.this.f8057d = iArr[1];
                        i6 = i5;
                    }
                    AbsListViewCompat.this.f8054a.onScrollChanged(i6, i4, AbsListViewCompat.this.m5233c());
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public int m5230b() {
        View childAt = this.f8058e.getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        return -(childAt.getTop() + this.f8058e.getPaddingTop());
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public int m5233c() {
        View childAt;
        if (this.f8058e.getLastVisiblePosition() == this.f8058e.getCount() - 1) {
            T t = this.f8058e;
            if (t.getChildAt(t.getChildCount() - 1).getBottom() + this.f8058e.getPaddingBottom() == this.f8058e.getBottom()) {
                return 2;
            }
        }
        if (this.f8058e.getFirstVisiblePosition() == 0 && (childAt = this.f8058e.getChildAt(0)) != null && childAt.getTop() == this.f8058e.getPaddingTop()) {
            return 1;
        }
        return 0;
    }
}
