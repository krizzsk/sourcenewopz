package net.lingala.zip4j.model;

import net.lingala.zip4j.headers.HeaderSignature;

public abstract class ZipHeader {

    /* renamed from: a */
    private HeaderSignature f4982a;

    public HeaderSignature getSignature() {
        return this.f4982a;
    }

    public void setSignature(HeaderSignature headerSignature) {
        this.f4982a = headerSignature;
    }
}
