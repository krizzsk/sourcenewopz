package org.bouncycastle.crypto.agreement.srp;

import java.math.BigInteger;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.params.SRP6GroupParameters;

public class SRP6VerifierGenerator {

    /* renamed from: N */
    protected BigInteger f5760N;
    protected Digest digest;

    /* renamed from: g */
    protected BigInteger f5761g;

    public BigInteger generateVerifier(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return this.f5761g.modPow(SRP6Util.calculateX(this.digest, this.f5760N, bArr, bArr2, bArr3), this.f5760N);
    }

    public void init(BigInteger bigInteger, BigInteger bigInteger2, Digest digest2) {
        this.f5760N = bigInteger;
        this.f5761g = bigInteger2;
        this.digest = digest2;
    }

    public void init(SRP6GroupParameters sRP6GroupParameters, Digest digest2) {
        this.f5760N = sRP6GroupParameters.getN();
        this.f5761g = sRP6GroupParameters.getG();
        this.digest = digest2;
    }
}
