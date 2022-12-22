package atd.p018e0;

import atd.p046s0.C1172a;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.util.Arrays;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1OutputStream;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DERSequence;

/* renamed from: atd.e0.a */
final class C1017a extends C1019c {
    static {
        C1172a.m764a(-699229719055022L);
    }

    C1017a() {
    }

    /* renamed from: b */
    private Signature m338b() throws GeneralSecurityException {
        return Signature.getInstance(C1172a.m764a(-699126639839918L));
    }

    /* renamed from: a */
    public String mo13603a() {
        return C1172a.m764a(-699100870036142L);
    }

    /* renamed from: a */
    public boolean mo13746a(byte[] bArr, byte[] bArr2, PublicKey publicKey) throws GeneralSecurityException {
        Signature b = m338b();
        b.initVerify(publicKey);
        b.update(bArr2);
        return b.verify(m337a(bArr));
    }

    /* renamed from: a */
    private byte[] m337a(byte[] bArr) throws GeneralSecurityException {
        if (bArr.length != 64) {
            return bArr;
        }
        int length = bArr.length / 2;
        byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, length);
        byte[] copyOfRange2 = Arrays.copyOfRange(bArr, length, bArr.length);
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(new ASN1Integer(new BigInteger(1, copyOfRange)));
        aSN1EncodableVector.add(new ASN1Integer(new BigInteger(1, copyOfRange2)));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ASN1OutputStream.create(byteArrayOutputStream, C1172a.m764a(-699195359316654L)).writeObject((ASN1Primitive) new DERSequence(aSN1EncodableVector));
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            throw new SignatureException(C1172a.m764a(-699212539185838L), e);
        }
    }
}
