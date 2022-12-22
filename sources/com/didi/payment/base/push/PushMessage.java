package com.didi.payment.base.push;

public class PushMessage {

    /* renamed from: a */
    private String f29923a;

    /* renamed from: b */
    private byte[] f29924b;

    public PushMessage(String str, byte[] bArr) {
        this.f29923a = str;
        this.f29924b = bArr;
    }

    public PushMessage() {
    }

    public String getTopic() {
        return this.f29923a;
    }

    public void setTopic(String str) {
        this.f29923a = str;
    }

    public byte[] getData() {
        return this.f29924b;
    }

    public void setData(byte[] bArr) {
        this.f29924b = bArr;
    }
}
