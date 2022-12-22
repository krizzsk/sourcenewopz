package com.didichuxing.omega.sdk.trafficstat.datareader.snapshot;

import com.didichuxing.omega.sdk.analysis.Tracker;
import com.didichuxing.omega.sdk.trafficstat.datareader.exception.StatsParseException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FormatCheck {
    public static Boolean isHeaderCorrect;

    public static boolean isAdapterSuccess() {
        if (isHeaderCorrect == null) {
            isHeaderCorrect = Boolean.valueOf(checkFileHeader());
        }
        return isHeaderCorrect.booleanValue();
    }

    private static boolean checkFileHeader() {
        try {
            checkHeaderLine(new ProcFileReader(new FileInputStream(new File("/proc/", "net/xt_qtaguid/stats"))));
            return true;
        } catch (IOException e) {
            Tracker.trackGood("omega_generic_traffic_stat:checkFileHeader1", e);
            e.printStackTrace();
            return false;
        } catch (StatsParseException e2) {
            Tracker.trackGood("omega_generic_traffic_stat:checkFileHeader2", e2);
            e2.printStackTrace();
            return false;
        }
    }

    private static void checkHeaderLine(ProcFileReader procFileReader) throws IOException, StatsParseException {
        String[] strArr = {"idx", "iface", "acct_tag_hex", "uid_tag_int", "cnt_set", "rx_bytes", "rx_packets", "tx_bytes", "tx_packets"};
        for (int i = 0; i < 9; i++) {
            String str = strArr[i];
            String nextString = procFileReader.nextString();
            if (!str.equals(nextString)) {
                throwFieldFailureException(nextString, str);
            }
        }
        procFileReader.finishLine();
    }

    private static void throwFieldFailureException(String str, String str2) throws StatsParseException {
        throw new StatsParseException("Unknown field \"" + str + "\" when check " + str2);
    }
}
