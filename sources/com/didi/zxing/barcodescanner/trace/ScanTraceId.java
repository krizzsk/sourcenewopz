package com.didi.zxing.barcodescanner.trace;

public interface ScanTraceId {
    public static final String SCAN_CODETYPE = "dqr_scan_codetype";
    public static final String SCAN_DUPLICATE = "dqr_scan_duplicate";
    public static final String SCAN_FINDQR = "dqr_scan_findqr";
    public static final String SCAN_FOCUS_FAIL = "dqr_scan_focus_fail";
    public static final String SCAN_FOCUS_TIMEOUT = "dqr_scan_focus_timeout";
    public static final String SCAN_START = "dqr_scan_start";
    public static final String SCAN_STOP = "dqr_scan_stop";
    public static final String SCAN_SUCCESS = "dqr_scan_success";

    public interface CodeType {

        /* renamed from: BH */
        public static final String f45451BH = "https://dc.tt/hm";
        public static final String BLUEGOGO = "https://www.bluegogo.com/qrcode.html?no=";
        public static final String NOKELOCK = "https://dc.tt/htw";
        public static final String OFO = "http://ofo.so/plate/";
    }
}
