package com.didichuxing.dfbasesdk.downloader;

public interface FileDownloaderListener {
    void failed(Throwable th);

    void progress(int i);

    void success(String str, String str2);
}
