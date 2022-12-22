package com.didi.soda.customer.widget.scroll;

import android.content.Context;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

public class SlowLinearLayoutManager extends LinearLayoutManager {
    public SlowLinearLayoutManager(Context context) {
        super(context);
    }

    public SlowLinearLayoutManager(Context context, int i, boolean z) {
        super(context, i, z);
    }

    public SlowLinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
        SlowSnappedSmoothScroller slowSnappedSmoothScroller = new SlowSnappedSmoothScroller(recyclerView.getContext());
        slowSnappedSmoothScroller.setTargetPosition(i);
        startSmoothScroll(slowSnappedSmoothScroller);
    }

    class SlowSnappedSmoothScroller extends LinearSmoothScroller {
        public SlowSnappedSmoothScroller(Context context) {
            super(context);
        }

        public PointF computeScrollVectorForPosition(int i) {
            return SlowLinearLayoutManager.this.computeScrollVectorForPosition(i);
        }

        public int calculateDtToFit(int i, int i2, int i3, int i4, int i5) {
            return (i3 + ((i4 - i3) / 2)) - (i + ((i2 - i) / 2));
        }

        /* access modifiers changed from: protected */
        public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
            return 75.0f / ((float) displayMetrics.densityDpi);
        }
    }
}
