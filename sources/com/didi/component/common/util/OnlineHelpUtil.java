package com.didi.component.common.util;

import android.content.Context;
import android.content.Intent;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.web.GlobalWebUrl;
import com.didi.component.common.GlobalWebActivity;
import com.didi.sdk.nation.NationComponentData;
import com.didi.sdk.nation.NationTypeUtil;
import java.util.HashMap;

public class OnlineHelpUtil {
    public static final String DEFAULT_ON_SERVICE_SOURCE_PARAM = "app_globalck_xcz";
    public static final String DEFAULT_OTHER_PAGE_SOURCE_PARAM = "app_globalck_home";

    public static void startOnServiceHelp(Context context) {
        startHelp(context, GlobalWebUrl.getServiceHelpUrl(context, (String) null), DEFAULT_ON_SERVICE_SOURCE_PARAM);
    }

    public static void startOnServiceHelp(Context context, String str) {
        Intent intent = new Intent(context, GlobalWebActivity.class);
        intent.putExtra("web_view_model", GlobalWebUrl.buildWebViewModel(str));
        context.startActivity(intent);
    }

    public static void startOtherPageHelp(Context context) {
        startHelp(context, GlobalWebUrl.getOtherPageHelpUrl(context, (String) null), DEFAULT_OTHER_PAGE_SOURCE_PARAM);
    }

    public static void startHelp(Context context, String str, String str2) {
        Intent startIntent = getStartIntent(context, str, str2);
        if (startIntent != null) {
            context.startActivity(startIntent);
        }
    }

    public static Intent getStartIntent(Context context, String str, String str2) {
        if (CarOrderHelper.getOrder() == null) {
            return null;
        }
        int i = 0;
        String str3 = "";
        String oid = CarOrderHelper.getOrder() != null ? CarOrderHelper.getOrder().getOid() : str3;
        NationComponentData nationComponentData = NationTypeUtil.getNationComponentData();
        if (nationComponentData != null) {
            i = nationComponentData.getTimeZoneUtcOffset();
            str3 = nationComponentData.getLocaleCode();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("orderId", oid);
        hashMap.put("utc_offset", Integer.valueOf(i));
        hashMap.put("locale", str3);
        hashMap.put("source", str2);
        String buildUrl = GlobalWebUrl.buildUrl(str, hashMap);
        Intent intent = new Intent(context, GlobalWebActivity.class);
        intent.putExtra("web_view_model", GlobalWebUrl.buildWebViewModel(buildUrl));
        return intent;
    }
}
