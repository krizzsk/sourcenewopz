package com.didi.sdk.global.common.utils;

import android.content.Context;
import com.didi.payment.base.utils.PayBaseParamUtil;
import java.util.HashMap;

public class RpcParameterBuilder {

    /* renamed from: a */
    private Context f36100a;

    /* renamed from: b */
    private HashMap<String, Object> f36101b;

    public RpcParameterBuilder(Context context) {
        this.f36100a = context;
        HashMap<String, Object> hashMap = new HashMap<>();
        this.f36101b = hashMap;
        hashMap.putAll(PayBaseParamUtil.getHttpBaseParams(this.f36100a));
    }

    public RpcParameterBuilder addParam(String str, Object obj) {
        this.f36101b.put(str, obj);
        return this;
    }

    public HashMap<String, Object> build() {
        return this.f36101b;
    }
}
