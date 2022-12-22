package net.lingala.zip4j.p067io.outputstream;

import java.io.IOException;
import java.io.OutputStream;

/* renamed from: net.lingala.zip4j.io.outputstream.c */
/* compiled from: CompressedOutputStream */
abstract class C2393c extends OutputStream {

    /* renamed from: a */
    private C2392b f4902a;

    public C2393c(C2392b bVar) {
        this.f4902a = bVar;
    }

    public void write(int i) throws IOException {
        write(new byte[]{(byte) i});
    }

    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.f4902a.write(bArr, i, i2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo24192a() throws IOException {
        this.f4902a.mo24184a();
    }

    public void close() throws IOException {
        this.f4902a.close();
    }

    /* renamed from: b */
    public long mo24193b() {
        return this.f4902a.mo24189b();
    }
}
