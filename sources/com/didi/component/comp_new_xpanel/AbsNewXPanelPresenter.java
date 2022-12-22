package com.didi.component.comp_new_xpanel;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.constant.BaseExtras;
import com.didi.component.business.model.XpTrackItem;
import com.didi.component.business.model.XpanelTrackModel;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.xengine.XERequestKey;
import com.didi.component.business.xengine.XEngineReq;
import com.didi.component.business.xengine.model.XpTemplateMsgModel;
import com.didi.component.business.xengine.request.XEParams;
import com.didi.component.business.xengine.request.XESimpleReqParams;
import com.didi.component.business.xpanelnew.IXpCardBindDataReady;
import com.didi.component.business.xpanelnew.IXpCardBindDataReadyCallback;
import com.didi.component.business.xpanelnew.IXpCardLifeCycle;
import com.didi.component.business.xpanelnew.IXpCompRefresh;
import com.didi.component.business.xpanelnew.XpNewAdapter;
import com.didi.component.business.xpanelnew.XpNewHeightChangeModel;
import com.didi.component.common.util.GLog;
import com.didi.component.comp_new_xpanel.inner.XpBizCardProperty;
import com.didi.component.comp_new_xpanel.template.XpTemplateAdCardModel;
import com.didi.component.comp_new_xpanel.template.XpTemplateAdCardView;
import com.didi.component.comp_new_xpanel.template.XpTemplateBizModel;
import com.didi.component.comp_new_xpanel.template.XpTemplateBizView;
import com.didi.component.comp_new_xpanel.template.XpTemplateMsgView;
import com.didi.component.comp_new_xpanel.template.XpTemplateOperationModel;
import com.didi.component.comp_new_xpanel.template.XpTemplateOperationView;
import com.didi.component.comp_new_xpanel.view.XpanelLoadingView;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.IComponent;
import com.didi.component.core.IPresenter;
import com.didi.component.core.IViewContainer;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.global.globaluikit.utils.UIThreadHandler;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.paxadsdk.GlobalAdManager;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didi.xengine.callback.XEReqJSONParamsCallbackImpl;
import com.didi.xengine.register.XERegister;
import com.didiglobal.enginecore.callback.XEResponseCallback;
import com.didiglobal.enginecore.component.XEComponent;
import com.didiglobal.enginecore.data.exception.EngineErrorException;
import com.didiglobal.enginecore.data.model.XEngineData;
import com.didiglobal.enginecore.data.parser.XEParseConst;
import com.didiglobal.enginecore.register.XERegisterModel;
import com.didiglobal.enginecore.template.nat.NativeComponent;
import com.didiglobal.enginecore.template.temp.TemplateComponent;
import com.didiglobal.enginecore.template.temp.XETemplateComponent;
import com.didiglobal.enginecore.template.xml.XMLComponent;
import com.didiglobal.xpanelnew.base.XpCardProperty;
import com.didiglobal.xpanelnew.base.XpConfig;
import com.didiglobal.xpanelnew.base.XpOmegaConfig;
import com.didiglobal.xpanelnew.callback.IXpCallback;
import com.didiglobal.xpanelnew.message.XpMessageItem;
import com.didiglobal.xpanelnew.omega.XPanelOmegaCallback;
import com.didiglobal.xpanelnew.omega.XpCardTrackProperty;
import com.didiglobal.xpanelnew.sdk.XpanelNew;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.internal.LinkedTreeMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public abstract class AbsNewXPanelPresenter extends IPresenter<AbsNewXPanelView> implements IViewContainer {

    /* renamed from: a */
    private static final int f12260a = 1000;

    /* renamed from: b */
    private static final int f12261b = 1;

    /* renamed from: c */
    private static final int f12262c = 0;
    public static Map<String, View> cachedAdViews = new HashMap();
    public static boolean entered = false;

    /* renamed from: A */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f12263A = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (!AbsNewXPanelPresenter.this.f12277f) {
                AbsNewXPanelPresenter.this.f12278g.refreshMsgHeight();
            }
        }
    };

    /* renamed from: B */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f12264B = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            AbsNewXPanelPresenter.this.f12278g.setShowOneCard();
        }
    };

    /* renamed from: C */
    private final XPanelOmegaCallback f12265C = new XPanelOmegaCallback() {
        public void onItemShowingWhenScrollStopped(List<XpCardTrackProperty> list) {
            XpanelTrackModel xpanelTrackModel = new XpanelTrackModel();
            xpanelTrackModel.list = new ArrayList();
            for (XpCardTrackProperty a : list) {
                xpanelTrackModel.list.add(AbsNewXPanelPresenter.this.m8302a(a));
            }
            AbsNewXPanelPresenter.this.doPublish(BaseEventKeys.NewXpanel.EVENT_XPANEL_NEW_OMEGA_TRACK_CALLBACK, xpanelTrackModel);
        }
    };

    /* renamed from: D */
    private HashMap<String, LinkedTreeMap<String, Object>> f12266D = new HashMap<>();

    /* renamed from: E */
    private BaseEventPublisher.OnEventListener<Integer> f12267E = new BaseEventPublisher.OnEventListener<Integer>() {
        public void onEvent(String str, Integer num) {
            XpConfig build = new XpConfig.Builder().setDefaultDpSecondCardShowHeight((float) num.intValue()).build();
            float unused = AbsNewXPanelPresenter.this.f12292v = (float) num.intValue();
            AbsNewXPanelPresenter.this.f12278g.setConfig(build);
        }
    };

    /* renamed from: F */
    private XEReqJSONParamsCallbackImpl f12268F = new XEReqJSONParamsCallbackImpl() {
        public JSONObject getRequestParams() {
            CarOrder order;
            int lastOrderStatus = XEParams.getInstance().getLastOrderStatus();
            int lastOrderSubStatus = XEParams.getInstance().getLastOrderSubStatus();
            if ((lastOrderStatus == 0 || lastOrderSubStatus == 0) && (order = CarOrderHelper.getOrder()) != null) {
                lastOrderStatus = order.status;
                lastOrderSubStatus = order.substatus;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("status", Integer.valueOf(lastOrderStatus));
            hashMap.put(ParamKeys.PARAM_SUB_STATUS, Integer.valueOf(lastOrderSubStatus));
            return new JSONObject(hashMap);
        }
    };

    /* renamed from: G */
    private BaseEventPublisher.OnEventListener<XpTemplateMsgModel> f12269G = new BaseEventPublisher.OnEventListener<XpTemplateMsgModel>() {
        public void onEvent(String str, XpTemplateMsgModel xpTemplateMsgModel) {
            if (BaseEventKeys.NewXpanel.EVENT_XPANEL_NEW_ADD_COMMON_MSG.equals(str) && xpTemplateMsgModel != null) {
                if (AbsNewXPanelPresenter.this.f12281j == null) {
                    XpTemplateMsgView unused = AbsNewXPanelPresenter.this.f12281j = new XpTemplateMsgView();
                    AbsNewXPanelPresenter.this.f12281j.initView(AbsNewXPanelPresenter.this.mContext);
                    AbsNewXPanelPresenter.this.f12281j.bindData(xpTemplateMsgModel);
                    AbsNewXPanelPresenter.this.f12281j.setPageId(AbsNewXPanelPresenter.this.componentParams.pageID);
                    AbsNewXPanelPresenter.this.f12278g.getMessageContainer().addMessageItem(new XpMessageItem(AbsNewXPanelPresenter.this.f12281j.getView()));
                } else {
                    AbsNewXPanelPresenter.this.f12281j.bindData(xpTemplateMsgModel);
                    AbsNewXPanelPresenter.this.f12281j.setPageId(AbsNewXPanelPresenter.this.componentParams.pageID);
                }
                if (xpTemplateMsgModel.normal != null && xpTemplateMsgModel.normal.data != null && xpTemplateMsgModel.normal.data.title != null) {
                    AbsNewXPanelPresenter.this.f12278g.setTitle(xpTemplateMsgModel.normal.data.title.getContent());
                }
            }
        }
    };

    /* renamed from: H */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f12270H = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (AbsNewXPanelPresenter.this.f12281j != null) {
                AbsNewXPanelPresenter.this.f12281j.bindData((XpTemplateMsgModel) null);
            }
        }
    };

    /* renamed from: I */
    private BaseEventPublisher.OnEventListener<String> f12271I = new BaseEventPublisher.OnEventListener<String>() {
        public void onEvent(String str, String str2) {
            if (BaseEventKeys.NewXpanel.EVENT_XPANEL_UPDATE_TITLE.equals(str)) {
                AbsNewXPanelPresenter.this.f12278g.setTitle(str2);
            }
        }
    };

    /* renamed from: J */
    private XEResponseCallback f12272J = new XEResponseCallback() {
        public void onFailed(String str, EngineErrorException engineErrorException) {
        }

        public void onSuccess(String str, XEngineData xEngineData, List<XEComponent> list) {
            JsonObject asJsonObject;
            if (list != null && list.size() != 0) {
                JsonObject jsonObject = xEngineData.jsonObject;
                if (jsonObject != null) {
                    JsonArray asJsonArray = jsonObject.getAsJsonArray("list");
                    if (asJsonArray != null && asJsonArray.size() > 0) {
                        GLog.m7970i("NewXpanelBiz: 后端下发卡片个数 = " + asJsonArray.size());
                    }
                    AbsNewXPanelPresenter.this.m8313a(asJsonArray);
                }
                if (jsonObject == null || (asJsonObject = jsonObject.getAsJsonObject(XEParseConst.COMPONENT_ATTRIBUTE)) == null || asJsonObject.get(XEParseConst.UPDATE_MODE).getAsInt() != 1) {
                    if (jsonObject != null) {
                        JsonObject asJsonObject2 = jsonObject.getAsJsonObject(XEParseConst.XE_JSON_KEY_UI_CONFIG);
                        if (asJsonObject2 != null) {
                            int unused = AbsNewXPanelPresenter.this.f12288r = asJsonObject2.get("transition_type") == null ? 0 : asJsonObject2.get("transition_type").getAsInt();
                            if (AbsNewXPanelPresenter.this.f12288r > 0) {
                                AbsNewXPanelPresenter.this.doPublish(BaseEventKeys.NewXpanel.EVENT_XPANEL_NEW_TRANSITION_START, 1000);
                            }
                            int i = 70;
                            if (!(asJsonObject2.get("panel_state_height") == null || asJsonObject2.get("panel_state_height").getAsInt() == 0)) {
                                i = asJsonObject2.get("panel_state_height").getAsInt();
                            }
                            float f = (float) i;
                            XpConfig build = new XpConfig.Builder().setDefaultDpSecondCardShowHeight(f).build();
                            float unused2 = AbsNewXPanelPresenter.this.f12292v = f;
                            AbsNewXPanelPresenter.this.f12278g.setConfig(build);
                        } else {
                            XpConfig build2 = new XpConfig.Builder().setDefaultDpSecondCardShowHeight(70.0f).build();
                            float unused3 = AbsNewXPanelPresenter.this.f12292v = 70.0f;
                            AbsNewXPanelPresenter.this.f12278g.setConfig(build2);
                        }
                    } else {
                        XpConfig build3 = new XpConfig.Builder().setDefaultDpSecondCardShowHeight(70.0f).build();
                        float unused4 = AbsNewXPanelPresenter.this.f12292v = 70.0f;
                        AbsNewXPanelPresenter.this.f12278g.setConfig(build3);
                    }
                    AbsNewXPanelPresenter.this.m8326b(list);
                    if (AbsNewXPanelPresenter.this.f12290t != null) {
                        AbsNewXPanelPresenter.this.f12290t.hideLoading();
                        XpanelLoadingView unused5 = AbsNewXPanelPresenter.this.f12290t = null;
                        return;
                    }
                    return;
                }
                AbsNewXPanelPresenter.this.m8315a(list);
            }
        }
    };

    /* renamed from: K */
    private int f12273K = 0;

    /* renamed from: L */
    private BaseEventPublisher.OnEventListener<Integer> f12274L = new BaseEventPublisher.OnEventListener<Integer>() {
        /* JADX WARNING: Removed duplicated region for block: B:17:0x0038  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x0050  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onEvent(java.lang.String r6, java.lang.Integer r7) {
            /*
                r5 = this;
                int r0 = r6.hashCode()
                r1 = -1726623589(0xffffffff9915d09b, float:-7.745247E-24)
                r2 = 0
                r3 = 2
                r4 = 1
                if (r0 == r1) goto L_0x002b
                r1 = -348758759(0xffffffffeb365d19, float:-2.2046414E26)
                if (r0 == r1) goto L_0x0021
                r1 = -308741934(0xffffffffed98f8d2, float:-5.917816E27)
                if (r0 == r1) goto L_0x0017
                goto L_0x0035
            L_0x0017:
                java.lang.String r0 = "event_xpanel_height_changed_4_pay_up"
                boolean r6 = r6.equals(r0)
                if (r6 == 0) goto L_0x0035
                r6 = 1
                goto L_0x0036
            L_0x0021:
                java.lang.String r0 = "event_xpanel_height_changed_4_pay_down"
                boolean r6 = r6.equals(r0)
                if (r6 == 0) goto L_0x0035
                r6 = 0
                goto L_0x0036
            L_0x002b:
                java.lang.String r0 = "event_xpanel_height_changed_4_pay_visible"
                boolean r6 = r6.equals(r0)
                if (r6 == 0) goto L_0x0035
                r6 = 2
                goto L_0x0036
            L_0x0035:
                r6 = -1
            L_0x0036:
                if (r6 == 0) goto L_0x0050
                if (r6 == r4) goto L_0x004a
                if (r6 == r3) goto L_0x003d
                goto L_0x0059
            L_0x003d:
                com.didi.component.comp_new_xpanel.AbsNewXPanelPresenter r6 = com.didi.component.comp_new_xpanel.AbsNewXPanelPresenter.this
                int r7 = r7.intValue()
                if (r7 != r4) goto L_0x0046
                r2 = 1
            L_0x0046:
                r6.m8316a((boolean) r2)
                goto L_0x0059
            L_0x004a:
                com.didi.component.comp_new_xpanel.AbsNewXPanelPresenter r6 = com.didi.component.comp_new_xpanel.AbsNewXPanelPresenter.this
                r6.m8340g()
                goto L_0x0059
            L_0x0050:
                com.didi.component.comp_new_xpanel.AbsNewXPanelPresenter r6 = com.didi.component.comp_new_xpanel.AbsNewXPanelPresenter.this
                int r7 = r7.intValue()
                r6.m8323b((int) r7)
            L_0x0059:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.component.comp_new_xpanel.AbsNewXPanelPresenter.C505526.onEvent(java.lang.String, java.lang.Integer):void");
        }
    };
    protected ComponentParams componentParams;

    /* renamed from: d */
    private final String f12275d = getClass().getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f12276e = false;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f12277f = false;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public XpanelNew f12278g;

    /* renamed from: h */
    private boolean f12279h;

    /* renamed from: i */
    private IViewContainer.IComponentCreator f12280i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public XpTemplateMsgView f12281j;

    /* renamed from: k */
    private List<XpBizCardProperty> f12282k = new LinkedList();

    /* renamed from: l */
    private List<XpCardProperty> f12283l = new LinkedList();

    /* renamed from: m */
    private List<String> f12284m = new CopyOnWriteArrayList();
    protected BusinessContext mBizCtx;
    protected Logger mLogger = LoggerFactory.getLogger("NewXpanelLog");
    protected BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> mRequestDefaultHeight = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (str.equals(BaseEventKeys.XPanel.EVENT_REQUEST_FETCH_DEFAULT_HEIGHT)) {
                AbsNewXPanelPresenter absNewXPanelPresenter = AbsNewXPanelPresenter.this;
                absNewXPanelPresenter.doPublish(BaseEventKeys.XPanel.EVENT_HEIGHT_CHANGED_SCROLL_LISTENER, Integer.valueOf(absNewXPanelPresenter.f12286p));
                GLog.m7965d("lxsXpanelCb", "EVENT_HEIGHT_CHANGED" + AbsNewXPanelPresenter.this.f12286p);
            }
        }
    };

    /* renamed from: n */
    private List<String> f12285n = new CopyOnWriteArrayList();
    /* access modifiers changed from: private */

    /* renamed from: p */
    public int f12286p = 0;

    /* renamed from: q */
    private AtomicInteger f12287q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public int f12288r;

    /* renamed from: s */
    private List<XEComponent> f12289s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public XpanelLoadingView f12290t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public int f12291u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public float f12292v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public List<String> f12293w = new LinkedList();

    /* renamed from: x */
    private BaseEventPublisher.OnEventListener<String> f12294x = new BaseEventPublisher.OnEventListener<String>() {
        public void onEvent(String str, String str2) {
            AbsNewXPanelPresenter.this.m8314a(str2);
        }
    };

    /* renamed from: y */
    private BaseEventPublisher.OnEventListener<XpNewHeightChangeModel> f12295y = new BaseEventPublisher.OnEventListener<XpNewHeightChangeModel>() {
        public void onEvent(String str, XpNewHeightChangeModel xpNewHeightChangeModel) {
            String str2 = xpNewHeightChangeModel.mCardID;
            int i = xpNewHeightChangeModel.mToHeight;
            if (!TextUtils.isEmpty(str2) && i > 0) {
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    if (i3 >= AbsNewXPanelPresenter.this.f12293w.size()) {
                        break;
                    } else if (str2.equals(AbsNewXPanelPresenter.this.f12293w.get(i3))) {
                        i2 = i3;
                        break;
                    } else {
                        i3++;
                    }
                }
                if (i2 >= 1) {
                    AbsNewXPanelPresenter.this.f12278g.cardHeightChange(i2, i);
                }
            }
        }
    };

    /* renamed from: z */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f12296z = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (BaseEventKeys.NewXpanel.EVENT_REFRESH_XPANEL_NEW.equals(str)) {
                AbsNewXPanelPresenter.this.loadData();
            }
        }
    };

    public final void addViewByHand(String str, String str2, View view) {
    }

    /* access modifiers changed from: protected */
    public abstract String getComponentIdByType(String str);

    /* access modifiers changed from: protected */
    public abstract String[] getNativeCards();

    /* access modifiers changed from: private */
    /* renamed from: a */
    public XpTrackItem m8302a(XpCardTrackProperty xpCardTrackProperty) {
        XpTrackItem xpTrackItem = new XpTrackItem();
        xpTrackItem.f11324id = xpCardTrackProperty.f51624id;
        xpTrackItem.height = xpCardTrackProperty.height;
        xpTrackItem.top = xpCardTrackProperty.top;
        return xpTrackItem;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8314a(String str) {
        if (!TextUtils.isEmpty(str)) {
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i2 >= this.f12293w.size()) {
                    break;
                } else if (str.equals(this.f12293w.get(i2))) {
                    i = i2;
                    break;
                } else {
                    i2++;
                }
            }
            if (i >= 1) {
                if (this.f12284m.contains(str)) {
                    Iterator<XpBizCardProperty> it = this.f12282k.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        XpBizCardProperty next = it.next();
                        if (next.mId != null && next.mId.equals(str)) {
                            GLog.m7968e("lxsLife remove", next.mId);
                            if (next.mLifeCycle != null) {
                                next.mLifeCycle.onCardRemove();
                            }
                        }
                    }
                    this.f12284m.remove(str);
                }
                this.f12278g.removeCard(i + 1);
                this.f12293w.remove(i);
                for (XpBizCardProperty next2 : this.f12282k) {
                    if (!(next2 == null || next2.mRefresh == null)) {
                        next2.mRefresh.compRefresh(2, str, this.f12291u, new IXpCompRefresh.IXpCompRefreshCb() {
                            public void callback(float f, int i) {
                                AbsNewXPanelPresenter.this.f12278g.firstCardHeightWillChangeTo(new XpConfig.Builder().setDefaultDpSecondCardShowHeight(AbsNewXPanelPresenter.this.f12292v).setFirstCardHeightWillChangeTo(i).build());
                            }

                            public void heightAnimValue(int i) {
                                AbsNewXPanelPresenter.this.f12278g.fistCardHeightChange(i);
                            }
                        });
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0051, code lost:
        if (r3 == 0) goto L_0x0053;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m8315a(java.util.List<com.didiglobal.enginecore.component.XEComponent> r9) {
        /*
            r8 = this;
            if (r9 == 0) goto L_0x00ca
            int r0 = r9.size()
            if (r0 != 0) goto L_0x000a
            goto L_0x00ca
        L_0x000a:
            java.util.Iterator r9 = r9.iterator()
        L_0x000e:
            boolean r0 = r9.hasNext()
            if (r0 == 0) goto L_0x00ca
            java.lang.Object r0 = r9.next()
            com.didiglobal.enginecore.component.XEComponent r0 = (com.didiglobal.enginecore.component.XEComponent) r0
            org.json.JSONObject r1 = r0.getData()
            if (r1 == 0) goto L_0x000e
            java.lang.String r2 = "update"
            org.json.JSONObject r2 = r1.optJSONObject(r2)
            if (r2 == 0) goto L_0x000e
            java.lang.String r3 = "pre_node"
            java.lang.String r2 = r2.optString(r3)
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            r4 = 1
            if (r3 != 0) goto L_0x0053
            r3 = 0
            r5 = 0
        L_0x0037:
            java.util.List<java.lang.String> r6 = r8.f12293w
            int r6 = r6.size()
            if (r5 >= r6) goto L_0x0051
            java.util.List<java.lang.String> r6 = r8.f12293w
            java.lang.Object r6 = r6.get(r5)
            boolean r6 = r2.equals(r6)
            if (r6 == 0) goto L_0x004e
            int r3 = r5 + 1
            goto L_0x0051
        L_0x004e:
            int r5 = r5 + 1
            goto L_0x0037
        L_0x0051:
            if (r3 != 0) goto L_0x0054
        L_0x0053:
            r3 = 1
        L_0x0054:
            com.didiglobal.xpanelnew.base.XpCardProperty r2 = new com.didiglobal.xpanelnew.base.XpCardProperty
            r2.<init>()
            java.util.HashMap<java.lang.String, com.google.gson.internal.LinkedTreeMap<java.lang.String, java.lang.Object>> r5 = r8.f12266D
            java.lang.String r6 = r0.getId()
            java.lang.Object r5 = r5.get(r6)
            java.util.Map r5 = (java.util.Map) r5
            if (r5 == 0) goto L_0x006a
            r2.setExtension(r5)
        L_0x006a:
            boolean r5 = r0 instanceof com.didiglobal.enginecore.template.nat.NativeComponent
            if (r5 == 0) goto L_0x00ab
            java.util.List<com.didi.component.comp_new_xpanel.inner.XpBizCardProperty> r4 = r8.f12282k
            java.util.Iterator r4 = r4.iterator()
        L_0x0074:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x000e
            java.lang.Object r5 = r4.next()
            com.didi.component.comp_new_xpanel.inner.XpBizCardProperty r5 = (com.didi.component.comp_new_xpanel.inner.XpBizCardProperty) r5
            java.lang.String r6 = r5.mId
            java.lang.String r7 = r0.getId()
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x0074
            android.view.View r6 = r0.getView()
            if (r6 != 0) goto L_0x009c
            android.view.View r6 = r5.mView
            r2.setView(r6)
            java.lang.String r6 = r5.mId
            r2.setId(r6)
        L_0x009c:
            com.didi.component.business.xpanelnew.XpNewAdapter r6 = r5.mAdapter
            if (r6 == 0) goto L_0x0074
            com.didi.component.business.xpanelnew.XpNewAdapter r5 = r5.mAdapter
            com.didi.component.comp_new_xpanel.AbsNewXPanelPresenter$9 r6 = new com.didi.component.comp_new_xpanel.AbsNewXPanelPresenter$9
            r6.<init>(r3, r2, r0)
            r5.setViewWithData(r1, r6)
            goto L_0x0074
        L_0x00ab:
            boolean r1 = r0 instanceof com.didiglobal.enginecore.template.temp.TemplateComponent
            if (r1 != 0) goto L_0x00b3
            boolean r1 = r0 instanceof com.didiglobal.enginecore.template.xml.XMLComponent
            if (r1 == 0) goto L_0x000e
        L_0x00b3:
            android.view.View r1 = r0.getView()
            r2.setView(r1)
            java.lang.String r1 = r0.getId()
            r2.setId(r1)
            java.lang.String r0 = r0.getId()
            r8.m8317a(r4, r3, r2, r0)
            goto L_0x000e
        L_0x00ca:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.comp_new_xpanel.AbsNewXPanelPresenter.m8315a(java.util.List):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8317a(boolean z, int i, XpCardProperty xpCardProperty, String str) {
        if (!this.f12293w.contains(str) && z) {
            boolean z2 = false;
            Iterator<String> it = this.f12284m.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (str.equals(it.next())) {
                        z2 = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (!z2) {
                Iterator<XpBizCardProperty> it2 = this.f12282k.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    XpBizCardProperty next = it2.next();
                    if (next.mId != null && next.mId.equals(str)) {
                        GLog.m7968e("lxsLife add", next.mId);
                        if (next.mLifeCycle != null) {
                            next.mLifeCycle.onCardAdd();
                        }
                    }
                }
                this.f12284m.add(str);
            }
            this.f12293w.add(i, str);
            this.f12278g.addCard(xpCardProperty, i + 1);
            for (XpBizCardProperty next2 : this.f12282k) {
                if (!(next2 == null || next2.mRefresh == null)) {
                    next2.mRefresh.compRefresh(1, str, this.f12291u, new IXpCompRefresh.IXpCompRefreshCb() {
                        public void callback(float f, int i) {
                            AbsNewXPanelPresenter.this.f12278g.firstCardHeightWillChangeTo(new XpConfig.Builder().setDefaultDpSecondCardShowHeight(f).setFirstCardHeightWillChangeTo(i).build());
                        }

                        public void heightAnimValue(int i) {
                            AbsNewXPanelPresenter.this.f12278g.fistCardHeightChange(i);
                        }
                    });
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v12, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: com.google.gson.internal.LinkedTreeMap} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m8313a(com.google.gson.JsonArray r7) {
        /*
            r6 = this;
            com.google.gson.Gson r0 = new com.google.gson.Gson
            r0.<init>()
            java.lang.String r1 = r7.toString()
            com.didi.component.comp_new_xpanel.AbsNewXPanelPresenter$12 r2 = new com.didi.component.comp_new_xpanel.AbsNewXPanelPresenter$12
            r2.<init>()
            java.lang.reflect.Type r2 = r2.getType()
            java.lang.Object r0 = r0.fromJson((java.lang.String) r1, (java.lang.reflect.Type) r2)
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            com.didi.sdk.logging.Logger r1 = r6.mLogger
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "NewXpanelBizFlow:Engine callback list size = "
            r2.append(r3)
            int r7 = r7.size()
            r2.append(r7)
            java.lang.String r7 = r2.toString()
            r2 = 0
            java.lang.Object[] r3 = new java.lang.Object[r2]
            r1.info((java.lang.String) r7, (java.lang.Object[]) r3)
            java.util.Iterator r7 = r0.iterator()
        L_0x0039:
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto L_0x0094
            java.lang.Object r0 = r7.next()
            com.google.gson.internal.LinkedTreeMap r0 = (com.google.gson.internal.LinkedTreeMap) r0     // Catch:{ Exception -> 0x008f }
            if (r0 != 0) goto L_0x0048
            goto L_0x0039
        L_0x0048:
            java.lang.String r1 = "id"
            java.lang.Object r1 = r0.get(r1)     // Catch:{ Exception -> 0x008f }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x008f }
            com.didi.sdk.logging.Logger r3 = r6.mLogger     // Catch:{ Exception -> 0x008f }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x008f }
            r4.<init>()     // Catch:{ Exception -> 0x008f }
            java.lang.String r5 = "NewXpanelBizFlow:Engine callback list ids, id =  "
            r4.append(r5)     // Catch:{ Exception -> 0x008f }
            r4.append(r1)     // Catch:{ Exception -> 0x008f }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x008f }
            java.lang.Object[] r5 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x008f }
            r3.info((java.lang.String) r4, (java.lang.Object[]) r5)     // Catch:{ Exception -> 0x008f }
            r3 = 0
            java.lang.String r4 = "extension"
            java.lang.Object r0 = r0.get(r4)     // Catch:{ Exception -> 0x008f }
            com.google.gson.internal.LinkedTreeMap r0 = (com.google.gson.internal.LinkedTreeMap) r0     // Catch:{ Exception -> 0x008f }
            if (r0 == 0) goto L_0x007c
            java.lang.String r3 = "log_data"
            java.lang.Object r0 = r0.get(r3)     // Catch:{ Exception -> 0x008f }
            r3 = r0
            com.google.gson.internal.LinkedTreeMap r3 = (com.google.gson.internal.LinkedTreeMap) r3     // Catch:{ Exception -> 0x008f }
        L_0x007c:
            if (r3 == 0) goto L_0x0039
            boolean r0 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x008f }
            if (r0 != 0) goto L_0x0039
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x008f }
            r0.<init>(r3)     // Catch:{ Exception -> 0x008f }
            java.util.HashMap<java.lang.String, com.google.gson.internal.LinkedTreeMap<java.lang.String, java.lang.Object>> r0 = r6.f12266D     // Catch:{ Exception -> 0x008f }
            r0.put(r1, r3)     // Catch:{ Exception -> 0x008f }
            goto L_0x0039
        L_0x008f:
            r0 = move-exception
            r0.printStackTrace()
            goto L_0x0039
        L_0x0094:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.comp_new_xpanel.AbsNewXPanelPresenter.m8313a(com.google.gson.JsonArray):void");
    }

    /* renamed from: b */
    private void m8322b() {
        AtomicInteger atomicInteger = this.f12287q;
        if (atomicInteger != null) {
            atomicInteger.decrementAndGet();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m8326b(List<XEComponent> list) {
        if (list != null && list.size() != 0) {
            Logger logger = this.mLogger;
            logger.info("NewXpanelBizFlow:Engine callback List<XEComponent> size = " + list.size(), new Object[0]);
            this.f12289s = list;
            this.f12287q = new AtomicInteger(list.size());
            Iterator<XEComponent> it = list.iterator();
            while (true) {
                boolean z = true;
                if (!it.hasNext()) {
                    break;
                }
                XEComponent next = it.next();
                if (next instanceof NativeComponent) {
                    Iterator<XpBizCardProperty> it2 = this.f12282k.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            if (it2.next().mId.equals(next.getId())) {
                                break;
                            }
                        } else {
                            z = false;
                            break;
                        }
                    }
                    if (!z) {
                        m8322b();
                    }
                }
            }
            for (XEComponent next2 : list) {
                final XpCardProperty xpCardProperty = new XpCardProperty();
                Map map = this.f12266D.get(next2.getId());
                Logger logger2 = this.mLogger;
                logger2.info("NewXpanelBizFlow:Engine callback List<XEComponent> ids, id = " + next2.getId(), new Object[0]);
                if (map != null) {
                    xpCardProperty.setExtension(map);
                }
                if (next2 instanceof NativeComponent) {
                    for (XpBizCardProperty next3 : this.f12282k) {
                        if (next3.mId.equals(next2.getId())) {
                            if (next2.getView() == null) {
                                xpCardProperty.setView(next3.mView);
                                GLog.m7968e("XParentE", next3.mView.getParent() != null ? C16471q.f49113b : "N");
                                xpCardProperty.setId(next3.mId);
                            }
                            JSONObject data = next2.getData();
                            if (!(data == null || next3.mAdapter == null)) {
                                next3.mAdapter.setViewWithData(data, new IXpCardBindDataReadyCallback() {
                                    public void ready(boolean z) {
                                        AbsNewXPanelPresenter.this.m8318a(z, xpCardProperty);
                                    }
                                });
                            }
                            if (next3.mReady != null) {
                                next3.mReady.viewBindBizDataReady(new IXpCardBindDataReadyCallback() {
                                    public void ready(boolean z) {
                                        AbsNewXPanelPresenter.this.m8318a(z, xpCardProperty);
                                    }
                                });
                            }
                        }
                    }
                } else if ((next2 instanceof TemplateComponent) || (next2 instanceof XMLComponent)) {
                    xpCardProperty.setView(next2.getView());
                    xpCardProperty.setId(next2.getId());
                    m8318a(true, xpCardProperty);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8318a(boolean z, XpCardProperty xpCardProperty) {
        m8322b();
        Logger logger = this.mLogger;
        logger.info("NewXpanelBizFlow:viewReady后剩余处理组件数 = " + this.f12287q.get() + ", ready组件id = " + xpCardProperty.getId() + ", 卡片是否可见：" + z, new Object[0]);
        if (z) {
            this.f12283l.add(xpCardProperty);
        }
        GLog.m7967e("lxsConfig:" + this.f12287q.get() + xpCardProperty.getId());
        if (this.f12287q.get() == 0) {
            this.f12285n.clear();
            this.f12293w.clear();
            LinkedList linkedList = new LinkedList();
            Iterator<XEComponent> it = this.f12289s.iterator();
            while (true) {
                boolean z2 = true;
                if (!it.hasNext()) {
                    break;
                }
                XEComponent next = it.next();
                Iterator<XpCardProperty> it2 = this.f12283l.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    XpCardProperty next2 = it2.next();
                    if (!TextUtils.isEmpty(next2.getId()) && next2.getId().equals(next.getId())) {
                        linkedList.add(next2);
                        Logger logger2 = this.mLogger;
                        logger2.info("NewXpanelBizFlow:业务处理后设置给xpanelsdk的可见卡片id = " + next2.getId(), new Object[0]);
                        this.f12293w.add(next.getId());
                        Iterator<String> it3 = this.f12284m.iterator();
                        while (true) {
                            if (!it3.hasNext()) {
                                z2 = false;
                                break;
                            }
                            if (next2.getId().equals(it3.next())) {
                                this.f12284m.remove(next2.getId());
                                break;
                            }
                        }
                        if (!z2) {
                            Iterator<XpBizCardProperty> it4 = this.f12282k.iterator();
                            while (true) {
                                if (!it4.hasNext()) {
                                    break;
                                }
                                XpBizCardProperty next3 = it4.next();
                                if (next3.mId != null && next3.mId.equals(next2.getId())) {
                                    GLog.m7968e("lxsLife add", next3.mId);
                                    if (next3.mLifeCycle != null) {
                                        next3.mLifeCycle.onCardAdd();
                                    }
                                }
                            }
                        }
                        this.f12285n.add(next2.getId());
                    }
                }
            }
            for (String next4 : this.f12284m) {
                Iterator<XpBizCardProperty> it5 = this.f12282k.iterator();
                while (true) {
                    if (!it5.hasNext()) {
                        break;
                    }
                    XpBizCardProperty next5 = it5.next();
                    if (next5.mId != null && next5.mId.equals(next4)) {
                        GLog.m7968e("lxsLife remove", next5.mId);
                        if (next5.mLifeCycle != null) {
                            next5.mLifeCycle.onCardRemove();
                        }
                    }
                }
                this.f12284m.remove(next4);
            }
            this.f12284m.addAll(this.f12285n);
            this.f12278g.setData(linkedList, this.f12288r > 0);
            for (XpBizCardProperty next6 : this.f12282k) {
                if (!(next6 == null || next6.mRefresh == null)) {
                    next6.mRefresh.compIds(this.f12293w, this.f12291u, new IXpCompRefresh.IXpCompRefreshCb() {
                        public void callback(float f, int i) {
                            AbsNewXPanelPresenter.this.f12278g.firstCardHeightWillChangeTo(new XpConfig.Builder().setDefaultDpSecondCardShowHeight(f).setFirstCardHeightWillChangeTo(i).build());
                        }

                        public void heightAnimValue(int i) {
                            AbsNewXPanelPresenter.this.f12278g.fistCardHeightChange(i);
                        }
                    });
                }
            }
            this.f12278g.setXpScrollEnabled(true);
            Logger logger3 = this.mLogger;
            logger3.info("NewXpanelBizFlow:业务处理后给到xpanelsdk的可见卡片个数 = " + linkedList.size(), new Object[0]);
            this.f12283l.clear();
            m8329c();
        }
    }

    /* renamed from: c */
    private void m8329c() {
        if (CarOrderHelper.isOrderEnd()) {
            UIThreadHandler.post(new Runnable() {
                public void run() {
                    BaseEventPublisher.getPublisher().publish(BaseEventKeys.NewXpanel.EVENT_XPANEL_HEIGHT_CHANGED_4_PAY_XPANEL_READY);
                }
            }, 400);
        }
    }

    /* renamed from: b */
    private void m8325b(String str) {
        ArrayList arrayList = new ArrayList();
        XpCardProperty xpCardProperty = new XpCardProperty();
        for (XpBizCardProperty next : this.f12282k) {
            if (next.mId.equals(str)) {
                if (xpCardProperty.getView() == null) {
                    xpCardProperty.setView(next.mView);
                }
                arrayList.add(xpCardProperty);
                this.f12278g.setData(arrayList);
            }
        }
    }

    /* renamed from: a */
    private void m8307a(View view) {
        ArrayList arrayList = new ArrayList();
        XpCardProperty xpCardProperty = new XpCardProperty();
        if (xpCardProperty.getView() == null) {
            xpCardProperty.setView(view);
        }
        GLog.m7968e("BizLog", "addNativeView()");
        arrayList.add(xpCardProperty);
        this.f12278g.setXpScrollEnabled(false);
        this.f12278g.setData(arrayList);
    }

    public AbsNewXPanelPresenter(ComponentParams componentParams2) {
        super(componentParams2.bizCtx.getContext());
        this.mBizCtx = componentParams2.bizCtx;
        this.componentParams = componentParams2;
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        cachedAdViews.clear();
        entered = true;
        int i = bundle.getInt(BaseExtras.Common.EXTRA_ORDER_SOURCE, 0);
        boolean z = bundle.getBoolean(BaseExtras.Trip.EXTRA_TRIP_IS_ANY_CAR, false);
        this.f12279h = false;
        XpanelNew xPanel = ((AbsNewXPanelView) this.mView).getXPanel();
        this.f12278g = xPanel;
        xPanel.setXpCallback(new IXpCallback() {
            private static final int INVISIBLE_HEIGHT_DELTA = 100;
            private int defaultStatusHeight = 0;
            private int invisibleHeight = 0;

            public void doXPanelHeightChange(int i) {
                int unused = AbsNewXPanelPresenter.this.f12286p = i;
                GLog.m7965d("lxsXpanelCb", "doXPanelHeightChange: " + i);
                BaseEventPublisher.getPublisher().publishSticky(BaseEventKeys.XPanel.EVENT_HEIGHT_CHANGED_SCROLL_LISTENER, Integer.valueOf(i));
                calComponentAlpha(i);
            }

            public void doXpanelStatusHeight(int i, int i2) {
                GLog.m7965d("lxsXpanelCb", "doXpanelStatusHeight: " + i2 + "xpStatus: " + i);
                AbsNewXPanelPresenter.this.doPublish(BaseEventKeys.XPanel.EVENT_NEW_XPANEL_STATUS, Integer.valueOf(i));
                if (i == 2 || i == 3) {
                    AbsNewXPanelPresenter.this.doPublish(BaseEventKeys.XPanel.EVENT_HEIGHT_CHANGED, Integer.valueOf(i2));
                }
                if (i == 2) {
                    boolean unused = AbsNewXPanelPresenter.this.f12276e = true;
                    AbsNewXPanelPresenter.this.doPublish(BaseEventKeys.NewXpanel.EVENT_XPANEL_DEFAULT_HEIGHT, Integer.valueOf(i2));
                    this.defaultStatusHeight = i2;
                    this.invisibleHeight = i2 + 100;
                    return;
                }
                boolean unused2 = AbsNewXPanelPresenter.this.f12276e = false;
            }

            public void onCardWithCallback(int i) {
                int unused = AbsNewXPanelPresenter.this.f12291u = i;
            }

            private void calComponentAlpha(int i) {
                float f = 1.0f;
                if (i > this.invisibleHeight) {
                    f = 0.0f;
                } else {
                    int i2 = this.defaultStatusHeight;
                    if (i > i2) {
                        f = 1.0f - ((((float) (i - i2)) * 1.0f) / 100.0f);
                    }
                }
                AbsNewXPanelPresenter.this.doPublish(BaseEventKeys.NewXpanel.EVENT_XPANEL_COMPONENT_ALPHA, Float.valueOf(f));
            }
        });
        loadNativeCards(bundle);
        subscribe(BaseEventKeys.NewXpanel.EVENT_REFRESH_XPANEL_NEW, this.f12296z);
        subscribe(BaseEventKeys.XPanel.EVENT_REQUEST_FETCH_DEFAULT_HEIGHT, this.mRequestDefaultHeight);
        subscribe(BaseEventKeys.NewXpanel.EVENT_XPANEL_NEW_ADD_COMMON_MSG, this.f12269G);
        subscribe(BaseEventKeys.NewXpanel.EVENT_XPANEL_UPDATE_TITLE, this.f12271I);
        subscribe(BaseEventKeys.NewXpanel.EVENT_XPANEL_REFRESH_HEIGHT, this.f12263A);
        subscribe(BaseEventKeys.NewXpanel.EVENT_XPANEL_SHOW_ONE_CARD, this.f12264B);
        subscribe(BaseEventKeys.NewXpanel.EVENT_XPANEL_NEW_AGAIN_ARRANGE_REMOVE_MSG, this.f12270H);
        subscribe(BaseEventKeys.NewXpanel.EVENT_XPANEL_NEW_CONFIG_DEFAULT_SHOW_HEIGHT, this.f12267E);
        subscribe(BaseEventKeys.NewXpanel.EVENT_XPANEL_HEIGHT_CHANGED_4_PAY_DOWN, this.f12274L);
        subscribe(BaseEventKeys.NewXpanel.EVENT_XPANEL_HEIGHT_CHANGED_4_PAY_UP, this.f12274L);
        subscribe(BaseEventKeys.NewXpanel.EVENT_XPANEL_HEIGHT_CHANGED_4_PAY_VISIBLE, this.f12274L);
        subscribe(BaseEventKeys.NewXpanel.EVENT_XPNAEL_NEW_REMOVE_CARD, this.f12294x);
        subscribe(BaseEventKeys.NewXpanel.EVENT_XPNAEL_NEW_CARD_HEIGHT_CHANGE, this.f12295y);
        XERegisterModel xERegisterModel = new XERegisterModel(XERequestKey.REQUEST_KEY_XPANEL, XERequestKey.SCENE_TRIP, this.f12272J);
        xERegisterModel.requestParams = this.f12268F;
        xERegisterModel.components = new ArrayList();
        xERegisterModel.components.add(new XETemplateComponent("template_standard_biz_xpanel_card", XpTemplateBizView.class, XpTemplateBizModel.class));
        xERegisterModel.components.add(new XETemplateComponent("template_standard_operation_xpanel_card", XpTemplateOperationView.class, XpTemplateOperationModel.class));
        xERegisterModel.components.add(new XETemplateComponent("template_ad_card", XpTemplateAdCardView.class, XpTemplateAdCardModel.class));
        XERegister.registerTemplate(xERegisterModel);
        XpanelLoadingView xpanelLoadingView = new XpanelLoadingView(this.mContext);
        this.f12290t = xpanelLoadingView;
        m8307a(xpanelLoadingView.getView());
        if (!z && i == 0 && CarOrderHelper.getOrder() == null) {
            this.f12278g.setConfig(new XpConfig.Builder().setOneCardAndXDp(70.0f).build());
            this.f12290t.showExpectLoading();
        } else {
            this.f12278g.setConfig(new XpConfig.Builder().setOneCardAndXDp(-130.0f).build());
            this.f12290t.showDefaultLoading();
        }
        XpOmegaConfig xpOmegaConfig = new XpOmegaConfig();
        xpOmegaConfig.setXPanelOmegaCallback(this.f12265C);
        this.f12278g.setOmegaConfig(xpOmegaConfig);
    }

    /* access modifiers changed from: protected */
    public final void loadNativeCards(Bundle bundle) {
        String[] nativeCards = getNativeCards();
        if (nativeCards == null || nativeCards.length == 0) {
            GLog.m7968e(this.f12275d, "No card was defined in local.");
            return;
        }
        for (String str : nativeCards) {
            if (!TextUtils.isEmpty(str)) {
                inflateComponent(str, bundle);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        GLog.m7971i(this.f12275d, "onRemove");
        cachedAdViews.clear();
        entered = false;
        GlobalAdManager.getInstance().releaseAll();
        unsubscribe(BaseEventKeys.NewXpanel.EVENT_REFRESH_XPANEL_NEW, this.f12296z);
        unsubscribe(BaseEventKeys.XPanel.EVENT_REQUEST_FETCH_DEFAULT_HEIGHT, this.mRequestDefaultHeight);
        unsubscribe(BaseEventKeys.NewXpanel.EVENT_XPANEL_NEW_ADD_COMMON_MSG, this.f12269G);
        unsubscribe(BaseEventKeys.NewXpanel.EVENT_XPANEL_UPDATE_TITLE, this.f12271I);
        unsubscribe(BaseEventKeys.NewXpanel.EVENT_XPANEL_REFRESH_HEIGHT, this.f12263A);
        unsubscribe(BaseEventKeys.NewXpanel.EVENT_XPANEL_SHOW_ONE_CARD, this.f12264B);
        unsubscribe(BaseEventKeys.NewXpanel.EVENT_XPANEL_NEW_AGAIN_ARRANGE_REMOVE_MSG, this.f12270H);
        unsubscribe(BaseEventKeys.NewXpanel.EVENT_XPANEL_NEW_CONFIG_DEFAULT_SHOW_HEIGHT, this.f12267E);
        unsubscribe(BaseEventKeys.NewXpanel.EVENT_XPANEL_HEIGHT_CHANGED_4_PAY_DOWN, this.f12274L);
        unsubscribe(BaseEventKeys.NewXpanel.EVENT_XPANEL_HEIGHT_CHANGED_4_PAY_UP, this.f12274L);
        unsubscribe(BaseEventKeys.NewXpanel.EVENT_XPANEL_HEIGHT_CHANGED_4_PAY_VISIBLE, this.f12274L);
        unsubscribe(BaseEventKeys.NewXpanel.EVENT_XPNAEL_NEW_REMOVE_CARD, this.f12294x);
        unsubscribe(BaseEventKeys.NewXpanel.EVENT_XPNAEL_NEW_CARD_HEIGHT_CHANGE, this.f12295y);
        this.f12279h = true;
        XERegister.unregisterTemplate(XERequestKey.REQUEST_KEY_XPANEL);
    }

    public boolean isRemoved() {
        return this.f12279h;
    }

    public final void inflateComponent(String str, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        IComponent newComponent = this.f12280i.newComponent(str, (ViewGroup) ((AbsNewXPanelView) this.mView).getView(), bundle);
        if (newComponent != null && newComponent.getView() != null) {
            View view = newComponent.getView().getView();
            XpBizCardProperty xpBizCardProperty = new XpBizCardProperty();
            xpBizCardProperty.mView = view;
            xpBizCardProperty.mType = str;
            xpBizCardProperty.mId = getComponentIdByType(str);
            if (newComponent.getPresenter() instanceof XpNewAdapter) {
                xpBizCardProperty.mAdapter = (XpNewAdapter) newComponent.getPresenter();
            }
            if (newComponent.getPresenter() instanceof IXpCardBindDataReady) {
                xpBizCardProperty.mReady = (IXpCardBindDataReady) newComponent.getPresenter();
            }
            if (newComponent.getPresenter() instanceof IXpCardLifeCycle) {
                xpBizCardProperty.mLifeCycle = (IXpCardLifeCycle) newComponent.getPresenter();
            }
            if (newComponent.getPresenter() instanceof IXpCompRefresh) {
                xpBizCardProperty.mRefresh = (IXpCompRefresh) newComponent.getPresenter();
            }
            this.f12282k.add(xpBizCardProperty);
        }
    }

    public XpBizCardProperty getCardProperty(String str) {
        for (XpBizCardProperty next : this.f12282k) {
            if (next.mId.equalsIgnoreCase(str)) {
                return next;
            }
        }
        return null;
    }

    public XpBizCardProperty getPropertyByType(String str) {
        for (XpBizCardProperty next : this.f12282k) {
            if (next.mType.equalsIgnoreCase(str)) {
                return next;
            }
        }
        return null;
    }

    public final void setVisibilityByType(String str, boolean z) {
        getPropertyByType(str);
    }

    public final void commit() {
        this.f12283l.clear();
    }

    public void loadData() {
        GLog.m7965d(this.f12275d, "request net");
        XESimpleReqParams xESimpleReqParams = new XESimpleReqParams();
        xESimpleReqParams.requestKey = XERequestKey.REQUEST_KEY_XPANEL;
        xESimpleReqParams.scene = XERequestKey.SCENE_TRIP;
        xESimpleReqParams.bizParams = new HashMap();
        int lastOrderStatus = XEParams.getInstance().getLastOrderStatus();
        int lastOrderSubStatus = XEParams.getInstance().getLastOrderSubStatus();
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null) {
            if (lastOrderStatus == 0 || lastOrderSubStatus == 0) {
                lastOrderStatus = order.status;
                lastOrderSubStatus = order.substatus;
            }
            xESimpleReqParams.bizParams.put("oid", order.oid);
        }
        xESimpleReqParams.bizParams.put("status", Integer.valueOf(lastOrderStatus));
        xESimpleReqParams.bizParams.put(ParamKeys.PARAM_SUB_STATUS, Integer.valueOf(lastOrderSubStatus));
        XEngineReq.simpleRequest(xESimpleReqParams);
    }

    public final void setComponentCreator(IViewContainer.IComponentCreator iComponentCreator) {
        this.f12280i = iComponentCreator;
    }

    /* access modifiers changed from: protected */
    public void onPagePause() {
        super.onPagePause();
        this.f12278g.onPause();
        GLog.m7971i(this.f12275d, "onPagePause");
    }

    /* access modifiers changed from: protected */
    public void onPageResume() {
        super.onPageResume();
        this.f12278g.onResume();
        GLog.m7971i(this.f12275d, "onPageResume");
    }

    /* access modifiers changed from: protected */
    public void onBackHome(Bundle bundle) {
        super.onBackHome(bundle);
    }

    /* access modifiers changed from: protected */
    public void onLeaveHome() {
        super.onLeaveHome();
    }

    /* renamed from: a */
    private void m8306a(int i) {
        ObjectAnimator.ofFloat(this.f12278g.getView(), "translationY", new float[]{(float) (this.f12278g.getFirstCardHeight() - (i - this.f12278g.getMessageRealHeight()))}).start();
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m8333d() {
        this.f12278g.getView().setTranslationY(0.0f);
    }

    /* renamed from: e */
    private void m8336e() {
        this.f12278g.setXpScrollEnabled(false);
        int firstCardHeight = this.f12278g.getFirstCardHeight() + this.f12278g.getMessageRealHeight();
        this.f12273K = this.f12278g.getFirstCardHeight();
        String str = this.f12275d;
        GLog.m7965d(str, "transXpAll:tranY:" + firstCardHeight);
        GLog.m7968e(this.f12275d, "transXpAll");
        this.f12278g.getView().setTranslationY((float) firstCardHeight);
    }

    /* renamed from: f */
    private void m8338f() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.f12278g.getView(), "translationY", new float[]{(float) this.f12273K}).setDuration(400);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.f12278g.getView(), "alpha", new float[]{1.0f, 1.0f}).setDuration(400);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(this.f12278g.getView(), "translationY", new float[]{0.0f}).setDuration(400);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(new Animator[]{duration, duration2, duration3});
        animatorSet.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                boolean unused = AbsNewXPanelPresenter.this.f12277f = false;
                AbsNewXPanelPresenter.this.f12278g.refreshMsgHeight();
            }
        });
        animatorSet.start();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m8323b(int i) {
        if (this.f12276e) {
            this.f12277f = true;
            int min = Math.min(i, this.f12278g.getMessageRealHeight());
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f12278g.getView(), "translationY", new float[]{(float) (this.f12278g.getFirstCardHeight() - (min - this.f12278g.getMessageRealHeight()))});
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f12278g.getView(), "alpha", new float[]{1.0f, 0.0f});
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playSequentially(new Animator[]{ofFloat, ofFloat2});
            ofFloat2.addListener(new AnimatorListenerAdapter() {
                public void onAnimationStart(Animator animator) {
                    AbsNewXPanelPresenter.this.doPublish(BaseEventKeys.Trip.EVENT_GLOBAL_NO_PSD_PROCESSING_SHOWING_FROM_XPANEL);
                }
            });
            animatorSet.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    AbsNewXPanelPresenter.this.m8316a(false);
                    AbsNewXPanelPresenter.this.m8333d();
                    boolean unused = AbsNewXPanelPresenter.this.f12277f = false;
                }
            });
            animatorSet.start();
            return;
        }
        m8316a(false);
        doPublish(BaseEventKeys.Trip.EVENT_GLOBAL_NO_PSD_PROCESSING_SHOWING_FROM_XPANEL);
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m8340g() {
        this.f12277f = true;
        m8336e();
        m8316a(true);
        m8338f();
        this.f12278g.setXpScrollEnabled(true);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8316a(boolean z) {
        this.f12278g.getView().setAlpha(z ? 1.0f : 0.0f);
    }
}
