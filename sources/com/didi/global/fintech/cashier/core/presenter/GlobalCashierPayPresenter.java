package com.didi.global.fintech.cashier.core.presenter;

import android.content.Context;
import com.didi.global.fintech.cashier.core.action.GlobalCashierActionsHandler;
import com.didi.global.fintech.cashier.core.api.ICashier3DSProcessor;
import com.didi.global.fintech.cashier.core.api.ICashierBaseProcessor;
import com.didi.global.fintech.cashier.core.api.ICashierCVVProcessor;
import com.didi.global.fintech.cashier.core.api.ICashierDialogProcessor;
import com.didi.global.fintech.cashier.core.api.ICashierOperateProcessor;
import com.didi.global.fintech.cashier.core.api.ICashierPayInfoProcessor;
import com.didi.global.fintech.cashier.core.api.ICashierPolicyProcessor;
import com.didi.global.fintech.cashier.core.api.ICashierResultProcessor;
import com.didi.global.fintech.cashier.core.api.ICashierSyncStatusProcessor;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierActionInterceptCallback;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierBaseView;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierNetPresenter;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierPayPresenter;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierPayView;
import com.didi.global.fintech.cashier.core.interceptor.BaseRouterAdapter;
import com.didi.global.fintech.cashier.core.interceptor.CashierActionInterceptor;
import com.didi.global.fintech.cashier.core.interceptor.PolicyRouterAdapter;
import com.didi.global.fintech.cashier.core.interceptor.RouterOpenInterceptor;
import com.didi.global.fintech.cashier.core.utils.PayInfoManager;
import com.didi.global.fintech.cashier.model.CashierError;
import com.didi.global.fintech.cashier.model.net.request.AgreePolicyRequest;
import com.didi.global.fintech.cashier.model.net.request.CVVCardInfo;
import com.didi.global.fintech.cashier.model.net.request.CashierAction;
import com.didi.global.fintech.cashier.model.net.request.GetCVVInfoRequest;
import com.didi.global.fintech.cashier.model.net.request.GetPayInfoRequest;
import com.didi.global.fintech.cashier.model.net.request.GetPayStatusRequest;
import com.didi.global.fintech.cashier.model.net.request.GetSuccessInfoRequest;
import com.didi.global.fintech.cashier.model.net.request.PaymentThreeDSDetailsRequest;
import com.didi.global.fintech.cashier.model.net.request.PrepayRequest;
import com.didi.global.fintech.cashier.model.net.response.AgreePolicyResponse;
import com.didi.global.fintech.cashier.model.net.response.BasicPayment;
import com.didi.global.fintech.cashier.model.net.response.CVVInfoResponse;
import com.didi.global.fintech.cashier.model.net.response.GlobalCashierAdyen3DSModel;
import com.didi.global.fintech.cashier.model.net.response.OrderInfo;
import com.didi.global.fintech.cashier.model.net.response.PayInfoResponse;
import com.didi.global.fintech.cashier.model.net.response.PayStatusResponse;
import com.didi.global.fintech.cashier.model.net.response.Payment;
import com.didi.global.fintech.cashier.model.net.response.PaymentGroup;
import com.didi.global.fintech.cashier.model.net.response.PaymentThreeDSDetailsResponse;
import com.didi.global.fintech.cashier.model.net.response.PolicyData;
import com.didi.global.fintech.cashier.model.net.response.PrepayResponse;
import com.didi.global.fintech.cashier.model.net.response.PriceAmount;
import com.didi.global.fintech.cashier.model.net.response.PriceInfo;
import com.didi.global.fintech.cashier.model.net.response.SuccessInfoResponse;
import com.didi.global.fintech.cashier.model.strategy.BaseStrategy;
import com.didi.global.fintech.cashier.model.strategy.PayInfoStrategy;
import com.didi.global.fintech.cashier.model.strategy.SyncStatusStrategy;
import com.didi.global.fintech.cashier.network.processor.GlobalCommonParamsProcessor;
import com.didi.global.fintech.cashier.p117ui.dialog.GlobalCashierDialogCommonConfig;
import com.didi.global.fintech.cashier.p117ui.omega.CashierOmegaUtils;
import com.didi.global.fintech.cashier.p117ui.omega.PubPageType;
import com.didi.global.fintech.cashier.user.facade.CashierFacade;
import com.didi.global.fintech.cashier.user.model.CashierParam;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.UiThreadHandler;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.Constants;

@Metadata(mo175977d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\n\u0010o\u001a\u0004\u0018\u00010pH\u0016J\u0012\u0010q\u001a\u00020r2\b\u0010s\u001a\u0004\u0018\u00010tH\u0016J\u0012\u0010u\u001a\u00020r2\b\u0010v\u001a\u0004\u0018\u00010wH\u0016J\u001d\u0010x\u001a\u0004\u0018\u0001Hy\"\u0004\b\u0000\u0010y2\u0006\u0010z\u001a\u00020\u0016H\u0004¢\u0006\u0002\u0010{J<\u0010|\u001a\u00020r2\b\u0010}\u001a\u0004\u0018\u00010~2\f\u0010\u001a\b\u0012\u0004\u0012\u00020Q0/2\u001a\u0010\u0001\u001a\u0015\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020Q\u0012\u0004\u0012\u00020\u00110\u0001H\u0004J\t\u0010\u0001\u001a\u00020rH\u0016J*\u0010\u0001\u001a\u0004\u0018\u0001Hy\"\b\b\u0000\u0010y*\u00020h2\r\u0010\u0001\u001a\b\u0012\u0004\u0012\u0002Hy0gH\u0002¢\u0006\u0003\u0010\u0001J\u0015\u0010\u0001\u001a\u00020r2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016J\t\u0010\u0001\u001a\u00020rH\u0016J\u0012\u0010\u0001\u001a\u00020r2\u0007\u0010\u0001\u001a\u00020~H\u0004J\u0013\u0010\u0001\u001a\u00020r2\b\u0010\u0001\u001a\u00030\u0001H\u0016J\t\u0010\u0001\u001a\u00020rH\u0016J\u0013\u0010\u0001\u001a\u00020r2\b\u0010\u0001\u001a\u00030\u0001H\u0016J\u001c\u0010\u0001\u001a\u00020r2\u0007\u0010\u0001\u001a\u00020~2\b\u0010\u0001\u001a\u00030\u0001H\u0016J\u0013\u0010\u0001\u001a\u00020r2\b\u0010\u0001\u001a\u00030\u0001H\u0016J\u0013\u0010\u0001\u001a\u00020r2\b\u0010\u0001\u001a\u00030\u0001H\u0016J\u001d\u0010\u0001\u001a\u00020r2\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0016J\u0013\u0010\u0001\u001a\u00020r2\b\u0010\u0001\u001a\u00030\u0001H\u0016J\u0013\u0010\u0001\u001a\u00020r2\b\u0010\u0001\u001a\u00030\u0001H\u0016J\u0019\u0010 \u0001\u001a\u00020r2\u000e\u0010¡\u0001\u001a\t\u0012\u0004\u0012\u0002000¢\u0001H\u0016J#\u0010£\u0001\u001a\u00020r2\u0007\u0010¤\u0001\u001a\u00020h2\u000f\u0010\u0001\u001a\n\u0012\u0006\b\u0001\u0012\u00020h0gH\u0004J\u0013\u0010¥\u0001\u001a\u00020r2\b\u0010¦\u0001\u001a\u00030§\u0001H\u0016J\u0015\u0010¨\u0001\u001a\u00020r2\n\u0010©\u0001\u001a\u0005\u0018\u00010ª\u0001H\u0016J\u0013\u0010«\u0001\u001a\u00020r2\b\u0010¬\u0001\u001a\u00030­\u0001H\u0016J\u0012\u0010®\u0001\u001a\u00020r2\u0007\u0010¯\u0001\u001a\u00020LH\u0016J\t\u0010°\u0001\u001a\u00020rH\u0016J\u0012\u0010±\u0001\u001a\u00020r2\u0007\u0010¯\u0001\u001a\u00020[H\u0016J\t\u0010²\u0001\u001a\u00020rH\u0016J\t\u0010³\u0001\u001a\u00020\u0016H\u0016J\t\u0010´\u0001\u001a\u00020rH\u0016J\t\u0010µ\u0001\u001a\u00020rH\u0016J\u001f\u0010¶\u0001\u001a\u00020r2\t\u0010¦\u0001\u001a\u0004\u0018\u00010a2\t\u0010·\u0001\u001a\u0004\u0018\u00010\u0016H\u0016J\u0014\u0010¸\u0001\u001a\u00020r2\t\u0010¹\u0001\u001a\u0004\u0018\u00010\u0016H\u0016R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0010\n\u0002\u0010#\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010$\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0018\"\u0004\b&\u0010\u001aR&\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020)0(X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R \u0010.\u001a\b\u0012\u0004\u0012\u0002000/X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001e\u00105\u001a\u0004\u0018\u000106X\u000e¢\u0006\u0010\n\u0002\u0010;\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001e\u0010<\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0010\n\u0002\u0010#\u001a\u0004\b=\u0010 \"\u0004\b>\u0010\"R\u001c\u0010?\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u0018\"\u0004\bA\u0010\u001aR\u001c\u0010B\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u0018\"\u0004\bD\u0010\u001aR\u001c\u0010E\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\u0018\"\u0004\bG\u0010\u001aR\u001c\u0010H\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\u0018\"\u0004\bJ\u0010\u001aR\u000e\u0010K\u001a\u00020LX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010M\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010\u0018\"\u0004\bO\u0010\u001aR \u0010P\u001a\b\u0012\u0004\u0012\u00020Q0/X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u00102\"\u0004\bS\u00104R\u001c\u0010T\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010\u0018\"\u0004\bV\u0010\u001aR\u001c\u0010W\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010\u0018\"\u0004\bY\u0010\u001aR\u001a\u0010Z\u001a\u00020[X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R\u001c\u0010`\u001a\u0004\u0018\u00010aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010c\"\u0004\bd\u0010eR\"\u0010f\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020h0g\u0012\u0004\u0012\u00020h0(X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010i\u001a\u0004\u0018\u00010jX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010l\"\u0004\bm\u0010n¨\u0006º\u0001"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/core/presenter/GlobalCashierPayPresenter;", "Lcom/didi/global/fintech/cashier/core/presenter/GlobalCashierNetPresenter;", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierPayPresenter;", "context", "Landroid/content/Context;", "actionInterceptHandler", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierActionInterceptCallback;", "(Landroid/content/Context;Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierActionInterceptCallback;)V", "getActionInterceptHandler", "()Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierActionInterceptCallback;", "actionInterceptor", "Lcom/didi/global/fintech/cashier/core/interceptor/CashierActionInterceptor;", "getActionInterceptor", "()Lcom/didi/global/fintech/cashier/core/interceptor/CashierActionInterceptor;", "setActionInterceptor", "(Lcom/didi/global/fintech/cashier/core/interceptor/CashierActionInterceptor;)V", "isBalanceSwitcher", "", "()Z", "setBalanceSwitcher", "(Z)V", "mAppId", "", "getMAppId", "()Ljava/lang/String;", "setMAppId", "(Ljava/lang/String;)V", "mBizContent", "getMBizContent", "setMBizContent", "mBoletoConfirm", "getMBoletoConfirm", "()Ljava/lang/Boolean;", "setMBoletoConfirm", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "mCvv", "getMCvv", "setMCvv", "mExtraParams", "", "", "getMExtraParams", "()Ljava/util/Map;", "setMExtraParams", "(Ljava/util/Map;)V", "mExtraPayments", "", "Lcom/didi/global/fintech/cashier/model/net/response/BasicPayment;", "getMExtraPayments", "()Ljava/util/List;", "setMExtraPayments", "(Ljava/util/List;)V", "mInstallmentPlan", "", "getMInstallmentPlan", "()Ljava/lang/Integer;", "setMInstallmentPlan", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "mIsInstallment", "getMIsInstallment", "setMIsInstallment", "mOrderId", "getMOrderId", "setMOrderId", "mOutTradeId", "getMOutTradeId", "setMOutTradeId", "mPasswordToken", "getMPasswordToken", "setMPasswordToken", "mPayFeeTextDisplay", "getMPayFeeTextDisplay", "setMPayFeeTextDisplay", "mPayInfoStrategy", "Lcom/didi/global/fintech/cashier/model/strategy/PayInfoStrategy;", "mProductId", "getMProductId", "setMProductId", "mSelectPayments", "Lcom/didi/global/fintech/cashier/model/net/response/Payment;", "getMSelectPayments", "setMSelectPayments", "mSign", "getMSign", "setMSign", "mSignType", "getMSignType", "setMSignType", "mSyncStatusStrategy", "Lcom/didi/global/fintech/cashier/model/strategy/SyncStatusStrategy;", "getMSyncStatusStrategy", "()Lcom/didi/global/fintech/cashier/model/strategy/SyncStatusStrategy;", "setMSyncStatusStrategy", "(Lcom/didi/global/fintech/cashier/model/strategy/SyncStatusStrategy;)V", "mThreeDSV2", "Lcom/didi/global/fintech/cashier/model/net/request/PrepayRequest$ThreeDSV2;", "getMThreeDSV2", "()Lcom/didi/global/fintech/cashier/model/net/request/PrepayRequest$ThreeDSV2;", "setMThreeDSV2", "(Lcom/didi/global/fintech/cashier/model/net/request/PrepayRequest$ThreeDSV2;)V", "processors", "Ljava/lang/Class;", "Lcom/didi/global/fintech/cashier/core/api/ICashierBaseProcessor;", "routerInterceptor", "Lcom/didi/global/fintech/cashier/core/interceptor/RouterOpenInterceptor;", "getRouterInterceptor", "()Lcom/didi/global/fintech/cashier/core/interceptor/RouterOpenInterceptor;", "setRouterInterceptor", "(Lcom/didi/global/fintech/cashier/core/interceptor/RouterOpenInterceptor;)V", "IView", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierPayView;", "bindView", "", "view", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierBaseView;", "doPay", "action", "Lcom/didi/global/fintech/cashier/model/net/request/CashierAction;", "getParamByName", "T", "name", "(Ljava/lang/String;)Ljava/lang/Object;", "getPaymentsFromPayInfo", "src", "Lcom/didi/global/fintech/cashier/model/net/response/PayInfoResponse;", "dst", "filter", "Lkotlin/Function2;", "getPolicy", "getProcessor", "clazz", "(Ljava/lang/Class;)Lcom/didi/global/fintech/cashier/core/api/ICashierBaseProcessor;", "init", "param", "Lcom/didi/global/fintech/cashier/user/model/CashierParam;", "initNet", "interceptPayInfo", "response", "onAgreePolicyResponse", "Lcom/didi/global/fintech/cashier/model/net/response/AgreePolicyResponse;", "onBind", "onCVVInfoResponse", "Lcom/didi/global/fintech/cashier/model/net/response/CVVInfoResponse;", "onPayInfoResponse", "API", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierNetPresenter$API;", "onPayStatusResponse", "Lcom/didi/global/fintech/cashier/model/net/response/PayStatusResponse;", "onPrePayResponse", "Lcom/didi/global/fintech/cashier/model/net/response/PrepayResponse;", "onRequestFailed", "api", "error", "Lcom/didi/global/fintech/cashier/model/CashierError;", "onSuccessInfoResponse", "Lcom/didi/global/fintech/cashier/model/net/response/SuccessInfoResponse;", "onThreeDSDetailsResponse", "Lcom/didi/global/fintech/cashier/model/net/response/PaymentThreeDSDetailsResponse;", "refreshPayInfo", "afterSelectPayment", "", "registerProcessor", "processor", "request3DSDetails", "data", "Lcom/didi/global/fintech/cashier/model/net/response/GlobalCashierAdyen3DSModel;", "requestCVVInfo", "cardInfo", "Lcom/didi/global/fintech/cashier/model/net/request/CVVCardInfo;", "requestConfirmPolicy", "agreePolicy", "Lcom/didi/global/fintech/cashier/model/net/response/PolicyData;", "requestPayInfo", "strategy", "requestSuccessInfo", "startSyncPayResult", "stopSyncPayResult", "syncStatusScene", "unBind", "updateBoletoConfirm", "updateCybs3DS", "cvv", "updatePasswordToken", "token", "cashier_core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCashierPayPresenter.kt */
public abstract class GlobalCashierPayPresenter extends GlobalCashierNetPresenter implements IGlobalCashierPayPresenter {

    /* renamed from: a */
    private final IGlobalCashierActionInterceptCallback f21459a;

    /* renamed from: b */
    private CashierActionInterceptor f21460b;

    /* renamed from: c */
    private RouterOpenInterceptor f21461c;

    /* renamed from: d */
    private PayInfoStrategy f21462d = new PayInfoStrategy(0, PayInfoStrategy.Companion.getNormal(), 1, (DefaultConstructorMarker) null);

    /* renamed from: e */
    private SyncStatusStrategy f21463e = new SyncStatusStrategy(0, 0, SyncStatusStrategy.Companion.getNormal(), 3, (DefaultConstructorMarker) null);

    /* renamed from: f */
    private String f21464f;

    /* renamed from: g */
    private String f21465g;

    /* renamed from: h */
    private String f21466h;

    /* renamed from: i */
    private String f21467i;

    /* renamed from: j */
    private String f21468j;

    /* renamed from: k */
    private Map<String, Object> f21469k = new LinkedHashMap();

    /* renamed from: l */
    private String f21470l;

    /* renamed from: m */
    private String f21471m;

    /* renamed from: n */
    private String f21472n;

    /* renamed from: o */
    private PrepayRequest.ThreeDSV2 f21473o;

    /* renamed from: p */
    private String f21474p;

    /* renamed from: q */
    private Boolean f21475q;

    /* renamed from: r */
    private List<Payment> f21476r = new ArrayList();

    /* renamed from: s */
    private List<BasicPayment> f21477s = new ArrayList();

    /* renamed from: t */
    private boolean f21478t;

    /* renamed from: u */
    private String f21479u;

    /* renamed from: v */
    private Boolean f21480v;

    /* renamed from: w */
    private Integer f21481w;

    /* renamed from: x */
    private Map<Class<? extends ICashierBaseProcessor>, ICashierBaseProcessor> f21482x = new LinkedHashMap();

    @Metadata(mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: GlobalCashierPayPresenter.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BaseStrategy.Result.values().length];
            iArr[BaseStrategy.Result.SUCCESS.ordinal()] = 1;
            iArr[BaseStrategy.Result.CONTINUE.ordinal()] = 2;
            iArr[BaseStrategy.Result.FAILED.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* access modifiers changed from: protected */
    public final IGlobalCashierActionInterceptCallback getActionInterceptHandler() {
        return this.f21459a;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlobalCashierPayPresenter(Context context, IGlobalCashierActionInterceptCallback iGlobalCashierActionInterceptCallback) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f21459a = iGlobalCashierActionInterceptCallback;
    }

    public String syncStatusScene() {
        return IGlobalCashierPayPresenter.SyncStatusScene.PAY.name();
    }

    /* access modifiers changed from: protected */
    public final CashierActionInterceptor getActionInterceptor() {
        return this.f21460b;
    }

    /* access modifiers changed from: protected */
    public final void setActionInterceptor(CashierActionInterceptor cashierActionInterceptor) {
        this.f21460b = cashierActionInterceptor;
    }

    /* access modifiers changed from: protected */
    public final RouterOpenInterceptor getRouterInterceptor() {
        return this.f21461c;
    }

    /* access modifiers changed from: protected */
    public final void setRouterInterceptor(RouterOpenInterceptor routerOpenInterceptor) {
        this.f21461c = routerOpenInterceptor;
    }

    /* access modifiers changed from: protected */
    public final SyncStatusStrategy getMSyncStatusStrategy() {
        return this.f21463e;
    }

    /* access modifiers changed from: protected */
    public final void setMSyncStatusStrategy(SyncStatusStrategy syncStatusStrategy) {
        Intrinsics.checkNotNullParameter(syncStatusStrategy, "<set-?>");
        this.f21463e = syncStatusStrategy;
    }

    /* access modifiers changed from: protected */
    public final String getMSign() {
        return this.f21464f;
    }

    /* access modifiers changed from: protected */
    public final void setMSign(String str) {
        this.f21464f = str;
    }

    /* access modifiers changed from: protected */
    public final String getMSignType() {
        return this.f21465g;
    }

    /* access modifiers changed from: protected */
    public final void setMSignType(String str) {
        this.f21465g = str;
    }

    /* access modifiers changed from: protected */
    public final String getMBizContent() {
        return this.f21466h;
    }

    /* access modifiers changed from: protected */
    public final void setMBizContent(String str) {
        this.f21466h = str;
    }

    /* access modifiers changed from: protected */
    public final String getMOutTradeId() {
        return this.f21467i;
    }

    /* access modifiers changed from: protected */
    public final void setMOutTradeId(String str) {
        this.f21467i = str;
    }

    /* access modifiers changed from: protected */
    public final String getMAppId() {
        return this.f21468j;
    }

    /* access modifiers changed from: protected */
    public final void setMAppId(String str) {
        this.f21468j = str;
    }

    /* access modifiers changed from: protected */
    public final Map<String, Object> getMExtraParams() {
        return this.f21469k;
    }

    /* access modifiers changed from: protected */
    public final void setMExtraParams(Map<String, Object> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.f21469k = map;
    }

    /* access modifiers changed from: protected */
    public final String getMProductId() {
        return this.f21470l;
    }

    /* access modifiers changed from: protected */
    public final void setMProductId(String str) {
        this.f21470l = str;
    }

    /* access modifiers changed from: protected */
    public final String getMOrderId() {
        return this.f21471m;
    }

    /* access modifiers changed from: protected */
    public final void setMOrderId(String str) {
        this.f21471m = str;
    }

    /* access modifiers changed from: protected */
    public final String getMPasswordToken() {
        return this.f21472n;
    }

    /* access modifiers changed from: protected */
    public final void setMPasswordToken(String str) {
        this.f21472n = str;
    }

    /* access modifiers changed from: protected */
    public final PrepayRequest.ThreeDSV2 getMThreeDSV2() {
        return this.f21473o;
    }

    /* access modifiers changed from: protected */
    public final void setMThreeDSV2(PrepayRequest.ThreeDSV2 threeDSV2) {
        this.f21473o = threeDSV2;
    }

    /* access modifiers changed from: protected */
    public final String getMCvv() {
        return this.f21474p;
    }

    /* access modifiers changed from: protected */
    public final void setMCvv(String str) {
        this.f21474p = str;
    }

    /* access modifiers changed from: protected */
    public final Boolean getMBoletoConfirm() {
        return this.f21475q;
    }

    /* access modifiers changed from: protected */
    public final void setMBoletoConfirm(Boolean bool) {
        this.f21475q = bool;
    }

    /* access modifiers changed from: protected */
    public final List<Payment> getMSelectPayments() {
        return this.f21476r;
    }

    /* access modifiers changed from: protected */
    public final void setMSelectPayments(List<Payment> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.f21476r = list;
    }

    /* access modifiers changed from: protected */
    public final List<BasicPayment> getMExtraPayments() {
        return this.f21477s;
    }

    /* access modifiers changed from: protected */
    public final void setMExtraPayments(List<BasicPayment> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.f21477s = list;
    }

    /* access modifiers changed from: protected */
    public final boolean isBalanceSwitcher() {
        return this.f21478t;
    }

    /* access modifiers changed from: protected */
    public final void setBalanceSwitcher(boolean z) {
        this.f21478t = z;
    }

    /* access modifiers changed from: protected */
    public final String getMPayFeeTextDisplay() {
        return this.f21479u;
    }

    /* access modifiers changed from: protected */
    public final void setMPayFeeTextDisplay(String str) {
        this.f21479u = str;
    }

    /* access modifiers changed from: protected */
    public final Boolean getMIsInstallment() {
        return this.f21480v;
    }

    /* access modifiers changed from: protected */
    public final void setMIsInstallment(Boolean bool) {
        this.f21480v = bool;
    }

    /* access modifiers changed from: protected */
    public final Integer getMInstallmentPlan() {
        return this.f21481w;
    }

    /* access modifiers changed from: protected */
    public final void setMInstallmentPlan(Integer num) {
        this.f21481w = num;
    }

    /* access modifiers changed from: protected */
    public final void registerProcessor(ICashierBaseProcessor iCashierBaseProcessor, Class<? extends ICashierBaseProcessor> cls) {
        Intrinsics.checkNotNullParameter(iCashierBaseProcessor, Constants.BUNDLE_NATIVECODE_PROCESSOR);
        Intrinsics.checkNotNullParameter(cls, "clazz");
        this.f21482x.put(cls, iCashierBaseProcessor);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final <T extends ICashierBaseProcessor> T m15739a(Class<T> cls) {
        T t = this.f21482x.get(cls);
        if (t instanceof ICashierBaseProcessor) {
            return (ICashierBaseProcessor) t;
        }
        return null;
    }

    public void init(CashierParam cashierParam) {
        String str;
        String str2;
        Map<String, Object> extraParams;
        String str3 = null;
        this.f21467i = cashierParam == null ? null : cashierParam.getOutTradeId();
        if (cashierParam == null) {
            str = null;
        } else {
            str = cashierParam.getSign();
        }
        this.f21464f = str;
        if (cashierParam == null) {
            str2 = null;
        } else {
            str2 = cashierParam.getSignType();
        }
        this.f21465g = str2;
        if (cashierParam != null) {
            str3 = cashierParam.getBizContent();
        }
        this.f21466h = str3;
        if (!(cashierParam == null || (extraParams = cashierParam.getExtraParams()) == null)) {
            getMExtraParams().putAll(extraParams);
        }
        initNet();
        CashierOmegaUtils.Companion.setOutTradeId(this.f21467i);
        CashierOmegaUtils.Companion.setUid(CashierFacade.Companion.getInstance().getInitConfig().getUid());
        CashierOmegaUtils.Companion.setPubPage(PubPageType.CHECKOUT.getType());
    }

    public void initNet() {
        setParamsProcessor(new GlobalCommonParamsProcessor(getUniqueId(), getFromType()));
    }

    public void onBind() {
        this.f21460b = new CashierActionInterceptor(getUniqueId());
        this.f21461c = new RouterOpenInterceptor(getUniqueId());
    }

    /* access modifiers changed from: protected */
    public final <T> T getParamByName(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        try {
            Map<String, Object> map = this.f21469k;
            if (map == null) {
                return null;
            }
            return map.get(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public void unBind() {
        super.unBind();
        GlobalCashierActionsHandler.INSTANCE.onDestroy();
    }

    public void updatePasswordToken(String str) {
        this.f21472n = str;
        doPay((CashierAction) null);
    }

    public void updateBoletoConfirm() {
        this.f21475q = true;
        doPay((CashierAction) null);
    }

    public void updateCybs3DS(PrepayRequest.ThreeDSV2 threeDSV2, String str) {
        this.f21473o = threeDSV2;
        this.f21474p = str;
        doPay((CashierAction) null);
    }

    public void bindView(IGlobalCashierBaseView iGlobalCashierBaseView) {
        super.bindView(iGlobalCashierBaseView);
        SystemUtils.log(4, "Arirus", "GlobalCashierPayPresenter bindView: ", (Throwable) null, "com.didi.global.fintech.cashier.core.presenter.GlobalCashierPayPresenter", 139);
    }

    public void requestPayInfo(PayInfoStrategy payInfoStrategy) {
        Intrinsics.checkNotNullParameter(payInfoStrategy, "strategy");
        this.f21462d = payInfoStrategy;
        GetPayInfoRequest getPayInfoRequest = new GetPayInfoRequest((String) null, (String) null, (String) null, (String) null, 15, (DefaultConstructorMarker) null);
        getPayInfoRequest.setOut_trade_id(getMOutTradeId());
        getPayInfoRequest.setSign(getMSign());
        getPayInfoRequest.setSign_type(getMSignType());
        getPayInfoRequest.setBiz_content(getMBizContent());
        Unit unit = Unit.INSTANCE;
        getPayInfo(getPayInfoRequest);
        ICashierOperateProcessor iCashierOperateProcessor = (ICashierOperateProcessor) m15739a(ICashierOperateProcessor.class);
        if (iCashierOperateProcessor != null) {
            ICashierOperateProcessor.DefaultImpls.loading$default(iCashierOperateProcessor, false, 0, 2, (Object) null);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x007d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void refreshPayInfo(java.util.List<? extends com.didi.global.fintech.cashier.model.net.response.BasicPayment> r9) {
        /*
            r8 = this;
            java.lang.String r0 = "afterSelectPayment"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.List r0 = (java.util.List) r0
            java.util.List<com.didi.global.fintech.cashier.model.net.response.Payment> r1 = r8.f21476r
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r1 = r1.iterator()
        L_0x0014:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x008a
            java.lang.Object r2 = r1.next()
            com.didi.global.fintech.cashier.model.net.response.Payment r2 = (com.didi.global.fintech.cashier.model.net.response.Payment) r2
            com.didi.global.fintech.cashier.model.net.response.Payment$InstallmentVo r3 = r2.getInstallment()
            r4 = 0
            if (r3 != 0) goto L_0x0029
        L_0x0027:
            r3 = r4
            goto L_0x005d
        L_0x0029:
            java.util.List r3 = r3.getSuggestPlans()
            if (r3 != 0) goto L_0x0030
            goto L_0x0027
        L_0x0030:
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.Iterator r3 = r3.iterator()
        L_0x0036:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x0053
            java.lang.Object r5 = r3.next()
            r6 = r5
            com.didi.global.fintech.cashier.model.net.response.Payment$InstallmentVo$PlansVo r6 = (com.didi.global.fintech.cashier.model.net.response.Payment.InstallmentVo.PlansVo) r6
            java.lang.Boolean r6 = r6.getSelected()
            r7 = 1
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r7)
            if (r6 == 0) goto L_0x0036
            goto L_0x0054
        L_0x0053:
            r5 = r4
        L_0x0054:
            com.didi.global.fintech.cashier.model.net.response.Payment$InstallmentVo$PlansVo r5 = (com.didi.global.fintech.cashier.model.net.response.Payment.InstallmentVo.PlansVo) r5
            if (r5 != 0) goto L_0x0059
            goto L_0x0027
        L_0x0059:
            java.lang.Integer r3 = r5.getNumber()
        L_0x005d:
            java.lang.Integer r5 = r2.getChannelId()
            if (r3 == 0) goto L_0x007d
            com.didi.global.fintech.cashier.model.net.response.Payment$ExtraInfo r6 = new com.didi.global.fintech.cashier.model.net.response.Payment$ExtraInfo
            r7 = 3
            r6.<init>(r4, r4, r7, r4)
            com.didi.global.fintech.cashier.model.net.response.Payment$ExtraInfo r2 = r2.getExtraInfo()
            if (r2 != 0) goto L_0x0070
            goto L_0x0074
        L_0x0070:
            java.lang.String r4 = r2.getCardIndex()
        L_0x0074:
            r6.setCardIndex(r4)
            r6.setInstallmentNumber(r3)
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
            goto L_0x0081
        L_0x007d:
            com.didi.global.fintech.cashier.model.net.response.Payment$ExtraInfo r6 = r2.getExtraInfo()
        L_0x0081:
            com.didi.global.fintech.cashier.model.net.response.BasicPayment r2 = new com.didi.global.fintech.cashier.model.net.response.BasicPayment
            r2.<init>(r5, r6)
            r0.add(r2)
            goto L_0x0014
        L_0x008a:
            java.util.List<com.didi.global.fintech.cashier.model.net.response.BasicPayment> r1 = r8.f21477s
            java.util.Collection r1 = (java.util.Collection) r1
            r0.addAll(r1)
            com.didi.global.fintech.cashier.model.net.request.ChangePayInfoRequest r1 = new com.didi.global.fintech.cashier.model.net.request.ChangePayInfoRequest
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 7
            r7 = 0
            r2 = r1
            r2.<init>(r3, r4, r5, r6, r7)
            java.lang.String r2 = r8.getMOutTradeId()
            if (r2 != 0) goto L_0x00a4
            java.lang.String r2 = ""
        L_0x00a4:
            r1.setOut_trade_id(r2)
            java.util.List r2 = r1.getFrom_select()
            java.util.Collection r0 = (java.util.Collection) r0
            r2.addAll(r0)
            java.util.List r0 = r1.getTo_select()
            java.util.Collection r9 = (java.util.Collection) r9
            r0.addAll(r9)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            r8.changePayInfo(r1)
            java.lang.Class<com.didi.global.fintech.cashier.core.api.ICashierOperateProcessor> r9 = com.didi.global.fintech.cashier.core.api.ICashierOperateProcessor.class
            com.didi.global.fintech.cashier.core.api.ICashierBaseProcessor r9 = r8.m15739a(r9)
            r0 = r9
            com.didi.global.fintech.cashier.core.api.ICashierOperateProcessor r0 = (com.didi.global.fintech.cashier.core.api.ICashierOperateProcessor) r0
            if (r0 != 0) goto L_0x00ca
            goto L_0x00d2
        L_0x00ca:
            r1 = 0
            r2 = 0
            r4 = 2
            r5 = 0
            com.didi.global.fintech.cashier.core.api.ICashierOperateProcessor.DefaultImpls.loading$default(r0, r1, r2, r4, r5)
        L_0x00d2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.fintech.cashier.core.presenter.GlobalCashierPayPresenter.refreshPayInfo(java.util.List):void");
    }

    public void doPay(CashierAction cashierAction) {
        CashierActionInterceptor cashierActionInterceptor = this.f21460b;
        if (cashierActionInterceptor != null) {
            CashierParam cashierParam = new CashierParam((String) null, (String) null, (String) null, (String) null, (Map) null, (Map) null, (String) null, 127, (DefaultConstructorMarker) null);
            cashierParam.setOutTradeId(getMOutTradeId());
            cashierParam.setNeedPayFeeTextDisplay(getMPayFeeTextDisplay());
            Unit unit = Unit.INSTANCE;
            cashierActionInterceptor.setCashierParam(cashierParam);
        }
        CashierActionInterceptor cashierActionInterceptor2 = this.f21460b;
        if (cashierActionInterceptor2 != null) {
            cashierActionInterceptor2.intercept(getContext(), cashierAction, (Function0<Unit>[]) new Function0[]{new GlobalCashierPayPresenter$doPay$2(this, cashierAction), new GlobalCashierPayPresenter$doPay$3(this)});
        }
    }

    public void startSyncPayResult(SyncStatusStrategy syncStatusStrategy) {
        Intrinsics.checkNotNullParameter(syncStatusStrategy, "strategy");
        this.f21463e = syncStatusStrategy;
        ICashierOperateProcessor iCashierOperateProcessor = (ICashierOperateProcessor) m15739a(ICashierOperateProcessor.class);
        if (iCashierOperateProcessor != null) {
            ICashierOperateProcessor.DefaultImpls.loading$default(iCashierOperateProcessor, false, 0, 2, (Object) null);
        }
        UiThreadHandler.postDelayed(new Runnable(syncStatusStrategy) {
            public final /* synthetic */ SyncStatusStrategy f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                GlobalCashierPayPresenter.m15741a(GlobalCashierPayPresenter.this, this.f$1);
            }
        }, ((long) this.f21463e.getInterval()) * 1000);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m15741a(GlobalCashierPayPresenter globalCashierPayPresenter, SyncStatusStrategy syncStatusStrategy) {
        Intrinsics.checkNotNullParameter(globalCashierPayPresenter, "this$0");
        Intrinsics.checkNotNullParameter(syncStatusStrategy, "$strategy");
        GetPayStatusRequest getPayStatusRequest = new GetPayStatusRequest(false, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
        getPayStatusRequest.setScene(globalCashierPayPresenter.syncStatusScene());
        String mOutTradeId = globalCashierPayPresenter.getMOutTradeId();
        if (mOutTradeId == null) {
            mOutTradeId = "";
        }
        getPayStatusRequest.setOut_trade_id(mOutTradeId);
        getPayStatusRequest.setFirst_polling(Intrinsics.areEqual((Object) syncStatusStrategy.getAction(), (Object) SyncStatusStrategy.Companion.getFastPay()));
        Unit unit = Unit.INSTANCE;
        globalCashierPayPresenter.getPayStatus(getPayStatusRequest);
    }

    public void stopSyncPayResult() {
        this.f21463e.setSyncTimes(0);
        ICashierOperateProcessor iCashierOperateProcessor = (ICashierOperateProcessor) m15739a(ICashierOperateProcessor.class);
        if (iCashierOperateProcessor != null) {
            iCashierOperateProcessor.dismissLoading();
        }
    }

    public void requestSuccessInfo() {
        GetSuccessInfoRequest getSuccessInfoRequest = new GetSuccessInfoRequest((String) null, 1, (DefaultConstructorMarker) null);
        String mOutTradeId = getMOutTradeId();
        if (mOutTradeId == null) {
            mOutTradeId = "";
        }
        getSuccessInfoRequest.setOut_trade_id(mOutTradeId);
        Unit unit = Unit.INSTANCE;
        getSuccessInfo(getSuccessInfoRequest);
        ICashierOperateProcessor iCashierOperateProcessor = (ICashierOperateProcessor) m15739a(ICashierOperateProcessor.class);
        if (iCashierOperateProcessor != null) {
            ICashierOperateProcessor.DefaultImpls.loading$default(iCashierOperateProcessor, false, 0, 2, (Object) null);
        }
    }

    public void request3DSDetails(GlobalCashierAdyen3DSModel globalCashierAdyen3DSModel) {
        Intrinsics.checkNotNullParameter(globalCashierAdyen3DSModel, "data");
        PaymentThreeDSDetailsRequest paymentThreeDSDetailsRequest = new PaymentThreeDSDetailsRequest((String) null, 0, (String) null, (String) null, (String) null, 31, (DefaultConstructorMarker) null);
        paymentThreeDSDetailsRequest.setReference(globalCashierAdyen3DSModel.getReference());
        Integer channelId = globalCashierAdyen3DSModel.getChannelId();
        paymentThreeDSDetailsRequest.setChannel_id(channelId == null ? 150 : channelId.intValue());
        paymentThreeDSDetailsRequest.setVendor(globalCashierAdyen3DSModel.getVendor());
        paymentThreeDSDetailsRequest.setShopper(globalCashierAdyen3DSModel.getShopper());
        paymentThreeDSDetailsRequest.setAuth_details(globalCashierAdyen3DSModel.getAuth_details());
        Unit unit = Unit.INSTANCE;
        payment3DSDetails(paymentThreeDSDetailsRequest);
        ICashierOperateProcessor iCashierOperateProcessor = (ICashierOperateProcessor) m15739a(ICashierOperateProcessor.class);
        if (iCashierOperateProcessor != null) {
            ICashierOperateProcessor.DefaultImpls.loading$default(iCashierOperateProcessor, false, 0, 2, (Object) null);
        }
    }

    public void requestCVVInfo(CVVCardInfo cVVCardInfo) {
        GetCVVInfoRequest getCVVInfoRequest = new GetCVVInfoRequest((String) null, (CVVCardInfo) null, 3, (DefaultConstructorMarker) null);
        getCVVInfoRequest.setOut_trade_id(getMOutTradeId());
        getCVVInfoRequest.setExtra_info(cVVCardInfo);
        Unit unit = Unit.INSTANCE;
        getCvvInfo(getCVVInfoRequest);
        ICashierOperateProcessor iCashierOperateProcessor = (ICashierOperateProcessor) m15739a(ICashierOperateProcessor.class);
        if (iCashierOperateProcessor != null) {
            ICashierOperateProcessor.DefaultImpls.loading$default(iCashierOperateProcessor, false, 0, 2, (Object) null);
        }
    }

    public void getPolicy() {
        PayInfoResponse payInfo = PayInfoManager.getInstance().getPayInfo(getUniqueId());
        if (payInfo != null) {
            interceptPayInfo(payInfo);
        }
        ICashierPolicyProcessor iCashierPolicyProcessor = (ICashierPolicyProcessor) m15739a(ICashierPolicyProcessor.class);
        if (iCashierPolicyProcessor != null) {
            iCashierPolicyProcessor.onShowPrivacyPolicy(payInfo);
        }
    }

    public void requestConfirmPolicy(PolicyData policyData) {
        Intrinsics.checkNotNullParameter(policyData, "agreePolicy");
        AgreePolicyRequest agreePolicyRequest = new AgreePolicyRequest((String) null, (Boolean) null, (PolicyData) null, 7, (DefaultConstructorMarker) null);
        agreePolicyRequest.setOut_trade_id(getMOutTradeId());
        agreePolicyRequest.setAgree(true);
        agreePolicyRequest.setPolicy_info(policyData);
        Unit unit = Unit.INSTANCE;
        agreePolicy(agreePolicyRequest);
        ICashierOperateProcessor iCashierOperateProcessor = (ICashierOperateProcessor) m15739a(ICashierOperateProcessor.class);
        if (iCashierOperateProcessor != null) {
            ICashierOperateProcessor.DefaultImpls.loading$default(iCashierOperateProcessor, false, 0, 2, (Object) null);
        }
    }

    public void onAgreePolicyResponse(AgreePolicyResponse agreePolicyResponse) {
        Intrinsics.checkNotNullParameter(agreePolicyResponse, "response");
        ICashierPolicyProcessor iCashierPolicyProcessor = (ICashierPolicyProcessor) m15739a(ICashierPolicyProcessor.class);
        if (iCashierPolicyProcessor != null) {
            iCashierPolicyProcessor.onPolicyProcess(agreePolicyResponse);
        }
        ICashierOperateProcessor iCashierOperateProcessor = (ICashierOperateProcessor) m15739a(ICashierOperateProcessor.class);
        if (iCashierOperateProcessor != null) {
            iCashierOperateProcessor.dismissLoading();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m15740a(GlobalCashierPayPresenter globalCashierPayPresenter, PayInfoResponse payInfoResponse, IGlobalCashierNetPresenter.API api) {
        ICashierPayInfoProcessor iCashierPayInfoProcessor = (ICashierPayInfoProcessor) globalCashierPayPresenter.m15739a(ICashierPayInfoProcessor.class);
        if (iCashierPayInfoProcessor != null) {
            iCashierPayInfoProcessor.onPayInfoSuccess(globalCashierPayPresenter.f21462d, payInfoResponse, api);
        }
        CashierActionInterceptor cashierActionInterceptor = globalCashierPayPresenter.f21460b;
        if (cashierActionInterceptor != null) {
            CashierParam cashierParam = new CashierParam((String) null, (String) null, (String) null, (String) null, (Map) null, (Map) null, (String) null, 127, (DefaultConstructorMarker) null);
            cashierParam.setOutTradeId(globalCashierPayPresenter.getMOutTradeId());
            cashierParam.setNeedPayFeeTextDisplay(globalCashierPayPresenter.getMPayFeeTextDisplay());
            Unit unit = Unit.INSTANCE;
            cashierActionInterceptor.setCashierParam(cashierParam);
        }
        CashierActionInterceptor cashierActionInterceptor2 = globalCashierPayPresenter.f21460b;
        if (cashierActionInterceptor2 != null) {
            cashierActionInterceptor2.intercept(globalCashierPayPresenter.getContext(), payInfoResponse.getInitAction(), (Function0<Unit>[]) new Function0[0]);
        }
    }

    public void onPayInfoResponse(PayInfoResponse payInfoResponse, IGlobalCashierNetPresenter.API api) {
        Intrinsics.checkNotNullParameter(payInfoResponse, "response");
        Intrinsics.checkNotNullParameter(api, "API");
        if (payInfoResponse.success()) {
            PayInfoManager.getInstance().setPayInfo(getUniqueId(), payInfoResponse);
            interceptPayInfo(payInfoResponse);
            RouterOpenInterceptor routerOpenInterceptor = this.f21461c;
            if (routerOpenInterceptor != null) {
                routerOpenInterceptor.intercept(getContext(), (BaseRouterAdapter<?>) new PolicyRouterAdapter(payInfoResponse.getPolicyInfo()), (Function0<Unit>[]) new Function0[]{new GlobalCashierPayPresenter$onPayInfoResponse$1(this), new GlobalCashierPayPresenter$onPayInfoResponse$2(this, payInfoResponse, api)});
            }
        } else {
            Integer failedType = payInfoResponse.getFailedType();
            if (failedType != null && failedType.intValue() == 2) {
                ICashierDialogProcessor iCashierDialogProcessor = (ICashierDialogProcessor) m15739a(ICashierDialogProcessor.class);
                if (iCashierDialogProcessor != null) {
                    iCashierDialogProcessor.appUpgrade();
                }
            } else {
                Integer failedType2 = payInfoResponse.getFailedType();
                if (failedType2 != null && failedType2.intValue() == 1) {
                    ICashierDialogProcessor iCashierDialogProcessor2 = (ICashierDialogProcessor) m15739a(ICashierDialogProcessor.class);
                    if (iCashierDialogProcessor2 != null) {
                        GlobalCashierDialogCommonConfig globalCashierDialogCommonConfig = GlobalCashierDialogCommonConfig.CUSTOM_ERROR;
                        globalCashierDialogCommonConfig.setTitle(payInfoResponse.getFailedTitle());
                        globalCashierDialogCommonConfig.setSubTitle(payInfoResponse.getFailedReason());
                        Unit unit = Unit.INSTANCE;
                        iCashierDialogProcessor2.customError(globalCashierDialogCommonConfig, api);
                    }
                } else {
                    ICashierDialogProcessor iCashierDialogProcessor3 = (ICashierDialogProcessor) m15739a(ICashierDialogProcessor.class);
                    if (iCashierDialogProcessor3 != null) {
                        GlobalCashierDialogCommonConfig globalCashierDialogCommonConfig2 = GlobalCashierDialogCommonConfig.CUSTOM_ERROR;
                        globalCashierDialogCommonConfig2.setTitle("当前错误未指定");
                        globalCashierDialogCommonConfig2.setSubTitle("当前错误未指定 这里需要翻译资源");
                        Unit unit2 = Unit.INSTANCE;
                        iCashierDialogProcessor3.customError(globalCashierDialogCommonConfig2, api);
                    }
                }
            }
        }
        ICashierOperateProcessor iCashierOperateProcessor = (ICashierOperateProcessor) m15739a(ICashierOperateProcessor.class);
        if (iCashierOperateProcessor != null) {
            iCashierOperateProcessor.dismissLoading();
        }
    }

    /* access modifiers changed from: protected */
    public final void interceptPayInfo(PayInfoResponse payInfoResponse) {
        List<Payment.InstallmentVo.PlansVo> suggestPlans;
        PriceAmount actualAmount;
        Intrinsics.checkNotNullParameter(payInfoResponse, "response");
        OrderInfo orderInfo = payInfoResponse.getOrderInfo();
        this.f21467i = orderInfo == null ? null : orderInfo.getOutTradeId();
        OrderInfo orderInfo2 = payInfoResponse.getOrderInfo();
        this.f21468j = orderInfo2 == null ? null : orderInfo2.getAppId();
        OrderInfo orderInfo3 = payInfoResponse.getOrderInfo();
        this.f21470l = orderInfo3 == null ? null : orderInfo3.getProductId();
        OrderInfo orderInfo4 = payInfoResponse.getOrderInfo();
        this.f21471m = orderInfo4 == null ? null : orderInfo4.getOrderId();
        PriceInfo priceInfo = payInfoResponse.getPriceInfo();
        this.f21479u = (priceInfo == null || (actualAmount = priceInfo.getActualAmount()) == null) ? null : actualAmount.getDisplay();
        CashierOmegaUtils.Companion companion = CashierOmegaUtils.Companion;
        String str = this.f21470l;
        String str2 = "";
        if (str == null) {
            str = str2;
        }
        companion.setProductId(str);
        CashierOmegaUtils.Companion companion2 = CashierOmegaUtils.Companion;
        String str3 = this.f21471m;
        if (str3 == null) {
            str3 = str2;
        }
        companion2.setOid(str3);
        CashierOmegaUtils.Companion companion3 = CashierOmegaUtils.Companion;
        String str4 = this.f21467i;
        if (str4 != null) {
            str2 = str4;
        }
        companion3.setOutTradeId(str2);
        RouterOpenInterceptor routerOpenInterceptor = this.f21461c;
        if (routerOpenInterceptor != null) {
            CashierParam insByOutTradeId = CashierParam.Companion.insByOutTradeId(this.f21467i);
            insByOutTradeId.getExtraParams().putAll(getMExtraParams());
            Unit unit = Unit.INSTANCE;
            routerOpenInterceptor.setCashierParam(insByOutTradeId);
        }
        CashierActionInterceptor cashierActionInterceptor = this.f21460b;
        if (cashierActionInterceptor != null) {
            CashierParam insByOutTradeId2 = CashierParam.Companion.insByOutTradeId(this.f21467i);
            insByOutTradeId2.getExtraParams().putAll(getMExtraParams());
            Unit unit2 = Unit.INSTANCE;
            cashierActionInterceptor.setCashierParam(insByOutTradeId2);
        }
        this.f21476r.clear();
        getPaymentsFromPayInfo(payInfoResponse, this.f21476r, new GlobalCashierPayPresenter$interceptPayInfo$3(this));
        Collection arrayList = new ArrayList();
        Iterator it = this.f21476r.iterator();
        while (true) {
            boolean z = false;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            Payment payment = (Payment) next;
            Integer channelId = payment.getChannelId();
            if (channelId != null && channelId.intValue() == 150) {
                Payment.InstallmentVo installment = payment.getInstallment();
                if (installment == null ? false : Intrinsics.areEqual((Object) installment.getSupport(), (Object) true)) {
                    z = true;
                }
            }
            if (z) {
                arrayList.add(next);
            }
        }
        List<Payment> list = (List) arrayList;
        if (!list.isEmpty()) {
            for (Payment payment2 : list) {
                Payment.InstallmentVo installment2 = payment2.getInstallment();
                setMIsInstallment(Boolean.valueOf(installment2 == null ? false : Intrinsics.areEqual((Object) installment2.getSupport(), (Object) true)));
                Payment.InstallmentVo installment3 = payment2.getInstallment();
                if (!(installment3 == null || (suggestPlans = installment3.getSuggestPlans()) == null)) {
                    for (Payment.InstallmentVo.PlansVo plansVo : suggestPlans) {
                        if (plansVo.isSelected()) {
                            setMInstallmentPlan(plansVo.getNumber());
                        }
                    }
                }
            }
        } else {
            this.f21480v = null;
            this.f21481w = null;
        }
        this.f21477s.clear();
        List<BasicPayment> extraPayChannels = payInfoResponse.getExtraPayChannels();
        if (extraPayChannels != null) {
            getMExtraPayments().addAll(extraPayChannels);
        }
    }

    /* access modifiers changed from: protected */
    public final void getPaymentsFromPayInfo(PayInfoResponse payInfoResponse, List<Payment> list, Function2<? super Integer, ? super Payment, Boolean> function2) {
        List<PaymentGroup> paymentGroups;
        Intrinsics.checkNotNullParameter(list, "dst");
        Intrinsics.checkNotNullParameter(function2, "filter");
        if (payInfoResponse != null && (paymentGroups = payInfoResponse.getPaymentGroups()) != null) {
            for (PaymentGroup payments : paymentGroups) {
                List<Payment> payments2 = payments.getPayments();
                if (payments2 != null) {
                    int i = 0;
                    for (Object next : payments2) {
                        int i2 = i + 1;
                        if (i < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        if (function2.invoke(Integer.valueOf(i), (Payment) next).booleanValue()) {
                            list.add(next);
                        }
                        i = i2;
                    }
                    List list2 = list;
                }
            }
        }
    }

    public void onPrePayResponse(PrepayResponse prepayResponse) {
        Intrinsics.checkNotNullParameter(prepayResponse, "response");
        CashierActionInterceptor cashierActionInterceptor = this.f21460b;
        if (cashierActionInterceptor != null) {
            CashierParam cashierParam = new CashierParam((String) null, (String) null, (String) null, (String) null, (Map) null, (Map) null, (String) null, 127, (DefaultConstructorMarker) null);
            cashierParam.setOutTradeId(getMOutTradeId());
            cashierParam.setNeedPayFeeTextDisplay(getMPayFeeTextDisplay());
            Unit unit = Unit.INSTANCE;
            cashierActionInterceptor.setCashierParam(cashierParam);
        }
        CashierActionInterceptor cashierActionInterceptor2 = this.f21460b;
        if (cashierActionInterceptor2 != null) {
            cashierActionInterceptor2.intercept(getContext(), prepayResponse.getNextStep(), (Function0<Unit>[]) new Function0[]{new GlobalCashierPayPresenter$onPrePayResponse$2(this, prepayResponse), new GlobalCashierPayPresenter$onPrePayResponse$3(this, prepayResponse)});
        }
    }

    public void onPayStatusResponse(PayStatusResponse payStatusResponse) {
        Intrinsics.checkNotNullParameter(payStatusResponse, "response");
        int i = WhenMappings.$EnumSwitchMapping$0[this.f21463e.handle(payStatusResponse).ordinal()];
        if (i == 1) {
            PayInfoManager.getInstance().setPayStatus(getUniqueId(), payStatusResponse);
            ICashierSyncStatusProcessor iCashierSyncStatusProcessor = (ICashierSyncStatusProcessor) m15739a(ICashierSyncStatusProcessor.class);
            if (iCashierSyncStatusProcessor != null) {
                iCashierSyncStatusProcessor.onSyncSuccess(payStatusResponse);
            }
        } else if (i == 2) {
            CashierActionInterceptor cashierActionInterceptor = this.f21460b;
            if (cashierActionInterceptor != null) {
                cashierActionInterceptor.intercept(getContext(), payStatusResponse.getNextStep(), (Function0<Unit>[]) new Function0[]{new GlobalCashierPayPresenter$onPayStatusResponse$1(this, payStatusResponse), new GlobalCashierPayPresenter$onPayStatusResponse$2(this)});
            }
        } else if (i == 3) {
            ICashierOperateProcessor iCashierOperateProcessor = (ICashierOperateProcessor) m15739a(ICashierOperateProcessor.class);
            if (iCashierOperateProcessor != null) {
                iCashierOperateProcessor.dismissLoading();
            }
            ICashierSyncStatusProcessor iCashierSyncStatusProcessor2 = (ICashierSyncStatusProcessor) m15739a(ICashierSyncStatusProcessor.class);
            if (iCashierSyncStatusProcessor2 != null) {
                iCashierSyncStatusProcessor2.onSyncFail(payStatusResponse);
            }
        }
    }

    public void onSuccessInfoResponse(SuccessInfoResponse successInfoResponse) {
        Intrinsics.checkNotNullParameter(successInfoResponse, "response");
        ICashierOperateProcessor iCashierOperateProcessor = (ICashierOperateProcessor) m15739a(ICashierOperateProcessor.class);
        if (iCashierOperateProcessor != null) {
            iCashierOperateProcessor.dismissLoading();
        }
        ICashierResultProcessor iCashierResultProcessor = (ICashierResultProcessor) m15739a(ICashierResultProcessor.class);
        if (iCashierResultProcessor != null) {
            iCashierResultProcessor.successInfoProcess(successInfoResponse);
        }
    }

    public void onThreeDSDetailsResponse(PaymentThreeDSDetailsResponse paymentThreeDSDetailsResponse) {
        Intrinsics.checkNotNullParameter(paymentThreeDSDetailsResponse, "response");
        ICashier3DSProcessor iCashier3DSProcessor = (ICashier3DSProcessor) m15739a(ICashier3DSProcessor.class);
        if (iCashier3DSProcessor != null) {
            iCashier3DSProcessor.payment3DSDetailProcess(paymentThreeDSDetailsResponse);
        }
        CashierAction nextStep = paymentThreeDSDetailsResponse.getNextStep();
        GlobalCashierPayPresenter globalCashierPayPresenter = null;
        Integer threeDSResult = nextStep == null ? null : nextStep.threeDSResult();
        if (threeDSResult != null && threeDSResult.intValue() == 2) {
            CashierActionInterceptor cashierActionInterceptor = this.f21460b;
            if (cashierActionInterceptor != null) {
                cashierActionInterceptor.intercept(getContext(), paymentThreeDSDetailsResponse.getNextStep(), (Function0<Unit>[]) new Function0[]{new GlobalCashierPayPresenter$onThreeDSDetailsResponse$1(this)});
            }
        } else if (threeDSResult != null && threeDSResult.intValue() == 1) {
            GlobalCashierPayPresenter globalCashierPayPresenter2 = this;
            if (Intrinsics.areEqual((Object) paymentThreeDSDetailsResponse.getNeedPollingResult(), (Object) true)) {
                globalCashierPayPresenter = this;
            }
            GlobalCashierPayPresenter globalCashierPayPresenter3 = globalCashierPayPresenter;
            if (globalCashierPayPresenter3 != null) {
                Integer pollingTimes = paymentThreeDSDetailsResponse.getPollingTimes();
                int intValue = pollingTimes == null ? 10 : pollingTimes.intValue();
                Integer pollingFrequency = paymentThreeDSDetailsResponse.getPollingFrequency();
                globalCashierPayPresenter3.startSyncPayResult(new SyncStatusStrategy(intValue, pollingFrequency == null ? 3 : pollingFrequency.intValue(), SyncStatusStrategy.Companion.getNormal()));
            }
        } else {
            ICashierOperateProcessor iCashierOperateProcessor = (ICashierOperateProcessor) m15739a(ICashierOperateProcessor.class);
            if (iCashierOperateProcessor != null) {
                iCashierOperateProcessor.dismissLoading();
            }
        }
    }

    public void onCVVInfoResponse(CVVInfoResponse cVVInfoResponse) {
        Intrinsics.checkNotNullParameter(cVVInfoResponse, "response");
        ICashierOperateProcessor iCashierOperateProcessor = (ICashierOperateProcessor) m15739a(ICashierOperateProcessor.class);
        if (iCashierOperateProcessor != null) {
            iCashierOperateProcessor.dismissLoading();
        }
        ICashierCVVProcessor iCashierCVVProcessor = (ICashierCVVProcessor) m15739a(ICashierCVVProcessor.class);
        if (iCashierCVVProcessor != null) {
            iCashierCVVProcessor.onCvvInfoSuccess(cVVInfoResponse);
        }
    }

    public void onRequestFailed(IGlobalCashierNetPresenter.API api, CashierError cashierError) {
        ICashier3DSProcessor iCashier3DSProcessor;
        Intrinsics.checkNotNullParameter(api, "api");
        Intrinsics.checkNotNullParameter(cashierError, "error");
        ICashierOperateProcessor iCashierOperateProcessor = (ICashierOperateProcessor) m15739a(ICashierOperateProcessor.class);
        if (iCashierOperateProcessor != null) {
            iCashierOperateProcessor.dismissLoading();
        }
        ICashierDialogProcessor iCashierDialogProcessor = (ICashierDialogProcessor) m15739a(ICashierDialogProcessor.class);
        if (iCashierDialogProcessor != null) {
            iCashierDialogProcessor.netError(cashierError, api);
        }
        GlobalCashierPayPresenter globalCashierPayPresenter = this;
        GlobalCashierPayPresenter globalCashierPayPresenter2 = api == IGlobalCashierNetPresenter.API.PAYMENT_3DS_DETAILS ? this : null;
        if (globalCashierPayPresenter2 != null && (iCashier3DSProcessor = (ICashier3DSProcessor) globalCashierPayPresenter2.m15739a(ICashier3DSProcessor.class)) != null) {
            iCashier3DSProcessor.payment3DSDetailProcess(new PaymentThreeDSDetailsResponse((Boolean) null, (Integer) null, (Integer) null, (CashierAction) null, 15, (DefaultConstructorMarker) null));
        }
    }

    public IGlobalCashierPayView IView() {
        IGlobalCashierBaseView mView = getMView();
        if (mView instanceof IGlobalCashierPayView) {
            return (IGlobalCashierPayView) mView;
        }
        return null;
    }
}
