package com.android.didi.bfflib.business;

import android.text.TextUtils;
import com.android.didi.bfflib.task.IBffParamsService;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didi.security.wireless.adapter.SecurityWrapper;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import java.util.Map;

@ServiceProvider({IBffParamsService.class})
public class BffParamsSecurityService implements IBffParamsService {
    public void bffParams(String str, Map<String, Object> map, Map<String, Object> map2, Map<String, Object> map3) {
        if (!TextUtils.isEmpty(str) && !CollectionUtil.isEmpty((Map<?, ?>) map2)) {
            for (String str2 : map2.keySet()) {
                String doCollect = SecurityWrapper.doCollect(str + str2);
                if (!TextUtils.isEmpty(doCollect)) {
                    map.put("wsgenv", doCollect);
                    return;
                }
            }
        }
    }
}
