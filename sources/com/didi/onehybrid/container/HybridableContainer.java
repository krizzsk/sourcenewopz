package com.didi.onehybrid.container;

import android.app.Activity;

public interface HybridableContainer {
    Activity getActivity();

    Object getExportModuleInstance(Class cls);

    UpdateUIHandler getUpdateUIHandler();

    FusionWebView getWebView();
}
