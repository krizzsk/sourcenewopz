package com.didi.app.nova.skeleton.internal.page;

import com.didi.app.nova.skeleton.IScopeLifecycle;
import com.didi.app.nova.skeleton.Page;
import com.didi.app.nova.skeleton.PageInstrument;
import com.didi.app.nova.skeleton.conductor.Router;
import com.didi.app.nova.skeleton.conductor.RouterTransaction;
import com.didi.app.nova.skeleton.dialog.DialogFrameLayout;
import com.didi.app.nova.skeleton.dialog.DialogInstrument;
import com.didi.app.nova.skeleton.title.TitleBar;
import com.didi.app.nova.skeleton.tools.TraceUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class PageInstrumentImpl implements PageInstrument {

    /* renamed from: a */
    static final String f8491a = "PageInstrumentImpl.Tag.RootPage";

    /* renamed from: b */
    private List<IScopeLifecycle> f8492b = new ArrayList();

    /* renamed from: c */
    private PageInstrument.IPagePushCallback f8493c;

    /* renamed from: router  reason: collision with root package name */
    public Router f61861router;

    public PageInstrumentImpl(Router router2) {
        this.f61861router = router2;
    }

    public boolean hasRootPage() {
        return this.f61861router.hasRootController();
    }

    public void setRootPage(Page page) {
        if (this.f61861router.getContainerId() == 0) {
            TraceUtil.trace("PageInstrumentImpl", "[WARN] Conductor is destroyed and setRootPage " + page);
            return;
        }
        PageInstrument.IPagePushCallback iPagePushCallback = this.f8493c;
        if (iPagePushCallback != null) {
            iPagePushCallback.pageConfigureOnPush(page);
        }
        ControllerProxy controllerProxy = new ControllerProxy(page.getArgs());
        controllerProxy.f8490c = page;
        if (!this.f8492b.isEmpty()) {
            for (int i = 0; i < this.f8492b.size(); i++) {
                page.addLifecycleCallback(this.f8492b.get(i));
            }
        }
        TraceUtil.trace("PageInstrumentImpl", "setRootPage " + page);
        page.attach(this.f61861router.getActivity(), this, controllerProxy);
        this.f61861router.setRoot(RouterTransaction.with(controllerProxy).pushChangeHandler(getBackstackSize() > 0 ? page.getPushHandler() : null).popChangeHandler(page.getPopHandler()).tag(f8491a).pageName(page.getClass().getName()));
    }

    public Page getRootPage() {
        ControllerProxy controllerProxy;
        if (!this.f61861router.hasRootController() || (controllerProxy = (ControllerProxy) this.f61861router.getControllerWithTag(f8491a)) == null) {
            return null;
        }
        return (Page) controllerProxy.getPage();
    }

    public void pushPage(Page page) {
        if (this.f61861router.getContainerId() == 0) {
            TraceUtil.trace("PageInstrumentImpl", "[WARN] Conductor is destroyed and pushPage " + page);
            return;
        }
        PageInstrument.IPagePushCallback iPagePushCallback = this.f8493c;
        if (iPagePushCallback != null) {
            iPagePushCallback.pageConfigureOnPush(page);
        }
        ControllerProxy controllerProxy = new ControllerProxy(page.getArgs());
        controllerProxy.f8490c = page;
        if (!this.f8492b.isEmpty()) {
            for (int i = 0; i < this.f8492b.size(); i++) {
                page.addLifecycleCallback(this.f8492b.get(i));
            }
        }
        TraceUtil.trace("PageInstrumentImpl", "pushPage " + page);
        page.attach(this.f61861router.getActivity(), this, controllerProxy);
        this.f61861router.pushController(RouterTransaction.with(page.controller).pushChangeHandler(page.getPushHandler()).popChangeHandler(page.getPopHandler()).tag(page.getClass().getName()).pageName(page.getClass().getName()));
    }

    public void pop() {
        if (this.f61861router.getBackstackSize() != 0) {
            this.f61861router.popCurrentController();
            TraceUtil.trace("PageInstrumentImpl", "pop()");
        }
    }

    public void popToPage(Class<?> cls) {
        if (containsPageInBackStack(cls)) {
            this.f61861router.popToPageName(cls.getName());
        }
    }

    public boolean containsPageInBackStack(Class<?> cls) {
        return this.f61861router.getControllerWithPageName(cls.getName()) != null;
    }

    public void popToRoot() {
        this.f61861router.popToRoot();
        TraceUtil.trace("PageInstrumentImpl", "popToRoot()");
    }

    public boolean handleBack() {
        if (getDialogInstrument() != null && getDialogInstrument().handleBack()) {
            return true;
        }
        TraceUtil.trace("PageInstrumentImpl", "handleBack()");
        return this.f61861router.handleBack();
    }

    public void attachTitleBar(TitleBar titleBar) {
        this.f61861router.attachTitleBar(titleBar);
    }

    public void attachDialogFrame(DialogFrameLayout dialogFrameLayout) {
        this.f61861router.attachDialogFrame(dialogFrameLayout);
    }

    public DialogInstrument getDialogInstrument() {
        return this.f61861router.getDialogInstrument();
    }

    public int getBackstackSize() {
        return this.f61861router.getBackstackSize();
    }

    public void registerPageLifecycleCallback(IScopeLifecycle iScopeLifecycle) {
        synchronized (this.f8492b) {
            this.f8492b.add(iScopeLifecycle);
        }
    }

    public void unregisterPageLifecycleCallback(IScopeLifecycle iScopeLifecycle) {
        synchronized (this.f8492b) {
            this.f8492b.remove(iScopeLifecycle);
        }
    }

    public List<IScopeLifecycle> getRegisteredPageLifecycleCallbacks() {
        return Collections.unmodifiableList(this.f8492b);
    }

    public void setPagePushCallback(PageInstrument.IPagePushCallback iPagePushCallback) {
        this.f8493c = iPagePushCallback;
    }
}
