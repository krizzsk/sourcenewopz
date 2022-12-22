package com.didi.sdk.fusionbridge.module;

import android.app.Activity;
import com.didi.onehybrid.BaseHybridModule;
import com.didi.onehybrid.container.HybridableContainer;
import com.didi.onehybrid.container.UpdateUIHandler;
import com.didi.onehybrid.jsbridge.CallbackFunction;
import com.didi.onehybrid.jsbridge.JsInterface;
import org.json.JSONObject;

public class ShareEntranceModule extends BaseHybridModule {
    public static final String ALIPAY_FRIENDS_NAME = "ALIPAY_FRIENDS";
    public static final String ALIPAY_FRIENDS_TIMELINE = "ALIPAY_TIMELINE";
    public static final String UI_TARGET_GOTOALIPAY = "goto_alipay";
    public static final String UI_TARGET_HIDE_ENTRANCE = "hide_entrance";
    public static final String UI_TARGET_INIT_ENTRANCE = "init_entrance";
    public static final String UI_TARGET_INVOKE_ENTRANCE = "invoke_entrance";
    public static final String UI_TARGET_ISBACKGROUND = "is_backgroundchanged";
    public static final String UI_TARGET_SHOW_ENTRANCE = "show_entrance";
    public static final String WINDOW_CALL_BACK = "windowCallBack";

    /* renamed from: a */
    private Activity f36003a;

    /* renamed from: b */
    private UpdateUIHandler f36004b;

    public ShareEntranceModule(HybridableContainer hybridableContainer) {
        super(hybridableContainer);
        this.f36003a = hybridableContainer.getActivity();
        this.f36004b = hybridableContainer.getUpdateUIHandler();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0029, code lost:
        r9 = "";
     */
    @com.didi.onehybrid.jsbridge.JsInterface({"init_entrance", "initEntrance"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void initEntrance(org.json.JSONObject r20, com.didi.onehybrid.jsbridge.CallbackFunction r21) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            r2 = r21
            java.lang.String r3 = "image"
            if (r1 == 0) goto L_0x015d
            java.lang.String r4 = "entrance"
            r1.optJSONObject(r4)
            java.lang.String r4 = "buttons"
            org.json.JSONArray r1 = r1.optJSONArray(r4)
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            if (r1 == 0) goto L_0x0136
            r6 = 0
        L_0x001d:
            int r7 = r1.length()
            if (r6 >= r7) goto L_0x0136
            org.json.JSONObject r7 = r1.optJSONObject(r6)
            if (r7 == 0) goto L_0x012e
            java.lang.String r8 = "type"
            java.lang.String r9 = ""
            java.lang.String r10 = r7.optString(r8, r9)
            com.didi.sdk.webview.tool.WebViewToolModel r11 = com.didi.sdk.webview.tool.WebViewToolModel.getH5ShareModel(r10)
            if (r11 != 0) goto L_0x0039
            goto L_0x012e
        L_0x0039:
            r11.type = r10
            java.lang.String r10 = "name"
            java.lang.String r10 = r7.optString(r10, r9)
            r11.name = r10
            java.lang.String r10 = "icon"
            java.lang.String r12 = r7.optString(r10, r9)
            r11.icon = r12
            java.lang.String r12 = "redirect_url"
            java.lang.String r12 = r7.optString(r12, r9)
            r11.redirect_url = r12
            java.lang.String r12 = "data"
            org.json.JSONObject r7 = r7.optJSONObject(r12)
            com.didi.sharesdk.OneKeyShareModel r12 = r11.onkKeyShareModel
            if (r7 == 0) goto L_0x0128
            java.lang.String r13 = "share_url"
            java.lang.String r14 = r7.optString(r13, r9)
            boolean r14 = android.text.TextUtils.isEmpty(r14)
            if (r14 == 0) goto L_0x006b
            java.lang.String r13 = "url"
        L_0x006b:
            java.lang.String r13 = r7.optString(r13, r9)
            java.lang.String r14 = "share_icon_url"
            java.lang.String r15 = r7.optString(r14, r9)
            boolean r15 = android.text.TextUtils.isEmpty(r15)
            if (r15 == 0) goto L_0x0080
            java.lang.String r10 = r7.optString(r10, r9)
            goto L_0x0084
        L_0x0080:
            java.lang.String r10 = r7.optString(r14, r9)
        L_0x0084:
            java.lang.String r14 = "share_img_url"
            java.lang.String r15 = r7.optString(r14, r9)
            boolean r15 = android.text.TextUtils.isEmpty(r15)
            if (r15 == 0) goto L_0x0092
            java.lang.String r14 = "img"
        L_0x0092:
            java.lang.String r14 = r7.optString(r14, r9)
            java.lang.String r15 = "share_title"
            java.lang.String r16 = r7.optString(r15, r9)
            boolean r16 = android.text.TextUtils.isEmpty(r16)
            if (r16 == 0) goto L_0x00a4
            java.lang.String r15 = "title"
        L_0x00a4:
            java.lang.String r15 = r7.optString(r15, r9)
            java.lang.String r5 = "share_content"
            java.lang.String r16 = r7.optString(r5, r9)
            boolean r16 = android.text.TextUtils.isEmpty(r16)
            r17 = r1
            java.lang.String r1 = "content"
            if (r16 == 0) goto L_0x00bd
            java.lang.String r5 = r7.optString(r1, r9)
            goto L_0x00c1
        L_0x00bd:
            java.lang.String r5 = r7.optString(r5, r9)
        L_0x00c1:
            r16 = r10
            java.lang.String r10 = "sms_message"
            java.lang.String r18 = r7.optString(r10, r9)
            boolean r18 = android.text.TextUtils.isEmpty(r18)
            if (r18 == 0) goto L_0x00d4
            java.lang.String r1 = r7.optString(r1, r9)
            goto L_0x00d8
        L_0x00d4:
            java.lang.String r1 = r7.optString(r10, r9)
        L_0x00d8:
            java.lang.String r8 = r7.getString(r8)     // Catch:{ JSONException -> 0x00e3 }
            java.lang.String r9 = r7.getString(r3)     // Catch:{ JSONException -> 0x00e1 }
            goto L_0x00e4
        L_0x00e1:
            goto L_0x00e4
        L_0x00e3:
            r8 = r9
        L_0x00e4:
            boolean r7 = android.text.TextUtils.isEmpty(r8)
            if (r7 != 0) goto L_0x0110
            boolean r7 = r3.equals(r8)
            if (r7 == 0) goto L_0x0110
            java.lang.String r7 = r12.getPlatform()
            java.lang.String r8 = "ALIPAY_FRIENDS"
            boolean r7 = r8.equals(r7)
            if (r7 != 0) goto L_0x010c
            java.lang.String r7 = r12.getPlatform()
            java.lang.String r8 = "ALIPAY_TIMELINE"
            boolean r7 = r8.equals(r7)
            if (r7 == 0) goto L_0x0109
            goto L_0x010c
        L_0x0109:
            r10 = r9
            r14 = r10
            goto L_0x0112
        L_0x010c:
            r10 = r9
            r13 = r10
            r14 = r13
            goto L_0x0112
        L_0x0110:
            r10 = r16
        L_0x0112:
            if (r12 == 0) goto L_0x012a
            r12.url = r13
            boolean r7 = android.text.TextUtils.isEmpty(r10)
            if (r7 == 0) goto L_0x011d
            r10 = r14
        L_0x011d:
            r12.imgUrl = r10
            r12.title = r15
            r12.content = r5
            r11.onkKeyShareModel = r12
            r12.smsMessage = r1
            goto L_0x012a
        L_0x0128:
            r17 = r1
        L_0x012a:
            r4.add(r11)
            goto L_0x0130
        L_0x012e:
            r17 = r1
        L_0x0130:
            int r6 = r6 + 1
            r1 = r17
            goto L_0x001d
        L_0x0136:
            com.didi.onehybrid.container.UpdateUIHandler r1 = r0.f36004b
            r3 = 1
            if (r1 == 0) goto L_0x014e
            int r1 = r4.size()
            if (r1 == 0) goto L_0x014e
            com.didi.onehybrid.container.UpdateUIHandler r1 = r0.f36004b
            java.lang.Object[] r5 = new java.lang.Object[r3]
            r6 = 0
            r5[r6] = r4
            java.lang.String r4 = "init_entrance"
            r1.updateUI(r4, r5)
            goto L_0x014f
        L_0x014e:
            r6 = 0
        L_0x014f:
            if (r2 == 0) goto L_0x015d
            java.lang.Object[] r1 = new java.lang.Object[r3]
            org.json.JSONObject r3 = new org.json.JSONObject
            r3.<init>()
            r1[r6] = r3
            r2.onCallBack(r1)
        L_0x015d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.fusionbridge.module.ShareEntranceModule.initEntrance(org.json.JSONObject, com.didi.onehybrid.jsbridge.CallbackFunction):void");
    }

    @JsInterface({"show_entrance", "showEntrance"})
    public void showEntrance(JSONObject jSONObject, CallbackFunction callbackFunction) {
        String str;
        if (jSONObject != null) {
            str = jSONObject.optString("windowCallBack");
            initEntrance(jSONObject, callbackFunction);
        } else {
            str = null;
        }
        UpdateUIHandler updateUIHandler = this.f36004b;
        if (updateUIHandler != null) {
            updateUIHandler.updateUI(UI_TARGET_SHOW_ENTRANCE, callbackFunction, str);
        }
    }

    @JsInterface({"invoke_entrance", "invokeEntrance"})
    public void invokeEntrance(JSONObject jSONObject, CallbackFunction callbackFunction) {
        UpdateUIHandler updateUIHandler = this.f36004b;
        if (updateUIHandler != null) {
            updateUIHandler.updateUI(UI_TARGET_INVOKE_ENTRANCE, callbackFunction);
        }
    }

    @JsInterface({"hide_entrance", "hideEntrance"})
    public void hideEntrance(CallbackFunction callbackFunction) {
        UpdateUIHandler updateUIHandler = this.f36004b;
        if (updateUIHandler != null) {
            updateUIHandler.updateUI(UI_TARGET_HIDE_ENTRANCE, new Object[0]);
        }
    }
}
