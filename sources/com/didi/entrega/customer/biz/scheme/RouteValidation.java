package com.didi.entrega.customer.biz.scheme;

import android.net.Uri;
import android.text.TextUtils;
import com.didi.entrega.customer.foundation.log.util.LogUtil;

public class RouteValidation {
    public static final String WALLET_PATH = "walletPage";

    /* renamed from: a */
    private static final String f19831a = "globalOneTravel";

    /* renamed from: b */
    private static final String f19832b = "taxis99OneTravel";

    public static boolean isIMLocationSchemeUri(Uri uri) {
        LogUtil.m14761d("TAG", "isIMLocationSchemeUri" + uri);
        if (uri == null) {
            return false;
        }
        LogUtil.m14761d("TAG", "isIMLocationSchemeUri" + uri.toString());
        String path = uri.getPath();
        if (TextUtils.isEmpty(path)) {
            return false;
        }
        return path.contains("beatles_im_location");
    }

    public static boolean isWebSchemeUri(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.startsWith("http") || str.startsWith("https")) {
            return true;
        }
        return false;
    }

    public static boolean isOneTravelSchemeUri(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.startsWith("taxis99OneTravel") || str.startsWith("globalOneTravel")) {
            return true;
        }
        return false;
    }

    public static boolean isWalletSchemeUri(Uri uri) {
        if (uri == null) {
            return false;
        }
        String path = uri.getPath();
        if (TextUtils.isEmpty(path)) {
            return false;
        }
        return path.trim().contains("walletPage");
    }

    public static boolean isEntregaSchemeUri(Uri uri) {
        if (uri != null && !TextUtils.isEmpty(uri.getHost())) {
            String scheme = uri.getScheme();
            String host = uri.getHost();
            if (!TextUtils.isEmpty(scheme) && !TextUtils.isEmpty(host)) {
                return "sodaEntrega".equals(host);
            }
        }
        return false;
    }
}
