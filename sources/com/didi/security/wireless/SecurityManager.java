package com.didi.security.wireless;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import android.view.MotionEvent;
import com.didi.remotereslibrary.Config;
import com.didi.security.uuid.ToolUtils;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didiglobal.ddmirror.monitor.PrismConstants;
import com.google.common.base.Ascii;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class SecurityManager {
    private static final String SDK_VERSION = "5.15.3";
    public static final String WSG_SIGN_KEY_NAME = "wsgsig";
    private static volatile boolean isInited = false;
    private static Context sContext;

    @Deprecated
    public static void funcSet(int i, boolean z) {
    }

    @Deprecated
    public static void setState(int i) {
    }

    public static String version() {
        return "5.15.3";
    }

    public static void initialize(Context context, String str, ISecurityDispatcher iSecurityDispatcher) throws DAQException {
        if (!isInited) {
            isInited = true;
            long nanoTime = System.nanoTime();
            if (sContext == null && context != null) {
                sContext = context.getApplicationContext();
                DAQUtils.setDispatcher(iSecurityDispatcher);
                SecurityController.getInstance().init(sContext);
                Region.initOne(sContext);
                ToolUtils.getInstance().initContext(sContext);
                SecurityLib.init(sContext);
                Region.initTwo(sContext);
            }
            long nanoTime2 = System.nanoTime();
            Logger.m27324i("TIME", "[+][MainThread][Init]:" + (nanoTime2 - nanoTime) + Config.KEY_NS);
        }
    }

    public static void setConfigure(ISecurityConf iSecurityConf) {
        SecurityLib.setConfigure(iSecurityConf);
    }

    public static void report(String str, String str2) {
        if (sContext != null && str2 != null && str2.getBytes().length <= 10240) {
            SecurityController.getInstance().post(SecurityMessage.obtainLocal(str, str2));
        }
    }

    public static String collect(String str) {
        if (sContext == null || str == null || "".equals(str)) {
            return null;
        }
        return SecurityLib.collect(str);
    }

    public static void reportByCmd(String str) {
        if (sContext != null) {
            SecurityController.getInstance().post(SecurityMessage.obtainCmd(str));
        }
    }

    @Deprecated
    public static String secKey(String str) {
        if (sContext == null) {
            return null;
        }
        return SecurityLib.secKey(str);
    }

    @Deprecated
    public static String secKey2(String str) throws DAQException {
        return SecurityLib.secKey2(str);
    }

    @Deprecated
    public static String secKey3(String str) throws DAQException {
        return SecurityLib.secKey3(str);
    }

    public static String sign(String str) {
        if (str == null) {
            return null;
        }
        try {
            return sign(str.getBytes("UTF-8"));
        } catch (Exception unused) {
            return errSign(DAQException.WSG_CODE_DATAENC_UNSUPPORTED);
        }
    }

    public static String sign(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        Context context = sContext;
        if (context == null) {
            return errSign(DAQException.WSG_CODE_NOTINIT);
        }
        return SecurityLib.sign(context, bArr);
    }

    public static String errSign(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            String a = DAQUtils.m27321a(sContext);
            String b = DAQUtils.m27322b(sContext);
            jSONObject.put("sv", "5.15.3");
            jSONObject.put("an", a);
            jSONObject.put(PrismConstants.Symbol.VIEW_CLASS, b);
            jSONObject.put("ec", i);
        } catch (Exception unused) {
        }
        String encodeToString = Base64.encodeToString(jSONObject.toString().getBytes(), 3);
        return "dd02-" + encodeToString;
    }

    public static boolean checkSign(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        for (byte b : str.getBytes()) {
            if ((b < 97 || b > 122) && ((b < 65 || b > 90) && ((b < 48 || b > 57) && b != 43 && b != 47 && b != 45))) {
                return false;
            }
        }
        return true;
    }

    public static String doSign(String str, String str2) {
        if (str2 == null) {
            str2 = "";
        }
        return doSign(prepareSign(str, str2.getBytes()));
    }

    public static String doSign(String str) {
        String sign = sign(str);
        return !checkSign(sign) ? errSign(DAQException.WSG_CODE_SIGN_CHARACTEREXCEPTION) : sign;
    }

    public static String prepareSign(String str, byte[] bArr) {
        try {
            String query = getQuery(str);
            byte[] body = getBody(bArr);
            Map<String, String> queryStringToMap = queryStringToMap(query);
            String bytesToHex = bytesToHex(body);
            if (!TextUtils.isEmpty(bytesToHex)) {
                queryStringToMap.put(bytesToHex, "");
            }
            return signMapToString(queryStringToMap);
        } catch (Exception unused) {
            return null;
        }
    }

    public static byte[] getBody(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        if (bArr.length <= 4096) {
            return (byte[]) bArr.clone();
        }
        byte[] bArr2 = new byte[4096];
        System.arraycopy(bArr, 0, bArr2, 0, 4096);
        return bArr2;
    }

    public static String getQuery(String str) {
        int i;
        try {
            int indexOf = str.indexOf("?");
            if (indexOf <= 0 || (i = indexOf + 1) >= str.length()) {
                return null;
            }
            return str.substring(i);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Map<String, String> queryStringToMap(String str) {
        HashMap hashMap = new HashMap();
        try {
            for (String str2 : str.split(ParamKeys.SIGN_AND)) {
                if (!TextUtils.isEmpty(str2)) {
                    String[] split = str2.split("=", 2);
                    if (split.length == 2) {
                        hashMap.put(URLDecoder.decode(split[0], "utf-8") + URLDecoder.decode(split[1], "utf-8"), "");
                    } else {
                        hashMap.put(URLDecoder.decode(split[0], "utf-8"), "");
                    }
                }
            }
        } catch (Exception unused) {
        }
        return hashMap;
    }

    public static String signMapToString(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        try {
            ArrayList arrayList = new ArrayList(map.keySet());
            Collections.sort(arrayList, Collections.reverseOrder());
            for (int i = 0; i < arrayList.size(); i++) {
                String str = (String) arrayList.get(i);
                if (!str.startsWith("__x_")) {
                    if (!"wsgsig".equalsIgnoreCase(str)) {
                        sb.append(str);
                        sb.append(map.get(str));
                    }
                }
            }
        } catch (Exception unused) {
        }
        return sb.toString();
    }

    public static String bytesToHex(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        char[] charArray = "0123456789abcdef".toCharArray();
        char[] cArr = new char[(bArr.length * 2)];
        for (int i = 0; i < bArr.length; i++) {
            byte b = bArr[i] & 255;
            int i2 = i * 2;
            cArr[i2] = charArray[b >>> 4];
            cArr[i2 + 1] = charArray[b & Ascii.f53593SI];
        }
        return new String(cArr);
    }

    public static void touchReset() {
        SecurityLib.touchReset();
    }

    public static void onTouch(MotionEvent motionEvent) {
        SecurityLib.onTouch(motionEvent);
    }

    public static void setHost(String str) {
        SecurityLib.nativeSetHost(str);
    }

    public static String getHost() {
        try {
            return new URL(SecurityLib.nativeGetHost()).getHost();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
