package com.didi.payment.wallet.global.prepaidcard.interceptor;

import androidx.fragment.app.FragmentActivity;
import com.didi.payment.wallet.global.model.WalletPageModel;
import com.didi.payment.wallet.global.prepaidcard.interceptor.IPrepaidInterceptor;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(mo175977d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, mo175978d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
@DebugMetadata(mo176686c = "com.didi.payment.wallet.global.prepaidcard.interceptor.IPreApplyCardInterceptor$onInterceptor$1", mo176687f = "IPreApplyCardInterceptor.kt", mo176688i = {}, mo176689l = {33}, mo176690m = "invokeSuspend", mo176691n = {}, mo176692s = {})
/* compiled from: IPreApplyCardInterceptor.kt */
final class IPreApplyCardInterceptor$onInterceptor$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FragmentActivity $activity;
    final /* synthetic */ IPrepaidInterceptor.Chain $chain;
    final /* synthetic */ WalletPageModel $netModel;
    final /* synthetic */ Map<String, String> $params;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    IPreApplyCardInterceptor$onInterceptor$1(Map<String, String> map, IPrepaidInterceptor.Chain chain, FragmentActivity fragmentActivity, WalletPageModel walletPageModel, Continuation<? super IPreApplyCardInterceptor$onInterceptor$1> continuation) {
        super(2, continuation);
        this.$params = map;
        this.$chain = chain;
        this.$activity = fragmentActivity;
        this.$netModel = walletPageModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        IPreApplyCardInterceptor$onInterceptor$1 iPreApplyCardInterceptor$onInterceptor$1 = new IPreApplyCardInterceptor$onInterceptor$1(this.$params, this.$chain, this.$activity, this.$netModel, continuation);
        iPreApplyCardInterceptor$onInterceptor$1.L$0 = obj;
        return iPreApplyCardInterceptor$onInterceptor$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((IPreApplyCardInterceptor$onInterceptor$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0067, code lost:
        r0 = r13.getData();
     */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00c5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
        /*
            r12 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r12.label
            java.lang.String r2 = "card_id"
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L_0x001a
            if (r1 != r3) goto L_0x0012
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x0061
        L_0x0012:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L_0x001a:
            kotlin.ResultKt.throwOnFailure(r13)
            java.lang.Object r13 = r12.L$0
            r6 = r13
            kotlinx.coroutines.CoroutineScope r6 = (kotlinx.coroutines.CoroutineScope) r6
            java.util.Map<java.lang.String, java.lang.String> r13 = r12.$params
            java.lang.String r1 = "pre_apply"
            java.lang.Object r13 = r13.get(r1)
            java.lang.String r13 = (java.lang.String) r13
            java.util.Map<java.lang.String, java.lang.String> r1 = r12.$params
            java.lang.Object r1 = r1.get(r2)
            java.lang.String r1 = (java.lang.String) r1
            java.util.Map<java.lang.String, java.lang.String> r1 = r12.$params
            java.lang.String r5 = "source"
            java.lang.Object r1 = r1.get(r5)
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r5 = "1"
            boolean r13 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r13, (java.lang.Object) r5)
            if (r13 == 0) goto L_0x00b2
            com.didi.payment.base.net.WalletNet r5 = com.didi.payment.base.net.WalletNet.INSTANCE
            com.didi.payment.wallet.global.prepaidcard.interceptor.IPreApplyCardInterceptor$onInterceptor$1$preResp$1 r13 = new com.didi.payment.wallet.global.prepaidcard.interceptor.IPreApplyCardInterceptor$onInterceptor$1$preResp$1
            com.didi.payment.wallet.global.model.WalletPageModel r7 = r12.$netModel
            r13.<init>(r1, r7, r4)
            r7 = r13
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            r8 = 0
            r9 = r12
            kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
            r10 = 4
            r11 = 0
            r12.label = r3
            java.lang.Object r13 = com.didi.payment.base.net.WalletNet.withContext$default(r5, r6, r7, r8, r9, r10, r11)
            if (r13 != r0) goto L_0x0061
            return r0
        L_0x0061:
            com.didi.payment.wallet.global.prepaidcard.resp.PreApplyCardResp r13 = (com.didi.payment.wallet.global.prepaidcard.resp.PreApplyCardResp) r13
            if (r13 != 0) goto L_0x0067
        L_0x0065:
            r0 = r4
            goto L_0x0072
        L_0x0067:
            com.didi.payment.wallet.global.prepaidcard.resp.PreApplyCardResp$Data r0 = r13.getData()
            if (r0 != 0) goto L_0x006e
            goto L_0x0065
        L_0x006e:
            java.lang.String r0 = r0.getIndexType()
        L_0x0072:
            java.lang.String r1 = "4"
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            if (r1 == 0) goto L_0x0084
            java.util.Map<java.lang.String, java.lang.String> r0 = r12.$params
            java.lang.String r1 = "scene"
            java.lang.String r5 = "apply"
            r0.put(r1, r5)
            goto L_0x008f
        L_0x0084:
            java.lang.String r1 = "5"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            if (r0 == 0) goto L_0x008d
            goto L_0x008f
        L_0x008d:
            r0 = 0
            r3 = 0
        L_0x008f:
            if (r13 != 0) goto L_0x0093
        L_0x0091:
            r0 = r4
            goto L_0x009e
        L_0x0093:
            com.didi.payment.wallet.global.prepaidcard.resp.PreApplyCardResp$Data r0 = r13.getData()
            if (r0 != 0) goto L_0x009a
            goto L_0x0091
        L_0x009a:
            java.lang.String r0 = r0.getCardId()
        L_0x009e:
            if (r13 != 0) goto L_0x00a1
            goto L_0x00ac
        L_0x00a1:
            com.didi.payment.wallet.global.prepaidcard.resp.PreApplyCardResp$Data r13 = r13.getData()
            if (r13 != 0) goto L_0x00a8
            goto L_0x00ac
        L_0x00a8:
            java.lang.String r4 = r13.getLinkUrl()
        L_0x00ac:
            java.util.Map<java.lang.String, java.lang.String> r13 = r12.$params
            r13.put(r2, r0)
            goto L_0x00b4
        L_0x00b2:
            java.lang.String r4 = ""
        L_0x00b4:
            if (r3 == 0) goto L_0x00c5
            java.util.Map<java.lang.String, java.lang.String> r13 = r12.$params
            java.lang.String r0 = "pre_url"
            r13.put(r0, r4)
            com.didi.payment.wallet.global.prepaidcard.interceptor.IPrepaidInterceptor$Chain r13 = r12.$chain
            java.util.Map<java.lang.String, java.lang.String> r0 = r12.$params
            r13.proceed(r0)
            goto L_0x00ec
        L_0x00c5:
            com.didi.payment.wallet.global.prepaidcard.PrepaidCardManager$Companion r13 = com.didi.payment.wallet.global.prepaidcard.PrepaidCardManager.Companion
            java.lang.String r13 = r13.buildWalletUrl(r4)
            com.didi.drouter.router.Request r13 = com.didi.drouter.api.DRouter.build((java.lang.String) r13)
            androidx.fragment.app.FragmentActivity r0 = r12.$activity
            android.content.Context r0 = (android.content.Context) r0
            r13.start(r0)
            com.didi.payment.base.proxy.LoadingProxyHolder$ILoadingProxy r13 = com.didi.payment.base.proxy.LoadingProxyHolder.getProxy()
            if (r13 != 0) goto L_0x00dd
            goto L_0x00e0
        L_0x00dd:
            r13.dismissLoading()
        L_0x00e0:
            org.greenrobot.eventbus.EventBus r13 = org.greenrobot.eventbus.EventBus.getDefault()
            com.didi.payment.base.event.WalletRefreshDataEvent r0 = new com.didi.payment.base.event.WalletRefreshDataEvent
            r0.<init>()
            r13.post(r0)
        L_0x00ec:
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.wallet.global.prepaidcard.interceptor.IPreApplyCardInterceptor$onInterceptor$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
