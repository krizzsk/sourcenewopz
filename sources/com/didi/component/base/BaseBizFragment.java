package com.didi.component.base;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import com.didi.component.common.dialog.CommonDialogHandler;
import com.didi.component.common.dialog.DialogHandler;
import com.didi.component.core.IGroupView;
import com.didi.component.core.IPageSwitcher;
import com.didi.component.core.IPresenter;
import com.didi.component.core.PresenterGroup;
import com.didi.component.core.dialog.DialogInfo;
import com.didi.component.core.dialog.ToastHandler;
import com.didi.component.core.util.CLog;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.home.BizEntranceFragment;
import com.didichuxing.omega.sdk.leak.LeakFacade;
import com.didiglobal.font.decorator.DecoratorInjector;
import com.didiglobal.font.iface.DecoratorFactory;

abstract class BaseBizFragment<P extends PresenterGroup> extends BizEntranceFragment implements KeyEvent.Callback, IGroupView<P> {
    private int mComboType;
    private int mCurrentBID;
    private boolean mDestroyed = false;
    private DialogHandler mDialogHandler;
    private CLayoutInflaterFactory mLayoutInflaterFactory;
    /* access modifiers changed from: private */
    public ViewTreeObserver.OnGlobalLayoutListener mListener = new ViewTreeObserver.OnGlobalLayoutListener() {
        public void onGlobalLayout() {
            View access$000 = BaseBizFragment.this.mRootView;
            if (access$000 != null) {
                access$000.getViewTreeObserver().removeGlobalOnLayoutListener(BaseBizFragment.this.mListener);
                Animator offerEnterAnimation = BaseBizFragment.this.offerEnterAnimation();
                if (offerEnterAnimation != null) {
                    offerEnterAnimation.start();
                }
                BaseBizFragment.this.onFirstLayoutDone();
            }
        }
    };
    private IPageSwitcher mPageSwitcher;
    /* access modifiers changed from: private */
    public View mRootView;
    private ToastHandler mToastHandler;
    protected P mTopPresenter;

    /* access modifiers changed from: protected */
    public abstract int getBidFromBundle(Bundle bundle);

    /* access modifiers changed from: protected */
    public abstract int getBidFromBusinessContext(BusinessContext businessContext);

    /* access modifiers changed from: protected */
    public abstract int getComboTypeFromBundle(Bundle bundle);

    /* access modifiers changed from: protected */
    public abstract int getComboTypeFromBusinessContext(BusinessContext businessContext);

    /* access modifiers changed from: protected */
    public boolean isEnableComponentConfig() {
        return true;
    }

    /* access modifiers changed from: protected */
    public Animator offerEnterAnimation() {
        return null;
    }

    /* access modifiers changed from: protected */
    public Animator offerExitAnimation() {
        return null;
    }

    public boolean onActivityResultHappen(int i, int i2, Intent intent) {
        return false;
    }

    /* access modifiers changed from: protected */
    public abstract void onBIDPopulated(int i);

    /* access modifiers changed from: protected */
    public void onBackHomeImpl() {
    }

    /* access modifiers changed from: protected */
    public abstract P onCreateTopPresenter();

    /* access modifiers changed from: protected */
    public View onCreateViewImpl(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return null;
    }

    /* access modifiers changed from: protected */
    public void onDestroyViewImpl() {
    }

    /* access modifiers changed from: protected */
    public boolean onDialogAction(int i, int i2) {
        return false;
    }

    /* access modifiers changed from: protected */
    public void onFirstLayoutDone() {
    }

    /* access modifiers changed from: protected */
    public void onHideImpl() {
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return false;
    }

    public boolean onKeyLongPress(int i, KeyEvent keyEvent) {
        return false;
    }

    public boolean onKeyMultiple(int i, int i2, KeyEvent keyEvent) {
        return false;
    }

    /* access modifiers changed from: protected */
    public void onLeaveHomeImpl() {
    }

    /* access modifiers changed from: protected */
    public void onPauseImpl() {
    }

    /* access modifiers changed from: protected */
    public void onResumeImpl() {
    }

    /* access modifiers changed from: protected */
    public void onShowImpl() {
    }

    /* access modifiers changed from: protected */
    public void onStartImpl() {
    }

    /* access modifiers changed from: protected */
    public void onStopImpl() {
    }

    public void setBackVisible(boolean z) {
    }

    public void setTitle(String str) {
    }

    BaseBizFragment() {
    }

    /* access modifiers changed from: protected */
    public final IPageSwitcher getPageSwitcher() {
        IPageSwitcher iPageSwitcher = this.mPageSwitcher;
        if (iPageSwitcher != null) {
            return iPageSwitcher;
        }
        IPageSwitcher createPageSwitcher = createPageSwitcher();
        this.mPageSwitcher = createPageSwitcher;
        return createPageSwitcher;
    }

    /* access modifiers changed from: protected */
    public IPageSwitcher createPageSwitcher() {
        return new BasePagerSwitcher(getBusinessContext(), this);
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        P p;
        if (!onActivityResultHappen(i, i2, intent) && (p = this.mTopPresenter) != null) {
            p.onDispatchActivityResult(i, i2, intent);
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mDestroyed = false;
        populateCurrentSID();
        this.mToastHandler = new ToastHandler(getContext());
        this.mDialogHandler = new CommonDialogHandler(getBusinessContext(), this);
        setPresenter(onCreateTopPresenter());
        this.mTopPresenter.setPageSwitcher(getPageSwitcher());
        this.mTopPresenter.setIView(this);
        LayoutInflater from = LayoutInflater.from(getContext());
        attachLayoutInflaterFactory(from);
        View onCreateViewImpl = onCreateViewImpl(from, viewGroup, bundle);
        this.mRootView = onCreateViewImpl;
        onCreateViewImpl.getViewTreeObserver().addOnGlobalLayoutListener(this.mListener);
        this.mTopPresenter.dispatchPageCreate();
        return this.mRootView;
    }

    private void attachLayoutInflaterFactory(LayoutInflater layoutInflater) {
        LayoutInflater.Factory2 factory2 = layoutInflater.getFactory2();
        if (factory2 instanceof DecoratorInjector.CombineFactory) {
            for (DecoratorFactory next : ((DecoratorInjector.CombineFactory) factory2).getDecoratorFactories()) {
                if (next instanceof CLayoutInflaterFactory) {
                    CLayoutInflaterFactory cLayoutInflaterFactory = (CLayoutInflaterFactory) next;
                    cLayoutInflaterFactory.attach((DecoratorFactory) this);
                    this.mLayoutInflaterFactory = cLayoutInflaterFactory;
                }
            }
        }
    }

    private void detachLayoutInflaterFactory() {
        CLayoutInflaterFactory cLayoutInflaterFactory = this.mLayoutInflaterFactory;
        if (cLayoutInflaterFactory != null) {
            cLayoutInflaterFactory.detach((DecoratorFactory) this);
        }
        this.mLayoutInflaterFactory = null;
    }

    public void setPresenter(P p) {
        this.mTopPresenter = p;
    }

    private void populateCurrentSID() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mCurrentBID = getBidFromBundle(arguments);
            this.mComboType = getComboTypeFromBundle(arguments);
            int i = this.mCurrentBID;
            if (i > 0) {
                onBIDPopulated(i);
                return;
            }
        }
        BusinessContext businessContext = getBusinessContext();
        this.mCurrentBID = getBidFromBusinessContext(businessContext);
        this.mComboType = getComboTypeFromBusinessContext(businessContext);
        int i2 = this.mCurrentBID;
        if (i2 > 0) {
            onBIDPopulated(i2);
        }
    }

    /* access modifiers changed from: protected */
    public int currentBID() {
        return this.mCurrentBID;
    }

    /* access modifiers changed from: protected */
    public void setCurrentBID(int i) {
        this.mCurrentBID = i;
    }

    /* access modifiers changed from: protected */
    public int getComboType() {
        return this.mComboType;
    }

    /* access modifiers changed from: protected */
    public void setComboType(int i) {
        this.mComboType = i;
    }

    public final void onStart() {
        super.onStart();
        this.mTopPresenter.dispatchPageStart();
        onStartImpl();
    }

    public final void onResume() {
        super.onResume();
        this.mTopPresenter.dispatchPageResume();
        onResumeImpl();
    }

    public final void onPause() {
        super.onPause();
        this.mTopPresenter.dispatchPagePause();
        onPauseImpl();
    }

    public final void onStop() {
        super.onStop();
        this.mTopPresenter.dispatchPageStop();
        onStopImpl();
    }

    public final void onDestroyView() {
        this.mDestroyed = true;
        super.onDestroyView();
        dismissCurrentDialog();
        this.mTopPresenter.dispatchPageDestroy();
        detachLayoutInflaterFactory();
        onDestroyViewImpl();
        this.mPageSwitcher = null;
        this.mTopPresenter = null;
        this.mToastHandler = null;
        this.mDialogHandler = null;
        this.mRootView = null;
    }

    public void onDestroy() {
        super.onDestroy();
        LeakFacade.watch(this);
    }

    /* access modifiers changed from: protected */
    public boolean isDestroyed() {
        return this.mDestroyed;
    }

    private void dismissCurrentDialog() {
        DialogHandler dialogHandler = this.mDialogHandler;
        if (dialogHandler != null) {
            dialogHandler.dismissCurrent();
        }
    }

    /* access modifiers changed from: protected */
    public final void onShow() {
        super.onShow();
        this.mTopPresenter.dispatchOnPageShow();
        onShowImpl();
    }

    /* access modifiers changed from: protected */
    public final void onHide() {
        super.onHide();
        this.mTopPresenter.dispatchOnPageHide();
        onHideImpl();
    }

    public final void onLeaveHome() {
        super.onLeaveHome();
        P p = this.mTopPresenter;
        if (p != null) {
            p.dispatchLeaveHome();
        } else {
            CLog.m8709e("onLeaveHome TopPresenter is null");
        }
        onLeaveHomeImpl();
    }

    public void onBackToHome() {
        super.onBackToHome();
        P p = this.mTopPresenter;
        if (p != null) {
            p.dispatchBackHome(getArguments());
        } else {
            CLog.m8709e("onBackToHome TopPresenter is null");
        }
        onBackHomeImpl();
    }

    public final void showDialog(DialogInfo dialogInfo) {
        DialogHandler dialogHandler;
        if (!isDestroyed() && (dialogHandler = this.mDialogHandler) != null) {
            dialogHandler.show(dialogInfo);
        }
    }

    public final boolean isDialogShowing() {
        DialogHandler dialogHandler = this.mDialogHandler;
        return dialogHandler != null && dialogHandler.isDialogShowing();
    }

    public final void dismissDialog(int i) {
        DialogHandler dialogHandler;
        if (!isDestroyed() && (dialogHandler = this.mDialogHandler) != null) {
            dialogHandler.dismiss(i);
        }
    }

    public final void onDialogClicked(int i, int i2) {
        if (!isDestroyed() && !onDialogAction(i, i2)) {
            this.mTopPresenter.dispatchDialogAction(i, i2);
        }
    }

    public final void showToast(ToastHandler.ToastInfo toastInfo) {
        ToastHandler toastHandler;
        if (!isDestroyed() && (toastHandler = this.mToastHandler) != null) {
            toastHandler.showToast(toastInfo);
        }
    }

    public Animation onCreateAnimation(int i, boolean z, int i2) {
        onCreateAnimationHappen(z);
        return super.onCreateAnimation(i, z, i2);
    }

    private void onCreateAnimationHappen(boolean z) {
        Animator offerExitAnimation = !z ? offerExitAnimation() : null;
        if (offerExitAnimation != null) {
            offerExitAnimation.start();
        }
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (isDestroyed() || keyEvent.getKeyCode() != 4) {
            return false;
        }
        DialogHandler dialogHandler = this.mDialogHandler;
        if (dialogHandler != null && dialogHandler.onBackPressed()) {
            return true;
        }
        P p = this.mTopPresenter;
        if (p == null) {
            return false;
        }
        return p.dispatchBackPressed(IPresenter.BackType.BackKey);
    }

    public void setBusinessContext(BusinessContext businessContext) {
        super.setBusinessContext(businessContext);
        this.mCurrentBID = getBidFromBusinessContext(businessContext);
        this.mComboType = getComboTypeFromBusinessContext(businessContext);
        IPageSwitcher iPageSwitcher = this.mPageSwitcher;
        if (iPageSwitcher != null) {
            iPageSwitcher.updateBusinessContext(businessContext);
        }
    }
}
