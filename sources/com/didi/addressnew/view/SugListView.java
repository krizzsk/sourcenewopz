package com.didi.addressnew.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.AbsListView;
import android.widget.ListView;
import com.didi.addressnew.util.ViewUtils;
import com.didi.addressnew.widget.AbsListViewCompat;
import com.didi.common.map.util.DLog;

public class SugListView extends ListView {

    /* renamed from: a */
    private static String f7516a = SugListView.class.getSimpleName();

    /* renamed from: e */
    private static final int f7517e = 100;

    /* renamed from: f */
    private static final float f7518f = 0.75f;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f7519b = 1;

    /* renamed from: c */
    private float f7520c = 0.0f;

    /* renamed from: d */
    private int f7521d;

    /* renamed from: g */
    private int f7522g;

    public SugListView(Context context) {
        super(context);
        m4752a();
    }

    public SugListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m4752a();
    }

    /* renamed from: a */
    private void m4752a() {
        this.f7521d = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        new AbsListViewCompat().setScrollView(this).setOnScrollCallback(new AbsListViewCompat.OnScrollCallback() {
            public void onScrollChanged(int i, int i2, int i3) {
                int unused = SugListView.this.f7519b = i3;
                if (i == 0) {
                    ViewUtils.hideInputWindow(SugListView.this.getContext(), SugListView.this);
                }
            }
        });
        setRecyclerListener(new AbsListView.RecyclerListener() {
            public void onMovedToScrapHeap(View view) {
                if (view != null && view.hasFocus()) {
                    view.clearFocus();
                }
            }
        });
        this.f7522g = ViewUtils.dip2px(getContext(), 100.0f);
    }

    public boolean isScrollToTop() {
        return this.f7519b == 1;
    }

    /* access modifiers changed from: protected */
    public boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        int i9 = i2;
        boolean z2 = z;
        int abs = z2 ? (int) ((0.75d - Math.abs((((double) i4) / ((double) this.f7522g)) * 0.75d)) * ((double) i9)) : i9;
        int i10 = i9 == 0 ? 0 : abs != 0 ? abs : i9 > 0 ? 1 : -1;
        String str = f7516a;
        DLog.m7384d(str, "overScrollBy deltaY ：" + i2 + " newDeltaY : " + i10 + " scrollY : " + i4 + " maxOverScrollY : " + i8 + " isTouchEvent : " + z2, new Object[0]);
        return super.overScrollBy(i, i10, i3, i4, i5, i6, i7, this.f7522g, z);
    }

    public void setOnScrollChangeListener(View.OnScrollChangeListener onScrollChangeListener) {
        super.setOnScrollChangeListener(onScrollChangeListener);
    }
}
