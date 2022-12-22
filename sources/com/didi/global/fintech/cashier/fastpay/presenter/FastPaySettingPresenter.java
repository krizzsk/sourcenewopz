package com.didi.global.fintech.cashier.fastpay.presenter;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.didi.component.comp_xpanel.XPanelScene;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierBaseView;
import com.didi.global.fintech.cashier.core.interceptor.CashierActionInterceptor;
import com.didi.global.fintech.cashier.fastpay.api.IFastPayBaseProcessor;
import com.didi.global.fintech.cashier.fastpay.api.IFastPayOperateProcessor;
import com.didi.global.fintech.cashier.fastpay.api.IFastPaySettingProcessor;
import com.didi.global.fintech.cashier.fastpay.consts.FastPayStatus;
import com.didi.global.fintech.cashier.fastpay.contract.IFastPayBaseViewBinder;
import com.didi.global.fintech.cashier.fastpay.contract.IFastPayCallback;
import com.didi.global.fintech.cashier.fastpay.contract.IFastPaySettingPresenter;
import com.didi.global.fintech.cashier.fastpay.contract.IFastPaySettingView;
import com.didi.global.fintech.cashier.fastpay.dialog.FastPayLimitDrawer;
import com.didi.global.fintech.cashier.fastpay.dialog.FastPayLimitItemData;
import com.didi.global.fintech.cashier.fastpay.dialog.FastPayQuestionnaireDrawer;
import com.didi.global.fintech.cashier.fastpay.omega.FastPayOmegaConstants;
import com.didi.global.fintech.cashier.fastpay.viewbinder.setting.FastPaySettingBtnVB;
import com.didi.global.fintech.cashier.fastpay.viewbinder.setting.FastPaySettingContentVB;
import com.didi.global.fintech.cashier.fastpay.viewbinder.setting.FastPaySettingHeaderVB;
import com.didi.global.fintech.cashier.model.net.request.CashierAction;
import com.didi.global.fintech.cashier.model.net.request.fastpay.ChangePayLimitRequest;
import com.didi.global.fintech.cashier.model.net.request.fastpay.FastPayInfoRequest;
import com.didi.global.fintech.cashier.model.net.request.fastpay.FastPayStatusRequest;
import com.didi.global.fintech.cashier.model.net.request.fastpay.FastPaySubmitQuizRequest;
import com.didi.global.fintech.cashier.model.net.response.fastpay.ChangePayLimitResponse;
import com.didi.global.fintech.cashier.model.net.response.fastpay.FastPayInfoResponse;
import com.didi.global.fintech.cashier.model.net.response.fastpay.FastPayLimit;
import com.didi.global.fintech.cashier.model.net.response.fastpay.FastPayLimitItem;
import com.didi.global.fintech.cashier.model.net.response.fastpay.FastPayStatusResponse;
import com.didi.global.fintech.cashier.model.net.response.fastpay.Questionnaire;
import com.didi.global.fintech.cashier.p117ui.IFastPayMainBtnViewHolder;
import com.didi.global.fintech.cashier.p117ui.omega.CashierOmegaUtils;
import com.didi.global.fintech.cashier.user.facade.FastPayFacade;
import com.didi.global.fintech.cashier.user.model.FastPayParam;
import com.didi.global.globalgenerickit.eventtracker.Const;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\n\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0015H\u0016J\b\u0010\u0019\u001a\u00020\u0015H\u0016J\u0010\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0018\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u0011H\u0016J\u0010\u0010 \u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u0011H\u0016J\u0010\u0010#\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u0002H\u0016J\u0012\u0010$\u001a\u00020\u00152\b\u0010%\u001a\u0004\u0018\u00010\u0011H\u0016J&\u0010&\u001a\u00020\u00152\f\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u0011H\u0016J\b\u0010-\u001a\u00020\u0015H\u0016J\u0012\u0010.\u001a\u00020\u00152\b\u0010/\u001a\u0004\u0018\u00010\u0011H\u0016J\"\u00100\u001a\u00020\u00152\b\u00101\u001a\u0004\u0018\u00010\u00112\u000e\u00102\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010(H\u0016J\b\u00103\u001a\u00020\u0015H\u0016J\u0010\u00104\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u000205H\u0016J\u0012\u00106\u001a\u00020\u00152\b\u00107\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u00108\u001a\u00020\u0015H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000¨\u00069"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/fastpay/presenter/FastPaySettingPresenter;", "Lcom/didi/global/fintech/cashier/fastpay/presenter/FastPayBasePresenter;", "Lcom/didi/global/fintech/cashier/model/net/response/fastpay/FastPayInfoResponse;", "Lcom/didi/global/fintech/cashier/fastpay/api/IFastPaySettingProcessor;", "Lcom/didi/global/fintech/cashier/fastpay/contract/IFastPaySettingPresenter;", "context", "Landroid/content/Context;", "callback", "Lcom/didi/global/fintech/cashier/fastpay/contract/IFastPayCallback;", "(Landroid/content/Context;Lcom/didi/global/fintech/cashier/fastpay/contract/IFastPayCallback;)V", "interpretedType", "Lcom/didi/global/fintech/cashier/fastpay/api/IFastPaySettingProcessor$PasswordInterpreted;", "getInterpretedType", "()Lcom/didi/global/fintech/cashier/fastpay/api/IFastPaySettingProcessor$PasswordInterpreted;", "setInterpretedType", "(Lcom/didi/global/fintech/cashier/fastpay/api/IFastPaySettingProcessor$PasswordInterpreted;)V", "toAmount", "", "IView", "Lcom/didi/global/fintech/cashier/fastpay/contract/IFastPaySettingView;", "bindView", "", "view", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierBaseView;", "onBackPressed", "onBind", "onChangeLimitChangeSuccess", "response", "Lcom/didi/global/fintech/cashier/model/net/response/fastpay/ChangePayLimitResponse;", "onPasswordFailed", "status", "desc", "onPasswordInterpreted", "onPasswordSuccess", "token", "onPayInfoSuccess", "onPayLimitBack", "amount", "onPayLimitClick", "items", "", "Lcom/didi/global/fintech/cashier/fastpay/dialog/FastPayLimitItemData;", "selectIndex", "", "confirm", "onPayOrderBack", "onPayOrderClick", "title", "onQuizBack", "question", "answers", "onStatusBtnClick", "onSwitchFastPayStatusSuccess", "Lcom/didi/global/fintech/cashier/model/net/response/fastpay/FastPayStatusResponse;", "onTermUrlClick", "url", "unBind", "cashier_fastpay_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FastPaySettingPresenter.kt */
public final class FastPaySettingPresenter extends FastPayBasePresenter<FastPayInfoResponse> implements IFastPaySettingProcessor, IFastPaySettingPresenter {

    /* renamed from: a */
    private final IFastPayCallback f21585a;

    /* renamed from: b */
    private String f21586b;
    public IFastPaySettingProcessor.PasswordInterpreted interpretedType;

    @Metadata(mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: FastPaySettingPresenter.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[IFastPaySettingProcessor.PasswordInterpreted.values().length];
            iArr[IFastPaySettingProcessor.PasswordInterpreted.TYPE_LIMIT.ordinal()] = 1;
            iArr[IFastPaySettingProcessor.PasswordInterpreted.TYPE_SWITCH.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public void onPasswordFailed(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "status");
        Intrinsics.checkNotNullParameter(str2, "desc");
    }

    public void onPayOrderBack() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastPaySettingPresenter(Context context, IFastPayCallback iFastPayCallback) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(iFastPayCallback, "callback");
        this.f21585a = iFastPayCallback;
    }

    public final IFastPaySettingProcessor.PasswordInterpreted getInterpretedType() {
        IFastPaySettingProcessor.PasswordInterpreted passwordInterpreted = this.interpretedType;
        if (passwordInterpreted != null) {
            return passwordInterpreted;
        }
        Intrinsics.throwUninitializedPropertyAccessException("interpretedType");
        return null;
    }

    public final void setInterpretedType(IFastPaySettingProcessor.PasswordInterpreted passwordInterpreted) {
        Intrinsics.checkNotNullParameter(passwordInterpreted, "<set-?>");
        this.interpretedType = passwordInterpreted;
    }

    public void bindView(IGlobalCashierBaseView iGlobalCashierBaseView) {
        super.bindView(iGlobalCashierBaseView);
        IFastPaySettingPresenter iFastPaySettingPresenter = this;
        FastPaySettingHeaderVB fastPaySettingHeaderVB = new FastPaySettingHeaderVB(iFastPaySettingPresenter);
        IFastPaySettingView IView = IView();
        IFastPayMainBtnViewHolder iFastPayMainBtnViewHolder = null;
        fastPaySettingHeaderVB.viewBind(IView == null ? null : IView.headerView());
        FastPaySettingContentVB fastPaySettingContentVB = new FastPaySettingContentVB(iFastPaySettingPresenter);
        IFastPaySettingView IView2 = IView();
        fastPaySettingContentVB.viewBind(IView2 == null ? null : IView2.contentView());
        FastPaySettingBtnVB fastPaySettingBtnVB = new FastPaySettingBtnVB(iFastPaySettingPresenter);
        IFastPaySettingView IView3 = IView();
        if (IView3 != null) {
            iFastPayMainBtnViewHolder = IView3.payBtnView();
        }
        fastPaySettingBtnVB.viewBind(iFastPayMainBtnViewHolder);
    }

    public void onBind() {
        super.onBind();
        IFastPayBaseProcessor iFastPayBaseProcessor = this;
        registerProcessor(iFastPayBaseProcessor, IFastPaySettingProcessor.class);
        registerProcessor(iFastPayBaseProcessor, IFastPayOperateProcessor.class);
        String str = null;
        FastPayInfoRequest fastPayInfoRequest = new FastPayInfoRequest((String) null, 1, (DefaultConstructorMarker) null);
        FastPayParam fastPayParam = getFastPayParam();
        if (fastPayParam != null) {
            str = fastPayParam.getProductId();
        }
        fastPayInfoRequest.setProduct_id(str);
        Unit unit = Unit.INSTANCE;
        requestFastPayInfo(fastPayInfoRequest);
    }

    public void onPayOrderClick(String str) {
        FastPayFacade instance = FastPayFacade.Companion.getInstance();
        Activity activity = (Activity) getContext();
        FastPayParam fastPayParam = new FastPayParam((String) null, (String) null, (String) null, (Map) null, 15, (DefaultConstructorMarker) null);
        FastPayParam fastPayParam2 = getFastPayParam();
        fastPayParam.setProductId(fastPayParam2 == null ? null : fastPayParam2.getProductId());
        fastPayParam.setOrderPageTitle(str);
        Unit unit = Unit.INSTANCE;
        instance.order(activity, 413, fastPayParam);
        CashierOmegaUtils.Companion.trackEvent(FastPayOmegaConstants.EVENT_SETTING_ORDER_CK);
    }

    public void onPayLimitClick(List<FastPayLimitItemData> list, int i, String str) {
        Intrinsics.checkNotNullParameter(list, FirebaseAnalytics.Param.ITEMS);
        Intrinsics.checkNotNullParameter(str, XPanelScene.SCENE_CONFIRM);
        FastPayLimitDrawer newInstance = FastPayLimitDrawer.Companion.newInstance(new FastPaySettingPresenter$onPayLimitClick$drawer$1(this));
        List arrayList = new ArrayList();
        arrayList.addAll(list);
        Unit unit = Unit.INSTANCE;
        newInstance.setData(arrayList);
        newInstance.setCurSelect(i);
        newInstance.setBtn(str);
        FragmentManager supportFragmentManager = ((FragmentActivity) getContext()).getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "context as FragmentActiv…y).supportFragmentManager");
        newInstance.show(supportFragmentManager, Const.DRAWER);
        CashierOmegaUtils.Companion.trackEvent(FastPayOmegaConstants.EVENT_SETTING_LIMIT_CK);
    }

    public void onStatusBtnClick() {
        FastPayStatusRequest fastPayStatusRequest = new FastPayStatusRequest((String) null, (String) null, 3, (DefaultConstructorMarker) null);
        fastPayStatusRequest.setPilot_switch(getCurFastPayStatus().opposite());
        Unit unit = Unit.INSTANCE;
        switchFastPayStatus(fastPayStatusRequest);
        new CashierOmegaUtils(FastPayOmegaConstants.EVENT_SETTING_CONFIRM_CK).addParam("switch", getCurFastPayStatus().opposite()).send();
    }

    public void onBackPressed() {
        this.f21585a.onClose(getRefreshed(), getCurFastPayStatus());
    }

    public void onTermUrlClick(String str) {
        CashierActionInterceptor actionInterceptor = getActionInterceptor();
        if (actionInterceptor != null) {
            actionInterceptor.intercept(getContext(), CashierAction.Companion.insOpenUrl(str), (Function0<Unit>[]) new Function0[0]);
        }
        CashierOmegaUtils.Companion.trackEvent(FastPayOmegaConstants.EVENT_SETTING_TC_CK);
    }

    public void onPayLimitBack(String str) {
        this.f21586b = str;
        ChangePayLimitRequest changePayLimitRequest = new ChangePayLimitRequest((String) null, (String) null, (String) null, (String) null, 15, (DefaultConstructorMarker) null);
        changePayLimitRequest.setTo_amount(this.f21586b);
        Unit unit = Unit.INSTANCE;
        changeFastPayLimit(changePayLimitRequest);
    }

    public void onQuizBack(String str, List<String> list) {
        FastPaySubmitQuizRequest fastPaySubmitQuizRequest = new FastPaySubmitQuizRequest((String) null, (List) null, 3, (DefaultConstructorMarker) null);
        fastPaySubmitQuizRequest.setQuestion_id(str);
        fastPaySubmitQuizRequest.setAnswer_id_list(list);
        Unit unit = Unit.INSTANCE;
        submitQuestionnaire(fastPaySubmitQuizRequest);
    }

    public void onPayInfoSuccess(FastPayInfoResponse fastPayInfoResponse) {
        FastPayLimitItem curLimit;
        Intrinsics.checkNotNullParameter(fastPayInfoResponse, "response");
        for (IFastPayBaseViewBinder iFastPayBaseViewBinder : getViewBinders()) {
            iFastPayBaseViewBinder.setupView(fastPayInfoResponse);
        }
        IFastPaySettingView IView = IView();
        if (IView != null) {
            IView.setupView(fastPayInfoResponse);
        }
        FastPayLimit paymentLimit = fastPayInfoResponse.getPaymentLimit();
        String str = null;
        if (!(paymentLimit == null || (curLimit = paymentLimit.getCurLimit()) == null)) {
            str = curLimit.getAmount();
        }
        this.f21586b = str;
        CashierOmegaUtils.Companion.trackEvent(FastPayOmegaConstants.EVENT_SETTING_SW);
    }

    public void onPasswordInterpreted(IFastPaySettingProcessor.PasswordInterpreted passwordInterpreted) {
        Intrinsics.checkNotNullParameter(passwordInterpreted, "interpretedType");
        setInterpretedType(passwordInterpreted);
    }

    public void onChangeLimitChangeSuccess(ChangePayLimitResponse changePayLimitResponse) {
        Intrinsics.checkNotNullParameter(changePayLimitResponse, "response");
        String str = null;
        FastPayInfoRequest fastPayInfoRequest = new FastPayInfoRequest((String) null, 1, (DefaultConstructorMarker) null);
        FastPayParam fastPayParam = getFastPayParam();
        if (fastPayParam != null) {
            str = fastPayParam.getProductId();
        }
        fastPayInfoRequest.setProduct_id(str);
        Unit unit = Unit.INSTANCE;
        requestFastPayInfo(fastPayInfoRequest);
    }

    public void onSwitchFastPayStatusSuccess(FastPayStatusResponse fastPayStatusResponse) {
        String str;
        Object obj;
        Intrinsics.checkNotNullParameter(fastPayStatusResponse, "response");
        Iterator it = this.f21566a.iterator();
        while (true) {
            str = null;
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((IFastPayBaseViewBinder) obj) instanceof FastPaySettingBtnVB) {
                break;
            }
        }
        IFastPayBaseViewBinder iFastPayBaseViewBinder = (IFastPayBaseViewBinder) obj;
        if (!(iFastPayBaseViewBinder instanceof FastPaySettingBtnVB)) {
            iFastPayBaseViewBinder = null;
        }
        FastPaySettingBtnVB fastPaySettingBtnVB = (FastPaySettingBtnVB) iFastPayBaseViewBinder;
        if (fastPaySettingBtnVB != null) {
            fastPaySettingBtnVB.changeStatus(fastPayStatusResponse.getButton(), getCurFastPayStatus());
        }
        FastPaySettingPresenter fastPaySettingPresenter = this;
        boolean z = true;
        FastPaySettingPresenter fastPaySettingPresenter2 = getCurFastPayStatus() == FastPayStatus.ON ? this : null;
        if (fastPaySettingPresenter2 != null) {
            fastPaySettingPresenter2.f21585a.onClose(true, fastPaySettingPresenter2.getCurFastPayStatus());
        }
        Questionnaire questionnaire = fastPayStatusResponse.getQuestionnaire();
        if (questionnaire != null) {
            z = questionnaire.illegal();
        }
        if ((z ? this : null) == null) {
            FastPayQuestionnaireDrawer newInstance = FastPayQuestionnaireDrawer.Companion.newInstance(new FastPaySettingPresenter$onSwitchFastPayStatusSuccess$drawer$1(this));
            Questionnaire questionnaire2 = fastPayStatusResponse.getQuestionnaire();
            newInstance.setData(questionnaire2 == null ? null : questionnaire2.getAnswers());
            Questionnaire questionnaire3 = fastPayStatusResponse.getQuestionnaire();
            newInstance.setBtn(questionnaire3 == null ? null : questionnaire3.getButton());
            Questionnaire questionnaire4 = fastPayStatusResponse.getQuestionnaire();
            newInstance.setTitle(questionnaire4 == null ? null : questionnaire4.getQuestion());
            Questionnaire questionnaire5 = fastPayStatusResponse.getQuestionnaire();
            if (questionnaire5 != null) {
                str = questionnaire5.getQuestionId();
            }
            newInstance.setQuestionId(str);
            FragmentManager supportFragmentManager = ((FragmentActivity) getContext()).getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "context as FragmentActiv…y).supportFragmentManager");
            newInstance.show(supportFragmentManager, Const.DRAWER);
        }
    }

    public void onPasswordSuccess(String str) {
        Intrinsics.checkNotNullParameter(str, "token");
        int i = WhenMappings.$EnumSwitchMapping$0[getInterpretedType().ordinal()];
        if (i == 1) {
            ChangePayLimitRequest changePayLimitRequest = new ChangePayLimitRequest((String) null, (String) null, (String) null, (String) null, 15, (DefaultConstructorMarker) null);
            changePayLimitRequest.setTo_amount(this.f21586b);
            changePayLimitRequest.setPassword_token(str);
            Unit unit = Unit.INSTANCE;
            changeFastPayLimit(changePayLimitRequest);
        } else if (i == 2) {
            FastPayStatusRequest fastPayStatusRequest = new FastPayStatusRequest((String) null, (String) null, 3, (DefaultConstructorMarker) null);
            fastPayStatusRequest.setPassword_token(str);
            fastPayStatusRequest.setPilot_switch(getCurFastPayStatus().opposite());
            Unit unit2 = Unit.INSTANCE;
            switchFastPayStatus(fastPayStatusRequest);
        }
    }

    public IFastPaySettingView IView() {
        IGlobalCashierBaseView mView = getMView();
        if (mView instanceof IFastPaySettingView) {
            return (IFastPaySettingView) mView;
        }
        return null;
    }

    public void unBind() {
        super.unBind();
        getViewBinders().clear();
    }
}
