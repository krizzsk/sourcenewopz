package com.didi.payment.pix.transfer.fragment;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo175977d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J*\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000e"}, mo175978d2 = {"com/didi/payment/pix/transfer/fragment/PixTransferAmountEditFragment$defaultTextWatcher$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PixTransferAmountEditFragment.kt */
public final class PixTransferAmountEditFragment$defaultTextWatcher$1 implements TextWatcher {
    final /* synthetic */ PixTransferAmountEditFragment this$0;

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    PixTransferAmountEditFragment$defaultTextWatcher$1(PixTransferAmountEditFragment pixTransferAmountEditFragment) {
        this.this$0 = pixTransferAmountEditFragment;
    }

    public void afterTextChanged(Editable editable) {
        String valueOf = String.valueOf(editable);
        CharSequence charSequence = valueOf;
        if (!TextUtils.isEmpty(charSequence) && StringsKt.startsWith$default(valueOf, "0", false, 2, (Object) null)) {
            String str = this.this$0.getNFloatParser().decimalSeperatorBySys;
            Intrinsics.checkNotNullExpressionValue(str, "NFloatParser.decimalSeperatorBySys");
            if (StringsKt.indexOf$default(charSequence, str, 0, false, 6, (Object) null) == -1) {
                return;
            }
        }
        PixTransferAmountEditFragment pixTransferAmountEditFragment = this.this$0;
        pixTransferAmountEditFragment.m21994a(valueOf, pixTransferAmountEditFragment.f31243i);
    }
}
