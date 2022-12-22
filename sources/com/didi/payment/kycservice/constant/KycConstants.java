package com.didi.payment.kycservice.constant;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00032\u00020\u0001:\u0002\u0003\u0004B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/payment/kycservice/constant/KycConstants;", "", "()V", "Companion", "Router", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: KycConstants.kt */
public final class KycConstants {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String FULL_KYC_ADDRESS_PAGE_FROM = "full_kyc_address_inbound_source";
    public static final String PAGE_FROM_KYC = "page_from_kyc";
    public static final String PAGE_SOURCE_TYPE = "source";
    public static final String PARAM_SIGN_INFO = "param_sign_info";

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/payment/kycservice/constant/KycConstants$Router;", "", "()V", "KYC_REGISTER_ROUTER", "", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: KycConstants.kt */
    public static final class Router {
        public static final Router INSTANCE = new Router();
        public static final String KYC_REGISTER_ROUTER = "wallet99://one/kyc_common";

        private Router() {
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, mo175978d2 = {"Lcom/didi/payment/kycservice/constant/KycConstants$Companion;", "", "()V", "FULL_KYC_ADDRESS_PAGE_FROM", "", "PAGE_FROM_KYC", "PAGE_SOURCE_TYPE", "PARAM_SIGN_INFO", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: KycConstants.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
