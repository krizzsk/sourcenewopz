package com.didi.sdk.app.scheme;

import android.app.Activity;
import android.content.Intent;
import com.didi.sdk.app.ActivityLifecycleManager;
import com.didi.sdk.app.MainActivity;
import com.didi.sdk.app.SchemeDispatcher;
import com.didi.sdk.log.Logger;

public abstract class AbsSchemeDispatcherFilter {
    public abstract boolean doFilter(Intent intent, SchemeDispatcher schemeDispatcher);

    /* access modifiers changed from: protected */
    public void tryToStartMainActivity(Activity activity) {
        if (!ActivityLifecycleManager.getInstance().isMainActivityRunning()) {
            Logger.easylog("SchemeDispatcher", "MainActivity is not running, start it.");
            Intent intent = new Intent(activity, MainActivity.class);
            intent.addFlags(335544320);
            activity.startActivity(intent);
            return;
        }
        activity.startActivity(new Intent("android.action.launch.DidiLoadDexActivity"));
        activity.finish();
    }
}
