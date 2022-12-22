package com.didiglobal.enginecore.template.xml;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.didi.global.globalgenerickit.eventtracker.Const;
import com.didi.reactive.tracker.EventTracker;
import com.didi.sdk.apm.SystemUtils;
import com.didiglobal.dittoview.DittoKit;
import com.didiglobal.dittoview.callback.CDNCallback;
import com.didiglobal.dittoview.impl.DittoEventListenerImpl;
import com.didiglobal.dittoview.mvvm.DittoData;
import com.didiglobal.dittoview.mvvm.DittoView;
import com.didiglobal.enginecore.utils.XEngineUtil;
import com.didiglobal.enginecore.view.AsyncViewLoadListener;
import com.didiglobal.enginecore.view.XECardView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public class XMLCardView implements XECardView<XMLCardData> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public AsyncViewLoadListener f50204a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public View f50205b;

    public void resetView() {
    }

    public XMLCardView(AsyncViewLoadListener asyncViewLoadListener) {
        this.f50204a = asyncViewLoadListener;
    }

    public void createView(final Context context, final XMLCardData xMLCardData) {
        final DittoData data = xMLCardData.getData();
        data.setCDNCallback(new CDNCallback() {
            public void onCDNCached() {
                StringBuilder sb = new StringBuilder();
                sb.append("onCDNCached::");
                boolean z = true;
                sb.append(XMLCardView.this.f50204a == null);
                SystemUtils.log(6, "CDNCacheManager", sb.toString(), (Throwable) null, "com.didiglobal.enginecore.template.xml.XMLCardView$1", 44);
                if (XMLCardView.this.f50204a != null) {
                    View unused = XMLCardView.this.f50205b = XMLCardView.m36175b(context, data, xMLCardData);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("onCDNCached::mView:::");
                    if (XMLCardView.this.f50205b != null) {
                        z = false;
                    }
                    sb2.append(z);
                    SystemUtils.log(6, "CDNCacheManager", sb2.toString(), (Throwable) null, "com.didiglobal.enginecore.template.xml.XMLCardView$1", 47);
                    XMLCardView.this.f50204a.onAsyncViewLoad(XMLCardView.this.f50205b);
                }
            }

            public void onCDNCachedFailed(String str) {
                XMLCardView.this.f50204a.onAsyncViewLoadFailed();
            }
        });
        data.setEventListener(new DittoEventListenerImpl(data) {
            public boolean handleEvent(String str, String str2, Map<String, Object> map) {
                XMLCardView.this.m36173a(this.data, str, map);
                return super.handleEvent(str, str2, map);
            }
        });
        this.f50205b = m36175b(context, data, xMLCardData);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m36173a(DittoData dittoData, String str, Map<String, Object> map) {
        HashMap hashMap = new HashMap();
        hashMap.put("id", dittoData.getId());
        hashMap.put("k", "click");
        if (str.equals("xpanel_button_ck")) {
            hashMap.put(Const.BUTTON_ID, (String) map.get(Const.BUTTON_ID));
        }
        if (dittoData.getExtension() != null) {
            if (dittoData.getExtension().has("container_id")) {
                hashMap.put("container_com_id", dittoData.getExtension().opt("container_id"));
            }
            if (dittoData.getExtension().has("log_data")) {
                try {
                    JSONObject jSONObject = (JSONObject) dittoData.getExtension().get("log_data");
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        hashMap.put(next, jSONObject.opt(next));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        EventTracker.trackEvent("ibt_gp_commonmodule_btn_ck", hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static View m36175b(Context context, DittoData dittoData, XMLCardData xMLCardData) {
        DittoView createTemplateView;
        ViewGroup.LayoutParams layoutParams;
        if (context == null || dittoData == null || (createTemplateView = DittoKit.createTemplateView(context, dittoData)) == null) {
            return null;
        }
        View view = createTemplateView.getView();
        if (view != null) {
            if (view.getLayoutParams() != null) {
                layoutParams = view.getLayoutParams();
            } else {
                layoutParams = new ViewGroup.LayoutParams(-2, -2);
            }
            int width = xMLCardData.getWidth();
            int height = xMLCardData.getHeight();
            if (width > 0) {
                layoutParams.width = XEngineUtil.dip2px(context, (float) width);
            } else if (height > 0) {
                layoutParams.height = XEngineUtil.dip2px(context, (float) height);
            }
            view.setLayoutParams(layoutParams);
        }
        return view;
    }

    public View getView() {
        return this.f50205b;
    }
}
