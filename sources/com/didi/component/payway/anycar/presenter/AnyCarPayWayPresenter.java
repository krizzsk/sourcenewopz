package com.didi.component.payway.anycar.presenter;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.constant.PaymentsApi;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.data.form.PageCompDataTransfer;
import com.didi.component.business.data.form.listener.ConfirmListener;
import com.didi.component.business.oneconfig.AbsConfirmConfigState;
import com.didi.component.business.tracker.GPageIdConstant;
import com.didi.component.business.tracker.anycar.AnycarTrack;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.NationComponentDataUtil;
import com.didi.component.business.util.Utils;
import com.didi.component.business.xengine.XERequestKey;
import com.didi.component.common.dialog.NormalDialogInfo;
import com.didi.component.common.router.PayRouterHandler;
import com.didi.component.common.util.DateConverUtils;
import com.didi.component.common.util.GlobalTipsPriorityManager;
import com.didi.component.common.util.GsonUtils;
import com.didi.component.common.util.SearchIdUploadManager;
import com.didi.component.common.widget.NewBubbleHelper;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.IPresenter;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.payway.anycar.callback.NewPopShowResultListener;
import com.didi.component.payway.anycar.view.IAnycarPayWayView;
import com.didi.drouter.api.DRouter;
import com.didi.payment.creditcard.open.DidiGlobalAddCardData;
import com.didi.sdk.global.DidiGlobalCardExpireInterceptData;
import com.didi.sdk.global.DidiGlobalPayApiFactory;
import com.didi.sdk.global.DidiGlobalPayMethodListData;
import com.didi.sdk.global.common.com.EnterpriseInfo;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.sidebar.setup.mutilocale.MultiLocaleStore;
import com.didi.sdk.util.AssetsUtil;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.util.ToastHelper;
import com.didi.sdk.util.UiThreadHandler;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didi.travel.psnger.datasource.BubbleSourceManager;
import com.didi.travel.psnger.model.response.PayEnterpriseInfo;
import com.didi.travel.psnger.model.response.PayWayModel;
import com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel;
import com.didi.travel.psnger.model.response.anycar.AnyCarPayModel;
import com.didi.travel.psnger.model.response.estimate.CarBubbleModule;
import com.didi.travel.psnger.model.response.estimate.CarBusinessConfig;
import com.didi.travel.psnger.model.response.estimate.CarPayExtraItemInfo;
import com.didi.travel.psnger.model.response.estimate.CarPayInfoModel;
import com.didi.travel.psnger.model.response.newbubbleParams.BubbleItemModel;
import com.didi.xengine.callback.XEReqJSONParamsCallbackImpl;
import com.didi.xengine.register.XERegister;
import com.didichuxing.omega.sdk.init.OmegaSDK;
import com.didiglobal.enginecore.callback.XEResponseCallback;
import com.didiglobal.enginecore.component.XEComponent;
import com.didiglobal.enginecore.data.exception.EngineErrorException;
import com.didiglobal.enginecore.data.model.XEngineData;
import com.didiglobal.enginecore.register.XERegisterModel;
import com.didiglobal.travel.util.CollectionUtils;
import com.google.gson.JsonObject;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class AnyCarPayWayPresenter extends AbsPayWayPresenter {

    /* renamed from: a */
    private static final String f15120a = "brz_payments/default_payments";

    /* renamed from: b */
    private static final String f15121b = "brz_payments/guarana_default_payments";

    /* renamed from: c */
    private static final int f15122c = 2;

    /* renamed from: d */
    private static final int f15123d = 3;

    /* renamed from: e */
    private static final int f15124e = 1;

    /* renamed from: f */
    private static final int f15125f = 1100;

    /* renamed from: g */
    private static final int f15126g = 3;

    /* renamed from: h */
    private static final int f15127h = 1101;

    /* renamed from: A */
    private Runnable f15128A;
    public EnterpriseInfo enterpriseInfo;

    /* renamed from: i */
    private AnyCarPayWayHelper f15129i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public boolean f15130j = false;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public AnyCarPayModel f15131k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public AnyCarPayModel f15132l;

    /* renamed from: m */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f15133m = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (AnyCarPayWayPresenter.this.m10829e()) {
                ((IAnycarPayWayView) AnyCarPayWayPresenter.this.mView).dismissPopup();
            }
        }
    };
    protected final Logger mLogger = LoggerFactory.getLogger(getClass());
    protected List<PayWayModel.PayWayItem> mPaywayItems;
    public List<PayWayModel.PayWayItem> mSelectedPaywayItem = new ArrayList();

    /* renamed from: n */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f15134n = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (AnyCarPayWayPresenter.this.m10829e()) {
                AnyCarPayModel c = AnyCarPayWayPresenter.this.f15132l;
                if (AnyCarPayWayPresenter.this.f15130j && !AnyCarPayWayPresenter.this.showGuidePopup()) {
                    AnyCarPayWayPresenter.this.showPayWayGuideIfNeed(c);
                }
            }
        }
    };

    /* renamed from: p */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f15135p = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (AnyCarPayWayPresenter.this.m10829e()) {
                ((IAnycarPayWayView) AnyCarPayWayPresenter.this.mView).dismissPopup();
            }
        }
    };

    /* renamed from: q */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f15136q = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (AnyCarPayWayPresenter.this.m10829e()) {
                boolean unused = AnyCarPayWayPresenter.this.f15130j = true;
                AnyCarPayModel c = AnyCarPayWayPresenter.this.f15132l;
                if (!AnyCarPayWayPresenter.this.showGuidePopup()) {
                    AnyCarPayWayPresenter.this.showPayWayGuideIfNeed(c);
                }
            }
        }
    };

    /* renamed from: r */
    private BaseEventPublisher.OnEventListener<PayRouterHandler.PayRouterModel> f15137r = new BaseEventPublisher.OnEventListener<PayRouterHandler.PayRouterModel>() {
        public void onEvent(String str, PayRouterHandler.PayRouterModel payRouterModel) {
            PayRouterHandler.PayInfo payInfo;
            List<PayWayModel.PayWayItem> payWayItem;
            if (!AnyCarPayWayPresenter.this.m10829e() || payRouterModel == null || TextUtils.isEmpty(payRouterModel.actionType) || (payInfo = payRouterModel.payInfo) == null) {
                return;
            }
            if ("1".equals(payRouterModel.actionType)) {
                if (payInfo.resourceId != 0) {
                    DidiGlobalAddCardData.AddCardParam addCardParam = new DidiGlobalAddCardData.AddCardParam();
                    addCardParam.bindType = 8;
                    addCardParam.isShowLoading = true;
                    addCardParam.isSignAfterOrder = false;
                    addCardParam.resourceId = String.valueOf(payInfo.resourceId);
                    addCardParam.discountContent = payInfo.toAddCardInfo;
                    DidiGlobalPayApiFactory.createDidiPay().startAddCreditCardActivity(AnyCarPayWayPresenter.this.getHost(), AnyCarPayWayPresenter.this.requestCodeForHost(1), addCardParam);
                    boolean unused = AnyCarPayWayPresenter.this.f15138s = true;
                }
            } else if ("2".equals(payRouterModel.actionType)) {
                if (payInfo.resourceId != 0) {
                    AnyCarPayWayPresenter.this.onFormPayWayClicked(String.valueOf(payInfo.resourceId));
                }
            } else if ("3".equals(payRouterModel.actionType) && payInfo.payTag != 0 && (payWayItem = AnyCarPayWayPresenter.this.getPayWayItem(payInfo.payTag)) != null && !payWayItem.isEmpty()) {
                AnyCarPayWayPresenter.this.setPayWayToForm(payWayItem);
                AnyCarPayWayPresenter.this.doPublish(BaseEventKeys.Estimate.ESTIMATE_GET_ESTIMATE);
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: s */
    public boolean f15138s = false;
    public DidiGlobalPayMethodListData.PayMethodListResult selectedResults;

    /* renamed from: t */
    private XEResponseCallback f15139t = new XEResponseCallback() {
        public void onSuccess(String str, XEngineData xEngineData, List<XEComponent> list) {
            if (xEngineData != null) {
                AnyCarPayWayPresenter.this.m10810a(xEngineData.jsonObject);
            } else {
                AnyCarPayWayPresenter.this.refreshPayWay(false);
            }
        }

        public void onFailed(String str, EngineErrorException engineErrorException) {
            AnyCarPayWayPresenter.this.refreshPayWay(false);
        }
    };

    /* renamed from: u */
    private XEReqJSONParamsCallbackImpl f15140u = new XEReqJSONParamsCallbackImpl() {
        public JSONObject getRequestParams() {
            return new JSONObject(new HashMap());
        }
    };

    /* renamed from: v */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f15141v = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (AnyCarPayWayPresenter.this.m10829e()) {
                ((IAnycarPayWayView) AnyCarPayWayPresenter.this.mView).dismissPopup();
            }
        }
    };

    /* renamed from: w */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f15142w = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (AnyCarPayWayPresenter.this.m10829e() && TextUtils.equals(BaseEventKeys.Confirm.SHOW_PAYMENTS, str)) {
                AnyCarPayWayPresenter.this.onFormPayWayClicked();
            }
        }
    };

    /* renamed from: x */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f15143x = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (TextUtils.equals(BaseEventKeys.Estimate.ESTIMATE_IS_LOADING, str)) {
                ((IAnycarPayWayView) AnyCarPayWayPresenter.this.mView).dismissPopup();
                ((IAnycarPayWayView) AnyCarPayWayPresenter.this.mView).hide();
            }
        }
    };

    /* renamed from: y */
    private BaseEventPublisher.OnEventListener<PayWayModel.PayWayItem> f15144y = new BaseEventPublisher.OnEventListener<PayWayModel.PayWayItem>() {
        public void onEvent(String str, final PayWayModel.PayWayItem payWayItem) {
            if (AnyCarPayWayPresenter.this.m10829e() && payWayItem != null) {
                DidiGlobalCardExpireInterceptData.CardExpireInterceptParam cardExpireInterceptParam = new DidiGlobalCardExpireInterceptData.CardExpireInterceptParam();
                cardExpireInterceptParam.cardNo = payWayItem.getCard();
                cardExpireInterceptParam.icon = payWayItem.getIconUrl();
                cardExpireInterceptParam.type = 0;
                DidiGlobalPayApiFactory.createDidiPay().startCardExpireIntercept(AnyCarPayWayPresenter.this.getHost(), cardExpireInterceptParam, (DidiGlobalCardExpireInterceptData.CardExpireInterceptCallback) new DidiGlobalCardExpireInterceptData.CardExpireInterceptCallback() {
                    public void onClick(int i) {
                        if (i == 0) {
                            DidiGlobalAddCardData.AddCardParam addCardParam = new DidiGlobalAddCardData.AddCardParam();
                            addCardParam.bindType = 8;
                            addCardParam.isShowLoading = true;
                            addCardParam.isSignAfterOrder = false;
                            addCardParam.cardNo = payWayItem.getCard();
                            DidiGlobalPayApiFactory.createDidiPay().startAddCreditCardActivity(AnyCarPayWayPresenter.this.getHost(), AnyCarPayWayPresenter.this.requestCodeForHost(1), addCardParam);
                            return;
                        }
                        AnyCarPayWayPresenter.this.onFormPayWayClicked();
                    }
                });
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: z */
    public final HashSet<String> f15145z = new HashSet<>();

    /* access modifiers changed from: protected */
    public void checkPaywayDialog(List<PayWayModel.PayWayItem> list) {
    }

    public void onPayWayCloseClicked(int i, int i2) {
    }

    public void onPayWayGuideClicked(int i, int i2) {
    }

    public AnyCarPayWayPresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10810a(JsonObject jsonObject) {
        if (getHost() == null || getHost().getActivity() == null || jsonObject == null || TextUtils.isEmpty(jsonObject.toString())) {
            refreshPayWay(false);
        } else {
            m10811a(jsonObject.toString());
        }
    }

    /* renamed from: a */
    private void m10811a(String str) {
        if (str != null) {
            try {
                JSONObject optJSONObject = new JSONObject(str).optJSONObject("data");
                if (optJSONObject != null) {
                    m10820b(optJSONObject.toString());
                }
            } catch (JSONException e) {
                e.printStackTrace();
                refreshPayWay(false);
            }
        } else {
            refreshPayWay(false);
        }
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        XERegisterModel xERegisterModel = new XERegisterModel(XERequestKey.SingleCompRefresh.REQUEST_KEY_ANYCAR_USER_PAY_INFO, XERequestKey.SCENE_ESTIMATE, this.f15139t);
        xERegisterModel.requestParams = this.f15140u;
        XERegister.registerTemplate(xERegisterModel);
        ((IAnycarPayWayView) this.mView).setContentDescription("");
        this.f15145z.clear();
        m10824c();
        m10818b();
    }

    /* renamed from: b */
    private void m10820b(String str) {
        GsonUtils.fromJsonAsync(str, AnyCarPayModel.class, new GsonUtils.OnFromJsonListener<AnyCarPayModel>() {
            public void onSuccess(AnyCarPayModel anyCarPayModel) {
                ConfirmListener confirmListener = PageCompDataTransfer.getInstance().getConfirmListener();
                if (anyCarPayModel != null) {
                    ((IAnycarPayWayView) AnyCarPayWayPresenter.this.mView).setData(anyCarPayModel);
                    AnyCarPayModel unused = AnyCarPayWayPresenter.this.f15131k = anyCarPayModel;
                    AnyCarPayWayPresenter anyCarPayWayPresenter = AnyCarPayWayPresenter.this;
                    AnyCarPayModel unused2 = anyCarPayWayPresenter.f15132l = anyCarPayWayPresenter.payModelAdapter(anyCarPayModel);
                    if (FormStore.getInstance().isShowPayWayAfterEstimate()) {
                        AnyCarPayWayPresenter.this.doPublish(BaseEventKeys.Confirm.SHOW_PAYMENTS);
                        FormStore.getInstance().setShowPayWayAfterEstimate(false);
                    }
                    if (confirmListener != null) {
                        confirmListener.setAnycarPayModel(AnyCarPayWayPresenter.this.f15132l);
                    }
                    AnyCarPayWayPresenter.this.refreshPayWay(true);
                    return;
                }
                AnyCarPayWayPresenter.this.refreshPayWay(false);
            }

            public void onFail() {
                AnyCarPayWayPresenter.this.refreshPayWay(false);
            }
        });
    }

    public AnyCarPayModel payModelAdapter(AnyCarPayModel anyCarPayModel) {
        anyCarPayModel.payWayList = new ArrayList();
        if (CollectionUtils.isNotEmpty((Collection<?>) anyCarPayModel.carPayInfo)) {
            for (CarPayInfoModel carPayInfoToPayWayItem : anyCarPayModel.carPayInfo) {
                anyCarPayModel.payWayList.add(carPayInfoToPayWayItem(carPayInfoToPayWayItem));
            }
        }
        if (anyCarPayModel.businessConfig != null) {
            CarBusinessConfig carBusinessConfig = anyCarPayModel.businessConfig;
            String str = carBusinessConfig.memberId;
            String str2 = carBusinessConfig.defaultCompanyId;
            String str3 = carBusinessConfig.defaultCompanyName;
            String str4 = carBusinessConfig.defaultCostCenterId;
            String str5 = carBusinessConfig.defaultCostCenterName;
            String str6 = carBusinessConfig.defaultProjectId;
            String str7 = carBusinessConfig.defaultProjectName;
            boolean z = carBusinessConfig.costCenterRequired;
            boolean z2 = carBusinessConfig.projectRequired;
            boolean z3 = carBusinessConfig.commentsRequired;
            int i = carBusinessConfig.commentsMinSize;
            int i2 = carBusinessConfig.commentsMaxSize;
            PayEnterpriseInfo payEnterpriseInfo = new PayEnterpriseInfo();
            payEnterpriseInfo.setDefault(str2, str3, str4, str5, str6, str7, z, z2, z3, i, i2);
            payEnterpriseInfo.setMemberId(str);
            anyCarPayModel.payEnterpriseInfo = payEnterpriseInfo;
        }
        return anyCarPayModel;
    }

    public PayWayModel.PayWayItem carPayInfoToPayWayItem(CarPayInfoModel carPayInfoModel) {
        PayWayModel.PayWayItem payWayItem = new PayWayModel.PayWayItem();
        payWayItem.tag = carPayInfoModel.payTag;
        payWayItem.text = carPayInfoModel.payShowMessage;
        payWayItem.title = carPayInfoModel.payMessage;
        payWayItem.titleInSelectPage = carPayInfoModel.payMessageInSelectPage;
        payWayItem.tips = carPayInfoModel.payTips;
        payWayItem.businessUrl = carPayInfoModel.payBussUrl;
        payWayItem.businessConstSet = carPayInfoModel.payBussConstSet;
        payWayItem.companyPayMsg = carPayInfoModel.payCompanyMsg;
        payWayItem.isSigned = carPayInfoModel.payIsSigned;
        payWayItem.channelID = carPayInfoModel.payChannelId;
        payWayItem.isSelected = carPayInfoModel.payIsSelected;
        payWayItem.isPriorityUse = carPayInfoModel.isPriorityUse;
        payWayItem.isHit99payCombination = carPayInfoModel.isHit99payCombination;
        payWayItem.isOffline = carPayInfoModel.payIsOffline;
        payWayItem.card = carPayInfoModel.payCard;
        payWayItem.card_org = carPayInfoModel.payCardOrg;
        payWayItem.iconUrl = carPayInfoModel.payIconUrl;
        payWayItem.disabled = carPayInfoModel.payDisable;
        payWayItem.recommendSignPayType = carPayInfoModel.payRecommendSignPayType;
        payWayItem.priorityShow = carPayInfoModel.priorityShow;
        boolean z = true;
        if (carPayInfoModel.payIsOffline == 1) {
            payWayItem.viewType = PayWayModel.PayWayItem.ViewType.PAY_IN_CAR;
        } else {
            payWayItem.viewType = PayWayModel.PayWayItem.ViewType.PAY_IN_APP;
        }
        payWayItem.companyCarpoolOpen = carPayInfoModel.payCarpoolOpen == 1;
        payWayItem.cardIndex = carPayInfoModel.payCarIndex;
        payWayItem.cardPrefix = carPayInfoModel.cardPrefix;
        payWayItem.totalDiscount = carPayInfoModel.payTotalDiscount;
        payWayItem.discountMsg = carPayInfoModel.payDiscountMessage;
        if (carPayInfoModel.payHasCoupon != 1) {
            z = false;
        }
        payWayItem.hasCoupon = z;
        payWayItem.balanceMsg = carPayInfoModel.payBalanceMsg;
        payWayItem.is_sufficient = carPayInfoModel.payIsSufficient;
        payWayItem.isPromotion = carPayInfoModel.payIsPromotion;
        payWayItem.expired = carPayInfoModel.payExpired;
        payWayItem.expiredDesc = carPayInfoModel.payExpiredDesc;
        payWayItem.can_combination_pay_type = carPayInfoModel.payCombineType;
        payWayItem.toAddCardInfo = carPayInfoModel.toAddCardInfo;
        payWayItem.cardDiscountTags = carPayInfoModel.cardDiscountTags;
        payWayItem.mostFavorableTxt = carPayInfoModel.mostFavorableTxt;
        if (carPayInfoModel.mLogData != null) {
            payWayItem.mLogData = carPayInfoModel.mLogData.toString();
        }
        if (!TextUtils.isEmpty(carPayInfoModel.payExtraInfo)) {
            try {
                JSONObject jSONObject = new JSONObject(carPayInfoModel.payExtraInfo);
                payWayItem.channelTip = jSONObject.optString("channel_tip");
                payWayItem.guidePageH5 = jSONObject.optString("guide_page_h5");
                payWayItem.balance = jSONObject.optString("balance");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        if (carPayInfoModel.payExtraItemInfos != null) {
            payWayItem.extroInfoItemList = new ArrayList();
            for (CarPayExtraItemInfo next : carPayInfoModel.payExtraItemInfos) {
                PayWayModel.ExtroInfoItem extroInfoItem = new PayWayModel.ExtroInfoItem();
                extroInfoItem.cardDesc = next.cardStatusDesc;
                extroInfoItem.cardIndex = next.cardIndex;
                extroInfoItem.cardOrg = next.carOrg;
                extroInfoItem.cardStatus = next.cardStatus;
                extroInfoItem.cardSuffix = next.cardSuffix;
                extroInfoItem.cardSuffixInSelectPage = next.cardSuffixInSelectPage;
                extroInfoItem.expired = next.cardExpried;
                extroInfoItem.expiredDesc = next.expiredDesc;
                extroInfoItem.discountMsg = next.discountMsg;
                extroInfoItem.cardDiscountTags = next.cardDiscountTags;
                extroInfoItem.mostFavorableTxt = next.mostFavorableTxt;
                if (next.mLogData != null) {
                    extroInfoItem.mLogData = next.mLogData.toString();
                }
                payWayItem.extroInfoItemList.add(extroInfoItem);
            }
        }
        return payWayItem;
    }

    /* renamed from: b */
    private void m10818b() {
        this.mSelectedPaywayItem = FormStore.getInstance().getPayWaySelectedItem();
        this.enterpriseInfo = null;
        ((IAnycarPayWayView) this.mView).setLabel(this.mSelectedPaywayItem, (String) null);
    }

    /* access modifiers changed from: protected */
    public String getSelectItemsDesc(List<PayWayModel.PayWayItem> list) {
        if (list == null || list.isEmpty()) {
            return this.mContext.getString(R.string.pay_way_title);
        }
        StringBuilder sb = new StringBuilder();
        for (PayWayModel.PayWayItem next : list) {
            if (next != null) {
                sb.append(this.mContext.getResources().getString(R.string.pay_way_selected_desc));
                if (next.channelID == 150) {
                    sb.append(this.mContext.getResources().getString(R.string.pay_way_via_app_desc));
                    sb.append(this.mContext.getResources().getString(R.string.pay_way_card_ending_desc));
                    sb.append(next.card);
                } else if (next.channelID == 154) {
                    sb.append(this.mContext.getResources().getString(R.string.pay_way_pos_terminal_desc));
                } else if (next.channelID == 121) {
                    sb.append(this.mContext.getResources().getString(R.string.pay_way_for_desc, new Object[]{next.text}));
                } else if (next.channelID == 153) {
                    sb.append(next.title);
                } else if (next.channelID == 152 || next.channelID == 183) {
                    sb.append(next.title);
                } else {
                    sb.append(next.title);
                }
                if (next.hasCoupon) {
                    sb.append(this.mContext.getResources().getString(R.string.pay_way_with_discount_desc));
                }
            }
        }
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        XERegister.unregisterTemplate(XERequestKey.SingleCompRefresh.REQUEST_KEY_ANYCAR_USER_PAY_INFO);
        m10826d();
        ((IAnycarPayWayView) this.mView).dismissPopup();
    }

    /* renamed from: c */
    private void m10824c() {
        subscribe(BaseEventKeys.Confirm.EVENT_SHOW_CONFIRM_ADDRESS, this.f15141v);
        subscribe(BaseEventKeys.Confirm.SHOW_PAYMENTS, this.f15142w);
        subscribe(BaseEventKeys.Estimate.ESTIMATE_IS_LOADING, this.f15143x);
        subscribe("event_show_sug_page_container", this.f15133m);
        subscribe("event_hide_sug_page_container", this.f15134n);
        subscribe(BaseEventKeys.Confirm.EVENT_BOTTOM_FORM_HINTED, this.f15135p);
        subscribe(BaseEventKeys.Confirm.EVENT_HIDE_PAY_POPUP, this.f15135p);
        subscribe(BaseEventKeys.Service.SendOrder.EVENT_CARD_EXPIRED_INTERCEPT, this.f15144y);
        subscribe(BaseEventKeys.Estimate.ESTIMATE_COMPONENT_SHOWN, this.f15136q);
        subscribe(BaseEventKeys.Estimate.EVENT_PREORDER_INTERCEPT_PAYMENT_ACTION, this.f15137r);
    }

    /* renamed from: d */
    private void m10826d() {
        unsubscribe(BaseEventKeys.Confirm.EVENT_SHOW_CONFIRM_ADDRESS, this.f15141v);
        unsubscribe(BaseEventKeys.Confirm.SHOW_PAYMENTS, this.f15142w);
        unsubscribe(BaseEventKeys.Estimate.ESTIMATE_IS_LOADING, this.f15143x);
        unsubscribe("event_show_sug_page_container", this.f15133m);
        unsubscribe("event_hide_sug_page_container", this.f15134n);
        unsubscribe(BaseEventKeys.Confirm.EVENT_BOTTOM_FORM_HINTED, this.f15135p);
        unsubscribe(BaseEventKeys.Confirm.EVENT_HIDE_PAY_POPUP, this.f15135p);
        unsubscribe(BaseEventKeys.Service.SendOrder.EVENT_CARD_EXPIRED_INTERCEPT, this.f15144y);
        unsubscribe(BaseEventKeys.Estimate.ESTIMATE_COMPONENT_SHOWN, this.f15136q);
        unsubscribe(BaseEventKeys.Estimate.EVENT_PREORDER_INTERCEPT_PAYMENT_ACTION, this.f15137r);
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public boolean m10829e() {
        ConfirmListener confirmListener = PageCompDataTransfer.getInstance().getConfirmListener();
        return confirmListener != null && confirmListener.getIsAnyCar();
    }

    /* access modifiers changed from: protected */
    public void refreshPayWay(boolean z) {
        if (Utils.isBrazilPackage(this.mContext)) {
            m10812a(z);
            return;
        }
        this.mSelectedPaywayItem.clear();
        ((IAnycarPayWayView) this.mView).show();
        AnyCarPayModel anyCarPayModel = this.f15132l;
        this.mSelectedPaywayItem.clear();
        if (anyCarPayModel == null) {
            ((IAnycarPayWayView) this.mView).setLabel((List<PayWayModel.PayWayItem>) null, (String) null);
            ((IAnycarPayWayView) this.mView).changeEnableColor(false);
            return;
        }
        this.enterpriseInfo = null;
        if (anyCarPayModel.payWayList != null) {
            int size = anyCarPayModel.payWayList.size();
            for (int i = 0; i < size; i++) {
                PayWayModel.PayWayItem payWayItem = anyCarPayModel.payWayList.get(i);
                if (1 == payWayItem.isSelected()) {
                    this.mSelectedPaywayItem.add(payWayItem);
                }
            }
        }
        ((IAnycarPayWayView) this.mView).dismissPopup();
        if (z && !showGuidePopup()) {
            showPayWayGuideIfNeed(anyCarPayModel);
        }
        checkPaywayDialog(this.mSelectedPaywayItem);
        if (z) {
            checkCashLimit(this.mSelectedPaywayItem);
        }
        setPayWayToForm(this.mSelectedPaywayItem);
        setEnterpriseInfoToForm((EnterpriseInfo) null);
        this.mPaywayItems = anyCarPayModel.payWayList;
        ((IAnycarPayWayView) this.mView).setLabel(this.mSelectedPaywayItem, (String) null);
        ((IAnycarPayWayView) this.mView).setContentDescription(getSelectItemsDesc(this.mSelectedPaywayItem));
        ((IAnycarPayWayView) this.mView).hideLoading();
    }

    /* renamed from: a */
    private void m10812a(boolean z) {
        ((IAnycarPayWayView) this.mView).setClickable(true);
        ((IAnycarPayWayView) this.mView).show();
        AnyCarPayModel anyCarPayModel = this.f15132l;
        this.mSelectedPaywayItem.clear();
        if (anyCarPayModel == null) {
            ((IAnycarPayWayView) this.mView).setLabel((List<PayWayModel.PayWayItem>) null);
            ((IAnycarPayWayView) this.mView).changeEnableColor(false);
            return;
        }
        PayWayModel payWayModel = new PayWayModel();
        payWayModel.payWayList = anyCarPayModel.payWayList;
        if (CollectionUtil.isEmpty((Collection<?>) payWayModel.payWayList)) {
            payWayModel.parse(AssetsUtil.getAssetsFile(this.mContext, m10831f()));
            this.mSelectedPaywayItem = FormStore.getInstance().getPayWaySelectedItem();
            if (CollectionUtil.isEmpty((Collection<?>) payWayModel.payWayList)) {
                ((IAnycarPayWayView) this.mView).setLabel((List<PayWayModel.PayWayItem>) null);
                ((IAnycarPayWayView) this.mView).setClickable(false);
                return;
            }
        }
        if (payWayModel.payWayList != null) {
            int size = payWayModel.payWayList.size();
            for (int i = 0; i < size; i++) {
                PayWayModel.PayWayItem payWayItem = payWayModel.payWayList.get(i);
                if (PaymentsApi.containsPayment(payWayItem.getTag()) && 1 == payWayItem.isSelected()) {
                    this.mSelectedPaywayItem.add(payWayItem);
                }
            }
        }
        ((IAnycarPayWayView) this.mView).dismissPopup();
        if (z && !showGuidePopup()) {
            showPayWayGuideIfNeed(anyCarPayModel);
        }
        if (z) {
            checkCashLimit(this.mSelectedPaywayItem);
        }
        setPayWayToForm(this.mSelectedPaywayItem);
        this.mPaywayItems = payWayModel.payWayList;
        ((IAnycarPayWayView) this.mView).setLabel(this.mSelectedPaywayItem);
        ((IAnycarPayWayView) this.mView).setContentDescription(getSelectItemsDesc(this.mSelectedPaywayItem));
    }

    /* renamed from: f */
    private String m10831f() {
        return TextUtils.equals("pt-BR", MultiLocaleStore.getInstance().getLocaleCode()) ? f15121b : f15120a;
    }

    /* renamed from: b */
    private boolean m10822b(boolean z) {
        ConfirmListener confirmListener = PageCompDataTransfer.getInstance().getConfirmListener();
        if (confirmListener == null) {
            return false;
        }
        List<AnyCarEstimateItemModel> allCarItems = confirmListener.getAllCarItems();
        CarBubbleModule carBubbleModule = null;
        if (!CollectionUtil.isEmpty((Collection<?>) allCarItems)) {
            Iterator<AnyCarEstimateItemModel> it = allCarItems.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                AnyCarEstimateItemModel next = it.next();
                if (next.mAnyCarEstimateNetItem.carBubbleModule != null && !CollectionUtil.isEmpty((Collection<?>) next.mAnyCarEstimateNetItem.carBubbleModule.locationList)) {
                    carBubbleModule = next.mAnyCarEstimateNetItem.carBubbleModule;
                    break;
                }
            }
        }
        if (carBubbleModule != null) {
            BubbleSourceManager bubbleSourceManager = new BubbleSourceManager(this.mContext);
            bubbleSourceManager.setmIsJapan(z);
            final BubbleItemModel bubble = bubbleSourceManager.getBubble(1, carBubbleModule, false);
            if (bubble != null) {
                ((IAnycarPayWayView) this.mView).showNewPopup(bubble, new NewPopShowResultListener() {
                    public void success(NewBubbleHelper newBubbleHelper) {
                        if (AnyCarPayWayPresenter.this.f15145z.add(bubble.bubbleId)) {
                            newBubbleHelper.trackEvent(true);
                        }
                    }
                });
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean showPayWayGuideIfNeed(AnyCarPayModel anyCarPayModel) {
        if (this.mRemoved || anyCarPayModel == null || isDialogShowing() || FormStore.getInstance().isShowingPopupCompoent() || CollectionUtil.isEmpty((Collection<?>) anyCarPayModel.payWayList)) {
            return false;
        }
        return m10822b(false);
    }

    public void onNewPayWayGuideClicked(BubbleItemModel bubbleItemModel) {
        List<PayWayModel.PayWayItem> payWayItem;
        ((IAnycarPayWayView) this.mView).dismissPopup();
        if (bubbleItemModel != null && bubbleItemModel.actionEvent != null) {
            int i = bubbleItemModel.actionEvent.eventType;
            if (i != 1) {
                if (i == 2) {
                    onFormPayWayClicked();
                } else if (i == 3) {
                    DidiGlobalAddCardData.AddCardParam addCardParam = new DidiGlobalAddCardData.AddCardParam();
                    addCardParam.bindType = 8;
                    addCardParam.isShowLoading = true;
                    addCardParam.isSignAfterOrder = false;
                    DidiGlobalPayApiFactory.createDidiPay().startAddCreditCardActivity(getHost(), requestCodeForHost(1), addCardParam);
                } else if (i == 4 && bubbleItemModel.actionEvent.paramsModel != null) {
                    DRouter.build(bubbleItemModel.actionEvent.paramsModel.scheme).start(this.mContext);
                }
            } else if (bubbleItemModel.actionEvent.paramsModel != null && (payWayItem = getPayWayItem(bubbleItemModel.actionEvent.paramsModel.payTag)) != null && !payWayItem.isEmpty()) {
                setPayWayToForm(payWayItem);
                doPublish(BaseEventKeys.Estimate.ESTIMATE_GET_ESTIMATE);
            }
        }
    }

    /* access modifiers changed from: protected */
    public List<PayWayModel.PayWayItem> getPayWayItem(int i) {
        AnyCarPayModel anyCarPayModel = this.f15132l;
        ArrayList arrayList = new ArrayList();
        List<PayWayModel.PayWayItem> list = anyCarPayModel != null ? anyCarPayModel.payWayList : null;
        if (CollectionUtil.isEmpty((Collection<?>) list)) {
            return arrayList;
        }
        for (PayWayModel.PayWayItem next : list) {
            if ((next.getTag() & i) > 0) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public void onBindCardResult(int i, Intent intent) {
        if (i == -1) {
            String stringExtra = intent.getStringExtra("card_index");
            if (TextUtil.isEmpty(stringExtra)) {
                FormStore.getInstance().setSkipEstimateGet(true);
                return;
            }
            PayWayModel.PayWayItem payWayItem = new PayWayModel.PayWayItem();
            payWayItem.tag = 256;
            payWayItem.cardIndex = stringExtra;
            ArrayList arrayList = new ArrayList();
            arrayList.add(payWayItem);
            setPayWayToForm(arrayList);
            doPublish(BaseEventKeys.Estimate.ESTIMATE_GET_ESTIMATE);
        } else if (this.f15138s) {
            this.f15138s = false;
        } else {
            FormStore.getInstance().setSkipEstimateGet(true);
        }
    }

    /* access modifiers changed from: protected */
    public void checkCashLimit(List<PayWayModel.PayWayItem> list) {
        if (list != null) {
            for (PayWayModel.PayWayItem next : list) {
                if (String.valueOf(1024).equals(FormStore.getInstance().getPayWay())) {
                    if (next == null) {
                        m10825c(this.mContext.getResources().getString(R.string.pay_way_crash_limit_tips_null));
                    } else if (next.getTag() == 256) {
                        m10822b(true);
                    }
                }
            }
        }
    }

    /* renamed from: c */
    private void m10825c(String str) {
        NormalDialogInfo normalDialogInfo = new NormalDialogInfo(1100);
        normalDialogInfo.setCancelable(true);
        normalDialogInfo.setMessage(str);
        normalDialogInfo.setPositiveText(this.mContext.getResources().getString(R.string.pay_way_crash_limit_tips_confirm));
        showDialog(normalDialogInfo);
        GlobalOmegaUtils.trackEvent("pas_orderconfirm_casharea_sw");
    }

    /* access modifiers changed from: protected */
    public void setPayWayToForm(List<PayWayModel.PayWayItem> list) {
        FormStore.getInstance().setPayWaySelectedItem(list);
        if (list == null || list.isEmpty()) {
            FormStore.getInstance().setPayWay("");
            FormStore.getInstance().setPayWayMsg("");
            return;
        }
        int i = 0;
        StringBuilder sb = new StringBuilder();
        for (PayWayModel.PayWayItem next : list) {
            if (next != null) {
                i |= next.tag;
                sb.append(next.getLabel());
                sb.append(",");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        FormStore instance = FormStore.getInstance();
        instance.setPayWay(i + "");
        FormStore.getInstance().setPayWayMsg(sb.toString());
    }

    /* access modifiers changed from: protected */
    public void setEnterpriseInfoToForm(EnterpriseInfo enterpriseInfo2) {
        if (enterpriseInfo2 == null) {
            FormStore.getInstance().setEnterpriseFlag(1);
        } else {
            FormStore.getInstance().setEnterpriseFlag(enterpriseInfo2.flag);
        }
    }

    public void onFormPayWayClicked() {
        ((IAnycarPayWayView) this.mView).dismissPopup();
        if (!NationComponentDataUtil.isLoginNow()) {
            NationComponentDataUtil.goToLoginPageForResult(getHost(), requestCodeForHost(2));
        } else if (this.f15132l == null) {
            ToastHelper.showShortInfo(this.mContext, (int) R.string.pay_way_estimate_fail);
        } else if (!isInterceptNoPayWay(this.mPaywayItems).booleanValue()) {
            if (this.f15129i == null) {
                this.f15129i = new AnyCarPayWayHelper();
            }
            DidiGlobalPayMethodListData.PayMethodListParam payMethodListParam = new DidiGlobalPayMethodListData.PayMethodListParam(DidiGlobalPayMethodListData.Entrance.FROM_PAY_ESTIMATION);
            payMethodListParam.list = DateConverUtils.converPayMethodInfoList(this.mPaywayItems);
            AnyCarPayModel anyCarPayModel = this.f15131k;
            if (anyCarPayModel != null) {
                payMethodListParam.groupList = DateConverUtils.convertPayGroupInfoList(anyCarPayModel.carPayGroupInfo);
                payMethodListParam.configInfo = DateConverUtils.convertPayPopupInfo(this.f15131k.payCfgInfo);
            }
            payMethodListParam.resourceId = "4";
            payMethodListParam.enterpriseInfo = null;
            payMethodListParam.resourceId = "4";
            DidiGlobalPayApiFactory.createDidiPay().startPayMethodListActivity(getHost(), requestCodeForHost(3), payMethodListParam, this.f15129i.getPayMethodAdapter());
            this.mLogger.info("Click pay way", new Object[0]);
        }
    }

    public void onFormPayWayClicked(String str) {
        ((IAnycarPayWayView) this.mView).dismissPopup();
        if (!NationComponentDataUtil.isLoginNow()) {
            NationComponentDataUtil.goToLoginPageForResult(getHost(), requestCodeForHost(2));
        } else if (this.f15132l == null) {
            ToastHelper.showShortInfo(this.mContext, (int) R.string.pay_way_estimate_fail);
        } else if (!isInterceptNoPayWay(this.mPaywayItems).booleanValue()) {
            if (this.f15129i == null) {
                this.f15129i = new AnyCarPayWayHelper();
            }
            DidiGlobalPayMethodListData.PayMethodListParam payMethodListParam = new DidiGlobalPayMethodListData.PayMethodListParam(DidiGlobalPayMethodListData.Entrance.FROM_PAY_ESTIMATION);
            payMethodListParam.list = DateConverUtils.converPayMethodInfoList(this.mPaywayItems);
            AnyCarPayModel anyCarPayModel = this.f15131k;
            if (anyCarPayModel != null) {
                payMethodListParam.groupList = DateConverUtils.convertPayGroupInfoList(anyCarPayModel.carPayGroupInfo);
                payMethodListParam.configInfo = DateConverUtils.convertPayPopupInfo(this.f15131k.payCfgInfo);
            }
            payMethodListParam.resourceId = str;
            payMethodListParam.enterpriseInfo = null;
            DidiGlobalPayApiFactory.createDidiPay().startPayMethodListActivity(getHost(), requestCodeForHost(3), payMethodListParam, this.f15129i.getPayMethodAdapter());
            this.mLogger.info("Click pay way", new Object[0]);
        }
    }

    /* access modifiers changed from: protected */
    public Boolean isInterceptNoPayWay(List<PayWayModel.PayWayItem> list) {
        return false;
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        OmegaSDK.putGlobalAttr("g_PageId", GPageIdConstant.G_PAGE_ID_CONF);
        if (2 == i && -1 == i2) {
            setPayWayToForm(this.mSelectedPaywayItem);
            doPublish(BaseEventKeys.Estimate.ESTIMATE_GET_ESTIMATE);
        } else if (3 == i && intent != null && -1 == i2) {
            m10819b((DidiGlobalPayMethodListData.PayMethodListResult) intent.getSerializableExtra("pay_method_list_result"));
        } else if (1 == i) {
            onBindCardResult(i2, intent);
        }
    }

    /* renamed from: a */
    private PayWayModel.PayWayItem m10806a(DidiGlobalPayMethodListData.SelectedPayMethod selectedPayMethod) {
        List<PayWayModel.PayWayItem> list;
        if (selectedPayMethod == null || selectedPayMethod.channelId <= 0 || (list = this.mPaywayItems) == null) {
            return null;
        }
        for (PayWayModel.PayWayItem next : list) {
            if (next.channelID == selectedPayMethod.channelId) {
                next.cardIndex = selectedPayMethod.cardIndex;
                next.card = selectedPayMethod.cardNo;
                if (!TextUtils.isEmpty(selectedPayMethod.iconUrl)) {
                    next.card_org = selectedPayMethod.iconUrl;
                }
                return next;
            }
        }
        return null;
    }

    /* renamed from: a */
    private List<PayWayModel.PayWayItem> m10808a(DidiGlobalPayMethodListData.PayMethodListResult payMethodListResult) {
        ArrayList arrayList = new ArrayList();
        if (!(payMethodListResult == null || payMethodListResult.selectedPayMethods == null)) {
            for (DidiGlobalPayMethodListData.SelectedPayMethod a : payMethodListResult.selectedPayMethods) {
                PayWayModel.PayWayItem a2 = m10806a(a);
                if (a2 != null) {
                    arrayList.add(a2);
                }
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public void onDialogAction(int i, int i2) {
        super.onDialogAction(i, i2);
        if (i == 1100 && i2 == 2) {
            if (this.mSelectedPaywayItem == null && ((IAnycarPayWayView) this.mView).isClickable()) {
                onFormPayWayClicked();
            }
        } else if (i == 1101) {
            GlobalTipsPriorityManager.getInstance().remove(10);
            if (!((IAnycarPayWayView) this.mView).isClickable() || i2 != 2) {
                dismissDialog(i);
                GlobalOmegaUtils.trackEvent("gp_conf_dlg_untiedcard_ck");
                return;
            }
            onFormPayWayClicked();
            GlobalOmegaUtils.trackEvent("gp_conf_dlg_tiedcard_ck");
        }
    }

    /* access modifiers changed from: protected */
    public boolean showGuidePopup() {
        if (this.mContext == null || isDialogShowing() || FormStore.getInstance().isShowingPopupCompoent() || AbsConfirmConfigState.isLoadingInConfirmPage) {
            return false;
        }
        if (AbsConfirmConfigState.isShowPopInConfirmPage) {
            return true;
        }
        return m10822b(false);
    }

    /* access modifiers changed from: protected */
    public boolean onBackPressed(IPresenter.BackType backType) {
        Runnable runnable = this.f15128A;
        if (runnable != null) {
            UiThreadHandler.removeCallbacks(runnable);
            this.f15128A = null;
        }
        return super.onBackPressed(backType);
    }

    /* renamed from: b */
    private void m10819b(DidiGlobalPayMethodListData.PayMethodListResult payMethodListResult) {
        if (payMethodListResult != null) {
            List<PayWayModel.PayWayItem> a = m10808a(payMethodListResult);
            if (!a.isEmpty()) {
                if (this.mSelectedPaywayItem.size() > 0) {
                    PayWayModel.PayWayItem payWayItem = this.mSelectedPaywayItem.get(0);
                    PayWayModel.PayWayItem payWayItem2 = a.get(0);
                    if (!(payWayItem == null || payWayItem2 == null || payWayItem.tag == payWayItem2.tag)) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("tag", Integer.valueOf(payWayItem2.tag));
                        AnycarTrack.anycarMonitorTrack(AnycarTrack.mSceneChangePayMethod, hashMap);
                    }
                }
                this.mSelectedPaywayItem.clear();
                this.mSelectedPaywayItem.addAll(a);
            }
            this.selectedResults = payMethodListResult;
            setPayWayToForm(this.mSelectedPaywayItem);
            setEnterpriseInfoToForm((EnterpriseInfo) null);
            doPublish(BaseEventKeys.Estimate.ESTIMATE_GET_ESTIMATE);
            ((IAnycarPayWayView) this.mView).setLabel(this.mSelectedPaywayItem, (String) null);
        } else if (payMethodListResult == null || !payMethodListResult.hasRefreshed) {
            FormStore.getInstance().setSkipEstimateGet(true);
        } else {
            doPublish(BaseEventKeys.Estimate.ESTIMATE_GET_ESTIMATE);
        }
        SearchIdUploadManager.getInstance().setEstimateAction("after_select_pay_method");
    }

    public void notifyUpdate() {
        doPublish(BaseEventKeys.Form.KEY_UPDATE_FORM_OPTIONS);
    }
}
