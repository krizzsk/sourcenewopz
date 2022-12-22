package com.didi.component.splitfare.presenter.impl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import androidx.fragment.app.Fragment;
import com.didi.app.router.PageRouter;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.constant.BaseExtras;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.FragmentUtils;
import com.didi.component.business.util.HighlightUtil;
import com.didi.component.business.util.UiUtils;
import com.didi.component.common.dialog.GlobalCommonBottomPop;
import com.didi.component.common.dialog.NormalDialogInfo;
import com.didi.component.common.router.GRouterUtil;
import com.didi.component.common.util.GLog;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.IGroupView;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.splitfare.event.SplitFareEventTracker;
import com.didi.component.splitfare.model.NewSplitFareMsg;
import com.didi.component.splitfare.model.SplitFareManager;
import com.didi.component.splitfare.model.UpdateSplitFareInfo;
import com.didi.component.splitfare.presenter.AbsSplitFarePresenter;
import com.didi.component.splitfare.view.AcceptSplitFarePopupWindow;
import com.didi.component.splitfare.view.ISplitFareHomeView;
import com.didi.component.splitfare.view.SplitFloatWindow;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.RouterCallback;
import com.didi.entrega.customer.foundation.tracker.param.ParamConst;
import com.didi.payment.creditcard.open.DidiCreditCardFactory;
import com.didi.payment.creditcard.open.DidiGlobalVerifyCardData;
import com.didi.reactive.tracker.Attrs;
import com.didi.sdk.app.ActivityLifecycleManager;
import com.didi.sdk.app.BaseMainActivity;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.app.INavigation;
import com.didi.sdk.global.DidiGlobalPayMethodListData;
import com.didi.sdk.recover.RecoverStore;
import com.didi.sdk.sidebar.fragment.HomeNavDrawerFragment;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.util.UiThreadHandler;
import com.didi.travel.psnger.common.net.base.BaseObject;
import com.didi.travel.psnger.common.net.base.ITravelOrderListener;
import com.didi.travel.psnger.common.net.base.ResponseListener;
import com.didi.travel.psnger.core.model.response.DTSDKOrderDetail;
import com.didi.travel.psnger.core.model.response.DTSDKSplitFareInfo;
import com.didi.travel.psnger.core.model.response.ICarOrder;
import com.didi.travel.psnger.core.service.CoreHttpRequest;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didi.travel.psnger.model.response.PayWayModel;
import com.didi.travel.psnger.p170v2.TravelUtil;
import com.didi.travel.psnger.store.DDTravelOrderStore;
import com.didi.unifylogin.api.OneLoginFacade;
import com.didi.unifylogin.listener.LoginListeners;
import com.google.gson.JsonObject;
import com.taxis99.R;
import global.didi.pay.UniCancelFeePayActivity;
import global.didi.pay.model.CancelFeePayParam;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SplitFareHomePresenter extends AbsSplitFarePresenter<ISplitFareHomeView> implements AcceptSplitFarePopupWindow.OnSplitFareActionListener {
    public static final String TAG = "SplitFareHomePresenter";

    /* renamed from: a */
    private static final int f15967a = 1024;

    /* renamed from: b */
    private static final int f15968b = 100;

    /* renamed from: c */
    private BusinessContext f15969c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f15970d = false;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public String f15971e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public DTSDKSplitFareInfo f15972f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public List<PayWayModel.PayWayItem> f15973g = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: h */
    public AcceptSplitFarePopupWindow f15974h;

    /* renamed from: i */
    private SplitFloatWindow f15975i;

    /* renamed from: j */
    private volatile boolean f15976j = false;

    /* renamed from: k */
    private SplitFareManager f15977k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public int f15978l = 0;

    /* renamed from: m */
    private Runnable f15979m = new Runnable() {
        public void run() {
            SplitFareHomePresenter.this.m11709g();
        }
    };

    /* renamed from: n */
    private BaseEventPublisher.OnEventListener f15980n = new BaseEventPublisher.OnEventListener<Object>() {
        public void onEvent(String str, Object obj) {
            if (BaseEventKeys.Push.EVENT_ASK_SPLIT_FARE.equals(str)) {
                BaseEventPublisher.getPublisher().removeStickyEvent(str);
                GLog.m7965d(SplitFareHomePresenter.TAG, "push EVENT_ASK_SPLIT_FARE arrived, commonPushMsg=" + obj);
                SplitFareHomePresenter.this.m11691a(obj);
            }
        }
    };

    /* renamed from: p */
    private BaseEventPublisher.OnEventListener f15981p = new BaseEventPublisher.OnEventListener<Boolean>() {
        public void onEvent(String str, Boolean bool) {
            GLog.m7971i(SplitFareHomePresenter.TAG, "@mGewSplitMessageListener, inHome=" + bool);
            if (bool.booleanValue()) {
                SplitFareHomePresenter.this.m11695b();
                return;
            }
            SplitFareHomePresenter.this.m11709g();
            SplitFareHomePresenter.this.goBackRoot();
            boolean unused = SplitFareHomePresenter.this.f15970d = true;
        }
    };

    /* renamed from: q */
    private BaseEventPublisher.OnEventListener f15982q = new BaseEventPublisher.OnEventListener<CarOrder>() {
        public void onEvent(String str, CarOrder carOrder) {
            if (!BaseEventKeys.Home.SPLIT_FARE_SHOW_ACCEPT_WINDOW.equals(str)) {
                return;
            }
            if (SplitFareHomePresenter.this.f15974h == null || !SplitFareHomePresenter.this.f15974h.isShowing()) {
                String unused = SplitFareHomePresenter.this.f15971e = carOrder.oid;
                DTSDKSplitFareInfo unused2 = SplitFareHomePresenter.this.f15972f = carOrder.splitFareInfo;
                List<PayWayModel.PayWayItem> list = SplitFareHomePresenter.this.f15972f.splitUserPayList;
                SplitFareHomePresenter.this.f15973g.clear();
                if (list != null) {
                    for (PayWayModel.PayWayItem next : list) {
                        if (next != null && next.isSelected == 1) {
                            SplitFareHomePresenter.this.f15973g.add(next);
                        }
                    }
                    int unused3 = SplitFareHomePresenter.this.f15978l = 0;
                    for (PayWayModel.PayWayItem payWayItem : SplitFareHomePresenter.this.f15973g) {
                        if (payWayItem != null) {
                            SplitFareHomePresenter splitFareHomePresenter = SplitFareHomePresenter.this;
                            int unused4 = splitFareHomePresenter.f15978l = payWayItem.tag | splitFareHomePresenter.f15978l;
                        }
                    }
                }
                SplitFareHomePresenter splitFareHomePresenter2 = SplitFareHomePresenter.this;
                splitFareHomePresenter2.m11690a(splitFareHomePresenter2.f15972f);
            }
        }
    };

    /* renamed from: r */
    private BaseEventPublisher.OnEventListener f15983r = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (BaseEventKeys.Home.SPLIT_FARE_REFRESH_DATA.equals(str) && !TextUtils.isEmpty(SplitFareHomePresenter.this.f15971e)) {
                SplitFareHomePresenter.this.m11705e();
                TravelUtil.getOrderDetail(SplitFareHomePresenter.this.mComponentProxy.getSession(), SplitFareHomePresenter.this.f15971e, new ITravelOrderListener() {
                    public void onSuccess(ICarOrder iCarOrder) {
                        GLog.m7971i(SplitFareHomePresenter.TAG, "refresh detail onSuccess " + iCarOrder);
                        if (iCarOrder == null) {
                            SplitFareHomePresenter.this.m11707f();
                            return;
                        }
                        CarOrder carOrder = (CarOrder) iCarOrder;
                        DDTravelOrderStore.setOrder(carOrder);
                        TravelUtil.setCarOrder(carOrder);
                        String unused = SplitFareHomePresenter.this.f15971e = carOrder.oid;
                        DTSDKSplitFareInfo unused2 = SplitFareHomePresenter.this.f15972f = carOrder.splitFareInfo;
                        List<PayWayModel.PayWayItem> list = SplitFareHomePresenter.this.f15972f.splitUserPayList;
                        DidiGlobalPayMethodListData.PayMethodListParam payMethodListParam = new DidiGlobalPayMethodListData.PayMethodListParam(DidiGlobalPayMethodListData.Entrance.FROM_SPLIT_FARE);
                        payMethodListParam.list = SplitFareHomePresenter.this.m11678a(list);
                        SplitFareHomePresenter.this.doPublish(BaseEventKeys.Home.SPLIT_FARE_REFRESH_CALLBACK_SUCCESS, payMethodListParam);
                        if (list != null) {
                            for (PayWayModel.PayWayItem next : list) {
                                if (next != null && next.isSelected == 1) {
                                    SplitFareHomePresenter.this.f15973g.add(next);
                                }
                            }
                            int unused3 = SplitFareHomePresenter.this.f15978l = 0;
                            for (PayWayModel.PayWayItem payWayItem : SplitFareHomePresenter.this.f15973g) {
                                if (payWayItem != null) {
                                    int unused4 = SplitFareHomePresenter.this.f15978l = payWayItem.tag | SplitFareHomePresenter.this.f15978l;
                                }
                            }
                        }
                        if (SplitFareHomePresenter.this.f15974h != null && SplitFareHomePresenter.this.f15974h.isShowing()) {
                            SplitFareHomePresenter.this.f15974h.updatePaymentLabel(SplitFareHomePresenter.this.f15973g);
                        }
                    }

                    public void onError(int i, String str) {
                        GLog.m7971i(SplitFareHomePresenter.TAG, "refresh detail onError " + i + ":" + str);
                        SplitFareHomePresenter.this.m11707f();
                        SplitFareHomePresenter.this.doPublish(BaseEventKeys.Home.SPLIT_FARE_REFRESH_CALLBACK_FAIL);
                    }

                    public void onFail(int i, String str) {
                        GLog.m7971i(SplitFareHomePresenter.TAG, "refresh detail onFail " + i + ":" + str);
                        SplitFareHomePresenter.this.m11707f();
                        SplitFareHomePresenter.this.doPublish(BaseEventKeys.Home.SPLIT_FARE_REFRESH_CALLBACK_FAIL);
                    }

                    public void onTimeout(String str) {
                        GLog.m7971i(SplitFareHomePresenter.TAG, "refresh detail onTimeout " + str);
                        SplitFareHomePresenter.this.m11707f();
                        SplitFareHomePresenter.this.doPublish(BaseEventKeys.Home.SPLIT_FARE_REFRESH_CALLBACK_FAIL);
                    }
                });
            }
        }
    };

    /* renamed from: s */
    private BaseEventPublisher.OnEventListener f15984s = new BaseEventPublisher.OnEventListener<BaseObject>() {
        public void onEvent(String str, BaseObject baseObject) {
            if (baseObject.errno == 700013 && !TextUtils.isEmpty(baseObject.errmsg)) {
                NormalDialogInfo normalDialogInfo = new NormalDialogInfo(1024);
                normalDialogInfo.setMessage(HighlightUtil.highlight(SplitFareHomePresenter.this.mContext, baseObject.errmsg));
                normalDialogInfo.setCloseVisible(false);
                normalDialogInfo.setCancelable(false);
                normalDialogInfo.setIconVisible(false);
                normalDialogInfo.setPositiveText(ResourcesHelper.getString(SplitFareHomePresenter.this.mContext, R.string.car_me_known));
                SplitFareHomePresenter.this.showDialog(normalDialogInfo);
            }
        }
    };

    /* renamed from: t */
    private LoginListeners.LoginOutListener f15985t = new LoginListeners.LoginOutListener() {
        public void onSuccess() {
            if (SplitFareHomePresenter.this.f15974h != null) {
                SplitFareHomePresenter.this.f15974h.dismiss();
            }
        }
    };

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11690a(DTSDKSplitFareInfo dTSDKSplitFareInfo) {
        AcceptSplitFarePopupWindow acceptSplitFarePopupWindow = this.f15974h;
        if (acceptSplitFarePopupWindow != null) {
            acceptSplitFarePopupWindow.dismiss();
        }
        AcceptSplitFarePopupWindow acceptSplitFarePopupWindow2 = new AcceptSplitFarePopupWindow(this.mContext, dTSDKSplitFareInfo);
        this.f15974h = acceptSplitFarePopupWindow2;
        acceptSplitFarePopupWindow2.setActionListener(this);
        this.f15974h.show();
        this.f15974h.updatePaymentLabel(this.f15973g);
    }

    public SplitFareHomePresenter(ComponentParams componentParams) {
        super(componentParams);
        this.f15969c = componentParams.bizCtx;
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        this.f15977k = new SplitFareManager(this.mContext);
        BaseEventPublisher.getPublisher().subscribeSticky(BaseEventKeys.Push.EVENT_ASK_SPLIT_FARE, this.f15980n);
        subscribe(BaseEventKeys.Home.SPLIT_FARE_GET_INVITE_INFO, this.f15981p);
        subscribe(BaseEventKeys.Home.SPLIT_FARE_SHOW_ACCEPT_WINDOW, this.f15982q);
        subscribe(BaseEventKeys.Home.SPLIT_FARE_REFRESH_DATA, this.f15983r);
        OneLoginFacade.getFunction().addLoginOutListener(this.f15985t);
        subscribe(BaseEventKeys.Order.BIZ_ERROR, this.f15984s);
    }

    /* access modifiers changed from: protected */
    public void onBackHome(Bundle bundle) {
        super.onBackHome(bundle);
        if (this.f15970d) {
            this.f15970d = false;
            m11695b();
        }
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        unsubscribe(BaseEventKeys.Push.EVENT_ASK_SPLIT_FARE, this.f15980n);
        unsubscribe(BaseEventKeys.Home.SPLIT_FARE_GET_INVITE_INFO, this.f15981p);
        unsubscribe(BaseEventKeys.Home.SPLIT_FARE_SHOW_ACCEPT_WINDOW, this.f15982q);
        unsubscribe(BaseEventKeys.Home.SPLIT_FARE_REFRESH_DATA, this.f15983r);
        OneLoginFacade.getFunction().removeLoginOutListener(this.f15985t);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0040 A[Catch:{ JSONException -> 0x004f }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m11691a(java.lang.Object r5) {
        /*
            r4 = this;
            java.lang.String r0 = "data"
            boolean r1 = r5 instanceof java.lang.String
            if (r1 == 0) goto L_0x0054
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x004f }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ JSONException -> 0x004f }
            r1.<init>(r5)     // Catch:{ JSONException -> 0x004f }
            java.lang.String r5 = "ty"
            boolean r5 = r1.has(r5)     // Catch:{ JSONException -> 0x004f }
            java.lang.String r2 = "from"
            if (r5 == 0) goto L_0x003a
            boolean r5 = r1.has(r0)     // Catch:{ JSONException -> 0x004f }
            if (r5 == 0) goto L_0x003a
            org.json.JSONObject r5 = r1.optJSONObject(r0)     // Catch:{ JSONException -> 0x004f }
            java.lang.String r0 = com.didi.sdk.push.fcm.FcmSchemeFilter.FROM_NOTIFICATION     // Catch:{ JSONException -> 0x004f }
            java.lang.String r3 = com.didi.sdk.push.fcm.FcmSchemeFilter.FROM_TAG     // Catch:{ JSONException -> 0x004f }
            java.lang.String r1 = r1.optString(r3)     // Catch:{ JSONException -> 0x004f }
            boolean r0 = r0.equals(r1)     // Catch:{ JSONException -> 0x004f }
            if (r0 == 0) goto L_0x0034
            r0 = 4
            r5.put(r2, r0)     // Catch:{ JSONException -> 0x004f }
            goto L_0x0038
        L_0x0034:
            r0 = 2
            r5.put(r2, r0)     // Catch:{ JSONException -> 0x004f }
        L_0x0038:
            r1 = r5
            goto L_0x003e
        L_0x003a:
            r5 = 1
            r1.put(r2, r5)     // Catch:{ JSONException -> 0x004f }
        L_0x003e:
            if (r1 == 0) goto L_0x005d
            java.lang.String r5 = r1.toString()     // Catch:{ JSONException -> 0x004f }
            java.lang.Class<com.didi.component.splitfare.model.NewSplitFareMsg> r0 = com.didi.component.splitfare.model.NewSplitFareMsg.class
            com.didi.component.splitfare.presenter.impl.SplitFareHomePresenter$8 r1 = new com.didi.component.splitfare.presenter.impl.SplitFareHomePresenter$8     // Catch:{ JSONException -> 0x004f }
            r1.<init>()     // Catch:{ JSONException -> 0x004f }
            com.didi.component.common.util.GsonUtils.fromJsonAsync((java.lang.String) r5, r0, r1)     // Catch:{ JSONException -> 0x004f }
            goto L_0x005d
        L_0x004f:
            r5 = move-exception
            r5.printStackTrace()
            goto L_0x005d
        L_0x0054:
            boolean r0 = r5 instanceof com.didi.component.splitfare.model.NewSplitFareMsg
            if (r0 == 0) goto L_0x005d
            com.didi.component.splitfare.model.NewSplitFareMsg r5 = (com.didi.component.splitfare.model.NewSplitFareMsg) r5
            r4.m11679a((com.didi.component.splitfare.model.NewSplitFareMsg) r5)
        L_0x005d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.splitfare.presenter.impl.SplitFareHomePresenter.m11691a(java.lang.Object):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11679a(NewSplitFareMsg newSplitFareMsg) {
        HomeNavDrawerFragment drawerFragment;
        if (newSplitFareMsg != null) {
            if (newSplitFareMsg.from == 3 || newSplitFareMsg.from == 4) {
                m11709g();
                m11692a((Runnable) new Runnable() {
                    public void run() {
                        SplitFareHomePresenter.this.m11695b();
                    }
                });
                return;
            }
            Fragment topVisibleFragment = FragmentUtils.getTopVisibleFragment();
            newSplitFareMsg.inHome = topVisibleFragment != null && topVisibleFragment.getClass().getName().contains("HomeTemplateFragment");
            if (!newSplitFareMsg.inHome) {
                try {
                    m11696b(newSplitFareMsg);
                } catch (Exception e) {
                    e.printStackTrace();
                    GLog.m7968e(TAG, "Can't show window error! type -> WindowManager.LayoutParams.TYPE_APPLICATION_PANEL");
                    BaseEventPublisher.getPublisher().publishSticky(BaseEventKeys.Home.SPLIT_FARE_GET_INVITE_INFO, Boolean.valueOf(newSplitFareMsg.inHome));
                }
            } else {
                Activity currentActivity = ActivityLifecycleManager.getInstance().getCurrentActivity();
                if ((currentActivity instanceof BaseMainActivity) && (drawerFragment = ((BaseMainActivity) currentActivity).getDrawerFragment()) != null && drawerFragment.isDrawerOpen()) {
                    drawerFragment.close();
                }
                BaseEventPublisher.getPublisher().publishSticky(BaseEventKeys.Home.SPLIT_FARE_GET_INVITE_INFO, Boolean.valueOf(newSplitFareMsg.inHome));
            }
        }
    }

    /* renamed from: b */
    private void m11696b(NewSplitFareMsg newSplitFareMsg) {
        Activity currentActivity = ActivityLifecycleManager.getInstance().getCurrentActivity();
        if (currentActivity != null && !this.f15976j) {
            this.f15975i = new SplitFloatWindow(this.mContext, newSplitFareMsg);
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.format = 1;
            layoutParams.flags = 520;
            layoutParams.token = currentActivity.getWindow().getDecorView().getWindowToken();
            layoutParams.type = 1000;
            layoutParams.gravity = 51;
            layoutParams.x = 0;
            layoutParams.y = 0;
            layoutParams.width = UiUtils.getWindowWidth(currentActivity);
            layoutParams.height = UiUtils.dip2px(currentActivity, 71.0f);
            ((WindowManager) this.mContext.getSystemService("window")).addView(this.f15975i.getView(), layoutParams);
            this.f15976j = true;
            this.f15975i.setOnClickCallback(new SplitFloatWindow.OnClickCallback() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    SplitFareHomePresenter.this.m11709g();
                    SplitFareHomePresenter.this.m11692a((Runnable) new Runnable() {
                        public void run() {
                            SplitFareHomePresenter.this.m11695b();
                        }
                    });
                }
            });
            UiThreadHandler.removeCallbacks(this.f15979m);
            UiThreadHandler.postDelayed(this.f15979m, 5000);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11692a(final Runnable runnable) {
        final ActivityLifecycleManager instance = ActivityLifecycleManager.getInstance();
        if (!instance.isMainActivityOnTop()) {
            Activity currentActivity = instance.getCurrentActivity();
            Intent intent = new Intent();
            intent.addFlags(View.STATUS_BAR_TRANSIENT);
            PageRouter.getInstance().startMainActivity(currentActivity, intent);
        }
        UiThreadHandler.postDelayed(new Runnable() {
            public void run() {
                HomeNavDrawerFragment drawerFragment;
                Activity currentActivity = instance.getCurrentActivity();
                if ((currentActivity instanceof BaseMainActivity) && (drawerFragment = ((BaseMainActivity) currentActivity).getDrawerFragment()) != null && drawerFragment.isDrawerOpen()) {
                    drawerFragment.close();
                }
                SplitFareHomePresenter.this.goBackRoot();
                Runnable runnable = runnable;
                if (runnable != null) {
                    runnable.run();
                }
            }
        }, 500);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m11695b() {
        CarOrderHelper.saveOrder((CarOrder) null);
        RecoverStore.getInstance().dispatchForeceRefreshRecoverEvent();
    }

    /* renamed from: c */
    private Map<String, Object> m11700c() {
        String str;
        HashMap hashMap = new HashMap();
        hashMap.put("order_id", this.f15971e);
        hashMap.put("status", 1);
        if (this.f15973g.size() > 0) {
            Iterator<PayWayModel.PayWayItem> it = this.f15973g.iterator();
            String str2 = "";
            while (true) {
                if (!it.hasNext()) {
                    str = "0";
                    break;
                }
                PayWayModel.PayWayItem next = it.next();
                if (next.channelID == 150) {
                    String card = next.getCard();
                    String str3 = next.cardIndex;
                    str2 = card;
                    str = str3;
                    break;
                }
                str2 = next.getLabel();
            }
            hashMap.put("card_suffix", str2);
            hashMap.put("card_index", str);
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty(ParamConst.PARAM_PAY_TYPE, (Number) Integer.valueOf(this.f15978l));
            hashMap.put("extra_info", jsonObject.toString());
        }
        return hashMap;
    }

    public void onAccept(View view) {
        List<PayWayModel.PayWayItem> list = this.f15973g;
        boolean z = list == null || list.isEmpty();
        SplitFareEventTracker.trackEvent(SplitFareEventTracker.EVENT_GP_SPLIT_ACCEPT_BTN_CK, new Attrs().attr("type", z ? "1" : "2"));
        if (z) {
            m11703d();
            return;
        }
        m11705e();
        AcceptSplitFarePopupWindow acceptSplitFarePopupWindow = this.f15974h;
        if (acceptSplitFarePopupWindow != null) {
            acceptSplitFarePopupWindow.dismiss();
        }
        this.f15977k.acceptSplitFare(m11700c(), new ResponseListener<UpdateSplitFareInfo>() {
            public void onSuccess(UpdateSplitFareInfo updateSplitFareInfo) {
                super.onSuccess(updateSplitFareInfo);
                SplitFareHomePresenter.this.m11707f();
                if (!SplitFareHomePresenter.this.mRemoved) {
                    DTSDKOrderDetail dTSDKOrderDetail = updateSplitFareInfo.orderDetail;
                    if (dTSDKOrderDetail.isAvailable()) {
                        CoreHttpRequest.doOrderDetailFetchSuccess(dTSDKOrderDetail, (ITravelOrderListener) null);
                    }
                    Bundle bundle = new Bundle();
                    bundle.putBoolean(INavigation.BUNDLE_KEY_MAP_NEED, true);
                    bundle.putBoolean(IGroupView.BACK_VISIBILITY, true);
                    bundle.putSerializable(BaseExtras.Common.EXTRA_ORDER_BEAN, CarOrderHelper.getOrder());
                    SplitFareHomePresenter.this.mComponentProxy.createSession(SplitFareHomePresenter.TAG);
                    SplitFareHomePresenter.this.mComponentProxy.updateOrderId(SplitFareHomePresenter.this.mComponentProxy.getPageId(), CarOrderHelper.getOrder() == null ? "" : CarOrderHelper.getOrder().oid);
                    bundle.putInt(BaseExtras.Trip.EXTRA_TRIP_SCENE, 10402);
                    SplitFareHomePresenter.this.forward(1040, bundle);
                }
            }

            public void onFail(UpdateSplitFareInfo updateSplitFareInfo) {
                super.onFail(updateSplitFareInfo);
                SplitFareEventTracker.trackEvent(SplitFareEventTracker.EVENT_GP_SPLIT_UNABLE_DLG_SW, new Attrs().attr("error_code", Integer.valueOf(updateSplitFareInfo.errno)));
                SplitFareHomePresenter.this.m11707f();
                SplitFareHomePresenter.this.m11680a(updateSplitFareInfo);
            }

            public void onError(UpdateSplitFareInfo updateSplitFareInfo) {
                super.onError(updateSplitFareInfo);
                SplitFareHomePresenter.this.m11707f();
                SplitFareHomePresenter.this.m11680a(updateSplitFareInfo);
            }
        });
    }

    public void onDecline(View view) {
        SplitFareEventTracker.trackEvent(SplitFareEventTracker.EVENT_GP_SPLIT_DECLINE_BTN_CK);
        m11705e();
        if (this.f15974h != null) {
            GLog.m7973w("mAcceptWindow dismiss()    1, mAcceptWindow:" + this.f15974h.toString());
            this.f15974h.dismiss();
        }
        this.f15977k.rejectSplitFare(m11700c(), new ResponseListener<UpdateSplitFareInfo>() {
            public void onFail(UpdateSplitFareInfo updateSplitFareInfo) {
                super.onFail(updateSplitFareInfo);
                GLog.m7974w(SplitFareHomePresenter.TAG, updateSplitFareInfo.errmsg);
                SplitFareHomePresenter.this.m11680a(updateSplitFareInfo);
            }

            public void onError(UpdateSplitFareInfo updateSplitFareInfo) {
                super.onError(updateSplitFareInfo);
                SplitFareHomePresenter.this.m11680a(updateSplitFareInfo);
            }

            public void onFinish(UpdateSplitFareInfo updateSplitFareInfo) {
                super.onFinish(updateSplitFareInfo);
                SplitFareHomePresenter.this.doPublish(BaseEventKeys.XPanel.EVENT_REFRESH_XPANEL_DATA);
                SplitFareHomePresenter.this.m11707f();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11680a(UpdateSplitFareInfo updateSplitFareInfo) {
        if (updateSplitFareInfo != null) {
            switch (updateSplitFareInfo.errno) {
                case 1020:
                    if (updateSplitFareInfo.data != null) {
                        CancelFeePayParam cancelFeePayParam = new CancelFeePayParam();
                        cancelFeePayParam.bid = GRouterUtil.parseInt(updateSplitFareInfo.data.businessId, FormStore.getInstance().Bid);
                        cancelFeePayParam.oid = updateSplitFareInfo.data.overdraftOid;
                        cancelFeePayParam.sid = FormStore.getInstance().Sid;
                        Intent intent = new Intent(this.mContext, UniCancelFeePayActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("uni_pay_param", cancelFeePayParam);
                        intent.putExtras(bundle);
                        startActivityForResult(intent, 100);
                        return;
                    }
                    m11697b(updateSplitFareInfo);
                    return;
                case SplitFareManager.SPLIT_FARE_ACCEPT_ERROR:
                    if (updateSplitFareInfo.data == null || updateSplitFareInfo.data.code != 100001) {
                        m11697b(updateSplitFareInfo);
                        return;
                    }
                    DidiGlobalVerifyCardData.VerifyCardParam verifyCardParam = new DidiGlobalVerifyCardData.VerifyCardParam();
                    Iterator<PayWayModel.PayWayItem> it = this.f15973g.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            PayWayModel.PayWayItem next = it.next();
                            if (next.channelID == 150) {
                                verifyCardParam.cardIndex = next.cardIndex;
                                verifyCardParam.cardNo = next.card;
                            }
                        }
                    }
                    DidiCreditCardFactory.createGlobalCreditCardApi().startVerifyBalanceActivity(getHost(), requestCodeForHost(6), verifyCardParam);
                    return;
                case SplitFareManager.SPLIT_FARE_UNBIND_CARD_ERROR:
                case SplitFareManager.SPLIT_FARE_NOT_IN_ORDER_ERROR:
                    m11697b(updateSplitFareInfo);
                    return;
                default:
                    m11697b(updateSplitFareInfo);
                    return;
            }
        }
    }

    /* renamed from: b */
    private void m11697b(UpdateSplitFareInfo updateSplitFareInfo) {
        GlobalCommonBottomPop.BottomPopModel bottomPopModel = new GlobalCommonBottomPop.BottomPopModel();
        bottomPopModel.title = updateSplitFareInfo.data != null ? updateSplitFareInfo.data.title : "";
        bottomPopModel.content = updateSplitFareInfo.errmsg;
        bottomPopModel.isShowNegative = false;
        bottomPopModel.positive = this.mContext.getString(R.string.fine);
        final GlobalCommonBottomPop globalCommonBottomPop = new GlobalCommonBottomPop(this.mContext, bottomPopModel);
        globalCommonBottomPop.setCanceledOnTouchOutside(true);
        globalCommonBottomPop.setBottomActionListener(new GlobalCommonBottomPop.GlobalBottomPopActionListener() {
            public void onNegativeClick() {
            }

            public void onPositiveClick() {
                SplitFareHomePresenter.this.doPublish(BaseEventKeys.XPanel.EVENT_REFRESH_XPANEL_DATA);
                globalCommonBottomPop.dismiss();
            }
        });
        globalCommonBottomPop.show();
    }

    public void onPaymentClick(View view) {
        SplitFareEventTracker.trackEvent(SplitFareEventTracker.EVENT_GP_SPLIT_PAY_BTN_CK);
        m11703d();
    }

    /* renamed from: d */
    private void m11703d() {
        DidiGlobalPayMethodListData.PayMethodListParam payMethodListParam = new DidiGlobalPayMethodListData.PayMethodListParam(DidiGlobalPayMethodListData.Entrance.FROM_SPLIT_FARE);
        payMethodListParam.list = m11678a(this.f15972f.splitUserPayList);
        ((Request) DRouter.build("/payway/global_pay_method_list").putExtra("pay_method_list_param", (Serializable) payMethodListParam)).start(this.mContext, new RouterCallback.ActivityCallback() {
            public void onActivityResult(int i, Intent intent) {
                if (-1 == i && intent != null) {
                    SplitFareHomePresenter.this.m11689a((DidiGlobalPayMethodListData.PayMethodListResult) intent.getSerializableExtra("pay_method_list_result"));
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11689a(DidiGlobalPayMethodListData.PayMethodListResult payMethodListResult) {
        if (payMethodListResult != null) {
            List<PayWayModel.PayWayItem> b = m11694b(payMethodListResult);
            if (!b.isEmpty()) {
                this.f15973g.clear();
                this.f15973g.addAll(b);
            }
            this.f15978l = 0;
            for (PayWayModel.PayWayItem next : this.f15973g) {
                if (next != null) {
                    next.isSelected = 1;
                    this.f15978l = next.tag | this.f15978l;
                }
            }
            AcceptSplitFarePopupWindow acceptSplitFarePopupWindow = this.f15974h;
            if (acceptSplitFarePopupWindow != null && acceptSplitFarePopupWindow.isShowing()) {
                this.f15974h.updatePaymentLabel(this.f15973g);
            }
        }
    }

    /* renamed from: b */
    private List<PayWayModel.PayWayItem> m11694b(DidiGlobalPayMethodListData.PayMethodListResult payMethodListResult) {
        ArrayList arrayList = new ArrayList();
        if (!(payMethodListResult == null || payMethodListResult.selectedPayMethods == null)) {
            for (DidiGlobalPayMethodListData.SelectedPayMethod a : payMethodListResult.selectedPayMethods) {
                PayWayModel.PayWayItem a2 = m11675a(a);
                if (a2 != null) {
                    arrayList.add(a2);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private PayWayModel.PayWayItem m11675a(DidiGlobalPayMethodListData.SelectedPayMethod selectedPayMethod) {
        List<PayWayModel.PayWayItem> list = this.f15972f.splitUserPayList;
        if (selectedPayMethod == null || selectedPayMethod.channelId <= 0 || list == null) {
            return null;
        }
        for (PayWayModel.PayWayItem next : list) {
            if (next.channelID == selectedPayMethod.channelId) {
                next.cardIndex = selectedPayMethod.cardIndex;
                next.card = selectedPayMethod.cardNo;
                if (!TextUtils.isEmpty(selectedPayMethod.iconUrl)) {
                    next.card_org = selectedPayMethod.iconUrl;
                }
                return next;
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public List<DidiGlobalPayMethodListData.PayMethodInfo> m11678a(List<PayWayModel.PayWayItem> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (PayWayModel.PayWayItem a : list) {
            DidiGlobalPayMethodListData.PayMethodInfo a2 = m11673a(a);
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private DidiGlobalPayMethodListData.PayMethodInfo m11673a(PayWayModel.PayWayItem payWayItem) {
        if (payWayItem == null) {
            return null;
        }
        DidiGlobalPayMethodListData.PayMethodInfo payMethodInfo = new DidiGlobalPayMethodListData.PayMethodInfo();
        payMethodInfo.channelId = payWayItem.channelID;
        payMethodInfo.title = payWayItem.title;
        payMethodInfo.subTitle = payWayItem.text;
        payMethodInfo.isSelected = payWayItem.isSelected == 1;
        payMethodInfo.isSigned = payWayItem.isSigned == 1;
        payMethodInfo.isEnabled = payWayItem.disabled == 0;
        payMethodInfo.iconUrl = payWayItem.iconUrl;
        payMethodInfo.combineTag = payWayItem.tag;
        if (payWayItem.can_combination_pay_type != null && !payWayItem.can_combination_pay_type.isEmpty()) {
            payMethodInfo.allowedCombineTags = new HashSet(payWayItem.can_combination_pay_type);
        }
        payMethodInfo.isSufficient = true;
        payMethodInfo.info = payWayItem.balanceMsg;
        if (payWayItem.extroInfoItemList != null) {
            payMethodInfo.cardList = new ArrayList(payWayItem.extroInfoItemList.size());
            for (PayWayModel.ExtroInfoItem next : payWayItem.extroInfoItemList) {
                DidiGlobalPayMethodListData.CardInfo cardInfo = new DidiGlobalPayMethodListData.CardInfo();
                cardInfo.cardIndex = next.cardIndex;
                cardInfo.cardNo = next.cardSuffix;
                cardInfo.iconUrl = next.cardOrg;
                cardInfo.isSelected = TextUtils.equals(next.cardIndex, payWayItem.cardIndex) && payWayItem.isSelected == 1;
                cardInfo.cardStatus = next.cardStatus;
                cardInfo.cardDesc = next.cardDesc;
                payMethodInfo.cardList.add(cardInfo);
            }
        }
        return payMethodInfo;
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m11705e() {
        doPublish("event_show_loading_on_titlebar_in_home");
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m11707f() {
        doPublish("event_hide_loading_on_titlebar_in_home");
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m11709g() {
        SplitFloatWindow splitFloatWindow = this.f15975i;
        if (splitFloatWindow != null && splitFloatWindow.getView() != null) {
            this.f15975i.setOnClickCallback((SplitFloatWindow.OnClickCallback) null);
            try {
                this.f15976j = false;
                WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
                if (windowManager != null) {
                    windowManager.removeView(this.f15975i.getView());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        if ((6 == i && i2 == -1) || 100 == i) {
            DTSDKSplitFareInfo dTSDKSplitFareInfo = this.f15972f;
            if (dTSDKSplitFareInfo != null) {
                m11690a(dTSDKSplitFareInfo);
            } else {
                doPublish(BaseEventKeys.Home.SPLIT_FARE_REFRESH_DATA);
            }
        }
    }
}
