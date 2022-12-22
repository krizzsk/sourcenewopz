package com.koushikdutta.async;

import java.io.IOException;
import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

/* renamed from: com.koushikdutta.async.d */
/* compiled from: ServerSocketChannelWrapper */
class C20149d extends C20146a {

    /* renamed from: b */
    static final /* synthetic */ boolean f55246b = (!C20149d.class.desiredAssertionStatus());

    /* renamed from: a */
    ServerSocketChannel f55247a;

    /* renamed from: a */
    public void mo163894a() {
    }

    /* renamed from: b */
    public void mo163895b() {
    }

    /* renamed from: f */
    public InetAddress mo163900f() {
        return this.f55247a.socket().getInetAddress();
    }

    /* renamed from: e */
    public int mo163899e() {
        return this.f55247a.socket().getLocalPort();
    }

    C20149d(ServerSocketChannel serverSocketChannel) throws IOException {
        super(serverSocketChannel);
        this.f55247a = serverSocketChannel;
    }

    public int read(ByteBuffer byteBuffer) throws IOException {
        if (!f55246b) {
            throw new AssertionError();
        }
        throw new IOException("Can't read ServerSocketChannel");
    }

    /* renamed from: c */
    public boolean mo163896c() {
        if (f55246b) {
            return false;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    public int mo163890a(ByteBuffer byteBuffer) throws IOException {
        if (!f55246b) {
            throw new AssertionError();
        }
        throw new IOException("Can't write ServerSocketChannel");
    }

    /* renamed from: a */
    public SelectionKey mo163892a(Selector selector) throws ClosedChannelException {
        return this.f55247a.register(selector, 16);
    }

    /* renamed from: a */
    public int mo163891a(ByteBuffer[] byteBufferArr) throws IOException {
        if (!f55246b) {
            throw new AssertionError();
        }
        throw new IOException("Can't write ServerSocketChannel");
    }

    public long read(ByteBuffer[] byteBufferArr) throws IOException {
        if (!f55246b) {
            throw new AssertionError();
        }
        throw new IOException("Can't read ServerSocketChannel");
    }

    public long read(ByteBuffer[] byteBufferArr, int i, int i2) throws IOException {
        if (!f55246b) {
            throw new AssertionError();
        }
        throw new IOException("Can't read ServerSocketChannel");
    }

    /* renamed from: g */
    public Object mo163901g() {
        return this.f55247a.socket();
    }
}
