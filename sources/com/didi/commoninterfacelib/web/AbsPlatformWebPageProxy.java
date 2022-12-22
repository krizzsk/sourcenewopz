package com.didi.commoninterfacelib.web;

import android.content.Intent;
import android.os.Bundle;
import com.didi.commoninterfacelib.ServiceProviderManager;
import com.didi.commoninterfacelib.web.IPlatformWebPageProxy;
import com.didi.flutter.nacho2.p115v2.NachoLifecycleManager;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import java.util.HashMap;

public abstract class AbsPlatformWebPageProxy extends Intent implements IPlatformWebPageProxy {
    public static final String KEY_PROXYCLASS = "proxy_class";
    public static final String KEY_TITLE = "title";
    public static final String KEY_URL = "url";
    private final String TAG = "AbsPlatformWebPageProxy";
    private Logger logger = LoggerFactory.getLogger("AbsPlatformWebPageProxy");

    public AbsPlatformWebPageProxy() {
        IPlatformWebPageActionRegister iPlatformWebPageActionRegister = (IPlatformWebPageActionRegister) ServiceProviderManager.getInstance().getComponent(IPlatformWebPageActionRegister.class);
        if (iPlatformWebPageActionRegister != null) {
            String action = iPlatformWebPageActionRegister.getAction();
            Logger logger2 = this.logger;
            logger2.debug("AbsPlatformWebPageProxy", "AbsPlatformWebPageProxy action:" + action);
            setAction(action);
            return;
        }
        throw new ExceptionInInitializerError("please register action in business project");
    }

    public void setWebUrl(String str) {
        putExtra("url", str);
        putExtra(KEY_PROXYCLASS, getClass().getName());
    }

    public void setWebTitle(String str) {
        putExtra("title", str);
    }

    public HashMap<String, IPlatformWebPageProxy.JsExeCallBack> getJsFunctions() {
        this.logger.debug("AbsPlatformWebPageProxy", "getJsFunctions");
        return null;
    }

    public void onCreate(Bundle bundle) {
        this.logger.debug("AbsPlatformWebPageProxy", NachoLifecycleManager.LIFECYCLE_ON_CREATE);
    }

    public void onStart() {
        this.logger.debug("AbsPlatformWebPageProxy", "onStart");
    }

    public void onReStart() {
        this.logger.debug("AbsPlatformWebPageProxy", "onReStart");
    }

    public void onResume() {
        this.logger.debug("AbsPlatformWebPageProxy", "onResume");
    }

    public void onSaveInstanceState(Bundle bundle) {
        this.logger.debug("AbsPlatformWebPageProxy", "onSaveInstanceState");
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        this.logger.debug("AbsPlatformWebPageProxy", "onActivityResult");
    }

    public void onPause() {
        this.logger.debug("AbsPlatformWebPageProxy", "onPause");
    }

    public void onStop() {
        this.logger.debug("AbsPlatformWebPageProxy", "onStop");
    }

    public void onDestroy() {
        this.logger.debug("AbsPlatformWebPageProxy", NachoLifecycleManager.LIFECYCLE_ON_DESTROY);
    }
}
