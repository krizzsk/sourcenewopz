package com.didichuxing.alpha.lag;

import com.didichuxing.alpha.lag.internal.BlockInfo;
import java.util.ArrayList;
import java.util.LinkedHashMap;

class StackSampler extends AbstractSampler {
    private static final int DEFAULT_MAX_ENTRY_COUNT = 100;
    private static final LinkedHashMap<Long, String> sStackMap = new LinkedHashMap<>();
    private Thread mCurrentThread;
    private int mMaxEntryCount;

    public StackSampler(Thread thread, long j) {
        this(thread, 100, j);
    }

    public StackSampler(Thread thread, int i, long j) {
        super(j);
        this.mMaxEntryCount = 100;
        this.mCurrentThread = thread;
        this.mMaxEntryCount = i;
    }

    public ArrayList<String> getThreadStackEntries(long j, long j2) {
        ArrayList<String> arrayList = new ArrayList<>();
        synchronized (sStackMap) {
            for (Long next : sStackMap.keySet()) {
                if (j < next.longValue() && next.longValue() < j2) {
                    arrayList.add(BlockInfo.TIME_FORMATTER.format(next) + "\r\n" + "\r\n" + sStackMap.get(next));
                }
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public void doSample() {
        StringBuilder sb = new StringBuilder(2048);
        for (StackTraceElement stackTraceElement : this.mCurrentThread.getStackTrace()) {
            sb.append(stackTraceElement.toString());
            sb.append("\r\n");
        }
        synchronized (sStackMap) {
            if (sStackMap.size() == this.mMaxEntryCount && this.mMaxEntryCount > 0) {
                sStackMap.remove(sStackMap.keySet().iterator().next());
            }
            sStackMap.put(Long.valueOf(System.currentTimeMillis()), sb.toString());
        }
    }
}
