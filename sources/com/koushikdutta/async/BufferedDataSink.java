package com.koushikdutta.async;

import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.WritableCallback;

public class BufferedDataSink implements DataSink {

    /* renamed from: g */
    static final /* synthetic */ boolean f55192g = (!BufferedDataSink.class.desiredAssertionStatus());

    /* renamed from: a */
    DataSink f55193a;

    /* renamed from: b */
    boolean f55194b;

    /* renamed from: c */
    final ByteBufferList f55195c = new ByteBufferList();

    /* renamed from: d */
    WritableCallback f55196d;

    /* renamed from: e */
    int f55197e = Integer.MAX_VALUE;

    /* renamed from: f */
    boolean f55198f;

    /* access modifiers changed from: protected */
    public void onDataAccepted(ByteBufferList byteBufferList) {
    }

    public BufferedDataSink(DataSink dataSink) {
        setDataSink(dataSink);
    }

    public boolean isBuffering() {
        return this.f55195c.hasRemaining() || this.f55194b;
    }

    public boolean isWritable() {
        boolean z;
        synchronized (this.f55195c) {
            z = this.f55195c.remaining() < this.f55197e;
        }
        return z;
    }

    public DataSink getDataSink() {
        return this.f55193a;
    }

    public void forceBuffering(boolean z) {
        this.f55194b = z;
        if (!z) {
            m39726a();
        }
    }

    public void setDataSink(DataSink dataSink) {
        this.f55193a = dataSink;
        dataSink.setWriteableCallback(new WritableCallback() {
            public final void onWriteable() {
                BufferedDataSink.this.m39726a();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m39726a() {
        boolean isEmpty;
        WritableCallback writableCallback;
        if (!this.f55194b) {
            synchronized (this.f55195c) {
                this.f55193a.write(this.f55195c);
                isEmpty = this.f55195c.isEmpty();
            }
            if (isEmpty && this.f55198f) {
                this.f55193a.end();
            }
            if (isEmpty && (writableCallback = this.f55196d) != null) {
                writableCallback.onWriteable();
            }
        }
    }

    public void write(ByteBufferList byteBufferList) {
        if (getServer().getAffinity() != Thread.currentThread()) {
            synchronized (this.f55195c) {
                if (this.f55195c.remaining() < this.f55197e) {
                    onDataAccepted(byteBufferList);
                    byteBufferList.get(this.f55195c);
                    getServer().post(new Runnable() {
                        public final void run() {
                            BufferedDataSink.this.m39726a();
                        }
                    });
                    return;
                }
                return;
            }
        }
        onDataAccepted(byteBufferList);
        if (!isBuffering()) {
            this.f55193a.write(byteBufferList);
        }
        synchronized (this.f55195c) {
            byteBufferList.get(this.f55195c);
        }
    }

    public void setWriteableCallback(WritableCallback writableCallback) {
        this.f55196d = writableCallback;
    }

    public WritableCallback getWriteableCallback() {
        return this.f55196d;
    }

    public int remaining() {
        return this.f55195c.remaining();
    }

    public int getMaxBuffer() {
        return this.f55197e;
    }

    public void setMaxBuffer(int i) {
        if (f55192g || i >= 0) {
            this.f55197e = i;
            return;
        }
        throw new AssertionError();
    }

    public boolean isOpen() {
        return this.f55193a.isOpen();
    }

    public void end() {
        if (getServer().getAffinity() != Thread.currentThread()) {
            getServer().post(new Runnable() {
                public final void run() {
                    BufferedDataSink.this.end();
                }
            });
            return;
        }
        synchronized (this.f55195c) {
            if (this.f55195c.hasRemaining()) {
                this.f55198f = true;
            } else {
                this.f55193a.end();
            }
        }
    }

    public void setClosedCallback(CompletedCallback completedCallback) {
        this.f55193a.setClosedCallback(completedCallback);
    }

    public CompletedCallback getClosedCallback() {
        return this.f55193a.getClosedCallback();
    }

    public AsyncServer getServer() {
        return this.f55193a.getServer();
    }
}
