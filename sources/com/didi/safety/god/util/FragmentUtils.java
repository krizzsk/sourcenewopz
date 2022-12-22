package com.didi.safety.god.util;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class FragmentUtils {
    private FragmentUtils() {
    }

    public static void closeFragment(Fragment fragment) {
        FragmentManager fragmentManager = fragment.getFragmentManager();
        if (fragmentManager != null) {
            if (!fragmentManager.isStateSaved()) {
                fragmentManager.popBackStackImmediate();
                return;
            }
            LogUtils.m24580e("cannot close " + fragment + ", cause state saved!!!");
        }
    }
}
