package com.didi.component.driverbar.view;

import com.didiglobal.travel.biz.util.OmegaTraceWrapper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, mo175978d2 = {"<anonymous>", "", "Lcom/didiglobal/travel/biz/util/OmegaTraceWrapper;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: DriverBarOnServiceJapanStyleView.kt */
final class DriverBarOnServiceJapanStyleView$onDriverAvatarClick$1 extends Lambda implements Function1<OmegaTraceWrapper, Unit> {
    public static final DriverBarOnServiceJapanStyleView$onDriverAvatarClick$1 INSTANCE = new DriverBarOnServiceJapanStyleView$onDriverAvatarClick$1();

    DriverBarOnServiceJapanStyleView$onDriverAvatarClick$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((OmegaTraceWrapper) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(OmegaTraceWrapper omegaTraceWrapper) {
        Intrinsics.checkNotNullParameter(omegaTraceWrapper, "$this$omega");
        omegaTraceWrapper.setEventId("ibt_gp_tripservice_driverhead_ck");
    }
}
