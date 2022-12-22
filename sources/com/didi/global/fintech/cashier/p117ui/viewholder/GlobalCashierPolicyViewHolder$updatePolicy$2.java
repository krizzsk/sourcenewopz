package com.didi.global.fintech.cashier.p117ui.viewholder;

import android.view.View;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, mo175978d2 = {"<anonymous>", "", "it", "Landroid/view/View;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.global.fintech.cashier.ui.viewholder.GlobalCashierPolicyViewHolder$updatePolicy$2 */
/* compiled from: GlobalCashierPolicyViewHolder.kt */
final class GlobalCashierPolicyViewHolder$updatePolicy$2 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ List<AcceptContent> $contents;
    final /* synthetic */ Function1<String, Unit> $linkListener;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GlobalCashierPolicyViewHolder$updatePolicy$2(Function1<? super String, Unit> function1, List<AcceptContent> list) {
        super(1);
        this.$linkListener = function1;
        this.$contents = list;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((View) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(View view) {
        AcceptContent acceptContent;
        Function1<String, Unit> function1 = this.$linkListener;
        if (function1 != null) {
            List<AcceptContent> list = this.$contents;
            String str = null;
            if (!(list == null || (acceptContent = list.get(1)) == null)) {
                str = acceptContent.getLink();
            }
            function1.invoke(str);
        }
    }
}
