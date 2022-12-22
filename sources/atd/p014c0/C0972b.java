package atd.p014c0;

import atd.p012b0.C0960a;
import atd.p044r0.C1154a;
import atd.p046s0.C1172a;
import atd.p052y.C1225c;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

/* renamed from: atd.c0.b */
public abstract class C0972b extends C0960a {
    C0972b() {
    }

    /* renamed from: a */
    public final byte[] mo13618a(C0974d dVar, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) throws GeneralSecurityException {
        if (Arrays.equals(bArr4, m198a(dVar, bArr, bArr3, bArr2))) {
            return m197a(dVar, 2, bArr, bArr2);
        }
        throw new GeneralSecurityException(C1172a.m764a(-697958408735406L));
    }

    /* renamed from: b */
    public final byte[] mo13620b() {
        byte[] bArr = new byte[mo13613d()];
        new SecureRandom().nextBytes(bArr);
        return bArr;
    }

    /* renamed from: c */
    public abstract String mo13612c();

    /* renamed from: d */
    public abstract int mo13613d();

    /* renamed from: e */
    public abstract String mo13614e();

    /* renamed from: f */
    public abstract int mo13615f();

    /* renamed from: g */
    public abstract String mo13616g();

    /* renamed from: h */
    public abstract int mo13617h();

    /* renamed from: b */
    public final C0975e mo13619b(C0974d dVar, byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        byte[] a = m197a(dVar, 1, bArr, bArr2);
        return new C0975e(bArr, a, m198a(dVar, bArr, bArr3, a));
    }

    /* renamed from: a */
    private byte[] m197a(C0974d dVar, int i, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        SecretKey a = dVar.mo13621a();
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr);
        Cipher instance = Cipher.getInstance(mo13612c());
        instance.init(i, a, ivParameterSpec, new SecureRandom());
        return instance.doFinal(bArr2);
    }

    /* renamed from: a */
    private byte[] m198a(C0974d dVar, byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        byte[] a = m199a(bArr2, bArr, bArr3);
        Mac instance = Mac.getInstance(mo13616g());
        instance.init(dVar.mo13622b());
        instance.update(a);
        return Arrays.copyOf(instance.doFinal(), mo13617h());
    }

    /* renamed from: a */
    private byte[] m199a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] c = C1154a.m710a(Charset.forName(C1172a.m764a(-698108732590766L))).mo13924c(bArr);
            byteArrayOutputStream.write(c);
            byteArrayOutputStream.write(bArr2);
            byteArrayOutputStream.write(bArr3);
            byteArrayOutputStream.write(m196a(c.length));
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            throw C1225c.CRYPTO_FAILURE.mo13983a(e);
        }
    }

    /* renamed from: a */
    private byte[] m196a(int i) {
        return ByteBuffer.allocate(8).putLong((long) (i * 8)).array();
    }
}
