package com.didi.sdk.app;

import android.content.Context;
import android.os.Bundle;
import com.didi.sdk.app.delegate.BusinessVisibilityDelegate;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.spi.AbstractDelegateManager;
import com.didi.sdk.util.LogTimer;
import com.didi.sdk.util.SingletonHolder;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class BizVisibilityDelegateManager extends AbstractDelegateManager<BusinessVisibilityDelegate> {
    private static final String TAG = "BizVisibilityDelegateManager";
    private static Logger log = LoggerFactory.getLogger(TAG);
    private static boolean resourcesInited;
    /* access modifiers changed from: private */
    public Set<BusinessVisibilityDelegate> delegates = new LinkedHashSet();
    private LogTimer.ElapsedTime elapsedTime = new LogTimer.ElapsedTime();

    private static synchronized void initResources() {
        synchronized (BizVisibilityDelegateManager.class) {
            if (!resourcesInited) {
                resourcesInited = true;
            }
        }
    }

    private BizVisibilityDelegateManager() {
        initResources();
    }

    public void loadDelegates() {
        this.delegates = new HashSet();
        loadDelegates(BusinessVisibilityDelegate.class, new AbstractDelegateManager.DelegateListener<BusinessVisibilityDelegate>() {
            public void onDelegate(String str, BusinessVisibilityDelegate businessVisibilityDelegate) {
                BizVisibilityDelegateManager.this.delegates.add(businessVisibilityDelegate);
            }
        });
    }

    public static BizVisibilityDelegateManager getInstance() {
        return (BizVisibilityDelegateManager) SingletonHolder.getInstance(BizVisibilityDelegateManager.class);
    }

    public void notifyDelegate(Context context, Bundle bundle) {
        Set<BusinessVisibilityDelegate> set = this.delegates;
        if (set != null) {
            for (BusinessVisibilityDelegate next : set) {
                Class<?> cls = next.getClass();
                LogTimer.get().methodStart(this.elapsedTime, String.format("    %s#onStart()", new Object[]{cls}));
                next.notifyUpdateVisibility(context, bundle);
                LogTimer.get().methodEnd(this.elapsedTime, String.format("    %s#onStart()", new Object[]{cls}));
            }
        }
    }
}
