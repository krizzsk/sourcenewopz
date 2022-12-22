package com.didi.component.comp_xpanel;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.util.BusinessUtils;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.GlobalApolloUtil;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.NationComponentDataUtil;
import com.didi.component.business.web.GlobalWebUrl;
import com.didi.component.business.xpanel.sdk.IGlobalXPanelAdapter;
import com.didi.component.business.xpanel.sdk.IGlobalXPanelControllerInflater;
import com.didi.component.business.xpanel.sdk.IGlobalXPanelOmega;
import com.didi.component.business.xpanel.sdk.component.SelfControlComponent;
import com.didi.component.business.xpanel.sdk.controllers.IXPanelAgentController;
import com.didi.component.business.xpanel.sdk.controllers.IXPanelBaseController;
import com.didi.component.business.xpanel.sdk.controllers.IXPanelServiceCardController;
import com.didi.component.common.GlobalWebActivity;
import com.didi.component.common.animator.IGlobalXPanelAnimator;
import com.didi.component.common.base.BaseExpressPresenter;
import com.didi.component.common.base.ComponentType;
import com.didi.component.common.util.GLog;
import com.didi.component.comp_xpanel.AbsGlobalXPanelView;
import com.didi.component.comp_xpanel.model.CardProperties;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.IComponent;
import com.didi.component.core.IPresenter;
import com.didi.component.core.IViewContainer;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.drouter.api.DRouter;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.app.DIDIBaseApplication;
import com.didi.sdk.misconfig.model.CountryInfo;
import com.didi.sdk.push.ServerParam;
import com.didi.sdk.util.CommonParamsUtil;
import com.didi.sdk.view.LazyInflateView;
import com.didi.sdk.view.OnInflateListener;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didichuxing.xpanel.agent.AgentRequestCallBack;
import com.didichuxing.xpanel.agent.IXPanelAgentClickListener;
import com.didichuxing.xpanel.agent.IXPanelAgentListener;
import com.didichuxing.xpanel.agent.net.BaseObject;
import com.didichuxing.xpanel.base.CommonXPanelChildView;
import com.didichuxing.xpanel.base.IStateChangeListener;
import com.didichuxing.xpanel.base.XPanelCardData;
import com.didichuxing.xpanel.channel.global.GlobalXPanel;
import com.didichuxing.xpanel.channel.global.impl.IXPanelCallBack;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public abstract class AbsGlobalXPanelPresenter<T extends AbsGlobalXPanelView> extends BaseExpressPresenter<T> implements IGlobalXPanelAnimator.VisibilityChangedListener, IViewContainer, IXPanelAgentClickListener, IXPanelAgentListener, IXPanelCallBack {

    /* renamed from: a */
    private final String f12522a = getClass().getSimpleName();

    /* renamed from: b */
    private boolean f12523b = false;

    /* renamed from: c */
    private List<CardProperties> f12524c = new LinkedList();

    /* renamed from: d */
    private List<XPanelCardData> f12525d = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: e */
    public GlobalXPanel f12526e;

    /* renamed from: f */
    private IViewContainer.IComponentCreator f12527f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public int f12528g = 0;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f12529h = false;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public String f12530i = "";
    protected BusinessContext mBizCtx;
    protected BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> mMisEventListener = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            CountryInfo countryInfo = BusinessUtils.getCountryInfo(AbsGlobalXPanelPresenter.this.mBizCtx);
            if (countryInfo != null && !TextUtils.equals(AbsGlobalXPanelPresenter.this.f12530i, countryInfo.getCountryIsoCode())) {
                String unused = AbsGlobalXPanelPresenter.this.f12530i = countryInfo.getCountryIsoCode();
                if (AbsGlobalXPanelPresenter.this.f12526e != null) {
                    AbsGlobalXPanelPresenter.this.f12526e.setCountryCode(countryInfo.getCountryIsoCode());
                    AbsGlobalXPanelPresenter.this.refreshAgentData();
                }
            }
        }
    };
    protected BaseEventPublisher.OnEventListener mRefreshDataListener = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (str.equals(BaseEventKeys.XPanel.EVENT_REFRESH_XPANEL_DATA)) {
                AbsGlobalXPanelPresenter.this.refreshAgentData();
            }
        }
    };
    protected BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> mRequestDefaultHeight = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (str.equals(BaseEventKeys.XPanel.EVENT_REQUEST_FETCH_DEFAULT_HEIGHT)) {
                AbsGlobalXPanelPresenter.this.doPublish(BaseEventKeys.XPanel.EVENT_HEIGHT_CHANGED, new Integer(AbsGlobalXPanelPresenter.this.mXPanelDefaultDisplayHeight));
            }
        }
    };
    protected BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> mRequestDefaultScrollHeight = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (str.equals(BaseEventKeys.XPanel.EVENT_REQUEST_FETCH_DEFAULT_SCROLL_HEIGHT)) {
                AbsGlobalXPanelPresenter.this.doPublish(BaseEventKeys.XPanel.EVENT_HEIGHT_CHANGED_SCROLL_LISTENER, new Integer(AbsGlobalXPanelPresenter.this.f12528g));
            }
        }
    };
    protected BaseEventPublisher.OnEventListener mRequestHideEventListener = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (str.equals(BaseEventKeys.XPanel.EVENT_REQUEST_HIDE)) {
                ((AbsGlobalXPanelView) AbsGlobalXPanelPresenter.this.mView).hide();
            }
        }
    };
    protected BaseEventPublisher.OnEventListener mRequestShowEventListener = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (str.equals(BaseEventKeys.XPanel.EVENT_REQUEST_SHOW)) {
                ((AbsGlobalXPanelView) AbsGlobalXPanelPresenter.this.mView).show();
            }
        }
    };
    protected int mXPanelDefaultDisplayHeight = 0;

    public void doXPanelDrag(boolean z) {
    }

    public void doXPanelPullStateChange(boolean z) {
    }

    /* access modifiers changed from: protected */
    public abstract String[] getDefaultCards();

    public String getDimension() {
        return "";
    }

    public String getRequestTag() {
        return "";
    }

    public void loadError(BaseObject baseObject) {
    }

    public void onShownStart() {
    }

    public void toShow(List<XPanelCardData> list) {
    }

    public AbsGlobalXPanelPresenter(ComponentParams componentParams) {
        super(componentParams);
        this.mBizCtx = componentParams.bizCtx;
    }

    public final void bind(Context context, GlobalXPanel globalXPanel) {
        CountryInfo countryInfo = BusinessUtils.getCountryInfo(this.mBizCtx);
        if (countryInfo != null) {
            this.f12530i = countryInfo.getCountryIsoCode();
        }
        this.f12526e = globalXPanel;
        globalXPanel.setCountryCode(this.f12530i);
        this.f12526e.setXPanelAgentListener(this);
        ((AbsGlobalXPanelView) this.mView).getXPanel().setXPanelCallBack(this);
        ((AbsGlobalXPanelView) this.mView).getXPanel().addStateChangeListener(new IStateChangeListener() {
            public void onStateChanged(int i) {
                GLog.m7965d("zl-xpanel", "event_touch_scroll_state = " + i);
                AbsGlobalXPanelPresenter.this.doPublish(BaseEventKeys.XPanel.EVENT_TOUCH_SCROLL_STATE, new Integer(i));
            }
        });
        ((AbsGlobalXPanelView) this.mView).setVisibilityChangedListener(this);
        this.f12526e.bindAgentClickListener(this);
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        GLog.m7971i(this.f12522a, "onAdd");
        subscribe(BaseEventKeys.XPanel.EVENT_REQUEST_SHOW, this.mRequestShowEventListener);
        subscribe(BaseEventKeys.XPanel.EVENT_REQUEST_HIDE, this.mRequestHideEventListener);
        subscribe(BaseEventKeys.Common.KEY_MIS_CHANGED_FROM_NET, this.mMisEventListener);
        subscribe(BaseEventKeys.XPanel.EVENT_REQUEST_FETCH_DEFAULT_HEIGHT, this.mRequestDefaultHeight);
        subscribe(BaseEventKeys.XPanel.EVENT_REQUEST_FETCH_DEFAULT_SCROLL_HEIGHT, this.mRequestDefaultScrollHeight);
        subscribe(BaseEventKeys.XPanel.EVENT_REFRESH_XPANEL_DATA, this.mRefreshDataListener);
        this.f12523b = false;
        GlobalXPanel globalXPanel = this.f12526e;
        if (globalXPanel != null) {
            globalXPanel.onCreate();
        }
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        GLog.m7971i(this.f12522a, "onRemove");
        unsubscribe(BaseEventKeys.XPanel.EVENT_REQUEST_SHOW, this.mRequestShowEventListener);
        unsubscribe(BaseEventKeys.XPanel.EVENT_REQUEST_HIDE, this.mRequestHideEventListener);
        unsubscribe(BaseEventKeys.Common.KEY_MIS_CHANGED_FROM_NET, this.mMisEventListener);
        unsubscribe(BaseEventKeys.XPanel.EVENT_REQUEST_FETCH_DEFAULT_HEIGHT, this.mRequestDefaultHeight);
        unsubscribe(BaseEventKeys.XPanel.EVENT_REQUEST_FETCH_DEFAULT_SCROLL_HEIGHT, this.mRequestDefaultScrollHeight);
        unsubscribe(BaseEventKeys.XPanel.EVENT_REFRESH_XPANEL_DATA, this.mRefreshDataListener);
        GlobalXPanel globalXPanel = this.f12526e;
        if (globalXPanel != null) {
            globalXPanel.destroy();
        }
        this.f12523b = true;
    }

    public boolean isRemoved() {
        return this.f12523b;
    }

    public final IComponent inflateComponent(String str, boolean z) {
        return inflateComponent(str, z, (Bundle) null);
    }

    public final IComponent inflateComponent(String str, boolean z, Bundle bundle) {
        return inflateComponent(str, -1, z, bundle);
    }

    public final IComponent inflateComponent(String str, int i, boolean z, Bundle bundle) {
        return inflateComponent(str, i, z, true, bundle);
    }

    public final IComponent inflateComponent(String str, int i, boolean z, boolean z2, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        boolean z3 = true;
        bundle.putBoolean(SelfControlComponent.BUNDLE_KEY_FROM_XPANEL, true);
        IComponent newComponent = this.f12527f.newComponent(convertToComponentId(str), (ViewGroup) ((AbsGlobalXPanelView) this.mView).getView(), bundle);
        if (newComponent == null || newComponent.getView() == null) {
            return null;
        }
        if (newComponent instanceof SelfControlComponent) {
            z3 = ((SelfControlComponent) newComponent).mIsDefaultVisible;
        }
        View view = newComponent.getView().getView();
        final CardProperties cardProperties = new CardProperties();
        cardProperties.mType = str;
        cardProperties.mComponent = newComponent;
        cardProperties.isServiceCard = z;
        if (!z) {
            i = this.f12524c.size();
        } else if (i < 0 || i > this.f12524c.size()) {
            i = this.f12524c.size();
        }
        cardProperties.mView = view;
        cardProperties.mId = getComponentIdByType(str);
        cardProperties.mController = m8503a(str, z);
        cardProperties.mXPanelData = new XPanelCardData.Builder().mo121493id(cardProperties.mId).view(view, z2).build();
        cardProperties.mXPanelData.isMain = cardProperties.isServiceCard;
        cardProperties.isVisible = z3;
        final IPresenter presenter = newComponent.getPresenter();
        if (presenter instanceof IGlobalXPanelAdapter) {
            cardProperties.mAdapter = (IGlobalXPanelAdapter) presenter;
        }
        if (presenter instanceof IGlobalXPanelOmega) {
            cardProperties.mXPanelData.iOmegaMap = new XPanelCardData.IOmegaMap() {
                public Map<String, Object> createCustomMap() {
                    return ((IGlobalXPanelOmega) presenter).getCustomOmegaParams();
                }
            };
        }
        this.f12524c.add(i, cardProperties);
        if (presenter instanceof IGlobalXPanelControllerInflater) {
            ((IGlobalXPanelControllerInflater) presenter).inflateController(cardProperties.mController);
        }
        if (newComponent.getView() instanceof LazyInflateView) {
            ((LazyInflateView) newComponent.getView()).setOnInflateListener(new OnInflateListener() {
                public void onInflate(View view) {
                    cardProperties.mView = view;
                }
            });
        }
        return newComponent;
    }

    /* access modifiers changed from: protected */
    public final void loadDefaultCards(Bundle bundle) {
        String[] defaultCards = getDefaultCards();
        if (defaultCards == null || defaultCards.length == 0) {
            GLog.m7968e(this.f12522a, "No card was defined in local.");
            return;
        }
        for (String str : defaultCards) {
            if (!TextUtils.isEmpty(str)) {
                GLog.m7971i(this.f12522a, "start load service card--------" + str);
                inflateComponent(str, -1, true, bundle);
            }
        }
    }

    /* access modifiers changed from: protected */
    public String convertToComponentId(String str) {
        return "new_driver_bar".equals(str) ? ComponentType.DRIVER_BAR : str;
    }

    public final void addViewByHand(String str, String str2, View view) {
        CardProperties cardProperties = new CardProperties();
        cardProperties.mType = str;
        cardProperties.mView = view;
        cardProperties.mId = str2;
        cardProperties.isServiceCard = true;
        cardProperties.mController = m8503a(str, true);
        cardProperties.mXPanelData = new XPanelCardData.Builder().mo121493id(cardProperties.mId).view(view).build();
        cardProperties.mXPanelData.isMain = cardProperties.isServiceCard;
        this.f12524c.add(cardProperties);
    }

    /* renamed from: a */
    private IXPanelBaseController m8503a(final String str, boolean z) {
        return z ? new IXPanelServiceCardController() {
            public void setVisibilityChanged(boolean z) {
                AbsGlobalXPanelPresenter.this.setVisibilityByType(str, z);
                AbsGlobalXPanelPresenter.this.commit();
            }

            public void removeSelfComponent() {
                AbsGlobalXPanelPresenter.this.removeComponentByType(str);
                AbsGlobalXPanelPresenter.this.commit();
            }
        } : new IXPanelAgentController() {
            public void reloadAgentData() {
                AbsGlobalXPanelPresenter.this.refreshAgentData();
            }

            public void removeSelfComponent() {
                AbsGlobalXPanelPresenter.this.removeComponentByType(str);
                AbsGlobalXPanelPresenter.this.commit();
            }
        };
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0042 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getComponentIdByType(java.lang.String r5) {
        /*
            r4 = this;
            int r0 = r5.hashCode()
            r1 = 186798071(0xb224ff7, float:3.1260224E-32)
            r2 = 2
            r3 = 1
            if (r0 == r1) goto L_0x002a
            r1 = 758062106(0x2d2f1c1a, float:9.953838E-12)
            if (r0 == r1) goto L_0x0020
            r1 = 1815646716(0x6c3891fc, float:8.92527E26)
            if (r0 == r1) goto L_0x0016
            goto L_0x0034
        L_0x0016:
            java.lang.String r0 = "service_control_card"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0034
            r0 = 2
            goto L_0x0035
        L_0x0020:
            java.lang.String r0 = "unfinished_order"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0034
            r0 = 0
            goto L_0x0035
        L_0x002a:
            java.lang.String r0 = "unfinished_delivery_order"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0034
            r0 = 1
            goto L_0x0035
        L_0x0034:
            r0 = -1
        L_0x0035:
            if (r0 == 0) goto L_0x0042
            if (r0 == r3) goto L_0x003f
            if (r0 == r2) goto L_0x003c
            return r5
        L_0x003c:
            java.lang.String r5 = "cash_unpay_entrance"
            return r5
        L_0x003f:
            java.lang.String r5 = "xpcard_delivery_running_order"
            return r5
        L_0x0042:
            java.lang.String r5 = "xpcard_global_running_order"
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.comp_xpanel.AbsGlobalXPanelPresenter.getComponentIdByType(java.lang.String):java.lang.String");
    }

    public final void setVisibilityByType(String str, boolean z) {
        CardProperties propertiesByType = getPropertiesByType(str);
        if (propertiesByType != null) {
            propertiesByType.isVisible = z;
        }
    }

    public final void hideAgentCardView(String str) {
        CardProperties propertiesByType;
        if (!TextUtils.isEmpty(str) && (propertiesByType = getPropertiesByType(str)) != null && (propertiesByType.mAdapter instanceof IGlobalXPanelAdapter)) {
            this.f12526e.removeAgentCard(propertiesByType.mXPanelData);
        }
    }

    public final boolean isVisibileByType(String str) {
        CardProperties propertiesByType = getPropertiesByType(str);
        if (propertiesByType != null) {
            return propertiesByType.isVisible;
        }
        return false;
    }

    public final void setComponentExposedCallback(String str, XPanelCardData.ICardShow iCardShow) {
        CardProperties propertiesByType = getPropertiesByType(str);
        if (propertiesByType != null) {
            propertiesByType.mCardShowCallback = iCardShow;
        }
    }

    public final boolean removeComponentByType(String str) {
        CardProperties propertiesByType = getPropertiesByType(str);
        if (propertiesByType == null) {
            return false;
        }
        this.f12524c.remove(propertiesByType);
        IViewContainer.IComponentCreator iComponentCreator = this.f12527f;
        if (iComponentCreator == null) {
            return true;
        }
        iComponentCreator.removeComponent(propertiesByType.mComponent);
        return true;
    }

    public final void commit() {
        this.f12525d.clear();
        for (CardProperties next : this.f12524c) {
            if (next.isServiceCard && next.isVisible) {
                this.f12525d.add(next.mXPanelData);
            }
        }
        this.f12526e.notifyServiceCards(this.f12525d);
    }

    public final void refreshAgentData(AgentRequestCallBack agentRequestCallBack) {
        this.f12526e.reloadAgent(true, GlobalApolloUtil.isXPanelUseBff() ? getRequestTag() : getDimension(), getRequestParams(), true, agentRequestCallBack);
    }

    public void loadAgentData() {
        GLog.m7970i("xpanel loadAgentData true");
        this.f12526e.reloadAgent(GlobalApolloUtil.isXPanelUseBff() ? getRequestTag() : getDimension(), getRequestParams(), true);
    }

    public void refreshAgentData() {
        GLog.m7970i("xpanel loadAgentData false");
        this.f12526e.reloadAgent(GlobalApolloUtil.isXPanelUseBff() ? getRequestTag() : getDimension(), getRequestParams(), false);
    }

    public void refreshAgentDataOnPageResume() {
        this.f12526e.reloadAgent(true, GlobalApolloUtil.isXPanelUseBff() ? getRequestTag() : getDimension(), getRequestParams(), true, (AgentRequestCallBack) null);
    }

    public final void setComponentCreator(IViewContainer.IComponentCreator iComponentCreator) {
        this.f12527f = iComponentCreator;
    }

    /* access modifiers changed from: protected */
    public void onPagePause() {
        super.onPagePause();
        GLog.m7971i(this.f12522a, "onPagePause");
        GlobalXPanel globalXPanel = this.f12526e;
        if (globalXPanel != null) {
            globalXPanel.onPause();
        }
    }

    /* access modifiers changed from: protected */
    public void onPageResume() {
        super.onPageResume();
        GLog.m7971i(this.f12522a, "onPageResume");
        GlobalXPanel globalXPanel = this.f12526e;
        if (globalXPanel != null) {
            globalXPanel.onResume();
        }
    }

    public final XPanelCardData getViewById(String str, String str2, JSONObject jSONObject, JSONObject jSONObject2) {
        View customViewWithData;
        CardProperties propertiesById = getPropertiesById(str);
        if (propertiesById == null) {
            inflateComponent(str2, false);
        }
        if (propertiesById == null || propertiesById.mAdapter == null || (customViewWithData = propertiesById.mAdapter.getCustomViewWithData(jSONObject, jSONObject2)) == null) {
            return null;
        }
        propertiesById.mView = customViewWithData;
        if (propertiesById.mXPanelData.content == null) {
            propertiesById.mXPanelData.content = new CommonXPanelChildView(customViewWithData);
        }
        propertiesById.mXPanelData.mTemplate = str2;
        propertiesById.mXPanelData.f49329id = str;
        return propertiesById.mXPanelData;
    }

    public final HashMap<String, Object> getRequestParams() {
        String str;
        HashMap<String, Object> hashMap = new HashMap<>();
        if (GlobalApolloUtil.isXPanelUseBff()) {
            hashMap.put("business_scene", getRequestTag());
            CarOrder order = CarOrderHelper.getOrder();
            if (order == null) {
                str = "";
            } else {
                str = order.getOid();
            }
            hashMap.put("oid", str);
        }
        CommonParamsUtil.addCommonParam(hashMap, DIDIBaseApplication.getAppContext());
        hashMap.put("dimensions", getDimension());
        hashMap.put("uid", Long.valueOf(NationComponentDataUtil.getUid()));
        return hashMap;
    }

    public CardProperties getPropertiesById(String str) {
        for (CardProperties next : this.f12524c) {
            if (next.mId.equalsIgnoreCase(str)) {
                return next;
            }
        }
        return null;
    }

    public CardProperties getPropertiesByType(String str) {
        for (CardProperties next : this.f12524c) {
            if (next.mType.equalsIgnoreCase(str)) {
                return next;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public int getCardIndex(CardProperties cardProperties) {
        return this.f12524c.indexOf(cardProperties);
    }

    public void doXPanelShowHeightChange(int i) {
        GLog.m7971i("XPanel_Height_change", i + "");
        this.mXPanelDefaultDisplayHeight = i;
        if (((AbsGlobalXPanelView) this.mView).isShown()) {
            doPublish(BaseEventKeys.XPanel.EVENT_HEIGHT_CHANGED, new Integer(i));
            this.f12529h = true;
        }
    }

    public void doXPanelScrollStatusChange(int i) {
        GLog.m7971i("doXPanelScrollStatusChange", "newStatus=" + i);
        doPublish(BaseEventKeys.XPanel.EVENT_XPANEL_SCROLL_STATE, Integer.valueOf(i));
    }

    /* access modifiers changed from: protected */
    public void onBackHome(Bundle bundle) {
        super.onBackHome(bundle);
        GlobalXPanel globalXPanel = this.f12526e;
        if (globalXPanel != null) {
            globalXPanel.onBackHome();
        }
        ((AbsGlobalXPanelView) this.mView).getView().post(new Runnable() {
            public void run() {
                if (AbsGlobalXPanelPresenter.this.mXPanelDefaultDisplayHeight > 0 && ((AbsGlobalXPanelView) AbsGlobalXPanelPresenter.this.mView).isShown()) {
                    AbsGlobalXPanelPresenter.this.doPublish(BaseEventKeys.XPanel.EVENT_HEIGHT_CHANGED, new Integer(AbsGlobalXPanelPresenter.this.mXPanelDefaultDisplayHeight));
                    boolean unused = AbsGlobalXPanelPresenter.this.f12529h = true;
                }
                if (AbsGlobalXPanelPresenter.this.f12528g > 0 && ((AbsGlobalXPanelView) AbsGlobalXPanelPresenter.this.mView).isShown() && AbsGlobalXPanelPresenter.this.f12529h) {
                    AbsGlobalXPanelPresenter.this.doPublish(BaseEventKeys.XPanel.EVENT_HEIGHT_CHANGED_SCROLL_LISTENER, new Integer(AbsGlobalXPanelPresenter.this.f12528g));
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onLeaveHome() {
        super.onLeaveHome();
        GlobalXPanel globalXPanel = this.f12526e;
        if (globalXPanel != null) {
            globalXPanel.onLeaveHome();
        }
    }

    public void doXPanelMoveChange(int i) {
        GLog.m7971i("XPanel_Height_change", "doXPanelMoveChange>>>>" + i + " cls = " + getClass().getSimpleName());
        if (this.f12529h && ((AbsGlobalXPanelView) this.mView).isShown() && this.f12528g != i) {
            this.f12528g = i;
            doPublish(BaseEventKeys.XPanel.EVENT_HEIGHT_CHANGED_SCROLL_LISTENER, new Integer(i));
        }
    }

    public void onHiddenStart() {
        doPublish(BaseEventKeys.XPanel.EVENT_HEIGHT_CHANGED, new Integer(0));
        this.f12529h = true;
        this.f12528g = 0;
    }

    public void onShown() {
        doPublish(BaseEventKeys.XPanel.EVENT_HEIGHT_CHANGED, new Integer(this.mXPanelDefaultDisplayHeight));
        this.f12529h = true;
    }

    public void onHidden() {
        ((AbsGlobalXPanelView) this.mView).hideLoading();
    }

    /* access modifiers changed from: protected */
    public final boolean isEmpty() {
        return this.f12525d.isEmpty();
    }

    public void clickUri(String str, XPanelCardData xPanelCardData) {
        if (!TextUtils.isEmpty(str)) {
            GLog.m7964d("@clickUri, url=" + str);
            DRouter.build(str).start(this.mContext);
        }
    }

    public boolean dispatchClickUri(String str, XPanelCardData xPanelCardData, String str2) {
        if (xPanelCardData == null || !"xpcard_global_mission_combo".equals(xPanelCardData.f49329id) || !"button_0".equals(str2)) {
            return false;
        }
        CountryInfo countryInfo = BusinessUtils.getCountryInfo(this.mBizCtx);
        if (countryInfo != null) {
            str = Uri.parse(str).buildUpon().appendQueryParameter(ServerParam.PARAM_TRIPCOUNTRY, countryInfo.getCountryIsoCode()).build().toString();
        }
        Intent intent = new Intent(this.mContext, GlobalWebActivity.class);
        intent.putExtra("web_view_model", GlobalWebUrl.buildWebViewModel(str));
        startActivity(intent);
        ((Activity) this.mContext).overridePendingTransition(R.anim.side_right_in, R.anim.anim_none);
        GlobalOmegaUtils.trackEvent("gp_xpanel_dxgydetail_ck");
        return true;
    }

    public void doXPanelContentChange() {
        doPublish(BaseEventKeys.Location.EVENT_BEST_VIEW);
    }

    public IGlobalXPanelView getComponentView() {
        return (IGlobalXPanelView) this.mView;
    }

    public boolean hasCardInXpanel() {
        if (this.f12524c.size() > 0) {
            return true;
        }
        GlobalXPanel globalXPanel = this.f12526e;
        if (globalXPanel == null) {
            return false;
        }
        return !globalXPanel.isListEmpty();
    }

    /* access modifiers changed from: protected */
    public boolean shouldLoadTravelDetailComponent() {
        return CarOrderHelper.isUseNewCard() && CarOrderHelper.getOrder() != null && !CarOrderHelper.isCarPoolLineHaveOrder();
    }
}
