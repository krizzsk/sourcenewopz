package com.didi.sdk.fusionbridge.module;

import android.app.Activity;
import android.content.Intent;
import android.provider.ContactsContract;
import com.didi.onehybrid.BaseHybridModule;
import com.didi.onehybrid.container.HybridableContainer;
import com.didi.onehybrid.jsbridge.CallbackFunction;
import com.didi.onehybrid.jsbridge.JsInterface;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.facebook.AuthenticationTokenClaims;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class ContactModule extends BaseHybridModule {
    public static final int REQUEST_CONTACT = 102;

    /* renamed from: a */
    private Activity f35982a;

    /* renamed from: b */
    private CallbackFunction f35983b;

    public ContactModule(HybridableContainer hybridableContainer) {
        super(hybridableContainer);
        this.f35982a = hybridableContainer.getActivity();
    }

    @JsInterface({"openAddressBook"})
    public void openAddressBook(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.f35983b = callbackFunction;
        Intent intent = new Intent();
        intent.setAction("android.intent.action.PICK");
        intent.setData(ContactsContract.Contacts.CONTENT_URI);
        this.f35982a.startActivityForResult(intent, 102);
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x008f A[Catch:{ Exception -> 0x00af }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handleContactResult(int r10, android.content.Intent r11) {
        /*
            r9 = this;
            java.lang.String r0 = ""
            r1 = -1
            if (r10 != r1) goto L_0x00b4
            if (r11 != 0) goto L_0x000d
            java.lang.String r10 = "get data is empty"
            r9.m25455a(r10)
            return
        L_0x000d:
            android.app.Activity r10 = r9.f35982a     // Catch:{ Exception -> 0x00af }
            android.content.ContentResolver r1 = r10.getContentResolver()     // Catch:{ Exception -> 0x00af }
            android.net.Uri r3 = r11.getData()     // Catch:{ Exception -> 0x00af }
            android.app.Activity r2 = r9.f35982a     // Catch:{ Exception -> 0x00af }
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r10 = r2.managedQuery(r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x00af }
            r10.moveToFirst()     // Catch:{ Exception -> 0x00af }
            java.lang.String r11 = "display_name"
            int r11 = r10.getColumnIndex(r11)     // Catch:{ Exception -> 0x00af }
            java.lang.String r11 = r10.getString(r11)     // Catch:{ Exception -> 0x00af }
            java.lang.String r2 = "_id"
            int r2 = r10.getColumnIndex(r2)     // Catch:{ Exception -> 0x00af }
            java.lang.String r2 = r10.getString(r2)     // Catch:{ Exception -> 0x00af }
            java.lang.String r3 = "data2"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x005c }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x005c }
            java.lang.String r4 = "data5"
            int r4 = r10.getColumnIndex(r4)     // Catch:{ Exception -> 0x0059 }
            java.lang.String r4 = r10.getString(r4)     // Catch:{ Exception -> 0x0059 }
            java.lang.String r5 = "data3"
            int r5 = r10.getColumnIndex(r5)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r0 = r10.getString(r5)     // Catch:{ Exception -> 0x0057 }
            goto L_0x0062
        L_0x0057:
            r10 = move-exception
            goto L_0x005f
        L_0x0059:
            r10 = move-exception
            r4 = r0
            goto L_0x005f
        L_0x005c:
            r10 = move-exception
            r3 = r0
            r4 = r3
        L_0x005f:
            r10.printStackTrace()     // Catch:{ Exception -> 0x00af }
        L_0x0062:
            r7 = r0
            r10 = r3
            r0 = r4
            android.net.Uri r3 = android.provider.ContactsContract.CommonDataKinds.Phone.CONTENT_URI     // Catch:{ Exception -> 0x00af }
            r4 = 0
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00af }
            r5.<init>()     // Catch:{ Exception -> 0x00af }
            java.lang.String r6 = "contact_id = "
            r5.append(r6)     // Catch:{ Exception -> 0x00af }
            r5.append(r2)     // Catch:{ Exception -> 0x00af }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x00af }
            r6 = 0
            r8 = 0
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r8
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x00af }
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ Exception -> 0x00af }
            r4.<init>()     // Catch:{ Exception -> 0x00af }
        L_0x0089:
            boolean r2 = r1.moveToNext()     // Catch:{ Exception -> 0x00af }
            if (r2 == 0) goto L_0x00a7
            java.lang.String r2 = "data1"
            int r2 = r1.getColumnIndex(r2)     // Catch:{ Exception -> 0x00af }
            java.lang.String r2 = r1.getString(r2)     // Catch:{ Exception -> 0x00af }
            java.lang.String r3 = r2.trim()     // Catch:{ Exception -> 0x00af }
            boolean r3 = r3.isEmpty()     // Catch:{ Exception -> 0x00af }
            if (r3 != 0) goto L_0x0089
            r4.add(r2)     // Catch:{ Exception -> 0x00af }
            goto L_0x0089
        L_0x00a7:
            r2 = r9
            r3 = r11
            r5 = r10
            r6 = r0
            r2.m25456a(r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x00af }
            goto L_0x00b4
        L_0x00af:
            java.lang.String r10 = "fetch contacts refused"
            r9.m25455a(r10)
        L_0x00b4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.fusionbridge.module.ContactModule.handleContactResult(int, android.content.Intent):void");
    }

    /* renamed from: a */
    private void m25456a(String str, List<String> list, String str2, String str3, String str4) {
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
        CallbackFunction callbackFunction = this.f35983b;
        if (callbackFunction != null) {
            callbackFunction.onCallBack(jSONObject);
            this.f35983b = null;
        }
    }

    /* renamed from: a */
    private void m25455a(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("err_code", -1);
            jSONObject.put("err_msg", str);
            jSONObject.put("name", "");
            jSONObject.put("phone", new JSONArray());
        } catch (Exception e) {
            e.printStackTrace();
        }
        CallbackFunction callbackFunction = this.f35983b;
        if (callbackFunction != null) {
            callbackFunction.onCallBack(jSONObject);
            this.f35983b = null;
        }
    }
}
