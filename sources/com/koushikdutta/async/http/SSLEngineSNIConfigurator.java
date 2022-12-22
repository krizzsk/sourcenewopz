package com.koushikdutta.async.http;

import android.os.Build;
import com.google.android.gms.security.ProviderInstaller;
import com.koushikdutta.async.http.AsyncHttpClientMiddleware;
import java.lang.reflect.Field;
import java.util.Hashtable;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;

public class SSLEngineSNIConfigurator implements AsyncSSLEngineConfigurator {
    Hashtable<String, EngineHolder> holders = new Hashtable<>();

    private static class EngineHolder implements AsyncSSLEngineConfigurator {
        Field peerHost;
        Field peerPort;
        boolean skipReflection;
        Field sslParameters;
        Field useSni;

        public SSLEngine createEngine(SSLContext sSLContext, String str, int i) {
            return null;
        }

        public EngineHolder(Class cls) {
            try {
                Field declaredField = cls.getSuperclass().getDeclaredField("peerHost");
                this.peerHost = declaredField;
                declaredField.setAccessible(true);
                Field declaredField2 = cls.getSuperclass().getDeclaredField("peerPort");
                this.peerPort = declaredField2;
                declaredField2.setAccessible(true);
                Field declaredField3 = cls.getDeclaredField("sslParameters");
                this.sslParameters = declaredField3;
                declaredField3.setAccessible(true);
                Field declaredField4 = this.sslParameters.getType().getDeclaredField("useSni");
                this.useSni = declaredField4;
                declaredField4.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
        }

        public void configureEngine(SSLEngine sSLEngine, AsyncHttpClientMiddleware.GetSocketData getSocketData, String str, int i) {
            if (this.useSni != null && !this.skipReflection) {
                try {
                    this.peerHost.set(sSLEngine, str);
                    this.peerPort.set(sSLEngine, Integer.valueOf(i));
                    this.useSni.set(this.sslParameters.get(sSLEngine), true);
                } catch (IllegalAccessException unused) {
                }
            }
        }
    }

    public SSLEngine createEngine(SSLContext sSLContext, String str, int i) {
        if (ProviderInstaller.PROVIDER_NAME.equals(sSLContext.getProvider().getName()) || Build.VERSION.SDK_INT >= 23) {
            return sSLContext.createSSLEngine(str, i);
        }
        return sSLContext.createSSLEngine();
    }

    /* access modifiers changed from: package-private */
    public EngineHolder ensureHolder(SSLEngine sSLEngine) {
        String canonicalName = sSLEngine.getClass().getCanonicalName();
        EngineHolder engineHolder = this.holders.get(canonicalName);
        if (engineHolder != null) {
            return engineHolder;
        }
        EngineHolder engineHolder2 = new EngineHolder(sSLEngine.getClass());
        this.holders.put(canonicalName, engineHolder2);
        return engineHolder2;
    }

    public void configureEngine(SSLEngine sSLEngine, AsyncHttpClientMiddleware.GetSocketData getSocketData, String str, int i) {
        ensureHolder(sSLEngine).configureEngine(sSLEngine, getSocketData, str, i);
    }
}
