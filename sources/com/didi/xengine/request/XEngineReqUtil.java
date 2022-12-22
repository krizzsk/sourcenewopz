package com.didi.xengine.request;

import com.didi.xengine.config.EngineInitInstance;

public class XEngineReqUtil {

    /* renamed from: a */
    private final String f45198a;

    public XEngineReqUtil(String str) {
        this.f45198a = str;
    }

    public void pageRequest(String str) {
        XEBizParamsImpl xEBizParamsImpl = new XEBizParamsImpl();
        xEBizParamsImpl.scene = str;
        pageRequest(xEBizParamsImpl);
    }

    public void pageRequest(XEBizParamsImpl xEBizParamsImpl) {
        if (EngineInitInstance.getInstance().getConfig(this.f45198a) != null && EngineInitInstance.getInstance().getConfig(this.f45198a).getMethod() != null) {
            EngineInitInstance.getInstance().getConfig(this.f45198a).getMethod().pageRequest(xEBizParamsImpl);
        }
    }

    public void simpleRequest(XEBizParamsImpl xEBizParamsImpl) {
        if (EngineInitInstance.getInstance().getConfig(this.f45198a) != null && EngineInitInstance.getInstance().getConfig(this.f45198a).getMethod() != null) {
            EngineInitInstance.getInstance().getConfig(this.f45198a).getMethod().simpleRequest(xEBizParamsImpl);
        }
    }

    public void simpleRequest(String str, String... strArr) {
        XEBizParamsImpl xEBizParamsImpl = new XEBizParamsImpl();
        xEBizParamsImpl.requestKeys = strArr;
        xEBizParamsImpl.scene = str;
        simpleRequest(xEBizParamsImpl);
    }

    public void engineCommit(XECommitBizParams xECommitBizParams) {
        if (EngineInitInstance.getInstance().getConfig(this.f45198a) != null && EngineInitInstance.getInstance().getConfig(this.f45198a).getMethod() != null) {
            EngineInitInstance.getInstance().getConfig(this.f45198a).getMethod().engineCommit(xECommitBizParams);
        }
    }

    public void engineDispatch(XEDispatchBizParams xEDispatchBizParams) {
        if (EngineInitInstance.getInstance().getConfig(this.f45198a) != null && EngineInitInstance.getInstance().getConfig(this.f45198a).getMethod() != null) {
            EngineInitInstance.getInstance().getConfig(this.f45198a).getMethod().engineDispatch(xEDispatchBizParams);
        }
    }

    public void setCache(XECacheParamsImpl xECacheParamsImpl, Boolean bool) {
        if (EngineInitInstance.getInstance().getConfig(this.f45198a) != null && EngineInitInstance.getInstance().getConfig(this.f45198a).getMethod() != null) {
            EngineInitInstance.getInstance().getConfig(this.f45198a).getMethod().setCache(xECacheParamsImpl, bool);
        }
    }
}
