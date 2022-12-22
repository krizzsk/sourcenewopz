package com.didi.address;

import android.app.Activity;

public class TransparentStatusBarManager {
    public static TransparentStatusBarManager manager;
    public OnStatusBarTransparentListener listener;

    public interface OnStatusBarTransparentListener {
        void OnStartusBarTransparent(Activity activity);
    }

    private TransparentStatusBarManager() {
    }

    public static synchronized TransparentStatusBarManager getInstance() {
        TransparentStatusBarManager transparentStatusBarManager;
        synchronized (TransparentStatusBarManager.class) {
            if (manager == null) {
                manager = new TransparentStatusBarManager();
            }
            transparentStatusBarManager = manager;
        }
        return transparentStatusBarManager;
    }

    public OnStatusBarTransparentListener getOnStatusBarTransparentListener() {
        return this.listener;
    }

    public void setOnStatusBarTransparentListener(OnStatusBarTransparentListener onStatusBarTransparentListener) {
        this.listener = onStatusBarTransparentListener;
    }
}
