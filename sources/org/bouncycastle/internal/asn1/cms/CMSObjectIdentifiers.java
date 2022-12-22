package org.bouncycastle.internal.asn1.cms;

import com.didichuxing.diface.logger.DiFaceLogger;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;

public interface CMSObjectIdentifiers {
    public static final ASN1ObjectIdentifier authEnvelopedData = PKCSObjectIdentifiers.id_ct_authEnvelopedData;
    public static final ASN1ObjectIdentifier authenticatedData = PKCSObjectIdentifiers.id_ct_authData;
    public static final ASN1ObjectIdentifier compressedData = PKCSObjectIdentifiers.id_ct_compressedData;
    public static final ASN1ObjectIdentifier data = PKCSObjectIdentifiers.data;
    public static final ASN1ObjectIdentifier digestedData = PKCSObjectIdentifiers.digestedData;
    public static final ASN1ObjectIdentifier encryptedData = PKCSObjectIdentifiers.encryptedData;
    public static final ASN1ObjectIdentifier envelopedData = PKCSObjectIdentifiers.envelopedData;
    public static final ASN1ObjectIdentifier id_RSASSA_PSS_SHAKE128;
    public static final ASN1ObjectIdentifier id_RSASSA_PSS_SHAKE256 = id_alg.branch(DiFaceLogger.EVENT_ID_APPEAL_DATA_SUBMIT_ENTER_VIDEO_TAKE);
    public static final ASN1ObjectIdentifier id_alg;
    public static final ASN1ObjectIdentifier id_ecdsa_with_shake128 = id_alg.branch(DiFaceLogger.EVENT_ID_APPEAL_DATA_SUBMIT_VIDEO_TAKE_EXIT);
    public static final ASN1ObjectIdentifier id_ecdsa_with_shake256 = id_alg.branch(DiFaceLogger.EVENT_ID_APPEAL_DATA_SUBMIT_START_VIDEO_TAKE);
    public static final ASN1ObjectIdentifier id_ri;
    public static final ASN1ObjectIdentifier id_ri_ocsp_response;
    public static final ASN1ObjectIdentifier id_ri_scvp = id_ri.branch("4");
    public static final ASN1ObjectIdentifier signedAndEnvelopedData = PKCSObjectIdentifiers.signedAndEnvelopedData;
    public static final ASN1ObjectIdentifier signedData = PKCSObjectIdentifiers.signedData;
    public static final ASN1ObjectIdentifier timestampedData = PKCSObjectIdentifiers.id_ct_timestampedData;

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.16");
        id_ri = aSN1ObjectIdentifier;
        id_ri_ocsp_response = aSN1ObjectIdentifier.branch("2");
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.6");
        id_alg = aSN1ObjectIdentifier2;
        id_RSASSA_PSS_SHAKE128 = aSN1ObjectIdentifier2.branch(DiFaceLogger.EVENT_ID_APPEAL_DATA_SUBMIT_ENTER_PHOTO_DEMO_CHECK);
    }
}
