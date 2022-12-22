package com.didi.global.fintech.cashier.core.presenter;

import android.content.Context;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierBaseView;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierNetPresenter;
import com.didi.global.fintech.cashier.model.CashierError;
import com.didi.global.fintech.cashier.model.net.request.AgreePolicyRequest;
import com.didi.global.fintech.cashier.model.net.request.ChangePayInfoRequest;
import com.didi.global.fintech.cashier.model.net.request.GetCVVInfoRequest;
import com.didi.global.fintech.cashier.model.net.request.GetPayInfoRequest;
import com.didi.global.fintech.cashier.model.net.request.GetPayStatusRequest;
import com.didi.global.fintech.cashier.model.net.request.GetSuccessInfoRequest;
import com.didi.global.fintech.cashier.model.net.request.PaymentThreeDSDetailsRequest;
import com.didi.global.fintech.cashier.model.net.request.PrepayRequest;
import com.didi.global.fintech.cashier.model.net.response.AgreePolicyResponse;
import com.didi.global.fintech.cashier.model.net.response.CVVInfoResponse;
import com.didi.global.fintech.cashier.model.net.response.PayInfoResponse;
import com.didi.global.fintech.cashier.model.net.response.PayStatusResponse;
import com.didi.global.fintech.cashier.model.net.response.PaymentThreeDSDetailsResponse;
import com.didi.global.fintech.cashier.model.net.response.PrepayResponse;
import com.didi.global.fintech.cashier.model.net.response.SuccessInfoResponse;
import com.didi.global.fintech.cashier.network.CashierNetwork;
import com.didi.global.fintech.cashier.network.callback.CashierNetCallback;
import com.didi.global.fintech.cashier.network.processor.GlobalCommonParamsProcessor;
import com.didi.sdk.apm.SystemUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000Ê\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u00105\u001a\u0002062\u0006\u00107\u001a\u000208H\u0016J\u0012\u00109\u001a\u0002062\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J0\u0010<\u001a\b\u0012\u0004\u0012\u0002H=0\u0007\"\u0004\b\u0000\u0010=2\u0012\u0010>\u001a\u000e\u0012\u0004\u0012\u0002H=\u0012\u0004\u0012\u0002060?2\u0006\u0010@\u001a\u00020AH\u0002JE\u0010B\u001a\b\u0012\u0004\u0012\u0002H=0\u0007\"\u0004\b\u0000\u0010=2'\u0010>\u001a#\u0012\u0004\u0012\u0002H=\u0012\u0013\u0012\u00110A¢\u0006\f\bD\u0012\b\bE\u0012\u0004\b\b(@\u0012\u0004\u0012\u0002060C2\u0006\u0010@\u001a\u00020AH\u0002J\u0010\u0010F\u001a\u0002062\u0006\u0010G\u001a\u00020HH\u0016J\u0010\u0010I\u001a\u0002062\u0006\u00107\u001a\u00020JH\u0016J\u0010\u0010K\u001a\u0002062\u0006\u0010L\u001a\u00020MH\u0016J\u0010\u0010N\u001a\u0002062\u0006\u0010O\u001a\u00020PH\u0016J\u0010\u0010Q\u001a\u0002062\u0006\u00107\u001a\u00020RH\u0016J\u0010\u0010S\u001a\u0002062\u0006\u0010T\u001a\u00020\bH&J\u0010\u0010U\u001a\u0002062\u0006\u0010T\u001a\u00020\u0019H&J\u0018\u0010V\u001a\u0002062\u0006\u0010T\u001a\u00020\u00132\u0006\u0010@\u001a\u00020AH&J\u0010\u0010W\u001a\u0002062\u0006\u0010T\u001a\u00020&H&J\u0010\u0010X\u001a\u0002062\u0006\u0010T\u001a\u000202H&J\u0018\u0010Y\u001a\u0002062\u0006\u0010Z\u001a\u00020A2\u0006\u0010[\u001a\u00020\\H&J\u0010\u0010]\u001a\u0002062\u0006\u0010T\u001a\u00020*H&J\u0010\u0010^\u001a\u0002062\u0006\u0010T\u001a\u00020.H&J\u0010\u0010_\u001a\u0002062\u0006\u00107\u001a\u00020`H\u0016J\u0010\u0010a\u001a\u0002062\u0006\u0010a\u001a\u00020bH\u0016J\b\u0010c\u001a\u000206H\u0016R!\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001b\u0010\r\u001a\u00020\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010R!\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00078BX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\f\u001a\u0004\b\u0014\u0010\nR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R!\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u00078BX\u0002¢\u0006\f\n\u0004\b\u001b\u0010\f\u001a\u0004\b\u001a\u0010\nR!\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00130\u00078BX\u0002¢\u0006\f\n\u0004\b\u001e\u0010\f\u001a\u0004\b\u001d\u0010\nR\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R!\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u00078BX\u0002¢\u0006\f\n\u0004\b(\u0010\f\u001a\u0004\b'\u0010\nR!\u0010)\u001a\b\u0012\u0004\u0012\u00020*0\u00078BX\u0002¢\u0006\f\n\u0004\b,\u0010\f\u001a\u0004\b+\u0010\nR!\u0010-\u001a\b\u0012\u0004\u0012\u00020.0\u00078BX\u0002¢\u0006\f\n\u0004\b0\u0010\f\u001a\u0004\b/\u0010\nR!\u00101\u001a\b\u0012\u0004\u0012\u0002020\u00078BX\u0002¢\u0006\f\n\u0004\b4\u0010\f\u001a\u0004\b3\u0010\n¨\u0006d"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/core/presenter/GlobalCashierNetPresenter;", "Lcom/didi/global/fintech/cashier/core/presenter/GlobalCashierBasePresenter;", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierNetPresenter;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "agreePolicyCallback", "Lcom/didi/global/fintech/cashier/network/callback/CashierNetCallback;", "Lcom/didi/global/fintech/cashier/model/net/response/AgreePolicyResponse;", "getAgreePolicyCallback", "()Lcom/didi/global/fintech/cashier/network/callback/CashierNetCallback;", "agreePolicyCallback$delegate", "Lkotlin/Lazy;", "cashierNetwork", "Lcom/didi/global/fintech/cashier/network/CashierNetwork;", "getCashierNetwork", "()Lcom/didi/global/fintech/cashier/network/CashierNetwork;", "cashierNetwork$delegate", "changePayInfoCallback", "Lcom/didi/global/fintech/cashier/model/net/response/PayInfoResponse;", "getChangePayInfoCallback", "changePayInfoCallback$delegate", "getContext", "()Landroid/content/Context;", "cvvInfoCallback", "Lcom/didi/global/fintech/cashier/model/net/response/CVVInfoResponse;", "getCvvInfoCallback", "cvvInfoCallback$delegate", "getPayInfoCallback", "getGetPayInfoCallback", "getPayInfoCallback$delegate", "paramsProcessor", "Lcom/didi/global/fintech/cashier/network/processor/GlobalCommonParamsProcessor;", "getParamsProcessor", "()Lcom/didi/global/fintech/cashier/network/processor/GlobalCommonParamsProcessor;", "setParamsProcessor", "(Lcom/didi/global/fintech/cashier/network/processor/GlobalCommonParamsProcessor;)V", "payStatusCallback", "Lcom/didi/global/fintech/cashier/model/net/response/PayStatusResponse;", "getPayStatusCallback", "payStatusCallback$delegate", "paySuccessCallback", "Lcom/didi/global/fintech/cashier/model/net/response/SuccessInfoResponse;", "getPaySuccessCallback", "paySuccessCallback$delegate", "payment3DSCallback", "Lcom/didi/global/fintech/cashier/model/net/response/PaymentThreeDSDetailsResponse;", "getPayment3DSCallback", "payment3DSCallback$delegate", "prepayCallback", "Lcom/didi/global/fintech/cashier/model/net/response/PrepayResponse;", "getPrepayCallback", "prepayCallback$delegate", "agreePolicy", "", "request", "Lcom/didi/global/fintech/cashier/model/net/request/AgreePolicyRequest;", "bindView", "view", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierBaseView;", "callback", "T", "success", "Lkotlin/Function1;", "API", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierNetPresenter$API;", "callbackWithAction", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "changePayInfo", "changePayInfoRequest", "Lcom/didi/global/fintech/cashier/model/net/request/ChangePayInfoRequest;", "getCvvInfo", "Lcom/didi/global/fintech/cashier/model/net/request/GetCVVInfoRequest;", "getPayInfo", "getPayInfoRequest", "Lcom/didi/global/fintech/cashier/model/net/request/GetPayInfoRequest;", "getPayStatus", "getPayStatusRequest", "Lcom/didi/global/fintech/cashier/model/net/request/GetPayStatusRequest;", "getSuccessInfo", "Lcom/didi/global/fintech/cashier/model/net/request/GetSuccessInfoRequest;", "onAgreePolicyResponse", "response", "onCVVInfoResponse", "onPayInfoResponse", "onPayStatusResponse", "onPrePayResponse", "onRequestFailed", "api", "error", "Lcom/didi/global/fintech/cashier/model/CashierError;", "onSuccessInfoResponse", "onThreeDSDetailsResponse", "payment3DSDetails", "Lcom/didi/global/fintech/cashier/model/net/request/PaymentThreeDSDetailsRequest;", "prePay", "Lcom/didi/global/fintech/cashier/model/net/request/PrepayRequest;", "unBind", "cashier_core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCashierNetPresenter.kt */
public abstract class GlobalCashierNetPresenter extends GlobalCashierBasePresenter implements IGlobalCashierNetPresenter {

    /* renamed from: a */
    private final Context f21448a;

    /* renamed from: b */
    private final Lazy f21449b = LazyKt.lazy(new GlobalCashierNetPresenter$cashierNetwork$2(this));

    /* renamed from: c */
    private final Lazy f21450c = LazyKt.lazy(new GlobalCashierNetPresenter$getPayInfoCallback$2(this));

    /* renamed from: d */
    private final Lazy f21451d = LazyKt.lazy(new GlobalCashierNetPresenter$changePayInfoCallback$2(this));

    /* renamed from: e */
    private final Lazy f21452e = LazyKt.lazy(new GlobalCashierNetPresenter$prepayCallback$2(this));

    /* renamed from: f */
    private final Lazy f21453f = LazyKt.lazy(new GlobalCashierNetPresenter$payStatusCallback$2(this));

    /* renamed from: g */
    private final Lazy f21454g = LazyKt.lazy(new GlobalCashierNetPresenter$paySuccessCallback$2(this));

    /* renamed from: h */
    private final Lazy f21455h = LazyKt.lazy(new GlobalCashierNetPresenter$payment3DSCallback$2(this));

    /* renamed from: i */
    private final Lazy f21456i = LazyKt.lazy(new GlobalCashierNetPresenter$cvvInfoCallback$2(this));

    /* renamed from: j */
    private final Lazy f21457j = LazyKt.lazy(new GlobalCashierNetPresenter$agreePolicyCallback$2(this));

    /* renamed from: k */
    private GlobalCommonParamsProcessor f21458k;

    public abstract void onAgreePolicyResponse(AgreePolicyResponse agreePolicyResponse);

    public abstract void onCVVInfoResponse(CVVInfoResponse cVVInfoResponse);

    public abstract void onPayInfoResponse(PayInfoResponse payInfoResponse, IGlobalCashierNetPresenter.API api);

    public abstract void onPayStatusResponse(PayStatusResponse payStatusResponse);

    public abstract void onPrePayResponse(PrepayResponse prepayResponse);

    public abstract void onRequestFailed(IGlobalCashierNetPresenter.API api, CashierError cashierError);

    public abstract void onSuccessInfoResponse(SuccessInfoResponse successInfoResponse);

    public abstract void onThreeDSDetailsResponse(PaymentThreeDSDetailsResponse paymentThreeDSDetailsResponse);

    public GlobalCashierNetPresenter(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f21448a = context;
    }

    public final Context getContext() {
        return this.f21448a;
    }

    /* renamed from: a */
    private final CashierNetwork m15728a() {
        return (CashierNetwork) this.f21449b.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final <T> CashierNetCallback<T> m15729a(Function1<? super T, Unit> function1, IGlobalCashierNetPresenter.API api) {
        return new GlobalCashierNetPresenter$callback$1(function1, this, api);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final <T> CashierNetCallback<T> m15730a(Function2<? super T, ? super IGlobalCashierNetPresenter.API, Unit> function2, IGlobalCashierNetPresenter.API api) {
        return new GlobalCashierNetPresenter$callbackWithAction$1(function2, api, this);
    }

    /* renamed from: b */
    private final CashierNetCallback<PayInfoResponse> m15731b() {
        return (CashierNetCallback) this.f21450c.getValue();
    }

    /* renamed from: c */
    private final CashierNetCallback<PayInfoResponse> m15732c() {
        return (CashierNetCallback) this.f21451d.getValue();
    }

    /* renamed from: d */
    private final CashierNetCallback<PrepayResponse> m15733d() {
        return (CashierNetCallback) this.f21452e.getValue();
    }

    /* renamed from: e */
    private final CashierNetCallback<PayStatusResponse> m15734e() {
        return (CashierNetCallback) this.f21453f.getValue();
    }

    /* renamed from: f */
    private final CashierNetCallback<SuccessInfoResponse> m15735f() {
        return (CashierNetCallback) this.f21454g.getValue();
    }

    /* renamed from: g */
    private final CashierNetCallback<PaymentThreeDSDetailsResponse> m15736g() {
        return (CashierNetCallback) this.f21455h.getValue();
    }

    /* renamed from: h */
    private final CashierNetCallback<CVVInfoResponse> m15737h() {
        return (CashierNetCallback) this.f21456i.getValue();
    }

    /* renamed from: i */
    private final CashierNetCallback<AgreePolicyResponse> m15738i() {
        return (CashierNetCallback) this.f21457j.getValue();
    }

    /* access modifiers changed from: protected */
    public final GlobalCommonParamsProcessor getParamsProcessor() {
        return this.f21458k;
    }

    /* access modifiers changed from: protected */
    public final void setParamsProcessor(GlobalCommonParamsProcessor globalCommonParamsProcessor) {
        this.f21458k = globalCommonParamsProcessor;
    }

    public void bindView(IGlobalCashierBaseView iGlobalCashierBaseView) {
        super.bindView(iGlobalCashierBaseView);
        SystemUtils.log(4, "Arirus", "GlobalCashierNetPresenter bindView: ", (Throwable) null, "com.didi.global.fintech.cashier.core.presenter.GlobalCashierNetPresenter", 92);
    }

    public void unBind() {
        super.unBind();
        this.f21458k = null;
    }

    public void getPayInfo(GetPayInfoRequest getPayInfoRequest) {
        Intrinsics.checkNotNullParameter(getPayInfoRequest, "getPayInfoRequest");
        m15728a().getPayInfo(getPayInfoRequest, m15731b(), new GlobalCashierNetPresenter$getPayInfo$1(this));
    }

    public void changePayInfo(ChangePayInfoRequest changePayInfoRequest) {
        Intrinsics.checkNotNullParameter(changePayInfoRequest, "changePayInfoRequest");
        m15728a().changePayInfo(changePayInfoRequest, m15732c(), new GlobalCashierNetPresenter$changePayInfo$1(this));
    }

    public void prePay(PrepayRequest prepayRequest) {
        Intrinsics.checkNotNullParameter(prepayRequest, "prePay");
        m15728a().prePay(prepayRequest, m15733d(), new GlobalCashierNetPresenter$prePay$1(this));
    }

    public void getPayStatus(GetPayStatusRequest getPayStatusRequest) {
        Intrinsics.checkNotNullParameter(getPayStatusRequest, "getPayStatusRequest");
        m15728a().getPayStatus(getPayStatusRequest, m15734e(), new GlobalCashierNetPresenter$getPayStatus$1(this));
    }

    public void getSuccessInfo(GetSuccessInfoRequest getSuccessInfoRequest) {
        Intrinsics.checkNotNullParameter(getSuccessInfoRequest, "request");
        m15728a().getSuccessInfo(getSuccessInfoRequest, m15735f(), new GlobalCashierNetPresenter$getSuccessInfo$1(this));
    }

    public void payment3DSDetails(PaymentThreeDSDetailsRequest paymentThreeDSDetailsRequest) {
        Intrinsics.checkNotNullParameter(paymentThreeDSDetailsRequest, "request");
        m15728a().payment3DSDetails(paymentThreeDSDetailsRequest, m15736g(), new GlobalCashierNetPresenter$payment3DSDetails$1(this));
    }

    public void getCvvInfo(GetCVVInfoRequest getCVVInfoRequest) {
        Intrinsics.checkNotNullParameter(getCVVInfoRequest, "request");
        m15728a().getCVVInfo(getCVVInfoRequest, m15737h(), new GlobalCashierNetPresenter$getCvvInfo$1(this));
    }

    public void agreePolicy(AgreePolicyRequest agreePolicyRequest) {
        Intrinsics.checkNotNullParameter(agreePolicyRequest, "request");
        m15728a().agreePolicy(agreePolicyRequest, m15738i(), new GlobalCashierNetPresenter$agreePolicy$1(this));
    }
}
