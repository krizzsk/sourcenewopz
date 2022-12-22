package com.didi.map.core.download;

public interface MapDownloadListener {
    void onCancel(String str);

    void onData(String str, byte[] bArr);

    void onFail(String str);
}
