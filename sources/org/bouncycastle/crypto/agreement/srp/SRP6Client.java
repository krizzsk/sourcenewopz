package org.bouncycastle.crypto.agreement.srp;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.params.SRP6GroupParameters;

public class SRP6Client {

    /* renamed from: A */
    protected BigInteger f5740A;

    /* renamed from: B */
    protected BigInteger f5741B;
    protected BigInteger Key;

    /* renamed from: M1 */
    protected BigInteger f5742M1;

    /* renamed from: M2 */
    protected BigInteger f5743M2;

    /* renamed from: N */
    protected BigInteger f5744N;

    /* renamed from: S */
    protected BigInteger f5745S;

    /* renamed from: a */
    protected BigInteger f5746a;
    protected Digest digest;

    /* renamed from: g */
    protected BigInteger f5747g;
    protected SecureRandom random;

    /* renamed from: u */
    protected BigInteger f5748u;

    /* renamed from: x */
    protected BigInteger f5749x;

    private BigInteger calculateS() {
        BigInteger calculateK = SRP6Util.calculateK(this.digest, this.f5744N, this.f5747g);
        return this.f5741B.subtract(this.f5747g.modPow(this.f5749x, this.f5744N).multiply(calculateK).mod(this.f5744N)).mod(this.f5744N).modPow(this.f5748u.multiply(this.f5749x).add(this.f5746a), this.f5744N);
    }

    public BigInteger calculateClientEvidenceMessage() throws CryptoException {
        BigInteger bigInteger;
        BigInteger bigInteger2;
        BigInteger bigInteger3 = this.f5740A;
        if (bigInteger3 == null || (bigInteger = this.f5741B) == null || (bigInteger2 = this.f5745S) == null) {
            throw new CryptoException("Impossible to compute M1: some data are missing from the previous operations (A,B,S)");
        }
        BigInteger calculateM1 = SRP6Util.calculateM1(this.digest, this.f5744N, bigInteger3, bigInteger, bigInteger2);
        this.f5742M1 = calculateM1;
        return calculateM1;
    }

    public BigInteger calculateSecret(BigInteger bigInteger) throws CryptoException {
        BigInteger validatePublicValue = SRP6Util.validatePublicValue(this.f5744N, bigInteger);
        this.f5741B = validatePublicValue;
        this.f5748u = SRP6Util.calculateU(this.digest, this.f5744N, this.f5740A, validatePublicValue);
        BigInteger calculateS = calculateS();
        this.f5745S = calculateS;
        return calculateS;
    }

    public BigInteger calculateSessionKey() throws CryptoException {
        BigInteger bigInteger = this.f5745S;
        if (bigInteger == null || this.f5742M1 == null || this.f5743M2 == null) {
            throw new CryptoException("Impossible to compute Key: some data are missing from the previous operations (S,M1,M2)");
        }
        BigInteger calculateKey = SRP6Util.calculateKey(this.digest, this.f5744N, bigInteger);
        this.Key = calculateKey;
        return calculateKey;
    }

    public BigInteger generateClientCredentials(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        this.f5749x = SRP6Util.calculateX(this.digest, this.f5744N, bArr, bArr2, bArr3);
        BigInteger selectPrivateValue = selectPrivateValue();
        this.f5746a = selectPrivateValue;
        BigInteger modPow = this.f5747g.modPow(selectPrivateValue, this.f5744N);
        this.f5740A = modPow;
        return modPow;
    }

    public void init(BigInteger bigInteger, BigInteger bigInteger2, Digest digest2, SecureRandom secureRandom) {
        this.f5744N = bigInteger;
        this.f5747g = bigInteger2;
        this.digest = digest2;
        this.random = secureRandom;
    }

    public void init(SRP6GroupParameters sRP6GroupParameters, Digest digest2, SecureRandom secureRandom) {
        init(sRP6GroupParameters.getN(), sRP6GroupParameters.getG(), digest2, secureRandom);
    }

    /* access modifiers changed from: protected */
    public BigInteger selectPrivateValue() {
        return SRP6Util.generatePrivateValue(this.digest, this.f5744N, this.f5747g, this.random);
    }

    public boolean verifyServerEvidenceMessage(BigInteger bigInteger) throws CryptoException {
        BigInteger bigInteger2;
        BigInteger bigInteger3;
        BigInteger bigInteger4 = this.f5740A;
        if (bigInteger4 == null || (bigInteger2 = this.f5742M1) == null || (bigInteger3 = this.f5745S) == null) {
            throw new CryptoException("Impossible to compute and verify M2: some data are missing from the previous operations (A,M1,S)");
        } else if (!SRP6Util.calculateM2(this.digest, this.f5744N, bigInteger4, bigInteger2, bigInteger3).equals(bigInteger)) {
            return false;
        } else {
            this.f5743M2 = bigInteger;
            return true;
        }
    }
}
