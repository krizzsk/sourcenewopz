package com.koushikdutta.async;

import com.didi.sdk.apm.SystemUtils;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.DataCallback;
import com.koushikdutta.async.callback.WritableCallback;
import com.koushikdutta.async.util.Allocator;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.CancelledKeyException;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;

public class AsyncNetworkSocket implements AsyncSocket {

    /* renamed from: j */
    static final /* synthetic */ boolean f55136j = (!AsyncNetworkSocket.class.desiredAssertionStatus());

    /* renamed from: a */
    InetSocketAddress f55137a;

    /* renamed from: b */
    Allocator f55138b;

    /* renamed from: c */
    boolean f55139c;

    /* renamed from: d */
    WritableCallback f55140d;

    /* renamed from: e */
    DataCallback f55141e;

    /* renamed from: f */
    CompletedCallback f55142f;

    /* renamed from: g */
    boolean f55143g;

    /* renamed from: h */
    Exception f55144h;

    /* renamed from: i */
    boolean f55145i = false;

    /* renamed from: k */
    private C20146a f55146k;

    /* renamed from: l */
    private SelectionKey f55147l;

    /* renamed from: m */
    private AsyncServer f55148m;

    /* renamed from: n */
    private ByteBufferList f55149n = new ByteBufferList();

    /* renamed from: o */
    private CompletedCallback f55150o;

    public String charset() {
        return null;
    }

    AsyncNetworkSocket() {
    }

    public void end() {
        this.f55146k.mo163895b();
    }

    public boolean isChunked() {
        return this.f55146k.mo163898d();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo163692a(SocketChannel socketChannel, InetSocketAddress inetSocketAddress) throws IOException {
        this.f55137a = inetSocketAddress;
        this.f55138b = new Allocator();
        this.f55146k = new C20152e(socketChannel);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo163691a(DatagramChannel datagramChannel) throws IOException {
        this.f55146k = new C20147b(datagramChannel);
        this.f55138b = new Allocator(8192);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C20146a mo163688a() {
        return this.f55146k;
    }

    public void onDataWritable() {
        if (!this.f55146k.mo163898d()) {
            SelectionKey selectionKey = this.f55147l;
            selectionKey.interestOps(selectionKey.interestOps() & -5);
        }
        WritableCallback writableCallback = this.f55140d;
        if (writableCallback != null) {
            writableCallback.onWriteable();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo163689a(AsyncServer asyncServer, SelectionKey selectionKey) {
        this.f55148m = asyncServer;
        this.f55147l = selectionKey;
    }

    public void write(final ByteBufferList byteBufferList) {
        if (this.f55148m.getAffinity() != Thread.currentThread()) {
            this.f55148m.run(new Runnable() {
                public void run() {
                    AsyncNetworkSocket.this.write(byteBufferList);
                }
            });
        } else if (this.f55146k.mo163896c()) {
            try {
                int remaining = byteBufferList.remaining();
                ByteBuffer[] allArray = byteBufferList.getAllArray();
                this.f55146k.mo163891a(allArray);
                byteBufferList.addAll(allArray);
                m39677a(byteBufferList.remaining());
                this.f55148m.onDataSent(remaining - byteBufferList.remaining());
            } catch (IOException e) {
                m39678c();
                mo163694b(e);
                reportClose(e);
            }
        } else if (!f55136j && this.f55146k.mo163898d()) {
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    private void m39677a(int i) throws IOException {
        if (!this.f55147l.isValid()) {
            throw new IOException(new CancelledKeyException());
        } else if (i <= 0) {
            SelectionKey selectionKey = this.f55147l;
            selectionKey.interestOps(selectionKey.interestOps() & -5);
        } else if (f55136j || !this.f55146k.mo163898d()) {
            SelectionKey selectionKey2 = this.f55147l;
            selectionKey2.interestOps(selectionKey2.interestOps() | 4);
        } else {
            throw new AssertionError();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo163693b() {
        long j;
        int i;
        m39679d();
        boolean z = false;
        if (this.f55145i) {
            return 0;
        }
        ByteBuffer allocate = this.f55138b.allocate();
        try {
            j = (long) this.f55146k.read(allocate);
        } catch (Exception e) {
            m39678c();
            mo163694b(e);
            reportClose(e);
            j = -1;
        }
        int i2 = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i2 < 0) {
            m39678c();
            z = true;
            i = 0;
        } else {
            i = (int) (((long) 0) + j);
        }
        if (i2 > 0) {
            this.f55138b.track(j);
            allocate.flip();
            this.f55149n.add(allocate);
            C20137Util.emitAllData(this, this.f55149n);
        } else {
            ByteBufferList.reclaim(allocate);
        }
        if (z) {
            mo163694b((Exception) null);
            reportClose((Exception) null);
        }
        return i;
    }

    /* access modifiers changed from: protected */
    public void reportClose(Exception exc) {
        if (!this.f55139c) {
            this.f55139c = true;
            CompletedCallback completedCallback = this.f55142f;
            if (completedCallback != null) {
                completedCallback.onCompleted(exc);
                this.f55142f = null;
            }
        }
    }

    public void close() {
        m39678c();
        reportClose((Exception) null);
    }

    /* renamed from: c */
    private void m39678c() {
        this.f55147l.cancel();
        try {
            this.f55146k.close();
        } catch (IOException unused) {
        }
    }

    public void setWriteableCallback(WritableCallback writableCallback) {
        this.f55140d = writableCallback;
    }

    public void setDataCallback(DataCallback dataCallback) {
        this.f55141e = dataCallback;
    }

    public DataCallback getDataCallback() {
        return this.f55141e;
    }

    public void setClosedCallback(CompletedCallback completedCallback) {
        this.f55142f = completedCallback;
    }

    public CompletedCallback getClosedCallback() {
        return this.f55142f;
    }

    public WritableCallback getWriteableCallback() {
        return this.f55140d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo163690a(Exception exc) {
        if (!this.f55143g) {
            this.f55143g = true;
            CompletedCallback completedCallback = this.f55150o;
            if (completedCallback != null) {
                completedCallback.onCompleted(exc);
            } else if (exc != null) {
                SystemUtils.log(6, AsyncServer.LOGTAG, "Unhandled exception", exc, "com.koushikdutta.async.AsyncNetworkSocket", 243);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo163694b(Exception exc) {
        if (this.f55149n.hasRemaining()) {
            this.f55144h = exc;
        } else {
            mo163690a(exc);
        }
    }

    public void setEndCallback(CompletedCallback completedCallback) {
        this.f55150o = completedCallback;
    }

    public CompletedCallback getEndCallback() {
        return this.f55150o;
    }

    public boolean isOpen() {
        return this.f55146k.mo163896c() && this.f55147l.isValid();
    }

    public void pause() {
        if (this.f55148m.getAffinity() != Thread.currentThread()) {
            this.f55148m.run(new Runnable() {
                public void run() {
                    AsyncNetworkSocket.this.pause();
                }
            });
        } else if (!this.f55145i) {
            this.f55145i = true;
            try {
                this.f55147l.interestOps(this.f55147l.interestOps() & -2);
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: d */
    private void m39679d() {
        if (this.f55149n.hasRemaining()) {
            C20137Util.emitAllData(this, this.f55149n);
        }
    }

    public void resume() {
        if (this.f55148m.getAffinity() != Thread.currentThread()) {
            this.f55148m.run(new Runnable() {
                public void run() {
                    AsyncNetworkSocket.this.resume();
                }
            });
        } else if (this.f55145i) {
            this.f55145i = false;
            try {
                this.f55147l.interestOps(this.f55147l.interestOps() | 1);
            } catch (Exception unused) {
            }
            m39679d();
            if (!isOpen()) {
                mo163694b(this.f55144h);
            }
        }
    }

    public boolean isPaused() {
        return this.f55145i;
    }

    public AsyncServer getServer() {
        return this.f55148m;
    }

    public InetSocketAddress getRemoteAddress() {
        return this.f55137a;
    }

    public InetAddress getLocalAddress() {
        return this.f55146k.mo163900f();
    }

    public int getLocalPort() {
        return this.f55146k.mo163899e();
    }

    public Object getSocket() {
        return mo163688a().mo163901g();
    }
}
