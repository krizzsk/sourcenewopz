package com.didichuxing.swarm.launcher.util;

public final class SwarmServices {
    /* JADX WARNING: type inference failed for: r2v0, types: [java.lang.Class, java.lang.Class<T>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> T lookup(java.lang.Class<T> r2) {
        /*
            com.didichuxing.swarm.launcher.SwarmLauncher r0 = com.didichuxing.swarm.launcher.SwarmLauncher.getInstance()
            org.osgi.framework.launch.Framework r0 = r0.getFramework()
            r1 = 0
            if (r0 != 0) goto L_0x000c
            return r1
        L_0x000c:
            org.osgi.framework.BundleContext r0 = r0.getBundleContext()
            if (r0 != 0) goto L_0x0013
            return r1
        L_0x0013:
            org.osgi.framework.ServiceReference r2 = r0.getServiceReference(r2)
            if (r2 != 0) goto L_0x001a
            return r1
        L_0x001a:
            java.lang.Object r2 = r0.getService(r2)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.swarm.launcher.util.SwarmServices.lookup(java.lang.Class):java.lang.Object");
    }

    private SwarmServices() {
    }
}
