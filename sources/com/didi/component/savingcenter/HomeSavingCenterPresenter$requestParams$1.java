package com.didi.component.savingcenter;

import com.didi.component.common.bff.BFFStore;
import com.didi.xengine.callback.XEReqJSONParamsCallbackImpl;
import com.didiglobal.scan.GlobalScan;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(mo175977d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, mo175978d2 = {"com/didi/component/savingcenter/HomeSavingCenterPresenter$requestParams$1", "Lcom/didi/xengine/callback/XEReqJSONParamsCallbackImpl;", "getRequestParams", "Lorg/json/JSONObject;", "comp-savingcenter_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: HomeSavingCenterPresenter.kt */
public final class HomeSavingCenterPresenter$requestParams$1 extends XEReqJSONParamsCallbackImpl {
    final /* synthetic */ HomeSavingCenterPresenter this$0;

    HomeSavingCenterPresenter$requestParams$1(HomeSavingCenterPresenter homeSavingCenterPresenter) {
        this.this$0 = homeSavingCenterPresenter;
    }

    public JSONObject getRequestParams() {
        Map hashMap = new HashMap();
        hashMap.put("scene", "home");
        hashMap.put("from", GlobalScan.ScanFrom.INDEX.getFrom());
        hashMap.put("user_type", Integer.valueOf(BFFStore.getCarWanliuUserType(this.this$0.mContext)));
        return new JSONObject(hashMap);
    }
}
