package com.didi.component.core;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.didi.component.core.IView;
import com.didi.component.core.dialog.DialogInfo;
import com.didi.component.core.dialog.ToastHandler;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.lifecycle.Lifecycle;
import com.didi.component.lifecycle.LifecycleDispatcher;
import com.didi.component.lifecycle.LifecycleOwner;
import java.util.HashMap;
import java.util.Map;

public abstract class IPresenter<V extends IView> implements LifecycleOwner {
    public static Map<Integer, Class<? extends Fragment>> templateMapping = new HashMap();

    /* renamed from: a */
    private Handler f12738a = new Handler();

    /* renamed from: b */
    private LifecycleDispatcher f12739b = new LifecycleDispatcher();
    /* access modifiers changed from: protected */
    public Context mContext;
    protected PresenterGroup mParent;
    /* access modifiers changed from: protected */
    public boolean mRemoved = false;
    /* access modifiers changed from: protected */
    public V mView;

    /* renamed from: o */
    Bundle f12740o;

    public enum BackType {
        TopLeft,
        BackKey
    }

    /* access modifiers changed from: protected */
    public long forwardDelay() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
    }

    /* access modifiers changed from: protected */
    public boolean onBackPressed(BackType backType) {
        return false;
    }

    /* access modifiers changed from: protected */
    public void onDialogAction(int i, int i2) {
    }

    public IPresenter(Context context) {
        this.mContext = context;
    }

    public IPresenter(ComponentParams componentParams) {
        if (componentParams != null && componentParams.bizCtx != null) {
            this.mContext = componentParams.bizCtx.getContext();
        }
    }

    /* access modifiers changed from: protected */
    public void setParent(PresenterGroup presenterGroup) {
        this.mParent = presenterGroup;
    }

    /* access modifiers changed from: protected */
    public PresenterGroup getParent() {
        return this.mParent;
    }

    /* access modifiers changed from: protected */
    public void forward(int i, Bundle bundle) {
        PresenterGroup presenterGroup = this.mParent;
        if (presenterGroup != null) {
            presenterGroup.forward(i, bundle);
        }
    }

    /* access modifiers changed from: protected */
    public void forward(int i, Bundle bundle, Animations animations) {
        PresenterGroup presenterGroup = this.mParent;
        if (presenterGroup != null) {
            presenterGroup.forward(i, bundle, animations);
        }
    }

    /* access modifiers changed from: protected */
    public void forward(Class<? extends Fragment> cls, Bundle bundle) {
        PresenterGroup presenterGroup = this.mParent;
        if (presenterGroup != null) {
            presenterGroup.forward(cls, bundle);
        }
    }

    /* access modifiers changed from: protected */
    public void forward(Class<? extends Fragment> cls, Bundle bundle, Animations animations) {
        PresenterGroup presenterGroup = this.mParent;
        if (presenterGroup != null) {
            presenterGroup.forward(cls, bundle, animations);
        }
    }

    /* access modifiers changed from: protected */
    public void goBack() {
        PresenterGroup presenterGroup = this.mParent;
        if (presenterGroup != null) {
            presenterGroup.goBack();
        }
    }

    /* access modifiers changed from: protected */
    public void goBack(Bundle bundle) {
        PresenterGroup presenterGroup = this.mParent;
        if (presenterGroup != null) {
            presenterGroup.goBack(bundle);
        }
    }

    /* access modifiers changed from: protected */
    public void goBackRoot() {
        PresenterGroup presenterGroup = this.mParent;
        if (presenterGroup != null) {
            presenterGroup.goBackRoot();
        }
    }

    /* access modifiers changed from: protected */
    public void goBackRoot(Bundle bundle) {
        PresenterGroup presenterGroup = this.mParent;
        if (presenterGroup != null) {
            presenterGroup.goBackRoot(bundle);
        }
    }

    /* access modifiers changed from: protected */
    public Fragment getHost() {
        IPageSwitcher pageSwitcher = getPageSwitcher();
        if (pageSwitcher != null) {
            return pageSwitcher.getHost();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public IPageSwitcher getPageSwitcher() {
        PresenterGroup presenterGroup = this.mParent;
        if (presenterGroup != null) {
            return presenterGroup.getPageSwitcher();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void startActivity(Intent intent) {
        startActivityForResult(intent, -1, (Bundle) null);
    }

    /* access modifiers changed from: protected */
    public void startActivity(Intent intent, Bundle bundle) {
        startActivityForResult(intent, -1, bundle);
    }

    /* access modifiers changed from: protected */
    public void startActivityForResult(Intent intent, int i) {
        startActivityForResult(intent, i, (Bundle) null);
    }

    /* access modifiers changed from: protected */
    public void startActivityForResult(Intent intent, int i, Bundle bundle) {
        PresenterGroup presenterGroup = this.mParent;
        if (presenterGroup != null) {
            presenterGroup.mo48141a(intent, i, bundle, this);
        }
    }

    /* access modifiers changed from: protected */
    public void startFragment(Class<? extends Fragment> cls, Bundle bundle) {
        startFragmentForResult(cls, -1, bundle);
    }

    /* access modifiers changed from: protected */
    public void startFragmentForResult(Class<? extends Fragment> cls, int i, Bundle bundle) {
        Intent intent = new Intent(this.mContext, FragmentContainerActivity.class);
        intent.putExtra(FragmentContainerActivity.FRAGMENT_CLASS, cls.getName());
        intent.putExtras(bundle);
        startActivityForResult(intent, i);
    }

    public void doPublish(String str) {
        doPublish(str, (Object) null);
    }

    public void doPublish(String str, Object obj) {
        if (!TextUtils.isEmpty(str) && !this.mRemoved) {
            BaseEventPublisher.getPublisher().publish(str, obj);
        }
    }

    public void subscribe(String str, BaseEventPublisher.OnEventListener onEventListener) {
        if (!TextUtils.isEmpty(str) && onEventListener != null && !this.mRemoved) {
            BaseEventPublisher.getPublisher().subscribe(str, onEventListener);
        }
    }

    public void subscribe(String str, BaseEventPublisher.OnEventListener onEventListener, Class<?> cls) {
        if (!TextUtils.isEmpty(str) && onEventListener != null && !this.mRemoved) {
            if (cls == null) {
                BaseEventPublisher.getPublisher().subscribe(str, onEventListener);
            } else {
                BaseEventPublisher.getPublisher().subscribe(str, onEventListener, cls);
            }
        }
    }

    public void unsubscribe(String str, BaseEventPublisher.OnEventListener onEventListener) {
        if (!TextUtils.isEmpty(str) && onEventListener != null) {
            BaseEventPublisher.getPublisher().unsubscribe(str, onEventListener);
        }
    }

    public void unsubscribe(String str, BaseEventPublisher.OnEventListener onEventListener, Class<?> cls) {
        if (!TextUtils.isEmpty(str) && onEventListener != null) {
            if (cls == null) {
                BaseEventPublisher.getPublisher().unsubscribe(str, onEventListener);
            } else {
                BaseEventPublisher.getPublisher().unsubscribe(str, onEventListener, cls);
            }
        }
    }

    public void setIView(V v) {
        this.mView = v;
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        this.f12739b.dispatchAdd();
    }

    /* access modifiers changed from: protected */
    public void onPageStart() {
        this.f12739b.dispatchPageStart();
    }

    /* access modifiers changed from: protected */
    public void onPageResume() {
        this.f12739b.dispatchPageResume();
    }

    /* access modifiers changed from: protected */
    public void onPagePause() {
        this.f12739b.dispatchPagePause();
    }

    /* access modifiers changed from: protected */
    public void onPageStop() {
        this.f12739b.dispatchPageStop();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo48104a() {
        onRemove();
        this.mRemoved = true;
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        this.f12739b.dispatchRemove();
    }

    /* access modifiers changed from: protected */
    public void onPageShow() {
        this.f12739b.dispatchPageShow();
    }

    /* access modifiers changed from: protected */
    public void onPageHide() {
        this.f12739b.dispatchPageHide();
    }

    /* access modifiers changed from: protected */
    public void onLeaveHome() {
        this.f12739b.dispatchLeaveHome();
    }

    /* access modifiers changed from: protected */
    public void onBackHome(Bundle bundle) {
        this.f12739b.dispatchBackHome();
    }

    /* access modifiers changed from: protected */
    public void showDialog(DialogInfo dialogInfo) {
        PresenterGroup presenterGroup = this.mParent;
        if (presenterGroup != null) {
            presenterGroup.mo48142a(dialogInfo, this);
        }
    }

    /* access modifiers changed from: protected */
    public boolean isDialogShowing() {
        PresenterGroup presenterGroup = this.mParent;
        if (presenterGroup != null) {
            return presenterGroup.isDialogShowing();
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void dismissDialog(int i) {
        PresenterGroup presenterGroup = this.mParent;
        if (presenterGroup != null) {
            presenterGroup.mo48140a(i, this);
        }
    }

    /* access modifiers changed from: protected */
    public void showToast(ToastHandler.ToastInfo toastInfo) {
        PresenterGroup presenterGroup = this.mParent;
        if (presenterGroup != null) {
            presenterGroup.showToast(toastInfo);
        }
    }

    /* access modifiers changed from: protected */
    public int requestCodeForHost(int i) {
        PresenterGroup presenterGroup = this.mParent;
        return presenterGroup != null ? presenterGroup.mo48139a(this, i) : i;
    }

    public Lifecycle getLifecycle() {
        return this.f12739b;
    }
}
