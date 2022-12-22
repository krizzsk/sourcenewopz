package com.didichuxing.bigdata.p173dp.locsdk;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.Cgi */
public class Cgi {
    public static final int iCdmaT = 2;
    public static final int iDefCgiT = 0;
    public static final int iGsmOldT = 5;
    public static final int iGsmT = 1;
    public static final int iLteT = 4;
    public static final int iWcdmaT = 3;
    public int cid_bid = 0;
    public long detectedTs = 0;
    public int lac_nid = 0;
    public int lat = 0;
    public int lon = 0;
    public String mcc = "";
    public String mnc_sid = "";
    public int sig = Const.iDefCgiSig;
    public int type = 0;

    public boolean isSame(Cgi cgi) {
        return cgi != null && this.mcc.equals(cgi.mcc) && this.mnc_sid.equals(cgi.mnc_sid) && this.cid_bid == cgi.cid_bid && this.lac_nid == cgi.lac_nid;
    }

    public String toString() {
        return "Cgi{mcc='" + this.mcc + '\'' + ", mnc_sid='" + this.mnc_sid + '\'' + ", cid_bid=" + this.cid_bid + ", lat=" + this.lat + ", lon=" + this.lon + ", lac_nid=" + this.lac_nid + ", sig=" + this.sig + ", type=" + this.type + ", detectedTs=" + this.detectedTs + '}';
    }
}
