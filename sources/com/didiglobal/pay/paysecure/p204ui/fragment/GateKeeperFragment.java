package com.didiglobal.pay.paysecure.p204ui.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.didiglobal.pay.paysecure.OpenCertificationListener;
import com.didiglobal.pay.paysecure.PayPwdResultListener;
import com.didiglobal.pay.paysecure.PaySecure;
import com.didiglobal.pay.paysecure.SetPwdResultListener;
import com.didiglobal.pay.paysecure.base.PaySecureBaseFragment;
import com.didiglobal.pay.paysecure.base.PaySecureState;
import com.didiglobal.pay.paysecure.net.PaySecureRequest;
import com.didiglobal.pay.paysecure.omega.OmegaUtil;
import com.didiglobal.pay.paysecure.p204ui.view.ErrorDialogCallback;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\tJ\b\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J$\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u001a\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0010\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020\rH\u0002R\u0010\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000¨\u0006#"}, mo175978d2 = {"Lcom/didiglobal/pay/paysecure/ui/fragment/GateKeeperFragment;", "Lcom/didiglobal/pay/paysecure/base/PaySecureBaseFragment;", "()V", "gatekeeperCallback", "com/didiglobal/pay/paysecure/ui/fragment/GateKeeperFragment$gatekeeperCallback$1", "Lcom/didiglobal/pay/paysecure/ui/fragment/GateKeeperFragment$gatekeeperCallback$1;", "mRootView", "Landroid/widget/FrameLayout;", "getErrorDialogCallback", "Lcom/didiglobal/pay/paysecure/ui/view/ErrorDialogCallback;", "getNowState", "Lcom/didiglobal/pay/paysecure/base/PaySecureState;", "handleGatekeeper", "", "data", "Lcom/didiglobal/pay/paysecure/net/pojo/response/GateKeeperResponse;", "nextStep", "userVerificationParams", "", "onBackPressed", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "openKyc", "source", "", "sendRequest", "paysecure_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* renamed from: com.didiglobal.pay.paysecure.ui.fragment.GateKeeperFragment */
/* compiled from: GateKeeperFragment.kt */
public final class GateKeeperFragment extends PaySecureBaseFragment {

    /* renamed from: a */
    private FrameLayout f50426a;

    /* renamed from: b */
    private final GateKeeperFragment$gatekeeperCallback$1 f50427b = new GateKeeperFragment$gatekeeperCallback$1(this);

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.fragment_gatekeeper, viewGroup, false);
        if (inflate != null) {
            FrameLayout frameLayout = (FrameLayout) inflate;
            this.f50426a = frameLayout;
            if (frameLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            }
            return frameLayout;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.widget.FrameLayout");
    }

    public PaySecureState getNowState() {
        return getMState();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        m36269a();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m36269a() {
        showLoading((String) null);
        PaySecureRequest.INSTANCE.gatekeeper(getMessenger().getScene(), getMessenger().getPaySessionId(), this.f50427b);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0042, code lost:
        r0 = r0.getCheckType();
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m36271a(com.didiglobal.pay.paysecure.net.pojo.response.GateKeeperResponse r4) {
        /*
            r3 = this;
            com.didiglobal.pay.paysecure.base.FragmentMessenger r0 = r3.getMessenger()
            com.didiglobal.pay.paysecure.net.pojo.response.PasswordSettings r1 = r4.getPasswordSettings()
            r0.setPasswordSettings(r1)
            com.didiglobal.pay.paysecure.base.FragmentMessenger r0 = r3.getMessenger()
            com.google.gson.JsonObject r1 = r4.getUserVerificationParamsRaw()
            java.lang.String r1 = java.lang.String.valueOf(r1)
            r0.setUserVerificationParamsRaw(r1)
            com.google.gson.Gson r0 = new com.google.gson.Gson
            r0.<init>()
            com.didiglobal.pay.paysecure.base.FragmentMessenger r1 = r3.getMessenger()
            com.google.gson.JsonObject r4 = r4.getUserVerificationParamsRaw()
            com.google.gson.JsonElement r4 = (com.google.gson.JsonElement) r4
            java.lang.Class<com.didiglobal.pay.paysecure.net.pojo.response.UserVerificationParams> r2 = com.didiglobal.pay.paysecure.net.pojo.response.UserVerificationParams.class
            java.lang.Object r4 = r0.fromJson((com.google.gson.JsonElement) r4, r2)
            com.didiglobal.pay.paysecure.net.pojo.response.UserVerificationParams r4 = (com.didiglobal.pay.paysecure.net.pojo.response.UserVerificationParams) r4
            r1.setUserVerificationParams(r4)
            com.didiglobal.pay.paysecure.base.FragmentMessenger r4 = r3.getMessenger()
            com.didiglobal.pay.paysecure.base.FragmentMessenger r0 = r3.getMessenger()
            com.didiglobal.pay.paysecure.net.pojo.response.UserVerificationParams r0 = r0.getUserVerificationParams()
            if (r0 == 0) goto L_0x004c
            java.lang.String[] r0 = r0.getCheckType()
            if (r0 == 0) goto L_0x004c
            r1 = 0
            r0 = r0[r1]
            goto L_0x004d
        L_0x004c:
            r0 = 0
        L_0x004d:
            r4.setSelectedCheckType(r0)
            com.didiglobal.pay.paysecure.base.FragmentMessenger r4 = r3.getMessenger()
            int r4 = r4.getSceneType()
            r0 = 1
            if (r4 == 0) goto L_0x0088
            r1 = 3
            if (r4 == r0) goto L_0x006e
            r0 = 2
            if (r4 == r0) goto L_0x0068
            if (r4 == r1) goto L_0x0064
            goto L_0x00a1
        L_0x0064:
            r3.m36270a((int) r0)
            goto L_0x00a1
        L_0x0068:
            com.didiglobal.pay.paysecure.base.PaySecureState r4 = com.didiglobal.pay.paysecure.base.PaySecureState.STATE_VERIFY_PWD
            r3.transform(r4)
            goto L_0x00a1
        L_0x006e:
            com.didiglobal.pay.paysecure.base.FragmentMessenger r4 = r3.getMessenger()
            java.lang.String r4 = r4.getSelectedCheckType()
            java.lang.String r0 = "OLD_PASSWORD"
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r0)
            if (r4 == 0) goto L_0x0084
            com.didiglobal.pay.paysecure.base.PaySecureState r4 = com.didiglobal.pay.paysecure.base.PaySecureState.STATE_VERIFY_OLD_PWD
            r3.transform(r4)
            goto L_0x00a1
        L_0x0084:
            r3.m36270a((int) r1)
            goto L_0x00a1
        L_0x0088:
            com.didiglobal.pay.paysecure.base.FragmentMessenger r4 = r3.getMessenger()
            java.lang.String r4 = r4.getSelectedCheckType()
            java.lang.String r1 = "NO_VERIFY"
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r1)
            if (r4 == 0) goto L_0x009e
            com.didiglobal.pay.paysecure.base.PaySecureState r4 = com.didiglobal.pay.paysecure.base.PaySecureState.STATE_SET_PWD
            r3.transform(r4)
            goto L_0x00a1
        L_0x009e:
            r3.m36270a((int) r0)
        L_0x00a1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.pay.paysecure.p204ui.fragment.GateKeeperFragment.m36271a(com.didiglobal.pay.paysecure.net.pojo.response.GateKeeperResponse):void");
    }

    /* renamed from: a */
    private final void m36270a(int i) {
        OpenCertificationListener openCertificationListener = PaySecure.INSTANCE.getOpenCertificationListener();
        if (openCertificationListener != null) {
            FragmentActivity activity = getActivity();
            if (activity == null) {
                Intrinsics.throwNpe();
            }
            Intrinsics.checkExpressionValueIsNotNull(activity, "activity!!");
            Activity activity2 = activity;
            String selectedCheckType = getMessenger().getSelectedCheckType();
            if (selectedCheckType == null) {
                Intrinsics.throwNpe();
            }
            String userVerificationParamsRaw = getMessenger().getUserVerificationParamsRaw();
            if (userVerificationParamsRaw == null) {
                Intrinsics.throwNpe();
            }
            openCertificationListener.openCert(activity2, selectedCheckType, userVerificationParamsRaw, i, getMessenger().getScene(), new GateKeeperFragment$openKyc$1(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m36272a(String str) {
        new OmegaUtil("ibt_password_secure_nex_step_en").add("sceneType", Integer.valueOf(getMessenger().getSceneType())).send();
        int sceneType = getMessenger().getSceneType();
        if (sceneType == 0) {
            transform(PaySecureState.STATE_SET_PWD);
        } else if (sceneType == 1) {
            transform(PaySecureState.STATE_SET_NEW_PWD);
        } else if (sceneType == 3) {
            transform(PaySecureState.STATE_SET_NEW_PWD);
        }
    }

    public final ErrorDialogCallback getErrorDialogCallback() {
        return new GateKeeperFragment$getErrorDialogCallback$1(this);
    }

    public boolean onBackPressed() {
        SetPwdResultListener setPwdResultListener = PaySecure.INSTANCE.getSetPwdResultListener();
        if (setPwdResultListener != null) {
            setPwdResultListener.onFailure("gatekeeper_failed", "");
        }
        PayPwdResultListener pwdResultListener = PaySecure.INSTANCE.getPwdResultListener();
        if (pwdResultListener != null) {
            pwdResultListener.onFailure("gatekeeper_failed", "");
        }
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return true;
        }
        activity.finish();
        return true;
    }
}
