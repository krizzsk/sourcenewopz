package com.didi.sdk.util;

import android.content.Context;
import android.view.accessibility.AccessibilityManager;

public class AccessibilityUtil {
    public static boolean isAccessibilityEnabled(Context context) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
        if (accessibilityManager.getEnabledAccessibilityServiceList(1).isEmpty() || !accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        return true;
    }
}
