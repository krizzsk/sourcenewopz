package com.didi.sdk.login;

import android.content.Context;
import com.didi.sdk.util.SystemUtil;
import com.didi.unifylogin.api.OneLoginFacade;
import com.didi.unifylogin.base.net.pojo.response.CountryListResponse;
import com.didi.unifylogin.country.CountryManager;
import com.didi.unifylogin.store.LoginStore;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationManager;
import com.didichuxing.omega.sdk.Omega;
import org.json.JSONException;
import org.json.JSONObject;

public final class PassportUpdateSDk {
    private PassportUpdateSDk() {
    }

    public static void requestPassportUpdate(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("abkey", "IBTLoginHomePage");
            jSONObject.put("app_version", SystemUtil.getVersionName(context));
            jSONObject.put("omega_id", Omega.getOmegaId());
            jSONObject.put("appid", LoginStore.getInstance().getAppId());
            DIDILocation lastKnownLocation = DIDILocationManager.getInstance(context).getLastKnownLocation();
            if (lastKnownLocation != null) {
                jSONObject.put("lng", lastKnownLocation.getLongitude());
                jSONObject.put("lat", lastKnownLocation.getLatitude());
            }
            CountryListResponse.CountryRule defCountry = CountryManager.getIns().getDefCountry();
            if (defCountry != null) {
                jSONObject.put("area", defCountry.area);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        OneLoginFacade.getFunction().requestPageAbTest(context, jSONObject);
    }
}
