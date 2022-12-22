package com.didichuxing.omega.sdk.corelink.node;

import android.os.Process;
import com.didichuxing.omega.sdk.common.record.Event;
import java.util.concurrent.atomic.AtomicLong;

public class EventSeqNode {
    private static AtomicLong eventSeq = new AtomicLong(Long.valueOf(seq).longValue());
    private static String seq = (getPid() + ((System.currentTimeMillis() / 1000) % 100000) + "0");

    public static void addSeq(Event event) {
        event.setSeq(eventSeq.getAndIncrement());
    }

    private static String getPid() {
        int myPid = Process.myPid();
        String valueOf = String.valueOf(myPid);
        if (valueOf.length() <= 3) {
            return valueOf;
        }
        return String.valueOf(myPid % 1000);
    }
}
