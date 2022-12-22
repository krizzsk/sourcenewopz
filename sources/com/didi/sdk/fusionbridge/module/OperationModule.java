package com.didi.sdk.fusionbridge.module;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.didi.onehybrid.BaseHybridModule;
import com.didi.onehybrid.container.HybridableContainer;
import com.didi.onehybrid.jsbridge.CallbackFunction;
import com.didi.onehybrid.jsbridge.JsInterface;
import com.didi.sdk.webview.BaseWebActivity;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didichuxing.apollo.sdk.Apollo;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class OperationModule extends BaseHybridModule {
    public static final String KEY_COUPON_ID = "couponID";

    /* renamed from: a */
    private Activity f36001a;

    /* renamed from: b */
    private String[] f36002b;

    @JsInterface({"openVerifyComponent"})
    public void openVerifyComponent(JSONObject jSONObject, CallbackFunction callbackFunction) {
    }

    public OperationModule(HybridableContainer hybridableContainer) {
        super(hybridableContainer);
        this.f36001a = hybridableContainer.getActivity();
    }

    @JsInterface({"getContacts"})
    public void getContacts(JSONObject jSONObject, CallbackFunction callbackFunction) {
        String[] strArr;
        JSONObject jSONObject2 = new JSONObject();
        try {
            int optInt = jSONObject.optInt(TypedValues.CycleType.S_WAVE_OFFSET);
            int optInt2 = jSONObject.optInt("size");
            if (this.f36002b != null) {
                strArr = this.f36002b;
            } else {
                strArr = m25469a();
                this.f36002b = strArr;
            }
            if (optInt < 0) {
                optInt = 0;
            }
            if (optInt > strArr.length) {
                optInt = strArr.length;
            }
            int i = optInt2 + optInt;
            if (i > strArr.length) {
                i = strArr.length;
            }
            int i2 = i - optInt;
            JSONArray jSONArray = new JSONArray();
            while (true) {
                int i3 = i2 - 1;
                if (i2 <= 0) {
                    break;
                }
                jSONArray.put(new JSONObject(strArr[optInt]));
                i2 = i3;
                optInt++;
            }
            jSONObject2.put(ParamConst.PARAM_TOTAL, strArr.length);
            jSONObject2.put("datas", jSONArray.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (callbackFunction != null) {
            callbackFunction.onCallBack(jSONObject2);
        }
    }

    @JsInterface({"apolloGetToggle"})
    public JSONObject apolloGetToggle(JSONObject jSONObject, CallbackFunction callbackFunction) {
        if (jSONObject != null) {
            JSONObject jsonToggle = Apollo.getJsonToggle(jSONObject.optString("name"));
            callbackFunction.onCallBack(jsonToggle);
            return jsonToggle;
        }
        callbackFunction.onCallBack(new JSONObject());
        return null;
    }

    @JsInterface({"getSelectedCouponID"})
    public void getSelectedCouponID(JSONObject jSONObject, CallbackFunction callbackFunction) {
        if (jSONObject != null) {
            Activity activity = this.f36001a;
            if (activity instanceof BaseWebActivity) {
                BaseWebActivity baseWebActivity = (BaseWebActivity) activity;
                String optString = jSONObject.optString(KEY_COUPON_ID);
                Intent intent = new Intent();
                intent.putExtra(KEY_COUPON_ID, optString);
                baseWebActivity.setResultIntent(intent);
                if (!TextUtils.isEmpty(optString)) {
                    baseWebActivity.setResult(-1, intent);
                    baseWebActivity.finish();
                }
                callbackFunction.onCallBack(new JSONObject());
                return;
            }
            throw new RuntimeException("Can't be invoked in any activity except BaseWebActivity");
        }
    }

    /* renamed from: a */
    private String[] m25469a() {
        int i;
        JSONException e;
        int i2 = 0;
        String[] strArr = new String[0];
        Cursor query = this.f36001a.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, new String[]{"display_name", "data1", "photo_id"}, (String) null, (String[]) null, "display_name");
        if (query != null && query.getCount() > 0) {
            strArr = new String[query.getCount()];
            while (query.moveToNext()) {
                String string = query.getString(query.getColumnIndex("data1"));
                String string2 = query.getString(query.getColumnIndex("display_name"));
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(string2, string.trim());
                    i = i2 + 1;
                    try {
                        strArr[i2] = jSONObject.toString();
                    } catch (JSONException e2) {
                        e = e2;
                    }
                } catch (JSONException e3) {
                    JSONException jSONException = e3;
                    i = i2;
                    e = jSONException;
                    e.printStackTrace();
                    i2 = i;
                }
                i2 = i;
            }
            query.close();
        }
        return strArr;
    }
}
