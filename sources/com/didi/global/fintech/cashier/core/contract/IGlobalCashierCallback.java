package com.didi.global.fintech.cashier.core.contract;

import android.content.Intent;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u001a\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\bH&¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierCallback;", "", "onCallStartActivity", "", "intent", "Landroid/content/Intent;", "onCallStartActivityForResult", "requestCode", "", "onClose", "payResult", "cashier_core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: IGlobalCashierCallback.kt */
public interface IGlobalCashierCallback {
    void onCallStartActivity(Intent intent);

    void onCallStartActivityForResult(Intent intent, int i);

    void onClose(int i);
}
