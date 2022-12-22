package com.didi.entrega.security;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import com.didi.entrega.customer.base.pages.BaseActivity;
import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.customer.foundation.util.CustomerApolloUtil;
import com.facebook.AuthenticationTokenClaims;
import com.facebook.login.LoginManager;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175977d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014J\u001c\u0010\n\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0014¨\u0006\u0011"}, mo175978d2 = {"Lcom/didi/entrega/security/FacebookMiddleActivity;", "Lcom/didi/entrega/customer/base/pages/BaseActivity;", "()V", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "persistentState", "Landroid/os/PersistableBundle;", "onStart", "Companion", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FacebookMiddleActivity.kt */
public final class FacebookMiddleActivity extends BaseActivity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private static final String f21045a = "FacebookMiddleActivity";

    public void _$_clearFindViewByIdCache() {
    }

    public FacebookMiddleActivity() {
        LogUtil.m14763e("wangzhe", "facebook start");
    }

    public void onCreate(Bundle bundle, PersistableBundle persistableBundle) {
        LogUtil.m14763e("wangzhe", "facebook oncreate");
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
        LogUtil.m14765i(f21045a, "facebook onStart");
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        setResult(i2, intent);
        finish();
        LogUtil.m14765i(f21045a, "facebook onActivityResult");
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/entrega/security/FacebookMiddleActivity$Companion;", "", "()V", "TAG", "", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: FacebookMiddleActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
