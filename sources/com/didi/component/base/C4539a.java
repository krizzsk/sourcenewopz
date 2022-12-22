package com.didi.component.base;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import androidx.fragment.app.Fragment;
import com.didi.component.common.dialog.CommonDialogHandler;
import com.didi.component.common.dialog.DialogHandler;
import com.didi.component.core.IGroupView;
import com.didi.component.core.IPageSwitcher;
import com.didi.component.core.IPresenter;
import com.didi.component.core.PresenterGroup;
import com.didi.component.core.dialog.DialogInfo;
import com.didi.component.core.dialog.ToastHandler;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.app.IComponent;
import com.didichuxing.omega.sdk.init.OmegaSDK;
import com.didichuxing.omega.sdk.leak.LeakFacade;

@Deprecated
/* renamed from: com.didi.component.base.a */
/* compiled from: BaseFragment */
abstract class C4539a<P extends PresenterGroup> extends Fragment implements KeyEvent.Callback, IGroupView<P>, IComponent<BusinessContext> {

    /* renamed from: a */
    protected P f10990a;

    /* renamed from: b */
    private BusinessContext f10991b;

    /* renamed from: c */
    private IPageSwitcher f10992c;

    /* renamed from: d */
    private ToastHandler f10993d;

    /* renamed from: e */
    private DialogHandler f10994e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public View f10995f;

    /* renamed from: g */
    private int f10996g;

    /* renamed from: h */
    private boolean f10997h = false;

    /* renamed from: i */
    private ViewTreeObserver.OnGlobalLayoutListener f10998i = new BaseFragment$1(this);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract int mo45660a(Bundle bundle);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public View mo45661a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo45663a(int i);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo45667a(int i, int i2) {
        return false;
    }

    /* renamed from: a */
    public boolean mo45668a(int i, int i2, Intent intent) {
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract int mo45669b(BusinessContext businessContext);

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public abstract P mo45672d();

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public void mo45674f() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public void mo45675g() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public void mo45677h() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: i */
    public void mo45678i() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: k */
    public void mo45680k() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: l */
    public void mo45681l() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: m */
    public Animator mo45682m() {
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: n */
    public Animator mo45683n() {
        return null;
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

    public void setBackVisible(boolean z) {
    }

    public void setTitle(String str) {
    }

    C4539a() {
    }

    /* renamed from: a */
    public void setBusinessContext(BusinessContext businessContext) {
        this.f10991b = businessContext;
        this.f10996g = mo45669b(businessContext);
        IPageSwitcher iPageSwitcher = this.f10992c;
        if (iPageSwitcher != null) {
            iPageSwitcher.updateBusinessContext(businessContext);
        }
    }

    /* renamed from: a */
    public BusinessContext getBusinessContext() {
        return this.f10991b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final IPageSwitcher mo45670b() {
        IPageSwitcher iPageSwitcher = this.f10992c;
        if (iPageSwitcher != null) {
            return iPageSwitcher;
        }
        IPageSwitcher c = mo45671c();
        this.f10992c = c;
        return c;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public IPageSwitcher mo45671c() {
        return new BasePagerSwitcher(getBusinessContext(), this);
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        P p;
        if (!mo45668a(i, i2, intent) && (p = this.f10990a) != null) {
            p.onDispatchActivityResult(i, i2, intent);
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f10997h = false;
        m7430o();
        this.f10993d = new ToastHandler(getContext());
        this.f10994e = new CommonDialogHandler(getBusinessContext(), this);
        setPresenter(mo45672d());
        this.f10990a.setPageSwitcher(mo45670b());
        this.f10990a.setIView(this);
        View a = mo45661a(layoutInflater, viewGroup, bundle);
        this.f10995f = a;
        a.getViewTreeObserver().addOnGlobalLayoutListener(this.f10998i);
        this.f10990a.dispatchPageCreate();
        return this.f10995f;
    }

    /* renamed from: a */
    public void setPresenter(P p) {
        this.f10990a = p;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo45664a(View view, View view2) {
        if (view2 != null && (view instanceof ViewGroup)) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) parent;
                viewGroup.setClipChildren(false);
                if (view != parent) {
                    mo45664a(view, (View) viewGroup);
                }
            }
        }
    }

    /* renamed from: o */
    private void m7430o() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            int a = mo45660a(arguments);
            this.f10996g = a;
            if (a > 0) {
                mo45663a(a);
                return;
            }
        }
        int b = mo45669b(getBusinessContext());
        this.f10996g = b;
        if (b > 0) {
            mo45663a(b);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public int mo45673e() {
        return this.f10996g;
    }

    public final void onStart() {
        super.onStart();
        this.f10990a.dispatchPageStart();
        mo45674f();
    }

    public final void onResume() {
        super.onResume();
        this.f10990a.dispatchPageResume();
        mo45675g();
        OmegaSDK.fireFragmentResumed(this);
    }

    public final void onPause() {
        super.onPause();
        this.f10990a.dispatchPagePause();
        mo45677h();
        OmegaSDK.fireFragmentPaused(this);
    }

    public final void onStop() {
        super.onStop();
        this.f10990a.dispatchPageStop();
        mo45678i();
    }

    public final void onDestroyView() {
        this.f10997h = true;
        super.onDestroyView();
        m7431p();
        this.f10990a.dispatchPageDestroy();
        mo45680k();
        this.f10992c = null;
        this.f10990a = null;
        this.f10993d = null;
        this.f10994e = null;
        this.f10995f = null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public boolean mo45679j() {
        return this.f10997h;
    }

    /* renamed from: p */
    private void m7431p() {
        DialogHandler dialogHandler = this.f10994e;
        if (dialogHandler != null) {
            dialogHandler.dismissCurrent();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        LeakFacade.watch(this);
    }

    public final void showDialog(DialogInfo dialogInfo) {
        DialogHandler dialogHandler;
        if (!mo45679j() && (dialogHandler = this.f10994e) != null) {
            dialogHandler.show(dialogInfo);
        }
    }

    public boolean isDialogShowing() {
        return this.f10994e.isDialogShowing();
    }

    public final void dismissDialog(int i) {
        DialogHandler dialogHandler;
        if (!mo45679j() && (dialogHandler = this.f10994e) != null) {
            dialogHandler.dismiss(i);
        }
    }

    public final void onDialogClicked(int i, int i2) {
        P p;
        if (!mo45679j() && !mo45667a(i, i2) && (p = this.f10990a) != null) {
            p.dispatchDialogAction(i, i2);
        }
    }

    public final void showToast(ToastHandler.ToastInfo toastInfo) {
        ToastHandler toastHandler;
        if (!mo45679j() && (toastHandler = this.f10993d) != null) {
            toastHandler.showToast(toastInfo);
        }
    }

    public Animation onCreateAnimation(int i, boolean z, int i2) {
        m7429a(z);
        return super.onCreateAnimation(i, z, i2);
    }

    /* renamed from: a */
    private void m7429a(boolean z) {
        Animator n = !z ? mo45683n() : null;
        if (n != null) {
            n.start();
        }
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (mo45679j() || keyEvent.getKeyCode() != 4) {
            return false;
        }
        DialogHandler dialogHandler = this.f10994e;
        if (dialogHandler == null || !dialogHandler.onBackPressed()) {
            return this.f10990a.dispatchBackPressed(IPresenter.BackType.BackKey);
        }
        return true;
    }
}
