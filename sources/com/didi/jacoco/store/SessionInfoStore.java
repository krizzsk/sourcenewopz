package com.didi.jacoco.store;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SessionInfoStore implements ISessionInfoVisitor {
    private final List<SessionInfo> infos = new ArrayList();

    public boolean isEmpty() {
        return this.infos.isEmpty();
    }

    public List<SessionInfo> getInfos() {
        ArrayList arrayList = new ArrayList(this.infos);
        Collections.sort(arrayList);
        return arrayList;
    }

    public SessionInfo getMerged(String str) {
        if (this.infos.isEmpty()) {
            return new SessionInfo(str, 0, 0);
        }
        long j = Long.MAX_VALUE;
        long j2 = Long.MIN_VALUE;
        for (SessionInfo next : this.infos) {
            j = Math.min(j, next.getStartTimeStamp());
            j2 = Math.max(j2, next.getDumpTimeStamp());
        }
        return new SessionInfo(str, j, j2);
    }

    public void accept(ISessionInfoVisitor iSessionInfoVisitor) {
        for (SessionInfo visitSessionInfo : getInfos()) {
            iSessionInfoVisitor.visitSessionInfo(visitSessionInfo);
        }
    }

    public void visitSessionInfo(SessionInfo sessionInfo) {
        this.infos.add(sessionInfo);
    }
}
