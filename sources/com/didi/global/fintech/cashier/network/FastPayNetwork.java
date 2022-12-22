package com.didi.global.fintech.cashier.network;

import android.content.Context;
import com.didi.global.fintech.cashier.model.net.request.fastpay.ChangePayLimitRequest;
import com.didi.global.fintech.cashier.model.net.request.fastpay.ChangePayOrderRequest;
import com.didi.global.fintech.cashier.model.net.request.fastpay.FastPayInfoRequest;
import com.didi.global.fintech.cashier.model.net.request.fastpay.FastPayStatusRequest;
import com.didi.global.fintech.cashier.model.net.request.fastpay.FastPaySubmitQuizRequest;
import com.didi.global.fintech.cashier.model.net.response.fastpay.ChangePayLimitResponse;
import com.didi.global.fintech.cashier.model.net.response.fastpay.ChangePayOrderResponse;
import com.didi.global.fintech.cashier.model.net.response.fastpay.FastPayInfoResponse;
import com.didi.global.fintech.cashier.model.net.response.fastpay.FastPayOrderResponse;
import com.didi.global.fintech.cashier.model.net.response.fastpay.FastPayStatusResponse;
import com.didi.global.fintech.cashier.model.net.response.fastpay.FastPaySubmitQuizResponse;
import com.didi.global.fintech.cashier.network.api.FastPayApi;
import com.didi.global.fintech.cashier.network.api.FastPayApiRpcService;
import com.didi.global.fintech.cashier.network.callback.CashierNetCallback;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J4\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0013H\u0016J4\u0010\u0014\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00152\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00160\u00102\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0013H\u0016J4\u0010\u0017\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00182\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00190\u00102\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0013H\u0016J4\u0010\u001a\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00182\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00102\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0013H\u0016J4\u0010\u001c\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u001d2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00102\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u0013H\u0016J4\u0010\u001f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020 2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020!0\u00102\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020 \u0018\u00010\u0013H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006#"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/network/FastPayNetwork;", "Lcom/didi/global/fintech/cashier/network/api/FastPayApi;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "fastPayApiRpcService", "Lcom/didi/global/fintech/cashier/network/api/FastPayApiRpcService;", "getFastPayApiRpcService", "()Lcom/didi/global/fintech/cashier/network/api/FastPayApiRpcService;", "fastPayApiRpcService$delegate", "Lkotlin/Lazy;", "changePayLimit", "", "request", "Lcom/didi/global/fintech/cashier/model/net/request/fastpay/ChangePayLimitRequest;", "callback", "Lcom/didi/global/fintech/cashier/network/callback/CashierNetCallback;", "Lcom/didi/global/fintech/cashier/model/net/response/fastpay/ChangePayLimitResponse;", "processor", "Lkotlin/Function1;", "changePayOrder", "Lcom/didi/global/fintech/cashier/model/net/request/fastpay/ChangePayOrderRequest;", "Lcom/didi/global/fintech/cashier/model/net/response/fastpay/ChangePayOrderResponse;", "getFastPayInfo", "Lcom/didi/global/fintech/cashier/model/net/request/fastpay/FastPayInfoRequest;", "Lcom/didi/global/fintech/cashier/model/net/response/fastpay/FastPayInfoResponse;", "getPayOrder", "Lcom/didi/global/fintech/cashier/model/net/response/fastpay/FastPayOrderResponse;", "setFastPayStatus", "Lcom/didi/global/fintech/cashier/model/net/request/fastpay/FastPayStatusRequest;", "Lcom/didi/global/fintech/cashier/model/net/response/fastpay/FastPayStatusResponse;", "submitQuestionnaire", "Lcom/didi/global/fintech/cashier/model/net/request/fastpay/FastPaySubmitQuizRequest;", "Lcom/didi/global/fintech/cashier/model/net/response/fastpay/FastPaySubmitQuizResponse;", "Companion", "cashier_network_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FastPayNetwork.kt */
public final class FastPayNetwork implements FastPayApi {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Context f21632a;

    /* renamed from: b */
    private final Lazy f21633b;

    public /* synthetic */ FastPayNetwork(Context context, DefaultConstructorMarker defaultConstructorMarker) {
        this(context);
    }

    private FastPayNetwork(Context context) {
        this.f21632a = context;
        this.f21633b = LazyKt.lazy(new FastPayNetwork$fastPayApiRpcService$2(this));
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/network/FastPayNetwork$Companion;", "Lcom/didi/global/fintech/cashier/network/SingletonHolder;", "Lcom/didi/global/fintech/cashier/network/FastPayNetwork;", "Landroid/content/Context;", "()V", "cashier_network_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: FastPayNetwork.kt */
    public static final class Companion extends SingletonHolder<FastPayNetwork, Context> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
            super(C84801.INSTANCE);
        }
    }

    /* renamed from: a */
    private final FastPayApiRpcService m15796a() {
        Object value = this.f21633b.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-fastPayApiRpcService>(...)");
        return (FastPayApiRpcService) value;
    }

    public void getFastPayInfo(FastPayInfoRequest fastPayInfoRequest, CashierNetCallback<FastPayInfoResponse> cashierNetCallback, Function1<? super FastPayInfoRequest, FastPayInfoRequest> function1) {
        FastPayInfoRequest invoke;
        Intrinsics.checkNotNullParameter(fastPayInfoRequest, "request");
        Intrinsics.checkNotNullParameter(cashierNetCallback, "callback");
        FastPayApiRpcService a = m15796a();
        if (!(function1 == null || (invoke = function1.invoke(fastPayInfoRequest)) == null)) {
            fastPayInfoRequest = invoke;
        }
        a.getFastPayInfo(fastPayInfoRequest, new FastPayNetwork$getFastPayInfo$$inlined$getBaseResponseCallback$1(cashierNetCallback));
    }

    public void getPayOrder(FastPayInfoRequest fastPayInfoRequest, CashierNetCallback<FastPayOrderResponse> cashierNetCallback, Function1<? super FastPayInfoRequest, FastPayInfoRequest> function1) {
        FastPayInfoRequest invoke;
        Intrinsics.checkNotNullParameter(fastPayInfoRequest, "request");
        Intrinsics.checkNotNullParameter(cashierNetCallback, "callback");
        FastPayApiRpcService a = m15796a();
        if (!(function1 == null || (invoke = function1.invoke(fastPayInfoRequest)) == null)) {
            fastPayInfoRequest = invoke;
        }
        a.getPayOrder(fastPayInfoRequest, new FastPayNetwork$getPayOrder$$inlined$getBaseResponseCallback$1(cashierNetCallback));
    }

    public void changePayOrder(ChangePayOrderRequest changePayOrderRequest, CashierNetCallback<ChangePayOrderResponse> cashierNetCallback, Function1<? super ChangePayOrderRequest, ChangePayOrderRequest> function1) {
        ChangePayOrderRequest invoke;
        Intrinsics.checkNotNullParameter(changePayOrderRequest, "request");
        Intrinsics.checkNotNullParameter(cashierNetCallback, "callback");
        FastPayApiRpcService a = m15796a();
        if (!(function1 == null || (invoke = function1.invoke(changePayOrderRequest)) == null)) {
            changePayOrderRequest = invoke;
        }
        a.changePayOrder(changePayOrderRequest, new FastPayNetwork$changePayOrder$$inlined$getBaseResponseCallback$1(cashierNetCallback));
    }

    public void setFastPayStatus(FastPayStatusRequest fastPayStatusRequest, CashierNetCallback<FastPayStatusResponse> cashierNetCallback, Function1<? super FastPayStatusRequest, FastPayStatusRequest> function1) {
        FastPayStatusRequest invoke;
        Intrinsics.checkNotNullParameter(fastPayStatusRequest, "request");
        Intrinsics.checkNotNullParameter(cashierNetCallback, "callback");
        FastPayApiRpcService a = m15796a();
        if (!(function1 == null || (invoke = function1.invoke(fastPayStatusRequest)) == null)) {
            fastPayStatusRequest = invoke;
        }
        a.setFastPayStatus(fastPayStatusRequest, new C8481x4ae6c7c3(cashierNetCallback));
    }

    public void changePayLimit(ChangePayLimitRequest changePayLimitRequest, CashierNetCallback<ChangePayLimitResponse> cashierNetCallback, Function1<? super ChangePayLimitRequest, ChangePayLimitRequest> function1) {
        ChangePayLimitRequest invoke;
        Intrinsics.checkNotNullParameter(changePayLimitRequest, "request");
        Intrinsics.checkNotNullParameter(cashierNetCallback, "callback");
        FastPayApiRpcService a = m15796a();
        if (!(function1 == null || (invoke = function1.invoke(changePayLimitRequest)) == null)) {
            changePayLimitRequest = invoke;
        }
        a.changePayLimit(changePayLimitRequest, new FastPayNetwork$changePayLimit$$inlined$getBaseResponseCallback$1(cashierNetCallback));
    }

    public void submitQuestionnaire(FastPaySubmitQuizRequest fastPaySubmitQuizRequest, CashierNetCallback<FastPaySubmitQuizResponse> cashierNetCallback, Function1<? super FastPaySubmitQuizRequest, FastPaySubmitQuizRequest> function1) {
        FastPaySubmitQuizRequest invoke;
        Intrinsics.checkNotNullParameter(fastPaySubmitQuizRequest, "request");
        Intrinsics.checkNotNullParameter(cashierNetCallback, "callback");
        FastPayApiRpcService a = m15796a();
        if (!(function1 == null || (invoke = function1.invoke(fastPaySubmitQuizRequest)) == null)) {
            fastPaySubmitQuizRequest = invoke;
        }
        a.submitQuiz(fastPaySubmitQuizRequest, new C8482x8dbb6bf8(cashierNetCallback));
    }
}
