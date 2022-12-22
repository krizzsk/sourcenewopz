package net.lingala.zip4j.p067io.outputstream;

import java.io.IOException;
import java.io.OutputStream;
import net.lingala.zip4j.crypto.Encrypter;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;

/* renamed from: net.lingala.zip4j.io.outputstream.b */
/* compiled from: CipherOutputStream */
abstract class C2392b<T extends Encrypter> extends OutputStream {

    /* renamed from: a */
    private C2396f f4900a;

    /* renamed from: b */
    private T f4901b;

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract T mo24166b(OutputStream outputStream, ZipParameters zipParameters, char[] cArr) throws IOException, ZipException;

    public C2392b(C2396f fVar, ZipParameters zipParameters, char[] cArr) throws IOException, ZipException {
        this.f4900a = fVar;
        this.f4901b = mo24166b(fVar, zipParameters, cArr);
    }

    public void write(int i) throws IOException {
        this.f4900a.write(i);
    }

    public void write(byte[] bArr) throws IOException {
        this.f4900a.write(bArr);
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.f4901b.encryptData(bArr, i, i2);
        this.f4900a.write(bArr, i, i2);
    }

    /* renamed from: a */
    public void mo24188a(byte[] bArr) throws IOException {
        this.f4900a.write(bArr);
    }

    /* renamed from: a */
    public void mo24184a() throws IOException {
        this.f4900a.mo24198a();
    }

    public void close() throws IOException {
        this.f4900a.close();
    }

    /* renamed from: b */
    public long mo24189b() {
        return this.f4900a.mo24199b();
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public T mo24190c() {
        return this.f4901b;
    }
}
