package com.didichuxing.publicservice.resourcecontrol.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import com.didi.flutter.nacho2.p115v2.NachoLifecycleManager;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.publicservice.general.AppUtils;
import com.didichuxing.publicservice.general.ConstantUtils;
import com.didichuxing.publicservice.resourcecontrol.api.ResourceApi;
import com.didichuxing.publicservice.resourcecontrol.fragments.AssetBasicFragment;
import com.didichuxing.publicservice.resourcecontrol.utils.AssetWindowUtil;
import com.didichuxing.publicservice.resourcecontrol.utils.ResourceManager;
import com.taxis99.R;
import java.util.HashMap;

public class RControlActivity extends FragmentActivity {
    private static final String TAG = RControlActivity.class.getSimpleName();
    public static HashMap<String, Object> tunaDownloadMapList = new HashMap<>();
    private Bundle bundle;
    private int code;
    private Intent mIntent;
    private String sharedkey = null;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle2) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle2);
        requestWindowFeature(1);
        if (ResourceManager.getManager().getApplication() != null) {
            AssetWindowUtil.resize(getLayoutInflater().inflate(R.layout.asset_activity_show, (ViewGroup) null, false));
        }
        Intent intent = getIntent();
        this.mIntent = intent;
        if (intent == null) {
            finish();
            return;
        }
        Bundle extras = intent.getExtras();
        this.bundle = extras;
        this.code = extras.getInt(ConstantUtils.EXTRA_RESOURCE_TYPE);
        this.sharedkey = this.bundle.getString(ConstantUtils.SHAREDPRERENCE_KEY);
        SystemUtils.log(3, "RControlActivity", NachoLifecycleManager.LIFECYCLE_ON_CREATE, (Throwable) null, "com.didichuxing.publicservice.resourcecontrol.activities.RControlActivity", 57);
        AppUtils.log(TAG + " ======= sharedkey: " + this.sharedkey);
        int i = this.code;
        if (i == 1001) {
            setTheme(R.style.Asset_Notices);
        } else if (i == 1002) {
            setTheme(R.style.Asset_Splash);
        }
        setContentView((int) R.layout.asset_activity_show);
        initFragmentUI(this.bundle);
    }

    private void initFragmentUI(Bundle bundle2) {
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        AssetBasicFragment creatFragmentByCode = AssetBasicFragment.creatFragmentByCode(bundle2);
        if (creatFragmentByCode == null) {
            AppUtils.log(TAG + "=======check your Code");
            return;
        }
        beginTransaction.replace(R.id.fragmentshow, creatFragmentByCode);
        beginTransaction.commit();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        SystemUtils.hookSetRequestedOrientation(this, 1);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        ResourceApi.mResourceHandler.sendEmptyMessage(21);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        int i = this.code;
        if (i == 1003 || i == 1001) {
            ResourceManager.WINDOW_SHOWING = false;
        }
        if (!TextUtils.isEmpty(this.sharedkey)) {
            AppUtils.log("删除缓存,type = " + this);
            AppUtils.saveStringToPreference(this, this.sharedkey, (String) null);
        }
        boolean allow = Apollo.getToggle("switch_publicservice_bitmaps_leak", true).allow();
        SystemUtils.log(3, "RControlActivity", "Leak:" + allow, (Throwable) null, "com.didichuxing.publicservice.resourcecontrol.activities.RControlActivity", 104);
        if (allow) {
            tunaDownloadMapList.clear();
        }
    }
}
