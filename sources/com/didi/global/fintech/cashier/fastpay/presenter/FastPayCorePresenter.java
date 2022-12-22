package com.didi.global.fintech.cashier.fastpay.presenter;

import android.content.Context;
import com.didi.global.fintech.cashier.core.interceptor.CashierActionInterceptor;
import com.didi.global.fintech.cashier.fastpay.api.IFastPayBaseProcessor;
import com.didi.global.fintech.cashier.fastpay.api.IFastPayDialogProcessor;
import com.didi.global.fintech.cashier.fastpay.api.IFastPayOperateProcessor;
import com.didi.global.fintech.cashier.fastpay.api.IFastPayOrderProcessor;
import com.didi.global.fintech.cashier.fastpay.api.IFastPaySettingProcessor;
import com.didi.global.fintech.cashier.fastpay.consts.FastPayStatus;
import com.didi.global.fintech.cashier.fastpay.contract.IFastPayCorePresenter;
import com.didi.global.fintech.cashier.fastpay.contract.IFastPayNetPresenter;
import com.didi.global.fintech.cashier.model.CashierError;
import com.didi.global.fintech.cashier.model.net.request.fastpay.ChangePayLimitRequest;
import com.didi.global.fintech.cashier.model.net.request.fastpay.ChangePayOrderRequest;
import com.didi.global.fintech.cashier.model.net.request.fastpay.FastPayInfoRequest;
import com.didi.global.fintech.cashier.model.net.request.fastpay.FastPayStatusRequest;
import com.didi.global.fintech.cashier.model.net.request.fastpay.FastPaySubmitQuizRequest;
import com.didi.global.fintech.cashier.model.net.response.fastpay.ChangePayLimitResponse;
import com.didi.global.fintech.cashier.model.net.response.fastpay.ChangePayOrderResponse;
import com.didi.global.fintech.cashier.model.net.response.fastpay.FastPayInfoResponse;
import com.didi.global.fintech.cashier.model.net.response.fastpay.FastPayOrderResponse;
import com.didi.global.fintech.cashier.model.net.response.fastpay.FastPaySubmitQuizResponse;
import com.didi.global.fintech.cashier.model.strategy.SyncStatusStrategy;
import com.didi.global.fintech.cashier.network.processor.GlobalCommonParamsProcessor;
import com.didi.global.fintech.cashier.p117ui.omega.CashierOmegaUtils;
import com.didi.global.fintech.cashier.user.facade.CashierFacade;
import com.didi.global.fintech.cashier.user.model.FastPayParam;
import com.didi.sdk.apm.SystemUtils;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.Constants;

@Metadata(mo175977d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0016J\u0010\u00102\u001a\u00020/2\u0006\u00100\u001a\u000203H\u0016J'\u00104\u001a\u0004\u0018\u0001H5\"\b\b\u0000\u00105*\u00020'2\f\u00106\u001a\b\u0012\u0004\u0012\u0002H50&H\u0002¢\u0006\u0002\u00107J\u0012\u00108\u001a\u00020/2\b\u00109\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010:\u001a\u00020/H\u0016J\b\u0010;\u001a\u00020/H\u0016J\u0010\u0010<\u001a\u00020/2\u0006\u0010=\u001a\u00020>H\u0016J\u0010\u0010?\u001a\u00020/2\u0006\u0010=\u001a\u00020@H\u0016J\u0010\u0010A\u001a\u00020/2\u0006\u0010=\u001a\u00020BH\u0016J\u0010\u0010C\u001a\u00020/2\u0006\u0010=\u001a\u00020DH\u0016J\u0010\u0010E\u001a\u00020/2\u0006\u0010=\u001a\u00020FH\u0016J\u0018\u0010G\u001a\u00020/2\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020KH\u0016J\u0010\u0010L\u001a\u00020/2\u0006\u0010=\u001a\u00020MH\u0016J \u0010N\u001a\u00020/2\u0006\u0010O\u001a\u00020'2\u000e\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020'0&H\u0004J\u0010\u0010P\u001a\u00020/2\u0006\u00100\u001a\u00020QH\u0016J\u0010\u0010R\u001a\u00020/2\u0006\u00100\u001a\u00020QH\u0016J\u0010\u0010S\u001a\u00020/2\u0006\u00100\u001a\u00020TH\u0016J\u0010\u0010U\u001a\u00020/2\u0006\u00100\u001a\u00020VH\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@DX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001eR\u000e\u0010\"\u001a\u00020#X.¢\u0006\u0002\n\u0000R\"\u0010$\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020'0&\u0012\u0004\u0012\u00020'0%X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010(\u001a\u00020)X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-¨\u0006W"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/fastpay/presenter/FastPayCorePresenter;", "Lcom/didi/global/fintech/cashier/fastpay/presenter/FastPayNetPresenter;", "Lcom/didi/global/fintech/cashier/fastpay/contract/IFastPayCorePresenter;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "actionInterceptor", "Lcom/didi/global/fintech/cashier/core/interceptor/CashierActionInterceptor;", "getActionInterceptor", "()Lcom/didi/global/fintech/cashier/core/interceptor/CashierActionInterceptor;", "setActionInterceptor", "(Lcom/didi/global/fintech/cashier/core/interceptor/CashierActionInterceptor;)V", "<set-?>", "Lcom/didi/global/fintech/cashier/fastpay/consts/FastPayStatus;", "curFastPayStatus", "getCurFastPayStatus", "()Lcom/didi/global/fintech/cashier/fastpay/consts/FastPayStatus;", "setCurFastPayStatus", "(Lcom/didi/global/fintech/cashier/fastpay/consts/FastPayStatus;)V", "fastPayParam", "Lcom/didi/global/fintech/cashier/user/model/FastPayParam;", "getFastPayParam", "()Lcom/didi/global/fintech/cashier/user/model/FastPayParam;", "setFastPayParam", "(Lcom/didi/global/fintech/cashier/user/model/FastPayParam;)V", "mAppId", "", "getMAppId", "()Ljava/lang/String;", "setMAppId", "(Ljava/lang/String;)V", "mProductId", "getMProductId", "setMProductId", "mSyncStatusStrategy", "Lcom/didi/global/fintech/cashier/model/strategy/SyncStatusStrategy;", "processors", "", "Ljava/lang/Class;", "Lcom/didi/global/fintech/cashier/fastpay/api/IFastPayBaseProcessor;", "refreshed", "", "getRefreshed", "()Z", "setRefreshed", "(Z)V", "changeFastPayLimit", "", "request", "Lcom/didi/global/fintech/cashier/model/net/request/fastpay/ChangePayLimitRequest;", "changeFastPayOrder", "Lcom/didi/global/fintech/cashier/model/net/request/fastpay/ChangePayOrderRequest;", "getProcessor", "T", "clazz", "(Ljava/lang/Class;)Lcom/didi/global/fintech/cashier/fastpay/api/IFastPayBaseProcessor;", "init", "param", "initNet", "onBind", "onChangePayLimitResponse", "response", "Lcom/didi/global/fintech/cashier/model/net/response/fastpay/ChangePayLimitResponse;", "onChangePayOrderResponse", "Lcom/didi/global/fintech/cashier/model/net/response/fastpay/ChangePayOrderResponse;", "onFastPayInfoResponse", "Lcom/didi/global/fintech/cashier/model/net/response/fastpay/FastPayInfoResponse;", "onFastPayOrderResponse", "Lcom/didi/global/fintech/cashier/model/net/response/fastpay/FastPayOrderResponse;", "onFastPayStatusResponse", "Lcom/didi/global/fintech/cashier/model/net/response/fastpay/FastPayStatusResponse;", "onRequestFailed", "api", "Lcom/didi/global/fintech/cashier/fastpay/contract/IFastPayNetPresenter$API;", "error", "Lcom/didi/global/fintech/cashier/model/CashierError;", "onSubmitQuizResponse", "Lcom/didi/global/fintech/cashier/model/net/response/fastpay/FastPaySubmitQuizResponse;", "registerProcessor", "processor", "requestFastPayInfo", "Lcom/didi/global/fintech/cashier/model/net/request/fastpay/FastPayInfoRequest;", "requestFastPayOrder", "submitQuestionnaire", "Lcom/didi/global/fintech/cashier/model/net/request/fastpay/FastPaySubmitQuizRequest;", "switchFastPayStatus", "Lcom/didi/global/fintech/cashier/model/net/request/fastpay/FastPayStatusRequest;", "cashier_fastpay_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FastPayCorePresenter.kt */
public abstract class FastPayCorePresenter extends FastPayNetPresenter implements IFastPayCorePresenter {

    /* renamed from: a */
    private SyncStatusStrategy f21568a;

    /* renamed from: b */
    private CashierActionInterceptor f21569b;

    /* renamed from: c */
    private FastPayParam f21570c;

    /* renamed from: d */
    private boolean f21571d;

    /* renamed from: e */
    private String f21572e;

    /* renamed from: f */
    private String f21573f;

    /* renamed from: g */
    private volatile FastPayStatus f21574g = FastPayStatus.UNKNOWN;

    /* renamed from: h */
    private Map<Class<? extends IFastPayBaseProcessor>, IFastPayBaseProcessor> f21575h = new LinkedHashMap();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastPayCorePresenter(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* access modifiers changed from: protected */
    public final CashierActionInterceptor getActionInterceptor() {
        return this.f21569b;
    }

    /* access modifiers changed from: protected */
    public final void setActionInterceptor(CashierActionInterceptor cashierActionInterceptor) {
        this.f21569b = cashierActionInterceptor;
    }

    /* access modifiers changed from: protected */
    public final FastPayParam getFastPayParam() {
        return this.f21570c;
    }

    /* access modifiers changed from: protected */
    public final void setFastPayParam(FastPayParam fastPayParam) {
        this.f21570c = fastPayParam;
    }

    /* access modifiers changed from: protected */
    public final boolean getRefreshed() {
        return this.f21571d;
    }

    /* access modifiers changed from: protected */
    public final void setRefreshed(boolean z) {
        this.f21571d = z;
    }

    /* access modifiers changed from: protected */
    public final String getMProductId() {
        return this.f21572e;
    }

    /* access modifiers changed from: protected */
    public final void setMProductId(String str) {
        this.f21572e = str;
    }

    /* access modifiers changed from: protected */
    public final String getMAppId() {
        return this.f21573f;
    }

    /* access modifiers changed from: protected */
    public final void setMAppId(String str) {
        this.f21573f = str;
    }

    /* access modifiers changed from: protected */
    public final FastPayStatus getCurFastPayStatus() {
        return this.f21574g;
    }

    /* access modifiers changed from: protected */
    public final synchronized void setCurFastPayStatus(FastPayStatus fastPayStatus) {
        Intrinsics.checkNotNullParameter(fastPayStatus, "<set-?>");
        this.f21574g = fastPayStatus;
    }

    /* access modifiers changed from: protected */
    public final void registerProcessor(IFastPayBaseProcessor iFastPayBaseProcessor, Class<? extends IFastPayBaseProcessor> cls) {
        Intrinsics.checkNotNullParameter(iFastPayBaseProcessor, Constants.BUNDLE_NATIVECODE_PROCESSOR);
        Intrinsics.checkNotNullParameter(cls, "clazz");
        this.f21575h.put(cls, iFastPayBaseProcessor);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final <T extends IFastPayBaseProcessor> T m15779a(Class<T> cls) {
        T t = this.f21575h.get(cls);
        if (t instanceof IFastPayBaseProcessor) {
            return (IFastPayBaseProcessor) t;
        }
        return null;
    }

    public void onBind() {
        this.f21569b = new CashierActionInterceptor((String) null, 1, (DefaultConstructorMarker) null);
    }

    public void init(FastPayParam fastPayParam) {
        initNet();
        this.f21570c = fastPayParam;
        CashierOmegaUtils.Companion.setUid(CashierFacade.Companion.getInstance().getInitConfig().getUid());
    }

    public void initNet() {
        setParamsProcessor(new GlobalCommonParamsProcessor("", "NATIVE"));
    }

    public void requestFastPayInfo(FastPayInfoRequest fastPayInfoRequest) {
        Intrinsics.checkNotNullParameter(fastPayInfoRequest, "request");
        getFastPayInfo(fastPayInfoRequest);
        IFastPayOperateProcessor iFastPayOperateProcessor = (IFastPayOperateProcessor) m15779a(IFastPayOperateProcessor.class);
        if (iFastPayOperateProcessor != null) {
            IFastPayOperateProcessor.DefaultImpls.loading$default(iFastPayOperateProcessor, true, 0, 2, (Object) null);
        }
    }

    public void requestFastPayOrder(FastPayInfoRequest fastPayInfoRequest) {
        Intrinsics.checkNotNullParameter(fastPayInfoRequest, "request");
        getPayOrder(fastPayInfoRequest);
        IFastPayOperateProcessor iFastPayOperateProcessor = (IFastPayOperateProcessor) m15779a(IFastPayOperateProcessor.class);
        if (iFastPayOperateProcessor != null) {
            IFastPayOperateProcessor.DefaultImpls.loading$default(iFastPayOperateProcessor, true, 0, 2, (Object) null);
        }
    }

    public void changeFastPayOrder(ChangePayOrderRequest changePayOrderRequest) {
        Intrinsics.checkNotNullParameter(changePayOrderRequest, "request");
        changePayOrder(changePayOrderRequest);
        IFastPayOperateProcessor iFastPayOperateProcessor = (IFastPayOperateProcessor) m15779a(IFastPayOperateProcessor.class);
        if (iFastPayOperateProcessor != null) {
            IFastPayOperateProcessor.DefaultImpls.loading$default(iFastPayOperateProcessor, true, 0, 2, (Object) null);
        }
    }

    public void changeFastPayLimit(ChangePayLimitRequest changePayLimitRequest) {
        Intrinsics.checkNotNullParameter(changePayLimitRequest, "request");
        changePayLimit(changePayLimitRequest);
        IFastPayOperateProcessor iFastPayOperateProcessor = (IFastPayOperateProcessor) m15779a(IFastPayOperateProcessor.class);
        if (iFastPayOperateProcessor != null) {
            IFastPayOperateProcessor.DefaultImpls.loading$default(iFastPayOperateProcessor, true, 0, 2, (Object) null);
        }
    }

    public void switchFastPayStatus(FastPayStatusRequest fastPayStatusRequest) {
        Intrinsics.checkNotNullParameter(fastPayStatusRequest, "request");
        setFastPayStatus(fastPayStatusRequest);
        IFastPayOperateProcessor iFastPayOperateProcessor = (IFastPayOperateProcessor) m15779a(IFastPayOperateProcessor.class);
        if (iFastPayOperateProcessor != null) {
            IFastPayOperateProcessor.DefaultImpls.loading$default(iFastPayOperateProcessor, true, 0, 2, (Object) null);
        }
    }

    public void submitQuestionnaire(FastPaySubmitQuizRequest fastPaySubmitQuizRequest) {
        Intrinsics.checkNotNullParameter(fastPaySubmitQuizRequest, "request");
        FastPayCorePresenter fastPayCorePresenter = this;
        List<String> answer_id_list = fastPaySubmitQuizRequest.getAnswer_id_list();
        boolean z = true;
        if (answer_id_list == null || !answer_id_list.isEmpty()) {
            z = false;
        }
        if ((z ? this : null) == null) {
            submitOffQuiz(fastPaySubmitQuizRequest);
            IFastPayOperateProcessor iFastPayOperateProcessor = (IFastPayOperateProcessor) m15779a(IFastPayOperateProcessor.class);
            if (iFastPayOperateProcessor != null) {
                IFastPayOperateProcessor.DefaultImpls.loading$default(iFastPayOperateProcessor, true, 0, 2, (Object) null);
            }
        }
    }

    public void onFastPayInfoResponse(FastPayInfoResponse fastPayInfoResponse) {
        Intrinsics.checkNotNullParameter(fastPayInfoResponse, "response");
        this.f21574g = FastPayStatus.Companion.value(fastPayInfoResponse.getSwitchStatus());
        IFastPayOperateProcessor iFastPayOperateProcessor = (IFastPayOperateProcessor) m15779a(IFastPayOperateProcessor.class);
        if (iFastPayOperateProcessor != null) {
            iFastPayOperateProcessor.dismissLoading();
        }
        IFastPaySettingProcessor iFastPaySettingProcessor = (IFastPaySettingProcessor) m15779a(IFastPaySettingProcessor.class);
        if (iFastPaySettingProcessor != null) {
            iFastPaySettingProcessor.onPayInfoSuccess(fastPayInfoResponse);
        }
    }

    public void onFastPayOrderResponse(FastPayOrderResponse fastPayOrderResponse) {
        Intrinsics.checkNotNullParameter(fastPayOrderResponse, "response");
        IFastPayOperateProcessor iFastPayOperateProcessor = (IFastPayOperateProcessor) m15779a(IFastPayOperateProcessor.class);
        if (iFastPayOperateProcessor != null) {
            iFastPayOperateProcessor.dismissLoading();
        }
        IFastPayOrderProcessor iFastPayOrderProcessor = (IFastPayOrderProcessor) m15779a(IFastPayOrderProcessor.class);
        if (iFastPayOrderProcessor != null) {
            iFastPayOrderProcessor.onPayOrderSuccess(fastPayOrderResponse);
        }
    }

    public void onChangePayOrderResponse(ChangePayOrderResponse changePayOrderResponse) {
        Intrinsics.checkNotNullParameter(changePayOrderResponse, "response");
        this.f21571d = true;
        IFastPayOperateProcessor iFastPayOperateProcessor = (IFastPayOperateProcessor) m15779a(IFastPayOperateProcessor.class);
        if (iFastPayOperateProcessor != null) {
            iFastPayOperateProcessor.dismissLoading();
        }
        IFastPayOrderProcessor iFastPayOrderProcessor = (IFastPayOrderProcessor) m15779a(IFastPayOrderProcessor.class);
        if (iFastPayOrderProcessor != null) {
            iFastPayOrderProcessor.onChangeOrderChangeSuccess(changePayOrderResponse);
        }
    }

    public void onChangePayLimitResponse(ChangePayLimitResponse changePayLimitResponse) {
        IFastPayOperateProcessor iFastPayOperateProcessor;
        Intrinsics.checkNotNullParameter(changePayLimitResponse, "response");
        String toast = changePayLimitResponse.getToast();
        if (!(toast == null || (iFastPayOperateProcessor = (IFastPayOperateProcessor) m15779a(IFastPayOperateProcessor.class)) == null)) {
            IFastPayOperateProcessor.DefaultImpls.toast$default(iFastPayOperateProcessor, toast, false, 2, (Object) null);
        }
        CashierActionInterceptor cashierActionInterceptor = this.f21569b;
        if (cashierActionInterceptor != null) {
            cashierActionInterceptor.intercept(getContext(), changePayLimitResponse.getNextStep(), (Function0<Unit>[]) new Function0[]{new FastPayCorePresenter$onChangePayLimitResponse$2(this), new FastPayCorePresenter$onChangePayLimitResponse$3(this, changePayLimitResponse)});
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onFastPayStatusResponse(com.didi.global.fintech.cashier.model.net.response.fastpay.FastPayStatusResponse r8) {
        /*
            r7 = this;
            java.lang.String r0 = "response"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            r0 = r7
            com.didi.global.fintech.cashier.fastpay.presenter.FastPayCorePresenter r0 = (com.didi.global.fintech.cashier.fastpay.presenter.FastPayCorePresenter) r0
            java.lang.String r0 = r8.getSwitchStatus()
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x0013
        L_0x0011:
            r0 = 0
            goto L_0x0021
        L_0x0013:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            if (r0 <= 0) goto L_0x001d
            r0 = 1
            goto L_0x001e
        L_0x001d:
            r0 = 0
        L_0x001e:
            if (r0 != r2) goto L_0x0011
            r0 = 1
        L_0x0021:
            if (r0 == 0) goto L_0x0025
            r0 = r7
            goto L_0x0026
        L_0x0025:
            r0 = 0
        L_0x0026:
            com.didi.global.fintech.cashier.fastpay.presenter.FastPayCorePresenter r0 = (com.didi.global.fintech.cashier.fastpay.presenter.FastPayCorePresenter) r0
            if (r0 != 0) goto L_0x002b
            goto L_0x003b
        L_0x002b:
            r7.setRefreshed(r2)
            com.didi.global.fintech.cashier.fastpay.consts.FastPayStatus$Companion r0 = com.didi.global.fintech.cashier.fastpay.consts.FastPayStatus.Companion
            java.lang.String r3 = r8.getSwitchStatus()
            com.didi.global.fintech.cashier.fastpay.consts.FastPayStatus r0 = r0.value(r3)
            r7.setCurFastPayStatus(r0)
        L_0x003b:
            java.lang.String r0 = r8.getToast()
            java.lang.Class<com.didi.global.fintech.cashier.fastpay.api.IFastPayOperateProcessor> r0 = com.didi.global.fintech.cashier.fastpay.api.IFastPayOperateProcessor.class
            com.didi.global.fintech.cashier.fastpay.api.IFastPayBaseProcessor r0 = r7.m15779a(r0)
            com.didi.global.fintech.cashier.fastpay.api.IFastPayOperateProcessor r0 = (com.didi.global.fintech.cashier.fastpay.api.IFastPayOperateProcessor) r0
            if (r0 != 0) goto L_0x004a
            goto L_0x004d
        L_0x004a:
            r0.dismissLoading()
        L_0x004d:
            com.didi.global.fintech.cashier.core.interceptor.CashierActionInterceptor r0 = r7.f21569b
            if (r0 != 0) goto L_0x0052
            goto L_0x0072
        L_0x0052:
            android.content.Context r3 = r7.getContext()
            com.didi.global.fintech.cashier.model.net.request.CashierAction r4 = r8.getNextStep()
            r5 = 2
            kotlin.jvm.functions.Function0[] r5 = new kotlin.jvm.functions.Function0[r5]
            com.didi.global.fintech.cashier.fastpay.presenter.FastPayCorePresenter$onFastPayStatusResponse$4 r6 = new com.didi.global.fintech.cashier.fastpay.presenter.FastPayCorePresenter$onFastPayStatusResponse$4
            r6.<init>(r7)
            kotlin.jvm.functions.Function0 r6 = (kotlin.jvm.functions.Function0) r6
            r5[r1] = r6
            com.didi.global.fintech.cashier.fastpay.presenter.FastPayCorePresenter$onFastPayStatusResponse$5 r1 = new com.didi.global.fintech.cashier.fastpay.presenter.FastPayCorePresenter$onFastPayStatusResponse$5
            r1.<init>(r7, r8)
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
            r5[r2] = r1
            r0.intercept((android.content.Context) r3, (com.didi.global.fintech.cashier.model.net.request.CashierAction) r4, (kotlin.jvm.functions.Function0<kotlin.Unit>[]) r5)
        L_0x0072:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.fintech.cashier.fastpay.presenter.FastPayCorePresenter.onFastPayStatusResponse(com.didi.global.fintech.cashier.model.net.response.fastpay.FastPayStatusResponse):void");
    }

    public void onSubmitQuizResponse(FastPaySubmitQuizResponse fastPaySubmitQuizResponse) {
        Intrinsics.checkNotNullParameter(fastPaySubmitQuizResponse, "response");
        IFastPayOperateProcessor iFastPayOperateProcessor = (IFastPayOperateProcessor) m15779a(IFastPayOperateProcessor.class);
        if (iFastPayOperateProcessor != null) {
            iFastPayOperateProcessor.dismissLoading();
        }
    }

    public void onRequestFailed(IFastPayNetPresenter.API api, CashierError cashierError) {
        Intrinsics.checkNotNullParameter(api, "api");
        Intrinsics.checkNotNullParameter(cashierError, "error");
        IFastPayOperateProcessor iFastPayOperateProcessor = (IFastPayOperateProcessor) m15779a(IFastPayOperateProcessor.class);
        if (iFastPayOperateProcessor != null) {
            iFastPayOperateProcessor.dismissLoading();
        }
        IFastPayDialogProcessor iFastPayDialogProcessor = (IFastPayDialogProcessor) m15779a(IFastPayDialogProcessor.class);
        if (iFastPayDialogProcessor != null) {
            iFastPayDialogProcessor.netError(CashierError.Companion.getNET_ERROR(), api);
        }
        SystemUtils.log(4, "Arirus", "onRequestFailed: " + api + " 请求失败", (Throwable) null, "com.didi.global.fintech.cashier.fastpay.presenter.FastPayCorePresenter", 172);
    }
}
