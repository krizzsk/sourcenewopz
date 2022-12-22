package com.didi.global.fintech.cashier.core.presenter;

import android.content.Context;
import com.didi.component.business.tracker.GPageIdConstant;
import com.didi.global.fintech.cashier.core.contract.IGlobalBizCashierPresenter;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierActionInterceptCallback;
import com.didi.global.fintech.cashier.model.net.response.Payment;
import com.didi.global.fintech.cashier.p117ui.kts.JsonKtxKt;
import com.didi.global.fintech.cashier.p117ui.omega.CashierOmegaUtils;
import com.didi.global.fintech.cashier.user.model.CashierParam;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.mas.sdk.quality.report.utils.Constants;
import global.didi.pay.omega.GlobalPayOmegaConstant;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0016\u0018\u0000 ]2\u00020\u00012\u00020\u0002:\u0001]B/\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\n\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0010\u001a\u00020\u0006H\u0016J\u0012\u0010\u0011\u001a\u00020\u00062\b\b\u0001\u0010\u0012\u001a\u00020\u0013H\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016JI\u0010\u0019\u001a\u00020\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0002\u0010 J+\u0010!\u001a\u00020\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u00062\b\u0010\"\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0002\u0010#J&\u0010$\u001a\u00020\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u00062\b\u0010%\u001a\u0004\u0018\u00010\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010&\u001a\u00020\u0016H\u0016J\u001c\u0010'\u001a\u00020\u00162\b\u0010(\u001a\u0004\u0018\u00010\u00062\b\u0010)\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010*\u001a\u00020\u0016H\u0016J\u0017\u0010+\u001a\u00020\u00162\b\u0010,\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0002\u0010-J\u001e\u0010.\u001a\u00020\u00162\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\r0/H\u0016J\u001e\u00100\u001a\u00020\u00162\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\r0/H\u0016J\b\u00101\u001a\u00020\u0016H\u0016J\b\u00102\u001a\u00020\u0016H\u0016J\b\u00103\u001a\u00020\u0016H\u0016J\u0010\u00104\u001a\u00020\u00162\u0006\u00105\u001a\u00020\u0006H\u0016J\b\u00106\u001a\u00020\u0016H\u0016J+\u00107\u001a\u00020\u00162\b\u00108\u001a\u0004\u0018\u0001092\b\u0010)\u001a\u0004\u0018\u00010\u00062\b\u0010:\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0002\u0010;J\b\u0010<\u001a\u00020\u0016H\u0016J\u0010\u0010=\u001a\u00020\u00162\u0006\u00105\u001a\u00020\u0006H\u0016J\b\u0010>\u001a\u00020\u0016H\u0016J\u001e\u0010?\u001a\u00020\u00162\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\r0/H\u0016J\u001e\u0010@\u001a\u00020\u00162\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\r0/H\u0016J\u001e\u0010A\u001a\u00020\u00162\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\r0/H\u0016J\u001e\u0010B\u001a\u00020\u00162\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\r0/H\u0016J\u001e\u0010C\u001a\u00020\u00162\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\r0/H\u0016J\u0010\u0010D\u001a\u00020\u00162\u0006\u0010E\u001a\u00020\u0006H\u0016J\u0010\u0010F\u001a\u00020\u00162\u0006\u0010E\u001a\u00020\u0006H\u0016J\b\u0010G\u001a\u00020\u0016H\u0016J\b\u0010H\u001a\u00020\u0016H\u0016J\u0016\u0010I\u001a\u00020\u00162\f\u0010J\u001a\b\u0012\u0004\u0012\u00020L0KH\u0016J\u0018\u0010M\u001a\u00020\u00162\u0006\u0010N\u001a\u00020L2\u0006\u0010O\u001a\u00020\u0013H\u0016J\b\u0010P\u001a\u00020\u0016H\u0016J\b\u0010Q\u001a\u00020\u0016H\u0016J\b\u0010R\u001a\u00020\u0016H\u0016J\u001e\u0010S\u001a\u00020\u00162\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\r0/H\u0016J\b\u0010T\u001a\u00020\u0016H\u0016J\u0010\u0010U\u001a\u00020\u00162\u0006\u00105\u001a\u00020\u0013H\u0016J\b\u0010V\u001a\u00020\u0016H\u0016J\b\u0010W\u001a\u00020\u0016H\u0016J\b\u0010X\u001a\u00020\u0016H\u0016J\b\u0010Y\u001a\u00020\u0016H\u0016J\u0010\u0010Z\u001a\u00020\u00162\u0006\u0010[\u001a\u00020\u0006H\u0016J\b\u0010\\\u001a\u00020\u0016H\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0\fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006^"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/core/presenter/GlobalCashierBizPresenter;", "Lcom/didi/global/fintech/cashier/core/presenter/GlobalCashierPayPresenter;", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalBizCashierPresenter;", "context", "Landroid/content/Context;", "uniqueId", "", "fromType", "actionInterceptCallback", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierActionInterceptCallback;", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierActionInterceptCallback;)V", "omegaAttrs", "", "", "getFromType", "getOmegaAttr", "name", "getString", "id", "", "getUniqueId", "init", "", "param", "Lcom/didi/global/fintech/cashier/user/model/CashierParam;", "omega3dsVerifyResultSt", "oid", "uid", "auth", "errno", "errno_json", "is_cancel", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "omega3dsVerifyServerSt", "result", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "omega3dsVerifySt", "type", "omega99PayUnfoldCk", "omegaAddCardCk", "productId", "appid", "omegaAllInstallmentCk", "omegaChangeInstallmentCk", "number", "(Ljava/lang/Integer;)V", "omegaCheckoutPayFailBtnCk", "", "omegaCheckoutPayFailSw", "omegaCheckoutPaySuccessBtnCk", "omegaCheckoutPaySuccessSw", "omegaCheckoutReturnCk", "omegaCheckoutReturnPopupCk", "btnName", "omegaCheckoutReturnPopupSw", "omegaCheckoutSw", "clickable", "", "details", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)V", "omegaCheckoutTopUpCk", "omegaEndsPixCodeBtnCk", "omegaEndsPixCodeSw", "omegaFailDrawerOtherCk", "omegaFailDrawerRcmdCk", "omegaFailDrawerSw", "omegaFailNoDrawerCk", "omegaFailNoDrawerSw", "omegaNetworkErrorSw", "errorCode", "omegaOrderNotExistSw", "omegaPasswordPopupSw", "omegaPasswordPopupYesCk", "omegaPayCk", "list", "", "Lcom/didi/global/fintech/cashier/model/net/response/Payment;", "omegaPayMethodCk", "payment", "selection", "omegaPaySuccessBackCk", "omegaPaySuccessCloseCk", "omegaPaySuccessSw", "omegaPlanCk", "omegaPlanSw", "omegaPolicyCk", "omegaPolicySw", "omegaPolicyToastSw", "omegaThirdUnfoldCk", "omegaTransactionFeeCk", "omegaVersionUpdateBtnCk", "buttonName", "omegaVersionUpdateSw", "Companion", "cashier_core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCashierBizPresenter.kt */
public class GlobalCashierBizPresenter extends GlobalCashierPayPresenter implements IGlobalBizCashierPresenter {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String OMEGA_ATTR_PUB_SOURCE = "pub_source";

    /* renamed from: a */
    private final String f21440a;

    /* renamed from: b */
    private final String f21441b;

    /* renamed from: c */
    private final Map<String, Object> f21442c;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GlobalCashierBizPresenter(Context context, String str, String str2, IGlobalCashierActionInterceptCallback iGlobalCashierActionInterceptCallback, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : iGlobalCashierActionInterceptCallback);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlobalCashierBizPresenter(Context context, String str, String str2, IGlobalCashierActionInterceptCallback iGlobalCashierActionInterceptCallback) {
        super(context, iGlobalCashierActionInterceptCallback);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f21440a = str;
        this.f21441b = str2;
        this.f21442c = new LinkedHashMap();
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/core/presenter/GlobalCashierBizPresenter$Companion;", "", "()V", "OMEGA_ATTR_PUB_SOURCE", "", "cashier_core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: GlobalCashierBizPresenter.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public String getOmegaAttr(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        String str2 = (String) this.f21442c.get(str);
        return str2 == null ? "" : str2;
    }

    public String getString(int i) {
        String string = getContext().getString(i);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(id)");
        return string;
    }

    public String getUniqueId() {
        return this.f21440a;
    }

    public String getFromType() {
        String str = this.f21441b;
        return str == null ? (String) getParamByName(CashierParam.PARAM_FROM_TYPE) : str;
    }

    public void init(CashierParam cashierParam) {
        Map<String, Object> omegaAttrs;
        super.init(cashierParam);
        if (!(cashierParam == null || (omegaAttrs = cashierParam.getOmegaAttrs()) == null)) {
            this.f21442c.putAll(omegaAttrs);
        }
        for (String str : this.f21442c.keySet()) {
            SystemUtils.log(4, "Arirus", "omegaAttrs init: key: " + str + "  value:" + this.f21442c.get(str), (Throwable) null, "com.didi.global.fintech.cashier.core.presenter.GlobalCashierBizPresenter", 47);
        }
    }

    public void omegaCheckoutSw(Boolean bool, String str, String str2) {
        new CashierOmegaUtils("ibt_checkout_sw").addParam("is_pay_click", Integer.valueOf(Intrinsics.areEqual((Object) bool, (Object) true) ? 1 : 0)).addParam("pay_detail_list", str2).addParam(OMEGA_ATTR_PUB_SOURCE, getOmegaAttr(OMEGA_ATTR_PUB_SOURCE)).addParam("appid", str).addParam("app_id", str).send();
    }

    public void omegaCheckoutReturnCk() {
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("is_installment", Integer.valueOf(Intrinsics.areEqual((Object) getMIsInstallment(), (Object) true) ? 1 : 0));
        if (Intrinsics.areEqual((Object) getMIsInstallment(), (Object) true)) {
            linkedHashMap.put(GlobalPayOmegaConstant.EventKey.IBT_WALLET_INSTALLMENT_PLAN, getMInstallmentPlan());
        }
        new CashierOmegaUtils("ibt_checkout_return_ck").addParamAll(linkedHashMap).send();
    }

    public void omegaCheckoutReturnPopupSw() {
        CashierOmegaUtils.Companion.trackEvent("ibt_checkout_return_popup_sw");
    }

    public void omegaCheckoutReturnPopupCk(String str) {
        Intrinsics.checkNotNullParameter(str, "btnName");
        new CashierOmegaUtils("ibt_checkout_return_popup_ck").addParam("button_name", str).send();
    }

    public void omegaEndsPixCodeSw() {
        CashierOmegaUtils.Companion.setPubPage(GPageIdConstant.G_PAGE_ID_ENDS);
        CashierOmegaUtils.Companion.trackEvent("ibt_ends_pixcode_sw");
        CashierOmegaUtils.Companion.setPubPage("");
    }

    public void omegaEndsPixCodeBtnCk(String str) {
        Intrinsics.checkNotNullParameter(str, "btnName");
        CashierOmegaUtils.Companion.setPubPage(GPageIdConstant.G_PAGE_ID_ENDS);
        new CashierOmegaUtils("ibt_ends_pixcode_btn_ck").addParam("button_name", str).send();
        CashierOmegaUtils.Companion.setPubPage("");
    }

    public void omegaAddCardCk(String str, String str2) {
        new CashierOmegaUtils("ibt_checkout_addcard_ck").addParam("product_id", str).addParam("app_id", str2).addParam("appid", str2).addParam("resource_id", 8).send();
    }

    public void omegaTransactionFeeCk() {
        CashierOmegaUtils.Companion.trackEvent("ibt_checkout_transactionfee_ck");
    }

    public void omega99PayUnfoldCk() {
        CashierOmegaUtils.Companion.trackEvent("ibt_checkout_99pay_unfold_ck");
    }

    public void omegaThirdUnfoldCk() {
        CashierOmegaUtils.Companion.trackEvent("ibt_checkout_third_unfold_ck");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0026, code lost:
        r1 = r6.getSelectAction();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void omegaPayMethodCk(com.didi.global.fintech.cashier.model.net.response.Payment r6, int r7) {
        /*
            r5 = this;
            java.lang.String r0 = "payment"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.util.LinkedHashMap r0 = new java.util.LinkedHashMap
            r0.<init>()
            java.util.Map r0 = (java.util.Map) r0
            java.lang.String r1 = r6.getDisplay()
            if (r1 == 0) goto L_0x0014
            goto L_0x0016
        L_0x0014:
            java.lang.String r1 = ""
        L_0x0016:
            java.lang.String r2 = "pay_method"
            r0.put(r2, r1)
            com.didi.global.fintech.cashier.model.net.request.CashierAction r1 = r6.getSelectAction()
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L_0x0026
        L_0x0024:
            r1 = r3
            goto L_0x0031
        L_0x0026:
            com.didi.global.fintech.cashier.model.net.request.CashierAction r1 = r6.getSelectAction()
            if (r1 != 0) goto L_0x002d
            goto L_0x0024
        L_0x002d:
            java.lang.String r1 = com.didi.global.fintech.cashier.p117ui.kts.JsonKtxKt.toJson$default(r1, r3, r2, r3)
        L_0x0031:
            java.lang.String r4 = "pay_method_status"
            r0.put(r4, r1)
            int r1 = r6.getPosition()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.String r4 = "position"
            r0.put(r4, r1)
            java.lang.Integer r1 = r6.getChannelId()
            r4 = 150(0x96, float:2.1E-43)
            if (r1 != 0) goto L_0x004e
            goto L_0x00b7
        L_0x004e:
            int r1 = r1.intValue()
            if (r1 != r4) goto L_0x00b7
            com.didi.global.fintech.cashier.model.net.response.Payment$InstallmentVo r1 = r6.getInstallment()
            if (r1 != 0) goto L_0x005c
            r1 = 0
            goto L_0x0068
        L_0x005c:
            java.lang.Boolean r1 = r1.getSupport()
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r2)
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r4)
        L_0x0068:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.String r4 = "if_installment"
            r0.put(r4, r1)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.List r1 = (java.util.List) r1
            com.didi.global.fintech.cashier.model.net.response.Payment$InstallmentVo r6 = r6.getInstallment()
            if (r6 != 0) goto L_0x007f
            goto L_0x00ad
        L_0x007f:
            java.util.List r6 = r6.getSuggestPlans()
            if (r6 != 0) goto L_0x0086
            goto L_0x00ad
        L_0x0086:
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.Iterator r6 = r6.iterator()
        L_0x008c:
            boolean r4 = r6.hasNext()
            if (r4 == 0) goto L_0x00ad
            java.lang.Object r4 = r6.next()
            com.didi.global.fintech.cashier.model.net.response.Payment$InstallmentVo$PlansVo r4 = (com.didi.global.fintech.cashier.model.net.response.Payment.InstallmentVo.PlansVo) r4
            java.lang.Integer r4 = r4.getNumber()
            if (r4 != 0) goto L_0x009f
            goto L_0x008c
        L_0x009f:
            java.lang.Number r4 = (java.lang.Number) r4
            int r4 = r4.intValue()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r1.add(r4)
            goto L_0x008c
        L_0x00ad:
            java.lang.String r6 = com.didi.global.fintech.cashier.p117ui.kts.JsonKtxKt.toJson$default(r1, r3, r2, r3)
            java.lang.String r1 = "recommend_plan"
            r0.put(r1, r6)
        L_0x00b7:
            java.lang.Integer r6 = java.lang.Integer.valueOf(r7)
            java.lang.String r7 = "selection"
            r0.put(r7, r6)
            com.didi.global.fintech.cashier.ui.omega.CashierOmegaUtils r6 = new com.didi.global.fintech.cashier.ui.omega.CashierOmegaUtils
            java.lang.String r7 = "ibt_checkout_pay_method_ck"
            r6.<init>(r7)
            com.didi.global.fintech.cashier.ui.omega.CashierOmegaUtils r6 = r6.addParamAll(r0)
            r6.send()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.fintech.cashier.core.presenter.GlobalCashierBizPresenter.omegaPayMethodCk(com.didi.global.fintech.cashier.model.net.response.Payment, int):void");
    }

    public void omegaPayCk(List<Payment> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        try {
            List arrayList = new ArrayList();
            List arrayList2 = new ArrayList();
            List arrayList3 = new ArrayList();
            List arrayList4 = new ArrayList();
            int i = 0;
            boolean z = false;
            for (Payment payment : getMSelectPayments()) {
                String display = payment.getDisplay();
                if (display == null) {
                    display = "";
                }
                arrayList.add(display);
                arrayList2.add(payment.getSelectAction());
                arrayList3.add(payment.getTags());
                Integer channelId = payment.getChannelId();
                if (channelId != null) {
                    if (channelId.intValue() == 190) {
                        z = true;
                    }
                }
                arrayList4.add(Integer.valueOf(payment.getPosition()));
            }
            Map linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("pay_method", JsonKtxKt.toJson$default(arrayList, (Type) null, 1, (Object) null));
            linkedHashMap.put("pay_method_status", JsonKtxKt.toJson$default(arrayList2, (Type) null, 1, (Object) null));
            linkedHashMap.put("campaign_detail", JsonKtxKt.toJson$default(arrayList3, (Type) null, 1, (Object) null));
            if (isBalanceSwitcher()) {
                linkedHashMap.put("is_balance_pay", Boolean.valueOf(z));
            }
            linkedHashMap.put("position", JsonKtxKt.toJson$default(arrayList4, (Type) null, 1, (Object) null));
            linkedHashMap.put("appid", getMAppId());
            linkedHashMap.put("app_id", getMAppId());
            if (Intrinsics.areEqual((Object) getMIsInstallment(), (Object) true)) {
                i = 1;
            }
            linkedHashMap.put("is_installment", Integer.valueOf(i));
            if (Intrinsics.areEqual((Object) getMIsInstallment(), (Object) true)) {
                linkedHashMap.put(GlobalPayOmegaConstant.EventKey.IBT_WALLET_INSTALLMENT_PLAN, getMInstallmentPlan());
            }
            new CashierOmegaUtils("ibt_checkout_pay_ck").addParamAll(linkedHashMap).send();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void omegaCheckoutPaySuccessSw() {
        CashierOmegaUtils.Companion.trackEvent("fin_payment_success_sw");
    }

    public void omegaCheckoutPaySuccessBtnCk() {
        CashierOmegaUtils.Companion.trackEvent("fin_payment_success_ck");
    }

    public void omegaPaySuccessSw() {
        CashierOmegaUtils.Companion.setPubPage("paysuccess");
        CashierOmegaUtils.Companion.trackEvent("ibt_paysuccess_sw");
        CashierOmegaUtils.Companion.setPubPage("");
    }

    public void omegaPaySuccessBackCk() {
        CashierOmegaUtils.Companion.setPubPage("paysuccess");
        CashierOmegaUtils.Companion.trackEvent("ibt_paysuccess_back_ck");
        CashierOmegaUtils.Companion.setPubPage("");
    }

    public void omegaPaySuccessCloseCk() {
        CashierOmegaUtils.Companion.setPubPage("paysuccess");
        CashierOmegaUtils.Companion.trackEvent("ibt_paysuccess_close_ck");
        CashierOmegaUtils.Companion.setPubPage("");
    }

    public void omegaCheckoutTopUpCk() {
        new CashierOmegaUtils("ibt_checkout_topup_ck").addParam(OMEGA_ATTR_PUB_SOURCE, getOmegaAttr(OMEGA_ATTR_PUB_SOURCE)).send();
    }

    public void omegaCheckoutPayFailSw(Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "param");
        new CashierOmegaUtils("ibt_checkout_payfail_sw").addParamAll(map).send();
    }

    public void omegaCheckoutPayFailBtnCk(Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "param");
        new CashierOmegaUtils("ibt_checkout_payfail_btn_ck").addParamAll(map).send();
    }

    public void omegaNetworkErrorSw(String str) {
        Intrinsics.checkNotNullParameter(str, Constants.ERROR_CODE);
        new CashierOmegaUtils("ibt_checkout_network_error_sw").addParam("error_code", str).send();
    }

    public void omegaOrderNotExistSw(String str) {
        Intrinsics.checkNotNullParameter(str, Constants.ERROR_CODE);
        new CashierOmegaUtils("ibt_checkout_order_not_exist_sw").addParam("error_code", str).send();
    }

    public void omegaVersionUpdateSw() {
        CashierOmegaUtils.Companion.trackEvent("ibt_checkout_version_updating_sw");
    }

    public void omegaVersionUpdateBtnCk(String str) {
        Intrinsics.checkNotNullParameter(str, "buttonName");
        new CashierOmegaUtils("ibt_checkout_network_error_sw").addParam("button_name", str).send();
    }

    public void omegaPasswordPopupSw() {
        CashierOmegaUtils.Companion.trackEvent("ibt_password_paying_bottom_popoup_sw");
    }

    public void omegaPasswordPopupYesCk() {
        CashierOmegaUtils.Companion.trackEvent("ibt_password_paying_bottom_popoup_yes_ck");
    }

    public void omega3dsVerifySt(String str, String str2, String str3) {
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("oid", str);
        linkedHashMap.put("scene", "trade");
        linkedHashMap.put("pub_biz", "fintech");
        linkedHashMap.put("type", str2);
        linkedHashMap.put("uid", str3);
        new CashierOmegaUtils(GlobalPayOmegaConstant.EventId.ibt_3ds_verify_st).addParamAll(linkedHashMap).send();
    }

    public void omega3dsVerifyResultSt(String str, String str2, String str3, String str4, String str5, Integer num) {
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("oid", str);
        linkedHashMap.put("uid", str2);
        linkedHashMap.put("scene", "trade");
        linkedHashMap.put("pub_biz", "fintech");
        linkedHashMap.put("errno", str4);
        linkedHashMap.put("errno_json", str5);
        linkedHashMap.put("is_cancel", num);
        linkedHashMap.put("auth", str3);
        new CashierOmegaUtils(GlobalPayOmegaConstant.EventId.ibt_3ds_verify_result_ex).addParamAll(linkedHashMap).send();
    }

    public void omega3dsVerifyServerSt(String str, String str2, Integer num) {
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("oid", str);
        linkedHashMap.put("scene", "trade");
        linkedHashMap.put("uid", str2);
        linkedHashMap.put("pub_biz", "fintech");
        linkedHashMap.put("result", num);
        new CashierOmegaUtils(GlobalPayOmegaConstant.EventId.ibt_3ds_verify_result_server_st).addParamAll(linkedHashMap).send();
    }

    public void omegaChangeInstallmentCk(Integer num) {
        new CashierOmegaUtils("fin_checkout_change_installment_ck").addParam("recommend_plan", num).send();
    }

    public void omegaAllInstallmentCk() {
        CashierOmegaUtils.Companion.trackEvent("fin_checkout_all_installment_ck");
    }

    public void omegaPlanSw() {
        CashierOmegaUtils.Companion.trackEvent("fin_installment_plan_sw");
    }

    public void omegaPlanCk(Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "param");
        new CashierOmegaUtils("fin_installment_plan_ck").addParamAll(map).send();
    }

    public void omegaFailDrawerSw(Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "param");
        new CashierOmegaUtils("fin_payment_fail_drawer_sw").addParamAll(map).send();
    }

    public void omegaFailDrawerRcmdCk(Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "param");
        new CashierOmegaUtils("fin_payment_fail_drawer_rcmd_ck").addParamAll(map).send();
    }

    public void omegaFailDrawerOtherCk(Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "param");
        new CashierOmegaUtils("fin_payment_fail_drawer_other_ck").addParamAll(map).send();
    }

    public void omegaFailNoDrawerSw(Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "param");
        new CashierOmegaUtils("fin_payment_fail_no_drawer_sw").addParamAll(map).send();
    }

    public void omegaFailNoDrawerCk(Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "param");
        new CashierOmegaUtils("fin_payment_fail_no_drawer_ck").addParamAll(map).send();
    }

    public void omegaPolicySw() {
        new CashierOmegaUtils("fin_didipay_privacy_policy_sw").addParam("appid", getMAppId()).send();
    }

    public void omegaPolicyCk(int i) {
        new CashierOmegaUtils("fin_didipay_privacy_policy_ck").addParam("button_name", Integer.valueOf(i)).addParam("appid", getMAppId()).send();
    }

    public void omegaPolicyToastSw() {
        new CashierOmegaUtils("fin_didipay_privacy_policy_popup_sw").addParam("appid", getMAppId()).send();
    }
}
