package com.didi.rfusion.widget.floating;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ScrollView;
import androidx.core.view.ScrollingView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class RFViewScrollChecker {

    /* renamed from: a */
    private static final Class<?>[] f33577a = {ScrollingView.class, ScrollView.class, ListView.class};

    /* renamed from: a */
    private static boolean m23659a(int i) {
        return i == 0;
    }

    public static void scanScrollableViews(View view, List<View> list) {
        if (view != null && list != null) {
            if (view instanceof ViewGroup) {
                int i = 0;
                while (true) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    if (i < viewGroup.getChildCount()) {
                        View childAt = viewGroup.getChildAt(i);
                        if (childAt instanceof ViewGroup) {
                            if (m23660a(childAt)) {
                                list.add(childAt);
                            } else {
                                scanScrollableViews(viewGroup.getChildAt(i), list);
                            }
                        } else if (m23660a(childAt)) {
                            list.add(childAt);
                        }
                        i++;
                    } else {
                        return;
                    }
                }
            } else if (m23660a(view)) {
                list.add(view);
            }
        }
    }

    /* renamed from: a */
    private static boolean m23660a(View view) {
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        for (Class<?> isInstance : f33577a) {
            if (isInstance.isInstance(view)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isScrollTop(View view) {
        if (view == null) {
            return true;
        }
        if (view instanceof RecyclerView) {
            return isScrollTop((RecyclerView) view);
        }
        if (view instanceof ScrollView) {
            return isScrollTop((ScrollView) view);
        }
        if (view instanceof ScrollingView) {
            return isScrollTop((ScrollingView) view);
        }
        if (view instanceof ListView) {
            return isScrollTop((ListView) view);
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002d, code lost:
        if (r3.getTop() == 0) goto L_0x002f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0031, code lost:
        if (r3 == 0) goto L_0x002f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isScrollTop(androidx.recyclerview.widget.RecyclerView r3) {
        /*
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = r3.getLayoutManager()
            boolean r1 = r0 instanceof androidx.recyclerview.widget.LinearLayoutManager
            if (r1 == 0) goto L_0x0039
            androidx.recyclerview.widget.LinearLayoutManager r0 = (androidx.recyclerview.widget.LinearLayoutManager) r0
            int r1 = r0.getOrientation()
            r2 = 1
            if (r1 != r2) goto L_0x0034
            int r3 = r0.findFirstCompletelyVisibleItemPosition()
            r1 = 0
            if (r3 >= 0) goto L_0x0031
            int r3 = r0.getChildCount()
            if (r3 != 0) goto L_0x001f
            goto L_0x002f
        L_0x001f:
            android.view.View r3 = r0.getChildAt(r1)
            int r0 = r0.getPosition(r3)
            if (r0 != 0) goto L_0x003d
            int r3 = r3.getTop()
            if (r3 != 0) goto L_0x003d
        L_0x002f:
            r2 = 0
            goto L_0x003d
        L_0x0031:
            if (r3 != 0) goto L_0x003d
            goto L_0x002f
        L_0x0034:
            int r2 = r3.computeVerticalScrollOffset()
            goto L_0x003d
        L_0x0039:
            int r2 = r3.computeVerticalScrollOffset()
        L_0x003d:
            boolean r3 = m23659a((int) r2)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.rfusion.widget.floating.RFViewScrollChecker.isScrollTop(androidx.recyclerview.widget.RecyclerView):boolean");
    }

    public static boolean isScrollTop(ScrollingView scrollingView) {
        return m23659a(scrollingView.computeVerticalScrollOffset());
    }

    public static boolean isScrollTop(ScrollView scrollView) {
        return m23659a(scrollView.getScrollY());
    }

    public static boolean isScrollTop(ListView listView) {
        int i = 0;
        if (!(listView.getChildCount() == 0 || (listView.getFirstVisiblePosition() == 0 && listView.getChildAt(0).getTop() == 0))) {
            i = 1;
        }
        return m23659a(i);
    }
}
