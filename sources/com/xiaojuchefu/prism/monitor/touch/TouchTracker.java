package com.xiaojuchefu.prism.monitor.touch;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.reflect.Field;

public class TouchTracker {

    /* renamed from: a */
    private static Field f56131a;

    /* renamed from: b */
    private static Field f56132b;

    public static View findTargetView(ViewGroup viewGroup, int[] iArr) {
        View view = null;
        if (m40401a() && viewGroup != null) {
            View a = m40400a(viewGroup);
            while (true) {
                View a2 = a instanceof ViewGroup ? m40400a((ViewGroup) a) : null;
                if (a2 == null) {
                    break;
                }
                a = a2;
            }
            view = a;
        }
        return iArr != null ? filterView(view, iArr) : view;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0046 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<android.view.View> findTargetViewList(android.view.ViewGroup r4, int[] r5) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            boolean r2 = m40401a()
            if (r2 == 0) goto L_0x002a
            if (r4 == 0) goto L_0x002a
            android.view.View r4 = m40400a(r4)
        L_0x0016:
            r2 = 0
            if (r4 == 0) goto L_0x001c
            r0.add(r4)
        L_0x001c:
            boolean r3 = r4 instanceof android.view.ViewGroup
            if (r3 == 0) goto L_0x0027
            android.view.ViewGroup r4 = (android.view.ViewGroup) r4
            android.view.View r4 = m40400a(r4)
            goto L_0x0028
        L_0x0027:
            r4 = r2
        L_0x0028:
            if (r4 != 0) goto L_0x0016
        L_0x002a:
            if (r5 == 0) goto L_0x0046
            r4 = 0
        L_0x002d:
            int r2 = r0.size()
            if (r4 >= r2) goto L_0x0045
            java.lang.Object r2 = r0.get(r4)
            android.view.View r2 = (android.view.View) r2
            android.view.View r2 = filterView(r2, r5)
            if (r2 == 0) goto L_0x0042
            r1.add(r2)
        L_0x0042:
            int r4 = r4 + 1
            goto L_0x002d
        L_0x0045:
            return r1
        L_0x0046:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaojuchefu.prism.monitor.touch.TouchTracker.findTargetViewList(android.view.ViewGroup, int[]):java.util.List");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:2|3|4|(1:6)|7|8|(1:10)) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0018 */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x001c A[Catch:{ Exception -> 0x002e }] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean m40401a() {
        /*
            java.lang.reflect.Field r0 = f56131a
            r1 = 1
            if (r0 != 0) goto L_0x002f
            java.lang.String r0 = "android.view.ViewGroup"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ Exception -> 0x0018 }
            if (r0 == 0) goto L_0x0018
            java.lang.String r2 = "mFirstTouchTarget"
            java.lang.reflect.Field r0 = r0.getDeclaredField(r2)     // Catch:{ Exception -> 0x0018 }
            f56131a = r0     // Catch:{ Exception -> 0x0018 }
            r0.setAccessible(r1)     // Catch:{ Exception -> 0x0018 }
        L_0x0018:
            java.lang.reflect.Field r0 = f56131a     // Catch:{ Exception -> 0x002e }
            if (r0 == 0) goto L_0x002f
            java.lang.reflect.Field r0 = f56131a     // Catch:{ Exception -> 0x002e }
            java.lang.Class r0 = r0.getType()     // Catch:{ Exception -> 0x002e }
            java.lang.String r2 = "child"
            java.lang.reflect.Field r0 = r0.getDeclaredField(r2)     // Catch:{ Exception -> 0x002e }
            f56132b = r0     // Catch:{ Exception -> 0x002e }
            r0.setAccessible(r1)     // Catch:{ Exception -> 0x002e }
            goto L_0x002f
        L_0x002e:
        L_0x002f:
            java.lang.reflect.Field r0 = f56131a
            if (r0 == 0) goto L_0x0038
            java.lang.reflect.Field r0 = f56132b
            if (r0 == 0) goto L_0x0038
            goto L_0x0039
        L_0x0038:
            r1 = 0
        L_0x0039:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaojuchefu.prism.monitor.touch.TouchTracker.m40401a():boolean");
    }

    /* renamed from: a */
    private static View m40400a(ViewGroup viewGroup) {
        try {
            Object obj = f56131a.get(viewGroup);
            if (obj == null) {
                return null;
            }
            Object obj2 = f56132b.get(obj);
            if (obj2 instanceof View) {
                return (View) obj2;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static View filterView(View view, int[] iArr) {
        if ((view instanceof AbsListView) || (view instanceof RecyclerView)) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                Rect rect = new Rect();
                childAt.getGlobalVisibleRect(rect);
                if (rect.contains(iArr[0], iArr[1])) {
                    return childAt;
                }
            }
        } else if ((view instanceof ScrollView) || (view instanceof HorizontalScrollView)) {
            return null;
        }
        return view;
    }
}
