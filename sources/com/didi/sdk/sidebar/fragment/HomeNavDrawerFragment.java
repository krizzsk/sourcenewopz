package com.didi.sdk.sidebar.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.legacy.app.ActionBarDrawerToggle;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.app.BaseBusinessContext;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.events.IMRefreshEvent;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.sidebar.PageDecorator;
import com.didi.sdk.sidebar.SidebarEvent;
import com.didi.sdk.sidebar.ViewAssembler;
import com.didi.sdk.sidebar.component.AbsComponent;
import com.didi.sdk.sidebar.component.ComponentFactory;
import com.didi.sdk.sidebar.data.DataContainer;
import com.didi.sdk.sidebar.model.SidebarItem;
import com.didi.sdk.sidebar.model.SidebarPage;
import com.didi.sdk.util.EventKeys;
import com.didi.usercenter.api.UserCenterFacade;
import com.didi.usercenter.entity.UserInfo;
import com.didichuxing.foundation.rpc.RpcService;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.didiglobal.travel.util.CollectionUtils;
import com.didiglobal.travel.util.view.ViewEx;
import com.taxis99.R;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class HomeNavDrawerFragment extends Fragment {

    /* renamed from: b */
    private static final String f37262b = "HomeNavDrawerFragment";

    /* renamed from: c */
    private static final Object f37263c = new Object();

    /* renamed from: a */
    private Logger f37264a = LoggerFactory.getLogger("DataContainer");

    /* renamed from: d */
    private BaseBusinessContext f37265d;

    /* renamed from: e */
    private SidebarPage f37266e;

    /* renamed from: f */
    private boolean f37267f;

    /* renamed from: g */
    private DrawerLayout f37268g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public ActionBarDrawerToggle f37269h;

    /* renamed from: i */
    private View f37270i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public ViewAssembler f37271j;

    /* renamed from: k */
    private LinearLayout f37272k;

    /* renamed from: l */
    private ViewStub f37273l;

    /* access modifiers changed from: protected */
    public void fixBarrierFree(View view) {
    }

    /* access modifiers changed from: protected */
    public int getRootLayoutId() {
        return R.layout.slide_bar_view;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f37264a.info("onCreate register ", new Object[0]);
        EventBus.getDefault().register(this);
    }

    public void onDestroy() {
        super.onDestroy();
        this.f37264a.info("onDestroy unregister ", new Object[0]);
        EventBus.getDefault().unregister(this);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflateViewAsync = ViewEx.inflateViewAsync(layoutInflater, getRootLayoutId(), (ViewGroup) null, false);
        this.f37270i = inflateViewAsync;
        this.f37273l = (ViewStub) inflateViewAsync.findViewById(R.id.new_slide_bar_view_stub);
        return this.f37270i;
    }

    public void setDrawerLayout(DrawerLayout drawerLayout) {
        this.f37268g = drawerLayout;
    }

    public void setBusinessContext(BusinessContext businessContext) {
        this.f37265d = businessContext;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void openSidebar(SidebarEvent sidebarEvent) {
        if (EventKeys.Sidebar.OPEN_SIDEBAR.equalsIgnoreCase(sidebarEvent.type)) {
            Logger logger = this.f37264a;
            logger.info("openSidebar hasInit = " + this.f37267f + ", pageData = " + this.f37266e, new Object[0]);
            if (NationTypeUtil.getNationComponentData().getLoginInfo().isLoginNow()) {
                UserCenterFacade.getIns().fetchUserInfo(getContext(), NationTypeUtil.getNationComponentData().getLoginInfo().getToken(), NationTypeUtil.getNationComponentData().getGLang(), (RpcService.Callback<UserInfo>) null);
                this.f37266e = DataContainer.getInstance().getPageData("level0", "root");
                if (!this.f37267f) {
                    this.f37267f = true;
                    View findViewById = this.f37270i.findViewById(R.id.container);
                    if (findViewById == null) {
                        this.f37273l.inflate();
                        findViewById = this.f37270i.findViewById(R.id.container);
                    }
                    m26466a((ViewGroup) findViewById);
                    m26469b();
                }
                DataContainer.getInstance().refreshData();
                this.f37268g.openDrawer(this.f37270i);
                m26465a();
            }
        }
    }

    /* renamed from: a */
    private void m26465a() {
        String str;
        SidebarPage sidebarPage = this.f37266e;
        if (sidebarPage != null && !CollectionUtils.isEmpty((Collection<?>) sidebarPage.getGroupList())) {
            int i = 0;
            List list = this.f37266e.getGroupList().get(0);
            while (true) {
                if (i >= list.size()) {
                    break;
                }
                str = ((SidebarItem) list.get(i)).getDiscountMsg();
                if (!TextUtils.isEmpty(str)) {
                    break;
                }
                i++;
            }
        }
        str = "";
        HashMap hashMap = new HashMap();
        hashMap.put("tag", str);
        OmegaSDKAdapter.trackEvent("pas_sidebar_sw", (Map<String, Object>) hashMap);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void closeSidebar(SidebarEvent sidebarEvent) {
        if (EventKeys.Sidebar.CLOSE_SIDEBAR.equalsIgnoreCase(sidebarEvent.type)) {
            this.f37268g.closeDrawer(this.f37270i);
            lockDrawerToClose();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void refreshSidebar(SidebarPage sidebarPage) {
        SystemUtils.log(3, f37262b, "refrsh Sidebar", (Throwable) null, "com.didi.sdk.sidebar.fragment.HomeNavDrawerFragment", 171);
        this.f37266e = sidebarPage;
        View view = this.f37270i;
        if (view != null && this.f37267f) {
            m26466a((ViewGroup) view.findViewById(R.id.container));
        }
    }

    /* renamed from: a */
    private void m26466a(ViewGroup viewGroup) {
        List list;
        synchronized (f37263c) {
            this.f37264a.info("assemble begin....", new Object[0]);
            viewGroup.removeAllViews();
            this.f37271j = new ViewAssembler();
            if (!(this.f37266e == null || this.f37266e.getGroupList() == null || this.f37266e.getGroupList().size() <= 0 || (list = this.f37266e.getGroupList().get(0)) == null || list.size() <= 0)) {
                m26467a((SidebarItem) list.get(0));
            }
            this.f37271j.assemble(this.f37266e, new PageDecorator.PageDecoratorBuilder(viewGroup).setDividerColor(R.color.white).build(), this.f37265d);
            this.f37264a.info("assemble end....", new Object[0]);
        }
    }

    /* renamed from: a */
    private void m26467a(SidebarItem sidebarItem) {
        View view;
        if (this.f37272k == null) {
            this.f37272k = (LinearLayout) this.f37270i.findViewById(R.id.sidebar_head_container);
        }
        this.f37272k.setVisibility(0);
        this.f37272k.removeAllViews();
        AbsComponent createComponent = new ComponentFactory().createComponent(sidebarItem.getComponentType(), this.f37265d, sidebarItem, this.f37266e.getSubLevel());
        if (createComponent != null && createComponent.getView() != null && (view = createComponent.getView()) != null) {
            this.f37272k.addView(view);
        }
    }

    /* renamed from: b */
    private void m26469b() {
        fixBarrierFree(this.f37270i);
        this.f37268g.setDrawerShadow((int) R.drawable.drawer_shadow, (int) GravityCompat.START);
        this.f37269h = new ActionBarDrawerToggle(getActivity(), this.f37268g, R.drawable.ic_drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {
            private void notifyDelegate() {
            }

            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                EventBus.getDefault().post(new SidebarEvent(EventKeys.Sidebar.CLOSE_SIDEBAR));
                if (!HomeNavDrawerFragment.this.isAdded()) {
                }
            }

            public void onDrawerOpened(View view) {
                super.onDrawerOpened(view);
                EventBus.getDefault().post(new IMRefreshEvent());
                HomeNavDrawerFragment.this.unlockDrawer();
                if (HomeNavDrawerFragment.this.f37271j != null) {
                    HomeNavDrawerFragment.this.f37271j.notifyOnResume();
                }
            }
        };
        this.f37268g.post(new Runnable() {
            public void run() {
                HomeNavDrawerFragment.this.f37269h.syncState();
            }
        });
        this.f37268g.setDrawerListener(this.f37269h);
    }

    public boolean isDrawerOpen() {
        DrawerLayout drawerLayout = this.f37268g;
        return drawerLayout != null && drawerLayout.isDrawerOpen(this.f37270i);
    }

    public void lockDrawerToClose() {
        DrawerLayout drawerLayout = this.f37268g;
        if (drawerLayout != null) {
            drawerLayout.setDrawerLockMode(1);
        }
    }

    public void unlockDrawer() {
        DrawerLayout drawerLayout = this.f37268g;
        if (drawerLayout != null) {
            drawerLayout.setDrawerLockMode(0);
        }
    }

    public void show() {
        this.f37268g.openDrawer(this.f37270i);
    }

    public void close() {
        this.f37268g.closeDrawer(this.f37270i);
    }

    public void onResume() {
        super.onResume();
        EventBus.getDefault().post(EventKeys.Sidebar.OPEN_SIDEBAR);
        EventBus.getDefault().post(new IMRefreshEvent());
    }
}
