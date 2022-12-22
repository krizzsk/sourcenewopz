package com.didi.travel.p171v2.biz.rpc;

import com.didi.travel.p171v2.biz.api.Api;

/* renamed from: com.didi.travel.v2.biz.rpc.IRpcDynamicHostCallback */
public interface IRpcDynamicHostCallback {
    String getHost(Api api, String str, String str2);

    String getSharePath(Api api, String str, String str2);
}
