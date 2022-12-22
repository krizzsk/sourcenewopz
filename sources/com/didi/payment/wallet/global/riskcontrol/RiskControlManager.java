package com.didi.payment.wallet.global.riskcontrol;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JJ\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\u000fJB\u0010\u0010\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/riskcontrol/RiskControlManager;", "", "()V", "type", "", "startRiskControl", "", "context", "Landroid/content/Context;", "verifyType", "faceSessionId", "faceBizCode", "scene", "sessionId", "callback", "Lcom/didi/payment/wallet/global/riskcontrol/IRiskControlCallback;", "verify", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: RiskControlManager.kt */
public final class RiskControlManager {
    public static final RiskControlManager INSTANCE = new RiskControlManager();

    /* renamed from: a */
    private static String f31785a;

    private RiskControlManager() {
    }

    public final void startRiskControl(Context context, String str, String str2, String str3, String str4, String str5, IRiskControlCallback iRiskControlCallback) {
        Intrinsics.checkNotNullParameter(iRiskControlCallback, "callback");
        f31785a = str;
        m22541a(context, str2, str3, str4, str5, iRiskControlCallback);
    }

    /* renamed from: a */
    private final void m22541a(Context context, String str, String str2, String str3, String str4, IRiskControlCallback iRiskControlCallback) {
        String str5 = f31785a;
        if (Intrinsics.areEqual((Object) str5, (Object) "1")) {
            new FaceVerify(context, str, str2, str3, str4).startFaceVerify(new RiskControlManager$verify$1(iRiskControlCallback));
        } else {
            Intrinsics.areEqual((Object) str5, (Object) "2");
        }
    }
}
