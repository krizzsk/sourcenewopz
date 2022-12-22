package com.koushikdutta.async;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;

/* renamed from: com.koushikdutta.async.b */
/* compiled from: DatagramChannelWrapper */
class C20147b extends C20146a {

    /* renamed from: a */
    DatagramChannel f55241a;

    /* renamed from: b */
    InetSocketAddress f55242b;

    /* renamed from: a */
    public void mo163894a() {
    }

    /* renamed from: b */
    public void mo163895b() {
    }

    /* renamed from: d */
    public boolean mo163898d() {
        return true;
    }

    /* renamed from: f */
    public InetAddress mo163900f() {
        return this.f55241a.socket().getLocalAddress();
    }

    /* renamed from: e */
    public int mo163899e() {
        return this.f55241a.socket().getLocalPort();
    }

    /* renamed from: h */
    public InetSocketAddress mo163903h() {
        return this.f55242b;
    }

    /* renamed from: i */
    public void mo163904i() throws IOException {
        this.f55241a.disconnect();
    }

    C20147b(DatagramChannel datagramChannel) throws IOException {
        super(datagramChannel);
        this.f55241a = datagramChannel;
    }

    public int read(ByteBuffer byteBuffer) throws IOException {
        if (!mo163896c()) {
            int position = byteBuffer.position();
            InetSocketAddress inetSocketAddress = (InetSocketAddress) this.f55241a.receive(byteBuffer);
            this.f55242b = inetSocketAddress;
            if (inetSocketAddress == null) {
                return -1;
            }
            return byteBuffer.position() - position;
        }
        this.f55242b = null;
        return this.f55241a.read(byteBuffer);
    }

    /* renamed from: c */
    public boolean mo163896c() {
        return this.f55241a.isConnected();
    }

    /* renamed from: a */
    public int mo163890a(ByteBuffer byteBuffer) throws IOException {
        return this.f55241a.write(byteBuffer);
    }

    /* renamed from: a */
    public int mo163891a(ByteBuffer[] byteBufferArr) throws IOException {
        return (int) this.f55241a.write(byteBufferArr);
    }

    /* renamed from: a */
    public SelectionKey mo163893a(Selector selector, int i) throws ClosedChannelException {
        return this.f55241a.register(selector, i);
    }

    /* renamed from: a */
    public SelectionKey mo163892a(Selector selector) throws ClosedChannelException {
        return mo163893a(selector, 1);
    }

    public long read(ByteBuffer[] byteBufferArr) throws IOException {
        return this.f55241a.read(byteBufferArr);
    }

    public long read(ByteBuffer[] byteBufferArr, int i, int i2) throws IOException {
        return this.f55241a.read(byteBufferArr, i, i2);
    }

    /* renamed from: g */
    public Object mo163901g() {
        return this.f55241a.socket();
    }
}
