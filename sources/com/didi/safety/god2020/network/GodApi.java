package com.didi.safety.god2020.network;

import com.didi.safety.god.http.AbsRpcCallback;
import com.didi.safety.god.http.InitConfigResp2;
import com.didi.safety.god.http.SafetyHttp;
import com.didi.safety.god.http.SafetyResponse2;
import com.didi.safety.god.http.VinAnalizeResp2;
import com.didi.safety.god.http.X1RuleCheckResp2;
import com.didi.safety.god.util.LogUtils;
import com.didichuxing.dfbasesdk.AppContextHolder;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.RpcServiceFactory;
import java.util.HashMap;
import java.util.Map;

public class GodApi {

    /* renamed from: a */
    private static GodApi f34850a = new GodApi();

    /* renamed from: b */
    private final SafetyHttp.SafetyRequest f34851b = ((SafetyHttp.SafetyRequest) new RpcServiceFactory(AppContextHolder.getAppContext()).newRpcService(SafetyHttp.SafetyRequest.class, SafetyHttp.getApiHost()));

    /* renamed from: c */
    private final Map<String, Object> f34852c;

    private GodApi() {
        HashMap hashMap = new HashMap();
        this.f34852c = hashMap;
        hashMap.put("accessType", "SDK");
    }

    public static GodApi getInstance() {
        return f34850a;
    }

    public void fillParams(Map<String, Object> map) {
        this.f34852c.putAll(map);
        LogUtils.m24578d("common body params====" + this.f34852c);
        LogUtils.m24578d("api host===" + SafetyHttp.getApiHost());
    }

    public void getInitConfig2(Map<String, Object> map, RpcService.Callback<SafetyResponse2<InitConfigResp2>> callback) {
        HashMap hashMap = new HashMap(this.f34852c);
        hashMap.putAll(map);
        this.f34851b.getInitConfig2(hashMap, SafetyHttp.getQueryParams(), callback);
    }

    public void upload2(Map<String, Object> map, RpcService.Callback<String> callback) {
        HashMap hashMap = new HashMap(this.f34852c);
        hashMap.putAll(map);
        this.f34851b.uploadFile2(hashMap, SafetyHttp.getQueryParams(), callback);
    }

    public void globalSdkCheck(Map<String, Object> map, RpcService.Callback<String> callback) {
        HashMap hashMap = new HashMap(this.f34852c);
        hashMap.putAll(map);
        this.f34851b.globalCheckSdk(hashMap, SafetyHttp.getQueryParams(), callback);
    }

    public void uploadLocalPic(Map<String, Object> map, RpcService.Callback<String> callback) {
        HashMap hashMap = new HashMap(this.f34852c);
        hashMap.putAll(map);
        this.f34851b.uploadLocalAlbumPic(hashMap, SafetyHttp.getQueryParams(), callback);
    }

    public void vinAnalize2(String str, AbsRpcCallback<SafetyResponse2<VinAnalizeResp2>, VinAnalizeResp2> absRpcCallback) {
        LogUtils.m24578d("vinAnalize2, vin===" + str);
        HashMap hashMap = new HashMap(this.f34852c);
        hashMap.put("vin", str);
        this.f34851b.vinAnalize2(hashMap, SafetyHttp.getQueryParams(), absRpcCallback);
    }

    public void x1RuleCheck(String str, String str2, AbsRpcCallback<SafetyResponse2<X1RuleCheckResp2>, X1RuleCheckResp2> absRpcCallback) {
        LogUtils.m24578d("x1RuleCheck, bId===" + str + ", sId=" + str2);
        HashMap hashMap = new HashMap(this.f34852c);
        hashMap.put("brandId", str);
        hashMap.put("seriesId", str2);
        this.f34851b.x1RuleCheck(hashMap, SafetyHttp.getQueryParams(), absRpcCallback);
    }
}
