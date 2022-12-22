package com.didiglobal.p205sa.biz.component.activity.presenter;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import com.didi.component.never.core.ComponentParams;
import com.didi.drouter.api.DRouter;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.util.NetUtil;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didi.unifylogin.api.OneLoginFacade;
import com.didi.unifylogin.listener.LoginListeners;
import com.didi.xengine.callback.XEReqJSONParamsCallbackImpl;
import com.didi.xengine.register.XERegister;
import com.didiglobal.enginecore.callback.XEResponseCallback;
import com.didiglobal.enginecore.component.XEComponent;
import com.didiglobal.enginecore.data.exception.EngineErrorException;
import com.didiglobal.enginecore.data.model.XEngineData;
import com.didiglobal.enginecore.data.parser.XEParseConst;
import com.didiglobal.enginecore.register.XERegisterModel;
import com.didiglobal.p205sa.biz.component.ComponentType;
import com.didiglobal.p205sa.biz.component.activity.model.ActivityCardModel;
import com.didiglobal.p205sa.biz.component.activity.model.ActivityProperty;
import com.didiglobal.p205sa.biz.component.activity.model.ActivityViewType;
import com.didiglobal.p205sa.biz.component.activity.omega.ActivityOmegaTracker;
import com.didiglobal.p205sa.biz.component.activity.view.ActivityPanelView;
import com.didiglobal.p205sa.biz.component.activity.view.ToastUtils;
import com.didiglobal.p205sa.biz.component.xengine.SAXEngineReqUtil;
import com.didiglobal.p205sa.biz.util.GsonUtils;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONObject;

/* renamed from: com.didiglobal.sa.biz.component.activity.presenter.ActivityPanelPresenter */
public class ActivityPanelPresenter extends AbsActivityPanelPresenter implements LoginListeners.LoginListener, IActivityPresenter {
    public static boolean isNoData = false;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public int f50742a = -1;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f50743b = -1;

    /* renamed from: c */
    private boolean f50744c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public int f50745d = -1;

    /* renamed from: e */
    private Timer f50746e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public int f50747f = 1;

    /* renamed from: g */
    private long f50748g = 0;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public Handler f50749h = new Handler();
    /* access modifiers changed from: private */

    /* renamed from: i */
    public Logger f50750i = LoggerFactory.getLogger("ActivityPanelPresenter");
    /* access modifiers changed from: private */

    /* renamed from: j */
    public List<ActivityProperty> f50751j;

    /* renamed from: k */
    private TimerTask f50752k;

    /* renamed from: l */
    private XEResponseCallback f50753l = new XEResponseCallback() {
        public void onSuccess(String str, XEngineData xEngineData, List<XEComponent> list) {
            boolean z = false;
            ActivityPanelPresenter.this.f50750i.info("XEResponseCallback success: %s", xEngineData);
            List a = ActivityPanelPresenter.this.m36433a(xEngineData);
            if (!CollectionUtil.isEmpty((Collection<?>) a)) {
                ActivityOmegaTracker.clear();
                if (a.size() == 1) {
                    z = true;
                }
                ActivityPanelPresenter.isNoData = z;
                if (ActivityPanelPresenter.isNoData) {
                    ActivityOmegaTracker.OmegaActivityNoData(1);
                }
                ((ActivityPanelView) ActivityPanelPresenter.this.mView).setData(a, ActivityPanelPresenter.this.f50743b, ActivityPanelPresenter.this.f50745d);
            } else {
                ActivityPanelPresenter.this.m36436a();
            }
            List unused = ActivityPanelPresenter.this.f50751j = a;
            ActivityPanelPresenter.this.m36438b();
        }

        public void onFailed(String str, EngineErrorException engineErrorException) {
            ActivityPanelPresenter.this.f50750i.info("XEResponseCallback fail: %s", engineErrorException.toString());
            ActivityPanelPresenter.this.m36436a();
        }
    };

    /* renamed from: m */
    private XEReqJSONParamsCallbackImpl f50754m = new XEReqJSONParamsCallbackImpl() {
        public JSONObject getRequestParams() {
            HashMap hashMap = new HashMap();
            hashMap.put("page", Integer.valueOf(ActivityPanelPresenter.this.f50747f));
            return new JSONObject(hashMap);
        }
    };

    /* access modifiers changed from: protected */
    public String getComponentIdByType(String str) {
        return str;
    }

    /* access modifiers changed from: protected */
    public String[] getNativeCards() {
        return new String[0];
    }

    public ActivityPanelPresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m36436a() {
        if (CollectionUtil.isEmpty((Collection<?>) this.f50751j)) {
            ((ActivityPanelView) this.mView).showErrorView(R.drawable.activity_page_lost, this.mContext.getResources().getString(R.string.GRider_batch1__ijLA));
            ActivityOmegaTracker.OmegaActivityNoData(3);
            return;
        }
        ((ActivityPanelView) this.mView).resetLoading();
        ToastUtils.showToast(this.mContext, this.mContext.getString(R.string.GRider_batch1__ijLA), R.drawable.activity_toast_icon);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public List<ActivityProperty> m36433a(XEngineData xEngineData) {
        try {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            JsonObject jsonObject = xEngineData.jsonObject;
            JsonArray asJsonArray = jsonObject.getAsJsonArray("list");
            JsonObject asJsonObject = jsonObject.getAsJsonObject(XEParseConst.XE_JSON_KEY_UI_CONFIG).getAsJsonObject("setting");
            if (asJsonObject.has("refresh_interval")) {
                this.f50742a = asJsonObject.get("refresh_interval").getAsInt() * 1000;
            }
            if (asJsonArray.get(0).getAsJsonObject().has("max_count")) {
                this.f50743b = asJsonArray.get(0).getAsJsonObject().get("max_count").getAsInt();
            }
            if (asJsonArray.size() > 1 && asJsonArray.get(1).getAsJsonObject().has("is_all_data")) {
                this.f50745d = asJsonArray.get(1).getAsJsonObject().get("is_all_data").getAsInt();
            }
            for (int i = 0; i < asJsonArray.size(); i++) {
                JsonArray asJsonArray2 = asJsonArray.get(i).getAsJsonObject().getAsJsonArray("cards");
                for (int i2 = 0; i2 < asJsonArray2.size(); i2++) {
                    ActivityCardModel activityCardModel = (ActivityCardModel) GsonUtils.fromJson(asJsonArray2.get(i2).getAsJsonObject().toString(), ActivityCardModel.class);
                    ActivityProperty activityProperty = new ActivityProperty();
                    activityProperty.setModel(activityCardModel);
                    activityProperty.setTypeId(activityCardModel.getType_id());
                    if (ActivityViewType.ongoing_card.getTypeId().equals(activityCardModel.getType_id())) {
                        arrayList2.add(activityProperty);
                    }
                    arrayList.add(activityProperty);
                }
            }
            if (CollectionUtil.isEmpty((Collection<?>) arrayList)) {
                ActivityOmegaTracker.OmegaError(1);
            }
            if (arrayList2.size() > this.f50743b) {
                ActivityProperty activityProperty2 = new ActivityProperty();
                activityProperty2.setTypeId(ActivityViewType.ongoing_more_card.getTypeId());
                arrayList.add(arrayList2.size() + 1, activityProperty2);
            }
            return arrayList;
        } catch (Exception e) {
            Logger logger = this.f50750i;
            logger.info("parseData error" + e.toString(), new Object[0]);
            ActivityOmegaTracker.OmegaError(3);
            return null;
        }
    }

    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        this.f50750i.info("onAdd", new Object[0]);
        this.f50744c = false;
        m36443e();
    }

    public void onPageHiddenChanged(boolean z) {
        Logger logger = this.f50750i;
        logger.info("onPageHiddenChanged：" + z, new Object[0]);
        this.f50744c = z;
        super.onPageHiddenChanged(z);
        if (!z) {
            if (!m36446f()) {
                ActivityOmegaTracker.OmegaError(4);
            }
            m36448g();
            m36442d();
            this.f50748g = System.currentTimeMillis();
            ActivityOmegaTracker.OmegaActivityVisible(CollectionUtil.isEmpty((Collection<?>) this.f50751j) ^ true ? 1 : 0);
            return;
        }
        m36449h();
        m36440c();
        ActivityOmegaTracker.OmegaActivityShowTime(System.currentTimeMillis() - this.f50748g, CollectionUtil.isEmpty((Collection<?>) this.f50751j) ^ true ? 1 : 0);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m36438b() {
        this.f50750i.info("scheduleRequest %s", Integer.valueOf(this.f50742a));
        m36440c();
        if (this.f50742a >= 0) {
            this.f50746e = new Timer();
            C170902 r2 = new TimerTask() {
                public void run() {
                    ActivityPanelPresenter.this.f50749h.post(new Runnable() {
                        public void run() {
                            ActivityPanelPresenter.this.f50750i.info("TimerTask schedule: %s", Integer.valueOf(ActivityPanelPresenter.this.f50742a));
                            ActivityPanelPresenter.this.m36442d();
                        }
                    });
                }
            };
            this.f50752k = r2;
            Timer timer = this.f50746e;
            int i = this.f50742a;
            timer.schedule(r2, (long) i, (long) i);
        }
    }

    /* renamed from: c */
    private void m36440c() {
        this.f50750i.info("stopSchedule", new Object[0]);
        Timer timer = this.f50746e;
        if (timer != null) {
            timer.cancel();
            this.f50746e = null;
        }
        TimerTask timerTask = this.f50752k;
        if (timerTask != null) {
            timerTask.cancel();
            this.f50752k = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m36442d() {
        this.f50750i.info("requestActivity", new Object[0]);
        if (NetUtil.isAvailable(this.mContext)) {
            SAXEngineReqUtil.INSTANCE.pageRequest("sa_activity");
        } else if (CollectionUtil.isEmpty((Collection<?>) this.f50751j)) {
            ((ActivityPanelView) this.mView).showErrorView(R.drawable.activity_network_error, this.mContext.getResources().getString(R.string.GRider_batch1__SSTN));
            ActivityOmegaTracker.OmegaActivityNoData(2);
        } else {
            ToastUtils.showToast(this.mContext, this.mContext.getString(R.string.GRider_batch1__SSTN), R.drawable.activity_toast_icon);
        }
    }

    public void onPageResume() {
        super.onPageResume();
        Logger logger = this.f50750i;
        logger.info("onPageResumepageHidden: " + this.f50744c, new Object[0]);
        if (!this.f50744c) {
            m36448g();
            m36442d();
            this.f50748g = System.currentTimeMillis();
            ActivityOmegaTracker.OmegaActivityVisible(CollectionUtil.isEmpty((Collection<?>) this.f50751j) ^ true ? 1 : 0);
        }
    }

    public void onPagePause() {
        super.onPagePause();
        this.f50750i.info("onPagePause", new Object[0]);
        m36440c();
        ActivityOmegaTracker.OmegaActivityShowTime(System.currentTimeMillis() - this.f50748g, CollectionUtil.isEmpty((Collection<?>) this.f50751j) ^ true ? 1 : 0);
    }

    public void onPageStop() {
        super.onPageStop();
        this.f50750i.info("onPageStop", new Object[0]);
        m36449h();
    }

    /* renamed from: e */
    private void m36443e() {
        XERegisterModel xERegisterModel = new XERegisterModel(ComponentType.COMPONENT_SA_ACTIVITY_PANEL, "sa_activity", this.f50753l);
        xERegisterModel.required = true;
        xERegisterModel.requestParams = this.f50754m;
        XERegister.registerTemplate(xERegisterModel);
    }

    public void reqeustRetry() {
        m36442d();
    }

    public void requestRefresh() {
        this.f50747f = 1;
        m36442d();
    }

    public void requestLoadMore() {
        this.f50747f++;
        m36442d();
    }

    /* renamed from: f */
    private boolean m36446f() {
        return NationTypeUtil.getNationComponentData().getLoginInfo().isLoginNow();
    }

    /* renamed from: g */
    private void m36448g() {
        OneLoginFacade.getFunction().addLoginListener(this);
    }

    /* renamed from: h */
    private void m36449h() {
        OneLoginFacade.getFunction().removeLoginListener(this);
    }

    public void onSuccess(Activity activity, String str) {
        this.f50750i.info("login_onSuccess", new Object[0]);
    }

    public void onCancel() {
        Logger logger = this.f50750i;
        logger.info("login_cancel " + this.f50744c, new Object[0]);
        if (!this.f50744c) {
            DRouter.build("GlobalOneTravel://one/switch_tab?tab_id=tab_home").start();
        }
    }
}
