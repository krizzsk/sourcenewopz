package atd.p014c0;

import java.security.Key;
import java.util.Arrays;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: atd.c0.d */
public final class C0974d extends SecretKeySpec {

    /* renamed from: a */
    private final SecretKey f203a;

    /* renamed from: b */
    private final Key f204b;

    public C0974d(byte[] bArr, C0972b bVar) {
        super(bArr, bVar.mo13614e());
        int length = bArr.length;
        int i = length / 2;
        this.f203a = new SecretKeySpec(Arrays.copyOfRange(bArr, i, length), bVar.mo13614e());
        this.f204b = new SecretKeySpec(Arrays.copyOfRange(bArr, 0, i), bVar.mo13616g());
    }

    /* renamed from: a */
    public SecretKey mo13621a() {
        return this.f203a;
    }

    /* renamed from: b */
    public Key mo13622b() {
        return this.f204b;
    }

    public C0974d(SecretKey secretKey, C0972b bVar) {
        this(secretKey.getEncoded(), bVar);
    }
}
