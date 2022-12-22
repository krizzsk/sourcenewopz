package com.didi.component.service.activity.rgltaxiguide;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;

public class RegularTaxiGuideActivity extends FragmentActivity {
    public static Intent getIntent(Context context) {
        return new Intent(context, RegularTaxiGuideActivity.class);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.global_regular_taxi_guide_activity);
        m11432a();
    }

    /* renamed from: a */
    private void m11432a() {
        getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_container, new RegularTaxiGuideFragment()).commit();
    }
}
