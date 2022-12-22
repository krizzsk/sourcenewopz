package com.didi.foundation.sdk.upgrade;

public interface DownloadListener {
    void onDownloadFailed(int i, String str);

    void onDownloadProgress(int i);

    void onDownloadStart();

    void onDownloadSuccess();
}
