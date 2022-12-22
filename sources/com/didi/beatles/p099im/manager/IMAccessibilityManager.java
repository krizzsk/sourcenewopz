package com.didi.beatles.p099im.manager;

import android.view.accessibility.AccessibilityManager;
import com.didi.beatles.p099im.IMContextInfoHelper;

/* renamed from: com.didi.beatles.im.manager.IMAccessibilityManager */
public class IMAccessibilityManager {

    /* renamed from: a */
    private static IMAccessibilityManager f9224a;

    /* renamed from: b */
    private AccessibilityManager f9225b;

    public static IMAccessibilityManager getInstance() {
        if (f9224a == null) {
            f9224a = new IMAccessibilityManager();
        }
        return f9224a;
    }

    private IMAccessibilityManager() {
        try {
            this.f9225b = (AccessibilityManager) IMContextInfoHelper.getContext().getSystemService("accessibility");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isEnabled() {
        AccessibilityManager accessibilityManager = this.f9225b;
        if (accessibilityManager != null) {
            return accessibilityManager.isEnabled();
        }
        return false;
    }
}
