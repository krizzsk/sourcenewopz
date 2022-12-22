package com.didi.payment.kycservice.utils;

import com.didi.payment.base.utils.WalletCommonParamsUtil;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/payment/kycservice/utils/ApolloSignUpUtil;", "", "()V", "Companion", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ApolloSignUpUtil.kt */
public final class ApolloSignUpUtil {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private static final String f30917a = "Wallet_KYC_flow_optimization";

    /* renamed from: b */
    private static final String f30918b = "Wallet_KYC_flow_optimization_Latour";

    /* renamed from: c */
    private static final String f30919c = "Wallet_KYC_flow_optimization_DRV";
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static Boolean f30920d;

    @JvmStatic
    public static final boolean getApolloExp() {
        return Companion.getApolloExp();
    }

    @Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/payment/kycservice/utils/ApolloSignUpUtil$Companion;", "", "()V", "WALLET_KYC_AB_DRIVER", "", "WALLET_KYC_AB_LATOUR", "WALLET_KYC_AB_PASSENGER", "isNewVersion", "", "Ljava/lang/Boolean;", "getApolloExp", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ApolloSignUpUtil.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final boolean getApolloExp() {
            String str;
            boolean z;
            boolean z2;
            if (WalletCommonParamsUtil.is99PayClient()) {
                str = ApolloSignUpUtil.f30918b;
            } else {
                str = WalletCommonParamsUtil.isDriverClient() ? ApolloSignUpUtil.f30919c : ApolloSignUpUtil.f30917a;
            }
            if (ApolloSignUpUtil.f30920d == null) {
                Companion companion = this;
                boolean z3 = false;
                IToggle toggle = Apollo.getToggle(str, false);
                if (toggle != null && toggle.allow()) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    Object param = toggle.getExperiment().getParam("newKYC", "0");
                    Intrinsics.checkNotNullExpressionValue(param, "toggle.experiment.getParam(\"newKYC\", \"0\")");
                    if (Integer.parseInt((String) param) == 1) {
                        z3 = true;
                    }
                    z2 = Boolean.valueOf(z3);
                } else {
                    z2 = false;
                }
                ApolloSignUpUtil.f30920d = z2;
            }
            return true;
        }
    }
}
