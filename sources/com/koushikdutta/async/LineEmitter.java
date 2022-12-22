package com.koushikdutta.async;

import com.koushikdutta.async.callback.DataCallback;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public class LineEmitter implements DataCallback {

    /* renamed from: d */
    static final /* synthetic */ boolean f55219d = (!LineEmitter.class.desiredAssertionStatus());

    /* renamed from: a */
    Charset f55220a;

    /* renamed from: b */
    ByteBufferList f55221b;

    /* renamed from: c */
    StringCallback f55222c;

    public interface StringCallback {
        void onStringAvailable(String str);
    }

    public LineEmitter() {
        this((Charset) null);
    }

    public LineEmitter(Charset charset) {
        this.f55221b = new ByteBufferList();
        this.f55220a = charset;
    }

    public void setLineCallback(StringCallback stringCallback) {
        this.f55222c = stringCallback;
    }

    public StringCallback getLineCallback() {
        return this.f55222c;
    }

    public void onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
        ByteBuffer allocate = ByteBuffer.allocate(byteBufferList.remaining());
        while (byteBufferList.remaining() > 0) {
            byte b = byteBufferList.get();
            if (b != 10) {
                allocate.put(b);
            } else if (f55219d || this.f55222c != null) {
                allocate.flip();
                this.f55221b.add(allocate);
                this.f55222c.onStringAvailable(this.f55221b.readString(this.f55220a));
                this.f55221b = new ByteBufferList();
                return;
            } else {
                throw new AssertionError();
            }
        }
        allocate.flip();
        this.f55221b.add(allocate);
    }
}
