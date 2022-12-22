package com.didi.address.cache;

import android.content.Context;
import android.text.TextUtils;
import com.didi.address.util.SugOmegaTracker;
import com.didi.map.sdk.env.PaxEnvironment;
import com.sdk.poibase.ResultCallback;
import com.sdk.poibase.model.AddressParam;
import com.sdk.poibase.model.recsug.RpcRecSug;
import com.sdk.poibase.store.PoiStore;

public class CacheManager {

    /* renamed from: a */
    private Cache<RpcRecSug> f4303a;

    /* renamed from: b */
    private Context f4304b;

    /* renamed from: c */
    private String f4305c;

    public CacheManager(Context context) {
        if (context != null) {
            this.f4304b = context.getApplicationContext();
        }
        if (m2620a()) {
            this.f4305c = PaxEnvironment.getInstance().getAppVersion();
            this.f4303a = new RecCache(PoiStore.getInstance(this.f4304b), this.f4305c);
        }
    }

    public void storeRecSug(AddressParam addressParam, RpcRecSug rpcRecSug) {
        if (this.f4303a != null && m2621a(addressParam)) {
            this.f4303a.storeRecSugCache(PaxEnvironment.getInstance().getUid() + PaxEnvironment.getInstance().getCityId(), rpcRecSug);
        }
    }

    public boolean useRecSugCache(AddressParam addressParam, ResultCallback<RpcRecSug> resultCallback) {
        if (this.f4303a == null || !m2621a(addressParam)) {
            return false;
        }
        String str = PaxEnvironment.getInstance().getUid() + PaxEnvironment.getInstance().getCityId();
        if (resultCallback == null) {
            return false;
        }
        try {
            CacheData<RpcRecSug> recSugCache = this.f4303a.getRecSugCache(str);
            if (recSugCache != null) {
                if (recSugCache.data != null) {
                    if (!this.f4305c.equals(recSugCache.version)) {
                        this.f4303a.removeRecSugCache(str);
                        return false;
                    }
                    resultCallback.onSuccess((RpcRecSug) recSugCache.data);
                    SugOmegaTracker.trackRecCacheFallback(((RpcRecSug) recSugCache.data).rec_poi_list.size());
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            this.f4303a.removeRecSugCache(str);
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: a */
    private boolean m2621a(AddressParam addressParam) {
        if (addressParam == null || PaxEnvironment.getInstance().getCityId() == 0 || TextUtils.isEmpty(PaxEnvironment.getInstance().getToken()) || TextUtils.isEmpty(PaxEnvironment.getInstance().getUid()) || addressParam.addressType != 2) {
            return false;
        }
        return !TextUtils.isEmpty(PaxEnvironment.getInstance().getToken());
    }

    /* renamed from: a */
    private boolean m2620a() {
        return this.f4304b != null && !TextUtils.isEmpty(PaxEnvironment.getInstance().getAppVersion());
    }
}
