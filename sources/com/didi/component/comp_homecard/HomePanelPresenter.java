package com.didi.component.comp_homecard;

import android.os.Bundle;
import android.text.TextUtils;
import com.didi.component.business.commonlist.AbsCommonListPresenter;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.util.BusinessUtils;
import com.didi.component.business.util.GlobalApolloUtil;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.NationComponentDataUtil;
import com.didi.component.business.xengine.XERequestKey;
import com.didi.component.business.xengine.XEngineReq;
import com.didi.component.common.base.ComponentType;
import com.didi.component.common.util.LocationUtils;
import com.didi.component.comp_homecard.template.TemplateHomeCardBizModel;
import com.didi.component.comp_homecard.template.TemplateHomeCardBizView;
import com.didi.component.core.ComponentParams;
import com.didi.component.unenablecity.utils.HomeCardOmegaUtils;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.nation.MapType;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.util.SystemUtil;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didi.soda.compose.card.BaseCard;
import com.didi.xengine.request.XEBizParamsImpl;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationManager;
import com.didiglobal.common.common.xengine.XEngineRegister;
import com.didiglobal.enginecore.component.XEComponent;
import com.didiglobal.enginecore.register.XERegisterModel;
import com.didiglobal.enginecore.template.temp.XETemplateComponent;
import com.didiglobal.enginecore.template.xml.XMLComponent;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class HomePanelPresenter extends AbsCommonListPresenter {

    /* renamed from: a */
    private BusinessContext f12225a;

    /* renamed from: b */
    private int f12226b = 0;

    /* access modifiers changed from: protected */
    public void afterRemoveCard() {
    }

    /* access modifiers changed from: protected */
    public String getComponentIdByType(String str) {
        return str;
    }

    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        addNativeCard(ComponentType.HOME_ADDRESS_CARD);
    }

    public HomePanelPresenter(ComponentParams componentParams) {
        super(componentParams);
        this.f12225a = componentParams.bizCtx;
    }

    /* access modifiers changed from: protected */
    public String[] getNativeCards() {
        return new String[]{ComponentType.HOME_ADDRESS_CARD};
    }

    /* access modifiers changed from: protected */
    public XERegisterModel getXERegisterModel() {
        XERegisterModel xERegisterModel = new XERegisterModel(XERequestKey.REQUEST_KEY_PASSENGER_HOME_CARD, XERequestKey.SCENE_HOME, this.xeResponse);
        xERegisterModel.components = new ArrayList();
        xERegisterModel.components.add(new XETemplateComponent("template_standard_biz_home_card", TemplateHomeCardBizView.class, TemplateHomeCardBizModel.class));
        return xERegisterModel;
    }

    /* access modifiers changed from: protected */
    public void addXERequestParams(Map<String, Object> map) {
        map.put("product_id", Integer.valueOf(BusinessUtils.getCurrentBID(this.f12225a)));
        map.put("requester_type", "1");
        map.put("app_id", this.mContext.getApplicationInfo().packageName);
        map.put("imei", SystemUtil.getIMEI());
        map.put("platform", "2");
        map.put("lang", NationTypeUtil.getNationComponentData().getLocaleCode());
        DIDILocation lastKnownLocation = DIDILocationManager.getInstance(this.mContext).getLastKnownLocation();
        if (lastKnownLocation != null) {
            map.put("user_loc_lng", Double.valueOf(lastKnownLocation.getLongitude()));
            map.put("user_loc_lat", Double.valueOf(lastKnownLocation.getLatitude()));
        }
        if (GlobalApolloUtil.isBffMaptypeParamFix()) {
            map.put("coordinate_type", MapType.MAPTYPE_WGS84.getMapTypeString());
        } else {
            map.put("coordinate_type", NationComponentDataUtil.getMapTypeString());
        }
        map.put("map_type", "gmap");
        map.put("no_location_permission", Integer.valueOf(LocationUtils.parseLocation(this.mContext) != 0 ? 1 : 0));
        map.put("networky_type", SystemUtil.getNetworkType());
    }

    public void request() {
        XEBizParamsImpl xEBizParamsImpl = new XEBizParamsImpl();
        xEBizParamsImpl.requestKeys = new String[]{XERequestKey.REQUEST_KEY_PASSENGER_HOME_CARD};
        xEBizParamsImpl.scene = XERequestKey.SCENE_HOME;
        XEngineReq.simpleRequest(xEBizParamsImpl);
    }

    public void onRemove() {
        super.onRemove();
        XEngineRegister.unregister(XERequestKey.REQUEST_KEY_PASSENGER_HOME_CARD);
    }

    /* access modifiers changed from: protected */
    public boolean handleData(JsonObject jsonObject, List<XEComponent> list) {
        XEComponent xEComponent;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        int optInt;
        if (!CollectionUtil.isEmpty((Collection<?>) list) && (xEComponent = list.get(0)) != null) {
            JSONObject data = xEComponent.getData();
            if (!(data == null || (optJSONObject = data.optJSONObject("extension")) == null || (optJSONObject2 = optJSONObject.optJSONObject("biz_params")) == null || (optInt = optJSONObject2.optInt("page_state")) == this.f12226b)) {
                doPublish(BaseEventKeys.XBanner.EVENT_HOME_REFACTOR_XBANNER_RELOAD_WITH_PAGE_STATE, Integer.valueOf(optInt));
                this.f12226b = optInt;
            }
            if (xEComponent instanceof XMLComponent) {
                String id = xEComponent.getId();
                if (!TextUtils.isEmpty(id) && (HomeCardOmegaUtils.CARD_ID_ORDER_BAN.equals(id) || HomeCardOmegaUtils.CARD_ID_EDU.equals(id))) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(BaseCard.KEY_CARD_ID, id);
                    GlobalOmegaUtils.trackEvent("ibt_gp_home_unavailablecard_sw", (Map<String, Object>) hashMap);
                }
            }
        }
        return false;
    }
}
