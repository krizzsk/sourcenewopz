package com.didi.safetoolkit.business.monitor;

public interface ISMonitorCallback {
    void onFailed(Exception exc);

    void onSuccess(String str);
}
