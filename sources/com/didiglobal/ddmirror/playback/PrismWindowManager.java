package com.didiglobal.ddmirror.playback;

import android.app.Activity;
import android.view.Window;
import java.util.ArrayList;
import java.util.List;

public class PrismWindowManager {
    private static PrismWindowManager sPrismWindowManager;
    private List<PrismWindow> mPrismWindows = new ArrayList();

    public static PrismWindowManager getInstance() {
        if (sPrismWindowManager == null) {
            sPrismWindowManager = new PrismWindowManager();
        }
        return sPrismWindowManager;
    }

    public void addPrismWindow(PrismWindow prismWindow) {
        this.mPrismWindows.add(prismWindow);
    }

    public void removePrismWindow(Window window) {
        for (int i = 0; i < this.mPrismWindows.size(); i++) {
            if (this.mPrismWindows.get(i).getWindow() == window) {
                this.mPrismWindows.remove(i);
                return;
            }
        }
    }

    public PrismWindow getTopWindow() {
        Activity currentActivity;
        if (this.mPrismWindows.size() == 0 || (currentActivity = AppLifecycler.getInstance().getCurrentActivity()) == null) {
            return null;
        }
        for (int size = this.mPrismWindows.size() - 1; size >= 0; size--) {
            PrismWindow prismWindow = this.mPrismWindows.get(size);
            Window window = prismWindow.getWindow();
            if (window.getAttributes().type == 1) {
                if (window == currentActivity.getWindow()) {
                    return prismWindow;
                }
            } else if (window.getAttributes().type == 2 && window.getAttributes().getTitle().equals(currentActivity.getWindow().getAttributes().getTitle())) {
                return prismWindow;
            }
        }
        return null;
    }
}
