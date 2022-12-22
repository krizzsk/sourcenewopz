package com.didichuxing.upgrade;

import com.didichuxing.bean.UpdateResponse;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, mo175978d2 = {"<anonymous>", "", "run", "com/didichuxing/upgrade/UpgradeSDK$syncUpdates$1$onRequestSuccess$2$1"}, mo175979k = 3, mo175980mv = {1, 1, 15})
/* renamed from: com.didichuxing.upgrade.UpgradeSDK$syncUpdates$1$onRequestSuccess$$inlined$apply$lambda$1 */
/* compiled from: UpgradeSDK.kt */
final class C16518x63136d84 implements Runnable {
    final /* synthetic */ UpdateResponse $response$inlined;
    final /* synthetic */ UpgradeSDK$syncUpdates$1 this$0;

    C16518x63136d84(UpgradeSDK$syncUpdates$1 upgradeSDK$syncUpdates$1, UpdateResponse updateResponse) {
        this.this$0 = upgradeSDK$syncUpdates$1;
        this.$response$inlined = updateResponse;
    }

    public final void run() {
        this.this$0.this$0.m35517a(this.$response$inlined);
    }
}
