package com.didichuxing.dfbasesdk.download;

@Deprecated
public interface IDownloadListener {
    void failed(Exception exc);

    void progress(int i);

    void success(String str, String str2);
}
