package com.didi.global.fintech.cashier.network;

import android.content.Context;
import com.didi.global.fintech.cashier.model.net.request.AgreePolicyRequest;
import com.didi.global.fintech.cashier.model.net.request.CanChangeNewVersionRequest;
import com.didi.global.fintech.cashier.model.net.request.ChangePayInfoRequest;
import com.didi.global.fintech.cashier.model.net.request.GetCVVInfoRequest;
import com.didi.global.fintech.cashier.model.net.request.GetPayInfoRequest;
import com.didi.global.fintech.cashier.model.net.request.GetPayStatusRequest;
import com.didi.global.fintech.cashier.model.net.request.GetSuccessInfoRequest;
import com.didi.global.fintech.cashier.model.net.request.PaymentThreeDSDetailsRequest;
import com.didi.global.fintech.cashier.model.net.request.PrepayRequest;
import com.didi.global.fintech.cashier.model.net.response.AgreePolicyResponse;
import com.didi.global.fintech.cashier.model.net.response.CVVInfoResponse;
import com.didi.global.fintech.cashier.model.net.response.CanChangeNewVersionResponse;
import com.didi.global.fintech.cashier.model.net.response.PayInfoResponse;
import com.didi.global.fintech.cashier.model.net.response.PayStatusResponse;
import com.didi.global.fintech.cashier.model.net.response.PaymentThreeDSDetailsResponse;
import com.didi.global.fintech.cashier.model.net.response.PrepayResponse;
import com.didi.global.fintech.cashier.model.net.response.SuccessInfoResponse;
import com.didi.global.fintech.cashier.network.api.CashierApi;
import com.didi.global.fintech.cashier.network.api.CashierApiRpcService;
import com.didi.global.fintech.cashier.network.callback.CashierNetCallback;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 -2\u00020\u0001:\u0001-B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J4\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0013H\u0016J4\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00162\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00170\u00102\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0013H\u0016J4\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u001a2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00102\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0013H\u0016J4\u0010\u001c\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u001d2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00102\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u0013H\u0016J4\u0010\u001f\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020 2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00102\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020 \u0018\u00010\u0013H\u0016J4\u0010!\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\"2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020#0\u00102\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\"\u0018\u00010\u0013H\u0016J4\u0010$\u001a\u00020\f2\u0006\u0010\r\u001a\u00020%2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020&0\u00102\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020%\u0018\u00010\u0013H\u0016J4\u0010'\u001a\u00020\f2\u0006\u0010\r\u001a\u00020(2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020)0\u00102\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020(\u0018\u00010\u0013H\u0016J4\u0010*\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020+2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020,0\u00102\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020+\u0018\u00010\u0013H\u0016R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006."}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/network/CashierNetwork;", "Lcom/didi/global/fintech/cashier/network/api/CashierApi;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "cashierApiRpcService", "Lcom/didi/global/fintech/cashier/network/api/CashierApiRpcService;", "getCashierApiRpcService", "()Lcom/didi/global/fintech/cashier/network/api/CashierApiRpcService;", "cashierApiRpcService$delegate", "Lkotlin/Lazy;", "agreePolicy", "", "request", "Lcom/didi/global/fintech/cashier/model/net/request/AgreePolicyRequest;", "callback", "Lcom/didi/global/fintech/cashier/network/callback/CashierNetCallback;", "Lcom/didi/global/fintech/cashier/model/net/response/AgreePolicyResponse;", "processor", "Lkotlin/Function1;", "canChangeNewVersion", "canChangeNewVersionRequest", "Lcom/didi/global/fintech/cashier/model/net/request/CanChangeNewVersionRequest;", "Lcom/didi/global/fintech/cashier/model/net/response/CanChangeNewVersionResponse;", "changePayInfo", "getPayInfoRequest", "Lcom/didi/global/fintech/cashier/model/net/request/ChangePayInfoRequest;", "Lcom/didi/global/fintech/cashier/model/net/response/PayInfoResponse;", "getCVVInfo", "Lcom/didi/global/fintech/cashier/model/net/request/GetCVVInfoRequest;", "Lcom/didi/global/fintech/cashier/model/net/response/CVVInfoResponse;", "getPayInfo", "Lcom/didi/global/fintech/cashier/model/net/request/GetPayInfoRequest;", "getPayStatus", "Lcom/didi/global/fintech/cashier/model/net/request/GetPayStatusRequest;", "Lcom/didi/global/fintech/cashier/model/net/response/PayStatusResponse;", "getSuccessInfo", "Lcom/didi/global/fintech/cashier/model/net/request/GetSuccessInfoRequest;", "Lcom/didi/global/fintech/cashier/model/net/response/SuccessInfoResponse;", "payment3DSDetails", "Lcom/didi/global/fintech/cashier/model/net/request/PaymentThreeDSDetailsRequest;", "Lcom/didi/global/fintech/cashier/model/net/response/PaymentThreeDSDetailsResponse;", "prePay", "Lcom/didi/global/fintech/cashier/model/net/request/PrepayRequest;", "Lcom/didi/global/fintech/cashier/model/net/response/PrepayResponse;", "Companion", "cashier_network_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CashierNetwork.kt */
public final class CashierNetwork implements CashierApi {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Context f21630a;

    /* renamed from: b */
    private final Lazy f21631b;

    public /* synthetic */ CashierNetwork(Context context, DefaultConstructorMarker defaultConstructorMarker) {
        this(context);
    }

    private CashierNetwork(Context context) {
        this.f21630a = context;
        this.f21631b = LazyKt.lazy(new CashierNetwork$cashierApiRpcService$2(this));
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/network/CashierNetwork$Companion;", "Lcom/didi/global/fintech/cashier/network/SingletonHolder;", "Lcom/didi/global/fintech/cashier/network/CashierNetwork;", "Landroid/content/Context;", "()V", "cashier_network_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CashierNetwork.kt */
    public static final class Companion extends SingletonHolder<CashierNetwork, Context> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
            super(C84771.INSTANCE);
        }
    }

    /* renamed from: a */
    private final CashierApiRpcService m15795a() {
        Object value = this.f21631b.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-cashierApiRpcService>(...)");
        return (CashierApiRpcService) value;
    }

    public void canChangeNewVersion(CanChangeNewVersionRequest canChangeNewVersionRequest, CashierNetCallback<CanChangeNewVersionResponse> cashierNetCallback, Function1<? super CanChangeNewVersionRequest, CanChangeNewVersionRequest> function1) {
        CanChangeNewVersionRequest invoke;
        Intrinsics.checkNotNullParameter(canChangeNewVersionRequest, "canChangeNewVersionRequest");
        Intrinsics.checkNotNullParameter(cashierNetCallback, "callback");
        CashierApiRpcService a = m15795a();
        if (!(function1 == null || (invoke = function1.invoke(canChangeNewVersionRequest)) == null)) {
            canChangeNewVersionRequest = invoke;
        }
        a.canChangeNewVersion(canChangeNewVersionRequest, new C8478xb907fc42(cashierNetCallback));
    }

    public void getPayInfo(GetPayInfoRequest getPayInfoRequest, CashierNetCallback<PayInfoResponse> cashierNetCallback, Function1<? super GetPayInfoRequest, GetPayInfoRequest> function1) {
        GetPayInfoRequest invoke;
        Intrinsics.checkNotNullParameter(getPayInfoRequest, "getPayInfoRequest");
        Intrinsics.checkNotNullParameter(cashierNetCallback, "callback");
        CashierApiRpcService a = m15795a();
        if (!(function1 == null || (invoke = function1.invoke(getPayInfoRequest)) == null)) {
            getPayInfoRequest = invoke;
        }
        a.getPayInfo(getPayInfoRequest, new CashierNetwork$getPayInfo$$inlined$getBaseResponseCallback$1(cashierNetCallback));
    }

    public void changePayInfo(ChangePayInfoRequest changePayInfoRequest, CashierNetCallback<PayInfoResponse> cashierNetCallback, Function1<? super ChangePayInfoRequest, ChangePayInfoRequest> function1) {
        ChangePayInfoRequest invoke;
        Intrinsics.checkNotNullParameter(changePayInfoRequest, "getPayInfoRequest");
        Intrinsics.checkNotNullParameter(cashierNetCallback, "callback");
        CashierApiRpcService a = m15795a();
        if (!(function1 == null || (invoke = function1.invoke(changePayInfoRequest)) == null)) {
            changePayInfoRequest = invoke;
        }
        a.changePayInfo(changePayInfoRequest, new CashierNetwork$changePayInfo$$inlined$getBaseResponseCallback$1(cashierNetCallback));
    }

    public void prePay(PrepayRequest prepayRequest, CashierNetCallback<PrepayResponse> cashierNetCallback, Function1<? super PrepayRequest, PrepayRequest> function1) {
        PrepayRequest invoke;
        Intrinsics.checkNotNullParameter(prepayRequest, "getPayInfoRequest");
        Intrinsics.checkNotNullParameter(cashierNetCallback, "callback");
        CashierApiRpcService a = m15795a();
        if (!(function1 == null || (invoke = function1.invoke(prepayRequest)) == null)) {
            prepayRequest = invoke;
        }
        a.prepay(prepayRequest, new CashierNetwork$prePay$$inlined$getBaseResponseCallback$1(cashierNetCallback));
    }

    public void getPayStatus(GetPayStatusRequest getPayStatusRequest, CashierNetCallback<PayStatusResponse> cashierNetCallback, Function1<? super GetPayStatusRequest, GetPayStatusRequest> function1) {
        GetPayStatusRequest invoke;
        Intrinsics.checkNotNullParameter(getPayStatusRequest, "getPayInfoRequest");
        Intrinsics.checkNotNullParameter(cashierNetCallback, "callback");
        CashierApiRpcService a = m15795a();
        if (!(function1 == null || (invoke = function1.invoke(getPayStatusRequest)) == null)) {
            getPayStatusRequest = invoke;
        }
        a.getPayStatus(getPayStatusRequest, new CashierNetwork$getPayStatus$$inlined$getBaseResponseCallback$1(cashierNetCallback));
    }

    public void getSuccessInfo(GetSuccessInfoRequest getSuccessInfoRequest, CashierNetCallback<SuccessInfoResponse> cashierNetCallback, Function1<? super GetSuccessInfoRequest, GetSuccessInfoRequest> function1) {
        GetSuccessInfoRequest invoke;
        Intrinsics.checkNotNullParameter(getSuccessInfoRequest, "request");
        Intrinsics.checkNotNullParameter(cashierNetCallback, "callback");
        CashierApiRpcService a = m15795a();
        if (!(function1 == null || (invoke = function1.invoke(getSuccessInfoRequest)) == null)) {
            getSuccessInfoRequest = invoke;
        }
        a.getSuccessInfo(getSuccessInfoRequest, new CashierNetwork$getSuccessInfo$$inlined$getBaseResponseCallback$1(cashierNetCallback));
    }

    public void payment3DSDetails(PaymentThreeDSDetailsRequest paymentThreeDSDetailsRequest, CashierNetCallback<PaymentThreeDSDetailsResponse> cashierNetCallback, Function1<? super PaymentThreeDSDetailsRequest, PaymentThreeDSDetailsRequest> function1) {
        PaymentThreeDSDetailsRequest invoke;
        Intrinsics.checkNotNullParameter(paymentThreeDSDetailsRequest, "request");
        Intrinsics.checkNotNullParameter(cashierNetCallback, "callback");
        CashierApiRpcService a = m15795a();
        if (!(function1 == null || (invoke = function1.invoke(paymentThreeDSDetailsRequest)) == null)) {
            paymentThreeDSDetailsRequest = invoke;
        }
        a.paymentThreeDSDetails(paymentThreeDSDetailsRequest, new C8479xdccc6c34(cashierNetCallback));
    }

    public void getCVVInfo(GetCVVInfoRequest getCVVInfoRequest, CashierNetCallback<CVVInfoResponse> cashierNetCallback, Function1<? super GetCVVInfoRequest, GetCVVInfoRequest> function1) {
        GetCVVInfoRequest invoke;
        Intrinsics.checkNotNullParameter(getCVVInfoRequest, "request");
        Intrinsics.checkNotNullParameter(cashierNetCallback, "callback");
        CashierApiRpcService a = m15795a();
        if (!(function1 == null || (invoke = function1.invoke(getCVVInfoRequest)) == null)) {
            getCVVInfoRequest = invoke;
        }
        a.getCVVInfo(getCVVInfoRequest, new CashierNetwork$getCVVInfo$$inlined$getBaseResponseCallback$1(cashierNetCallback));
    }

    public void agreePolicy(AgreePolicyRequest agreePolicyRequest, CashierNetCallback<AgreePolicyResponse> cashierNetCallback, Function1<? super AgreePolicyRequest, AgreePolicyRequest> function1) {
        AgreePolicyRequest invoke;
        Intrinsics.checkNotNullParameter(agreePolicyRequest, "request");
        Intrinsics.checkNotNullParameter(cashierNetCallback, "callback");
        CashierApiRpcService a = m15795a();
        if (!(function1 == null || (invoke = function1.invoke(agreePolicyRequest)) == null)) {
            agreePolicyRequest = invoke;
        }
        a.agreePolicy(agreePolicyRequest, new CashierNetwork$agreePolicy$$inlined$getBaseResponseCallback$1(cashierNetCallback));
    }
}
