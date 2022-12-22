package com.koushikdutta.async;

import java.io.IOException;
import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

/* renamed from: com.koushikdutta.async.e */
/* compiled from: SocketChannelWrapper */
class C20152e extends C20146a {

    /* renamed from: a */
    SocketChannel f55248a;

    /* renamed from: f */
    public InetAddress mo163900f() {
        return this.f55248a.socket().getLocalAddress();
    }

    /* renamed from: e */
    public int mo163899e() {
        return this.f55248a.socket().getLocalPort();
    }

    C20152e(SocketChannel socketChannel) throws IOException {
        super(socketChannel);
        this.f55248a = socketChannel;
    }

    public int read(ByteBuffer byteBuffer) throws IOException {
        return this.f55248a.read(byteBuffer);
    }

    /* renamed from: c */
    public boolean mo163896c() {
        return this.f55248a.isConnected();
    }

    /* renamed from: a */
    public int mo163890a(ByteBuffer byteBuffer) throws IOException {
        return this.f55248a.write(byteBuffer);
    }

    /* renamed from: a */
    public int mo163891a(ByteBuffer[] byteBufferArr) throws IOException {
        return (int) this.f55248a.write(byteBufferArr);
    }

    /* renamed from: a */
    public SelectionKey mo163892a(Selector selector) throws ClosedChannelException {
        return mo163893a(selector, 8);
    }

    /* renamed from: b */
    public void mo163895b() {
        try {
            this.f55248a.socket().shutdownOutput();
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    public void mo163894a() {
        try {
            this.f55248a.socket().shutdownInput();
        } catch (Exception unused) {
        }
    }

    public long read(ByteBuffer[] byteBufferArr) throws IOException {
        return this.f55248a.read(byteBufferArr);
    }

    public long read(ByteBuffer[] byteBufferArr, int i, int i2) throws IOException {
        return this.f55248a.read(byteBufferArr, i, i2);
    }

    /* renamed from: g */
    public Object mo163901g() {
        return this.f55248a.socket();
    }
}
