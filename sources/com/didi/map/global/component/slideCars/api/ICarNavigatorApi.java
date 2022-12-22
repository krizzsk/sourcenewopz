package com.didi.map.global.component.slideCars.api;

import android.content.Context;
import com.didi.sdk.util.TextUtil;
import java.util.Map;

public abstract class ICarNavigatorApi {
    public static final String PHONE_NUM_SUFFIX = "_5";
    public Context context;

    public abstract void getCarNavigator(CarNavigatorRequest carNavigatorRequest, ICarNavigatorCallback iCarNavigatorCallback);

    /* access modifiers changed from: protected */
    public abstract Map packageParamToMap(CarNavigatorRequest carNavigatorRequest);

    public ICarNavigatorApi(Context context2) {
        this.context = context2;
    }

    protected static void put(Map map, String str, Object obj) {
        String valueOf = String.valueOf(obj);
        if (TextUtil.isEmpty(valueOf)) {
            map.put(str, "");
        } else {
            map.put(str, valueOf.trim());
        }
    }
}
