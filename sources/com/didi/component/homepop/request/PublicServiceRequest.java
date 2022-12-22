package com.didi.component.homepop.request;

import android.app.Activity;
import android.content.Context;
import com.didi.component.business.util.BusinessDataUtil;
import com.didi.component.business.util.NationComponentDataUtil;
import com.didi.component.business.util.Utils;
import com.didi.sdk.misconfig.p153v2.ConfProxy;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.publicservice.general.ConstantUtils;
import com.didichuxing.publicservice.resourcecontrol.api.ResourceApi;
import com.didichuxing.publicservice.resourcecontrol.pojo.RCRequestParams;
import com.didichuxing.publicservice.resourcecontrol.utils.ResourceManager;

public class PublicServiceRequest implements HomePopupRequest {
    public void requestByService(Context context, String str) {
        if (ResourceManager.getManager().getActivity() == null) {
            Activity activity = (Activity) context;
            ResourceManager.getManager().setActivity(activity);
            ResourceManager.getManager().setApplication(activity.getApplication());
        }
        RCRequestParams rcRequestParams = ResourceManager.getManager().getRcRequestParams();
        if (rcRequestParams == null) {
            rcRequestParams = new RCRequestParams();
        }
        rcRequestParams.token = NationComponentDataUtil.getToken();
        DIDILocation lastKnownLocation = NationComponentDataUtil.getLastKnownLocation();
        if (lastKnownLocation != null) {
            rcRequestParams.lat = lastKnownLocation.getLatitude();
            rcRequestParams.lng = lastKnownLocation.getLongitude();
        }
        rcRequestParams.groupType = ConfProxy.getInstance().getSelectedType();
        ResourceManager.getManager().setRcRequestParams(rcRequestParams);
        String str2 = Utils.isBrazilPackage(context) ? "pas_notice" : ConstantUtils.GLOBAL_RESOURCE_NAME;
        ResourceApi.showPopupByService(ConstantUtils.ResourceId.NOTICE_PUBLIC, str2, Utils.isBrazilPackage(context) ? 316 : 256, str);
        ResourceApi.showPopupByService(ConstantUtils.ResourceId.NOTICE_ZHUANCHE, str2, Integer.parseInt(BusinessDataUtil.getProductId()), str);
    }

    public void cancelGroup() {
        ResourceApi.cancelGroupAbility();
    }

    public void closeWindow() {
        ResourceApi.closePopupWindow();
    }
}
