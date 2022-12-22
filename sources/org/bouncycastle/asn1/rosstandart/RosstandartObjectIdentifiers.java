package org.bouncycastle.asn1.rosstandart;

import com.didi.raven.config.RavenConstants;
import com.didichuxing.xpanel.xcard.ParseHelper;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;

public interface RosstandartObjectIdentifiers {
    public static final ASN1ObjectIdentifier id_tc26;
    public static final ASN1ObjectIdentifier id_tc26_agreement;
    public static final ASN1ObjectIdentifier id_tc26_agreement_gost_3410_12_256;
    public static final ASN1ObjectIdentifier id_tc26_agreement_gost_3410_12_512 = id_tc26_agreement.branch("2");
    public static final ASN1ObjectIdentifier id_tc26_gost_28147_param_Z = id_tc26.branch("2.5.1.1");
    public static final ASN1ObjectIdentifier id_tc26_gost_3410_12_256 = id_tc26.branch(ParseHelper.XCARD_VERSION);
    public static final ASN1ObjectIdentifier id_tc26_gost_3410_12_256_paramSet;
    public static final ASN1ObjectIdentifier id_tc26_gost_3410_12_256_paramSetA;
    public static final ASN1ObjectIdentifier id_tc26_gost_3410_12_512 = id_tc26.branch("1.1.2");
    public static final ASN1ObjectIdentifier id_tc26_gost_3410_12_512_paramSet;
    public static final ASN1ObjectIdentifier id_tc26_gost_3410_12_512_paramSetA;
    public static final ASN1ObjectIdentifier id_tc26_gost_3410_12_512_paramSetB = id_tc26_gost_3410_12_512_paramSet.branch("2");
    public static final ASN1ObjectIdentifier id_tc26_gost_3410_12_512_paramSetC = id_tc26_gost_3410_12_512_paramSet.branch("3");
    public static final ASN1ObjectIdentifier id_tc26_gost_3411_12_256;
    public static final ASN1ObjectIdentifier id_tc26_gost_3411_12_512 = id_tc26.branch("1.2.3");
    public static final ASN1ObjectIdentifier id_tc26_hmac_gost_3411_12_256 = id_tc26.branch("1.4.1");
    public static final ASN1ObjectIdentifier id_tc26_hmac_gost_3411_12_512 = id_tc26.branch("1.4.2");
    public static final ASN1ObjectIdentifier id_tc26_signwithdigest_gost_3410_12_256 = id_tc26.branch(RavenConstants.SDK_VERSION);
    public static final ASN1ObjectIdentifier id_tc26_signwithdigest_gost_3410_12_512 = id_tc26.branch("1.3.3");
    public static final ASN1ObjectIdentifier rosstandart;

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier("1.2.643.7");
        rosstandart = aSN1ObjectIdentifier;
        ASN1ObjectIdentifier branch = aSN1ObjectIdentifier.branch("1");
        id_tc26 = branch;
        id_tc26_gost_3411_12_256 = branch.branch("1.2.2");
        ASN1ObjectIdentifier branch2 = id_tc26.branch("1.6");
        id_tc26_agreement = branch2;
        id_tc26_agreement_gost_3410_12_256 = branch2.branch("1");
        ASN1ObjectIdentifier branch3 = id_tc26.branch("2.1.1");
        id_tc26_gost_3410_12_256_paramSet = branch3;
        id_tc26_gost_3410_12_256_paramSetA = branch3.branch("1");
        ASN1ObjectIdentifier branch4 = id_tc26.branch("2.1.2");
        id_tc26_gost_3410_12_512_paramSet = branch4;
        id_tc26_gost_3410_12_512_paramSetA = branch4.branch("1");
    }
}
