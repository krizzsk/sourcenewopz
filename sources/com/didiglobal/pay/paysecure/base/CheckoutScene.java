package com.didiglobal.pay.paysecure.base;

import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, mo175978d2 = {"Lcom/didiglobal/pay/paysecure/base/CheckoutScene;", "", "name", "", "(Ljava/lang/String;ILjava/lang/String;)V", "CHECK_OUT_WALLET", "CHECK_OUT_FOOD", "CHECK_OUT_TRIP", "CHECK_OUT_MERCHANT", "DRIVER_BANK_TRANSFER", "PREPAY_CARD_ACTIVATION", "DRIVER_BANK_BLOTETO", "FASTPAY_VERIFY_PASSWD", "paysecure_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: PaySecureState.kt */
public enum CheckoutScene {
    CHECK_OUT_WALLET("CHECK_OUT_WALLET"),
    CHECK_OUT_FOOD("CHECK_OUT_FOOD"),
    CHECK_OUT_TRIP("CHECK_OUT_TRIP"),
    CHECK_OUT_MERCHANT("CHECK_OUT_MERCHANT"),
    DRIVER_BANK_TRANSFER("DRIVER_BANK_TRANSFER"),
    PREPAY_CARD_ACTIVATION("PREPAY_CARD_ACTIVATION"),
    DRIVER_BANK_BLOTETO("DRIVER_BANK_BLOTETO"),
    FASTPAY_VERIFY_PASSWD("FASTPAY_VERIFY_PASSWD");

    private CheckoutScene(String str) {
    }
}
