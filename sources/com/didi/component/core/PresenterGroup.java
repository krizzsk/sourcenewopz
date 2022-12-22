package com.didi.component.core;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.Fragment;
import com.didi.component.core.IGroupView;
import com.didi.component.core.IPresenter;
import com.didi.component.core.dialog.DialogInfo;
import com.didi.component.core.dialog.ToastHandler;
import com.didi.sdk.apm.SystemUtils;
import java.util.LinkedList;
import java.util.List;

public abstract class PresenterGroup<V extends IGroupView> extends IPresenter<V> {

    /* renamed from: a */
    private static final int f12741a = 65280;

    /* renamed from: b */
    private static final int f12742b = 255;

    /* renamed from: c */
    private static final int f12743c = -65536;

    /* renamed from: d */
    private static final int f12744d = 65535;

    /* renamed from: e */
    private IPageSwitcher f12745e;

    /* renamed from: f */
    private PageState f12746f = PageState.NONE;

    /* renamed from: g */
    private Handler f12747g = new Handler();

    /* renamed from: h */
    private final List<IPresenter> f12748h = new LinkedList();

    /* renamed from: i */
    private final C5348a<IPresenter> f12749i = new C5348a<>();
    protected final Handler mUIHandler = new Handler(Looper.getMainLooper());

    private enum PageState {
        NONE,
        CREATED,
        STARTED,
        RESUMED,
        PAUSED,
        STOPPED,
        DESTROYED
    }

    /* access modifiers changed from: protected */
    public final int requestCodeForHost(int i) {
        return i;
    }

    public PresenterGroup(Context context, Bundle bundle) {
        super(context);
        this.f12740o = bundle;
    }

    public PresenterGroup(ComponentParams componentParams) {
        super(componentParams);
        this.f12740o = componentParams.extras;
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        if (bundle != null) {
            ((IGroupView) this.mView).setBackVisible(bundle.getBoolean(IGroupView.BACK_VISIBILITY, false));
        }
    }

    public final boolean addChild(IPresenter iPresenter, Bundle bundle) {
        if (!runOnUIThread()) {
            throw new RuntimeException("添加child必须在UI线程!");
        } else if (iPresenter == null) {
            throw new IllegalArgumentException("无法添加一个null的Presenter到父Presenter中!");
        } else if (iPresenter.getParent() != null) {
            throw new IllegalArgumentException(iPresenter + "已经添加到" + iPresenter.mParent + "中!");
        } else if (this.f12746f != PageState.DESTROYED) {
            iPresenter.setParent(this);
            this.f12748h.add(iPresenter);
            if (bundle == null) {
                bundle = this.f12740o;
            }
            iPresenter.f12740o = bundle;
            m8677a(iPresenter);
            return true;
        } else {
            throw new IllegalStateException("页面已经销毁,不能够再往里边添加组件!!!");
        }
    }

    public final boolean addChild(IPresenter iPresenter) {
        return addChild(iPresenter, (Bundle) null);
    }

    public final boolean removeChild(IPresenter iPresenter) {
        if (!runOnUIThread()) {
            throw new RuntimeException("移除child必须在UI线程执行!");
        } else if (this.f12746f == PageState.DESTROYED) {
            throw new IllegalStateException("页面已经销毁,已经没有任何组件了!!!");
        } else if (iPresenter == null || iPresenter.getParent() == null) {
            return false;
        } else {
            boolean remove = this.f12748h.remove(iPresenter);
            if (remove) {
                this.f12749i.mo48167a(iPresenter);
                m8679b(iPresenter);
            }
            iPresenter.setParent((PresenterGroup) null);
            return remove;
        }
    }

    public void setPageSwitcher(IPageSwitcher iPageSwitcher) {
        this.f12745e = iPageSwitcher;
    }

    /* access modifiers changed from: protected */
    public final IPageSwitcher getPageSwitcher() {
        return this.mParent != null ? this.mParent.getPageSwitcher() : this.f12745e;
    }

    /* access modifiers changed from: protected */
    public final void startActivityForResult(Intent intent, int i, Bundle bundle) {
        IPageSwitcher iPageSwitcher = this.f12745e;
        if (iPageSwitcher != null) {
            iPageSwitcher.startActivityForResult(intent, i, bundle);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo48141a(Intent intent, int i, Bundle bundle, IPresenter iPresenter) {
        IPageSwitcher iPageSwitcher;
        if (intent != null && iPresenter != null && (iPageSwitcher = this.f12745e) != null) {
            if (i == -1) {
                iPageSwitcher.startActivityForResult(intent, i, bundle);
                return;
            }
            this.f12745e.startActivityForResult(intent, mo48139a(iPresenter, i), bundle);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo48139a(IPresenter iPresenter, int i) {
        if (i == -1) {
            return i;
        }
        if ((65280 & i) == 0) {
            int a = this.f12749i.mo48165a(iPresenter, 1, 255);
            if (a > 0) {
                return (a << 8) | i;
            }
            throw new RuntimeException("子Presenter已经超过容量,请审核自己的代码!");
        }
        throw new RuntimeException("request code 必须在0到255之间");
    }

    public final void onDispatchActivityResult(int i, int i2, Intent intent) {
        int i3 = 65280 & i;
        if (i3 == 0) {
            onActivityResult(i, i2, intent);
            return;
        }
        IPresenter a = this.f12749i.mo48166a(i3 >> 8);
        if (a != null) {
            a.onActivityResult(i & -65281, i2, intent);
        }
    }

    public final void dispatchPageCreate() {
        onAdd(this.f12740o);
        for (int i = 0; i < this.f12748h.size(); i++) {
            IPresenter iPresenter = this.f12748h.get(i);
            iPresenter.onAdd(iPresenter.f12740o);
        }
        this.f12746f = PageState.CREATED;
    }

    public final void dispatchPageStart() {
        onPageStart();
        List<IPresenter> list = this.f12748h;
        int size = list != null ? list.size() : 0;
        for (int i = 0; i < size; i++) {
            this.f12748h.get(i).onPageStart();
        }
        this.f12746f = PageState.STARTED;
    }

    public final void dispatchPageResume() {
        onPageResume();
        List<IPresenter> list = this.f12748h;
        int size = list != null ? list.size() : 0;
        for (int i = 0; i < size; i++) {
            this.f12748h.get(i).onPageResume();
        }
        this.f12746f = PageState.RESUMED;
    }

    public final void dispatchPagePause() {
        onPagePause();
        List<IPresenter> list = this.f12748h;
        int size = list != null ? list.size() : 0;
        for (int i = 0; i < size; i++) {
            this.f12748h.get(i).onPagePause();
        }
        this.f12746f = PageState.PAUSED;
    }

    public final void dispatchPageStop() {
        onPageStop();
        List<IPresenter> list = this.f12748h;
        int size = list != null ? list.size() : 0;
        for (int i = 0; i < size; i++) {
            this.f12748h.get(i).onPageStop();
        }
        this.f12746f = PageState.STOPPED;
    }

    public final void dispatchPageDestroy() {
        this.mUIHandler.removeCallbacksAndMessages((Object) null);
        mo48104a();
        List<IPresenter> list = this.f12748h;
        for (int size = (list != null ? list.size() : 0) - 1; size >= 0; size--) {
            removeChild(this.f12748h.get(size));
        }
        this.f12746f = PageState.DESTROYED;
    }

    public final void dispatchOnPageShow() {
        onPageShow();
        List<IPresenter> list = this.f12748h;
        int size = list != null ? list.size() : 0;
        for (int i = 0; i < size; i++) {
            this.f12748h.get(i).onPageShow();
        }
    }

    public final void dispatchOnPageHide() {
        onPageHide();
        List<IPresenter> list = this.f12748h;
        int size = list != null ? list.size() : 0;
        for (int i = 0; i < size; i++) {
            this.f12748h.get(i).onPageHide();
        }
    }

    public final void dispatchLeaveHome() {
        onLeaveHome();
        List<IPresenter> list = this.f12748h;
        int size = list != null ? list.size() : 0;
        for (int i = 0; i < size; i++) {
            this.f12748h.get(i).onLeaveHome();
        }
    }

    public final void dispatchBackHome(Bundle bundle) {
        onBackHome(bundle);
        List<IPresenter> list = this.f12748h;
        int size = list != null ? list.size() : 0;
        for (int i = 0; i < size; i++) {
            this.f12748h.get(i).onBackHome(bundle);
        }
    }

    /* access modifiers changed from: protected */
    public boolean runOnUIThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    /* access modifiers changed from: protected */
    public final void showDialog(DialogInfo dialogInfo) {
        ((IGroupView) this.mView).showDialog(dialogInfo);
    }

    /* access modifiers changed from: protected */
    public final boolean isDialogShowing() {
        return ((IGroupView) this.mView).isDialogShowing();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo48142a(DialogInfo dialogInfo, IPresenter iPresenter) {
        dialogInfo.setDialogId(m8678b(dialogInfo.getDialogId(), iPresenter));
        showDialog(dialogInfo);
    }

    /* access modifiers changed from: protected */
    public final void dismissDialog(int i) {
        ((IGroupView) this.mView).dismissDialog(i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo48140a(int i, IPresenter iPresenter) {
        dismissDialog(m8678b(i, iPresenter));
    }

    public final void dispatchDialogAction(int i, int i2) {
        int i3 = (-65536 & i) >> 16;
        if (i3 == 0) {
            onDialogAction(i, i2);
            return;
        }
        IPresenter a = this.f12749i.mo48166a(i3);
        int i4 = i & 65535;
        if (a != null) {
            a.onDialogAction(i4, i2);
        }
    }

    /* access modifiers changed from: protected */
    public final void showToast(ToastHandler.ToastInfo toastInfo) {
        ((IGroupView) this.mView).showToast(toastInfo);
    }

    public final void setBackVisible(boolean z) {
        ((IGroupView) this.mView).setBackVisible(z);
    }

    public final void setTitle(String str) {
        ((IGroupView) this.mView).setTitle(str);
    }

    /* renamed from: b */
    private int m8678b(int i, IPresenter iPresenter) {
        if ((-65536 & i) == 0) {
            int a = this.f12749i.mo48165a(iPresenter, 1, 65535);
            if (a > 0) {
                return i | (a << 16);
            }
            throw new RuntimeException("在父容器中查找不到自身!");
        }
        throw new RuntimeException("Dialog id必须在0到65535之间");
    }

    public boolean dispatchBackPressed(IPresenter.BackType backType) {
        List<IPresenter> list = this.f12748h;
        for (int size = (list != null ? list.size() : 0) - 1; size >= 0; size--) {
            IPresenter iPresenter = this.f12748h.get(size);
            if (iPresenter != null) {
                boolean onBackPressed = iPresenter.onBackPressed(backType);
                SystemUtils.log(3, "dispatchBackPressed", iPresenter.getClass().getSimpleName(), (Throwable) null, "com.didi.component.core.PresenterGroup", 470);
                if (onBackPressed) {
                    return onBackPressed;
                }
            }
        }
        return onBackPressed(backType);
    }

    /* renamed from: com.didi.component.core.PresenterGroup$2 */
    static /* synthetic */ class C53362 {
        static final /* synthetic */ int[] $SwitchMap$com$didi$component$core$PresenterGroup$PageState;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.didi.component.core.PresenterGroup$PageState[] r0 = com.didi.component.core.PresenterGroup.PageState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$didi$component$core$PresenterGroup$PageState = r0
                com.didi.component.core.PresenterGroup$PageState r1 = com.didi.component.core.PresenterGroup.PageState.CREATED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$didi$component$core$PresenterGroup$PageState     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.component.core.PresenterGroup$PageState r1 = com.didi.component.core.PresenterGroup.PageState.STARTED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$didi$component$core$PresenterGroup$PageState     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.component.core.PresenterGroup$PageState r1 = com.didi.component.core.PresenterGroup.PageState.RESUMED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$didi$component$core$PresenterGroup$PageState     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.didi.component.core.PresenterGroup$PageState r1 = com.didi.component.core.PresenterGroup.PageState.PAUSED     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$didi$component$core$PresenterGroup$PageState     // Catch:{ NoSuchFieldError -> 0x003e }
                com.didi.component.core.PresenterGroup$PageState r1 = com.didi.component.core.PresenterGroup.PageState.STOPPED     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.component.core.PresenterGroup.C53362.<clinit>():void");
        }
    }

    /* renamed from: a */
    private void m8677a(IPresenter iPresenter) {
        Bundle bundle = iPresenter.f12740o;
        int i = C53362.$SwitchMap$com$didi$component$core$PresenterGroup$PageState[this.f12746f.ordinal()];
        if (i == 1) {
            iPresenter.onAdd(bundle);
        } else if (i == 2) {
            iPresenter.onAdd(bundle);
            iPresenter.onPageStart();
        } else if (i == 3) {
            iPresenter.onAdd(bundle);
            iPresenter.onPageStart();
            iPresenter.onPageResume();
        } else if (i == 4) {
            iPresenter.onAdd(bundle);
            iPresenter.onPageStart();
            iPresenter.onPageResume();
            iPresenter.onPagePause();
        } else if (i == 5) {
            iPresenter.onAdd(bundle);
            iPresenter.onPageStart();
            iPresenter.onPageResume();
            iPresenter.onPagePause();
            iPresenter.onPageStop();
        }
    }

    /* renamed from: b */
    private void m8679b(IPresenter iPresenter) {
        int i = C53362.$SwitchMap$com$didi$component$core$PresenterGroup$PageState[this.f12746f.ordinal()];
        if (i == 1) {
            iPresenter.onPageStart();
            iPresenter.onPageResume();
            iPresenter.onPagePause();
            iPresenter.onPageStop();
            iPresenter.mo48104a();
        } else if (i == 2) {
            iPresenter.onPageResume();
            iPresenter.onPagePause();
            iPresenter.onPageStop();
            iPresenter.mo48104a();
        } else if (i != 3) {
            if (i == 4) {
                iPresenter.onPageStop();
                iPresenter.mo48104a();
            } else if (i != 5) {
                return;
            }
            iPresenter.mo48104a();
        } else {
            iPresenter.onPagePause();
            iPresenter.onPageStop();
            iPresenter.mo48104a();
        }
    }

    public IView getView() {
        return this.mView;
    }

    /* access modifiers changed from: protected */
    public void forward(int i, Bundle bundle) {
        forward(i, bundle, (Animations) null);
    }

    /* access modifiers changed from: protected */
    public void forward(int i, Bundle bundle, Animations animations) {
        Class cls = (Class) templateMapping.get(Integer.valueOf(i));
        if (cls != null) {
            forward((Class<? extends Fragment>) cls, bundle, animations);
        }
    }

    /* access modifiers changed from: protected */
    public void forward(Class<? extends Fragment> cls, Bundle bundle) {
        forward(cls, bundle, (Animations) null);
    }

    /* access modifiers changed from: protected */
    public void forward(final Class<? extends Fragment> cls, final Bundle bundle, Animations animations) {
        this.f12747g.removeCallbacksAndMessages((Object) null);
        final IPageSwitcher pageSwitcher = getPageSwitcher();
        if (pageSwitcher != null) {
            long forwardDelay = forwardDelay();
            if (forwardDelay <= 0) {
                pageSwitcher.forward(cls, bundle, animations);
            } else {
                this.f12747g.postDelayed(new Runnable() {
                    public void run() {
                        pageSwitcher.forward((Class<? extends Fragment>) cls, bundle);
                    }
                }, forwardDelay);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void goBack() {
        goBack((Bundle) null);
    }

    /* access modifiers changed from: protected */
    public void goBack(Bundle bundle) {
        IPageSwitcher pageSwitcher = getPageSwitcher();
        if (pageSwitcher != null) {
            pageSwitcher.goBack(bundle);
        }
    }

    /* access modifiers changed from: protected */
    public void goBackRoot() {
        goBackRoot((Bundle) null);
    }

    /* access modifiers changed from: protected */
    public void goBackRoot(Bundle bundle) {
        IPageSwitcher pageSwitcher = getPageSwitcher();
        if (pageSwitcher != null) {
            pageSwitcher.goBackRoot(bundle);
        }
    }
}
