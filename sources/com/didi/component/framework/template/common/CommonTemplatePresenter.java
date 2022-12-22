package com.didi.component.framework.template.common;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.constant.BaseExtras;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.common.base.ComponentProxy;
import com.didi.component.common.base.ComponentType;
import com.didi.component.common.base.ComponentWrap;
import com.didi.component.common.util.GLog;
import com.didi.component.core.Animations;
import com.didi.component.core.IPresenter;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.framework.base.XPanelLoadingPresenterGroup;
import com.didi.component.framework.base.constructor.interfaces.presenter.IGlobalPresenter;
import com.didi.sdk.app.BusinessContext;
import com.didi.travel.p171v2.store.Store;
import com.didi.travel.p171v2.util.LogUtils;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didi.travel.psnger.p170v2.TravelConstant;
import com.didi.travel.psnger.p170v2.TravelUtil;

public class CommonTemplatePresenter extends XPanelLoadingPresenterGroup<ICommonTemplateView> implements IGlobalPresenter {

    /* renamed from: a */
    private final String f13953a;

    /* renamed from: b */
    private BusinessContext f13954b;

    /* renamed from: c */
    private int f13955c;

    /* renamed from: d */
    private int f13956d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f13957e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f13958f;

    /* renamed from: g */
    private BaseEventPublisher.OnEventListener<ComponentWrap> f13959g;

    /* renamed from: h */
    private BaseEventPublisher.OnEventListener<String> f13960h;

    /* renamed from: i */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f13961i;
    protected boolean isCreateSession;
    protected boolean isFillCarOrderOnCreateSession;
    protected ComponentProxy mComponentProxy;
    protected int mPageId;

    public CommonTemplatePresenter(Context context, final Bundle bundle) {
        super(context, bundle);
        this.f13953a = getClass().getSimpleName();
        this.f13957e = false;
        this.f13958f = false;
        this.f13959g = new BaseEventPublisher.OnEventListener<ComponentWrap>() {
            public void onEvent(String str, ComponentWrap componentWrap) {
                if (BaseEventKeys.Template.EVENT_SHOW_POPUP_COMPONENT.equals(str)) {
                    ((ICommonTemplateView) CommonTemplatePresenter.this.mView).showPopupComponent(componentWrap);
                }
            }
        };
        this.f13960h = new BaseEventPublisher.OnEventListener<String>() {
            public void onEvent(String str, String str2) {
                if (BaseEventKeys.Template.EVENT_HIDE_POPUP_COMPONENT.equals(str)) {
                    ((ICommonTemplateView) CommonTemplatePresenter.this.mView).hidePopupComponent(str2);
                }
            }
        };
        this.f13961i = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
            public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
                if ("event_show_sug_page_container".equals(str)) {
                    ((ICommonTemplateView) CommonTemplatePresenter.this.mView).showSugPageContainer();
                } else if ("event_hide_sug_page_container".equals(str)) {
                    ((ICommonTemplateView) CommonTemplatePresenter.this.mView).hideSugPageContainer();
                } else if ("event_show_loading_on_titlebar_in_home".equals(str)) {
                    ((ICommonTemplateView) CommonTemplatePresenter.this.mView).showLoadingOnTitleBar();
                } else if ("event_hide_loading_on_titlebar_in_home".equals(str)) {
                    ((ICommonTemplateView) CommonTemplatePresenter.this.mView).hideLoading();
                } else if (BaseEventKeys.WaitRsp.EVENT_BEFORE_GOTO_WAITRSP_ANIMATION.equals(str)) {
                    ((ICommonTemplateView) CommonTemplatePresenter.this.mView).beforeOutAnimation();
                } else if (BaseEventKeys.WaitRsp.EVENT_BEFORE_OUT_WAITRSP_ANIMATION.equals(str) || BaseEventKeys.WaitRsp.EVENT_BEFORE_OUT_WAITRSP_ANIMATION_DUE_CANCEL.equals(str)) {
                    ((ICommonTemplateView) CommonTemplatePresenter.this.mView).beforeOutAnimation();
                } else if (BaseEventKeys.Evaluate.EVALUATE_CLOSED.equals(str) || BaseEventKeys.Evaluate.EVALUATE_SUBMIT_SUCCESS.equals(str)) {
                    ((ICommonTemplateView) CommonTemplatePresenter.this.mView).hidePopupComponent(ComponentType.EVALUATE);
                } else if (BaseEventKeys.Template.EVENT_BOTTOM_SHEET_SHOW.equals(str)) {
                    ((ICommonTemplateView) CommonTemplatePresenter.this.mView).showBottomSheet();
                } else if (BaseEventKeys.Template.EVENT_BOTTOM_SHEET_HIDE.equals(str)) {
                    CommonTemplatePresenter.this.goBack();
                } else if (BaseEventKeys.Trip.EVENT_GLOBAL_NO_PSD_PROCESSING_HIDE.equals(str)) {
                    boolean unused = CommonTemplatePresenter.this.f13957e = true;
                    CommonTemplatePresenter.this.m9681b();
                } else if (BaseEventKeys.Trip.EVENT_GLOBAL_NO_PSD_PROCESSING_SHOWING.equals(str)) {
                    ((ICommonTemplateView) CommonTemplatePresenter.this.mView).showPayProcessLoading4XPanel();
                } else if (BaseEventKeys.NewXpanel.EVENT_XPANEL_HEIGHT_CHANGED_4_PAY_XPANEL_READY.equals(str)) {
                    boolean unused2 = CommonTemplatePresenter.this.f13958f = true;
                    CommonTemplatePresenter.this.m9681b();
                } else if (BaseEventKeys.Trip.EVENT_GLOBAL_NO_PSD_PROCESSING_SHOWING_FROM_XPANEL.equals(str)) {
                    ((ICommonTemplateView) CommonTemplatePresenter.this.mView).showPayProcessLoading();
                }
            }
        };
        this.f13955c = bundle.getInt(BaseExtras.Common.EXTRA_CURRENT_BID);
        this.f13956d = bundle.getInt(BaseExtras.Common.EXTRA_CURRENT_COMBOTYPE);
        this.mComponentProxy = new ComponentProxy(new ComponentProxy.ComponentCallback() {
            public int getPageId() {
                return CommonTemplatePresenter.this.mPageId;
            }

            public void afterOrderIdUpdate() {
                super.afterOrderIdUpdate();
                bundle.putString(TravelConstant.EXTRA_ORDER_ID, CommonTemplatePresenter.this.mComponentProxy.getOrderId());
            }
        }, getClass().getSimpleName());
    }

    public CommonTemplatePresenter(BusinessContext businessContext, Bundle bundle) {
        this(businessContext.getContext(), bundle);
        this.f13954b = businessContext;
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        this.mPageId = bundle.getInt(TravelConstant.EXTRA_PAGE_ID);
        this.mComponentProxy.onAdd(bundle);
        boolean z = bundle.getBoolean(TravelConstant.EXTRA_CREATE_SESSION, false);
        this.isCreateSession = z;
        if (z) {
            this.mComponentProxy.createSession(bundle.getString(TravelConstant.EXTRA_SESSION_TAG));
            boolean z2 = bundle.getBoolean(TravelConstant.EXTRA_IS_FILL_CAR_ORDER_ON_CREATE_SESSION, false);
            this.isFillCarOrderOnCreateSession = z2;
            if (z2 && CarOrderHelper.getOrder() != null) {
                CarOrder order = CarOrderHelper.getOrder();
                ComponentProxy componentProxy = this.mComponentProxy;
                componentProxy.updateOrderId(componentProxy.getPageId(), order.oid);
                Store store = Store.getStore(TravelUtil.generateCarOrderStoreKey(order.oid));
                if (store != null) {
                    store.setOuterLifecycle(this.mComponentProxy.getSession().getLifecycle());
                } else {
                    LogUtils.m31492e(this.f13953a, "onAdd:store is null");
                }
            }
        }
        String str = this.f13953a;
        LogUtils.m31493i(str, "onAdd:mComponentProxy.getBundle() = " + this.mComponentProxy.getBundle());
        if (this.mComponentProxy.getBundle() != null) {
            bundle.putAll(this.mComponentProxy.getBundle());
        }
        String str2 = this.f13953a;
        LogUtils.m31493i(str2, "onAdd:arguments = " + bundle);
        registerListener();
        m9678a(bundle);
    }

    /* renamed from: a */
    private void m9678a(Bundle bundle) {
        if (bundle.getInt(BaseExtras.EndService.EXTRA_FIRST_VIEW, 0) == 2) {
            GLog.m7964d("end service on add auto pay");
            ((ICommonTemplateView) this.mView).showPopupComponent(new ComponentWrap("payment", bundle));
        }
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        this.mComponentProxy.onRemove();
        unregisterListener();
    }

    public void onPaddingTopChanged(int i) {
        doPublish(BaseEventKeys.Location.EVENT_PADDING_TOP, Integer.valueOf(i));
    }

    /* access modifiers changed from: protected */
    public void registerListener() {
        subscribe(BaseEventKeys.Template.EVENT_SHOW_POPUP_COMPONENT, this.f13959g);
        subscribe(BaseEventKeys.Template.EVENT_HIDE_POPUP_COMPONENT, this.f13960h);
        subscribe("event_show_sug_page_container", this.f13961i);
        subscribe("event_hide_sug_page_container", this.f13961i);
        subscribe("event_show_loading_on_titlebar_in_home", this.f13961i);
        subscribe("event_hide_loading_on_titlebar_in_home", this.f13961i);
        subscribe(BaseEventKeys.WaitRsp.EVENT_BEFORE_GOTO_WAITRSP_ANIMATION, this.f13961i);
        subscribe(BaseEventKeys.WaitRsp.EVENT_BEFORE_OUT_WAITRSP_ANIMATION, this.f13961i);
        subscribe(BaseEventKeys.WaitRsp.EVENT_BEFORE_OUT_WAITRSP_ANIMATION_DUE_CANCEL, this.f13961i);
        subscribe(BaseEventKeys.Evaluate.EVALUATE_CLOSED, this.f13961i);
        subscribe(BaseEventKeys.Evaluate.EVALUATE_SUBMIT_SUCCESS, this.f13961i);
        subscribe(BaseEventKeys.Template.EVENT_BOTTOM_SHEET_HIDE, this.f13961i);
        subscribe(BaseEventKeys.Trip.EVENT_GLOBAL_NO_PSD_PROCESSING_SHOWING, this.f13961i);
        subscribe(BaseEventKeys.Trip.EVENT_GLOBAL_NO_PSD_PROCESSING_SHOWING_FROM_XPANEL, this.f13961i);
        subscribe(BaseEventKeys.NewXpanel.EVENT_XPANEL_HEIGHT_CHANGED_4_PAY_XPANEL_READY, this.f13961i);
        subscribe(BaseEventKeys.Trip.EVENT_GLOBAL_NO_PSD_PROCESSING_HIDE, this.f13961i);
    }

    /* access modifiers changed from: protected */
    public void unregisterListener() {
        unsubscribe(BaseEventKeys.Template.EVENT_SHOW_POPUP_COMPONENT, this.f13959g);
        unsubscribe(BaseEventKeys.Template.EVENT_HIDE_POPUP_COMPONENT, this.f13960h);
        unsubscribe("event_show_sug_page_container", this.f13961i);
        unsubscribe("event_hide_sug_page_container", this.f13961i);
        unsubscribe("event_show_loading_on_titlebar_in_home", this.f13961i);
        unsubscribe("event_hide_loading_on_titlebar_in_home", this.f13961i);
        unsubscribe(BaseEventKeys.WaitRsp.EVENT_BEFORE_GOTO_WAITRSP_ANIMATION, this.f13961i);
        unsubscribe(BaseEventKeys.WaitRsp.EVENT_BEFORE_OUT_WAITRSP_ANIMATION, this.f13961i);
        unsubscribe(BaseEventKeys.WaitRsp.EVENT_BEFORE_OUT_WAITRSP_ANIMATION_DUE_CANCEL, this.f13961i);
        unsubscribe(BaseEventKeys.Evaluate.EVALUATE_CLOSED, this.f13961i);
        unsubscribe(BaseEventKeys.Evaluate.EVALUATE_SUBMIT_SUCCESS, this.f13961i);
        unsubscribe(BaseEventKeys.Template.EVENT_BOTTOM_SHEET_HIDE, this.f13961i);
        unsubscribe(BaseEventKeys.Trip.EVENT_GLOBAL_NO_PSD_PROCESSING_SHOWING, this.f13961i);
        unsubscribe(BaseEventKeys.Trip.EVENT_GLOBAL_NO_PSD_PROCESSING_SHOWING_FROM_XPANEL, this.f13961i);
        unsubscribe(BaseEventKeys.Trip.EVENT_GLOBAL_NO_PSD_PROCESSING_HIDE, this.f13961i);
        unsubscribe(BaseEventKeys.NewXpanel.EVENT_XPANEL_HEIGHT_CHANGED_4_PAY_XPANEL_READY, this.f13961i);
    }

    /* access modifiers changed from: protected */
    public void forward(int i, Bundle bundle) {
        int i2 = this.f13955c;
        if (i2 > 0) {
            bundle.putInt(BaseExtras.Common.EXTRA_CURRENT_BID, i2);
            bundle.putInt(BaseExtras.Common.EXTRA_CURRENT_COMBOTYPE, this.f13956d);
        }
        super.forward(i, bundle);
    }

    /* access modifiers changed from: protected */
    public void forward(Class<? extends Fragment> cls, Bundle bundle, Animations animations) {
        Bundle bundle2 = this.mComponentProxy.getBundle();
        if (bundle2 != null) {
            bundle.putAll(bundle2);
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putAll(bundle2);
        }
        LogUtils.m31493i(this.f13953a + ".forward", "bundle = " + bundle2 + ", currentFragment = " + this.mView + ", to clazz = " + cls);
        super.forward(cls, bundle, animations);
    }

    public void onBackViewClicked() {
        if (!dispatchBackPressed(IPresenter.BackType.TopLeft)) {
            goBack();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m9681b() {
        if (this.f13957e && this.f13958f) {
            ((ICommonTemplateView) this.mView).hidePayProcessLoading();
            this.f13958f = false;
            this.f13957e = false;
        }
    }
}
