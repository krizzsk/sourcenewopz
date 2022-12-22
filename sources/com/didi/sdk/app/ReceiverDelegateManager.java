package com.didi.sdk.app;

import android.content.IntentFilter;
import android.os.Build;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.spi.AbstractDelegateManager;
import com.didi.sdk.util.SpiUtil;
import java.util.HashMap;
import java.util.Map;

class ReceiverDelegateManager extends AbstractDelegateManager<AbsDidiBroadcastReceiver> implements AbstractDelegateManager.DelegateListener<Class<? extends AbsDidiBroadcastReceiver>> {
    private static Logger log = LoggerFactory.getLogger("ReceiverDelegateManager");
    private BusinessContextHelper contextHelper;
    private Map<AbsDidiBroadcastReceiver, BroadcastReceiverManager> didiBroadcastReceivers = new HashMap();
    private boolean loaded;

    ReceiverDelegateManager(BusinessContextHelper businessContextHelper) {
        this.contextHelper = businessContextHelper;
    }

    /* access modifiers changed from: package-private */
    public void loadDelegates(Class cls) {
        if (!this.loaded) {
            loadDelegateClasses(cls, this);
            this.loaded = true;
        }
    }

    /* access modifiers changed from: package-private */
    public void unloadDelegates() {
        if (this.loaded) {
            for (Map.Entry next : this.didiBroadcastReceivers.entrySet()) {
                AbsDidiBroadcastReceiver absDidiBroadcastReceiver = (AbsDidiBroadcastReceiver) next.getKey();
                ((BroadcastReceiverManager) next.getValue()).unregisterReceiver(absDidiBroadcastReceiver);
                log.debug("注销 Receiver -> %s", absDidiBroadcastReceiver);
            }
            this.didiBroadcastReceivers.clear();
            this.loaded = false;
        }
    }

    public void onDelegate(String str, Class<? extends AbsDidiBroadcastReceiver> cls) {
        IntentFilter intentFilter = (IntentFilter) cls.getAnnotation(IntentFilter.class);
        if (intentFilter == null) {
            log.debug("[%s] %s no @IntentFilter found!", str, cls.getName());
            return;
        }
        try {
            AbsDidiBroadcastReceiver absDidiBroadcastReceiver = (AbsDidiBroadcastReceiver) SpiUtil.makeInstance((ClassLoader) null, cls.getName(), AbsDidiBroadcastReceiver.class);
            if (absDidiBroadcastReceiver != null) {
                IntentFilter parse = parse(intentFilter);
                BroadcastReceiverManager receiverManager = this.contextHelper.getBusinessContext(str, this.contextHelper.getBusinessContextImpl()).getReceiverManager();
                receiverManager.registerReceiver(absDidiBroadcastReceiver, parse);
                this.didiBroadcastReceivers.put(absDidiBroadcastReceiver, receiverManager);
                log.debug("注册 receiver -> %s", absDidiBroadcastReceiver);
            }
        } catch (Exception e) {
            log.error("", (Throwable) e);
        }
    }

    static IntentFilter parse(IntentFilter intentFilter) {
        IntentFilter intentFilter2 = new IntentFilter();
        for (String addAction : intentFilter.actions()) {
            intentFilter2.addAction(addAction);
        }
        for (String addCategory : intentFilter.categories()) {
            intentFilter2.addCategory(addCategory);
        }
        for (String addDataType : intentFilter.dataTypes()) {
            try {
                intentFilter2.addDataType(addDataType);
            } catch (IntentFilter.MalformedMimeTypeException e) {
                log.error("", (Throwable) e);
            }
        }
        for (String addDataScheme : intentFilter.dataSchemes()) {
            intentFilter2.addDataScheme(addDataScheme);
        }
        for (DataAuthority dataAuthority : intentFilter.dataAuthorities()) {
            intentFilter2.addDataAuthority(dataAuthority.value(), Integer.toString(dataAuthority.port()));
        }
        if (Build.VERSION.SDK_INT >= 19) {
            for (DataPatternMatcherPart dataPatternMatcherPart : intentFilter.schemeSpecificParts()) {
                intentFilter2.addDataSchemeSpecificPart(dataPatternMatcherPart.value(), dataPatternMatcherPart.flag());
            }
        }
        for (DataPatternMatcherPart dataPatternMatcherPart2 : intentFilter.dataPaths()) {
            intentFilter2.addDataPath(dataPatternMatcherPart2.value(), dataPatternMatcherPart2.flag());
        }
        return intentFilter2;
    }
}
