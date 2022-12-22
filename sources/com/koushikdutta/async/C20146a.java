package com.koushikdutta.async;

import java.io.IOException;
import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.spi.AbstractSelectableChannel;

/* renamed from: com.koushikdutta.async.a */
/* compiled from: ChannelWrapper */
abstract class C20146a implements ReadableByteChannel, ScatteringByteChannel {

    /* renamed from: a */
    private AbstractSelectableChannel f55240a;

    /* renamed from: a */
    public abstract int mo163890a(ByteBuffer byteBuffer) throws IOException;

    /* renamed from: a */
    public abstract int mo163891a(ByteBuffer[] byteBufferArr) throws IOException;

    /* renamed from: a */
    public abstract SelectionKey mo163892a(Selector selector) throws ClosedChannelException;

    /* renamed from: a */
    public abstract void mo163894a();

    /* renamed from: b */
    public abstract void mo163895b();

    /* renamed from: c */
    public abstract boolean mo163896c();

    /* renamed from: d */
    public boolean mo163898d() {
        return false;
    }

    /* renamed from: e */
    public abstract int mo163899e();

    /* renamed from: f */
    public abstract InetAddress mo163900f();

    /* renamed from: g */
    public abstract Object mo163901g();

    C20146a(AbstractSelectableChannel abstractSelectableChannel) throws IOException {
        abstractSelectableChannel.configureBlocking(false);
        this.f55240a = abstractSelectableChannel;
    }

    /* renamed from: a */
    public SelectionKey mo163893a(Selector selector, int i) throws ClosedChannelException {
        return this.f55240a.register(selector, i);
    }

    public boolean isOpen() {
        return this.f55240a.isOpen();
    }

    public void close() throws IOException {
        this.f55240a.close();
    }
}
