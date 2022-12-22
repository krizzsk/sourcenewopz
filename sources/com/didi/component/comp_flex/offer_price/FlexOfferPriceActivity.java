package com.didi.component.comp_flex.offer_price;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.didi.safetoolkit.util.statuslightning.StatusBarLightingCompat;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;

public class FlexOfferPriceActivity extends FragmentActivity {
    public static Intent getIntent(Context context, String str) {
        Intent intent = new Intent(context, FlexOfferPriceActivity.class);
        intent.putExtra(FlexOfferPriceFragment.KEY_FLEX_DATA, str);
        intent.setFlags(268435456);
        return intent;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.global_flex_offer_activity);
        StatusBarLightingCompat.setStatusBarBgLightning((Activity) this, true);
        m8226a();
    }

    /* renamed from: a */
    private void m8226a() {
        getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_container, FlexOfferPriceFragment.newInstance(getIntent().getStringExtra(FlexOfferPriceFragment.KEY_FLEX_DATA))).commit();
    }
}
