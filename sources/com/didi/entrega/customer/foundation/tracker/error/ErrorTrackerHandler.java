package com.didi.entrega.customer.foundation.tracker.error;

import java.util.Map;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\bf\u0018\u00002\u00020\u0001JD\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00052\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\nH&¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/entrega/customer/foundation/tracker/error/ErrorTrackerHandler;", "", "trackError", "", "moduleName", "", "errorName", "errorType", "errorMsg", "map", "", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ErrorTrackerHandler.kt */
public interface ErrorTrackerHandler {
    void trackError(String str, String str2, String str3, String str4, Map<String, ? extends Object> map);
}
