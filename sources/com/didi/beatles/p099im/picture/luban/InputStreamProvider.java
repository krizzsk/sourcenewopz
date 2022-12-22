package com.didi.beatles.p099im.picture.luban;

import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.didi.beatles.im.picture.luban.InputStreamProvider */
public interface InputStreamProvider {
    void close();

    String getPath();

    InputStream open() throws IOException;
}
