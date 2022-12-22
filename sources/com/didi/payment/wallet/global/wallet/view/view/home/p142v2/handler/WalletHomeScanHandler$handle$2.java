package com.didi.payment.wallet.global.wallet.view.view.home.p142v2.handler;

import com.didiglobal.scan.data.ManualInputInfoItem;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo175978d2 = {"<anonymous>", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.handler.WalletHomeScanHandler$handle$2 */
/* compiled from: WalletHomeScanHandler.kt */
final class WalletHomeScanHandler$handle$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ManualInputInfoItem $manualInputInfoItem;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WalletHomeScanHandler$handle$2(ManualInputInfoItem manualInputInfoItem) {
        super(0);
        this.$manualInputInfoItem = manualInputInfoItem;
    }

    public final void invoke() {
        this.$manualInputInfoItem.setEnableEntrance(false);
    }
}
