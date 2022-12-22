package com.didi.dimina.webview.resource;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;

public class FusionBridgeStream extends InputStream {

    /* renamed from: a */
    private final BufferedInputStream f18319a;

    /* renamed from: b */
    private boolean f18320b = false;

    /* renamed from: c */
    private ByteArrayOutputStream f18321c;

    /* renamed from: d */
    private WeakReference<OnCloseListener> f18322d;

    public interface OnCloseListener {
        void onClose(boolean z, ByteArrayOutputStream byteArrayOutputStream);
    }

    public FusionBridgeStream(BufferedInputStream bufferedInputStream) {
        this.f18319a = bufferedInputStream;
        this.f18321c = new ByteArrayOutputStream();
    }

    public void setOnCloseListener(OnCloseListener onCloseListener) {
        this.f18322d = new WeakReference<>(onCloseListener);
    }

    public int read() throws IOException {
        int read = this.f18319a.read();
        if (read != -1) {
            this.f18321c.write(read);
        } else {
            this.f18320b = true;
        }
        return read;
    }

    public void close() throws IOException {
        OnCloseListener onCloseListener;
        this.f18319a.close();
        WeakReference<OnCloseListener> weakReference = this.f18322d;
        if (!(weakReference == null || (onCloseListener = (OnCloseListener) weakReference.get()) == null)) {
            onCloseListener.onClose(this.f18320b, this.f18321c);
        }
        this.f18321c = null;
    }
}
