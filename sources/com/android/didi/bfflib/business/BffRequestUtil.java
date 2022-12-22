package com.android.didi.bfflib.business;

import android.content.Context;
import com.android.didi.bfflib.Bff;
import com.android.didi.bfflib.IBffProxy;
import java.util.Map;

public class BffRequestUtil {
    public static <T extends BffBaseObject> void request(Context context, String str, Map<String, Object> map, BffResponseListener<T> bffResponseListener) {
        Bff.call(new IBffProxy.Ability.Builder(context, str).setParams(map).setBffCallBack(new BffCallbackAdapter(bffResponseListener)).build());
    }

    public static <T extends BffBaseObject> void requestV2(Context context, String str, Map<String, Object> map, BffResponseListenerV2<T> bffResponseListenerV2) {
        Bff.call(new IBffProxy.Ability.Builder(context, str).setParams(map).setBffCallBack(new BffCallbackAdapterV2(bffResponseListenerV2)).build());
    }
}
