package com.didi.payment.wallet.global.wallet.view.view.home.p142v2.tool;

import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt;

@Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/tool/WalletUriParam;", "", "()V", "Companion", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.tool.WalletUriParam */
/* compiled from: WalletUriParam.kt */
public final class WalletUriParam {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @JvmStatic
    public static final String findUrlStrParam(Uri uri, String str) {
        return Companion.findUrlStrParam(uri, str);
    }

    @Metadata(mo175977d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\u0004J\u001a\u0010\n\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u001a\u0010\f\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u001c\u0010\u000e\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007¨\u0006\u000f"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/tool/WalletUriParam$Companion;", "", "()V", "findUrlBoolParam", "", "uri", "Landroid/net/Uri;", "key", "", "defaultValue", "findUrlDoubleParam", "", "findUrlIntParam", "", "findUrlStrParam", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.tool.WalletUriParam$Companion */
    /* compiled from: WalletUriParam.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final int findUrlIntParam(Uri uri, String str) {
            String queryParameter;
            if (uri == null || str == null || (queryParameter = uri.getQueryParameter(str)) == null) {
                return 0;
            }
            try {
                Integer intOrNull = StringsKt.toIntOrNull(queryParameter);
                if (intOrNull == null) {
                    return 0;
                }
                return intOrNull.intValue();
            } catch (IllegalArgumentException unused) {
                return 0;
            }
        }

        public final double findUrlDoubleParam(Uri uri, String str) {
            String queryParameter;
            if (uri == null || str == null || (queryParameter = uri.getQueryParameter(str)) == null) {
                return 0.0d;
            }
            try {
                Double doubleOrNull = StringsKt.toDoubleOrNull(queryParameter);
                if (doubleOrNull == null) {
                    return 0.0d;
                }
                return doubleOrNull.doubleValue();
            } catch (IllegalArgumentException unused) {
                return 0.0d;
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:3:0x0007, code lost:
            r2 = r2.getQueryParameter(r3);
         */
        @kotlin.jvm.JvmStatic
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.String findUrlStrParam(android.net.Uri r2, java.lang.String r3) {
            /*
                r1 = this;
                java.lang.String r0 = ""
                if (r2 == 0) goto L_0x000f
                if (r3 != 0) goto L_0x0007
                goto L_0x000f
            L_0x0007:
                java.lang.String r2 = r2.getQueryParameter(r3)
                if (r2 != 0) goto L_0x000e
                goto L_0x000f
            L_0x000e:
                r0 = r2
            L_0x000f:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.wallet.global.wallet.view.view.home.p142v2.tool.WalletUriParam.Companion.findUrlStrParam(android.net.Uri, java.lang.String):java.lang.String");
        }

        public static /* synthetic */ boolean findUrlBoolParam$default(Companion companion, Uri uri, String str, boolean z, int i, Object obj) {
            if ((i & 4) != 0) {
                z = false;
            }
            return companion.findUrlBoolParam(uri, str, z);
        }

        public final boolean findUrlBoolParam(Uri uri, String str, boolean z) {
            if (uri == null || str == null) {
                return false;
            }
            return uri.getBooleanQueryParameter(str, z);
        }
    }
}
