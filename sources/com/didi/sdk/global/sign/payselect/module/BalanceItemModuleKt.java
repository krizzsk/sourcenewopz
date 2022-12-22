package com.didi.sdk.global.sign.payselect.module;

import com.didi.sdk.global.sign.model.local.PaySelItemData;
import com.didi.sdk.global.sign.payselect.utils.PaySelUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0010\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo175978d2 = {"hasShowGuideView", "", "canShowTopUpBtn", "data", "Lcom/didi/sdk/global/sign/model/local/PaySelItemData;", "is99WalletNotSufficientNotCombined", "payment_globalRelease"}, mo175979k = 2, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BalanceItemModule.kt */
public final class BalanceItemModuleKt {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static boolean f36247a;

    public static final boolean canShowTopUpBtn(PaySelItemData paySelItemData) {
        Intrinsics.checkNotNullParameter(paySelItemData, "data");
        if (paySelItemData.channelId == 120 && PaySelUtils.INSTANCE.isZeroBalance(paySelItemData.balance)) {
            return true;
        }
        if ((paySelItemData.channelId != 190 || !PaySelUtils.INSTANCE.isZeroBalance(paySelItemData.balance) || !paySelItemData.isHit99payCombination) && !m25638a(paySelItemData)) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    private static final boolean m25638a(PaySelItemData paySelItemData) {
        if (paySelItemData.channelId != 190 || paySelItemData.isHit99payCombination || paySelItemData.isSufficient || paySelItemData.status != 1) {
            return false;
        }
        return true;
    }
}
