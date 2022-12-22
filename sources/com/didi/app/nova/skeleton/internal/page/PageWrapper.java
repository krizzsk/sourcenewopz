package com.didi.app.nova.skeleton.internal.page;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.didi.app.nova.skeleton.AbstractPage;
import com.didi.app.nova.skeleton.Component;
import com.didi.app.nova.skeleton.ComponentGroup;
import com.didi.app.nova.skeleton.IScopeLifecycle;
import com.didi.app.nova.skeleton.Page;
import com.didi.app.nova.skeleton.PageInstrument;
import com.didi.app.nova.skeleton.PageInstrumentFactory;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.ScopeContextBase;
import com.didi.app.nova.skeleton.Skeleton;
import com.didi.app.nova.skeleton.conductor.Controller;
import com.didi.app.nova.skeleton.conductor.ControllerChangeHandler;
import com.didi.app.nova.skeleton.conductor.ControllerChangeType;
import com.didi.app.nova.skeleton.conductor.Router;
import com.didi.app.nova.skeleton.conductor.changehandler.HorizontalChangeHandler;
import com.didi.app.nova.skeleton.dialog.Dialog;
import com.didi.app.nova.skeleton.internal.ScopeContextPageImpl;
import com.didi.app.nova.skeleton.title.Attr;
import com.didi.app.nova.skeleton.title.TitleAttr;
import com.didi.app.nova.skeleton.title.TitleBar;
import com.didi.app.nova.skeleton.title.TitleBarAttr;
import com.didi.app.nova.skeleton.tools.TraceUtil;
import com.didichuxing.sofa.permission.PermissionRequest;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public abstract class PageWrapper extends AbstractPage {
    public static final int Created = 2;
    public static final int Destroyed = 7;
    public static final int FLAG_PAGE_CLEAR_TOP = 4352;
    public static final int FLAG_PAGE_STANDARD = 4096;
    public static final int Finalized = 8;
    public static final int Initialized = 1;
    public static final int Paused = 5;
    public static final int Resumed = 4;
    public static final int Started = 3;
    public static final int Stopped = 6;
    public static final int Unknown = 0;
    private Bundle args = new Bundle();
    public Controller controller;
    final Controller.LifecycleListener controllerListener = new Controller.LifecycleListener() {
        public void postCreateView(Controller controller, View view) {
            for (IScopeLifecycle onCreate : new ArrayList(PageWrapper.this.mScopeLifecycles)) {
                onCreate.onCreate(PageWrapper.this);
            }
            PageWrapper.this.onPostCreate();
        }

        public void postAttach(Controller controller, View view) {
            for (IScopeLifecycle onStart : new ArrayList(PageWrapper.this.mScopeLifecycles)) {
                onStart.onStart(PageWrapper.this);
            }
            PageWrapper.this.onPostStart();
        }

        public void postDetach(Controller controller, View view) {
            for (IScopeLifecycle onStop : new ArrayList(PageWrapper.this.mScopeLifecycles)) {
                onStop.onStop(PageWrapper.this);
            }
            PageWrapper.this.onPostStop();
        }

        public void postDestroyView(Controller controller) {
            for (IScopeLifecycle onDestroy : new ArrayList(PageWrapper.this.mScopeLifecycles)) {
                onDestroy.onDestroy(PageWrapper.this);
            }
            PageWrapper.this.onPostDestroy();
        }
    };
    private WeakReference<PageWrapper> fromPage;
    private Handler handler = new Handler(Looper.getMainLooper());
    private int lifeSteps = 0;
    private ComponentGroup mComponentGroup = new ComponentGroup();
    private ScopeContextBase mScopeContext;
    /* access modifiers changed from: private */
    public List<IScopeLifecycle> mScopeLifecycles = new ArrayList();
    PageInstrument pageInstrument;
    private PageTitleBarProxy titleBarProxy = new PageTitleBarProxy();

    /* access modifiers changed from: protected */
    public String getTitle() {
        return null;
    }

    public abstract View onInflateView(LayoutInflater layoutInflater, ViewGroup viewGroup);

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return false;
    }

    public void onPageResult(Bundle bundle) {
    }

    public void onPermissionDenied(String[] strArr) {
    }

    public void onPermissionGranted() {
    }

    /* access modifiers changed from: protected */
    public void onPostDestroy() {
    }

    /* access modifiers changed from: protected */
    public void onPostStart() {
    }

    /* access modifiers changed from: protected */
    public void onPostStop() {
    }

    /* access modifiers changed from: protected */
    public String overrideTitle() {
        return null;
    }

    public boolean showPermissionExplanation(PermissionRequest permissionRequest) {
        return false;
    }

    public PageWrapper() {
    }

    public PageWrapper(Bundle bundle) {
        super((Bundle) null);
        if (bundle != null) {
            this.args.putAll(bundle);
        }
    }

    /* access modifiers changed from: package-private */
    public final void attach(Context context, PageInstrument pageInstrument2, ControllerProxy controllerProxy) {
        attachBaseContext(context);
        this.pageInstrument = pageInstrument2;
        this.controller = controllerProxy;
        controllerProxy.addLifecycleListener(this.controllerListener);
        onInitialize();
    }

    public void onInitialize() {
        this.lifeSteps = 1;
        setFlags(4096);
        ScopeContextBase onCreateScopeContext = onCreateScopeContext();
        this.mScopeContext = onCreateScopeContext;
        addLifecycleCallback(onCreateScopeContext);
        addLifecycleCallback(this.mComponentGroup);
        String alias = alias();
        TraceUtil.trace(alias, this + " onInitialize end ");
    }

    /* access modifiers changed from: protected */
    public ScopeContextBase onCreateScopeContext() {
        return new ScopeContextPageImpl(this);
    }

    public void onCreate(View view) {
        this.lifeSteps = 2;
        String alias = alias();
        TraceUtil.trace(alias, this + " onCreate");
    }

    /* access modifiers changed from: package-private */
    public final void callStart() {
        int i = this.lifeSteps;
        if (i == 2 || i == 6) {
            onStart();
        }
    }

    public void onStart() {
        this.lifeSteps = 3;
        String alias = alias();
        TraceUtil.trace(alias, this + " onStart");
        resetTitleBar();
    }

    /* access modifiers changed from: package-private */
    public final void callResume() {
        int i = this.lifeSteps;
        if (i == 3 || i == 5) {
            onResume();
            for (IScopeLifecycle onResume : new ArrayList(this.mScopeLifecycles)) {
                onResume.onResume(this);
            }
        }
    }

    public void onResume() {
        this.lifeSteps = 4;
        String alias = alias();
        TraceUtil.trace(alias, this + " onResume");
    }

    public void onPageChangeEnded() {
        String alias = alias();
        TraceUtil.trace(alias, this + " onPageChangeEnded");
    }

    /* access modifiers changed from: package-private */
    public final void callPause() {
        if (this.lifeSteps == 4) {
            onPause();
            for (IScopeLifecycle onPause : new ArrayList(this.mScopeLifecycles)) {
                onPause.onPause(this);
            }
        }
    }

    public void onPause() {
        this.lifeSteps = 5;
        String alias = alias();
        TraceUtil.trace(alias, this + " onPause");
    }

    /* access modifiers changed from: package-private */
    public final void callStop() {
        int i = this.lifeSteps;
        if (i == 3 || i == 5) {
            onStop();
        }
    }

    public void onStop() {
        this.lifeSteps = 6;
        String alias = alias();
        TraceUtil.trace(alias, this + " onStop");
        if (!this.titleBarProxy.disable) {
            this.titleBarProxy.titleBar = null;
        }
    }

    /* access modifiers changed from: package-private */
    public final void callDestroy() {
        int i = this.lifeSteps;
        if (i == 6 || i == 2) {
            onDestroy();
        }
    }

    public void onDestroy() {
        this.lifeSteps = 7;
        String alias = alias();
        TraceUtil.trace(alias, this + " onDestroy");
    }

    public void onFinalize() {
        String alias = alias();
        TraceUtil.trace(alias, this + " onFinalize");
        this.lifeSteps = 8;
        this.mScopeLifecycles.clear();
        this.mScopeContext.detachAll();
        this.mScopeContext = null;
        removeLifecycleCallback(this.mComponentGroup);
        this.mComponentGroup.clear();
        Skeleton.watchDeletedObject(this);
        this.controller.removeLifecycleListener(this.controllerListener);
    }

    public void finish(Bundle bundle) {
        WeakReference<PageWrapper> weakReference = this.fromPage;
        if (!(weakReference == null || weakReference.get() == null || ((PageWrapper) this.fromPage.get()).isDestroyed())) {
            ((PageWrapper) this.fromPage.get()).onPageResult(bundle);
        }
        this.handler.post(new Runnable() {
            public void run() {
                if (PageWrapper.this.controller != null) {
                    PageWrapper.this.controller.getRouter().popController(PageWrapper.this.controller);
                }
            }
        });
    }

    public void finish() {
        finish((Bundle) null);
    }

    public boolean isDestroyed() {
        return this.lifeSteps >= 7;
    }

    public boolean isActive() {
        int i = this.lifeSteps;
        return i >= 2 && i <= 4;
    }

    /* access modifiers changed from: protected */
    public final void setFlags(int i) {
        if ((i & 4096) == 4096) {
            this.controller.setRetainViewMode(Controller.RetainViewMode.RETAIN_DETACH);
        } else if ((i & 4352) == 4352) {
            this.controller.setRetainViewMode(Controller.RetainViewMode.RELEASE_DETACH);
        }
    }

    /* access modifiers changed from: package-private */
    public final void onChangeStarted(ControllerChangeHandler controllerChangeHandler, ControllerChangeType controllerChangeType) {
        Controller controller2;
        if ((controllerChangeType == ControllerChangeType.POP_EXIT || controllerChangeType == ControllerChangeType.PUSH_EXIT) && (controller2 = this.controller) != null && controller2.isAttached()) {
            callPause();
        }
    }

    /* access modifiers changed from: package-private */
    public final void onChangeEnded(ControllerChangeHandler controllerChangeHandler, ControllerChangeType controllerChangeType) {
        Controller controller2;
        if ((controllerChangeType != ControllerChangeType.PUSH_ENTER && controllerChangeType != ControllerChangeType.POP_ENTER) || (controller2 = this.controller) == null) {
            return;
        }
        if (controller2.isAttached()) {
            onPageChangeEnded();
            callResume();
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {
                if (PageWrapper.this.controller.isAttached()) {
                    PageWrapper.this.onPageChangeEnded();
                    PageWrapper.this.callResume();
                }
            }
        });
    }

    public final void startActivity(Intent intent) {
        if (hasController()) {
            this.controller.startActivity(intent);
        }
    }

    public final void startActivityForResult(Intent intent, int i) {
        if (hasController()) {
            this.controller.startActivityForResult(intent, i);
        }
    }

    public final void startActivityForResult(Intent intent, int i, Bundle bundle) {
        if (hasController()) {
            this.controller.startActivityForResult(intent, i, bundle);
        }
    }

    public final void requestPermissions(String[] strArr) {
        if (hasController()) {
            this.controller.requestPermissions(strArr);
        }
    }

    public final void push(final Page page) {
        this.handler.post(new Runnable() {
            public void run() {
                PageWrapper.this.pageInstrument.pushPage(page);
            }
        });
    }

    public final void pushForResult(Page page) {
        page.setFromPage(this);
        push(page);
    }

    /* access modifiers changed from: package-private */
    public final void setFromPage(PageWrapper pageWrapper) {
        this.fromPage = new WeakReference<>(pageWrapper);
    }

    public final void popToRoot() {
        this.handler.post(new Runnable() {
            public void run() {
                PageWrapper.this.pageInstrument.popToRoot();
            }
        });
    }

    public void showDialog(Dialog dialog, String str) {
        dialog.show(getInstrument(), str);
    }

    public void setArgs(Bundle bundle) {
        if (bundle != null) {
            this.args.putAll(bundle);
        }
    }

    /* access modifiers changed from: protected */
    public final <T extends View> T findViewById(int i) {
        View view = getView();
        if (view == null) {
            return null;
        }
        return view.findViewById(i);
    }

    public String alias() {
        return getClass().getSimpleName();
    }

    public Bundle getArgs() {
        return this.args;
    }

    private final void resetTitleBar() {
        if (hasController()) {
            TitleBar titleBar = this.controller.getRouter().getTitleBar();
            this.titleBarProxy.titleBar = titleBar;
            if (titleBar != null) {
                if (this.titleBarProxy.titleAttr == null) {
                    String overrideTitle = overrideTitle();
                    if (overrideTitle == null) {
                        overrideTitle = getTitle();
                    }
                    if (overrideTitle != null) {
                        this.titleBarProxy.titleAttr = new TitleAttr.Builder(overrideTitle).build();
                    }
                }
                titleBar.setTitle(this.titleBarProxy.titleAttr);
                titleBar.setLeft(this.titleBarProxy.leftAttrs);
                titleBar.setRight(this.titleBarProxy.rightAttrs);
                titleBar.setHidden(this.titleBarProxy.hidden);
                titleBar.setStyle(this.titleBarProxy.titlebarAttr);
            }
        }
    }

    public final TitleBar getTitleBar() {
        return this.titleBarProxy;
    }

    public final void setTitleBarEnable(boolean z) {
        this.titleBarProxy.disable = !z;
    }

    /* access modifiers changed from: protected */
    public View getView() {
        if (hasController()) {
            return this.controller.getView();
        }
        return null;
    }

    public ControllerChangeHandler getPushHandler() {
        return new HorizontalChangeHandler();
    }

    public ControllerChangeHandler getPopHandler() {
        return new HorizontalChangeHandler();
    }

    /* access modifiers changed from: package-private */
    @Deprecated
    public void overridePushHandler(ControllerChangeHandler controllerChangeHandler) {
        if (hasController()) {
            this.controller.overridePushHandler(controllerChangeHandler);
        }
    }

    /* access modifiers changed from: package-private */
    @Deprecated
    public void overridePopHandler(ControllerChangeHandler controllerChangeHandler) {
        if (hasController()) {
            this.controller.overridePopHandler(controllerChangeHandler);
        }
    }

    public final void setOptionsMenuHidden(boolean z) {
        if (hasController()) {
            this.controller.setOptionsMenuHidden(z);
        }
    }

    public final void setHasOptionsMenu(boolean z) {
        if (hasController()) {
            this.controller.setHasOptionsMenu(z);
        }
    }

    public final void addLifecycleCallback(IScopeLifecycle iScopeLifecycle) {
        if (!this.mScopeLifecycles.contains(iScopeLifecycle)) {
            this.mScopeLifecycles.add(iScopeLifecycle);
        }
    }

    public final void removeLifecycleCallback(IScopeLifecycle iScopeLifecycle) {
        if (this.mScopeLifecycles.contains(iScopeLifecycle)) {
            this.mScopeLifecycles.remove(iScopeLifecycle);
        }
    }

    public boolean onHandleBack() {
        WeakReference<PageWrapper> weakReference = this.fromPage;
        if (weakReference == null || weakReference.get() == null || ((PageWrapper) this.fromPage.get()).isDestroyed()) {
            return false;
        }
        ((PageWrapper) this.fromPage.get()).onPageResult((Bundle) null);
        return false;
    }

    public final PageInstrument getInstrument() {
        return this.pageInstrument;
    }

    public final PageInstrument getInstrument(ViewGroup viewGroup, String str, boolean z) {
        Router childRouter;
        if (hasController() && (childRouter = this.controller.getChildRouter(viewGroup, str, z)) != null) {
            return PageInstrumentFactory.create(childRouter);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public boolean addComponent(Component component) {
        component.attachScopeContext(getScopeContext());
        if (this.mComponentGroup.addComponent(component)) {
            return true;
        }
        component.attachScopeContext((ScopeContext) null);
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean removeComponent(Component component) {
        if (!this.mComponentGroup.removeComponent(component)) {
            return false;
        }
        component.attachScopeContext((ScopeContext) null);
        return true;
    }

    /* access modifiers changed from: protected */
    public Component getComponent(Class<? extends Component> cls) {
        return this.mComponentGroup.getComponent(cls);
    }

    private boolean hasController() {
        return this.controller != null;
    }

    public final ScopeContext getScopeContext() {
        return this.mScopeContext;
    }

    /* access modifiers changed from: protected */
    public void onPostCreate() {
        onCreate(getView());
    }

    public int getLifeSteps() {
        return this.lifeSteps;
    }

    static final class PageTitleBarProxy implements TitleBar {
        boolean disable;
        boolean hidden;
        Attr[] leftAttrs;
        Attr[] rightAttrs;
        TitleAttr titleAttr;
        TitleBar titleBar;
        TitleBarAttr titlebarAttr;

        PageTitleBarProxy() {
        }

        public void setTitle(TitleAttr titleAttr2) {
            if (!this.disable) {
                this.titleAttr = titleAttr2;
                TitleBar titleBar2 = this.titleBar;
                if (titleBar2 != null) {
                    titleBar2.setTitle(titleAttr2);
                }
            }
        }

        public void setLeft(Attr... attrArr) {
            if (!this.disable) {
                this.leftAttrs = attrArr;
                TitleBar titleBar2 = this.titleBar;
                if (titleBar2 != null) {
                    titleBar2.setLeft(attrArr);
                }
            }
        }

        public void setRight(Attr... attrArr) {
            if (!this.disable) {
                this.rightAttrs = attrArr;
                TitleBar titleBar2 = this.titleBar;
                if (titleBar2 != null) {
                    titleBar2.setRight(attrArr);
                }
            }
        }

        public void setHidden(boolean z) {
            if (!this.disable) {
                this.hidden = z;
                TitleBar titleBar2 = this.titleBar;
                if (titleBar2 != null) {
                    titleBar2.setHidden(z);
                }
            }
        }

        public void setStyle(TitleBarAttr titleBarAttr) {
            if (!this.disable) {
                this.titlebarAttr = titleBarAttr;
                TitleBar titleBar2 = this.titleBar;
                if (titleBar2 != null) {
                    titleBar2.setStyle(titleBarAttr);
                }
            }
        }
    }
}
