package com.didiglobal.pay.paysecure.p204ui;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import com.didi.sdk.apm.SystemUtils;
import com.didiglobal.pay.paysecure.OpenCertificationListener;
import com.didiglobal.pay.paysecure.PayPwdResultListener;
import com.didiglobal.pay.paysecure.PaySecure;
import com.didiglobal.pay.paysecure.SetPwdResultListener;
import com.didiglobal.pay.paysecure.base.AbsPaySecureBaseActivity;
import com.didiglobal.pay.paysecure.base.FragmentMessenger;
import com.didiglobal.pay.paysecure.base.PaySecureState;
import com.didiglobal.pay.paysecure.omega.OmegaUtil;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0014J\b\u0010\t\u001a\u00020\u0006H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000¨\u0006\n"}, mo175978d2 = {"Lcom/didiglobal/pay/paysecure/ui/PaySecureActivity;", "Lcom/didiglobal/pay/paysecure/base/AbsPaySecureBaseActivity;", "()V", "root", "Landroid/widget/FrameLayout;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "paysecure_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* renamed from: com.didiglobal.pay.paysecure.ui.PaySecureActivity */
/* compiled from: PaySecureActivity.kt */
public final class PaySecureActivity extends AbsPaySecureBaseActivity {

    /* renamed from: a */
    private FrameLayout f50414a;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_pay_secure);
        View findViewById = findViewById(R.id.fl_pay_secure_root);
        Intrinsics.checkExpressionValueIsNotNull(findViewById, "findViewById(R.id.fl_pay_secure_root)");
        this.f50414a = (FrameLayout) findViewById;
        FragmentMessenger fragmentMessenger = new FragmentMessenger();
        String stringExtra = getIntent().getStringExtra("scene");
        if (stringExtra == null) {
            Intrinsics.throwNpe();
        }
        fragmentMessenger.setScene(stringExtra);
        fragmentMessenger.setPaySessionId(getIntent().getStringExtra("paySessionId"));
        fragmentMessenger.setSceneType(getIntent().getIntExtra("scene_type", 0));
        fragmentMessenger.setAmount(getIntent().getStringExtra("amount"));
        OmegaUtil.Companion.setMessenger(fragmentMessenger);
        transform((PaySecureState) null, PaySecureState.STATE_GATEKEEPER, fragmentMessenger);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        OmegaUtil.Companion.trackEvent("ibt_password_secure_page_destroy_ex");
        if (PaySecure.INSTANCE.getOpenCertificationListener() != null) {
            PaySecure.INSTANCE.setOpenCertificationListener((OpenCertificationListener) null);
        }
        if (PaySecure.INSTANCE.getPwdResultListener() != null) {
            PaySecure.INSTANCE.setPwdResultListener((PayPwdResultListener) null);
        }
        if (PaySecure.INSTANCE.getSetPwdResultListener() != null) {
            PaySecure.INSTANCE.setSetPwdResultListener((SetPwdResultListener) null);
        }
        super.onDestroy();
    }
}
