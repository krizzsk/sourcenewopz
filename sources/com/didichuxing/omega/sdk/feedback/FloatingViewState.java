package com.didichuxing.omega.sdk.feedback;

import com.didichuxing.afanty.beans.SmileMenuItem;
import com.didichuxing.omega.sdk.uicomponents.floatingview.FloatingViewApi;
import java.util.HashMap;
import java.util.Map;

public class FloatingViewState {
    private static FloatingViewState instance;
    private Map<String, SmileMenuItem> smileMenuItemMap = new HashMap();

    public static synchronized FloatingViewState getInstance() {
        FloatingViewState floatingViewState;
        synchronized (FloatingViewState.class) {
            if (instance == null) {
                instance = new FloatingViewState();
            }
            floatingViewState = instance;
        }
        return floatingViewState;
    }

    public void addMenuItemState(SmileMenuItem smileMenuItem) {
        this.smileMenuItemMap.put(smileMenuItem.getText(), smileMenuItem);
    }

    public void clearDynamicMenuItem() {
        for (String removeSubMenuItem : this.smileMenuItemMap.keySet()) {
            FloatingViewApi.removeSubMenuItem(removeSubMenuItem);
        }
    }
}
