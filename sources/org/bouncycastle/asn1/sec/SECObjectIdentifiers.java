package org.bouncycastle.asn1.sec;

import com.appsflyer.AppsFlyerLibCore;
import com.didi.travel.psnger.model.response.ScarShareReportModel;
import com.didichuxing.diface.logger.DiFaceLogger;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.p075x9.X9ObjectIdentifiers;

public interface SECObjectIdentifiers {
    public static final ASN1ObjectIdentifier dhSinglePass_cofactorDH_sha224kdf_scheme = secg_scheme.branch("14.0");
    public static final ASN1ObjectIdentifier dhSinglePass_cofactorDH_sha256kdf_scheme = secg_scheme.branch("14.1");
    public static final ASN1ObjectIdentifier dhSinglePass_cofactorDH_sha384kdf_scheme = secg_scheme.branch("14.2");
    public static final ASN1ObjectIdentifier dhSinglePass_cofactorDH_sha512kdf_scheme = secg_scheme.branch("14.3");
    public static final ASN1ObjectIdentifier dhSinglePass_stdDH_sha224kdf_scheme;
    public static final ASN1ObjectIdentifier dhSinglePass_stdDH_sha256kdf_scheme = secg_scheme.branch("11.1");
    public static final ASN1ObjectIdentifier dhSinglePass_stdDH_sha384kdf_scheme = secg_scheme.branch("11.2");
    public static final ASN1ObjectIdentifier dhSinglePass_stdDH_sha512kdf_scheme = secg_scheme.branch("11.3");
    public static final ASN1ObjectIdentifier ellipticCurve;
    public static final ASN1ObjectIdentifier mqvFull_sha224kdf_scheme = secg_scheme.branch("16.0");
    public static final ASN1ObjectIdentifier mqvFull_sha256kdf_scheme = secg_scheme.branch("16.1");
    public static final ASN1ObjectIdentifier mqvFull_sha384kdf_scheme = secg_scheme.branch("16.2");
    public static final ASN1ObjectIdentifier mqvFull_sha512kdf_scheme = secg_scheme.branch("16.3");
    public static final ASN1ObjectIdentifier mqvSinglePass_sha224kdf_scheme = secg_scheme.branch("15.0");
    public static final ASN1ObjectIdentifier mqvSinglePass_sha256kdf_scheme = secg_scheme.branch("15.1");
    public static final ASN1ObjectIdentifier mqvSinglePass_sha384kdf_scheme = secg_scheme.branch("15.2");
    public static final ASN1ObjectIdentifier mqvSinglePass_sha512kdf_scheme = secg_scheme.branch("15.3");
    public static final ASN1ObjectIdentifier secg_scheme;
    public static final ASN1ObjectIdentifier secp112r1 = ellipticCurve.branch("6");
    public static final ASN1ObjectIdentifier secp112r2 = ellipticCurve.branch("7");
    public static final ASN1ObjectIdentifier secp128r1 = ellipticCurve.branch("28");
    public static final ASN1ObjectIdentifier secp128r2 = ellipticCurve.branch(DiFaceLogger.EVENT_ID_APPEAL_DATA_SUBMIT_ENTER_VIDEO_DEMO_CHECK);
    public static final ASN1ObjectIdentifier secp160k1 = ellipticCurve.branch("9");
    public static final ASN1ObjectIdentifier secp160r1 = ellipticCurve.branch("8");
    public static final ASN1ObjectIdentifier secp160r2 = ellipticCurve.branch(DiFaceLogger.EVENT_ID_APPEAL_DATA_SUBMIT_ENTER_PHOTO_DEMO_CHECK);
    public static final ASN1ObjectIdentifier secp192k1 = ellipticCurve.branch(DiFaceLogger.EVENT_ID_APPEAL_DATA_SUBMIT_ENTER_VIDEO_TAKE);
    public static final ASN1ObjectIdentifier secp192r1 = X9ObjectIdentifiers.prime192v1;
    public static final ASN1ObjectIdentifier secp224k1 = ellipticCurve.branch(DiFaceLogger.EVENT_ID_APPEAL_DATA_SUBMIT_VIDEO_TAKE_EXIT);
    public static final ASN1ObjectIdentifier secp224r1 = ellipticCurve.branch(DiFaceLogger.EVENT_ID_APPEAL_DATA_SUBMIT_START_VIDEO_TAKE);
    public static final ASN1ObjectIdentifier secp256k1 = ellipticCurve.branch("10");
    public static final ASN1ObjectIdentifier secp256r1 = X9ObjectIdentifiers.prime256v1;
    public static final ASN1ObjectIdentifier secp384r1 = ellipticCurve.branch(DiFaceLogger.EVENT_ID_APPEAL_DATA_SUBMIT_STOP_VIDEO_TAKE);
    public static final ASN1ObjectIdentifier secp521r1 = ellipticCurve.branch(DiFaceLogger.EVENT_ID_APPEAL_DATA_SUBMIT_CONFIRM_VIDEO_NO);
    public static final ASN1ObjectIdentifier sect113r1 = ellipticCurve.branch("4");
    public static final ASN1ObjectIdentifier sect113r2 = ellipticCurve.branch("5");
    public static final ASN1ObjectIdentifier sect131r1 = ellipticCurve.branch(ScarShareReportModel.CHANNEL_WHATSAPP);
    public static final ASN1ObjectIdentifier sect131r2 = ellipticCurve.branch(ScarShareReportModel.CHANNEL_TWITTER);
    public static final ASN1ObjectIdentifier sect163k1;
    public static final ASN1ObjectIdentifier sect163r1 = ellipticCurve.branch("2");
    public static final ASN1ObjectIdentifier sect163r2 = ellipticCurve.branch(DiFaceLogger.EVENT_ID_COMPARE_REQUEST_LAUNCH);
    public static final ASN1ObjectIdentifier sect193r1 = ellipticCurve.branch(ScarShareReportModel.CHANNEL_MESSENGER);
    public static final ASN1ObjectIdentifier sect193r2 = ellipticCurve.branch(ScarShareReportModel.CHANNEL_EMAIL);
    public static final ASN1ObjectIdentifier sect233k1 = ellipticCurve.branch(ScarShareReportModel.CHANNEL_LINE);
    public static final ASN1ObjectIdentifier sect233r1 = ellipticCurve.branch("27");
    public static final ASN1ObjectIdentifier sect239k1 = ellipticCurve.branch("3");
    public static final ASN1ObjectIdentifier sect283k1 = ellipticCurve.branch("16");
    public static final ASN1ObjectIdentifier sect283r1 = ellipticCurve.branch(DiFaceLogger.EVENT_ID_BIOASSAY_EXIT);
    public static final ASN1ObjectIdentifier sect409k1 = ellipticCurve.branch(DiFaceLogger.EVENT_ID_APPEAL_DATA_SUBMIT_CONFIRM_VIDEO_YES);
    public static final ASN1ObjectIdentifier sect409r1 = ellipticCurve.branch("37");
    public static final ASN1ObjectIdentifier sect571k1 = ellipticCurve.branch(AppsFlyerLibCore.f1788);
    public static final ASN1ObjectIdentifier sect571r1 = ellipticCurve.branch("39");

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier("1.3.132.0");
        ellipticCurve = aSN1ObjectIdentifier;
        sect163k1 = aSN1ObjectIdentifier.branch("1");
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = new ASN1ObjectIdentifier("1.3.132.1");
        secg_scheme = aSN1ObjectIdentifier2;
        dhSinglePass_stdDH_sha224kdf_scheme = aSN1ObjectIdentifier2.branch("11.0");
    }
}
