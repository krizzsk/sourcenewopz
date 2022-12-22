package com.didi.component.comp_xpanel.presenter;

import android.os.Bundle;
import android.text.TextUtils;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.tracker.GPageIdConstant;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.common.animator.VisibilityChangeListenerAdapter;
import com.didi.component.common.base.ComponentType;
import com.didi.component.common.helper.SceneHelper;
import com.didi.component.common.util.LocationController;
import com.didi.component.comp_xpanel.AbsGlobalXPanelPresenter;
import com.didi.component.comp_xpanel.XPanelScene;
import com.didi.component.comp_xpanel.model.CardProperties;
import com.didi.component.comp_xpanel.view.GlobalConfirmXPanelView;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.reactive.tracker.EventTracker;
import com.didi.reactive.tracker.OneshotShowEventAttrGetter;
import com.didi.sdk.address.address.entity.Address;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didi.travel.psnger.model.response.estimate.EstimateItemModel;
import com.didichuxing.omega.sdk.init.OmegaSDK;
import java.util.HashMap;
import java.util.Map;

public class GlobalXPanelConfirmPresenter extends AbsGlobalXPanelPresenter<GlobalConfirmXPanelView> {

    /* renamed from: a */
    BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f12533a = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (!BaseEventKeys.Confirm.EVENT_SHOW_CONFIRM_ADDRESS.equals(str) && !BaseEventKeys.Confirm.EVENT_SHOW_CONFIRM_PRICE.equals(str) && !"event_confirm_boarding_enable_city".equals(str) && !BaseEventKeys.Confirm.EVENT_SHOW_XPANEL.equals(str) && !BaseEventKeys.Confirm.EVENT_HIDE_XPANEL.equals(str) && !BaseEventKeys.Confirm.EVENT_NEW_ESTIMATE_HIDE_GROUP_FORM.equalsIgnoreCase(str)) {
                BaseEventKeys.Confirm.EVENT_NEW_ESTIMATE_SHOW_GROUP_FORM.equalsIgnoreCase(str);
            }
        }
    };

    /* renamed from: c */
    private void m8518c() {
    }

    /* renamed from: d */
    private void m8519d() {
    }

    /* access modifiers changed from: protected */
    public String[] getDefaultCards() {
        return null;
    }

    public String getDimension() {
        return XPanelScene.SCENE_CONFIRM;
    }

    public GlobalXPanelConfirmPresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        m8518c();
        m8516a(bundle);
        m8517b();
    }

    /* renamed from: b */
    private void m8517b() {
        CardProperties propertiesByType = getPropertiesByType(ComponentType.CONFIRM_BROADING_POINT);
        if (propertiesByType != null) {
            EventTracker.bind(propertiesByType.mView).trackOnShow(true, "pas_pickupconfirm_sw_new", new OneshotShowEventAttrGetter());
        }
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        m8519d();
    }

    /* renamed from: a */
    private void m8516a(Bundle bundle) {
        initInflateComponent();
        m8520e();
    }

    /* access modifiers changed from: protected */
    public void initInflateComponent() {
        inflateServiceComponent(ComponentType.CONFIRM_BROADING_POINT, (Bundle) null);
        setVisibilityByType(ComponentType.CONFIRM_BROADING_POINT, false);
    }

    /* access modifiers changed from: protected */
    public void inflateServiceComponent(String str, Bundle bundle) {
        inflateComponent(str, -1, true, false, bundle);
    }

    /* renamed from: e */
    private void m8520e() {
        if (!isVisibileByType(ComponentType.CONFIRM_BROADING_POINT)) {
            if (!"pick".equals(OmegaSDK.getGlobalAttr("g_PageId"))) {
                GlobalOmegaUtils.putGlobal("g_PageId", GPageIdConstant.G_PAGE_ID_PICONF);
            }
            m8521f();
            ((GlobalConfirmXPanelView) this.mView).hide(0, new VisibilityChangeListenerAdapter() {
                public void onHidden() {
                    if (!GlobalXPanelConfirmPresenter.this.isRemoved()) {
                        GlobalXPanelConfirmPresenter.this.setVisibilityByType(ComponentType.CONFIRM_BROADING_POINT, true);
                        GlobalXPanelConfirmPresenter.this.commit();
                        ((GlobalConfirmXPanelView) GlobalXPanelConfirmPresenter.this.mView).show(0, new VisibilityChangeListenerAdapter() {
                            public void onShown() {
                                GlobalXPanelConfirmPresenter.this.doPublish(BaseEventKeys.Map.EVENT_GET_ON_SCENE_SHOW_PIN);
                                GlobalXPanelConfirmPresenter.this.doPublish(BaseEventKeys.Map.EVENT_ONSERVICE_SHOW_ADDRESS_AREA);
                            }
                        });
                    }
                }
            });
        }
    }

    /* renamed from: f */
    private void m8521f() {
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
        int i = 1;
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
            hashMap.put("from_addr", !TextUtils.isEmpty(departureAddress.address) ? departureAddress.address : departureAddress.displayName);
            hashMap.put("from_srctag", departureAddress.getSrcTag() == null ? str2 : departureAddress.getSrcTag());
        }
        Address endAddress = FormStore.getInstance().getEndAddress();
        if (endAddress != null) {
            hashMap.put(ParamKeys.PARAM_TO_POI_UID, endAddress.poiId == null ? str2 : endAddress.poiId);
            hashMap.put("to_lng", Double.valueOf(endAddress.getLongitude()));
            hashMap.put("to_lat", Double.valueOf(endAddress.getLatitude()));
            hashMap.put("to_addr", !TextUtils.isEmpty(endAddress.address) ? endAddress.address : endAddress.displayName);
            if (endAddress.getSrcTag() != null) {
                str2 = endAddress.getSrcTag();
            }
            hashMap.put("to_srctag", str2);
        }
        hashMap.put("cartype", Integer.valueOf(FormStore.getInstance().getCarLevel()));
        if (FormStore.getInstance().getTransportTime() == 0) {
            i = 0;
        }
        hashMap.put("order_type", Integer.valueOf(i));
        EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
        if (newEstimateItem != null) {
            hashMap.put("bubble_id", newEstimateItem.estimateId);
        }
        instance.setParamsAFA(hashMap);
        instance.setParamsABA(hashMap);
        hashMap.put("fixed", FormStore.getInstance().isQuotaInCurEstimateItem() ? "1" : "0");
        GlobalOmegaUtils.trackEvent("pas_pickupconfirm_sw", (Map<String, Object>) hashMap);
    }
}
