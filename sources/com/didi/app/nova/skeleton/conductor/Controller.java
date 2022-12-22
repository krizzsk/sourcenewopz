package com.didi.app.nova.skeleton.conductor;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.didi.app.nova.skeleton.conductor.internal.ClassUtils;
import com.didi.app.nova.skeleton.conductor.internal.RouterRequiringFunc;
import com.didi.app.nova.skeleton.conductor.internal.ViewAttachHandler;
import com.didichuxing.sofa.permission.PermissionRequest;
import com.didichuxing.sofa.permission.PermissionResultCallback;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public abstract class Controller implements PermissionResultCallback {

    /* renamed from: a */
    static final String f8277a = "Controller.viewState.bundle";

    /* renamed from: c */
    private static final String f8278c = "Controller.className";

    /* renamed from: d */
    private static final String f8279d = "Controller.viewState";

    /* renamed from: e */
    private static final String f8280e = "Controller.childRouters";

    /* renamed from: f */
    private static final String f8281f = "Controller.savedState";

    /* renamed from: g */
    private static final String f8282g = "Controller.instanceId";

    /* renamed from: h */
    private static final String f8283h = "Controller.target.instanceId";

    /* renamed from: i */
    private static final String f8284i = "Controller.args";

    /* renamed from: j */
    private static final String f8285j = "Controller.needsAttach";

    /* renamed from: k */
    private static final String f8286k = "Controller.requestedPermissions";

    /* renamed from: l */
    private static final String f8287l = "Controller.overriddenPushHandler";

    /* renamed from: m */
    private static final String f8288m = "Controller.overriddenPopHandler";

    /* renamed from: n */
    private static final String f8289n = "Controller.viewState.hierarchy";

    /* renamed from: o */
    private static final String f8290o = "Controller.retainViewMode";

    /* renamed from: A */
    private Controller f8291A;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public String f8292B;

    /* renamed from: C */
    private String f8293C;

    /* renamed from: D */
    private boolean f8294D;

    /* renamed from: E */
    private boolean f8295E;

    /* renamed from: F */
    private boolean f8296F;
    /* access modifiers changed from: private */

    /* renamed from: G */
    public boolean f8297G;

    /* renamed from: H */
    private ControllerChangeHandler f8298H;

    /* renamed from: I */
    private ControllerChangeHandler f8299I;

    /* renamed from: J */
    private RetainViewMode f8300J;

    /* renamed from: K */
    private ViewAttachHandler f8301K;

    /* renamed from: L */
    private final List<C3703a> f8302L;

    /* renamed from: M */
    private final List<LifecycleListener> f8303M;

    /* renamed from: N */
    private final ArrayList<String> f8304N;

    /* renamed from: O */
    private final ArrayList<RouterRequiringFunc> f8305O;

    /* renamed from: P */
    private WeakReference<View> f8306P;

    /* renamed from: Q */
    private boolean f8307Q;

    /* renamed from: R */
    private boolean f8308R;

    /* renamed from: b */
    Bundle f8309b;

    /* renamed from: p */
    private final Bundle f8310p;

    /* renamed from: q */
    private Bundle f8311q;

    /* renamed from: r */
    private boolean f8312r;

    /* renamed from: s */
    private boolean f8313s;

    /* renamed from: t */
    private boolean f8314t;

    /* renamed from: u */
    private boolean f8315u;

    /* renamed from: v */
    private boolean f8316v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public boolean f8317w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public boolean f8318x;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public Router f8319y;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public View f8320z;

    public static abstract class LifecycleListener {
        public void onChangeEnd(Controller controller, ControllerChangeHandler controllerChangeHandler, ControllerChangeType controllerChangeType) {
        }

        public void onChangeStart(Controller controller, ControllerChangeHandler controllerChangeHandler, ControllerChangeType controllerChangeType) {
        }

        public void onRestoreInstanceState(Controller controller, Bundle bundle) {
        }

        public void onRestoreViewState(Controller controller, Bundle bundle) {
        }

        public void onSaveInstanceState(Controller controller, Bundle bundle) {
        }

        public void onSaveViewState(Controller controller, Bundle bundle) {
        }

        public void postAttach(Controller controller, View view) {
        }

        public void postContextAvailable(Controller controller, Context context) {
        }

        public void postContextUnavailable(Controller controller) {
        }

        public void postCreateView(Controller controller, View view) {
        }

        public void postDestroy(Controller controller) {
        }

        public void postDestroyView(Controller controller) {
        }

        public void postDetach(Controller controller, View view) {
        }

        public void preAttach(Controller controller, View view) {
        }

        public void preContextAvailable(Controller controller) {
        }

        public void preContextUnavailable(Controller controller, Context context) {
        }

        public void preCreateView(Controller controller) {
        }

        public void preDestroy(Controller controller) {
        }

        public void preDestroyView(Controller controller, View view) {
        }

        public void preDetach(Controller controller, View view) {
        }
    }

    public enum RetainViewMode {
        RELEASE_DETACH,
        RETAIN_DETACH
    }

    /* access modifiers changed from: protected */
    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResult(int i, int i2, Intent intent) {
    }

    /* access modifiers changed from: protected */
    public void onActivityResumed(Activity activity) {
    }

    /* access modifiers changed from: protected */
    public void onActivityStarted(Activity activity) {
    }

    /* access modifiers changed from: protected */
    public void onActivityStopped(Activity activity) {
    }

    /* access modifiers changed from: protected */
    public void onAttach(View view) {
    }

    /* access modifiers changed from: protected */
    public void onChangeEnded(ControllerChangeHandler controllerChangeHandler, ControllerChangeType controllerChangeType) {
    }

    /* access modifiers changed from: protected */
    public void onChangeStarted(ControllerChangeHandler controllerChangeHandler, ControllerChangeType controllerChangeType) {
    }

    /* access modifiers changed from: protected */
    public void onContextAvailable(Context context) {
    }

    /* access modifiers changed from: protected */
    public void onContextUnavailable() {
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
    }

    /* access modifiers changed from: protected */
    public abstract View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup);

    /* access modifiers changed from: protected */
    public void onDestroy() {
    }

    /* access modifiers changed from: protected */
    public void onDestroyView(View view) {
    }

    /* access modifiers changed from: protected */
    public void onDetach(View view) {
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return false;
    }

    public void onPermissionDenied(String[] strArr) {
    }

    public void onPermissionGranted() {
    }

    public void onPrepareOptionsMenu(Menu menu) {
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Bundle bundle) {
    }

    /* access modifiers changed from: protected */
    public void onRestoreViewState(View view, Bundle bundle) {
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
    }

    /* access modifiers changed from: protected */
    public void onSaveViewState(View view, Bundle bundle) {
    }

    public boolean onShowPermissionExplanation(PermissionRequest permissionRequest) {
        return false;
    }

    /* renamed from: a */
    static Controller m5452a(Bundle bundle) {
        Controller controller;
        String string = bundle.getString(f8278c);
        Class classForName = ClassUtils.classForName(string, false);
        Constructor[] constructors = classForName.getConstructors();
        Constructor b = m5458b(constructors);
        Bundle bundle2 = bundle.getBundle(f8284i);
        if (bundle2 != null) {
            bundle2.setClassLoader(classForName.getClassLoader());
        }
        if (b != null) {
            try {
                controller = (Controller) b.newInstance(new Object[]{bundle2});
            } catch (Exception e) {
                throw new RuntimeException("An exception occurred while creating a new instance of " + string + ". " + e.getMessage(), e);
            }
        } else {
            controller = (Controller) m5453a(constructors).newInstance(new Object[0]);
            if (bundle2 != null) {
                controller.f8310p.putAll(bundle2);
            }
        }
        controller.m5459b(bundle);
        return controller;
    }

    protected Controller() {
        this((Bundle) null);
    }

    protected Controller(Bundle bundle) {
        this.f8300J = RetainViewMode.RELEASE_DETACH;
        this.f8302L = new ArrayList();
        this.f8303M = new ArrayList();
        this.f8304N = new ArrayList<>();
        this.f8305O = new ArrayList<>();
        this.f8310p = bundle == null ? new Bundle(getClass().getClassLoader()) : bundle;
        this.f8292B = UUID.randomUUID().toString();
        m5471j();
    }

    public final Router getRouter() {
        return this.f8319y;
    }

    public Bundle getArgs() {
        return this.f8310p;
    }

    public final Router getChildRouter(ViewGroup viewGroup) {
        return getChildRouter(viewGroup, (String) null);
    }

    public final Router getChildRouter(ViewGroup viewGroup, String str) {
        return getChildRouter(viewGroup, str, true);
    }

    public final Router getChildRouter(ViewGroup viewGroup, String str, boolean z) {
        C3703a aVar;
        int id = viewGroup.getId();
        Iterator<C3703a> it = this.f8302L.iterator();
        while (true) {
            if (!it.hasNext()) {
                aVar = null;
                break;
            }
            aVar = it.next();
            if (aVar.mo40773f() == id && TextUtils.equals(str, aVar.mo40774g())) {
                break;
            }
        }
        if (aVar == null) {
            if (z) {
                aVar = new C3703a(viewGroup.getId(), str);
                aVar.mo40770a(this, viewGroup);
                this.f8302L.add(aVar);
                if (this.f8307Q) {
                    aVar.mo40771a(true);
                }
            }
        } else if (!aVar.mo40555a()) {
            aVar.mo40770a(this, viewGroup);
            aVar.rebindIfNeeded();
        }
        return aVar;
    }

    public final void removeChildRouter(Router router2) {
        if ((router2 instanceof C3703a) && this.f8302L.remove(router2)) {
            router2.mo40715b(true);
        }
    }

    public final boolean isDestroyed() {
        return this.f8313s;
    }

    public final boolean isBeingDestroyed() {
        return this.f8312r;
    }

    public final boolean isAttached() {
        return this.f8314t;
    }

    public final View getView() {
        return this.f8320z;
    }

    public final Activity getActivity() {
        Router router2 = this.f8319y;
        if (router2 != null) {
            return router2.getActivity();
        }
        return null;
    }

    public final Resources getResources() {
        Activity activity = getActivity();
        if (activity != null) {
            return activity.getResources();
        }
        return null;
    }

    public final Context getApplicationContext() {
        Activity activity = getActivity();
        if (activity != null) {
            return activity.getApplicationContext();
        }
        return null;
    }

    public final Controller getParentController() {
        return this.f8291A;
    }

    public final String getInstanceId() {
        return this.f8292B;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final Controller mo40587a(String str) {
        if (this.f8292B.equals(str)) {
            return this;
        }
        for (C3703a controllerWithInstanceId : this.f8302L) {
            Controller controllerWithInstanceId2 = controllerWithInstanceId.getControllerWithInstanceId(str);
            if (controllerWithInstanceId2 != null) {
                return controllerWithInstanceId2;
            }
        }
        return null;
    }

    public final List<Router> getChildRouters() {
        ArrayList arrayList = new ArrayList();
        for (C3703a add : this.f8302L) {
            arrayList.add(add);
        }
        return arrayList;
    }

    public void setTargetController(Controller controller) {
        if (this.f8293C == null) {
            this.f8293C = controller != null ? controller.getInstanceId() : null;
            return;
        }
        throw new RuntimeException("Target controller already set. A controller's target may only be set once.");
    }

    public final Controller getTargetController() {
        if (this.f8293C != null) {
            return this.f8319y.mo40557c().getControllerWithInstanceId(this.f8293C);
        }
        return null;
    }

    public final void startActivity(final Intent intent) {
        mo40597a((RouterRequiringFunc) new RouterRequiringFunc() {
            public void execute() {
                Controller.this.f8319y.mo40548a(intent);
            }
        });
    }

    public final void startActivityForResult(final Intent intent, final int i) {
        mo40597a((RouterRequiringFunc) new RouterRequiringFunc() {
            public void execute() {
                Controller.this.f8319y.mo40551a(Controller.this.f8292B, intent, i);
            }
        });
    }

    public final void startActivityForResult(final Intent intent, final int i, final Bundle bundle) {
        mo40597a((RouterRequiringFunc) new RouterRequiringFunc() {
            public void execute() {
                Controller.this.f8319y.mo40552a(Controller.this.f8292B, intent, i, bundle);
            }
        });
    }

    public final void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
        this.f8319y.mo40553a(this.f8292B, intentSender, i, intent, i2, i3, i4, bundle);
    }

    public final void registerForActivityResult(final int i) {
        mo40597a((RouterRequiringFunc) new RouterRequiringFunc() {
            public void execute() {
                Controller.this.f8319y.mo40550a(Controller.this.f8292B, i);
            }
        });
    }

    public final void requestPermissions(final String[] strArr) {
        this.f8304N.addAll(Arrays.asList(strArr));
        mo40597a((RouterRequiringFunc) new RouterRequiringFunc() {
            public void execute() {
                Controller.this.f8319y.mo40554a(Controller.this.f8292B, strArr);
            }
        });
    }

    public boolean shouldShowRequestPermissionRationale(String str) {
        return Build.VERSION.SDK_INT >= 23 && getActivity().shouldShowRequestPermissionRationale(str);
    }

    public boolean handleBack() {
        ArrayList<RouterTransaction> arrayList = new ArrayList<>();
        for (C3703a backstack : this.f8302L) {
            arrayList.addAll(backstack.getBackstack());
        }
        Collections.sort(arrayList, new Comparator<RouterTransaction>() {
            public int compare(RouterTransaction routerTransaction, RouterTransaction routerTransaction2) {
                return routerTransaction2.f8346b - routerTransaction.f8346b;
            }
        });
        for (RouterTransaction routerTransaction : arrayList) {
            Controller controller = routerTransaction.f8345a;
            if (controller.isAttached() && controller.getRouter().handleBack()) {
                return true;
            }
        }
        return false;
    }

    public final void addLifecycleListener(LifecycleListener lifecycleListener) {
        if (!this.f8303M.contains(lifecycleListener)) {
            this.f8303M.add(lifecycleListener);
        }
    }

    public final void removeLifecycleListener(LifecycleListener lifecycleListener) {
        this.f8303M.remove(lifecycleListener);
    }

    public RetainViewMode getRetainViewMode() {
        return this.f8300J;
    }

    public void setRetainViewMode(RetainViewMode retainViewMode) {
        if (retainViewMode == null) {
            retainViewMode = RetainViewMode.RELEASE_DETACH;
        }
        this.f8300J = retainViewMode;
        if (retainViewMode == RetainViewMode.RELEASE_DETACH && !this.f8314t) {
            m5467f();
        }
    }

    public final ControllerChangeHandler getOverriddenPushHandler() {
        return this.f8298H;
    }

    public void overridePushHandler(ControllerChangeHandler controllerChangeHandler) {
        this.f8298H = controllerChangeHandler;
    }

    public ControllerChangeHandler getOverriddenPopHandler() {
        return this.f8299I;
    }

    public void overridePopHandler(ControllerChangeHandler controllerChangeHandler) {
        this.f8299I = controllerChangeHandler;
    }

    public final void setHasOptionsMenu(boolean z) {
        boolean z2 = this.f8314t && !this.f8316v && this.f8315u != z;
        this.f8315u = z;
        if (z2) {
            this.f8319y.invalidateOptionsMenu();
        }
    }

    public final void setOptionsMenuHidden(boolean z) {
        boolean z2 = this.f8314t && this.f8315u && this.f8316v != z;
        this.f8316v = z;
        if (z2) {
            this.f8319y.invalidateOptionsMenu();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo40598a(boolean z) {
        this.f8294D = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo40588a() {
        this.f8294D = this.f8294D || this.f8314t;
        for (C3703a h : this.f8302L) {
            h.mo40724h();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final boolean mo40604b() {
        return this.f8294D;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final boolean mo40605b(String str) {
        return this.f8304N.contains(str);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo40589a(int i, String[] strArr, int[] iArr) {
        this.f8304N.removeAll(Arrays.asList(strArr));
        onRequestPermissionsResult(i, strArr, iArr);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo40596a(Router router2) {
        if (this.f8319y != router2) {
            this.f8319y = router2;
            m5470i();
            Iterator<RouterRequiringFunc> it = this.f8305O.iterator();
            while (it.hasNext()) {
                it.next().execute();
            }
            this.f8305O.clear();
            return;
        }
        m5470i();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final void mo40606c() {
        Activity activity = this.f8319y.getActivity();
        if (activity != null && !this.f8308R) {
            for (LifecycleListener preContextAvailable : new ArrayList(this.f8303M)) {
                preContextAvailable.preContextAvailable(this);
            }
            this.f8308R = true;
            onContextAvailable(activity);
            for (LifecycleListener postContextAvailable : new ArrayList(this.f8303M)) {
                postContextAvailable.postContextAvailable(this, activity);
            }
        }
        for (C3703a onContextAvailable : this.f8302L) {
            onContextAvailable.onContextAvailable();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo40597a(RouterRequiringFunc routerRequiringFunc) {
        if (this.f8319y != null) {
            routerRequiringFunc.execute();
        } else {
            this.f8305O.add(routerRequiringFunc);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo40590a(Activity activity) {
        ViewAttachHandler viewAttachHandler = this.f8301K;
        if (viewAttachHandler != null) {
            viewAttachHandler.onActivityStarted();
        }
        onActivityStarted(activity);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo40601b(Activity activity) {
        View view;
        if (!this.f8314t && (view = this.f8320z) != null && this.f8317w) {
            m5454a(view);
        } else if (this.f8314t) {
            this.f8294D = false;
            this.f8296F = false;
        }
        onActivityResumed(activity);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final void mo40607c(Activity activity) {
        onActivityPaused(activity);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final void mo40609d(Activity activity) {
        ViewAttachHandler viewAttachHandler = this.f8301K;
        if (viewAttachHandler != null) {
            viewAttachHandler.onActivityStopped();
        }
        onActivityStopped(activity);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public final void mo40611e(Activity activity) {
        if (activity.isChangingConfigurations()) {
            mo40593a(this.f8320z, true, false);
        } else {
            m5464c(true);
        }
        if (this.f8308R) {
            for (LifecycleListener preContextUnavailable : new ArrayList(this.f8303M)) {
                preContextUnavailable.preContextUnavailable(this, activity);
            }
            this.f8308R = false;
            onContextUnavailable();
            for (LifecycleListener postContextUnavailable : new ArrayList(this.f8303M)) {
                postContextUnavailable.postContextUnavailable(this);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m5454a(View view) {
        boolean z = this.f8319y == null || view.getParent() != this.f8319y.f8332d;
        this.f8295E = z;
        if (!z) {
            this.f8296F = false;
            for (LifecycleListener preAttach : new ArrayList(this.f8303M)) {
                preAttach.preAttach(this, view);
            }
            this.f8314t = true;
            this.f8294D = false;
            onAttach(view);
            if (this.f8315u && !this.f8316v) {
                this.f8319y.invalidateOptionsMenu();
            }
            for (LifecycleListener postAttach : new ArrayList(this.f8303M)) {
                postAttach.postAttach(this, view);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo40593a(View view, boolean z, boolean z2) {
        if (!this.f8295E) {
            for (C3703a h : this.f8302L) {
                h.mo40724h();
            }
        }
        boolean z3 = !z2 && (z || this.f8300J == RetainViewMode.RELEASE_DETACH || this.f8312r);
        if (this.f8314t) {
            for (LifecycleListener preDetach : new ArrayList(this.f8303M)) {
                preDetach.preDetach(this, view);
            }
            this.f8314t = false;
            onDetach(view);
            if (this.f8315u && !this.f8316v) {
                this.f8319y.invalidateOptionsMenu();
            }
            for (LifecycleListener postDetach : new ArrayList(this.f8303M)) {
                postDetach.postDetach(this, view);
            }
        }
        if (z3) {
            m5467f();
        }
    }

    /* renamed from: f */
    private void m5467f() {
        View view = this.f8320z;
        if (view != null) {
            if (!this.f8312r && !this.f8296F) {
                m5460b(view);
            }
            for (LifecycleListener preDestroyView : new ArrayList(this.f8303M)) {
                preDestroyView.preDestroyView(this, this.f8320z);
            }
            onDestroyView(this.f8320z);
            ViewAttachHandler viewAttachHandler = this.f8301K;
            if (viewAttachHandler != null) {
                viewAttachHandler.unregisterAttachListener(this.f8320z);
            }
            this.f8301K = null;
            this.f8317w = false;
            if (this.f8312r) {
                this.f8306P = new WeakReference<>(this.f8320z);
            }
            for (LifecycleListener postDestroyView : new ArrayList(this.f8303M)) {
                postDestroyView.postDestroyView(this);
            }
            this.f8320z = null;
            for (C3703a e : this.f8302L) {
                e.mo40772e();
            }
        }
        if (this.f8312r) {
            m5469h();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final View mo40586a(ViewGroup viewGroup) {
        View view = this.f8320z;
        if (!(view == null || view.getParent() == null || this.f8320z.getParent() == viewGroup)) {
            mo40593a(this.f8320z, true, false);
            m5467f();
        }
        if (this.f8320z == null) {
            for (LifecycleListener preCreateView : new ArrayList(this.f8303M)) {
                preCreateView.preCreateView(this);
            }
            View onCreateView = onCreateView(LayoutInflater.from(viewGroup.getContext()), viewGroup);
            this.f8320z = onCreateView;
            if (onCreateView != viewGroup) {
                for (LifecycleListener postCreateView : new ArrayList(this.f8303M)) {
                    postCreateView.postCreateView(this, this.f8320z);
                }
                View view2 = this.f8320z;
                if (view2 == null) {
                    return view2;
                }
                m5463c(view2);
                ViewAttachHandler viewAttachHandler = new ViewAttachHandler(new ViewAttachHandler.ViewAttachListener() {
                    public void onAttached() {
                        boolean unused = Controller.this.f8317w = true;
                        boolean unused2 = Controller.this.f8318x = false;
                        Controller controller = Controller.this;
                        controller.m5454a(controller.f8320z);
                    }

                    public void onDetached(boolean z) {
                        boolean unused = Controller.this.f8317w = false;
                        boolean unused2 = Controller.this.f8318x = true;
                        if (!Controller.this.f8297G) {
                            Controller controller = Controller.this;
                            controller.mo40593a(controller.f8320z, false, z);
                        }
                    }

                    public void onViewDetachAfterStop() {
                        if (!Controller.this.f8297G) {
                            Controller controller = Controller.this;
                            controller.mo40593a(controller.f8320z, false, false);
                        }
                    }
                });
                this.f8301K = viewAttachHandler;
                viewAttachHandler.listenForAttach(this.f8320z);
            } else {
                throw new IllegalStateException("Controller's onCreateView method returned the parent ViewGroup. Perhaps you forgot to pass false for LayoutInflater.inflate's attachToRoot parameter?");
            }
        } else if (this.f8300J == RetainViewMode.RETAIN_DETACH) {
            m5468g();
        }
        return this.f8320z;
    }

    /* renamed from: g */
    private void m5468g() {
        View findViewById;
        for (C3703a next : this.f8302L) {
            if (!next.mo40555a() && (findViewById = this.f8320z.findViewById(next.mo40773f())) != null && (findViewById instanceof ViewGroup)) {
                next.mo40770a(this, (ViewGroup) findViewById);
                next.rebindIfNeeded();
            }
        }
    }

    /* renamed from: h */
    private void m5469h() {
        if (this.f8308R) {
            for (LifecycleListener preContextUnavailable : new ArrayList(this.f8303M)) {
                preContextUnavailable.preContextUnavailable(this, getActivity());
            }
            this.f8308R = false;
            onContextUnavailable();
            for (LifecycleListener postContextUnavailable : new ArrayList(this.f8303M)) {
                postContextUnavailable.postContextUnavailable(this);
            }
        }
        if (!this.f8313s) {
            for (LifecycleListener preDestroy : new ArrayList(this.f8303M)) {
                preDestroy.preDestroy(this);
            }
            this.f8313s = true;
            onDestroy();
            this.f8291A = null;
            for (LifecycleListener postDestroy : new ArrayList(this.f8303M)) {
                postDestroy.postDestroy(this);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final void mo40608d() {
        m5464c(false);
    }

    /* renamed from: c */
    private void m5464c(boolean z) {
        this.f8312r = true;
        Router router2 = this.f8319y;
        if (router2 != null) {
            router2.mo40549a(this.f8292B);
        }
        for (C3703a b : this.f8302L) {
            b.mo40715b(false);
        }
        if (!this.f8314t) {
            m5467f();
        } else if (z) {
            mo40593a(this.f8320z, true, false);
        }
    }

    /* renamed from: b */
    private void m5460b(View view) {
        this.f8296F = true;
        this.f8309b = new Bundle(getClass().getClassLoader());
        SparseArray sparseArray = new SparseArray();
        view.saveHierarchyState(sparseArray);
        this.f8309b.putSparseParcelableArray(f8289n, sparseArray);
        Bundle bundle = new Bundle(getClass().getClassLoader());
        onSaveViewState(view, bundle);
        this.f8309b.putBundle(f8277a, bundle);
        for (LifecycleListener onSaveViewState : new ArrayList(this.f8303M)) {
            onSaveViewState.onSaveViewState(this, this.f8309b);
        }
    }

    /* renamed from: c */
    private void m5463c(View view) {
        Bundle bundle = this.f8309b;
        if (bundle != null) {
            view.restoreHierarchyState(bundle.getSparseParcelableArray(f8289n));
            Bundle bundle2 = this.f8309b.getBundle(f8277a);
            bundle2.setClassLoader(getClass().getClassLoader());
            onRestoreViewState(view, bundle2);
            m5468g();
            for (LifecycleListener onRestoreViewState : new ArrayList(this.f8303M)) {
                onRestoreViewState.onRestoreViewState(this, this.f8309b);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public final Bundle mo40610e() {
        View view;
        if (!this.f8296F && (view = this.f8320z) != null) {
            m5460b(view);
        }
        Bundle bundle = new Bundle();
        bundle.putString(f8278c, getClass().getName());
        bundle.putBundle(f8279d, this.f8309b);
        bundle.putBundle(f8284i, this.f8310p);
        bundle.putString(f8282g, this.f8292B);
        bundle.putString(f8283h, this.f8293C);
        bundle.putStringArrayList(f8286k, this.f8304N);
        bundle.putBoolean(f8285j, this.f8294D || this.f8314t);
        bundle.putInt(f8290o, this.f8300J.ordinal());
        ControllerChangeHandler controllerChangeHandler = this.f8298H;
        if (controllerChangeHandler != null) {
            bundle.putBundle(f8287l, controllerChangeHandler.mo40698a());
        }
        ControllerChangeHandler controllerChangeHandler2 = this.f8299I;
        if (controllerChangeHandler2 != null) {
            bundle.putBundle(f8288m, controllerChangeHandler2.mo40698a());
        }
        ArrayList arrayList = new ArrayList();
        for (C3703a saveInstanceState : this.f8302L) {
            Bundle bundle2 = new Bundle();
            saveInstanceState.saveInstanceState(bundle2);
            arrayList.add(bundle2);
        }
        bundle.putParcelableArrayList(f8280e, arrayList);
        Bundle bundle3 = new Bundle(getClass().getClassLoader());
        onSaveInstanceState(bundle3);
        for (LifecycleListener onSaveInstanceState : new ArrayList(this.f8303M)) {
            onSaveInstanceState.onSaveInstanceState(this, bundle3);
        }
        bundle.putBundle(f8281f, bundle3);
        return bundle;
    }

    /* renamed from: b */
    private void m5459b(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle(f8279d);
        this.f8309b = bundle2;
        if (bundle2 != null) {
            bundle2.setClassLoader(getClass().getClassLoader());
        }
        this.f8292B = bundle.getString(f8282g);
        this.f8293C = bundle.getString(f8283h);
        this.f8304N.addAll(bundle.getStringArrayList(f8286k));
        this.f8298H = ControllerChangeHandler.fromBundle(bundle.getBundle(f8287l));
        this.f8299I = ControllerChangeHandler.fromBundle(bundle.getBundle(f8288m));
        this.f8294D = bundle.getBoolean(f8285j);
        this.f8300J = RetainViewMode.values()[bundle.getInt(f8290o, 0)];
        for (Bundle restoreInstanceState : bundle.getParcelableArrayList(f8280e)) {
            C3703a aVar = new C3703a();
            aVar.restoreInstanceState(restoreInstanceState);
            this.f8302L.add(aVar);
        }
        Bundle bundle3 = bundle.getBundle(f8281f);
        this.f8311q = bundle3;
        if (bundle3 != null) {
            bundle3.setClassLoader(getClass().getClassLoader());
        }
        m5470i();
    }

    /* renamed from: i */
    private void m5470i() {
        Bundle bundle = this.f8311q;
        if (bundle != null && this.f8319y != null) {
            onRestoreInstanceState(bundle);
            for (LifecycleListener onRestoreInstanceState : new ArrayList(this.f8303M)) {
                onRestoreInstanceState.onRestoreInstanceState(this, this.f8311q);
            }
            this.f8311q = null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo40595a(ControllerChangeHandler controllerChangeHandler, ControllerChangeType controllerChangeType) {
        if (!controllerChangeType.isEnter) {
            this.f8307Q = true;
            for (C3703a a : this.f8302L) {
                a.mo40771a(true);
            }
        }
        onChangeStarted(controllerChangeHandler, controllerChangeType);
        for (LifecycleListener onChangeStart : new ArrayList(this.f8303M)) {
            onChangeStart.onChangeStart(this, controllerChangeHandler, controllerChangeType);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo40602b(ControllerChangeHandler controllerChangeHandler, ControllerChangeType controllerChangeType) {
        WeakReference<View> weakReference;
        if (!controllerChangeType.isEnter) {
            this.f8307Q = false;
            for (C3703a a : this.f8302L) {
                a.mo40771a(false);
            }
        }
        onChangeEnded(controllerChangeHandler, controllerChangeType);
        for (LifecycleListener onChangeEnd : new ArrayList(this.f8303M)) {
            onChangeEnd.onChangeEnd(this, controllerChangeHandler, controllerChangeType);
        }
        if (this.f8312r && !this.f8317w && !this.f8314t && (weakReference = this.f8306P) != null) {
            View view = (View) weakReference.get();
            if (!(this.f8319y.f8332d == null || view == null || view.getParent() != this.f8319y.f8332d)) {
                this.f8319y.f8332d.removeView(view);
            }
            this.f8306P = null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo40603b(boolean z) {
        View view;
        if (this.f8297G != z) {
            this.f8297G = z;
            for (C3703a a : this.f8302L) {
                a.mo40771a(z);
            }
            if (!z && (view = this.f8320z) != null && this.f8318x) {
                mo40593a(view, false, false);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo40592a(Menu menu, MenuInflater menuInflater) {
        if (this.f8314t && this.f8315u && !this.f8316v) {
            onCreateOptionsMenu(menu, menuInflater);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo40591a(Menu menu) {
        if (this.f8314t && this.f8315u && !this.f8316v) {
            onPrepareOptionsMenu(menu);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final boolean mo40599a(MenuItem menuItem) {
        return this.f8314t && this.f8315u && !this.f8316v && onOptionsItemSelected(menuItem);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo40594a(Controller controller) {
        this.f8291A = controller;
    }

    /* renamed from: j */
    private void m5471j() {
        Constructor[] constructors = getClass().getConstructors();
        if (m5458b(constructors) == null && m5453a(constructors) == null) {
            throw new RuntimeException(getClass() + " does not have a constructor that takes a Bundle argument or a default constructor. Controllers must have one of these in order to restore their states.");
        }
    }

    /* renamed from: a */
    private static Constructor m5453a(Constructor[] constructorArr) {
        for (Constructor constructor : constructorArr) {
            if (constructor.getParameterTypes().length == 0) {
                return constructor;
            }
        }
        return null;
    }

    /* renamed from: b */
    private static Constructor m5458b(Constructor[] constructorArr) {
        for (Constructor constructor : constructorArr) {
            if (constructor.getParameterTypes().length == 1 && constructor.getParameterTypes()[0] == Bundle.class) {
                return constructor;
            }
        }
        return null;
    }
}
