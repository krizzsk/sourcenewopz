package com.didi.payment.wallet.global.prepaidcard;

import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/prepaidcard/PrepaidSource;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "HOME_TOP", "HOME_DIALOG", "TOP_UP_DIALOG", "HOME_SKU", "HOME_BANNER", "REAPPLY", "SETTING", "SETTING_CANCEL", "SETTING_RESET", "SETTING_REQUEST", "FORGET_PASSWORD", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PrepaidConstant.kt */
public enum PrepaidSource {
    HOME_TOP("0"),
    HOME_DIALOG("1"),
    TOP_UP_DIALOG("2"),
    HOME_SKU("3"),
    HOME_BANNER("4"),
    REAPPLY("5"),
    SETTING("6"),
    SETTING_CANCEL("7"),
    SETTING_RESET("8"),
    SETTING_REQUEST("9"),
    FORGET_PASSWORD("10");
    
    private final String value;

    private PrepaidSource(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }
}
