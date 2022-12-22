package com.didi.onefacelogin;

import android.app.Activity;
import android.content.Intent;
import com.didi.thirdpartylogin.base.AbsThirdPartyLoginBase;
import com.didi.thirdpartylogin.base.ThirdPartyLoginListener;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.taxis99.R;
import java.util.Arrays;
import java.util.Collection;

public class FaceBookLoginHelper extends AbsThirdPartyLoginBase {

    /* renamed from: a */
    private static final String f29490a = "FaceBookLogin - ";

    /* renamed from: b */
    private CallbackManager f29491b;

    public String getChannel() {
        return "facebook";
    }

    public String getText() {
        return "Facebook";
    }

    public FaceBookLoginHelper(String str) {
        super(str);
        this.iconRes = R.drawable.one_facebook_login_image_icon;
    }

    public void startLogin(Activity activity, ThirdPartyLoginListener thirdPartyLoginListener) {
        this.listener = thirdPartyLoginListener;
        this.f29491b = CallbackManager.Factory.create();
        LoginManager.getInstance().registerCallback(this.f29491b, new FacebookCallback<LoginResult>() {
            public void onSuccess(LoginResult loginResult) {
                AccessToken accessToken = loginResult.getAccessToken();
                FaceBookLoginHelper.this.log("FaceBookLogin - onSuccess: ");
                if (accessToken != null) {
                    FaceBookLoginHelper.this.onSucess(accessToken.getToken(), (String) null);
                    return;
                }
                FaceBookLoginHelper.this.log("FaceBookLogin - token is null");
                FaceBookLoginHelper.this.onFailure(new Exception("token is null"));
            }

            public void onCancel() {
                FaceBookLoginHelper.this.log("FaceBookLogin - onCancel: ");
                FaceBookLoginHelper.this.onFailure(new Exception("cancel"));
            }

            public void onError(FacebookException facebookException) {
                FaceBookLoginHelper.this.log("FaceBookLogin - onError(): ");
                FaceBookLoginHelper.this.onFailure(facebookException);
                facebookException.printStackTrace();
            }
        });
        LoginManager.getInstance().logOut();
        LoginManager.getInstance().logInWithReadPermissions(activity, (Collection<String>) Arrays.asList(new String[]{"email", "public_profile"}));
    }

    public void handleLoginResult(int i, int i2, Intent intent) {
        log("FaceBookLogin - handleLoginResult(): ");
        CallbackManager callbackManager = this.f29491b;
        if (callbackManager != null) {
            try {
                callbackManager.onActivityResult(i, i2, intent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
