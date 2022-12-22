package com.didi.soda.web;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.didi.onehybrid.BusinessAgent;
import com.didi.onehybrid.util.MD5;
import com.didi.soda.web.tools.SystemUtils;
import com.didi.soda.web.tools.UrlWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class BizAgent extends BusinessAgent {
    public static final String TYPE_CUSTOMER = "Soda.Customer";
    public static final String TYPE_DELIVERY = "Soda.Rider";
    public static final String TYPE_EMBEDCUSTOMER = "Soda.EmbedCustomer";
    public static final String TYPE_MANAGER = "Soda.Manager";
    public static final String TYPE_MERCHANT = "Soda.Merchant";
    public static final String TYPE_PAD_MERCHANT = "Soda.PadMerchant";

    /* renamed from: a */
    private static String f43851a = "*&didi@";

    /* renamed from: c */
    private static List<String> f43852c = m31203b();

    /* renamed from: d */
    private static List<String> f43853d = m31201a();

    /* renamed from: b */
    private final Context f43854b;

    /* access modifiers changed from: protected */
    public List<String> getAllowMixContentList() {
        return null;
    }

    public abstract String getAppUserAgent();

    public List<String> getBlackList() {
        return null;
    }

    /* access modifiers changed from: protected */
    public abstract String getChannelId();

    /* access modifiers changed from: protected */
    public abstract String getDiDiSUUID();

    /* access modifiers changed from: protected */
    public abstract double getLatitude();

    /* access modifiers changed from: protected */
    public abstract String getLocale();

    /* access modifiers changed from: protected */
    public abstract double getLongitude();

    /* access modifiers changed from: protected */
    public abstract String getMapType();

    public String getUserPhone() {
        return null;
    }

    public boolean needRequestPermission() {
        return true;
    }

    /* renamed from: a */
    private static List<String> m31201a() {
        ArrayList arrayList = new ArrayList();
        f43853d = arrayList;
        arrayList.add("rlab.xyz");
        f43853d.add("didi-food.com");
        return f43853d;
    }

    /* renamed from: b */
    private static List<String> m31203b() {
        ArrayList arrayList = new ArrayList();
        f43852c = arrayList;
        arrayList.add("didiopenapi.com");
        f43852c.add("didichuxing.com");
        f43852c.add("didiqiche.com");
        f43852c.add("didishangye.com");
        f43852c.add("didistatic.com");
        f43852c.add("walletranship.com");
        f43852c.add("didialift.com");
        f43852c.add("zhidabanche.com");
        f43852c.add("xiaojukeji.com");
        f43852c.add("kuaidadi.com");
        f43852c.add("udache.com");
        f43852c.add("dc.tt");
        f43852c.add("ofo-didi.ofo.so");
        f43852c.add("cmbchina.com");
        f43852c.add("didimobility.com");
        f43852c.add("rlab.xyz");
        f43852c.add("didi-food.com");
        f43852c.add("didiglobal.com");
        f43852c.add("99app.com");
        return f43852c;
    }

    public BizAgent(Context context) {
        super(context);
        this.f43854b = context;
    }

    /* renamed from: a */
    private boolean m31202a(String str) {
        List<String> bridgeWhiteList = getBridgeWhiteList();
        if (bridgeWhiteList == null || bridgeWhiteList.isEmpty()) {
            return true;
        }
        return UrlWriter.isInHostList(str, bridgeWhiteList);
    }

    public boolean isAllowMixContent(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int indexOf = str.indexOf("?");
        if (indexOf > -1) {
            str = str.substring(0, indexOf);
        }
        if (!str.startsWith("http")) {
            return false;
        }
        return UrlWriter.isInHostList(str, getAllowMixContentList());
    }

    public boolean isWhiteUrl(Context context, String str) {
        return m31202a(str);
    }

    /* access modifiers changed from: protected */
    public List<String> getBridgeWhiteList() {
        return getAppendParameterList();
    }

    public List<String> getAppendParameterList() {
        return f43852c;
    }

    /* access modifiers changed from: protected */
    public List<String> getReplaceLocaleList() {
        return f43853d;
    }

    public String addCommonQuery(String str) {
        if (TextUtils.isEmpty(str) || !UrlWriter.isInHostList(str, getAppendParameterList())) {
            return str;
        }
        if (!str.startsWith("http:") && !str.startsWith("https:")) {
            return str;
        }
        if (str.contains("${locale}") && UrlWriter.isInHostList(str, getReplaceLocaleList())) {
            str = str.replace("${locale}", getLocale());
        }
        Uri parse = Uri.parse(str);
        HashMap hashMap = new HashMap();
        hashMap.put("locale", getLanguage());
        hashMap.put("lang", getLanguage());
        hashMap.put("lng", String.valueOf(getLongitude()));
        hashMap.put("lat", String.valueOf(getLatitude()));
        hashMap.put("appversion", SystemUtils.getVersionName(this.f43854b));
        hashMap.put("channel", getChannelId());
        hashMap.put("os", Build.VERSION.RELEASE);
        hashMap.put("model", SystemUtils.getModel());
        hashMap.put("sig", MD5.toMD5(getDiDiSUUID() + f43851a).substring(3).toLowerCase());
        hashMap.put("maptype", getMapType());
        return UrlWriter.executeAppend(parse, hashMap).toString();
    }

    /* access modifiers changed from: protected */
    public String getLanguage() {
        return getLocale();
    }
}
