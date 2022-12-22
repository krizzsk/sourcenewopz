package com.didi.entrega.pay;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.entrega.bill.BillOmegaHelper;
import com.didi.entrega.customer.app.constant.AppConst;
import com.didi.entrega.customer.app.constant.Const;
import com.didi.entrega.customer.foundation.rpc.CustomerRpcManagerProxy;
import com.didi.entrega.customer.foundation.rpc.entity.PayChannel;
import com.didi.entrega.customer.foundation.util.DialogUtil;
import com.didi.entrega.customer.foundation.util.GsonUtil;
import com.didi.entrega.customer.pay.BindCardHelper;
import com.didi.entrega.customer.pay.ValidateCardHelper;
import com.didi.entrega.customer.repo.CustomerActivityResultRepo;
import com.didi.entrega.customer.repo.RepoFactory;
import com.didi.entrega.pay.Contract;
import com.didi.entrega.pay.model.PayMethodInfoModel;
import com.didi.entrega.uni_entrega_business.UniAPI;
import com.didi.entrega.uni_entrega_business.bill.GLEUniBillFlutterModuleService;
import com.didi.payment.creditcard.open.DidiGlobalAddCardData;
import com.didi.payment.paymethod.open.param.SignParam;
import com.didi.payment.wallet.global.utils.WalletRouter;
import com.didi.sdk.global.DidiGlobalPayApiFactory;
import com.didi.sdk.global.DidiGlobalPayMethodListData;
import com.didi.sdk.global.IDidiGlobalPayApi;
import com.didichuxing.dfbasesdk.utils.GsonUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\u0018\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0004H\u0016J\u0018\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\rH\u0016J\u0010\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\rH\u0016J\u0010\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\rH\u0016J\b\u0010\u001e\u001a\u00020\u0011H\u0016J\b\u0010\u001f\u001a\u00020\u0011H\u0014J\u000e\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u000fJ\b\u0010\"\u001a\u00020\u0011H\u0014J\u0010\u0010#\u001a\u00020\u00112\b\u0010!\u001a\u0004\u0018\u00010\u000fJ\b\u0010$\u001a\u00020\u0011H\u0002R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, mo175978d2 = {"Lcom/didi/entrega/pay/PayMethodPresenter;", "Lcom/didi/entrega/pay/Contract$AbsPayMethodPresenter;", "()V", "cardNum", "", "getCardNum", "()I", "mCartId", "", "mIsRefreshDataWhenResume", "", "mPayMethodInfoList", "", "Lcom/didi/entrega/pay/model/PayMethodInfoModel;", "mSelectedChannel", "Lcom/didi/entrega/customer/foundation/rpc/entity/PayChannel;", "getPayInfo", "", "goBindCard", "onClick99Pay", "payInfo", "channelState", "onClickCardPay", "cardPayInfo", "selectedCard", "Lcom/didi/entrega/pay/model/PayMethodInfoModel$CardInfoModel;", "onClickCashPay", "cashPayInfo", "onClickDidiCashPay", "onClickPayPay", "onClose", "onCreate", "onPayMethodSelect", "payChannel", "onResume", "trackSelectCard", "updateSelectedPayChannel", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PayMethodPresenter.kt */
public final class PayMethodPresenter extends Contract.AbsPayMethodPresenter {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public PayChannel f21004a;

    /* renamed from: b */
    private String f21005b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final List<PayMethodInfoModel> f21006c = new ArrayList();

    /* renamed from: d */
    private boolean f21007d;

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m15368a(Void voidR) {
    }

    public void onClose() {
        PayOmegaHelper.closePay(getScopeContext(), m15370c());
    }

    public void onClickCashPay(PayMethodInfoModel payMethodInfoModel) {
        PayMethodInfoModel payMethodInfoModel2 = payMethodInfoModel;
        Intrinsics.checkNotNullParameter(payMethodInfoModel2, "cashPayInfo");
        String str = payMethodInfoModel2.mChannelId;
        Intrinsics.checkNotNullExpressionValue(str, "cashPayInfo.mChannelId");
        PayChannel payChannel = new PayChannel((String) null, payMethodInfoModel2.mIconUrl, (String) null, Integer.parseInt(str), payMethodInfoModel2.mChannelName, (String) null, (String) null, 0, (String) null, (String) null, 0, (String) null, (String) null, (String) null, 0, 32741, (DefaultConstructorMarker) null);
        this.f21004a = payChannel;
        m15366a();
        trackSelectCard(payChannel);
        onPayMethodSelect(payChannel);
    }

    public void onClickCardPay(PayMethodInfoModel payMethodInfoModel, PayMethodInfoModel.CardInfoModel cardInfoModel) {
        PayMethodInfoModel payMethodInfoModel2 = payMethodInfoModel;
        PayMethodInfoModel.CardInfoModel cardInfoModel2 = cardInfoModel;
        Intrinsics.checkNotNullParameter(payMethodInfoModel2, "cardPayInfo");
        Intrinsics.checkNotNullParameter(cardInfoModel2, "selectedCard");
        if (cardInfoModel2.mDataType == 2) {
            DialogUtil.showLoadingDialog(getScopeContext(), false);
            m15369b();
        } else if (cardInfoModel2.needExValidate == 1) {
            ValidateCardHelper.validateCard(cardInfoModel2.cardSuffix, cardInfoModel2.cardIndex, 101);
        } else {
            String str = payMethodInfoModel2.mChannelId;
            Intrinsics.checkNotNullExpressionValue(str, "cardPayInfo.mChannelId");
            int parseInt = Integer.parseInt(str);
            PayChannel payChannel = new PayChannel(cardInfoModel2.cardIndex, cardInfoModel2.cardOrg, cardInfoModel2.cardSuffix, parseInt, (String) null, (String) null, (String) null, 0, (String) null, (String) null, 0, (String) null, (String) null, (String) null, 0, 32752, (DefaultConstructorMarker) null);
            this.f21004a = payChannel;
            m15366a();
            trackSelectCard(payChannel);
            onPayMethodSelect(payChannel);
        }
    }

    public void onClickDidiCashPay(PayMethodInfoModel payMethodInfoModel) {
        PayMethodInfoModel payMethodInfoModel2 = payMethodInfoModel;
        Intrinsics.checkNotNullParameter(payMethodInfoModel2, "cashPayInfo");
        String str = payMethodInfoModel2.mChannelId;
        Intrinsics.checkNotNullExpressionValue(str, "cashPayInfo.mChannelId");
        PayChannel payChannel = new PayChannel((String) null, payMethodInfoModel2.mIconUrl, (String) null, Integer.parseInt(str), payMethodInfoModel2.mChannelName, (String) null, (String) null, 0, (String) null, (String) null, 0, (String) null, (String) null, (String) null, 0, 32741, (DefaultConstructorMarker) null);
        this.f21004a = payChannel;
        m15366a();
        trackSelectCard(payChannel);
        onPayMethodSelect(payChannel);
    }

    public void onClickPayPay(PayMethodInfoModel payMethodInfoModel) {
        PayMethodInfoModel payMethodInfoModel2 = payMethodInfoModel;
        Intrinsics.checkNotNullParameter(payMethodInfoModel2, "payInfo");
        if (payMethodInfoModel2.mIsSigned == 1) {
            String str = payMethodInfoModel2.mChannelId;
            Intrinsics.checkNotNullExpressionValue(str, "payInfo.mChannelId");
            PayChannel payChannel = new PayChannel((String) null, payMethodInfoModel2.mIconUrl, (String) null, Integer.parseInt(str), (String) null, (String) null, (String) null, 0, (String) null, (String) null, 0, (String) null, (String) null, (String) null, 0, 32757, (DefaultConstructorMarker) null);
            this.f21004a = payChannel;
            m15366a();
            trackSelectCard(payChannel);
            onPayMethodSelect(payChannel);
            return;
        }
        SignParam signParam = new SignParam();
        String str2 = payMethodInfoModel2.mChannelId;
        Intrinsics.checkNotNullExpressionValue(str2, "payInfo.mChannelId");
        signParam.channelId = Integer.parseInt(str2);
        signParam.bindType = 14;
        BindCardHelper.bindPayPay(getScopeContext(), signParam, new PayMethodPresenter$onClickPayPay$1(payMethodInfoModel2, this));
    }

    public void onClick99Pay(PayMethodInfoModel payMethodInfoModel, int i) {
        PayMethodInfoModel payMethodInfoModel2 = payMethodInfoModel;
        int i2 = i;
        Intrinsics.checkNotNullParameter(payMethodInfoModel2, "payInfo");
        if (i2 == 0) {
            String str = payMethodInfoModel2.mChannelId;
            Intrinsics.checkNotNullExpressionValue(str, "payInfo.mChannelId");
            PayChannel payChannel = new PayChannel((String) null, payMethodInfoModel2.mIconUrl, (String) null, Integer.parseInt(str), (String) null, (String) null, (String) null, 0, (String) null, (String) null, 0, (String) null, (String) null, (String) null, 0, 32757, (DefaultConstructorMarker) null);
            this.f21004a = payChannel;
            m15366a();
            trackSelectCard(payChannel);
            onPayMethodSelect(payChannel);
        } else if (i2 == 1) {
            if (payMethodInfoModel2.mIsBindCard == 1) {
                Context context = getContext();
                if (context != null) {
                    WalletRouter.gotoTopupOnlinePay((FragmentActivity) context, 8);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
                }
            } else {
                WalletRouter.gotoTopUpChannelPage(getContext(), 10);
            }
            this.f21007d = true;
        } else if (i2 == 2) {
            DidiGlobalPayMethodListData.PayMethodListParam payMethodListParam = new DidiGlobalPayMethodListData.PayMethodListParam(DidiGlobalPayMethodListData.Entrance.FROM_SIDEBAR);
            IDidiGlobalPayApi createDidiPay = DidiGlobalPayApiFactory.createDidiPay();
            Context context2 = getContext();
            if (context2 != null) {
                createDidiPay.startPayMethodListActivity((Activity) context2, 1, payMethodListParam);
                this.f21007d = true;
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
        }
    }

    public final void trackSelectCard(PayChannel payChannel) {
        BillOmegaHelper.INSTANCE.tracePayMethodCK(this.f21005b, payChannel == null ? null : Integer.valueOf(payChannel.getChannelId()));
    }

    /* access modifiers changed from: protected */
    public void onCreate() {
        super.onCreate();
        try {
            this.f21004a = (PayChannel) GsonUtils.fromJson(GsonUtils.toJson(getScopeContext().getBundle().getSerializable(Const.BundleKey.SELECT_PAYMENT_DATA)), PayChannel.class);
        } catch (Exception unused) {
        }
        if (this.f21004a == null) {
            this.f21004a = (PayChannel) getScopeContext().getBundle().getSerializable("payMethodPage");
        }
        this.f21005b = getScopeContext().getBundle().getString(Const.BundleKey.CART_ID);
        m15371d();
        BillOmegaHelper.INSTANCE.tracePayMethodSW(this.f21005b);
        ((CustomerActivityResultRepo) RepoFactory.getRepo(CustomerActivityResultRepo.class)).subscribeResult(getScopeContext(), new Action1() {
            public final void call(Object obj) {
                PayMethodPresenter.m15367a(PayMethodPresenter.this, (CustomerActivityResultRepo.ActivityResult) obj);
            }
        }, 101, 1);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m15367a(PayMethodPresenter payMethodPresenter, CustomerActivityResultRepo.ActivityResult activityResult) {
        Intrinsics.checkNotNullParameter(payMethodPresenter, "this$0");
        if (activityResult == null) {
            return;
        }
        if (activityResult.requestCode == 101) {
            payMethodPresenter.m15371d();
        } else if (activityResult.requestCode == 1) {
            payMethodPresenter.m15371d();
            PayOmegaHelper.bindCardResult(activityResult, "bill");
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (this.f21007d) {
            this.f21007d = false;
            m15371d();
        }
    }

    /* renamed from: a */
    private final void m15366a() {
        PayChannel payChannel = this.f21004a;
        if (payChannel != null) {
            for (PayMethodInfoModel next : this.f21006c) {
                boolean equals = TextUtils.equals(payChannel.toString(), next.mChannelId);
                next.mIsSelected = equals;
                if (next.mCardInfoList != null) {
                    Iterator<PayMethodInfoModel.CardInfoModel> it = next.mCardInfoList.iterator();
                    while (it.hasNext()) {
                        PayMethodInfoModel.CardInfoModel next2 = it.next();
                        next2.mIsSelected = equals && TextUtils.equals(payChannel.getCardIndex(), next2.cardIndex);
                    }
                }
            }
            ((Contract.AbsPayMethodView) getLogicView()).updateView(this.f21006c);
        }
    }

    public final void onPayMethodSelect(PayChannel payChannel) {
        Intrinsics.checkNotNullParameter(payChannel, "payChannel");
        Bundle bundle = new Bundle();
        if (getScopeContext().getBundle().getInt("pay_scene", 0) == 0) {
            HashMap hashMap = new HashMap();
            String string = getScopeContext().getBundle().getString("fromPage", "");
            Map map = hashMap;
            String json = GsonUtil.toJson(payChannel);
            Intrinsics.checkNotNullExpressionValue(json, "toJson(payChannel)");
            map.put("payChannel", json);
            Intrinsics.checkNotNullExpressionValue(string, "fromPage");
            map.put("fromPage", string);
            ((GLEUniBillFlutterModuleService) UniAPI.get(GLEUniBillFlutterModuleService.class)).updateBillInfoData(GsonUtil.toJson(hashMap), $$Lambda$PayMethodPresenter$abobTE6WkxDPBk2C1eNQ2nIikU.INSTANCE);
            getScopeContext().getNavigator().finish();
            return;
        }
        bundle.putSerializable("payMethodPage", payChannel);
        getScopeContext().getNavigator().finish(bundle);
    }

    /* renamed from: b */
    private final void m15369b() {
        DidiGlobalAddCardData.AddCardParam addCardParam = new DidiGlobalAddCardData.AddCardParam();
        addCardParam.bindType = 14;
        addCardParam.isShowLoading = true;
        addCardParam.isSignAfterOrder = true;
        addCardParam.productLine = AppConst.BUSINESS_ID;
        BindCardHelper.bindCard(addCardParam, 1);
        BillOmegaHelper.INSTANCE.tracePayMethodAddCardCk(this.f21005b);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public final int m15370c() {
        return PayMethodInfoModel.findCardNum(this.f21006c);
    }

    /* renamed from: d */
    private final void m15371d() {
        if (getScopeContext() != null) {
            DialogUtil.showLoadingDialog(getScopeContext(), false);
            int i = getScopeContext().getBundle().getInt("pay_scene", 0);
            int i2 = getScopeContext().getBundle().getInt("pay_method_price", 0);
            CustomerRpcManagerProxy.get().getPayInfo(String.valueOf(i2), i, getScopeContext().getBundle().getString(Const.BundleKey.CART_ID), new PayMethodPresenter$getPayInfo$1(this));
        }
    }
}
