package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzdgk implements Callable {
    private final List zzhfu;

    zzdgk(List list) {
        this.zzhfu = list;
    }

    public final Object call() {
        List<zzebt> list = this.zzhfu;
        JSONArray jSONArray = new JSONArray();
        for (zzebt zzebt : list) {
            if (((JSONObject) zzebt.get()) != null) {
                jSONArray.put(zzebt.get());
            }
        }
        if (jSONArray.length() == 0) {
            return null;
        }
        return new zzdgd(jSONArray.toString());
    }
}
