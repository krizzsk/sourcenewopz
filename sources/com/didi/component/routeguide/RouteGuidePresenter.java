package com.didi.component.routeguide;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.web.GlobalWebUrl;
import com.didi.component.common.GlobalWebActivity;
import com.didi.component.common.util.AddressUtil;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.sdk.nation.NationComponentData;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.travel.psnger.core.model.response.DTSDKOrderStatus;
import com.didi.travel.psnger.model.response.CarOrder;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;

public class RouteGuidePresenter extends AbsRouteGuidePresenter {

    /* renamed from: a */
    BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f15352a = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            DTSDKOrderStatus dTSDKOrderStatus = CarOrderHelper.getOrder().orderState;
            if (dTSDKOrderStatus != null && dTSDKOrderStatus.status == 4 && dTSDKOrderStatus.subStatus == 4006) {
                RouteGuidePresenter.this.doPublish(BaseEventKeys.Service.OnService.EVENT_ONSERVICE_AIRPORT_PANEL, false);
            }
        }
    };

    /* renamed from: b */
    private RouteGuideData f15353b;

    public RouteGuidePresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        subscribe(BaseEventKeys.Service.EVENT_ORDER_STATUS_RECEIVED, this.f15352a);
        RouteGuideData initCardData = initCardData();
        this.f15353b = initCardData;
        if (initCardData != null) {
            m11014a("gp_routeGuide_btn_sw");
            doPublish(BaseEventKeys.Service.OnService.EVENT_ONSERVICE_AIRPORT_PANEL, true);
            ((IRouteGuideView) this.mView).updateData(this.f15353b);
            return;
        }
        doPublish(BaseEventKeys.Service.OnService.EVENT_ONSERVICE_AIRPORT_PANEL, false);
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        unsubscribe(BaseEventKeys.Service.EVENT_ORDER_STATUS_RECEIVED, this.f15352a);
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (this.f15353b != null) {
            m11014a("gp_routeGuide_btn_ck");
            Intent intent = new Intent(this.mContext, GlobalWebActivity.class);
            intent.putExtra("web_view_model", GlobalWebUrl.buildWebViewModel(this.f15353b.guideUrl));
            startActivity(intent);
        }
    }

    /* access modifiers changed from: protected */
    public RouteGuideData initCardData() {
        CarOrder order = CarOrderHelper.getOrder();
        if (order == null || order.airportPanelData == null) {
            return null;
        }
        RouteGuideData routeGuideData = new RouteGuideData();
        routeGuideData.title = order.airportPanelData.fromArea;
        routeGuideData.subTitle = order.airportPanelData.subText;
        routeGuideData.iconResId = R.drawable.icon_airport_panel_guide_tip;
        routeGuideData.bottom = ResourcesHelper.getString(this.mContext, R.string.global_airport_panel_learn_more);
        routeGuideData.guideUrl = order.airportPanelData.guideUrl;
        routeGuideData.listener = this;
        return routeGuideData;
    }

    /* renamed from: a */
    private void m11014a(String str) {
        NationComponentData nationComponentData = NationTypeUtil.getNationComponentData();
        HashMap hashMap = new HashMap();
        hashMap.put("country_code", AddressUtil.getTripCountry(nationComponentData));
        hashMap.put("city_code", AddressUtil.getTripCityId(nationComponentData));
        GlobalOmegaUtils.trackEvent(str, (Map<String, Object>) hashMap);
    }
}
