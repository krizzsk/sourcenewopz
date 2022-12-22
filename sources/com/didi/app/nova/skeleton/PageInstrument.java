package com.didi.app.nova.skeleton;

import com.didi.app.nova.skeleton.dialog.DialogFrameLayout;
import com.didi.app.nova.skeleton.dialog.DialogInstrument;
import com.didi.app.nova.skeleton.title.TitleBar;
import java.util.List;

public interface PageInstrument {

    public interface IPagePushCallback {
        void pageConfigureOnPush(Page page);
    }

    void attachDialogFrame(DialogFrameLayout dialogFrameLayout);

    void attachTitleBar(TitleBar titleBar);

    boolean containsPageInBackStack(Class<?> cls);

    int getBackstackSize();

    DialogInstrument getDialogInstrument();

    List<IScopeLifecycle> getRegisteredPageLifecycleCallbacks();

    Page getRootPage();

    boolean handleBack();

    boolean hasRootPage();

    void pop();

    void popToPage(Class<?> cls);

    void popToRoot();

    void pushPage(Page page);

    void registerPageLifecycleCallback(IScopeLifecycle iScopeLifecycle);

    void setPagePushCallback(IPagePushCallback iPagePushCallback);

    void setRootPage(Page page);

    void unregisterPageLifecycleCallback(IScopeLifecycle iScopeLifecycle);
}
