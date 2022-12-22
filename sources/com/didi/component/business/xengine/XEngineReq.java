package com.didi.component.business.xengine;

import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.xengine.request.XESimpleReqParams;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.sdk.apm.SystemUtils;
import com.didi.xengine.request.XEBizParamsImpl;
import com.didi.xengine.request.XECommitBizParams;
import com.didi.xengine.request.XEDispatchBizParams;
import com.didi.xengine.request.XEngineReqUtil;
import com.google.gson.JsonObject;

public class XEngineReq {

    /* renamed from: a */
    private static final String f11407a = XEngineReq.class.getSimpleName();

    /* renamed from: b */
    private static final XEngineReqUtil f11408b = new XEngineReqUtil(XERequestKey.X_ENGINE_TYPE_4_PASSENGER);

    public static void pageRequest(String str) {
        f11408b.pageRequest(str);
        SystemUtils.log(3, f11407a, "pageRequest: ", new Exception(), "com.didi.component.business.xengine.XEngineReq", 31);
    }

    public static void pageRequest(XEBizParamsImpl xEBizParamsImpl) {
        f11408b.pageRequest(xEBizParamsImpl);
    }

    public static void simpleRequest(XEBizParamsImpl xEBizParamsImpl) {
        f11408b.simpleRequest(xEBizParamsImpl);
    }

    public static void simpleRequest(String str, String... strArr) {
        f11408b.simpleRequest(str, strArr);
    }

    public static void engineCommit(XECommitBizParams xECommitBizParams) {
        f11408b.engineCommit(xECommitBizParams);
    }

    @Deprecated
    public static void simpleRequest(XESimpleReqParams xESimpleReqParams) {
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.XEngine.EVENT_XENGINE_SIMPLE_REQUEST, xESimpleReqParams);
    }

    public static void engineDispatch(JsonObject jsonObject, String str) {
        XEDispatchBizParams xEDispatchBizParams = new XEDispatchBizParams();
        xEDispatchBizParams.scene = str;
        xEDispatchBizParams.dispatchData = jsonObject;
        engineDispatch(xEDispatchBizParams);
    }

    public static void engineDispatch(XEDispatchBizParams xEDispatchBizParams) {
        f11408b.engineDispatch(xEDispatchBizParams);
    }
}
