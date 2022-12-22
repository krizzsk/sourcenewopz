package com.didi.app.nova.skeleton;

import com.didi.app.nova.skeleton.internal.Const;
import com.didi.app.nova.skeleton.tools.TraceUtil;

public class Skeleton {

    /* renamed from: a */
    private static boolean f8264a = false;

    /* renamed from: b */
    private static boolean f8265b = false;

    /* renamed from: c */
    private static boolean f8266c = false;

    /* renamed from: d */
    private static ReferenceWatcher f8267d;

    /* renamed from: e */
    private static ServiceRegistry f8268e;

    public interface ReferenceWatcher {
        void logBreadcrumb(String str, String str2, String str3);

        void watch(Object obj);
    }

    public interface Tracer {
        void trace(String str, String str2);
    }

    public static ReferenceWatcher getReferenceWatcher() {
        return f8267d;
    }

    public static void setReferenceWatcher(ReferenceWatcher referenceWatcher) {
        f8267d = referenceWatcher;
    }

    public static void watchDeletedObject(Object obj) {
        if (obj != null && f8267d != null) {
            if (f8264a || f8265b) {
                f8267d.watch(obj);
            }
        }
    }

    public static void logBreadcrumb(String str, String str2, String str3) {
        ReferenceWatcher referenceWatcher = f8267d;
        if (referenceWatcher != null && f8266c) {
            if (str2 == null || str3 == null) {
                f8267d.logBreadcrumb(str, str, str);
            } else {
                referenceWatcher.logBreadcrumb(str, str2, str3);
            }
        }
    }

    public static void enableBreadcrumbLogging() {
        f8266c = true;
    }

    public static void enableLeakCanary() {
        f8264a = true;
    }

    public static void disableLeakCanary() {
        f8264a = false;
    }

    public static boolean isLeakCanaryEnabled() {
        return f8264a;
    }

    public static void enableULeakLifecycleTracking() {
        f8265b = true;
    }

    public static void disableULeakLifecycleTracking() {
        f8265b = false;
    }

    public static void setServiceRegistry(ServiceRegistry serviceRegistry) {
        f8268e = serviceRegistry;
    }

    public static ServiceRegistry getServiceRegistry() {
        return f8268e;
    }

    public static void enableRevealComponent(boolean z) {
        Const.ENABLE_REVEAL = z;
    }

    public static void enableAnnotationDsl(boolean z) {
        Const.ENABLE_ANNOTATION = z;
    }

    public static void enableAnnotationDslDebug(boolean z) {
        Const.ENABLE_ANNOTATION_DEBUG = z;
    }

    public static void setLifeTracer(Tracer tracer) {
        TraceUtil.ENABLE = tracer != null;
        TraceUtil.tracer = tracer;
    }
}
