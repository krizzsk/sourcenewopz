package com.koushikdutta.async.dns;

import com.didichuxing.mlcp.drtc.consts.SDKConsts;
import com.koushikdutta.async.AsyncDatagramSocket;
import com.koushikdutta.async.AsyncServer;
import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.callback.DataCallback;
import com.koushikdutta.async.future.Cancellable;
import com.koushikdutta.async.future.Future;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.async.future.SimpleFuture;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Random;

public class Dns {
    /* renamed from: a */
    private static int m39778a(int i, int i2, int i3) {
        return i | (i2 << i3);
    }

    public static Future<DnsResponse> lookup(String str) {
        return lookup(AsyncServer.getDefault(), str, false, (FutureCallback<DnsResponse>) null);
    }

    /* renamed from: a */
    private static int m39777a(int i) {
        return m39778a(i, 0, 0);
    }

    /* renamed from: b */
    private static int m39781b(int i) {
        return m39778a(i, 1, 8);
    }

    /* renamed from: a */
    private static void m39780a(ByteBuffer byteBuffer, String str) {
        for (String str2 : str.split("\\.")) {
            byteBuffer.put((byte) str2.length());
            byteBuffer.put(str2.getBytes());
        }
        byteBuffer.put((byte) 0);
    }

    public static Future<DnsResponse> lookup(AsyncServer asyncServer, String str) {
        return lookup(asyncServer, str, false, (FutureCallback<DnsResponse>) null);
    }

    public static Cancellable multicastLookup(AsyncServer asyncServer, String str, FutureCallback<DnsResponse> futureCallback) {
        return lookup(asyncServer, str, true, futureCallback);
    }

    public static Cancellable multicastLookup(String str, FutureCallback<DnsResponse> futureCallback) {
        return multicastLookup(AsyncServer.getDefault(), str, futureCallback);
    }

    public static Future<DnsResponse> lookup(AsyncServer asyncServer, String str, final boolean z, final FutureCallback<DnsResponse> futureCallback) {
        final AsyncDatagramSocket asyncDatagramSocket;
        if (!asyncServer.isAffinityThread()) {
            SimpleFuture simpleFuture = new SimpleFuture();
            asyncServer.post(new Runnable(asyncServer, str, z, futureCallback) {
                public final /* synthetic */ AsyncServer f$1;
                public final /* synthetic */ String f$2;
                public final /* synthetic */ boolean f$3;
                public final /* synthetic */ FutureCallback f$4;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                    this.f$4 = r5;
                }

                public final void run() {
                    SimpleFuture.this.setComplete(Dns.lookup(this.f$1, this.f$2, this.f$3, this.f$4));
                }
            });
            return simpleFuture;
        }
        ByteBuffer order = ByteBufferList.obtain(1024).order(ByteOrder.BIG_ENDIAN);
        short nextInt = (short) new Random().nextInt();
        short a = (short) m39777a(0);
        if (!z) {
            a = (short) m39781b(a);
        }
        order.putShort(nextInt);
        order.putShort(a);
        order.putShort(z ? (short) 1 : 2);
        order.putShort(0);
        order.putShort(0);
        order.putShort(0);
        m39780a(order, str);
        order.putShort(z ? (short) 12 : 1);
        order.putShort(1);
        if (!z) {
            m39780a(order, str);
            order.putShort(28);
            order.putShort(1);
        }
        order.flip();
        if (!z) {
            try {
                asyncDatagramSocket = asyncServer.connectDatagram(new InetSocketAddress("8.8.8.8", 53));
            } catch (Exception e) {
                SimpleFuture simpleFuture2 = new SimpleFuture();
                simpleFuture2.setComplete(e);
                if (z) {
                    futureCallback.onCompleted(e, null);
                }
                return simpleFuture2;
            }
        } else {
            asyncDatagramSocket = AsyncServer.getDefault().openDatagram((InetAddress) null, 0, true);
            Field declaredField = DatagramSocket.class.getDeclaredField("impl");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(asyncDatagramSocket.getSocket());
            Method declaredMethod = obj.getClass().getDeclaredMethod(SDKConsts.ACTION_VALUE_JOIN, new Class[]{InetAddress.class});
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(obj, new Object[]{InetAddress.getByName("224.0.0.251")});
            ((DatagramSocket) asyncDatagramSocket.getSocket()).setBroadcast(true);
        }
        final C201501 r4 = new SimpleFuture<DnsResponse>() {
            /* access modifiers changed from: protected */
            public void cleanup() {
                super.cleanup();
                asyncDatagramSocket.close();
            }
        };
        asyncDatagramSocket.setDataCallback(new DataCallback() {
            public void onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
                try {
                    DnsResponse parse = DnsResponse.parse(byteBufferList);
                    parse.source = asyncDatagramSocket.getRemoteAddress();
                    if (!z) {
                        asyncDatagramSocket.close();
                        r4.setComplete(parse);
                    } else {
                        futureCallback.onCompleted((Exception) null, parse);
                    }
                } catch (Exception unused) {
                }
                byteBufferList.recycle();
            }
        });
        if (!z) {
            asyncDatagramSocket.write(new ByteBufferList(order));
        } else {
            asyncDatagramSocket.send(new InetSocketAddress("224.0.0.251", 5353), order);
        }
        return r4;
    }
}
