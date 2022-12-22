package com.pay99.diff_passenger;

import com.didi.dcrypto.util.network.CommonProxyHolder;
import com.pay99.diff_base.base.IDcrypto;
import com.pay99.diff_base.base.IDcryptoInitCallback;
import com.pay99.diff_base.base.IDiff;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, mo175978d2 = {"Lcom/pay99/diff_passenger/PassengerDcrypto;", "Lcom/pay99/diff_base/base/IDcrypto;", "Lcom/pay99/diff_base/base/IDiff;", "()V", "init", "", "callback", "Lcom/pay99/diff_base/base/IDcryptoInitCallback;", "diff-base_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PassengerDcrypto.kt */
public final class PassengerDcrypto implements IDcrypto, IDiff {
    public void init(IDcryptoInitCallback iDcryptoInitCallback) {
        Intrinsics.checkNotNullParameter(iDcryptoInitCallback, "callback");
        CommonProxyHolder.setProxy(new PassengerDcrypto$init$1(iDcryptoInitCallback));
    }
}
