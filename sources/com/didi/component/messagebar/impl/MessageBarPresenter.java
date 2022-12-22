package com.didi.component.messagebar.impl;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.xengine.XERequestKey;
import com.didi.component.business.xengine.XEngineReq;
import com.didi.component.business.xengine.model.XpTemplateMsgModel;
import com.didi.component.business.xengine.request.XESimpleReqParams;
import com.didi.component.common.util.GLog;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.messagebar.AbsMessageBarPresenter;
import com.didi.component.messagebar.model.CountDownModel;
import com.didi.global.globaluikit.richinfo.LEGORichInfo;
import com.didi.map.global.flow.model.EtaEda;
import com.didi.map.sdk.nav.inertia.SctxStateInfo;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.util.GSonUtil;
import com.didi.travel.psnger.utils.ApolloUtil;
import com.didi.unifiedPay.sdk.model.BasicPayInfo;
import com.didi.xengine.register.XERegister;
import com.didiglobal.enginecore.callback.XEReqParamsCallback;
import com.didiglobal.enginecore.callback.XEResponseCallback;
import com.didiglobal.enginecore.component.XEComponent;
import com.didiglobal.enginecore.data.exception.EngineErrorException;
import com.didiglobal.enginecore.data.exception.NoMatchException;
import com.didiglobal.enginecore.data.model.XEngineData;
import com.didiglobal.enginecore.register.XERegisterModel;
import com.didiglobal.enginecore.template.temp.TemplateComponent;
import com.global.didi.elvish.DistanceStyle;
import com.global.didi.elvish.Elvish;
import com.google.gson.Gson;
import com.google.gson.JsonParser;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import org.json.JSONObject;

public class MessageBarPresenter extends AbsMessageBarPresenter {

    /* renamed from: i */
    private static final String f14586i = "[!!";

    /* renamed from: j */
    private static final String f14587j = "!!]";

    /* renamed from: k */
    private static final String f14588k = "[##";

    /* renamed from: l */
    private static final String f14589l = "##]";

    /* renamed from: m */
    private static final String f14590m = "[eta]";

    /* renamed from: n */
    private static final String f14591n = "[eda]";
    /* access modifiers changed from: private */

    /* renamed from: q */
    public static long f14592q = 10000;

    /* renamed from: r */
    private static final int f14593r = 2;

    /* renamed from: s */
    private static final int f14594s = 3;

    /* renamed from: t */
    private static final int f14595t = 6;

    /* renamed from: A */
    private XpTemplateMsgModel f14596A;

    /* renamed from: B */
    private CountDownModel f14597B;

    /* renamed from: C */
    private CountDownModel f14598C;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public boolean f14599D = true;
    /* access modifiers changed from: private */

    /* renamed from: E */
    public int f14600E;
    /* access modifiers changed from: private */

    /* renamed from: F */
    public boolean f14601F;
    /* access modifiers changed from: private */

    /* renamed from: G */
    public int f14602G = 0;

    /* renamed from: H */
    private BaseEventPublisher.OnEventListener<Integer> f14603H = new BaseEventPublisher.OnEventListener<Integer>() {
        public void onEvent(String str, Integer num) {
            int unused = MessageBarPresenter.this.f14600E = num.intValue();
            Logger logger = MessageBarPresenter.this.mLogger;
            logger.info("lmfmNearDropOffThreshold" + MessageBarPresenter.this.f14600E, new Object[0]);
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: I */
    public String f14604I = null;
    /* access modifiers changed from: private */

    /* renamed from: J */
    public Handler f14605J = new Handler() {
        /* JADX WARNING: Code restructure failed: missing block: B:3:0x000b, code lost:
            if (r0 != 3) goto L_0x003b;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void handleMessage(android.os.Message r6) {
            /*
                r5 = this;
                super.handleMessage(r6)
                int r0 = r6.what
                r1 = 2
                r2 = 0
                r3 = 1
                if (r0 == r1) goto L_0x000e
                r6 = 3
                if (r0 == r6) goto L_0x0024
                goto L_0x003b
            L_0x000e:
                com.didi.component.messagebar.impl.MessageBarPresenter r0 = com.didi.component.messagebar.impl.MessageBarPresenter.this
                int r0 = r0.f14620u
                int r1 = r6.arg1
                if (r0 == r1) goto L_0x00fc
                com.didi.component.messagebar.impl.MessageBarPresenter r0 = com.didi.component.messagebar.impl.MessageBarPresenter.this
                int r6 = r6.arg1
                int unused = r0.f14620u = r6
                com.didi.component.messagebar.impl.MessageBarPresenter r6 = com.didi.component.messagebar.impl.MessageBarPresenter.this
                boolean unused = r6.f14623x = r3
            L_0x0024:
                com.didi.component.messagebar.impl.MessageBarPresenter r6 = com.didi.component.messagebar.impl.MessageBarPresenter.this
                boolean unused = r6.f14623x = r3
                com.didi.component.messagebar.impl.MessageBarPresenter r6 = com.didi.component.messagebar.impl.MessageBarPresenter.this
                r0 = 0
                long unused = r6.f14622w = r0
                com.didi.component.messagebar.impl.MessageBarPresenter r6 = com.didi.component.messagebar.impl.MessageBarPresenter.this
                com.didi.sdk.logging.Logger r6 = r6.mLogger
                java.lang.Object[] r0 = new java.lang.Object[r2]
                java.lang.String r1 = "lmf>>>>>>onEvent>>>>>>>>WHAT_UPDATE_MSG_IMMEDIATELY"
                r6.info((java.lang.String) r1, (java.lang.Object[]) r0)
            L_0x003b:
                com.didi.component.messagebar.impl.MessageBarPresenter r6 = com.didi.component.messagebar.impl.MessageBarPresenter.this
                boolean r6 = r6.f14623x
                if (r6 == 0) goto L_0x00fc
                long r0 = java.lang.System.currentTimeMillis()
                com.didi.component.messagebar.impl.MessageBarPresenter r6 = com.didi.component.messagebar.impl.MessageBarPresenter.this
                long r3 = r6.f14622w
                long r0 = r0 - r3
                long r3 = com.didi.component.messagebar.impl.MessageBarPresenter.f14592q
                int r6 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
                if (r6 <= 0) goto L_0x00fc
                com.didi.component.business.xengine.request.XESimpleReqParams r6 = new com.didi.component.business.xengine.request.XESimpleReqParams
                r6.<init>()
                java.lang.String r0 = "passenger_message"
                r6.requestKey = r0
                java.lang.String r0 = "xEngine_trip"
                r6.scene = r0
                java.util.HashMap r0 = new java.util.HashMap
                r0.<init>()
                r6.bizParams = r0
                java.util.Map<java.lang.String, java.lang.Object> r0 = r6.bizParams
                java.lang.String r1 = com.didi.component.business.util.CarOrderHelper.getOrderId()
                java.lang.String r3 = "oid"
                r0.put(r3, r1)
                java.util.Map<java.lang.String, java.lang.Object> r0 = r6.bizParams
                com.didi.component.messagebar.impl.MessageBarPresenter r1 = com.didi.component.messagebar.impl.MessageBarPresenter.this
                int r1 = r1.f14621v
                java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
                java.lang.String r3 = "version"
                r0.put(r3, r1)
                java.util.Map<java.lang.String, java.lang.Object> r0 = r6.bizParams
                com.didi.component.messagebar.impl.MessageBarPresenter r1 = com.didi.component.messagebar.impl.MessageBarPresenter.this
                java.util.Map r1 = r1.m10387c()
                java.lang.String r3 = "args"
                r0.put(r3, r1)
                java.util.Map<java.lang.String, java.lang.Object> r0 = r6.bizParams
                com.didi.component.messagebar.impl.MessageBarPresenter r1 = com.didi.component.messagebar.impl.MessageBarPresenter.this
                int r1 = r1.f14602G
                java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
                java.lang.String r3 = "trip_state"
                r0.put(r3, r1)
                java.util.HashMap r0 = new java.util.HashMap
                r0.<init>()
                com.didi.component.messagebar.impl.MessageBarPresenter r1 = com.didi.component.messagebar.impl.MessageBarPresenter.this
                int r1 = r1.f14620u
                r3 = -1
                if (r1 == r3) goto L_0x00c1
                com.didi.component.messagebar.impl.MessageBarPresenter r1 = com.didi.component.messagebar.impl.MessageBarPresenter.this
                int r1 = r1.f14620u
                java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
                java.lang.String r3 = "driverMovingException"
                r0.put(r3, r1)
            L_0x00c1:
                com.didi.component.messagebar.impl.MessageBarPresenter r1 = com.didi.component.messagebar.impl.MessageBarPresenter.this
                java.lang.String r1 = r1.f14604I
                boolean r1 = android.text.TextUtils.isEmpty(r1)
                if (r1 != 0) goto L_0x00da
                java.lang.String r1 = "exter_source"
                java.lang.String r3 = "map"
                r0.put(r1, r3)
                com.didi.component.messagebar.impl.MessageBarPresenter r1 = com.didi.component.messagebar.impl.MessageBarPresenter.this
                r3 = 0
                java.lang.String unused = r1.f14604I = r3
            L_0x00da:
                boolean r1 = r0.isEmpty()
                if (r1 != 0) goto L_0x00e7
                java.util.Map<java.lang.String, java.lang.Object> r1 = r6.bizParams
                java.lang.String r3 = "conditions"
                r1.put(r3, r0)
            L_0x00e7:
                com.didi.component.messagebar.impl.MessageBarPresenter r0 = com.didi.component.messagebar.impl.MessageBarPresenter.this
                java.lang.String r1 = "event_xengine_simple_request"
                r0.doPublish(r1, r6)
                com.didi.component.messagebar.impl.MessageBarPresenter r6 = com.didi.component.messagebar.impl.MessageBarPresenter.this
                boolean unused = r6.f14623x = r2
                com.didi.component.messagebar.impl.MessageBarPresenter r6 = com.didi.component.messagebar.impl.MessageBarPresenter.this
                long r0 = java.lang.System.currentTimeMillis()
                long unused = r6.f14622w = r0
            L_0x00fc:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.component.messagebar.impl.MessageBarPresenter.C62652.handleMessage(android.os.Message):void");
        }
    };

    /* renamed from: K */
    private final BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f14606K = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            MessageBarPresenter.this.mLogger.info("lmf>>>>>>onEvent>>>>>>>>mCarPoolPeopleListener", new Object[0]);
            MessageBarPresenter.this.m10396e();
            XEngineReq.simpleRequest(XERequestKey.SCENE_TRIP, XERequestKey.REQUEST_KEY_MAP_INFO);
        }
    };

    /* renamed from: L */
    private final BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f14607L = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (MessageBarPresenter.this.f14605J != null) {
                MessageBarPresenter.this.f14605J.removeMessages(3);
            }
            MessageBarPresenter.this.m10392d();
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: M */
    public int f14608M = -1;
    /* access modifiers changed from: private */

    /* renamed from: N */
    public int f14609N = -1;

    /* renamed from: O */
    private XEResponseCallback f14610O = new XEResponseCallback() {
        public void onSuccess(String str, XEngineData xEngineData, List<XEComponent> list) {
            XEComponent xEComponent;
            if (list != null && list.size() >= 1 && (xEComponent = list.get(0)) != null && (xEComponent instanceof TemplateComponent)) {
                JSONObject data = xEComponent.getData();
                if ("template_message_card".equals(xEComponent.getTemplateId()) && data != null) {
                    try {
                        XpTemplateMsgModel xpTemplateMsgModel = (XpTemplateMsgModel) new Gson().fromJson(data.toString(), XpTemplateMsgModel.class);
                        if (xpTemplateMsgModel != null) {
                            xpTemplateMsgModel.parseExtension(new JsonParser().parse(data.toString()).getAsJsonObject());
                            MessageBarPresenter.this.m10392d();
                            if (xpTemplateMsgModel.normal.data != null) {
                                if (xpTemplateMsgModel.normal.data.subtitle != null) {
                                    xpTemplateMsgModel.normal.data.subtitleKey = GSonUtil.jsonFromObject(xpTemplateMsgModel.normal.data.subtitle);
                                }
                                if (xpTemplateMsgModel.normal.data.title != null) {
                                    String jsonFromObject = GSonUtil.jsonFromObject(xpTemplateMsgModel.normal.data.title);
                                    GLog.m7965d("lxslxs", jsonFromObject);
                                    xpTemplateMsgModel.normal.data.titleKey = jsonFromObject;
                                    if (xpTemplateMsgModel.normal.data.title_type == 6) {
                                        String unused = MessageBarPresenter.this.f14619p = data.toString();
                                        MessageBarPresenter.this.updateEtaEda();
                                        return;
                                    }
                                    String unused2 = MessageBarPresenter.this.f14619p = "";
                                }
                            }
                            if (MessageBarPresenter.this.m10377a(xpTemplateMsgModel.normal)) {
                                MessageBarPresenter.this.m10374a(xpTemplateMsgModel);
                                return;
                            }
                            xpTemplateMsgModel.normal.isNeedAnim = true;
                            MessageBarPresenter.this.doPublish(BaseEventKeys.NewXpanel.EVENT_XPANEL_NEW_ADD_COMMON_MSG, xpTemplateMsgModel);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        public void onFailed(String str, EngineErrorException engineErrorException) {
            if (engineErrorException instanceof NoMatchException) {
                MessageBarPresenter.this.doPublish(BaseEventKeys.NewXpanel.EVENT_XPANEL_NEW_AGAIN_ARRANGE_REMOVE_MSG, (Object) null);
            }
        }
    };

    /* renamed from: a */
    BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f14611a = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            MessageBarPresenter.this.mLogger.info("lmf>>>>>>onEvent>>>>>>>>onPassengerLateEventListener", new Object[0]);
            MessageBarPresenter.this.m10396e();
        }
    };

    /* renamed from: b */
    BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f14612b = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            MessageBarPresenter.this.mLogger.info("lmf>>>>>>onEvent>>>>>>>>wayPointChanged", new Object[0]);
            MessageBarPresenter.this.m10396e();
        }
    };

    /* renamed from: c */
    BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f14613c = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            MessageBarPresenter.this.mLogger.info("MessageBarPresenter>>>>>>onEvent>>>>>>>>onUpdateRecommendPoint", new Object[0]);
            MessageBarPresenter.this.m10396e();
        }
    };

    /* renamed from: d */
    BaseEventPublisher.OnEventListener<String> f14614d = new BaseEventPublisher.OnEventListener<String>() {
        public void onEvent(String str, String str2) {
            MessageBarPresenter.this.mLogger.info("MessageBarPresenter>>>>>>onEvent>>>>>>>>onMapRouteDescribe", new Object[0]);
            String unused = MessageBarPresenter.this.f14604I = str2;
            MessageBarPresenter.this.m10396e();
        }
    };

    /* renamed from: e */
    BaseEventPublisher.OnEventListener<Integer> f14615e = new BaseEventPublisher.OnEventListener<Integer>() {
        public void onEvent(String str, Integer num) {
            Logger logger = MessageBarPresenter.this.mLogger;
            logger.info("MessageBarPresenter tripstate " + num, new Object[0]);
            int unused = MessageBarPresenter.this.f14602G = num.intValue();
            XEngineReq.simpleRequest(XERequestKey.SCENE_TRIP, XERequestKey.REQUEST_KEY_MESSAGE);
        }
    };

    /* renamed from: f */
    BaseEventPublisher.OnEventListener<EtaEda> f14616f = new BaseEventPublisher.OnEventListener<EtaEda>() {
        public void onEvent(String str, EtaEda etaEda) {
            Logger logger = MessageBarPresenter.this.mLogger;
            logger.info("lmf  etaOnEventListener>>>>>>>>>>>>>>>>>" + etaEda, new Object[0]);
            if (etaEda != null && MessageBarPresenter.this.f14621v == 1) {
                if (etaEda.eta != 0 || etaEda.eda != 0) {
                    int unused = MessageBarPresenter.this.f14608M = etaEda.eta;
                    int unused2 = MessageBarPresenter.this.f14609N = etaEda.eda;
                    MessageBarPresenter.this.updateEtaEda();
                    if (MessageBarPresenter.this.f14600E != 0 && !MessageBarPresenter.this.f14601F && MessageBarPresenter.this.f14608M <= MessageBarPresenter.this.f14600E) {
                        XESimpleReqParams xESimpleReqParams = new XESimpleReqParams();
                        xESimpleReqParams.requestKey = XERequestKey.REQUEST_KEY_MESSAGE;
                        xESimpleReqParams.scene = XERequestKey.SCENE_TRIP;
                        xESimpleReqParams.bizParams = new HashMap();
                        xESimpleReqParams.bizParams.put("oid", CarOrderHelper.getOrderId());
                        xESimpleReqParams.bizParams.put("version", Integer.valueOf(MessageBarPresenter.this.f14621v));
                        boolean unused3 = MessageBarPresenter.this.f14601F = true;
                        xESimpleReqParams.bizParams.put("args", MessageBarPresenter.this.m10387c());
                        xESimpleReqParams.bizParams.put("trip_state", Integer.valueOf(MessageBarPresenter.this.f14602G));
                        MessageBarPresenter.this.doPublish(BaseEventKeys.XEngine.EVENT_XENGINE_SIMPLE_REQUEST, xESimpleReqParams);
                        MessageBarPresenter.this.mLogger.info("lmfmessage_text_color_change", new Object[0]);
                        int unused4 = MessageBarPresenter.this.f14600E = 0;
                    }
                }
            }
        }
    };

    /* renamed from: g */
    BaseEventPublisher.OnEventListener<SctxStateInfo> f14617g = new BaseEventPublisher.OnEventListener<SctxStateInfo>() {
        public void onEvent(String str, SctxStateInfo sctxStateInfo) {
            MessageBarPresenter.this.mLogger.info("lmf  mSctxStateEnumOnEventListener>>>>>>>>>>>>>>>>>", new Object[0]);
            if (sctxStateInfo != null) {
                Message obtain = Message.obtain();
                obtain.what = 2;
                obtain.arg1 = sctxStateInfo.isExceptionState() ? 1 : 0;
                MessageBarPresenter.this.f14605J.sendMessage(obtain);
            }
        }
    };

    /* renamed from: h */
    BaseEventPublisher.OnEventListener<BasicPayInfo> f14618h = new BaseEventPublisher.OnEventListener<BasicPayInfo>() {
        public void onEvent(String str, BasicPayInfo basicPayInfo) {
            Logger logger = MessageBarPresenter.this.mLogger;
            logger.info("lmf  getPayBasicInfoOnEventListener>>>>>>>>>>>>>>>>>" + basicPayInfo, new Object[0]);
            if (basicPayInfo != null && !TextUtils.isEmpty(basicPayInfo.payStatusSubtitle)) {
                XESimpleReqParams xESimpleReqParams = new XESimpleReqParams();
                xESimpleReqParams.requestKey = XERequestKey.REQUEST_KEY_MESSAGE;
                xESimpleReqParams.scene = XERequestKey.SCENE_TRIP;
                HashMap hashMap = new HashMap();
                if (basicPayInfo.payStatus == 3 || basicPayInfo.payStatus == 5 || basicPayInfo.payStatus == 7) {
                    hashMap.put("pay_status_subtitle", basicPayInfo.payStatusSubtitle);
                }
                xESimpleReqParams.bizParams = new HashMap();
                xESimpleReqParams.bizParams.put("oid", CarOrderHelper.getOrderId());
                xESimpleReqParams.bizParams.put("version", Integer.valueOf(MessageBarPresenter.this.f14621v));
                xESimpleReqParams.bizParams.put("args", hashMap);
                xESimpleReqParams.bizParams.put("trip_state", Integer.valueOf(MessageBarPresenter.this.f14602G));
                MessageBarPresenter.this.doPublish(BaseEventKeys.XEngine.EVENT_XENGINE_SIMPLE_REQUEST, xESimpleReqParams);
            }
        }
    };
    protected Logger mLogger = LoggerFactory.getLogger(getClass());
    protected XEResponseCallback mXELogicCallbackMapInfo = new XEResponseCallback() {
        public void onFailed(String str, EngineErrorException engineErrorException) {
        }

        public void onSuccess(String str, XEngineData xEngineData, List<XEComponent> list) {
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: p */
    public String f14619p = "";
    /* access modifiers changed from: private */

    /* renamed from: u */
    public int f14620u = -1;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public int f14621v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public long f14622w = 0;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public boolean f14623x = false;

    /* renamed from: y */
    private CountDownTimer f14624y;

    /* renamed from: z */
    private Timer f14625z;

    /* access modifiers changed from: private */
    /* renamed from: c */
    public Map<String, Object> m10387c() {
        this.mLogger.info("lmf>>>>>>buildEtaEdaArgus>>>>>>>>", new Object[0]);
        HashMap hashMap = new HashMap();
        hashMap.put("eta", f14590m);
        hashMap.put("eda", f14591n);
        if (this.f14601F) {
            hashMap.put("message_text_color_change", 1);
        }
        if (!TextUtils.isEmpty(this.f14604I)) {
            hashMap.put("exter_title", this.f14604I);
        }
        return hashMap;
    }

    /* renamed from: a */
    private LEGORichInfo m10371a(LEGORichInfo lEGORichInfo, int i, int i2, String str, String str2) {
        if (lEGORichInfo != null) {
            String content = lEGORichInfo.getContent();
            if (!TextUtils.isEmpty(content)) {
                content.length();
            }
            int indexOf = content.indexOf(str);
            int length = str.length();
            int indexOf2 = content.indexOf(str2);
            int length2 = str2.length();
            List<LEGORichInfo.RichInfo> infoList = lEGORichInfo.getInfoList();
            if (infoList != null && infoList.size() > 0) {
                for (LEGORichInfo.RichInfo next : infoList) {
                    if (next.start == i) {
                        next.start = indexOf;
                        next.length = length;
                    }
                    if (next.start == i2) {
                        next.start = indexOf2;
                        next.length = length2;
                    }
                }
            }
        }
        return lEGORichInfo;
    }

    public void updateEtaEda() {
        if (!TextUtils.isEmpty(this.f14619p)) {
            try {
                XpTemplateMsgModel xpTemplateMsgModel = (XpTemplateMsgModel) new Gson().fromJson(this.f14619p, XpTemplateMsgModel.class);
                if (xpTemplateMsgModel != null) {
                    xpTemplateMsgModel.parseExtension(new JsonParser().parse(this.f14619p).getAsJsonObject());
                    if (xpTemplateMsgModel.normal.data != null) {
                        if (xpTemplateMsgModel.normal.data.subtitle != null) {
                            xpTemplateMsgModel.normal.data.subtitleKey = GSonUtil.jsonFromObject(xpTemplateMsgModel.normal.data.subtitle);
                        }
                        if (xpTemplateMsgModel.normal.data.title != null && xpTemplateMsgModel.normal.data.title_type == 6) {
                            String content = xpTemplateMsgModel.normal.data.title.getContent();
                            if (!content.contains(f14590m)) {
                                if (!content.contentEquals(f14591n)) {
                                    return;
                                }
                            }
                            if (this.f14608M == -1 || this.f14609N == -1 || this.f14608M == 0 || this.f14609N == 0) {
                                xpTemplateMsgModel.normal.data.title.setText("");
                                if (TextUtils.isEmpty(xpTemplateMsgModel.normal.data.subtitle.getContent())) {
                                    return;
                                }
                            } else {
                                if (this.f14608M < 1) {
                                    this.f14608M = 1;
                                }
                                if (this.f14609N < 100) {
                                    this.f14609N = 100;
                                }
                                int indexOf = content.indexOf(f14590m);
                                int indexOf2 = content.indexOf(f14591n);
                                String formatCountdownTime = Elvish.Companion.getInstance().formatCountdownTime(this.f14608M * 60, false);
                                String formatDistance = Elvish.Companion.getInstance().formatDistance((double) this.f14609N, DistanceStyle.KM, 1, false);
                                xpTemplateMsgModel.normal.data.title.setText(content.replace(f14590m, formatCountdownTime).replace(f14591n, formatDistance));
                                m10371a(xpTemplateMsgModel.normal.data.title, indexOf, indexOf2, formatCountdownTime, formatDistance);
                            }
                            String jsonFromObject = GSonUtil.jsonFromObject(xpTemplateMsgModel.normal.data.title);
                            GLog.m7965d("lxslxs", jsonFromObject);
                            xpTemplateMsgModel.normal.data.titleKey = jsonFromObject;
                            xpTemplateMsgModel.normal.isNeedAnim = true;
                            doPublish(BaseEventKeys.NewXpanel.EVENT_XPANEL_NEW_ADD_COMMON_MSG, xpTemplateMsgModel);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public MessageBarPresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m10377a(XpTemplateMsgModel.MsgTemplateNormal msgTemplateNormal) {
        if (msgTemplateNormal != null && msgTemplateNormal.data != null && (msgTemplateNormal.data.title_type == 4 || msgTemplateNormal.data.subtitle_type == 4)) {
            return true;
        }
        if (msgTemplateNormal == null || msgTemplateNormal.data == null) {
            return false;
        }
        if (msgTemplateNormal.data.title_type == 5 || msgTemplateNormal.data.subtitle_type == 5) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10374a(XpTemplateMsgModel xpTemplateMsgModel) {
        if (xpTemplateMsgModel != null && xpTemplateMsgModel.normal != null && xpTemplateMsgModel.normal.data != null) {
            this.f14596A = null;
            this.f14597B = null;
            this.f14598C = null;
            this.f14599D = true;
            if (xpTemplateMsgModel.normal.data.title_type == 4) {
                this.f14597B = m10370a(xpTemplateMsgModel.normal.data.title);
            }
            if (xpTemplateMsgModel.normal.data.subtitle_type == 4) {
                this.f14598C = m10370a(xpTemplateMsgModel.normal.data.subtitle);
            }
            if (xpTemplateMsgModel.normal.data.title_type == 5) {
                this.f14597B = m10383b(xpTemplateMsgModel.normal.data.title);
            }
            if (xpTemplateMsgModel.normal.data.subtitle_type == 5) {
                this.f14598C = m10383b(xpTemplateMsgModel.normal.data.subtitle);
            }
            if (this.f14597B != null || this.f14598C != null) {
                this.f14596A = xpTemplateMsgModel;
                if (this.f14597B != null) {
                    XpTemplateMsgModel.MsgTemplateData msgTemplateData = xpTemplateMsgModel.normal.data;
                    msgTemplateData.titleKey = this.f14597B.prefix + this.f14597B.suffix;
                }
                if (this.f14598C != null) {
                    XpTemplateMsgModel.MsgTemplateData msgTemplateData2 = this.f14596A.normal.data;
                    msgTemplateData2.subtitleKey = this.f14598C.prefix + this.f14598C.suffix;
                }
                CountDownModel countDownModel = this.f14597B;
                int i = 0;
                int abs = countDownModel == null ? 0 : Math.abs(countDownModel.countBeginTime - this.f14597B.countEndTime);
                CountDownModel countDownModel2 = this.f14598C;
                if (countDownModel2 != null) {
                    i = Math.abs(countDownModel2.countBeginTime);
                }
                m10373a(Math.max(abs, i));
            }
        }
    }

    /* renamed from: a */
    private CountDownModel m10370a(LEGORichInfo lEGORichInfo) {
        List<LEGORichInfo.RichInfo> infoList;
        if (lEGORichInfo == null) {
            return null;
        }
        String content = lEGORichInfo.getContent();
        int indexOf = content.indexOf(f14586i);
        int lastIndexOf = content.lastIndexOf(f14587j);
        if (indexOf < 0 || lastIndexOf <= indexOf) {
            return null;
        }
        int a = m10368a(content.substring(indexOf + 3, lastIndexOf));
        String substring = content.substring(0, indexOf);
        int i = lastIndexOf + 3;
        String substring2 = i < content.length() ? content.substring(i, content.length()) : "";
        int i2 = (lastIndexOf - indexOf) + 3;
        if (!(i2 == 6 || (infoList = lEGORichInfo.getInfoList()) == null || infoList.size() <= 0)) {
            int i3 = i2 - 6;
            for (LEGORichInfo.RichInfo next : infoList) {
                if (next.start >= lastIndexOf) {
                    next.start -= i3;
                } else if (next.start + next.length > indexOf) {
                    next.length -= i3;
                }
            }
        }
        this.mLogger.info("lmf", ">>>>>>>>createCountDownModel>>>>>>>>" + indexOf + ":" + lastIndexOf);
        return new CountDownModel(lEGORichInfo, a, substring, substring2, 0, 0);
    }

    /* renamed from: b */
    private CountDownModel m10383b(LEGORichInfo lEGORichInfo) {
        List<LEGORichInfo.RichInfo> infoList;
        if (lEGORichInfo == null) {
            return null;
        }
        String content = lEGORichInfo.getContent();
        int indexOf = content.indexOf(f14588k);
        int lastIndexOf = content.lastIndexOf(f14589l);
        int indexOf2 = content.indexOf("|");
        if (indexOf < 0 || lastIndexOf <= indexOf) {
            return null;
        }
        String substring = content.substring(indexOf + 3, indexOf2);
        String substring2 = content.substring(indexOf2 + 1, lastIndexOf);
        int a = m10368a(substring);
        int a2 = m10368a(substring2);
        String substring3 = content.substring(0, indexOf);
        int i = lastIndexOf + 3;
        String substring4 = i < content.length() ? content.substring(i) : "";
        int i2 = (lastIndexOf - indexOf) + 3;
        if (!(i2 == 6 || (infoList = lEGORichInfo.getInfoList()) == null || infoList.size() <= 0)) {
            int i3 = i2 - 6;
            for (LEGORichInfo.RichInfo next : infoList) {
                if (next.start >= lastIndexOf) {
                    next.start -= i3;
                } else if (next.start + next.length > indexOf) {
                    next.length -= i3;
                }
            }
        }
        return new CountDownModel(lEGORichInfo, a, substring3, substring4, 1, a2);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m10392d() {
        CountDownTimer countDownTimer = this.f14624y;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    /* renamed from: a */
    private void m10373a(int i) {
        final int i2 = i;
        this.f14624y = new CountDownTimer((long) (i * 1000), 1000) {
            public void onTick(long j) {
                if (MessageBarPresenter.this.f14599D) {
                    MessageBarPresenter messageBarPresenter = MessageBarPresenter.this;
                    messageBarPresenter.m10376a(messageBarPresenter.f14599D);
                    boolean unused = MessageBarPresenter.this.f14599D = false;
                    return;
                }
                MessageBarPresenter messageBarPresenter2 = MessageBarPresenter.this;
                messageBarPresenter2.m10376a(messageBarPresenter2.f14599D);
            }

            public void onFinish() {
                MessageBarPresenter.this.m10376a(false);
                if (i2 > 0) {
                    MessageBarPresenter.this.m10396e();
                }
            }
        }.start();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10376a(boolean z) {
        XpTemplateMsgModel xpTemplateMsgModel = this.f14596A;
        if (xpTemplateMsgModel != null && xpTemplateMsgModel.normal != null && this.f14596A.normal.data != null) {
            boolean z2 = false;
            CountDownModel countDownModel = this.f14597B;
            boolean z3 = true;
            if (countDownModel != null && countDownModel.isNeedUpdate()) {
                this.f14597B.updateTextInt();
                this.f14596A.normal.data.title = this.f14597B.info;
                this.f14597B.countDown();
                z2 = true;
            }
            CountDownModel countDownModel2 = this.f14598C;
            if (countDownModel2 == null || !countDownModel2.isNeedUpdate()) {
                z3 = z2;
            } else {
                this.f14598C.updateTextInt();
                this.f14596A.normal.data.subtitle = this.f14598C.info;
                this.f14598C.countDown();
            }
            if (z3) {
                this.f14596A.normal.isNeedAnim = z;
                doPublish(BaseEventKeys.NewXpanel.EVENT_XPANEL_NEW_ADD_COMMON_MSG, this.f14596A);
            }
        }
    }

    /* renamed from: a */
    private int m10368a(String str) {
        try {
            return Integer.valueOf(str).intValue();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m10396e() {
        this.f14605J.removeMessages(3);
        Message obtain = Message.obtain();
        obtain.what = 3;
        this.f14605J.sendMessageDelayed(obtain, 100);
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        this.f14602G = 0;
        this.f14621v = 1;
        f14592q = (long) ((Integer) ApolloUtil.getParam("GR_MESSAGE_UPDATE_INTERVAL", "time", 10)).intValue();
        Logger logger = this.mLogger;
        logger.info("lmf>>>>>>>>etaInterval>>>>>>>" + f14592q + ",version:" + this.f14621v, new Object[0]);
        XERegisterModel xERegisterModel = new XERegisterModel(XERequestKey.REQUEST_KEY_MESSAGE, XERequestKey.SCENE_TRIP, this.f14610O);
        xERegisterModel.required = true;
        xERegisterModel.requestParams = new XEReqParamsCallback() {
            public Object getRequestParams() {
                HashMap hashMap = new HashMap();
                hashMap.put("oid", CarOrderHelper.getOrderId());
                hashMap.put("version", Integer.valueOf(MessageBarPresenter.this.f14621v));
                hashMap.put("args", MessageBarPresenter.this.m10387c());
                hashMap.put("trip_state", Integer.valueOf(MessageBarPresenter.this.f14602G));
                return hashMap;
            }
        };
        XERegister.registerTemplate(xERegisterModel);
        XERegisterModel xERegisterModel2 = new XERegisterModel(XERequestKey.REQUEST_KEY_MAP_INFO, XERequestKey.SCENE_TRIP, this.mXELogicCallbackMapInfo);
        xERegisterModel2.requestParams = new XEReqParamsCallback() {
            public Object getRequestParams() {
                HashMap hashMap = new HashMap();
                hashMap.put("oid", CarOrderHelper.getOrderId());
                hashMap.put("version", Integer.valueOf(MessageBarPresenter.this.f14621v));
                hashMap.put("args", MessageBarPresenter.this.m10387c());
                return hashMap;
            }
        };
        XERegister.registerTemplate(xERegisterModel2);
        subscribe(BaseEventKeys.Trip.EVENT_DRIVER_ETA_EDA, this.f14616f);
        subscribe(BaseEventKeys.Trip.EVENT_TRIP_STATE, this.f14615e);
        subscribe(BaseEventKeys.OnService.EVENT_STATUS_PASSENGER_LATE, this.f14611a);
        subscribe(BaseEventKeys.Service.EndService.EVENT_BASIC_PAY_INFO, this.f14618h);
        subscribe("event_sctx_state_change", this.f14617g);
        subscribe(BaseEventKeys.Service.EVENT_WAY_POINT_CHANGED_RECEIVED, this.f14612b);
        subscribe(BaseEventKeys.CarPool.EVENT_CAR_POOL_PEOPLE_INFOS_CHANGE, this.f14606K);
        subscribe(BaseEventKeys.MessageBar.EVENT_MESSAGE_BAR_STOP_TIMER, this.f14607L);
        subscribe(BaseEventKeys.OnService.EVENT_STATUS_NEAR_DROPOFF_ETA, this.f14603H);
        subscribe("event_sctx_state_change", this.f14613c);
        subscribe(BaseEventKeys.OnService.EVENT_MAP_ROUTE_DESCRIBE, this.f14614d);
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        this.f14602G = 0;
        XERegister.unregisterTemplate(XERequestKey.REQUEST_KEY_MESSAGE);
        XERegister.unregisterCallback(XERequestKey.REQUEST_KEY_MAP_INFO, this.mXELogicCallbackMapInfo);
        unsubscribe(BaseEventKeys.Trip.EVENT_DRIVER_ETA_EDA, this.f14616f);
        unsubscribe(BaseEventKeys.Trip.EVENT_TRIP_STATE, this.f14615e);
        unsubscribe(BaseEventKeys.OnService.EVENT_STATUS_PASSENGER_LATE, this.f14611a);
        unsubscribe(BaseEventKeys.Service.EndService.EVENT_BASIC_PAY_INFO, this.f14618h);
        unsubscribe("event_sctx_state_change", this.f14617g);
        unsubscribe(BaseEventKeys.Service.EVENT_WAY_POINT_CHANGED_RECEIVED, this.f14612b);
        unsubscribe(BaseEventKeys.CarPool.EVENT_CAR_POOL_PEOPLE_INFOS_CHANGE, this.f14606K);
        unsubscribe(BaseEventKeys.MessageBar.EVENT_MESSAGE_BAR_STOP_TIMER, this.f14607L);
        unsubscribe(BaseEventKeys.OnService.EVENT_STATUS_NEAR_DROPOFF_ETA, this.f14603H);
        this.f14605J.removeMessages(3);
        m10392d();
        unsubscribe("event_sctx_state_change", this.f14613c);
        unsubscribe(BaseEventKeys.OnService.EVENT_MAP_ROUTE_DESCRIBE, this.f14614d);
    }
}
