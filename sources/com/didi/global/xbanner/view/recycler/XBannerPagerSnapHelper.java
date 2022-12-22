package com.didi.global.xbanner.view.recycler;

import android.view.View;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

public class XBannerPagerSnapHelper extends PagerSnapHelper {

    /* renamed from: a */
    private OrientationHelper f22958a;

    /* renamed from: b */
    private OrientationHelper f22959b;

    public int[] calculateDistanceToFinalSnap(RecyclerView.LayoutManager layoutManager, View view) {
        return new int[]{m16523a(view, m16524a(layoutManager)), 0};
    }

    /* renamed from: a */
    private int m16523a(View view, OrientationHelper orientationHelper) {
        return orientationHelper.getDecoratedStart(view) - orientationHelper.getStartAfterPadding();
    }

    /* renamed from: a */
    private OrientationHelper m16524a(RecyclerView.LayoutManager layoutManager) {
        OrientationHelper orientationHelper = this.f22959b;
        if (orientationHelper == null || orientationHelper.getLayoutManager() != layoutManager) {
            this.f22959b = OrientationHelper.createHorizontalHelper(layoutManager);
        }
        return this.f22959b;
    }
}
