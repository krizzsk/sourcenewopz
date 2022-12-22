package com.didi.payment.wallet.global.wallet.view.view.home.p142v2;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0017\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\tJ\u0006\u0010\n\u001a\u00020\u000bR\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/WalletHomeDialogManager;", "", "()V", "dialogMap", "", "", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/IDialogManager;", "findDialogManager", "type", "(Ljava/lang/Integer;)Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/IDialogManager;", "init", "", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.WalletHomeDialogManager */
/* compiled from: WalletHomeDialogManager.kt */
public final class WalletHomeDialogManager {
    public static final WalletHomeDialogManager INSTANCE = new WalletHomeDialogManager();

    /* renamed from: a */
    private static final Map<Integer, IDialogManager> f32639a = new LinkedHashMap();

    private WalletHomeDialogManager() {
    }

    public final void init() {
        f32639a.put(1, new DefaultDialog());
        f32639a.put(2, new PasswordDialog());
        f32639a.put(3, new V2HomeDialog());
        f32639a.put(4, new DefaultDialog());
    }

    public final IDialogManager findDialogManager(Integer num) {
        return f32639a.get(num) == null ? new DefaultDialog() : f32639a.get(num);
    }
}
