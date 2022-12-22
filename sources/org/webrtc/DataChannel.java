package org.webrtc;

import java.nio.ByteBuffer;

public class DataChannel {
    private long nativeDataChannel;
    private long nativeObserver;

    public interface Observer {
        void onBufferedAmountChange(long j);

        void onMessage(Buffer buffer);

        void onStateChange();
    }

    private native long nativeBufferedAmount();

    private native void nativeClose();

    private native int nativeId();

    private native String nativeLabel();

    private native long nativeRegisterObserver(Observer observer);

    private native boolean nativeSend(byte[] bArr, boolean z);

    private native State nativeState();

    private native void nativeUnregisterObserver(long j);

    public static class Init {

        /* renamed from: id */
        public int f6703id = -1;
        public int maxRetransmitTimeMs = -1;
        public int maxRetransmits = -1;
        public boolean negotiated;
        public boolean ordered = true;
        public String protocol = "";

        /* access modifiers changed from: package-private */
        public boolean getOrdered() {
            return this.ordered;
        }

        /* access modifiers changed from: package-private */
        public int getMaxRetransmitTimeMs() {
            return this.maxRetransmitTimeMs;
        }

        /* access modifiers changed from: package-private */
        public int getMaxRetransmits() {
            return this.maxRetransmits;
        }

        /* access modifiers changed from: package-private */
        public String getProtocol() {
            return this.protocol;
        }

        /* access modifiers changed from: package-private */
        public boolean getNegotiated() {
            return this.negotiated;
        }

        /* access modifiers changed from: package-private */
        public int getId() {
            return this.f6703id;
        }
    }

    public static class Buffer {
        public final boolean binary;
        public final ByteBuffer data;

        public Buffer(ByteBuffer byteBuffer, boolean z) {
            this.data = byteBuffer;
            this.binary = z;
        }
    }

    public enum State {
        CONNECTING,
        OPEN,
        CLOSING,
        CLOSED;

        static State fromNativeIndex(int i) {
            return values()[i];
        }
    }

    public DataChannel(long j) {
        this.nativeDataChannel = j;
    }

    public void registerObserver(Observer observer) {
        checkDataChannelExists();
        long j = this.nativeObserver;
        if (j != 0) {
            nativeUnregisterObserver(j);
        }
        this.nativeObserver = nativeRegisterObserver(observer);
    }

    public void unregisterObserver() {
        checkDataChannelExists();
        nativeUnregisterObserver(this.nativeObserver);
    }

    public String label() {
        checkDataChannelExists();
        return nativeLabel();
    }

    /* renamed from: id */
    public int mo37490id() {
        checkDataChannelExists();
        return nativeId();
    }

    public State state() {
        checkDataChannelExists();
        return nativeState();
    }

    public long bufferedAmount() {
        checkDataChannelExists();
        return nativeBufferedAmount();
    }

    public void close() {
        checkDataChannelExists();
        nativeClose();
    }

    public boolean send(Buffer buffer) {
        checkDataChannelExists();
        byte[] bArr = new byte[buffer.data.remaining()];
        buffer.data.get(bArr);
        return nativeSend(bArr, buffer.binary);
    }

    public void dispose() {
        checkDataChannelExists();
        JniCommon.nativeReleaseRef(this.nativeDataChannel);
        this.nativeDataChannel = 0;
    }

    /* access modifiers changed from: package-private */
    public long getNativeDataChannel() {
        return this.nativeDataChannel;
    }

    private void checkDataChannelExists() {
        if (this.nativeDataChannel == 0) {
            throw new IllegalStateException("DataChannel has been disposed.");
        }
    }
}
