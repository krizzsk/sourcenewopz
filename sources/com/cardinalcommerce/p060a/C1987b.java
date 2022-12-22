package com.cardinalcommerce.p060a;

import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.cardinalcommerce.p060a.DSASigner;
import com.cardinalcommerce.p060a.GMCipherSpi;
import com.cardinalcommerce.p060a.GMSignatureSpi;
import java.io.IOException;
import java.math.BigInteger;
import java.security.cert.CRLException;
import java.security.cert.X509CRLEntry;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.asn1.ASN1Encoding;

/* renamed from: com.cardinalcommerce.a.b */
final class C1987b extends X509CRLEntry {

    /* renamed from: a */
    private GMSignatureSpi.sha256WithSM2.C1945configure f2508a;

    /* renamed from: b */
    private DSASigner.dsaSha3_224 f2509b;

    /* renamed from: c */
    private int f2510c;

    /* renamed from: d */
    private boolean f2511d;

    protected C1987b(GMSignatureSpi.sha256WithSM2.C1945configure configure, boolean z, DSASigner.dsaSha3_224 dsasha3_224) {
        this.f2508a = configure;
        this.f2509b = m1833a(z, dsasha3_224);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return obj instanceof C1987b ? this.f2508a.equals(((C1987b) obj).f2508a) : super.equals(this);
    }

    public final X500Principal getCertificateIssuer() {
        if (this.f2509b == null) {
            return null;
        }
        try {
            return new X500Principal(this.f2509b.getEncoded());
        } catch (IOException unused) {
            return null;
        }
    }

    public final Set getCriticalExtensionOIDs() {
        return m1834a(true);
    }

    public final byte[] getEncoded() throws CRLException {
        try {
            return this.f2508a.init(ASN1Encoding.DER);
        } catch (IOException e) {
            throw new CRLException(e.toString());
        }
    }

    public final Set getNonCriticalExtensionOIDs() {
        return m1834a(false);
    }

    public final boolean hasExtensions() {
        return this.f2508a.configure() != null;
    }

    public final boolean hasUnsupportedCriticalExtension() {
        Set criticalExtensionOIDs = getCriticalExtensionOIDs();
        return criticalExtensionOIDs != null && !criticalExtensionOIDs.isEmpty();
    }

    public final int hashCode() {
        if (!this.f2511d) {
            this.f2510c = super.hashCode();
            this.f2511d = true;
        }
        return this.f2510c;
    }

    /* renamed from: a */
    private DSASigner.dsaSha3_224 m1833a(boolean z, DSASigner.dsaSha3_224 dsasha3_224) {
        if (!z) {
            return null;
        }
        ASN1ObjectIdentifier aSN1ObjectIdentifier = GMCipherSpi.SM2withSha384.getWarnings;
        GMCipherSpi.SM2withSha224 configure = this.f2508a.configure();
        GMCipherSpi.SM2withSha384 sM2withSha384 = configure != null ? (GMCipherSpi.SM2withSha384) configure.cca_continue.get(aSN1ObjectIdentifier) : null;
        if (sM2withSha384 == null) {
            return dsasha3_224;
        }
        try {
            setLocationDataConsentGiven cca_continue = GMCipherSpi.SM2withSha384.cca_continue(sM2withSha384);
            GMCipherSpi.SM2withRMD[] sM2withRMDArr = (cca_continue != null ? new GMCipherSpi.SM2withSha256(setThreeDSRequestorAppURL.cca_continue((Object) cca_continue)) : null).cca_continue;
            int length = sM2withRMDArr.length;
            GMCipherSpi.SM2withRMD[] sM2withRMDArr2 = new GMCipherSpi.SM2withRMD[length];
            System.arraycopy(sM2withRMDArr, 0, sM2withRMDArr2, 0, length);
            for (int i = 0; i < length; i++) {
                if (sM2withRMDArr2[i].init == 4) {
                    return DSASigner.dsaSha3_224.getInstance(sM2withRMDArr2[i].Cardinal);
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }

    /* renamed from: a */
    private Set m1834a(boolean z) {
        GMCipherSpi.SM2withSha224 configure = this.f2508a.configure();
        if (configure == null) {
            return null;
        }
        HashSet hashSet = new HashSet();
        Enumeration elements = configure.configure.elements();
        while (elements.hasMoreElements()) {
            ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) elements.nextElement();
            if (z == ((GMCipherSpi.SM2withSha384) configure.cca_continue.get(aSN1ObjectIdentifier)).init()) {
                hashSet.add(aSN1ObjectIdentifier.init);
            }
        }
        return hashSet;
    }

    public final byte[] getExtensionValue(String str) {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier(str);
        GMCipherSpi.SM2withSha224 configure = this.f2508a.configure();
        GMCipherSpi.SM2withSha384 sM2withSha384 = configure != null ? (GMCipherSpi.SM2withSha384) configure.cca_continue.get(aSN1ObjectIdentifier) : null;
        if (sM2withSha384 == null) {
            return null;
        }
        try {
            return sM2withSha384.getRequestTimeout.getEncoded();
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder("Exception encoding: ");
            sb.append(e.toString());
            throw new IllegalStateException(sb.toString());
        }
    }

    public final BigInteger getSerialNumber() {
        return new BigInteger(setProxyAddress.Cardinal((Object) this.f2508a.configure.Cardinal(0)).Cardinal);
    }

    public final Date getRevocationDate() {
        return GMCipherSpi.SM2withSha512.init(this.f2508a.configure.Cardinal(1)).configure();
    }

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        String instance = setAnimation.getInstance();
        stringBuffer.append("      userCertificate: ");
        stringBuffer.append(getSerialNumber());
        stringBuffer.append(instance);
        stringBuffer.append("       revocationDate: ");
        stringBuffer.append(getRevocationDate());
        stringBuffer.append(instance);
        stringBuffer.append("       certificateIssuer: ");
        stringBuffer.append(getCertificateIssuer());
        stringBuffer.append(instance);
        GMCipherSpi.SM2withSha224 configure = this.f2508a.configure();
        if (configure != null) {
            Enumeration elements = configure.configure.elements();
            if (elements.hasMoreElements()) {
                stringBuffer.append("   crlEntryExtensions:");
                stringBuffer.append(instance);
                while (elements.hasMoreElements()) {
                    ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) elements.nextElement();
                    GMCipherSpi.SM2withSha384 sM2withSha384 = (GMCipherSpi.SM2withSha384) configure.cca_continue.get(aSN1ObjectIdentifier);
                    if (sM2withSha384.getRequestTimeout != null) {
                        getUiType getuitype = new getUiType(sM2withSha384.getRequestTimeout.cca_continue());
                        stringBuffer.append("                       critical(");
                        stringBuffer.append(sM2withSha384.init());
                        stringBuffer.append(") ");
                        try {
                            if (aSN1ObjectIdentifier.equals(GMCipherSpi.SM2withSha384.values)) {
                                stringBuffer.append(SignatureSpiLe.getInstance(getChallengeTimeout.configure(getuitype.cca_continue())));
                                stringBuffer.append(instance);
                            } else if (aSN1ObjectIdentifier.equals(GMCipherSpi.SM2withSha384.getWarnings)) {
                                stringBuffer.append("Certificate issuer: ");
                                setLocationDataConsentGiven cca_continue = getuitype.cca_continue();
                                stringBuffer.append(cca_continue != null ? new GMCipherSpi.SM2withSha256(setThreeDSRequestorAppURL.cca_continue((Object) cca_continue)) : null);
                                stringBuffer.append(instance);
                            } else {
                                stringBuffer.append(aSN1ObjectIdentifier.init);
                                stringBuffer.append(" value = ");
                                stringBuffer.append(DSASigner.dsaSha3_384.cca_continue((Object) getuitype.cca_continue()));
                                stringBuffer.append(instance);
                            }
                        } catch (Exception unused) {
                            stringBuffer.append(aSN1ObjectIdentifier.init);
                            stringBuffer.append(" value = *****");
                        }
                    }
                    stringBuffer.append(instance);
                }
            }
        }
        return stringBuffer.toString();
    }
}
