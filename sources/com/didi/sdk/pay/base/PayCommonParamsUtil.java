package com.didi.sdk.pay.base;

import android.content.Context;
import android.util.Pair;
import com.didi.sdk.util.SingletonHolder;
import java.util.HashMap;

public class PayCommonParamsUtil {

    /* renamed from: a */
    private CommonParamsProxy f36889a;

    public interface CommonParamsProxy {
        HashMap<String, Object> addCommonParam(HashMap<String, Object> hashMap, Context context);

        String createCommonParamJson(Context context);

        String createCommonParamString(Context context);

        HashMap<String, Object> getCommonParam(Context context);

        Object getCurrency();

        String getDeviceId(Context context);

        String getLang();

        Pair<Double, Double> getLastKnownLocation(Context context);

        String getLocaleCode();

        String getPid(Context context);

        HashMap<String, Object> getRiskParam(Context context);

        String getSUUID(Context context);

        int getStartCityId();

        String getToken(Context context);

        String getUUID(Context context);

        String getUid(Context context);

        boolean isLogin(Context context);

        boolean isTestNow();

        void startLogin(Context context);
    }

    private PayCommonParamsUtil() {
    }

    public static PayCommonParamsUtil getInstance() {
        return (PayCommonParamsUtil) SingletonHolder.getInstance(PayCommonParamsUtil.class);
    }

    public void setCommonParamsProxy(CommonParamsProxy commonParamsProxy) {
        this.f36889a = commonParamsProxy;
        PayBaseInjecter.injectCommonParamsProxy(commonParamsProxy);
    }

    public HashMap<String, Object> addCommonParam(HashMap<String, Object> hashMap, Context context) {
        if (hashMap == null) {
            return new HashMap<>();
        }
        CommonParamsProxy commonParamsProxy = this.f36889a;
        if (commonParamsProxy == null) {
            return hashMap;
        }
        return commonParamsProxy.addCommonParam(hashMap, context);
    }

    public String createCommonParamJson(Context context) {
        CommonParamsProxy commonParamsProxy = this.f36889a;
        if (commonParamsProxy == null) {
            return "";
        }
        return commonParamsProxy.createCommonParamJson(context);
    }

    public String createCommonParamString(Context context) {
        CommonParamsProxy commonParamsProxy = this.f36889a;
        if (commonParamsProxy == null) {
            return "";
        }
        return commonParamsProxy.createCommonParamString(context);
    }

    public Pair<Double, Double> getLastKnownLocation(Context context) {
        CommonParamsProxy commonParamsProxy = this.f36889a;
        if (commonParamsProxy == null) {
            return null;
        }
        return commonParamsProxy.getLastKnownLocation(context);
    }

    public String getDeviceId(Context context) {
        CommonParamsProxy commonParamsProxy = this.f36889a;
        if (commonParamsProxy == null) {
            return "";
        }
        return commonParamsProxy.getDeviceId(context);
    }

    public String getSUUID(Context context) {
        CommonParamsProxy commonParamsProxy = this.f36889a;
        if (commonParamsProxy == null) {
            return "";
        }
        return commonParamsProxy.getSUUID(context);
    }

    public String getLocaleCode() {
        CommonParamsProxy commonParamsProxy = this.f36889a;
        if (commonParamsProxy == null) {
            return "";
        }
        return commonParamsProxy.getLocaleCode();
    }

    public boolean isLogin(Context context) {
        CommonParamsProxy commonParamsProxy = this.f36889a;
        if (commonParamsProxy == null) {
            return false;
        }
        return commonParamsProxy.isLogin(context);
    }

    public void startLogin(Context context) {
        CommonParamsProxy commonParamsProxy = this.f36889a;
        if (commonParamsProxy != null) {
            commonParamsProxy.startLogin(context);
        }
    }

    public String getToken(Context context) {
        CommonParamsProxy commonParamsProxy = this.f36889a;
        if (commonParamsProxy == null) {
            return "";
        }
        return commonParamsProxy.getToken(context);
    }

    public Object getCurrency() {
        CommonParamsProxy commonParamsProxy = this.f36889a;
        if (commonParamsProxy == null) {
            return null;
        }
        return commonParamsProxy.getCurrency();
    }

    public String getLang() {
        CommonParamsProxy commonParamsProxy = this.f36889a;
        if (commonParamsProxy == null) {
            return "";
        }
        return commonParamsProxy.getLang();
    }

    public boolean isTestNow() {
        CommonParamsProxy commonParamsProxy = this.f36889a;
        if (commonParamsProxy == null) {
            return false;
        }
        return commonParamsProxy.isTestNow();
    }

    public String getPid(Context context) {
        CommonParamsProxy commonParamsProxy = this.f36889a;
        if (commonParamsProxy == null) {
            return "";
        }
        return commonParamsProxy.getPid(context);
    }

    public String getUid(Context context) {
        CommonParamsProxy commonParamsProxy = this.f36889a;
        if (commonParamsProxy == null) {
            return "";
        }
        return commonParamsProxy.getUid(context);
    }

    public String getUUID(Context context) {
        CommonParamsProxy commonParamsProxy = this.f36889a;
        if (commonParamsProxy == null) {
            return "";
        }
        return commonParamsProxy.getUUID(context);
    }

    public int getStartCityId() {
        CommonParamsProxy commonParamsProxy = this.f36889a;
        if (commonParamsProxy == null) {
            return -1;
        }
        return commonParamsProxy.getStartCityId();
    }

    public HashMap<String, Object> getRiskParam(Context context) {
        CommonParamsProxy commonParamsProxy = this.f36889a;
        if (commonParamsProxy == null) {
            return new HashMap<>();
        }
        return commonParamsProxy.getRiskParam(context);
    }

    public HashMap<String, Object> getCommonParam(Context context) {
        CommonParamsProxy commonParamsProxy = this.f36889a;
        if (commonParamsProxy == null) {
            return new HashMap<>();
        }
        return commonParamsProxy.getCommonParam(context);
    }
}
