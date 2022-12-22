package com.didi.dimina.container.secondparty.bundle.http;

import java.io.File;

public interface PmDownloadCallback {
    void onFailed(Exception exc);

    void onStart();

    void onSucceed(File file);
}
