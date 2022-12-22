package com.didichuxing.xpanel.agent;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.global.globalgenerickit.CommonEventListener;
import com.didi.global.globalgenerickit.GGKData;
import com.didi.global.globalgenerickit.GGKView;
import com.didi.global.globalgenerickit.GGKViewBinder;
import com.didi.global.globalgenerickit.GlobalGenericKit;
import com.didi.global.globalgenerickit.template.yoga.CDNTemplateBinder;
import com.didi.soda.compose.card.BaseCard;
import com.didichuxing.xpanel.agent.net.ResponseListener;
import com.didichuxing.xpanel.agent.net.XPanelAgentData;
import com.didichuxing.xpanel.agent.net.XPanelRequest;
import com.didichuxing.xpanel.agent.net.XPanelResponse;
import com.didichuxing.xpanel.agent.net.XPanelUpdateResponse;
import com.didichuxing.xpanel.base.CommonXPanelChildView;
import com.didichuxing.xpanel.base.IXPanelDataPrivate;
import com.didichuxing.xpanel.base.XPanelCardData;
import com.didichuxing.xpanel.log.ExtensionLogHelper;
import com.didichuxing.xpanel.log.MisLogHelper;
import com.didichuxing.xpanel.models.IXPanelModel;
import com.didichuxing.xpanel.models.ModelsFactory;
import com.didichuxing.xpanel.models.XPanelYogaModel;
import com.didichuxing.xpanel.util.DomUtil;
import com.didichuxing.xpanel.util.LogcatUtil;
import com.didichuxing.xpanel.util.Utils;
import com.didichuxing.xpanel.util.XPanelApolloUtil;
import com.didichuxing.xpanel.util.XPanelOmegaUtils;
import com.didichuxing.xpanel.xcard.ICardListener;
import com.didichuxing.xpanel.xcard.ParseHelper;
import com.didichuxing.xpanel.xcard.TemplateParser;
import com.didichuxing.xpanel.xcard.XCardNode;
import com.didichuxing.xpanel.xcard.XCardRenderer;
import com.didichuxing.xpanel.xcard.XCardXmlInfo;
import com.didichuxing.xpanel.xcard.XPanelCardDataHelper;
import com.didichuxing.xpanel.xcard.loader.IXMLLoaderTrackCallback;
import com.didichuxing.xpanel.xcard.loader.IXMLoaderCallback;
import com.didichuxing.xpanel.xcard.loader.XCardManager;
import com.didichuxing.xpanel.xcard.loader.XMLCacheEntity;
import com.didichuxing.xpanel.xcard.view.XPanelCardWrapper;
import com.didichuxing.xpanel.xcard.view.recyclerview.XPanelHorizontalRecyclerView;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.taxis99.R;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;
import org.w3c.dom.Element;

public class XPanelDataSource implements IXPanelDataSource, IXPanelDataPrivate, IXMLoaderCallback {

    /* renamed from: a */
    private static final String f49277a = "XPanelDataSource";

    /* renamed from: b */
    private static final String f49278b = "global_xpanel";

    /* renamed from: c */
    private ParseHelper f49279c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public IXPanelAgentListener f49280d;

    /* renamed from: e */
    private IAgentCallBack f49281e;

    /* renamed from: f */
    private Object f49282f;

    /* renamed from: g */
    private IXPanelAgentClickListener f49283g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f49284h;

    /* renamed from: i */
    private boolean f49285i = false;

    /* renamed from: j */
    private Runnable f49286j = null;

    /* renamed from: k */
    private HashMap<String, Object> f49287k = null;

    /* renamed from: l */
    private String f49288l;

    /* renamed from: m */
    private boolean f49289m = false;
    protected ArrayList mAgentList = new ArrayList();
    protected Context mContext;
    protected Handler mHandler = new Handler();
    protected ArrayList<XPanelCardData> mServiceList = new ArrayList<>();
    protected XCardManager mXCardManager;
    protected int mXpanelMargin;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public String f49290n;

    /* renamed from: o */
    private HashMap<String, Object> f49291o;

    /* renamed from: p */
    private long f49292p;

    /* renamed from: q */
    private ICardListener f49293q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public Runnable f49294r = new Runnable() {
        public void run() {
            LogcatUtil.m35796i(XPanelDataSource.f49277a, "执行延时任务");
            XPanelDataSource.this.prepareToNotifyList();
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: s */
    public Runnable f49295s = new Runnable() {
        public void run() {
            LogcatUtil.m35796i(XPanelDataSource.f49277a, "执行延时任务");
            XPanelDataSource.this.m35541a();
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: t */
    public String f49296t;

    /* renamed from: u */
    private String f49297u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public boolean f49298v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public ArrayList<XPanelAgentData> f49299w = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: x */
    public ArrayList<XPanelAgentData> f49300x = new ArrayList<>();

    /* renamed from: y */
    private boolean f49301y;

    public XPanelDataSource(Context context, boolean z) {
        this.mContext = context;
        this.f49289m = z;
        XCardManager instance = XCardManager.getInstance();
        this.mXCardManager = instance;
        instance.setLeftRightMargin(this.mXpanelMargin);
        File cacheDir = context.getCacheDir();
        if (cacheDir != null) {
            XCardManager.setCacheFilePath(cacheDir.getPath());
        }
        if (XPanelApolloUtil.getStatus("xpanel_agentV3_switch")) {
            XPanelRequest.getInstance(context);
            XPanelRequest.isV3 = true;
        }
        this.f49301y = XPanelApolloUtil.isGenericKitEnable();
    }

    public void notifyServiceCards(List<XPanelCardData> list) {
        notifyServiceCards(list, true);
    }

    /* renamed from: a */
    private void m35544a(XPanelAgentData xPanelAgentData, XPanelCardData xPanelCardData) {
        xPanelCardData.dataJson = xPanelAgentData.data;
        MisLogHelper.parseExtension(xPanelAgentData.extension, xPanelCardData);
        ExtensionLogHelper.parseExtension(xPanelAgentData.extension, xPanelCardData);
    }

    public void notifyServiceCards(List<XPanelCardData> list, boolean z) {
        boolean z2 = (this.mServiceList.size() > 0) | false;
        this.mServiceList.clear();
        for (int i = 0; i < list.size(); i++) {
            reBuildXCardData(list.get(i));
        }
        if (list != null && list.size() > 0) {
            z2 |= this.mServiceList.addAll(list);
        }
        if (!z2) {
            return;
        }
        if (z) {
            notifyShowList();
        } else {
            this.f49284h = true;
        }
    }

    /* access modifiers changed from: protected */
    public void reBuildXCardData(XPanelCardData xPanelCardData) {
        if (xPanelCardData != null) {
            T t = xPanelCardData.object;
            if ((t instanceof XCardXmlInfo) && xPanelCardData.content == null) {
                XCardXmlInfo xCardXmlInfo = (XCardXmlInfo) t;
                Element parseXML = DomUtil.parseXML(xCardXmlInfo.xml);
                if (parseXML != null) {
                    AgentXCardListener agentXCardListener = new AgentXCardListener();
                    XPanelAgentData xPanelAgentData = new XPanelAgentData();
                    xPanelAgentData.f49304id = xPanelCardData.f49329id;
                    xPanelAgentData.extension = new JSONObject();
                    try {
                        xPanelAgentData.extension.put("act_id", xPanelCardData.getOmegaParams((Map<String, Object>) null).get("act_id"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    View a = m35537a(xPanelAgentData, parseXML, xCardXmlInfo.data, agentXCardListener, xPanelCardData.mTemplate);
                    if (a != null) {
                        xPanelCardData.content = new CommonXPanelChildView(a);
                        agentXCardListener.bindXCardData(xPanelCardData);
                        attachCardData2ChildView(a, xPanelCardData);
                    }
                }
            }
        }
    }

    public void reloadAgent(String str, HashMap<String, Object> hashMap, boolean z) {
        reloadAgent(false, str, hashMap, z, (AgentRequestCallBack) null);
    }

    public void reloadByCardIds(String[] strArr, HashMap<String, Object> hashMap) {
        if (strArr != null && strArr.length != 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < strArr.length; i++) {
                if (!TextUtils.isEmpty(strArr[i])) {
                    sb.append(",");
                    sb.append(strArr[i]);
                }
            }
            String sb2 = sb.toString();
            if (sb2.length() > 1) {
                String substring = sb2.substring(1, sb2.length());
                String str = this.f49296t;
                LogcatUtil.m35796i(f49277a, "单刷接口currentdimension：" + str);
                hashMap.put(BaseCard.KEY_CARD_ID, substring);
                hashMap.put("dimensions", str);
                XPanelRequest.getInstance(this.mContext).queryUpdate(hashMap, new XResponseUpdate(str), new XPanelUpdateResponse(str));
            }
        }
    }

    public void reloadAgent(boolean z, String str, HashMap<String, Object> hashMap, boolean z2, AgentRequestCallBack agentRequestCallBack) {
        if (z2) {
            this.f49299w.clear();
            this.f49300x.clear();
            if (this.mAgentList.size() > 0) {
                m35557c();
                notifyShowList();
                LogcatUtil.m35795e(f49277a, "强制清空agenet卡片 去掉内存缓存");
                this.f49290n = "";
            }
        }
        this.f49288l = str;
        this.f49287k = hashMap;
        m35549a(z || z2, str, hashMap, agentRequestCallBack);
    }

    public String getCurrentDimension() {
        return this.f49296t;
    }

    public void destroy() {
        this.f49279c = null;
        this.mHandler.removeCallbacks(this.f49295s);
        this.mHandler.removeCallbacks(this.f49294r);
        this.mXCardManager.unBindIXMLoaderCallback(f49278b);
        this.mXCardManager.setLeftRightMargin(0);
    }

    public void testResult(String str, String str2) {
        XPanelResponse xPanelResponse = new XPanelResponse(str2);
        xPanelResponse.parse(str);
        this.f49296t = str2;
        new XResponseListener((AgentRequestCallBack) null, str2).onSuccess(xPanelResponse);
    }

    public void onResume() {
        this.f49285i = true;
        Runnable runnable = this.f49286j;
        if (runnable != null) {
            this.mHandler.post(runnable);
            this.f49286j = null;
        }
    }

    public void onPause() {
        this.f49285i = false;
    }

    /* renamed from: a */
    private XPanelCardData m35539a(XPanelAgentData xPanelAgentData, Element element, String str) {
        String str2 = xPanelAgentData.template;
        String str3 = xPanelAgentData.f49304id;
        JSONObject jSONObject = xPanelAgentData.data;
        JSONObject jSONObject2 = xPanelAgentData.extension;
        AgentXCardListener agentXCardListener = new AgentXCardListener();
        View a = m35537a(xPanelAgentData, element, jSONObject, agentXCardListener, str2);
        ScriptableObject scriptableObject = null;
        if (a == null) {
            return null;
        }
        XPanelYogaModel xPanelYogaModel = new XPanelYogaModel(str2);
        xPanelYogaModel.bindExtension(jSONObject2);
        if (!TextUtils.isEmpty(str)) {
            org.mozilla.javascript.Context enter = org.mozilla.javascript.Context.enter();
            scriptableObject = enter.initSafeStandardObjects();
            ScriptableObject.putProperty((Scriptable) scriptableObject, "xpJsTool", org.mozilla.javascript.Context.javaToJS(this.f49282f, scriptableObject));
            enter.evaluateString(scriptableObject, str, str2, 1, (Object) null);
        }
        XPanelCardData build = new XPanelCardData.Builder().view(a).object(xPanelYogaModel).mo121493id(str3).template(str2).jsScope(scriptableObject).build();
        agentXCardListener.bindXCardData(build);
        attachCardData2ChildView(a, build);
        return build;
    }

    /* renamed from: a */
    private View m35537a(XPanelAgentData xPanelAgentData, Element element, Object obj, AgentXCardListener agentXCardListener, String str) {
        agentXCardListener.bindXCardListener(this.f49293q);
        agentXCardListener.bindAgentClickListener(this.f49283g);
        XCardNode parse = new TemplateParser().parse(element, obj);
        if (parse == null) {
            return null;
        }
        XCardRenderer xCardRenderer = new XCardRenderer(this.mContext, this.mXpanelMargin, xPanelAgentData);
        xCardRenderer.bindXCardListener(agentXCardListener);
        View render = xCardRenderer.render(parse);
        if (render == null) {
            return null;
        }
        return m35538a(str, render);
    }

    /* renamed from: a */
    private View m35538a(String str, View view) {
        XPanelCardWrapper xPanelCardWrapper = new XPanelCardWrapper(this.mContext);
        if (this.f49289m) {
            int i = -1;
            Drawable background = view.getBackground();
            if (background instanceof ColorDrawable) {
                i = ((ColorDrawable) background).getColor();
            }
            xPanelCardWrapper.setBackgroundColor(i);
        } else if ("new_travel_package".equals(str)) {
            setCardViewOutsideMargin(xPanelCardWrapper, view, 0, 0);
        } else if (view.getTag(R.id.outsideMargin) != null) {
            setCardViewOutsideMargin(xPanelCardWrapper, view, 0, 0);
        } else {
            xPanelCardWrapper.addView(m35553b());
            xPanelCardWrapper.setBackgroundResource(R.drawable.oc_x_panel_card_bg);
        }
        xPanelCardWrapper.setTag(R.id.itemId, XCardManager.XML_VIEW);
        xPanelCardWrapper.addView(view);
        return xPanelCardWrapper;
    }

    /* access modifiers changed from: protected */
    public ParseHelper getParseInstance() {
        if (this.f49279c == null) {
            ParseHelper parseHelper = new ParseHelper(this.mContext);
            this.f49279c = parseHelper;
            parseHelper.bindAgentClickListener(this.f49283g);
        }
        return this.f49279c;
    }

    /* renamed from: a */
    private void m35549a(boolean z, final String str, HashMap<String, Object> hashMap, AgentRequestCallBack agentRequestCallBack) {
        if (!TextUtils.isEmpty(str)) {
            if (hashMap == null) {
                hashMap = new HashMap<>();
            }
            HashMap<String, Object> hashMap2 = hashMap;
            this.f49296t = str;
            this.f49297u = (String) hashMap2.get("business_scene");
            StringBuilder sb = new StringBuilder();
            sb.append(hashCode());
            boolean z2 = true;
            sb.append(String.format(": 这次请求距离上次%s ms", new Object[]{Long.valueOf(System.currentTimeMillis() - this.f49292p)}));
            LogcatUtil.m35795e(f49277a, sb.toString());
            if (this.f49291o != null && this.f49292p != 0 && System.currentTimeMillis() - this.f49292p < 1000 && hashMap2.equals(this.f49291o)) {
                LogcatUtil.m35795e(f49277a, "同样参数的请求在1s内发出 不做请求");
                z2 = false;
            }
            this.f49291o = hashMap2;
            this.f49292p = System.currentTimeMillis();
            if (z2) {
                XPanelRequest.getInstance(this.mContext).getXPanelConfig(z, hashMap2, new XResponseListener(agentRequestCallBack, str), new XPanelResponse(str), new XPanelRequest.ISuccess() {
                    public boolean onSuccessAndIntercept(String str) {
                        if (!TextUtils.equals(str, XPanelDataSource.this.f49296t)) {
                            return true;
                        }
                        if (TextUtils.isEmpty(XPanelDataSource.this.f49290n) || !TextUtils.equals(str, XPanelDataSource.this.f49290n)) {
                            String unused = XPanelDataSource.this.f49290n = str;
                            return false;
                        }
                        LogcatUtil.m35795e(XPanelDataSource.f49277a, hashCode() + ": 二次请求的数据完全相同，不做刷新");
                        return true;
                    }
                });
            }
        }
    }

    public void bindICardListener(ICardListener iCardListener) {
        this.f49293q = iCardListener;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m35552a(ArrayList<XPanelAgentData> arrayList, boolean z, boolean z2) {
        int i;
        boolean z3 = true;
        if (this.f49301y) {
            return true;
        }
        if (arrayList == null) {
            i = 0;
        } else {
            i = arrayList.size();
        }
        for (int i2 = 0; i2 < i; i2++) {
            final XPanelAgentData xPanelAgentData = arrayList.get(i2);
            if (xPanelAgentData != null && !TextUtils.isEmpty(xPanelAgentData.f49304id)) {
                C165294 r4 = null;
                if (z) {
                    r4 = new IXMLLoaderTrackCallback() {
                        public void onLoadTrack(int i) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("url", xPanelAgentData.cdn);
                            hashMap.put("id", xPanelAgentData.f49304id);
                            hashMap.put("template", xPanelAgentData.template);
                            hashMap.put("status", Integer.valueOf(i));
                            XPanelOmegaUtils.trackEvent("xpanel_xml_cache", hashMap);
                        }
                    };
                }
                boolean prepareToBuildSingleCard = this.mXCardManager.prepareToBuildSingleCard(f49278b, xPanelAgentData.template, xPanelAgentData.cdn, z2, r4);
                LogcatUtil.m35794d(f49277a, "singleCompleted: " + prepareToBuildSingleCard);
                z3 &= prepareToBuildSingleCard;
            }
        }
        return z3;
    }

    public void onTaskComplete(boolean z) {
        if (this.mContext != null) {
            if (z) {
                if (m35552a(this.f49300x, true, true) && this.f49299w.size() > 0) {
                    m35541a();
                    this.mHandler.removeCallbacks(this.f49295s);
                }
            } else if (m35552a(this.f49299w, true, false) && this.f49299w.size() > 0) {
                LogcatUtil.m35796i(f49277a, "所有任务完成 准备Notify");
                prepareToNotifyList();
                this.mHandler.removeCallbacks(this.f49294r);
            }
        }
    }

    private class XResponseUpdate extends ResponseListener<XPanelUpdateResponse> {
        private String mUpdateDimension;

        private XResponseUpdate(String str) {
            this.mUpdateDimension = str;
        }

        public void onSuccess(XPanelUpdateResponse xPanelUpdateResponse) {
            super.onSuccess(xPanelUpdateResponse);
            if (XPanelDataSource.this.mContext != null) {
                if (!TextUtils.equals(this.mUpdateDimension, XPanelDataSource.this.f49296t)) {
                    LogcatUtil.m35795e(XPanelDataSource.f49277a, "Update Fail,currentDimension=" + XPanelDataSource.this.f49296t + ",updateDimension=" + this.mUpdateDimension);
                    return;
                }
                List<XPanelAgentData> resultList = xPanelUpdateResponse.getResultList();
                if (resultList == null || resultList.size() == 0) {
                    LogcatUtil.m35796i(XPanelDataSource.f49277a, "Update 没有返回list");
                    return;
                }
                XPanelDataSource.this.f49300x.addAll(resultList);
                XPanelDataSource xPanelDataSource = XPanelDataSource.this;
                if (xPanelDataSource.m35552a((ArrayList<XPanelAgentData>) xPanelDataSource.f49300x, false, true)) {
                    LogcatUtil.m35796i(XPanelDataSource.f49277a, "单刷接口 数据准备完毕 执行updateResponseToNotifyList()刷新，移除timer");
                    XPanelDataSource.this.m35541a();
                    XPanelDataSource.this.mHandler.removeCallbacks(XPanelDataSource.this.f49295s);
                    return;
                }
                LogcatUtil.m35796i(XPanelDataSource.f49277a, "单刷接口 数据准备未准备完毕存在cdn卡片 放置timer");
                XPanelDataSource.this.mHandler.postDelayed(XPanelDataSource.this.f49295s, (long) XPanelApolloUtil.getXPanelCdnTimeout());
            }
        }

        public void onFail(XPanelUpdateResponse xPanelUpdateResponse) {
            super.onFail(xPanelUpdateResponse);
            LogcatUtil.m35796i(XPanelDataSource.f49277a, "单刷接口fail");
        }
    }

    private class XResponseListener extends ResponseListener<XPanelResponse> {
        private AgentRequestCallBack mAgentRequestCallBack;
        private String mXResponseDimension;

        public XResponseListener(AgentRequestCallBack agentRequestCallBack, String str) {
            this.mAgentRequestCallBack = agentRequestCallBack;
            this.mXResponseDimension = str;
        }

        public void onError(XPanelResponse xPanelResponse) {
            super.onError(xPanelResponse);
            if (XPanelDataSource.this.f49280d != null) {
                XPanelDataSource.this.f49280d.loadError(xPanelResponse);
            }
            if (XPanelDataSource.this.f49284h) {
                XPanelDataSource.this.notifyShowList();
            }
            AgentRequestCallBack agentRequestCallBack = this.mAgentRequestCallBack;
            if (agentRequestCallBack != null) {
                agentRequestCallBack.onFail();
            }
        }

        public void onSuccess(XPanelResponse xPanelResponse) {
            super.onSuccess(xPanelResponse);
            if (XPanelDataSource.this.mContext != null && TextUtils.equals(XPanelDataSource.this.f49296t, this.mXResponseDimension)) {
                boolean unused = XPanelDataSource.this.f49298v = xPanelResponse.mSupportSort;
                XPanelDataSource.this.f49299w.clear();
                List<XPanelAgentData> resultList = xPanelResponse.getResultList();
                if (resultList != null) {
                    XPanelDataSource.this.f49299w.addAll(resultList);
                }
                XPanelDataSource xPanelDataSource = XPanelDataSource.this;
                if (xPanelDataSource.m35552a((ArrayList<XPanelAgentData>) xPanelDataSource.f49299w, false, false)) {
                    XPanelDataSource.this.prepareToNotifyList();
                    XPanelDataSource.this.mHandler.removeCallbacks(XPanelDataSource.this.f49294r);
                } else {
                    XPanelDataSource.this.mHandler.postDelayed(XPanelDataSource.this.f49294r, (long) XPanelApolloUtil.getXPanelCdnTimeout());
                }
                AgentRequestCallBack agentRequestCallBack = this.mAgentRequestCallBack;
                if (agentRequestCallBack != null) {
                    agentRequestCallBack.onSuccess();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m35541a() {
        boolean z;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = (ArrayList) this.f49300x.clone();
        this.f49300x.clear();
        for (int i = 0; i < arrayList2.size(); i++) {
            XPanelAgentData xPanelAgentData = (XPanelAgentData) arrayList2.get(i);
            if (!TextUtils.isEmpty(xPanelAgentData.view) || !(xPanelAgentData.data == null || xPanelAgentData.data.length() == 0)) {
                try {
                    m35547a((List) arrayList, xPanelAgentData);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        synchronized (this.mAgentList) {
            z = false;
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                XPanelCardData xPanelCardData = (XPanelCardData) arrayList.get(i2);
                int i3 = 0;
                while (true) {
                    if (i3 < this.mAgentList.size()) {
                        Object obj = this.mAgentList.get(i3);
                        if (obj != xPanelCardData) {
                            if ((obj instanceof XPanelCardData) && TextUtils.equals(((XPanelCardData) obj).f49329id, xPanelCardData.f49329id)) {
                                this.mAgentList.remove(obj);
                                this.mAgentList.add(i3, xPanelCardData);
                                z = true;
                                break;
                            }
                            i3++;
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        if (z) {
            notifyShowList();
        }
    }

    public void prepareToNotifyList() {
        LogcatUtil.m35796i(f49277a, "prepareToNotifyList begin mXPanelAgentListener=" + this.f49280d);
        ArrayList arrayList = (ArrayList) this.f49299w.clone();
        if (!this.f49301y) {
            this.f49299w.clear();
        }
        int size = arrayList.size();
        int i = 0;
        boolean z = this.mAgentList.size() > 0 || size > 0;
        ArrayList arrayList2 = new ArrayList();
        while (i < size) {
            XPanelAgentData xPanelAgentData = (XPanelAgentData) arrayList.get(i);
            try {
                if (!TextUtils.isEmpty(xPanelAgentData.template) || xPanelAgentData.data != null || TextUtils.isEmpty(xPanelAgentData.f49304id)) {
                    m35547a((List) arrayList2, xPanelAgentData);
                    i++;
                } else {
                    arrayList2.add(new SortData(xPanelAgentData.f49304id));
                    i++;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.mAgentList.clear();
        this.mAgentList.addAll(arrayList2);
        if (z) {
            m35548a(true);
        }
    }

    /* renamed from: a */
    private void m35547a(List list, XPanelAgentData xPanelAgentData) {
        XPanelCardData a;
        if (!TextUtils.isEmpty(xPanelAgentData.cdn)) {
            if (this.f49301y && XPanelApolloUtil.isXPanelCdnEnabled()) {
                GGKData parse = new GGKData().parse(xPanelAgentData.originalData);
                parse.setCDNCallback(new GGKData.CDNCallback() {
                    public void onCDNCached() {
                        XPanelDataSource.this.prepareToNotifyList();
                    }
                });
                parse.setEventListener(new CommonEventListener(parse) {
                    public boolean handleEvent(String str, String str2, Map<String, Object> map) {
                        Object obj = this.data.getExt().get("cardData");
                        if (obj instanceof XPanelCardData) {
                            ((XPanelCardData) obj).clickCardOmega((Map<String, Object>) null);
                        }
                        return super.handleEvent(str, str2, map);
                    }
                });
                GGKView createTemplateView = GlobalGenericKit.createTemplateView(this.mContext, parse);
                if (createTemplateView != null) {
                    View a2 = m35538a(xPanelAgentData.template, createTemplateView.getView());
                    XPanelYogaModel xPanelYogaModel = new XPanelYogaModel(xPanelAgentData.template);
                    xPanelYogaModel.bindExtension(xPanelAgentData.extension);
                    GGKViewBinder viewBinder = GlobalGenericKit.getViewBinder(parse);
                    if (viewBinder instanceof CDNTemplateBinder) {
                        XPanelCardData build = new XPanelCardData.Builder().view(a2).object(xPanelYogaModel).mo121493id(xPanelAgentData.f49304id).template(xPanelAgentData.template).jsScope(((CDNTemplateBinder) viewBinder).getJSScope()).build();
                        attachCardData2ChildView(a2, build);
                        m35544a(xPanelAgentData, build);
                        list.add(build);
                        parse.getExt().put("cardData", build);
                        return;
                    }
                } else {
                    return;
                }
            }
            XMLCacheEntity xMLCache = XCardManager.getInstance().getXMLCache(xPanelAgentData.cdn);
            if (xMLCache != null && (a = m35539a(xPanelAgentData, xMLCache.element, xMLCache.script)) != null) {
                m35544a(xPanelAgentData, a);
                list.add(a);
            }
        } else if (TextUtils.isEmpty(xPanelAgentData.view)) {
            IXPanelModel newTemplateData = ModelsFactory.get().newTemplateData(xPanelAgentData.template, xPanelAgentData.data, xPanelAgentData.extension);
            if (newTemplateData == null) {
                IXPanelAgentListener iXPanelAgentListener = this.f49280d;
                if (iXPanelAgentListener != null) {
                    XPanelCardData viewById = iXPanelAgentListener.getViewById(xPanelAgentData.f49304id, xPanelAgentData.template, xPanelAgentData.data, xPanelAgentData.extension);
                    StringBuilder sb = new StringBuilder();
                    sb.append("getCardFrom业务：id=");
                    sb.append(xPanelAgentData.f49304id);
                    sb.append(",card=");
                    sb.append(viewById);
                    sb.append(",card.content=");
                    sb.append(viewById == null ? "null" : viewById.content);
                    LogcatUtil.m35796i(f49277a, sb.toString());
                    if (viewById != null && viewById.content != null && viewById.content.getView() != null) {
                        m35544a(xPanelAgentData, viewById);
                        list.add(viewById);
                        return;
                    }
                    return;
                }
                return;
            }
            XPanelCardData build2 = new XPanelCardData.Builder().object(newTemplateData).template(xPanelAgentData.template).mo121493id(xPanelAgentData.f49304id).build();
            m35544a(xPanelAgentData, build2);
            list.add(build2);
        } else if (XPanelApolloUtil.isXPanelXCardV2Enabled()) {
            XPanelCardData a3 = m35539a(xPanelAgentData, DomUtil.parseXML(Base64.decode(xPanelAgentData.view, 0)), (String) null);
            if (a3 != null) {
                m35544a(xPanelAgentData, a3);
                list.add(a3);
            }
        } else {
            ParseHelper parseInstance = getParseInstance();
            parseInstance.setAgentData(xPanelAgentData);
            parseInstance.setInputStream(xPanelAgentData.view);
            parseInstance.setLeftRightMargin(this.mXpanelMargin);
            XPanelCardDataHelper xPanelCardDataHelper = new XPanelCardDataHelper();
            View parseXmlToView = parseInstance.parseXmlToView(xPanelCardDataHelper);
            if (parseXmlToView != null) {
                addToAgentList(xPanelAgentData, xPanelCardDataHelper, parseXmlToView, list);
            }
        }
    }

    private class SortData {

        /* renamed from: id */
        public String f49302id;

        public SortData(String str) {
            this.f49302id = str;
        }
    }

    /* access modifiers changed from: protected */
    public void addToAgentList(XPanelAgentData xPanelAgentData, XPanelCardDataHelper xPanelCardDataHelper, View view, List list) {
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        frameLayout.setTag(R.id.itemId, XCardManager.XML_VIEW);
        frameLayout.addView(view);
        if ("new_travel_package".equals(xPanelAgentData.template)) {
            setCardViewOutsideMargin(frameLayout, view, 0, 0);
        } else if (view.getTag(R.id.outsideMargin) != null) {
            setCardViewOutsideMargin(frameLayout, view, 0, 0);
        } else {
            frameLayout.addView(m35553b());
            frameLayout.setBackgroundResource(R.drawable.oc_x_panel_card_bg);
        }
        XPanelYogaModel xPanelYogaModel = new XPanelYogaModel(xPanelAgentData.template);
        xPanelYogaModel.bindExtension(xPanelAgentData.extension);
        XPanelCardData build = new XPanelCardData.Builder().object(xPanelYogaModel).view((View) frameLayout).mo121493id(xPanelAgentData.f49304id).template(xPanelAgentData.template).build();
        xPanelCardDataHelper.setCardData(build);
        attachCardData2ChildView(view, build);
        m35544a(xPanelAgentData, build);
        list.add(build);
    }

    /* renamed from: b */
    private ImageView m35553b() {
        ImageView imageView = new ImageView(this.mContext);
        imageView.setId(R.id.corn_mark);
        imageView.setImageResource(R.drawable.oc_x_panel_coin_mark);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.oc_x_panel_coin_mark_size);
        imageView.setLayoutParams(new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize));
        return imageView;
    }

    /* access modifiers changed from: protected */
    public void setCardViewOutsideMargin(FrameLayout frameLayout, View view, int i, int i2) {
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(-1, -2);
        layoutParams.leftMargin = i;
        layoutParams.rightMargin = i2;
        frameLayout.setLayoutParams(layoutParams);
        m35542a(view);
    }

    /* access modifiers changed from: protected */
    public void attachCardData2ChildView(View view, XPanelCardData xPanelCardData) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt instanceof XPanelHorizontalRecyclerView) {
                    ((XPanelHorizontalRecyclerView) childAt).setCardData(xPanelCardData.f49329id);
                }
            }
        }
    }

    /* renamed from: a */
    private void m35542a(View view) {
        View childAt;
        if ((view instanceof ViewGroup) && (childAt = ((ViewGroup) view).getChildAt(0)) != null && (childAt instanceof RecyclerView)) {
            RecyclerView recyclerView = (RecyclerView) childAt;
            recyclerView.setPadding(this.mXpanelMargin, 0, 0, 0);
            recyclerView.setClipToPadding(false);
        }
    }

    /* renamed from: c */
    private void m35557c() {
        this.mAgentList.clear();
    }

    public final void notifyShowList() {
        m35548a(false);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m35548a(boolean z) {
        if (!this.f49285i) {
            this.f49286j = new Runnable() {
                public void run() {
                    XPanelDataSource.this.m35548a(false);
                }
            };
            return;
        }
        this.f49286j = null;
        boolean z2 = false;
        this.f49284h = false;
        LogcatUtil.m35796i(f49277a, "notifyShowList: 执行了notifyShowList方法");
        ArrayList arrayList = (ArrayList) this.mAgentList.clone();
        ArrayList arrayList2 = new ArrayList();
        boolean z3 = true;
        if (this.f49298v) {
            ArrayList arrayList3 = (ArrayList) this.mServiceList.clone();
            if (!arrayList.isEmpty()) {
                for (int i = 0; i < arrayList.size(); i++) {
                    Object obj = arrayList.get(i);
                    if (obj instanceof XPanelCardData) {
                        arrayList2.add((XPanelCardData) obj);
                    } else if (obj instanceof SortData) {
                        int size = arrayList3.size();
                        int i2 = 0;
                        while (true) {
                            if (i2 >= size) {
                                break;
                            }
                            XPanelCardData xPanelCardData = (XPanelCardData) arrayList3.get(i2);
                            if (((SortData) obj).f49302id.equals(xPanelCardData.f49329id)) {
                                arrayList3.remove(i2);
                                arrayList2.add(xPanelCardData);
                                break;
                            }
                            i2++;
                        }
                    }
                }
                if (!arrayList3.isEmpty() && z) {
                    m35546a(arrayList, (ArrayList<XPanelCardData>) arrayList3);
                    arrayList2.clear();
                    z2 = true;
                }
            } else {
                arrayList2.addAll(arrayList3);
            }
            z3 = z2;
        }
        if (z3) {
            arrayList2.addAll(this.mServiceList);
            if (arrayList != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (next instanceof XPanelCardData) {
                        arrayList2.add((XPanelCardData) next);
                    }
                }
            }
        }
        IXPanelAgentListener iXPanelAgentListener = this.f49280d;
        if (iXPanelAgentListener != null) {
            iXPanelAgentListener.toShow(arrayList2);
        }
        IAgentCallBack iAgentCallBack = this.f49281e;
        if (iAgentCallBack != null) {
            iAgentCallBack.notify(arrayList2, z3);
        }
    }

    /* renamed from: a */
    private void m35546a(ArrayList arrayList, ArrayList<XPanelCardData> arrayList2) {
        if (arrayList2 != null && !arrayList2.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            Iterator<XPanelCardData> it = arrayList2.iterator();
            while (it.hasNext()) {
                sb.append(it.next().f49329id);
                sb.append(",");
            }
            sb.deleteCharAt(sb.length() - 1);
            if (!Utils.isDebug(this.mContext)) {
                StringBuilder sb2 = new StringBuilder();
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    Object next = it2.next();
                    if (next instanceof SortData) {
                        sb2.append(((SortData) next).f49302id);
                        sb2.append(",");
                    }
                }
                sb2.deleteCharAt(sb2.length() - 1);
                HashMap hashMap = new HashMap();
                hashMap.put("miss_cards", sb.toString());
                hashMap.put("all_service_cards", sb2.toString());
                hashMap.put("business_scene", this.f49297u);
                OmegaSDKAdapter.trackEvent("gp_xpanel_cardnumber_error", (Map<String, Object>) hashMap);
                return;
            }
            throw new IllegalStateException("后端未下发必须主体卡片：[ " + sb.toString() + " ]");
        }
    }

    /* renamed from: a */
    private void m35545a(XPanelCardData xPanelCardData, boolean z) {
        xPanelCardData.isSortMain = z;
    }

    public void bindAgentClickListener(IXPanelAgentClickListener iXPanelAgentClickListener) {
        this.f49283g = iXPanelAgentClickListener;
    }

    public void setXPanelAgentListener(IXPanelAgentListener iXPanelAgentListener) {
        this.f49280d = iXPanelAgentListener;
    }

    public void reload() {
        HashMap<String, Object> hashMap;
        String str = this.f49288l;
        if (str != null && (hashMap = this.f49287k) != null) {
            reloadAgent(str, hashMap, true);
        }
    }

    public void setAgentCallBack(IAgentCallBack iAgentCallBack) {
        this.f49281e = iAgentCallBack;
    }

    public void setXpanelJsTool(Object obj) {
        this.f49282f = obj;
    }

    public void removeAgentCard(XPanelCardData xPanelCardData) {
        if (this.mAgentList.remove(xPanelCardData)) {
            notifyShowList();
        }
    }

    public void onBackHome() {
        this.mXCardManager.bindIXMLoaderCallback(f49278b, this);
    }

    public void onLeaveHome() {
        this.mXCardManager.unBindIXMLoaderCallback(f49278b);
    }

    public void onCreate() {
        this.mXCardManager.bindIXMLoaderCallback(f49278b, this);
    }
}
