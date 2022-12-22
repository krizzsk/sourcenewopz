package com.didi.sdk.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

public class ViewPagerWrapper extends ViewPager {
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public ViewPagerWrapper(Context context) {
        super(context);
    }

    public ViewPagerWrapper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
