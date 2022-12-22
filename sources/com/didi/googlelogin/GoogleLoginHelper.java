package com.didi.googlelogin;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.didi.thirdpartylogin.base.AbsThirdPartyLoginBase;
import com.didi.thirdpartylogin.base.ThirdPartyLoginListener;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.taxis99.R;

public class GoogleLoginHelper extends AbsThirdPartyLoginBase {
    protected static final int RC_GET_TOKEN = 9002;

    /* renamed from: a */
    private static final String f22963a = "GoogleLoginHelper - ";

    public String getChannel() {
        return "google";
    }

    public String getText() {
        return "Google";
    }

    public GoogleLoginHelper(String str) {
        super(str);
        this.iconRes = R.drawable.one_google_login_image_icon;
    }

    public void startLogin(Activity activity, ThirdPartyLoginListener thirdPartyLoginListener) {
        log("GoogleLoginHelper - startLogin(): ");
        this.listener = thirdPartyLoginListener;
        activity.startActivityForResult(GoogleSignIn.getClient(activity, new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestIdToken(this.clientId).requestEmail().build()).getSignInIntent(), 9002);
    }

    public void handleLoginResult(int i, int i2, Intent intent) {
        log("GoogleLoginHelper - handleLoginResult(): ");
        if (i == 9002) {
            try {
                Task<GoogleSignInAccount> signedInAccountFromIntent = GoogleSignIn.getSignedInAccountFromIntent(intent);
                if (signedInAccountFromIntent == null) {
                    onFailure(new Exception("task is null"));
                    return;
                }
                String idToken = signedInAccountFromIntent.getResult(ApiException.class).getIdToken();
                if (!TextUtils.isEmpty(idToken)) {
                    onSucess(idToken, this.clientId);
                } else {
                    onFailure(signedInAccountFromIntent.getException());
                }
                log("GoogleLoginHelper - handleSignInResult: " + idToken);
            } catch (ApiException e) {
                e.printStackTrace();
                onFailure(e);
            }
        }
    }
}
