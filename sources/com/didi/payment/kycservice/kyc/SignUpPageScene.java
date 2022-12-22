package com.didi.payment.kycservice.kyc;

import com.didi.component.comp_xpanel.XPanelScene;
import com.didi.payment.base.anti.AccessBlockManager;
import com.dmap.navigation.base.ctx.INaviOptionExt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0001\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0012"}, mo175978d2 = {"Lcom/didi/payment/kycservice/kyc/SignUpPageScene;", "", "sceneTag", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getSceneTag", "()Ljava/lang/String;", "NULL", "GUIDE", "SIGN_UP_99PAY", "CHOOSE_ID_TYPE", "CHOOSE_ID_TYPE_JUMIO", "CHOOSE_KEY_TYPE", "RESULT", "ADDRESS", "FULL_KYC_EXTRA", "FULL_KYC_FINISH", "Companion", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SignUpVM.kt */
public enum SignUpPageScene {
    NULL("null"),
    GUIDE(INaviOptionExt.KEY_GUIDE),
    SIGN_UP_99PAY("kyc"),
    CHOOSE_ID_TYPE(AccessBlockManager.PARAM_ACCESS_BLOCK_PAGE_CHOOSE_ID),
    CHOOSE_ID_TYPE_JUMIO("chooseIdTypeJumio"),
    CHOOSE_KEY_TYPE("chooseKeyType"),
    RESULT("result"),
    ADDRESS("address"),
    FULL_KYC_EXTRA("full_kyc_extra"),
    FULL_KYC_FINISH(XPanelScene.SCENE_FINISH);
    
    public static final Companion Companion = null;
    private final String sceneTag;

    private SignUpPageScene(String str) {
        this.sceneTag = str;
    }

    public final String getSceneTag() {
        return this.sceneTag;
    }

    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    @Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/payment/kycservice/kyc/SignUpPageScene$Companion;", "", "()V", "getScene", "Lcom/didi/payment/kycservice/kyc/SignUpPageScene;", "scene", "", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: SignUpVM.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SignUpPageScene getScene(String str) {
            Intrinsics.checkNotNullParameter(str, "scene");
            if (Intrinsics.areEqual((Object) str, (Object) SignUpPageScene.GUIDE.getSceneTag())) {
                return SignUpPageScene.GUIDE;
            }
            if (Intrinsics.areEqual((Object) str, (Object) SignUpPageScene.SIGN_UP_99PAY.getSceneTag())) {
                return SignUpPageScene.SIGN_UP_99PAY;
            }
            if (Intrinsics.areEqual((Object) str, (Object) SignUpPageScene.CHOOSE_ID_TYPE.getSceneTag())) {
                return SignUpPageScene.CHOOSE_ID_TYPE;
            }
            if (Intrinsics.areEqual((Object) str, (Object) SignUpPageScene.CHOOSE_ID_TYPE_JUMIO.getSceneTag())) {
                return SignUpPageScene.CHOOSE_ID_TYPE_JUMIO;
            }
            if (Intrinsics.areEqual((Object) str, (Object) SignUpPageScene.CHOOSE_KEY_TYPE.getSceneTag())) {
                return SignUpPageScene.CHOOSE_KEY_TYPE;
            }
            if (Intrinsics.areEqual((Object) str, (Object) SignUpPageScene.ADDRESS.getSceneTag())) {
                return SignUpPageScene.ADDRESS;
            }
            if (Intrinsics.areEqual((Object) str, (Object) SignUpPageScene.FULL_KYC_EXTRA.getSceneTag())) {
                return SignUpPageScene.FULL_KYC_EXTRA;
            }
            if (Intrinsics.areEqual((Object) str, (Object) SignUpPageScene.FULL_KYC_FINISH.getSceneTag())) {
                return SignUpPageScene.FULL_KYC_FINISH;
            }
            return SignUpPageScene.RESULT;
        }
    }
}
