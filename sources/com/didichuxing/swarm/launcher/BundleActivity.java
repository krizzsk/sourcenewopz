package com.didichuxing.swarm.launcher;

import android.os.Bundle;
import android.widget.TextView;
import com.didi.sdk.apm.SystemUtils;

public class BundleActivity extends BaseFragmentActivity {
    public static final String EXTRA_ID = "bundle_id";

    /* renamed from: a */
    private TextView f49155a;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        super.setContentView(17367043);
        super.setupActionBar();
        this.f49155a = (TextView) findViewById(16908308);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        org.osgi.framework.Bundle bundle = SwarmLauncher.getInstance().getFramework().getBundleContext().getBundle(getIntent().getLongExtra(EXTRA_ID, -1));
        setTitle(bundle.getSymbolicName());
        this.f49155a.setText(bundle.toString());
    }
}
