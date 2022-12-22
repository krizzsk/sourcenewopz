package com.didiglobal.pay.paysecure;

import com.didi.dcrypto.util.DCryptoUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rui.config.RConfigConstants;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\nHÆ\u0003J=\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006!"}, mo175978d2 = {"Lcom/didiglobal/pay/paysecure/PaySecureConfig;", "", "terminalId", "", "appId", "theme", "Lcom/didiglobal/pay/paysecure/PaySecureTheme;", "netParamListener", "Lcom/didiglobal/pay/paysecure/PaySecureNetParamListener;", "webUrlListener", "Lcom/didiglobal/pay/paysecure/WebUrlListener;", "(Ljava/lang/String;Ljava/lang/String;Lcom/didiglobal/pay/paysecure/PaySecureTheme;Lcom/didiglobal/pay/paysecure/PaySecureNetParamListener;Lcom/didiglobal/pay/paysecure/WebUrlListener;)V", "getAppId", "()Ljava/lang/String;", "getNetParamListener", "()Lcom/didiglobal/pay/paysecure/PaySecureNetParamListener;", "getTerminalId", "getTheme", "()Lcom/didiglobal/pay/paysecure/PaySecureTheme;", "getWebUrlListener", "()Lcom/didiglobal/pay/paysecure/WebUrlListener;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "paysecure_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: PaySecure.kt */
public final class PaySecureConfig {

    /* renamed from: a */
    private final String f50307a;

    /* renamed from: b */
    private final String f50308b;

    /* renamed from: c */
    private final PaySecureTheme f50309c;

    /* renamed from: d */
    private final PaySecureNetParamListener f50310d;

    /* renamed from: e */
    private final WebUrlListener f50311e;

    public static /* synthetic */ PaySecureConfig copy$default(PaySecureConfig paySecureConfig, String str, String str2, PaySecureTheme paySecureTheme, PaySecureNetParamListener paySecureNetParamListener, WebUrlListener webUrlListener, int i, Object obj) {
        if ((i & 1) != 0) {
            str = paySecureConfig.f50307a;
        }
        if ((i & 2) != 0) {
            str2 = paySecureConfig.f50308b;
        }
        String str3 = str2;
        if ((i & 4) != 0) {
            paySecureTheme = paySecureConfig.f50309c;
        }
        PaySecureTheme paySecureTheme2 = paySecureTheme;
        if ((i & 8) != 0) {
            paySecureNetParamListener = paySecureConfig.f50310d;
        }
        PaySecureNetParamListener paySecureNetParamListener2 = paySecureNetParamListener;
        if ((i & 16) != 0) {
            webUrlListener = paySecureConfig.f50311e;
        }
        return paySecureConfig.copy(str, str3, paySecureTheme2, paySecureNetParamListener2, webUrlListener);
    }

    public final String component1() {
        return this.f50307a;
    }

    public final String component2() {
        return this.f50308b;
    }

    public final PaySecureTheme component3() {
        return this.f50309c;
    }

    public final PaySecureNetParamListener component4() {
        return this.f50310d;
    }

    public final WebUrlListener component5() {
        return this.f50311e;
    }

    public final PaySecureConfig copy(String str, String str2, PaySecureTheme paySecureTheme, PaySecureNetParamListener paySecureNetParamListener, WebUrlListener webUrlListener) {
        Intrinsics.checkParameterIsNotNull(str, DCryptoUtils.PARAMS_KEY_TERMINAL_ID);
        Intrinsics.checkParameterIsNotNull(str2, "appId");
        Intrinsics.checkParameterIsNotNull(paySecureTheme, RConfigConstants.SEGMENT_THEME);
        Intrinsics.checkParameterIsNotNull(paySecureNetParamListener, "netParamListener");
        return new PaySecureConfig(str, str2, paySecureTheme, paySecureNetParamListener, webUrlListener);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaySecureConfig)) {
            return false;
        }
        PaySecureConfig paySecureConfig = (PaySecureConfig) obj;
        return Intrinsics.areEqual((Object) this.f50307a, (Object) paySecureConfig.f50307a) && Intrinsics.areEqual((Object) this.f50308b, (Object) paySecureConfig.f50308b) && Intrinsics.areEqual((Object) this.f50309c, (Object) paySecureConfig.f50309c) && Intrinsics.areEqual((Object) this.f50310d, (Object) paySecureConfig.f50310d) && Intrinsics.areEqual((Object) this.f50311e, (Object) paySecureConfig.f50311e);
    }

    public int hashCode() {
        String str = this.f50307a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f50308b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        PaySecureTheme paySecureTheme = this.f50309c;
        int hashCode3 = (hashCode2 + (paySecureTheme != null ? paySecureTheme.hashCode() : 0)) * 31;
        PaySecureNetParamListener paySecureNetParamListener = this.f50310d;
        int hashCode4 = (hashCode3 + (paySecureNetParamListener != null ? paySecureNetParamListener.hashCode() : 0)) * 31;
        WebUrlListener webUrlListener = this.f50311e;
        if (webUrlListener != null) {
            i = webUrlListener.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        return "PaySecureConfig(terminalId=" + this.f50307a + ", appId=" + this.f50308b + ", theme=" + this.f50309c + ", netParamListener=" + this.f50310d + ", webUrlListener=" + this.f50311e + ")";
    }

    public PaySecureConfig(String str, String str2, PaySecureTheme paySecureTheme, PaySecureNetParamListener paySecureNetParamListener, WebUrlListener webUrlListener) {
        Intrinsics.checkParameterIsNotNull(str, DCryptoUtils.PARAMS_KEY_TERMINAL_ID);
        Intrinsics.checkParameterIsNotNull(str2, "appId");
        Intrinsics.checkParameterIsNotNull(paySecureTheme, RConfigConstants.SEGMENT_THEME);
        Intrinsics.checkParameterIsNotNull(paySecureNetParamListener, "netParamListener");
        this.f50307a = str;
        this.f50308b = str2;
        this.f50309c = paySecureTheme;
        this.f50310d = paySecureNetParamListener;
        this.f50311e = webUrlListener;
    }

    public final String getTerminalId() {
        return this.f50307a;
    }

    public final String getAppId() {
        return this.f50308b;
    }

    public final PaySecureTheme getTheme() {
        return this.f50309c;
    }

    public final PaySecureNetParamListener getNetParamListener() {
        return this.f50310d;
    }

    public final WebUrlListener getWebUrlListener() {
        return this.f50311e;
    }
}
