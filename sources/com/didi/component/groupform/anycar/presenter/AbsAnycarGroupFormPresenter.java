package com.didi.component.groupform.anycar.presenter;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.data.form.PageCompDataTransfer;
import com.didi.component.business.data.form.listener.ConfirmGetListener;
import com.didi.component.business.data.form.listener.ConfirmListener;
import com.didi.component.business.tracker.anycar.AnycarTrack;
import com.didi.component.business.util.BrazilCarTypeUtil;
import com.didi.component.business.util.GlobalSPUtil;
import com.didi.component.business.util.NationComponentDataUtil;
import com.didi.component.common.base.BaseExpressPresenter;
import com.didi.component.common.pininput.PinInputActivity;
import com.didi.component.common.util.GLog;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.IComponent;
import com.didi.component.core.IViewContainer;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.groupform.anycar.view.IAnycarGroupFormView;
import com.didi.component.service.activity.rgltaxiguide.RegularTaxiGuideActivity;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel;
import com.didi.travel.psnger.model.response.anycar.AnyCarResponse;
import com.didi.travel.psnger.model.response.estimate.daijiao.FriendItem;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public abstract class AbsAnycarGroupFormPresenter extends BaseExpressPresenter<IAnycarGroupFormView> implements IViewContainer {
    public static final int REQUEST_CODE_PIN_INPUT = 101;
    public static final int REQUEST_CODE_REGULAR_TAXI_GUIDE = 100;

    /* renamed from: a */
    private final Logger f14014a = LoggerFactory.getLogger(getClass());

    /* renamed from: b */
    private boolean f14015b;

    /* renamed from: c */
    private BaseEventPublisher.OnEventListener<Boolean> f14016c = new BaseEventPublisher.OnEventListener<Boolean>() {
        public void onEvent(String str, Boolean bool) {
            ConfirmListener confirmListener = PageCompDataTransfer.getInstance().getConfirmListener();
            if (confirmListener != null) {
                AnyCarResponse anyCarResponse = confirmListener.getAnyCarResponse();
                if (anyCarResponse == null || anyCarResponse.globalConfig == null || anyCarResponse.globalConfig.mFormOperationModel == null) {
                    AnycarTrack.anycarMonitorTrack(AnycarTrack.mSceneSubstituteCall, (Map<String, Object>) null);
                } else {
                    ((IAnycarGroupFormView) AbsAnycarGroupFormPresenter.this.mView).setAnyCarFormOperationData(anyCarResponse.globalConfig.mFormOperationModel);
                    ((IAnycarGroupFormView) AbsAnycarGroupFormPresenter.this.mView).setOptionViews(new ArrayList());
                }
                ((IAnycarGroupFormView) AbsAnycarGroupFormPresenter.this.mView).setEnabled(AbsAnycarGroupFormPresenter.this.isActionfilter(bool.booleanValue()));
                AbsAnycarGroupFormPresenter.this.updateNewEstButtonText();
                AbsAnycarGroupFormPresenter.this.m9775b();
            }
        }
    };

    /* renamed from: d */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f14017d = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            AbsAnycarGroupFormPresenter.this.m9775b();
        }
    };

    /* renamed from: e */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f14018e = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (TextUtils.equals(BaseEventKeys.Estimate.ESTIMATE_IS_LOADING, str)) {
                AbsAnycarGroupFormPresenter.this.updateButtonStatus();
                ((IAnycarGroupFormView) AbsAnycarGroupFormPresenter.this.mView).setEnabled(false);
            }
        }
    };

    /* renamed from: f */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f14019f = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            AbsAnycarGroupFormPresenter.this.onConfirmPriceIntercept();
        }
    };
    protected BusinessContext mBusinessContext;
    protected IViewContainer.IComponentCreator mComponentCreator;
    protected ComponentParams mComponentParams;

    /* access modifiers changed from: protected */
    public int getMaxColCount() {
        return 3;
    }

    public abstract boolean isActionfilter(boolean z);

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m9775b() {
        ((IAnycarGroupFormView) this.mView).setPriceBtn(m9777c());
    }

    /* renamed from: c */
    private String m9777c() {
        ConfirmGetListener confirmGetListener = PageCompDataTransfer.getInstance().getConfirmGetListener();
        if (confirmGetListener == null) {
            return "";
        }
        return confirmGetListener.getBtnSubText();
    }

    public AbsAnycarGroupFormPresenter(ComponentParams componentParams) {
        super(componentParams);
        this.mComponentParams = componentParams;
        this.mBusinessContext = componentParams.bizCtx;
        BrazilCarTypeUtil.initOptionsApollo();
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        m9778d();
        m9784h();
        FormStore.getInstance().setSelectedFriend((FriendItem) null);
        m9781e();
    }

    /* renamed from: d */
    private void m9778d() {
        ((IAnycarGroupFormView) this.mView).setMaxColCount(getMaxColCount());
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        ((IAnycarGroupFormView) this.mView).onDestroy();
        m9782f();
    }

    /* renamed from: e */
    private void m9781e() {
        subscribe(BaseEventKeys.Estimate.ESTIMATE_IS_LOADING, this.f14018e);
        subscribe(BaseEventKeys.AnyCar.ANYCAR_EVENT_ONE_PRICE_SELECT_CONFIRM, this.f14019f);
        subscribe(BaseEventKeys.AnyCar.ANYCAR_EYEBALL_RESPONSE, this.f14016c);
        subscribe(BaseEventKeys.AnyCar.ANYCAR_EYEBALL_SELECT_OR_UNSELECT, this.f14017d);
    }

    /* renamed from: f */
    private void m9782f() {
        unsubscribe(BaseEventKeys.Estimate.ESTIMATE_IS_LOADING, this.f14018e);
        unsubscribe(BaseEventKeys.AnyCar.ANYCAR_EVENT_ONE_PRICE_SELECT_CONFIRM, this.f14019f);
        unsubscribe(BaseEventKeys.AnyCar.ANYCAR_EYEBALL_RESPONSE, this.f14016c);
        unsubscribe(BaseEventKeys.AnyCar.ANYCAR_EYEBALL_SELECT_OR_UNSELECT, this.f14017d);
    }

    public void showNoviceGuidance(int i) {
        doPublish(BaseEventKeys.Confirm.EVENT_SHOW_NOVICE_GUIDANCE_FOR_SUBSTITUTE_CALL, Integer.valueOf(i));
    }

    public void onConfirmPriceIntercept() {
        if (!m9783g() && !showPinInputPage()) {
            onConfirmPrice();
        }
    }

    /* renamed from: g */
    private boolean m9783g() {
        if (!isPricingTaxi() || GlobalSPUtil.getRegularTaxiGuideHasShow(this.mContext)) {
            return false;
        }
        GlobalSPUtil.setRegularTaxiGuideHasShow(this.mContext, true);
        startActivityForResult(RegularTaxiGuideActivity.getIntent(this.mContext), 100);
        return true;
    }

    public void onConfirmPrice() {
        this.f14014a.info("Click send order btn", new Object[0]);
        doPublish(BaseEventKeys.Service.SendOrder.EVENT_REQUEST_ACTION_SEND_ORDER);
    }

    public boolean showPinInputPage() {
        if (!m9773a(FormStore.getInstance().getPayWay()) || hasPin()) {
            return false;
        }
        FormStore.getInstance().setSkipEstimateGet(true);
        startActivityForResult(PinInputActivity.getIntent(this.mContext), 101);
        return true;
    }

    public boolean hasPin() {
        String userPin = NationComponentDataUtil.getUserPin(this.mContext);
        GLog.m7965d("UserInfoPin", "UserInfo.getPin=" + userPin);
        return !TextUtils.isEmpty(userPin) && userPin.length() == 3;
    }

    /* renamed from: a */
    private boolean m9773a(String str) {
        int i;
        if (!isPricingTaxi()) {
            return false;
        }
        try {
            i = Integer.parseInt(str);
        } catch (Exception unused) {
            i = 0;
        }
        if (i == 128 || i == 256 || i == 512) {
            return true;
        }
        return false;
    }

    public boolean isPricingTaxi() {
        List<AnyCarEstimateItemModel> list;
        AnyCarEstimateItemModel anyCarEstimateItemModel = null;
        if (PageCompDataTransfer.getInstance().getConfirmListener() != null) {
            anyCarEstimateItemModel = PageCompDataTransfer.getInstance().getConfirmListener().getSelectedSingleAnyCarItem();
            list = PageCompDataTransfer.getInstance().getConfirmListener().getSelectedAnyCarItems();
        } else {
            list = null;
        }
        if (anyCarEstimateItemModel == null && CollectionUtil.isEmpty((Collection<?>) list)) {
            return false;
        }
        if (anyCarEstimateItemModel == null) {
            if (!CollectionUtil.isEmpty((Collection<?>) list)) {
                for (AnyCarEstimateItemModel next : list) {
                    if (next.mAnyCarEstimateNetItem.carBreakModel != null && next.mAnyCarEstimateNetItem.carBreakModel.carBreakPinInfo != null && next.mAnyCarEstimateNetItem.carBreakModel.carBreakPinInfo.enable == 1) {
                        return true;
                    }
                }
            }
            return false;
        } else if (anyCarEstimateItemModel.mAnyCarEstimateNetItem.carBreakModel == null || anyCarEstimateItemModel.mAnyCarEstimateNetItem.carBreakModel.carBreakPinInfo == null || anyCarEstimateItemModel.mAnyCarEstimateNetItem.carBreakModel.carBreakPinInfo.enable != 1) {
            return false;
        } else {
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public void updateButtonStatus() {
        dealBtnText();
    }

    /* access modifiers changed from: protected */
    public void updateNewEstButtonText() {
        dealBtnText();
    }

    /* access modifiers changed from: protected */
    public void dealBtnText() {
        ConfirmListener confirmListener = PageCompDataTransfer.getInstance().getConfirmListener();
        if (confirmListener == null || confirmListener.getAnyCarResponse() == null || confirmListener.getAnyCarResponse().globalConfig == null || TextUtils.isEmpty(confirmListener.getAnyCarResponse().globalConfig.confirmBtnText)) {
            ((IAnycarGroupFormView) this.mView).setButtonText(ResourcesHelper.getString(this.mContext, R.string.global_confirm_btn_new));
        } else {
            ((IAnycarGroupFormView) this.mView).setButtonText(confirmListener.getAnyCarResponse().globalConfig.confirmBtnText);
        }
    }

    /* renamed from: h */
    private void m9784h() {
        if (this.mComponentCreator != null) {
            ((IAnycarGroupFormView) this.mView).setOptionViews(new ArrayList());
        }
    }

    public void setComponentCreator(IViewContainer.IComponentCreator iComponentCreator) {
        this.mComponentCreator = iComponentCreator;
    }

    public IViewContainer.IComponentCreator getComponentCreator() {
        return this.mComponentCreator;
    }

    public IComponent inflateComponent(String str, ViewGroup viewGroup) {
        IComponent newComponent = this.mComponentCreator.newComponent(str, viewGroup);
        if (newComponent != null && newComponent.getView() != null && newComponent.getView().getView() != null) {
            return newComponent;
        }
        this.mComponentCreator.removeComponent(newComponent);
        return null;
    }

    public void removeComponent(IComponent iComponent) {
        this.mComponentCreator.removeComponent(iComponent);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 101 && i2 == -1 && hasPin()) {
            onConfirmPrice();
        }
        if (i == 100 && !showPinInputPage()) {
            onConfirmPrice();
        }
        super.onActivityResult(i, i2, intent);
    }
}
