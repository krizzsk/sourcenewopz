package com.didi.component.comp_homecard.destination;

import android.os.Bundle;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.model.HomeCardModel;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.NationComponentDataUtil;
import com.didi.component.business.util.SendOrderUtils;
import com.didi.component.common.util.SearchIdUploadManager;
import com.didi.component.core.ComponentParams;
import com.didi.map.global.component.departure.DepartureConstants;
import com.didi.map.global.flow.scene.sug.SugResult;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.app.BusinessContext;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.sdk.poibase.model.RpcPoiBaseInfo;
import java.util.HashMap;
import java.util.Map;

public class HomeDestinationCardPresenter extends AbsHomeDestinationCardPresenter {

    /* renamed from: a */
    private BusinessContext f12236a;

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m8288b() {
        HashMap hashMap = new HashMap();
        hashMap.put("message", "");
        GlobalOmegaUtils.trackEvent("ibt_gp_home_destinationbox_view_sw", (Map<String, Object>) hashMap);
    }

    public HomeDestinationCardPresenter(ComponentParams componentParams) {
        super(componentParams);
        this.f12236a = componentParams.bizCtx;
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        ((IHomeDestinationCardView) this.mView).setVisibility(0, new Runnable() {
            public void run() {
                HomeDestinationCardPresenter.this.m8288b();
            }
        });
        ((IHomeDestinationCardView) this.mView).setGuessItemClickListener(this);
    }

    /* access modifiers changed from: protected */
    public void onPageResume() {
        super.onPageResume();
    }

    /* access modifiers changed from: protected */
    public void onPagePause() {
        super.onPagePause();
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
    }

    /* access modifiers changed from: protected */
    public void onBackHome(Bundle bundle) {
        super.onBackHome(bundle);
        ((IHomeDestinationCardView) this.mView).setVisibility(0, (Runnable) null);
    }

    /* access modifiers changed from: protected */
    public void onLeaveHome() {
        super.onLeaveHome();
    }

    public void clickWhereToGo() {
        clearOpenRideCarOrder();
        doPublish(BaseEventKeys.Service.EVENT_DESTINATION_CLICKED);
        m8289c();
    }

    /* renamed from: c */
    private void m8289c() {
        HashMap hashMap = new HashMap();
        hashMap.put("isRecommended", ((IHomeDestinationCardView) this.mView).isRecListShown() ? "1" : "0");
        hashMap.put("city_id", NationComponentDataUtil.getLocCityId());
        hashMap.put("country_code", NationComponentDataUtil.getLocCountry());
        hashMap.put("message", "");
        GlobalOmegaUtils.trackEvent("pas_destinationbox_ck", (Map<String, Object>) hashMap);
        prepareForward((SugResult) null);
        SearchIdUploadManager.getInstance().setEstimateAction("where_to_go");
    }

    public void onItemClick(int i, HomeCardModel homeCardModel) {
        HomeCardModel homeCardModel2;
        clearOpenRideCarOrder();
        FormStore.getInstance().setIsClickGuessDestination(true);
        SugResult sugResult = new SugResult();
        sugResult.isStartNeedNearRoad = true;
        Address endAddress = SendOrderUtils.getEndAddress(homeCardModel);
        sugResult.start = getStartAddress(this.mContext);
        sugResult.end = endAddress;
        prepareForward(sugResult);
        if (this.mResultList != null && this.mResultList.size() > i && (homeCardModel2 = (HomeCardModel) this.mResultList.get(i)) != null && homeCardModel2.base_info != null) {
            RpcPoiBaseInfo rpcPoiBaseInfo = homeCardModel2.base_info;
            HashMap hashMap = new HashMap();
            hashMap.put("name", rpcPoiBaseInfo.displayname);
            hashMap.put("address", rpcPoiBaseInfo.address);
            hashMap.put("uid", rpcPoiBaseInfo.poi_id);
            hashMap.put("guessDesid", this.mSearchId);
            hashMap.put("rank", Integer.valueOf(i));
            hashMap.put(DepartureConstants.SRCTAG, rpcPoiBaseInfo.srctag);
            if (homeCardModel2.extend_info != null) {
                hashMap.put("poi_ui_tag", homeCardModel2.extend_info.poi_ui_tag);
            }
            hashMap.put("searchname", this.mSearchName);
            hashMap.put(ParamConst.PARAM_ADDRESS_LAT, Double.valueOf(rpcPoiBaseInfo.lat));
            hashMap.put(ParamConst.PARAM_ADDRESS_LNG, Double.valueOf(rpcPoiBaseInfo.lng));
            hashMap.put("is_fastCall", false);
            GlobalOmegaUtils.trackEvent("requireDlg_guessDestination_ck", (Map<String, Object>) hashMap);
        }
    }
}
