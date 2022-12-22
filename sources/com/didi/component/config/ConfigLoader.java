package com.didi.component.config;

import android.content.Context;
import android.text.TextUtils;
import com.didi.component.config.GlobalConfig;
import com.didi.component.config.util.StreamUtils;
import com.didi.component.core.ComponentFactory;
import com.didi.component.core.util.CLog;
import com.didi.sdk.apm.SystemUtils;
import java.io.IOException;
import java.io.InputStream;

public class ConfigLoader {

    /* renamed from: a */
    static Context f12592a = null;

    /* renamed from: b */
    private static final String f12593b = "components/SProductComConfig.json";

    /* renamed from: c */
    private static final String f12594c = "SProductComConfig/SProductComConfig.json";

    /* renamed from: d */
    private static boolean f12595d = false;

    /* renamed from: e */
    private static boolean f12596e = false;

    public static void init(Context context) {
        f12592a = context.getApplicationContext();
        ComponentFactory.get().setProxy(new ComponentFactoryProxy(ComponentFactory.get().getComponentRegistry()));
        m8580b(context);
    }

    /* renamed from: b */
    private static void m8580b(final Context context) {
        SystemUtils.startThread(new Thread(new Runnable() {
            public void run() {
                ConfigLoader.m8581c(context);
            }
        }));
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static synchronized void m8581c(Context context) {
        synchronized (ConfigLoader.class) {
            if (!f12595d) {
                m8582d(context);
                f12595d = true;
            }
        }
    }

    /* renamed from: d */
    private static synchronized void m8582d(Context context) {
        synchronized (ConfigLoader.class) {
            String a = m8578a();
            if (TextUtils.isEmpty(a)) {
                a = m8583e(context);
            }
            if (TextUtils.isEmpty(a)) {
                CLog.m8710i("ConfigLoader#loadConfigFileImpl content is empty");
                return;
            }
            try {
                ComponentsConfig.get().replace(GlobalConfig.fromJSON(a));
                f12596e = true;
            } catch (GlobalConfig.WrongConfigException e) {
                e.printStackTrace();
                CLog.m8711w("ConfigLoader#loadConfigFileImpl catch WrongConfigException");
            }
        }
        return;
    }

    public static boolean isUseConfig() {
        return f12596e;
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [boolean] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String m8578a() {
        /*
            java.lang.String r0 = "scar_passenger_com_remote_config_toggle"
            com.didichuxing.apollo.sdk.IToggle r0 = com.didichuxing.apollo.sdk.Apollo.getToggle(r0)
            boolean r0 = r0.allow()
            r1 = 0
            if (r0 != 0) goto L_0x0013
            java.lang.String r0 = "ConfigLoader#readRemoteConfigFileIfAllow allow=false"
            com.didi.component.core.util.CLog.m8710i(r0)
            return r1
        L_0x0013:
            java.lang.String r0 = "ConfigLoader#readRemoteConfigFileIfAllow allow=true"
            com.didi.component.core.util.CLog.m8710i(r0)
            com.didi.remotereslibrary.RemoteResourceManager r0 = com.didi.remotereslibrary.RemoteResourceManager.getInstance()
            java.lang.String r2 = "SProductComConfig/SProductComConfig.json"
            java.io.File r0 = r0.getResource(r2)     // Catch:{ RemoteResourceNotFoundException -> 0x0023 }
            goto L_0x0028
        L_0x0023:
            r0 = move-exception
            r0.printStackTrace()
            r0 = r1
        L_0x0028:
            if (r0 == 0) goto L_0x0059
            boolean r2 = r0.exists()
            if (r2 != 0) goto L_0x0031
            goto L_0x0059
        L_0x0031:
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x004a, IOException -> 0x0044, all -> 0x0042 }
            r2.<init>(r0)     // Catch:{ FileNotFoundException -> 0x004a, IOException -> 0x0044, all -> 0x0042 }
            java.lang.String r0 = com.didi.component.config.util.StreamUtils.readStringFromStream(r2)     // Catch:{ FileNotFoundException -> 0x0040, IOException -> 0x003e }
            com.didi.component.config.util.StreamUtils.closeQuietly(r2)
            return r0
        L_0x003e:
            r0 = move-exception
            goto L_0x0046
        L_0x0040:
            r0 = move-exception
            goto L_0x004c
        L_0x0042:
            r0 = move-exception
            goto L_0x0055
        L_0x0044:
            r0 = move-exception
            r2 = r1
        L_0x0046:
            r0.printStackTrace()     // Catch:{ all -> 0x0053 }
            goto L_0x004f
        L_0x004a:
            r0 = move-exception
            r2 = r1
        L_0x004c:
            r0.printStackTrace()     // Catch:{ all -> 0x0053 }
        L_0x004f:
            com.didi.component.config.util.StreamUtils.closeQuietly(r2)
            return r1
        L_0x0053:
            r0 = move-exception
            r1 = r2
        L_0x0055:
            com.didi.component.config.util.StreamUtils.closeQuietly(r1)
            throw r0
        L_0x0059:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.config.ConfigLoader.m8578a():java.lang.String");
    }

    /* renamed from: e */
    private static String m8583e(Context context) {
        InputStream inputStream;
        CLog.m8710i("ConfigLoader#readLocalConfigFile");
        try {
            inputStream = context.getAssets().open(f12593b);
            try {
                String readStringFromStream = StreamUtils.readStringFromStream(inputStream);
                StreamUtils.closeQuietly(inputStream);
                return readStringFromStream;
            } catch (IOException e) {
                e = e;
                try {
                    e.printStackTrace();
                    StreamUtils.closeQuietly(inputStream);
                    return null;
                } catch (Throwable th) {
                    th = th;
                    StreamUtils.closeQuietly(inputStream);
                    throw th;
                }
            }
        } catch (IOException e2) {
            e = e2;
            inputStream = null;
            e.printStackTrace();
            StreamUtils.closeQuietly(inputStream);
            return null;
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
            StreamUtils.closeQuietly(inputStream);
            throw th;
        }
    }
}
