package com.didi.sdk.apm.utils;

import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;

public class TimingLogger {

    /* renamed from: a */
    ArrayList<Long> f35068a;

    /* renamed from: b */
    ArrayList<String> f35069b;

    /* renamed from: c */
    private String f35070c;

    /* renamed from: d */
    private String f35071d;

    /* renamed from: e */
    private boolean f35072e;

    public TimingLogger(String str, String str2) {
        reset(str, str2);
    }

    public TimingLogger setDisabled(boolean z) {
        this.f35072e = z;
        return this;
    }

    public void reset(String str, String str2) {
        this.f35070c = str;
        this.f35071d = str2;
        reset();
    }

    public void reset() {
        if (!this.f35072e) {
            ArrayList<Long> arrayList = this.f35068a;
            if (arrayList == null) {
                this.f35068a = new ArrayList<>();
                this.f35069b = new ArrayList<>();
            } else {
                arrayList.clear();
                this.f35069b.clear();
            }
            addSplit((String) null);
        }
    }

    public void addSplit(String str) {
        if (!this.f35072e) {
            this.f35068a.add(Long.valueOf(SystemClock.elapsedRealtime()));
            this.f35069b.add(str);
        }
    }

    public void dumpToLog() {
        if (!this.f35072e) {
            String str = this.f35070c;
            Log.d(str, this.f35071d + ": begin");
            long longValue = this.f35068a.get(0).longValue();
            long j = longValue;
            for (int i = 1; i < this.f35068a.size(); i++) {
                j = this.f35068a.get(i).longValue();
                long longValue2 = this.f35068a.get(i - 1).longValue();
                String str2 = this.f35070c;
                Log.d(str2, this.f35071d + ":      " + (j - longValue2) + " ms, " + this.f35069b.get(i));
            }
            String str3 = this.f35070c;
            Log.d(str3, this.f35071d + ": end, " + (j - longValue) + " ms");
        }
    }
}
