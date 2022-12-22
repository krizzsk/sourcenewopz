package com.pay99.diff_base;

import android.text.TextUtils;
import com.pay99.diff_base.base.IDiff;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u0005J\u0018\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0006R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo175978d2 = {"Lcom/pay99/diff_base/DiffContain;", "", "()V", "diffContain", "", "", "Lcom/pay99/diff_base/base/IDiff;", "getContain", "key", "putContain", "value", "diff-base_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: DiffUtil.kt */
public final class DiffContain {

    /* renamed from: a */
    private final Map<String, IDiff> f55808a = new LinkedHashMap();

    public final IDiff putContain(String str, IDiff iDiff) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(iDiff, "value");
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        IDiff iDiff2 = this.f55808a.get(str);
        this.f55808a.put(str, iDiff);
        return iDiff2;
    }

    public final IDiff getContain(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f55808a.get(str);
    }
}
