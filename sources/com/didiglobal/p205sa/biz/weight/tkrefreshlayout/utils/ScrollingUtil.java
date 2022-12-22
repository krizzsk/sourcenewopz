package com.didiglobal.p205sa.biz.weight.tkrefreshlayout.utils;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ScrollView;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import java.lang.reflect.Field;

/* renamed from: com.didiglobal.sa.biz.weight.tkrefreshlayout.utils.ScrollingUtil */
public class ScrollingUtil {
    private ScrollingUtil() {
    }

    public static boolean canChildScrollUp(View view) {
        if (view == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 14) {
            return ViewCompat.canScrollVertically(view, -1);
        }
        if (view instanceof AbsListView) {
            AbsListView absListView = (AbsListView) view;
            if (absListView.getChildCount() <= 0) {
                return false;
            }
            if (absListView.getFirstVisiblePosition() > 0 || absListView.getChildAt(0).getTop() < absListView.getPaddingTop()) {
                return true;
            }
            return false;
        } else if (ViewCompat.canScrollVertically(view, -1) || view.getScrollY() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean canChildScrollDown(View view) {
        if (Build.VERSION.SDK_INT >= 14) {
            return ViewCompat.canScrollVertically(view, 1);
        }
        if (view instanceof AbsListView) {
            AbsListView absListView = (AbsListView) view;
            if (absListView.getChildCount() <= 0 || (absListView.getLastVisiblePosition() >= absListView.getChildCount() - 1 && absListView.getChildAt(absListView.getChildCount() - 1).getBottom() <= absListView.getPaddingBottom())) {
                return false;
            }
            return true;
        } else if (ViewCompat.canScrollVertically(view, 1) || view.getScrollY() < 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isScrollViewOrWebViewToTop(View view) {
        return view != null && view.getScrollY() == 0;
    }

    public static boolean isViewToTop(View view, int i) {
        if (view instanceof AbsListView) {
            return isAbsListViewToTop((AbsListView) view);
        }
        if (view instanceof RecyclerView) {
            return isRecyclerViewToTop((RecyclerView) view);
        }
        return view != null && Math.abs(view.getScrollY()) <= i * 2;
    }

    public static boolean isViewToBottom(View view, int i) {
        if (view instanceof AbsListView) {
            return isAbsListViewToBottom((AbsListView) view);
        }
        if (view instanceof RecyclerView) {
            return isRecyclerViewToBottom((RecyclerView) view);
        }
        if (view instanceof WebView) {
            return isWebViewToBottom((WebView) view, i);
        }
        if (view instanceof ViewGroup) {
            return isViewGroupToBottom((ViewGroup) view);
        }
        return false;
    }

    public static boolean isAbsListViewToTop(AbsListView absListView) {
        if (absListView != null) {
            int top = absListView.getChildCount() > 0 ? absListView.getChildAt(0).getTop() - absListView.getPaddingTop() : 0;
            if (absListView.getFirstVisiblePosition() == 0 && top == 0) {
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x0081 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isRecyclerViewToTop(androidx.recyclerview.widget.RecyclerView r6) {
        /*
            r0 = 0
            if (r6 == 0) goto L_0x0081
            androidx.recyclerview.widget.RecyclerView$LayoutManager r1 = r6.getLayoutManager()
            r2 = 1
            if (r1 != 0) goto L_0x000b
            return r2
        L_0x000b:
            int r3 = r1.getItemCount()
            if (r3 != 0) goto L_0x0012
            return r2
        L_0x0012:
            int r3 = r6.getChildCount()
            if (r3 <= 0) goto L_0x005f
            android.view.View r3 = r6.getChildAt(r0)
            if (r3 == 0) goto L_0x0043
            int r3 = r3.getMeasuredHeight()
            int r4 = r6.getMeasuredHeight()
            if (r3 < r4) goto L_0x0043
            int r1 = android.os.Build.VERSION.SDK_INT
            r3 = 14
            r4 = -1
            if (r1 >= r3) goto L_0x003d
            boolean r1 = androidx.core.view.ViewCompat.canScrollVertically(r6, r4)
            if (r1 != 0) goto L_0x003c
            int r6 = r6.getScrollY()
            if (r6 > 0) goto L_0x003c
            r0 = 1
        L_0x003c:
            return r0
        L_0x003d:
            boolean r6 = androidx.core.view.ViewCompat.canScrollVertically(r6, r4)
            r6 = r6 ^ r2
            return r6
        L_0x0043:
            android.view.View r3 = r6.getChildAt(r0)
            android.view.ViewGroup$LayoutParams r4 = r3.getLayoutParams()
            androidx.recyclerview.widget.RecyclerView$LayoutParams r4 = (androidx.recyclerview.widget.RecyclerView.LayoutParams) r4
            int r3 = r3.getTop()
            int r5 = r4.topMargin
            int r3 = r3 - r5
            int r4 = m36776a(r4)
            int r3 = r3 - r4
            int r6 = r6.getPaddingTop()
            int r3 = r3 - r6
            goto L_0x0060
        L_0x005f:
            r3 = 0
        L_0x0060:
            boolean r6 = r1 instanceof androidx.recyclerview.widget.LinearLayoutManager
            if (r6 == 0) goto L_0x006f
            androidx.recyclerview.widget.LinearLayoutManager r1 = (androidx.recyclerview.widget.LinearLayoutManager) r1
            int r6 = r1.findFirstCompletelyVisibleItemPosition()
            if (r6 >= r2) goto L_0x0081
            if (r3 != 0) goto L_0x0081
            return r2
        L_0x006f:
            boolean r6 = r1 instanceof androidx.recyclerview.widget.StaggeredGridLayoutManager
            if (r6 == 0) goto L_0x0081
            androidx.recyclerview.widget.StaggeredGridLayoutManager r1 = (androidx.recyclerview.widget.StaggeredGridLayoutManager) r1
            r6 = 0
            int[] r6 = r1.findFirstCompletelyVisibleItemPositions(r6)
            r6 = r6[r0]
            if (r6 >= r2) goto L_0x0081
            if (r3 != 0) goto L_0x0081
            return r2
        L_0x0081:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.p205sa.biz.weight.tkrefreshlayout.utils.ScrollingUtil.isRecyclerViewToTop(androidx.recyclerview.widget.RecyclerView):boolean");
    }

    /* renamed from: a */
    private static int m36776a(RecyclerView.LayoutParams layoutParams) {
        try {
            Field declaredField = RecyclerView.LayoutParams.class.getDeclaredField("mDecorInsets");
            declaredField.setAccessible(true);
            return ((Rect) declaredField.get(layoutParams)).top;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static boolean isWebViewToBottom(WebView webView, int i) {
        return webView != null && (((float) webView.getContentHeight()) * webView.getScale()) - ((float) (webView.getHeight() + webView.getScrollY())) <= ((float) (i * 2));
    }

    public static boolean isViewGroupToBottom(ViewGroup viewGroup) {
        View childAt = viewGroup.getChildAt(0);
        if (childAt == null || childAt.getMeasuredHeight() > viewGroup.getScrollY() + viewGroup.getHeight()) {
            return false;
        }
        return true;
    }

    public static boolean isScrollViewToBottom(ScrollView scrollView) {
        if (scrollView == null || ((scrollView.getScrollY() + scrollView.getMeasuredHeight()) - scrollView.getPaddingTop()) - scrollView.getPaddingBottom() != scrollView.getChildAt(0).getMeasuredHeight()) {
            return false;
        }
        return true;
    }

    public static boolean isAbsListViewToBottom(AbsListView absListView) {
        if (absListView == null || absListView.getAdapter() == null || absListView.getChildCount() <= 0 || absListView.getLastVisiblePosition() != ((ListAdapter) absListView.getAdapter()).getCount() - 1 || absListView.getChildAt(absListView.getChildCount() - 1).getBottom() > absListView.getMeasuredHeight()) {
            return false;
        }
        return true;
    }

    public static boolean isRecyclerViewToBottom(RecyclerView recyclerView) {
        RecyclerView.LayoutManager layoutManager;
        if (!(recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null || layoutManager.getItemCount() == 0)) {
            if (layoutManager instanceof LinearLayoutManager) {
                View childAt = recyclerView.getChildAt(recyclerView.getChildCount() - 1);
                if (childAt == null || childAt.getMeasuredHeight() < recyclerView.getMeasuredHeight()) {
                    LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                    if (linearLayoutManager.findLastCompletelyVisibleItemPosition() == linearLayoutManager.getItemCount() - 1) {
                        return true;
                    }
                } else if (Build.VERSION.SDK_INT >= 14) {
                    return !ViewCompat.canScrollVertically(recyclerView, 1);
                } else {
                    if (ViewCompat.canScrollVertically(recyclerView, 1) || recyclerView.getScrollY() < 0) {
                        return false;
                    }
                    return true;
                }
            } else if (layoutManager instanceof StaggeredGridLayoutManager) {
                StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
                int[] findLastCompletelyVisibleItemPositions = staggeredGridLayoutManager.findLastCompletelyVisibleItemPositions((int[]) null);
                int itemCount = staggeredGridLayoutManager.getItemCount() - 1;
                for (int i : findLastCompletelyVisibleItemPositions) {
                    if (i == itemCount) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void scrollAViewBy(View view, int i) {
        if (view instanceof RecyclerView) {
            ((RecyclerView) view).scrollBy(0, i);
        } else if (view instanceof ScrollView) {
            ((ScrollView) view).smoothScrollBy(0, i);
        } else if (view instanceof AbsListView) {
            ((AbsListView) view).smoothScrollBy(i, 0);
        } else {
            try {
                view.getClass().getDeclaredMethod("smoothScrollBy", new Class[]{Integer.class, Integer.class}).invoke(view, new Object[]{0, Integer.valueOf(i)});
            } catch (Exception unused) {
                view.scrollBy(0, i);
            }
        }
    }

    public static void scrollToBottom(final ScrollView scrollView) {
        if (scrollView != null) {
            scrollView.post(new Runnable() {
                public void run() {
                    scrollView.fullScroll(130);
                }
            });
        }
    }

    public static void scrollToBottom(final AbsListView absListView) {
        if (absListView != null && absListView.getAdapter() != null && ((ListAdapter) absListView.getAdapter()).getCount() > 0) {
            absListView.post(new Runnable() {
                public void run() {
                    AbsListView absListView = absListView;
                    absListView.setSelection(((ListAdapter) absListView.getAdapter()).getCount() - 1);
                }
            });
        }
    }

    public static void scrollToBottom(final RecyclerView recyclerView) {
        if (recyclerView != null && recyclerView.getAdapter() != null && recyclerView.getAdapter().getItemCount() > 0) {
            recyclerView.post(new Runnable() {
                public void run() {
                    RecyclerView recyclerView = RecyclerView.this;
                    recyclerView.smoothScrollToPosition(recyclerView.getAdapter().getItemCount() - 1);
                }
            });
        }
    }

    public static void scrollToBottom(View view) {
        if (view instanceof RecyclerView) {
            scrollToBottom((RecyclerView) view);
        }
        if (view instanceof AbsListView) {
            scrollToBottom((AbsListView) view);
        }
        if (view instanceof ScrollView) {
            scrollToBottom((ScrollView) view);
        }
    }

    public static int getScreenHeight(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }
}
