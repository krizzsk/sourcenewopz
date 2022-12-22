package com.microblink.blinkbarcode.view.viewfinder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: line */
public class llIIlIlIIl extends ViewGroup {
    public llIIlIlIIl(Context context) {
        super(context);
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int i5 = i4 - i2;
        int i6 = i3 - i;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            childAt.measure(View.MeasureSpec.makeMeasureSpec(i6, 1073741824), View.MeasureSpec.makeMeasureSpec(i5, 1073741824));
            childAt.layout(0, 0, i6, i5);
        }
    }
}
