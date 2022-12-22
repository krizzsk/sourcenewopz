package com.didi.payment.wallet_ui.keyboard;

import android.graphics.Path;
import com.didi.payment.wallet_ui.UiUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo175978d2 = {"<anonymous>", "Landroid/graphics/Path;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: WalletNumKeyboard.kt */
final class WalletNumKeyboard$okPath$2 extends Lambda implements Function0<Path> {
    final /* synthetic */ WalletNumKeyboard this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WalletNumKeyboard$okPath$2(WalletNumKeyboard walletNumKeyboard) {
        super(0);
        this.this$0 = walletNumKeyboard;
    }

    public final Path invoke() {
        Path path = new Path();
        WalletNumKeyboard walletNumKeyboard = this.this$0;
        path.moveTo(0.0f, 0.0f);
        path.rLineTo((float) UiUtils.Companion.getScreenWidth(), 0.0f);
        int i = 1;
        while (true) {
            int i2 = i + 1;
            path.moveTo(0.0f, ((float) i) * walletNumKeyboard.f32961B);
            float f = (float) 3;
            path.rLineTo(walletNumKeyboard.f32962C * f, 0.0f);
            if (i2 > 3) {
                path.moveTo(walletNumKeyboard.f32962C, 0.0f);
                path.lineTo(walletNumKeyboard.f32962C, walletNumKeyboard.f32961B * f);
                float f2 = (float) 2;
                path.moveTo(walletNumKeyboard.f32962C * f2, 0.0f);
                path.lineTo(f2 * walletNumKeyboard.f32962C, walletNumKeyboard.f33005x);
                path.moveTo(walletNumKeyboard.f32962C * f, 0.0f);
                path.lineTo(f * walletNumKeyboard.f32962C, walletNumKeyboard.f32961B);
                return path;
            }
            i = i2;
        }
    }
}
