package org.bouncycastle.asn1.nsri;

import androidx.room.RoomMasterTable;
import com.appsflyer.AppsFlyerLibCore;
import com.didi.travel.psnger.model.response.ScarShareReportModel;
import com.didichuxing.diface.logger.DiFaceLogger;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;

public interface NSRIObjectIdentifiers {
    public static final ASN1ObjectIdentifier id_algorithm;
    public static final ASN1ObjectIdentifier id_aria128_cbc = id_sea.branch("2");
    public static final ASN1ObjectIdentifier id_aria128_ccm = id_sea.branch("37");
    public static final ASN1ObjectIdentifier id_aria128_cfb = id_sea.branch("3");
    public static final ASN1ObjectIdentifier id_aria128_cmac = id_sea.branch(ScarShareReportModel.CHANNEL_FACEBOOK);
    public static final ASN1ObjectIdentifier id_aria128_ctr = id_sea.branch("5");
    public static final ASN1ObjectIdentifier id_aria128_ecb = id_sea.branch("1");
    public static final ASN1ObjectIdentifier id_aria128_gcm = id_sea.branch(DiFaceLogger.EVENT_ID_APPEAL_DATA_SUBMIT_STOP_VIDEO_TAKE);
    public static final ASN1ObjectIdentifier id_aria128_kw = id_sea.branch("40");
    public static final ASN1ObjectIdentifier id_aria128_kwp = id_sea.branch("43");
    public static final ASN1ObjectIdentifier id_aria128_ocb2 = id_sea.branch(DiFaceLogger.EVENT_ID_APPEAL_DATA_SUBMIT_ENTER_VIDEO_TAKE);
    public static final ASN1ObjectIdentifier id_aria128_ofb = id_sea.branch("4");
    public static final ASN1ObjectIdentifier id_aria192_cbc = id_sea.branch("7");
    public static final ASN1ObjectIdentifier id_aria192_ccm = id_sea.branch(AppsFlyerLibCore.f1788);
    public static final ASN1ObjectIdentifier id_aria192_cfb = id_sea.branch("8");
    public static final ASN1ObjectIdentifier id_aria192_cmac = id_sea.branch(ScarShareReportModel.CHANNEL_WHATSAPP);
    public static final ASN1ObjectIdentifier id_aria192_ctr = id_sea.branch("10");
    public static final ASN1ObjectIdentifier id_aria192_ecb = id_sea.branch("6");
    public static final ASN1ObjectIdentifier id_aria192_gcm = id_sea.branch(DiFaceLogger.EVENT_ID_APPEAL_DATA_SUBMIT_CONFIRM_VIDEO_NO);
    public static final ASN1ObjectIdentifier id_aria192_kw = id_sea.branch("41");
    public static final ASN1ObjectIdentifier id_aria192_kwp = id_sea.branch("44");
    public static final ASN1ObjectIdentifier id_aria192_ocb2 = id_sea.branch(DiFaceLogger.EVENT_ID_APPEAL_DATA_SUBMIT_VIDEO_TAKE_EXIT);
    public static final ASN1ObjectIdentifier id_aria192_ofb = id_sea.branch("9");
    public static final ASN1ObjectIdentifier id_aria256_cbc = id_sea.branch("12");
    public static final ASN1ObjectIdentifier id_aria256_ccm = id_sea.branch("39");
    public static final ASN1ObjectIdentifier id_aria256_cfb = id_sea.branch(DiFaceLogger.EVENT_ID_BIOASSAY_ACTION_SUCCESS);
    public static final ASN1ObjectIdentifier id_aria256_cmac = id_sea.branch(ScarShareReportModel.CHANNEL_TWITTER);
    public static final ASN1ObjectIdentifier id_aria256_ctr = id_sea.branch(DiFaceLogger.EVENT_ID_COMPARE_REQUEST_LAUNCH);
    public static final ASN1ObjectIdentifier id_aria256_ecb = id_sea.branch("11");
    public static final ASN1ObjectIdentifier id_aria256_gcm = id_sea.branch(DiFaceLogger.EVENT_ID_APPEAL_DATA_SUBMIT_CONFIRM_VIDEO_YES);
    public static final ASN1ObjectIdentifier id_aria256_kw = id_sea.branch(RoomMasterTable.DEFAULT_ID);
    public static final ASN1ObjectIdentifier id_aria256_kwp = id_sea.branch("45");
    public static final ASN1ObjectIdentifier id_aria256_ocb2 = id_sea.branch(DiFaceLogger.EVENT_ID_APPEAL_DATA_SUBMIT_START_VIDEO_TAKE);
    public static final ASN1ObjectIdentifier id_aria256_ofb = id_sea.branch("14");
    public static final ASN1ObjectIdentifier id_pad = id_algorithm.branch("2");
    public static final ASN1ObjectIdentifier id_pad_1 = id_algorithm.branch("1");
    public static final ASN1ObjectIdentifier id_pad_null = id_algorithm.branch("0");
    public static final ASN1ObjectIdentifier id_sea;
    public static final ASN1ObjectIdentifier nsri;

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier("1.2.410.200046");
        nsri = aSN1ObjectIdentifier;
        ASN1ObjectIdentifier branch = aSN1ObjectIdentifier.branch("1");
        id_algorithm = branch;
        id_sea = branch.branch("1");
    }
}
