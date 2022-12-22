package com.pay99.diff_base.base;

import java.util.Map;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\bH&¨\u0006\n"}, mo175978d2 = {"Lcom/pay99/diff_base/base/ITrackEvent;", "Lcom/pay99/diff_base/base/IDiff;", "trackEvent", "", "driverKey", "", "passengerKey", "params", "", "", "diff-base_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ITrackEvent.kt */
public interface ITrackEvent extends IDiff {
    void trackEvent(String str, String str2);

    void trackEvent(String str, String str2, Map<String, ? extends Object> map);
}
