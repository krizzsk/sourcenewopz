package com.didi.sdk.componentconfig;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.android.didi.bfflib.Bff;
import com.android.didi.bfflib.IBffProxy;
import com.didi.common.map.model.LatLng;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.bff.BffConstants;
import com.didi.sdk.bff.BffUtils;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.map.LocationPerformer;
import com.didi.sdk.store.BaseStore;
import com.didi.sdk.util.SingletonHolder;
import com.didi.sdk.util.TextUtil;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.RpcServiceFactory;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ComponentStore extends BaseStore {
    public static final String EVENT = "Component_Config_Event";

    /* renamed from: b */
    private static final String f35680b = "component_store_sp";

    /* renamed from: c */
    private static final String f35681c = "framework-ComponentStore";

    /* renamed from: d */
    private static final String f35682d = "component_version";

    /* renamed from: e */
    private static final String f35683e = "component_cityId";

    /* renamed from: f */
    private static final String f35684f = "component_data";

    /* renamed from: g */
    private static final String f35685g = "timer,201";

    /* renamed from: a */
    private Logger f35686a = LoggerFactory.getLogger("ComponentStore");

    /* renamed from: h */
    private Object f35687h = new Object();

    /* renamed from: i */
    private Context f35688i;

    /* renamed from: j */
    private String f35689j;

    /* renamed from: k */
    private String f35690k;

    /* renamed from: l */
    private SharedPreferences f35691l;

    /* renamed from: m */
    private ComponentConfigInfo f35692m;

    /* renamed from: a */
    private String m25268a(int i) {
        if (i == 0) {
            return "wgs84";
        }
        if (i == 1) {
        }
        return "soso";
    }

    private ComponentStore() {
        super(f35681c);
    }

    public static ComponentStore getInstance() {
        return (ComponentStore) SingletonHolder.getInstance(ComponentStore.class);
    }

    public void init(Context context) {
        this.f35688i = context;
        this.f35691l = SystemUtils.getSharedPreferences(context, f35680b, 0);
        this.f35690k = m25277c(f35683e);
        this.f35689j = m25277c(f35682d);
    }

    public ComponentConfigInfo getConfigInfoFromLocal() {
        ComponentConfigInfo parse;
        synchronized (this.f35687h) {
            parse = ComponentConfigInfo.parse((String) get(f35684f));
            this.f35692m = parse;
        }
        return parse;
    }

    public ComponentConfigInfo getComponentInfo() {
        ComponentConfigInfo componentConfigInfo;
        synchronized (this.f35687h) {
            componentConfigInfo = this.f35692m;
        }
        return componentConfigInfo;
    }

    /* renamed from: a */
    private static int m25267a(String str) {
        try {
            if (TextUtil.isEmpty(str)) {
                return 0;
            }
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    public void getComponentConfig(String str, LatLng latLng) {
        if (this.f35692m == null || !str.equals(this.f35690k)) {
            DIDILocation lastLocation = LocationPerformer.getInstance().getLastLocation();
            String a = lastLocation != null ? m25268a(lastLocation.getCoordinateType()) : "soso";
            ComponentService componentService = (ComponentService) new RpcServiceFactory(this.f35688i).newRpcService(ComponentService.class, ComponentParams.URL);
            HashMap<String, Object> createParams = ComponentParams.createParams(this.f35688i, a, f35685g, "" + latLng.latitude, "" + latLng.longitude);
            if (BffUtils.isBffStageNewFifth()) {
                HashMap hashMap = new HashMap();
                hashMap.put(ComponentParams.PARAMS_FLAT, Double.valueOf(latLng.latitude));
                hashMap.put(ComponentParams.PARAMS_FLNG, Double.valueOf(latLng.longitude));
                hashMap.put(ComponentParams.PARAMS_CID, f35685g);
                Bff.call(new IBffProxy.Ability.Builder(this.f35688i, BffConstants.AbilityID.ABILITY_API_COMPONENT).setParams(hashMap).setCallback(new RpcService.Callback<JsonObject>() {
                    public void onSuccess(JsonObject jsonObject) {
                        ComponentStore.this.m25276b(jsonObject.get("data").getAsJsonObject().toString());
                    }

                    public void onFailure(IOException iOException) {
                        ComponentStore.this.m25269a();
                    }
                }).build());
                return;
            }
            componentService.getComponentConfig(createParams, new RpcService.Callback<String>() {
                public void onSuccess(String str) {
                    ComponentStore.this.m25276b(str);
                }

                public void onFailure(IOException iOException) {
                    ComponentStore.this.m25269a();
                }
            });
            return;
        }
        this.f35686a.infoEvent("ComponentStore", "ComponentStore", "getComponentConfig cid" + this.f35690k);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m25276b(String str) {
        synchronized (this.f35687h) {
            ComponentConfigInfo parse = ComponentConfigInfo.parse(str);
            this.f35692m = parse;
            m25270a(parse);
        }
        m25278c();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m25269a() {
        Logger logger = this.f35686a;
        logger.infoEvent("ComponentStore", "ComponentStore", "getComponentConfig onFailure cityid=" + this.f35690k);
        m25275b();
    }

    /* renamed from: a */
    private void m25270a(ComponentConfigInfo componentConfigInfo) {
        if (componentConfigInfo != null) {
            this.f35689j = componentConfigInfo.version;
            this.f35690k = componentConfigInfo.cityId;
            m25273a(f35683e, componentConfigInfo.cityId);
            m25273a(f35682d, componentConfigInfo.version);
            putAndSave(this.f35688i, f35684f, componentConfigInfo.data);
        }
    }

    /* renamed from: b */
    private void m25275b() {
        synchronized (this.f35687h) {
            m25273a(f35683e, "");
            m25273a(f35682d, "");
            remove(f35684f);
        }
    }

    /* renamed from: c */
    private void m25278c() {
        synchronized (this.f35687h) {
            if (this.f35692m == null) {
                Logger logger = this.f35686a;
                logger.infoEvent("ComponentStore", "ComponentStore", "dispatchConfigEvent no " + this.f35690k);
                return;
            }
            Logger logger2 = this.f35686a;
            logger2.infoEvent("ComponentStore", "ComponentStore", "dispatchConfigEvent  " + this.f35690k);
            dispatchEvent(new ComponentConfigEvent(EVENT));
        }
    }

    /* renamed from: a */
    private void m25273a(String str, String str2) {
        this.f35691l.edit().putString(str, str2).apply();
    }

    /* renamed from: c */
    private String m25277c(String str) {
        return this.f35691l.getString(str, "");
    }

    /* renamed from: d */
    private Map<String, List<ConfigItem>> m25279d(String str) {
        ComponentConfigInfo componentConfigInfo = this.f35692m;
        if (componentConfigInfo != null && componentConfigInfo.data == null) {
        }
        return null;
    }

    public List<ConfigItem> getConfigs(String str, String str2) {
        Map<String, List<ConfigItem>> d = m25279d(str);
        if (d != null && d.containsKey(str2)) {
            return d.get(str2);
        }
        return null;
    }

    public ConfigItem getConfig(ComponentParam componentParam) {
        List<ConfigItem> configs;
        if (componentParam == null || TextUtils.isEmpty(componentParam.componentId) || TextUtils.isEmpty(componentParam.productId) || (configs = getConfigs(componentParam.componentId, componentParam.productId)) == null) {
            return null;
        }
        for (ConfigItem next : configs) {
            if (next != null && m25274a(next, componentParam)) {
                return next;
            }
        }
        return null;
    }

    /* renamed from: a */
    private boolean m25274a(ConfigItem configItem, ComponentParam componentParam) {
        if (componentParam.carLevel != -1 && configItem.carLevel != componentParam.carLevel) {
            return false;
        }
        if (componentParam.orderType != -1 && configItem.orderType != componentParam.orderType) {
            return false;
        }
        if (TextUtils.isEmpty(componentParam.sceneType) || TextUtils.equals(configItem.scene, componentParam.sceneType)) {
            return true;
        }
        return false;
    }
}
