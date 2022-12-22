package com.pay99.diff_base.base;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, mo175978d2 = {"Lcom/pay99/diff_base/base/IAppDiff;", "", "handle", "", "context", "Landroid/content/Context;", "diff-base_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: IAppDiff.kt */
public interface IAppDiff {

    @Metadata(mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: IAppDiff.kt */
    public static final class DefaultImpls {
        public static void handle(IAppDiff iAppDiff, Context context) {
            Intrinsics.checkNotNullParameter(iAppDiff, "this");
            Intrinsics.checkNotNullParameter(context, "context");
        }
    }

    void handle(Context context);
}
