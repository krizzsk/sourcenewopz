package net.lingala.zip4j.model;

public class DigitalSignature extends ZipHeader {

    /* renamed from: a */
    private int f4938a;

    /* renamed from: b */
    private String f4939b;

    public int getSizeOfData() {
        return this.f4938a;
    }

    public void setSizeOfData(int i) {
        this.f4938a = i;
    }

    public String getSignatureData() {
        return this.f4939b;
    }

    public void setSignatureData(String str) {
        this.f4939b = str;
    }
}
