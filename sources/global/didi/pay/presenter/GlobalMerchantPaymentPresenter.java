package global.didi.pay.presenter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.didi.sdk.util.UiThreadHandler;
import com.didi.unifiedPay.UnifiedPaySystem;
import com.didi.unifiedPay.component.IViewCallback;
import com.didi.unifiedPay.component.model.PayParam;
import com.didi.unifiedPay.sdk.internal.PayConstant;
import com.didi.unifiedPay.sdk.internal.api.IUnifiedPayApi;
import com.didi.unifiedPay.sdk.model.EventInfoModel;
import com.didi.unifiedPay.sdk.model.PayInfo;
import global.didi.pay.IGlobalPayView;
import global.didi.pay.merchant.GlobalMerchantUniPayActivity;
import global.didi.pay.merchant.GlobalMerchantUniPayStatusActivity;
import global.didi.pay.merchant.processor.GlobalMerchantUnifiedPayProcessor;
import global.didi.pay.merchant.processor.model.MerchantRequestType;
import global.didi.pay.merchant.processor.model.MerchantResponseFactory;
import global.didi.pay.merchantcore.DSchemeConstantKt;
import global.didi.pay.merchantcore.model.DPayRequest;
import global.didi.pay.merchantcore.model.DPayResponse;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;
import org.json.JSONObject;

@Metadata(mo175977d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\b\u0010\u0011\u001a\u00020\u0012H\u0014J\b\u0010\u0013\u001a\u00020\u0007H\u0014J\b\u0010\u0014\u001a\u00020\u0015H\u0014J\b\u0010\u0016\u001a\u00020\u0007H\u0014J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0018H\u0016J\b\u0010\u001c\u001a\u00020\u0018H\u0014J\u001a\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u00122\b\u0010\u001f\u001a\u0004\u0018\u00010\u0007H\u0014J,\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010\u00072\u0006\u0010&\u001a\u00020\u0012H\u0014R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000¨\u0006'"}, mo175978d2 = {"Lglobal/didi/pay/presenter/GlobalMerchantPaymentPresenter;", "Lglobal/didi/pay/presenter/GlobalAbsPaymentPresenter;", "context", "Landroid/content/Context;", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "sid", "", "viewCallback", "Lcom/didi/unifiedPay/component/IViewCallback;", "(Landroid/content/Context;Landroidx/fragment/app/FragmentManager;Ljava/lang/String;Lcom/didi/unifiedPay/component/IViewCallback;)V", "mDPayRequest", "Lglobal/didi/pay/merchantcore/model/DPayRequest;", "mExtraParam", "Lorg/json/JSONObject;", "mMerchantType", "Lglobal/didi/pay/merchant/processor/model/MerchantRequestType;", "getBid", "", "getOrderId", "getPayBillType", "Lcom/didi/unifiedPay/sdk/internal/PayConstant$PayBillType;", "getVerifyScene", "onAdd", "", "arguments", "Landroid/os/Bundle;", "onDateClean", "onInterceptConfirm", "onPaySuccessed", "payStatus", "statusMsg", "requestPayInfoResult", "isSuccess", "", "payinfo", "Lcom/didi/unifiedPay/sdk/model/PayInfo;", "errorMsg", "errorCode", "pay_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalMerchantPaymentPresenter.kt */
public final class GlobalMerchantPaymentPresenter extends GlobalAbsPaymentPresenter {
    private DPayRequest mDPayRequest;
    private JSONObject mExtraParam;
    private MerchantRequestType mMerchantType;

    /* access modifiers changed from: protected */
    public int getBid() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public String getOrderId() {
        return "MerchantOidPlaceHolder";
    }

    /* access modifiers changed from: protected */
    public String getVerifyScene() {
        return "CHECK_OUT_MERCHANT";
    }

    public void onDateClean() {
    }

    public GlobalMerchantPaymentPresenter(Context context, FragmentManager fragmentManager, String str, IViewCallback iViewCallback) {
        super(context, fragmentManager, str, iViewCallback);
    }

    /* access modifiers changed from: protected */
    public PayConstant.PayBillType getPayBillType() {
        return PayConstant.PayBillType.Merchant;
    }

    public void onAdd(Bundle bundle) {
        JSONObject jSONObject;
        Intrinsics.checkNotNullParameter(bundle, "arguments");
        this.mPayParam = (PayParam) bundle.getSerializable("pay_param");
        DPayRequest dPayRequest = (DPayRequest) bundle.getParcelable("request");
        if (dPayRequest == null) {
            dPayRequest = DPayRequest.Companion.getEMPTY();
        }
        this.mDPayRequest = dPayRequest;
        Serializable serializable = bundle.getSerializable(GlobalMerchantUniPayActivity.MERCHANT_REQUEST_TYPE);
        if (serializable != null) {
            this.mMerchantType = (MerchantRequestType) serializable;
            String string = bundle.getString(DSchemeConstantKt.EXTRA_JSON_PARAM);
            if (string == null) {
                jSONObject = null;
            } else {
                jSONObject = new JSONObject(string);
            }
            this.mExtraParam = jSONObject;
            this.mUnifiedPaySystem = UnifiedPaySystem.createUnifiedPay(this.mContext, getPayBillType());
            this.mUnifiedPaySystem.setPayParam(this.mPayParam);
            this.mUnifiedPaySystem.setDPayRequest(this.mDPayRequest);
            this.mUnifiedPaySystem.setExtraParam(this.mExtraParam);
            IUnifiedPayApi iUnifiedPayApi = this.mUnifiedPaySystem;
            MerchantRequestType merchantRequestType = this.mMerchantType;
            if (merchantRequestType != null) {
                iUnifiedPayApi.setRequestType(merchantRequestType);
                this.mUnifiedPaySystem.init(0, getOrderId(), this.mFragmentManager);
                prepareData();
                this.mAdyen3DS.registerListener(this);
                ((IGlobalPayView) this.mView).setPixViewListener(this);
                if (!EventBus.getDefault().isRegistered(this)) {
                    EventBus.getDefault().register(this);
                    return;
                }
                return;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mMerchantType");
            throw null;
        }
        throw new NullPointerException("null cannot be cast to non-null type global.didi.pay.merchant.processor.model.MerchantRequestType");
    }

    /* access modifiers changed from: protected */
    public void requestPayInfoResult(boolean z, PayInfo payInfo, String str, int i) {
        ((IGlobalPayView) this.mView).hideLoadingPop(true);
        super.requestPayInfoResult(z, payInfo, str, i);
    }

    /* access modifiers changed from: protected */
    public void onInterceptConfirm() {
        EventInfoModel eventInfoModel;
        GlobalMerchantUnifiedPayProcessor globalMerchantUnifiedPayProcessor = GlobalMerchantUnifiedPayProcessor.INS;
        FragmentActivity fragmentActivity = this.mFragmentActivity;
        Intrinsics.checkNotNullExpressionValue(fragmentActivity, "mFragmentActivity");
        Context context = fragmentActivity;
        MerchantResponseFactory.Companion companion = MerchantResponseFactory.Companion;
        MerchantRequestType merchantRequestType = this.mMerchantType;
        String str = null;
        if (merchantRequestType != null) {
            DPayResponse cancel = DPayResponse.Companion.getCANCEL();
            PayInfo curPayInfo = getCurPayInfo();
            if (!(curPayInfo == null || (eventInfoModel = curPayInfo.eventInfo) == null)) {
                str = eventInfoModel.getReturnUrl();
            }
            globalMerchantUnifiedPayProcessor.onHandleMerchantResponse(context, companion.getInstance(merchantRequestType, cancel, str));
            super.onInterceptConfirm();
            return;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mMerchantType");
        throw null;
    }

    /* access modifiers changed from: protected */
    public void onPaySuccessed(int i, String str) {
        if (getCurPayStaus() == null) {
            this.mUnifiedPaySystem.registerCallback(this.mPayCallback);
            this.mUnifiedPaySystem.startSyncPayResult(15, 3000);
            return;
        }
        super.onPaySuccessed(i, str);
        UiThreadHandler.postDelayed(new Runnable() {
            public final void run() {
                GlobalMerchantPaymentPresenter.m47657onPaySuccessed$lambda1(GlobalMerchantPaymentPresenter.this);
            }
        }, 1000);
    }

    /* access modifiers changed from: private */
    /* renamed from: onPaySuccessed$lambda-1  reason: not valid java name */
    public static final void m47657onPaySuccessed$lambda1(GlobalMerchantPaymentPresenter globalMerchantPaymentPresenter) {
        Intrinsics.checkNotNullParameter(globalMerchantPaymentPresenter, "this$0");
        GlobalMerchantUniPayStatusActivity.Companion companion = GlobalMerchantUniPayStatusActivity.Companion;
        FragmentActivity fragmentActivity = globalMerchantPaymentPresenter.mFragmentActivity;
        Intrinsics.checkNotNullExpressionValue(fragmentActivity, "mFragmentActivity");
        Activity activity = fragmentActivity;
        String orderId = globalMerchantPaymentPresenter.getOrderId();
        MerchantRequestType merchantRequestType = globalMerchantPaymentPresenter.mMerchantType;
        if (merchantRequestType != null) {
            companion.startActivity(activity, orderId, merchantRequestType);
            if (globalMerchantPaymentPresenter.mFragmentActivity != null) {
                globalMerchantPaymentPresenter.mFragmentActivity.finish();
                return;
            }
            return;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mMerchantType");
        throw null;
    }
}
