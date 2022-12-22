package com.didi.app.nova.skeleton.conductor;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.didi.app.nova.skeleton.conductor.changehandler.SimpleSwapChangeHandler;
import com.didi.app.nova.skeleton.conductor.internal.ClassUtils;
import com.didi.app.nova.skeleton.tools.TraceUtil;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class ControllerChangeHandler {

    /* renamed from: a */
    private static final String f8321a = "ControllerChangeHandler.className";

    /* renamed from: b */
    private static final String f8322b = "ControllerChangeHandler.savedState";
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final Map<String, ChangeHandlerData> f8323c = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f8324d;

    /* renamed from: e */
    private boolean f8325e;

    public interface ControllerChangeCompletedListener {
        void onChangeCompleted();
    }

    public interface ControllerChangeListener {
        void onChangeCompleted(Controller controller, Controller controller2, boolean z, ViewGroup viewGroup, ControllerChangeHandler controllerChangeHandler);

        void onChangeStarted(Controller controller, Controller controller2, boolean z, ViewGroup viewGroup, ControllerChangeHandler controllerChangeHandler);
    }

    public void completeImmediately() {
    }

    public boolean isReusable() {
        return false;
    }

    public void onAbortPush(ControllerChangeHandler controllerChangeHandler, Controller controller) {
    }

    public abstract void performChange(ViewGroup viewGroup, View view, View view2, boolean z, ControllerChangeCompletedListener controllerChangeCompletedListener);

    public boolean removesFromViewOnPush() {
        return true;
    }

    public void restoreFromBundle(Bundle bundle) {
    }

    public void saveToBundle(Bundle bundle) {
    }

    public ControllerChangeHandler() {
        m5503c();
    }

    public ControllerChangeHandler copy() {
        return fromBundle(mo40698a());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final Bundle mo40698a() {
        Bundle bundle = new Bundle();
        bundle.putString(f8321a, getClass().getName());
        Bundle bundle2 = new Bundle();
        saveToBundle(bundle2);
        bundle.putBundle(f8322b, bundle2);
        return bundle;
    }

    /* renamed from: c */
    private void m5503c() {
        try {
            getClass().getConstructor(new Class[0]);
        } catch (Exception unused) {
            throw new RuntimeException(getClass() + " does not have a default constructor.");
        }
    }

    public static ControllerChangeHandler fromBundle(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        ControllerChangeHandler controllerChangeHandler = (ControllerChangeHandler) ClassUtils.newInstance(bundle.getString(f8321a));
        controllerChangeHandler.restoreFromBundle(bundle.getBundle(f8322b));
        return controllerChangeHandler;
    }

    /* renamed from: a */
    static boolean m5501a(String str) {
        ChangeHandlerData changeHandlerData = f8323c.get(str);
        if (changeHandlerData == null) {
            return false;
        }
        changeHandlerData.changeHandler.completeImmediately();
        f8323c.remove(str);
        TraceUtil.trace("[Conductor]", "ControllerChangeHandler#completeHandlerImmediately [changeHandler=" + changeHandlerData.changeHandler + Const.jaRight);
        return true;
    }

    /* renamed from: a */
    static void m5497a(Controller controller, Controller controller2, ControllerChangeHandler controllerChangeHandler) {
        ChangeHandlerData changeHandlerData = f8323c.get(controller.getInstanceId());
        if (changeHandlerData != null) {
            if (changeHandlerData.isPush) {
                changeHandlerData.changeHandler.onAbortPush(controllerChangeHandler, controller2);
            } else {
                changeHandlerData.changeHandler.completeImmediately();
            }
            f8323c.remove(controller.getInstanceId());
        }
        TraceUtil.trace("[Conductor]", "ControllerChangeHandler#abortOrComplete [toAbort=" + controller + ", newController=" + controller2 + ", newChangeHandler=" + controllerChangeHandler + ", changeHandlerData=" + changeHandlerData + Const.jaRight);
    }

    /* renamed from: a */
    static void m5499a(ChangeTransaction changeTransaction) {
        m5498a(changeTransaction.f8326to, changeTransaction.from, changeTransaction.isPush, changeTransaction.container, changeTransaction.changeHandler, changeTransaction.listeners);
    }

    /* renamed from: a */
    private static void m5498a(Controller controller, Controller controller2, boolean z, ViewGroup viewGroup, ControllerChangeHandler controllerChangeHandler, List<ControllerChangeListener> list) {
        View view;
        Controller controller3 = controller;
        Controller controller4 = controller2;
        boolean z2 = z;
        ViewGroup viewGroup2 = viewGroup;
        ControllerChangeHandler controllerChangeHandler2 = controllerChangeHandler;
        TraceUtil.trace("[Conductor]", "ControllerChangeHandler#executeChange [container=" + viewGroup2 + ", from=" + controller4 + ", to=" + controller3 + ", isPush=" + z2 + ", inHandler=" + controllerChangeHandler2 + Const.jaRight);
        if (viewGroup2 != null) {
            if (controllerChangeHandler2 == null) {
                controllerChangeHandler2 = new SimpleSwapChangeHandler();
            } else if (controllerChangeHandler2.f8325e && !controllerChangeHandler.isReusable()) {
                controllerChangeHandler2 = controllerChangeHandler.copy();
            }
            ControllerChangeHandler controllerChangeHandler3 = controllerChangeHandler2;
            controllerChangeHandler3.f8325e = true;
            if (controller4 != null) {
                if (z2) {
                    m5501a(controller2.getInstanceId());
                } else {
                    m5497a(controller4, controller3, controllerChangeHandler3);
                }
            }
            if (controller3 != null) {
                f8323c.put(controller.getInstanceId(), new ChangeHandlerData(controllerChangeHandler3, z2));
            }
            for (ControllerChangeListener onChangeStarted : list) {
                onChangeStarted.onChangeStarted(controller, controller2, z, viewGroup, controllerChangeHandler3);
            }
            final ControllerChangeType controllerChangeType = z2 ? ControllerChangeType.PUSH_ENTER : ControllerChangeType.POP_ENTER;
            final ControllerChangeType controllerChangeType2 = z2 ? ControllerChangeType.PUSH_EXIT : ControllerChangeType.POP_EXIT;
            View view2 = null;
            if (controller3 != null) {
                View a = controller3.mo40586a(viewGroup2);
                controller3.mo40595a(controllerChangeHandler3, controllerChangeType);
                view = a;
            } else {
                view = null;
            }
            if (controller4 != null) {
                view2 = controller2.getView();
                controller4.mo40595a(controllerChangeHandler3, controllerChangeType2);
            }
            View view3 = view2;
            final Controller controller5 = controller2;
            final ControllerChangeHandler controllerChangeHandler4 = controllerChangeHandler3;
            final Controller controller6 = controller;
            final List<ControllerChangeListener> list2 = list;
            final boolean z3 = z;
            final ViewGroup viewGroup3 = viewGroup;
            final View view4 = view3;
            controllerChangeHandler3.performChange(viewGroup, view3, view, z, new ControllerChangeCompletedListener() {
                public void onChangeCompleted() {
                    Controller controller;
                    View view;
                    ViewParent parent;
                    Controller controller2 = controller5;
                    if (controller2 != null) {
                        controller2.mo40602b(controllerChangeHandler4, controllerChangeType2);
                    }
                    if (controller6 != null) {
                        ControllerChangeHandler.f8323c.remove(controller6.getInstanceId());
                        controller6.mo40602b(controllerChangeHandler4, controllerChangeType);
                    }
                    for (ControllerChangeListener onChangeCompleted : list2) {
                        onChangeCompleted.onChangeCompleted(controller6, controller5, z3, viewGroup3, controllerChangeHandler4);
                    }
                    if (controllerChangeHandler4.f8324d && (view = view4) != null && (parent = view.getParent()) != null && (parent instanceof ViewGroup)) {
                        ((ViewGroup) parent).removeView(view4);
                    }
                    if (controllerChangeHandler4.removesFromViewOnPush() && (controller = controller5) != null) {
                        controller.mo40598a(false);
                    }
                }
            });
        }
    }

    public void setForceRemoveViewOnPush(boolean z) {
        this.f8324d = z;
    }

    static class ChangeTransaction {
        final ControllerChangeHandler changeHandler;
        final ViewGroup container;
        final Controller from;
        final boolean isPush;
        final List<ControllerChangeListener> listeners;

        /* renamed from: to */
        final Controller f8326to;

        public ChangeTransaction(Controller controller, Controller controller2, boolean z, ViewGroup viewGroup, ControllerChangeHandler controllerChangeHandler, List<ControllerChangeListener> list) {
            this.f8326to = controller;
            this.from = controller2;
            this.isPush = z;
            this.container = viewGroup;
            this.changeHandler = controllerChangeHandler;
            this.listeners = list;
        }
    }

    private static class ChangeHandlerData {
        public final ControllerChangeHandler changeHandler;
        public final boolean isPush;

        public ChangeHandlerData(ControllerChangeHandler controllerChangeHandler, boolean z) {
            this.changeHandler = controllerChangeHandler;
            this.isPush = z;
        }

        public String toString() {
            return super.toString() + "{changeHandler=" + this.changeHandler + "&isPush=" + this.isPush + "}";
        }
    }
}
