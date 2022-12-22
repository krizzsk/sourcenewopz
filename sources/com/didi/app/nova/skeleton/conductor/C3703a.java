package com.didi.app.nova.skeleton.conductor;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.didi.app.nova.skeleton.conductor.ControllerChangeHandler;
import com.didi.app.nova.skeleton.conductor.internal.TransactionIndexer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.didi.app.nova.skeleton.conductor.a */
/* compiled from: ControllerHostedRouter */
class C3703a extends Router {

    /* renamed from: g */
    private final String f8352g = "ControllerHostedRouter.hostId";

    /* renamed from: h */
    private final String f8353h = "ControllerHostedRouter.tag";

    /* renamed from: i */
    private Controller f8354i;

    /* renamed from: j */
    private int f8355j;

    /* renamed from: k */
    private String f8356k;

    /* renamed from: l */
    private boolean f8357l;

    C3703a() {
    }

    C3703a(int i, String str) {
        this.f8355j = i;
        this.f8356k = str;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo40770a(Controller controller, ViewGroup viewGroup) {
        if (this.f8354i != controller || this.f8332d != viewGroup) {
            mo40772e();
            if (viewGroup instanceof ControllerChangeHandler.ControllerChangeListener) {
                addChangeListener((ControllerChangeHandler.ControllerChangeListener) viewGroup);
            }
            this.f8354i = controller;
            this.f8332d = viewGroup;
            Iterator<RouterTransaction> it = this.f8329a.iterator();
            while (it.hasNext()) {
                it.next().f8345a.mo40594a(controller);
            }
            mo40728i();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public final void mo40772e() {
        if (this.f8332d != null && (this.f8332d instanceof ControllerChangeHandler.ControllerChangeListener)) {
            removeChangeListener((ControllerChangeHandler.ControllerChangeListener) this.f8332d);
        }
        for (Controller controller : new ArrayList(this.f8330b)) {
            if (controller.getView() != null) {
                controller.mo40593a(controller.getView(), true, false);
            }
        }
        Iterator<RouterTransaction> it = this.f8329a.iterator();
        while (it.hasNext()) {
            RouterTransaction next = it.next();
            if (next.f8345a.getView() != null) {
                next.f8345a.mo40593a(next.f8345a.getView(), true, false);
            }
        }
        mo40729j();
        this.f8354i = null;
        this.f8332d = null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo40771a(boolean z) {
        this.f8357l = z;
        Iterator<RouterTransaction> it = this.f8329a.iterator();
        while (it.hasNext()) {
            it.next().f8345a.mo40603b(z);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo40715b(boolean z) {
        mo40771a(false);
        super.mo40715b(z);
    }

    /* access modifiers changed from: protected */
    public void pushToBackstack(RouterTransaction routerTransaction) {
        if (this.f8357l) {
            routerTransaction.f8345a.mo40603b(true);
        }
        super.pushToBackstack(routerTransaction);
    }

    public void setBackstack(List<RouterTransaction> list, ControllerChangeHandler controllerChangeHandler) {
        if (this.f8357l) {
            for (RouterTransaction routerTransaction : list) {
                routerTransaction.f8345a.mo40603b(true);
            }
        }
        super.setBackstack(list, controllerChangeHandler);
    }

    public Activity getActivity() {
        Controller controller = this.f8354i;
        if (controller != null) {
            return controller.getActivity();
        }
        return null;
    }

    public Fragment getFragment() {
        Controller controller = this.f8354i;
        if (controller == null || controller.getRouter() == null) {
            return null;
        }
        this.f8354i.getRouter().getFragment();
        return null;
    }

    public void onActivityDestroyed(Activity activity) {
        super.onActivityDestroyed(activity);
        mo40772e();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        Controller controller = this.f8354i;
        if (controller != null && controller.getRouter() != null) {
            this.f8354i.getRouter().onActivityResult(i, i2, intent);
        }
    }

    public void invalidateOptionsMenu() {
        Controller controller = this.f8354i;
        if (controller != null && controller.getRouter() != null) {
            this.f8354i.getRouter().invalidateOptionsMenu();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo40548a(Intent intent) {
        Controller controller = this.f8354i;
        if (controller != null && controller.getRouter() != null) {
            this.f8354i.getRouter().mo40548a(intent);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo40551a(String str, Intent intent, int i) {
        Controller controller = this.f8354i;
        if (controller != null && controller.getRouter() != null) {
            this.f8354i.getRouter().mo40551a(str, intent, i);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo40552a(String str, Intent intent, int i, Bundle bundle) {
        Controller controller = this.f8354i;
        if (controller != null && controller.getRouter() != null) {
            this.f8354i.getRouter().mo40552a(str, intent, i, bundle);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo40553a(String str, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
        Controller controller = this.f8354i;
        if (controller != null && controller.getRouter() != null) {
            this.f8354i.getRouter().mo40553a(str, intentSender, i, intent, i2, i3, i4, bundle);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo40550a(String str, int i) {
        Controller controller = this.f8354i;
        if (controller != null && controller.getRouter() != null) {
            this.f8354i.getRouter().mo40550a(str, i);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo40549a(String str) {
        Controller controller = this.f8354i;
        if (controller != null && controller.getRouter() != null) {
            this.f8354i.getRouter().mo40549a(str);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo40554a(String str, String[] strArr) {
        Controller controller = this.f8354i;
        if (controller != null && controller.getRouter() != null) {
            this.f8354i.getRouter().mo40554a(str, strArr);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo40555a() {
        return this.f8354i != null;
    }

    public void saveInstanceState(Bundle bundle) {
        super.saveInstanceState(bundle);
        bundle.putInt("ControllerHostedRouter.hostId", this.f8355j);
        bundle.putString("ControllerHostedRouter.tag", this.f8356k);
    }

    public void restoreInstanceState(Bundle bundle) {
        super.restoreInstanceState(bundle);
        this.f8355j = bundle.getInt("ControllerHostedRouter.hostId");
        this.f8356k = bundle.getString("ControllerHostedRouter.tag");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo40711a(Controller controller) {
        super.mo40711a(controller);
        controller.mo40594a(this.f8354i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public int mo40773f() {
        return this.f8355j;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public String mo40774g() {
        return this.f8356k;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public List<Router> mo40556b() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f8354i.getChildRouters());
        arrayList.addAll(this.f8354i.getRouter().mo40556b());
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public Router mo40557c() {
        Controller controller = this.f8354i;
        return (controller == null || controller.getRouter() == null) ? this : this.f8354i.getRouter().mo40557c();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public TransactionIndexer mo40558d() {
        return mo40557c().mo40558d();
    }
}
