package com.koushikdutta.async;

import com.koushikdutta.async.callback.DataCallback;

public class DataEmitterReader implements DataCallback {

    /* renamed from: d */
    static final /* synthetic */ boolean f55208d = (!DataEmitterReader.class.desiredAssertionStatus());

    /* renamed from: a */
    DataCallback f55209a;

    /* renamed from: b */
    int f55210b;

    /* renamed from: c */
    ByteBufferList f55211c = new ByteBufferList();

    public void read(int i, DataCallback dataCallback) {
        if (f55208d || this.f55209a == null) {
            this.f55210b = i;
            this.f55209a = dataCallback;
            if (f55208d || !this.f55211c.hasRemaining()) {
                this.f55211c.recycle();
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    private boolean m39731a(DataEmitter dataEmitter) {
        if (this.f55210b > this.f55211c.remaining()) {
            return false;
        }
        DataCallback dataCallback = this.f55209a;
        this.f55209a = null;
        dataCallback.onDataAvailable(dataEmitter, this.f55211c);
        if (f55208d || !this.f55211c.hasRemaining()) {
            return true;
        }
        throw new AssertionError();
    }

    public void onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
        if (f55208d || this.f55209a != null) {
            do {
                byteBufferList.get(this.f55211c, Math.min(byteBufferList.remaining(), this.f55210b - this.f55211c.remaining()));
                byteBufferList.remaining();
                if (!m39731a(dataEmitter) || this.f55209a == null) {
                    byteBufferList.remaining();
                }
                byteBufferList.get(this.f55211c, Math.min(byteBufferList.remaining(), this.f55210b - this.f55211c.remaining()));
                byteBufferList.remaining();
                break;
            } while (this.f55209a == null);
            byteBufferList.remaining();
            return;
        }
        throw new AssertionError();
    }
}
