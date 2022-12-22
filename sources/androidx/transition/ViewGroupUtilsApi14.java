package androidx.transition;

import android.animation.LayoutTransition;
import com.didi.sdk.apm.SystemUtils;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ViewGroupUtilsApi14 {
    private static final int LAYOUT_TRANSITION_CHANGING = 4;
    private static final String TAG = "ViewGroupUtilsApi14";
    private static Method sCancelMethod;
    private static boolean sCancelMethodFetched;
    private static LayoutTransition sEmptyLayoutTransition;
    private static Field sLayoutSuppressedField;
    private static boolean sLayoutSuppressedFieldFetched;

    /* JADX WARNING: Removed duplicated region for block: B:34:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void suppressLayout(android.view.ViewGroup r10, boolean r11) {
        /*
            android.animation.LayoutTransition r0 = sEmptyLayoutTransition
            r1 = 1
            r2 = 0
            r3 = 0
            if (r0 != 0) goto L_0x0028
            androidx.transition.ViewGroupUtilsApi14$1 r0 = new androidx.transition.ViewGroupUtilsApi14$1
            r0.<init>()
            sEmptyLayoutTransition = r0
            r4 = 2
            r0.setAnimator(r4, r3)
            android.animation.LayoutTransition r0 = sEmptyLayoutTransition
            r0.setAnimator(r2, r3)
            android.animation.LayoutTransition r0 = sEmptyLayoutTransition
            r0.setAnimator(r1, r3)
            android.animation.LayoutTransition r0 = sEmptyLayoutTransition
            r4 = 3
            r0.setAnimator(r4, r3)
            android.animation.LayoutTransition r0 = sEmptyLayoutTransition
            r4 = 4
            r0.setAnimator(r4, r3)
        L_0x0028:
            if (r11 == 0) goto L_0x0048
            android.animation.LayoutTransition r11 = r10.getLayoutTransition()
            if (r11 == 0) goto L_0x0042
            boolean r0 = r11.isRunning()
            if (r0 == 0) goto L_0x0039
            cancelLayoutTransition(r11)
        L_0x0039:
            android.animation.LayoutTransition r0 = sEmptyLayoutTransition
            if (r11 == r0) goto L_0x0042
            int r0 = androidx.transition.C0773R.C0776id.transition_layout_save
            r10.setTag(r0, r11)
        L_0x0042:
            android.animation.LayoutTransition r11 = sEmptyLayoutTransition
            r10.setLayoutTransition(r11)
            goto L_0x00a4
        L_0x0048:
            r10.setLayoutTransition(r3)
            boolean r11 = sLayoutSuppressedFieldFetched
            if (r11 != 0) goto L_0x006c
            java.lang.Class<android.view.ViewGroup> r11 = android.view.ViewGroup.class
            java.lang.String r0 = "mLayoutSuppressed"
            java.lang.reflect.Field r11 = r11.getDeclaredField(r0)     // Catch:{ NoSuchFieldException -> 0x005d }
            sLayoutSuppressedField = r11     // Catch:{ NoSuchFieldException -> 0x005d }
            r11.setAccessible(r1)     // Catch:{ NoSuchFieldException -> 0x005d }
            goto L_0x006a
        L_0x005d:
            r4 = 4
            r7 = 0
            r9 = 80
            java.lang.String r5 = "ViewGroupUtilsApi14"
            java.lang.String r6 = "Failed to access mLayoutSuppressed field by reflection"
            java.lang.String r8 = "androidx.transition.ViewGroupUtilsApi14"
            com.didi.sdk.apm.SystemUtils.log(r4, r5, r6, r7, r8, r9)
        L_0x006a:
            sLayoutSuppressedFieldFetched = r1
        L_0x006c:
            java.lang.reflect.Field r11 = sLayoutSuppressedField
            if (r11 == 0) goto L_0x008d
            boolean r11 = r11.getBoolean(r10)     // Catch:{ IllegalAccessException -> 0x0080 }
            if (r11 == 0) goto L_0x007e
            java.lang.reflect.Field r0 = sLayoutSuppressedField     // Catch:{ IllegalAccessException -> 0x007c }
            r0.setBoolean(r10, r2)     // Catch:{ IllegalAccessException -> 0x007c }
            goto L_0x007e
        L_0x007c:
            r2 = r11
            goto L_0x0080
        L_0x007e:
            r2 = r11
            goto L_0x008d
        L_0x0080:
            r4 = 4
            r7 = 0
            r9 = 92
            java.lang.String r5 = "ViewGroupUtilsApi14"
            java.lang.String r6 = "Failed to get mLayoutSuppressed field by reflection"
            java.lang.String r8 = "androidx.transition.ViewGroupUtilsApi14"
            com.didi.sdk.apm.SystemUtils.log(r4, r5, r6, r7, r8, r9)
        L_0x008d:
            if (r2 == 0) goto L_0x0092
            r10.requestLayout()
        L_0x0092:
            int r11 = androidx.transition.C0773R.C0776id.transition_layout_save
            java.lang.Object r11 = r10.getTag(r11)
            android.animation.LayoutTransition r11 = (android.animation.LayoutTransition) r11
            if (r11 == 0) goto L_0x00a4
            int r0 = androidx.transition.C0773R.C0776id.transition_layout_save
            r10.setTag(r0, r3)
            r10.setLayoutTransition(r11)
        L_0x00a4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.ViewGroupUtilsApi14.suppressLayout(android.view.ViewGroup, boolean):void");
    }

    private static void cancelLayoutTransition(LayoutTransition layoutTransition) {
        if (!sCancelMethodFetched) {
            try {
                Method declaredMethod = LayoutTransition.class.getDeclaredMethod("cancel", new Class[0]);
                sCancelMethod = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
                SystemUtils.log(4, TAG, "Failed to access cancel method by reflection", (Throwable) null, "androidx.transition.ViewGroupUtilsApi14", 114);
            }
            sCancelMethodFetched = true;
        }
        Method method = sCancelMethod;
        if (method != null) {
            try {
                method.invoke(layoutTransition, new Object[0]);
            } catch (IllegalAccessException unused2) {
                SystemUtils.log(4, TAG, "Failed to access cancel method by reflection", (Throwable) null, "androidx.transition.ViewGroupUtilsApi14", 122);
            } catch (InvocationTargetException unused3) {
                SystemUtils.log(4, TAG, "Failed to invoke cancel method by reflection", (Throwable) null, "androidx.transition.ViewGroupUtilsApi14", 124);
            }
        }
    }

    private ViewGroupUtilsApi14() {
    }
}
