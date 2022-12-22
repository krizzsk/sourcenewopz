package com.didi.entrega.info.component;

import com.didi.entrega.customer.foundation.util.ToastUtil;
import com.didi.entrega.info.component.ContactConstract;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, mo175978d2 = {"<anonymous>", "", "msg", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.entrega.info.component.ContactConstract$AbsEditContactPresenter$onHistoryItemDeleteClick$2$1$2 */
/* compiled from: ContactConstract.kt */
final class C8194x471ce07f extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ ContactConstract.AbsEditContactPresenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C8194x471ce07f(ContactConstract.AbsEditContactPresenter absEditContactPresenter) {
        super(1);
        this.this$0 = absEditContactPresenter;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(String str) {
        Intrinsics.checkNotNullParameter(str, "msg");
        ((ContactConstract.AbsEditContactView) this.this$0.getLogicView()).hideLoading();
        ToastUtil.showCustomerToast(this.this$0.getScopeContext(), str);
    }
}
