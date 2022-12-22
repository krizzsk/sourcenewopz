package com.scwang.smart.refresh.horizontal;

import android.graphics.PointF;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.scwang.smart.refresh.layout.simple.SimpleBoundaryDecider;
import com.scwang.smart.refresh.layout.util.SmartUtil;

public class ScrollBoundaryHorizontal extends SimpleBoundaryDecider {
    public boolean canRefresh(View view) {
        return canRefresh(view, this.mActionEvent);
    }

    public boolean canLoadMore(View view) {
        return canLoadMore(view, this.mActionEvent, this.mEnableLoadMoreWhenContentNotFull);
    }

    public static boolean canRefresh(View view, PointF pointF) {
        if (canScrollLeft(view) && view.getVisibility() == 0) {
            return false;
        }
        if (!(view instanceof ViewGroup) || pointF == null) {
            return true;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        PointF pointF2 = new PointF();
        while (childCount > 0) {
            View childAt = viewGroup.getChildAt(childCount - 1);
            if (!SmartUtil.isTransformedTouchPointInView(viewGroup, childAt, pointF.x, pointF.y, pointF2)) {
                childCount--;
            } else if ("fixed".equals(childAt.getTag())) {
                return false;
            } else {
                pointF.offset(pointF2.x, pointF2.y);
                boolean canRefresh = canRefresh(childAt, pointF);
                pointF.offset(-pointF2.x, -pointF2.y);
                return canRefresh;
            }
        }
        return true;
    }

    public static boolean canLoadMore(View view, PointF pointF, boolean z) {
        if (canScrollRight(view) && view.getVisibility() == 0) {
            return false;
        }
        if ((view instanceof ViewGroup) && pointF != null && !SmartUtil.isScrollableView(view)) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            PointF pointF2 = new PointF();
            int i = 0;
            while (i < childCount) {
                View childAt = viewGroup.getChildAt(i);
                if (!SmartUtil.isTransformedTouchPointInView(viewGroup, childAt, pointF.x, pointF.y, pointF2)) {
                    i++;
                } else if ("fixed".equals(childAt.getTag())) {
                    return false;
                } else {
                    pointF.offset(pointF2.x, pointF2.y);
                    boolean canLoadMore = canLoadMore(childAt, pointF, z);
                    pointF.offset(-pointF2.x, -pointF2.y);
                    return canLoadMore;
                }
            }
        }
        if (z || canScrollLeft(view)) {
            return true;
        }
        return false;
    }

    public static boolean canScrollLeft(View view) {
        if (Build.VERSION.SDK_INT >= 14) {
            return view.canScrollHorizontally(-1);
        }
        if (view instanceof AbsListView) {
            ViewGroup viewGroup = (ViewGroup) view;
            AbsListView absListView = (AbsListView) view;
            if (viewGroup.getChildCount() <= 0 || (absListView.getFirstVisiblePosition() <= 0 && viewGroup.getChildAt(0).getTop() >= view.getPaddingTop())) {
                return false;
            }
            return true;
        } else if (view.getScrollY() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean canScrollRight(View view) {
        int i;
        if (Build.VERSION.SDK_INT >= 14) {
            return view.canScrollHorizontally(1);
        }
        if (view instanceof AbsListView) {
            ViewGroup viewGroup = (ViewGroup) view;
            AbsListView absListView = (AbsListView) view;
            int childCount = viewGroup.getChildCount();
            if (childCount <= 0 || (absListView.getLastVisiblePosition() >= (i = childCount - 1) && viewGroup.getChildAt(i).getBottom() <= view.getPaddingBottom())) {
                return false;
            }
            return true;
        } else if (view.getScrollY() < 0) {
            return true;
        } else {
            return false;
        }
    }
}
