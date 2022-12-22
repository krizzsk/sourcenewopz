package net.lingala.zip4j.p067io.inputstream;

import java.io.IOException;
import net.lingala.zip4j.crypto.StandardDecrypter;
import net.lingala.zip4j.model.LocalFileHeader;

/* renamed from: net.lingala.zip4j.io.inputstream.f */
/* compiled from: ZipStandardCipherInputStream */
class C2390f extends C2386b<StandardDecrypter> {
    public C2390f(C2389e eVar, LocalFileHeader localFileHeader, char[] cArr, int i) throws IOException {
        super(eVar, localFileHeader, cArr, i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public StandardDecrypter mo24109b(LocalFileHeader localFileHeader, char[] cArr) throws IOException {
        return new StandardDecrypter(cArr, localFileHeader.getCrc(), localFileHeader.getLastModifiedTime(), m3157e());
    }

    /* renamed from: e */
    private byte[] m3157e() throws IOException {
        byte[] bArr = new byte[12];
        mo24140a(bArr);
        return bArr;
    }
}
