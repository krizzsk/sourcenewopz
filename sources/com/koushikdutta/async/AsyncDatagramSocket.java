package com.koushikdutta.async;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;

public class AsyncDatagramSocket extends AsyncNetworkSocket {
    public void disconnect() throws IOException {
        this.f55137a = null;
        ((C20147b) mo163688a()).mo163904i();
    }

    public InetSocketAddress getRemoteAddress() {
        if (isOpen()) {
            return super.getRemoteAddress();
        }
        return ((C20147b) mo163688a()).mo163903h();
    }

    public void connect(InetSocketAddress inetSocketAddress) throws IOException {
        this.f55137a = inetSocketAddress;
        ((C20147b) mo163688a()).f55241a.connect(inetSocketAddress);
    }

    public void send(final String str, final int i, final ByteBuffer byteBuffer) {
        if (getServer().getAffinity() != Thread.currentThread()) {
            getServer().run(new Runnable() {
                public void run() {
                    AsyncDatagramSocket.this.send(str, i, byteBuffer);
                }
            });
            return;
        }
        try {
            ((C20147b) mo163688a()).f55241a.send(byteBuffer, new InetSocketAddress(str, i));
        } catch (IOException unused) {
        }
    }

    public void send(final InetSocketAddress inetSocketAddress, final ByteBuffer byteBuffer) {
        if (getServer().getAffinity() != Thread.currentThread()) {
            getServer().run(new Runnable() {
                public void run() {
                    AsyncDatagramSocket.this.send(inetSocketAddress, byteBuffer);
                }
            });
            return;
        }
        try {
            ((C20147b) mo163688a()).f55241a.send(byteBuffer, new InetSocketAddress(inetSocketAddress.getHostName(), inetSocketAddress.getPort()));
        } catch (IOException unused) {
        }
    }
}
