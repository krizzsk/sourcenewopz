package com.didi.onehybrid.resource;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;

public class FusionBridgeStream extends InputStream {

    /* renamed from: a */
    private BufferedInputStream f29668a;

    /* renamed from: b */
    private boolean f29669b = false;

    /* renamed from: c */
    private ByteArrayOutputStream f29670c;

    /* renamed from: d */
    private WeakReference<OnCloseListener> f29671d;

    public interface OnCloseListener {
        void onClose(boolean z, ByteArrayOutputStream byteArrayOutputStream);
    }

    public FusionBridgeStream(BufferedInputStream bufferedInputStream) {
        this.f29668a = bufferedInputStream;
        this.f29670c = new ByteArrayOutputStream();
    }

    public void setOnCloseListener(OnCloseListener onCloseListener) {
        this.f29671d = new WeakReference<>(onCloseListener);
    }

    public int read() throws IOException {
        int read = this.f29668a.read();
        if (read != -1) {
            this.f29670c.write(read);
        } else {
            this.f29669b = true;
        }
        return read;
    }

    public void close() throws IOException {
        OnCloseListener onCloseListener;
        this.f29668a.close();
        WeakReference<OnCloseListener> weakReference = this.f29671d;
        if (!(weakReference == null || (onCloseListener = (OnCloseListener) weakReference.get()) == null)) {
            onCloseListener.onClose(this.f29669b, this.f29670c);
        }
        this.f29670c = null;
    }
}
