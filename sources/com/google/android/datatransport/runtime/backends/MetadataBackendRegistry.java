package com.google.android.datatransport.runtime.backends;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import com.didi.sdk.apm.SystemUtils;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
class MetadataBackendRegistry implements BackendRegistry {
    private static final String BACKEND_KEY_PREFIX = "backend:";
    private static final String TAG = "BackendRegistry";
    private final BackendFactoryProvider backendFactoryProvider;
    private final Map<String, TransportBackend> backends;
    private final CreationContextFactory creationContextFactory;

    @Inject
    MetadataBackendRegistry(Context context, CreationContextFactory creationContextFactory2) {
        this(new BackendFactoryProvider(context), creationContextFactory2);
    }

    MetadataBackendRegistry(BackendFactoryProvider backendFactoryProvider2, CreationContextFactory creationContextFactory2) {
        this.backends = new HashMap();
        this.backendFactoryProvider = backendFactoryProvider2;
        this.creationContextFactory = creationContextFactory2;
    }

    public synchronized TransportBackend get(String str) {
        if (this.backends.containsKey(str)) {
            return this.backends.get(str);
        }
        BackendFactory backendFactory = this.backendFactoryProvider.get(str);
        if (backendFactory == null) {
            return null;
        }
        TransportBackend create = backendFactory.create(this.creationContextFactory.create(str));
        this.backends.put(str, create);
        return create;
    }

    static class BackendFactoryProvider {
        private final Context applicationContext;
        private Map<String, String> backendProviders = null;

        BackendFactoryProvider(Context context) {
            this.applicationContext = context;
        }

        /* access modifiers changed from: package-private */
        public BackendFactory get(String str) {
            String str2 = getBackendProviders().get(str);
            if (str2 == null) {
                return null;
            }
            try {
                return (BackendFactory) Class.forName(str2).asSubclass(BackendFactory.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (ClassNotFoundException e) {
                SystemUtils.log(5, MetadataBackendRegistry.TAG, String.format("Class %s is not found.", new Object[]{str2}), e, "com.google.android.datatransport.runtime.backends.MetadataBackendRegistry$BackendFactoryProvider", 106);
                return null;
            } catch (IllegalAccessException e2) {
                SystemUtils.log(5, MetadataBackendRegistry.TAG, String.format("Could not instantiate %s.", new Object[]{str2}), e2, "com.google.android.datatransport.runtime.backends.MetadataBackendRegistry$BackendFactoryProvider", 108);
                return null;
            } catch (InstantiationException e3) {
                SystemUtils.log(5, MetadataBackendRegistry.TAG, String.format("Could not instantiate %s.", new Object[]{str2}), e3, "com.google.android.datatransport.runtime.backends.MetadataBackendRegistry$BackendFactoryProvider", 110);
                return null;
            } catch (NoSuchMethodException e4) {
                SystemUtils.log(5, MetadataBackendRegistry.TAG, String.format("Could not instantiate %s", new Object[]{str2}), e4, "com.google.android.datatransport.runtime.backends.MetadataBackendRegistry$BackendFactoryProvider", 112);
                return null;
            } catch (InvocationTargetException e5) {
                SystemUtils.log(5, MetadataBackendRegistry.TAG, String.format("Could not instantiate %s", new Object[]{str2}), e5, "com.google.android.datatransport.runtime.backends.MetadataBackendRegistry$BackendFactoryProvider", 114);
                return null;
            }
        }

        private Map<String, String> getBackendProviders() {
            if (this.backendProviders == null) {
                this.backendProviders = discover(this.applicationContext);
            }
            return this.backendProviders;
        }

        private Map<String, String> discover(Context context) {
            Bundle metadata = getMetadata(context);
            if (metadata == null) {
                SystemUtils.log(5, MetadataBackendRegistry.TAG, "Could not retrieve metadata, returning empty list of transport backends.", (Throwable) null, "com.google.android.datatransport.runtime.backends.MetadataBackendRegistry$BackendFactoryProvider", 131);
                return Collections.emptyMap();
            }
            HashMap hashMap = new HashMap();
            for (String str : metadata.keySet()) {
                Object obj = metadata.get(str);
                if ((obj instanceof String) && str.startsWith(MetadataBackendRegistry.BACKEND_KEY_PREFIX)) {
                    for (String trim : ((String) obj).split(",", -1)) {
                        String trim2 = trim.trim();
                        if (!trim2.isEmpty()) {
                            hashMap.put(trim2, str.substring(8));
                        }
                    }
                }
            }
            return hashMap;
        }

        private static Bundle getMetadata(Context context) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null) {
                    SystemUtils.log(5, MetadataBackendRegistry.TAG, "Context has no PackageManager.", (Throwable) null, "com.google.android.datatransport.runtime.backends.MetadataBackendRegistry$BackendFactoryProvider", 155);
                    return null;
                }
                ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, TransportBackendDiscovery.class), 128);
                if (serviceInfo != null) {
                    return serviceInfo.metaData;
                }
                SystemUtils.log(5, MetadataBackendRegistry.TAG, "TransportBackendDiscovery has no service info.", (Throwable) null, "com.google.android.datatransport.runtime.backends.MetadataBackendRegistry$BackendFactoryProvider", 163);
                return null;
            } catch (PackageManager.NameNotFoundException unused) {
                SystemUtils.log(5, MetadataBackendRegistry.TAG, "Application info not found.", (Throwable) null, "com.google.android.datatransport.runtime.backends.MetadataBackendRegistry$BackendFactoryProvider", 168);
                return null;
            }
        }
    }
}
