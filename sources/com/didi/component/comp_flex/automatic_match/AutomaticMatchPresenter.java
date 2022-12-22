package com.didi.component.comp_flex.automatic_match;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.xengine.XERequestKey;
import com.didi.component.business.xpanelnew.IXpCardBindDataReadyCallback;
import com.didi.component.business.xpanelnew.XpNewAdapter;
import com.didi.component.common.adapter.CommonListAdapter;
import com.didi.component.common.adapter.ICommonListCardBindDataReadyCallback;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.IPresenter;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import com.didi.drouter.router.RouterCallback;
import com.didi.global.globaluikit.toast.LEGOToastHelper;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.google.gson.Gson;
import java.net.URLDecoder;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;

public class AutomaticMatchPresenter extends IPresenter<AutomaticMatchView> implements XpNewAdapter, CommonListAdapter {

    /* renamed from: a */
    private BaseEventPublisher.OnEventListener<Boolean> f12133a = new BaseEventPublisher.OnEventListener<Boolean>() {
        public void onEvent(String str, Boolean bool) {
            ((AutomaticMatchView) AutomaticMatchPresenter.this.mView).resetSwitchChecked(bool.booleanValue());
        }
    };

    /* renamed from: b */
    private BaseEventPublisher.OnEventListener<Boolean> f12134b = new BaseEventPublisher.OnEventListener<Boolean>() {
        public void onEvent(String str, Boolean bool) {
            ((AutomaticMatchView) AutomaticMatchPresenter.this.mView).updateSwitchBtnEnable(bool.booleanValue());
        }
    };

    /* renamed from: c */
    private final Logger f12135c = LoggerFactory.getLogger("AutomaticMatchPresenter");

    /* renamed from: d */
    private AutomaticMatchModel f12136d;

    public AutomaticMatchPresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8204a(String str) {
        this.f12135c.info(str, new Object[0]);
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        m8204a("onadd");
        subscribe(BaseEventKeys.WaitRsp.EVENT_FLEX_AUTOMATIC_CHECKED, this.f12133a);
        subscribe(BaseEventKeys.WaitRsp.EVENT_FLEX_AUTOMATIC_ENABLE, this.f12134b);
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        m8204a("onremove");
        unsubscribe(BaseEventKeys.WaitRsp.EVENT_FLEX_AUTOMATIC_CHECKED, this.f12133a);
        unsubscribe(BaseEventKeys.WaitRsp.EVENT_FLEX_AUTOMATIC_ENABLE, this.f12134b);
    }

    public void onCheckedChanged(final boolean z) {
        try {
            String str = this.f12136d.toggle_submit_link;
            boolean z2 = false;
            if (TextUtils.isEmpty(str)) {
                m8204a("onCheckedChanged link is null");
                if (!z) {
                    z2 = true;
                }
                resetSwitch(z2);
                return;
            }
            String queryParameter = Uri.parse(str).getQueryParameter("query");
            if (TextUtils.isEmpty(queryParameter)) {
                if (!z) {
                    z2 = true;
                }
                resetSwitch(z2);
                return;
            }
            String substring = str.substring(0, str.indexOf("?"));
            JSONObject jSONObject = new JSONObject(URLDecoder.decode(queryParameter, "UTF-8"));
            if (z) {
                z2 = true;
            }
            jSONObject.put("auto_deal_status", z2 ? 1 : 0);
            ((Request) DRouter.build(substring + "?query=" + URLEncoder.encode(jSONObject.toString(), "UTF-8")).putExtra("KEY_COMMIT_SCENE", XERequestKey.SCENE_TRIP)).start(this.mContext, new RouterCallback() {
                public void onResult(Result result) {
                    String string = result.getString("KEY_CALLBACK");
                    AutomaticMatchPresenter.this.doPublish(BaseEventKeys.WaitRsp.EVENT_FLEX_AUTOMATIC_ENABLE, true);
                    if (TextUtils.isEmpty(string)) {
                        AutomaticMatchPresenter.this.m8204a("xengine commit failed");
                        AutomaticMatchPresenter.this.doPublish(BaseEventKeys.WaitRsp.EVENT_FLEX_AUTOMATIC_CHECKED, Boolean.valueOf(!z));
                        return;
                    }
                    boolean z = false;
                    try {
                        JSONObject jSONObject = new JSONObject(string);
                        if (jSONObject.has("data")) {
                            JSONObject optJSONObject = jSONObject.optJSONObject("data");
                            if (optJSONObject.has("extension")) {
                                JSONObject optJSONObject2 = optJSONObject.optJSONObject("extension");
                                if (optJSONObject2 == null || optJSONObject2.optInt("errno") == 0) {
                                    z = true;
                                } else {
                                    LEGOToastHelper.showToast(AutomaticMatchPresenter.this.mContext, optJSONObject2.optString("errmsg"));
                                }
                            }
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    if (!z) {
                        AutomaticMatchPresenter.this.doPublish(BaseEventKeys.WaitRsp.EVENT_FLEX_AUTOMATIC_CHECKED, Boolean.valueOf(!z));
                    }
                }
            });
            doPublish(BaseEventKeys.WaitRsp.EVENT_FLEX_AUTOMATIC_CHECKED, Boolean.valueOf(z));
        } catch (Exception e) {
            e.printStackTrace();
            resetSwitch(!z);
        }
    }

    public void resetSwitch(boolean z) {
        doPublish(BaseEventKeys.WaitRsp.EVENT_FLEX_AUTOMATIC_ENABLE, true);
        doPublish(BaseEventKeys.WaitRsp.EVENT_FLEX_AUTOMATIC_CHECKED, Boolean.valueOf(z));
    }

    public void setViewWithData(JSONObject jSONObject, IXpCardBindDataReadyCallback iXpCardBindDataReadyCallback) {
        boolean z = false;
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("normal");
            if (optJSONObject != null) {
                if (optJSONObject.has("data")) {
                    String optString = optJSONObject.optString("data");
                    m8204a("onSuccessWithLogic:jsonObject = " + optString);
                    this.f12136d = (AutomaticMatchModel) new Gson().fromJson(optString, AutomaticMatchModel.class);
                    ((AutomaticMatchView) this.mView).update(this.f12136d);
                }
                z = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        iXpCardBindDataReadyCallback.ready(z);
    }

    public void setViewWithData(JSONObject jSONObject, ICommonListCardBindDataReadyCallback iCommonListCardBindDataReadyCallback) {
        boolean z = false;
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("normal");
            if (optJSONObject != null) {
                if (optJSONObject.has("data")) {
                    String optString = optJSONObject.optString("data");
                    m8204a("onSuccessWithLogic:jsonObject = " + optString);
                    this.f12136d = (AutomaticMatchModel) new Gson().fromJson(optString, AutomaticMatchModel.class);
                    ((AutomaticMatchView) this.mView).update(this.f12136d);
                }
                z = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        iCommonListCardBindDataReadyCallback.ready(z);
    }
}
