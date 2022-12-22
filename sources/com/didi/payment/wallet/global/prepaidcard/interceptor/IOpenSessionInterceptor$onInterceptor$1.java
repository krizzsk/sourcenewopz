package com.didi.payment.wallet.global.prepaidcard.interceptor;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import com.didi.drouter.router.RouterHelper;
import com.didi.payment.base.net.WalletNet;
import com.didi.payment.base.proxy.LoadingProxyHolder;
import com.didi.payment.commonsdk.widget.WalletToastNew;
import com.didi.payment.wallet.global.model.WalletPageModel;
import com.didi.payment.wallet.global.prepaidcard.PrepaidSource;
import com.didi.payment.wallet.global.prepaidcard.resp.CancelCardResp;
import com.didi.payment.wallet.global.prepaidcard.resp.OpenSessionResp;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.tool.WalletHomeTrackerManager;
import com.didi.soda.compose.card.BaseCard;
import com.didiglobal.pay.paysecure.prepaidcard.CardPwdManager;
import com.didiglobal.pay.paysecure.prepaidcard.IActiveCardListener;
import com.taxis99.R;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(mo175977d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, mo175978d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
@DebugMetadata(mo176686c = "com.didi.payment.wallet.global.prepaidcard.interceptor.IOpenSessionInterceptor$onInterceptor$1", mo176687f = "IOpenSessionInterceptor.kt", mo176688i = {0, 0, 0, 0, 0, 0}, mo176689l = {52}, mo176690m = "invokeSuspend", mo176691n = {"source", "cardId", "scene", "preApply", "preUrl", "fullKyc"}, mo176692s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5"})
/* compiled from: IOpenSessionInterceptor.kt */
final class IOpenSessionInterceptor$onInterceptor$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FragmentActivity $activity;
    final /* synthetic */ WalletPageModel $netModel;
    final /* synthetic */ Map<String, String> $params;
    final /* synthetic */ Request $request;
    final /* synthetic */ Result $result;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    final /* synthetic */ IOpenSessionInterceptor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    IOpenSessionInterceptor$onInterceptor$1(Map<String, String> map, Request request, Result result, IOpenSessionInterceptor iOpenSessionInterceptor, WalletPageModel walletPageModel, FragmentActivity fragmentActivity, Continuation<? super IOpenSessionInterceptor$onInterceptor$1> continuation) {
        super(2, continuation);
        this.$params = map;
        this.$request = request;
        this.$result = result;
        this.this$0 = iOpenSessionInterceptor;
        this.$netModel = walletPageModel;
        this.$activity = fragmentActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        IOpenSessionInterceptor$onInterceptor$1 iOpenSessionInterceptor$onInterceptor$1 = new IOpenSessionInterceptor$onInterceptor$1(this.$params, this.$request, this.$result, this.this$0, this.$netModel, this.$activity, continuation);
        iOpenSessionInterceptor$onInterceptor$1.L$0 = obj;
        return iOpenSessionInterceptor$onInterceptor$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((IOpenSessionInterceptor$onInterceptor$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        final String str;
        final String str2;
        final String str3;
        String str4;
        Object obj2;
        String str5;
        String str6;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        Integer errno;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        String str7 = null;
        boolean z5 = true;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            str5 = this.$params.get("source");
            String str8 = this.$params.get(BaseCard.KEY_CARD_ID);
            String str9 = this.$params.get("scene");
            String str10 = this.$params.get("pre_apply");
            String str11 = this.$params.get("pre_url");
            String str12 = this.$params.get("full_kyc");
            WalletNet walletNet = WalletNet.INSTANCE;
            this.L$0 = str5;
            this.L$1 = str8;
            this.L$2 = str9;
            this.L$3 = str10;
            this.L$4 = str11;
            this.L$5 = str12;
            this.label = 1;
            String str13 = str12;
            obj2 = WalletNet.withContext$default(walletNet, (CoroutineScope) this.L$0, new IOpenSessionInterceptor$onInterceptor$1$resp$1(this.$netModel, str9, str8, (Continuation<? super IOpenSessionInterceptor$onInterceptor$1$resp$1>) null), (Function1) null, this, 4, (Object) null);
            if (obj2 == coroutine_suspended) {
                return coroutine_suspended;
            }
            str3 = str8;
            str6 = str9;
            str2 = str10;
            str = str11;
            str4 = str13;
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
            str4 = (String) this.L$5;
            str = (String) this.L$4;
            str2 = (String) this.L$3;
            str6 = (String) this.L$2;
            str3 = (String) this.L$1;
            str5 = (String) this.L$0;
            obj2 = obj;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        final OpenSessionResp openSessionResp = (OpenSessionResp) obj2;
        LoadingProxyHolder.ILoadingProxy proxy = LoadingProxyHolder.getProxy();
        if (proxy != null) {
            proxy.dismissLoading();
        }
        if (openSessionResp == null || (errno = openSessionResp.getErrno()) == null || errno.intValue() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            Context context = this.$request.getContext();
            if (openSessionResp != null) {
                str7 = openSessionResp.getErrmsg();
            }
            WalletToastNew.showFailedMsg(context, str7);
            this.$result.putExtra("result", 0);
            RouterHelper.release(this.$request);
            return Unit.INSTANCE;
        }
        if (Intrinsics.areEqual((Object) str5, (Object) PrepaidSource.SETTING_REQUEST.getValue())) {
            z2 = true;
        } else {
            z2 = Intrinsics.areEqual((Object) str5, (Object) PrepaidSource.HOME_TOP.getValue());
        }
        if (z2) {
            IOpenSessionInterceptor iOpenSessionInterceptor = this.this$0;
            Context context2 = this.$request.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "request.context");
            Request request = this.$request;
            Result result = this.$result;
            final OpenSessionResp openSessionResp2 = openSessionResp;
            final String str14 = str2;
            final String str15 = str;
            final Request request2 = request;
            final Result result2 = result;
            iOpenSessionInterceptor.m22533a(context2, request, result, openSessionResp, str6, str4, new Function1<String, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((String) obj);
                    return Unit.INSTANCE;
                }

                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void invoke(java.lang.String r6) {
                    /*
                        r5 = this;
                        if (r6 == 0) goto L_0x00fc
                        int r0 = r6.hashCode()
                        java.lang.String r1 = "sessionStatus"
                        java.lang.String r2 = "sessionId"
                        java.lang.String r3 = "1"
                        r4 = 0
                        switch(r0) {
                            case 48: goto L_0x0086;
                            case 49: goto L_0x007e;
                            case 50: goto L_0x001c;
                            case 51: goto L_0x0012;
                            default: goto L_0x0010;
                        }
                    L_0x0010:
                        goto L_0x00fc
                    L_0x0012:
                        java.lang.String r0 = "3"
                        boolean r6 = r6.equals(r0)
                        if (r6 != 0) goto L_0x0026
                        goto L_0x00fc
                    L_0x001c:
                        java.lang.String r0 = "2"
                        boolean r6 = r6.equals(r0)
                        if (r6 != 0) goto L_0x0026
                        goto L_0x00fc
                    L_0x0026:
                        java.util.LinkedHashMap r6 = new java.util.LinkedHashMap
                        r6.<init>()
                        java.util.Map r6 = (java.util.Map) r6
                        com.didi.payment.wallet.global.prepaidcard.resp.OpenSessionResp r0 = r7
                        com.didi.payment.wallet.global.prepaidcard.resp.OpenSessionResp$Data r0 = r0.getData()
                        if (r0 != 0) goto L_0x0037
                        r0 = r4
                        goto L_0x003b
                    L_0x0037:
                        java.lang.String r0 = r0.getSessionId()
                    L_0x003b:
                        r6.put(r2, r0)
                        com.didi.payment.wallet.global.prepaidcard.resp.OpenSessionResp r0 = r7
                        com.didi.payment.wallet.global.prepaidcard.resp.OpenSessionResp$Data r0 = r0.getData()
                        if (r0 != 0) goto L_0x0048
                        r0 = r4
                        goto L_0x004c
                    L_0x0048:
                        java.lang.String r0 = r0.getStatus()
                    L_0x004c:
                        r6.put(r1, r0)
                        com.didi.payment.wallet.global.prepaidcard.PrepaidCardManager$Companion r0 = com.didi.payment.wallet.global.prepaidcard.PrepaidCardManager.Companion
                        com.didi.payment.wallet.global.prepaidcard.resp.OpenSessionResp r1 = r7
                        com.didi.payment.wallet.global.prepaidcard.resp.OpenSessionResp$Data r1 = r1.getData()
                        if (r1 != 0) goto L_0x005a
                        goto L_0x0065
                    L_0x005a:
                        com.didi.payment.wallet.global.prepaidcard.resp.OpenSessionResp$ExtraInfo r1 = r1.getExtraInfo()
                        if (r1 != 0) goto L_0x0061
                        goto L_0x0065
                    L_0x0061:
                        java.lang.String r4 = r1.getLinkUrl()
                    L_0x0065:
                        java.lang.String r6 = r0.buildParamsUrl(r4, r6)
                        com.didi.payment.wallet.global.prepaidcard.PrepaidCardManager$Companion r0 = com.didi.payment.wallet.global.prepaidcard.PrepaidCardManager.Companion
                        java.lang.String r6 = r0.buildWalletUrl(r6)
                        com.didi.drouter.router.Request r6 = com.didi.drouter.api.DRouter.build((java.lang.String) r6)
                        com.didi.drouter.router.Request r0 = r10
                        android.content.Context r0 = r0.getContext()
                        r6.start(r0)
                        goto L_0x0109
                    L_0x007e:
                        boolean r6 = r6.equals(r3)
                        if (r6 != 0) goto L_0x0090
                        goto L_0x00fc
                    L_0x0086:
                        java.lang.String r0 = "0"
                        boolean r6 = r6.equals(r0)
                        if (r6 != 0) goto L_0x0090
                        goto L_0x00fc
                    L_0x0090:
                        java.util.LinkedHashMap r6 = new java.util.LinkedHashMap
                        r6.<init>()
                        java.util.Map r6 = (java.util.Map) r6
                        com.didi.payment.wallet.global.prepaidcard.resp.OpenSessionResp r0 = r7
                        com.didi.payment.wallet.global.prepaidcard.resp.OpenSessionResp$Data r0 = r0.getData()
                        if (r0 != 0) goto L_0x00a1
                        r0 = r4
                        goto L_0x00a5
                    L_0x00a1:
                        java.lang.String r0 = r0.getSessionId()
                    L_0x00a5:
                        r6.put(r2, r0)
                        com.didi.payment.wallet.global.prepaidcard.resp.OpenSessionResp r0 = r7
                        com.didi.payment.wallet.global.prepaidcard.resp.OpenSessionResp$Data r0 = r0.getData()
                        if (r0 != 0) goto L_0x00b2
                        r0 = r4
                        goto L_0x00b6
                    L_0x00b2:
                        java.lang.String r0 = r0.getStatus()
                    L_0x00b6:
                        r6.put(r1, r0)
                        java.lang.String r0 = r8
                        boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r3)
                        if (r0 == 0) goto L_0x00ce
                        java.lang.String r0 = r9
                        java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                        boolean r0 = android.text.TextUtils.isEmpty(r0)
                        if (r0 != 0) goto L_0x00ce
                        java.lang.String r4 = r9
                        goto L_0x00e2
                    L_0x00ce:
                        com.didi.payment.wallet.global.prepaidcard.resp.OpenSessionResp r0 = r7
                        com.didi.payment.wallet.global.prepaidcard.resp.OpenSessionResp$Data r0 = r0.getData()
                        if (r0 != 0) goto L_0x00d7
                        goto L_0x00e2
                    L_0x00d7:
                        com.didi.payment.wallet.global.prepaidcard.resp.OpenSessionResp$ExtraInfo r0 = r0.getExtraInfo()
                        if (r0 != 0) goto L_0x00de
                        goto L_0x00e2
                    L_0x00de:
                        java.lang.String r4 = r0.getLinkUrl()
                    L_0x00e2:
                        com.didi.payment.wallet.global.prepaidcard.PrepaidCardManager$Companion r0 = com.didi.payment.wallet.global.prepaidcard.PrepaidCardManager.Companion
                        java.lang.String r6 = r0.buildParamsUrl(r4, r6)
                        com.didi.payment.wallet.global.prepaidcard.PrepaidCardManager$Companion r0 = com.didi.payment.wallet.global.prepaidcard.PrepaidCardManager.Companion
                        java.lang.String r6 = r0.buildWalletUrl(r6)
                        com.didi.drouter.router.Request r6 = com.didi.drouter.api.DRouter.build((java.lang.String) r6)
                        com.didi.drouter.router.Request r0 = r10
                        android.content.Context r0 = r0.getContext()
                        r6.start(r0)
                        goto L_0x0109
                    L_0x00fc:
                        com.didi.drouter.router.Result r6 = r11
                        r0 = 0
                        java.lang.String r1 = "result"
                        r6.putExtra((java.lang.String) r1, (int) r0)
                        com.didi.drouter.router.Request r6 = r10
                        com.didi.drouter.router.RouterHelper.release((com.didi.drouter.router.Request) r6)
                    L_0x0109:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.wallet.global.prepaidcard.interceptor.IOpenSessionInterceptor$onInterceptor$1.C111031.invoke(java.lang.String):void");
                }
            });
        } else {
            if (Intrinsics.areEqual((Object) str5, (Object) PrepaidSource.HOME_DIALOG.getValue())) {
                z3 = true;
            } else {
                z3 = Intrinsics.areEqual((Object) str5, (Object) PrepaidSource.TOP_UP_DIALOG.getValue());
            }
            if (z3) {
                z4 = true;
            } else {
                z4 = Intrinsics.areEqual((Object) str5, (Object) PrepaidSource.HOME_BANNER.getValue());
            }
            if (!z4) {
                z5 = Intrinsics.areEqual((Object) str5, (Object) PrepaidSource.HOME_SKU.getValue());
            }
            if (z5) {
                IOpenSessionInterceptor iOpenSessionInterceptor2 = this.this$0;
                Context context3 = this.$request.getContext();
                Intrinsics.checkNotNullExpressionValue(context3, "request.context");
                Request request3 = this.$request;
                Result result3 = this.$result;
                final OpenSessionResp openSessionResp3 = openSessionResp;
                final Request request4 = request3;
                final String str16 = str3;
                final String str17 = str5;
                final String str18 = str6;
                final FragmentActivity fragmentActivity = this.$activity;
                final WalletPageModel walletPageModel = this.$netModel;
                iOpenSessionInterceptor2.m22533a(context3, request3, result3, openSessionResp, str6, str4, new Function1<String, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((String) obj);
                        return Unit.INSTANCE;
                    }

                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public final void invoke(java.lang.String r13) {
                        /*
                            r12 = this;
                            if (r13 == 0) goto L_0x0196
                            int r0 = r13.hashCode()
                            java.lang.String r1 = "sessionStatus"
                            java.lang.String r2 = "sessionId"
                            java.lang.String r3 = "2"
                            java.lang.String r4 = "1"
                            r5 = 0
                            switch(r0) {
                                case 48: goto L_0x0086;
                                case 49: goto L_0x007e;
                                case 50: goto L_0x001e;
                                case 51: goto L_0x0014;
                                default: goto L_0x0012;
                            }
                        L_0x0012:
                            goto L_0x0196
                        L_0x0014:
                            java.lang.String r0 = "3"
                            boolean r13 = r13.equals(r0)
                            if (r13 != 0) goto L_0x0026
                            goto L_0x0196
                        L_0x001e:
                            boolean r13 = r13.equals(r3)
                            if (r13 != 0) goto L_0x0026
                            goto L_0x0196
                        L_0x0026:
                            java.util.LinkedHashMap r13 = new java.util.LinkedHashMap
                            r13.<init>()
                            java.util.Map r13 = (java.util.Map) r13
                            com.didi.payment.wallet.global.prepaidcard.resp.OpenSessionResp r0 = r14
                            com.didi.payment.wallet.global.prepaidcard.resp.OpenSessionResp$Data r0 = r0.getData()
                            if (r0 != 0) goto L_0x0037
                            r0 = r5
                            goto L_0x003b
                        L_0x0037:
                            java.lang.String r0 = r0.getSessionId()
                        L_0x003b:
                            r13.put(r2, r0)
                            com.didi.payment.wallet.global.prepaidcard.resp.OpenSessionResp r0 = r14
                            com.didi.payment.wallet.global.prepaidcard.resp.OpenSessionResp$Data r0 = r0.getData()
                            if (r0 != 0) goto L_0x0048
                            r0 = r5
                            goto L_0x004c
                        L_0x0048:
                            java.lang.String r0 = r0.getStatus()
                        L_0x004c:
                            r13.put(r1, r0)
                            com.didi.payment.wallet.global.prepaidcard.PrepaidCardManager$Companion r0 = com.didi.payment.wallet.global.prepaidcard.PrepaidCardManager.Companion
                            com.didi.payment.wallet.global.prepaidcard.resp.OpenSessionResp r1 = r14
                            com.didi.payment.wallet.global.prepaidcard.resp.OpenSessionResp$Data r1 = r1.getData()
                            if (r1 != 0) goto L_0x005a
                            goto L_0x0065
                        L_0x005a:
                            com.didi.payment.wallet.global.prepaidcard.resp.OpenSessionResp$ExtraInfo r1 = r1.getExtraInfo()
                            if (r1 != 0) goto L_0x0061
                            goto L_0x0065
                        L_0x0061:
                            java.lang.String r5 = r1.getLinkUrl()
                        L_0x0065:
                            java.lang.String r13 = r0.buildParamsUrl(r5, r13)
                            com.didi.payment.wallet.global.prepaidcard.PrepaidCardManager$Companion r0 = com.didi.payment.wallet.global.prepaidcard.PrepaidCardManager.Companion
                            java.lang.String r13 = r0.buildWalletUrl(r13)
                            com.didi.drouter.router.Request r13 = com.didi.drouter.api.DRouter.build((java.lang.String) r13)
                            com.didi.drouter.router.Request r0 = r15
                            android.content.Context r0 = r0.getContext()
                            r13.start(r0)
                            goto L_0x0196
                        L_0x007e:
                            boolean r13 = r13.equals(r4)
                            if (r13 != 0) goto L_0x0090
                            goto L_0x0196
                        L_0x0086:
                            java.lang.String r0 = "0"
                            boolean r13 = r13.equals(r0)
                            if (r13 != 0) goto L_0x0090
                            goto L_0x0196
                        L_0x0090:
                            com.didi.payment.wallet.global.prepaidcard.resp.OpenSessionResp r13 = r14
                            com.didi.payment.wallet.global.prepaidcard.resp.OpenSessionResp$Data r13 = r13.getData()
                            if (r13 != 0) goto L_0x009a
                        L_0x0098:
                            r13 = r5
                            goto L_0x00a5
                        L_0x009a:
                            com.didi.payment.wallet.global.prepaidcard.resp.OpenSessionResp$ExtraInfo r13 = r13.getExtraInfo()
                            if (r13 != 0) goto L_0x00a1
                            goto L_0x0098
                        L_0x00a1:
                            java.lang.String r13 = r13.getVerifyPasswordStatus()
                        L_0x00a5:
                            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r13, (java.lang.Object) r4)
                            if (r0 == 0) goto L_0x00ad
                            r13 = 1
                            goto L_0x00b1
                        L_0x00ad:
                            boolean r13 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r13, (java.lang.Object) r3)
                        L_0x00b1:
                            if (r13 == 0) goto L_0x012b
                            android.os.Bundle r9 = new android.os.Bundle
                            r9.<init>()
                            java.lang.String r13 = r16
                            java.lang.String r0 = "card_id"
                            r9.putString(r0, r13)
                            java.lang.String r13 = r17
                            java.lang.String r0 = "source"
                            r9.putString(r0, r13)
                            java.lang.String r13 = r18
                            java.lang.String r0 = "scene"
                            r9.putString(r0, r13)
                            com.didi.payment.wallet.global.prepaidcard.resp.OpenSessionResp r13 = r14
                            com.didi.payment.wallet.global.prepaidcard.resp.OpenSessionResp$Data r13 = r13.getData()
                            if (r13 != 0) goto L_0x00d7
                            r13 = r5
                            goto L_0x00db
                        L_0x00d7:
                            java.lang.String r13 = r13.getSessionId()
                        L_0x00db:
                            java.lang.String r0 = "session_id"
                            r9.putString(r0, r13)
                            com.didi.payment.wallet.global.prepaidcard.resp.OpenSessionResp r13 = r14
                            com.didi.payment.wallet.global.prepaidcard.resp.OpenSessionResp$Data r13 = r13.getData()
                            if (r13 != 0) goto L_0x00ea
                        L_0x00e8:
                            r13 = r5
                            goto L_0x00f5
                        L_0x00ea:
                            com.didi.payment.wallet.global.prepaidcard.resp.OpenSessionResp$ExtraInfo r13 = r13.getExtraInfo()
                            if (r13 != 0) goto L_0x00f1
                            goto L_0x00e8
                        L_0x00f1:
                            java.lang.String r13 = r13.getPaySessionId()
                        L_0x00f5:
                            java.lang.String r0 = "pay_session_id"
                            r9.putString(r0, r13)
                            com.didi.payment.wallet.global.prepaidcard.VerifyPwdUtil$Companion r6 = com.didi.payment.wallet.global.prepaidcard.VerifyPwdUtil.Companion
                            androidx.fragment.app.FragmentActivity r7 = r19
                            com.didi.payment.wallet.global.model.WalletPageModel r8 = r20
                            com.didi.payment.wallet.global.prepaidcard.resp.OpenSessionResp r13 = r14
                            com.didi.payment.wallet.global.prepaidcard.resp.OpenSessionResp$Data r13 = r13.getData()
                            if (r13 != 0) goto L_0x010a
                        L_0x0108:
                            r10 = r5
                            goto L_0x0116
                        L_0x010a:
                            com.didi.payment.wallet.global.prepaidcard.resp.OpenSessionResp$ExtraInfo r13 = r13.getExtraInfo()
                            if (r13 != 0) goto L_0x0111
                            goto L_0x0108
                        L_0x0111:
                            java.lang.String r5 = r13.getVerifyPasswordStatus()
                            goto L_0x0108
                        L_0x0116:
                            com.didi.payment.wallet.global.prepaidcard.interceptor.IOpenSessionInterceptor$onInterceptor$1$2$1 r13 = new com.didi.payment.wallet.global.prepaidcard.interceptor.IOpenSessionInterceptor$onInterceptor$1$2$1
                            com.didi.payment.wallet.global.prepaidcard.resp.OpenSessionResp r0 = r14
                            java.lang.String r1 = r21
                            java.lang.String r2 = r22
                            com.didi.drouter.router.Request r3 = r15
                            r13.<init>(r0, r1, r2, r3)
                            r11 = r13
                            com.didi.payment.wallet.global.prepaidcard.IPwdVerify r11 = (com.didi.payment.wallet.global.prepaidcard.IPwdVerify) r11
                            r6.handlePwdVerify(r7, r8, r9, r10, r11)
                            goto L_0x0196
                        L_0x012b:
                            java.util.LinkedHashMap r13 = new java.util.LinkedHashMap
                            r13.<init>()
                            java.util.Map r13 = (java.util.Map) r13
                            com.didi.payment.wallet.global.prepaidcard.resp.OpenSessionResp r0 = r14
                            com.didi.payment.wallet.global.prepaidcard.resp.OpenSessionResp$Data r0 = r0.getData()
                            if (r0 != 0) goto L_0x013c
                            r0 = r5
                            goto L_0x0140
                        L_0x013c:
                            java.lang.String r0 = r0.getSessionId()
                        L_0x0140:
                            r13.put(r2, r0)
                            com.didi.payment.wallet.global.prepaidcard.resp.OpenSessionResp r0 = r14
                            com.didi.payment.wallet.global.prepaidcard.resp.OpenSessionResp$Data r0 = r0.getData()
                            if (r0 != 0) goto L_0x014d
                            r0 = r5
                            goto L_0x0151
                        L_0x014d:
                            java.lang.String r0 = r0.getStatus()
                        L_0x0151:
                            r13.put(r1, r0)
                            java.lang.String r0 = r21
                            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r4)
                            if (r0 == 0) goto L_0x0169
                            java.lang.String r0 = r22
                            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                            boolean r0 = android.text.TextUtils.isEmpty(r0)
                            if (r0 != 0) goto L_0x0169
                            java.lang.String r5 = r22
                            goto L_0x017d
                        L_0x0169:
                            com.didi.payment.wallet.global.prepaidcard.resp.OpenSessionResp r0 = r14
                            com.didi.payment.wallet.global.prepaidcard.resp.OpenSessionResp$Data r0 = r0.getData()
                            if (r0 != 0) goto L_0x0172
                            goto L_0x017d
                        L_0x0172:
                            com.didi.payment.wallet.global.prepaidcard.resp.OpenSessionResp$ExtraInfo r0 = r0.getExtraInfo()
                            if (r0 != 0) goto L_0x0179
                            goto L_0x017d
                        L_0x0179:
                            java.lang.String r5 = r0.getLinkUrl()
                        L_0x017d:
                            com.didi.payment.wallet.global.prepaidcard.PrepaidCardManager$Companion r0 = com.didi.payment.wallet.global.prepaidcard.PrepaidCardManager.Companion
                            java.lang.String r13 = r0.buildParamsUrl(r5, r13)
                            com.didi.payment.wallet.global.prepaidcard.PrepaidCardManager$Companion r0 = com.didi.payment.wallet.global.prepaidcard.PrepaidCardManager.Companion
                            java.lang.String r13 = r0.buildWalletUrl(r13)
                            com.didi.drouter.router.Request r13 = com.didi.drouter.api.DRouter.build((java.lang.String) r13)
                            com.didi.drouter.router.Request r0 = r15
                            android.content.Context r0 = r0.getContext()
                            r13.start(r0)
                        L_0x0196:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.wallet.global.prepaidcard.interceptor.IOpenSessionInterceptor$onInterceptor$1.C111042.invoke(java.lang.String):void");
                    }
                });
            } else if (Intrinsics.areEqual((Object) str5, (Object) PrepaidSource.SETTING_RESET.getValue())) {
                IOpenSessionInterceptor iOpenSessionInterceptor3 = this.this$0;
                Context context4 = this.$request.getContext();
                Intrinsics.checkNotNullExpressionValue(context4, "request.context");
                Request request5 = this.$request;
                Result result4 = this.$result;
                final FragmentActivity fragmentActivity2 = this.$activity;
                final String str19 = str3;
                final OpenSessionResp openSessionResp4 = openSessionResp;
                final String str20 = str6;
                final Result result5 = result4;
                final Request request6 = request5;
                iOpenSessionInterceptor3.m22533a(context4, request5, result4, openSessionResp, str6, str4, new Function1<String, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((String) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(String str) {
                        boolean z;
                        if (Intrinsics.areEqual((Object) str, (Object) "1")) {
                            z = true;
                        } else {
                            z = Intrinsics.areEqual((Object) str, (Object) "0");
                        }
                        if (z) {
                            CardPwdManager cardPwdManager = CardPwdManager.INSTANCE;
                            Activity activity = fragmentActivity2;
                            String str2 = str19;
                            OpenSessionResp.Data data = openSessionResp4.getData();
                            String sessionId = data == null ? null : data.getSessionId();
                            String str3 = str20;
                            final Result result = result5;
                            final Request request = request6;
                            cardPwdManager.showResetPassword(activity, str2, sessionId, str3, new IActiveCardListener() {
                                public void onResult(int i) {
                                    result.putExtra("result", i);
                                    RouterHelper.release(request);
                                }
                            });
                            return;
                        }
                        result5.putExtra("result", 0);
                        RouterHelper.release(request6);
                        WalletHomeTrackerManager.Companion.trackPrepaidSettingFailed();
                    }
                });
            } else if (Intrinsics.areEqual((Object) str5, (Object) PrepaidSource.FORGET_PASSWORD.getValue())) {
                IOpenSessionInterceptor iOpenSessionInterceptor4 = this.this$0;
                Context context5 = this.$request.getContext();
                Intrinsics.checkNotNullExpressionValue(context5, "request.context");
                final Request request7 = this.$request;
                final Result result6 = this.$result;
                iOpenSessionInterceptor4.m22533a(context5, request7, result6, openSessionResp, str6, str4, new Function1<String, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((String) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(String str) {
                        if (Intrinsics.areEqual((Object) str, (Object) "1") ? true : Intrinsics.areEqual((Object) str, (Object) "0")) {
                            Result result = result6;
                            OpenSessionResp.Data data = openSessionResp.getData();
                            result.putExtra("session_id", data == null ? null : data.getSessionId());
                            result6.putExtra("result", 1);
                            RouterHelper.release(request7);
                            return;
                        }
                        result6.putExtra("result", 0);
                        RouterHelper.release(request7);
                    }
                });
            } else if (Intrinsics.areEqual((Object) str5, (Object) PrepaidSource.SETTING_CANCEL.getValue())) {
                IOpenSessionInterceptor iOpenSessionInterceptor5 = this.this$0;
                Context context6 = this.$request.getContext();
                Intrinsics.checkNotNullExpressionValue(context6, "request.context");
                Request request8 = this.$request;
                Result result7 = this.$result;
                final FragmentActivity fragmentActivity3 = this.$activity;
                final Result result8 = result7;
                final Request request9 = request8;
                final WalletPageModel walletPageModel2 = this.$netModel;
                final String str21 = str5;
                final OpenSessionResp openSessionResp5 = openSessionResp;
                iOpenSessionInterceptor5.m22533a(context6, request8, result7, openSessionResp, str6, str4, new Function1<String, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((String) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(String str) {
                        boolean z;
                        if (Intrinsics.areEqual((Object) str, (Object) "1")) {
                            z = true;
                        } else {
                            z = Intrinsics.areEqual((Object) str, (Object) "0");
                        }
                        if (z) {
                            LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(fragmentActivity3);
                            final FragmentActivity fragmentActivity = fragmentActivity3;
                            final Result result = result8;
                            final Request request = request9;
                            final WalletPageModel walletPageModel = walletPageModel2;
                            final String str2 = str3;
                            final String str3 = str21;
                            final OpenSessionResp openSessionResp = openSessionResp5;
                            lifecycleScope.launchWhenResumed(new C111101((Continuation<? super C111101>) null));
                            return;
                        }
                        result8.putExtra("result", 0);
                        RouterHelper.release(request9);
                    }

                    @Metadata(mo175977d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, mo175978d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
                    @DebugMetadata(mo176686c = "com.didi.payment.wallet.global.prepaidcard.interceptor.IOpenSessionInterceptor$onInterceptor$1$5$1", mo176687f = "IOpenSessionInterceptor.kt", mo176688i = {}, mo176689l = {190}, mo176690m = "invokeSuspend", mo176691n = {}, mo176692s = {})
                    /* renamed from: com.didi.payment.wallet.global.prepaidcard.interceptor.IOpenSessionInterceptor$onInterceptor$1$5$1 */
                    /* compiled from: IOpenSessionInterceptor.kt */
                    static final class C111101 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        private /* synthetic */ Object L$0;
                        int label;

                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            C111101 r0 = new C111101(fragmentActivity, result, request, walletPageModel, str2, str3, openSessionResp, continuation);
                            r0.L$0 = obj;
                            return r0;
                        }

                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((C111101) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        public final Object invokeSuspend(Object obj) {
                            boolean z;
                            Integer errno;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i = this.label;
                            if (i == 0) {
                                ResultKt.throwOnFailure(obj);
                                LoadingProxyHolder.getProxy().showLoading();
                                WalletNet walletNet = WalletNet.INSTANCE;
                                this.label = 1;
                                obj = WalletNet.withContext$default(walletNet, (CoroutineScope) this.L$0, new IOpenSessionInterceptor$onInterceptor$1$5$1$cancelResp$1(walletPageModel, str2, str3, openSessionResp, (Continuation<? super IOpenSessionInterceptor$onInterceptor$1$5$1$cancelResp$1>) null), (Function1) null, this, 4, (Object) null);
                                if (obj == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } else if (i == 1) {
                                ResultKt.throwOnFailure(obj);
                            } else {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            CancelCardResp cancelCardResp = (CancelCardResp) obj;
                            LoadingProxyHolder.getProxy().dismissLoading();
                            if (cancelCardResp == null || (errno = cancelCardResp.getErrno()) == null || errno.intValue() != 0) {
                                z = false;
                            } else {
                                z = true;
                            }
                            if (z) {
                                FragmentActivity fragmentActivity = fragmentActivity;
                                WalletToastNew.showSuccessMsg(fragmentActivity, fragmentActivity.getString(R.string.Fintech_Payment_Password_Prepaid_card_zTfb));
                                result.putExtra("result", 1);
                                RouterHelper.release(request);
                            } else {
                                WalletToastNew.showFailedMsg(fragmentActivity, cancelCardResp == null ? null : cancelCardResp.getErrmsg());
                                result.putExtra("result", 0);
                                RouterHelper.release(request);
                            }
                            return Unit.INSTANCE;
                        }
                    }
                });
            }
        }
        return Unit.INSTANCE;
    }
}
