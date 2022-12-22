package com.didi.foundation.sdk.liveconnection;

public class Request {

    /* renamed from: a */
    private int f21199a;

    /* renamed from: b */
    private byte[] f21200b;

    /* renamed from: c */
    private byte[] f21201c;

    /* renamed from: d */
    private boolean f21202d;

    public Request() {
        this.f21201c = new byte[8];
    }

    public Request(int i, byte[] bArr, byte[] bArr2, boolean z) {
        this.f21199a = i;
        this.f21200b = bArr;
        if (bArr2 == null) {
            this.f21201c = new byte[8];
        } else {
            this.f21201c = bArr2;
        }
        this.f21202d = z;
    }

    public int getMessageType() {
        return this.f21199a;
    }

    public void setMessageType(int i) {
        this.f21199a = i;
    }

    public byte[] getData() {
        return this.f21200b;
    }

    public void setData(byte[] bArr) {
        this.f21200b = bArr;
    }

    public byte[] getSeqIdOut() {
        return this.f21201c;
    }

    public void setSeqIdOut(byte[] bArr) {
        this.f21201c = bArr;
    }

    public boolean isNeedResponse() {
        return this.f21202d;
    }
}
