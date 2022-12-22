package com.didi.soda.customer.compose.action;

import android.net.Uri;
import android.text.TextUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/soda/customer/compose/action/ComposeActionAnalyse;", "", "()V", "doUrlPathAnalyse", "Lcom/didi/soda/customer/compose/action/ComposePathType;", "action", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ComposeActionAnalyse.kt */
public final class ComposeActionAnalyse {
    public final ComposePathType doUrlPathAnalyse(String str) {
        if (str == null) {
            return null;
        }
        int i = 0;
        String str2 = Uri.parse(str).getPathSegments().get(0);
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        ComposePathType[] values = ComposePathType.values();
        int length = values.length;
        while (i < length) {
            ComposePathType composePathType = values[i];
            i++;
            if (Intrinsics.areEqual((Object) composePathType.getType(), (Object) str2)) {
                return composePathType;
            }
        }
        return null;
    }
}
