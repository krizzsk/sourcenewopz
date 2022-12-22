package com.didi.sdk.global.balance.adapter;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

@Deprecated
public class SnapPageScrollListener extends RecyclerView.OnScrollListener {
    public int currentPosition = -1;
    protected SnapHelper snapHelper;

    public void onPageScrolled(int i, float f, int i2) {
    }

    public void onPageSelected(int i) {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001b, code lost:
        r8 = r6.snapHelper.findSnapView(r7);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onScrolled(androidx.recyclerview.widget.RecyclerView r7, int r8, int r9) {
        /*
            r6 = this;
            super.onScrolled(r7, r8, r9)
            androidx.recyclerview.widget.SnapHelper r8 = r6.snapHelper
            if (r8 != 0) goto L_0x0013
            androidx.recyclerview.widget.RecyclerView$OnFlingListener r8 = r7.getOnFlingListener()
            boolean r9 = r8 instanceof androidx.recyclerview.widget.SnapHelper
            if (r9 == 0) goto L_0x0013
            androidx.recyclerview.widget.SnapHelper r8 = (androidx.recyclerview.widget.SnapHelper) r8
            r6.snapHelper = r8
        L_0x0013:
            androidx.recyclerview.widget.RecyclerView$LayoutManager r7 = r7.getLayoutManager()
            r8 = 0
            r9 = -1
            if (r7 == 0) goto L_0x0028
            androidx.recyclerview.widget.SnapHelper r8 = r6.snapHelper
            android.view.View r8 = r8.findSnapView(r7)
            if (r8 == 0) goto L_0x0028
            int r0 = r7.getPosition(r8)
            goto L_0x0029
        L_0x0028:
            r0 = -1
        L_0x0029:
            if (r0 != r9) goto L_0x002c
            return
        L_0x002c:
            int r9 = r6.currentPosition
            if (r9 == r0) goto L_0x0035
            r6.currentPosition = r0
            r6.onPageSelected(r0)
        L_0x0035:
            androidx.recyclerview.widget.SnapHelper r9 = r6.snapHelper
            int[] r9 = r9.calculateDistanceToFinalSnap(r7, r8)
            r1 = 0
            r2 = 1
            r3 = 0
            if (r9 == 0) goto L_0x005c
            boolean r4 = r7.canScrollHorizontally()
            if (r4 == 0) goto L_0x0050
            r4 = r9[r3]
            r9 = r9[r3]
            float r9 = (float) r9
            int r5 = r8.getWidth()
            goto L_0x0059
        L_0x0050:
            r4 = r9[r2]
            r9 = r9[r2]
            float r9 = (float) r9
            int r5 = r8.getHeight()
        L_0x0059:
            float r5 = (float) r5
            float r9 = r9 / r5
            goto L_0x005e
        L_0x005c:
            r9 = 0
            r4 = 0
        L_0x005e:
            int r5 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r5 > 0) goto L_0x006b
            float r7 = java.lang.Math.abs(r9)
            int r8 = java.lang.Math.abs(r4)
            goto L_0x00a6
        L_0x006b:
            int r0 = r0 + -1
            android.view.View r9 = r7.findViewByPosition(r0)
            r4 = 2
            int[] r4 = new int[r4]
            if (r9 == 0) goto L_0x007c
            androidx.recyclerview.widget.SnapHelper r4 = r6.snapHelper
            int[] r4 = r4.calculateDistanceToFinalSnap(r7, r9)
        L_0x007c:
            if (r4 == 0) goto L_0x009e
            boolean r7 = r7.canScrollHorizontally()
            if (r7 == 0) goto L_0x0092
            r7 = r4[r3]
            r9 = r4[r3]
            float r9 = (float) r9
            int r8 = r8.getWidth()
            float r8 = (float) r8
            float r1 = r9 / r8
            r3 = r7
            goto L_0x009e
        L_0x0092:
            r3 = r4[r2]
            r7 = r4[r2]
            float r7 = (float) r7
            int r8 = r8.getHeight()
            float r8 = (float) r8
            float r1 = r7 / r8
        L_0x009e:
            float r7 = java.lang.Math.abs(r1)
            int r8 = java.lang.Math.abs(r3)
        L_0x00a6:
            r6.onPageScrolled(r0, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.global.balance.adapter.SnapPageScrollListener.onScrolled(androidx.recyclerview.widget.RecyclerView, int, int):void");
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        super.onScrollStateChanged(recyclerView, i);
        int i2 = this.currentPosition;
        if (i2 != -1 && i == 0) {
            onPageScrolled(i2, 0.0f, 0);
        }
    }
}
