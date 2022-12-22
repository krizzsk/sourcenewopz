package com.didi.address.cache;

import android.text.TextUtils;
import android.util.Log;
import com.didi.common.map.util.DLog;
import com.didi.common.map.util.LatLngUtils;
import com.didi.sdk.util.TextUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sdk.poibase.model.RpcPoi;
import com.sdk.poibase.model.RpcPoiBaseInfo;
import com.sdk.poibase.model.recsug.RpcRecSug;
import com.sdk.poibase.store.PoiStore;
import java.util.Iterator;
import rui.config.RConfigConstants;

public class RecCache implements Cache<RpcRecSug> {

    /* renamed from: a */
    private static final String f4306a = "_rec_cache";

    /* renamed from: b */
    private PoiStore f4307b;

    /* renamed from: c */
    private String f4308c;

    public RecCache(PoiStore poiStore, String str) {
        this.f4307b = poiStore;
        this.f4308c = str;
    }

    public void storeRecSugCache(String str, RpcRecSug rpcRecSug) {
        try {
            if (m2623a(rpcRecSug)) {
                Iterator<RpcPoi> it = rpcRecSug.rec_poi_list.iterator();
                while (it.hasNext()) {
                    RpcPoi next = it.next();
                    if (!(next == null || next.base_info == null)) {
                        StringBuilder sb = new StringBuilder();
                        RpcPoiBaseInfo rpcPoiBaseInfo = next.base_info;
                        sb.append(rpcPoiBaseInfo.srctag);
                        sb.append(f4306a);
                        rpcPoiBaseInfo.srctag = sb.toString();
                    }
                }
                try {
                    String json = new Gson().toJson((Object) new CacheData(this.f4308c, rpcRecSug));
                    DLog.m7384d("rec-cache", "setRecommendPoiCache...：key: " + str + RConfigConstants.KEYWORD_COLOR_SIGN + json, new Object[0]);
                    this.f4307b.putAndSave(str, json);
                } catch (Exception e) {
                    DLog.m7384d("SugErr", "存缓存，Rec缓存转换成json出问题了" + e.getStackTrace(), new Object[0]);
                    removeRecSugCache(str);
                }
                Iterator<RpcPoi> it2 = rpcRecSug.rec_poi_list.iterator();
                while (it2.hasNext()) {
                    RpcPoi next2 = it2.next();
                    if (!(next2 == null || next2.base_info == null || next2.base_info.srctag == null)) {
                        next2.base_info.srctag = next2.base_info.srctag.replaceAll(f4306a, "");
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void removeRecSugCache(String str) {
        DLog.m7384d("rec-cache", "removeRecSugCache...：key: " + str, new Object[0]);
        try {
            this.f4307b.remove(str);
        } catch (Exception e) {
            DLog.m7384d("SugErr", "删除缓存出问题了：" + e.getStackTrace(), new Object[0]);
        }
    }

    public CacheData<RpcRecSug> getRecSugCache(String str) {
        CacheData<RpcRecSug> cacheData;
        Exception e;
        DLog.m7384d("rec-cache", "getRecSugCache...：stack: " + Log.getStackTraceString(new Throwable()), new Object[0]);
        try {
            String string = this.f4307b.getString(str, "");
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            try {
                DLog.m7384d("rec-cache", "getRecommendPoisCache...：缓存: " + string, new Object[0]);
                cacheData = (CacheData) new Gson().fromJson(string, new TypeToken<CacheData<RpcRecSug>>() {
                }.getType());
            } catch (Exception e2) {
                DLog.m7384d("SugErr", "取缓存出问题了：" + e2.getStackTrace(), new Object[0]);
                removeRecSugCache(str);
                cacheData = null;
            }
            if (cacheData != null) {
                try {
                    if (!m2623a((RpcRecSug) cacheData.data)) {
                        return null;
                    }
                } catch (Exception e3) {
                    e = e3;
                    e.printStackTrace();
                    removeRecSugCache(str);
                    return cacheData;
                }
            }
            return cacheData;
        } catch (Exception e4) {
            cacheData = null;
            e = e4;
            e.printStackTrace();
            removeRecSugCache(str);
            return cacheData;
        }
    }

    /* renamed from: a */
    private boolean m2622a(RpcPoi rpcPoi) {
        if (rpcPoi == null || rpcPoi.base_info == null || !LatLngUtils.locateCorrect(rpcPoi.base_info.lat, rpcPoi.base_info.lng) || TextUtil.isEmpty(rpcPoi.base_info.displayname) || TextUtil.isEmpty(rpcPoi.base_info.address) || TextUtil.isEmpty(rpcPoi.base_info.poi_id)) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    private boolean m2623a(RpcRecSug rpcRecSug) {
        if (rpcRecSug == null || rpcRecSug.errno != 0 || rpcRecSug.rec_poi_list == null || rpcRecSug.rec_poi_list.isEmpty()) {
            return false;
        }
        Iterator<RpcPoi> it = rpcRecSug.rec_poi_list.iterator();
        while (it.hasNext()) {
            if (!m2622a(it.next())) {
                return false;
            }
        }
        return true;
    }
}
