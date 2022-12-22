package com.didi.map.sdk.passengerlocation.http;

import android.os.AsyncTask;
import com.didi.common.map.util.NetUtils;
import com.didi.map.sdk.proto.driver_gl.UserLocationRes;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;
import com.facebook.AuthenticationTokenClaims;
import com.squareup.wire.Wire;

public class UserLocationTask extends AsyncTask<byte[], Integer, UserLocationRes> {
    public static final String PASSENGER_LOCATION = "https://apimap.didiglobal.com/navi/v1/userlocation/";

    /* renamed from: a */
    private IUserLocationCallback f28600a;

    /* renamed from: b */
    private String f28601b = "";

    public UserLocationTask(IUserLocationCallback iUserLocationCallback) {
        this.f28600a = iUserLocationCallback;
    }

    /* access modifiers changed from: protected */
    public void onPreExecute() {
        this.f28600a.onStarted();
    }

    /* access modifiers changed from: protected */
    public UserLocationRes doInBackground(byte[]... bArr) {
        this.f28601b = "";
        try {
            byte[] doPost = NetUtils.doPost(m20208a(), bArr[0]);
            if (doPost != null) {
                return (UserLocationRes) new Wire((Class<?>[]) new Class[0]).parseFrom(doPost, UserLocationRes.class);
            }
            this.f28601b = "response is null";
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            this.f28601b = e.toString();
            return null;
        }
    }

    /* renamed from: a */
    private String m20208a() {
        IToggle toggle = Apollo.getToggle("global_passenger_route_url_toggle");
        if (toggle == null || !toggle.allow()) {
            return "https://apimap.didiglobal.com/navi/v1/userlocation/";
        }
        return (String) toggle.getExperiment().getParam(AuthenticationTokenClaims.JSON_KEY_USER_LOCATION, "https://apimap.didiglobal.com/navi/v1/userlocation/");
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(UserLocationRes userLocationRes) {
        this.f28600a.onFinished(userLocationRes, this.f28601b);
    }
}
