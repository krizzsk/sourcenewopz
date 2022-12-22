package com.didi.dimina.starbox.module;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.didi.dimina.container.DMConfig;
import com.didi.dimina.container.Dimina;
import com.didi.dimina.container.bundle.RemoteBundleMangerStrategy;
import com.didi.dimina.container.debug.IWebSocketMsgSender;
import com.didi.dimina.container.jsengine.DiminaEngine;
import com.didi.dimina.container.jsengine.JSEngine;
import com.didi.dimina.container.mina.DMMinaPool;
import com.didi.dimina.container.mina.DefaultDMNavigator;
import com.didi.dimina.container.secondparty.DMConfig4Di;
import com.didi.dimina.container.secondparty.bundle.strategy.ReleaseBundleMangerStrategy;
import com.didi.dimina.container.webengine.WebViewEngine;
import com.didi.dimina.container.webengine.webview.DMGeneralWebView;
import com.didi.dimina.starbox.websocket.IDEEngine;
import com.didi.dimina.starbox.websocket.IDEWebSocket;
import com.didi.sdk.apm.SystemUtils;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class StarBoxDockerActivity extends FragmentActivity {
    public static final String IDE_DEV_MODE_IP = "ipAddress";
    public static final String IDE_DEV_MODE_PORT = "websocketPort";
    public static final String KEY_DEV_MODE = "star_box_docker_activity_dev_mode";
    public static final String KEY_DEV_MODE_APP_ID = "app_id";
    public static final String KEY_DEV_MODE_ENTRY_PAGE_PATH = "star_box_docker_activity_dev_mode_entry_page_path";
    public static final String KEY_DEV_MODE_GIFT_URL = "star_box_docker_activity_dev_mode_gift_url";
    public static final String KEY_DEV_MODE_IP_URL = "star_box_docker_activity_dev_mode_ip_url";
    public static final String KEY_DEV_MODE_LAUNCH_PARAMS = "star_box_docker_activity_dev_mode_launch_params";
    public static final String VALUE_DEV_MODE_GIFT = "gift";
    public static final String VALUE_DEV_MODE_IP = "ip";
    public static final String VALUE_DEV_MODE_NONE = "none";

    /* renamed from: a */
    private static final String f17999a = "android";

    /* access modifiers changed from: protected */
    public int getContentId() {
        return 16908290;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        if (bundle != null) {
            bundle.remove("android:support:fragments");
        }
        super.onCreate(bundle);
        m13459a();
    }

    /* renamed from: a */
    private void m13459a() {
        DMConfig4Di dMConfig4Di = new DMConfig4Di(this);
        String stringExtra = getIntent().getStringExtra(KEY_DEV_MODE);
        if (TextUtils.equals(stringExtra, VALUE_DEV_MODE_GIFT)) {
            dMConfig4Di.getLaunchConfig().setBundleManagerStrategy(new RemoteBundleMangerStrategy(getIntent().getStringExtra(KEY_DEV_MODE_GIFT_URL)));
        } else if (TextUtils.equals(stringExtra, "ip")) {
            dMConfig4Di.getLaunchConfig().setBundleManagerStrategy(new RemoteBundleMangerStrategy(getIntent().getStringExtra(KEY_DEV_MODE_IP_URL)));
        } else {
            dMConfig4Di.getLaunchConfig().setBundleManagerStrategy(new ReleaseBundleMangerStrategy());
        }
        String stringExtra2 = getIntent().getStringExtra("app_id");
        if (!TextUtils.isEmpty(stringExtra2)) {
            dMConfig4Di.getLaunchConfig().setAppId(stringExtra2);
        }
        String stringExtra3 = getIntent().getStringExtra(KEY_DEV_MODE_LAUNCH_PARAMS);
        if (!TextUtils.isEmpty(stringExtra3)) {
            try {
                dMConfig4Di.getLaunchConfig().setExtraOptions(new JSONObject(stringExtra3));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        String stringExtra4 = getIntent().getStringExtra(KEY_DEV_MODE_ENTRY_PAGE_PATH);
        if (!TextUtils.isEmpty(stringExtra4)) {
            dMConfig4Di.getLaunchConfig().setEntryPath(stringExtra4);
        }
        String stringExtra5 = getIntent().getStringExtra(IDE_DEV_MODE_IP);
        String stringExtra6 = getIntent().getStringExtra(IDE_DEV_MODE_PORT);
        if (TextUtils.isEmpty(stringExtra5) || TextUtils.isEmpty(stringExtra6)) {
            dMConfig4Di.getLaunchConfig().setEngineFactory(new DMConfig.EngineFactory() {
                public WebViewEngine createWebViewEngine(Activity activity) {
                    return new DMGeneralWebView(activity);
                }

                public JSEngine createJSEngine() {
                    return new DiminaEngine();
                }
            });
        } else {
            String format = String.format("%s:%s", new Object[]{stringExtra5, stringExtra6});
            dMConfig4Di.getLaunchConfig().setIDEDebugUrl(String.format(Locale.US, "ws://%s/%s", new Object[]{format, "android"}));
            dMConfig4Di.getLaunchConfig().setEngineFactory(new DMConfig.EngineFactory() {
                public WebViewEngine createWebViewEngine(Activity activity) {
                    return new DMGeneralWebView(activity);
                }

                public JSEngine createJSEngine() {
                    return new IDEEngine();
                }
            });
        }
        Dimina.launch(this, dMConfig4Di, new DMNavigator(getSupportFragmentManager(), getContentId()), m13458a(dMConfig4Di));
    }

    /* renamed from: a */
    private IWebSocketMsgSender m13458a(DMConfig dMConfig) {
        if (TextUtils.isEmpty(dMConfig.getLaunchConfig().getIDEDebugUrl())) {
            return null;
        }
        return new IDEWebSocket();
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0028  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x002d A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onKeyUp(int r4, android.view.KeyEvent r5) {
        /*
            r3 = this;
            androidx.fragment.app.FragmentManager r0 = r3.getSupportFragmentManager()
            java.util.List r0 = r0.getFragments()
            boolean r1 = r0.isEmpty()
            r2 = 1
            if (r1 != 0) goto L_0x0025
            int r1 = r0.size()
            int r1 = r1 - r2
            java.lang.Object r0 = r0.get(r1)
            androidx.fragment.app.Fragment r0 = (androidx.fragment.app.Fragment) r0
            boolean r1 = r0 instanceof android.view.KeyEvent.Callback
            if (r1 == 0) goto L_0x0025
            android.view.KeyEvent$Callback r0 = (android.view.KeyEvent.Callback) r0
            boolean r0 = r0.onKeyUp(r4, r5)
            goto L_0x0026
        L_0x0025:
            r0 = 0
        L_0x0026:
            if (r0 != 0) goto L_0x002d
            boolean r4 = super.onKeyUp(r4, r5)
            return r4
        L_0x002d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.starbox.module.StarBoxDockerActivity.onKeyUp(int, android.view.KeyEvent):boolean");
    }

    public class DMNavigator extends DefaultDMNavigator {
        public DMNavigator(FragmentManager fragmentManager, int i) {
            super(fragmentManager, i);
        }

        public boolean navigateBack(int i, int i2, int i3) {
            boolean navigateBack = super.navigateBack(i, i2, i3);
            if (this.mPageStack.isEmpty() || DMMinaPool.size() == 0) {
                StarBoxDockerActivity.this.finish();
            }
            return navigateBack;
        }

        public boolean closeDimina() {
            boolean closeDimina = super.closeDimina();
            if (this.mPageStack.isEmpty() || DMMinaPool.size() == 0) {
                StarBoxDockerActivity.this.finish();
            }
            return closeDimina;
        }
    }
}
