package com.didi.addressold.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewConfiguration;
import android.widget.ListView;
import com.didi.addressold.util.ViewUtils;
import com.didi.addressold.widget.AbsListViewCompat;

public class SugListView extends ListView {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public int f7926a = 1;

    /* renamed from: b */
    private float f7927b = 0.0f;

    /* renamed from: c */
    private int f7928c;

    public SugListView(Context context) {
        super(context);
        m5113a();
    }

    public SugListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m5113a();
    }

    /* renamed from: a */
    private void m5113a() {
        this.f7928c = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        new AbsListViewCompat().setScrollView(this).setOnScrollCallback(new AbsListViewCompat.OnScrollCallback() {
            public void onScrollChanged(int i, int i2, int i3) {
                int unused = SugListView.this.f7926a = i3;
                if (i == 0) {
                    ViewUtils.hideInputWindow(SugListView.this.getContext(), SugListView.this);
                }
            }
        });
    }

    public boolean isScrollToTop() {
        return this.f7926a == 1;
    }
}
