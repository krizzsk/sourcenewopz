package com.didi.soda.customer;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.didi.app.nova.skeleton.PageInstrument;
import com.didi.app.nova.skeleton.PageInstrumentFactory;
import com.didi.app.nova.skeleton.Skeleton;
import com.didi.app.nova.skeleton.conductor.ChangeHandlerFrameLayout;
import com.didi.app.nova.skeleton.conductor.embed.FragmentLifecycle;
import com.didi.app.nova.skeleton.image.Fly;
import com.didi.common.map.model.LatLng;
import com.didi.sdk.home.BizEntranceFragment;
import com.didi.sdk.sidebar.setup.mutilocale.MultiLocaleUtil;
import com.didi.soda.address.AndroidBug5497Workaround;
import com.didi.soda.customer.app.CustomerApplicationLifecycleHandler;
import com.didi.soda.customer.app.FlyInitializer;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.base.pages.CustomerPage;
import com.didi.soda.customer.base.rxdux.SkeletonStore;
import com.didi.soda.customer.biz.order.OrderMixService;
import com.didi.soda.customer.biz.scheme.SchemeHelper;
import com.didi.soda.customer.flutter.FlutterInitialisation;
import com.didi.soda.customer.foundation.fusion.CustomerRFusionManager;
import com.didi.soda.customer.foundation.log.lifecycle.SkeletonTracer;
import com.didi.soda.customer.foundation.map.location.LocationRepo;
import com.didi.soda.customer.foundation.p164im.ImMessageHelper;
import com.didi.soda.customer.foundation.report.CustomerUserEventReporter;
import com.didi.soda.customer.foundation.skin.SkinUtil;
import com.didi.soda.customer.foundation.tracker.performance.ConversionOmegaHelper;
import com.didi.soda.customer.foundation.util.LocationUtil;
import com.didi.soda.customer.foundation.util.OnceActionUtil;
import com.didi.soda.customer.foundation.util.SingletonFactory;
import com.didi.soda.customer.foundation.util.ToastUtil;
import com.didi.soda.customer.mlocale.LocaleServiceEmb;
import com.didi.soda.customer.p165h5.WebHelper;
import com.didi.soda.customer.repo.CustomerActivityResultRepo;
import com.didi.soda.customer.repo.RepoFactory;
import com.didi.soda.customer.widget.dialog.CustomerDialogFrameLayout;
import com.didi.soda.customer.widget.dialog.SodaWindowFactory;
import com.didi.soda.home.page.CustomerMainPage;
import com.didi.soda.router.DiRouter;
import com.didi.soda.router.IRouterCallback;
import com.taxis99.R;

public class CustomerFragment extends BizEntranceFragment implements KeyEvent.Callback {

    /* renamed from: a */
    private FragmentLifecycle f40143a;

    /* renamed from: b */
    private PageInstrument f40144b;

    /* renamed from: c */
    private CustomerDialogFrameLayout f40145c;

    /* renamed from: d */
    private SkeletonStore f40146d;

    /* renamed from: e */
    private boolean f40147e;

    /* renamed from: f */
    private View f40148f;

    /* access modifiers changed from: protected */
    public boolean isDirectOpen() {
        return false;
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

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.f40143a.onActivityResult(i, i2, intent);
        ((CustomerActivityResultRepo) RepoFactory.getRepo(CustomerActivityResultRepo.class)).dispatchResult(i, i2, intent);
    }

    public void onAttach(final Context context) {
        super.onAttach(context);
        SkinUtil.initSkinConfig();
        WebHelper.init((Application) context.getApplicationContext());
        ImMessageHelper.getInstance().setMerchantCommonWords(context);
        ImMessageHelper.getInstance().setRiderCommonWords(context);
        CustomerRFusionManager.initRFusion((Application) context.getApplicationContext());
        DiRouter.init("taxis99OneTravel://soda", (IRouterCallback) null);
        this.f40143a = PageInstrumentFactory.install(this);
        CustomerApplicationLifecycleHandler.getInstance().initLifecycle(getActivity().getApplication());
        CustomerUserEventReporter.INSTANCE.bindApplicationLifecycle();
        CustomerUserEventReporter.INSTANCE.reportTabIn();
        FlyInitializer.init(getContext().getApplicationContext());
        Skeleton.setLifeTracer(new SkeletonTracer());
        LocationUtil.getCurrentLocationOnce(new LocationUtil.LocationCallback() {
            public void onLocationError() {
            }

            public void onLocationSuccess(LatLng latLng) {
                ((LocationRepo) RepoFactory.getRepo(LocationRepo.class)).reverseLocation(context, LocationUtil.getCurrentLatLng());
            }
        });
        ConversionOmegaHelper.trackTabIn(getArguments());
        if (getContext() != null) {
            String locale = MultiLocaleUtil.getLanguageModel().getLocale();
            if (TextUtils.isEmpty(locale)) {
                locale = "en-US";
            }
            LocaleServiceEmb.getInstance().initEmb(getContext(), locale);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        this.f40143a.onCreateOptionsMenu(menu, menuInflater);
    }

    /* renamed from: a */
    private View m28557a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        GlobalContext.setBusinessContext(getBusinessContext());
        FrameLayout frameLayout = (FrameLayout) layoutInflater.inflate(R.layout.fragment_soda_customer, viewGroup, false);
        ChangeHandlerFrameLayout changeHandlerFrameLayout = (ChangeHandlerFrameLayout) frameLayout.findViewById(R.id.customer_conductor_root_layout);
        changeHandlerFrameLayout.setPadding(0, 0, 0, 0);
        PageInstrument create = PageInstrumentFactory.create(this, changeHandlerFrameLayout, bundle);
        this.f40144b = create;
        GlobalContext.setPageInstrument(create);
        GlobalContext.setFragment(this);
        SkeletonStore.createStore(this.f40144b);
        if (!this.f40144b.hasRootPage()) {
            this.f40144b.setRootPage(m28558a());
        }
        CustomerDialogFrameLayout customerDialogFrameLayout = (CustomerDialogFrameLayout) frameLayout.findViewById(R.id.customer_loading_root_layout);
        this.f40145c = customerDialogFrameLayout;
        this.f40144b.attachDialogFrame(customerDialogFrameLayout);
        this.f40147e = true;
        OrderMixService.getInstance().start();
        SchemeHelper.delayOpenPage();
        ToastUtil.bindToastContainer(frameLayout);
        FlutterInitialisation.initFlutter(getActivity().getApplicationContext(), getActivity(), this.f40144b);
        return frameLayout;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (!GlobalContext.isSuperApp()) {
            return m28557a(layoutInflater, viewGroup, bundle);
        }
        if (this.f40148f == null) {
            this.f40148f = m28557a(layoutInflater, viewGroup, bundle);
        }
        return this.f40148f;
    }

    /* renamed from: a */
    private CustomerPage m28558a() {
        CustomerMainPage customerMainPage = new CustomerMainPage(GlobalContext.isSuperApp(), isDirectOpen());
        customerMainPage.setArgs(getArguments());
        return customerMainPage;
    }

    public void onDestroy() {
        ConversionOmegaHelper.trackTabOut();
        super.onDestroy();
        SchemeHelper.recycle();
        this.f40147e = false;
        if (!GlobalContext.isFragmentInited()) {
            OrderMixService.getInstance().stop();
        }
        Fly.clearMemory();
    }

    public void onDetach() {
        super.onDetach();
        CustomerUserEventReporter.INSTANCE.reportTabOut();
        CustomerUserEventReporter.INSTANCE.unBindApplicationLifecycle();
        m28559b();
    }

    public void onDestroyView() {
        super.onDestroyView();
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4) {
            return false;
        }
        PageInstrument pageInstrument = this.f40144b;
        boolean z = true;
        if (pageInstrument == null) {
            return true;
        }
        if (pageInstrument.getBackstackSize() != 1) {
            z = false;
        }
        boolean handleBack = this.f40144b.handleBack();
        if (z) {
            return false;
        }
        return handleBack;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return this.f40143a.onOptionsItemSelected(menuItem);
    }

    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        this.f40143a.onPrepareOptionsMenu(menu);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        this.f40143a.onRequestPermissionsResult(i, strArr, iArr);
    }

    public void onStart() {
        super.onStart();
        AndroidBug5497Workaround.getInstance(getActivity()).assistGlobalDialog(this.f40145c);
    }

    public void onStop() {
        super.onStop();
        AndroidBug5497Workaround.getInstance(getActivity()).destroyGlobal();
    }

    public boolean shouldShowRequestPermissionRationale(String str) {
        return this.f40143a.shouldShowRequestPermissionRationale(str);
    }

    public void onLeaveHome() {
        super.onLeaveHome();
        GlobalContext.setInHome(false);
    }

    public void onBackToHome() {
        super.onBackToHome();
        GlobalContext.setInHome(true);
        if (GlobalContext.isInRoot()) {
            GlobalContext.getTitleAndBizBarManager().showTitleBarAndBizBar();
        } else {
            GlobalContext.getTitleAndBizBarManager().hideTitleBarAndBizBar();
        }
    }

    public boolean isFragmentInited() {
        return this.f40147e;
    }

    /* renamed from: b */
    private void m28559b() {
        SingletonFactory.clear();
        RepoFactory.clearAll();
        CustomerApplicationLifecycleHandler.getInstance().clear();
        OnceActionUtil.resetGlobalActions();
        SodaWindowFactory.clearLoadingDialog();
        Fly.clearMemory();
        SkeletonStore.destory();
        this.f40148f = null;
    }
}
