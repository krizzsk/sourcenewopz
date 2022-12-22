package com.didi.map.google.util;

import android.text.TextUtils;
import com.didi.common.map.model.LatLng;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class EtaEdaChangeTracker {

    /* renamed from: a */
    private static final String f27809a = "EtaEdaChangeTracker";

    /* renamed from: b */
    private String f27810b;

    /* renamed from: c */
    private List<EtaEdaChangeData> f27811c = new ArrayList();

    public EtaEdaChangeTracker(String str) {
        this.f27810b = str;
    }

    public void record(int i, int i2, boolean z, boolean z2, LatLng latLng, boolean z3) {
        LatLng latLng2 = latLng;
        if (!z3) {
            DLog.m19914d(f27809a, "record a record of EtaEdaChange", new Object[0]);
            List<EtaEdaChangeData> list = this.f27811c;
            long currentTimeMillis = System.currentTimeMillis();
            String str = z ? "simulation" : "ora";
            double d = 0.0d;
            double d2 = latLng2 == null ? 0.0d : latLng2.latitude;
            if (latLng2 != null) {
                d = latLng2.longitude;
            }
            list.add(new EtaEdaChangeData(i, i2, currentTimeMillis, str, z2 ? 1 : 0, d2, d));
            return;
        }
    }

    public void doOmega(String str, int i, boolean z, String str2, LatLng latLng) {
        String str3;
        double d;
        if (!z && this.f27811c.size() > 0) {
            try {
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject = null;
                for (EtaEdaChangeData next : this.f27811c) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("eta", next.eta);
                    jSONObject2.put("eda", next.eda);
                    jSONObject2.put("timestamp", next.timestamp);
                    jSONObject2.put("from", next.from);
                    jSONObject2.put("yawed", next.yawed);
                    jSONObject2.put("lat", next.lat);
                    jSONObject2.put("lng", next.lng);
                    jSONObject = jSONObject2;
                }
                jSONArray.put(jSONObject);
                str3 = jSONArray.toString();
            } catch (JSONException e) {
                DLog.m19914d(f27809a, "doOmega  exception:%s", e.toString());
                e.printStackTrace();
                str3 = "";
            }
            if (!TextUtils.isEmpty(str3)) {
                HashMap hashMap = new HashMap();
                hashMap.put("order_id", str);
                hashMap.put("country_id", str2);
                int i2 = 3;
                if (i != 3 && !z) {
                    i2 = 4;
                }
                hashMap.put("order_stage", Integer.valueOf(i2));
                hashMap.put("os", "android");
                double d2 = 0.0d;
                if (latLng == null) {
                    d = 0.0d;
                } else {
                    d = latLng.latitude;
                }
                hashMap.put("location_lat", Double.valueOf(d));
                if (latLng != null) {
                    d2 = latLng.longitude;
                }
                hashMap.put("location_lng", Double.valueOf(d2));
                hashMap.put("estimate_changes", str3);
                hashMap.put("entrance", this.f27810b);
                OmegaSDKAdapter.trackEvent("com_map_EtaOrEdaChanges_sw_global", (Map<String, Object>) hashMap);
                DLog.m19914d(f27809a, "doOmega EtaEdaChange success", new Object[0]);
            }
            this.f27811c.clear();
        }
    }

    public static class EtaEdaChangeData {
        int eda;
        int eta;
        String from;
        double lat;
        double lng;
        long timestamp;
        int yawed;

        public EtaEdaChangeData(int i, int i2, long j, String str, int i3, double d, double d2) {
            this.eta = i;
            this.eda = i2;
            this.timestamp = j;
            this.from = str;
            this.yawed = i3;
            this.lat = d;
            this.lng = d2;
        }
    }
}
