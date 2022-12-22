package com.didiglobal.privacysdk;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import com.didi.commoninterfacelib.statuslightning.StatusBarLightingCompat;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;

public class PrivacyActivity extends FragmentActivity {
    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        if (GlobalPrivacySDK.getBaseActivityDelegate() != null) {
            context = GlobalPrivacySDK.getBaseActivityDelegate().getAttachBaseContext(context, this);
        }
        super.attachBaseContext(context);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        if (GlobalPrivacySDK.hasConfigThemeResInt()) {
            setTheme(GlobalPrivacySDK.getThemeResInt());
        }
        setContentView((int) R.layout.global_privacy_activity_privacy);
        StatusBarLightingCompat.setStatusBarBgLightning((Activity) this, GlobalPrivacySDK.getGlobalPrivacyThemeOptions().isStatusBarBgLightning());
        if (bundle == null) {
            m36348a();
            GlobalOmegaUtils.sendSettingPrivacyEntranceClick();
        } else if (GlobalPrivacySDK.isFinishActivityWhenAppRestarted()) {
            finish();
        }
    }

    /* renamed from: a */
    private void m36348a() {
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        PrivacyFragment privacyFragment = new PrivacyFragment();
        privacyFragment.setArguments(new Bundle());
        beginTransaction.replace(R.id.fragment, privacyFragment, privacyFragment.getClass().getName());
        getSupportFragmentManager().popBackStackImmediate((String) null, 1);
        beginTransaction.commitAllowingStateLoss();
    }

    public void jumpPermissionFragment() {
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        PermissionFragment permissionFragment = new PermissionFragment();
        beginTransaction.setCustomAnimations(R.anim.global_unify_anim_end_slide_in, R.anim.global_unify_anim_start_side_out, R.anim.global_unify_anim_start_side_in, R.anim.global_unify_anim_end_slide_out);
        permissionFragment.setArguments(new Bundle());
        beginTransaction.add(R.id.fragment, permissionFragment, permissionFragment.getClass().getName());
        beginTransaction.addToBackStack((String) null);
        beginTransaction.commitAllowingStateLoss();
    }
}
