package com.didichuxing.swarm.launcher;

import android.app.Application;
import android.content.Context;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.swarm.launcher.toolkit.HotPatchService;
import com.didichuxing.swarm.runtime.SwarmFactory;
import com.didichuxing.swarm.toolkit.ConfigurationService;
import com.didichuxing.swarm.toolkit.TimeService;
import com.didichuxing.swarm.toolkit.ToolkitService;
import com.didichuxing.swarm.toolkit.TraceIdService;
import java.util.Dictionary;
import java.util.HashMap;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import org.osgi.framework.FrameworkListener;
import org.osgi.framework.launch.Framework;

public final class SwarmLauncher {

    /* renamed from: a */
    private static final String f49171a = "SwarmLauncher";

    /* renamed from: b */
    private static final SwarmLauncher f49172b = new SwarmLauncher();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Framework f49173c = new SwarmFactory().newFramework(new HashMap());

    public static SwarmLauncher getInstance() {
        return f49172b;
    }

    private SwarmLauncher() {
    }

    public void launch(final Application application, BundleActivator bundleActivator, final String[] strArr, FrameworkListener... frameworkListenerArr) {
        try {
            this.f49173c.init(frameworkListenerArr);
            m35453a(application, this.f49173c, bundleActivator);
            this.f49173c.start();
            SystemUtils.startThread(new Thread(new Runnable() {
                public void run() {
                    try {
                        SwarmLauncher.this.m35454a((Context) application, SwarmLauncher.this.f49173c, strArr);
                        SwarmLauncher.this.f49173c.waitForStop(0);
                    } catch (Exception e) {
                        Exception exc = e;
                        SystemUtils.log(6, SwarmLauncher.f49171a, exc.getMessage(), exc, "com.didichuxing.swarm.launcher.SwarmLauncher$1", 60);
                    }
                }
            }));
        } catch (BundleException e) {
            SystemUtils.log(6, f49171a, "Start swarm framework error", e, "com.didichuxing.swarm.launcher.SwarmLauncher", 65);
        }
    }

    public Framework getFramework() {
        return this.f49173c;
    }

    /* renamed from: a */
    private void m35453a(Application application, Framework framework, BundleActivator... bundleActivatorArr) {
        BundleContext bundleContext = framework.getBundleContext();
        C16499d dVar = new C16499d(application, framework);
        C16498c cVar = new C16498c(framework);
        bundleContext.registerService(Application.class, application, (Dictionary<String, ?>) null);
        bundleContext.registerService(Context.class, application, (Dictionary<String, ?>) null);
        bundleContext.registerService(ToolkitService.class, dVar, (Dictionary<String, ?>) null);
        bundleContext.registerService(ConfigurationService.class, cVar, (Dictionary<String, ?>) null);
        bundleContext.registerService(TimeService.class, new TimeServiceImpl(framework), (Dictionary<String, ?>) null);
        bundleContext.registerService(TraceIdService.class, new TraceIdServiceImpl(framework), (Dictionary<String, ?>) null);
        bundleContext.registerService(HotPatchService.class, new HotPatchServiceImpl(framework), (Dictionary<String, ?>) null);
        for (BundleActivator bundleActivator : bundleActivatorArr) {
            if (bundleActivator != null) {
                try {
                    bundleActivator.start(bundleContext);
                } catch (Exception e) {
                    SystemUtils.log(6, f49171a, "Start system bundle activator error", e, "com.didichuxing.swarm.launcher.SwarmLauncher", 99);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:12|(2:14|15)|16|17) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0028 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m35454a(android.content.Context r7, org.osgi.framework.launch.Framework r8, java.lang.String... r9) throws org.osgi.framework.BundleException {
        /*
            r6 = this;
            r0 = 0
            if (r9 == 0) goto L_0x0046
            int r1 = r9.length
            if (r1 <= 0) goto L_0x0046
            android.content.res.AssetManager r7 = r7.getAssets()
            int r1 = r9.length
            r2 = 0
        L_0x000c:
            if (r2 >= r1) goto L_0x0046
            r3 = r9[r2]
            r4 = 0
            java.io.InputStream r4 = r7.open(r3)     // Catch:{ all -> 0x0022 }
            org.osgi.framework.BundleContext r5 = r8.getBundleContext()     // Catch:{ all -> 0x0022 }
            r5.installBundle(r3, r4)     // Catch:{ all -> 0x0022 }
            if (r4 == 0) goto L_0x0043
            r4.close()     // Catch:{ FileNotFoundException | IOException -> 0x0043 }
            goto L_0x0043
        L_0x0022:
            r5 = move-exception
            if (r4 == 0) goto L_0x0028
            r4.close()     // Catch:{ IOException -> 0x0028 }
        L_0x0028:
            throw r5     // Catch:{ IOException -> 0x0029 }
        L_0x0029:
            r7 = move-exception
            org.osgi.framework.BundleException r8 = new org.osgi.framework.BundleException
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r0 = "Cannot retrieve bundle from "
            r9.append(r0)
            r9.append(r3)
            java.lang.String r9 = r9.toString()
            r0 = 11
            r8.<init>(r9, r0, r7)
            throw r8
        L_0x0043:
            int r2 = r2 + 1
            goto L_0x000c
        L_0x0046:
            org.osgi.framework.BundleContext r7 = r8.getBundleContext()
            org.osgi.framework.Bundle[] r7 = r7.getBundles()
            java.util.HashMap r8 = new java.util.HashMap
            int r9 = r7.length
            r8.<init>(r9)
            r9 = 0
        L_0x0055:
            int r1 = r7.length
            if (r9 >= r1) goto L_0x0069
            r1 = r7[r9]
            java.lang.String r2 = r1.getSymbolicName()
            com.didichuxing.swarm.launcher.b r3 = new com.didichuxing.swarm.launcher.b
            r3.<init>(r1)
            r8.put(r2, r3)
            int r9 = r9 + 1
            goto L_0x0055
        L_0x0069:
            int r9 = r7.length
            if (r0 >= r9) goto L_0x0079
            com.didichuxing.swarm.launcher.a r9 = new com.didichuxing.swarm.launcher.a
            r1 = r7[r0]
            r9.<init>(r8, r1)
            r9.mo121204b()
            int r0 = r0 + 1
            goto L_0x0069
        L_0x0079:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.swarm.launcher.SwarmLauncher.m35454a(android.content.Context, org.osgi.framework.launch.Framework, java.lang.String[]):void");
    }
}
