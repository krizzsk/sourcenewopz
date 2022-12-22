package com.didi.component.common.util;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.app.SuperAppBusinessManager;
import com.didi.sdk.util.SaApolloUtil;

public class GoBackRootUtils {

    /* renamed from: a */
    private static String f11767a = "com.didi.component.framework.template.home.HomeTemplateFragment";

    /* renamed from: b */
    private static String f11768b = "com.didiglobal.eevee_framework.node.page.FirstFragment";
    public static boolean isBackHome = false;

    public static boolean hasGobackRideHome(FragmentManager fragmentManager, Bundle bundle) {
        if (SaApolloUtil.INSTANCE.getSaState()) {
            int backStackEntryCount = fragmentManager.getBackStackEntryCount();
            int i = 0;
            while (i < backStackEntryCount) {
                String name = fragmentManager.getBackStackEntryAt(i).getName();
                int id = fragmentManager.getBackStackEntryAt(i).getId();
                SystemUtils.log(3, "dongxt", "======name ======" + name + "? id=" + id, (Throwable) null, "com.didi.component.common.util.GoBackRootUtils", 27);
                if (f11767a.equals(name) && SuperAppBusinessManager.INSTANCE.getCommonBusinessContext() != null) {
                    isBackHome = true;
                    SuperAppBusinessManager.INSTANCE.getCommonBusinessContext().getNavigation().popBackStack(f11767a, 0, bundle);
                    return true;
                } else if (!f11768b.equals(name) || SuperAppBusinessManager.INSTANCE.getCommonBusinessContext() == null) {
                    i++;
                } else {
                    SuperAppBusinessManager.INSTANCE.getCommonBusinessContext().getNavigation().popBackStack(f11768b, 0, bundle);
                    return true;
                }
            }
        }
        return false;
    }
}
