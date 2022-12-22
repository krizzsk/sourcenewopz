package com.didi.payment.wallet.global.prepaidcard.interceptor;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import com.didi.payment.wallet.global.model.WalletPageModel;
import com.didi.payment.wallet.global.prepaidcard.interceptor.IPrepaidInterceptor;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002JH\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\r0\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016Jc\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\r2#\u0010\u0019\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00040\u001aH\u0002¨\u0006\u001e"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/prepaidcard/interceptor/IOpenSessionInterceptor;", "Lcom/didi/payment/wallet/global/prepaidcard/interceptor/IPrepaidInterceptor;", "()V", "onInterceptor", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "netModel", "Lcom/didi/payment/wallet/global/model/WalletPageModel;", "chain", "Lcom/didi/payment/wallet/global/prepaidcard/interceptor/IPrepaidInterceptor$Chain;", "params", "", "", "request", "Lcom/didi/drouter/router/Request;", "result", "Lcom/didi/drouter/router/Result;", "startSession", "context", "Landroid/content/Context;", "resp", "Lcom/didi/payment/wallet/global/prepaidcard/resp/OpenSessionResp;", "scene", "kyc", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "status", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: IOpenSessionInterceptor.kt */
public final class IOpenSessionInterceptor implements IPrepaidInterceptor {
    public void onInterceptor(FragmentActivity fragmentActivity, WalletPageModel walletPageModel, IPrepaidInterceptor.Chain chain, Map<String, String> map, Request request, Result result) {
        LifecycleCoroutineScope lifecycleScope;
        Intrinsics.checkNotNullParameter(walletPageModel, "netModel");
        Intrinsics.checkNotNullParameter(chain, "chain");
        Intrinsics.checkNotNullParameter(map, "params");
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(result, "result");
        if (fragmentActivity != null && (lifecycleScope = LifecycleOwnerKt.getLifecycleScope(fragmentActivity)) != null) {
            lifecycleScope.launchWhenResumed(new IOpenSessionInterceptor$onInterceptor$1(map, request, result, this, walletPageModel, fragmentActivity, (Continuation<? super IOpenSessionInterceptor$onInterceptor$1>) null));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v1, resolved type: androidx.fragment.app.FragmentActivity} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r5v2, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r5v6, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r5v8, types: [java.lang.String] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0041, code lost:
        r14.putExtra("result", 2);
        com.didi.drouter.router.RouterHelper.release(r13);
        r0 = new com.didi.payment.wallet.global.wallet.view.widget.WalletCommonBottomDialog.Builder();
        r2 = r15.getData();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0055, code lost:
        if (r2 != null) goto L_0x0059;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0057, code lost:
        r2 = "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0059, code lost:
        r2 = r2.getNoPassInfo();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005d, code lost:
        if (r2 != null) goto L_0x0060;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0060, code lost:
        r0 = r0.setTitle(r2).setShowCloseBtn(true);
        r2 = r12.getString(com.taxis99.R.string.Fintech_Payment_management_Got_it_JAnQ);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, "context.getString(R.stri…t_management_Got_it_JAnQ)");
        r0 = r0.setConfirmStr(r2).setClickListener(new com.didi.payment.wallet.global.prepaidcard.interceptor.IOpenSessionInterceptor$startSession$dialog$1()).build();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0089, code lost:
        if ((r1 instanceof androidx.fragment.app.FragmentActivity) == false) goto L_0x008e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x008b, code lost:
        r5 = (androidx.fragment.app.FragmentActivity) r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x008e, code lost:
        if (r5 != null) goto L_0x0092;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0092, code lost:
        r1 = r5.getSupportFragmentManager();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0096, code lost:
        if (r1 != null) goto L_0x009a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x009a, code lost:
        r0.show(r1, "");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00e1, code lost:
        com.didi.payment.commonsdk.widget.WalletToastNew.showFailedMsg(r12, r15.getErrmsg());
        r0 = r15.getData();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00ec, code lost:
        if (r0 != null) goto L_0x00ef;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00ef, code lost:
        r5 = r0.getStatus();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00f3, code lost:
        r4.invoke(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:?, code lost:
        return;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m22533a(android.content.Context r12, com.didi.drouter.router.Request r13, com.didi.drouter.router.Result r14, com.didi.payment.wallet.global.prepaidcard.resp.OpenSessionResp r15, java.lang.String r16, java.lang.String r17, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r18) {
        /*
            r11 = this;
            r1 = r12
            r0 = r14
            r2 = r15
            r3 = r17
            r4 = r18
            r5 = 0
            if (r2 != 0) goto L_0x000c
        L_0x000a:
            r6 = r5
            goto L_0x0017
        L_0x000c:
            com.didi.payment.wallet.global.prepaidcard.resp.OpenSessionResp$Data r6 = r15.getData()
            if (r6 != 0) goto L_0x0013
            goto L_0x000a
        L_0x0013:
            java.lang.String r6 = r6.getStatus()
        L_0x0017:
            if (r6 == 0) goto L_0x017b
            int r7 = r6.hashCode()
            r8 = 1
            switch(r7) {
                case 48: goto L_0x0158;
                case 49: goto L_0x00f8;
                case 50: goto L_0x00d7;
                case 51: goto L_0x00cd;
                case 52: goto L_0x009f;
                case 53: goto L_0x0037;
                case 54: goto L_0x002d;
                case 55: goto L_0x0023;
                default: goto L_0x0021;
            }
        L_0x0021:
            goto L_0x017b
        L_0x0023:
            java.lang.String r3 = "7"
            boolean r3 = r6.equals(r3)
            if (r3 != 0) goto L_0x0041
            goto L_0x017b
        L_0x002d:
            java.lang.String r3 = "6"
            boolean r3 = r6.equals(r3)
            if (r3 != 0) goto L_0x0041
            goto L_0x017b
        L_0x0037:
            java.lang.String r3 = "5"
            boolean r3 = r6.equals(r3)
            if (r3 != 0) goto L_0x0041
            goto L_0x017b
        L_0x0041:
            r3 = 2
            java.lang.String r4 = "result"
            r14.putExtra((java.lang.String) r4, (int) r3)
            com.didi.drouter.router.RouterHelper.release((com.didi.drouter.router.Request) r13)
            com.didi.payment.wallet.global.wallet.view.widget.WalletCommonBottomDialog$Builder r0 = new com.didi.payment.wallet.global.wallet.view.widget.WalletCommonBottomDialog$Builder
            r0.<init>()
            com.didi.payment.wallet.global.prepaidcard.resp.OpenSessionResp$Data r2 = r15.getData()
            java.lang.String r3 = ""
            if (r2 != 0) goto L_0x0059
        L_0x0057:
            r2 = r3
            goto L_0x0060
        L_0x0059:
            java.lang.String r2 = r2.getNoPassInfo()
            if (r2 != 0) goto L_0x0060
            goto L_0x0057
        L_0x0060:
            com.didi.payment.wallet.global.wallet.view.widget.WalletCommonBottomDialog$Builder r0 = r0.setTitle(r2)
            com.didi.payment.wallet.global.wallet.view.widget.WalletCommonBottomDialog$Builder r0 = r0.setShowCloseBtn(r8)
            r2 = 2131951824(0x7f1300d0, float:1.9540073E38)
            java.lang.String r2 = r12.getString(r2)
            java.lang.String r4 = "context.getString(R.stri…t_management_Got_it_JAnQ)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)
            com.didi.payment.wallet.global.wallet.view.widget.WalletCommonBottomDialog$Builder r0 = r0.setConfirmStr(r2)
            com.didi.payment.wallet.global.prepaidcard.interceptor.IOpenSessionInterceptor$startSession$dialog$1 r2 = new com.didi.payment.wallet.global.prepaidcard.interceptor.IOpenSessionInterceptor$startSession$dialog$1
            r2.<init>()
            com.didi.payment.wallet.global.wallet.view.widget.ICommonBottomListener r2 = (com.didi.payment.wallet.global.wallet.view.widget.ICommonBottomListener) r2
            com.didi.payment.wallet.global.wallet.view.widget.WalletCommonBottomDialog$Builder r0 = r0.setClickListener(r2)
            com.didi.payment.wallet.global.wallet.view.widget.WalletCommonBottomDialog r0 = r0.build()
            boolean r2 = r1 instanceof androidx.fragment.app.FragmentActivity
            if (r2 == 0) goto L_0x008e
            r5 = r1
            androidx.fragment.app.FragmentActivity r5 = (androidx.fragment.app.FragmentActivity) r5
        L_0x008e:
            if (r5 != 0) goto L_0x0092
            goto L_0x017b
        L_0x0092:
            androidx.fragment.app.FragmentManager r1 = r5.getSupportFragmentManager()
            if (r1 != 0) goto L_0x009a
            goto L_0x017b
        L_0x009a:
            r0.show(r1, r3)
            goto L_0x017b
        L_0x009f:
            java.lang.String r0 = "4"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x00a9
            goto L_0x017b
        L_0x00a9:
            r0 = 0
            if (r3 != 0) goto L_0x00ad
            goto L_0x00b1
        L_0x00ad:
            int r0 = com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp.WalletHomeModelKt.toDefaultInt$default(r3, r0, r8, r5)
        L_0x00b1:
            r2 = 3
            if (r0 >= r2) goto L_0x00bf
            java.lang.String r0 = "99pay://one/register?source=1"
            com.didi.drouter.router.Request r0 = com.didi.drouter.api.DRouter.build((java.lang.String) r0)
            r0.start(r12)
            goto L_0x017b
        L_0x00bf:
            r2 = 6
            if (r0 >= r2) goto L_0x017b
            java.lang.String r0 = "99pay://one/full_kyc_channel?source=8"
            com.didi.drouter.router.Request r0 = com.didi.drouter.api.DRouter.build((java.lang.String) r0)
            r0.start(r12)
            goto L_0x017b
        L_0x00cd:
            java.lang.String r0 = "3"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x00e1
            goto L_0x017b
        L_0x00d7:
            java.lang.String r0 = "2"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x00e1
            goto L_0x017b
        L_0x00e1:
            java.lang.String r0 = r15.getErrmsg()
            com.didi.payment.commonsdk.widget.WalletToastNew.showFailedMsg(r12, r0)
            com.didi.payment.wallet.global.prepaidcard.resp.OpenSessionResp$Data r0 = r15.getData()
            if (r0 != 0) goto L_0x00ef
            goto L_0x00f3
        L_0x00ef:
            java.lang.String r5 = r0.getStatus()
        L_0x00f3:
            r4.invoke(r5)
            goto L_0x017b
        L_0x00f8:
            java.lang.String r3 = "1"
            boolean r3 = r6.equals(r3)
            if (r3 != 0) goto L_0x0102
            goto L_0x017b
        L_0x0102:
            com.didi.payment.wallet.global.riskcontrol.RiskControlManager r3 = com.didi.payment.wallet.global.riskcontrol.RiskControlManager.INSTANCE
            com.didi.payment.wallet.global.prepaidcard.resp.OpenSessionResp$Data r6 = r15.getData()
            if (r6 != 0) goto L_0x010c
            r6 = r5
            goto L_0x0110
        L_0x010c:
            java.lang.String r6 = r6.getVerifyType()
        L_0x0110:
            com.didi.payment.wallet.global.prepaidcard.resp.OpenSessionResp$Data r7 = r15.getData()
            if (r7 != 0) goto L_0x0118
        L_0x0116:
            r7 = r5
            goto L_0x0123
        L_0x0118:
            com.didi.payment.wallet.global.prepaidcard.resp.OpenSessionResp$ExtraInfo r7 = r7.getExtraInfo()
            if (r7 != 0) goto L_0x011f
            goto L_0x0116
        L_0x011f:
            java.lang.String r7 = r7.getFaceSessionId()
        L_0x0123:
            com.didi.payment.wallet.global.prepaidcard.resp.OpenSessionResp$Data r8 = r15.getData()
            if (r8 != 0) goto L_0x012b
        L_0x0129:
            r8 = r5
            goto L_0x0136
        L_0x012b:
            com.didi.payment.wallet.global.prepaidcard.resp.OpenSessionResp$ExtraInfo r8 = r8.getExtraInfo()
            if (r8 != 0) goto L_0x0132
            goto L_0x0129
        L_0x0132:
            java.lang.String r8 = r8.getFaceBizCode()
        L_0x0136:
            com.didi.payment.wallet.global.prepaidcard.resp.OpenSessionResp$Data r9 = r15.getData()
            if (r9 != 0) goto L_0x013d
            goto L_0x0141
        L_0x013d:
            java.lang.String r5 = r9.getSessionId()
        L_0x0141:
            r9 = r5
            com.didi.payment.wallet.global.prepaidcard.interceptor.IOpenSessionInterceptor$startSession$2 r5 = new com.didi.payment.wallet.global.prepaidcard.interceptor.IOpenSessionInterceptor$startSession$2
            r10 = r13
            r5.<init>(r4, r15, r14, r13)
            r10 = r5
            com.didi.payment.wallet.global.riskcontrol.IRiskControlCallback r10 = (com.didi.payment.wallet.global.riskcontrol.IRiskControlCallback) r10
            r0 = r3
            r1 = r12
            r2 = r6
            r3 = r7
            r4 = r8
            r5 = r16
            r6 = r9
            r7 = r10
            r0.startRiskControl(r1, r2, r3, r4, r5, r6, r7)
            goto L_0x017b
        L_0x0158:
            java.lang.String r0 = "0"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x0161
            goto L_0x017b
        L_0x0161:
            com.didi.payment.wallet.global.prepaidcard.resp.OpenSessionResp$Data r0 = r15.getData()
            if (r0 != 0) goto L_0x0168
            goto L_0x016c
        L_0x0168:
            java.lang.String r5 = r0.getStatus()
        L_0x016c:
            r4.invoke(r5)
            org.greenrobot.eventbus.EventBus r0 = org.greenrobot.eventbus.EventBus.getDefault()
            com.didi.payment.base.event.WalletRefreshDataEvent r1 = new com.didi.payment.base.event.WalletRefreshDataEvent
            r1.<init>()
            r0.post(r1)
        L_0x017b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.wallet.global.prepaidcard.interceptor.IOpenSessionInterceptor.m22533a(android.content.Context, com.didi.drouter.router.Request, com.didi.drouter.router.Result, com.didi.payment.wallet.global.prepaidcard.resp.OpenSessionResp, java.lang.String, java.lang.String, kotlin.jvm.functions.Function1):void");
    }
}
