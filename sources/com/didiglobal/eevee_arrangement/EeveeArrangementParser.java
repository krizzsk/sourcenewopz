package com.didiglobal.eevee_arrangement;

import android.text.TextUtils;
import com.didi.xengine.request.XECacheParamsImpl;
import com.didiglobal.common.business.arrangement.model.EeveeArrangementArrayItem;
import com.didiglobal.common.business.arrangement.model.EeveeArrangementComponentModel;
import com.didiglobal.common.business.arrangement.model.EeveeArrangementModel;
import com.didiglobal.common.business.arrangement.model.EeveeArrangementNodeModel;
import com.didiglobal.common.common.xengine.XEngineReq;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EeveeArrangementParser {
    public static EeveeArrangementModel arrangementParse(JsonObject jsonObject) {
        return (EeveeArrangementModel) new Gson().fromJson((JsonElement) jsonObject, EeveeArrangementModel.class);
    }

    public static Map<String, List<EeveeArrangementComponentModel>> convertMap(EeveeArrangementArrayItem eeveeArrangementArrayItem) {
        HashMap hashMap = new HashMap();
        if (eeveeArrangementArrayItem.nodeConfig != null) {
            for (EeveeArrangementNodeModel next : eeveeArrangementArrayItem.nodeConfig) {
                if (next != null && !TextUtils.isEmpty(next.scene)) {
                    if (next.element_list != null) {
                        hashMap.put(next.scene, next.element_list);
                    }
                    if (next.scene_cache != null) {
                        XECacheParamsImpl xECacheParamsImpl = new XECacheParamsImpl();
                        xECacheParamsImpl.scene = next.scene;
                        xECacheParamsImpl.component = null;
                        xECacheParamsImpl.jsonString = next.scene_cache.toString();
                        XEngineReq.setDefaultCache(xECacheParamsImpl);
                    }
                }
            }
        }
        return hashMap;
    }
}
