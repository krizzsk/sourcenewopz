package com.didi.soda.bill.widgets.notify;

import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0016\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/soda/bill/widgets/notify/NotifyHolder;", "", "getView", "Landroid/view/View;", "parent", "Landroid/view/ViewGroup;", "isPrepared", "", "block", "Lkotlin/Function0;", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: NotifyLayout.kt */
public interface NotifyHolder {

    @Metadata(mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: NotifyLayout.kt */
    public static final class DefaultImpls {
        public static boolean isPrepared(NotifyHolder notifyHolder, Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(notifyHolder, "this");
            Intrinsics.checkNotNullParameter(function0, "block");
            return true;
        }
    }

    View getView(ViewGroup viewGroup);

    boolean isPrepared(Function0<Unit> function0);
}
