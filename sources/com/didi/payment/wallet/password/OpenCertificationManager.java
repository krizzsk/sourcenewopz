package com.didi.payment.wallet.password;

import android.app.Activity;
import android.content.Context;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.api.Extend;
import com.didi.drouter.router.Request;
import com.didi.payment.base.exts.ApplicationContextProvider;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.base.utils.WalletCommonParamsUtil;
import com.didi.payment.kycservice.utils.ApolloSignUpUtil;
import com.didi.payment.kycservice.utils.KycRegisterUtils;
import com.didichuxing.diface.DiFace;
import com.didichuxing.diface.DiFaceParam;
import com.didichuxing.diface.DiFaceResult;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.didiglobal.pay.paysecure.CertificationResultListener;
import com.didiglobal.pay.paysecure.OpenCertificationListener;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@ServiceProvider(priority = 1, value = {OpenCertificationListener.class})
@Metadata(mo175977d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J \u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u000eH\u0002J \u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J8\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001a"}, mo175978d2 = {"Lcom/didi/payment/wallet/password/OpenCertificationManager;", "Lcom/didiglobal/pay/paysecure/OpenCertificationListener;", "()V", "request", "Lcom/didi/payment/wallet/password/CertificationRequest;", "getRequest", "()Lcom/didi/payment/wallet/password/CertificationRequest;", "request$delegate", "Lkotlin/Lazy;", "checkAccount", "", "params", "", "resultListener", "Lcom/didiglobal/pay/paysecure/CertificationResultListener;", "faceVerify", "source", "", "fullKyc", "context", "Landroid/content/Context;", "openCert", "activity", "Landroid/app/Activity;", "checkType", "scene", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OpenCertificationManager.kt */
public final class OpenCertificationManager implements OpenCertificationListener {

    /* renamed from: a */
    private final Lazy f32855a = LazyKt.lazy(OpenCertificationManager$request$2.INSTANCE);

    /* renamed from: a */
    private final CertificationRequest m23176a() {
        return (CertificationRequest) this.f32855a.getValue();
    }

    public void openCert(Activity activity, String str, String str2, int i, String str3, CertificationResultListener certificationResultListener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(str, "checkType");
        Intrinsics.checkNotNullParameter(str2, "params");
        Intrinsics.checkNotNullParameter(str3, "scene");
        Intrinsics.checkNotNullParameter(certificationResultListener, "resultListener");
        if (Intrinsics.areEqual((Object) str, (Object) CertificationType.FULL_KYC_VERIFY.name())) {
            m23177a((Context) activity, str2, certificationResultListener);
        } else if (Intrinsics.areEqual((Object) str, (Object) CertificationType.FACE_REC_VERIFY.name())) {
            Map hashMap = new HashMap();
            hashMap.put("source_id", Integer.valueOf(i));
            FinOmegaSDK.trackEvent("ibt_password_frame_face_bt", hashMap);
            m23179a(str2, i, certificationResultListener);
        } else {
            certificationResultListener.onFailure("fail", "Unimplemented verify type!");
        }
    }

    /* renamed from: a */
    private final void m23177a(Context context, String str, CertificationResultListener certificationResultListener) {
        if (ApolloSignUpUtil.Companion.getApolloExp()) {
            KycRegisterUtils.INSTANCE.go2SignUpActivity(context, "5", false, new OpenCertificationManager$fullKyc$1(this, str, certificationResultListener));
        } else {
            ((Request) DRouter.build("99pay://one/pix_register?source=5").putExtra(Extend.START_ACTIVITY_REQUEST_CODE, 100)).start(context, new OpenCertificationManager$fullKyc$2(this, str, certificationResultListener));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m23180a(String str, CertificationResultListener certificationResultListener) {
        m23176a().checkAccountStatus(new OpenCertificationManager$checkAccount$1(certificationResultListener, str));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m23179a(String str, int i, CertificationResultListener certificationResultListener) {
        JSONObject jSONObject = new JSONObject(str);
        int i2 = jSONObject.getInt("biz_code");
        String string = jSONObject.getString("face_recog_session_id");
        if (string != null) {
            DiFaceParam diFaceParam = new DiFaceParam();
            diFaceParam.setBizCode(i2);
            diFaceParam.setToken(WalletCommonParamsUtil.getToken(ApplicationContextProvider.Companion.getContext()));
            diFaceParam.setSessionId(string);
            DiFace.startFaceRecognition(diFaceParam, new DiFace.IDiFaceCallback(str, i, this) {
                public final /* synthetic */ String f$1;
                public final /* synthetic */ int f$2;
                public final /* synthetic */ OpenCertificationManager f$3;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                }

                public final void onResult(DiFaceResult diFaceResult) {
                    OpenCertificationManager.m23178a(CertificationResultListener.this, this.f$1, this.f$2, this.f$3, diFaceResult);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m23178a(CertificationResultListener certificationResultListener, String str, int i, OpenCertificationManager openCertificationManager, DiFaceResult diFaceResult) {
        Intrinsics.checkNotNullParameter(certificationResultListener, "$resultListener");
        Intrinsics.checkNotNullParameter(str, "$params");
        Intrinsics.checkNotNullParameter(openCertificationManager, "this$0");
        int code = diFaceResult.getCode();
        if (code == 0 || code == 1 || code == 2 || code == 3) {
            certificationResultListener.onSuccess(str);
        } else if (code != 102) {
            HashMap hashMap = new HashMap();
            Map map = hashMap;
            map.put("source_id", Integer.valueOf(i));
            FinOmegaSDK.trackEvent("ibt_password_frame_face_failed_sw", map);
            TransparentActivity.Companion.setOnTryAgain(new OpenCertificationManager$faceVerify$1$1(hashMap, openCertificationManager, str, i, certificationResultListener));
            TransparentActivity.Companion.setOnCancel(new OpenCertificationManager$faceVerify$1$2(hashMap, certificationResultListener, str));
            TransparentActivity.Companion.setOnClose(new OpenCertificationManager$faceVerify$1$3(certificationResultListener, str));
            TransparentActivity.Companion.start(ApplicationContextProvider.Companion.getContext(), "FAIL");
        } else {
            certificationResultListener.onFailure("fail", str);
        }
    }
}
