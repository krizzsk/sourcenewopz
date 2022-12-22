package com.didi.travel.p171v2.biz;

import com.didi.travel.p171v2.IKey;
import com.didi.travel.p171v2.biz.api.ApiInvokePolicy;
import com.didi.travel.p171v2.biz.api.IIApi;
import com.didichuxing.foundation.rpc.RpcService;

/* renamed from: com.didi.travel.v2.biz.IBiz */
public interface IBiz extends IKey, RpcService {
    public static final String API_KEY_BIZ_KEY = "biz_key";

    @IIApi(apiInvokePolicy = ApiInvokePolicy.INNER, key = "biz_key")
    String getKey();
}
