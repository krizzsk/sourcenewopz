package com.didi.payment.wallet_ui.keyboard;

import com.global.didi.elvish.Elvish;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u0001H\n"}, mo175978d2 = {"<anonymous>", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: WalletNumKeyboard.kt */
final class WalletNumKeyboard$decimalText$2 extends Lambda implements Function0<String> {
    public static final WalletNumKeyboard$decimalText$2 INSTANCE = new WalletNumKeyboard$decimalText$2();

    WalletNumKeyboard$decimalText$2() {
        super(0);
    }

    public final String invoke() {
        try {
            return Elvish.Companion.getInstance().getDecimalSymbol();
        } catch (Exception unused) {
            return ".";
        }
    }
}
