package com.didi.global.ninja.strategy;

import android.content.Context;
import com.didi.global.ninja.Ninja;
import com.didi.global.ninja.utils.SharedPreferencesUtils;
import com.didi.global.ninja.utils.TrackEvent;
import com.didi.sdk.apm.SystemUtils;

public class CountStrategy implements IStrategy {

    /* renamed from: a */
    private Context f22868a;

    /* renamed from: b */
    private String f22869b;

    /* renamed from: c */
    private int f22870c = 1;

    /* renamed from: d */
    private long f22871d = 86400;

    /* renamed from: e */
    private int f22872e = 0;

    /* renamed from: f */
    private long f22873f = 0;

    /* renamed from: g */
    private boolean f22874g = false;

    /* renamed from: h */
    private boolean f22875h = false;

    /* renamed from: i */
    private boolean f22876i = false;

    public CountStrategy(String str) {
        this.f22869b = str;
    }

    public CountStrategy(String str, int i, long j) {
        this.f22869b = str;
        this.f22870c = i;
        this.f22871d = j;
    }

    public synchronized boolean isHit() {
        if (this.f22875h) {
            return this.f22876i;
        }
        boolean hitStatus = getHitStatus();
        this.f22876i = hitStatus;
        this.f22875h = true;
        return hitStatus;
    }

    public synchronized void filter() {
        int i = this.f22872e + 1;
        this.f22872e = i;
        m16447a(i);
    }

    public synchronized boolean init() {
        if (!this.f22874g) {
            this.f22872e = m16450b();
            this.f22873f = m16451c();
            SystemUtils.log(4, Ninja.TAG, ">>>>>>recordCount>>>>>" + this.f22872e, (Throwable) null, "com.didi.global.ninja.strategy.CountStrategy", 58);
            SystemUtils.log(4, Ninja.TAG, ">>>>>>recordTime>>>>>" + this.f22873f, (Throwable) null, "com.didi.global.ninja.strategy.CountStrategy", 59);
            this.f22874g = true;
        }
        return this.f22874g;
    }

    public String getName() {
        return this.f22869b;
    }

    public void setContext(Context context) {
        this.f22868a = context;
    }

    /* renamed from: a */
    private boolean m16449a() {
        return (System.currentTimeMillis() / 1000) - this.f22873f < this.f22871d;
    }

    public boolean getHitStatus() {
        boolean z = false;
        if (this.f22872e >= this.f22870c) {
            if (this.f22873f == 0) {
                m16448a(System.currentTimeMillis() / 1000);
            } else if (!m16449a()) {
                m16447a(0);
                m16448a(0);
                TrackEvent.trackResume(this.f22869b);
            }
            z = true;
        }
        if (z) {
            TrackEvent.trackHit(this.f22869b, true);
        }
        return z;
    }

    /* renamed from: a */
    private void m16447a(int i) {
        this.f22872e = i;
        SharedPreferencesUtils.getInstance(this.f22868a).writeSPInt(m16452d(), this.f22872e);
    }

    /* renamed from: b */
    private int m16450b() {
        return SharedPreferencesUtils.getInstance(this.f22868a).readSPInt(m16452d(), 0);
    }

    /* renamed from: a */
    private void m16448a(long j) {
        this.f22873f = j;
        SharedPreferencesUtils.getInstance(this.f22868a).writeSPLong(m16453e(), this.f22873f);
    }

    /* renamed from: c */
    private long m16451c() {
        return SharedPreferencesUtils.getInstance(this.f22868a).readSPLong(m16453e(), 0);
    }

    /* renamed from: d */
    private String m16452d() {
        return "count_" + this.f22869b;
    }

    /* renamed from: e */
    private String m16453e() {
        return "time_" + this.f22869b;
    }
}
