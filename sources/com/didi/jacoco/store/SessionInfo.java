package com.didi.jacoco.store;

import com.didichuxing.bigdata.p173dp.locsdk.Const;

public class SessionInfo implements Comparable<SessionInfo> {
    private final long dump;

    /* renamed from: id */
    private final String f24388id;
    private final long start;

    public SessionInfo(String str, long j, long j2) {
        if (str != null) {
            this.f24388id = str;
            this.start = j;
            this.dump = j2;
            return;
        }
        throw new IllegalArgumentException();
    }

    public String getId() {
        return this.f24388id;
    }

    public long getStartTimeStamp() {
        return this.start;
    }

    public long getDumpTimeStamp() {
        return this.dump;
    }

    public int compareTo(SessionInfo sessionInfo) {
        long j = this.dump;
        long j2 = sessionInfo.dump;
        if (j < j2) {
            return -1;
        }
        return j > j2 ? 1 : 0;
    }

    public String toString() {
        return "SessionInfo[" + this.f24388id + Const.jaRight;
    }
}
