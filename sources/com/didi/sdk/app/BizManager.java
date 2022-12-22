package com.didi.sdk.app;

import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import com.didi.app.router.PageRouter;
import com.didi.drouter.api.DRouter;
import com.didi.safetoolkit.business.sdk.SafeToolKit;
import com.didi.sdk.apm.utils.ApmThreadPool;
import com.didi.sdk.app.TabEventManager;
import com.didi.sdk.app.business.BusinessInitCallback;
import com.didi.sdk.events.OpenSideBarPageEvent;
import com.didi.sdk.events.SwitchTypeEvent;
import com.didi.sdk.home.model.TopBarData;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.misconfig.event.CarInfoUpdateEvent;
import com.didi.sdk.misconfig.model.CarGrop;
import com.didi.sdk.misconfig.p153v2.ConfProxy;
import com.didi.sdk.sidebar.templet.AutoLinker;
import com.didi.sdk.util.EventKeys;
import com.didichuxing.foundation.spi.ServiceLoader;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.Map;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class BizManager {
    public static final String ENTRANCE = "entrance";

    /* renamed from: a */
    private Logger f35121a = LoggerFactory.getLogger("BizManager");

    /* renamed from: b */
    private String f35122b;

    /* renamed from: c */
    private String f35123c;

    /* renamed from: d */
    private BusinessContextHelper f35124d = null;

    /* renamed from: e */
    private HashMap<String, BusinessContext> f35125e = new HashMap<>();

    /* renamed from: f */
    private final HashMap<String, Boolean> f35126f = new HashMap<>();

    /* renamed from: g */
    private BizListener f35127g;

    public interface BizListener {
        void onBizDataChanged(int i);

        void onBizSwitched(CarGrop carGrop, String str, BusinessContext businessContext, TabEventManager.TabHandleModel tabHandleModel);
    }

    public void init(BusinessContextHelper businessContextHelper) {
        this.f35124d = businessContextHelper;
        EventBus.getDefault().register(this);
    }

    public void destory() {
        EventBus.getDefault().unregister(this);
        this.f35125e.clear();
    }

    public void setBizListener(BizListener bizListener) {
        this.f35127g = bizListener;
    }

    /* renamed from: a */
    private void m24831a(String str, BusinessContext businessContext) {
        if (businessContext != null && this.f35125e.get(str) == null) {
            this.f35125e.put(str, businessContext);
        }
    }

    public void loadBiz(String str, String str2, boolean z, TabEventManager.TabHandleModel tabHandleModel) {
        loadBiz(ConfProxy.getInstance().getGroupByType(str), str2, z, tabHandleModel);
    }

    public void loadBiz(final CarGrop carGrop, final String str, boolean z, final TabEventManager.TabHandleModel tabHandleModel) {
        if (carGrop == null) {
            this.f35121a.error("biz not exist", new Object[0]);
            return;
        }
        String groupType = carGrop.getGroupType();
        String navTag = carGrop.getNavTag();
        if (!z && navTag.equals(this.f35122b) && groupType.equals(this.f35123c)) {
            return;
        }
        if (!"ride".equals(groupType) && !ConfProxy.getInstance().isContainsGroupType(groupType)) {
            Logger logger = this.f35121a;
            logger.error("loadbiz failed, while topbar not contains " + groupType, new Object[0]);
        } else if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            ApmThreadPool.excuteOnUiThread(new Runnable() {
                public void run() {
                    BusinessContext unused = BizManager.this.m24829a(carGrop, str, tabHandleModel);
                }
            });
        } else {
            m24829a(carGrop, str, tabHandleModel);
        }
    }

    public void loadBiz(CarGrop carGrop, boolean z, TabEventManager.TabHandleModel tabHandleModel) {
        loadBiz(carGrop, (String) null, z, tabHandleModel);
    }

    /* renamed from: a */
    private void m24830a(String str) {
        BusinessInitCallback businessInitCallback = (BusinessInitCallback) ServiceLoader.load(BusinessInitCallback.class, str).get();
        if (businessInitCallback != null) {
            if (this.f35126f.containsKey(str)) {
                Logger logger = this.f35121a;
                logger.debug("syncInitBusiness", "has init " + str + ", just return");
            } else {
                Logger logger2 = this.f35121a;
                logger2.debug("syncInitBusiness", "init " + str);
                businessInitCallback.onSyncInit(DIDIBaseApplication.getAppContext());
                HashMap hashMap = new HashMap();
                hashMap.put("group_type", str);
                OmegaSDKAdapter.trackEvent("product_group_loaded", (Map<String, Object>) hashMap);
                this.f35126f.put(str, true);
            }
            businessInitCallback.onSwitchToBusiness(DIDIBaseApplication.getAppContext(), str);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public BusinessContext m24829a(CarGrop carGrop, String str, TabEventManager.TabHandleModel tabHandleModel) {
        String groupType = carGrop.getGroupType();
        String navTag = carGrop.getNavTag();
        m24830a(groupType);
        BusinessContext businessContext = (BusinessContext) this.f35124d.getBusinessContext(groupType, BusinessContext.class);
        businessContext.setBusinessGroupType(groupType);
        businessContext.setCountryInfo(ConfProxy.getInstance().getCountryInfo());
        m24831a(groupType, businessContext);
        String schema = carGrop.getSchema();
        this.f35122b = navTag;
        this.f35123c = groupType;
        if (TextUtils.isEmpty(schema) || schema.contains("entrance")) {
            ConfProxy.getInstance().setSelectedType(groupType);
        } else {
            TopBarData topBarData = ConfProxy.getInstance().getTopBarData();
            if (topBarData != null) {
                topBarData.setSelectedGroup(groupType);
            }
        }
        SafeToolKit.getIns().setProductId(ConfProxy.getInstance().getSelectedGroupId());
        SafeToolKit.getIns().setBusinessType(groupType);
        if ("bus".equals(groupType)) {
            SafeToolKit.getIns().setBusinessType("ride");
        }
        BusinessContextManager.getInstance().mo90610a((BaseBusinessContext) businessContext);
        PageRouter.getInstance().setBusinessContext(businessContext);
        BizListener bizListener = this.f35127g;
        if (bizListener != null) {
            bizListener.onBizSwitched(carGrop, str, businessContext, tabHandleModel);
        }
        if (tabHandleModel != null && !TextUtils.isEmpty(tabHandleModel.getActionUrl())) {
            DRouter.build(tabHandleModel.getActionUrl()).start();
        }
        return businessContext;
    }

    public void refreshMis(boolean z) {
        BusinessContext businessContext = (BusinessContext) this.f35124d.getBusinessContext(ConfProxy.getInstance().getSelectedType(), BusinessContext.class);
        if (!(businessContext == null || businessContext.getCountryInfo() == null)) {
            int cityId = businessContext.getCountryInfo().getCityId();
            Logger logger = this.f35121a;
            logger.debug("MainActivity refreshMis cityId = " + cityId, new Object[0]);
        }
        EventBus.getDefault().post(new Pair(EventKeys.MisConfig.REFRESH_MIS, Integer.valueOf(z ? 1 : 0)));
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onReceive(CarInfoUpdateEvent carInfoUpdateEvent) {
        if (carInfoUpdateEvent != null && EventKeys.MisConfig.MIS_DATA_FROM_UPDATE.equalsIgnoreCase(carInfoUpdateEvent.tag)) {
            Logger logger = this.f35121a;
            logger.debug("onReceive CarInfoUpdateEvent result = " + carInfoUpdateEvent.result, new Object[0]);
            if (this.f35125e.size() > 0) {
                for (String str : this.f35125e.keySet()) {
                    BusinessContext businessContext = this.f35125e.get(str);
                    businessContext.setCountryInfo(ConfProxy.getInstance().getCountryInfo());
                    businessContext.setMisDataFrom(carInfoUpdateEvent.result);
                }
            }
            if (this.f35127g != null && carInfoUpdateEvent.versionChanged) {
                this.f35127g.onBizDataChanged(carInfoUpdateEvent.result);
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onSwitchType(SwitchTypeEvent switchTypeEvent) {
        if (!TextUtils.isEmpty(switchTypeEvent.type)) {
            loadBiz(switchTypeEvent.type, switchTypeEvent.urlGetParams, false, switchTypeEvent.tabHandleModel);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onSideBarPageRequested(OpenSideBarPageEvent openSideBarPageEvent) {
        AutoLinker.getLinker().linkToTarget(openSideBarPageEvent.item, (BusinessContext) this.f35124d.getBusinessContext(ConfProxy.getInstance().getSelectedType(), BusinessContext.class), openSideBarPageEvent.subLevel);
    }
}
