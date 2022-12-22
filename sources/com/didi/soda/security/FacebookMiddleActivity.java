package com.didi.soda.security;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import com.didi.soda.customer.base.pages.BaseActivity;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.util.CustomerApolloUtil;
import com.facebook.AuthenticationTokenClaims;
import com.facebook.login.LoginManager;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class FacebookMiddleActivity extends BaseActivity {

    /* renamed from: a */
    private static final String f43809a = "FacebookMiddleActivity";

    public FacebookMiddleActivity() {
        LogUtil.m29102e("wangzhe", "facebook start");
    }

    public void onCreate(Bundle bundle, PersistableBundle persistableBundle) {
        LogUtil.m29102e("wangzhe", "facebook oncreate");
        super.onCreate(bundle, persistableBundle);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        List asList = Arrays.asList(new String[]{"email", "public_profile", AuthenticationTokenClaims.JSON_KEY_USER_FRIENDS});
        if (CustomerApolloUtil.isRequestFacebookUserPostsPermission()) {
            asList.add("user_posts");
        }
        LoginManager.getInstance().logInWithReadPermissions((Activity) this, (Collection<String>) asList);
        LogUtil.m29104i(f43809a, "facebook onStart");
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        setResult(i2, intent);
        finish();
        LogUtil.m29104i(f43809a, "facebook onActivityResult");
    }
}
