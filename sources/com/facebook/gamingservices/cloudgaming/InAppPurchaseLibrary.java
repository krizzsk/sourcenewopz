package com.facebook.gamingservices.cloudgaming;

import android.content.Context;
import com.facebook.gamingservices.cloudgaming.DaemonRequest;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKLogger;
import com.facebook.gamingservices.cloudgaming.internal.SDKMessageEnum;
import org.json.JSONException;
import org.json.JSONObject;

public class InAppPurchaseLibrary {
    public static void onReady(Context context, DaemonRequest.Callback callback) {
        DaemonRequest.executeAsync(context, (JSONObject) null, callback, SDKMessageEnum.ON_READY);
    }

    public static void getCatalog(Context context, DaemonRequest.Callback callback) {
        DaemonRequest.executeAsync(context, (JSONObject) null, callback, SDKMessageEnum.GET_CATALOG);
    }

    public static void getPurchases(Context context, DaemonRequest.Callback callback) {
        DaemonRequest.executeAsync(context, (JSONObject) null, callback, SDKMessageEnum.GET_PURCHASES);
    }

    public static void purchase(Context context, String str, String str2, DaemonRequest.Callback callback) {
        try {
            DaemonRequest.executeAsync(context, new JSONObject().put(SDKConstants.PARAM_PRODUCT_ID, str).put(SDKConstants.PARAM_DEVELOPER_PAYLOAD, str2), callback, SDKMessageEnum.PURCHASE);
        } catch (JSONException e) {
            SDKLogger.logInternalError(context, SDKMessageEnum.PURCHASE, e);
        }
    }

    public static void consumePurchase(Context context, String str, DaemonRequest.Callback callback) {
        try {
            DaemonRequest.executeAsync(context, new JSONObject().put(SDKConstants.PARAM_PURCHASE_TOKEN, str), callback, SDKMessageEnum.CONSUME_PURCHASE);
        } catch (JSONException e) {
            SDKLogger.logInternalError(context, SDKMessageEnum.CONSUME_PURCHASE, e);
        }
    }
}
