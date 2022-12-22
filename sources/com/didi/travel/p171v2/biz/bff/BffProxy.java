package com.didi.travel.p171v2.biz.bff;

import android.content.Context;
import com.android.didi.bfflib.Bff;
import com.android.didi.bfflib.IBffProxy;
import com.android.didi.bfflib.business.BffRequestUtil;
import com.android.didi.bfflib.business.BffResponseListener;
import com.didi.travel.p171v2.TravelSDKV2;
import com.didi.travel.p171v2.biz.Biz;
import com.didi.travel.p171v2.biz.IBiz;
import com.didi.travel.p171v2.biz.api.Api;
import com.didi.travel.p171v2.biz.api.ApiProxy;
import com.didi.travel.p171v2.biz.api.RemoteCallback;
import java.lang.reflect.Method;
import java.util.Map;

/* renamed from: com.didi.travel.v2.biz.bff.BffProxy */
public class BffProxy<T extends IBiz> extends ApiProxy<T> {
    public BffProxy(Biz<T> biz) {
        super(biz);
    }

    public Object invoke(Api api, Object obj, Method method, Object[] objArr) {
        IIBff iIBff = api.getIIBff();
        int length = objArr.length - 1;
        if (iIBff.version() == BffVersion.V1) {
            RemoteCallback remoteCallback = objArr[length];
            BffV1InvokeCallback instanceBffV1InvokeCallback = api.instanceBffV1InvokeCallback(api, objArr, remoteCallback);
            instanceBffV1InvokeCallback.beforeInvoke(api, objArr);
            IBffProxy.Ability.Builder params = new IBffProxy.Ability.Builder(TravelSDKV2.getAppContext(), iIBff.ability()).setParams(objArr[0]);
            Class<?> dataType = api.getIIBff().dataType();
            if (instanceBffV1InvokeCallback != null) {
                remoteCallback = instanceBffV1InvokeCallback;
            }
            Bff.call(params.setCallback(new BffV1CallbackAdapter(api, dataType, remoteCallback, objArr)).build());
            instanceBffV1InvokeCallback.afterInvoke(api, objArr);
            return null;
        } else if (iIBff.version() != BffVersion.V2) {
            return null;
        } else {
            BffResponseListener bffResponseListener = objArr[length];
            BffV2InvokeCallback instanceBffV2ApiInvokeCallback = api.instanceBffV2ApiInvokeCallback(api, objArr, bffResponseListener);
            instanceBffV2ApiInvokeCallback.beforeInvoke(api, objArr);
            Context appContext = TravelSDKV2.getAppContext();
            String ability = iIBff.ability();
            Map map = objArr[0];
            if (instanceBffV2ApiInvokeCallback != null) {
                bffResponseListener = instanceBffV2ApiInvokeCallback;
            }
            BffRequestUtil.request(appContext, ability, map, bffResponseListener);
            instanceBffV2ApiInvokeCallback.afterInvoke(api, objArr);
            return null;
        }
    }
}
