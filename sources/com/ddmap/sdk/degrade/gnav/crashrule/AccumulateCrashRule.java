package com.ddmap.sdk.degrade.gnav.crashrule;

import com.ddmap.sdk.degrade.gnav.GoogleNavDegrade;
import com.didi.raven.config.RavenKey;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016R\u000e\u0010\u0007\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, mo175978d2 = {"Lcom/ddmap/sdk/degrade/gnav/crashrule/AccumulateCrashRule;", "Lcom/ddmap/sdk/degrade/gnav/crashrule/ICrashRule;", "Lorg/json/JSONArray;", "periodHours", "", "counts", "(II)V", "mCounts", "mPeriodHours", "needDegrade", "", "t", "Degrade_release"}, mo175979k = 1, mo175980mv = {1, 1, 13})
/* compiled from: AccumulateCrashRule.kt */
public final class AccumulateCrashRule implements ICrashRule<JSONArray> {

    /* renamed from: a */
    private int f4295a;

    /* renamed from: b */
    private int f4296b;

    public AccumulateCrashRule(int i, int i2) {
        this.f4295a = i;
        this.f4296b = i2;
    }

    public boolean needDegrade(JSONArray jSONArray) {
        Intrinsics.checkParameterIsNotNull(jSONArray, RavenKey.TYPE);
        if (this.f4296b <= 0 || this.f4295a <= 0 || jSONArray.length() < this.f4296b) {
            return false;
        }
        float currentTimeMillis = ((float) System.currentTimeMillis()) - (((float) (((this.f4295a * 60) * 60) * 1000)) * 1.0f);
        GoogleNavDegrade.Companion companion = GoogleNavDegrade.Companion;
        companion.debug("满足计算周期的最早时间 ：" + currentTimeMillis);
        int length = jSONArray.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (((float) jSONArray.optLong(i2, 0)) >= currentTimeMillis) {
                i++;
            }
        }
        GoogleNavDegrade.Companion companion2 = GoogleNavDegrade.Companion;
        companion2.debug("Apollo配置次数 ：" + this.f4296b);
        GoogleNavDegrade.Companion companion3 = GoogleNavDegrade.Companion;
        companion3.debug("周期内发生的crash次数 ：" + i);
        if (i >= this.f4296b) {
            return true;
        }
        return false;
    }
}
