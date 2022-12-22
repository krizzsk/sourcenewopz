package com.didiglobal.privacy.domainmonitor.urlconnection;

import java.io.IOException;
import java.io.OutputStream;

public class FlowOutputStream extends OutputStream {

    /* renamed from: a */
    private final OutputStream f50547a;

    /* renamed from: b */
    private final OutputStreamStatusListener f50548b;

    /* renamed from: c */
    private long f50549c;

    interface OutputStreamStatusListener {
        void onWriteFinished(long j);
    }

    public FlowOutputStream(OutputStream outputStream, OutputStreamStatusListener outputStreamStatusListener) {
        this.f50547a = outputStream;
        this.f50548b = outputStreamStatusListener;
    }

    public long getUploadByteCountAndClear() {
        long j = this.f50549c;
        this.f50549c = 0;
        return j;
    }

    public void write(byte[] bArr) throws IOException {
        this.f50547a.write(bArr);
        if (bArr != null) {
            m36327a(bArr.length);
        }
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.f50547a.write(bArr, i, i2);
        m36327a(i2);
    }

    public void flush() throws IOException {
        this.f50547a.flush();
    }

    public void close() throws IOException {
        this.f50547a.close();
        OutputStreamStatusListener outputStreamStatusListener = this.f50548b;
        if (outputStreamStatusListener != null) {
            outputStreamStatusListener.onWriteFinished(this.f50549c);
        }
    }

    public int hashCode() {
        return this.f50547a.hashCode();
    }

    public boolean equals(Object obj) {
        return this.f50547a.equals(obj);
    }

    public String toString() {
        return this.f50547a.toString();
    }

    public void write(int i) throws IOException {
        this.f50547a.write(i);
        m36327a(1);
    }

    /* renamed from: a */
    private void m36327a(int i) {
        if (i > 0) {
            this.f50549c += (long) i;
        }
    }
}
