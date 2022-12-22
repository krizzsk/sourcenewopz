package com.didi.component.business.util;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.didi.sdk.app.ActivityLifecycleManager;
import java.util.List;

public class FragmentUtils {
    public static Fragment getTopFragment(FragmentActivity fragmentActivity) {
        return getLastIndexFragment(fragmentActivity.getSupportFragmentManager(), 1);
    }

    public static android.app.Fragment getTopFragment(Activity activity) {
        return getLastIndexFragment(activity.getFragmentManager(), 1);
    }

    public static Fragment getLastIndexFragment(FragmentManager fragmentManager, int i) {
        int backStackEntryCount = fragmentManager.getBackStackEntryCount();
        if (backStackEntryCount <= i - 1) {
            return null;
        }
        return fragmentManager.findFragmentByTag(fragmentManager.getBackStackEntryAt(backStackEntryCount - i).getName());
    }

    public static android.app.Fragment getLastIndexFragment(android.app.FragmentManager fragmentManager, int i) {
        int backStackEntryCount = fragmentManager.getBackStackEntryCount();
        if (backStackEntryCount <= i - 1) {
            return null;
        }
        return fragmentManager.findFragmentByTag(fragmentManager.getBackStackEntryAt(backStackEntryCount - i).getName());
    }

    public static Fragment getTopVisibleFragment() {
        Activity currentActivity = ActivityLifecycleManager.getInstance().getCurrentActivity();
        if (!(currentActivity instanceof FragmentActivity)) {
            return null;
        }
        List<Fragment> fragments = ((FragmentActivity) currentActivity).getSupportFragmentManager().getFragments();
        for (int size = fragments.size() - 1; size >= 0; size--) {
            Fragment fragment = fragments.get(size);
            if (fragment.isVisible() && fragment.getUserVisibleHint()) {
                return fragment;
            }
        }
        return null;
    }
}
