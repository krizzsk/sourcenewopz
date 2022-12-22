package com.didi.beatles.p099im.picture.luban;

import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.didi.beatles.im.picture.luban.InputStreamAdapter */
public abstract class InputStreamAdapter implements InputStreamProvider {
    private InputStream inputStream;

    public abstract InputStream openInternal() throws IOException;

    public InputStream open() throws IOException {
        close();
        InputStream openInternal = openInternal();
        this.inputStream = openInternal;
        return openInternal;
    }

    public void close() {
        InputStream inputStream2 = this.inputStream;
        if (inputStream2 != null) {
            try {
                inputStream2.close();
            } catch (IOException unused) {
            } catch (Throwable th) {
                this.inputStream = null;
                throw th;
            }
            this.inputStream = null;
        }
    }
}
