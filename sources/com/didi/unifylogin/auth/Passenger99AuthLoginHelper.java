package com.didi.unifylogin.auth;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.didi.thirdpartylogin.base.AbsThirdPartyLoginBase;
import com.didi.thirdpartylogin.base.ThirdPartyLoginListener;
import com.didi.unifylogin.auth.InnerAuthManager;
import com.taxis99.R;

public class Passenger99AuthLoginHelper extends AbsThirdPartyLoginBase {

    /* renamed from: a */
    InnerAuthManager.AuthParam f44671a;

    public String getChannel() {
        return "99_passenger";
    }

    public String getText() {
        return "99";
    }

    public Passenger99AuthLoginHelper(InnerAuthManager.AuthParam authParam) {
        super((String) null);
        this.f44671a = authParam;
        this.iconRes = R.drawable.login_unifiy_icon_third_party_99;
    }

    public void startLogin(Activity activity, ThirdPartyLoginListener thirdPartyLoginListener) {
        if (this.f44671a == null) {
            thirdPartyLoginListener.onFailure(new IllegalStateException("authParam is null"));
            return;
        }
        this.listener = thirdPartyLoginListener;
        Intent intent = new Intent("android.intent.action.VIEW", m31719a());
        if (activity.getPackageManager().queryIntentActivities(intent, 0).size() == 0) {
            thirdPartyLoginListener.onFailure(new IllegalStateException("can't find third party app"));
        } else {
            activity.startActivity(intent);
        }
    }

    /* renamed from: a */
    private Uri m31719a() {
        return new Uri.Builder().scheme("taxis99OneTravel").authority("one").appendPath("login").appendPath(InnerAuthManager.LOGIN_AUTH_PATH).appendQueryParameter(InnerAuthManager.PACKAGE_NAME_QUERY, this.f44671a.packageName).appendQueryParameter("source", this.f44671a.feedback).build();
    }

    public void handleLoginResult(int i, int i2, Intent intent) {
        if (this.listener != null) {
            this.listener.onSucess(intent.getStringExtra("token"), this.clientId);
        }
    }
}
