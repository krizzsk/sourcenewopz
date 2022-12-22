package com.didi.foundation.sdk.liveconnection;

public class Response {

    /* renamed from: a */
    private int f21203a;

    /* renamed from: b */
    private byte[] f21204b;

    /* renamed from: c */
    private byte[] f21205c;

    public Response(int i, byte[] bArr, byte[] bArr2) {
        this.f21203a = i;
        this.f21204b = bArr;
        this.f21205c = bArr2;
    }

    public int getMessageType() {
        return this.f21203a;
    }

    public byte[] getSeqId() {
        return this.f21204b;
    }

    public byte[] getData() {
        return this.f21205c;
    }
}
