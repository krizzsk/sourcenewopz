package com.didiglobal.xbanner;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.didi.component.business.xengine.XERequestKey;
import com.didi.global.xbanner.utils.XBannerUtil;
import com.didi.global.xbanner.view.base.ExpandViewCallback;
import com.didi.global.xbanner.view.base.XBannerView;
import com.didi.global.xbanner.view.recycler.XBannerItemBean;
import com.didi.global.xbanner.view.recycler.XBannerScrollChangedListener;
import com.didi.soda.compose.card.BaseCard;
import com.didichuxing.foundation.rpc.RpcService;
import com.didiglobal.enginecore.constant.XEngineConst;
import com.didiglobal.enginecore.data.parser.XEParseConst;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.didiglobal.xbanner.cache.XBannerCache;
import com.didiglobal.xbanner.net.XBannerRequest;
import com.didiglobal.xbanner.net.model.BizParams;
import com.didiglobal.xbanner.template.mdel.XBannerCDNData;
import com.didiglobal.xbanner.template.mdel.XBannerExtension;
import com.didiglobal.xbanner.template.mdel.XBannerUIConfig;
import com.didiglobal.xbanner.template.mdel.expand.XBannerExpandModel;
import com.didiglobal.xbanner.template.mdel.normal.XBannerNormalModel;
import com.didiglobal.xbanner.template.view.XBannerExpandView;
import com.didiglobal.xbanner.template.view.XBannerNativeView;
import com.didiglobal.xbanner.template.view.XBannerNormalView;
import com.didiglobal.xbanner.template.yoga.template.XBannerCDNView;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class XBanner implements XBannerScrollChangedListener {
    public static final String XB_CARDID_KEY = "xb_card_id";
    public static final String XB_EXTENSION_KEY = "xb_extension";
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Context f51462a;

    /* renamed from: b */
    private XBannerView f51463b;

    /* renamed from: c */
    private Map<String, XBannerNativeView> f51464c = new HashMap();

    /* renamed from: d */
    private String f51465d;

    /* renamed from: e */
    private BizParams f51466e;

    /* renamed from: f */
    private JsonArray f51467f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public boolean f51468g = false;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f51469h = false;

    public XBanner(Context context, XBannerView xBannerView) {
        this.f51462a = context;
        this.f51463b = xBannerView;
    }

    public void initXBanner(Activity activity, String str, BizParams bizParams, XBannerCallback xBannerCallback) {
        this.f51463b.setAttachedActivity(activity);
        this.f51465d = str;
        this.f51466e = bizParams;
        this.f51463b.setScrollChangedListener(this);
        xBannerRequest(this.f51462a, str, bizParams, xBannerCallback);
    }

    public void initXBanner(Activity activity, String str, BizParams bizParams, XBannerCallback xBannerCallback, XBannerNativeView xBannerNativeView) {
        this.f51463b.setAttachedActivity(activity);
        xBannerRequest(this.f51462a, str, bizParams, xBannerCallback);
        this.f51465d = str;
        this.f51466e = bizParams;
        this.f51464c.put(xBannerNativeView.getNativeModel().getCardId(), xBannerNativeView);
    }

    public void addNativeView(XBannerNativeView... xBannerNativeViewArr) {
        if (xBannerNativeViewArr != null && xBannerNativeViewArr.length != 0) {
            int length = xBannerNativeViewArr.length;
            int i = 0;
            while (i < length) {
                XBannerNativeView xBannerNativeView = xBannerNativeViewArr[i];
                if (xBannerNativeView != null) {
                    this.f51464c.put(xBannerNativeView.getNativeModel().getCardId(), xBannerNativeView);
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    public void reloadXBanner(XBannerCallback xBannerCallback) {
        reloadXBanner(xBannerCallback, new XBannerNativeView[0]);
    }

    public void reloadXBanner(XBannerCallback xBannerCallback, XBannerNativeView... xBannerNativeViewArr) {
        reloadXBannerAndNativeCheck(xBannerCallback, this.f51465d, this.f51466e, xBannerNativeViewArr);
    }

    public void reloadXBannerAndNativeCheck(XBannerCallback xBannerCallback, String str, BizParams bizParams, XBannerNativeView... xBannerNativeViewArr) {
        this.f51464c.clear();
        if (xBannerNativeViewArr.length != 0) {
            addNativeView(xBannerNativeViewArr);
        }
        this.f51465d = str;
        this.f51466e = bizParams;
        xBannerRequest(this.f51462a, str, bizParams, false, false, xBannerCallback);
    }

    public void reloadXBannerAndNativeCheck(XBannerCallback xBannerCallback, JsonObject jsonObject, XBannerNativeView... xBannerNativeViewArr) {
        this.f51464c.clear();
        if (xBannerNativeViewArr.length != 0) {
            addNativeView(xBannerNativeViewArr);
        }
        setXBannerData(jsonObject, false, false, xBannerCallback);
    }

    public void reloadXBanner(String str, XBannerCallback xBannerCallback, XBannerNativeView... xBannerNativeViewArr) {
        reloadXBannerAndNativeCheck(xBannerCallback, str, this.f51466e, xBannerNativeViewArr);
    }

    public void reloadXBanner(String str, BizParams bizParams, XBannerCallback xBannerCallback, XBannerNativeView... xBannerNativeViewArr) {
        reloadXBannerAndNativeCheck(xBannerCallback, str, bizParams, xBannerNativeViewArr);
    }

    public void xBannerRequest(Context context, String str, BizParams bizParams, XBannerCallback xBannerCallback) {
        xBannerRequest(context, str, bizParams, true, true, xBannerCallback);
    }

    public void xBannerRequest(Context context, String str, BizParams bizParams, final boolean z, final boolean z2, final XBannerCallback xBannerCallback) {
        XBannerRequest.expoRequest(context, str, bizParams, new RpcService.Callback<JsonObject>() {
            public void onSuccess(JsonObject jsonObject) {
                XBanner.this.m36848a(jsonObject, xBannerCallback, z, z2);
            }

            public void onFailure(IOException iOException) {
                XBannerCallback xBannerCallback = xBannerCallback;
                if (xBannerCallback != null) {
                    xBannerCallback.onFail(iOException);
                }
            }
        });
    }

    public void initXBanner(Activity activity) {
        this.f51463b.setAttachedActivity(activity);
        this.f51463b.setScrollChangedListener(this);
    }

    public void setXBannerData(JsonObject jsonObject, boolean z, boolean z2, XBannerCallback xBannerCallback) {
        if (jsonObject.has(XEParseConst.XE_JSON_KEY_UI_CONFIG)) {
            XBannerUIConfig xBannerUIConfig = (XBannerUIConfig) new Gson().fromJson(jsonObject.get(XEParseConst.XE_JSON_KEY_UI_CONFIG), XBannerUIConfig.class);
            XBannerUtil.setItemHeight((float) xBannerUIConfig.min_height);
            XBannerUtil.setItemUnfoldHeight((float) xBannerUIConfig.max_height);
        }
        JsonArray asJsonArray = jsonObject.getAsJsonArray("list");
        if (asJsonArray != null && asJsonArray.size() > 0) {
            boolean z3 = false;
            if (z) {
                z3 = m36853a((JsonObject) asJsonArray.get(0));
            }
            m36847a(asJsonArray);
            if (z2) {
                show(z3);
            }
            m36849a(jsonObject, asJsonArray, xBannerCallback);
        } else if (xBannerCallback != null) {
            xBannerCallback.onFail(new RuntimeException());
        }
    }

    public void show(boolean z) {
        if (!this.f51468g && !this.f51469h) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f51463b, "translationY", new float[]{(float) (z ? XBannerUtil.getUnfoldDefaultItemHeight(this.f51462a) : XBannerUtil.getDefaultItemHeight(this.f51462a)), 0.0f});
            ofFloat.setDuration(200);
            ofFloat.addListener(new Animator.AnimatorListener() {
                public void onAnimationCancel(Animator animator) {
                }

                public void onAnimationRepeat(Animator animator) {
                }

                public void onAnimationStart(Animator animator) {
                    boolean unused = XBanner.this.f51469h = true;
                }

                public void onAnimationEnd(Animator animator) {
                    boolean unused = XBanner.this.f51468g = true;
                    boolean unused2 = XBanner.this.f51469h = false;
                }
            });
            ofFloat.start();
        }
    }

    public boolean isXBannerShowing() {
        return this.f51468g;
    }

    public void hide() {
        if (this.f51468g && !this.f51469h) {
            int defaultItemHeight = XBannerUtil.getDefaultItemHeight(this.f51462a);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f51463b, "translationY", new float[]{0.0f, (float) defaultItemHeight});
            ofFloat.setDuration(200);
            ofFloat.addListener(new Animator.AnimatorListener() {
                public void onAnimationCancel(Animator animator) {
                }

                public void onAnimationRepeat(Animator animator) {
                }

                public void onAnimationStart(Animator animator) {
                    boolean unused = XBanner.this.f51469h = true;
                }

                public void onAnimationEnd(Animator animator) {
                    boolean unused = XBanner.this.f51468g = false;
                    boolean unused2 = XBanner.this.f51469h = false;
                }
            });
            ofFloat.start();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m36848a(JsonObject jsonObject, XBannerCallback xBannerCallback, boolean z, boolean z2) {
        if (!(jsonObject.get("errno").getAsInt() == 0 || xBannerCallback == null)) {
            xBannerCallback.onFail(new Exception());
        }
        if (jsonObject.has("data")) {
            JsonObject asJsonObject = jsonObject.getAsJsonObject("data");
            if (asJsonObject.has(XERequestKey.REQUEST_KEY_XBANNER)) {
                JsonObject asJsonObject2 = asJsonObject.getAsJsonObject(XERequestKey.REQUEST_KEY_XBANNER);
                if (asJsonObject2.has(XEParseConst.XE_JSON_KEY_UI_CONFIG)) {
                    XBannerUIConfig xBannerUIConfig = (XBannerUIConfig) new Gson().fromJson(asJsonObject2.get(XEParseConst.XE_JSON_KEY_UI_CONFIG), XBannerUIConfig.class);
                    XBannerUtil.setItemHeight((float) xBannerUIConfig.min_height);
                    XBannerUtil.setItemUnfoldHeight((float) xBannerUIConfig.max_height);
                }
                JsonArray asJsonArray = asJsonObject2.getAsJsonArray("list");
                if (asJsonArray != null && asJsonArray.size() > 0) {
                    boolean z3 = false;
                    if (z) {
                        z3 = m36853a((JsonObject) asJsonArray.get(0));
                    }
                    m36847a(asJsonArray);
                    if (z2) {
                        show(z3);
                    }
                    m36849a(asJsonObject2, asJsonArray, xBannerCallback);
                } else if (xBannerCallback != null) {
                    xBannerCallback.onFail(new RuntimeException());
                }
            }
        }
    }

    /* renamed from: a */
    private void m36849a(JsonObject jsonObject, JsonArray jsonArray, XBannerCallback xBannerCallback) {
        Iterator<JsonElement> it = jsonArray.iterator();
        while (it.hasNext()) {
            JsonObject asJsonObject = it.next().getAsJsonObject();
            if (asJsonObject.has("template")) {
                if (xBannerCallback != null) {
                    xBannerCallback.onSuccess(jsonObject);
                    return;
                }
                return;
            } else if (asJsonObject.has("id")) {
                try {
                    if (this.f51464c.get(asJsonObject.get("id").getAsString()) != null) {
                        if (xBannerCallback != null) {
                            xBannerCallback.onSuccess(jsonObject);
                            return;
                        }
                        return;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        if (xBannerCallback != null) {
            xBannerCallback.onFail(new RuntimeException());
        }
    }

    public void setData(Context context, List<XBannerItemBean> list) {
        this.f51463b.setData(context, list);
    }

    public void addData(Context context, XBannerItemBean... xBannerItemBeanArr) {
        this.f51463b.addData(context, Arrays.asList(xBannerItemBeanArr));
    }

    public void removeItem(int i) {
        XBannerView xBannerView = this.f51463b;
        if (xBannerView != null) {
            xBannerView.removeItem(i);
        }
    }

    public void removeItemByCardid(String str) {
        XBannerView xBannerView = this.f51463b;
        if (xBannerView != null) {
            xBannerView.removeItemByCardId(str);
        }
    }

    public List<XBannerItemBean> getData() {
        return this.f51463b.getData();
    }

    /* renamed from: a */
    private boolean m36853a(JsonObject jsonObject) {
        String asString = jsonObject.has("id") ? jsonObject.get("id").getAsString() : "";
        if (jsonObject.has("template")) {
            if (jsonObject.get("template").getAsString().equals(XEngineConst.XE_XML_TEMPLATE)) {
                String asString2 = jsonObject.get("id").getAsString();
                XBannerCDNData xBannerCDNData = new XBannerCDNData();
                try {
                    xBannerCDNData.parseExpand(new JSONObject(jsonObject.toString()));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                m36850a(asString2, xBannerCDNData);
                return true;
            }
            JsonObject asJsonObject = jsonObject.get("expanded") == null ? null : jsonObject.getAsJsonObject("expanded");
            if (asJsonObject != null) {
                try {
                    XBannerExpandModel xBannerExpandModel = (XBannerExpandModel) new Gson().fromJson(asJsonObject.get("data"), XBannerExpandModel.class);
                    xBannerExpandModel.extension = m36843a(jsonObject, 0);
                    m36851a(asString, xBannerExpandModel);
                    m36846a(xBannerExpandModel.extension, 0);
                    return true;
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    private void m36846a(XBannerExtension xBannerExtension, int i) {
        HashMap hashMap = new HashMap();
        if (xBannerExtension != null) {
            hashMap.put(BaseCard.KEY_CARD_ID, xBannerExtension.f51476id);
            hashMap.put("rank", Integer.valueOf(xBannerExtension.index));
            if (xBannerExtension.log_data != null) {
                try {
                    hashMap.putAll((Map) new Gson().fromJson((JsonElement) xBannerExtension.log_data, new HashMap().getClass()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        hashMap.put("type", Integer.valueOf(i));
        OmegaSDKAdapter.trackEvent("ibt_gp_operationcard_all_sw", (Map<String, Object>) hashMap);
    }

    /* renamed from: a */
    private void m36845a(XBannerExtension xBannerExtension) {
        HashMap hashMap = new HashMap();
        if (xBannerExtension != null) {
            hashMap.put("rank", Integer.valueOf(xBannerExtension.index));
            hashMap.put(BaseCard.KEY_CARD_ID, xBannerExtension.f51476id);
            if (xBannerExtension.log_data != null) {
                try {
                    hashMap.putAll((Map) new Gson().fromJson((JsonElement) xBannerExtension.log_data, new HashMap().getClass()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        OmegaSDKAdapter.trackEvent("ibt_gp_operationcard_sw", (Map<String, Object>) hashMap);
    }

    /* renamed from: a */
    private void m36847a(JsonArray jsonArray) {
        XBannerNativeView xBannerNativeView;
        ArrayList arrayList = new ArrayList();
        this.f51467f = new JsonArray();
        for (int i = 0; i < jsonArray.size(); i++) {
            JsonObject jsonObject = (JsonObject) jsonArray.get(i);
            String asString = jsonObject.has("id") ? jsonObject.get("id").getAsString() : "";
            if (jsonObject.has("template")) {
                if (jsonObject.get("template").getAsString().equals(XEngineConst.XE_XML_TEMPLATE)) {
                    XBannerCDNData xBannerCDNData = new XBannerCDNData();
                    try {
                        xBannerCDNData.parseNormal(new JSONObject(jsonObject.toString()), i);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    arrayList.add(new XBannerItemBean(asString, new XBannerCDNView(), xBannerCDNData));
                    this.f51467f.add(jsonArray.get(i));
                } else {
                    JsonObject asJsonObject = jsonObject.has("normal") ? jsonObject.getAsJsonObject("normal") : null;
                    if (asJsonObject != null) {
                        try {
                            XBannerNormalModel xBannerNormalModel = (XBannerNormalModel) new Gson().fromJson(asJsonObject.get("data"), XBannerNormalModel.class);
                            xBannerNormalModel.extension = m36843a(jsonObject, i);
                            arrayList.add(new XBannerItemBean(asString, new XBannerNormalView(this.f51462a), xBannerNormalModel));
                            this.f51467f.add(jsonArray.get(i));
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            } else if (!TextUtils.isEmpty(asString) && (xBannerNativeView = this.f51464c.get(asString)) != null) {
                arrayList.add(new XBannerItemBean(asString, xBannerNativeView, xBannerNativeView.getNativeModel()));
                this.f51467f.add(jsonArray.get(i));
            }
        }
        this.f51463b.setData(this.f51462a, arrayList);
        if (this.f51467f.size() > 0) {
            if (this.f51467f.size() > 1) {
                m36845a(m36843a(this.f51467f.get(1).getAsJsonObject(), 1));
            }
            XBannerExtension a = m36843a(this.f51467f.get(0).getAsJsonObject(), 0);
            m36845a(a);
            m36846a(a, 1);
        }
    }

    /* renamed from: a */
    private XBannerExtension m36843a(JsonObject jsonObject, int i) {
        XBannerExtension xBannerExtension = new XBannerExtension();
        if (jsonObject == null) {
            return xBannerExtension;
        }
        try {
            if (jsonObject.has("extension")) {
                JsonObject asJsonObject = jsonObject.get("extension").getAsJsonObject();
                if (asJsonObject.has("biz_params")) {
                    xBannerExtension.biz_params = asJsonObject.get("biz_params").getAsJsonObject();
                }
                if (asJsonObject.has("log_data")) {
                    xBannerExtension.log_data = asJsonObject.get("log_data").getAsJsonObject();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (jsonObject.has("id")) {
            try {
                xBannerExtension.f51476id = jsonObject.get("id").getAsString();
            } catch (Exception unused) {
                xBannerExtension.f51476id = "";
            }
        }
        xBannerExtension.index = i;
        return xBannerExtension;
    }

    /* renamed from: a */
    private void m36851a(final String str, final XBannerExpandModel xBannerExpandModel) {
        if (xBannerExpandModel != null && XBannerCache.getInstance(this.f51462a).isExpandNeedShow(str, xBannerExpandModel.display_count)) {
            this.f51463b.setXBannerExpandView(new XBannerExpandView(this.f51462a), xBannerExpandModel, new ExpandViewCallback() {
                public void onExpandViewShow() {
                }

                public void onExpandViewDismiss() {
                    XBannerCache.getInstance(XBanner.this.f51462a).setExpandNowCount(str, xBannerExpandModel.display_count);
                }
            });
        }
    }

    /* renamed from: a */
    private void m36850a(final String str, final XBannerCDNData xBannerCDNData) {
        if (xBannerCDNData != null && XBannerCache.getInstance(this.f51462a).isExpandNeedShow(str, xBannerCDNData.display_count)) {
            this.f51463b.setXBannerExpandView(new XBannerCDNView(), xBannerCDNData, new ExpandViewCallback() {
                public void onExpandViewShow() {
                }

                public void onExpandViewDismiss() {
                    XBannerCache.getInstance(XBanner.this.f51462a).setExpandNowCount(str, xBannerCDNData.display_count);
                }
            });
        }
    }

    public void test(Activity activity, String str) {
        this.f51463b.setAttachedActivity(activity);
        m36848a((JsonObject) new JsonParser().parse(str), (XBannerCallback) null, true, true);
    }

    public void test2(Activity activity, String str) {
        m36848a((JsonObject) new JsonParser().parse(str), (XBannerCallback) null, false, false);
    }

    public void onScrollChanged(int i, int i2, int i3) {
        JsonArray jsonArray = this.f51467f;
        if (i != i2) {
            m36845a(m36843a(jsonArray.get(i).getAsJsonObject(), i));
        }
        if (jsonArray != null && jsonArray.size() != 0 && i2 < jsonArray.size() && i3 < jsonArray.size() && i2 >= 0 && i3 >= 0 && jsonArray.get(i2) != null && jsonArray.get(i3) != null) {
            m36845a(m36843a(jsonArray.get(i2).getAsJsonObject(), i2));
            m36846a(m36843a(jsonArray.get(i3).getAsJsonObject(), i3), 1);
        }
    }
}
