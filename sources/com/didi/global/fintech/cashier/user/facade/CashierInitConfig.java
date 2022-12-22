package com.didi.global.fintech.cashier.user.facade;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0016\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0006H&J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\u0003H\u0016J\b\u0010\f\u001a\u00020\u0003H\u0016J\b\u0010\r\u001a\u00020\u0003H\u0016J\b\u0010\u000e\u001a\u00020\u0003H\u0016J\b\u0010\u000f\u001a\u00020\u0003H\u0016J\b\u0010\u0010\u001a\u00020\u0003H\u0016¨\u0006\u0011"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/user/facade/CashierInitConfig;", "", "getCityId", "", "getDeviceId", "getExtraInfo", "", "getLanguage", "getLat", "", "getLng", "getLocale", "getSUUID", "getTerminalID", "getToken", "getUUID", "getUid", "cashier_user_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CashierInitConfig.kt */
public interface CashierInitConfig {

    @Metadata(mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CashierInitConfig.kt */
    public static final class DefaultImpls {
        public static String getCityId(CashierInitConfig cashierInitConfig) {
            Intrinsics.checkNotNullParameter(cashierInitConfig, "this");
            return "";
        }

        public static String getDeviceId(CashierInitConfig cashierInitConfig) {
            Intrinsics.checkNotNullParameter(cashierInitConfig, "this");
            return "";
        }

        public static String getLanguage(CashierInitConfig cashierInitConfig) {
            Intrinsics.checkNotNullParameter(cashierInitConfig, "this");
            return "";
        }

        public static double getLat(CashierInitConfig cashierInitConfig) {
            Intrinsics.checkNotNullParameter(cashierInitConfig, "this");
            return 0.0d;
        }

        public static double getLng(CashierInitConfig cashierInitConfig) {
            Intrinsics.checkNotNullParameter(cashierInitConfig, "this");
            return 0.0d;
        }

        public static String getLocale(CashierInitConfig cashierInitConfig) {
            Intrinsics.checkNotNullParameter(cashierInitConfig, "this");
            return "";
        }

        public static String getSUUID(CashierInitConfig cashierInitConfig) {
            Intrinsics.checkNotNullParameter(cashierInitConfig, "this");
            return "";
        }

        public static String getTerminalID(CashierInitConfig cashierInitConfig) {
            Intrinsics.checkNotNullParameter(cashierInitConfig, "this");
            return "";
        }

        public static String getToken(CashierInitConfig cashierInitConfig) {
            Intrinsics.checkNotNullParameter(cashierInitConfig, "this");
            return "";
        }

        public static String getUUID(CashierInitConfig cashierInitConfig) {
            Intrinsics.checkNotNullParameter(cashierInitConfig, "this");
            return "";
        }

        public static String getUid(CashierInitConfig cashierInitConfig) {
            Intrinsics.checkNotNullParameter(cashierInitConfig, "this");
            return "";
        }
    }

    String getCityId();

    String getDeviceId();

    Map<String, Object> getExtraInfo();

    String getLanguage();

    double getLat();

    double getLng();

    String getLocale();

    String getSUUID();

    String getTerminalID();

    String getToken();

    String getUUID();

    String getUid();
}
