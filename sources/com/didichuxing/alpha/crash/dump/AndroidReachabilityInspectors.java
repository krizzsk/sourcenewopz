package com.didichuxing.alpha.crash.dump;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.app.Fragment;
import android.os.MessageQueue;
import android.view.View;
import com.didi.flutter.nacho2.p115v2.NachoConstants;
import com.didichuxing.alpha.crash.dump.Reachability;
import java.util.ArrayList;
import java.util.List;

public enum AndroidReachabilityInspectors {
    VIEW(ViewInspector.class),
    ACTIVITY(ActivityInspector.class),
    DIALOG(DialogInspector.class),
    APPLICATION(ApplicationInspector.class),
    FRAGMENT(FragmentInspector.class),
    SUPPORT_FRAGMENT(SupportFragmentInspector.class),
    MESSAGE_QUEUE(MessageQueueInspector.class),
    MORTAR_PRESENTER(MortarPresenterInspector.class),
    VIEW_ROOT_IMPL(ViewImplInspector.class),
    MAIN_THEAD(MainThreadInspector.class),
    WINDOW(WindowInspector.class);
    
    private final Class<? extends Reachability.Inspector> inspectorClass;

    private AndroidReachabilityInspectors(Class<? extends Reachability.Inspector> cls) {
        this.inspectorClass = cls;
    }

    public static List<Class<? extends Reachability.Inspector>> defaultAndroidInspectors() {
        ArrayList arrayList = new ArrayList();
        for (AndroidReachabilityInspectors androidReachabilityInspectors : values()) {
            arrayList.add(androidReachabilityInspectors.inspectorClass);
        }
        return arrayList;
    }

    public static class ViewInspector implements Reachability.Inspector {
        public Reachability expectedReachability(LeakTraceElement leakTraceElement) {
            if (!leakTraceElement.isInstanceOf((Class<?>) View.class)) {
                return Reachability.UNKNOWN;
            }
            String fieldReferenceValue = leakTraceElement.getFieldReferenceValue("mAttachInfo");
            if (fieldReferenceValue == null) {
                return Reachability.UNKNOWN;
            }
            return fieldReferenceValue.equals("null") ? Reachability.UNREACHABLE : Reachability.REACHABLE;
        }
    }

    public static class ActivityInspector implements Reachability.Inspector {
        public Reachability expectedReachability(LeakTraceElement leakTraceElement) {
            if (!leakTraceElement.isInstanceOf((Class<?>) Activity.class)) {
                return Reachability.UNKNOWN;
            }
            String fieldReferenceValue = leakTraceElement.getFieldReferenceValue("mDestroyed");
            if (fieldReferenceValue == null) {
                return Reachability.UNKNOWN;
            }
            return fieldReferenceValue.equals("true") ? Reachability.UNREACHABLE : Reachability.REACHABLE;
        }
    }

    public static class DialogInspector implements Reachability.Inspector {
        public Reachability expectedReachability(LeakTraceElement leakTraceElement) {
            if (!leakTraceElement.isInstanceOf((Class<?>) Dialog.class)) {
                return Reachability.UNKNOWN;
            }
            String fieldReferenceValue = leakTraceElement.getFieldReferenceValue("mDecor");
            if (fieldReferenceValue == null) {
                return Reachability.UNKNOWN;
            }
            return fieldReferenceValue.equals("null") ? Reachability.UNREACHABLE : Reachability.REACHABLE;
        }
    }

    public static class ApplicationInspector implements Reachability.Inspector {
        public Reachability expectedReachability(LeakTraceElement leakTraceElement) {
            if (leakTraceElement.isInstanceOf((Class<?>) Application.class)) {
                return Reachability.REACHABLE;
            }
            return Reachability.UNKNOWN;
        }
    }

    public static class FragmentInspector implements Reachability.Inspector {
        public Reachability expectedReachability(LeakTraceElement leakTraceElement) {
            if (!leakTraceElement.isInstanceOf((Class<?>) Fragment.class)) {
                return Reachability.UNKNOWN;
            }
            String fieldReferenceValue = leakTraceElement.getFieldReferenceValue("mDetached");
            if (fieldReferenceValue == null) {
                return Reachability.UNKNOWN;
            }
            return fieldReferenceValue.equals("true") ? Reachability.UNREACHABLE : Reachability.REACHABLE;
        }
    }

    public static class SupportFragmentInspector implements Reachability.Inspector {
        public Reachability expectedReachability(LeakTraceElement leakTraceElement) {
            if (!leakTraceElement.isInstanceOf("androidx.fragment.app.Fragment")) {
                return Reachability.UNKNOWN;
            }
            String fieldReferenceValue = leakTraceElement.getFieldReferenceValue("mDetached");
            if (fieldReferenceValue == null) {
                return Reachability.UNKNOWN;
            }
            return fieldReferenceValue.equals("true") ? Reachability.UNREACHABLE : Reachability.REACHABLE;
        }
    }

    public static class MessageQueueInspector implements Reachability.Inspector {
        public Reachability expectedReachability(LeakTraceElement leakTraceElement) {
            if (!leakTraceElement.isInstanceOf((Class<?>) MessageQueue.class)) {
                return Reachability.UNKNOWN;
            }
            if ("true".equals(leakTraceElement.getFieldReferenceValue("mQuitting"))) {
                return Reachability.UNREACHABLE;
            }
            return Reachability.UNKNOWN;
        }
    }

    public static class MortarPresenterInspector implements Reachability.Inspector {
        public Reachability expectedReachability(LeakTraceElement leakTraceElement) {
            if (!leakTraceElement.isInstanceOf("mortar.Presenter")) {
                return Reachability.UNKNOWN;
            }
            if ("null".equals(leakTraceElement.getFieldReferenceValue("view"))) {
                return Reachability.UNREACHABLE;
            }
            return Reachability.UNKNOWN;
        }
    }

    public static class ViewImplInspector implements Reachability.Inspector {
        public Reachability expectedReachability(LeakTraceElement leakTraceElement) {
            if (!leakTraceElement.isInstanceOf("android.view.ViewRootImpl")) {
                return Reachability.UNKNOWN;
            }
            String fieldReferenceValue = leakTraceElement.getFieldReferenceValue("mView");
            if (fieldReferenceValue == null) {
                return Reachability.UNKNOWN;
            }
            return fieldReferenceValue.equals("null") ? Reachability.UNREACHABLE : Reachability.REACHABLE;
        }
    }

    public static class MainThreadInspector implements Reachability.Inspector {
        public Reachability expectedReachability(LeakTraceElement leakTraceElement) {
            if (!leakTraceElement.isInstanceOf((Class<?>) Thread.class)) {
                return Reachability.UNKNOWN;
            }
            if (NachoConstants.NACHO_ENTRYPOINT_NAME.equals(leakTraceElement.getFieldReferenceValue("name"))) {
                return Reachability.REACHABLE;
            }
            return Reachability.UNKNOWN;
        }
    }

    public static class WindowInspector implements Reachability.Inspector {
        public Reachability expectedReachability(LeakTraceElement leakTraceElement) {
            if (!leakTraceElement.isInstanceOf("android.view.Window")) {
                return Reachability.UNKNOWN;
            }
            String fieldReferenceValue = leakTraceElement.getFieldReferenceValue("mDestroyed");
            if (fieldReferenceValue == null) {
                return Reachability.UNKNOWN;
            }
            return fieldReferenceValue.equals("true") ? Reachability.UNREACHABLE : Reachability.REACHABLE;
        }
    }
}
