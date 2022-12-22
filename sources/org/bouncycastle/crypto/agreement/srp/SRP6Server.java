package org.bouncycastle.crypto.agreement.srp;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.params.SRP6GroupParameters;

public class SRP6Server {

    /* renamed from: A */
    protected BigInteger f5750A;

    /* renamed from: B */
    protected BigInteger f5751B;
    protected BigInteger Key;

    /* renamed from: M1 */
    protected BigInteger f5752M1;

    /* renamed from: M2 */
    protected BigInteger f5753M2;

    /* renamed from: N */
    protected BigInteger f5754N;

    /* renamed from: S */
    protected BigInteger f5755S;

    /* renamed from: b */
    protected BigInteger f5756b;
    protected Digest digest;

    /* renamed from: g */
    protected BigInteger f5757g;
    protected SecureRandom random;

    /* renamed from: u */
    protected BigInteger f5758u;

    /* renamed from: v */
    protected BigInteger f5759v;

    private BigInteger calculateS() {
        return this.f5759v.modPow(this.f5758u, this.f5754N).multiply(this.f5750A).mod(this.f5754N).modPow(this.f5756b, this.f5754N);
    }

    public BigInteger calculateSecret(BigInteger bigInteger) throws CryptoException {
        BigInteger validatePublicValue = SRP6Util.validatePublicValue(this.f5754N, bigInteger);
        this.f5750A = validatePublicValue;
        this.f5758u = SRP6Util.calculateU(this.digest, this.f5754N, validatePublicValue, this.f5751B);
        BigInteger calculateS = calculateS();
        this.f5755S = calculateS;
        return calculateS;
    }

    public BigInteger calculateServerEvidenceMessage() throws CryptoException {
        BigInteger bigInteger;
        BigInteger bigInteger2;
        BigInteger bigInteger3 = this.f5750A;
        if (bigInteger3 == null || (bigInteger = this.f5752M1) == null || (bigInteger2 = this.f5755S) == null) {
            throw new CryptoException("Impossible to compute M2: some data are missing from the previous operations (A,M1,S)");
        }
        BigInteger calculateM2 = SRP6Util.calculateM2(this.digest, this.f5754N, bigInteger3, bigInteger, bigInteger2);
        this.f5753M2 = calculateM2;
        return calculateM2;
    }

    public BigInteger calculateSessionKey() throws CryptoException {
        BigInteger bigInteger = this.f5755S;
        if (bigInteger == null || this.f5752M1 == null || this.f5753M2 == null) {
            throw new CryptoException("Impossible to compute Key: some data are missing from the previous operations (S,M1,M2)");
        }
        BigInteger calculateKey = SRP6Util.calculateKey(this.digest, this.f5754N, bigInteger);
        this.Key = calculateKey;
        return calculateKey;
    }

    public BigInteger generateServerCredentials() {
        BigInteger calculateK = SRP6Util.calculateK(this.digest, this.f5754N, this.f5757g);
        this.f5756b = selectPrivateValue();
        BigInteger mod = calculateK.multiply(this.f5759v).mod(this.f5754N).add(this.f5757g.modPow(this.f5756b, this.f5754N)).mod(this.f5754N);
        this.f5751B = mod;
        return mod;
    }

    public void init(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, Digest digest2, SecureRandom secureRandom) {
        this.f5754N = bigInteger;
        this.f5757g = bigInteger2;
        this.f5759v = bigInteger3;
        this.random = secureRandom;
        this.digest = digest2;
    }

    public void init(SRP6GroupParameters sRP6GroupParameters, BigInteger bigInteger, Digest digest2, SecureRandom secureRandom) {
        init(sRP6GroupParameters.getN(), sRP6GroupParameters.getG(), bigInteger, digest2, secureRandom);
    }

    /* access modifiers changed from: protected */
    public BigInteger selectPrivateValue() {
        return SRP6Util.generatePrivateValue(this.digest, this.f5754N, this.f5757g, this.random);
    }

    public boolean verifyClientEvidenceMessage(BigInteger bigInteger) throws CryptoException {
        BigInteger bigInteger2;
        BigInteger bigInteger3;
        BigInteger bigInteger4 = this.f5750A;
        if (bigInteger4 == null || (bigInteger2 = this.f5751B) == null || (bigInteger3 = this.f5755S) == null) {
            throw new CryptoException("Impossible to compute and verify M1: some data are missing from the previous operations (A,B,S)");
        } else if (!SRP6Util.calculateM1(this.digest, this.f5754N, bigInteger4, bigInteger2, bigInteger3).equals(bigInteger)) {
            return false;
        } else {
            this.f5752M1 = bigInteger;
            return true;
        }
    }
}
