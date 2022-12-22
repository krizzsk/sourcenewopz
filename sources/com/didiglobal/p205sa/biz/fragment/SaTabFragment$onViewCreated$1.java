package com.didiglobal.p205sa.biz.fragment;

import com.didiglobal.p205sa.biz.tab.model.SaTabDataModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, mo175978d2 = {"<anonymous>", "", "it", "Lcom/didiglobal/sa/biz/tab/model/SaTabDataModel;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didiglobal.sa.biz.fragment.SaTabFragment$onViewCreated$1 */
/* compiled from: SaTabFragment.kt */
final class SaTabFragment$onViewCreated$1 extends Lambda implements Function1<SaTabDataModel, Unit> {
    final /* synthetic */ SaTabFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SaTabFragment$onViewCreated$1(SaTabFragment saTabFragment) {
        super(1);
        this.this$0 = saTabFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SaTabDataModel) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(SaTabDataModel saTabDataModel) {
        Intrinsics.checkNotNullParameter(saTabDataModel, "it");
        Function1<SaTabDataModel, Unit> refreshTabNotification = this.this$0.getRefreshTabNotification();
        if (refreshTabNotification != null) {
            refreshTabNotification.invoke(saTabDataModel);
        }
    }
}
