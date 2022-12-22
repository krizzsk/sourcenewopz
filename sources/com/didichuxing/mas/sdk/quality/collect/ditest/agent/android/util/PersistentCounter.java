package com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.util;

import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.SavedState;

public class PersistentCounter {

    /* renamed from: a */
    private SavedState f48068a;

    public PersistentCounter(SavedState savedState) {
        this.f48068a = savedState;
    }

    public boolean upperLimitToday(String str, long j) {
        String str2 = str + (System.currentTimeMillis() / 86400000);
        long j2 = this.f48068a.getLong(str2);
        this.f48068a.save(str2, 1 + j2);
        return j2 > j;
    }
}
