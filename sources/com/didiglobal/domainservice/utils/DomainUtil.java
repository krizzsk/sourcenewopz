package com.didiglobal.domainservice.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.didi.hawaii.mapsdkv2.HWMapConstant;
import com.didi.sdk.apm.SystemUtils;
import com.didiglobal.domainservice.DomainServiceManager;
import com.didiglobal.domainservice.IDomainFilter;
import com.didiglobal.domainservice.IDomainSwitchCondition;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import org.json.JSONArray;

public class DomainUtil {
    public static String rebuildHost(String str, String str2) {
        List<IDomainFilter> domainFilterInList = DomainServiceManager.getInstance().getDomainFilterInList();
        if (domainFilterInList == null || domainFilterInList.size() <= 0) {
            return rebuildHost(str, str2, (Set<String>) new HashSet());
        }
        return rebuildHost(str, str2, DomainServiceManager.getInstance().getDomainFilterInList());
    }

    public static String rebuildHost(String str, String str2, Set<String> set) {
        String[] split;
        if (!isDomainSuffixValid(str2) || (split = str.split("\\.")) == null || split.length <= 0 || split.length > 3) {
            return str;
        }
        if (set != null && set.size() > 0) {
            if (str.indexOf(HWMapConstant.HTTP.SEPARATOR) > 0) {
                String substring = str.substring(str.indexOf(HWMapConstant.HTTP.SEPARATOR) + 3);
                if (substring.indexOf("/") > 0) {
                    substring = substring.substring(0, substring.indexOf("/"));
                }
                if (set.contains(substring)) {
                    return str;
                }
            } else if (set.contains(str)) {
                return str;
            }
        }
        split[0] = m36055a(split[0], str2);
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        for (String append : split) {
            stringBuffer.append(append);
            if (i < split.length - 1) {
                stringBuffer.append(".");
                i++;
            }
        }
        return stringBuffer.toString();
    }

    public static String rebuildHost(String str, String str2, List<IDomainFilter> list) {
        String[] split;
        if (!isDomainSuffixValid(str2) || (split = str.split("\\.")) == null || split.length <= 0 || split.length > 3) {
            return str;
        }
        if (list != null && list.size() > 0) {
            for (IDomainFilter filterDomain : list) {
                if (filterDomain.filterDomain(str)) {
                    ELog.log("Host:" + str + " found in host whitelist RETURN!");
                    return str;
                }
            }
        }
        split[0] = m36055a(split[0], str2);
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        for (String append : split) {
            stringBuffer.append(append);
            if (i < split.length - 1) {
                stringBuffer.append(".");
                i++;
            }
        }
        return stringBuffer.toString();
    }

    public static boolean checkUrlSupportDomainSwitch(String str) {
        return checkUrlSupportDomainSwitch(str, DomainServiceManager.getInstance().getDomainFilterInList());
    }

    public static boolean checkUrlSupportDomainSwitch(String str, List<IDomainFilter> list) {
        try {
            String host = new URL(str).getHost();
            String[] split = host.split("\\.");
            if (split != null && split.length > 0) {
                if (split.length <= 3) {
                    if (list != null && list.size() > 0) {
                        for (IDomainFilter filterDomain : list) {
                            if (filterDomain.filterDomain(host)) {
                                ELog.log("Host: " + host + " filter hit return!");
                                return false;
                            }
                        }
                    }
                    if (isInIpFormat(host)) {
                        return false;
                    }
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            ELog.log("check url support domain switch catch err:" + e.getMessage() + " when format URL with: " + str);
            return false;
        }
    }

    public static boolean checkHostSupportDomainSwitch(String str) {
        return checkHostSupportDomainSwitch(str, DomainServiceManager.getInstance().getDomainFilterInList());
    }

    public static boolean checkHostSupportDomainSwitch(String str, List<IDomainFilter> list) {
        String[] split = str.split("\\.");
        if (split == null || split.length <= 0 || split.length > 3) {
            return false;
        }
        if (list == null || list.size() <= 0) {
            return true;
        }
        for (IDomainFilter filterDomain : list) {
            if (filterDomain.filterDomain(str)) {
                ELog.log("Host:" + str + " found in host whitelist RETURN!");
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    private static String m36055a(String str, String str2) {
        if (Pattern.compile("(-g|-ru|-us|-de)").matcher(str).find()) {
            return str.substring(0, str.lastIndexOf("-")) + "-" + str2;
        }
        return str + "-" + str2;
    }

    public static boolean isDomainSuffixValid(String str) {
        if (str == null || str.trim().length() == 0 || "g.ru.us.de".indexOf(str.toLowerCase()) < 0) {
            return false;
        }
        return true;
    }

    public static boolean isInIpFormat(String str) {
        return Pattern.compile("(\\d{1,3})(\\.\\d{1,3})").matcher(str).find();
    }

    public static String rebuildUrl(String str, String str2) {
        return rebuildUrl(str, str2, (Set<String>) new HashSet(), true);
    }

    public static String rebuildUrl(String str, String str2, boolean z) {
        return rebuildUrl(str, str2, (Set<String>) new HashSet(), z);
    }

    public static String rebuildUrl(String str, String str2, Set<String> set) {
        return rebuildUrl(str, str2, set, true);
    }

    public static String rebuildUrl(String str, String str2, Set<String> set, boolean z) {
        if (z && !isDomainSuffixValid(str2)) {
            return str;
        }
        try {
            URL url = new URL(str);
            String host = url.getHost();
            String[] split = host.split("\\.");
            if (split == null || split.length <= 0) {
                return str;
            }
            if (split.length > 3) {
                return str;
            }
            if (url.getPort() > 0) {
                PrintStream printStream = System.out;
                printStream.println("port:" + url.getPort());
                return str;
            } else if (set != null && set.size() > 0 && set.contains(host)) {
                ELog.log("Host: " + host + " hit whitelist return!");
                return str;
            } else if (isInIpFormat(host)) {
                return str;
            } else {
                String substring = host.substring(0, host.indexOf("."));
                return str.replaceFirst(substring, m36055a(substring, str2));
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
            PrintStream printStream2 = System.out;
            printStream2.println("invalid url string:" + str);
            return str;
        }
    }

    public static String rebuildUrl(String str, String str2, List<IDomainFilter> list) {
        return rebuildUrl(str, str2, list, true);
    }

    public static String rebuildUrl(String str, String str2, List<IDomainFilter> list, boolean z) {
        if (z && !isDomainSuffixValid(str2)) {
            return str;
        }
        try {
            URL url = new URL(str);
            String host = url.getHost();
            String[] split = host.split("\\.");
            if (split == null || split.length <= 0) {
                return str;
            }
            if (split.length > 3) {
                return str;
            }
            if (url.getPort() > 0) {
                PrintStream printStream = System.out;
                printStream.println("port:" + url.getPort());
                return str;
            }
            if (list != null && list.size() > 0) {
                for (IDomainFilter filterDomain : list) {
                    if (filterDomain.filterDomain(host)) {
                        ELog.log("Host: " + host + " filter hit return!");
                        return str;
                    }
                }
            }
            if (isInIpFormat(host)) {
                return str;
            }
            String substring = host.substring(0, host.indexOf("."));
            return str.replaceFirst(substring, m36055a(substring, str2));
        } catch (MalformedURLException e) {
            e.printStackTrace();
            PrintStream printStream2 = System.out;
            printStream2.println("invalid url string:" + str);
            return str;
        }
    }

    public static String trunckURLRootPath(String str) {
        if (str == null || str.trim().length() == 0) {
            ELog.log("invalid url.");
            return str;
        } else if (str.startsWith("https://") || str.startsWith("http://")) {
            try {
                URL url = new URL(str);
                String protocol = url.getProtocol();
                String host = url.getHost();
                return protocol + HWMapConstant.HTTP.SEPARATOR + host + "/";
            } catch (MalformedURLException e) {
                e.printStackTrace();
                String substring = str.contains("?") ? str.substring(0, str.indexOf("?")) : str;
                String substring2 = substring.substring(str.indexOf(HWMapConstant.HTTP.SEPARATOR) + 3);
                int indexOf = substring.indexOf(HWMapConstant.HTTP.SEPARATOR) + 3;
                PrintStream printStream = System.out;
                printStream.println("url without scheme = " + substring2);
                int indexOf2 = substring2.indexOf("/");
                if (indexOf2 <= 0) {
                    PrintStream printStream2 = System.out;
                    printStream2.println("invalid url: " + str);
                    return str;
                }
                return substring.substring(0, indexOf + indexOf2) + "/";
            }
        } else {
            System.out.println("url without protocal");
            return str;
        }
    }

    public static boolean isSupportDomainSwitch(Context context) {
        boolean z;
        Iterator<IDomainSwitchCondition> it = DomainServiceManager.getInstance().getDomainCondsInList().iterator();
        loop0:
        while (true) {
            z = true;
            while (true) {
                if (!it.hasNext()) {
                    break loop0;
                }
                IDomainSwitchCondition next = it.next();
                if (!z || !next.isAllowDomainSwitch(context)) {
                    z = false;
                }
            }
        }
        if (!((Boolean) getMetaDataByKey(context, DomainConstants.DYNAMIC_DOMAIN, false)).booleanValue() || !z) {
            return false;
        }
        return true;
    }

    public static <T> T isSupportDomainSwitch(Context context, String str, T t) {
        return getMetaDataByKey(context, str, t);
    }

    public static boolean isSupportDomainSwitchForIdc(Context context) {
        return ((Boolean) getMetaDataByKey(context, DomainConstants.DYNAMIC_DOMAIN_FOR_IDC, false)).booleanValue();
    }

    public static <T> T getMetaDataByKey(Context context, String str, T t) {
        T t2;
        try {
            PackageInfo packageInfo = SystemUtils.getPackageInfo(context.getPackageManager(), context.getPackageName(), 16512);
            if (packageInfo.applicationInfo == null || packageInfo.applicationInfo.metaData == null || (t2 = packageInfo.applicationInfo.metaData.get(str)) == null) {
                return t;
            }
            return t2;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<String> jsArrayToList(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(jSONArray.optString(i));
        }
        return arrayList;
    }
}
