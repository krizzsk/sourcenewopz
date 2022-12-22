package com.didi.payment.wallet.global.utils;

import android.content.Context;
import android.text.TextUtils;
import com.didi.payment.wallet.global.model.WalletAccountData;
import com.didi.unifylogin.api.OneLoginFacade;
import com.didiglobal.security.OneSecuritySharedPrefs;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u000b\u001a\u00020\f8FX\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u0002\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\n \u0011*\u0004\u0018\u00010\u00040\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R.\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u00158F@FX\u000e¢\u0006\u0012\u0012\u0004\b\u0017\u0010\u0002\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/utils/WalletSecuritySPUtils;", "", "()V", "WALLET_SECURITY_SP_FILE_NAME", "", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context$delegate", "Lkotlin/Lazy;", "kycTag", "", "getKycTag$annotations", "getKycTag", "()I", "uid", "kotlin.jvm.PlatformType", "getUid", "()Ljava/lang/String;", "value", "Lcom/didi/payment/wallet/global/model/WalletAccountData;", "walletAccountData", "getWalletAccountData$annotations", "getWalletAccountData", "()Lcom/didi/payment/wallet/global/model/WalletAccountData;", "setWalletAccountData", "(Lcom/didi/payment/wallet/global/model/WalletAccountData;)V", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: WalletSecuritySPUtils.kt */
public final class WalletSecuritySPUtils {
    public static final WalletSecuritySPUtils INSTANCE = new WalletSecuritySPUtils();

    /* renamed from: a */
    private static final String f32009a = "global_wallet_security_sp";

    /* renamed from: b */
    private static final Lazy f32010b = LazyKt.lazy(WalletSecuritySPUtils$context$2.INSTANCE);

    @JvmStatic
    public static /* synthetic */ void getKycTag$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getWalletAccountData$annotations() {
    }

    private WalletSecuritySPUtils() {
    }

    /* renamed from: a */
    private final Context m22664a() {
        return (Context) f32010b.getValue();
    }

    /* renamed from: b */
    private final String m22665b() {
        return OneLoginFacade.getStore().getUid();
    }

    public static final void setWalletAccountData(WalletAccountData walletAccountData) {
        String stringPlus = Intrinsics.stringPlus("wallet_account_data@", INSTANCE.m22665b());
        if (walletAccountData == null) {
            OneSecuritySharedPrefs.remove(INSTANCE.m22664a(), stringPlus, f32009a);
        } else {
            OneSecuritySharedPrefs.putObject(INSTANCE.m22664a(), stringPlus, walletAccountData, f32009a);
        }
    }

    public static final WalletAccountData getWalletAccountData() {
        return (WalletAccountData) OneSecuritySharedPrefs.getObject(INSTANCE.m22664a(), Intrinsics.stringPlus("wallet_account_data@", INSTANCE.m22665b()), WalletAccountData.class, f32009a);
    }

    public static final int getKycTag() {
        WalletAccountData walletAccountData = getWalletAccountData();
        if (walletAccountData == null) {
            return 0;
        }
        if (walletAccountData.getStatus() == 1 && TextUtils.equals(walletAccountData.getAuthenticationStatus(), "1")) {
            return 2;
        }
        if (walletAccountData.getStatus() == 1) {
            return 1;
        }
        return 0;
    }
}
