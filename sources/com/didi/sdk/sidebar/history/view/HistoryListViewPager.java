package com.didi.sdk.sidebar.history.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

public class HistoryListViewPager extends ViewPager {

    /* renamed from: a */
    private boolean f37422a = true;

    public HistoryListViewPager(Context context) {
        super(context);
    }

    public HistoryListViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setScrollable(boolean z) {
        this.f37422a = z;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f37422a) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f37422a) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }
}
