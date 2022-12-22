package com.didi.component.bubbleLayout.impl;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.didi.component.bubbleLayout.AbsBubbleLayoutPresenter;
import com.didi.component.bubbleLayout.IBubbleLayoutView;
import com.didi.component.bubbleLayout.anycar.AnycarBubbleLayout;
import com.didi.component.bubbleLayout.view.BubbleAnimationLayout;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.constant.BaseExtras;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.data.form.PageCompDataTransfer;
import com.didi.component.business.data.form.listener.ConfirmListener;
import com.didi.component.business.event.VerticalDataUpdateEvent;
import com.didi.component.business.tracker.GPageIdConstant;
import com.didi.component.business.tracker.OmegaCommonParamsTrackUtil;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.UiUtils;
import com.didi.component.common.base.ComponentType;
import com.didi.component.common.helper.SceneHelper;
import com.didi.component.common.util.CollectionUtils;
import com.didi.component.common.util.GLog;
import com.didi.component.common.util.LocationController;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.IComponent;
import com.didi.component.core.IViewContainer;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didi.travel.psnger.model.response.estimate.EstimateAbnormalModel;
import com.didi.travel.psnger.model.response.estimate.EstimateItemModel;
import com.didi.travel.psnger.model.response.estimate.StartEndCardModel;
import com.didichuxing.omega.sdk.init.OmegaSDK;
import java.util.HashMap;
import java.util.Map;

public class BubbleLayoutPresenter extends AbsBubbleLayoutPresenter {

    /* renamed from: a */
    private static final String f11111a = "BubbleLayout";

    /* renamed from: b */
    private IViewContainer.IComponentCreator f11112b;

    /* renamed from: c */
    private BusinessContext f11113c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public BubbleAnimationLayout f11114d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public AnycarBubbleLayout f11115e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f11116f;

    /* renamed from: g */
    private View f11117g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public StartEndCardModel f11118h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final Logger f11119i = LoggerFactory.getLogger(f11111a);

    /* renamed from: j */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f11120j = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (BaseEventKeys.Confirm.EVENT_SHOW_HIDE_ANIMATION.equals(str)) {
                BubbleLayoutPresenter.this.f11114d.hideAndShow();
            } else if (BaseEventKeys.Confirm.EVENT_SHOW_CONFIRM_ADDRESS.equals(str)) {
                BubbleLayoutPresenter.this.m7544d();
            } else if (BaseEventKeys.Confirm.EVENT_SHOW_CONFIRM_PRICE.equals(str)) {
                BubbleLayoutPresenter.this.m7546e();
            } else if (BaseEventKeys.Confirm.EVENT_CONFIRM_PAGE_SUB_TITLE_SHOWED.equals(str)) {
                BubbleLayoutPresenter.this.f11114d.refreshBestView();
            } else if (BaseEventKeys.Confirm.EVENT_NEW_ESTIMATE_HIDE_GROUP_FORM.equals(str)) {
                BubbleLayoutPresenter.this.f11114d.hideBottomCard();
                BubbleLayoutPresenter.this.f11114d.setBottomCardHeight(0);
            } else if (BaseEventKeys.Confirm.EVENT_NEW_ESTIMATE_SHOW_GROUP_FORM.equals(str)) {
                BubbleLayoutPresenter.this.f11114d.showBottomCard();
                BubbleLayoutPresenter.this.m7552h();
                BubbleLayoutPresenter.this.m7546e();
                BubbleLayoutPresenter.this.doPublish(BaseEventKeys.DDMirror.EVENT_MSG_ESTIMATE_COMPONENT_SHOWN);
            } else if (BaseEventKeys.Confirm.EVENT_NEW_VERTICAL_SCROLL_TOP.equals(str)) {
                BubbleLayoutPresenter.this.f11114d.scrollToTop();
            } else if (BaseEventKeys.Confirm.EVENT_NEW_VERTICAL_SCROLL_BOTTOM.equals(str)) {
                BubbleLayoutPresenter.this.f11114d.scrollToBottom();
            } else if (BaseEventKeys.Confirm.EVENT_NEW_VERTICAL_HIDE_BOTTOM.equals(str)) {
                BubbleLayoutPresenter.this.f11114d.hideBottomCard();
                BubbleLayoutPresenter.this.m7554i();
            } else if (BaseEventKeys.Estimate.ESTIMATE_IS_LOADING.equals(str)) {
                ConfirmListener confirmListener = PageCompDataTransfer.getInstance().getConfirmListener();
                if (confirmListener != null && confirmListener.isConfirmAddressPage() && confirmListener.getIsAnyCar()) {
                    BubbleLayoutPresenter.this.f11119i.info("anycar ESTIMATE_IS_LOADING current page is confirmaddrss", new Object[0]);
                } else if (BubbleLayoutPresenter.this.f11115e != null) {
                    BubbleLayoutPresenter.this.f11115e.setVisibility(0);
                    BubbleLayoutPresenter.this.f11115e.showLoading();
                }
            }
        }
    };

    /* renamed from: k */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f11121k = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            BubbleLayoutPresenter.this.f11115e.handleMsg();
            BubbleLayoutPresenter.this.f11115e.updatePreferenceStatus(true);
            BubbleLayoutPresenter.this.f11115e.updateSwipeTips(false);
        }
    };

    /* renamed from: l */
    private BaseEventPublisher.OnEventListener<Boolean> f11122l = new BaseEventPublisher.OnEventListener<Boolean>() {
        public void onEvent(String str, Boolean bool) {
            if (BaseEventKeys.AnyCar.ANYCAR_EYEBALL_RESPONSE.equals(str)) {
                Logger f = BubbleLayoutPresenter.this.f11119i;
                f.info("ANYCAR_EYEBALL_RESPONSE  result =" + bool, new Object[0]);
                ConfirmListener confirmListener = PageCompDataTransfer.getInstance().getConfirmListener();
                if (confirmListener == null || !confirmListener.isConfirmAddressPage() || !confirmListener.getIsAnyCar()) {
                    BubbleLayoutPresenter.this.f11114d.hideViewByAnycar();
                    if (BubbleLayoutPresenter.this.f11115e != null) {
                        BubbleLayoutPresenter.this.f11115e.setVisibility(0);
                        if (bool.booleanValue()) {
                            BubbleLayoutPresenter.this.f11115e.showEstimateWithAnimation(false);
                            BubbleLayoutPresenter.this.f11115e.updatePreferenceData();
                            BubbleLayoutPresenter.this.f11115e.handleMsg();
                            BubbleLayoutPresenter.this.f11115e.handleAbnormal(false);
                            return;
                        }
                        BubbleLayoutPresenter.this.f11115e.handleAbnormal(true);
                        return;
                    }
                    return;
                }
                BubbleLayoutPresenter.this.hideLoading();
                BubbleLayoutPresenter.this.f11119i.info(" ANYCAR_EYEBALL_RESPONSE current page is confirmaddrss", new Object[0]);
            } else if (BaseEventKeys.Estimate.NEW_ESTIMATE_RESULT.equals(str)) {
                Logger f2 = BubbleLayoutPresenter.this.f11119i;
                f2.info("NEW_ESTIMATE_RESULT  result =" + bool, new Object[0]);
                BubbleLayoutPresenter.this.hideLoading();
                if (BubbleLayoutPresenter.this.f11115e != null && bool.booleanValue()) {
                    BubbleLayoutPresenter.this.f11115e.setVisibility(8);
                    BubbleLayoutPresenter.this.f11114d.hideAnycarByOldEstimate();
                }
            }
        }
    };

    /* renamed from: m */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f11123m = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            BubbleLayoutPresenter.this.f11114d.hideViewByAnycar();
            BubbleLayoutPresenter.this.f11115e.updateAbnormal((EstimateAbnormalModel) null);
        }
    };

    /* renamed from: n */
    private BaseEventPublisher.OnEventListener<EstimateAbnormalModel> f11124n = new BaseEventPublisher.OnEventListener<EstimateAbnormalModel>() {
        public void onEvent(String str, EstimateAbnormalModel estimateAbnormalModel) {
            BubbleLayoutPresenter.this.f11114d.hideViewByAnycar();
            BubbleLayoutPresenter.this.f11115e.updateAbnormal(estimateAbnormalModel);
        }
    };

    /* renamed from: p */
    private final BaseEventPublisher.OnEventListener<VerticalDataUpdateEvent> f11125p = new BaseEventPublisher.OnEventListener<VerticalDataUpdateEvent>() {
        public void onEvent(String str, VerticalDataUpdateEvent verticalDataUpdateEvent) {
            if (BaseEventKeys.Confirm.EVENT_VERTICAL_DATA_UPDATE.equals(str)) {
                GLog.m7965d(BubbleLayoutPresenter.f11111a, "EVENT_VERTICAL_DATA_UPDATE offsetY: " + verticalDataUpdateEvent.offsetY);
                ConfirmListener confirmListener = PageCompDataTransfer.getInstance().getConfirmListener();
                if (confirmListener == null || !confirmListener.isConfirmAddressPage() || !confirmListener.getIsAnyCar()) {
                    BubbleLayoutPresenter.this.f11114d.setTopOffsetY(verticalDataUpdateEvent.offsetY);
                    BubbleLayoutPresenter.this.f11114d.setCanPullUp(verticalDataUpdateEvent.canPullUp);
                    if (verticalDataUpdateEvent.bottomOffsetY > 0) {
                        BubbleLayoutPresenter.this.f11114d.setBottomCardHeight(verticalDataUpdateEvent.bottomOffsetY);
                    }
                    boolean unused = BubbleLayoutPresenter.this.f11116f = true;
                    if (verticalDataUpdateEvent.isShowAnimation) {
                        BubbleLayoutPresenter.this.f11114d.showEstimatePage();
                        return;
                    }
                    return;
                }
                BubbleLayoutPresenter.this.f11119i.info("EVENT_VERTICAL_DATA_UPDATE current page is confirmaddrss", new Object[0]);
            }
        }
    };

    /* renamed from: q */
    private BaseEventPublisher.OnEventListener<StartEndCardModel> f11126q = new BaseEventPublisher.OnEventListener<StartEndCardModel>() {
        public void onEvent(String str, StartEndCardModel startEndCardModel) {
            StartEndCardModel unused = BubbleLayoutPresenter.this.f11118h = startEndCardModel;
            GLog.m7965d("lxsminibus", "startEndCardModel");
        }
    };

    public BubbleLayoutPresenter(ComponentParams componentParams) {
        super(componentParams);
        this.f11113c = componentParams.bizCtx;
    }

    public void setComponentCreator(IViewContainer.IComponentCreator iComponentCreator) {
        this.f11112b = iComponentCreator;
        this.f11114d = (BubbleAnimationLayout) ((IBubbleLayoutView) this.mView).getView();
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        m7540b();
        m7551g();
        m7538a(bundle);
    }

    /* access modifiers changed from: protected */
    public void onPagePause() {
        super.onPagePause();
    }

    /* access modifiers changed from: protected */
    public void onPageResume() {
        super.onPageResume();
    }

    /* renamed from: a */
    private void m7538a(Bundle bundle) {
        if (bundle == null || !bundle.getBoolean(BaseExtras.ConfirmService.EXTRA_CONFIRM_GET_ON_SCENE, false)) {
            m7546e();
        } else {
            m7544d();
        }
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        m7542c();
        OmegaCommonParamsTrackUtil.setCurrentStateInConfirmPage((String) null);
    }

    /* renamed from: b */
    private void m7540b() {
        subscribe(BaseEventKeys.Confirm.EVENT_VERTICAL_DATA_UPDATE, this.f11125p);
        subscribe(BaseEventKeys.Confirm.EVENT_SHOW_HIDE_ANIMATION, this.f11120j);
        subscribe(BaseEventKeys.Confirm.EVENT_SHOW_CONFIRM_ADDRESS, this.f11120j);
        subscribe(BaseEventKeys.Confirm.EVENT_SHOW_CONFIRM_PRICE, this.f11120j);
        subscribe("event_confirm_boarding_enable_city", this.f11120j);
        subscribe(BaseEventKeys.Confirm.EVENT_CONFIRM_PAGE_SUB_TITLE_SHOWED, this.f11120j);
        subscribe(BaseEventKeys.Confirm.EVENT_NEW_ESTIMATE_HIDE_GROUP_FORM, this.f11120j);
        subscribe(BaseEventKeys.Confirm.EVENT_NEW_ESTIMATE_SHOW_GROUP_FORM, this.f11120j);
        subscribe(BaseEventKeys.Confirm.EVENT_NEW_VERTICAL_SCROLL_TOP, this.f11120j);
        subscribe(BaseEventKeys.Confirm.EVENT_NEW_VERTICAL_SCROLL_BOTTOM, this.f11120j);
        subscribe(BaseEventKeys.Confirm.EVENT_NEW_VERTICAL_HIDE_BOTTOM, this.f11120j);
        subscribe(BaseEventKeys.Confirm.EVENT_CONFORM_START_END, this.f11126q);
        subscribe(BaseEventKeys.Estimate.ESTIMATE_IS_LOADING, this.f11120j);
        subscribe(BaseEventKeys.Estimate.NEW_ESTIMATE_RESULT, this.f11122l);
        subscribe(BaseEventKeys.AnyCar.ANYCAR_EYEBALL_RESPONSE, this.f11122l);
        subscribe(BaseEventKeys.AnyCar.ANYCAR_EYEBALL_SELECT_OR_UNSELECT, this.f11121k);
        subscribe(BaseEventKeys.AnyCar.ESTIMATE_ABNORMAL_TRANSFER_ANYCAR, this.f11124n);
        subscribe(BaseEventKeys.AnyCar.ESTIMATE_FAIL_TRANSFER_ANYCAR, this.f11123m);
    }

    /* renamed from: c */
    private void m7542c() {
        unsubscribe(BaseEventKeys.Confirm.EVENT_VERTICAL_DATA_UPDATE, this.f11125p);
        unsubscribe(BaseEventKeys.Confirm.EVENT_SHOW_HIDE_ANIMATION, this.f11120j);
        unsubscribe(BaseEventKeys.Confirm.EVENT_SHOW_CONFIRM_ADDRESS, this.f11120j);
        unsubscribe(BaseEventKeys.Confirm.EVENT_SHOW_CONFIRM_PRICE, this.f11120j);
        unsubscribe("event_confirm_boarding_enable_city", this.f11120j);
        unsubscribe(BaseEventKeys.Confirm.EVENT_CONFIRM_PAGE_SUB_TITLE_SHOWED, this.f11120j);
        unsubscribe(BaseEventKeys.Confirm.EVENT_NEW_ESTIMATE_HIDE_GROUP_FORM, this.f11120j);
        unsubscribe(BaseEventKeys.Confirm.EVENT_NEW_ESTIMATE_SHOW_GROUP_FORM, this.f11120j);
        unsubscribe(BaseEventKeys.Confirm.EVENT_NEW_VERTICAL_SCROLL_TOP, this.f11120j);
        unsubscribe(BaseEventKeys.Confirm.EVENT_NEW_VERTICAL_SCROLL_BOTTOM, this.f11120j);
        unsubscribe(BaseEventKeys.Confirm.EVENT_NEW_VERTICAL_HIDE_BOTTOM, this.f11120j);
        unsubscribe(BaseEventKeys.Confirm.EVENT_CONFORM_START_END, this.f11126q);
        unsubscribe(BaseEventKeys.Estimate.ESTIMATE_IS_LOADING, this.f11120j);
        unsubscribe(BaseEventKeys.Estimate.NEW_ESTIMATE_RESULT, this.f11122l);
        unsubscribe(BaseEventKeys.AnyCar.ANYCAR_EYEBALL_RESPONSE, this.f11122l);
        unsubscribe(BaseEventKeys.AnyCar.ANYCAR_EYEBALL_SELECT_OR_UNSELECT, this.f11121k);
        unsubscribe(BaseEventKeys.AnyCar.ESTIMATE_ABNORMAL_TRANSFER_ANYCAR, this.f11124n);
        unsubscribe(BaseEventKeys.AnyCar.ESTIMATE_FAIL_TRANSFER_ANYCAR, this.f11123m);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m7544d() {
        OmegaCommonParamsTrackUtil.setCurrentStateInConfirmPage(GPageIdConstant.G_PAGE_ID_PICONF);
        if (!GPageIdConstant.G_PAGE_ID_PICONF.equals(OmegaSDK.getGlobalAttr("g_PageId"))) {
            GlobalOmegaUtils.putGlobal("g_PageId", GPageIdConstant.G_PAGE_ID_PICONF);
        }
        m7556k();
        this.f11114d.showConfirmAddressPage();
        doPublish(BaseEventKeys.Map.EVENT_GET_ON_SCENE_SHOW_PIN);
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m7546e() {
        if (!this.f11116f) {
            SystemUtils.log(3, f11111a, "switchToEstimatePage: post", (Throwable) null, "com.didi.component.bubbleLayout.impl.BubbleLayoutPresenter", 319);
            this.f11114d.post(new Runnable() {
                public void run() {
                    BubbleLayoutPresenter.this.m7549f();
                }
            });
        } else {
            SystemUtils.log(3, f11111a, "switchToEstimatePage: direct perform", (Throwable) null, "com.didi.component.bubbleLayout.impl.BubbleLayoutPresenter", 327);
            m7549f();
        }
        OmegaCommonParamsTrackUtil.setCurrentStateInConfirmPage(GPageIdConstant.G_PAGE_ID_CONF);
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m7549f() {
        m7555j();
        this.f11114d.showEstimatePage();
        doPublish(BaseEventKeys.Estimate.ESTIMATE_COMPONENT_SHOWN);
    }

    /* renamed from: g */
    private void m7551g() {
        if (this.f11112b != null) {
            this.f11114d.removeAllViews();
            m7552h();
            this.f11114d.bindView(m7535a("estimate", this.f11114d, (Bundle) null), m7535a(ComponentType.GROUP_FORM_CONTAINER, this.f11114d, (Bundle) null), m7535a(ComponentType.CONFIRM_BROADING_POINT, this.f11114d, (Bundle) null), (View) null);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            AnycarBubbleLayout anycarBubbleLayout = this.f11115e;
            if (anycarBubbleLayout != null) {
                anycarBubbleLayout.removeAllViews();
            }
            AnycarBubbleLayout anycarBubbleLayout2 = new AnycarBubbleLayout(this.mContext);
            this.f11115e = anycarBubbleLayout2;
            this.f11114d.addView(anycarBubbleLayout2, layoutParams);
            this.f11114d.bindAnycarView(this.f11115e);
            this.f11115e.bindView(m7535a(ComponentType.ANYCAR_LIST, this.f11115e.getContentView(), (Bundle) null), m7535a(ComponentType.ANYCAR_GROUP_FORM_CONTAINER, this.f11115e.getFormContentView(), (Bundle) null));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m7552h() {
        View view = this.f11117g;
        if (view == null) {
            View view2 = new View(this.mContext);
            this.f11117g = view2;
            view2.setBackgroundColor(-1);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, UiUtils.dip2px(this.mContext, 84.0f));
            layoutParams.addRule(12);
            this.f11114d.addView(this.f11117g, layoutParams);
            return;
        }
        view.setVisibility(0);
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m7554i() {
        View view = this.f11117g;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    /* renamed from: a */
    private View m7535a(String str, ViewGroup viewGroup, Bundle bundle) {
        IComponent newComponent = this.f11112b.newComponent(str, viewGroup, bundle);
        RelativeLayout.LayoutParams layoutParams = null;
        if (newComponent == null || newComponent.getView() == null || newComponent.getView().getView() == null) {
            return null;
        }
        if (newComponent.getView().getView().getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            layoutParams = (RelativeLayout.LayoutParams) newComponent.getView().getView().getLayoutParams();
        }
        if (newComponent.getView().getView().getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) newComponent.getView().getView().getLayoutParams();
            layoutParams2.weight = -1.0f;
            viewGroup.addView(newComponent.getView().getView(), layoutParams2);
        } else {
            if (layoutParams == null) {
                layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            }
            if ("estimate".equals(str)) {
                layoutParams.topMargin = UiUtils.getStatusBarHeight(this.mContext);
            } else {
                layoutParams.addRule(12);
            }
            viewGroup.addView(newComponent.getView().getView(), layoutParams);
        }
        return newComponent.getView().getView();
    }

    /* renamed from: j */
    private void m7555j() {
        GlobalOmegaUtils.putGlobal("g_PageId", GPageIdConstant.G_PAGE_ID_CONF);
        HashMap hashMap = new HashMap();
        Address startAddress = FormStore.getInstance().getDepartureAddress() == null ? FormStore.getInstance().getStartAddress() : FormStore.getInstance().getDepartureAddress();
        Address endAddress = FormStore.getInstance().getEndAddress();
        String str = "";
        if (startAddress != null) {
            hashMap.put("from_poi_id", startAddress.poiId == null ? str : startAddress.poiId);
            hashMap.put("from_lng", Double.valueOf(startAddress.getLongitude()));
            hashMap.put("from_lat", Double.valueOf(startAddress.getLatitude()));
            hashMap.put("from_search_id", startAddress.searchId == null ? str : startAddress.searchId);
            hashMap.put("from_srctag", startAddress.getSrcTag() == null ? str : startAddress.getSrcTag());
        }
        if (endAddress != null) {
            hashMap.put(ParamKeys.PARAM_TO_POI_UID, endAddress.poiId == null ? str : endAddress.poiId);
            hashMap.put("to_lng", Double.valueOf(endAddress.getLongitude()));
            hashMap.put("to_lat", Double.valueOf(endAddress.getLatitude()));
            hashMap.put("to_search_id", endAddress.searchId == null ? str : endAddress.searchId);
            if (endAddress.getSrcTag() != null) {
                str = endAddress.getSrcTag();
            }
            hashMap.put("to_srctag", str);
        }
        SceneHelper instance = SceneHelper.getInstance();
        if (!instance.isFromPickupPoint() && !instance.isOrderIntercepted()) {
            hashMap.put("scene", "AA");
            hashMap.put("rider", Integer.valueOf(FormStore.getInstance().getSeatCount()));
            instance.traceBubbleEventIfNeed(this.mContext, hashMap);
        }
        if (FormStore.getInstance().isFromOpenRide()) {
            GlobalOmegaUtils.trackEvent("Pas_99GO_orderconfirm_sw", (Map<String, Object>) hashMap);
        }
    }

    /* renamed from: k */
    private void m7556k() {
        String str;
        double d;
        double d2;
        Address departureAddress = FormStore.getInstance().getDepartureAddress();
        if (departureAddress == null) {
            departureAddress = FormStore.getInstance().getStartAddress();
        }
        if (departureAddress == null) {
            str = LocationController.getInstance().getReverseDisplayName();
        } else {
            str = departureAddress.getDisplayName();
        }
        if (departureAddress != null) {
            d2 = departureAddress.getLatitude();
            d = departureAddress.getLongitude();
        } else {
            d2 = LocationController.getInstance().getLat(this.mContext);
            d = LocationController.getInstance().getLng(this.mContext);
        }
        HashMap hashMap = new HashMap();
        SceneHelper instance = SceneHelper.getInstance();
        instance.setFromPickupPoint(true);
        instance.setFromPickupPoARA(true);
        hashMap.put("scene", "AA");
        hashMap.put("addr", str);
        hashMap.put("lat", Double.valueOf(d2));
        hashMap.put("lng", Double.valueOf(d));
        String str2 = "";
        if (departureAddress != null) {
            hashMap.put("from_poi_id", departureAddress.poiId == null ? str2 : departureAddress.poiId);
            hashMap.put("from_lng", Double.valueOf(departureAddress.getLongitude()));
            hashMap.put("from_lat", Double.valueOf(departureAddress.getLatitude()));
        }
        Address endAddress = FormStore.getInstance().getEndAddress();
        if (endAddress != null) {
            if (endAddress.poiId != null) {
                str2 = endAddress.poiId;
            }
            hashMap.put(ParamKeys.PARAM_TO_POI_UID, str2);
            hashMap.put("to_lng", Double.valueOf(endAddress.getLongitude()));
            hashMap.put("to_lat", Double.valueOf(endAddress.getLatitude()));
        }
        EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
        if (newEstimateItem != null) {
            hashMap.put("bubble_id", newEstimateItem.estimateId);
        }
        instance.setParamsAFA(hashMap);
        instance.setParamsABA(hashMap);
        hashMap.put("fixed", FormStore.getInstance().isQuotaInCurEstimateItem() ? "1" : "0");
        StartEndCardModel startEndCardModel = this.f11118h;
        if (startEndCardModel != null && !CollectionUtils.isEmpty((Map) startEndCardModel.extraLogData)) {
            hashMap.putAll(this.f11118h.extraLogData);
        }
        GlobalOmegaUtils.putGlobal("g_PageId", GPageIdConstant.G_PAGE_ID_PICONF);
        GlobalOmegaUtils.trackEvent("pas_pickupconfirm_sw", (Map<String, Object>) hashMap);
        this.f11118h = null;
        GLog.m7965d("lxsminibus", "trackPickUpConfirmShowEvent");
    }
}
