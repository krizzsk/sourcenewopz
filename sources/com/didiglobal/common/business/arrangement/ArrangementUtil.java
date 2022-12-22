package com.didiglobal.common.business.arrangement;

import android.text.TextUtils;
import com.didi.component_processor.annonation.ModuleMap;
import com.didiglobal.common.business.arrangement.model.EeveeArrangementBizConfig;
import com.didiglobal.common.business.arrangement.model.EeveeArrangementComponentModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ArrangementUtil {
    public static void putArrangementMap(Map<String, List<EeveeArrangementComponentModel>> map) {
        EeveeArrangement.putAll(map);
    }

    public static void setConfig(EeveeArrangementBizConfig eeveeArrangementBizConfig) {
        EeveeArrangement.setConfig(eeveeArrangementBizConfig);
    }

    public static List<EeveeArrangementComponentModel> getCachedInflatedComponents(String str) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        for (EeveeArrangementComponentModel next : EeveeArrangement.getModel(str)) {
            if (ModuleMap.getStandardComponent(next.f49739id) != null || ModuleMap.getContainer(next.f49739id) != null) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public static String getStartNodeName() {
        return EeveeArrangement.getBizConfig().startNode;
    }

    public static List<String> convertComponents(List<EeveeArrangementComponentModel> list) {
        ArrayList arrayList = new ArrayList();
        for (EeveeArrangementComponentModel eeveeArrangementComponentModel : list) {
            arrayList.add(eeveeArrangementComponentModel.f49739id);
        }
        return arrayList;
    }
}
