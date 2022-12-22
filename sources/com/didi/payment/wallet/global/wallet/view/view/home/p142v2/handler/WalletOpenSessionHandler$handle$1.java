package com.didi.payment.wallet.global.wallet.view.view.home.p142v2.handler;

import androidx.fragment.app.FragmentActivity;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import com.didi.payment.wallet.global.model.WalletPageModel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

@Metadata(mo175977d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, mo175978d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
@DebugMetadata(mo176686c = "com.didi.payment.wallet.global.wallet.view.view.home.v2.handler.WalletOpenSessionHandler$handle$1", mo176687f = "WalletOpenSessionHandler.kt", mo176688i = {0, 0, 1}, mo176689l = {124, 143}, mo176690m = "invokeSuspend", mo176691n = {"$this$launchWhenResumed", "preUrl", "preUrl"}, mo176692s = {"L$0", "L$1", "L$0"})
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.handler.WalletOpenSessionHandler$handle$1 */
/* compiled from: WalletOpenSessionHandler.kt */
final class WalletOpenSessionHandler$handle$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FragmentActivity $activity;
    final /* synthetic */ Ref.ObjectRef<String> $cardId;
    final /* synthetic */ String $fullKyc;
    final /* synthetic */ WalletPageModel $netModel;
    final /* synthetic */ Map<String, String> $params;
    final /* synthetic */ String $preApply;
    final /* synthetic */ Request $request;
    final /* synthetic */ Result $result;
    final /* synthetic */ String $scene;
    final /* synthetic */ String $source;
    final /* synthetic */ String $verifyPwd;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ WalletOpenSessionHandler this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WalletOpenSessionHandler$handle$1(String str, Map<String, String> map, Ref.ObjectRef<String> objectRef, String str2, String str3, WalletOpenSessionHandler walletOpenSessionHandler, FragmentActivity fragmentActivity, Request request, Result result, WalletPageModel walletPageModel, String str4, String str5, Continuation<? super WalletOpenSessionHandler$handle$1> continuation) {
        super(2, continuation);
        this.$verifyPwd = str;
        this.$params = map;
        this.$cardId = objectRef;
        this.$source = str2;
        this.$scene = str3;
        this.this$0 = walletOpenSessionHandler;
        this.$activity = fragmentActivity;
        this.$request = request;
        this.$result = result;
        this.$netModel = walletPageModel;
        this.$fullKyc = str4;
        this.$preApply = str5;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        WalletOpenSessionHandler$handle$1 walletOpenSessionHandler$handle$1 = new WalletOpenSessionHandler$handle$1(this.$verifyPwd, this.$params, this.$cardId, this.$source, this.$scene, this.this$0, this.$activity, this.$request, this.$result, this.$netModel, this.$fullKyc, this.$preApply, continuation);
        walletOpenSessionHandler$handle$1.L$0 = obj;
        return walletOpenSessionHandler$handle$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WalletOpenSessionHandler$handle$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:67:0x017a  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x019c  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x01c9  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x01df  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x01f4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r22) {
        /*
            r21 = this;
            r0 = r21
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 0
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L_0x0035
            if (r2 == r5) goto L_0x0025
            if (r2 != r3) goto L_0x001d
            java.lang.Object r1 = r0.L$0
            kotlin.jvm.internal.Ref$ObjectRef r1 = (kotlin.jvm.internal.Ref.ObjectRef) r1
            kotlin.ResultKt.throwOnFailure(r22)
            r2 = r22
            goto L_0x01c0
        L_0x001d:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0025:
            java.lang.Object r2 = r0.L$1
            kotlin.jvm.internal.Ref$ObjectRef r2 = (kotlin.jvm.internal.Ref.ObjectRef) r2
            java.lang.Object r7 = r0.L$0
            kotlinx.coroutines.CoroutineScope r7 = (kotlinx.coroutines.CoroutineScope) r7
            kotlin.ResultKt.throwOnFailure(r22)
            r8 = r7
            r7 = r22
            goto L_0x012f
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r22)
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.CoroutineScope r2 = (kotlinx.coroutines.CoroutineScope) r2
            com.didi.payment.base.proxy.LoadingProxyHolder$ILoadingProxy r7 = com.didi.payment.base.proxy.LoadingProxyHolder.getProxy()
            if (r7 != 0) goto L_0x0043
            goto L_0x0046
        L_0x0043:
            r7.showLoading()
        L_0x0046:
            java.lang.String r7 = r0.$verifyPwd
            java.lang.String r8 = "1"
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r8)
            if (r7 == 0) goto L_0x00b6
            java.util.Map<java.lang.String, java.lang.String> r1 = r0.$params
            java.lang.String r2 = "session_id"
            java.lang.Object r1 = r1.get(r2)
            java.lang.String r1 = (java.lang.String) r1
            java.util.Map<java.lang.String, java.lang.String> r3 = r0.$params
            java.lang.String r4 = "pwd_type"
            java.lang.Object r3 = r3.get(r4)
            r10 = r3
            java.lang.String r10 = (java.lang.String) r10
            java.util.Map<java.lang.String, java.lang.String> r3 = r0.$params
            java.lang.String r4 = "pay_session_id"
            java.lang.Object r3 = r3.get(r4)
            java.lang.String r3 = (java.lang.String) r3
            android.os.Bundle r9 = new android.os.Bundle
            r9.<init>()
            kotlin.jvm.internal.Ref$ObjectRef<java.lang.String> r5 = r0.$cardId
            T r5 = r5.element
            java.lang.String r5 = (java.lang.String) r5
            java.lang.String r6 = "card_id"
            r9.putString(r6, r5)
            java.lang.String r5 = r0.$source
            java.lang.String r6 = "source"
            r9.putString(r6, r5)
            java.lang.String r5 = r0.$scene
            java.lang.String r6 = "scene"
            r9.putString(r6, r5)
            r9.putString(r2, r1)
            r9.putString(r4, r3)
            com.didi.payment.wallet.global.wallet.view.view.home.v2.handler.WalletOpenSessionHandler r4 = r0.this$0
            androidx.fragment.app.FragmentActivity r5 = r0.$activity
            com.didi.drouter.router.Request r6 = r0.$request
            com.didi.drouter.router.Result r7 = r0.$result
            com.didi.payment.wallet.global.model.WalletPageModel r8 = r0.$netModel
            com.didi.payment.wallet.global.wallet.view.view.home.v2.handler.WalletOpenSessionHandler$handle$1$1 r1 = new com.didi.payment.wallet.global.wallet.view.view.home.v2.handler.WalletOpenSessionHandler$handle$1$1
            r1.<init>(r7, r6)
            r11 = r1
            com.didi.payment.wallet.global.wallet.view.view.home.v2.handler.WalletOpenSessionHandler$IPwdVerify r11 = (com.didi.payment.wallet.global.wallet.view.view.home.p142v2.handler.WalletOpenSessionHandler.IPwdVerify) r11
            r4.m23122a(r5, r6, r7, r8, r9, r10, r11)
            com.didi.payment.base.proxy.LoadingProxyHolder$ILoadingProxy r1 = com.didi.payment.base.proxy.LoadingProxyHolder.getProxy()
            if (r1 != 0) goto L_0x00b0
            goto L_0x00b3
        L_0x00b0:
            r1.dismissLoading()
        L_0x00b3:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        L_0x00b6:
            java.lang.String r7 = r0.$fullKyc
            if (r7 != 0) goto L_0x00bc
            r7 = 0
            goto L_0x00c0
        L_0x00bc:
            int r7 = com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp.WalletHomeModelKt.toDefaultInt$default(r7, r4, r5, r6)
        L_0x00c0:
            r9 = 3
            if (r7 >= r9) goto L_0x00dd
            java.lang.String r1 = "99pay://one/register?source=1"
            com.didi.drouter.router.Request r1 = com.didi.drouter.api.DRouter.build((java.lang.String) r1)
            androidx.fragment.app.FragmentActivity r2 = r0.$activity
            android.content.Context r2 = (android.content.Context) r2
            r1.start(r2)
            com.didi.payment.base.proxy.LoadingProxyHolder$ILoadingProxy r1 = com.didi.payment.base.proxy.LoadingProxyHolder.getProxy()
            if (r1 != 0) goto L_0x00d7
            goto L_0x00da
        L_0x00d7:
            r1.dismissLoading()
        L_0x00da:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        L_0x00dd:
            r9 = 6
            if (r7 >= r9) goto L_0x00fa
            java.lang.String r1 = "99pay://one/full_kyc_channel?source=2"
            com.didi.drouter.router.Request r1 = com.didi.drouter.api.DRouter.build((java.lang.String) r1)
            androidx.fragment.app.FragmentActivity r2 = r0.$activity
            android.content.Context r2 = (android.content.Context) r2
            r1.start(r2)
            com.didi.payment.base.proxy.LoadingProxyHolder$ILoadingProxy r1 = com.didi.payment.base.proxy.LoadingProxyHolder.getProxy()
            if (r1 != 0) goto L_0x00f4
            goto L_0x00f7
        L_0x00f4:
            r1.dismissLoading()
        L_0x00f7:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        L_0x00fa:
            kotlin.jvm.internal.Ref$ObjectRef r14 = new kotlin.jvm.internal.Ref$ObjectRef
            r14.<init>()
            java.lang.String r7 = ""
            r14.element = r7
            java.lang.String r7 = r0.$preApply
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r8)
            if (r7 == 0) goto L_0x0176
            com.didi.payment.base.net.WalletNet r7 = com.didi.payment.base.net.WalletNet.INSTANCE
            com.didi.payment.wallet.global.wallet.view.view.home.v2.handler.WalletOpenSessionHandler$handle$1$preResp$1 r8 = new com.didi.payment.wallet.global.wallet.view.view.home.v2.handler.WalletOpenSessionHandler$handle$1$preResp$1
            com.didi.payment.wallet.global.model.WalletPageModel r9 = r0.$netModel
            java.lang.String r10 = r0.$source
            r8.<init>(r9, r10, r6)
            r9 = r8
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
            r10 = 0
            r11 = r0
            kotlin.coroutines.Continuation r11 = (kotlin.coroutines.Continuation) r11
            r12 = 4
            r13 = 0
            r0.L$0 = r2
            r0.L$1 = r14
            r0.label = r5
            r8 = r2
            java.lang.Object r7 = com.didi.payment.base.net.WalletNet.withContext$default(r7, r8, r9, r10, r11, r12, r13)
            if (r7 != r1) goto L_0x012d
            return r1
        L_0x012d:
            r8 = r2
            r2 = r14
        L_0x012f:
            com.didi.payment.wallet.global.prepaidcard.resp.PreApplyCardResp r7 = (com.didi.payment.wallet.global.prepaidcard.resp.PreApplyCardResp) r7
            if (r7 != 0) goto L_0x0135
        L_0x0133:
            r9 = r6
            goto L_0x0140
        L_0x0135:
            com.didi.payment.wallet.global.prepaidcard.resp.PreApplyCardResp$Data r9 = r7.getData()
            if (r9 != 0) goto L_0x013c
            goto L_0x0133
        L_0x013c:
            java.lang.String r9 = r9.getIndexType()
        L_0x0140:
            java.lang.String r10 = "4"
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r10)
            if (r10 == 0) goto L_0x014a
            r9 = 1
            goto L_0x0150
        L_0x014a:
            java.lang.String r10 = "5"
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r10)
        L_0x0150:
            kotlin.jvm.internal.Ref$ObjectRef<java.lang.String> r10 = r0.$cardId
            if (r7 != 0) goto L_0x0156
        L_0x0154:
            r11 = r6
            goto L_0x0161
        L_0x0156:
            com.didi.payment.wallet.global.prepaidcard.resp.PreApplyCardResp$Data r11 = r7.getData()
            if (r11 != 0) goto L_0x015d
            goto L_0x0154
        L_0x015d:
            java.lang.String r11 = r11.getCardId()
        L_0x0161:
            r10.element = r11
            if (r7 != 0) goto L_0x0167
        L_0x0165:
            r7 = r6
            goto L_0x0172
        L_0x0167:
            com.didi.payment.wallet.global.prepaidcard.resp.PreApplyCardResp$Data r7 = r7.getData()
            if (r7 != 0) goto L_0x016e
            goto L_0x0165
        L_0x016e:
            java.lang.String r7 = r7.getLinkUrl()
        L_0x0172:
            r2.element = r7
            r14 = r2
            goto L_0x0178
        L_0x0176:
            r8 = r2
            r9 = 1
        L_0x0178:
            if (r9 != 0) goto L_0x019c
            com.didi.payment.wallet.global.prepaidcard.PrepaidCardManager$Companion r1 = com.didi.payment.wallet.global.prepaidcard.PrepaidCardManager.Companion
            T r2 = r14.element
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r1 = r1.buildWalletUrl(r2)
            com.didi.drouter.router.Request r1 = com.didi.drouter.api.DRouter.build((java.lang.String) r1)
            androidx.fragment.app.FragmentActivity r2 = r0.$activity
            android.content.Context r2 = (android.content.Context) r2
            r1.start(r2)
            com.didi.payment.base.proxy.LoadingProxyHolder$ILoadingProxy r1 = com.didi.payment.base.proxy.LoadingProxyHolder.getProxy()
            if (r1 != 0) goto L_0x0196
            goto L_0x0199
        L_0x0196:
            r1.dismissLoading()
        L_0x0199:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        L_0x019c:
            com.didi.payment.base.net.WalletNet r7 = com.didi.payment.base.net.WalletNet.INSTANCE
            com.didi.payment.wallet.global.wallet.view.view.home.v2.handler.WalletOpenSessionHandler$handle$1$resp$1 r2 = new com.didi.payment.wallet.global.wallet.view.view.home.v2.handler.WalletOpenSessionHandler$handle$1$resp$1
            com.didi.payment.wallet.global.model.WalletPageModel r9 = r0.$netModel
            java.lang.String r10 = r0.$scene
            kotlin.jvm.internal.Ref$ObjectRef<java.lang.String> r11 = r0.$cardId
            r2.<init>(r9, r10, r11, r6)
            r9 = r2
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
            r10 = 0
            r11 = r0
            kotlin.coroutines.Continuation r11 = (kotlin.coroutines.Continuation) r11
            r12 = 4
            r13 = 0
            r0.L$0 = r14
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r2 = com.didi.payment.base.net.WalletNet.withContext$default(r7, r8, r9, r10, r11, r12, r13)
            if (r2 != r1) goto L_0x01bf
            return r1
        L_0x01bf:
            r1 = r14
        L_0x01c0:
            com.didi.payment.wallet.global.prepaidcard.resp.OpenSessionResp r2 = (com.didi.payment.wallet.global.prepaidcard.resp.OpenSessionResp) r2
            com.didi.payment.base.proxy.LoadingProxyHolder$ILoadingProxy r3 = com.didi.payment.base.proxy.LoadingProxyHolder.getProxy()
            if (r3 != 0) goto L_0x01c9
            goto L_0x01cc
        L_0x01c9:
            r3.dismissLoading()
        L_0x01cc:
            if (r2 != 0) goto L_0x01cf
            goto L_0x01dd
        L_0x01cf:
            java.lang.Integer r3 = r2.getErrno()
            if (r3 != 0) goto L_0x01d6
            goto L_0x01dd
        L_0x01d6:
            int r3 = r3.intValue()
            if (r3 != 0) goto L_0x01dd
            r4 = 1
        L_0x01dd:
            if (r4 != 0) goto L_0x01f4
            com.didiglobal.pay.paysecure.util.ToastUtil r1 = com.didiglobal.pay.paysecure.util.ToastUtil.INSTANCE
            com.didi.drouter.router.Request r3 = r0.$request
            android.content.Context r3 = r3.getContext()
            if (r2 != 0) goto L_0x01ea
            goto L_0x01ee
        L_0x01ea:
            java.lang.String r6 = r2.getErrmsg()
        L_0x01ee:
            r1.showError((android.content.Context) r3, (java.lang.String) r6)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        L_0x01f4:
            java.lang.String r3 = r0.$source
            com.didi.payment.wallet.global.prepaidcard.PrepaidSource r4 = com.didi.payment.wallet.global.prepaidcard.PrepaidSource.SETTING_REQUEST
            java.lang.String r4 = r4.getValue()
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r4)
            if (r4 == 0) goto L_0x0204
            r4 = 1
            goto L_0x020e
        L_0x0204:
            com.didi.payment.wallet.global.prepaidcard.PrepaidSource r4 = com.didi.payment.wallet.global.prepaidcard.PrepaidSource.HOME_TOP
            java.lang.String r4 = r4.getValue()
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r4)
        L_0x020e:
            java.lang.String r6 = "request.context"
            if (r4 == 0) goto L_0x0233
            com.didi.payment.wallet.global.wallet.view.view.home.v2.handler.WalletOpenSessionHandler r7 = r0.this$0
            com.didi.drouter.router.Request r3 = r0.$request
            android.content.Context r8 = r3.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r6)
            com.didi.drouter.router.Request r9 = r0.$request
            com.didi.drouter.router.Result r10 = r0.$result
            java.lang.String r12 = r0.$scene
            com.didi.payment.wallet.global.wallet.view.view.home.v2.handler.WalletOpenSessionHandler$handle$1$2 r3 = new com.didi.payment.wallet.global.wallet.view.view.home.v2.handler.WalletOpenSessionHandler$handle$1$2
            java.lang.String r4 = r0.$preApply
            r3.<init>(r2, r4, r1, r9)
            r13 = r3
            kotlin.jvm.functions.Function1 r13 = (kotlin.jvm.functions.Function1) r13
            r11 = r2
            r7.m23121a(r8, r9, r10, r11, r12, r13)
            goto L_0x0341
        L_0x0233:
            com.didi.payment.wallet.global.prepaidcard.PrepaidSource r4 = com.didi.payment.wallet.global.prepaidcard.PrepaidSource.HOME_DIALOG
            java.lang.String r4 = r4.getValue()
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r4)
            if (r4 == 0) goto L_0x0241
            r4 = 1
            goto L_0x024b
        L_0x0241:
            com.didi.payment.wallet.global.prepaidcard.PrepaidSource r4 = com.didi.payment.wallet.global.prepaidcard.PrepaidSource.TOP_UP_DIALOG
            java.lang.String r4 = r4.getValue()
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r4)
        L_0x024b:
            if (r4 == 0) goto L_0x024f
            r4 = 1
            goto L_0x0259
        L_0x024f:
            com.didi.payment.wallet.global.prepaidcard.PrepaidSource r4 = com.didi.payment.wallet.global.prepaidcard.PrepaidSource.HOME_BANNER
            java.lang.String r4 = r4.getValue()
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r4)
        L_0x0259:
            if (r4 == 0) goto L_0x025c
            goto L_0x0266
        L_0x025c:
            com.didi.payment.wallet.global.prepaidcard.PrepaidSource r4 = com.didi.payment.wallet.global.prepaidcard.PrepaidSource.HOME_SKU
            java.lang.String r4 = r4.getValue()
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r4)
        L_0x0266:
            if (r5 == 0) goto L_0x02a7
            com.didi.payment.wallet.global.wallet.view.view.home.v2.handler.WalletOpenSessionHandler r3 = r0.this$0
            com.didi.drouter.router.Request r4 = r0.$request
            android.content.Context r4 = r4.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r6)
            com.didi.drouter.router.Request r5 = r0.$request
            com.didi.drouter.router.Result r6 = r0.$result
            java.lang.String r15 = r0.$scene
            com.didi.payment.wallet.global.wallet.view.view.home.v2.handler.WalletOpenSessionHandler$handle$1$3 r19 = new com.didi.payment.wallet.global.wallet.view.view.home.v2.handler.WalletOpenSessionHandler$handle$1$3
            kotlin.jvm.internal.Ref$ObjectRef<java.lang.String> r10 = r0.$cardId
            java.lang.String r11 = r0.$source
            com.didi.payment.wallet.global.wallet.view.view.home.v2.handler.WalletOpenSessionHandler r13 = r0.this$0
            androidx.fragment.app.FragmentActivity r14 = r0.$activity
            com.didi.payment.wallet.global.model.WalletPageModel r12 = r0.$netModel
            java.lang.String r9 = r0.$preApply
            r7 = r19
            r8 = r2
            r17 = r9
            r9 = r5
            r16 = r12
            r12 = r15
            r20 = r15
            r15 = r6
            r18 = r1
            r7.<init>(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            r13 = r19
            kotlin.jvm.functions.Function1 r13 = (kotlin.jvm.functions.Function1) r13
            r7 = r3
            r8 = r4
            r10 = r6
            r11 = r2
            r12 = r20
            r7.m23121a(r8, r9, r10, r11, r12, r13)
            goto L_0x0341
        L_0x02a7:
            com.didi.payment.wallet.global.prepaidcard.PrepaidSource r1 = com.didi.payment.wallet.global.prepaidcard.PrepaidSource.SETTING_RESET
            java.lang.String r1 = r1.getValue()
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r1)
            if (r1 == 0) goto L_0x02df
            com.didi.payment.wallet.global.wallet.view.view.home.v2.handler.WalletOpenSessionHandler r1 = r0.this$0
            com.didi.drouter.router.Request r3 = r0.$request
            android.content.Context r3 = r3.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r6)
            com.didi.drouter.router.Request r4 = r0.$request
            com.didi.drouter.router.Result r5 = r0.$result
            java.lang.String r6 = r0.$scene
            com.didi.payment.wallet.global.wallet.view.view.home.v2.handler.WalletOpenSessionHandler$handle$1$4 r14 = new com.didi.payment.wallet.global.wallet.view.view.home.v2.handler.WalletOpenSessionHandler$handle$1$4
            androidx.fragment.app.FragmentActivity r8 = r0.$activity
            kotlin.jvm.internal.Ref$ObjectRef<java.lang.String> r9 = r0.$cardId
            r7 = r14
            r10 = r2
            r11 = r6
            r12 = r5
            r13 = r4
            r7.<init>(r8, r9, r10, r11, r12, r13)
            r13 = r14
            kotlin.jvm.functions.Function1 r13 = (kotlin.jvm.functions.Function1) r13
            r7 = r1
            r8 = r3
            r9 = r4
            r10 = r5
            r11 = r2
            r12 = r6
            r7.m23121a(r8, r9, r10, r11, r12, r13)
            goto L_0x0341
        L_0x02df:
            com.didi.payment.wallet.global.prepaidcard.PrepaidSource r1 = com.didi.payment.wallet.global.prepaidcard.PrepaidSource.FORGET_PASSWORD
            java.lang.String r1 = r1.getValue()
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r1)
            if (r1 == 0) goto L_0x0309
            com.didi.payment.wallet.global.wallet.view.view.home.v2.handler.WalletOpenSessionHandler r7 = r0.this$0
            com.didi.drouter.router.Request r1 = r0.$request
            android.content.Context r8 = r1.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r6)
            com.didi.drouter.router.Request r9 = r0.$request
            com.didi.drouter.router.Result r10 = r0.$result
            java.lang.String r12 = r0.$scene
            com.didi.payment.wallet.global.wallet.view.view.home.v2.handler.WalletOpenSessionHandler$handle$1$5 r1 = new com.didi.payment.wallet.global.wallet.view.view.home.v2.handler.WalletOpenSessionHandler$handle$1$5
            r1.<init>(r10, r2, r9)
            r13 = r1
            kotlin.jvm.functions.Function1 r13 = (kotlin.jvm.functions.Function1) r13
            r11 = r2
            r7.m23121a(r8, r9, r10, r11, r12, r13)
            goto L_0x0341
        L_0x0309:
            com.didi.payment.wallet.global.prepaidcard.PrepaidSource r1 = com.didi.payment.wallet.global.prepaidcard.PrepaidSource.SETTING_CANCEL
            java.lang.String r1 = r1.getValue()
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r1)
            if (r1 == 0) goto L_0x0341
            com.didi.payment.wallet.global.wallet.view.view.home.v2.handler.WalletOpenSessionHandler r1 = r0.this$0
            com.didi.drouter.router.Request r3 = r0.$request
            android.content.Context r3 = r3.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r6)
            com.didi.drouter.router.Request r4 = r0.$request
            com.didi.drouter.router.Result r5 = r0.$result
            java.lang.String r6 = r0.$scene
            com.didi.payment.wallet.global.wallet.view.view.home.v2.handler.WalletOpenSessionHandler$handle$1$6 r14 = new com.didi.payment.wallet.global.wallet.view.view.home.v2.handler.WalletOpenSessionHandler$handle$1$6
            androidx.fragment.app.FragmentActivity r8 = r0.$activity
            com.didi.payment.wallet.global.model.WalletPageModel r10 = r0.$netModel
            kotlin.jvm.internal.Ref$ObjectRef<java.lang.String> r11 = r0.$cardId
            java.lang.String r12 = r0.$source
            r7 = r14
            r9 = r4
            r13 = r2
            r7.<init>(r8, r9, r10, r11, r12, r13)
            r13 = r14
            kotlin.jvm.functions.Function1 r13 = (kotlin.jvm.functions.Function1) r13
            r7 = r1
            r8 = r3
            r10 = r5
            r11 = r2
            r12 = r6
            r7.m23121a(r8, r9, r10, r11, r12, r13)
        L_0x0341:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.wallet.global.wallet.view.view.home.p142v2.handler.WalletOpenSessionHandler$handle$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
