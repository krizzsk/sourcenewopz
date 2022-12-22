package com.didi.component.payentrance.activity.confirmfare;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;

public class ConfirmFareActivity extends FragmentActivity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.global_pe_confirm_fare_activity);
        if (bundle == null) {
            m10689a();
        }
    }

    /* renamed from: a */
    private void m10689a() {
        getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_container, new ConfirmFareFragment()).commit();
    }
}
