package net.lingala.zip4j.model;

public class ArchiveExtraDataRecord extends ZipHeader {

    /* renamed from: a */
    private int f4931a;

    /* renamed from: b */
    private String f4932b;

    public int getExtraFieldLength() {
        return this.f4931a;
    }

    public void setExtraFieldLength(int i) {
        this.f4931a = i;
    }

    public String getExtraFieldData() {
        return this.f4932b;
    }

    public void setExtraFieldData(String str) {
        this.f4932b = str;
    }
}
