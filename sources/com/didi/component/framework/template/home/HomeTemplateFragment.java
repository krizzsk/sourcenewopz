package com.didi.component.framework.template.home;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.util.BusinessUtils;
import com.didi.component.business.util.FragmentUtils;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.common.base.ComponentType;
import com.didi.component.common.helper.SceneHelper;
import com.didi.component.common.track.DidiTrackingClient;
import com.didi.component.common.util.GoBackRootUtils;
import com.didi.component.common.util.UIUtils;
import com.didi.component.comp_xpanel.view.GlobalHomeXPanelView;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.framework.template.common.CommonTemplateFragment;
import com.didi.sdk.app.BaseMainActivity;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.home.bizbar.BizNavBarEvent;
import com.didi.sdk.misconfig.model.CarInfo;
import com.didi.sdk.service.ForegroundLauncher;
import com.didi.sdk.sidebar.SidebarEvent;
import com.didi.sdk.sidebar.fragment.HomeNavDrawerFragment;
import com.didi.sdk.util.AppUtils;
import com.didi.sdk.util.EventKeys;
import com.didi.sdk.util.GlobalViewUtils;
import com.didi.sdk.util.SaApolloUtil;
import com.didi.sdk.weight.SaBackLayout;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.taxis99.R;
import java.io.Serializable;
import java.util.HashMap;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

@ServiceProvider(alias = "ride", value = {Fragment.class})
public class HomeTemplateFragment extends CommonTemplateFragment {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public BusinessContext f13967a;

    /* access modifiers changed from: protected */
    public int currentBID() {
        return 30008;
    }

    /* access modifiers changed from: protected */
    public int currentComboType() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public int currentPageId() {
        return 1001;
    }

    /* access modifiers changed from: protected */
    public boolean isRemoveSugContainer() {
        return true;
    }

    public void onCreate(Bundle bundle) {
        Serializable serializable;
        super.onCreate(bundle);
        GlobalOmegaUtils.putGlobal("g_PageId", "home");
        BusinessContext businessContext = getBusinessContext();
        this.f13967a = businessContext;
        GlobalOmegaUtils.setBusinessId(businessContext);
        m9710a();
        this.mLogger.info("Home Page onCreate", new Object[0]);
        if (getContext() != null) {
            ForegroundLauncher.stopForeground(getContext());
        }
        this.f13967a.setBizBarBackgroundColor(0);
        SceneHelper instance = SceneHelper.getInstance();
        try {
            Bundle arguments = getArguments();
            if (arguments != null && (serializable = arguments.getSerializable("sa_entry")) != null) {
                instance.setFromSA(true, (HashMap) serializable);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public View onCreateViewImpl(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mCompContainer = new RelativeLayout(getContext());
        this.mCompContainer.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.mRootView = this.mCompContainer;
        initComponents(this.mCompContainer);
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
        if (SaApolloUtil.INSTANCE.getSaState()) {
            SaBackLayout saBackLayout = new SaBackLayout(this.f13967a.getContext());
            saBackLayout.setOnBackListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    HomeTemplateFragment.this.f13967a.getNavigation().popBackStack();
                }
            });
            this.mCompContainer.addView(saBackLayout);
        }
        return this.mRootView;
    }

    /* access modifiers changed from: protected */
    public void onResumeImpl() {
        super.onResumeImpl();
        SceneHelper.getInstance().setHomeOnResume(true);
        if (GoBackRootUtils.isBackHome) {
            GoBackRootUtils.isBackHome = false;
            onBackToHome();
        }
    }

    /* access modifiers changed from: protected */
    public void onBackHomeImpl() {
        GlobalOmegaUtils.putGlobal("g_PageId", "home");
    }

    /* renamed from: a */
    private void m9710a() {
        CarInfo defaultConfCarInfo = BusinessUtils.getDefaultConfCarInfo(getBusinessContext());
        if (defaultConfCarInfo != null) {
            FormStore.getInstance().initData(defaultConfCarInfo.getBusinessId(), defaultConfCarInfo.getBusinessNumId(), defaultConfCarInfo.getComboType());
            FormStore.getInstance().setCarLevel(defaultConfCarInfo.getCarLevel());
        }
        DidiTrackingClient.getInstance().getTrackingApollo();
    }

    /* access modifiers changed from: protected */
    public HomeTemplatePresenter onCreateTopPresenter() {
        return new HomeTemplatePresenter(this.f13967a, getArguments());
    }

    /* access modifiers changed from: protected */
    public void initComponents(RelativeLayout relativeLayout) {
        int dimension = (int) getResources().getDimension(R.dimen.common_padding);
        inflateComponent(ComponentType.NEWBEE_COUPON, relativeLayout, new RelativeLayout.LayoutParams(-1, -1));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, dimension, dimension);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        inflateComponent(ComponentType.RESET_LOCATION, relativeLayout, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(12);
        layoutParams2.setMargins(dimension, dimension, UIUtils.dip2pxInt(getContext(), 65.0f), dimension);
        layoutParams2.addRule(9);
        inflateComponent(ComponentType.SAFE_JARVIS, relativeLayout, layoutParams2);
        inflateComponent(ComponentType.NEW_OPEN_RIDE, (ViewGroup) null, new RelativeLayout.LayoutParams(-2, -2));
        int statusBarHeight = AppUtils.getStatusBarHeight(getContext());
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.setMargins(0, statusBarHeight, 0, 0);
        layoutParams3.addRule(11);
        inflateComponent(ComponentType.SAVING_CENTER, relativeLayout, layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams4.bottomMargin = m9707a(this.f13967a.getBizBarHeight());
        inflateComponent(ComponentType.XPANEL, relativeLayout, layoutParams4);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams5.setMargins(0, 0, 0, 0);
        layoutParams5.addRule(12);
        inflateComponent(ComponentType.GLOBAL_XBANNER, relativeLayout, layoutParams5);
        inflateViewlessComponents(ComponentType.GLOBAL_XENGINE, "service", "map_flow", "deeplink", ComponentType.SPLIT_FARE);
    }

    public View getFallbackView() {
        if (getActivity() instanceof BaseMainActivity) {
            Fragment titleBarFragment = ((BaseMainActivity) getActivity()).getTitleBarFragment();
            HomeNavDrawerFragment drawerFragment = ((BaseMainActivity) getActivity()).getDrawerFragment();
            Fragment topFragment = FragmentUtils.getTopFragment(getActivity());
            if (titleBarFragment != null && drawerFragment != null && !drawerFragment.isDrawerOpen() && topFragment == null) {
                return titleBarFragment.getView();
            }
        }
        return super.getFallbackView();
    }

    /* access modifiers changed from: protected */
    public void onPauseImpl() {
        super.onPauseImpl();
        SceneHelper.getInstance().setHomeOnResume(false);
    }

    public void onDestroyViewImpl() {
        super.onDestroyViewImpl();
        this.f13967a.hideTitleBarRightBtn();
        EventBus.getDefault().unregister(this);
    }

    public void showLoadingOnTitleBar() {
        super.showLoadingOnTitleBar();
    }

    public void hideLoading() {
        hidePageLoading();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public int m9707a(int i) {
        return i > 0 ? i - GlobalViewUtils.dipToPx(this.mCompContainer.getContext(), 20) : i;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onReceive(final BizNavBarEvent bizNavBarEvent) {
        if (bizNavBarEvent == null) {
            return;
        }
        if (1 == bizNavBarEvent.state) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public void run() {
                    if (HomeTemplateFragment.this.mCompContainer != null) {
                        for (int i = 0; i < HomeTemplateFragment.this.mCompContainer.getChildCount(); i++) {
                            if (GlobalHomeXPanelView.class.getName().equals(HomeTemplateFragment.this.mCompContainer.getChildAt(i).getTag())) {
                                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                                layoutParams.bottomMargin = HomeTemplateFragment.this.m9707a(bizNavBarEvent.height);
                                HomeTemplateFragment.this.mCompContainer.getChildAt(i).setLayoutParams(layoutParams);
                            }
                        }
                        BaseEventPublisher.getPublisher().publish(BaseEventKeys.Home.EVENT_SHOW_NAV_BAR, Integer.valueOf(bizNavBarEvent.height));
                    }
                }
            });
        } else if (3 == bizNavBarEvent.state) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public void run() {
                    if (HomeTemplateFragment.this.mCompContainer != null) {
                        for (int i = 0; i < HomeTemplateFragment.this.mCompContainer.getChildCount(); i++) {
                            if (GlobalHomeXPanelView.class.getName().equals(HomeTemplateFragment.this.mCompContainer.getChildAt(i).getTag())) {
                                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                                layoutParams.bottomMargin = 0;
                                HomeTemplateFragment.this.mCompContainer.getChildAt(i).setLayoutParams(layoutParams);
                            }
                        }
                        BaseEventPublisher.getPublisher().publish(BaseEventKeys.Home.EVENT_SHOW_NAV_BAR, 0);
                    }
                }
            });
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onSidebarAction(SidebarEvent sidebarEvent) {
        if (EventKeys.Sidebar.CLOSE_SIDEBAR.equalsIgnoreCase(sidebarEvent.type) && (this.mTopPresenter instanceof HomeTemplatePresenter)) {
            ((HomeTemplatePresenter) this.mTopPresenter).trackPageShowEvent("AMA", (HashMap<String, Object>) null);
        }
    }
}
