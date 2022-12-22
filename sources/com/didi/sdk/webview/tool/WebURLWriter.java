package com.didi.sdk.webview.tool;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.didi.sdk.fusionbridge.FusionUtil;
import com.didi.sdk.nation.NationComponentData;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.push.ServerParam;
import com.didi.sdk.security.SecurityUtil;
import com.didi.sdk.util.MD5;
import com.didi.sdk.util.MixFlagUtil;
import com.didi.sdk.util.SystemUtil;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.util.Utils;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.foundation.spi.ServiceLoader;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WebURLWriter {
    public static String SIGN_KEY = "*&didi@";

    public static String combineBaseWebInfo(Context context, boolean z) {
        return m27285a(m27286a(m27287a(context, z)));
    }

    public static List<Pair<String, String>> combineBaseWebInfoAsPairList(Context context, boolean z) {
        return m27286a(m27287a(context, z));
    }

    /* renamed from: a */
    private static Map<String, String> m27287a(Context context, boolean z) {
        HashMap hashMap = new HashMap();
        NationComponentData.LoginInfo loginInfo = NationTypeUtil.getNationComponentData().getLoginInfo();
        String token = loginInfo.getToken();
        String phone = loginInfo.getPhone();
        if (!TextUtil.isEmpty(token) && z) {
            hashMap.put("token", URLEncoder.encode(token));
        }
        if (!TextUtil.isEmpty(phone)) {
            hashMap.put("phone", DesEncryptUtils.encode("*&^%$#@!", phone).trim());
        }
        NationComponentData nationComponentData = NationTypeUtil.getNationComponentData();
        hashMap.put("vcode", String.valueOf(SystemUtil.getVersionCode()));
        hashMap.put("dviceid", SecurityUtil.getDeviceId());
        hashMap.put("deviceid", SecurityUtil.getDeviceId());
        hashMap.put("platform", "1");
        hashMap.put("datatype", "1");
        hashMap.put("model", Utils.getModel());
        hashMap.put("appversion", Utils.getCurrentVersion(context));
        hashMap.put("os", TextUtil.encode(Build.VERSION.RELEASE));
        hashMap.put("imei", SystemUtil.getIMEI());
        hashMap.put("channel", SystemUtil.getChannelId());
        hashMap.put("lang", nationComponentData.getLocaleCode());
        hashMap.put("mix_flag", String.valueOf(MixFlagUtil.getMixFlag(context)));
        hashMap.put("location_country", nationComponentData.getLocCountry());
        hashMap.put("location_cityid", nationComponentData.getCityId());
        hashMap.put("origin_id", nationComponentData.getOriginID());
        DIDILocation didiLocation = nationComponentData.getDidiLocation();
        if (didiLocation != null) {
            hashMap.put("lng", String.valueOf(didiLocation.getLongitude()));
            hashMap.put("lat", String.valueOf(didiLocation.getLatitude()));
        }
        int intValue = Integer.valueOf(nationComponentData.getCityId()).intValue();
        if (intValue != -1) {
            hashMap.put("city_id", String.valueOf(intValue));
            hashMap.put("cityid", String.valueOf(intValue));
        }
        if (!TextUtils.isEmpty(nationComponentData.getCityName())) {
            hashMap.put("area", nationComponentData.getCityName());
        }
        hashMap.put("uuid", SecurityUtil.getUUID());
        hashMap.put("suuid", SecurityUtil.getSUUID());
        hashMap.put("time", System.currentTimeMillis() + "");
        hashMap.put("susig", MD5.toMD5(SecurityUtil.getSUUID() + SIGN_KEY).substring(3).toLowerCase());
        hashMap.put("uid", loginInfo.getUid());
        hashMap.put("product_id", m27284a() + "");
        hashMap.put(ServerParam.PARAM_TOP_BAR_HEIGHT, FusionUtil.getTopBarHeight() + "");
        return hashMap;
    }

    /* renamed from: a */
    private static int m27284a() {
        IWebProductIdService iWebProductIdService = (IWebProductIdService) ServiceLoader.load(IWebProductIdService.class).get();
        if (iWebProductIdService != null) {
            return iWebProductIdService.getProductId();
        }
        return 0;
    }

    /* renamed from: a */
    private static List<Pair<String, String>> m27286a(Map<String, String> map) {
        List<Pair<String, String>> b = m27288b(map);
        Collections.sort(b, new KVPairComparator());
        return b;
    }

    public static List<Pair<String, String>> queryStringToPairList(String str) {
        LinkedList linkedList = new LinkedList();
        if (TextUtils.isEmpty(str)) {
            return linkedList;
        }
        for (String str2 : str.split(ParamKeys.SIGN_AND)) {
            if (!TextUtils.isEmpty(str2)) {
                String[] split = str2.split("=");
                if (split.length == 2) {
                    linkedList.add(new Pair(split[0], split[1]));
                }
            }
        }
        return linkedList;
    }

    /* renamed from: a */
    private static String m27285a(List<Pair<String, String>> list) {
        if (list == null || list.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Pair next : list) {
            String encode = TextUtil.encode((String) next.first);
            String encode2 = TextUtil.encode((String) next.second);
            if (sb.length() > 0) {
                sb.append(ParamKeys.SIGN_AND);
            }
            sb.append(encode);
            sb.append("=");
            sb.append(encode2);
        }
        return sb.toString();
    }

    public static Uri replaceUriParameter(Uri uri, String str, String str2) {
        String str3;
        Set<String> queryParameterNames = uri.getQueryParameterNames();
        Uri.Builder clearQuery = uri.buildUpon().clearQuery();
        for (String next : queryParameterNames) {
            if (next.equals(str)) {
                str3 = str2;
            } else {
                str3 = uri.getQueryParameter(next);
            }
            clearQuery.appendQueryParameter(next, str3);
        }
        return clearQuery.build();
    }

    public static Uri deleteUriParameter(Uri uri, String str) {
        Set<String> queryParameterNames = uri.getQueryParameterNames();
        Uri.Builder clearQuery = uri.buildUpon().clearQuery();
        for (String next : queryParameterNames) {
            if (!next.equals(str)) {
                clearQuery.appendQueryParameter(next, uri.getQueryParameter(next));
            }
        }
        return clearQuery.build();
    }

    public static Uri appendUriQuery(Uri uri, List<Pair<String, String>> list) {
        if (list == null) {
            return uri;
        }
        Uri.Builder buildUpon = uri.buildUpon();
        String encodedQuery = uri.getEncodedQuery();
        StringBuilder sb = new StringBuilder();
        for (Pair next : list) {
            String str = (String) next.first;
            String str2 = (String) next.second;
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if (sb.length() != 0) {
                    sb.append(ParamKeys.SIGN_AND);
                }
                sb.append(str);
                sb.append("=");
                sb.append(str2);
            }
        }
        if (encodedQuery == null || encodedQuery.isEmpty()) {
            buildUpon.encodedQuery(sb.toString());
        } else {
            sb.append(ParamKeys.SIGN_AND);
            sb.append(encodedQuery);
            buildUpon.encodedQuery(sb.toString());
        }
        return buildUpon.build();
    }

    public static Uri appendEncodedUriQuery(Uri uri, String str) {
        if (TextUtils.isEmpty(str)) {
            return uri;
        }
        String encodedQuery = uri.getEncodedQuery();
        if (TextUtils.isEmpty(encodedQuery)) {
            if (str.startsWith(ParamKeys.SIGN_AND)) {
                str = str.substring(1);
            }
        } else if (str.startsWith(ParamKeys.SIGN_AND)) {
            str = encodedQuery + str;
        } else {
            str = encodedQuery + ParamKeys.SIGN_AND + str;
        }
        return uri.buildUpon().clearQuery().encodedQuery(str).build();
    }

    /* renamed from: b */
    private static List<Pair<String, String>> m27288b(Map<String, String> map) {
        LinkedList linkedList = new LinkedList();
        if (!(map == null || map.size() == 0)) {
            for (String next : map.keySet()) {
                if (!TextUtils.isEmpty(next) && !next.startsWith("__x_")) {
                    String str = map.get(next);
                    if (!TextUtils.isEmpty(str)) {
                        linkedList.add(new Pair(next, str));
                    }
                }
            }
        }
        return linkedList;
    }

    static class KVPairComparator implements Comparator<Pair<String, String>> {
        KVPairComparator() {
        }

        public int compare(Pair<String, String> pair, Pair<String, String> pair2) {
            return ((String) pair.first).compareTo((String) pair2.first);
        }
    }
}
