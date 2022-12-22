package com.didi.travel.p171v2.biz.rpc;

import com.didi.travel.p171v2.biz.api.Api;
import java.util.Map;

/* renamed from: com.didi.travel.v2.biz.rpc.RpcCommonParamListener */
public interface RpcCommonParamListener {
    Map<String, Object> generateRequestParamMap(Api api, Map<String, Object> map);
}
