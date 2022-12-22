package net.lingala.zip4j.model;

import java.util.ArrayList;
import java.util.List;

public class CentralDirectory {

    /* renamed from: a */
    private List<FileHeader> f4933a = new ArrayList();

    /* renamed from: b */
    private DigitalSignature f4934b = new DigitalSignature();

    public List<FileHeader> getFileHeaders() {
        return this.f4933a;
    }

    public void setFileHeaders(List<FileHeader> list) {
        this.f4933a = list;
    }

    public DigitalSignature getDigitalSignature() {
        return this.f4934b;
    }

    public void setDigitalSignature(DigitalSignature digitalSignature) {
        this.f4934b = digitalSignature;
    }
}
