package com.didi.payment.wallet.global.wallet.view.view.home.p142v2.handler;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.didi.drouter.router.IRouterHandler;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import com.didi.payment.base.utils.ServiceLoaderUtil;
import com.didi.payment.wallet.global.model.WalletPageModel;
import com.didi.payment.wallet.global.prepaidcard.PrepaidCardManager;
import com.didi.payment.wallet.password.PasswordScene;
import com.didi.soda.compose.card.BaseCard;
import com.didiglobal.pay.paysecure.OpenCertificationListener;
import com.didiglobal.pay.paysecure.PaySecure;
import com.didiglobal.pay.paysecure.prepaidcard.CardPwdManager;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(mo175977d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001eB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016JD\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002JY\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u00112#\u0010\u0012\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0011¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00040\u001aH\u0002¨\u0006\u001f"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/handler/WalletOpenSessionHandler;", "Lcom/didi/drouter/router/IRouterHandler;", "()V", "handle", "", "request", "Lcom/didi/drouter/router/Request;", "result", "Lcom/didi/drouter/router/Result;", "handlePwdVerify", "activity", "Landroidx/fragment/app/FragmentActivity;", "netModel", "Lcom/didi/payment/wallet/global/model/WalletPageModel;", "bundle", "Landroid/os/Bundle;", "pwdType", "", "callback", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/handler/WalletOpenSessionHandler$IPwdVerify;", "startSession", "context", "Landroid/content/Context;", "resp", "Lcom/didi/payment/wallet/global/prepaidcard/resp/OpenSessionResp;", "scene", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "status", "IPwdVerify", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
@Deprecated(message = "改用链式启动会话 {@link PrepaidCommonHandler}")
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.handler.WalletOpenSessionHandler */
/* compiled from: WalletOpenSessionHandler.kt */
public final class WalletOpenSessionHandler implements IRouterHandler {

    @Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/handler/WalletOpenSessionHandler$IPwdVerify;", "", "onFail", "", "onSuccess", "res", "", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.handler.WalletOpenSessionHandler$IPwdVerify */
    /* compiled from: WalletOpenSessionHandler.kt */
    public interface IPwdVerify {
        void onFail();

        void onSuccess(int i);
    }

    public void handle(Request request, Result result) {
        LifecycleCoroutineScope lifecycleScope;
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(result, "result");
        WalletPageModel walletPageModel = new WalletPageModel(request.getContext().getApplicationContext());
        Map<String, String> parseUrlParams = PrepaidCardManager.Companion.parseUrlParams(request.getUri().toString());
        String str = parseUrlParams.get("source");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = parseUrlParams.get(BaseCard.KEY_CARD_ID);
        String str2 = parseUrlParams.get("scene");
        String str3 = parseUrlParams.get("pre_apply");
        String str4 = parseUrlParams.get("full_kyc");
        String str5 = parseUrlParams.get("verify_pwd");
        Context context = request.getContext();
        FragmentActivity fragmentActivity = context instanceof FragmentActivity ? (FragmentActivity) context : null;
        if (fragmentActivity != null && (lifecycleScope = LifecycleOwnerKt.getLifecycleScope(fragmentActivity)) != null) {
            lifecycleScope.launchWhenResumed(new WalletOpenSessionHandler$handle$1(str5, parseUrlParams, objectRef, str, str2, this, fragmentActivity, request, result, walletPageModel, str4, str3, (Continuation<? super WalletOpenSessionHandler$handle$1>) null));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m23122a(FragmentActivity fragmentActivity, Request request, Result result, WalletPageModel walletPageModel, Bundle bundle, String str, IPwdVerify iPwdVerify) {
        if (Intrinsics.areEqual((Object) str, (Object) "1")) {
            String string = bundle.getString("pay_session_id");
            if (string == null) {
                string = "";
            }
            OpenCertificationListener openCertificationListener = (OpenCertificationListener) ServiceLoaderUtil.getInstance().load(OpenCertificationListener.class);
            Intrinsics.checkNotNullExpressionValue(openCertificationListener, "listener");
            PaySecure.INSTANCE.verifyPayPassword(PasswordScene.PREPAY_CARD_ACTIVATION.name(), string, "", new WalletOpenSessionHandler$handlePwdVerify$1(iPwdVerify, fragmentActivity, bundle, walletPageModel), openCertificationListener);
        } else if (Intrinsics.areEqual((Object) str, (Object) "2")) {
            CardPwdManager cardPwdManager = CardPwdManager.INSTANCE;
            FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.supportFragmentManager");
            cardPwdManager.showCardPasswordDialog(supportFragmentManager, bundle, new WalletOpenSessionHandler$handlePwdVerify$2(iPwdVerify));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: androidx.fragment.app.FragmentActivity} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r3v2, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r3v6, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r3v8, types: [java.lang.String] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0033, code lost:
        r2 = new com.didi.payment.wallet.global.wallet.view.widget.WalletCommonBottomDialog.Builder();
        r0 = r15.getData();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003e, code lost:
        if (r0 != null) goto L_0x0042;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0040, code lost:
        r0 = "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0042, code lost:
        r0 = r0.getNoPassInfo();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0046, code lost:
        if (r0 != null) goto L_0x0049;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0049, code lost:
        r0 = r2.setTitle(r0).setShowCloseBtn(true);
        r2 = r12.getString(com.taxis99.R.string.Fintech_Payment_management_Got_it_JAnQ);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, "context.getString(R.stri…t_management_Got_it_JAnQ)");
        r0 = r0.setConfirmStr(r2).setClickListener(new com.didi.payment.wallet.global.wallet.view.view.home.p142v2.handler.WalletOpenSessionHandler$startSession$dialog$1()).build();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0073, code lost:
        if ((r1 instanceof androidx.fragment.app.FragmentActivity) == false) goto L_0x0078;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0075, code lost:
        r3 = (androidx.fragment.app.FragmentActivity) r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0078, code lost:
        if (r3 != null) goto L_0x007c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x007c, code lost:
        r1 = r3.getSupportFragmentManager();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0080, code lost:
        if (r1 != null) goto L_0x0084;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0084, code lost:
        r0.show(r1, "");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00ad, code lost:
        r0 = r15.getData();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00b1, code lost:
        if (r0 != null) goto L_0x00b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00b4, code lost:
        r3 = r0.getStatus();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00b8, code lost:
        r2.invoke(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:?, code lost:
        return;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m23121a(android.content.Context r12, com.didi.drouter.router.Request r13, com.didi.drouter.router.Result r14, com.didi.payment.wallet.global.prepaidcard.resp.OpenSessionResp r15, java.lang.String r16, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r17) {
        /*
            r11 = this;
            r1 = r12
            r0 = r15
            r2 = r17
            r3 = 0
            if (r0 != 0) goto L_0x0009
        L_0x0007:
            r4 = r3
            goto L_0x0014
        L_0x0009:
            com.didi.payment.wallet.global.prepaidcard.resp.OpenSessionResp$Data r4 = r15.getData()
            if (r4 != 0) goto L_0x0010
            goto L_0x0007
        L_0x0010:
            java.lang.String r4 = r4.getStatus()
        L_0x0014:
            if (r4 == 0) goto L_0x0141
            int r5 = r4.hashCode()
            switch(r5) {
                case 48: goto L_0x011e;
                case 49: goto L_0x00bd;
                case 50: goto L_0x00a3;
                case 51: goto L_0x0099;
                case 52: goto L_0x0089;
                case 53: goto L_0x0029;
                case 54: goto L_0x001f;
                default: goto L_0x001d;
            }
        L_0x001d:
            goto L_0x0141
        L_0x001f:
            java.lang.String r2 = "6"
            boolean r2 = r4.equals(r2)
            if (r2 != 0) goto L_0x0033
            goto L_0x0141
        L_0x0029:
            java.lang.String r2 = "5"
            boolean r2 = r4.equals(r2)
            if (r2 != 0) goto L_0x0033
            goto L_0x0141
        L_0x0033:
            com.didi.payment.wallet.global.wallet.view.widget.WalletCommonBottomDialog$Builder r2 = new com.didi.payment.wallet.global.wallet.view.widget.WalletCommonBottomDialog$Builder
            r2.<init>()
            com.didi.payment.wallet.global.prepaidcard.resp.OpenSessionResp$Data r0 = r15.getData()
            java.lang.String r4 = ""
            if (r0 != 0) goto L_0x0042
        L_0x0040:
            r0 = r4
            goto L_0x0049
        L_0x0042:
            java.lang.String r0 = r0.getNoPassInfo()
            if (r0 != 0) goto L_0x0049
            goto L_0x0040
        L_0x0049:
            com.didi.payment.wallet.global.wallet.view.widget.WalletCommonBottomDialog$Builder r0 = r2.setTitle(r0)
            r2 = 1
            com.didi.payment.wallet.global.wallet.view.widget.WalletCommonBottomDialog$Builder r0 = r0.setShowCloseBtn(r2)
            r2 = 2131951824(0x7f1300d0, float:1.9540073E38)
            java.lang.String r2 = r12.getString(r2)
            java.lang.String r5 = "context.getString(R.stri…t_management_Got_it_JAnQ)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)
            com.didi.payment.wallet.global.wallet.view.widget.WalletCommonBottomDialog$Builder r0 = r0.setConfirmStr(r2)
            com.didi.payment.wallet.global.wallet.view.view.home.v2.handler.WalletOpenSessionHandler$startSession$dialog$1 r2 = new com.didi.payment.wallet.global.wallet.view.view.home.v2.handler.WalletOpenSessionHandler$startSession$dialog$1
            r2.<init>()
            com.didi.payment.wallet.global.wallet.view.widget.ICommonBottomListener r2 = (com.didi.payment.wallet.global.wallet.view.widget.ICommonBottomListener) r2
            com.didi.payment.wallet.global.wallet.view.widget.WalletCommonBottomDialog$Builder r0 = r0.setClickListener(r2)
            com.didi.payment.wallet.global.wallet.view.widget.WalletCommonBottomDialog r0 = r0.build()
            boolean r2 = r1 instanceof androidx.fragment.app.FragmentActivity
            if (r2 == 0) goto L_0x0078
            r3 = r1
            androidx.fragment.app.FragmentActivity r3 = (androidx.fragment.app.FragmentActivity) r3
        L_0x0078:
            if (r3 != 0) goto L_0x007c
            goto L_0x0141
        L_0x007c:
            androidx.fragment.app.FragmentManager r1 = r3.getSupportFragmentManager()
            if (r1 != 0) goto L_0x0084
            goto L_0x0141
        L_0x0084:
            r0.show(r1, r4)
            goto L_0x0141
        L_0x0089:
            java.lang.String r0 = "4"
            boolean r0 = r4.equals(r0)
            if (r0 != 0) goto L_0x0093
            goto L_0x0141
        L_0x0093:
            r0 = 2
            com.didi.payment.wallet.global.utils.WalletRouter.gotoFullKycRegisterPage(r12, r0)
            goto L_0x0141
        L_0x0099:
            java.lang.String r1 = "3"
            boolean r1 = r4.equals(r1)
            if (r1 != 0) goto L_0x00ad
            goto L_0x0141
        L_0x00a3:
            java.lang.String r1 = "2"
            boolean r1 = r4.equals(r1)
            if (r1 != 0) goto L_0x00ad
            goto L_0x0141
        L_0x00ad:
            com.didi.payment.wallet.global.prepaidcard.resp.OpenSessionResp$Data r0 = r15.getData()
            if (r0 != 0) goto L_0x00b4
            goto L_0x00b8
        L_0x00b4:
            java.lang.String r3 = r0.getStatus()
        L_0x00b8:
            r2.invoke(r3)
            goto L_0x0141
        L_0x00bd:
            java.lang.String r5 = "1"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x00c7
            goto L_0x0141
        L_0x00c7:
            com.didi.payment.wallet.global.riskcontrol.RiskControlManager r4 = com.didi.payment.wallet.global.riskcontrol.RiskControlManager.INSTANCE
            com.didi.payment.wallet.global.prepaidcard.resp.OpenSessionResp$Data r5 = r15.getData()
            if (r5 != 0) goto L_0x00d1
            r5 = r3
            goto L_0x00d5
        L_0x00d1:
            java.lang.String r5 = r5.getVerifyType()
        L_0x00d5:
            com.didi.payment.wallet.global.prepaidcard.resp.OpenSessionResp$Data r6 = r15.getData()
            if (r6 != 0) goto L_0x00dd
        L_0x00db:
            r6 = r3
            goto L_0x00e8
        L_0x00dd:
            com.didi.payment.wallet.global.prepaidcard.resp.OpenSessionResp$ExtraInfo r6 = r6.getExtraInfo()
            if (r6 != 0) goto L_0x00e4
            goto L_0x00db
        L_0x00e4:
            java.lang.String r6 = r6.getFaceSessionId()
        L_0x00e8:
            com.didi.payment.wallet.global.prepaidcard.resp.OpenSessionResp$Data r7 = r15.getData()
            if (r7 != 0) goto L_0x00f0
        L_0x00ee:
            r7 = r3
            goto L_0x00fb
        L_0x00f0:
            com.didi.payment.wallet.global.prepaidcard.resp.OpenSessionResp$ExtraInfo r7 = r7.getExtraInfo()
            if (r7 != 0) goto L_0x00f7
            goto L_0x00ee
        L_0x00f7:
            java.lang.String r7 = r7.getFaceBizCode()
        L_0x00fb:
            com.didi.payment.wallet.global.prepaidcard.resp.OpenSessionResp$Data r8 = r15.getData()
            if (r8 != 0) goto L_0x0102
            goto L_0x0106
        L_0x0102:
            java.lang.String r3 = r8.getSessionId()
        L_0x0106:
            r8 = r3
            com.didi.payment.wallet.global.wallet.view.view.home.v2.handler.WalletOpenSessionHandler$startSession$2 r3 = new com.didi.payment.wallet.global.wallet.view.view.home.v2.handler.WalletOpenSessionHandler$startSession$2
            r9 = r13
            r10 = r14
            r3.<init>(r2, r15, r14, r13)
            r9 = r3
            com.didi.payment.wallet.global.riskcontrol.IRiskControlCallback r9 = (com.didi.payment.wallet.global.riskcontrol.IRiskControlCallback) r9
            r0 = r4
            r1 = r12
            r2 = r5
            r3 = r6
            r4 = r7
            r5 = r16
            r6 = r8
            r7 = r9
            r0.startRiskControl(r1, r2, r3, r4, r5, r6, r7)
            goto L_0x0141
        L_0x011e:
            java.lang.String r1 = "0"
            boolean r1 = r4.equals(r1)
            if (r1 != 0) goto L_0x0127
            goto L_0x0141
        L_0x0127:
            com.didi.payment.wallet.global.prepaidcard.resp.OpenSessionResp$Data r0 = r15.getData()
            if (r0 != 0) goto L_0x012e
            goto L_0x0132
        L_0x012e:
            java.lang.String r3 = r0.getStatus()
        L_0x0132:
            r2.invoke(r3)
            org.greenrobot.eventbus.EventBus r0 = org.greenrobot.eventbus.EventBus.getDefault()
            com.didi.payment.base.event.WalletRefreshDataEvent r1 = new com.didi.payment.base.event.WalletRefreshDataEvent
            r1.<init>()
            r0.post(r1)
        L_0x0141:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.wallet.global.wallet.view.view.home.p142v2.handler.WalletOpenSessionHandler.m23121a(android.content.Context, com.didi.drouter.router.Request, com.didi.drouter.router.Result, com.didi.payment.wallet.global.prepaidcard.resp.OpenSessionResp, java.lang.String, kotlin.jvm.functions.Function1):void");
    }
}
