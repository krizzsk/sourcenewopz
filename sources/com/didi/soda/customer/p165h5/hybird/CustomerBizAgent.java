package com.didi.soda.customer.p165h5.hybird;

import android.content.Context;
import android.os.Build;
import com.didi.sdk.util.SUUIDHelper;
import com.didi.sdk.util.SystemUtil;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.foundation.storage.AppConfigStorage;
import com.didi.soda.customer.foundation.util.CustomerApolloUtil;
import com.didi.soda.customer.foundation.util.SingletonFactory;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.ILocaleService;
import com.didi.soda.web.BizAgent;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationManager;
import java.util.Collections;
import java.util.List;

/* renamed from: com.didi.soda.customer.h5.hybird.CustomerBizAgent */
public class CustomerBizAgent extends BizAgent {
    public String getAppUserAgent() {
        return "Soda.EmbedCustomer";
    }

    /* access modifiers changed from: protected */
    public String getMapType() {
        return "";
    }

    public boolean shouldIntercept(Context context, String str) {
        return true;
    }

    public CustomerBizAgent(Context context) {
        super(context);
    }

    public List<String> getAppendParameterList() {
        List<String> appendParameterList = CustomerApolloUtil.getAppendParameterList();
        if (appendParameterList == null || appendParameterList.isEmpty()) {
            return super.getAppendParameterList();
        }
        List<String> appendParameterList2 = super.getAppendParameterList();
        for (String next : appendParameterList) {
            if (!appendParameterList2.contains(next)) {
                appendParameterList2.add(next);
            }
        }
        return appendParameterList2;
    }

    public List<String> getBlackList() {
        return CustomerApolloUtil.getBlackList();
    }

    public List<String> getPreloadUrlList() {
        if (Build.VERSION.SDK_INT < 19) {
            return Collections.emptyList();
        }
        return ((AppConfigStorage) SingletonFactory.get(AppConfigStorage.class)).getData().mPreloadList;
    }

    /* access modifiers changed from: protected */
    public List<String> getReplaceLocaleList() {
        List<String> replaceLocaleList = CustomerApolloUtil.getReplaceLocaleList();
        if (replaceLocaleList == null || replaceLocaleList.isEmpty()) {
            List<String> replaceLocaleList2 = super.getReplaceLocaleList();
            replaceLocaleList2.add("99app.com");
            replaceLocaleList2.add("didiglobal.com");
            return replaceLocaleList2;
        }
        List<String> replaceLocaleList3 = super.getReplaceLocaleList();
        for (String next : replaceLocaleList) {
            if (!replaceLocaleList3.contains(next)) {
                replaceLocaleList3.add(next);
            }
        }
        return replaceLocaleList3;
    }

    /* access modifiers changed from: protected */
    public String getLocale() {
        return ((ILocaleService) CustomerServiceManager.getService(ILocaleService.class)).getCurrentLocaleTag();
    }

    /* access modifiers changed from: protected */
    public String getLanguage() {
        return ((ILocaleService) CustomerServiceManager.getService(ILocaleService.class)).getLangTag();
    }

    /* access modifiers changed from: protected */
    public String getDiDiSUUID() {
        return SUUIDHelper.getDiDiSUUID();
    }

    /* access modifiers changed from: protected */
    public String getChannelId() {
        return SystemUtil.getChannelId();
    }

    /* access modifiers changed from: protected */
    public double getLatitude() {
        DIDILocation lastKnownLocation = DIDILocationManager.getInstance(GlobalContext.getContext()).getLastKnownLocation();
        if (lastKnownLocation != null) {
            return lastKnownLocation.getLatitude();
        }
        return 0.0d;
    }

    /* access modifiers changed from: protected */
    public double getLongitude() {
        DIDILocation lastKnownLocation = DIDILocationManager.getInstance(GlobalContext.getContext()).getLastKnownLocation();
        if (lastKnownLocation != null) {
            return lastKnownLocation.getLongitude();
        }
        return 0.0d;
    }
}
