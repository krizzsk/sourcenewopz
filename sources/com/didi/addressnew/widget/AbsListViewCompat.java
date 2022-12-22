package com.didi.addressnew.widget;

import android.view.View;
import android.widget.AbsListView;

public class AbsListViewCompat<T extends AbsListView> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public OnScrollCallback f7636a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f7637b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f7638c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public int f7639d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public T f7640e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f7641f;

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
        this.f7640e = t;
        m4829a();
        return this;
    }

    public T getScrollView() {
        return this.f7640e;
    }

    public AbsListViewCompat setOnScrollCallback(OnScrollCallback onScrollCallback) {
        this.f7636a = onScrollCallback;
        return this;
    }

    /* renamed from: a */
    private void m4829a() {
        this.f7640e.setOnScrollListener(new AbsListView.OnScrollListener() {
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (AbsListViewCompat.this.f7636a != null) {
                    int b = AbsListViewCompat.this.m4834c();
                    if (i == 0) {
                        AbsListViewCompat absListViewCompat = AbsListViewCompat.this;
                        int unused = absListViewCompat.f7637b = absListViewCompat.m4831b();
                        AbsListViewCompat.this.f7636a.onScrollChanged(2, 0, b);
                    } else if (i == 1) {
                        try {
                            absListView.clearFocus();
                        } catch (Exception unused2) {
                        }
                        boolean unused3 = AbsListViewCompat.this.f7641f = true;
                        AbsListViewCompat.this.f7636a.onScrollChanged(0, 0, b);
                    }
                }
            }

            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int c;
                if (AbsListViewCompat.this.f7641f && AbsListViewCompat.this.f7636a != null && AbsListViewCompat.this.f7637b != (c = AbsListViewCompat.this.m4831b())) {
                    int unused = AbsListViewCompat.this.f7637b = c;
                    int i4 = 0;
                    View childAt = AbsListViewCompat.this.f7640e.getChildAt(0);
                    int i5 = 2;
                    int[] iArr = new int[2];
                    if (childAt != null) {
                        childAt.getLocationOnScreen(iArr);
                    }
                    int i6 = 1;
                    if (i != AbsListViewCompat.this.f7638c) {
                        if (i > AbsListViewCompat.this.f7638c) {
                            i4 = 1;
                        } else if (i < AbsListViewCompat.this.f7638c) {
                            i4 = 2;
                        }
                        int unused2 = AbsListViewCompat.this.f7638c = i;
                        int unused3 = AbsListViewCompat.this.f7639d = iArr[1];
                    } else {
                        if (AbsListViewCompat.this.f7639d > iArr[1]) {
                            i4 = 1;
                        } else {
                            if (AbsListViewCompat.this.f7639d < iArr[1]) {
                                i4 = 2;
                            }
                            int unused4 = AbsListViewCompat.this.f7639d = iArr[1];
                            i6 = i5;
                        }
                        i5 = 1;
                        int unused5 = AbsListViewCompat.this.f7639d = iArr[1];
                        i6 = i5;
                    }
                    AbsListViewCompat.this.f7636a.onScrollChanged(i6, i4, AbsListViewCompat.this.m4834c());
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public int m4831b() {
        View childAt = this.f7640e.getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        return -(childAt.getTop() + this.f7640e.getPaddingTop());
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public int m4834c() {
        View childAt;
        if (this.f7640e.getLastVisiblePosition() == this.f7640e.getCount() - 1) {
            T t = this.f7640e;
            if (t.getChildAt(t.getChildCount() - 1).getBottom() + this.f7640e.getPaddingBottom() == this.f7640e.getBottom()) {
                return 2;
            }
        }
        if (this.f7640e.getFirstVisiblePosition() == 0 && (childAt = this.f7640e.getChildAt(0)) != null && childAt.getTop() == this.f7640e.getPaddingTop()) {
            return 1;
        }
        return 0;
    }
}
