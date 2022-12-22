package net.lingala.zip4j.crypto.PBKDF2;

import net.lingala.zip4j.util.Zip4jUtil;

public class PBKDF2Engine {

    /* renamed from: a */
    private PBKDF2Parameters f4808a;

    /* renamed from: b */
    private C2384c f4809b;

    public PBKDF2Engine(PBKDF2Parameters pBKDF2Parameters) {
        this(pBKDF2Parameters, (C2384c) null);
    }

    public PBKDF2Engine(PBKDF2Parameters pBKDF2Parameters, C2384c cVar) {
        this.f4808a = pBKDF2Parameters;
        this.f4809b = cVar;
    }

    public byte[] deriveKey(char[] cArr) {
        return deriveKey(cArr, 0);
    }

    public byte[] deriveKey(char[] cArr, int i) {
        if (cArr != null) {
            m3056a(Zip4jUtil.convertCharArrayToByteArray(cArr));
            if (i == 0) {
                i = this.f4809b.getHLen();
            }
            return m3059a(this.f4809b, this.f4808a.getSalt(), this.f4808a.getIterationCount(), i);
        }
        throw null;
    }

    public boolean verifyKey(char[] cArr) {
        byte[] deriveKey;
        byte[] derivedKey = getParameters().getDerivedKey();
        if (derivedKey == null || derivedKey.length == 0 || (deriveKey = deriveKey(cArr, derivedKey.length)) == null || deriveKey.length != derivedKey.length) {
            return false;
        }
        for (int i = 0; i < deriveKey.length; i++) {
            if (deriveKey[i] != derivedKey[i]) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    private void m3056a(byte[] bArr) {
        if (this.f4809b == null) {
            this.f4809b = new MacBasedPRF(this.f4808a.getHashAlgorithm());
        }
        this.f4809b.init(bArr);
    }

    public C2384c getPseudoRandomFunction() {
        return this.f4809b;
    }

    /* renamed from: a */
    private byte[] m3059a(C2384c cVar, byte[] bArr, int i, int i2) {
        int i3 = i2;
        byte[] bArr2 = bArr == null ? new byte[0] : bArr;
        int hLen = cVar.getHLen();
        int a = m3055a(i3, hLen);
        int i4 = i3 - ((a - 1) * hLen);
        byte[] bArr3 = new byte[(a * hLen)];
        int i5 = 0;
        for (int i6 = 1; i6 <= a; i6++) {
            m3057a(bArr3, i5, cVar, bArr2, i, i6);
            i5 += hLen;
        }
        if (i4 >= hLen) {
            return bArr3;
        }
        byte[] bArr4 = new byte[i3];
        System.arraycopy(bArr3, 0, bArr4, 0, i3);
        return bArr4;
    }

    /* renamed from: a */
    private int m3055a(int i, int i2) {
        return (i / i2) + (i % i2 > 0 ? 1 : 0);
    }

    /* renamed from: a */
    private void m3057a(byte[] bArr, int i, C2384c cVar, byte[] bArr2, int i2, int i3) {
        int hLen = cVar.getHLen();
        byte[] bArr3 = new byte[hLen];
        byte[] bArr4 = new byte[(bArr2.length + 4)];
        System.arraycopy(bArr2, 0, bArr4, 0, bArr2.length);
        INT(bArr4, bArr2.length, i3);
        for (int i4 = 0; i4 < i2; i4++) {
            bArr4 = cVar.doFinal(bArr4);
            m3058a(bArr3, bArr4);
        }
        System.arraycopy(bArr3, 0, bArr, i, hLen);
    }

    /* renamed from: a */
    private void m3058a(byte[] bArr, byte[] bArr2) {
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) (bArr[i] ^ bArr2[i]);
        }
    }

    /* access modifiers changed from: protected */
    public void INT(byte[] bArr, int i, int i2) {
        bArr[i] = (byte) (i2 / 16777216);
        bArr[i + 1] = (byte) (i2 / 65536);
        bArr[i + 2] = (byte) (i2 / 256);
        bArr[i + 3] = (byte) i2;
    }

    public PBKDF2Parameters getParameters() {
        return this.f4808a;
    }

    public void setParameters(PBKDF2Parameters pBKDF2Parameters) {
        this.f4808a = pBKDF2Parameters;
    }

    public void setPseudoRandomFunction(C2384c cVar) {
        this.f4809b = cVar;
    }
}
