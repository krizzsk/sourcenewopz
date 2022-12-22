package com.didi.payment.commonsdk.p129ui;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.didi.commoninterfacelib.permission.TheOneBaseActivity;
import com.didi.commoninterfacelib.statuslightning.StatusBarLightingCompat;
import com.didi.payment.base.anti.AccessBlockEvent;
import com.didi.payment.base.anti.IAccessBlock;
import com.didi.payment.base.view.PayGlobalLoading;
import com.didi.payment.commonsdk.p129ui.FragmentSwitchVM;
import com.didi.payment.commonsdk.p129ui.WBaseViewModel;
import com.didi.payment.commonsdk.p129ui.event.BackStackEvent;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.view.titlebar.CommonTitleBar;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

@Metadata(mo175977d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B\u0005¢\u0006\u0002\u0010\u0006J \u0010 \u001a\u00020!2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020$H\u0014J\"\u0010 \u001a\u00020!2\n\u0010%\u001a\u0006\u0012\u0002\b\u00030&2\u0006\u0010'\u001a\u00020(2\u0006\u0010\"\u001a\u00020\u000eJ\u0010\u0010)\u001a\u00020!2\u0006\u0010*\u001a\u00020+H\u0016J\u0006\u0010,\u001a\u00020!J(\u0010-\u001a\u00020!2\u0006\u0010.\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010/\u001a\u00020\u00142\u0006\u0010#\u001a\u00020$H\u0014J\b\u00100\u001a\u000201H\u0016J\b\u00102\u001a\u00020\u000eH\u0016J\n\u00103\u001a\u0004\u0018\u000104H\u0014J\b\u00105\u001a\u00020!H\u0016J\b\u00106\u001a\u00020!H\u0016J\b\u00107\u001a\u00020!H\u0002J\b\u00108\u001a\u00020!H\u0014J\b\u00109\u001a\u00020!H\u0016J\b\u0010:\u001a\u00020\u0014H\u0016J\u0006\u0010;\u001a\u00020\u0014J\u0010\u0010<\u001a\u00020!2\u0006\u0010=\u001a\u00020>H\u0007J\u0012\u0010?\u001a\u00020!2\b\u0010@\u001a\u0004\u0018\u00010AH\u0017J\b\u0010B\u001a\u00020!H\u0016J\u0012\u0010C\u001a\u00020!2\b\u0010D\u001a\u0004\u0018\u00010(H\u0014J\b\u0010E\u001a\u00020!H\u0014J\b\u0010F\u001a\u00020\u000eH\u0016J\b\u0010G\u001a\u00020!H\u0014J\b\u0010H\u001a\u00020!H\u0014J\b\u0010I\u001a\u00020!H\u0014J\u0012\u0010J\u001a\u00020!2\b\u0010K\u001a\u0004\u0018\u00010(H\u0014J\b\u0010L\u001a\u00020\u0014H\u0016J\b\u0010M\u001a\u00020!H\u0016J\u0015\u0010N\u001a\u00020!2\u0006\u0010\u001a\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001eR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001a\u001a\u00028\u0000X.¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006O"}, mo175978d2 = {"Lcom/didi/payment/commonsdk/ui/WBaseActivity;", "T", "Lcom/didi/payment/commonsdk/ui/WBaseViewModel;", "Lcom/didi/commoninterfacelib/permission/TheOneBaseActivity;", "Landroidx/lifecycle/HasDefaultViewModelProviderFactory;", "Lcom/didi/payment/base/anti/IAccessBlock;", "()V", "errViewContainer", "Landroid/view/ViewGroup;", "getErrViewContainer", "()Landroid/view/ViewGroup;", "setErrViewContainer", "(Landroid/view/ViewGroup;)V", "fragmentChildIndex", "", "getFragmentChildIndex", "()I", "setFragmentChildIndex", "(I)V", "isVisibleToUser", "", "()Z", "setVisibleToUser", "(Z)V", "rootFragment", "Landroidx/fragment/app/Fragment;", "vm", "getVm", "()Lcom/didi/payment/commonsdk/ui/WBaseViewModel;", "setVm", "(Lcom/didi/payment/commonsdk/ui/WBaseViewModel;)V", "Lcom/didi/payment/commonsdk/ui/WBaseViewModel;", "attachRootFragment", "", "containerId", "fragTag", "", "fragmentClz", "Ljava/lang/Class;", "extras", "Landroid/os/Bundle;", "decoretaTitlebar", "titleBar", "Lcom/didi/sdk/view/titlebar/CommonTitleBar;", "displayError", "forwardFragment", "fragment", "addTobackstack", "getDefaultViewModelProviderFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getFragmentContainer", "getTitleBarView", "Landroid/view/View;", "hideLoading", "initContentView", "initPageSwitcherVM", "initStatusBar", "initTitleBar", "isNeedFinish", "isVisible2User", "listenBackstackEvent", "backStackEvent", "Lcom/didi/payment/commonsdk/ui/event/BackStackEvent;", "onAccessBlock", "event", "Lcom/didi/payment/base/anti/AccessBlockEvent;", "onBackPressed", "onCreate", "savedInstanceState", "onDestroy", "onInflateContentLayout", "onPause", "onReceivePopbackEvent", "onResume", "popBackToFrontPage", "extras4NextTop", "registeBackstackEvent", "showLoading", "subscribeUi", "wallet-service-commonsdk_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.commonsdk.ui.WBaseActivity */
/* compiled from: WBaseActivity.kt */
public abstract class WBaseActivity<T extends WBaseViewModel> extends TheOneBaseActivity implements HasDefaultViewModelProviderFactory, IAccessBlock {

    /* renamed from: a */
    private ViewGroup f30173a;

    /* renamed from: b */
    private boolean f30174b;

    /* renamed from: c */
    private Fragment f30175c;

    /* renamed from: d */
    private int f30176d;

    /* renamed from: vm */
    protected T f30177vm;

    public final void displayError() {
    }

    public int getFragmentContainer() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public View getTitleBarView() {
        return null;
    }

    public void initContentView() {
    }

    public void initTitleBar() {
    }

    public boolean isNeedFinish() {
        return true;
    }

    public int onInflateContentLayout() {
        return -9999;
    }

    /* access modifiers changed from: protected */
    public void onReceivePopbackEvent() {
    }

    public boolean registeBackstackEvent() {
        return true;
    }

    /* access modifiers changed from: protected */
    public final T getVm() {
        T t = this.f30177vm;
        if (t != null) {
            return t;
        }
        Intrinsics.throwUninitializedPropertyAccessException("vm");
        return null;
    }

    /* access modifiers changed from: protected */
    public final void setVm(T t) {
        Intrinsics.checkNotNullParameter(t, "<set-?>");
        this.f30177vm = t;
    }

    /* access modifiers changed from: protected */
    public final ViewGroup getErrViewContainer() {
        return this.f30173a;
    }

    /* access modifiers changed from: protected */
    public final void setErrViewContainer(ViewGroup viewGroup) {
        this.f30173a = viewGroup;
    }

    public final boolean isVisibleToUser() {
        return this.f30174b;
    }

    public final void setVisibleToUser(boolean z) {
        this.f30174b = z;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        initStatusBar();
        super.onCreate(bundle);
        m21125a();
        if (onInflateContentLayout() != -9999) {
            setContentView(onInflateContentLayout());
            initTitleBar();
            initContentView();
        }
        if (registeBackstackEvent()) {
            EventBus.getDefault().register(this);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void listenBackstackEvent(BackStackEvent backStackEvent) {
        Intrinsics.checkNotNullParameter(backStackEvent, "backStackEvent");
        onReceivePopbackEvent();
    }

    /* access modifiers changed from: protected */
    public void initStatusBar() {
        setTheme(R.style.GlobalActivityTheme);
        StatusBarLightingCompat.setStatusBarBgLightning(this, true, ContextCompat.getColor(this, R.color.transparent));
    }

    public void decoretaTitlebar(CommonTitleBar commonTitleBar) {
        Intrinsics.checkNotNullParameter(commonTitleBar, "titleBar");
        TextView middleTv = commonTitleBar.getMiddleTv();
        if (middleTv != null) {
            middleTv.setTypeface(Typeface.defaultFromStyle(1));
        }
        TextView middleTv2 = commonTitleBar.getMiddleTv();
        if (middleTv2 != null) {
            middleTv2.setTextSize(2, 20.0f);
        }
        ImageView leftImgView = commonTitleBar.getLeftImgView();
        if (leftImgView != null) {
            leftImgView.setImageResource(R.drawable.common_title_back_arrow);
        }
        View findViewById = commonTitleBar.findViewById(R.id.common_title_bar_line);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
    }

    /* renamed from: a */
    private final void m21125a() {
        ViewModel viewModel = new ViewModelProvider(this).get(FragmentSwitchVM.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this).…mentSwitchVM::class.java)");
        FragmentSwitchVM fragmentSwitchVM = (FragmentSwitchVM) viewModel;
        LifecycleOwner lifecycleOwner = this;
        fragmentSwitchVM.getFragmengSwitchLD().observe(lifecycleOwner, new Observer() {
            public final void onChanged(Object obj) {
                WBaseActivity.m21126a(WBaseActivity.this, (FragmentSwitchVM.ForwardAction) obj);
            }
        });
        fragmentSwitchVM.getFragmengSwitchLD2().observe(lifecycleOwner, new Observer() {
            public final void onChanged(Object obj) {
                WBaseActivity.m21127a(WBaseActivity.this, (FragmentSwitchVM.PageSwitch) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21126a(WBaseActivity wBaseActivity, FragmentSwitchVM.ForwardAction forwardAction) {
        Object obj;
        Intrinsics.checkNotNullParameter(wBaseActivity, "this$0");
        Class<?> targetPageClz = forwardAction.getTargetPageClz();
        if (targetPageClz == null) {
            obj = null;
        } else {
            obj = targetPageClz.newInstance();
        }
        if (obj instanceof Fragment) {
            Fragment fragment = (Fragment) obj;
            if (forwardAction.getExtras() != null) {
                fragment.setArguments(forwardAction.getExtras());
            }
            wBaseActivity.forwardFragment(fragment, wBaseActivity.getFragmentContainer(), true, Intrinsics.stringPlus(fragment.getClass().getName(), "Tag"));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21127a(WBaseActivity wBaseActivity, FragmentSwitchVM.PageSwitch pageSwitch) {
        Intrinsics.checkNotNullParameter(wBaseActivity, "this$0");
        if (pageSwitch.getPopCurrentFragment()) {
            wBaseActivity.popBackToFrontPage(pageSwitch.getExtras());
        } else if (pageSwitch.getMforwardPageClz() != null) {
            Class<? extends WBaseFragment<WBaseViewModel>> mforwardPageClz = pageSwitch.getMforwardPageClz();
            Intrinsics.checkNotNull(mforwardPageClz);
            WBaseFragment wBaseFragment = (WBaseFragment) mforwardPageClz.newInstance();
            if (wBaseFragment != null) {
                wBaseActivity.forwardFragment(wBaseFragment, wBaseActivity.getFragmentContainer(), true, Intrinsics.stringPlus(wBaseFragment.getClass().getName(), "Tag"));
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.Fragment");
        }
    }

    public final void attachRootFragment(Class<?> cls, Bundle bundle, int i) {
        Intrinsics.checkNotNullParameter(cls, "fragmentClz");
        Intrinsics.checkNotNullParameter(bundle, "extras");
        Object newInstance = cls.newInstance();
        if (newInstance instanceof Fragment) {
            Fragment fragment = (Fragment) newInstance;
            fragment.setArguments(bundle);
            attachRootFragment(fragment, i, Intrinsics.stringPlus(cls.getCanonicalName(), "_tag"));
        }
    }

    public void subscribeUi(T t) {
        Intrinsics.checkNotNullParameter(t, "vm");
        LifecycleOwner lifecycleOwner = this;
        t.isLoading().observe(lifecycleOwner, new Observer() {
            public final void onChanged(Object obj) {
                WBaseActivity.m21128a(WBaseActivity.this, (Boolean) obj);
            }
        });
        t.isNetError().observe(lifecycleOwner, new Observer() {
            public final void onChanged(Object obj) {
                WBaseActivity.m21129b(WBaseActivity.this, (Boolean) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21128a(WBaseActivity wBaseActivity, Boolean bool) {
        Intrinsics.checkNotNullParameter(wBaseActivity, "this$0");
        Intrinsics.checkNotNullExpressionValue(bool, "isLoading");
        if (bool.booleanValue()) {
            wBaseActivity.showLoading();
        } else {
            wBaseActivity.hideLoading();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m21129b(WBaseActivity wBaseActivity, Boolean bool) {
        Intrinsics.checkNotNullParameter(wBaseActivity, "this$0");
        ViewGroup errViewContainer = wBaseActivity.getErrViewContainer();
        if (errViewContainer != null) {
            Intrinsics.checkNotNullExpressionValue(bool, "isNetError");
            errViewContainer.setVisibility(bool.booleanValue() ? 0 : 8);
        }
    }

    public void showLoading() {
        if (getTitleBarView() != null) {
            PayGlobalLoading.show(getTitleBarView(), true);
        }
    }

    public void hideLoading() {
        if (getTitleBarView() != null) {
            PayGlobalLoading.hide(getTitleBarView());
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.f30174b = true;
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.f30174b = true;
    }

    public final boolean isVisible2User() {
        return this.f30174b;
    }

    /* access modifiers changed from: protected */
    public void attachRootFragment(Fragment fragment, int i, String str) {
        Intrinsics.checkNotNullParameter(fragment, "rootFragment");
        Intrinsics.checkNotNullParameter(str, "fragTag");
        this.f30175c = fragment;
        forwardFragment(fragment, i, false, str);
    }

    public final int getFragmentChildIndex() {
        return this.f30176d;
    }

    public final void setFragmentChildIndex(int i) {
        this.f30176d = i;
    }

    /* access modifiers changed from: protected */
    public void forwardFragment(Fragment fragment, int i, boolean z, String str) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(str, "fragTag");
        if (i > 0) {
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
            FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
            Intrinsics.checkNotNullExpressionValue(beginTransaction, "fm.beginTransaction()");
            View findViewById = findViewById(i);
            if (findViewById.getVisibility() != 0) {
                findViewById.setVisibility(0);
            }
            beginTransaction.add(i, fragment, Intrinsics.stringPlus(fragment.getClass().getSimpleName(), "_tag"));
            if (z) {
                int i2 = this.f30176d;
                this.f30176d = i2 + 1;
                beginTransaction.addToBackStack(Intrinsics.stringPlus(str, Integer.valueOf(i2)));
            }
            beginTransaction.commitAllowingStateLoss();
            return;
        }
        throw new IllegalArgumentException(Intrinsics.stringPlus("fragment contianer id invalid in activity: ", getClass().getSimpleName()).toString());
    }

    public void onBackPressed() {
        int backStackEntryCount = getSupportFragmentManager().getBackStackEntryCount();
        if (backStackEntryCount > 0) {
            FragmentManager.BackStackEntry backStackEntryAt = getSupportFragmentManager().getBackStackEntryAt(backStackEntryCount - 1);
            Intrinsics.checkNotNullExpressionValue(backStackEntryAt, "supportFragmentManager.g…tryAt(backEntryCount - 1)");
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(backStackEntryAt.getName());
            if (findFragmentByTag != null && (findFragmentByTag instanceof WBaseFragment) && ((WBaseFragment) findFragmentByTag).onBackKeyPressed()) {
                return;
            }
        } else {
            Fragment fragment = this.f30175c;
            if (fragment != null && (fragment instanceof WBaseFragment)) {
                ((WBaseFragment) fragment).onBackKeyPressed();
            }
        }
        super.onBackPressed();
    }

    /* access modifiers changed from: protected */
    public void popBackToFrontPage(Bundle bundle) {
        String string;
        Fragment findFragmentByTag;
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
            if (bundle != null && (string = bundle.getString("source_page")) != null && (findFragmentByTag = getSupportFragmentManager().findFragmentByTag(string)) != null) {
                findFragmentByTag.setArguments(bundle);
                SystemUtils.log(3, "w_common", Intrinsics.stringPlus("success set argument to fragment: ", findFragmentByTag), (Throwable) null, "com.didi.payment.commonsdk.ui.WBaseActivity", 274);
                if (findFragmentByTag instanceof WBaseFragment) {
                    ((WBaseFragment) findFragmentByTag).onBackToFront();
                    return;
                }
                return;
            }
            return;
        }
        finish();
    }

    public ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        return new ViewModelProvider.AndroidViewModelFactory(getApplication());
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        if (registeBackstackEvent()) {
            EventBus.getDefault().unregister(this);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onAccessBlock(AccessBlockEvent accessBlockEvent) {
        if (isNeedFinish()) {
            finish();
        }
    }
}
