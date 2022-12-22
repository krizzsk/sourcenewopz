package com.didi.global.qrscan;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.didi.sdk.apm.SystemUtils;

public abstract class BaseGlobalScanActivity extends FragmentActivity {
    protected QRScanFragment currentFragment;

    public abstract int getContainerId();

    public abstract int getLayout();

    public abstract String getProductId();

    public abstract void onBackPress();

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView(getLayout());
        QRScanFragment qRScanFragment = new QRScanFragment();
        this.currentFragment = qRScanFragment;
        qRScanFragment.setProductId(getProductId());
        getSupportFragmentManager().beginTransaction().replace(getContainerId(), this.currentFragment).commitAllowingStateLoss();
    }

    public void onBackPressed() {
        QRScanFragment qRScanFragment = this.currentFragment;
        if (qRScanFragment == null || !qRScanFragment.onBackPressed()) {
            onBackPress();
        }
    }

    public void finish() {
        QRScanFragment qRScanFragment;
        if (!isFinishing() && (qRScanFragment = this.currentFragment) != null) {
            qRScanFragment.finish();
        }
        super.finish();
    }
}
