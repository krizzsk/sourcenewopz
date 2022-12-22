package org.bouncycastle.pqc.crypto.xmss;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.crypto.Digest;

final class WOTSPlusParameters {
    private final int digestSize;
    private final int len;
    private final int len1;
    private final int len2;
    private final XMSSOid oid;
    private final ASN1ObjectIdentifier treeDigest;
    private final int winternitzParameter;

    protected WOTSPlusParameters(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        if (aSN1ObjectIdentifier != null) {
            this.treeDigest = aSN1ObjectIdentifier;
            Digest digest = DigestUtil.getDigest(aSN1ObjectIdentifier);
            int digestSize2 = XMSSUtil.getDigestSize(digest);
            this.digestSize = digestSize2;
            this.winternitzParameter = 16;
            int ceil = (int) Math.ceil(((double) (digestSize2 * 8)) / ((double) XMSSUtil.log2(16)));
            this.len1 = ceil;
            int floor = ((int) Math.floor((double) (XMSSUtil.log2(ceil * (this.winternitzParameter - 1)) / XMSSUtil.log2(this.winternitzParameter)))) + 1;
            this.len2 = floor;
            this.len = this.len1 + floor;
            WOTSPlusOid lookup = WOTSPlusOid.lookup(digest.getAlgorithmName(), this.digestSize, this.winternitzParameter, this.len);
            this.oid = lookup;
            if (lookup == null) {
                throw new IllegalArgumentException("cannot find OID for digest algorithm: " + digest.getAlgorithmName());
            }
            return;
        }
        throw new NullPointerException("treeDigest == null");
    }

    /* access modifiers changed from: protected */
    public int getLen() {
        return this.len;
    }

    /* access modifiers changed from: protected */
    public int getLen1() {
        return this.len1;
    }

    /* access modifiers changed from: protected */
    public int getLen2() {
        return this.len2;
    }

    /* access modifiers changed from: protected */
    public XMSSOid getOid() {
        return this.oid;
    }

    public ASN1ObjectIdentifier getTreeDigest() {
        return this.treeDigest;
    }

    /* access modifiers changed from: protected */
    public int getTreeDigestSize() {
        return this.digestSize;
    }

    /* access modifiers changed from: protected */
    public int getWinternitzParameter() {
        return this.winternitzParameter;
    }
}
