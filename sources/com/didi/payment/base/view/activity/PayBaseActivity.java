package com.didi.payment.base.view.activity;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.didi.flutter.nacho2.p115v2.NachoLifecycleManager;
import com.didi.payment.base.lifecycle.ILifecycle;
import com.didi.payment.base.lifecycle.LifecycleOwner;
import com.didi.payment.base.logger.PayLogger;
import com.didi.sdk.apm.SystemUtils;
import java.util.HashMap;
import rui.config.RConfigConstants;

public class PayBaseActivity extends FragmentActivity implements LifecycleOwner {
    public ILifecycle getILifecycle() {
        return null;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        PayLogger.getLogger().debugEvent(m21035a("onStart"), (HashMap<String, Object>) null);
        if (getILifecycle() != null) {
            getILifecycle().willAppear();
        }
    }

    /* access modifiers changed from: protected */
    public void onRestart() {
        super.onRestart();
        PayLogger.getLogger().debugEvent(m21035a("onRestart"), (HashMap<String, Object>) null);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        PayLogger.getLogger().debugEvent(m21035a("onResume"), (HashMap<String, Object>) null);
        if (getILifecycle() != null) {
            getILifecycle().didAppear();
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        PayLogger.getLogger().debugEvent(m21035a("onPause"), (HashMap<String, Object>) null);
        if (getILifecycle() != null) {
            getILifecycle().willDisappear();
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        PayLogger.getLogger().debugEvent(m21035a("onStop"), (HashMap<String, Object>) null);
        if (getILifecycle() != null) {
            getILifecycle().didDisappear();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        PayLogger.getLogger().debugEvent(m21035a(NachoLifecycleManager.LIFECYCLE_ON_DESTROY), (HashMap<String, Object>) null);
        if (getILifecycle() != null) {
            getILifecycle().didComplete();
        }
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        PayLogger.getLogger().debugEvent(m21035a("onSaveInstanceState"), (HashMap<String, Object>) null);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        PayLogger.getLogger().debugEvent(m21035a("onRestoreInstanceState"), (HashMap<String, Object>) null);
    }

    /* renamed from: a */
    private String m21035a(String str) {
        return PayBaseActivity.class.getSimpleName() + RConfigConstants.KEYWORD_COLOR_SIGN + str;
    }
}
