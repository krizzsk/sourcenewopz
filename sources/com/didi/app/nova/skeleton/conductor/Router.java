package com.didi.app.nova.skeleton.conductor;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.didi.app.nova.skeleton.conductor.Controller;
import com.didi.app.nova.skeleton.conductor.ControllerChangeHandler;
import com.didi.app.nova.skeleton.conductor.changehandler.SimpleSwapChangeHandler;
import com.didi.app.nova.skeleton.conductor.internal.NoOpControllerChangeHandler;
import com.didi.app.nova.skeleton.conductor.internal.ThreadUtils;
import com.didi.app.nova.skeleton.conductor.internal.TransactionIndexer;
import com.didi.app.nova.skeleton.dialog.DialogFrameLayout;
import com.didi.app.nova.skeleton.dialog.DialogInstrument;
import com.didi.app.nova.skeleton.title.TitleBar;
import com.didi.app.nova.skeleton.tools.TraceUtil;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class Router {

    /* renamed from: g */
    private static final String f8327g = "Router.backstack";

    /* renamed from: h */
    private static final String f8328h = "Router.popsLastView";

    /* renamed from: a */
    final Backstack f8329a = new Backstack();

    /* renamed from: b */
    final List<Controller> f8330b = new ArrayList();

    /* renamed from: c */
    boolean f8331c = false;

    /* renamed from: d */
    ViewGroup f8332d;

    /* renamed from: e */
    TitleBar f8333e;

    /* renamed from: f */
    DialogInstrument f8334f;

    /* renamed from: i */
    private final List<ControllerChangeHandler.ControllerChangeListener> f8335i = new ArrayList();

    /* renamed from: j */
    private final List<ControllerChangeHandler.ChangeTransaction> f8336j = new ArrayList();

    /* renamed from: k */
    private boolean f8337k = false;

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract void mo40548a(Intent intent);

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract void mo40549a(String str);

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract void mo40550a(String str, int i);

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract void mo40551a(String str, Intent intent, int i);

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract void mo40552a(String str, Intent intent, int i, Bundle bundle);

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract void mo40553a(String str, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException;

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract void mo40554a(String str, String[] strArr);

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract boolean mo40555a();

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public abstract List<Router> mo40556b();

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public abstract Router mo40557c();

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public abstract TransactionIndexer mo40558d();

    public abstract Activity getActivity();

    public abstract Fragment getFragment();

    /* access modifiers changed from: package-private */
    public abstract void invalidateOptionsMenu();

    public abstract void onActivityResult(int i, int i2, Intent intent);

    public TitleBar getTitleBar() {
        if (this == mo40557c()) {
            return this.f8333e;
        }
        return mo40557c().getTitleBar();
    }

    public void attachTitleBar(TitleBar titleBar) {
        if (this == mo40557c()) {
            this.f8333e = titleBar;
            return;
        }
        throw new UnsupportedOperationException("Un support attach title bar into sub router.");
    }

    public DialogInstrument getDialogInstrument() {
        if (mo40557c() == this) {
            return this.f8334f;
        }
        return mo40557c().getDialogInstrument();
    }

    public void attachDialogFrame(DialogFrameLayout dialogFrameLayout) {
        if (this == mo40557c()) {
            dialogFrameLayout.removeAllViews();
            this.f8334f = new DialogInstrument(dialogFrameLayout);
            return;
        }
        throw new UnsupportedOperationException("Un support attach Dialog frame into sub router.");
    }

    public void onRequestPermissionsResult(String str, int i, String[] strArr, int[] iArr) {
        Controller controllerWithInstanceId = getControllerWithInstanceId(str);
        if (controllerWithInstanceId != null) {
            controllerWithInstanceId.mo40589a(i, strArr, iArr);
        }
    }

    public boolean handleBack() {
        ThreadUtils.ensureMainThread();
        if (this.f8329a.mo40571a()) {
            return false;
        }
        if (!this.f8329a.mo40580f().f8345a.handleBack() && !popCurrentController()) {
            return false;
        }
        return true;
    }

    public boolean popCurrentController() {
        ThreadUtils.ensureMainThread();
        RouterTransaction f = this.f8329a.mo40580f();
        if (f != null) {
            return popController(f.f8345a);
        }
        TraceUtil.trace("Conductor#Router", "Trying to pop the current controller when there are none on the backstack.");
        return false;
    }

    public boolean popController(Controller controller) {
        ThreadUtils.ensureMainThread();
        RouterTransaction f = this.f8329a.mo40580f();
        if (!(f != null && f.f8345a == controller)) {
            Iterator<RouterTransaction> it = this.f8329a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                RouterTransaction next = it.next();
                if (next.f8345a == controller) {
                    next.f8345a.mo40608d();
                    it.remove();
                    break;
                }
            }
        } else {
            m5509a(this.f8329a.mo40579e());
            m5511a(this.f8329a.mo40580f(), f, false);
        }
        if (!this.f8337k) {
            return !this.f8329a.mo40571a();
        }
        if (f != null) {
            return true;
        }
        return false;
    }

    public void pushController(RouterTransaction routerTransaction) {
        ThreadUtils.ensureMainThread();
        if (this.f8332d != null) {
            RouterTransaction f = this.f8329a.mo40580f();
            pushToBackstack(routerTransaction);
            m5511a(routerTransaction, f, true);
        }
    }

    public void replaceTopController(RouterTransaction routerTransaction) {
        ThreadUtils.ensureMainThread();
        RouterTransaction f = this.f8329a.mo40580f();
        if (!this.f8329a.mo40571a()) {
            m5509a(this.f8329a.mo40579e());
        }
        ControllerChangeHandler pushChangeHandler = routerTransaction.pushChangeHandler();
        if (f != null) {
            boolean z = false;
            boolean z2 = f.pushChangeHandler() == null || f.pushChangeHandler().removesFromViewOnPush();
            if (pushChangeHandler == null || pushChangeHandler.removesFromViewOnPush()) {
                z = true;
            }
            if (!z2 && z) {
                for (RouterTransaction a : m5505a(this.f8329a.iterator())) {
                    m5512a((RouterTransaction) null, a, true, pushChangeHandler);
                }
            }
        }
        pushToBackstack(routerTransaction);
        if (pushChangeHandler != null) {
            pushChangeHandler.setForceRemoveViewOnPush(true);
        }
        m5511a(routerTransaction.pushChangeHandler(pushChangeHandler), f, true);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo40715b(boolean z) {
        this.f8337k = true;
        final List<RouterTransaction> g = this.f8329a.mo40581g();
        m5513a(g);
        if (z && g.size() > 0) {
            RouterTransaction routerTransaction = g.get(0);
            routerTransaction.controller().addLifecycleListener(new Controller.LifecycleListener() {
                public void onChangeEnd(Controller controller, ControllerChangeHandler controllerChangeHandler, ControllerChangeType controllerChangeType) {
                    if (controllerChangeType == ControllerChangeType.POP_EXIT) {
                        for (int size = g.size() - 1; size > 0; size--) {
                            Router.this.m5512a((RouterTransaction) null, (RouterTransaction) g.get(size), true, (ControllerChangeHandler) new SimpleSwapChangeHandler());
                        }
                    }
                }
            });
            m5512a((RouterTransaction) null, routerTransaction, false, routerTransaction.popChangeHandler());
        }
    }

    public int getContainerId() {
        ViewGroup viewGroup = this.f8332d;
        if (viewGroup != null) {
            return viewGroup.getId();
        }
        return 0;
    }

    public Router setPopsLastView(boolean z) {
        this.f8337k = z;
        return this;
    }

    public boolean popToRoot() {
        ThreadUtils.ensureMainThread();
        return popToRoot((ControllerChangeHandler) null);
    }

    public boolean popToRoot(ControllerChangeHandler controllerChangeHandler) {
        ThreadUtils.ensureMainThread();
        if (this.f8329a.mo40572b() <= 1) {
            return false;
        }
        m5510a(this.f8329a.mo40575c(), controllerChangeHandler);
        return true;
    }

    public boolean popToTag(String str) {
        ThreadUtils.ensureMainThread();
        return popToTag(str, (ControllerChangeHandler) null);
    }

    public boolean popToTag(String str, ControllerChangeHandler controllerChangeHandler) {
        ThreadUtils.ensureMainThread();
        Iterator<RouterTransaction> it = this.f8329a.iterator();
        while (it.hasNext()) {
            RouterTransaction next = it.next();
            if (str.equals(next.tag())) {
                m5510a(next, controllerChangeHandler);
                return true;
            }
        }
        return false;
    }

    public boolean popToPageName(String str) {
        ThreadUtils.ensureMainThread();
        Iterator<RouterTransaction> it = this.f8329a.iterator();
        while (it.hasNext()) {
            RouterTransaction next = it.next();
            if (str.equals(next.pageName())) {
                m5510a(next, (ControllerChangeHandler) null);
                return true;
            }
        }
        return false;
    }

    public void setRoot(RouterTransaction routerTransaction) {
        ThreadUtils.ensureMainThread();
        if (this.f8332d != null) {
            setBackstack(Collections.singletonList(routerTransaction), routerTransaction.pushChangeHandler());
        }
    }

    public Controller getControllerWithInstanceId(String str) {
        Iterator<RouterTransaction> it = this.f8329a.iterator();
        while (it.hasNext()) {
            Controller a = it.next().f8345a.mo40587a(str);
            if (a != null) {
                return a;
            }
        }
        return null;
    }

    public Controller getControllerWithTag(String str) {
        Iterator<RouterTransaction> it = this.f8329a.iterator();
        while (it.hasNext()) {
            RouterTransaction next = it.next();
            if (str.equals(next.tag())) {
                return next.f8345a;
            }
        }
        return null;
    }

    public Controller getControllerWithPageName(String str) {
        Iterator<RouterTransaction> it = this.f8329a.iterator();
        while (it.hasNext()) {
            RouterTransaction next = it.next();
            if (str.equals(next.pageName())) {
                return next.f8345a;
            }
        }
        return null;
    }

    public int getBackstackSize() {
        return this.f8329a.mo40572b();
    }

    public List<RouterTransaction> getBackstack() {
        ArrayList arrayList = new ArrayList();
        Iterator<RouterTransaction> d = this.f8329a.mo40577d();
        while (d.hasNext()) {
            arrayList.add(d.next());
        }
        return arrayList;
    }

    public void setBackstack(List<RouterTransaction> list, ControllerChangeHandler controllerChangeHandler) {
        ThreadUtils.ensureMainThread();
        List<RouterTransaction> backstack = getBackstack();
        List<RouterTransaction> a = m5505a(this.f8329a.iterator());
        mo40772e();
        m5515b(list);
        this.f8329a.mo40570a(list);
        Iterator<RouterTransaction> it = this.f8329a.iterator();
        while (it.hasNext()) {
            RouterTransaction next = it.next();
            next.mo40758a();
            mo40711a(next.f8345a);
        }
        if (list.size() > 0) {
            ArrayList arrayList = new ArrayList(list);
            Collections.reverse(arrayList);
            List<RouterTransaction> a2 = m5505a((Iterator<RouterTransaction>) arrayList.iterator());
            boolean z = a2.size() <= 0 || !backstack.contains(a2.get(0));
            if (!m5514a(a2, a)) {
                RouterTransaction routerTransaction = a.size() > 0 ? a.get(0) : null;
                RouterTransaction routerTransaction2 = a2.get(0);
                if (routerTransaction == null || routerTransaction.f8345a != routerTransaction2.f8345a) {
                    if (routerTransaction != null) {
                        ControllerChangeHandler.m5501a(routerTransaction.f8345a.getInstanceId());
                    }
                    m5512a(routerTransaction2, routerTransaction, z, controllerChangeHandler);
                }
                for (int size = a.size() - 1; size > 0; size--) {
                    RouterTransaction routerTransaction3 = a.get(size);
                    if (!a2.contains(routerTransaction3)) {
                        ControllerChangeHandler copy = controllerChangeHandler != null ? controllerChangeHandler.copy() : new SimpleSwapChangeHandler();
                        copy.setForceRemoveViewOnPush(true);
                        ControllerChangeHandler.m5501a(routerTransaction3.f8345a.getInstanceId());
                        m5512a((RouterTransaction) null, routerTransaction3, z, copy);
                    }
                }
                for (int i = 1; i < a2.size(); i++) {
                    RouterTransaction routerTransaction4 = a2.get(i);
                    if (!a.contains(routerTransaction4)) {
                        m5512a(routerTransaction4, a2.get(i - 1), true, routerTransaction4.pushChangeHandler());
                    }
                }
            }
        }
    }

    public boolean hasRootController() {
        return getBackstackSize() > 0;
    }

    public void addChangeListener(ControllerChangeHandler.ControllerChangeListener controllerChangeListener) {
        if (!this.f8335i.contains(controllerChangeListener)) {
            this.f8335i.add(controllerChangeListener);
        }
    }

    public void removeChangeListener(ControllerChangeHandler.ControllerChangeListener controllerChangeListener) {
        this.f8335i.remove(controllerChangeListener);
    }

    public void rebindIfNeeded() {
        ThreadUtils.ensureMainThread();
        Iterator<RouterTransaction> d = this.f8329a.mo40577d();
        while (d.hasNext()) {
            RouterTransaction next = d.next();
            if (next.f8345a.mo40604b()) {
                m5512a(next, (RouterTransaction) null, true, (ControllerChangeHandler) new SimpleSwapChangeHandler(false));
            }
        }
    }

    public final void onActivityResult(String str, int i, int i2, Intent intent) {
        Controller controllerWithInstanceId = getControllerWithInstanceId(str);
        if (controllerWithInstanceId != null) {
            controllerWithInstanceId.onActivityResult(i, i2, intent);
        }
    }

    public final void onActivityStarted(Activity activity) {
        DialogInstrument dialogInstrument = this.f8334f;
        if (dialogInstrument != null) {
            dialogInstrument.onActivityStart();
        }
        Iterator<RouterTransaction> it = this.f8329a.iterator();
        while (it.hasNext()) {
            RouterTransaction next = it.next();
            next.f8345a.mo40590a(activity);
            for (Router onActivityStarted : next.f8345a.getChildRouters()) {
                onActivityStarted.onActivityStarted(activity);
            }
        }
    }

    public final void onActivityResumed(Activity activity) {
        Iterator<RouterTransaction> it = this.f8329a.iterator();
        while (it.hasNext()) {
            RouterTransaction next = it.next();
            next.f8345a.mo40601b(activity);
            for (Router onActivityResumed : next.f8345a.getChildRouters()) {
                onActivityResumed.onActivityResumed(activity);
            }
        }
    }

    public final void onActivityPaused(Activity activity) {
        Iterator<RouterTransaction> it = this.f8329a.iterator();
        while (it.hasNext()) {
            RouterTransaction next = it.next();
            next.f8345a.mo40607c(activity);
            for (Router onActivityPaused : next.f8345a.getChildRouters()) {
                onActivityPaused.onActivityPaused(activity);
            }
        }
    }

    public final void onActivityStopped(Activity activity) {
        DialogInstrument dialogInstrument = this.f8334f;
        if (dialogInstrument != null) {
            dialogInstrument.onActivityStop();
        }
        Iterator<RouterTransaction> it = this.f8329a.iterator();
        while (it.hasNext()) {
            RouterTransaction next = it.next();
            next.f8345a.mo40609d(activity);
            for (Router onActivityStopped : next.f8345a.getChildRouters()) {
                onActivityStopped.onActivityStopped(activity);
            }
        }
    }

    public void onActivityDestroyed(Activity activity) {
        DialogInstrument dialogInstrument = this.f8334f;
        if (dialogInstrument != null) {
            dialogInstrument.onActivityDestroy();
        }
        mo40729j();
        this.f8335i.clear();
        this.f8336j.clear();
        Iterator<RouterTransaction> it = this.f8329a.iterator();
        while (it.hasNext()) {
            RouterTransaction next = it.next();
            next.f8345a.mo40611e(activity);
            for (Router onActivityDestroyed : next.f8345a.getChildRouters()) {
                onActivityDestroyed.onActivityDestroyed(activity);
            }
        }
        for (int size = this.f8330b.size() - 1; size >= 0; size--) {
            Controller controller = this.f8330b.get(size);
            controller.mo40611e(activity);
            for (Router onActivityDestroyed2 : controller.getChildRouters()) {
                onActivityDestroyed2.onActivityDestroyed(activity);
            }
        }
        this.f8329a.mo40581g();
        this.f8332d = null;
        this.f8333e = null;
        this.f8334f = null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public void mo40724h() {
        Iterator<RouterTransaction> it = this.f8329a.iterator();
        while (it.hasNext()) {
            RouterTransaction next = it.next();
            if (ControllerChangeHandler.m5501a(next.f8345a.getInstanceId())) {
                next.f8345a.mo40598a(true);
            }
            next.f8345a.mo40588a();
        }
    }

    public void saveInstanceState(Bundle bundle) {
        mo40724h();
        Bundle bundle2 = new Bundle();
        this.f8329a.mo40569a(bundle2);
        bundle.putParcelable(f8327g, bundle2);
        bundle.putBoolean(f8328h, this.f8337k);
    }

    public void restoreInstanceState(Bundle bundle) {
        this.f8329a.mo40573b((Bundle) bundle.getParcelable(f8327g));
        this.f8337k = bundle.getBoolean(f8328h);
        Iterator<RouterTransaction> d = this.f8329a.mo40577d();
        while (d.hasNext()) {
            mo40711a(d.next().f8345a);
        }
    }

    public final void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        Iterator<RouterTransaction> it = this.f8329a.iterator();
        while (it.hasNext()) {
            RouterTransaction next = it.next();
            next.f8345a.mo40592a(menu, menuInflater);
            for (Router onCreateOptionsMenu : next.f8345a.getChildRouters()) {
                onCreateOptionsMenu.onCreateOptionsMenu(menu, menuInflater);
            }
        }
    }

    public final void onPrepareOptionsMenu(Menu menu) {
        Iterator<RouterTransaction> it = this.f8329a.iterator();
        while (it.hasNext()) {
            RouterTransaction next = it.next();
            next.f8345a.mo40591a(menu);
            for (Router onPrepareOptionsMenu : next.f8345a.getChildRouters()) {
                onPrepareOptionsMenu.onPrepareOptionsMenu(menu);
            }
        }
    }

    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        Iterator<RouterTransaction> it = this.f8329a.iterator();
        while (it.hasNext()) {
            RouterTransaction next = it.next();
            if (next.f8345a.mo40599a(menuItem)) {
                return true;
            }
            Iterator<Router> it2 = next.f8345a.getChildRouters().iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (it2.next().onOptionsItemSelected(menuItem)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    private void m5510a(RouterTransaction routerTransaction, ControllerChangeHandler controllerChangeHandler) {
        StringBuilder sb = new StringBuilder("Router#popToTransaction");
        sb.append("[controller=");
        sb.append(routerTransaction.f8345a);
        if (this.f8329a.mo40572b() > 0) {
            sb.append(", backstack=[");
            RouterTransaction f = this.f8329a.mo40580f();
            ArrayList arrayList = new ArrayList();
            Iterator<RouterTransaction> d = this.f8329a.mo40577d();
            while (d.hasNext()) {
                RouterTransaction next = d.next();
                arrayList.add(next);
                sb.append(next.f8345a);
                sb.append(", ");
                if (next == routerTransaction) {
                    break;
                }
            }
            if (controllerChangeHandler == null) {
                controllerChangeHandler = f.popChangeHandler();
            }
            sb.append(f);
            sb.append(Const.jaRight);
            setBackstack(arrayList, controllerChangeHandler);
        }
        sb.append(Const.jaRight);
        TraceUtil.trace("[Conductor]", sb.toString());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public void mo40728i() {
        this.f8332d.post(new Runnable() {
            public void run() {
                Router.this.f8331c = true;
            }
        });
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public void mo40729j() {
        this.f8331c = false;
        ViewGroup viewGroup = this.f8332d;
        if (viewGroup != null) {
            viewGroup.setOnHierarchyChangeListener((ViewGroup.OnHierarchyChangeListener) null);
        }
    }

    /* access modifiers changed from: package-private */
    public void onContextAvailable() {
        Iterator<RouterTransaction> it = this.f8329a.iterator();
        while (it.hasNext()) {
            it.next().f8345a.mo40606c();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public final List<Controller> mo40730k() {
        ArrayList arrayList = new ArrayList();
        Iterator<RouterTransaction> d = this.f8329a.mo40577d();
        while (d.hasNext()) {
            arrayList.add(d.next().f8345a);
        }
        return arrayList;
    }

    public final Boolean handleRequestedPermission(String str) {
        Iterator<RouterTransaction> it = this.f8329a.iterator();
        while (it.hasNext()) {
            RouterTransaction next = it.next();
            if (next.f8345a.mo40605b(str)) {
                return Boolean.valueOf(next.f8345a.shouldShowRequestPermissionRationale(str));
            }
        }
        return null;
    }

    /* renamed from: a */
    private void m5511a(RouterTransaction routerTransaction, RouterTransaction routerTransaction2, boolean z) {
        ControllerChangeHandler controllerChangeHandler;
        if (z && routerTransaction != null) {
            routerTransaction.mo40758a();
        }
        if (z) {
            controllerChangeHandler = routerTransaction.pushChangeHandler();
        } else {
            controllerChangeHandler = routerTransaction2 != null ? routerTransaction2.popChangeHandler() : null;
        }
        m5512a(routerTransaction, routerTransaction2, z, controllerChangeHandler);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m5512a(RouterTransaction routerTransaction, RouterTransaction routerTransaction2, boolean z, ControllerChangeHandler controllerChangeHandler) {
        boolean z2;
        Controller controller = null;
        Controller controller2 = routerTransaction != null ? routerTransaction.f8345a : null;
        if (routerTransaction2 != null) {
            controller = routerTransaction2.f8345a;
        }
        if (routerTransaction != null) {
            routerTransaction.mo40759a(mo40558d());
            mo40711a(controller2);
        } else if (this.f8329a.mo40572b() == 0 && !this.f8337k) {
            controllerChangeHandler = new NoOpControllerChangeHandler();
            z2 = true;
            m5506a(controller2, controller, z, controllerChangeHandler);
            if (z2 && controller != null && controller.getView() != null) {
                controller.mo40593a(controller.getView(), true, false);
                return;
            }
            return;
        }
        z2 = false;
        m5506a(controller2, controller, z, controllerChangeHandler);
        if (z2) {
        }
    }

    /* renamed from: a */
    private void m5506a(Controller controller, Controller controller2, boolean z, ControllerChangeHandler controllerChangeHandler) {
        if (!z || controller == null || !controller.isDestroyed()) {
            ControllerChangeHandler.ChangeTransaction changeTransaction = new ControllerChangeHandler.ChangeTransaction(controller, controller2, z, this.f8332d, controllerChangeHandler, new ArrayList(this.f8335i));
            if (this.f8336j.size() > 0) {
                this.f8336j.add(changeTransaction);
            } else if (controller2 == null || ((controllerChangeHandler != null && !controllerChangeHandler.removesFromViewOnPush()) || this.f8331c)) {
                ControllerChangeHandler.m5499a(changeTransaction);
            } else {
                this.f8336j.add(changeTransaction);
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public void run() {
                        Router.this.mo40731l();
                    }
                });
            }
        } else {
            throw new IllegalStateException("Trying to push a controller that has already been destroyed. (" + controller.getClass().getSimpleName() + ")");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public void mo40731l() {
        for (int i = 0; i < this.f8336j.size(); i++) {
            ControllerChangeHandler.ChangeTransaction changeTransaction = this.f8336j.get(i);
            if (changeTransaction.f8326to == null || (!changeTransaction.f8326to.isBeingDestroyed() && !changeTransaction.f8326to.isDestroyed())) {
                ControllerChangeHandler.m5499a(changeTransaction);
            }
        }
        this.f8336j.clear();
    }

    /* access modifiers changed from: protected */
    public void pushToBackstack(RouterTransaction routerTransaction) {
        this.f8329a.mo40576c(routerTransaction);
    }

    /* renamed from: a */
    private void m5509a(RouterTransaction routerTransaction) {
        if (!routerTransaction.f8345a.isDestroyed()) {
            this.f8330b.add(routerTransaction.f8345a);
            routerTransaction.f8345a.addLifecycleListener(new Controller.LifecycleListener() {
                public void postDestroy(Controller controller) {
                    Router.this.f8330b.remove(controller);
                }
            });
        }
    }

    /* renamed from: a */
    private void m5513a(List<RouterTransaction> list) {
        for (RouterTransaction a : list) {
            m5509a(a);
        }
    }

    /* renamed from: e */
    private void mo40772e() {
        ArrayList arrayList = new ArrayList();
        for (RouterTransaction next : m5505a(this.f8329a.iterator())) {
            if (next.f8345a.getView() != null) {
                arrayList.add(next.f8345a.getView());
            }
        }
        for (Router next2 : mo40556b()) {
            if (next2.f8332d == this.f8332d) {
                m5508a(next2, (List<View>) arrayList);
            }
        }
        ViewGroup viewGroup = this.f8332d;
        for (int childCount = (viewGroup == null ? 0 : viewGroup.getChildCount()) - 1; childCount >= 0; childCount--) {
            View childAt = this.f8332d.getChildAt(childCount);
            if (!arrayList.contains(childAt)) {
                this.f8332d.removeView(childAt);
            }
        }
    }

    /* renamed from: b */
    private void m5515b(List<RouterTransaction> list) {
        ArrayList arrayList = new ArrayList();
        for (RouterTransaction next : list) {
            next.mo40759a(mo40558d());
            arrayList.add(Integer.valueOf(next.f8346b));
        }
        Collections.sort(arrayList);
        for (int i = 0; i < list.size(); i++) {
            list.get(i).f8346b = ((Integer) arrayList.get(i)).intValue();
        }
    }

    /* renamed from: a */
    private void m5508a(Router router2, List<View> list) {
        for (Controller next : router2.mo40730k()) {
            if (next.getView() != null) {
                list.add(next.getView());
            }
            for (Router a : next.getChildRouters()) {
                m5508a(a, list);
            }
        }
    }

    /* renamed from: a */
    private List<RouterTransaction> m5505a(Iterator<RouterTransaction> it) {
        ArrayList arrayList = new ArrayList();
        while (it.hasNext()) {
            RouterTransaction next = it.next();
            arrayList.add(next);
            if (next.pushChangeHandler() != null) {
                if (next.pushChangeHandler().removesFromViewOnPush()) {
                    break;
                }
            } else {
                break;
            }
        }
        Collections.reverse(arrayList);
        return arrayList;
    }

    /* renamed from: a */
    private boolean m5514a(List<RouterTransaction> list, List<RouterTransaction> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list2.size(); i++) {
            if (list2.get(i).controller() != list.get(i).controller()) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo40711a(Controller controller) {
        controller.mo40596a(this);
        controller.mo40606c();
    }
}
