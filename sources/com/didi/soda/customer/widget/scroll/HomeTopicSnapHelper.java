package com.didi.soda.customer.widget.scroll;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.nova.assembly.p127ui.banner.OnBannerClickListener;

public class HomeTopicSnapHelper extends LinearSnapHelper {

    /* renamed from: a */
    private final OnBannerClickListener f42162a;

    /* renamed from: b */
    private OrientationHelper f42163b;

    /* renamed from: c */
    private OrientationHelper f42164c;

    /* renamed from: d */
    private Context f42165d;

    public HomeTopicSnapHelper(OnBannerClickListener onBannerClickListener) {
        this.f42162a = onBannerClickListener;
    }

    public void attachToRecyclerView(RecyclerView recyclerView) throws IllegalStateException {
        super.attachToRecyclerView(recyclerView);
        this.f42165d = recyclerView.getContext();
    }

    public int[] calculateDistanceToFinalSnap(RecyclerView.LayoutManager layoutManager, View view) {
        int[] iArr = new int[2];
        boolean z = ((LinearLayoutManager) layoutManager).findLastCompletelyVisibleItemPosition() == layoutManager.getItemCount() - 1;
        if (this.f42162a != null) {
            int viewAdapterPosition = ((RecyclerView.LayoutParams) view.getLayoutParams()).getViewAdapterPosition();
            if (z) {
                viewAdapterPosition = layoutManager.getItemCount() - 1;
            }
            this.f42162a.onBannerPageSelected(viewAdapterPosition);
        }
        if (z) {
            return iArr;
        }
        if (layoutManager.canScrollHorizontally()) {
            iArr[0] = m29722a(view, m29724b(layoutManager));
        } else {
            iArr[0] = 0;
        }
        if (layoutManager.canScrollVertically()) {
            iArr[1] = m29722a(view, m29725c(layoutManager));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    public View findSnapView(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager instanceof LinearLayoutManager) {
            return m29723a(layoutManager);
        }
        return super.findSnapView(layoutManager);
    }

    public int findTargetSnapPosition(RecyclerView.LayoutManager layoutManager, int i, int i2) {
        int position;
        int itemCount = layoutManager.getItemCount();
        if (itemCount == 0) {
            return -1;
        }
        View view = null;
        if (layoutManager.canScrollHorizontally()) {
            view = m29723a(layoutManager);
        }
        if (view == null || (position = layoutManager.getPosition(view)) == -1) {
            return -1;
        }
        boolean z = true;
        boolean z2 = !layoutManager.canScrollHorizontally() ? i2 > 0 : i > 0;
        OrientationHelper b = m29724b(layoutManager);
        if (b.getDecoratedEnd(view) < (b.getDecoratedMeasurement(view) * 4) / 5) {
            z = false;
        }
        if (z2) {
            return position + 2;
        }
        return (z || itemCount % 2 == 0 || position != itemCount + -3) ? position - 2 : position;
    }

    /* access modifiers changed from: protected */
    public RecyclerView.SmoothScroller createScroller(final RecyclerView.LayoutManager layoutManager) {
        return new LinearSmoothScroller(this.f42165d) {
            /* access modifiers changed from: protected */
            public void onTargetFound(View view, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
                int[] calculateDistanceToFinalSnap = HomeTopicSnapHelper.this.calculateDistanceToFinalSnap(layoutManager, view);
                int i = calculateDistanceToFinalSnap[0];
                int i2 = calculateDistanceToFinalSnap[1];
                int calculateTimeForDeceleration = calculateTimeForDeceleration(Math.max(Math.abs(i), Math.abs(i2)));
                if (calculateTimeForDeceleration > 0) {
                    action.update(i, i2, calculateTimeForDeceleration, this.mDecelerateInterpolator);
                }
            }

            /* access modifiers changed from: protected */
            public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                return 50.0f / ((float) displayMetrics.densityDpi);
            }
        };
    }

    /* renamed from: a */
    private int m29722a(View view, OrientationHelper orientationHelper) {
        return orientationHelper.getDecoratedStart(view) - orientationHelper.getStartAfterPadding();
    }

    /* renamed from: a */
    private View m29723a(RecyclerView.LayoutManager layoutManager) {
        if (!(layoutManager instanceof LinearLayoutManager)) {
            return super.findSnapView(layoutManager);
        }
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
        int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        if (linearLayoutManager.findLastCompletelyVisibleItemPosition() == layoutManager.getItemCount() - 1) {
            return layoutManager.findViewByPosition(layoutManager.getItemCount() - 1);
        }
        if (findFirstVisibleItemPosition == -1) {
            return null;
        }
        View findViewByPosition = layoutManager.findViewByPosition(findFirstVisibleItemPosition);
        if (findFirstVisibleItemPosition % 2 == 0) {
            return findViewByPosition;
        }
        if (linearLayoutManager.findLastCompletelyVisibleItemPosition() == layoutManager.getItemCount() - 1) {
            return null;
        }
        return layoutManager.findViewByPosition(findFirstVisibleItemPosition + 1);
    }

    /* renamed from: b */
    private OrientationHelper m29724b(RecyclerView.LayoutManager layoutManager) {
        if (this.f42163b == null) {
            this.f42163b = OrientationHelper.createHorizontalHelper(layoutManager);
        }
        return this.f42163b;
    }

    /* renamed from: c */
    private OrientationHelper m29725c(RecyclerView.LayoutManager layoutManager) {
        if (this.f42164c == null) {
            this.f42164c = OrientationHelper.createVerticalHelper(layoutManager);
        }
        return this.f42164c;
    }
}
