package com.didi.component.operationpanel.model;

import androidx.fragment.app.Fragment;
import com.didi.component.business.sharetrip.CommonTripShareManager;
import com.didi.onekeyshare.entity.ShareInfo;
import com.didiglobal.travel.infra.rxjava2.SingleSubscribe;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*(\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005 \u0006*\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00030\u00030\u0002H\n"}, mo175978d2 = {"<anonymous>", "", "Lcom/didiglobal/travel/infra/rxjava2/SingleSubscribe;", "Lkotlin/Pair;", "Lcom/didi/component/business/sharetrip/CommonTripShareManager;", "Lcom/didi/onekeyshare/entity/ShareInfo;", "kotlin.jvm.PlatformType"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OperationPanelModel.kt */
final class OperationPanelModel$doShare$2 extends Lambda implements Function1<SingleSubscribe<Pair<? extends CommonTripShareManager, ? extends ShareInfo>>, Unit> {
    final /* synthetic */ Fragment $fragment;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OperationPanelModel$doShare$2(Fragment fragment) {
        super(1);
        this.$fragment = fragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SingleSubscribe<Pair<CommonTripShareManager, ShareInfo>>) (SingleSubscribe) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(SingleSubscribe<Pair<CommonTripShareManager, ShareInfo>> singleSubscribe) {
        Intrinsics.checkNotNullParameter(singleSubscribe, "$this$subscribeBy");
        final Fragment fragment = this.$fragment;
        singleSubscribe.onSuccess(new Function1<Pair<? extends CommonTripShareManager, ? extends ShareInfo>, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Pair<? extends CommonTripShareManager, ? extends ShareInfo>) (Pair) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Pair<? extends CommonTripShareManager, ? extends ShareInfo> pair) {
                ((CommonTripShareManager) pair.component1()).showDialogIfAvailable(fragment.requireActivity(), (ShareInfo) pair.component2());
            }
        });
        singleSubscribe.onError(C64212.INSTANCE);
    }
}
