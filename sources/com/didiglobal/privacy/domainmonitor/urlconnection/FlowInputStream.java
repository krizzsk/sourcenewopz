package com.didiglobal.privacy.domainmonitor.urlconnection;

import java.io.IOException;
import java.io.InputStream;

public class FlowInputStream extends InputStream {

    /* renamed from: a */
    private final InputStream f50544a;

    /* renamed from: b */
    private final InputStreamStatusListener f50545b;

    /* renamed from: c */
    private long f50546c;

    interface InputStreamStatusListener {
        void onReadFinished(long j);
    }

    public FlowInputStream(InputStream inputStream, InputStreamStatusListener inputStreamStatusListener) {
        this.f50544a = inputStream;
        this.f50545b = inputStreamStatusListener;
    }

    public int read() throws IOException {
        int read = this.f50544a.read();
        m36326a(1);
        return read;
    }

    public int read(byte[] bArr) throws IOException {
        int read = this.f50544a.read(bArr);
        m36326a(read);
        return read;
    }

    /* renamed from: a */
    private void m36326a(int i) {
        if (i > 0) {
            this.f50546c += (long) i;
        }
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        int read = this.f50544a.read(bArr, i, i2);
        m36326a(read);
        return read;
    }

    public long skip(long j) throws IOException {
        long skip = this.f50544a.skip(j);
        m36326a((int) skip);
        return skip;
    }

    public int available() throws IOException {
        return this.f50544a.available();
    }

    public void close() throws IOException {
        this.f50544a.close();
        this.f50545b.onReadFinished(this.f50546c);
        this.f50546c = 0;
    }

    public synchronized void mark(int i) {
        this.f50544a.mark(i);
    }

    public synchronized void reset() throws IOException {
        this.f50544a.reset();
    }

    public boolean markSupported() {
        return this.f50544a.markSupported();
    }

    public int hashCode() {
        return this.f50544a.hashCode();
    }

    public boolean equals(Object obj) {
        return this.f50544a.equals(obj);
    }

    public String toString() {
        return this.f50544a.toString();
    }
}
