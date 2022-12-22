package com.didi.payment.wallet.global.wallet.view.view.home.p142v2.tool;

import android.content.Context;
import android.text.TextUtils;
import com.didi.dcrypto.util.DCryptoUtils;
import com.didi.entrega.customer.app.constant.Const;
import com.didi.payment.base.utils.WalletApolloUtil;
import com.didi.payment.base.utils.WalletCommonParamsUtil;
import com.didi.payment.wallet.global.utils.WalletSPUtils;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp.WalletHomeModelKt;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/tool/WalletHomeController;", "", "()V", "Companion", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.tool.WalletHomeController */
/* compiled from: WalletHomeController.kt */
public final class WalletHomeController {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int WALLET_HOME_V2 = 2;

    /* renamed from: a */
    private static final int f32775a = 1;

    /* renamed from: b */
    private static final int f32776b = 5;

    /* renamed from: c */
    private static final int f32777c = 7;

    /* renamed from: d */
    private static final int f32778d = 300103;

    /* renamed from: e */
    private static final int f32779e = 300106;

    @JvmStatic
    public static final int getWalletHomeVersion(Context context, int i) {
        return Companion.getWalletHomeVersion(context, i);
    }

    @Metadata(mo175977d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JN\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000426\u0010\u000f\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u000b0\u0010J*\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0017J\u000e\u0010\u0019\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rJ8\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\f\u001a\u00020\r2\u000e\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u00172\u000e\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u00172\u0006\u0010\u001c\u001a\u00020\u001bJ\u0018\u0010\u001d\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u0004H\u0007J\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010\f\u001a\u00020\r2\b\u0010!\u001a\u0004\u0018\u00010\u001bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\""}, mo175978d2 = {"Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/tool/WalletHomeController$Companion;", "", "()V", "TERMINAL_ID_BRAZIL", "", "TERMINAL_ID_GLOBAL", "TERMINAL_ID_SODA_BRAZIL", "TERMINAL_ID_SODA_GLOBAL", "WALLET_HOME_V1", "WALLET_HOME_V2", "executeAddCardGif", "", "context", "Landroid/content/Context;", "cardNum", "callback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "count", "drawableId", "executeForTerminalId", "brazil", "Lkotlin/Function0;", "global", "findHomePageTheme", "getGifApollo", "", "default", "getWalletHomeVersion", "type", "isShowCouponRedDot", "", "lastTime", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.tool.WalletHomeController$Companion */
    /* compiled from: WalletHomeController.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final int getWalletHomeVersion(Context context, int i) {
            Intrinsics.checkNotNullParameter(context, "context");
            String terminalId = WalletCommonParamsUtil.getTerminalId(context);
            Intrinsics.checkNotNullExpressionValue(terminalId, DCryptoUtils.PARAMS_KEY_TERMINAL_ID);
            if (WalletHomeModelKt.toDefaultInt$default(terminalId, 0, 1, (Object) null) == 5) {
                if (Intrinsics.areEqual((Object) (String) WalletApolloUtil.getParamByStatus("BR_new_wallet_homepage", "new_homepage", "0"), (Object) "1")) {
                    return 2;
                }
                return 1;
            } else if (WalletHomeModelKt.toDefaultInt$default(terminalId, 0, 1, (Object) null) == 7) {
                if (i != 0 && !Intrinsics.areEqual((Object) (String) WalletApolloUtil.getParamByStatus("MX_new_wallet_homepage", "new_homepage", "0"), (Object) "1")) {
                    return 1;
                }
                return 2;
            } else if (WalletHomeModelKt.toDefaultInt$default(terminalId, 0, 1, (Object) null) == 300106) {
                if (WalletApolloUtil.getStatus("Food_Wallet_Update_BRMX", false)) {
                    return 2;
                }
                return 1;
            } else if (WalletHomeModelKt.toDefaultInt$default(terminalId, 0, 1, (Object) null) != WalletHomeController.f32778d || !WalletApolloUtil.getStatus("Food_Wallet_Update_BRMX", false)) {
                return 1;
            } else {
                return 2;
            }
        }

        public final int findHomePageTheme(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            String terminalId = WalletCommonParamsUtil.getTerminalId(context);
            Intrinsics.checkNotNullExpressionValue(terminalId, DCryptoUtils.PARAMS_KEY_TERMINAL_ID);
            if (WalletHomeModelKt.toDefaultInt$default(terminalId, 0, 1, (Object) null) != 5) {
                if (WalletHomeModelKt.toDefaultInt$default(terminalId, 0, 1, (Object) null) == 7) {
                    return R.style.wallet_home_mexco;
                }
                if (WalletHomeModelKt.toDefaultInt$default(terminalId, 0, 1, (Object) null) != 300106 && WalletHomeModelKt.toDefaultInt$default(terminalId, 0, 1, (Object) null) == WalletHomeController.f32778d) {
                    return R.style.wallet_home_mexco;
                }
            }
            return R.style.wallet_home_brazil;
        }

        public final void executeForTerminalId(Context context, Function0<Unit> function0, Function0<Unit> function02) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(function0, "brazil");
            Intrinsics.checkNotNullParameter(function02, "global");
            String terminalId = WalletCommonParamsUtil.getTerminalId(context);
            Intrinsics.checkNotNullExpressionValue(terminalId, DCryptoUtils.PARAMS_KEY_TERMINAL_ID);
            if (WalletHomeModelKt.toDefaultInt$default(terminalId, 0, 1, (Object) null) == 5) {
                function0.invoke();
            } else if (WalletHomeModelKt.toDefaultInt$default(terminalId, 0, 1, (Object) null) == 300106) {
                function0.invoke();
            } else if (WalletHomeModelKt.toDefaultInt$default(terminalId, 0, 1, (Object) null) == 7) {
                function02.invoke();
            } else if (WalletHomeModelKt.toDefaultInt$default(terminalId, 0, 1, (Object) null) == WalletHomeController.f32778d) {
                function02.invoke();
            }
        }

        public final boolean isShowCouponRedDot(Context context, String str) {
            String str2;
            Intrinsics.checkNotNullParameter(context, "context");
            try {
                str2 = WalletSPUtils.getLastCouponTime(context, "last_coupon_time");
            } catch (ClassCastException unused) {
                str2 = "";
            }
            return TextUtils.isEmpty(str2) || !Intrinsics.areEqual((Object) str2, (Object) str);
        }

        public final String getGifApollo(Context context, Function0<String> function0, Function0<String> function02, String str) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(function0, "brazil");
            Intrinsics.checkNotNullParameter(function02, "global");
            Intrinsics.checkNotNullParameter(str, "default");
            String terminalId = WalletCommonParamsUtil.getTerminalId(context);
            Intrinsics.checkNotNullExpressionValue(terminalId, DCryptoUtils.PARAMS_KEY_TERMINAL_ID);
            int defaultInt$default = WalletHomeModelKt.toDefaultInt$default(terminalId, 0, 1, (Object) null);
            if (defaultInt$default == 5) {
                return function0.invoke();
            }
            if (defaultInt$default != 7) {
                return str;
            }
            return function02.invoke();
        }

        public final void executeAddCardGif(Context context, int i, Function2<? super Integer, ? super Integer, Unit> function2) {
            Context context2 = context;
            int i2 = i;
            Function2<? super Integer, ? super Integer, Unit> function22 = function2;
            Intrinsics.checkNotNullParameter(context2, "context");
            Intrinsics.checkNotNullParameter(function22, "callback");
            String terminalId = WalletCommonParamsUtil.getTerminalId(context);
            Intrinsics.checkNotNullExpressionValue(terminalId, DCryptoUtils.PARAMS_KEY_TERMINAL_ID);
            if (WalletHomeModelKt.toDefaultInt$default(terminalId, 0, 1, (Object) null) == 5) {
                String str = (String) WalletApolloUtil.getParamByStatus("BR_bank_card_enhance", "show_gif", "0");
                String str2 = (String) WalletApolloUtil.getParamByStatus("BR_new_wallet_homepage", "new_homepage", "0");
                if (i2 < 1 && Intrinsics.areEqual((Object) str2, (Object) "1") && Intrinsics.areEqual((Object) str, (Object) "1")) {
                    String str3 = (String) WalletApolloUtil.getParamByStatus("BR_bank_card_enhance", "gif_show_max_count", "0");
                    String dateFromSP = WalletSPUtils.getDateFromSP(context2, "home_v2_gif");
                    int homeAddCardGifCount = WalletSPUtils.getHomeAddCardGifCount(context2, "home_v2_gif_count");
                    if (TextUtils.isEmpty(dateFromSP) || !Intrinsics.areEqual((Object) dateFromSP, (Object) WalletSPUtils.getFormatDate().toString())) {
                        Intrinsics.checkNotNullExpressionValue(str3, "maxCount");
                        if (homeAddCardGifCount <= WalletHomeModelKt.toDefaultInt$default(str3, 0, 1, (Object) null)) {
                            String str4 = (String) WalletApolloUtil.getParamByStatus("BR_bank_card_enhance", "gif_play_count", "0");
                            Intrinsics.checkNotNullExpressionValue(str4, Const.PageParams.COUNT);
                            function22.invoke(Integer.valueOf(WalletHomeModelKt.toDefaultInt$default(str4, 0, 1, (Object) null)), Integer.valueOf(R.drawable.ic_home_add_bank));
                            WalletSPUtils.setDate(context2, "home_v2_gif");
                            WalletSPUtils.setHomeAddCardGifCount(context2, "home_v2_gif_count", homeAddCardGifCount + 1);
                        }
                    }
                }
            } else if (WalletHomeModelKt.toDefaultInt$default(terminalId, 0, 1, (Object) null) == 7) {
                String str5 = (String) WalletApolloUtil.getParamByStatus("MX_bank_card_enhance", "show_gif", "0");
                String str6 = (String) WalletApolloUtil.getParamByStatus("MX_new_wallet_homepage", "new_homepage", "0");
                if (i2 < 1 && Intrinsics.areEqual((Object) str6, (Object) "1") && Intrinsics.areEqual((Object) str5, (Object) "1")) {
                    String str7 = (String) WalletApolloUtil.getParamByStatus("MX_bank_card_enhance", "gif_show_max_count", "0");
                    String dateFromSP2 = WalletSPUtils.getDateFromSP(context2, "home_v2_gif");
                    int homeAddCardGifCount2 = WalletSPUtils.getHomeAddCardGifCount(context2, "home_v2_gif_count");
                    if (TextUtils.isEmpty(dateFromSP2) || !Intrinsics.areEqual((Object) dateFromSP2, (Object) WalletSPUtils.getFormatDate().toString())) {
                        Intrinsics.checkNotNullExpressionValue(str7, "maxCount");
                        if (homeAddCardGifCount2 <= WalletHomeModelKt.toDefaultInt$default(str7, 0, 1, (Object) null)) {
                            String str8 = (String) WalletApolloUtil.getParamByStatus("MX_bank_card_enhance", "gif_play_count", "0");
                            Intrinsics.checkNotNullExpressionValue(str8, Const.PageParams.COUNT);
                            function2.invoke(Integer.valueOf(WalletHomeModelKt.toDefaultInt$default(str8, 0, 1, (Object) null)), Integer.valueOf(R.drawable.ic_home_add_bank_mx));
                            WalletSPUtils.setDate(context2, "home_v2_gif");
                            WalletSPUtils.setHomeAddCardGifCount(context2, "home_v2_gif_count", homeAddCardGifCount2 + 1);
                        }
                    }
                }
            }
        }
    }
}
