package com.didi.global.fintech.cashier.core;

import android.content.Intent;
import android.view.View;
import com.didi.payment.base.view.webview.PayBaseWebActivity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, mo175978d2 = {"<anonymous>", "", "it", "Landroid/view/View;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCashierPlansInfoActivity.kt */
final class GlobalCashierPlansInfoActivity$initData$1$2$1 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ String $url;
    final /* synthetic */ GlobalCashierPlansInfoActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GlobalCashierPlansInfoActivity$initData$1$2$1(GlobalCashierPlansInfoActivity globalCashierPlansInfoActivity, String str) {
        super(1);
        this.this$0 = globalCashierPlansInfoActivity;
        this.$url = str;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((View) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(View view) {
        Intent intent = new Intent(this.this$0, GlobalCashierWebActivity.class);
        intent.putExtra(PayBaseWebActivity.EXTRA_URL, this.$url);
        this.this$0.startActivity(intent);
        GlobalCashierPlansInfoActivity.m15722a(this.this$0, 2, (Integer) null, 2, (Object) null);
    }
}
