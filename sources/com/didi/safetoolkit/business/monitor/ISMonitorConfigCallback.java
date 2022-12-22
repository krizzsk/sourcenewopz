package com.didi.safetoolkit.business.monitor;

import com.didi.safetoolkit.business.toolkit.model.SfViewMonitorMenuModel;

public interface ISMonitorConfigCallback {
    void onFailed(String str);

    void onSuccess(SfViewMonitorMenuModel sfViewMonitorMenuModel);
}
