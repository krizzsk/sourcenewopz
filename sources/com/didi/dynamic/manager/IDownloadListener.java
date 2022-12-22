package com.didi.dynamic.manager;

public interface IDownloadListener {
    public static final int DOWNLOAD_FAILED = 0;
    public static final int DOWNLOAD_SUCCESS = 1;

    void onDownloadEnd(Module module, int i) throws Exception;

    void onDownloadStart(Module module) throws Exception;

    void onFinishAllDownload() throws Exception;
}
