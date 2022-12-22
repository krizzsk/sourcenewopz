package com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.instrumentation.p191io;

import java.io.IOException;
import java.io.OutputStream;

/* renamed from: com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.instrumentation.io.CountingOutputStream */
public final class CountingOutputStream extends OutputStream implements StreamCompleteListenerSource {

    /* renamed from: a */
    private final OutputStream f47994a;

    /* renamed from: b */
    private long f47995b;

    /* renamed from: c */
    private final C15778a f47996c = new C15778a();

    public CountingOutputStream(OutputStream outputStream) {
        this.f47994a = outputStream;
    }

    public void addStreamCompleteListener(StreamCompleteListener streamCompleteListener) {
        this.f47996c.mo118238a(streamCompleteListener);
    }

    public void removeStreamCompleteListener(StreamCompleteListener streamCompleteListener) {
        this.f47996c.mo118241b(streamCompleteListener);
    }

    public long getCount() {
        return this.f47995b;
    }

    public void write(int i) throws IOException {
        try {
            this.f47994a.write(i);
            this.f47995b++;
        } catch (IOException e) {
            m34258a(e);
            throw e;
        }
    }

    public void write(byte[] bArr) throws IOException {
        try {
            this.f47994a.write(bArr);
            this.f47995b += (long) bArr.length;
        } catch (IOException e) {
            m34258a(e);
            throw e;
        }
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        try {
            this.f47994a.write(bArr, i, i2);
            this.f47995b += (long) i2;
        } catch (IOException e) {
            m34258a(e);
            throw e;
        }
    }

    public void flush() throws IOException {
        try {
            this.f47994a.flush();
        } catch (IOException e) {
            m34258a(e);
            throw e;
        }
    }

    public void close() throws IOException {
        try {
            this.f47994a.close();
            m34257a();
        } catch (IOException e) {
            m34258a(e);
            throw e;
        }
    }

    /* renamed from: a */
    private void m34257a() {
        if (!this.f47996c.mo118239a()) {
            this.f47996c.mo118237a(new StreamCompleteEvent(this, this.f47995b));
        }
    }

    /* renamed from: a */
    private void m34258a(Exception exc) {
        if (!this.f47996c.mo118239a()) {
            this.f47996c.mo118240b(new StreamCompleteEvent(this, this.f47995b, exc));
        }
    }
}
