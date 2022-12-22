package com.didichuxing.mas.sdk.quality.collect.trafficstat.datareader.snapshot;

import com.didichuxing.mas.sdk.quality.collect.trafficstat.datareader.exception.StatsParseException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FormatCheck {
    public static Boolean isHeaderCorrect;

    public static boolean isAdapterSuccess() {
        if (isHeaderCorrect == null) {
            isHeaderCorrect = Boolean.valueOf(m34375a());
        }
        return isHeaderCorrect.booleanValue();
    }

    /* renamed from: a */
    private static boolean m34375a() {
        try {
            m34373a(new ProcFileReader(new FileInputStream(new File("/proc/", "net/xt_qtaguid/stats"))));
            return true;
        } catch (StatsParseException | IOException unused) {
            return false;
        }
    }

    /* renamed from: a */
    private static void m34373a(ProcFileReader procFileReader) throws IOException, StatsParseException {
        String[] strArr = {"idx", "iface", "acct_tag_hex", "uid_tag_int", "cnt_set", "rx_bytes", "rx_packets", "tx_bytes", "tx_packets"};
        for (int i = 0; i < 9; i++) {
            String str = strArr[i];
            String nextString = procFileReader.nextString();
            if (!str.equals(nextString)) {
                m34374a(nextString, str);
            }
        }
        procFileReader.finishLine();
    }

    /* renamed from: a */
    private static void m34374a(String str, String str2) throws StatsParseException {
        throw new StatsParseException("Unknown field \"" + str + "\" when check " + str2);
    }
}
