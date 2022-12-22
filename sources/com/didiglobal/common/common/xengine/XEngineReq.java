package com.didiglobal.common.common.xengine;

import com.didi.sdk.apm.SystemUtils;
import com.didi.xengine.request.XEBizParamsImpl;
import com.didi.xengine.request.XECacheParamsImpl;
import com.didi.xengine.request.XECommitBizParams;
import com.didi.xengine.request.XEDispatchBizParams;
import com.didi.xengine.request.XEngineReqUtil;

public class XEngineReq {

    /* renamed from: a */
    private static final String f49748a = XEngineReq.class.getSimpleName();

    /* renamed from: b */
    private static final String f49749b = "eevee";

    /* renamed from: c */
    private static final XEngineReqUtil f49750c = new XEngineReqUtil("eevee");

    public static void pageRequest(String str) {
        f49750c.pageRequest(str);
        SystemUtils.log(3, f49748a, "pageRequest: ", new Exception(), "com.didiglobal.common.common.xengine.XEngineReq", 29);
    }

    public static void pageRequest(String str, Boolean bool) {
        XEBizParamsImpl xEBizParamsImpl = new XEBizParamsImpl();
        xEBizParamsImpl.scene = str;
        xEBizParamsImpl.requestCache = bool;
        f49750c.pageRequest(xEBizParamsImpl);
    }

    public static void pageRequest(XEBizParamsImpl xEBizParamsImpl) {
        f49750c.pageRequest(xEBizParamsImpl);
    }

    public static void simpleRequest(XEBizParamsImpl xEBizParamsImpl) {
        f49750c.simpleRequest(xEBizParamsImpl);
    }

    public static void simpleRequest(String str, String... strArr) {
        f49750c.simpleRequest(str, strArr);
    }

    public static void engineCommit(XECommitBizParams xECommitBizParams) {
        f49750c.engineCommit(xECommitBizParams);
    }

    public static void engineDispatch(XEDispatchBizParams xEDispatchBizParams) {
        f49750c.engineDispatch(xEDispatchBizParams);
    }

    public static void setDefaultCache(XECacheParamsImpl xECacheParamsImpl) {
        f49750c.setCache(xECacheParamsImpl, true);
    }

    public static void setCache(XECacheParamsImpl xECacheParamsImpl, Boolean bool) {
        f49750c.setCache(xECacheParamsImpl, bool);
    }
}
