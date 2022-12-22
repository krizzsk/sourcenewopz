package com.didi.sdk.misconfig.p153v2.impl;

import com.android.didi.bfflib.Bff;
import com.android.didi.bfflib.IBffProxy;
import com.didi.sdk.app.DIDIApplication;
import com.didi.sdk.bff.BffConstants;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.misconfig.p153v2.model.PriConfModel;
import com.didi.sdk.misconfig.p153v2.model.PriConfRsp;
import com.didi.sdk.misconfig.p153v2.store.PriConfRepository;
import com.didi.sdk.misconfig.p153v2.utils.ConfUtil;
import com.didichuxing.foundation.rpc.RpcService;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.didi.sdk.misconfig.v2.impl.PriConfRequest */
public class PriConfRequest {

    /* renamed from: a */
    private Logger f36823a = LoggerFactory.getLogger("PriConfRequest");

    /* renamed from: b */
    private PriConfRepository f36824b;

    /* renamed from: c */
    private CityChangedNotifier f36825c;

    public PriConfRequest(PriConfRepository priConfRepository, CityChangedNotifier cityChangedNotifier) {
        this.f36824b = priConfRepository;
        this.f36825c = cityChangedNotifier;
    }

    public void requestWithOutSave(double d, double d2, final RpcService.Callback<PriConfModel> callback) {
        m26081a(d, d2, (RpcService.Callback<JsonObject>) new RpcService.Callback<JsonObject>() {
            public void onSuccess(JsonObject jsonObject) {
                PriConfRsp priConfRsp = (PriConfRsp) new Gson().fromJson((JsonElement) jsonObject, PriConfRsp.class);
                if (priConfRsp == null || priConfRsp.getErrno() != 0 || priConfRsp.getData() == null) {
                    callback.onFailure(new IOException());
                }
            }

            public void onFailure(IOException iOException) {
                callback.onFailure(iOException);
            }
        });
    }

    public void request(double d, double d2, final int i, final int i2) {
        m26081a(d, d2, (RpcService.Callback<JsonObject>) new RpcService.Callback<JsonObject>() {
            public void onSuccess(JsonObject jsonObject) {
                HashMap hashMap = new HashMap();
                hashMap.put("type", "bottomlead_success");
                OmegaSDKAdapter.trackEvent("tech_bottomlead_get", (Map<String, Object>) hashMap);
                PriConfRequest.this.m26085a(jsonObject, i, i2);
            }

            public void onFailure(IOException iOException) {
                PriConfRequest.this.m26082a(i, i2);
            }
        });
    }

    /* renamed from: a */
    private void m26081a(double d, double d2, RpcService.Callback<JsonObject> callback) {
        HashMap hashMap = new HashMap();
        hashMap.put("lat", Double.valueOf(d2));
        hashMap.put("lng", Double.valueOf(d));
        Bff.call(new IBffProxy.Ability.Builder(DIDIApplication.getAppContext(), BffConstants.AbilityID.ABILITY_PRIMARY_CONF).setParams(hashMap).setCallback(callback).build());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m26085a(JsonObject jsonObject, int i, int i2) {
        PriConfRsp priConfRsp = (PriConfRsp) new Gson().fromJson((JsonElement) jsonObject, PriConfRsp.class);
        if (priConfRsp == null || priConfRsp.getErrno() != 0 || priConfRsp.getData() == null) {
            m26082a(i, i2);
            return;
        }
        PriConfModel data = priConfRsp.getData();
        boolean z = false;
        if (!this.f36824b.getCurVersion().equals(data.getCurVersion())) {
            this.f36824b.saveConfig(data, jsonObject.toString());
            if (this.f36824b.getCityId() != data.getCityId()) {
                this.f36825c.dispatchCityChangeEvent(this.f36824b.getCityId(), data.getCityId());
                this.f36824b.saveCityId(data.getCityId());
            }
            z = true;
        }
        ConfUtil.dispatchMisFromUpdate(1, i2, z);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m26082a(int i, int i2) {
        if (this.f36824b.getConfigFromCache(i) != null) {
            ConfUtil.dispatchMisFromUpdate(2, i2, true);
        } else {
            ConfUtil.dispatchCarInfoUpdate(-1, i2, false);
        }
    }
}
