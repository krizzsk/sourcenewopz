package com.didi.payment.wallet.global.wallet.view.view.home.p142v2.tool;

import com.didi.drouter.api.DRouter;
import com.didi.payment.wallet.global.utils.WalletSPUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/tool/WalletHomeAmountStatus;", "", "()V", "Companion", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.tool.WalletHomeAmountStatus */
/* compiled from: WalletHomeAmountStatus.kt */
public final class WalletHomeAmountStatus {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @JvmStatic
    public static final String getEncryptionStr(int i) {
        return Companion.getEncryptionStr(i);
    }

    @JvmStatic
    public static final boolean isShowAmount() {
        return Companion.isShowAmount();
    }

    @JvmStatic
    public static final void saveAmountStatus(boolean z) {
        Companion.saveAmountStatus(z);
    }

    @Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\b\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0007¨\u0006\f"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/tool/WalletHomeAmountStatus$Companion;", "", "()V", "getEncryptionStr", "", "len", "", "isShowAmount", "", "saveAmountStatus", "", "status", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.tool.WalletHomeAmountStatus$Companion */
    /* compiled from: WalletHomeAmountStatus.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final boolean isShowAmount() {
            return WalletSPUtils.getHomeAmountStatus(DRouter.getContext(), "amount_status");
        }

        @JvmStatic
        public final void saveAmountStatus(boolean z) {
            WalletSPUtils.saveHomeAmountStatus(DRouter.getContext(), "amount_status", z);
        }

        @JvmStatic
        public final String getEncryptionStr(int i) {
            String str = "";
            if (i > 0) {
                int i2 = 0;
                do {
                    i2++;
                    str = Intrinsics.stringPlus(str, "* ");
                } while (i2 < i);
            }
            if (str.length() <= 1) {
                return "";
            }
            int length = str.length() - 1;
            if (str != null) {
                String substring = str.substring(0, length);
                Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                return substring;
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
    }
}
