package com.didi.dimina.container.secondparty.prefetch;

import android.text.TextUtils;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.Dimina;
import com.didi.dimina.container.bridge.BackgroundFetchDataSubJSBridge;
import com.didi.dimina.container.bridge.storage.MMKVUtil;
import com.didi.dimina.container.mina.IDMCommonAction;
import com.didi.dimina.container.secondparty.bundle.PmNodeConfigManager;
import com.didi.dimina.container.secondparty.http.DidiNetworkServiceManager;
import com.didi.dimina.container.secondparty.jsmodule.jsbridge.location.LocationHelper;
import com.didi.dimina.container.secondparty.prefetch.encryption.EncryptJsonUtil;
import com.didi.dimina.container.secondparty.prefetch.encryption.EncryptionUtil;
import com.didi.dimina.container.secondparty.prefetch.encryption.HttpEncryptBean;
import com.didi.dimina.container.secondparty.util.Trace4DiUtil;
import com.didi.dimina.container.service.FirstFetchService;
import com.didi.dimina.container.service.NetworkService;
import com.didi.dimina.container.util.JSONUtil;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.container.util.TextUtil;
import com.didi.dimina.container.util.TimeUtil;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import java.util.HashMap;
import org.json.JSONObject;

public class FirstTogetherManager implements FirstFetchService {

    /* renamed from: a */
    private static final String f17430a = "FirstTogetherHelper";

    /* renamed from: b */
    private static final DidiNetworkServiceManager f17431b = new DidiNetworkServiceManager();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public JSONObject f17432c = null;

    public void requestFirstTogether(DMMina dMMina) {
        LogUtil.iRelease("PreDataFetch", "normal start: " + dMMina.getMinaIndex());
        String appId = (dMMina.getConfig() == null || dMMina.getConfig().getLaunchConfig() == null) ? "" : dMMina.getConfig().getLaunchConfig().getAppId();
        if (TextUtils.isEmpty(appId)) {
            LogUtil.iRelease(f17430a, "appId is empty");
        } else {
            PmNodeConfigManager.readConfigRespJsonFile(appId, new IDMCommonAction(dMMina, appId) {
                public final /* synthetic */ DMMina f$1;
                public final /* synthetic */ String f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void callback(Object obj) {
                    FirstTogetherManager.this.m12966a(this.f$1, this.f$2, (String) obj);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m12966a(DMMina dMMina, String str, String str2) {
        final String jsonString = JSONUtil.getJsonString(JSONUtil.toJSONObject(str2), "aggregation_url");
        final String str3 = (String) MMKVUtil.getInstance().get(BackgroundFetchDataSubJSBridge.STORAGE_KEY, "");
        if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(jsonString)) {
            LogUtil.iRelease(f17430a, "token=" + str3 + ", togetherUrl=" + jsonString);
            Trace4DiUtil.trackBackgroundFetchDataError(dMMina.getMinaIndex(), jsonString, 1, str3);
            return;
        }
        NetworkService.NetworkTaskModel.Request request = new NetworkService.NetworkTaskModel.Request();
        HashMap hashMap = new HashMap();
        hashMap.put("token", str3);
        hashMap.put("appId", str);
        hashMap.put("platform", "android");
        String a = m12963a();
        if (!TextUtil.isEmpty(a)) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("enc-info", a);
            request.headers = hashMap2;
        }
        request.url = jsonString;
        request.data = hashMap;
        final long currentNanoMillis = TimeUtil.currentNanoMillis();
        final DMMina dMMina2 = dMMina;
        f17431b.request(request, new NetworkService.ITaskCallback() {
            public void onFailure(Exception exc) {
                Trace4DiUtil.trackBackgroundFetchDataDuration(dMMina2.getMinaIndex(), String.valueOf(TimeUtil.currentNanoMillis() - currentNanoMillis), str3, "");
                Trace4DiUtil.trackBackgroundFetchDataError(dMMina2.getMinaIndex(), jsonString, 2, str3);
                LogUtil.iRelease("PreDataFetch", "normal failed: " + dMMina2.getMinaIndex());
            }

            public void onSuccess(JSONObject jSONObject) {
                long currentNanoMillis = TimeUtil.currentNanoMillis() - currentNanoMillis;
                JSONObject unused = FirstTogetherManager.this.f17432c = JSONUtil.toJSONObject(JSONUtil.getJsonString(jSONObject, "data"));
                Trace4DiUtil.trackBackgroundFetchDataDuration(dMMina2.getMinaIndex(), String.valueOf(currentNanoMillis), str3, FirstTogetherManager.this.f17432c != null ? JSONUtil.getJsonString(FirstTogetherManager.this.f17432c, "traceId") : null);
                LogUtil.iRelease("PreDataFetch", "normal success: " + dMMina2.getMinaIndex());
            }
        });
    }

    public JSONObject getFirstTokenTogether(DMMina dMMina) {
        StringBuilder sb = new StringBuilder();
        sb.append("normal getData, isEmpty: ");
        sb.append(this.f17432c == null);
        sb.append(" ");
        sb.append(dMMina.getMinaIndex());
        LogUtil.iRelease("PreDataFetch", sb.toString());
        return this.f17432c;
    }

    /* renamed from: a */
    private static String m12963a() {
        DIDILocation lastLocation = new LocationHelper(Dimina.getConfig().getApp()).getLastLocation("gcj02");
        if (lastLocation == null) {
            return null;
        }
        HttpEncryptBean.HeaderBean headerBean = new HttpEncryptBean.HeaderBean();
        String str = "";
        headerBean.setLat(lastLocation.getLatitude() == 0.0d ? str : String.valueOf(lastLocation.getLatitude()));
        if (lastLocation.getLongitude() != 0.0d) {
            str = String.valueOf(lastLocation.getLongitude());
        }
        headerBean.setLng(str);
        HttpEncryptBean httpEncryptBean = new HttpEncryptBean();
        httpEncryptBean.setHeader(headerBean);
        return EncryptionUtil.encryption(EncryptJsonUtil.toJson(httpEncryptBean));
    }
}
