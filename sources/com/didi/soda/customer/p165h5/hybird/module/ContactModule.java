package com.didi.soda.customer.p165h5.hybird.module;

import android.app.Activity;
import android.content.Intent;
import android.provider.ContactsContract;
import com.didi.onehybrid.BaseHybridModule;
import com.didi.onehybrid.container.HybridableContainer;
import com.didi.onehybrid.container.UpdateUIHandler;
import com.didi.onehybrid.jsbridge.CallbackFunction;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.soda.customer.p165h5.CustomerWebPage;
import com.didi.soda.web.model.CallBackModel;
import com.didi.soda.web.tools.WebJsBridgeTool;
import com.facebook.AuthenticationTokenClaims;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.didi.soda.customer.h5.hybird.module.ContactModule */
public class ContactModule extends BaseHybridModule {
    public static final int REQUEST_CONTACT = 102;

    /* renamed from: a */
    private Activity f41321a;

    /* renamed from: b */
    private CallbackFunction f41322b;

    /* renamed from: c */
    private UpdateUIHandler f41323c;

    public ContactModule(HybridableContainer hybridableContainer) {
        super(hybridableContainer);
        this.f41321a = hybridableContainer.getActivity();
        this.f41323c = hybridableContainer.getUpdateUIHandler();
    }

    public void openAddressBook(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.f41322b = callbackFunction;
        if (this.f41323c instanceof CustomerWebPage) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.PICK");
            intent.setData(ContactsContract.Contacts.CONTENT_URI);
            ((CustomerWebPage) this.f41323c).startActivityForResult(intent, 102);
            return;
        }
        callbackFunction.onCallBack(WebJsBridgeTool.buildResponse(new CallBackModel(1, "Invalid state! the updateUIHandler is not CustomerWebPage", (JSONObject) null)));
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0098 A[Catch:{ Exception -> 0x00bb }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handleContactResult(int r11, android.content.Intent r12) {
        /*
            r10 = this;
            java.lang.String r0 = ""
            r1 = -1
            if (r11 != r1) goto L_0x00c0
            if (r12 != 0) goto L_0x000d
            java.lang.String r11 = "get data is empty"
            r10.m29268a(r11)
            return
        L_0x000d:
            android.app.Activity r11 = r10.f41321a     // Catch:{ Exception -> 0x00bb }
            android.content.ContentResolver r1 = r11.getContentResolver()     // Catch:{ Exception -> 0x00bb }
            android.net.Uri r3 = r12.getData()     // Catch:{ Exception -> 0x00bb }
            android.app.Activity r2 = r10.f41321a     // Catch:{ Exception -> 0x00bb }
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r11 = r2.managedQuery(r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x00bb }
            r11.moveToFirst()     // Catch:{ Exception -> 0x00bb }
            java.lang.String r12 = "display_name"
            int r12 = r11.getColumnIndex(r12)     // Catch:{ Exception -> 0x00bb }
            java.lang.String r12 = r11.getString(r12)     // Catch:{ Exception -> 0x00bb }
            java.lang.String r2 = "_id"
            int r2 = r11.getColumnIndex(r2)     // Catch:{ Exception -> 0x00bb }
            java.lang.String r2 = r11.getString(r2)     // Catch:{ Exception -> 0x00bb }
            java.lang.String r3 = "data2"
            int r3 = r11.getColumnIndex(r3)     // Catch:{ Exception -> 0x0066 }
            java.lang.String r3 = r11.getString(r3)     // Catch:{ Exception -> 0x0066 }
            java.lang.String r4 = "data5"
            int r4 = r11.getColumnIndex(r4)     // Catch:{ Exception -> 0x0061 }
            java.lang.String r4 = r11.getString(r4)     // Catch:{ Exception -> 0x0061 }
            java.lang.String r5 = "data3"
            int r5 = r11.getColumnIndex(r5)     // Catch:{ Exception -> 0x005c }
            java.lang.String r0 = r11.getString(r5)     // Catch:{ Exception -> 0x005c }
            r11.close()     // Catch:{ Exception -> 0x005c }
            r7 = r0
            r0 = r3
            goto L_0x006d
        L_0x005c:
            r11 = move-exception
            r9 = r3
            r3 = r0
            r0 = r9
            goto L_0x0069
        L_0x0061:
            r11 = move-exception
            r4 = r0
            r0 = r3
            r3 = r4
            goto L_0x0069
        L_0x0066:
            r11 = move-exception
            r3 = r0
            r4 = r3
        L_0x0069:
            r11.printStackTrace()     // Catch:{ Exception -> 0x00bb }
            r7 = r3
        L_0x006d:
            r11 = r4
            android.net.Uri r3 = android.provider.ContactsContract.CommonDataKinds.Phone.CONTENT_URI     // Catch:{ Exception -> 0x00bb }
            r4 = 0
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00bb }
            r5.<init>()     // Catch:{ Exception -> 0x00bb }
            java.lang.String r6 = "contact_id = "
            r5.append(r6)     // Catch:{ Exception -> 0x00bb }
            r5.append(r2)     // Catch:{ Exception -> 0x00bb }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x00bb }
            r6 = 0
            r8 = 0
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r8
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x00bb }
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ Exception -> 0x00bb }
            r4.<init>()     // Catch:{ Exception -> 0x00bb }
        L_0x0092:
            boolean r2 = r1.moveToNext()     // Catch:{ Exception -> 0x00bb }
            if (r2 == 0) goto L_0x00b0
            java.lang.String r2 = "data1"
            int r2 = r1.getColumnIndex(r2)     // Catch:{ Exception -> 0x00bb }
            java.lang.String r2 = r1.getString(r2)     // Catch:{ Exception -> 0x00bb }
            java.lang.String r3 = r2.trim()     // Catch:{ Exception -> 0x00bb }
            boolean r3 = r3.isEmpty()     // Catch:{ Exception -> 0x00bb }
            if (r3 != 0) goto L_0x0092
            r4.add(r2)     // Catch:{ Exception -> 0x00bb }
            goto L_0x0092
        L_0x00b0:
            r1.close()     // Catch:{ Exception -> 0x00bb }
            r2 = r10
            r3 = r12
            r5 = r0
            r6 = r11
            r2.m29269a(r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x00bb }
            goto L_0x00c0
        L_0x00bb:
            java.lang.String r11 = "fetch contacts refused"
            r10.m29268a(r11)
        L_0x00c0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.customer.p165h5.hybird.module.ContactModule.handleContactResult(int, android.content.Intent):void");
    }

    /* renamed from: a */
    private void m29269a(String str, List<String> list, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", str);
            jSONObject.put(ParamConst.PARAM_FIRST_NAME, str2);
            jSONObject.put(AuthenticationTokenClaims.JSON_KEY_MIDDLE_NAME, str3);
            jSONObject.put(ParamConst.PARAM_LAST_NAME, str4);
            JSONArray jSONArray = new JSONArray();
            for (String put : list) {
                jSONArray.put(put);
            }
            jSONObject.put("phone", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        CallbackFunction callbackFunction = this.f41322b;
        if (callbackFunction != null) {
            callbackFunction.onCallBack(WebJsBridgeTool.buildResponse(new CallBackModel(0, jSONObject)));
            this.f41322b = null;
        }
    }

    /* renamed from: a */
    private void m29268a(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("err_code", -1);
            jSONObject.put("err_msg", str);
            jSONObject.put("name", "");
            jSONObject.put("phone", new JSONArray());
        } catch (Exception e) {
            e.printStackTrace();
        }
        CallbackFunction callbackFunction = this.f41322b;
        if (callbackFunction != null) {
            callbackFunction.onCallBack(WebJsBridgeTool.buildResponse(new CallBackModel(0, jSONObject)));
            this.f41322b = null;
        }
    }
}
