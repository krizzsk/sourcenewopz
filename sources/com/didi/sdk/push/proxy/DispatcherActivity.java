package com.didi.sdk.push.proxy;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.push.PushClient;
import com.didi.sdk.push.PushLog;
import org.jacoco.agent.p086rt.internal_8ff85ea.core.runtime.AgentOptions;

public class DispatcherActivity extends Activity {
    private static final String TAG = "Dispatcher";

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        PushLog.m26280d(TAG, "DispatcherActivity onCreate()");
        Intent intent = getIntent();
        if (intent == null) {
            finish();
        } else {
            handleScheme(intent);
        }
    }

    private void handleScheme(Intent intent) {
        Uri data = intent.getData();
        if (data == null) {
            finish();
            return;
        }
        String scheme = data.getScheme();
        PushLog.m26280d(TAG, "scheme -> " + scheme);
        if ("didiPush".equalsIgnoreCase(scheme)) {
            String host = data.getHost();
            char c = 65535;
            if (host.hashCode() == -897048717 && host.equals("socket")) {
                c = 0;
            }
            if (c == 0) {
                handleSocketScheme(intent);
            }
        }
    }

    private void handleSocketScheme(Intent intent) {
        Uri data = intent.getData();
        String path = data.getPath();
        PushLog.m26280d(TAG, "path=" + path);
        AddressProxy proxy = AddressProxy.getProxy(getApplicationContext());
        if ("/debug".equals(path)) {
            String queryParameter = data.getQueryParameter("ip");
            String queryParameter2 = data.getQueryParameter(AgentOptions.PORT);
            String queryParameter3 = data.getQueryParameter("debug_mode");
            PushLog.m26280d("handleSocketScheme", String.format("ip=[%s],port=[%s]", new Object[]{queryParameter, queryParameter2}));
            proxy.setIp(queryParameter);
            proxy.setPort(Integer.parseInt(queryParameter2));
            if ("1".equals(queryParameter3)) {
                PushClient.getClient().setDebugModeState(1);
            }
        } else if ("/debug_clear".equals(path)) {
            proxy.clearIp();
            proxy.clearPort();
            PushClient.getClient().setDebugModeState(0);
        } else if ("/logup_bind".equals(path)) {
            PushLog.m26280d("handleSocketScheme", String.format("uri=[%s]", new Object[]{data.toString()}));
            LogupBindDispatcher.getInstance().notifyBind(getApplicationContext(), data);
        }
        Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(getPackageName());
        launchIntentForPackage.addFlags(805306368);
        startActivity(launchIntentForPackage);
        if (PushClient.getClient().getOption() != null) {
            PushClient.getClient().stopPush();
            PushClient.getClient().startPush();
        }
    }
}
