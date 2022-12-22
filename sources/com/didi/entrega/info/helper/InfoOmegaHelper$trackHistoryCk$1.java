package com.didi.entrega.info.helper;

import com.didi.entrega.customer.foundation.tracker.event.EventConst;
import com.didi.entrega.info.model.OmegaCommonModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(mo175977d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo175978d2 = {"<anonymous>", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: InfoOmegaHelper.kt */
final class InfoOmegaHelper$trackHistoryCk$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Ref.ObjectRef<String> $eventName;
    final /* synthetic */ OmegaCommonModel $omegaCommonModel;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InfoOmegaHelper$trackHistoryCk$1(Ref.ObjectRef<String> objectRef, OmegaCommonModel omegaCommonModel) {
        super(0);
        this.$eventName = objectRef;
        this.$omegaCommonModel = omegaCommonModel;
    }

    public final void invoke() {
        this.$eventName.element = EventConst.INFO.SAILING_C_E_ENTREGAPAGE_SENDER_HISTORYRECORD_CK;
        this.$omegaCommonModel.setFromPage(101);
    }
}
