package com.didi.app.nova.skeleton.image;

import java.io.File;

public interface ImageDownloadListener {
    void onFailure(Exception exc);

    void onSuccess(File file);
}
