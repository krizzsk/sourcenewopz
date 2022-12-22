package com.didi.component.business.secondconf;

import com.android.didi.bfflib.Bff;
import com.android.didi.bfflib.IBffProxy;
import com.didi.component.business.constant.BffConstants;
import com.didi.component.business.secondconf.model.RideConfModel;
import com.didi.component.business.secondconf.model.RideConfRsp;
import com.didi.sdk.app.DIDIApplication;
import com.didi.sdk.misconfig.p153v2.utils.ConfUtil;
import com.didichuxing.foundation.rpc.RpcService;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.util.HashMap;

public class RideConfRequest {

    /* renamed from: a */
    private RideConfRepository f11344a;

    public RideConfRequest(RideConfRepository rideConfRepository) {
        this.f11344a = rideConfRepository;
    }

    public void request(double d, double d2, final int i, final int i2) {
        m7657a(d, d2, (RpcService.Callback<JsonObject>) new RpcService.Callback<JsonObject>() {
            public void onSuccess(JsonObject jsonObject) {
                RideConfRequest.this.m7661a(jsonObject, i, i2);
            }

            public void onFailure(IOException iOException) {
                RideConfRequest.this.m7658a(i2);
            }
        });
    }

    /* renamed from: a */
    private void m7657a(double d, double d2, RpcService.Callback<JsonObject> callback) {
        HashMap hashMap = new HashMap();
        hashMap.put("lat", Double.valueOf(d2));
        hashMap.put("lng", Double.valueOf(d));
        Bff.call(new IBffProxy.Ability.Builder(DIDIApplication.getAppContext(), BffConstants.AbilityID.ABILITY_SECOND_CONF).setParams(hashMap).setCallback(callback).build());
    }

    public void requestWithOutSave(double d, double d2, final RpcService.Callback<RideConfRsp> callback) {
        HashMap hashMap = new HashMap();
        hashMap.put("lat", Double.valueOf(d2));
        hashMap.put("lng", Double.valueOf(d));
        Bff.call(new IBffProxy.Ability.Builder(DIDIApplication.getAppContext(), BffConstants.AbilityID.ABILITY_SECOND_CONF).setParams(hashMap).setCallback(new RpcService.Callback<JsonObject>() {
            public void onSuccess(JsonObject jsonObject) {
                callback.onSuccess((RideConfRsp) new Gson().fromJson((JsonElement) jsonObject, RideConfRsp.class));
            }

            public void onFailure(IOException iOException) {
                callback.onFailure(iOException);
            }
        }).build());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m7661a(JsonObject jsonObject, int i, int i2) {
        RideConfRsp rideConfRsp = (RideConfRsp) new Gson().fromJson((JsonElement) jsonObject, RideConfRsp.class);
        if (rideConfRsp == null || rideConfRsp.getErrno() != 0 || rideConfRsp.getData() == null) {
            m7658a(i2);
            return;
        }
        RideConfModel data = rideConfRsp.getData();
        RideConfRepository rideConfRepository = this.f11344a;
        if (rideConfRepository != null && !rideConfRepository.getCurVersion().equals(data.getCurVersion())) {
            this.f11344a.saveConfig(data, jsonObject.toString());
        }
        ConfUtil.dispatchCarInfoUpdate(1, i2);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m7658a(int i) {
        if (this.f11344a.getConfigFromCache() != null) {
            ConfUtil.dispatchCarInfoUpdate(2, i);
        } else {
            ConfUtil.dispatchCarInfoUpdate(-1, i);
        }
    }
}
