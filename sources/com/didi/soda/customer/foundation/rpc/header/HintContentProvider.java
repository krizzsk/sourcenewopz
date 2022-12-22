package com.didi.soda.customer.foundation.rpc.header;

import com.didi.foundation.sdk.utils.LocalizationUtils;
import com.didi.soda.customer.foundation.util.GsonUtil;
import com.didi.soda.customer.foundation.util.LocationUtil;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.ILocaleService;
import com.didichuxing.foundation.net.rpc.http.HttpRpcClient;
import com.didichuxing.foundation.net.rpc.http.HttpRpcRequest;

public class HintContentProvider extends AbsHttpHeaderContentProvider {

    /* renamed from: a */
    private static final String f41053a = "didi-header-hint-content";

    public String getParamKey() {
        return f41053a;
    }

    public HintContentProvider(HttpRpcRequest httpRpcRequest, HttpRpcClient httpRpcClient) {
        super(httpRpcRequest, httpRpcClient);
    }

    public String getParamContent() {
        return m29125c();
    }

    /* renamed from: c */
    private String m29125c() {
        HintContentStruct hintContentStruct = new HintContentStruct();
        hintContentStruct.setLang(((ILocaleService) CustomerServiceManager.getService(ILocaleService.class)).getLangTag());
        hintContentStruct.setAppTimeout(mo104801a().getReadTimeout() + mo104801a().getWriteTimeout());
        hintContentStruct.setCityId(LocationUtil.getCityId());
        hintContentStruct.setUtcOffset(String.valueOf(LocalizationUtils.getTimeZoneUtcOffset()));
        return GsonUtil.toJson(hintContentStruct);
    }
}
