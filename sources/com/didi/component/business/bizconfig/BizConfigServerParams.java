package com.didi.component.business.bizconfig;

import android.content.Context;
import com.didi.component.common.util.GLog;
import com.didi.sdk.util.CommonParamsUtil;
import com.didichuxing.foundation.gson.GsonSerializer;
import com.didichuxing.foundation.p188io.StringDeserializer;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.annotation.Deserialization;
import com.didichuxing.foundation.rpc.annotation.Path;
import com.didichuxing.foundation.rpc.annotation.QueryParameter;
import com.didichuxing.foundation.rpc.annotation.Serialization;
import com.didichuxing.foundation.rpc.annotation.TargetThread;
import com.didichuxing.foundation.rpc.annotation.ThreadType;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class BizConfigServerParams {
    public static final String BUSINESS_CONF = "business_conf";
    public static final String BUSINESS_ID = "business_id";
    public static final String VERSION = "version";

    @Path("/gulfstream/passenger/v2/other")
    public interface BizConfigService extends RpcService {
        @Serialization(GsonSerializer.class)
        @Path("/pGetBizConfig")
        @Deserialization(StringDeserializer.class)
        Object getBizConfig(@QueryParameter("") HashMap<String, Object> hashMap, @TargetThread(ThreadType.WORKER) RpcService.Callback<String> callback);
    }

    public static HashMap<String, Object> createParams(Context context, Map<String, Integer> map) {
        String str = "";
        if (map != null) {
            try {
                if (map.size() > 0) {
                    JSONArray jSONArray = new JSONArray();
                    for (String next : map.keySet()) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("business_id", next);
                        jSONObject.put("version", map.get(next));
                        jSONArray.put(jSONObject);
                    }
                    str = jSONArray.toString();
                }
            } catch (Exception e) {
                GLog.m7964d("BizConfigServerParams error:" + e.getMessage());
            }
        }
        GLog.m7964d(" BizConfigServerParams json :" + str);
        HashMap hashMap = new HashMap();
        hashMap.put(BUSINESS_CONF, str);
        return CommonParamsUtil.addCommonParam(hashMap, context);
    }
}
