package com.didichuxing.omega.sdk.corelink.node;

import android.os.Process;
import com.didichuxing.omega.sdk.common.utils.Constants;
import java.util.concurrent.atomic.AtomicLong;

public class EventRecordNameNode {
    private static AtomicLong eventSeq = new AtomicLong(0);
    static final int mPid = Process.myPid();

    static String getRecordName() {
        return Constants.FILE_EVENT_MMKV_CACHE + mPid + "_" + System.currentTimeMillis() + "_" + getSeqSafe();
    }

    private static Long getSeqSafe() {
        return Long.valueOf(eventSeq.getAndIncrement());
    }
}
