package com.didi.payment.pix.transfer.fragment;

import com.didi.payment.wallet.global.omega.GlobalOmegaUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo175978d2 = {"<anonymous>", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PixTransferAmountEditFragment.kt */
final class PixTransferAmountEditFragment$checkValue$2 extends Lambda implements Function0<Unit> {
    public static final PixTransferAmountEditFragment$checkValue$2 INSTANCE = new PixTransferAmountEditFragment$checkValue$2();

    PixTransferAmountEditFragment$checkValue$2() {
        super(0);
    }

    public final void invoke() {
        GlobalOmegaUtils.trackSkuLimitInputExceedSw(99996);
    }
}
