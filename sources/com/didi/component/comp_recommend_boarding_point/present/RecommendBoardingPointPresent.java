package com.didi.component.comp_recommend_boarding_point.present;

import android.os.Bundle;
import android.os.CountDownTimer;
import com.didi.common.map.model.LatLng;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.GlobalApolloUtil;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.NotificationUtils;
import com.didi.component.business.xpanelnew.IXpCardBindDataReady;
import com.didi.component.business.xpanelnew.IXpCardBindDataReadyCallback;
import com.didi.component.business.xpanelnew.IXpCardLifeCycle;
import com.didi.component.common.net.CarRequest;
import com.didi.component.common.util.GLog;
import com.didi.component.comp_recommend_boarding_point.AbsRecommendBoardingPointPresent;
import com.didi.component.comp_recommend_boarding_point.view.RecommendBoardingPointView;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.global.globaluikit.toast.LEGOToastHelper;
import com.didi.map.global.sctx.model.SecRouteInfoEx;
import com.didi.map.sdk.proto.driver_gl.PickupPoint;
import com.didi.raven.config.RavenKey;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.app.DIDIApplication;
import com.didi.sdk.util.SPUtils;
import com.didi.soda.customer.app.constant.Const;
import com.didi.travel.psnger.common.net.base.BaseObject;
import com.didi.travel.psnger.common.net.base.ResponseListener;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didi.travel.psnger.model.response.GlobalRichInfo;
import com.didi.travel.psnger.utils.TextUtil;
import com.taxis99.R;
import global.didi.pay.omega.GlobalPayOmegaConstant;
import java.util.HashMap;
import java.util.Map;

public class RecommendBoardingPointPresent extends AbsRecommendBoardingPointPresent<RecommendBoardingPointView> implements IXpCardBindDataReady, IXpCardLifeCycle {

    /* renamed from: a */
    private static final String f12353a = "RecommendBoardingPointPresent";

    /* renamed from: b */
    private String f12354b;

    /* renamed from: c */
    private String f12355c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public int f12356d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public SecRouteInfoEx f12357e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f12358f;

    /* renamed from: g */
    private boolean f12359g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f12360h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public int f12361i;

    /* renamed from: j */
    private int f12362j;

    /* renamed from: k */
    private int f12363k;

    /* renamed from: l */
    private CountDownTimer f12364l;

    /* renamed from: m */
    private PickupPoint f12365m;

    /* renamed from: n */
    private final BaseEventPublisher.OnEventListener<SecRouteInfoEx> f12366n = new BaseEventPublisher.OnEventListener<SecRouteInfoEx>() {
        public void onEvent(String str, SecRouteInfoEx secRouteInfoEx) {
            GLog.m7968e(RecommendBoardingPointPresent.f12353a, "onEvent:mRecommendBoardingPointShowEventListener mViewBind " + RecommendBoardingPointPresent.this.f12358f);
            if (!RecommendBoardingPointPresent.this.f12360h) {
                SecRouteInfoEx unused = RecommendBoardingPointPresent.this.f12357e = secRouteInfoEx;
                SPUtils.put(RecommendBoardingPointPresent.this.mContext, "CurPPGrtMsg", secRouteInfoEx.getCurPPGrtMsg());
                SPUtils.put(RecommendBoardingPointPresent.this.mContext, "CantChgMsg", secRouteInfoEx.getCantChgMsg());
                if (RecommendBoardingPointPresent.this.f12358f) {
                    RecommendBoardingPointPresent.this.doPublish(BaseEventKeys.NewXpanel.EVENT_REFRESH_XPANEL_NEW);
                }
                if (!GlobalApolloUtil.isShowNotify() || secRouteInfoEx == null || TextUtil.isEmpty(secRouteInfoEx.getMainTitle()) || TextUtil.isEmpty(secRouteInfoEx.getSubTitle())) {
                    GLog.m7968e(RecommendBoardingPointPresent.f12353a, "onEvent: title or subtitle is null");
                    return;
                }
                GLog.m7968e(RecommendBoardingPointPresent.f12353a, "onEvent: showNotification");
                GlobalRichInfo globalRichInfo = new GlobalRichInfo();
                globalRichInfo.setInfo(secRouteInfoEx.getMainTitle());
                String content = globalRichInfo.getContent();
                GlobalRichInfo globalRichInfo2 = new GlobalRichInfo();
                globalRichInfo2.setInfo(secRouteInfoEx.getSubTitle());
                NotificationUtils.getInstance(DIDIApplication.getAppContext()).showNotification(1114, content, globalRichInfo2.getContent(), true, false, false, (String) null);
            }
        }
    };

    /* renamed from: p */
    private final BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f12367p = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            GLog.m7968e(RecommendBoardingPointPresent.f12353a, "onEvent:mHideCardListener " + RecommendBoardingPointPresent.this.f12360h);
            if (RecommendBoardingPointPresent.this.f12360h) {
                int unused = RecommendBoardingPointPresent.this.f12361i = 3;
                RecommendBoardingPointPresent.this.m8391c();
            }
        }
    };

    /* renamed from: q */
    private final BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f12368q = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (SPUtils.get(RecommendBoardingPointPresent.this.mContext, "CurPPGrtMsg", "") != null) {
                String str2 = (String) SPUtils.get(RecommendBoardingPointPresent.this.mContext, "CurPPGrtMsg", "");
                if (!TextUtil.isEmpty(str2)) {
                    LEGOToastHelper.showShortToast(RecommendBoardingPointPresent.this.mContext, str2, R.drawable.common_toast_icon_failure);
                } else {
                    GLog.m7968e(RecommendBoardingPointPresent.f12353a, "onEvent: secRouteInfoEx.getCurPPGrtMsg() is null");
                }
            }
        }
    };

    /* renamed from: r */
    private final BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f12369r = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (RecommendBoardingPointPresent.this.f12360h) {
                RecommendBoardingPointPresent.this.m8387b();
            }
        }
    };

    /* renamed from: j */
    static /* synthetic */ int m8401j(RecommendBoardingPointPresent recommendBoardingPointPresent) {
        int i = recommendBoardingPointPresent.f12356d;
        recommendBoardingPointPresent.f12356d = i - 1;
        return i;
    }

    public RecommendBoardingPointPresent(ComponentParams componentParams) {
        super(componentParams.bizCtx.getContext());
        GLog.m7968e(f12353a, "RecommendBoardingPointPresent: ");
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        GLog.m7968e(f12353a, "onAdd: ");
        subscribe(BaseEventKeys.OnService.EVENT_RECOMMEND_BOARDING_POINT_SHOW, this.f12366n);
        subscribe(BaseEventKeys.OnService.EVENT_RECOMMEND_BOARDING_POINT_CARD_HIDE, this.f12367p);
        subscribe(BaseEventKeys.Service.EVENT_ORDER_STATUS_RECEIVED, this.f12369r);
        subscribe(BaseEventKeys.OnService.EVENT_RECOMMEND_BOARDING_POINT_SHOW_TOAST, this.f12368q);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m8387b() {
        CarOrder order = CarOrderHelper.getOrder();
        if (order == null) {
            return;
        }
        if (order.status == 4 || order.status == 1) {
            int i = order.substatus;
            if (i == 4003 || i == 4004 || i == 4007) {
                this.f12361i = 4;
                m8391c();
                String str = (String) SPUtils.get(this.mContext, "CantChgMsg", "");
                if (!TextUtil.isEmpty(str)) {
                    LEGOToastHelper.showShortToast(this.mContext, str, R.drawable.common_toast_icon_failure);
                }
            }
        }
    }

    /* renamed from: a */
    private void m8380a(SecRouteInfoEx secRouteInfoEx) {
        this.f12365m = secRouteInfoEx.getPickupPoint();
        this.f12356d = secRouteInfoEx.getRouteTerm();
        this.f12354b = secRouteInfoEx.getChgSuccMsg();
        this.f12355c = secRouteInfoEx.getCantChgMsg();
        String mainTitle = secRouteInfoEx.getMainTitle();
        String subTitle = secRouteInfoEx.getSubTitle();
        String useMsg = secRouteInfoEx.getUseMsg();
        ((RecommendBoardingPointView) this.mView).setTitle(mainTitle);
        ((RecommendBoardingPointView) this.mView).setContent(subTitle);
        ((RecommendBoardingPointView) this.mView).setButtonText(useMsg);
        this.f12362j = secRouteInfoEx.getBubType();
        final String ignMsg = secRouteInfoEx.getIgnMsg();
        m8394d();
        C51265 r1 = new CountDownTimer((long) (this.f12356d * 1000), 1000) {
            public void onFinish() {
            }

            public void onTick(long j) {
                String str;
                RecommendBoardingPointPresent.m8401j(RecommendBoardingPointPresent.this);
                if (!TextUtil.isEmpty(ignMsg)) {
                    str = ignMsg + "(" + RecommendBoardingPointPresent.this.f12356d + "s)";
                } else {
                    GLog.m7970i("RecommendBoardingPointPresentbindData>> getIgnMsg is null");
                    str = "(" + RecommendBoardingPointPresent.this.f12356d + "s)";
                }
                if (RecommendBoardingPointPresent.this.f12356d > 0) {
                    ((RecommendBoardingPointView) RecommendBoardingPointPresent.this.mView).setTime(str);
                } else {
                    ((RecommendBoardingPointView) RecommendBoardingPointPresent.this.mView).setTime("");
                }
                if (RecommendBoardingPointPresent.this.f12356d < 1 && RecommendBoardingPointPresent.this.f12360h) {
                    int unused = RecommendBoardingPointPresent.this.f12361i = 1;
                    GLog.m7965d(RecommendBoardingPointPresent.f12353a, "onTick mRouteTerm<1");
                    RecommendBoardingPointPresent.this.m8383a(false);
                }
            }
        };
        this.f12364l = r1;
        r1.start();
    }

    public void cardUseDismissClick(boolean z) {
        PickupPoint pickupPoint;
        this.f12361i = 2;
        if (!z || (pickupPoint = this.f12365m) == null) {
            m8383a(false);
        } else {
            m8381a(pickupPoint);
        }
        m8394d();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8383a(boolean z) {
        m8392c(z);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m8391c() {
        m8392c(false);
    }

    /* renamed from: b */
    private void m8388b(boolean z) {
        String str;
        int i;
        if (z) {
            str = this.f12354b;
            i = R.drawable.common_toast_icon_success;
        } else {
            str = this.f12355c;
            i = R.drawable.common_toast_icon_failure;
        }
        if (!TextUtil.isEmpty(str)) {
            LEGOToastHelper.showShortToast(this.mContext, str, i);
        }
    }

    /* renamed from: a */
    private void m8381a(PickupPoint pickupPoint) {
        GLog.m7968e(f12353a, "updateAddress: ");
        final Address b = m8386b(pickupPoint);
        final CarOrder order = CarOrderHelper.getOrder();
        if (order == null || TextUtil.isEmpty(order.oid)) {
            GLog.m7965d("updateAddress", "route is null");
            return;
        }
        final LatLng latLng = new LatLng(pickupPoint.lat.doubleValue(), pickupPoint.lng.doubleValue());
        CarRequest.updatePickUp(this.mContext, order.oid, b, new ResponseListener<BaseObject>() {
            public void onSuccess(BaseObject baseObject) {
                super.onSuccess(baseObject);
                GLog.m7968e(RecommendBoardingPointPresent.f12353a, "onSuccess: ");
                order.showUpdatePickUpPop = false;
                order.startAddress = b;
                RecommendBoardingPointPresent.this.doPublish(BaseEventKeys.OnService.EVENT_RECOMMEND_BOARDING_POINT_UPDATE_ADDRESS, latLng);
                RecommendBoardingPointPresent.this.doPublish("event_sctx_state_change");
                RecommendBoardingPointPresent.this.m8384a(true, order.oid);
            }

            public void onError(BaseObject baseObject) {
                super.onError(baseObject);
                GLog.m7964d("onError: " + baseObject.toString());
                GLog.m7968e(RecommendBoardingPointPresent.f12353a, "onError: ");
                RecommendBoardingPointPresent.this.m8384a(false, order.oid);
            }

            public void onFail(BaseObject baseObject) {
                super.onFail(baseObject);
                GLog.m7964d("onError: " + baseObject.toString());
                GLog.m7968e(RecommendBoardingPointPresent.f12353a, "onFail: ");
                RecommendBoardingPointPresent.this.m8384a(false, order.oid);
            }

            public void onFinish(BaseObject baseObject) {
                super.onFinish(baseObject);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8384a(boolean z, String str) {
        if (z) {
            this.f12363k = 1;
            m8383a(true);
        } else {
            this.f12363k = 0;
            m8392c(false);
        }
        m8382a(str);
        m8388b(z);
    }

    /* renamed from: b */
    private Address m8386b(PickupPoint pickupPoint) {
        Address address = new Address();
        address.latitude = pickupPoint.lat.doubleValue();
        address.longitude = pickupPoint.lng.doubleValue();
        address.displayName = pickupPoint.displayName;
        address.address = pickupPoint.address;
        address.fullName = pickupPoint.fullName;
        address.poiId = pickupPoint.poiId;
        address.srcTag = pickupPoint.srcTag;
        return address;
    }

    /* renamed from: c */
    private void m8392c(boolean z) {
        this.f12359g = true;
        ((RecommendBoardingPointView) this.mView).hideView();
        if (this.f12360h) {
            m8395d(false);
        }
        this.f12360h = false;
        doPublish(BaseEventKeys.NewXpanel.EVENT_REFRESH_XPANEL_NEW);
        if (!z) {
            GLog.m7965d(f12353a, "hideCard unClick");
            doPublish(BaseEventKeys.OnService.EVENT_RECOMMEND_BOARDING_POINT_CARD_DISMISS);
        }
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        GLog.m7968e(f12353a, "onRemove: ");
        super.onRemove();
        unsubscribe(BaseEventKeys.OnService.EVENT_RECOMMEND_BOARDING_POINT_SHOW, this.f12366n);
        unsubscribe(BaseEventKeys.OnService.EVENT_RECOMMEND_BOARDING_POINT_CARD_HIDE, this.f12367p);
        unsubscribe(BaseEventKeys.Service.EVENT_ORDER_STATUS_RECEIVED, this.f12369r);
        unsubscribe(BaseEventKeys.OnService.EVENT_RECOMMEND_BOARDING_POINT_SHOW_TOAST, this.f12368q);
        m8394d();
        if (this.f12360h) {
            m8392c(false);
        }
    }

    public void viewBindBizDataReady(IXpCardBindDataReadyCallback iXpCardBindDataReadyCallback) {
        GLog.m7968e(f12353a, "viewBindBizDataReady:mIsHideCard " + this.f12359g);
        if (this.f12359g) {
            iXpCardBindDataReadyCallback.ready(false);
            this.f12360h = false;
            return;
        }
        SecRouteInfoEx secRouteInfoEx = this.f12357e;
        if (secRouteInfoEx == null) {
            iXpCardBindDataReadyCallback.ready(false);
            this.f12360h = false;
        } else {
            m8380a(secRouteInfoEx);
            iXpCardBindDataReadyCallback.ready(true);
            this.f12360h = true;
        }
        this.f12358f = true;
    }

    public void onCardAdd() {
        GLog.m7968e(f12353a, "onCardAdd: ");
        m8395d(true);
    }

    public void onCardRemove() {
        GLog.m7968e(f12353a, "onCardRemove: ");
        m8394d();
    }

    /* renamed from: d */
    private void m8395d(boolean z) {
        String str;
        HashMap hashMap = new HashMap();
        CarOrder order = CarOrderHelper.getOrder();
        hashMap.put("g_OrderId", (order == null || TextUtil.isEmpty(order.oid)) ? "" : order.oid);
        if (z) {
            hashMap.put("k", "show");
            hashMap.put(RavenKey.VERSION, Const.ComponentType.BANNER);
            str = "ibt_gp_tbd_sw";
        } else {
            hashMap.put("k", "click");
            hashMap.put(RavenKey.VERSION, "dismiss");
            hashMap.put("style", Integer.valueOf(this.f12361i));
            str = "ibt_gp_tbd_ck";
        }
        hashMap.put("type", Integer.valueOf(this.f12362j));
        hashMap.put(GlobalPayOmegaConstant.EventKey.TAB, "tbd_banner");
        hashMap.put("pretab", "pick");
        GlobalOmegaUtils.trackEvent(str, (Map<String, Object>) hashMap);
    }

    /* renamed from: a */
    private void m8382a(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("g_OrderId", str);
        hashMap.put("k", "click");
        hashMap.put(RavenKey.VERSION, "tochange");
        hashMap.put("type", Integer.valueOf(this.f12362j));
        hashMap.put("style", Integer.valueOf(this.f12363k));
        hashMap.put(GlobalPayOmegaConstant.EventKey.TAB, "tbd_banner");
        hashMap.put("pretab", "pick");
        GlobalOmegaUtils.trackEvent("ibt_gp_tbd_ck", (Map<String, Object>) hashMap);
    }

    /* renamed from: d */
    private void m8394d() {
        CountDownTimer countDownTimer = this.f12364l;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.f12364l = null;
        }
    }
}
