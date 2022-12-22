package com.didi.component.common.pininput;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;

public class PinInputActivity extends FragmentActivity {
    public static Intent getIntent(Context context) {
        return new Intent(context, PinInputActivity.class);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.global_pin_input_activity);
        m7885a();
    }

    /* renamed from: a */
    private void m7885a() {
        getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_container, new PinInputFragment()).commit();
    }
}
