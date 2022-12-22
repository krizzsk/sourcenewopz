package com.didichuxing.ditest.agent.android.util;

import com.didichuxing.ditest.agent.android.SavedState;

public class PersistentCounter {
    private SavedState savedState;

    public PersistentCounter(SavedState savedState2) {
        this.savedState = savedState2;
    }

    public boolean upperLimitToday(String str, long j) {
        String str2 = str + (System.currentTimeMillis() / 86400000);
        long j2 = this.savedState.getLong(str2);
        this.savedState.save(str2, 1 + j2);
        return j2 > j;
    }
}
