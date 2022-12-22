package com.didi.global.fintech.cashier.core;

import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/core/PayChannel;", "", "()V", "CHANNEL_TYPE_99_BALANCE", "", "CHANNEL_TYPE_99_PAYPAL", "CHANNEL_TYPE_GLOBAL_BALANCE", "CHANNEL_TYPE_GLOBAL_PAYPAL", "CHANNEL_TYPE_PIX", "CHANNEL_TYPE_VISA", "cashier_core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCashierContants.kt */
public final class PayChannel {
    public static final int CHANNEL_TYPE_99_BALANCE = 190;
    public static final int CHANNEL_TYPE_99_PAYPAL = 152;
    public static final int CHANNEL_TYPE_GLOBAL_BALANCE = 120;
    public static final int CHANNEL_TYPE_GLOBAL_PAYPAL = 183;
    public static final int CHANNEL_TYPE_PIX = 212;
    public static final int CHANNEL_TYPE_VISA = 150;
    public static final PayChannel INSTANCE = new PayChannel();

    private PayChannel() {
    }
}
