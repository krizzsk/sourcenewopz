package com.didiglobal.p205sa.biz.component.homemsg;

import com.didi.sdk.util.SaApolloUtil;
import com.didi.xengine.callback.XEReqJSONParamsCallbackImpl;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationManager;
import com.didichuxing.bigdata.p173dp.locsdk.Utils;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(mo175977d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, mo175978d2 = {"com/didiglobal/sa/biz/component/homemsg/HomeMsgPresenter$paramCallback$1", "Lcom/didi/xengine/callback/XEReqJSONParamsCallbackImpl;", "getRequestParams", "Lorg/json/JSONObject;", "biz-library_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didiglobal.sa.biz.component.homemsg.HomeMsgPresenter$paramCallback$1 */
/* compiled from: HomeMsgPresenter.kt */
public final class HomeMsgPresenter$paramCallback$1 extends XEReqJSONParamsCallbackImpl {
    final /* synthetic */ HomeMsgPresenter this$0;

    HomeMsgPresenter$paramCallback$1(HomeMsgPresenter homeMsgPresenter) {
        this.this$0 = homeMsgPresenter;
    }

    public JSONObject getRequestParams() {
        Map hashMap = new HashMap();
        hashMap.put("location_authorization", Integer.valueOf((!Utils.isLocationPermissionGranted(this.this$0.mContext) || DIDILocationManager.getInstance(this.this$0.mContext).isLocationSwitchOff()) ? 0 : 1));
        DIDILocation lastKnownLocation = DIDILocationManager.getInstance(this.this$0.mContext).getLastKnownLocation();
        if (lastKnownLocation != null) {
            hashMap.put("select_lat", Double.valueOf(lastKnownLocation.getLatitude()));
            hashMap.put("select_lng", Double.valueOf(lastKnownLocation.getLongitude()));
        }
        if (SaApolloUtil.INSTANCE.getSaOneState()) {
            hashMap.put("is_sa_tab", 1);
        } else {
            hashMap.put("is_sa_tab", 0);
        }
        return new JSONObject(hashMap);
    }
}
