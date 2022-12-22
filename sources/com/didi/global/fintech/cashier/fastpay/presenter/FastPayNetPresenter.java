package com.didi.global.fintech.cashier.fastpay.presenter;

import android.content.Context;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierNetPresenter;
import com.didi.global.fintech.cashier.core.presenter.GlobalCashierNetPresenter;
import com.didi.global.fintech.cashier.fastpay.contract.IFastPayNetPresenter;
import com.didi.global.fintech.cashier.model.CashierError;
import com.didi.global.fintech.cashier.model.net.request.fastpay.ChangePayLimitRequest;
import com.didi.global.fintech.cashier.model.net.request.fastpay.ChangePayOrderRequest;
import com.didi.global.fintech.cashier.model.net.request.fastpay.FastPayInfoRequest;
import com.didi.global.fintech.cashier.model.net.request.fastpay.FastPayStatusRequest;
import com.didi.global.fintech.cashier.model.net.request.fastpay.FastPaySubmitQuizRequest;
import com.didi.global.fintech.cashier.model.net.response.AgreePolicyResponse;
import com.didi.global.fintech.cashier.model.net.response.CVVInfoResponse;
import com.didi.global.fintech.cashier.model.net.response.PayInfoResponse;
import com.didi.global.fintech.cashier.model.net.response.PayStatusResponse;
import com.didi.global.fintech.cashier.model.net.response.PaymentThreeDSDetailsResponse;
import com.didi.global.fintech.cashier.model.net.response.PrepayResponse;
import com.didi.global.fintech.cashier.model.net.response.SuccessInfoResponse;
import com.didi.global.fintech.cashier.model.net.response.fastpay.ChangePayLimitResponse;
import com.didi.global.fintech.cashier.model.net.response.fastpay.ChangePayOrderResponse;
import com.didi.global.fintech.cashier.model.net.response.fastpay.FastPayInfoResponse;
import com.didi.global.fintech.cashier.model.net.response.fastpay.FastPayOrderResponse;
import com.didi.global.fintech.cashier.model.net.response.fastpay.FastPayStatusResponse;
import com.didi.global.fintech.cashier.model.net.response.fastpay.FastPaySubmitQuizResponse;
import com.didi.global.fintech.cashier.network.FastPayNetwork;
import com.didi.global.fintech.cashier.network.callback.CashierNetCallback;
import com.didichuxing.mas.sdk.quality.report.utils.Constants;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J0\u0010&\u001a\b\u0012\u0004\u0012\u0002H'0\u0007\"\u0004\b\u0000\u0010'2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u0002H'\u0012\u0004\u0012\u00020*0)2\u0006\u0010+\u001a\u00020,H\u0002J\u0010\u0010-\u001a\u00020*2\u0006\u0010.\u001a\u00020/H\u0016J\u0010\u00100\u001a\u00020*2\u0006\u0010.\u001a\u000201H\u0016J\u0010\u00102\u001a\u00020*2\u0006\u0010.\u001a\u000203H\u0016J\u0010\u00104\u001a\u00020*2\u0006\u0010.\u001a\u000203H\u0016J\u0010\u00105\u001a\u00020*2\u0006\u00106\u001a\u000207H\u0016J\u0010\u00108\u001a\u00020*2\u0006\u00106\u001a\u000209H\u0016J\u0010\u0010:\u001a\u00020*2\u0006\u00106\u001a\u00020\bH&J\u0010\u0010;\u001a\u00020*2\u0006\u00106\u001a\u00020\u000eH&J\u0010\u0010<\u001a\u00020*2\u0006\u00106\u001a\u00020\u0017H&J\u0010\u0010=\u001a\u00020*2\u0006\u00106\u001a\u00020\u001bH&J\u0010\u0010>\u001a\u00020*2\u0006\u00106\u001a\u00020\u001fH&J\u0018\u0010?\u001a\u00020*2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020CH\u0016J\u0010\u0010D\u001a\u00020*2\u0006\u00106\u001a\u00020EH\u0016J\u0010\u0010F\u001a\u00020*2\u0006\u00106\u001a\u00020GH\u0016J\u0018\u0010H\u001a\u00020*2\u0006\u0010I\u001a\u00020C2\u0006\u0010J\u001a\u00020KH\u0016J\u0018\u0010H\u001a\u00020*2\u0006\u0010I\u001a\u00020,2\u0006\u0010J\u001a\u00020KH&J\u0010\u0010L\u001a\u00020*2\u0006\u00106\u001a\u00020#H&J\u0010\u0010M\u001a\u00020*2\u0006\u0010@\u001a\u00020NH\u0016J\u0010\u0010O\u001a\u00020*2\u0006\u00106\u001a\u00020PH\u0016J\u0010\u0010Q\u001a\u00020*2\u0006\u0010.\u001a\u00020RH\u0016J\u0010\u0010S\u001a\u00020*2\u0006\u0010.\u001a\u00020TH\u0016R!\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR!\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00078BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u000f\u0010\nR\u001b\u0010\u0011\u001a\u00020\u00128BX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\f\u001a\u0004\b\u0013\u0010\u0014R!\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00078BX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\f\u001a\u0004\b\u0018\u0010\nR!\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00078BX\u0002¢\u0006\f\n\u0004\b\u001d\u0010\f\u001a\u0004\b\u001c\u0010\nR!\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00078BX\u0002¢\u0006\f\n\u0004\b!\u0010\f\u001a\u0004\b \u0010\nR!\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u00078BX\u0002¢\u0006\f\n\u0004\b%\u0010\f\u001a\u0004\b$\u0010\n¨\u0006U"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/fastpay/presenter/FastPayNetPresenter;", "Lcom/didi/global/fintech/cashier/core/presenter/GlobalCashierNetPresenter;", "Lcom/didi/global/fintech/cashier/fastpay/contract/IFastPayNetPresenter;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "changePayLimitCallback", "Lcom/didi/global/fintech/cashier/network/callback/CashierNetCallback;", "Lcom/didi/global/fintech/cashier/model/net/response/fastpay/ChangePayLimitResponse;", "getChangePayLimitCallback", "()Lcom/didi/global/fintech/cashier/network/callback/CashierNetCallback;", "changePayLimitCallback$delegate", "Lkotlin/Lazy;", "changePayOrderCallback", "Lcom/didi/global/fintech/cashier/model/net/response/fastpay/ChangePayOrderResponse;", "getChangePayOrderCallback", "changePayOrderCallback$delegate", "fastNetwork", "Lcom/didi/global/fintech/cashier/network/FastPayNetwork;", "getFastNetwork", "()Lcom/didi/global/fintech/cashier/network/FastPayNetwork;", "fastNetwork$delegate", "fastPayInfoCallback", "Lcom/didi/global/fintech/cashier/model/net/response/fastpay/FastPayInfoResponse;", "getFastPayInfoCallback", "fastPayInfoCallback$delegate", "fastPayOrderCallback", "Lcom/didi/global/fintech/cashier/model/net/response/fastpay/FastPayOrderResponse;", "getFastPayOrderCallback", "fastPayOrderCallback$delegate", "fastPayStatusCallback", "Lcom/didi/global/fintech/cashier/model/net/response/fastpay/FastPayStatusResponse;", "getFastPayStatusCallback", "fastPayStatusCallback$delegate", "submitQuizCallback", "Lcom/didi/global/fintech/cashier/model/net/response/fastpay/FastPaySubmitQuizResponse;", "getSubmitQuizCallback", "submitQuizCallback$delegate", "callback", "T", "success", "Lkotlin/Function1;", "", "API", "Lcom/didi/global/fintech/cashier/fastpay/contract/IFastPayNetPresenter$API;", "changePayLimit", "request", "Lcom/didi/global/fintech/cashier/model/net/request/fastpay/ChangePayLimitRequest;", "changePayOrder", "Lcom/didi/global/fintech/cashier/model/net/request/fastpay/ChangePayOrderRequest;", "getFastPayInfo", "Lcom/didi/global/fintech/cashier/model/net/request/fastpay/FastPayInfoRequest;", "getPayOrder", "onAgreePolicyResponse", "response", "Lcom/didi/global/fintech/cashier/model/net/response/AgreePolicyResponse;", "onCVVInfoResponse", "Lcom/didi/global/fintech/cashier/model/net/response/CVVInfoResponse;", "onChangePayLimitResponse", "onChangePayOrderResponse", "onFastPayInfoResponse", "onFastPayOrderResponse", "onFastPayStatusResponse", "onPayInfoResponse", "r", "Lcom/didi/global/fintech/cashier/model/net/response/PayInfoResponse;", "a", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierNetPresenter$API;", "onPayStatusResponse", "Lcom/didi/global/fintech/cashier/model/net/response/PayStatusResponse;", "onPrePayResponse", "Lcom/didi/global/fintech/cashier/model/net/response/PrepayResponse;", "onRequestFailed", "api", "error", "Lcom/didi/global/fintech/cashier/model/CashierError;", "onSubmitQuizResponse", "onSuccessInfoResponse", "Lcom/didi/global/fintech/cashier/model/net/response/SuccessInfoResponse;", "onThreeDSDetailsResponse", "Lcom/didi/global/fintech/cashier/model/net/response/PaymentThreeDSDetailsResponse;", "setFastPayStatus", "Lcom/didi/global/fintech/cashier/model/net/request/fastpay/FastPayStatusRequest;", "submitOffQuiz", "Lcom/didi/global/fintech/cashier/model/net/request/fastpay/FastPaySubmitQuizRequest;", "cashier_fastpay_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FastPayNetPresenter.kt */
public abstract class FastPayNetPresenter extends GlobalCashierNetPresenter implements IFastPayNetPresenter {

    /* renamed from: a */
    private final Lazy f21576a;

    /* renamed from: b */
    private final Lazy f21577b = LazyKt.lazy(new FastPayNetPresenter$fastPayInfoCallback$2(this));

    /* renamed from: c */
    private final Lazy f21578c = LazyKt.lazy(new FastPayNetPresenter$fastPayOrderCallback$2(this));

    /* renamed from: d */
    private final Lazy f21579d = LazyKt.lazy(new FastPayNetPresenter$changePayOrderCallback$2(this));

    /* renamed from: e */
    private final Lazy f21580e = LazyKt.lazy(new FastPayNetPresenter$fastPayStatusCallback$2(this));

    /* renamed from: f */
    private final Lazy f21581f = LazyKt.lazy(new FastPayNetPresenter$changePayLimitCallback$2(this));

    /* renamed from: g */
    private final Lazy f21582g = LazyKt.lazy(new FastPayNetPresenter$submitQuizCallback$2(this));

    public void onAgreePolicyResponse(AgreePolicyResponse agreePolicyResponse) {
        Intrinsics.checkNotNullParameter(agreePolicyResponse, "response");
    }

    public void onCVVInfoResponse(CVVInfoResponse cVVInfoResponse) {
        Intrinsics.checkNotNullParameter(cVVInfoResponse, "response");
    }

    public abstract void onChangePayLimitResponse(ChangePayLimitResponse changePayLimitResponse);

    public abstract void onChangePayOrderResponse(ChangePayOrderResponse changePayOrderResponse);

    public abstract void onFastPayInfoResponse(FastPayInfoResponse fastPayInfoResponse);

    public abstract void onFastPayOrderResponse(FastPayOrderResponse fastPayOrderResponse);

    public abstract void onFastPayStatusResponse(FastPayStatusResponse fastPayStatusResponse);

    public void onPayInfoResponse(PayInfoResponse payInfoResponse, IGlobalCashierNetPresenter.API api) {
        Intrinsics.checkNotNullParameter(payInfoResponse, "r");
        Intrinsics.checkNotNullParameter(api, Constants.FILE_ANR_KEY);
    }

    public void onPayStatusResponse(PayStatusResponse payStatusResponse) {
        Intrinsics.checkNotNullParameter(payStatusResponse, "response");
    }

    public void onPrePayResponse(PrepayResponse prepayResponse) {
        Intrinsics.checkNotNullParameter(prepayResponse, "response");
    }

    public void onRequestFailed(IGlobalCashierNetPresenter.API api, CashierError cashierError) {
        Intrinsics.checkNotNullParameter(api, "api");
        Intrinsics.checkNotNullParameter(cashierError, "error");
    }

    public abstract void onRequestFailed(IFastPayNetPresenter.API api, CashierError cashierError);

    public abstract void onSubmitQuizResponse(FastPaySubmitQuizResponse fastPaySubmitQuizResponse);

    public void onSuccessInfoResponse(SuccessInfoResponse successInfoResponse) {
        Intrinsics.checkNotNullParameter(successInfoResponse, "r");
    }

    public void onThreeDSDetailsResponse(PaymentThreeDSDetailsResponse paymentThreeDSDetailsResponse) {
        Intrinsics.checkNotNullParameter(paymentThreeDSDetailsResponse, "response");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastPayNetPresenter(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f21576a = LazyKt.lazy(new FastPayNetPresenter$fastNetwork$2(context));
    }

    /* renamed from: a */
    private final FastPayNetwork m15780a() {
        return (FastPayNetwork) this.f21576a.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final <T> CashierNetCallback<T> m15781a(Function1<? super T, Unit> function1, IFastPayNetPresenter.API api) {
        return new FastPayNetPresenter$callback$1(function1, this, api);
    }

    /* renamed from: b */
    private final CashierNetCallback<FastPayInfoResponse> m15782b() {
        return (CashierNetCallback) this.f21577b.getValue();
    }

    /* renamed from: c */
    private final CashierNetCallback<FastPayOrderResponse> m15783c() {
        return (CashierNetCallback) this.f21578c.getValue();
    }

    /* renamed from: d */
    private final CashierNetCallback<ChangePayOrderResponse> m15784d() {
        return (CashierNetCallback) this.f21579d.getValue();
    }

    /* renamed from: e */
    private final CashierNetCallback<FastPayStatusResponse> m15785e() {
        return (CashierNetCallback) this.f21580e.getValue();
    }

    /* renamed from: f */
    private final CashierNetCallback<ChangePayLimitResponse> m15786f() {
        return (CashierNetCallback) this.f21581f.getValue();
    }

    /* renamed from: g */
    private final CashierNetCallback<FastPaySubmitQuizResponse> m15787g() {
        return (CashierNetCallback) this.f21582g.getValue();
    }

    public void getFastPayInfo(FastPayInfoRequest fastPayInfoRequest) {
        Intrinsics.checkNotNullParameter(fastPayInfoRequest, "request");
        m15780a().getFastPayInfo(fastPayInfoRequest, m15782b(), new FastPayNetPresenter$getFastPayInfo$1(this));
    }

    public void getPayOrder(FastPayInfoRequest fastPayInfoRequest) {
        Intrinsics.checkNotNullParameter(fastPayInfoRequest, "request");
        m15780a().getPayOrder(fastPayInfoRequest, m15783c(), new FastPayNetPresenter$getPayOrder$1(this));
    }

    public void changePayOrder(ChangePayOrderRequest changePayOrderRequest) {
        Intrinsics.checkNotNullParameter(changePayOrderRequest, "request");
        m15780a().changePayOrder(changePayOrderRequest, m15784d(), new FastPayNetPresenter$changePayOrder$1(this));
    }

    public void changePayLimit(ChangePayLimitRequest changePayLimitRequest) {
        Intrinsics.checkNotNullParameter(changePayLimitRequest, "request");
        m15780a().changePayLimit(changePayLimitRequest, m15786f(), new FastPayNetPresenter$changePayLimit$1(this));
    }

    public void setFastPayStatus(FastPayStatusRequest fastPayStatusRequest) {
        Intrinsics.checkNotNullParameter(fastPayStatusRequest, "request");
        m15780a().setFastPayStatus(fastPayStatusRequest, m15785e(), new FastPayNetPresenter$setFastPayStatus$1(this));
    }

    public void submitOffQuiz(FastPaySubmitQuizRequest fastPaySubmitQuizRequest) {
        Intrinsics.checkNotNullParameter(fastPaySubmitQuizRequest, "request");
        m15780a().submitQuestionnaire(fastPaySubmitQuizRequest, m15787g(), new FastPayNetPresenter$submitOffQuiz$1(this));
    }
}
