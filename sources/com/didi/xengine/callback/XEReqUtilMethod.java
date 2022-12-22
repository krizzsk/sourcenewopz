package com.didi.xengine.callback;

import com.didi.xengine.request.XEBizParamsImpl;
import com.didi.xengine.request.XECacheParamsImpl;
import com.didi.xengine.request.XECommitBizParams;
import com.didi.xengine.request.XEDispatchBizParams;

public interface XEReqUtilMethod {
    void engineCommit(XECommitBizParams xECommitBizParams);

    void engineDispatch(XEDispatchBizParams xEDispatchBizParams);

    void pageRequest(XEBizParamsImpl xEBizParamsImpl);

    void setCache(XECacheParamsImpl xECacheParamsImpl, Boolean bool);

    void simpleRequest(XEBizParamsImpl xEBizParamsImpl);
}
