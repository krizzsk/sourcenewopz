package com.didi.soda.customer.p165h5.hybird.tool;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.util.GsonUtil;
import com.didi.soda.customer.foundation.util.LocalPermissionHelper;
import com.didi.soda.customer.p165h5.hybird.model.ContactModel;
import com.yanzhenjie.permission.runtime.Permission;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.didi.soda.customer.h5.hybird.tool.ContactUtil */
public class ContactUtil {

    /* renamed from: a */
    private static final String f41330a = "ContactUtil";

    public static JSONObject getContacts2content(Activity activity) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        String str = "";
        if (LocalPermissionHelper.checkoutPermission(activity, new String[]{Permission.READ_CONTACTS})) {
            List a = m29286a(activity);
            if (a == null) {
                a = new ArrayList();
            }
            JSONArray jSONArray = new JSONArray(GsonUtil.toJson(a));
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("list", jSONArray);
            String jSONObject3 = jSONObject2.toString();
            LogUtil.m29100d(f41330a, jSONObject3);
            if (!a.isEmpty()) {
                str = WebEncryptUtil.aesEncrypt(jSONObject3);
            }
            jSONObject.put("content", str);
            jSONObject.put("permitted", 1);
        } else {
            jSONObject.put("content", str);
            jSONObject.put("permitted", 2);
        }
        return jSONObject;
    }

    /* renamed from: a */
    private static List<ContactModel> m29286a(Context context) {
        try {
            Cursor query = context.getContentResolver().query(ContactsContract.Data.CONTENT_URI, new String[]{"contact_id", "mimetype", "data1", "data2", "data5", "data3"}, "mimetype in ( ? , ?)", new String[]{"vnd.android.cursor.item/phone_v2", "vnd.android.cursor.item/name"}, (String) null);
            HashMap hashMap = new HashMap();
            while (query.moveToNext()) {
                String string = query.getString(query.getColumnIndex("contact_id"));
                ContactModel contactModel = (ContactModel) hashMap.get(string);
                if (contactModel == null) {
                    contactModel = new ContactModel();
                    hashMap.put(string, contactModel);
                }
                int columnIndex = query.getColumnIndex("mimetype");
                char c = 65535;
                if (columnIndex != -1) {
                    String string2 = query.getString(columnIndex);
                    int hashCode = string2.hashCode();
                    if (hashCode != -1079224304) {
                        if (hashCode == 684173810) {
                            if (string2.equals("vnd.android.cursor.item/phone_v2")) {
                                c = 0;
                            }
                        }
                    } else if (string2.equals("vnd.android.cursor.item/name")) {
                        c = 1;
                    }
                    if (c == 0) {
                        List list = contactModel.phoneNum;
                        if (list == null) {
                            list = new ArrayList(4);
                            contactModel.phoneNum = list;
                        }
                        list.add(query.getString(query.getColumnIndex("data1")));
                    } else if (c == 1) {
                        contactModel.name = query.getString(query.getColumnIndex("data1"));
                        contactModel.firstName = query.getString(query.getColumnIndex("data2"));
                        contactModel.middleName = query.getString(query.getColumnIndex("data5"));
                        contactModel.lastName = query.getString(query.getColumnIndex("data3"));
                    }
                }
            }
            query.close();
            ArrayList arrayList = new ArrayList(hashMap.size());
            arrayList.addAll(hashMap.values());
            return arrayList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
