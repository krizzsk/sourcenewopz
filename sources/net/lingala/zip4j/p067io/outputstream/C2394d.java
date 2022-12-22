package net.lingala.zip4j.p067io.outputstream;

import java.io.IOException;
import java.util.zip.Deflater;
import net.lingala.zip4j.model.enums.CompressionLevel;

/* renamed from: net.lingala.zip4j.io.outputstream.d */
/* compiled from: DeflaterOutputStream */
class C2394d extends C2393c {

    /* renamed from: a */
    protected Deflater f4903a;

    /* renamed from: b */
    private byte[] f4904b;

    public C2394d(C2392b bVar, CompressionLevel compressionLevel, int i) {
        super(bVar);
        this.f4903a = new Deflater(compressionLevel.getLevel(), true);
        this.f4904b = new byte[i];
    }

    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    public void write(int i) throws IOException {
        write(new byte[]{(byte) i}, 0, 1);
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.f4903a.setInput(bArr, i, i2);
        while (!this.f4903a.needsInput()) {
            m3187c();
        }
    }

    /* renamed from: c */
    private void m3187c() throws IOException {
        Deflater deflater = this.f4903a;
        byte[] bArr = this.f4904b;
        int deflate = deflater.deflate(bArr, 0, bArr.length);
        if (deflate > 0) {
            super.write(this.f4904b, 0, deflate);
        }
    }

    /* renamed from: a */
    public void mo24192a() throws IOException {
        if (!this.f4903a.finished()) {
            this.f4903a.finish();
            while (!this.f4903a.finished()) {
                m3187c();
            }
        }
        this.f4903a.end();
        super.mo24192a();
    }
}
